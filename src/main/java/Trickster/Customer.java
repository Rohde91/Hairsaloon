package Trickster;

public class Customer extends User{

    //TODO skal føjes til tabellen i sql:


    public Customer(int ID, String name, String email, String phone, String address, String password) {
        super(ID, name, email, phone, address,password);

    }

    public Customer() {
    }

    public Customer(String email, String password){
        super(email, password);
    }


}
