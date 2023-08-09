package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DshrToukeiTy;
import yuyu.def.db.meta.QZT_DshrToukeiTy;
import yuyu.def.zdb.comparator.OrderZT_DshrToukeiTy;

public class SortZT_DshrToukeiTy {

    
    public List<ZT_DshrToukeiTy> OrderZT_DshrToukeiTyByPkAsc(List<ZT_DshrToukeiTy> pEntity) {
        List<SortCondition<ZT_DshrToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_DshrToukeiTy> copyList = new ArrayList<ZT_DshrToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiTy(orders));
        return copyList;
    }

    
    public List<ZT_DshrToukeiTy> OrderZT_DshrToukeiTyByPkDesc(List<ZT_DshrToukeiTy> pEntity) {
        List<SortCondition<ZT_DshrToukeiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DshrToukeiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_DshrToukeiTy> copyList = new ArrayList<ZT_DshrToukeiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DshrToukeiTy(orders));
        return copyList;
    }
}
