package movie.discount.policy;

import common.Money;
import movie.Screening;
import movie.discount.condition.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions.addAll(Arrays.asList(conditions));
    }

    @Override
    public Money calculateDiscountAmount(Screening screening){
        for(DiscountCondition condition : conditions){
            if(condition.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount (Screening screening);
}
