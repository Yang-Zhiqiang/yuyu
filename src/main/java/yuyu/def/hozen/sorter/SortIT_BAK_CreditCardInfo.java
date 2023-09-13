package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_CreditCardInfo;
import yuyu.def.db.meta.QIT_BAK_CreditCardInfo;
import yuyu.def.hozen.comparator.OrderIT_BAK_CreditCardInfo;

public class SortIT_BAK_CreditCardInfo {

    public List<IT_BAK_CreditCardInfo> OrderIT_BAK_CreditCardInfoByPkAsc(List<IT_BAK_CreditCardInfo> pEntity) {
        List<SortCondition<IT_BAK_CreditCardInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_CreditCardInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCardInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCardInfo()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_CreditCardInfo> copyList = new ArrayList<IT_BAK_CreditCardInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_CreditCardInfo(orders));
        return copyList;
    }

    public List<IT_BAK_CreditCardInfo> OrderIT_BAK_CreditCardInfoByPkDesc(List<IT_BAK_CreditCardInfo> pEntity) {
        List<SortCondition<IT_BAK_CreditCardInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_CreditCardInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCardInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_CreditCardInfo()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_CreditCardInfo> copyList = new ArrayList<IT_BAK_CreditCardInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_CreditCardInfo(orders));
        return copyList;
    }
}
