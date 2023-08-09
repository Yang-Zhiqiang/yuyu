package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.zdb.comparator.OrderZT_KokyakuYuyuKykmeisaiFTy;

public class SortZT_KokyakuYuyuKykmeisaiFTy {

    
    public List<ZT_KokyakuYuyuKykmeisaiFTy> OrderZT_KokyakuYuyuKykmeisaiFTyByPkAsc(List<ZT_KokyakuYuyuKykmeisaiFTy> pEntity) {
        List<SortCondition<ZT_KokyakuYuyuKykmeisaiFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KokyakuYuyuKykmeisaiFTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KokyakuYuyuKykmeisaiFTy> copyList = new ArrayList<ZT_KokyakuYuyuKykmeisaiFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KokyakuYuyuKykmeisaiFTy(orders));
        return copyList;
    }

    
    public List<ZT_KokyakuYuyuKykmeisaiFTy> OrderZT_KokyakuYuyuKykmeisaiFTyByPkDesc(List<ZT_KokyakuYuyuKykmeisaiFTy> pEntity) {
        List<SortCondition<ZT_KokyakuYuyuKykmeisaiFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KokyakuYuyuKykmeisaiFTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KokyakuYuyuKykmeisaiFTy> copyList = new ArrayList<ZT_KokyakuYuyuKykmeisaiFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KokyakuYuyuKykmeisaiFTy(orders));
        return copyList;
    }
}
