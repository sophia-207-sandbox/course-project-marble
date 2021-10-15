package server;

import entity.Owner;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import server.OwnerRepository;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OwnerRepositoryTest {

    private OwnerRepository ownerRepo;

    @Before
    public void setUp() {
        ownerRepo = OwnerRepository.getOwnerRepository();
    }

    @Test
    void createOwner_OwnerExists() {
        ownerRepo.createOwner("User1", "User", "LOLXD");
        assertFalse(ownerRepo.createOwner("User1", "User", "LOLXD"));
    }

    @Test
    void createOwner_OwnerDoesNotExist() {
        assertTrue(ownerRepo.createOwner("User1", "User", "LOLXD"););
    }

    @Test
    void findOwner() {
    }

    @Test
    void getOwners() {
    }

    @After
    public void tearDown() {
        ownerRepo.deleteOwner("User1");
    }
}