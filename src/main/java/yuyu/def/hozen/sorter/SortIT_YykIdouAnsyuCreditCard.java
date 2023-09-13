package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_YykIdouAnsyuCreditCard;
import yuyu.def.db.meta.QIT_YykIdouAnsyuCreditCard;
import yuyu.def.hozen.comparator.OrderIT_YykIdouAnsyuCreditCard;

public class SortIT_YykIdouAnsyuCreditCard {

    public List<IT_YykIdouAnsyuCreditCard> OrderIT_YykIdouAnsyuCreditCardByPkAsc(List<IT_YykIdouAnsyuCreditCard> pEntity) {
        List<SortCondition<IT_YykIdouAnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YykIdouAnsyuCreditCard()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YykIdouAnsyuCreditCard()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YykIdouAnsyuCreditCard()).henkousikibetukey, SortOrder.ASC));
        List<IT_YykIdouAnsyuCreditCard> copyList = new ArrayList<IT_YykIdouAnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_YykIdouAnsyuCreditCard(orders));
        return copyList;
    }

    public List<IT_YykIdouAnsyuCreditCard> OrderIT_YykIdouAnsyuCreditCardByPkDesc(List<IT_YykIdouAnsyuCreditCard> pEntity) {
        List<SortCondition<IT_YykIdouAnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YykIdouAnsyuCreditCard()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YykIdouAnsyuCreditCard()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YykIdouAnsyuCreditCard()).henkousikibetukey, SortOrder.DESC));
        List<IT_YykIdouAnsyuCreditCard> copyList = new ArrayList<IT_YykIdouAnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_YykIdouAnsyuCreditCard(orders));
        return copyList;
    }

}

