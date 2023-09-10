package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.meta.QJT_BetukutiSateiInfo;
import yuyu.def.siharai.comparator.OrderJT_BetukutiSateiInfo;

public class SortJT_BetukutiSateiInfo {

    
    public List<JT_BetukutiSateiInfo> OrderJT_BetukutiSateiInfoByPkAsc(List<JT_BetukutiSateiInfo> pEntity) {
        List<SortCondition<JT_BetukutiSateiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_BetukutiSateiInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_BetukutiSateiInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_BetukutiSateiInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_BetukutiSateiInfo> copyList = new ArrayList<JT_BetukutiSateiInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_BetukutiSateiInfo(orders));
        return copyList;
    }

    
    public List<JT_BetukutiSateiInfo> OrderJT_BetukutiSateiInfoByPkDesc(List<JT_BetukutiSateiInfo> pEntity) {
        List<SortCondition<JT_BetukutiSateiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_BetukutiSateiInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_BetukutiSateiInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_BetukutiSateiInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_BetukutiSateiInfo> copyList = new ArrayList<JT_BetukutiSateiInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_BetukutiSateiInfo(orders));
        return copyList;
    }

}

