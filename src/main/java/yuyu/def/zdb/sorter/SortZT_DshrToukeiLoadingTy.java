package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingTy;
import yuyu.def.db.meta.QZT_DshrToukeiLoadingTy;
import yuyu.def.zdb.comparator.OrderZT_DshrToukeiLoadingTy;

public class SortZT_DshrToukeiLoadingTy {

    
    public List<ZT_DshrToukeiLoadingTy> OrderZT_DshrToukeiLoadingTyByPkAsc(List<ZT_DshrToukeiLoadingTy> pEntity) {
        List<SortCondition<ZT_DshrToukeiLoadingTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiLoadingTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_DshrToukeiLoadingTy> copyList = new ArrayList<ZT_DshrToukeiLoadingTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiLoadingTy(orders));
        return copyList;
    }

    
    public List<ZT_DshrToukeiLoadingTy> OrderZT_DshrToukeiLoadingTyByPkDesc(List<ZT_DshrToukeiLoadingTy> pEntity) {
        List<SortCondition<ZT_DshrToukeiLoadingTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiLoadingTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_DshrToukeiLoadingTy> copyList = new ArrayList<ZT_DshrToukeiLoadingTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiLoadingTy(orders));
        return copyList;
    }
}
