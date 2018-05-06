package biz.cosee.openwithlauncher;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class WindowsFileExtractor implements FileExtractor {

    private final String[] commandLineArguments;

    WindowsFileExtractor(String[] commandLineArguments) {
        this.commandLineArguments = commandLineArguments;
    }

    @Override
    public List<File> listOfFilesPassedToTheApplication() {
        return stream(commandLineArguments)
                .map(File::new)
                .collect(Collectors.toList());
    }

    String[] getCommandLineArguments() {
        return commandLineArguments;
    }
}
