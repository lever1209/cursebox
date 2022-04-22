package pkg.deepCurse.curseBox.core.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pkg.deepCurse.curseBox.core.CurseBox;

public class TimedTask {
	private static List<TimedTask> taskList = new ArrayList<TimedTask>();
	private int delayInTicks;
	private Task task;
	private String ID = "anonymous";

	private TimedTask(int delayInTicks, Task task) {
		this.delayInTicks = delayInTicks;
		this.task = task;
	}

	private TimedTask(String id, int delayInTicks, Task task) {
		this.delayInTicks = delayInTicks;
		this.task = task;
	}

	public static void createAnonymousTimedTask(int delayInTicks, Task task) {
		taskList.add(new TimedTask(delayInTicks, task));
	}

	public static void createTimedTask(String ID, boolean shouldCheckIfIDExists, int delayInTicks, Task task) {
		if (ID.contentEquals("anonymous")) {
			throw new IllegalArgumentException("Identifier anonymous is used internally, use a different identifier");
		} else {
			if (shouldCheckIfIDExists) {
				Iterator<TimedTask> var4 = taskList.iterator();

				while (var4.hasNext()) {
					TimedTask i = (TimedTask) var4.next();
					if (i.getID() == null) {
						return;
					}

					if (i.getID().contentEquals(ID)) {
						CurseBox.LOGGER.info("Task with id: " + ID + " already exists. . .");
						return;
					}
				}
			}

			taskList.add(new TimedTask(ID, delayInTicks, task));
		}
	}

	private String getID() {
		return this.ID;
	}

	public static void tickAllTasks() {
		List<TimedTask> shit = new ArrayList<TimedTask>();
		Iterator<TimedTask> var1 = taskList.iterator();

		TimedTask task;
		while (var1.hasNext()) {
			task = (TimedTask) var1.next();
			if (task.tick()) {
				shit.add(task);
			}
		}

		var1 = shit.iterator();

		while (var1.hasNext()) {
			task = (TimedTask) var1.next();
			taskList.remove(task);
		}

	}

	public static void tickTask(String ID) {
		List<TimedTask> shit = new ArrayList<TimedTask>();
		Iterator<TimedTask> var2 = taskList.iterator();

		TimedTask task;
		while (var2.hasNext()) {
			task = (TimedTask) var2.next();
			if (task.getID().contentEquals(ID) && task.tick()) {
				shit.add(task);
			}
		}

		var2 = shit.iterator();

		while (var2.hasNext()) {
			task = (TimedTask) var2.next();
			taskList.remove(task);
		}

	}

	public static List<TimedTask> getTaskList() {
		return taskList;
	}

	private boolean tick() {
		--this.delayInTicks;
		if (this.delayInTicks <= 0) {
			this.task.run();
			return true;
		} else {
			return false;
		}
	}

	public interface Task {
		void run();
	}
}