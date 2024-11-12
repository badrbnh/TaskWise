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
 * A class representing an EventTask with a start and end time, location,
 * and attendees, extending the basic Task class.
 *
 * @author Badreddine
 */
public class EventTask extends Task {
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;
    private final String eventLocation;
    private final String[] eventAttendees;

    // Constructor with parameters to initialize an EventTask
    public EventTask(Long taskId, String taskName, String description, LocalDate dueDate,
                     LocalDateTime startDateTime, LocalDateTime endDateTime,
                     String eventLocation, String[] eventAttendees) {
        super(taskId, taskName, description, dueDate);
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.eventLocation = eventLocation;
        this.eventAttendees = eventAttendees;
    }

    // Checks if the event is currently ongoing based on the current time
    public Boolean isEventOnGoing() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(this.startDateTime) && now.isBefore(this.endDateTime);
    }

    // Displays details about the event
    public void displayEventDetails() {
        System.out.println("Event: " + getTaskDescription());
        System.out.println("Location: " + eventLocation);
        System.out.println("Start: " + startDateTime);
        System.out.println("End: " + endDateTime);
        System.out.println("Attendees: " + String.join(", ", eventAttendees));
    }

    // Getters
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public String[] getEventAttendees() {
        return eventAttendees;
    }
}
