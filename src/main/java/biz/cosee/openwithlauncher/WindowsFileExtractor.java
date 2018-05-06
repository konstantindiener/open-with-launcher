package biz.cosee.openwithlauncher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class WindowsFileExtractor implements FileExtractor {

    private static final Logger logger = LoggerFactory.getLogger(WindowsFileExtractor.class);

    private final String[] commandLineArguments;

    WindowsFileExtractor(String[] commandLineArguments) {
        this.commandLineArguments = commandLineArguments;
    }

    @Override
    public List<File> listOfFilesPassedToTheApplication() {

        logger.info("Mapping '{}' to File objects.", Arrays.toString(commandLineArguments));

        return stream(commandLineArguments)
                .map(File::new)
                .collect(Collectors.toList());
    }

    String[] getCommandLineArguments() {
        return commandLineArguments;
    }
}
