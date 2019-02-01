package fake;

import models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeStorage {
    // a variable that stores a reference to a single instance of an object of the FakeStorage class.
    private static final FakeStorage storage;

    // statically initializer that creates an object of the FakeStorage class. Called once when loading a class in the JVM.
    static {
        storage = new FakeStorage();
    }

    // list field that stores a list of system users.
    private List<User> users;

    // private constructor initializing the list.
    private FakeStorage() {
        this.users = new ArrayList<>();
        User user = new User("Major Motoko Kusanagi", "gits", LocalDate.parse("2004-01-01"));
        User user1 = new User("Naomi Armitage", "third", LocalDate.parse("2020-01-01"));
        User user2 = new User("Alita", "cyborg", LocalDate.parse("2100-01-01"));

        users.add(user);
        users.add(user1);
        users.add(user2);
    }

    // method providing access to the class object.
    public static FakeStorage storage() {
        return storage;
    }

    // method that returns a list of users.
    public List<User> users() {
        return users;
    }
}
