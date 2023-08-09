package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknKimatuVTy;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknKimatuVTy;
import yuyu.def.zdb.comparator.OrderZT_KbkSsuRnduHknKimatuVTy;

public class SortZT_KbkSsuRnduHknKimatuVTy {

    
    public List<ZT_KbkSsuRnduHknKimatuVTy> OrderZT_KbkSsuRnduHknKimatuVTyByPkAsc(List<ZT_KbkSsuRnduHknKimatuVTy> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknKimatuVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknKimatuVTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KbkSsuRnduHknKimatuVTy> copyList = new ArrayList<ZT_KbkSsuRnduHknKimatuVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknKimatuVTy(orders));
        return copyList;
    }

    
    public List<ZT_KbkSsuRnduHknKimatuVTy> OrderZT_KbkSsuRnduHknKimatuVTyByPkDesc(List<ZT_KbkSsuRnduHknKimatuVTy> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknKimatuVTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknKimatuVTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KbkSsuRnduHknKimatuVTy> copyList = new ArrayList<ZT_KbkSsuRnduHknKimatuVTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknKimatuVTy(orders));
        return copyList;
    }
}
