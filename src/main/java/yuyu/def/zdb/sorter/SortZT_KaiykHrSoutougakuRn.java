package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KaiykHrSoutougakuRn;
import yuyu.def.db.meta.QZT_KaiykHrSoutougakuRn;
import yuyu.def.zdb.comparator.OrderZT_KaiykHrSoutougakuRn;

public class SortZT_KaiykHrSoutougakuRn {

    
    public List<ZT_KaiykHrSoutougakuRn> OrderZT_KaiykHrSoutougakuRnByPkAsc(List<ZT_KaiykHrSoutougakuRn> pEntity) {
        List<SortCondition<ZT_KaiykHrSoutougakuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaiykHrSoutougakuRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KaiykHrSoutougakuRn> copyList = new ArrayList<ZT_KaiykHrSoutougakuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KaiykHrSoutougakuRn(orders));
        return copyList;
    }

    
    public List<ZT_KaiykHrSoutougakuRn> OrderZT_KaiykHrSoutougakuRnByPkDesc(List<ZT_KaiykHrSoutougakuRn> pEntity) {
        List<SortCondition<ZT_KaiykHrSoutougakuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaiykHrSoutougakuRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KaiykHrSoutougakuRn> copyList = new ArrayList<ZT_KaiykHrSoutougakuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KaiykHrSoutougakuRn(orders));
        return copyList;
    }
}
