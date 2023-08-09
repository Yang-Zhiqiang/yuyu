package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuTy;
import yuyu.def.zdb.comparator.OrderZT_JigyounndsikiTkHoyuuTy;

public class SortZT_JigyounndsikiTkHoyuuTy {

    
    public List<ZT_JigyounndsikiTkHoyuuTy> OrderZT_JigyounndsikiTkHoyuuTyByPkAsc(List<ZT_JigyounndsikiTkHoyuuTy> pEntity) {
        List<SortCondition<ZT_JigyounndsikiTkHoyuuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JigyounndsikiTkHoyuuTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_JigyounndsikiTkHoyuuTy> copyList = new ArrayList<ZT_JigyounndsikiTkHoyuuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_JigyounndsikiTkHoyuuTy(orders));
        return copyList;
    }

    
    public List<ZT_JigyounndsikiTkHoyuuTy> OrderZT_JigyounndsikiTkHoyuuTyByPkDesc(List<ZT_JigyounndsikiTkHoyuuTy> pEntity) {
        List<SortCondition<ZT_JigyounndsikiTkHoyuuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JigyounndsikiTkHoyuuTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_JigyounndsikiTkHoyuuTy> copyList = new ArrayList<ZT_JigyounndsikiTkHoyuuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_JigyounndsikiTkHoyuuTy(orders));
        return copyList;
    }
}
