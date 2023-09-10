package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.meta.QJT_SateiKokuhanInfo;
import yuyu.def.siharai.comparator.OrderJT_SateiKokuhanInfo;

public class SortJT_SateiKokuhanInfo {

    
    public List<JT_SateiKokuhanInfo> OrderJT_SateiKokuhanInfoByPkAsc(List<JT_SateiKokuhanInfo> pEntity) {
        List<SortCondition<JT_SateiKokuhanInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiKokuhanInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiKokuhanInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiKokuhanInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_SateiKokuhanInfo> copyList = new ArrayList<JT_SateiKokuhanInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiKokuhanInfo(orders));
        return copyList;
    }

    
    public List<JT_SateiKokuhanInfo> OrderJT_SateiKokuhanInfoByPkDesc(List<JT_SateiKokuhanInfo> pEntity) {
        List<SortCondition<JT_SateiKokuhanInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiKokuhanInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiKokuhanInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiKokuhanInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_SateiKokuhanInfo> copyList = new ArrayList<JT_SateiKokuhanInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiKokuhanInfo(orders));
        return copyList;
    }

}

