package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SiShrdetailRn;
import yuyu.def.db.meta.QZT_SiShrdetailRn;
import yuyu.def.zdb.comparator.OrderZT_SiShrdetailRn;

public class SortZT_SiShrdetailRn {

    
    public List<ZT_SiShrdetailRn> OrderZT_SiShrdetailRnByPkAsc(List<ZT_SiShrdetailRn> pEntity) {
        List<SortCondition<ZT_SiShrdetailRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiShrdetailRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_SiShrdetailRn> copyList = new ArrayList<ZT_SiShrdetailRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SiShrdetailRn(orders));
        return copyList;
    }

    
    public List<ZT_SiShrdetailRn> OrderZT_SiShrdetailRnByPkDesc(List<ZT_SiShrdetailRn> pEntity) {
        List<SortCondition<ZT_SiShrdetailRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiShrdetailRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_SiShrdetailRn> copyList = new ArrayList<ZT_SiShrdetailRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SiShrdetailRn(orders));
        return copyList;
    }
}
