package com.bootLogisticSystem.utils;

import java.io.File;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.bootLogisticSystem.exception.InvalidParameterException;

public class InputArgumentParser {
	
	private Options options;

	@SuppressWarnings("static-access")
	public InputArgumentParser() {
		options = new Options();
		
		options.addOption( OptionBuilder
				.withArgName("i")
				.withLongOpt( "input" )
				.withType(File.class)
				.isRequired()
				.withDescription("input file list")
				.hasArgs()
				.withArgName("FILES")
				.create());
	};
	
	public List<File> parseArgsAsFilePath(String[] args) throws InvalidParameterException{
		CommandLine commandLine = null;
		
		try {
			CommandLineParser parser = new DefaultParser();
			commandLine = new DefaultParser().parse(options, args, false);


		} catch (ParseException e) {
			System.out.println(e.getMessage());
			printHelp();
			throw new InvalidParameterException();
		}

		
	      String[] inputPath = commandLine.getOptionValues("input");
	      
	      for (String path : inputPath) {
			System.out.println(path);
		}
	      
		if(commandLine.hasOption("input")) {
			   System.out.println(">>>>>>jest");
			} else if(commandLine.hasOption("input")) {
				System.out.println(">>>>>>nima");
			}

		return null;
	}
	
	private void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
	     formatter.printHelp("./run --input[input files] [output options]", options);
	}
}
