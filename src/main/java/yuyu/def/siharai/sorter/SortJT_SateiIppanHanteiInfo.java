package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.meta.QJT_SateiIppanHanteiInfo;
import yuyu.def.siharai.comparator.OrderJT_SateiIppanHanteiInfo;

public class SortJT_SateiIppanHanteiInfo {

    
    public List<JT_SateiIppanHanteiInfo> OrderJT_SateiIppanHanteiInfoByPkAsc(List<JT_SateiIppanHanteiInfo> pEntity) {
        List<SortCondition<JT_SateiIppanHanteiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiIppanHanteiInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiIppanHanteiInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiIppanHanteiInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_SateiIppanHanteiInfo> copyList = new ArrayList<JT_SateiIppanHanteiInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiIppanHanteiInfo(orders));
        return copyList;
    }

    
    public List<JT_SateiIppanHanteiInfo> OrderJT_SateiIppanHanteiInfoByPkDesc(List<JT_SateiIppanHanteiInfo> pEntity) {
        List<SortCondition<JT_SateiIppanHanteiInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiIppanHanteiInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiIppanHanteiInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiIppanHanteiInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_SateiIppanHanteiInfo> copyList = new ArrayList<JT_SateiIppanHanteiInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiIppanHanteiInfo(orders));
        return copyList;
    }

}

