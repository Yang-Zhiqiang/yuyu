package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.meta.QMT_DsHenkouRireki;
import yuyu.def.direct.comparator.OrderMT_DsHenkouRireki;

public class SortMT_DsHenkouRireki {

    public List<MT_DsHenkouRireki> OrderMT_DsHenkouRirekiByPkAsc(List<MT_DsHenkouRireki> pEntity) {
        List<SortCondition<MT_DsHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHenkouRireki()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHenkouRireki()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHenkouRireki()).renno, SortOrder.ASC));
        List<MT_DsHenkouRireki> copyList = new ArrayList<MT_DsHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHenkouRireki(orders));
        return copyList;
    }

    public List<MT_DsHenkouRireki> OrderMT_DsHenkouRirekiByPkDesc(List<MT_DsHenkouRireki> pEntity) {
        List<SortCondition<MT_DsHenkouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHenkouRireki()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHenkouRireki()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHenkouRireki()).renno, SortOrder.DESC));
        List<MT_DsHenkouRireki> copyList = new ArrayList<MT_DsHenkouRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHenkouRireki(orders));
        return copyList;
    }
}
