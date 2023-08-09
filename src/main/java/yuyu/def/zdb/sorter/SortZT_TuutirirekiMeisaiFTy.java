package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFTy;
import yuyu.def.zdb.comparator.OrderZT_TuutirirekiMeisaiFTy;

public class SortZT_TuutirirekiMeisaiFTy {

    
    public List<ZT_TuutirirekiMeisaiFTy> OrderZT_TuutirirekiMeisaiFTyByPkAsc(List<ZT_TuutirirekiMeisaiFTy> pEntity) {
        List<SortCondition<ZT_TuutirirekiMeisaiFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFTy()).ztytuutirirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFTy()).ztytuutisakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFTy()).ztytuutisakuseino, SortOrder.ASC));
        List<ZT_TuutirirekiMeisaiFTy> copyList = new ArrayList<ZT_TuutirirekiMeisaiFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TuutirirekiMeisaiFTy(orders));
        return copyList;
    }

    
    public List<ZT_TuutirirekiMeisaiFTy> OrderZT_TuutirirekiMeisaiFTyByPkDesc(List<ZT_TuutirirekiMeisaiFTy> pEntity) {
        List<SortCondition<ZT_TuutirirekiMeisaiFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFTy()).ztytuutirirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFTy()).ztytuutisakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFTy()).ztytuutisakuseino, SortOrder.DESC));
        List<ZT_TuutirirekiMeisaiFTy> copyList = new ArrayList<ZT_TuutirirekiMeisaiFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_TuutirirekiMeisaiFTy(orders));
        return copyList;
    }
}
