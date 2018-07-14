package by.itacademy.finalProject.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;

public class ArrayIntDeserializer extends StdDeserializer<int[]> {
    protected ArrayIntDeserializer() {
        super(Arrays.class);
    }

    @Override
    public int[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String marksInString = jsonParser.getValueAsString();
        String[] numbersAsString = marksInString.split(",");
        int[] marks = new int[numbersAsString.length];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = Integer.parseInt(numbersAsString[i]);
        }
        return marks;
    }
}
