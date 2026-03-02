public class PlanItem {
    private String title;
    private int estimatedHours, daysUntilDue;
    private boolean completed;

    PlanItem(String title, int estimatedHours, int daysUntilDue, boolean completed) {
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.daysUntilDue = daysUntilDue;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
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

    public boolean notUrgentAndNotCompleted() {
        if (daysUntilDue > 2 && !completed) {
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

    public String calculateUrgency() {
        if (isUrgent()) {
            return "URGENT! " + daysUntilDue + " days left!";
        }
        return "Due in " + daysUntilDue + " days";
    }

}