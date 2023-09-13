package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsTorihikiServiceKanri;
import yuyu.def.db.meta.QMT_BAK_DsTorihikiServiceKanri;
import yuyu.def.direct.comparator.OrderMT_BAK_DsTorihikiServiceKanri;

public class SortMT_BAK_DsTorihikiServiceKanri {

    public List<MT_BAK_DsTorihikiServiceKanri> OrderMT_BAK_DsTorihikiServiceKanriByPkAsc(List<MT_BAK_DsTorihikiServiceKanri> pEntity) {
        List<SortCondition<MT_BAK_DsTorihikiServiceKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiServiceKanri()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiServiceKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiServiceKanri()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsTorihikiServiceKanri> copyList = new ArrayList<MT_BAK_DsTorihikiServiceKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsTorihikiServiceKanri(orders));
        return copyList;
    }

    public List<MT_BAK_DsTorihikiServiceKanri> OrderMT_BAK_DsTorihikiServiceKanriByPkDesc(List<MT_BAK_DsTorihikiServiceKanri> pEntity) {
        List<SortCondition<MT_BAK_DsTorihikiServiceKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiServiceKanri()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiServiceKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiServiceKanri()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsTorihikiServiceKanri> copyList = new ArrayList<MT_BAK_DsTorihikiServiceKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsTorihikiServiceKanri(orders));
        return copyList;
    }
}
