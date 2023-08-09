package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandRn;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandRn;
import yuyu.def.zdb.comparator.OrderZT_BikinKeiyakuSeisandRn;

public class SortZT_BikinKeiyakuSeisandRn {

    
    public List<ZT_BikinKeiyakuSeisandRn> OrderZT_BikinKeiyakuSeisandRnByPkAsc(List<ZT_BikinKeiyakuSeisandRn> pEntity) {
        List<SortCondition<ZT_BikinKeiyakuSeisandRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinKeiyakuSeisandRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_BikinKeiyakuSeisandRn> copyList = new ArrayList<ZT_BikinKeiyakuSeisandRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinKeiyakuSeisandRn(orders));
        return copyList;
    }

    
    public List<ZT_BikinKeiyakuSeisandRn> OrderZT_BikinKeiyakuSeisandRnByPkDesc(List<ZT_BikinKeiyakuSeisandRn> pEntity) {
        List<SortCondition<ZT_BikinKeiyakuSeisandRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinKeiyakuSeisandRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_BikinKeiyakuSeisandRn> copyList = new ArrayList<ZT_BikinKeiyakuSeisandRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinKeiyakuSeisandRn(orders));
        return copyList;
    }
}
