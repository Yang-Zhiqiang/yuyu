package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouTy;
import yuyu.def.zdb.comparator.OrderZT_EgsyokuinSysRendouTy;

public class SortZT_EgsyokuinSysRendouTy {

    
    public List<ZT_EgsyokuinSysRendouTy> OrderZT_EgsyokuinSysRendouTyByPkAsc(List<ZT_EgsyokuinSysRendouTy> pEntity) {
        List<SortCondition<ZT_EgsyokuinSysRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_EgsyokuinSysRendouTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_EgsyokuinSysRendouTy> copyList = new ArrayList<ZT_EgsyokuinSysRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_EgsyokuinSysRendouTy(orders));
        return copyList;
    }

    
    public List<ZT_EgsyokuinSysRendouTy> OrderZT_EgsyokuinSysRendouTyByPkDesc(List<ZT_EgsyokuinSysRendouTy> pEntity) {
        List<SortCondition<ZT_EgsyokuinSysRendouTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_EgsyokuinSysRendouTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_EgsyokuinSysRendouTy> copyList = new ArrayList<ZT_EgsyokuinSysRendouTy>(pEntity);
        Collections.sort(copyList, new OrderZT_EgsyokuinSysRendouTy(orders));
        return copyList;
    }
}
