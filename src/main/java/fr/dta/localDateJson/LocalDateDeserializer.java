package fr.dta.localDateJson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String t = parser.readValueAs(String.class);
        System.out.println(t);
        String tabS[] = t.split("-");
        int[] tab = {Integer.parseInt(tabS[0]),Integer.parseInt(tabS[1]),Integer.parseInt(tabS[2])};
        LocalDate date = LocalDate.of(tab[0],tab[1],tab[2]);
        return date;
    }
}