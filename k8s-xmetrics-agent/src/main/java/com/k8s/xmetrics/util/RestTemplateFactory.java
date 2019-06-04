package com.k8s.xmetrics.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author apastoriza
 */
public class RestTemplateFactory {
	/**
	 * The Constant LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateFactory.class);
	private static final int DEFAULT_TIMEOUT = 60000;

	public static RestTemplate create() {
		final RestTemplate restTemplate = createRestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return restTemplate;
	}

	private static RestTemplate createRestTemplate() {
		final ClientHttpRequestFactory clientHttpRequestFactory = getClientHttpRequestFactory();
		final RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
		return restTemplate;
	}

	private static ClientHttpRequestFactory getClientHttpRequestFactory() {


		HttpComponentsClientHttpRequestFactory requestFactory = null;

		try {
			final RequestConfig requestConfig = loadRequestConfig();

			final TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
			final SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
			final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

			final Registry<ConnectionSocketFactory> socketFactoryRegistry =
					RegistryBuilder.<ConnectionSocketFactory>create()
							.register("https", sslsf)
							.register("http", new PlainConnectionSocketFactory())
							.build();

			final BasicHttpClientConnectionManager connectionManager =
					new BasicHttpClientConnectionManager(socketFactoryRegistry);
			final CloseableHttpClient httpClient = HttpClients.custom()
					.setSSLSocketFactory(sslsf)
					.setConnectionManager(connectionManager)
					.setDefaultRequestConfig(requestConfig)
					.build();

			requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
		} catch (final NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
			LOGGER.error(e.getMessage());
		}


		return requestFactory;


	}

	private static RequestConfig loadRequestConfig() {
		return RequestConfig.custom()
				.setConnectTimeout(DEFAULT_TIMEOUT)
				.setConnectionRequestTimeout(DEFAULT_TIMEOUT)
				.setSocketTimeout(DEFAULT_TIMEOUT)
				.build();
	}

	private static SSLConnectionSocketFactory loadSSLConnectionSocketFactory() {
		SSLConnectionSocketFactory socketFactory = null;
		try {
			final SSLContext sslContext = SSLContextBuilder.create().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			socketFactory = new SSLConnectionSocketFactory(sslContext);
		} catch (final NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
			LOGGER.error(e.getMessage());
		}
		return socketFactory;
	}

}
