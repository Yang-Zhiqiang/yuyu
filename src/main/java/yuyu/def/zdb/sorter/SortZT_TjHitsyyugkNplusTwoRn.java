package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjHitsyyugkNplusTwoRn;
import yuyu.def.db.meta.QZT_TjHitsyyugkNplusTwoRn;
import yuyu.def.zdb.comparator.OrderZT_TjHitsyyugkNplusTwoRn;

public class SortZT_TjHitsyyugkNplusTwoRn {

    
    public List<ZT_TjHitsyyugkNplusTwoRn> OrderZT_TjHitsyyugkNplusTwoRnByPkAsc(List<ZT_TjHitsyyugkNplusTwoRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusTwoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusTwoRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_TjHitsyyugkNplusTwoRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusTwoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusTwoRn(orders));
        return copyList;
    }

    
    public List<ZT_TjHitsyyugkNplusTwoRn> OrderZT_TjHitsyyugkNplusTwoRnByPkDesc(List<ZT_TjHitsyyugkNplusTwoRn> pEntity) {
        List<SortCondition<ZT_TjHitsyyugkNplusTwoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjHitsyyugkNplusTwoRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_TjHitsyyugkNplusTwoRn> copyList = new ArrayList<ZT_TjHitsyyugkNplusTwoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjHitsyyugkNplusTwoRn(orders));
        return copyList;
    }
}
