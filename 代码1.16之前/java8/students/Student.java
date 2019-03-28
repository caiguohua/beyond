package java8.students;

import java.time.LocalDate;

public class Student {

    public enum Gender{
        FEMALE,
        MAlE
    }

    public enum Department{
        CS,SE,CN,AT
    }
    private Long id;
    private String name;
    private Gender gender;
    private Integer age;
    private Department department;
    private Integer credit;
    private LocalDate brith;


    public Student(Long id, String name, Gender gender, Integer age, Department department, Integer credit, LocalDate brith) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.credit = credit;
        this.brith = brith;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getBrith() {
        return brith;
    }

    public void setBrith(LocalDate brith) {
        this.brith = brith;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", credit=" + credit +
                ", department=" + department +
                ", brith=" + brith +
                '}';
    }
}
