package by.bstu.unittesting.model;

import java.util.Objects;

public class User {

    private String email;
    private String password;

    private String surname;
    private String name;
    private String birthdate;

    public User(String email, String password, String surname, String name, String birthdate) {
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{"
                + "email='" + email + '\''
                + ", password='" + password + '\''
                + ", surname='" + surname + '\''
                + ", name='" + name + '\''
                + ", birthdate='" + birthdate + '\''
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        return Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(surname, user.surname)
                && Objects.equals(name, user.name)
                && Objects.equals(birthdate, user.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, surname, name, birthdate);
    }
}
