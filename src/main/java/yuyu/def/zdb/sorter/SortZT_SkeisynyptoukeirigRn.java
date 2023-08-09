package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkeisynyptoukeirigRn;
import yuyu.def.db.meta.QZT_SkeisynyptoukeirigRn;
import yuyu.def.zdb.comparator.OrderZT_SkeisynyptoukeirigRn;

public class SortZT_SkeisynyptoukeirigRn {

    
    public List<ZT_SkeisynyptoukeirigRn> OrderZT_SkeisynyptoukeirigRnByPkAsc(List<ZT_SkeisynyptoukeirigRn> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeirigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeirigRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_SkeisynyptoukeirigRn> copyList = new ArrayList<ZT_SkeisynyptoukeirigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeirigRn(orders));
        return copyList;
    }

    
    public List<ZT_SkeisynyptoukeirigRn> OrderZT_SkeisynyptoukeirigRnByPkDesc(List<ZT_SkeisynyptoukeirigRn> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeirigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeirigRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_SkeisynyptoukeirigRn> copyList = new ArrayList<ZT_SkeisynyptoukeirigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeirigRn(orders));
        return copyList;
    }
}
