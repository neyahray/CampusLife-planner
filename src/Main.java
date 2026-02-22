import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--ALL COURSES--");
        Course course1 = new Course("Calculus", "Hussein Chebsi", 6);
        Course course2 = new Course("Discrete Math", "Sherali Matanov", 6);
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(" ");

        AssignmentTask[] tasks = {
            new AssignmentTask("Presentation", course1, 4, 2, true),
            new AssignmentTask("Assignment 2", course1, 1, 1, false),
            new AssignmentTask("Quiz", course2, 2, 4, false),
            new AssignmentTask("HomeWork 4", course2, 3, 1, true),
            new AssignmentTask("HomeWork 5", course2, 5, 2, false)
        };

        System.out.println("--ALL TASKS--");
        for (AssignmentTask task : tasks) {
            System.out.println(task);
        }
        System.out.println(" ");

        System.out.println("--URGENT TASKS--");
        for (AssignmentTask task : tasks) {
            if (task.isUrgent()) {
                System.out.println(task);
            }
        }
        System.out.println(" ");

        int estHoursRem = 0;
        for (AssignmentTask task : tasks) {
            if (!task.isDone()) {
                estHoursRem += task.getEstimatedHours();
            }
        }
        System.out.println("--ESTIMATED HOURS REMAINING: " + estHoursRem + " hours--");
        System.out.println(" ");

        StudySession[] sessions = {
            new StudySession(course1, 66),
            new StudySession(course2, 52)
        };
        System.out.println("--STUDY TIME PER COURSE--");
        for (StudySession session : sessions) {
            System.out.println(session.getCourse().getName() + ": " + session.getMinutes() + " minutes");
        }
        System.out.println(" ");

        tasks[4].setCompleted(true);
        System.out.println("The Assignment " + tasks[4].getTitle() + " now completed!");
        System.out.println(tasks[4]);

        estHoursRem = 0;
        for (AssignmentTask task : tasks) {
            if (!task.isDone()) {
                estHoursRem += task.getEstimatedHours();
            }
        }

        System.out.println(" ");
        System.out.println("--NEW ESTIMATED HOURS REMAINING: " + estHoursRem + " hours--");
        System.out.println(" ");






    }
}

class Course {
    String name, instructor;
    int credits;

    Course(String name, String instructor, int credits) {
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }
    public String getInstructor() {
        return instructor;
    }
    public int getCredits() {
        return credits;
    }
    public String toString() {
        return "Course {name = '" + name + "', instructor = '" + instructor + "', credits = " + credits + "}";
    }
}


class AssignmentTask {
    private String title;
    private Course course;
    private int estimatedHours, daysUntilDue;
    private boolean completed;

    AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue, boolean completed) {
        this.title = title;
        this.course = course;
        this.estimatedHours = estimatedHours;
        this.daysUntilDue = daysUntilDue;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }
    public Course getCourse() {
        return course;
    }
    public int getEstimatedHours() {
        return estimatedHours;
    }
    public int getDaysUntilDue() {
        return daysUntilDue;
    }

    public void markCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isUrgent() {
        if (daysUntilDue <= 2 && !completed) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isDone() {
        if (completed) {
            return true;
        } else {
            return false;
        }
    }

    public void setCompleted(boolean newCompleted) {
        this.completed = true;
    }



    public String toString() {
        return "AssignmentTask {title = '" + title + "', course = '" + course.getName() + "', estHours = '" + estimatedHours + "', dueIn = '" + daysUntilDue + "', completed = '" + completed + "'}";
    }
}


class StudySession {
    private Course course;
    int minutes;

    StudySession(Course course, int minutes) {
        this.course = course;
        this.minutes = minutes;
    }

    public Course getCourse() {
        return course;
    }
    public double getMinutes() {
        return minutes;
    }
    public String toString() {
        return "StudySession {course = '" + course.getName() + "', minutes = '" + minutes + "'}";
    }
}


//class CampusLi