package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
		mixinStandardHelpOptions = true,
		version = "gendiff 0.1",
		description = "Compares two configuration files and shows a difference.")

class App implements Callable {

	@Parameters(index = "0", paramLabel = "filepath1", description = "path to first file")
	private String filepath1;

	@Parameters(index = "1", paramLabel = "filepath2", description = "path to second file")
	private String filepath2;

	@Option(names = { "-f", "--format" },
			paramLabel = "format",
			description = "output format [default: stylish]")
	String format;


	@Override
	public String call() throws Exception {
		final File file1 = new File("src/main/resources/file1.json");
		final File file2 = new File("src/main/resources/file2.json");

		try {
			System.out.println(Differ.generate(file1, file2));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		int exitCode = new CommandLine(new App()).execute(args);
		System.exit(exitCode);
	}

}
