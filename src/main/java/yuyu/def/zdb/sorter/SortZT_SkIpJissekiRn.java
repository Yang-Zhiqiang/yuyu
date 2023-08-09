package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkIpJissekiRn;
import yuyu.def.db.meta.QZT_SkIpJissekiRn;
import yuyu.def.zdb.comparator.OrderZT_SkIpJissekiRn;

public class SortZT_SkIpJissekiRn {

    
    public List<ZT_SkIpJissekiRn> OrderZT_SkIpJissekiRnByPkAsc(List<ZT_SkIpJissekiRn> pEntity) {
        List<SortCondition<ZT_SkIpJissekiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkIpJissekiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_SkIpJissekiRn> copyList = new ArrayList<ZT_SkIpJissekiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkIpJissekiRn(orders));
        return copyList;
    }

    
    public List<ZT_SkIpJissekiRn> OrderZT_SkIpJissekiRnByPkDesc(List<ZT_SkIpJissekiRn> pEntity) {
        List<SortCondition<ZT_SkIpJissekiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkIpJissekiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_SkIpJissekiRn> copyList = new ArrayList<ZT_SkIpJissekiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkIpJissekiRn(orders));
        return copyList;
    }
}
