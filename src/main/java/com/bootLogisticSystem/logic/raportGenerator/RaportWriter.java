package com.bootLogisticSystem.logic.raportGenerator;

import java.io.File;
import java.util.List;

import com.bootLogisticSystem.entity.GenerateAble;

/**
 * Interface to define raport writer class. Designed to provide save data raport
 * as file ability.
 * 
 * @author Karol Łukasiewicz
 *
 */
public interface RaportWriter {

	/**
	 * Save input list to file.
	 * @param file File to save.
	 * @param data Input data list.
	 */
	<T extends GenerateAble> void write(File file, List<T> data);
}
