package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_EgsyokuinSysRendouRn;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouRn;
import yuyu.def.zdb.comparator.OrderZT_EgsyokuinSysRendouRn;

public class SortZT_EgsyokuinSysRendouRn {

    
    public List<ZT_EgsyokuinSysRendouRn> OrderZT_EgsyokuinSysRendouRnByPkAsc(List<ZT_EgsyokuinSysRendouRn> pEntity) {
        List<SortCondition<ZT_EgsyokuinSysRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_EgsyokuinSysRendouRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_EgsyokuinSysRendouRn> copyList = new ArrayList<ZT_EgsyokuinSysRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_EgsyokuinSysRendouRn(orders));
        return copyList;
    }

    
    public List<ZT_EgsyokuinSysRendouRn> OrderZT_EgsyokuinSysRendouRnByPkDesc(List<ZT_EgsyokuinSysRendouRn> pEntity) {
        List<SortCondition<ZT_EgsyokuinSysRendouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_EgsyokuinSysRendouRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_EgsyokuinSysRendouRn> copyList = new ArrayList<ZT_EgsyokuinSysRendouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_EgsyokuinSysRendouRn(orders));
        return copyList;
    }
}
