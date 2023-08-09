package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.zdb.comparator.OrderZT_KbkSsuRnduHknIdouVTy;

public class SortZT_KbkSsuRnduHknIdouVTy {

    
    public List<ZT_KbkSsuRnduHknIdouVTy> OrderZT_KbkSsuRnduHknIdouVTyByPkAsc(List<ZT_KbkSsuRnduHknIdouVTy> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknIdouVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknIdouVTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KbkSsuRnduHknIdouVTy> copyList = new ArrayList<ZT_KbkSsuRnduHknIdouVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknIdouVTy(orders));
        return copyList;
    }

    
    public List<ZT_KbkSsuRnduHknIdouVTy> OrderZT_KbkSsuRnduHknIdouVTyByPkDesc(List<ZT_KbkSsuRnduHknIdouVTy> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknIdouVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknIdouVTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KbkSsuRnduHknIdouVTy> copyList = new ArrayList<ZT_KbkSsuRnduHknIdouVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknIdouVTy(orders));
        return copyList;
    }
}
