package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.direct.comparator.OrderMT_DsKokyakuKeiyaku;

public class SortMT_DsKokyakuKeiyaku {

    public List<MT_DsKokyakuKeiyaku> OrderMT_DsKokyakuKeiyakuByPkAsc(List<MT_DsKokyakuKeiyaku> pEntity) {
        List<SortCondition<MT_DsKokyakuKeiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsKokyakuKeiyaku()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsKokyakuKeiyaku()).syono, SortOrder.ASC));
        List<MT_DsKokyakuKeiyaku> copyList = new ArrayList<MT_DsKokyakuKeiyaku>(pEntity);
        Collections.sort(copyList, new OrderMT_DsKokyakuKeiyaku(orders));
        return copyList;
    }

    public List<MT_DsKokyakuKeiyaku> OrderMT_DsKokyakuKeiyakuByPkDesc(List<MT_DsKokyakuKeiyaku> pEntity) {
        List<SortCondition<MT_DsKokyakuKeiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsKokyakuKeiyaku()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsKokyakuKeiyaku()).syono, SortOrder.DESC));
        List<MT_DsKokyakuKeiyaku> copyList = new ArrayList<MT_DsKokyakuKeiyaku>(pEntity);
        Collections.sort(copyList, new OrderMT_DsKokyakuKeiyaku(orders));
        return copyList;
    }
    public List<MT_DsKokyakuKeiyaku> OrderMT_DsKokyakuKeiyakuByDskykkanyuuymdDesc(List<MT_DsKokyakuKeiyaku> pEntity) {
        List<SortCondition<MT_DsKokyakuKeiyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsKokyakuKeiyaku()).dskykkanyuuymd, SortOrder.DESC));
        List<MT_DsKokyakuKeiyaku> copyList = new ArrayList<MT_DsKokyakuKeiyaku>(pEntity);
        Collections.sort(copyList, new OrderMT_DsKokyakuKeiyaku(orders));
        return copyList;
    }

}
