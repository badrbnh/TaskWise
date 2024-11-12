/*
 *
 *  * © [TaskWise] ${YEAR}. All rights reserved.
 *  *
 *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  * of this software and associated documentation files (the "Software"), to deal
 *  * in the Software without restriction, including without limitation the rights
 *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  * copies of the Software, and to permit persons to whom the Software is
 *  * furnished to do so, subject to the following conditions:
 *  *
 *  * The above copyright notice and this permission notice shall be included in
 *  * all copies or substantial portions of the Software.
 *  *
 *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES, OR OTHER
 *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  * THE SOFTWARE.
 *
 *
 */

package app;


import java.time.LocalDate;

/**
 * Represents a generic Task with basic attributes such as taskId, taskName, description, and due date.
 *
 * @author Badreddine
 */
public class Task {
    private final Long taskId;  // Using BigDecimal for task ID
    private String taskName;
    private String taskDescription;
    private LocalDate taskDueDate;

    /**
     * Constructor to initialize a Task with the given details.
     *
     * @param taskId the unique identifier for the task
     * @param taskName the name of the task
     * @param description the description of the task
     * @param dueDate the due date for the task
     */
    public Task(Long taskId, String taskName, String description, LocalDate dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = description;
        this.taskDueDate = dueDate;
    }

    public Long getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(LocalDate taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskDueDate=" + taskDueDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return taskId.equals(task.taskId);
    }

    @Override
    public int hashCode() {
        return taskId.hashCode();
    }
}
