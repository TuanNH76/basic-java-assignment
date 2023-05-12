package service;

import model.StudentCapacity;

import java.util.*;

public class SortPercentService {

    public SortPercentService() {
    }

    public void sortCapacityPercent() {
        if (StudentService.StudentList.isEmpty()) {
            System.err.println("Student List is empty!");
            return;
        }
        System.out.println("List of Student Capacity Percentage ");
        ArrayList<StudentCapacity> CapacityList = new ArrayList<>();
        for (int i = 0; i < StudentService.StudentList.size(); i++) {
            CapacityList.add(StudentService.StudentList.get(i).getStudentCapacity());
        }
        Map<StudentCapacity, Integer> CapacityCounter = new HashMap<>();
        for (int i = 0; i < CapacityList.size(); i++) {
            if (!CapacityCounter.containsKey(CapacityList.get(i))) {
                CapacityCounter.put(CapacityList.get(i), 1);
            } else {
                CapacityCounter.put(CapacityList.get(i), CapacityCounter.get(CapacityList.get(i)) + 1);
            }
        }
        List<Map.Entry<StudentCapacity, Integer>> sortedCapacity = new ArrayList<>(CapacityCounter.entrySet());
        sortedCapacity.sort(Collections.reverseOrder(Comparator.comparingInt(entry -> (entry.getValue()))));
        for (Map.Entry<StudentCapacity, Integer> capacity : sortedCapacity) {
            double percentage = (double) capacity.getValue() / CapacityList.size() * 100;
            System.out.printf("%s  :  %.2f %% \n", capacity.getKey(), percentage);
        }
    }

    public void showGPAPercent() {
        if (StudentService.StudentList.isEmpty()) {
            System.err.println("Student List is empty!");
            return;
        }
        System.out.println("GPA Percent ");
        ArrayList<Double> ScoreList = new ArrayList<>();
        for (int i = 0; i < StudentService.StudentList.size(); i++) {
            ScoreList.add(StudentService.StudentList.get(i).getGPA());
        }

        HashMap<Double, Integer> ScoreCounter = new HashMap<>();

        for (int i = 0; i < ScoreList.size(); i++) {
            if (!ScoreCounter.containsKey(ScoreList.get(i))) {
                ScoreCounter.put(ScoreList.get(i), 1);
            } else {
                ScoreCounter.put(ScoreList.get(i), ScoreCounter.get(ScoreList.get(i)) + 1);
            }
        }
        for (double score : ScoreCounter.keySet()) {
            double percentage = (double) ScoreCounter.get(score) / ScoreList.size() * 100;
            System.out.printf("%.2f : %.2f %% \n", score, percentage);
        }

    }
}
