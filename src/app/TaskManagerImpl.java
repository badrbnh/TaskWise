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
import java.util.ArrayList;
import java.util.List;

/**
 * A concrete implementation of the TaskManager interface for managing tasks.
 *
 * @param <T> the type of task (e.g., Task, EventTask, ReminderTask, etc.)
 */
public class TaskManagerImpl<T> implements TaskManager<T> {

    private final List<T> tasks;

    public TaskManagerImpl() {
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(T task) {
        tasks.add(task);
    }

    @Override
    public void removeTask(T task) {
        tasks.remove(task);
    }

    @Override
    public T getTaskById(Long taskId) {
        // For simplicity, this example assumes task has a method `getTaskId()`
        for (T task : tasks) {
            if (task instanceof Task && ((Task) task).getTaskId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public List<T> getAllTasks() {
        return tasks;
    }
}
