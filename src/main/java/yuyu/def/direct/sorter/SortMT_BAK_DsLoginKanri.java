package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsLoginKanri;
import yuyu.def.db.meta.QMT_BAK_DsLoginKanri;
import yuyu.def.direct.comparator.OrderMT_BAK_DsLoginKanri;

public class SortMT_BAK_DsLoginKanri {

    public List<MT_BAK_DsLoginKanri> OrderMT_BAK_DsLoginKanriByPkAsc(List<MT_BAK_DsLoginKanri> pEntity) {
        List<SortCondition<MT_BAK_DsLoginKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsLoginKanri()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsLoginKanri()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsLoginKanri> copyList = new ArrayList<MT_BAK_DsLoginKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsLoginKanri(orders));
        return copyList;
    }

    public List<MT_BAK_DsLoginKanri> OrderMT_BAK_DsLoginKanriByPkDesc(List<MT_BAK_DsLoginKanri> pEntity) {
        List<SortCondition<MT_BAK_DsLoginKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsLoginKanri()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsLoginKanri()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsLoginKanri> copyList = new ArrayList<MT_BAK_DsLoginKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsLoginKanri(orders));
        return copyList;
    }
}
