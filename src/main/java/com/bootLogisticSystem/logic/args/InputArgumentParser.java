package com.bootLogisticSystem.logic.args;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.model.InputArgument;

public class InputArgumentParser {

	private Options options;

	public InputArgumentParser() {
		options = new Options();

		options.addOption(Option.builder("i").longOpt("input").required(true).desc(inputOptionDescription).hasArgs()
				.argName("FILES").build());

		options.addOption(Option.builder("r").longOpt("raport").required(true).desc(raportOptionDescription).hasArgs()
				.argName("OPTION").build());

		options.addOption(Option.builder("o").longOpt("output").required(false).desc(outputOptionDescription).hasArg()
				.argName("FILE").build());

		options.addOption(Option.builder("c").longOpt("client-id").required(false).desc(clientIdOptionDescription)
				.hasArg().argName("USER_ID").build());

		options.addOption(
				Option.builder("h").longOpt("help").required(false).desc(helpOptionDescription).hasArg(false).build());

	};

	public InputArgument parseArgs(String[] args) throws InvalidParameterException {
		Optional<CommandLine> commandLineOptional = Optional.empty();

		// basic parse and validation provide by apache common CLI
		try {
			CommandLineParser parser = new DefaultParser();
			commandLineOptional = Optional.of(new DefaultParser().parse(options, args, false));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			printHelp();
			throw new InvalidParameterException();
		}
		
		CommandLine commandLine = commandLineOptional.get();

		if (commandLine.hasOption("help")) {
			printHelp();
			throw new InvalidParameterException();
		}

		String[] inputPaths = commandLine.getOptionValues("input");
		String outputPath = commandLine.getOptionValue("output");
		String raportType = commandLine.getOptionValue("raport");
		String clientId = commandLine.getOptionValue("client-id");
		
		// more specific validation
		InputArgument inputArgument = new InputArgumentValidator().validate(inputPaths, outputPath, raportType, clientId);
		
		return inputArgument;	
	}

	private void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(helpDescription, options);
	}

	private final String helpDescription = "Przykładowe użycie: \n"
			+ "./run -i[pliki wejsciowe] -r[typ generowanego raportu] \n" + "./run -i -r[typ generowanego raportu]";

	private final String inputOptionDescription = "[PARAMETR WYMAGANY][Jeden lub wiele] \n"
			+ "Ściezka do jednego lubi wiecej plików wejsciowych. " + "Akcepowalne rozszerzenia to xml oraz csv.";

	private final String outputOptionDescription = "[Tylko jeden]Sćieżka do pliku wyjściowego. Może się kończyć rozszerzeniem .cvs/.xml. "
			+ "W razie potrzeby wygeneruje potrzebne rozszerzenie (standardowo .scv), " + "oraz nazwę pliku.\n"
			+ "Gdy nie podano ścieżki do pliku wyjściowego, wynik działania programu zostanie"
			+ "wyswietlony w konsoli.";

	private final String raportOptionDescription = "[PARAMETR WYMAGANY][Tylko jeden] Typ generowanego raportu\n "
			+ "kod  | typ raportu \n" + " a   | Ilość zamówień łącznie,\n"
			+ " b   | -||- do klienta o wskazanym identyfikatorze,\n" + " c   | Łączna kwota zamówień,\n"
			+ " d   | -||- do klienta o wskazanym identyfikatorze,\n" + " e   | Lista wszystkich zamówień,\n"
			+ " f   | -||- do klienta wskazanym identyfikatorze,\n" + " g   | Średnia wartość zamówienia ,\n"
			+ " h   | -||- do klienta o wskazanym identyfikatorze";

	private final String clientIdOptionDescription = "[PARAMETR WYMAGANY z opcjami b, d, f, h parametru raport]\n"
			+ "Identyfikator klienta. Jeśli podano nieistniejącego klienta, informacja o tym "
			+ "zostanie wyświetlona po odczytaniu danych";

	private final String helpOptionDescription = "Wypisują tą pomoc na ekranie.";
}
