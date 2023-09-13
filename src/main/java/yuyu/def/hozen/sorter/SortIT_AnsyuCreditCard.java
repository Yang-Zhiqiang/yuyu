package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AnsyuCreditCard;
import yuyu.def.db.meta.QIT_AnsyuCreditCard;
import yuyu.def.hozen.comparator.OrderIT_AnsyuCreditCard;

public class SortIT_AnsyuCreditCard {

    public List<IT_AnsyuCreditCard> OrderIT_AnsyuCreditCardByPkAsc(List<IT_AnsyuCreditCard> pEntity) {
        List<SortCondition<IT_AnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuCreditCard()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuCreditCard()).syono, SortOrder.ASC));
        List<IT_AnsyuCreditCard> copyList = new ArrayList<IT_AnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuCreditCard(orders));
        return copyList;
    }

    public List<IT_AnsyuCreditCard> OrderIT_AnsyuCreditCardByPkDesc(List<IT_AnsyuCreditCard> pEntity) {
        List<SortCondition<IT_AnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuCreditCard()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuCreditCard()).syono, SortOrder.DESC));
        List<IT_AnsyuCreditCard> copyList = new ArrayList<IT_AnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuCreditCard(orders));
        return copyList;
    }

}

