package movie.discount.policy;

import common.Money;
import movie.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
