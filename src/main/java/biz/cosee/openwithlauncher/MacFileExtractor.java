package biz.cosee.openwithlauncher;

import com.apple.eawt.AppEvent;
import com.apple.eawt.Application;
import com.apple.eawt.OpenFilesHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class MacFileExtractor implements FileExtractor, OpenFilesHandler {

    private static final Logger logger = LoggerFactory.getLogger(MacFileExtractor.class);

    private List<File> passedFiles = Collections.emptyList();

    MacFileExtractor() {
        logger.info("Registering MacFileExtractor as OpenFileHandler.");
        Application.getApplication().setOpenFileHandler(this);
    }

    @Override
    public List<File> listOfFilesPassedToTheApplication() {
        return passedFiles;
    }

    @Override
    public void openFiles(AppEvent.OpenFilesEvent openFilesEvent) {

        passedFiles = openFilesEvent.getFiles();

        logger.debug("Received an OpenFilesEvent ({}, {}, {}).",
                openFilesEvent.getSearchTerm(),
                openFilesEvent.getSource(),
                passedFiles);

    }
}
