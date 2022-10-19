package be.abis.mavenexercise;

import be.abis.mavenexercise.model.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    private Address address;

    @BeforeEach
    void setUp(){
        address = new Address("Rue de Bourgogne", "99", "1190", "Brussels", "Belgie", "BE");
    }

    @Test
    public void belgianZipCodeShouldBeNumeric(){
        assertTrue(address.isBelgianZipCodeNumeric());
    }

    @Test
    public void addressWritesToFile() throws IOException {
        List<String> linesBefore;

        try {
            linesBefore = Files.readAllLines(Paths.get("/temp/javacourses/address.txt"));
        } catch (NoSuchFileException e){
            PrintWriter pw = new PrintWriter(new FileWriter("/temp/javacourses/address.txt"));
            pw.close();
            linesBefore = Files.readAllLines(Paths.get("/temp/javacourses/address.txt"));
        }

        address.writeToFile();
        List<String> linesAfter = Files.readAllLines(Paths.get("/temp/javacourses/address.txt"));
        assertThat(linesAfter.size(), equalTo(linesBefore.size()+1));
    }

    @Test
    public void writeToFileThrowsIOException() {
        File file = new File("/temp/javacourses/address.txt");
        file.setReadOnly();

        assertThrows(IOException.class, () -> address.writeToFile());
        file.setWritable(true);
    }

}
