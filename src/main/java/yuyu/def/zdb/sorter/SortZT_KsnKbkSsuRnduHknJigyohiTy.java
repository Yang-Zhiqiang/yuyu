package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.QZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.def.zdb.comparator.OrderZT_KsnKbkSsuRnduHknJigyohiTy;

public class SortZT_KsnKbkSsuRnduHknJigyohiTy {

    
    public List<ZT_KsnKbkSsuRnduHknJigyohiTy> OrderZT_KsnKbkSsuRnduHknJigyohiTyByPkAsc(List<ZT_KsnKbkSsuRnduHknJigyohiTy> pEntity) {
        List<SortCondition<ZT_KsnKbkSsuRnduHknJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnKbkSsuRnduHknJigyohiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KsnKbkSsuRnduHknJigyohiTy> copyList = new ArrayList<ZT_KsnKbkSsuRnduHknJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnKbkSsuRnduHknJigyohiTy(orders));
        return copyList;
    }

    
    public List<ZT_KsnKbkSsuRnduHknJigyohiTy> OrderZT_KsnKbkSsuRnduHknJigyohiTyByPkDesc(List<ZT_KsnKbkSsuRnduHknJigyohiTy> pEntity) {
        List<SortCondition<ZT_KsnKbkSsuRnduHknJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KsnKbkSsuRnduHknJigyohiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KsnKbkSsuRnduHknJigyohiTy> copyList = new ArrayList<ZT_KsnKbkSsuRnduHknJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KsnKbkSsuRnduHknJigyohiTy(orders));
        return copyList;
    }
}
