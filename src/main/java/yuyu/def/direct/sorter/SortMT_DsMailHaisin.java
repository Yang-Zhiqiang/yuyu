package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsMailHaisin;
import yuyu.def.direct.comparator.OrderMT_DsMailHaisin;

public class SortMT_DsMailHaisin {

    public List<MT_DsMailHaisin> OrderMT_DsMailHaisinByPkAsc(List<MT_DsMailHaisin> pEntity) {
        List<SortCondition<MT_DsMailHaisin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).sousinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).dskokmailaddressskbtkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).dssousinmailsyubetukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).dssousinno, SortOrder.ASC));
        List<MT_DsMailHaisin> copyList = new ArrayList<MT_DsMailHaisin>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailHaisin(orders));
        return copyList;
    }

    public List<MT_DsMailHaisin> OrderMT_DsMailHaisinByPkDesc(List<MT_DsMailHaisin> pEntity) {
        List<SortCondition<MT_DsMailHaisin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).sousinymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).dskokmailaddressskbtkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).dssousinmailsyubetukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisin()).dssousinno, SortOrder.DESC));
        List<MT_DsMailHaisin> copyList = new ArrayList<MT_DsMailHaisin>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailHaisin(orders));
        return copyList;
    }
}
