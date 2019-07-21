package com.tuan.exercise.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tuan.exercise.java8.model.Mentor;
import com.tuan.exercise.java8.model.Student;
import com.tuan.exercise.java8.util.DateTime;
import com.tuan.exercise.java8.util.Log;
import com.tuan.exercise.java8.util.Statistic;

public class AppParallel {

    public static void main(String[] args) {

        Mentor[] mentors = { new Mentor("Jay", "Jonas", System.currentTimeMillis()),
                new Mentor("Ben", "Tennyson", System.currentTimeMillis()),
                new Mentor("Simba", "Harlord", System.currentTimeMillis()) };

        int studentNum = 10000;
        List<Student> studentList = new ArrayList<>(studentNum);
        Random rnd = new Random();
        Log.info("Preparing Data");
        for (int i = 0; i < studentNum; i++) {
            studentList.add(
                    new Student("NONE", "NONE", DateTime.getRandomDateTime(), mentors[rnd.nextInt(mentors.length)]));
        }
        Log.info("Finished Preparing Data");

        int minSkillPoint = 50;
        long start;
        long end;
        start = System.currentTimeMillis();
        long seqCount = Statistic.Parallel.getSkilledCount(studentList, minSkillPoint);
        end = System.currentTimeMillis();
        Log.info(
                String.format("Number of student with skill >= %d (Sequential Counting): %d", minSkillPoint, seqCount));
        Log.info(String.format("Iteration Duration: %dms", end - start));

        Log.info("-----");

        start = System.currentTimeMillis();
        long paraCount = Statistic.Parallel.getSkilledCount(studentList, minSkillPoint);
        end = System.currentTimeMillis();
        Log.info(String.format("Number of student with skill >= %d (Parallel): %d", minSkillPoint, paraCount));
        Log.info(String.format("Iteration Duration: %dms", end - start));
    }

}
