package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiRn;
import yuyu.def.db.meta.QZT_DSeisanShrTysySyuseiRn;
import yuyu.def.zdb.comparator.OrderZT_DSeisanShrTysySyuseiRn;

public class SortZT_DSeisanShrTysySyuseiRn {

    
    public List<ZT_DSeisanShrTysySyuseiRn> OrderZT_DSeisanShrTysySyuseiRnByPkAsc(List<ZT_DSeisanShrTysySyuseiRn> pEntity) {
        List<SortCondition<ZT_DSeisanShrTysySyuseiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DSeisanShrTysySyuseiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_DSeisanShrTysySyuseiRn> copyList = new ArrayList<ZT_DSeisanShrTysySyuseiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DSeisanShrTysySyuseiRn(orders));
        return copyList;
    }

    
    public List<ZT_DSeisanShrTysySyuseiRn> OrderZT_DSeisanShrTysySyuseiRnByPkDesc(List<ZT_DSeisanShrTysySyuseiRn> pEntity) {
        List<SortCondition<ZT_DSeisanShrTysySyuseiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DSeisanShrTysySyuseiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_DSeisanShrTysySyuseiRn> copyList = new ArrayList<ZT_DSeisanShrTysySyuseiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DSeisanShrTysySyuseiRn(orders));
        return copyList;
    }
}
