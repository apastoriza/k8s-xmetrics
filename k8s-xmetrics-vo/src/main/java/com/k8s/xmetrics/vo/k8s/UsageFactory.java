package com.k8s.xmetrics.vo.k8s;

import com.k8s.xmetrics.model.k8s.Usage;
import com.k8s.xmetrics.model.unit.CPUUnit;
import com.k8s.xmetrics.model.unit.MemoryUnit;
import com.k8s.xmetrics.vo.AbstractVOFactory;
import org.apache.commons.lang3.StringUtils;

/**
 * @author apastoriza
 */
public class UsageFactory extends AbstractVOFactory<Usage, UsageVO> {

	@Override
	protected UsageVO doVO(final Usage model) {
		final UsageVO vo = new UsageVO();
		final String cpuUsageRaw = model.getCpu();
		final CPUUnit cpuUnit = this.getCPUUnit(cpuUsageRaw);
		final String cpuUsage = this.getUsageValue(cpuUsageRaw, cpuUnit.getSymbol());

		final String memoryUsageRaw = model.getMemory();
		final MemoryUnit memoryUnit = this.getMemoryUnit(memoryUsageRaw);
		final String memoryUsage = this.getUsageValue(memoryUsageRaw, memoryUnit.getSymbol());

		vo.setCpu(cpuUsage);
		vo.setCpuUnits(cpuUnit.name());
		vo.setMemory(memoryUsage);
		vo.setMemoryUnits(memoryUnit.name());
		return vo;
	}

	@Override
	protected Usage doModel(final UsageVO vo) {
		final Usage usage = new Usage();
		final String cpu = vo.getCpu();
		final String cpuUnits = vo.getCpuUnits();
		final String cpuUnitsSymbol = CPUUnit.valueOf(cpuUnits).getSymbol();
		final String cpuUsageRaw = cpu.concat(cpuUnitsSymbol);


		final String memory = vo.getMemory();
		final String memoryUnits = vo.getMemoryUnits();
		final String memoryUnitsSymbol = MemoryUnit.valueOf(memoryUnits).getSymbol();
		final String memoryUsageRaw = memory.concat(memoryUnitsSymbol);

		usage.setCpu(cpuUsageRaw);
		usage.setMemory(memoryUsageRaw);

		return usage;
	}

	private CPUUnit getCPUUnit(final String cpuUsageRaw) {
		CPUUnit cpuUnitFound = null;
		final CPUUnit[] values = CPUUnit.values();
		for (final CPUUnit cpuUnit : values) {
			final String symbol = cpuUnit.getSymbol();
			if (cpuUsageRaw.endsWith(symbol)) {
				cpuUnitFound = cpuUnit;
			}
		}
		return cpuUnitFound;
	}

	private MemoryUnit getMemoryUnit(final String memoryUsageRaw) {
		MemoryUnit memoryUnitFound = null;
		final MemoryUnit[] values = MemoryUnit.values();
		for (final MemoryUnit memoryUnit : values) {
			final String symbol = memoryUnit.getSymbol();
			if (memoryUsageRaw.endsWith(symbol)) {
				memoryUnitFound = memoryUnit;
			}
		}
		return memoryUnitFound;
	}

	private String getUsageValue(final String usageRaw, final String symbol) {
		final String numericValueAsString = StringUtils.removeEnd(usageRaw, symbol);
		LOGGER.debug("From raw value '{}' to numeric value '{}' formatted as string", usageRaw, numericValueAsString);
		return numericValueAsString;
	}
}
