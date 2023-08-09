package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DshrToukeiRn;
import yuyu.def.db.meta.QZT_DshrToukeiRn;
import yuyu.def.zdb.comparator.OrderZT_DshrToukeiRn;

public class SortZT_DshrToukeiRn {

    
    public List<ZT_DshrToukeiRn> OrderZT_DshrToukeiRnByPkAsc(List<ZT_DshrToukeiRn> pEntity) {
        List<SortCondition<ZT_DshrToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_DshrToukeiRn> copyList = new ArrayList<ZT_DshrToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiRn(orders));
        return copyList;
    }

    
    public List<ZT_DshrToukeiRn> OrderZT_DshrToukeiRnByPkDesc(List<ZT_DshrToukeiRn> pEntity) {
        List<SortCondition<ZT_DshrToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_DshrToukeiRn> copyList = new ArrayList<ZT_DshrToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiRn(orders));
        return copyList;
    }
}
