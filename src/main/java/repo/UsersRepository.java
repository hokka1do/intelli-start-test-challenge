package repo;

import repo.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsersRepository {
    private final ArrayList<User> userList = new ArrayList<>();

    public UsersRepository() {
        userList.add(new User(1L, "Alex", "Pinq", 350));
        userList.add(new User(2L, "Jimmy", "Nord", 280));
        userList.add(new User(3L, "Timo", "Kuzn", 520));
    }

    public User findUserById(Long id) {
        for (User user : userList) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        System.out.println("User not found");
        return null;
    }

    public List<User> findUsersListById(List<Long> usersId) {
        List<User> usersList = new ArrayList<>();
        for (Long id : usersId) {
            usersList.add(findUserById(id));
        }
        return usersList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}