package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.meta.QJT_SiDshrTuki;
import yuyu.def.siharai.comparator.OrderJT_SiDshrTuki;

public class SortJT_SiDshrTuki {

    
    public List<JT_SiDshrTuki> OrderJT_SiDshrTukiByPkAsc(List<JT_SiDshrTuki> pEntity) {
        List<SortCondition<JT_SiDshrTuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDshrTuki()).dshrtoukeisikibetukey, SortOrder.ASC));
        List<JT_SiDshrTuki> copyList = new ArrayList<JT_SiDshrTuki>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDshrTuki(orders));
        return copyList;
    }

    
    public List<JT_SiDshrTuki> OrderJT_SiDshrTukiByPkDesc(List<JT_SiDshrTuki> pEntity) {
        List<SortCondition<JT_SiDshrTuki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDshrTuki()).dshrtoukeisikibetukey, SortOrder.DESC));
        List<JT_SiDshrTuki> copyList = new ArrayList<JT_SiDshrTuki>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDshrTuki(orders));
        return copyList;
    }
}
