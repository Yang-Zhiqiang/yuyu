package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_BikinIdouMeisaiTy;
import yuyu.def.db.meta.QZT_BikinIdouMeisaiTy;
import yuyu.def.zdb.comparator.OrderZT_BikinIdouMeisaiTy;

public class SortZT_BikinIdouMeisaiTy {

    
    public List<ZT_BikinIdouMeisaiTy> OrderZT_BikinIdouMeisaiTyByPkAsc(List<ZT_BikinIdouMeisaiTy> pEntity) {
        List<SortCondition<ZT_BikinIdouMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinIdouMeisaiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_BikinIdouMeisaiTy> copyList = new ArrayList<ZT_BikinIdouMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinIdouMeisaiTy(orders));
        return copyList;
    }

    
    public List<ZT_BikinIdouMeisaiTy> OrderZT_BikinIdouMeisaiTyByPkDesc(List<ZT_BikinIdouMeisaiTy> pEntity) {
        List<SortCondition<ZT_BikinIdouMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinIdouMeisaiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_BikinIdouMeisaiTy> copyList = new ArrayList<ZT_BikinIdouMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinIdouMeisaiTy(orders));
        return copyList;
    }
}
