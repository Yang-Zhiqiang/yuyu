package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyoumetuTuutiTy;
import yuyu.def.db.meta.QZT_SyoumetuTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_SyoumetuTuutiTy;

public class SortZT_SyoumetuTuutiTy {

    
    public List<ZT_SyoumetuTuutiTy> OrderZT_SyoumetuTuutiTyByPkAsc(List<ZT_SyoumetuTuutiTy> pEntity) {
        List<SortCondition<ZT_SyoumetuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiTy()).ztysikibetuno, SortOrder.ASC));
        List<ZT_SyoumetuTuutiTy> copyList = new ArrayList<ZT_SyoumetuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoumetuTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_SyoumetuTuutiTy> OrderZT_SyoumetuTuutiTyByPkDesc(List<ZT_SyoumetuTuutiTy> pEntity) {
        List<SortCondition<ZT_SyoumetuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoumetuTuutiTy()).ztysikibetuno, SortOrder.DESC));
        List<ZT_SyoumetuTuutiTy> copyList = new ArrayList<ZT_SyoumetuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoumetuTuutiTy(orders));
        return copyList;
    }
}
