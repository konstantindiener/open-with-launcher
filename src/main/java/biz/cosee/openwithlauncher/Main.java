package biz.cosee.openwithlauncher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting on OS '{}'.", System.getProperty("os.name"));

        FileExtractor fileExtractor =
                new FileExtractorFactory(System.getProperty("os.name")).createFileExtractor(args);

        List<File> passedFiles = fileExtractor.listOfFilesPassedToTheApplication();
        logger.info("Files to open: {}", passedFiles);
    }
}
