package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_GinkouMdhnFollowCall;
import yuyu.def.db.meta.QIT_GinkouMdhnFollowCall;
import yuyu.def.hozen.comparator.OrderIT_GinkouMdhnFollowCall;

public class SortIT_GinkouMdhnFollowCall {

    public List<IT_GinkouMdhnFollowCall> OrderIT_GinkouMdhnFollowCallByPkAsc(List<IT_GinkouMdhnFollowCall> pEntity) {
        List<SortCondition<IT_GinkouMdhnFollowCall>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_GinkouMdhnFollowCall()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_GinkouMdhnFollowCall()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_GinkouMdhnFollowCall()).syono, SortOrder.ASC));
        List<IT_GinkouMdhnFollowCall> copyList = new ArrayList<IT_GinkouMdhnFollowCall>(pEntity);
        Collections.sort(copyList, new OrderIT_GinkouMdhnFollowCall(orders));
        return copyList;
    }

    public List<IT_GinkouMdhnFollowCall> OrderIT_GinkouMdhnFollowCallByPkDesc(List<IT_GinkouMdhnFollowCall> pEntity) {
        List<SortCondition<IT_GinkouMdhnFollowCall>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_GinkouMdhnFollowCall()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_GinkouMdhnFollowCall()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_GinkouMdhnFollowCall()).syono, SortOrder.DESC));
        List<IT_GinkouMdhnFollowCall> copyList = new ArrayList<IT_GinkouMdhnFollowCall>(pEntity);
        Collections.sort(copyList, new OrderIT_GinkouMdhnFollowCall(orders));
        return copyList;
    }
}
