package com.example.ai.repository;

import java.util.List;

public interface ChatHistoryRepository {

    /**
     * Save a chat message to the history.
     * @param type The type of message (e.g., "user" or "assistant").
     * @param chatId The ID of the chat session.
     */
    void save(String type, String chatId);

    /**
     * Retrieve chat IDs based on the type of message.
     * @param type The type of message (e.g., "user" or "assistant").
     * @return A list of chat IDs associated with the specified type.
     */

    List<String> getChatIds(String type);
}
