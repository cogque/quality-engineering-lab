package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;

public class AllureUtils {

    private static final ObjectMapper mapper =
            new ObjectMapper();

    public static void attachRequest(
            String name,
            Object request) {

        try {

            String json =
                    mapper.writerWithDefaultPrettyPrinter()
                            .writeValueAsString(request);

            Allure.addAttachment(name, json);

        } catch (Exception e) {

            Allure.addAttachment(
                    "Serialization Error",
                    e.getMessage());
        }
    }

    public static void attachResponse(
            String name,
            String response) {

        Allure.addAttachment(
                name,
                response);
    }
}
