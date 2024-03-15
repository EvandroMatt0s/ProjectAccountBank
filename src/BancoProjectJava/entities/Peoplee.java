package BancoProjectJava.entities;

public class Peoplee {

    private static  int count =1;
    private String name;
    private String cpf;
    private String email;

    public Peoplee(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        count += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        return "\nName: "+ getName()
                +"\nEmail: "+getEmail()
                +"\nCpf: "+ getCpf();
    }
}
