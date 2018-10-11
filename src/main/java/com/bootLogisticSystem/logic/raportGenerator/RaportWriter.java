package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;

public interface RaportWriter {

	<T extends GenerateAble> void write (File file, List<T> data);
}
