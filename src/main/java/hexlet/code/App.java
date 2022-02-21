package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Paths;

import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
    mixinStandardHelpOptions = true,
    version = "gendiff 0.1",
    description = "Compares two configuration files and shows a difference.")

class App implements Callable {
    @Parameters
        (index = "0",
            paramLabel = "filepath1",
            description = "path to first file")
    private String filepath1;
    @Parameters
        (index = "1",
            paramLabel = "filepath2",
            description = "path to second file")
    private String filepath2;

    @Option(names = { "-f", "--format" },
        paramLabel = "format",
        description = "output format [default: stylish]")
    private String format = "stylish";


    @Override
    public String call() throws Exception {
        final String file1 = String.valueOf(Paths.get(filepath1).toAbsolutePath());
        final String file2 = String.valueOf(Paths.get(filepath2).toAbsolutePath());

        Map<String, Object> parsedfile1 = Parser.generate(file1);
        Map<String, Object> parsedfile2 = Parser.generate(file2);

        try {
            System.out.println(Differ.generate(parsedfile1, parsedfile2, format));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
