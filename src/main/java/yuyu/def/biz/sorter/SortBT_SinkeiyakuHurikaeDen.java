package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_SinkeiyakuHurikaeDen;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.meta.QBT_SinkeiyakuHurikaeDen;

public class SortBT_SinkeiyakuHurikaeDen {

    public List<BT_SinkeiyakuHurikaeDen> OrderBT_SinkeiyakuHurikaeDenByPkAsc(List<BT_SinkeiyakuHurikaeDen> pEntity) {
        List<SortCondition<BT_SinkeiyakuHurikaeDen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SinkeiyakuHurikaeDen()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_SinkeiyakuHurikaeDen()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_SinkeiyakuHurikaeDen()).edano, SortOrder.ASC));
        List<BT_SinkeiyakuHurikaeDen> copyList = new ArrayList<BT_SinkeiyakuHurikaeDen>(pEntity);
        Collections.sort(copyList, new OrderBT_SinkeiyakuHurikaeDen(orders));
        return copyList;
    }

    public List<BT_SinkeiyakuHurikaeDen> OrderBT_SinkeiyakuHurikaeDenByPkDesc(List<BT_SinkeiyakuHurikaeDen> pEntity) {
        List<SortCondition<BT_SinkeiyakuHurikaeDen>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SinkeiyakuHurikaeDen()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_SinkeiyakuHurikaeDen()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_SinkeiyakuHurikaeDen()).edano, SortOrder.DESC));
        List<BT_SinkeiyakuHurikaeDen> copyList = new ArrayList<BT_SinkeiyakuHurikaeDen>(pEntity);
        Collections.sort(copyList, new OrderBT_SinkeiyakuHurikaeDen(orders));
        return copyList;
    }

}

