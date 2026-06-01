

import java.util.stream.Collectors;

import com.demo.data.Student;
import com.demo.data.StudentDataBase;

public class StreamsJoining {


    public static String joining_1(){
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining(", ", "[", "]"));   
    }
    public static void main(String[] args) {
        System.out.println("Joining strings with streams:");
        System.out.println(joining_1());
    }
}
