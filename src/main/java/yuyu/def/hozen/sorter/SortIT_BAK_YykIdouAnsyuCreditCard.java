package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_YykIdouAnsyuCreditCard;
import yuyu.def.db.meta.QIT_BAK_YykIdouAnsyuCreditCard;
import yuyu.def.hozen.comparator.OrderIT_BAK_YykIdouAnsyuCreditCard;

public class SortIT_BAK_YykIdouAnsyuCreditCard {

    public List<IT_BAK_YykIdouAnsyuCreditCard> OrderIT_BAK_YykIdouAnsyuCreditCardByPkAsc(List<IT_BAK_YykIdouAnsyuCreditCard> pEntity) {
        List<SortCondition<IT_BAK_YykIdouAnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_YykIdouAnsyuCreditCard> copyList = new ArrayList<IT_BAK_YykIdouAnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_YykIdouAnsyuCreditCard(orders));
        return copyList;
    }

    public List<IT_BAK_YykIdouAnsyuCreditCard> OrderIT_BAK_YykIdouAnsyuCreditCardByPkDesc(List<IT_BAK_YykIdouAnsyuCreditCard> pEntity) {
        List<SortCondition<IT_BAK_YykIdouAnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_YykIdouAnsyuCreditCard()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_YykIdouAnsyuCreditCard> copyList = new ArrayList<IT_BAK_YykIdouAnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_YykIdouAnsyuCreditCard(orders));
        return copyList;
    }

}

