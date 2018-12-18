package com.SwissKnife;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class App {
	public static void main(String[] args) {
		String src = "/home/intec/Desktop/SecretFiles/";
		String dst = "/home/intec/Desktop/SwissKnifeTrash1/";
		Utils util = new Utils(src, dst);
		File file = new File(src);
		System.out.println(util.identifyFileTypeUsingFilesProbeContentType("photo.jpg"));

		Options options = new Options();

		Option input = new Option("i", "input", true, "input file path");
		input.setRequired(true);
		options.addOption(input);

		Option output = new Option("o", "output", true, "output file");
		output.setRequired(true);
		options.addOption(output);

		Option create = new Option("c", "create", true, "Create Directory(if not exist)");
		output.setRequired(true);
		options.addOption(create);

		Option help = new Option("h", "help", true, "Help");
		input.setRequired(true);
		options.addOption(help);

		Option delete = new Option("d", "delete", true, "Delete");
		output.setRequired(true);
		options.addOption(delete);

		Option FilterSize = new Option("s", "filesize", true, "File Size");
		output.setRequired(true);
		options.addOption(FilterSize);

		Option SecureDelete = new Option("dd", "securedelete", true, "Secure Delete");
		output.setRequired(true);
		options.addOption(SecureDelete);

		Option FileType = new Option("t", "filetype", true, "File Type");
		output.setRequired(true);
		options.addOption(FileType);

		CommandLineParser parser = new DefaultParser();
		HelpFormatter formatter = new HelpFormatter();
		
		try {
			CommandLine cmd = parser.parse(options, args);
			if (cmd.hasOption("i")) {
			    System.out.println("STRING: METHOD_METHOD");
			  } else if (cmd.hasOption("m")) {
			    System.out.println("STRING: METHOD_METHOD");
			  }
			String inputFilePath = cmd.getOptionValue("input");
			String outputFilePath = cmd.getOptionValue("output");
			String Create = cmd.getOptionValue("create");
			String Help = cmd.getOptionValue("help");
			String Delete = cmd.getOptionValue("delete");
			String FileSize = cmd.getOptionValue("FileSize");
			String SecDelete = cmd.getOptionValue("securedelete");
			String FileTypeFilter = cmd.getOptionValue("filetype");
			System.out.println(inputFilePath);
			System.out.println(outputFilePath);
			System.out.println(Create);
			System.out.println(Help);
			System.out.println(Delete);
			System.out.println(FileSize);
			System.out.println(SecDelete);
			System.out.println(FileTypeFilter);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			formatter.printHelp("SwissKnife", options);

			System.exit(1);
		}
		
		/*

		try {
			util.FolderMoveR(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			util.delete(file);
			System.out.println("Directory has been deleted recursively !");
		} catch (IOException e) {
			System.out.println("Problem occurs when deleting the directory : " + src);
			e.printStackTrace();
		}
		try {
			util.secureDelete(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
}
