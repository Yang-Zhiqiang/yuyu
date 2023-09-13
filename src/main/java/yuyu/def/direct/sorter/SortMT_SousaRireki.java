package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.meta.QMT_SousaRireki;
import yuyu.def.direct.comparator.OrderMT_SousaRireki;

public class SortMT_SousaRireki {

    public List<MT_SousaRireki> OrderMT_SousaRirekiByPkAsc(List<MT_SousaRireki> pEntity) {
        List<SortCondition<MT_SousaRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_SousaRireki()).ttdksikibetuid, SortOrder.ASC));
        List<MT_SousaRireki> copyList = new ArrayList<MT_SousaRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_SousaRireki(orders));
        return copyList;
    }

    public List<MT_SousaRireki> OrderMT_SousaRirekiByPkDesc(List<MT_SousaRireki> pEntity) {
        List<SortCondition<MT_SousaRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_SousaRireki()).ttdksikibetuid, SortOrder.DESC));
        List<MT_SousaRireki> copyList = new ArrayList<MT_SousaRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_SousaRireki(orders));
        return copyList;
    }
}
