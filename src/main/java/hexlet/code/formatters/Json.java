package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Node;

import java.util.List;

public class Json {
    public static String getFormated(List<Node> resultListOfPairs) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(resultListOfPairs);
    }
}
