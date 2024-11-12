
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
import java.time.Period;

/**
 * A class representing a recurring task that repeats at specified intervals.
 * For example, a task that recurs daily, weekly, or monthly.
 *
 * @author badreddine
 */
public class RecurringTask extends Task {
    private Period recurrenceInterval;
    private LocalDate nextOccurrenceDate;
    private String recurrenceRule;

    // Constructor to initialize a RecurringTask
    public RecurringTask(Long taskId, String taskName, String description, LocalDate dueDate,
                         Period recurrenceInterval, LocalDate nextOccurrenceDate, String recurrenceRule) {
        super(taskId, taskName, description, dueDate);
        this.recurrenceInterval = recurrenceInterval;
        this.nextOccurrenceDate = nextOccurrenceDate;
        this.recurrenceRule = recurrenceRule;
    }

    // Calculate the next occurrence date by adding the recurrence interval to the current occurrence date
    public LocalDate calculateNextOccurrenceDate() {
        return nextOccurrenceDate.plus(recurrenceInterval);
    }

    // Checks if the task is due
    public Boolean isTaskDue() {
        LocalDate now = LocalDate.now();
        return !now.isBefore(nextOccurrenceDate);
    }

    // Executes the recurring task if due and updates the next occurrence date
    public void executeRecurringTask() {
        if (isTaskDue()) {
            System.out.println("Executing recurring task: " + getTaskDescription());
            this.nextOccurrenceDate = calculateNextOccurrenceDate();
        } else {
            System.out.println("Task is not due yet.");
        }
    }

    // Getter for next occurrence date
    public LocalDate getNextOccurrenceDate() {
        return nextOccurrenceDate;
    }

    // Getter for recurrence interval
    public Period getRecurrenceInterval() {
        return recurrenceInterval;
    }

    // Getter for recurrence rule
    public String getRecurrenceRule() {
        return recurrenceRule;
    }
}
