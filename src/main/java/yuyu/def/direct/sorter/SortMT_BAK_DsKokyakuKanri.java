package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_BAK_DsKokyakuKanri;
import yuyu.def.direct.comparator.OrderMT_BAK_DsKokyakuKanri;

public class SortMT_BAK_DsKokyakuKanri {

    public List<MT_BAK_DsKokyakuKanri> OrderMT_BAK_DsKokyakuKanriByPkAsc(List<MT_BAK_DsKokyakuKanri> pEntity) {
        List<SortCondition<MT_BAK_DsKokyakuKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKanri()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKanri()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsKokyakuKanri> copyList = new ArrayList<MT_BAK_DsKokyakuKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsKokyakuKanri(orders));
        return copyList;
    }

    public List<MT_BAK_DsKokyakuKanri> OrderMT_BAK_DsKokyakuKanriByPkDesc(List<MT_BAK_DsKokyakuKanri> pEntity) {
        List<SortCondition<MT_BAK_DsKokyakuKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKanri()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsKokyakuKanri()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsKokyakuKanri> copyList = new ArrayList<MT_BAK_DsKokyakuKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsKokyakuKanri(orders));
        return copyList;
    }
}
