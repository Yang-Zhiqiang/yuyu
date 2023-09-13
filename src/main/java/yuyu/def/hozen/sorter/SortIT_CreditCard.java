package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_CreditCard;
import yuyu.def.db.meta.QIT_CreditCard;
import yuyu.def.hozen.comparator.OrderIT_CreditCard;

public class SortIT_CreditCard {

    public List<IT_CreditCard> OrderIT_CreditCardByPkAsc(List<IT_CreditCard> pEntity) {
        List<SortCondition<IT_CreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CreditCard()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_CreditCard()).syono, SortOrder.ASC));
        List<IT_CreditCard> copyList = new ArrayList<IT_CreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_CreditCard(orders));
        return copyList;
    }

    public List<IT_CreditCard> OrderIT_CreditCardByPkDesc(List<IT_CreditCard> pEntity) {
        List<SortCondition<IT_CreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CreditCard()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_CreditCard()).syono, SortOrder.DESC));
        List<IT_CreditCard> copyList = new ArrayList<IT_CreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_CreditCard(orders));
        return copyList;
    }

}

