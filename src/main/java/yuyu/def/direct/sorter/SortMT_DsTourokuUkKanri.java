package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.meta.QMT_DsTourokuUkKanri;
import yuyu.def.direct.comparator.OrderMT_DsTourokuUkKanri;

public class SortMT_DsTourokuUkKanri {

    public List<MT_DsTourokuUkKanri> OrderMT_DsTourokuUkKanriByPkAsc(List<MT_DsTourokuUkKanri> pEntity) {
        List<SortCondition<MT_DsTourokuUkKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKanri()).dsttdksyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKanri()).datarenno, SortOrder.ASC));
        List<MT_DsTourokuUkKanri> copyList = new ArrayList<MT_DsTourokuUkKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTourokuUkKanri(orders));
        return copyList;
    }

    public List<MT_DsTourokuUkKanri> OrderMT_DsTourokuUkKanriByPkDesc(List<MT_DsTourokuUkKanri> pEntity) {
        List<SortCondition<MT_DsTourokuUkKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKanri()).dsttdksyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKanri()).datarenno, SortOrder.DESC));
        List<MT_DsTourokuUkKanri> copyList = new ArrayList<MT_DsTourokuUkKanri>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTourokuUkKanri(orders));
        return copyList;
    }
}
