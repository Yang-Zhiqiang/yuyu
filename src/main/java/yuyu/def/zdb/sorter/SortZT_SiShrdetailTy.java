package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SiShrdetailTy;
import yuyu.def.db.meta.QZT_SiShrdetailTy;
import yuyu.def.zdb.comparator.OrderZT_SiShrdetailTy;

public class SortZT_SiShrdetailTy {

    
    public List<ZT_SiShrdetailTy> OrderZT_SiShrdetailTyByPkAsc(List<ZT_SiShrdetailTy> pEntity) {
        List<SortCondition<ZT_SiShrdetailTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiShrdetailTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_SiShrdetailTy> copyList = new ArrayList<ZT_SiShrdetailTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SiShrdetailTy(orders));
        return copyList;
    }

    
    public List<ZT_SiShrdetailTy> OrderZT_SiShrdetailTyByPkDesc(List<ZT_SiShrdetailTy> pEntity) {
        List<SortCondition<ZT_SiShrdetailTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiShrdetailTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SiShrdetailTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_SiShrdetailTy> copyList = new ArrayList<ZT_SiShrdetailTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SiShrdetailTy(orders));
        return copyList;
    }
}
