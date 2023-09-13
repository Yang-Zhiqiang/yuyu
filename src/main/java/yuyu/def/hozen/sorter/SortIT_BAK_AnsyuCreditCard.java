package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_AnsyuCreditCard;
import yuyu.def.db.meta.QIT_BAK_AnsyuCreditCard;
import yuyu.def.hozen.comparator.OrderIT_BAK_AnsyuCreditCard;

public class SortIT_BAK_AnsyuCreditCard {

    public List<IT_BAK_AnsyuCreditCard> OrderIT_BAK_AnsyuCreditCardByPkAsc(List<IT_BAK_AnsyuCreditCard> pEntity) {
        List<SortCondition<IT_BAK_AnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuCreditCard()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuCreditCard()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuCreditCard()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_AnsyuCreditCard> copyList = new ArrayList<IT_BAK_AnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AnsyuCreditCard(orders));
        return copyList;
    }

    public List<IT_BAK_AnsyuCreditCard> OrderIT_BAK_AnsyuCreditCardByPkDesc(List<IT_BAK_AnsyuCreditCard> pEntity) {
        List<SortCondition<IT_BAK_AnsyuCreditCard>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuCreditCard()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuCreditCard()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuCreditCard()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_AnsyuCreditCard> copyList = new ArrayList<IT_BAK_AnsyuCreditCard>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AnsyuCreditCard(orders));
        return copyList;
    }

}

