package manage;


import file.FileUserCSV;
import model.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ManageUser implements GeneralManage<User> {
    List<User> userList = new ArrayList<>();
    public static User currentUser = null;
    public ManageUser() throws FileNotFoundException {
        userList = (List<User>) FileUserCSV.readFromFile();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        ManageUser.currentUser = currentUser;
    }

    @Override
    public void add(User user) {
        userList.add(user);
    }

    @Override
    public User findById(int id) {
        return userList.get(findIndexById(id));
    }

    @Override
    public void edit(int id, User user) {
        userList.set(findIndexById(id), user);
    }

    @Override
    public void delete(int id) {
        userList.remove(findIndexById(id));
    }

    @Override
    public void findAll() {
        for (int i=0; i<userList.size(); i++) {
            System.out.println(userList.get(i));
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i=0; i<userList.size(); i++) {
            if (userList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}