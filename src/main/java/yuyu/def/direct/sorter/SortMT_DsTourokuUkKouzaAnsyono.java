package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.meta.QMT_DsTourokuUkKouzaAnsyono;
import yuyu.def.direct.comparator.OrderMT_DsTourokuUkKouzaAnsyono;

public class SortMT_DsTourokuUkKouzaAnsyono {

    public List<MT_DsTourokuUkKouzaAnsyono> OrderMT_DsTourokuUkKouzaAnsyonoByPkAsc(List<MT_DsTourokuUkKouzaAnsyono> pEntity) {
        List<SortCondition<MT_DsTourokuUkKouzaAnsyono>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKouzaAnsyono()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKouzaAnsyono()).dsttdksyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKouzaAnsyono()).datarenno, SortOrder.ASC));
        List<MT_DsTourokuUkKouzaAnsyono> copyList = new ArrayList<MT_DsTourokuUkKouzaAnsyono>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTourokuUkKouzaAnsyono(orders));
        return copyList;
    }

    public List<MT_DsTourokuUkKouzaAnsyono> OrderMT_DsTourokuUkKouzaAnsyonoByPkDesc(List<MT_DsTourokuUkKouzaAnsyono> pEntity) {
        List<SortCondition<MT_DsTourokuUkKouzaAnsyono>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKouzaAnsyono()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKouzaAnsyono()).dsttdksyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsTourokuUkKouzaAnsyono()).datarenno, SortOrder.DESC));
        List<MT_DsTourokuUkKouzaAnsyono> copyList = new ArrayList<MT_DsTourokuUkKouzaAnsyono>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTourokuUkKouzaAnsyono(orders));
        return copyList;
    }
}
