package be.abis.mavenexercise.repository;

import be.abis.mavenexercise.model.Address;

import java.io.IOException;
import java.nio.file.Path;

public interface AddressRepository {

    void saveAddress(Address a, Path pathToFile) throws IOException;

}
