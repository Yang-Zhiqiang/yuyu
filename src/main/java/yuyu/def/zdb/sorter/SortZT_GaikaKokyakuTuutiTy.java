package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_GaikaKokyakuTuutiTy;

public class SortZT_GaikaKokyakuTuutiTy {

    
    public List<ZT_GaikaKokyakuTuutiTy> OrderZT_GaikaKokyakuTuutiTyByPkAsc(List<ZT_GaikaKokyakuTuutiTy> pEntity) {
        List<SortCondition<ZT_GaikaKokyakuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiTy()).ztysyono, SortOrder.ASC));
        List<ZT_GaikaKokyakuTuutiTy> copyList = new ArrayList<ZT_GaikaKokyakuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GaikaKokyakuTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_GaikaKokyakuTuutiTy> OrderZT_GaikaKokyakuTuutiTyByPkDesc(List<ZT_GaikaKokyakuTuutiTy> pEntity) {
        List<SortCondition<ZT_GaikaKokyakuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiTy()).ztysyono, SortOrder.DESC));
        List<ZT_GaikaKokyakuTuutiTy> copyList = new ArrayList<ZT_GaikaKokyakuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GaikaKokyakuTuutiTy(orders));
        return copyList;
    }
}
