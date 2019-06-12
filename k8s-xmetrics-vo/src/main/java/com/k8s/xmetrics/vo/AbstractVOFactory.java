package com.k8s.xmetrics.vo;

import com.google.common.collect.Lists;
import net.jodah.typetools.TypeResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author apastoriza
 */
public abstract class AbstractVOFactory<M, V> {
	protected static Logger LOGGER;

	private final Class<M> modelClass;
	private final Class<V> valueObjectClass;

	protected abstract V doVO(M model);

	protected abstract M doModel(V vo);

	public AbstractVOFactory() {
		LOGGER = LoggerFactory.getLogger(this.getClass());
		final Class<?>[] typeArguments = TypeResolver.resolveRawArguments(AbstractVOFactory.class, this.getClass());
		this.modelClass = (Class<M>) typeArguments[0];
		this.valueObjectClass = (Class<V>) typeArguments[1];
	}

	public V toVO(final M model) {
		assertThat(model).isNotNull();
		final V vo = this.doVO(model);
		LOGGER.trace("From Model {} to VO: {}", model, vo);
		return vo;
	}

	public M toModel(final V vo) {
		assertThat(vo).isNotNull();
		final M model = this.doModel(vo);
		LOGGER.trace("From VO {} to Mo: {}", vo, model);
		return model;
	}

	public Collection<V> toVOs(final Collection<M> models) {
		assertThat(models).isNotNull();
		final Collection<V> vos = Lists.newArrayList();
		for (final M model : models) {
			final V vo = this.toVO(model);
			vos.add(vo);
		}
		return vos;
	}


	public Collection<M> toModels(final Collection<V> vos) {
		assertThat(vos).isNotNull();
		final Collection<M> models = Lists.newArrayList();
		for (final V vo : vos) {
			final M model = this.toModel(vo);
			models.add(model);
		}
		return models;
	}

	public Class<M> getModelClass() {
		return this.modelClass;
	}

	public Class<V> getValueObjectClass() {
		return this.valueObjectClass;
	}
}
