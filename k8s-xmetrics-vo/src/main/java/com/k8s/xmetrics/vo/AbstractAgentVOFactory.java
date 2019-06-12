package com.k8s.xmetrics.vo;

import com.k8s.xmetrics.datetime.DateTimeUtils;
import com.k8s.xmetrics.service.config.EnvironmentConfigurationService;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author apastoriza
 */
public abstract class AbstractAgentVOFactory<M, V> extends AbstractVOFactory<M, V> {
	private EnvironmentConfigurationService environmentConfigurationService;

	@Override
	public V toVO(final M model) {
		assertThat(this.environmentConfigurationService).isNotNull();
		final V vo = super.toVO(model);
		if(vo instanceof AbstractAgentVO){
			if(((AbstractAgentVO) vo).getAgentID()==null || ((AbstractAgentVO) vo).getAgentID().isEmpty()){
				final String agentID = this.getEnvironmentConfigurationService().getAgentID();
				((AbstractAgentVO) vo).setAgentID(agentID);
			}

			if(((AbstractAgentVO) vo).getEventTimeInMillis()==null){
				final Long now = DateTimeUtils.nowInMillis();
				((AbstractAgentVO) vo).setEventTimeInMillis(now);
			}

		}
		return vo;
	}

	@Override
	public M toModel(final V vo) {
		assertThat(this.environmentConfigurationService).isNotNull();
		return super.toModel(vo);
	}

	@Override
	public Collection<V> toVOs(final Collection<M> models) {
		assertThat(this.environmentConfigurationService).isNotNull();
		return super.toVOs(models);
	}

	@Override
	public Collection<M> toModels(final Collection<V> vos) {
		assertThat(this.environmentConfigurationService).isNotNull();
		return super.toModels(vos);
	}

	protected EnvironmentConfigurationService getEnvironmentConfigurationService() {
		assertThat(this.environmentConfigurationService).isNotNull();
		return this.environmentConfigurationService;
	}

	public void setEnvironmentConfigurationService(final EnvironmentConfigurationService environmentConfigurationService) {
		this.environmentConfigurationService = environmentConfigurationService;
	}
}
