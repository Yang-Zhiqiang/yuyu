package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzaHrkmTuutiTy;
import yuyu.def.db.meta.QZT_KouzaHrkmTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_KouzaHrkmTuutiTy;

public class SortZT_KouzaHrkmTuutiTy {

    
    public List<ZT_KouzaHrkmTuutiTy> OrderZT_KouzaHrkmTuutiTyByPkAsc(List<ZT_KouzaHrkmTuutiTy> pEntity) {
        List<SortCondition<ZT_KouzaHrkmTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_KouzaHrkmTuutiTy> copyList = new ArrayList<ZT_KouzaHrkmTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHrkmTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_KouzaHrkmTuutiTy> OrderZT_KouzaHrkmTuutiTyByPkDesc(List<ZT_KouzaHrkmTuutiTy> pEntity) {
        List<SortCondition<ZT_KouzaHrkmTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHrkmTuutiTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_KouzaHrkmTuutiTy> copyList = new ArrayList<ZT_KouzaHrkmTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHrkmTuutiTy(orders));
        return copyList;
    }
}
