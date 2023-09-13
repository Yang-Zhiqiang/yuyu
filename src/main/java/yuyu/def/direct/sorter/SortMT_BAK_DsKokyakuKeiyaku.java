package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_BAK_DsKokyakuKeiyaku;
import yuyu.def.direct.comparator.OrderMT_BAK_DsKokyakuKeiyaku;

public class SortMT_BAK_DsKokyakuKeiyaku {

    public List<MT_BAK_DsKokyakuKeiyaku> OrderMT_BAK_DsKokyakuKeiyakuByPkAsc(List<MT_BAK_DsKokyakuKeiyaku> pEntity) {
        List<SortCondition<MT_BAK_DsKokyakuKeiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKeiyaku()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKeiyaku()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKeiyaku()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsKokyakuKeiyaku> copyList = new ArrayList<MT_BAK_DsKokyakuKeiyaku>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsKokyakuKeiyaku(orders));
        return copyList;
    }

    public List<MT_BAK_DsKokyakuKeiyaku> OrderMT_BAK_DsKokyakuKeiyakuByPkDesc(List<MT_BAK_DsKokyakuKeiyaku> pEntity) {
        List<SortCondition<MT_BAK_DsKokyakuKeiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKeiyaku()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKeiyaku()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKeiyaku()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsKokyakuKeiyaku> copyList = new ArrayList<MT_BAK_DsKokyakuKeiyaku>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsKokyakuKeiyaku(orders));
        return copyList;
    }
}
