public class PersonRef {
    public String name;
    public String getName(){
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
    
    public static void main(String[] args) {
        PersonRef person = new PersonRef    ();
        person.setName("Bob Smith");
        System.out.println(person.getName());
    }
}
