package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_LincJyusinTr;
import yuyu.def.db.meta.QZT_LincJyusinTr;
import yuyu.def.zdb.comparator.OrderZT_LincJyusinTr;

public class SortZT_LincJyusinTr {

    
    public List<ZT_LincJyusinTr> OrderZT_LincJyusinTrByPkAsc(List<ZT_LincJyusinTr> pEntity) {
        List<SortCondition<ZT_LincJyusinTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_LincJyusinTr()).ztrsyoriymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_LincJyusinTr()).ztrrenno10, SortOrder.ASC));
        List<ZT_LincJyusinTr> copyList = new ArrayList<ZT_LincJyusinTr>(pEntity);
        Collections.sort(copyList, new OrderZT_LincJyusinTr(orders));
        return copyList;
    }

    
    public List<ZT_LincJyusinTr> OrderZT_LincJyusinTrByPkDesc(List<ZT_LincJyusinTr> pEntity) {
        List<SortCondition<ZT_LincJyusinTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_LincJyusinTr()).ztrsyoriymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_LincJyusinTr()).ztrrenno10, SortOrder.DESC));
        List<ZT_LincJyusinTr> copyList = new ArrayList<ZT_LincJyusinTr>(pEntity);
        Collections.sort(copyList, new OrderZT_LincJyusinTr(orders));
        return copyList;
    }
}
