package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SeirituInfoRn;
import yuyu.def.db.meta.QZT_SeirituInfoRn;
import yuyu.def.zdb.comparator.OrderZT_SeirituInfoRn;

public class SortZT_SeirituInfoRn {

    
    public List<ZT_SeirituInfoRn> OrderZT_SeirituInfoRnByPkAsc(List<ZT_SeirituInfoRn> pEntity) {
        List<SortCondition<ZT_SeirituInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeirituInfoRn()).zrnkijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeirituInfoRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SeirituInfoRn> copyList = new ArrayList<ZT_SeirituInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SeirituInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_SeirituInfoRn> OrderZT_SeirituInfoRnByPkDesc(List<ZT_SeirituInfoRn> pEntity) {
        List<SortCondition<ZT_SeirituInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeirituInfoRn()).zrnkijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeirituInfoRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SeirituInfoRn> copyList = new ArrayList<ZT_SeirituInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SeirituInfoRn(orders));
        return copyList;
    }
}
