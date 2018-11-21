package server

object Tasks {
    private val tasks = ArrayList<String>()

    fun getTasks() = listOf(tasks)

    fun addTask(task:String) = tasks.add(task)
}