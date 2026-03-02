import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--ALL COURSES--");
        Course course1 = new Course("Calculus", "Hussein Chebsi", 6);
        Course course2 = new Course("Discrete Math", "Sherali Matanov", 6);
        Course course3 = new Course("Korean Language", "Miss Tattybubu", 6);
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(course3);
        System.out.println(" ");
//
//        AssignmentTask[] tasks = {
//            new AssignmentTask("Presentation", course1, 4, 2, true),
//            new AssignmentTask("Assignment 2", course1, 1, 1, false),
//            new AssignmentTask("Quiz", course2, 2, 4, false),
//            new AssignmentTask("HomeWork 4", course2, 3, 1, true),
//            new AssignmentTask("HomeWork 5", course2, 5, 2, false)
//        };
//
//        System.out.println("--ALL TASKS--");
//        for (AssignmentTask task : tasks) {
//            System.out.println(task);
//        }
//        System.out.println(" ");
//
//        System.out.println("--URGENT TASKS--");
//        for (AssignmentTask task : tasks) {
//            if (task.isUrgent()) {
//                System.out.println(task);
//            }
//        }
//        System.out.println(" ");
//
//        int estHoursRem = 0;
//        for (AssignmentTask task : tasks) {
//            if (!task.isDone()) {
//                estHoursRem += task.getEstimatedHours();
//            }
//        }
//        System.out.println("--ESTIMATED HOURS REMAINING: " + estHoursRem + " hours--");
//        System.out.println(" ");
//
//        StudySession[] sessions = {
//            new StudySession(course1, 66),
//            new StudySession(course2, 52)
//        };
//        System.out.println("--STUDY TIME PER COURSE--");
//        for (StudySession session : sessions) {
//            System.out.println(session.getCourse().getName() + ": " + session.getMinutes() + " minutes");
//        }
//        System.out.println(" ");
//
//        tasks[4].setCompleted(true);
//        System.out.println("The Assignment " + tasks[4].getTitle() + " now completed!");
//        System.out.println(tasks[4]);
//
//        estHoursRem = 0;
//        for (AssignmentTask task : tasks) {
//            if (!task.isDone()) {
//                estHoursRem += task.getEstimatedHours();
//            }
//        }
//
//        System.out.println(" ");
//        System.out.println("--NEW ESTIMATED HOURS REMAINING: " + estHoursRem + " hours--");
//        System.out.println(" ");

        ArrayList<PlanItem> allItems = new ArrayList<>();
        allItems.add(new AssignmentTask("Exercises", course2, 1, 4, false));
        allItems.add(new AssignmentTask("Presentation", course1, 3, 3, true));
        allItems.add(new ExamPreparation("MidTerm", course3, 2, 1, false));
        allItems.add(new ExamPreparation("MidTerm", course1, 23, 14, false));
        allItems.add(new ClubEvent("Decorate Konya Holl", 4, 2, false));
        allItems.add(new ClubEvent("Prepare for AIU FEST", 10, 7, true));

        for (PlanItem item : allItems) {
            System.out.println(item.calculateUrgency());
        }
        System.out.println(" ");

        allItems.get(2).markCompleted(true);
        System.out.println(allItems.get(2).calculateUrgency());
        System.out.println(" ");

        int totalRemaining = 0;
        for (PlanItem item : allItems) {
            if (!item.isDone()) {
                totalRemaining += item.getEstimatedHours();
            }
        }
        System.out.println("--Total hours remaining: " + totalRemaining + " hours--");
        System.out.println(" ");


        int min = Integer.MAX_VALUE;
        String title = " ";
        for (PlanItem item : allItems) {
            if (item.getDaysUntilDue() < min) {
                min = item.getDaysUntilDue();
                title = item.getTitle();
            }
        }
        System.out.println("--Most urgent activity is now: " + title + ". You have only " + min + " days! Hurry up!--");



    }
}


