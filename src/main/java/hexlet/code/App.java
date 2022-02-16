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
		Path filepath1 = Paths.get("src/main/java/hexlet/code/file1.json").toAbsolutePath().normalize();
		Path filepath2 = Paths.get("src/main/java/hexlet/code/file2.json").toAbsolutePath().normalize();

		/*try {
			System.out.println(Differ.generate(filepath1.toString(), filepath2.toString()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/

		return null;
	}

	public static void main(String[] args) {
		int exitCode = new CommandLine(new App()).execute(args);
		System.exit(exitCode);
	}

}
