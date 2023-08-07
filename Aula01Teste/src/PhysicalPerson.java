import java.time.LocalDate;

public class PhysicalPerson {
    private String name;
    private LocalDate dateOfBirth;

    public PhysicalPerson(String name, Integer age) {
        this.name = name;
        this.dateOfBirth = LocalDate.now().minusYears(age);
    }

    public PhysicalPerson(String name, LocalDate birth) {
        this.name = name;
        this.dateOfBirth = birth;
    }

    public boolean isOver18Years() {
        LocalDate years18Ago = LocalDate.now().minusYears(18);
        return years18Ago.isAfter(dateOfBirth);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }
}
