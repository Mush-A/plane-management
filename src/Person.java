/**
 * This class represents a Person with properties name, surname and email.
 */
public class Person {
    private String name;
    private String surname;
    private String email;

    /**
     * Returns the name of the person.
     * @return A string representing the person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     * @param name A string containing the person's name.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name. Name cannot be null or empty.");
        }
    }

    /**
     * Returns the surname of the person.
     * @return A string representing the person's surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname of the person.
     * @param surname A string containing the person's surname.
     * @throws IllegalArgumentException if the surname is null or empty.
     */
    public void setSurname(String surname) {
        if (surname != null && !surname.trim().isEmpty()) {
            this.surname = surname;
        } else {
            throw new IllegalArgumentException("Invalid surname. Surname cannot be null or empty.");
        }
    }

    /**
     * Returns the email of the person.
     * @return A string representing the person's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the person.
     * @param email A string containing the person's email.
     * @throws IllegalArgumentException if the email is null or empty.
     */
    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email. Email cannot be null or empty.");
        }
    }

    /**
     * Prints the information of the person to the console.
     */
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
    }
}