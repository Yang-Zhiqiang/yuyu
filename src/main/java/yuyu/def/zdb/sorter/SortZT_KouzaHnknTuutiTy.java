package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiTy;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_KouzaHnknTuutiTy;

public class SortZT_KouzaHnknTuutiTy {

    
    public List<ZT_KouzaHnknTuutiTy> OrderZT_KouzaHnknTuutiTyByPkAsc(List<ZT_KouzaHnknTuutiTy> pEntity) {
        List<SortCondition<ZT_KouzaHnknTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_KouzaHnknTuutiTy> copyList = new ArrayList<ZT_KouzaHnknTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHnknTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_KouzaHnknTuutiTy> OrderZT_KouzaHnknTuutiTyByPkDesc(List<ZT_KouzaHnknTuutiTy> pEntity) {
        List<SortCondition<ZT_KouzaHnknTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzaHnknTuutiTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_KouzaHnknTuutiTy> copyList = new ArrayList<ZT_KouzaHnknTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzaHnknTuutiTy(orders));
        return copyList;
    }
}
