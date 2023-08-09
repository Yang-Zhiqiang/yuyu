package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IdouMeisaiTy;
import yuyu.def.db.meta.QZT_IdouMeisaiTy;
import yuyu.def.zdb.comparator.OrderZT_IdouMeisaiTy;

public class SortZT_IdouMeisaiTy {

    
    public List<ZT_IdouMeisaiTy> OrderZT_IdouMeisaiTyByPkAsc(List<ZT_IdouMeisaiTy> pEntity) {
        List<SortCondition<ZT_IdouMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdouMeisaiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_IdouMeisaiTy> copyList = new ArrayList<ZT_IdouMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_IdouMeisaiTy(orders));
        return copyList;
    }

    
    public List<ZT_IdouMeisaiTy> OrderZT_IdouMeisaiTyByPkDesc(List<ZT_IdouMeisaiTy> pEntity) {
        List<SortCondition<ZT_IdouMeisaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdouMeisaiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_IdouMeisaiTy> copyList = new ArrayList<ZT_IdouMeisaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_IdouMeisaiTy(orders));
        return copyList;
    }
}
