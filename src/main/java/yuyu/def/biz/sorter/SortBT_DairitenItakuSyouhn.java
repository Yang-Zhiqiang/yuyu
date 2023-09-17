package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_DairitenItakuSyouhn;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;
import yuyu.def.db.meta.QBT_DairitenItakuSyouhn;

public class SortBT_DairitenItakuSyouhn {

    public List<BT_DairitenItakuSyouhn> OrderBT_DairitenItakuSyouhnByPkAsc(List<BT_DairitenItakuSyouhn> pEntity) {
        List<SortCondition<BT_DairitenItakuSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drtsyouhinsikibetukbnstr, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drthrkhouhoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drtplannmkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).itakuhknhnbkaisiymd, SortOrder.ASC));
        List<BT_DairitenItakuSyouhn> copyList = new ArrayList<BT_DairitenItakuSyouhn>(pEntity);
        Collections.sort(copyList, new OrderBT_DairitenItakuSyouhn(orders));
        return copyList;
    }

    public List<BT_DairitenItakuSyouhn> OrderBT_DairitenItakuSyouhnByPkDesc(List<BT_DairitenItakuSyouhn> pEntity) {
        List<SortCondition<BT_DairitenItakuSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drtsyouhinsikibetukbnstr, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drthrkhouhoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).drtplannmkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_DairitenItakuSyouhn()).itakuhknhnbkaisiymd, SortOrder.DESC));
        List<BT_DairitenItakuSyouhn> copyList = new ArrayList<BT_DairitenItakuSyouhn>(pEntity);
        Collections.sort(copyList, new OrderBT_DairitenItakuSyouhn(orders));
        return copyList;
    }
}
