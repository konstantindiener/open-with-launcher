package biz.cosee.openwithlauncher;

import com.apple.eawt.AppEvent;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MacFileExtractorTest {

    private static final File[] fileList = {new File("file1"), new File("file2")};

    @Test
    public void listFilesAfterOSCallbackIsCalled() {

        MacFileExtractor macFileExtractor = new MacFileExtractor();
        macFileExtractor.openFiles(createMockedOpenFilesEvent());

        List<File> passedFiles = macFileExtractor.listOfFilesPassedToTheApplication();
        assertThat(passedFiles).contains(fileList);
    }

    private AppEvent.OpenFilesEvent createMockedOpenFilesEvent() {
        AppEvent.OpenFilesEvent openFilesEvent = mock(AppEvent.OpenFilesEvent.class);

        when(openFilesEvent.getSearchTerm())
                .thenReturn("test");
        when(openFilesEvent.getFiles())
                .thenReturn(asList(fileList));
        when(openFilesEvent.getSource())
                .thenReturn("os");
        return openFilesEvent;
    }

    @Test
    public void listFilesWithoutOSCallback() {

        List<File> passedFiles = new MacFileExtractor().listOfFilesPassedToTheApplication();

        assertThat(passedFiles).isEmpty();
    }
}