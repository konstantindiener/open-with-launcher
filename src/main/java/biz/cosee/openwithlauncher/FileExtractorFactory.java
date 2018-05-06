package biz.cosee.openwithlauncher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FileExtractorFactory {

    private static final Logger logger = LoggerFactory.getLogger(FileExtractorFactory.class);

    private final String operatingSystemName;

    FileExtractorFactory(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    FileExtractor createFileExtractor(String[] commandLineArguments) {

        if (operatingSystemName.toLowerCase().contains("mac os")) {
            logger.info("Creating MacFileExtractor");
            return new MacFileExtractor();
        }

        logger.info("Creating WindowsFileExtractor");
        return new WindowsFileExtractor(commandLineArguments);
    }
}
