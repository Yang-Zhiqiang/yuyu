package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;
import yuyu.def.db.meta.QJT_AksrendouzumiSkKykInfo;
import yuyu.def.siharai.comparator.OrderJT_AksrendouzumiSkKykInfo;

public class SortJT_AksrendouzumiSkKykInfo {

    
    public List<JT_AksrendouzumiSkKykInfo> OrderJT_AksrendouzumiSkKykInfoByPkAsc(List<JT_AksrendouzumiSkKykInfo> pEntity) {
        List<SortCondition<JT_AksrendouzumiSkKykInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSkKykInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSkKykInfo()).syono, SortOrder.ASC));
        List<JT_AksrendouzumiSkKykInfo> copyList = new ArrayList<JT_AksrendouzumiSkKykInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_AksrendouzumiSkKykInfo(orders));
        return copyList;
    }

    
    public List<JT_AksrendouzumiSkKykInfo> OrderJT_AksrendouzumiSkKykInfoByPkDesc(List<JT_AksrendouzumiSkKykInfo> pEntity) {
        List<SortCondition<JT_AksrendouzumiSkKykInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSkKykInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_AksrendouzumiSkKykInfo()).syono, SortOrder.DESC));
        List<JT_AksrendouzumiSkKykInfo> copyList = new ArrayList<JT_AksrendouzumiSkKykInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_AksrendouzumiSkKykInfo(orders));
        return copyList;
    }
}
