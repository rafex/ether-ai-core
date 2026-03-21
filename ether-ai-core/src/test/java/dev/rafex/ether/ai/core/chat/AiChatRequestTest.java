package dev.rafex.ether.ai.core.chat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dev.rafex.ether.ai.core.message.AiMessage;

class AiChatRequestTest {

    @Test
    void shouldCopyMessagesDefensively() {
        final var messages = new ArrayList<>(List.of(AiMessage.user("hola")));
        final var request = new AiChatRequest("gpt-test", messages, 0.3d, 128);

        messages.add(AiMessage.user("otro"));

        assertEquals(1, request.messages().size());
        assertEquals("hola", request.messages().get(0).content());
    }

    @Test
    void shouldRejectInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> new AiChatRequest("", List.of(AiMessage.user("hola")), null,
                null));
        assertThrows(IllegalArgumentException.class, () -> new AiChatRequest("model", List.of(), null, null));
        assertThrows(IllegalArgumentException.class,
                () -> new AiChatRequest("model", List.of(AiMessage.user("hola")), 3.0d, null));
        assertThrows(IllegalArgumentException.class,
                () -> new AiChatRequest("model", List.of(AiMessage.user("hola")), null, 0));
    }
}
