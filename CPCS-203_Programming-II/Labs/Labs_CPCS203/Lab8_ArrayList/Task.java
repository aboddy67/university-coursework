package Labs_CPCS203.Lab8_ArrayList;

public class Task {
    private String title;
    private String dueDate;
    private int status;

    public Task() {
        this.title = "";
        this.dueDate = "";
        this.status = 0;
    }

    public Task(String title, String dueDate, int status) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return title + "     " + dueDate + "     " + status;
    }
}
