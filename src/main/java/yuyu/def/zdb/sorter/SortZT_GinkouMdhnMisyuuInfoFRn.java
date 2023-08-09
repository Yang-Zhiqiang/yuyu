package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.zdb.comparator.OrderZT_GinkouMdhnMisyuuInfoFRn;

public class SortZT_GinkouMdhnMisyuuInfoFRn {

    
    public List<ZT_GinkouMdhnMisyuuInfoFRn> OrderZT_GinkouMdhnMisyuuInfoFRnByPkAsc(List<ZT_GinkouMdhnMisyuuInfoFRn> pEntity) {
        List<SortCondition<ZT_GinkouMdhnMisyuuInfoFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFRn()).zrndatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFRn()).zrnsyonosyuban, SortOrder.ASC));
        List<ZT_GinkouMdhnMisyuuInfoFRn> copyList = new ArrayList<ZT_GinkouMdhnMisyuuInfoFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GinkouMdhnMisyuuInfoFRn(orders));
        return copyList;
    }

    
    public List<ZT_GinkouMdhnMisyuuInfoFRn> OrderZT_GinkouMdhnMisyuuInfoFRnByPkDesc(List<ZT_GinkouMdhnMisyuuInfoFRn> pEntity) {
        List<SortCondition<ZT_GinkouMdhnMisyuuInfoFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFRn()).zrndatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GinkouMdhnMisyuuInfoFRn()).zrnsyonosyuban, SortOrder.DESC));
        List<ZT_GinkouMdhnMisyuuInfoFRn> copyList = new ArrayList<ZT_GinkouMdhnMisyuuInfoFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GinkouMdhnMisyuuInfoFRn(orders));
        return copyList;
    }
}
