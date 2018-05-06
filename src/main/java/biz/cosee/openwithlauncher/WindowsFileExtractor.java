package biz.cosee.openwithlauncher;

import java.io.File;
import java.util.List;

public class WindowsFileExtractor implements FileExtractor {

    private final String[] commandLineArguments;

    WindowsFileExtractor(String[] commandLineArguments) {
        this.commandLineArguments = commandLineArguments;
    }

    @Override
    public List<File> listOfFilesPassedToTheApplication() {
        return null;
    }

    String[] getCommandLineArguments() {
        return commandLineArguments;
    }
}
