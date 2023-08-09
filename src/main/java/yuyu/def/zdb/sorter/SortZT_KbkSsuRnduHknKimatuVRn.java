package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknKimatuVRn;
import yuyu.def.db.meta.QZT_KbkSsuRnduHknKimatuVRn;
import yuyu.def.zdb.comparator.OrderZT_KbkSsuRnduHknKimatuVRn;

public class SortZT_KbkSsuRnduHknKimatuVRn {

    
    public List<ZT_KbkSsuRnduHknKimatuVRn> OrderZT_KbkSsuRnduHknKimatuVRnByPkAsc(List<ZT_KbkSsuRnduHknKimatuVRn> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknKimatuVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknKimatuVRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KbkSsuRnduHknKimatuVRn> copyList = new ArrayList<ZT_KbkSsuRnduHknKimatuVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknKimatuVRn(orders));
        return copyList;
    }

    
    public List<ZT_KbkSsuRnduHknKimatuVRn> OrderZT_KbkSsuRnduHknKimatuVRnByPkDesc(List<ZT_KbkSsuRnduHknKimatuVRn> pEntity) {
        List<SortCondition<ZT_KbkSsuRnduHknKimatuVRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KbkSsuRnduHknKimatuVRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KbkSsuRnduHknKimatuVRn> copyList = new ArrayList<ZT_KbkSsuRnduHknKimatuVRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KbkSsuRnduHknKimatuVRn(orders));
        return copyList;
    }
}
