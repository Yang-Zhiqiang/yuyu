package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_HknBosyuRiyouInfo;
import yuyu.def.db.entity.BT_HknBosyuRiyouInfo;
import yuyu.def.db.meta.QBT_HknBosyuRiyouInfo;

public class SortBT_HknBosyuRiyouInfo {

    public List<BT_HknBosyuRiyouInfo> OrderBT_HknBosyuRiyouInfoByPkAsc(List<BT_HknBosyuRiyouInfo> pEntity) {
        List<SortCondition<BT_HknBosyuRiyouInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HknBosyuRiyouInfo()).drtencd, SortOrder.ASC));
        List<BT_HknBosyuRiyouInfo> copyList = new ArrayList<BT_HknBosyuRiyouInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_HknBosyuRiyouInfo(orders));
        return copyList;
    }

    public List<BT_HknBosyuRiyouInfo> OrderBT_HknBosyuRiyouInfoByPkDesc(List<BT_HknBosyuRiyouInfo> pEntity) {
        List<SortCondition<BT_HknBosyuRiyouInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HknBosyuRiyouInfo()).drtencd, SortOrder.DESC));
        List<BT_HknBosyuRiyouInfo> copyList = new ArrayList<BT_HknBosyuRiyouInfo>(pEntity);
        Collections.sort(copyList, new OrderBT_HknBosyuRiyouInfo(orders));
        return copyList;
    }

}

