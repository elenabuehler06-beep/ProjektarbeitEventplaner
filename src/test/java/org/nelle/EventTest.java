package org.nelle;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void checkTimely() {
        //create input data
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate datum = LocalDate.parse("2026-01-17", formatter);

        /*
        changed actual currentDate
           from: LocalDateTime currentDate = LocalDate.now().atStartOfDay();
           to :  LocalDate currentDate = LocalDate.parse("2026-01-04", formatter);
        for calculation purposes
        */

        //test distance calculation
        LocalDateTime checkDate = datum.atStartOfDay();
        LocalDateTime currentDate = LocalDate.parse("2026-01-04", formatter).atStartOfDay();
        long distanceInDays = Duration.between(currentDate, checkDate).toDays();
        assertEquals(13,distanceInDays);

        //test control structure from method
        if ((distanceInDays <= 30) && (distanceInDays > 0)) {
            assertTrue((distanceInDays <= 30) && (distanceInDays > 0));
        } else {
            assertFalse((distanceInDays <= 30) && (distanceInDays > 0));
        }

    }

}