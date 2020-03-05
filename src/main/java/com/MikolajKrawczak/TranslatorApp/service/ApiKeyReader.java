package com.MikolajKrawczak.TranslatorApp.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class ApiKeyReader {

    public String readApiKey() {
        StringBuilder stringBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get("apiKey.txt"), StandardCharsets.UTF_8)){
            stream.forEach(s -> stringBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
