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
import java.time.LocalDateTime;

/**
 * A class representing a ReminderTask with a specific reminder date and message.
 * Sends a reminder message at the designated reminder date and time.
 *
 * @author Badreddine
 */
public class ReminderTask extends Task implements Notifiable {
    private LocalDateTime reminderDateTime;
    private String reminderMessage;

    // Constructor to initialize ReminderTask
    public ReminderTask(Long taskId, String taskName, String description, LocalDate dueDate,
                        LocalDateTime reminderDateTime, String reminderMessage) {
        super(taskId, taskName, description, dueDate);
        this.reminderDateTime = reminderDateTime;
        this.reminderMessage = reminderMessage;
    }

    // Checks if the reminder is due
    public Boolean isReminderDue() {
        LocalDateTime now = LocalDateTime.now();
        return !now.isBefore(reminderDateTime);
    }

    // Sends the reminder message
    public void sendReminder() {
        if (isReminderDue()) {
            System.out.println("Reminder: " + reminderMessage);
        } else {
            System.out.println("Reminder not due yet.");
        }
    }

    // Getters for reminderDateTime and reminderMessage
    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public String getReminderMessage() {
        return reminderMessage;
    }
}
