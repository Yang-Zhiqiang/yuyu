package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.meta.QIT_CreditCardInfo;
import yuyu.def.hozen.comparator.OrderIT_CreditCardInfo;

public class SortIT_CreditCardInfo {

    public List<IT_CreditCardInfo> OrderIT_CreditCardInfoByPkAsc(List<IT_CreditCardInfo> pEntity) {
        List<SortCondition<IT_CreditCardInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CreditCardInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_CreditCardInfo()).syono, SortOrder.ASC));
        List<IT_CreditCardInfo> copyList = new ArrayList<IT_CreditCardInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_CreditCardInfo(orders));
        return copyList;
    }

    public List<IT_CreditCardInfo> OrderIT_CreditCardInfoByPkDesc(List<IT_CreditCardInfo> pEntity) {
        List<SortCondition<IT_CreditCardInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_CreditCardInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_CreditCardInfo()).syono, SortOrder.DESC));
        List<IT_CreditCardInfo> copyList = new ArrayList<IT_CreditCardInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_CreditCardInfo(orders));
        return copyList;
    }
}
