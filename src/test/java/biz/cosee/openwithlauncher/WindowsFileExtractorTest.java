package biz.cosee.openwithlauncher;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowsFileExtractorTest {

    @Test
    public void listOfFilesPassedToTheApplication() {
        List<File> passedFiles =
                new WindowsFileExtractor(new String[] { "file1", "file2" })
                    .listOfFilesPassedToTheApplication();

        assertThat(passedFiles).contains(new File("file1"), new File("file2"));
    }
}