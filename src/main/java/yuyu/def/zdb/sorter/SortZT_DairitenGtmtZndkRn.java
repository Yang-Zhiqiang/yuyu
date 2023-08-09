package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DairitenGtmtZndkRn;
import yuyu.def.db.meta.QZT_DairitenGtmtZndkRn;
import yuyu.def.zdb.comparator.OrderZT_DairitenGtmtZndkRn;

public class SortZT_DairitenGtmtZndkRn {

    
    public List<ZT_DairitenGtmtZndkRn> OrderZT_DairitenGtmtZndkRnByPkAsc(List<ZT_DairitenGtmtZndkRn> pEntity) {
        List<SortCondition<ZT_DairitenGtmtZndkRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkRn()).zrndatakijyunymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkRn()).zrnsyono, SortOrder.ASC));
        List<ZT_DairitenGtmtZndkRn> copyList = new ArrayList<ZT_DairitenGtmtZndkRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenGtmtZndkRn(orders));
        return copyList;
    }

    
    public List<ZT_DairitenGtmtZndkRn> OrderZT_DairitenGtmtZndkRnByPkDesc(List<ZT_DairitenGtmtZndkRn> pEntity) {
        List<SortCondition<ZT_DairitenGtmtZndkRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkRn()).zrndatakijyunymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DairitenGtmtZndkRn()).zrnsyono, SortOrder.DESC));
        List<ZT_DairitenGtmtZndkRn> copyList = new ArrayList<ZT_DairitenGtmtZndkRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DairitenGtmtZndkRn(orders));
        return copyList;
    }
}