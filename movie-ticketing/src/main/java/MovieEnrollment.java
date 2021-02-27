import common.Money;
import movie.discount.condition.PeriodCondition;
import movie.discount.condition.SequenceCondition;
import movie.discount.policy.AmountDiscountPolicy;
import movie.discount.policy.DiscountPolicy;
import movie.discount.policy.NoneDiscountPolicy;
import movie.discount.policy.PercentDiscountPolicy;
import movie.Movie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class MovieEnrollment {
    public Movie avatar() {
        return new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), avatarDiscountPolicy());
    }

    public DiscountPolicy avatarDiscountPolicy() {
        return new AmountDiscountPolicy(
                Money.wons(800),
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
        );
    }

    public Movie titanic() {
        return new Movie("타이타닉", Duration.ofMinutes(180), Money.wons(11000), titanicDiscountPolicy());
    }

    public DiscountPolicy titanicDiscountPolicy() {
        return new PercentDiscountPolicy(
                0.1,
                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                new SequenceCondition(2),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
        );
    }

    public Movie starWars (){
        return new Movie(
                "스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                starWarsDiscountPolicy()
        );
    }

    public DiscountPolicy starWarsDiscountPolicy (){
        return new NoneDiscountPolicy();
    }
}
