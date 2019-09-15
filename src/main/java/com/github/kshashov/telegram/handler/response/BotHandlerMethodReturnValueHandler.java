package com.github.kshashov.telegram.handler.response;

import com.github.kshashov.telegram.TelegramRequestResult;
import com.github.kshashov.telegram.api.TelegramRequest;
import org.springframework.core.MethodParameter;

/**
 * Strategy interface for resolving method parameters into argument values in the context of a given telegram request.
 */
public interface BotHandlerMethodReturnValueHandler {
    /**
     * Whether the given {@linkplain MethodParameter method return type} is supported by this handler.
     *
     * @param returnType the method return type to check
     * @return {@code true} if this handler supports the supplied return type; {@code false} otherwise
     */
    boolean supportsReturnType(MethodParameter returnType);

    /**
     * Resolves a method parameter into an argument value from a given request.
     *
     * @param returnValue     method result to handle
     * @param returnType      the method parameter to resolve. This parameter must have previously been passed to {@link
     *                        #supportsReturnType} which must have returned {@code true}.
     * @param telegramRequest the current telegram request
     * @return the resolved argument value, or {@code null} if not resolvable
     * @throws Exception in case of errors with the preparation of argument values
     */
    TelegramRequestResult handleReturnValue(Object returnValue, MethodParameter returnType, TelegramRequest telegramRequest) throws Exception;
}
