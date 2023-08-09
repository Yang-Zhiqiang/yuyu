package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkIktHriRn;
import yuyu.def.db.meta.QZT_NkIktHriRn;
import yuyu.def.zdb.comparator.OrderZT_NkIktHriRn;

public class SortZT_NkIktHriRn {

    
    public List<ZT_NkIktHriRn> OrderZT_NkIktHriRnByPkAsc(List<ZT_NkIktHriRn> pEntity) {
        List<SortCondition<ZT_NkIktHriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkIktHriRn()).zrndatakanrino, SortOrder.ASC));
        List<ZT_NkIktHriRn> copyList = new ArrayList<ZT_NkIktHriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkIktHriRn(orders));
        return copyList;
    }

    
    public List<ZT_NkIktHriRn> OrderZT_NkIktHriRnByPkDesc(List<ZT_NkIktHriRn> pEntity) {
        List<SortCondition<ZT_NkIktHriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkIktHriRn()).zrndatakanrino, SortOrder.DESC));
        List<ZT_NkIktHriRn> copyList = new ArrayList<ZT_NkIktHriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkIktHriRn(orders));
        return copyList;
    }
}
