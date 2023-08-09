package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;
import yuyu.def.db.meta.QZT_TuutirirekiMeisaiFRn;
import yuyu.def.zdb.comparator.OrderZT_TuutirirekiMeisaiFRn;

public class SortZT_TuutirirekiMeisaiFRn {

    
    public List<ZT_TuutirirekiMeisaiFRn> OrderZT_TuutirirekiMeisaiFRnByPkAsc(List<ZT_TuutirirekiMeisaiFRn> pEntity) {
        List<SortCondition<ZT_TuutirirekiMeisaiFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFRn()).zrntuutirirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFRn()).zrntuutisakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFRn()).zrntuutisakuseino, SortOrder.ASC));
        List<ZT_TuutirirekiMeisaiFRn> copyList = new ArrayList<ZT_TuutirirekiMeisaiFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TuutirirekiMeisaiFRn(orders));
        return copyList;
    }

    
    public List<ZT_TuutirirekiMeisaiFRn> OrderZT_TuutirirekiMeisaiFRnByPkDesc(List<ZT_TuutirirekiMeisaiFRn> pEntity) {
        List<SortCondition<ZT_TuutirirekiMeisaiFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFRn()).zrntuutirirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFRn()).zrntuutisakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TuutirirekiMeisaiFRn()).zrntuutisakuseino, SortOrder.DESC));
        List<ZT_TuutirirekiMeisaiFRn> copyList = new ArrayList<ZT_TuutirirekiMeisaiFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TuutirirekiMeisaiFRn(orders));
        return copyList;
    }
}
