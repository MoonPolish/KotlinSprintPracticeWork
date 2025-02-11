package org.example.lesson_11

// Класс, представляющий участника
data class User(
    val nickname: String, // Имя пользователя
    val avatarUrl: String, // URL аватара пользователя
)

// Класс, представляющий комнату
class Room(
    val title: String, // Название комнаты
    val coverUrl: String, // URL обложки комнаты
) {
    // Список участников комнаты
    private val participants = mutableListOf<User>()

    // Здесь хранятся статусы участников
    private val userStatuses = mutableMapOf<String, String>()

    // Метод для добавления участника
    fun addParticipant(user: User) {
        if (user.nickname !in userStatuses) {
            participants.add(user)
            userStatuses[user.nickname] = "микрофон выключен" // Статус по умолчанию
            println("${user.nickname} добавлен(а) в комнату '$title'.")
        } else {
            println("${user.nickname} уже является участником.")
        }
    }

    // Метод для обновления статуса участника
    fun updateStatus(nickname: String, newStatus: String) {
        if (nickname in userStatuses) {
            userStatuses[nickname] = newStatus
            println("Статус пользователя '$nickname' обновлён на '$newStatus'.")
        } else {
            println("Пользователь '$nickname' не найден в комнате.")
        }
    }

    // Метод для отображения информации о комнате
    fun displayRoomInfo() {
        println()
        println("Комната: $title")
        println("Обложка: $coverUrl")
        println("Участники:")
        participants.forEach { user ->
            println("- ${user.nickname} (статус: ${userStatuses[user.nickname]})")
        }
    }
}

fun main() {

    // Создаём комнату
    val room = Room(
        title = "Флудилка",
        coverUrl = "https://... .jpg",
    )

    // Создаём участников
    val user1 = User(nickname = "Рэма", avatarUrl = "https://kek.lol.com.jpg")
    val user2 = User(nickname = "Черепаха", avatarUrl = "https://lol.kek.jpg")
    val user3 = User(nickname = "DobriyDrobovik", avatarUrl = "https://drobovik.jpg")

    // Добавляем всех участников
    room.addParticipant(user1)
    room.addParticipant(user2)
    room.addParticipant(user3)

    // Обновляем статусы участников
    room.updateStatus("Рэма", "разговаривает")
    room.updateStatus("Черепаха", "микрофон выключен")
    room.updateStatus("DobriyDrobovik", "пользователь заглушен")

    // Отображаем информацию о комнате
    room.displayRoomInfo()

}
