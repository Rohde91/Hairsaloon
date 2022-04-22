package Trickster;

public class Employee extends User{
    int wage;
    //remove password from classes
    public Employee(int ID, String name, String email, String phone, String address, String password) {
        super(ID, name, email, phone, address, password);
//      this.wage = wage;
    }
    public Employee() {
    }

    public Employee(String email, String password){
        super(email, password);
    }


}