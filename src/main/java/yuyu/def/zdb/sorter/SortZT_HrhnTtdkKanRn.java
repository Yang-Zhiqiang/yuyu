package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HrhnTtdkKanRn;
import yuyu.def.db.meta.QZT_HrhnTtdkKanRn;
import yuyu.def.zdb.comparator.OrderZT_HrhnTtdkKanRn;

public class SortZT_HrhnTtdkKanRn {

    
    public List<ZT_HrhnTtdkKanRn> OrderZT_HrhnTtdkKanRnByPkAsc(List<ZT_HrhnTtdkKanRn> pEntity) {
        List<SortCondition<ZT_HrhnTtdkKanRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_HrhnTtdkKanRn> copyList = new ArrayList<ZT_HrhnTtdkKanRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HrhnTtdkKanRn(orders));
        return copyList;
    }

    
    public List<ZT_HrhnTtdkKanRn> OrderZT_HrhnTtdkKanRnByPkDesc(List<ZT_HrhnTtdkKanRn> pEntity) {
        List<SortCondition<ZT_HrhnTtdkKanRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HrhnTtdkKanRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_HrhnTtdkKanRn> copyList = new ArrayList<ZT_HrhnTtdkKanRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HrhnTtdkKanRn(orders));
        return copyList;
    }
}
