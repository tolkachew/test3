package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class RateTest {
    private Rate getRateForDate(String date) throws IOException {
        URL url = new URL("https://api.nbrb.by/exrates/rates/431?ondate=" + date);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Rate rate = mapper.readValue(is, Rate.class);
        is.close();
        return rate;
    }

    private LocalDate parseDate(String dateTime) {
        return LocalDate.parse(dateTime.split("T")[0], DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Test
    public void testUsdRateOnSep1st2023() throws IOException {
        Rate rate = getRateForDate("2023-09-01");
        assertEquals("USD", rate.getAbbreviation());
        assertEquals(LocalDate.of(2023, 9, 1), parseDate(rate.getDate()));
        assertEquals(3.22, rate.getOfficialRate(), 0.01);
    }

    @Test
    public void testUsdRateOnOct1st2023() throws IOException {
        Rate rate = getRateForDate("2023-10-01");
        assertEquals("USD", rate.getAbbreviation());
        assertEquals(LocalDate.of(2023, 10, 1), parseDate(rate.getDate()));
        assertEquals(3.28, rate.getOfficialRate(), 0.01);
    }

    @Test
    public void testUsdRateOnNov1st2023() throws IOException {
        Rate rate = getRateForDate("2023-11-01");
        assertEquals("USD", rate.getAbbreviation());
        assertEquals(LocalDate.of(2023, 11, 1), parseDate(rate.getDate()));
        assertEquals(3.16, rate.getOfficialRate(), 0.01);
    }
}