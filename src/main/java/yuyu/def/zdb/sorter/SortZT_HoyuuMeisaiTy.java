package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HoyuuMeisaiTy;
import yuyu.def.db.meta.QZT_HoyuuMeisaiTy;
import yuyu.def.zdb.comparator.OrderZT_HoyuuMeisaiTy;

public class SortZT_HoyuuMeisaiTy {

    
    public List<ZT_HoyuuMeisaiTy> OrderZT_HoyuuMeisaiTyByPkAsc(List<ZT_HoyuuMeisaiTy> pEntity) {
        List<SortCondition<ZT_HoyuuMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuMeisaiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_HoyuuMeisaiTy> copyList = new ArrayList<ZT_HoyuuMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuMeisaiTy(orders));
        return copyList;
    }

    
    public List<ZT_HoyuuMeisaiTy> OrderZT_HoyuuMeisaiTyByPkDesc(List<ZT_HoyuuMeisaiTy> pEntity) {
        List<SortCondition<ZT_HoyuuMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuMeisaiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_HoyuuMeisaiTy> copyList = new ArrayList<ZT_HoyuuMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuMeisaiTy(orders));
        return copyList;
    }
}
