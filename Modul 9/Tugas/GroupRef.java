import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupRef {

    // Gets users sorted by the most recently registered user
    public List<User> getUsersSortedByMostRecentlyRegistered() {
        List<User> users = new ArrayList<>();
        if (!userDirectoryExists()) {
            return users;
        }
        addFoundUsersTo(users);
        sortByMostRecentlyRegistered(users);
        return users;
    }

    // Cek apakah direktori pengguna ada
    private boolean userDirectoryExists() {
        return new File(persistencePath()).exists();
    }

    // Menambahkan pengguna yang ditemukan ke dalam daftar
    private void addFoundUsersTo(List<User> users) {
        File[] files = new File(persistencePath()).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                users.add(new User(file.getName(), this));
            }
        }
    }

    // Mengurutkan pengguna berdasarkan pendaftaran terbaru
    private void sortByMostRecentlyRegistered(List<User> users) {
        Collections.sort(users, new User.UserComparatorByDescendingRegistration());
    }

    // Placeholder untuk jalur penyimpanan
    private String persistencePath() {
        return "path/to/persistence";
    }

    // Kelas User
    public static class User {
        private String name;
        private GroupRef group;

        public User(String name, GroupRef group) {
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
        GroupRef group = new GroupRef();
        List<User> users = group.getUsersSortedByMostRecentlyRegistered();

        System.out.println("Users sorted by most recent registration:");
        for (User user : users) {
            System.out.println(user.getName());
        }
    }
}
