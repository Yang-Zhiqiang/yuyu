package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.meta.QMT_DsKokyakuKanri;
import yuyu.def.direct.comparator.OrderMT_DsKokyakuKanri;

public class SortMT_DsKokyakuKanri {

    public List<MT_DsKokyakuKanri> OrderMT_DsKokyakuKanriByPkAsc(List<MT_DsKokyakuKanri> pEntity) {
        List<SortCondition<MT_DsKokyakuKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsKokyakuKanri()).dskokno, SortOrder.ASC));
        List<MT_DsKokyakuKanri> copyList = new ArrayList<MT_DsKokyakuKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsKokyakuKanri(orders));
        return copyList;
    }

    public List<MT_DsKokyakuKanri> OrderMT_DsKokyakuKanriByPkDesc(List<MT_DsKokyakuKanri> pEntity) {
        List<SortCondition<MT_DsKokyakuKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsKokyakuKanri()).dskokno, SortOrder.DESC));
        List<MT_DsKokyakuKanri> copyList = new ArrayList<MT_DsKokyakuKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsKokyakuKanri(orders));
        return copyList;
    }
}
