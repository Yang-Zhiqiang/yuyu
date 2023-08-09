package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IsaToukeiDataRn;
import yuyu.def.db.meta.QZT_IsaToukeiDataRn;
import yuyu.def.zdb.comparator.OrderZT_IsaToukeiDataRn;

public class SortZT_IsaToukeiDataRn {

    
    public List<ZT_IsaToukeiDataRn> OrderZT_IsaToukeiDataRnByPkAsc(List<ZT_IsaToukeiDataRn> pEntity) {
        List<SortCondition<ZT_IsaToukeiDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IsaToukeiDataRn()).zrnmosno, SortOrder.ASC));
        List<ZT_IsaToukeiDataRn> copyList = new ArrayList<ZT_IsaToukeiDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IsaToukeiDataRn(orders));
        return copyList;
    }

    
    public List<ZT_IsaToukeiDataRn> OrderZT_IsaToukeiDataRnByPkDesc(List<ZT_IsaToukeiDataRn> pEntity) {
        List<SortCondition<ZT_IsaToukeiDataRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IsaToukeiDataRn()).zrnmosno, SortOrder.DESC));
        List<ZT_IsaToukeiDataRn> copyList = new ArrayList<ZT_IsaToukeiDataRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IsaToukeiDataRn(orders));
        return copyList;
    }
}
