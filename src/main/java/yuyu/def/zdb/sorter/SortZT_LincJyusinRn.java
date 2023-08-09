package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_LincJyusinRn;
import yuyu.def.db.meta.QZT_LincJyusinRn;
import yuyu.def.zdb.comparator.OrderZT_LincJyusinRn;

public class SortZT_LincJyusinRn {

    
    public List<ZT_LincJyusinRn> OrderZT_LincJyusinRnByPkAsc(List<ZT_LincJyusinRn> pEntity) {
        List<SortCondition<ZT_LincJyusinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_LincJyusinRn()).zrnsyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_LincJyusinRn()).zrnrenno10, SortOrder.ASC));
        List<ZT_LincJyusinRn> copyList = new ArrayList<ZT_LincJyusinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_LincJyusinRn(orders));
        return copyList;
    }

    
    public List<ZT_LincJyusinRn> OrderZT_LincJyusinRnByPkDesc(List<ZT_LincJyusinRn> pEntity) {
        List<SortCondition<ZT_LincJyusinRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_LincJyusinRn()).zrnsyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_LincJyusinRn()).zrnrenno10, SortOrder.DESC));
        List<ZT_LincJyusinRn> copyList = new ArrayList<ZT_LincJyusinRn>(pEntity);
        Collections.sort(copyList, new OrderZT_LincJyusinRn(orders));
        return copyList;
    }
}
