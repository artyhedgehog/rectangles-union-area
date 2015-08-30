import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import ru.e_legion.rectanglesunionarea.Main;

public class IntegrationTests {
    String inputFile1 = "/home/artyhedgehog/workspace/learning/e-legion/RectanglesUnionArea/target/test-classes/coordinates1.txt";
    String inputFile2 = "/home/artyhedgehog/workspace/learning/e-legion/RectanglesUnionArea/target/test-classes/coordinates2.txt";
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

    private void assertFileContentsEquals(String fileName, String expected)
            throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String contents = new String(Files.readAllBytes(Paths.get(fileName)));
        Assert.assertEquals(expected, contents);
    }

    @After
    public void tearDown() throws Exception {
        Files.delete(Paths.get(outputFile1));
        Files.delete(Paths.get(outputFile2));
    }
}
