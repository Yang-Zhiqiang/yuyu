package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DairitenSyougouRn;
import yuyu.def.db.meta.QZT_DairitenSyougouRn;
import yuyu.def.zdb.comparator.OrderZT_DairitenSyougouRn;

public class SortZT_DairitenSyougouRn {

    
    public List<ZT_DairitenSyougouRn> OrderZT_DairitenSyougouRnByPkAsc(List<ZT_DairitenSyougouRn> pEntity) {
        List<SortCondition<ZT_DairitenSyougouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenSyougouRn()).zrndairitencd, SortOrder.ASC));
        List<ZT_DairitenSyougouRn> copyList = new ArrayList<ZT_DairitenSyougouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenSyougouRn(orders));
        return copyList;
    }

    
    public List<ZT_DairitenSyougouRn> OrderZT_DairitenSyougouRnByPkDesc(List<ZT_DairitenSyougouRn> pEntity) {
        List<SortCondition<ZT_DairitenSyougouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenSyougouRn()).zrndairitencd, SortOrder.DESC));
        List<ZT_DairitenSyougouRn> copyList = new ArrayList<ZT_DairitenSyougouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenSyougouRn(orders));
        return copyList;
    }
}
