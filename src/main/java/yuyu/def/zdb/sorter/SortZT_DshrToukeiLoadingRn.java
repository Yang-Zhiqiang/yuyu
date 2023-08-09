package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingRn;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingRn;
import yuyu.def.zdb.comparator.OrderZT_DshrToukeiLoadingRn;

public class SortZT_DshrToukeiLoadingRn {

    
    public List<ZT_DshrToukeiLoadingRn> OrderZT_DshrToukeiLoadingRnByPkAsc(List<ZT_DshrToukeiLoadingRn> pEntity) {
        List<SortCondition<ZT_DshrToukeiLoadingRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiLoadingRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_DshrToukeiLoadingRn> copyList = new ArrayList<ZT_DshrToukeiLoadingRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiLoadingRn(orders));
        return copyList;
    }

    
    public List<ZT_DshrToukeiLoadingRn> OrderZT_DshrToukeiLoadingRnByPkDesc(List<ZT_DshrToukeiLoadingRn> pEntity) {
        List<SortCondition<ZT_DshrToukeiLoadingRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiLoadingRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_DshrToukeiLoadingRn> copyList = new ArrayList<ZT_DshrToukeiLoadingRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiLoadingRn(orders));
        return copyList;
    }
}
