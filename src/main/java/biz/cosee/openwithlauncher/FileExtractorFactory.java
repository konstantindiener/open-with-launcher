package biz.cosee.openwithlauncher;

class FileExtractorFactory {

    private final String operatingSystemName;

    FileExtractorFactory(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    FileExtractor createFileExtractor(String[] commandLineArguments) {

        if (operatingSystemName.toLowerCase().contains("mac os")) {
            return new MacFileExtractor();
        }

        return new WindowsFileExtractor(commandLineArguments);
    }
}
