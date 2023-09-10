package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.meta.QJT_SateiMeigihenkouInfo;
import yuyu.def.siharai.comparator.OrderJT_SateiMeigihenkouInfo;

public class SortJT_SateiMeigihenkouInfo {

    
    public List<JT_SateiMeigihenkouInfo> OrderJT_SateiMeigihenkouInfoByPkAsc(List<JT_SateiMeigihenkouInfo> pEntity) {
        List<SortCondition<JT_SateiMeigihenkouInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiMeigihenkouInfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiMeigihenkouInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SateiMeigihenkouInfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_SateiMeigihenkouInfo> copyList = new ArrayList<JT_SateiMeigihenkouInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiMeigihenkouInfo(orders));
        return copyList;
    }

    
    public List<JT_SateiMeigihenkouInfo> OrderJT_SateiMeigihenkouInfoByPkDesc(List<JT_SateiMeigihenkouInfo> pEntity) {
        List<SortCondition<JT_SateiMeigihenkouInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SateiMeigihenkouInfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiMeigihenkouInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SateiMeigihenkouInfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_SateiMeigihenkouInfo> copyList = new ArrayList<JT_SateiMeigihenkouInfo>(pEntity);
        Collections.sort(copyList, new OrderJT_SateiMeigihenkouInfo(orders));
        return copyList;
    }

}

