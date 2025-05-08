import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EnrollTest {

    @Test
    @DisplayName("자동차 이동 테스트")
    void movingTest(){
        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");

        car1.move(3);
        car2.move(4);
        car2.move(5);
        car3.move(7);

        assertThat(car1).extracting("location").isEqualTo(0);
        assertThat(car2).extracting("location").isEqualTo(9);
        assertThat(car3).extracting("location").isEqualTo(7);
    }

    @Test
    @DisplayName("우승자 식별 테스트")
    void getWinnerTest(){
        ByteArrayOutputStream printedMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printedMessage));

        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");

        car1.move(2);
        car2.move(9);
        car2.move(9);
        car3.move(3);

        List<Car> cars = List.of(car1, car2, car3);
        Racing racing = new Racing(cars);
        racing.start(0);

        assertThat(printedMessage.toString()).contains("car2");
    }

    @Test
    @DisplayName("공동 우승자 식별 테스트")
    void getWinnersTest(){
        ByteArrayOutputStream printedMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printedMessage));

        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");

        car1.move(2);
        car2.move(9);
        car3.move(9);

        List<Car> cars = List.of(car1, car2, car3);
        Racing racing = new Racing(cars);
        racing.start(0);

        assertThat(printedMessage.toString()).contains("car2");
        assertThat(printedMessage.toString()).contains("car3");
    }

}
