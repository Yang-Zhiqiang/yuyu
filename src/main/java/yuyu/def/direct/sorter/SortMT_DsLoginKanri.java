package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.meta.QMT_DsLoginKanri;
import yuyu.def.direct.comparator.OrderMT_DsLoginKanri;

public class SortMT_DsLoginKanri {

    public List<MT_DsLoginKanri> OrderMT_DsLoginKanriByPkAsc(List<MT_DsLoginKanri> pEntity) {
        List<SortCondition<MT_DsLoginKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsLoginKanri()).dskokno, SortOrder.ASC));
        List<MT_DsLoginKanri> copyList = new ArrayList<MT_DsLoginKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsLoginKanri(orders));
        return copyList;
    }

    public List<MT_DsLoginKanri> OrderMT_DsLoginKanriByPkDesc(List<MT_DsLoginKanri> pEntity) {
        List<SortCondition<MT_DsLoginKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsLoginKanri()).dskokno, SortOrder.DESC));
        List<MT_DsLoginKanri> copyList = new ArrayList<MT_DsLoginKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsLoginKanri(orders));
        return copyList;
    }
}
