package dev.rafex.ether.ai.core.chat;

import java.io.IOException;

public interface AiChatModel {

    AiChatResponse generate(AiChatRequest request) throws IOException, InterruptedException;
}
