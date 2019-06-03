package com.k8s.xmetrics.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
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
import java.security.cert.X509Certificate;
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






		final CloseableHttpClient client;
		final RequestConfig config = loadRequestConfig();
		final SSLContext sslContext = loadSSLContext();
		if(sslContext==null){
			LOGGER.error("No SSL context at this point");
			client = HttpClientBuilder
					.create()
					.setDefaultRequestConfig(config)
					.build();
		}else{
			client = HttpClientBuilder
					.create()
					.setDefaultRequestConfig(config)
					.setSSLContext(sslContext)
					.setConnectionManager(
							new PoolingHttpClientConnectionManager(
									RegistryBuilder.<ConnectionSocketFactory>create()
											.register("http", PlainConnectionSocketFactory.INSTANCE)
											.register("https", new SSLConnectionSocketFactory(sslContext,
													NoopHostnameVerifier.INSTANCE))
											.build()
							))
					.build();
		}



		return new HttpComponentsClientHttpRequestFactory(client);
	}

	private static RequestConfig loadRequestConfig() {
		return RequestConfig.custom()
				.setConnectTimeout(DEFAULT_TIMEOUT)
				.setConnectionRequestTimeout(DEFAULT_TIMEOUT)
				.setSocketTimeout(DEFAULT_TIMEOUT)
				.build();
	}

	private static SSLContext loadSSLContext() {
		SSLContext sslContext = null;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				public boolean isTrusted(final X509Certificate[] arg0, final String arg1) {
					return true;
				}
			}).build();
		} catch (final NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
			LOGGER.error(e.getMessage());
		}
		return sslContext;
	}

}
