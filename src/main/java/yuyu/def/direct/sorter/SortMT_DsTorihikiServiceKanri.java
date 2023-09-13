package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.meta.QMT_DsTorihikiServiceKanri;
import yuyu.def.direct.comparator.OrderMT_DsTorihikiServiceKanri;

public class SortMT_DsTorihikiServiceKanri {

    public List<MT_DsTorihikiServiceKanri> OrderMT_DsTorihikiServiceKanriByPkAsc(List<MT_DsTorihikiServiceKanri> pEntity) {
        List<SortCondition<MT_DsTorihikiServiceKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTorihikiServiceKanri()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsTorihikiServiceKanri()).syono, SortOrder.ASC));
        List<MT_DsTorihikiServiceKanri> copyList = new ArrayList<MT_DsTorihikiServiceKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTorihikiServiceKanri(orders));
        return copyList;
    }

    public List<MT_DsTorihikiServiceKanri> OrderMT_DsTorihikiServiceKanriByPkDesc(List<MT_DsTorihikiServiceKanri> pEntity) {
        List<SortCondition<MT_DsTorihikiServiceKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTorihikiServiceKanri()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsTorihikiServiceKanri()).syono, SortOrder.DESC));
        List<MT_DsTorihikiServiceKanri> copyList = new ArrayList<MT_DsTorihikiServiceKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTorihikiServiceKanri(orders));
        return copyList;
    }
}
