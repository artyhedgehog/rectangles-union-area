import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import ru.e_legion.rectanglesunionarea.Main;
import ru.e_legion.rectanglesunionarea.io.IOHelperException;

public class IntegrationTests {
    String inputFile1 = "/home/artyhedgehog/workspace/learning/e-legion/RectanglesUnionArea/target/test-classes/coordinates1.txt";
    String inputFile2 = "/home/artyhedgehog/workspace/learning/e-legion/RectanglesUnionArea/target/test-classes/coordinates2.txt";
    String nonExistentFile = "/dev/null/nosuchfile.txt";
    String outputFile1 = "area1.txt";
    String outputFile2 = "area2.txt";

    @Test
    public void testMain() throws Exception {
        ByteArrayOutputStream out;

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(new String[]{inputFile1, outputFile1});
        assertFileContentsEquals(outputFile1, "36");

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Main.main(new String[]{inputFile2, outputFile2});
        assertFileContentsEquals(outputFile2, "7");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoArgs() throws Exception {
        Main.main(new String[]{});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughArgs() throws Exception {
        Main.main(new String[]{inputFile1});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyArgs() throws Exception {
        Main.main(new String[]{inputFile1, outputFile1, inputFile2});
    }

    @Test(expected = IOHelperException.class)
    public void testNoSuchInputFile() throws Exception {
        Main.main(new String[]{nonExistentFile, outputFile1});
    }

    private void assertFileContentsEquals(String fileName, String expected)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String contents = new String(Files.readAllBytes(Paths.get(fileName)));
        Assert.assertEquals(expected, contents);
    }

    @After
    public void tearDown() throws Exception {
        try {
            Files.delete(Paths.get(outputFile1));
        } catch (NoSuchFileException ignore) {}
        try {
            Files.delete(Paths.get(outputFile2));
        } catch (NoSuchFileException ignore) {}
    }
}
