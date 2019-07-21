package com.tuan.exercise.java8.util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tuan.exercise.java8.model.Mentor;
import com.tuan.exercise.java8.model.Student;

public class Statistic {
    private Statistic() {
    }
    
    public static Map<Mentor, List<Student>> getMentorStudentMap(List<Student> studentList) {
        return studentList.stream()
                .collect(Collectors.groupingBy(Student::getMentor));
    }

    public static int getSum(List<Student> studentList) {
        return studentList.stream()
                .map(Student::getSkillPoint)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static int getFilteredSum(List<Student> studentList, int minAcceptableVal) {
        return studentList.stream()
                .map(Student::getSkillPoint).filter(skill -> skill >= minAcceptableVal)
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static Long getSkilledCount(List<Student> studentList, int minAcceptableVal) {
        return studentList.stream()
                .filter(skill -> skill.getSkillPoint() >= minAcceptableVal)
                .count();
    }

    public static Map<Mentor, Long> getSkilledCountMap(
            Map<Mentor, List<Student>> mentorStudentMap, 
            int minAcceptableVal) {

        return mentorStudentMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().stream()
                        .map(Student::getSkillPoint).filter(skill -> skill >= minAcceptableVal)
                        .count()
                        ));
    }
    
    public static class Parallel {
        private Parallel() {
        }

        public static Long getSkilledCount(List<Student> studentList, int minAcceptableVal) {
            return studentList.parallelStream()
                    .filter(student -> student.getSkillPoint() >= minAcceptableVal)
                    .count();
        }

        public static List<Student> getSkilledByAge(List<Student> studentList, int minAcceptableVal,
                LocalDateTime minDob) {
            return studentList.parallelStream()
                    .filter(
                            student -> student.getSkillPoint() >= minAcceptableVal && 
                            student.getDob().compareTo(minDob) > 0)
                    .collect(Collectors.toList());
        }
    }
}
