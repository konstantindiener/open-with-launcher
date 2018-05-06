package biz.cosee.openwithlauncher;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FileExtractorFactoryTest {

    private static final String[] arguments = {"arg1", "arg2"};

    @Test
    public void createForWindows() {
        FileExtractor fileExtractor =
                new FileExtractorFactory("Windows 7")
                        .createFileExtractor(arguments);
        assertThat(fileExtractor).isInstanceOf(WindowsFileExtractor.class);

        String[] commandLineArguments = ((WindowsFileExtractor) fileExtractor).getCommandLineArguments();
        assertThat(commandLineArguments).isEqualTo(arguments);
    }

    @Test
    public void createForMac() {
        FileExtractor fileExtractor =
                new FileExtractorFactory("Mac OS X")
                        .createFileExtractor(arguments);
        assertThat(fileExtractor).isInstanceOf(MacFileExtractor.class);
    }
}
