package com.tuan.exercise.java8.stream;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tuan.exercise.java8.model.Mentor;
import com.tuan.exercise.java8.model.Student;
import com.tuan.exercise.java8.util.DateTime;
import com.tuan.exercise.java8.util.Log;
import com.tuan.exercise.java8.util.Printer;
import com.tuan.exercise.java8.util.Statistic;

public class App {

    static Mentor mentorOne = new Mentor("Jay", "Jonas", System.currentTimeMillis());
    static Mentor mentorTwo = new Mentor("Ben", "Tennyson", System.currentTimeMillis());
    static Mentor mentorThree = new Mentor("Simba", "Harlord", System.currentTimeMillis());

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>(15);
        studentList.add(new Student("Tuan", "Dao", DateTime.getRandomDateTime(), mentorOne));
        studentList.add(new Student("Natasha", "Romanoff", DateTime.getRandomDateTime(), mentorOne));
        studentList.add(new Student("Tony", "Stark", DateTime.getRandomDateTime(), mentorTwo));
        studentList.add(new Student("Bruce", "Banner", DateTime.getRandomDateTime(), mentorThree));
        studentList.add(new Student("Steve", "Roger", DateTime.getRandomDateTime(), mentorTwo));
        studentList.add(new Student("Thor", "Odinson", DateTime.getRandomDateTime(), mentorOne));
        studentList.add(new Student("Stephen", "Strange", DateTime.getRandomDateTime(), mentorOne));
        studentList.add(new Student("Wanda", "Maximoff", DateTime.getRandomDateTime(), mentorThree));
        studentList.add(new Student("James", "Rhodes", DateTime.getRandomDateTime(), mentorThree));

        // Group students to their corresponding mentor
        Log.info("Map of mentors and their corresponding students");
        Map<Mentor, List<Student>> mentorStudentMap = Statistic.getMentorStudentMap(studentList);
        Printer.printMap(mentorStudentMap);

        // Total skill point sum
        int skillSumTotal = Statistic.getSum(studentList);
        Log.info(String.format("Total Sum: %s", skillSumTotal));

        // Sum of skill point that > 50
        int minSkillVal = 50;
        int sumAbove = Statistic.getFilteredSum(studentList, minSkillVal);
        Log.info((String.format("Sum of skill point that > %d: %s", minSkillVal, sumAbove)));

        Log.lineSep();
        
        // Map show number of skilled student per mentor
        Log.info(String.format("Mentor and count of student with skill >= %d", minSkillVal));
        Map<Mentor, Long> skilledCountMap = Statistic.getSkilledCountMap(mentorStudentMap, minSkillVal);
        Printer.printMap(skilledCountMap);
        
        Log.lineSep();

        LocalDateTime testTime = DateTime.getRandomDateTime();
        Log.info(String.format("List of student with skill >= %d born after %s", minSkillVal, testTime));
        Printer.printList(Statistic.Parallel.getSkilledByAge(studentList, minSkillVal, testTime));
    }
}
