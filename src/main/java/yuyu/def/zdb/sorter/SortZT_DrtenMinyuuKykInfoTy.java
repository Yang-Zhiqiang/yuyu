package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoTy;
import yuyu.def.zdb.comparator.OrderZT_DrtenMinyuuKykInfoTy;

public class SortZT_DrtenMinyuuKykInfoTy {

    
    public List<ZT_DrtenMinyuuKykInfoTy> OrderZT_DrtenMinyuuKykInfoTyByPkAsc(List<ZT_DrtenMinyuuKykInfoTy> pEntity) {
        List<SortCondition<ZT_DrtenMinyuuKykInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuuKykInfoTy()).ztysyono, SortOrder.ASC));
        List<ZT_DrtenMinyuuKykInfoTy> copyList = new ArrayList<ZT_DrtenMinyuuKykInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuuKykInfoTy(orders));
        return copyList;
    }

    
    public List<ZT_DrtenMinyuuKykInfoTy> OrderZT_DrtenMinyuuKykInfoTyByPkDesc(List<ZT_DrtenMinyuuKykInfoTy> pEntity) {
        List<SortCondition<ZT_DrtenMinyuuKykInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuuKykInfoTy()).ztysyono, SortOrder.DESC));
        List<ZT_DrtenMinyuuKykInfoTy> copyList = new ArrayList<ZT_DrtenMinyuuKykInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuuKykInfoTy(orders));
        return copyList;
    }
}
