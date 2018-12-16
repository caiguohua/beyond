package java8.students;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class StudentStats {

    public static void main(String[] args) {
        List<Student> students = readDB();

        long studentCount = students
                .stream()
                .mapToLong(s -> 1L)
                .sum();
        log("Total number of student is: ",studentCount);

        long totalCredits = students.stream()
                .mapToLong(Student::getCredit)
                .sum();
        log("total creadits of students is : ",totalCredits);

        Map<Student.Gender,Long> groupCountByGender = students.stream()
                .collect(Collectors.groupingBy(Student::getGender,Collectors.counting()));
        log("Student number by gender is: ",groupCountByGender);

//        students.sort((s1,s2) -> s1.getCredit() - s2.getCredit());
//        System.out.println(students);

        Optional<Student> maxCredit = students.stream()
                .max((s1,s2) -> s1.getCredit() - s2.getCredit());
        if(maxCredit.isPresent()){
            log("max credit is ",maxCredit.get().getName());
        }else {
            log("can not find max credit","!");
        }

        Integer sumCredits = students.stream()
                .reduce(0, (Integer partialSum,Student s) -> {
                    Integer middle = partialSum + s.getCredit();
                    System.out.println(Thread.currentThread().getName() + " " + s.getName() + " " + middle);
                    return middle;
                },
                (a,b) -> { //连接器（两种类型不兼容的时候，用连接器）
                    System.out.println(Thread.currentThread().getName() + " " + a + " " + b);
                    return null;
                });
        log("The sum credit is : ",sumCredits);

        boolean allMale = students.stream().allMatch(s -> s.getGender() == Student.Gender.MAlE);
        log("Whether all students are male: ",allMale);

        LongSummaryStatistics creditStats = students.stream()
                .map(Student::getCredit)
                .collect(LongSummaryStatistics::new,
                        LongSummaryStatistics::accept,
                        LongSummaryStatistics::combine);
        log("Starts: ",creditStats);

        Map<String,Integer> simpleStudent = students.stream()
                .collect(Collectors.toMap(Student::getName,Student::getCredit));
        log("<Name,Credits>: ",simpleStudent);

        String names = students.stream()
                .filter(s ->s.getCredit() >= 60)
                .map(Student::getName)
                .collect(Collectors.joining(", ", "YD 2018 Best Students <",">"));
        log("",names);
    }

    private static void log(String perfix, Object content) {
        System.out.println(perfix+content);
    }

    private static List<Student> readDB() {

        Student s1 = new Student(1L,"ZhangSan",Student.Gender.MAlE,22, Student.Department.AT, 50,LocalDate.of(1996, Month.FEBRUARY,12));
        Student s2 = new Student(2L,"ZhangSanSan",Student.Gender.MAlE,23, Student.Department.AT, 60,LocalDate.of(1995, Month.FEBRUARY,12));
        Student s3 = new Student(3L,"LiSi",Student.Gender.FEMALE,20, Student.Department.AT, 70,LocalDate.of(1998, Month.FEBRUARY,12));
        Student s4 = new Student(4L,"WangWu",Student.Gender.MAlE,21, Student.Department.AT, 59,LocalDate.of(1997, Month.FEBRUARY,12));
        Student s5 = new Student(5L,"ZhangSi",Student.Gender.MAlE,20, Student.Department.AT, 72,LocalDate.of(1998, Month.FEBRUARY,12));
        Student s6 = new Student(6L,"LiShan",Student.Gender.MAlE,21, Student.Department.AT, 69,LocalDate.of(1997, Month.FEBRUARY,12));
        Student s7 = new Student(7L,"HanWu",Student.Gender.FEMALE,22, Student.Department.AT, 80,LocalDate.of(1996, Month.FEBRUARY,12));
        Student s8 = new Student(8L,"LiWu",Student.Gender.MAlE,23, Student.Department.AT, 79,LocalDate.of(1995, Month.FEBRUARY,12));
        Student s9 = new Student(9L,"ZhaoSi",Student.Gender.FEMALE,19, Student.Department.AT, 57,LocalDate.of(1999, Month.FEBRUARY,12));
        Student s10 = new Student(10L,"CaiSi",Student.Gender.MAlE,20, Student.Department.AT, 62,LocalDate.of(1998, Month.FEBRUARY,12));
        Student s11 = new Student(11L,"WangSi",Student.Gender.FEMALE,22, Student.Department.AT, 66,LocalDate.of(1996, Month.FEBRUARY,12));

        return Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11);
    }
}
