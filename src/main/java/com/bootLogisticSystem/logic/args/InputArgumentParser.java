/*
 * Copyright (c) 2018 Karol Łukasiewicz
 *
 * @author Karol Łukasiewicz
 * @date 15 Oct 2018
 * 
 */
package com.bootLogisticSystem.logic.args;

import java.util.Optional;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.bootLogisticSystem.exception.InvalidParameterException;
import com.bootLogisticSystem.model.InputArgument;

/**
 * Contain parse input data mechanisms.
 * 
 * @author Karol Łukasiewicz
 *
 */
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

	/**
	 * Parse and validate input arguments
	 * 
	 * @param args program input arguments
	 * @return Validated input arguments
	 * @throws InvalidParameterException throw when too much input arguments are
	 *                                   invalid
	 */
	public InputArgument parseArgs(String[] args) throws InvalidParameterException {
		Optional<CommandLine> commandLineOptional = Optional.empty();

		// basic parse and validation provide by apache common CLI
		try {
			commandLineOptional = Optional.of(new DefaultParser().parse(options, args, false));
		} catch (ParseException e) {
//			printHelp();
			throw new InvalidParameterException(e.getMessage());
		}

		CommandLine commandLine = commandLineOptional.get();

		if (commandLine.hasOption("help")) {
//			printHelp();
			throw new InvalidParameterException();
		}

		String[] inputPaths = commandLine.getOptionValues("input");
		String outputPath = commandLine.getOptionValue("output");
		String raportType = commandLine.getOptionValue("raport");
		String clientId = commandLine.getOptionValue("client-id");

		// more specific validation
		InputArgument inputArgument = new InputArgumentValidator().validate(inputPaths, outputPath, raportType,
				clientId);

		return inputArgument;
	}

	public void printHelp() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(helpDescription, options);
	}

	private final String helpDescription = "Przykladowe uzycie: \n"
			+ "run -i[pliki wejsciowe] -r[typ generowanego raportu] \n" + "\n"
			+ "np: 'run -i input.xml -o output.csv -r b -c 1' - wygeneruje raport "
			+ "zwracajacy ilosc zamowien dla klienta o id = 1, z pliku input.xml, wynik zapisze do pliku output.csv"
			+ "\n" + "np: 'run -i in1.xml in2.csv -r e' - wygeneruje liste wszystkich zamowien parsujac "
			+ "pliki in1.xml oraz in2.csv, wynik wyswietli w konsoli";

	private final String inputOptionDescription = "[PARAMETR WYMAGANY][Jeden lub wiele] \n"
			+ "sciezka do jednego lubi wiecej plikow wejsciowych. " + "Akcepowalne rozszerzenia to xml oraz csv.";

	private final String outputOptionDescription = "[Tylko jeden]Sciezka do pliku wyjsciowego. Moze się kończyc rozszerzeniem .cvs/.xml. "
			+ "W razie potrzeby wygeneruje potrzebne rozszerzenie (standardowo .scv), " + "oraz nazwę pliku.\n"
			+ "Gdy nie podano sciezki do pliku wyjsciowego, wynik dzialania programu zostanie"
			+ "wyswietlony w konsoli.";

	private final String raportOptionDescription = "[PARAMETR WYMAGANY][Tylko jeden] Typ generowanego raportu\n "
			+ "kod  | typ raportu \n" + " a   | Ilosc zamowień lacznie,\n"
			+ " b   | -||- do klienta o wskazanym identyfikatorze,\n" 
			+ " c   | laczna kwota zamowień,\n"
			+ " d   | -||- do klienta o wskazanym identyfikatorze,\n" 
			+ " e   | Lista wszystkich zamowień,\n"
			+ " f   | -||- do klienta wskazanym identyfikatorze,\n" 
			+ " g   | srednia wartosc zamowienia ,\n"
			+ " h   | -||- do klienta o wskazanym identyfikatorze";

	private final String clientIdOptionDescription = "[PARAMETR WYMAGANY z opcjami b, d, f, h parametru raport]\n"
			+ "Identyfikator klienta. Jesli podano nieistniejacego klienta, informacja o tym "
			+ "zostanie wyswietlona po odczytaniu danych";

	private final String helpOptionDescription = "Wypisuja ta pomoc na ekranie.";
}
