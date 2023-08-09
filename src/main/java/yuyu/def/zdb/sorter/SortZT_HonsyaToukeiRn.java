package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HonsyaToukeiRn;
import yuyu.def.db.meta.QZT_HonsyaToukeiRn;
import yuyu.def.zdb.comparator.OrderZT_HonsyaToukeiRn;

public class SortZT_HonsyaToukeiRn {

    
    public List<ZT_HonsyaToukeiRn> OrderZT_HonsyaToukeiRnByPkAsc(List<ZT_HonsyaToukeiRn> pEntity) {
        List<SortCondition<ZT_HonsyaToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiRn()).zrnkijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiRn()).zrnmosno, SortOrder.ASC));
        List<ZT_HonsyaToukeiRn> copyList = new ArrayList<ZT_HonsyaToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HonsyaToukeiRn(orders));
        return copyList;
    }

    
    public List<ZT_HonsyaToukeiRn> OrderZT_HonsyaToukeiRnByPkDesc(List<ZT_HonsyaToukeiRn> pEntity) {
        List<SortCondition<ZT_HonsyaToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiRn()).zrnkijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HonsyaToukeiRn()).zrnmosno, SortOrder.DESC));
        List<ZT_HonsyaToukeiRn> copyList = new ArrayList<ZT_HonsyaToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HonsyaToukeiRn(orders));
        return copyList;
    }
}
