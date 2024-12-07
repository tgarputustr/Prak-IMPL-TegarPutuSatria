package CleanCode;


public class Clarification {
    private Comparable<Object> a = new Comparable<Object>() {
        @Override
        public int compareTo(Object o) {
            return -1;  // Implementasi sederhana untuk contoh: a < b
        }
    };

    private Comparable<Object> b = new Comparable<Object>() {
        @Override
        public int compareTo(Object o) {
            return 1;  // Implementasi sederhana untuk contoh: b > a
        }
    };

    public void testComparison() {
        assertTrue(a.compareTo(b) == -1); // a < b
        assertTrue(b.compareTo(a) == 1);  // b > a
    }    
    private void assertTrue(boolean c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }
}
