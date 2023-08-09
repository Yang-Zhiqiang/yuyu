package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.zdb.comparator.OrderZT_KbkSsuRnduHknJigyohiTy;

public class SortZT_KbkSsuRnduHknJigyohiTy {

    
    public List<ZT_KbkSsuRnduHknJigyohiTy> OrderZT_KbkSsuRnduHknJigyohiTyByPkAsc(List<ZT_KbkSsuRnduHknJigyohiTy> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknJigyohiTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KbkSsuRnduHknJigyohiTy> copyList = new ArrayList<ZT_KbkSsuRnduHknJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknJigyohiTy(orders));
        return copyList;
    }

    
    public List<ZT_KbkSsuRnduHknJigyohiTy> OrderZT_KbkSsuRnduHknJigyohiTyByPkDesc(List<ZT_KbkSsuRnduHknJigyohiTy> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknJigyohiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknJigyohiTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KbkSsuRnduHknJigyohiTy> copyList = new ArrayList<ZT_KbkSsuRnduHknJigyohiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknJigyohiTy(orders));
        return copyList;
    }
}
