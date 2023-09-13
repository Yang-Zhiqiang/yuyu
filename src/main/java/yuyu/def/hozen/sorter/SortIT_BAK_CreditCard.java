package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_CreditCard;
import yuyu.def.db.meta.QIT_BAK_CreditCard;
import yuyu.def.hozen.comparator.OrderIT_BAK_CreditCard;

public class SortIT_BAK_CreditCard {

    public List<IT_BAK_CreditCard> OrderIT_BAK_CreditCardByPkAsc(List<IT_BAK_CreditCard> pEntity) {
        List<SortCondition<IT_BAK_CreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_CreditCard()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCard()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCard()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_CreditCard> copyList = new ArrayList<IT_BAK_CreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_CreditCard(orders));
        return copyList;
    }

    public List<IT_BAK_CreditCard> OrderIT_BAK_CreditCardByPkDesc(List<IT_BAK_CreditCard> pEntity) {
        List<SortCondition<IT_BAK_CreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_CreditCard()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCard()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCard()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_CreditCard> copyList = new ArrayList<IT_BAK_CreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_CreditCard(orders));
        return copyList;
    }

}

