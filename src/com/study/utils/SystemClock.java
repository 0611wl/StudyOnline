package com.study.utils;


import java.sql.Timestamp;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class SystemClock {
  public static final long MILLIS_A_SECOND = 1000L;
  public static final long MILLIS_A_MINUTE = 60 * MILLIS_A_SECOND;
  public static final long MILLIS_A_HOUR = 60 * MILLIS_A_MINUTE;
  public static final long MILLIS_A_DAY = 24 * MILLIS_A_HOUR;
  public static final long MILLIS_A_WEEK = 7 * MILLIS_A_DAY;
  private static Clock clock = Clock.systemDefaultZone();

  public static long millis() {
    return clock.millis();
  }

  public static int seconds() {
    return (int) (millis() / 1000);
  }

  public static LocalDateTime dateTime() {
    return LocalDateTime.now(clock);
  }

  public static LocalDate localDate() {
    return LocalDate.now(clock);
  }

  public static Date date() {
    return new Date(clock.millis());
  }

  public static void setClock(Clock newClock) {
    SystemClock.clock = newClock;
  }

  public static Clock getClock() {
    return clock;
  }

  public static void main(String[] args) {
    SystemClock.setClock(Clock.offset(Clock.systemDefaultZone(), Duration.ofHours(1)));
  }

  public static Timestamp timestamp() {
    return new Timestamp(millis());
  }
}

