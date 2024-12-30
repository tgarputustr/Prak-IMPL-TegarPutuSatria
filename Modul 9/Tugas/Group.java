import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {

    // Gets users sorted by the most recently registered user
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        if (!new File(persistencePath()).exists()) {
            return users;
        }
        File[] files = new File(persistencePath()).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                users.add(new User(file.getName(), this));
            }
        }
        Collections.sort(users, new User.UserComparatorByDescendingRegistration());
        return users;
    }

    // Placeholder for the persistence path
    private String persistencePath() {
        return "path/to/persistence";
    }

    // Kelas User
    public static class User {
        private String name;
        private Group group;

        public User(String name, Group group) {
            this.name = name;
            this.group = group;
        }

        public String getName() {
            return name;
        }

        // Comparator untuk mengurutkan User berdasarkan tanggal pendaftaran (misalnya nama file di sini sebagai waktu pendaftaran)
        public static class UserComparatorByDescendingRegistration implements java.util.Comparator<User> {
            @Override
            public int compare(User u1, User u2) {
                // Mengasumsikan bahwa nama file mewakili tanggal pendaftaran dalam format tertentu
                return u2.getName().compareTo(u1.getName()); // Mengurutkan dari yang terbaru
            }
        }
    }

    public static void main(String[] args) {
        Group group = new Group();
        List<User> users = group.getUsers();
        
        System.out.println("Users sorted by most recent registration:");
        for (User user : users) {
            System.out.println(user.getName());
        }
    }
}
