package be.abis.mavenexercise;

import be.abis.mavenexercise.model.Address;
import be.abis.mavenexercise.repository.FileAddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class FileAddressRepositoryTest {

    private FileAddressRepository repository;

    @Mock
    private Address address;

    @BeforeEach
    void setUp(){
        repository = new FileAddressRepository();
    }

    /*
    @Test
    public void writeToFileSuccessfully() throws IOException {
        when(address.writeToFile(Mockito.any(Path.class))).then(doAnswer())
        repository.saveAddress(address, any());
    }

    @Test
    public void writeToFileThrowsException() throws IOException {
        when(address.writeToFile(any())).thenThrow(IOException.class);
        repository.saveAddress(address, any());
    }*/
}