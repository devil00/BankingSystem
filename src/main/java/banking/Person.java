package banking;

public class Person extends AccountHolder {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName, int idNumber) {
		// complete the function
    super(idNumber);
    this.firstName = firstName;
    this.lastName = lastName;
	}

	public String getFirstName() {
		// complete the function
        return firstName;
	}

	public String getLastName() {
		// complete the function
        return lastName;
	}


  @Override
  public boolean equals(Object obj) {
    if(obj == this) return true;
    if(!(obj instanceof Person)) {
      return false;
    }

    Person person = (Person)obj;

    return (person.getFirstName().equalsIgnoreCase(firstName)
       && person.getLastName().equalsIgnoreCase(lastName)
        && person.getIdNumber() == getIdNumber());
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + firstName.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + getIdNumber();
    return result;
  }
}
