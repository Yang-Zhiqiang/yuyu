package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_SikinIdouRireki;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.meta.QBT_SikinIdouRireki;

public class SortBT_SikinIdouRireki {

    public List<BT_SikinIdouRireki> OrderBT_SikinIdouRirekiByPkAsc(List<BT_SikinIdouRireki> pEntity) {
        List<SortCondition<BT_SikinIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SikinIdouRireki()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_SikinIdouRireki()).keirisyorirenno, SortOrder.ASC));
        List<BT_SikinIdouRireki> copyList = new ArrayList<BT_SikinIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderBT_SikinIdouRireki(orders));
        return copyList;
    }

    public List<BT_SikinIdouRireki> OrderBT_SikinIdouRirekiByPkDesc(List<BT_SikinIdouRireki> pEntity) {
        List<SortCondition<BT_SikinIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_SikinIdouRireki()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_SikinIdouRireki()).keirisyorirenno, SortOrder.DESC));
        List<BT_SikinIdouRireki> copyList = new ArrayList<BT_SikinIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderBT_SikinIdouRireki(orders));
        return copyList;
    }
}
