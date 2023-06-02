import lombok.extern.log4j.Log4j2;

import java.util.Objects;

import static java.util.Objects.isNull;

@Log4j2
public class Horse {

    private final String name;
    private final double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        if (isNull(name)) {
            log.error("Name is null");
            throw new IllegalArgumentException(ExceptionMsg.NAME_CANNOT_BE_NULL.msg);
        } else if (name.isBlank()) {
            log.error("Name is blank");
            throw new IllegalArgumentException(ExceptionMsg.NAME_CANNOT_BE_BLANK.msg);
        }
        if (speed < 0) {
            log.error("Speed is negative");
            throw new IllegalArgumentException(ExceptionMsg.SPEED_CANNOT_BE_NEGATIVE.msg);
        }
        if (distance < 0) {
            log.error("Distance is negative");
            throw new IllegalArgumentException(ExceptionMsg.DISTANCE_CANNOT_BE_NEGATIVE.msg);
        }

        this.name = name;
        this.speed = speed;
        this.distance = distance;
        //log.debug("Создание Horse, имя [{}], скорость [{}], дистанция [{}]", name, speed, distance);
    }

    public Horse(String name, double speed) {
        this(name, speed, 0);
        log.debug("Создание Horse, имя [{}], скорость [{}]", name, speed);
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void move() {
        distance += speed * getRandomDouble(0.2, 0.9);
    }

    public static double getRandomDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Double.compare(horse.speed, speed) == 0 && Double.compare(horse.distance, distance) == 0 && Objects.equals(name, horse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed, distance);
    }

    public enum ExceptionMsg {
        NAME_CANNOT_BE_NULL("Name cannot be null."),
        NAME_CANNOT_BE_BLANK("Name cannot be blank."),
        SPEED_CANNOT_BE_NEGATIVE("Speed cannot be negative."),
        DISTANCE_CANNOT_BE_NEGATIVE("Distance cannot be negative.");
        private final String msg;
        ExceptionMsg(String msg) {
            this.msg = msg;
        }
        public String getMsg() {
            return msg;
        }
    }
}
