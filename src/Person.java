public class Person {
    private String name;
    private String surname;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name. Name cannot be null or empty.");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null && !surname.trim().isEmpty()) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Invalid surname. Surname cannot be null or empty.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email. Email cannot be null or empty.");
        }
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}
