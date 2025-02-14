package org.example.lesson_11

class User(val userId: Int, val userName: String)

class Message(val authorId: Int, val message: String)

class Forum(
    val users: MutableList<User> = mutableListOf(),
    val messages: MutableList<Message> = mutableListOf(),
    var userIdCounter: Int = 1,
) {

    fun createNewUser(userName: String): User {
        val newUser = User(userIdCounter++, userName)
        users.add(newUser)
        return newUser
    }

    fun createNewMessage(authorId: Int, message: String) {
        if (users.any { it.userId == authorId }) {
            val newMessage = Message(authorId, message)
            messages.add(newMessage)
        } else {
            println("Пользователь с id $authorId не существует.")
        }
    }

    fun printThread() {
        for (message in messages) {
            val author = users.find { it.userId == message.authorId }
            if (author != null) {
                println("${author.userName}: ${message.message}")
            }
        }
    }
}

fun main() {
    val forum = Forum()

    val user1 = forum.createNewUser("Rema")
    val user2 = forum.createNewUser("Alena")

    forum.createNewMessage(user1.userId, "Привет, Алёна!")
    forum.createNewMessage(user1.userId, "Как твои дела?")
    forum.createNewMessage(user2.userId, "Привет, Рэма!")
    forum.createNewMessage(user2.userId, "Всё хорошо, но я соскучилась")

    forum.printThread()

}