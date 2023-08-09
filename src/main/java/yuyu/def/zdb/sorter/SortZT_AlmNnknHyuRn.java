package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_AlmNnknHyuRn;
import yuyu.def.db.meta.QZT_AlmNnknHyuRn;
import yuyu.def.zdb.comparator.OrderZT_AlmNnknHyuRn;

public class SortZT_AlmNnknHyuRn {

    
    public List<ZT_AlmNnknHyuRn> OrderZT_AlmNnknHyuRnByPkAsc(List<ZT_AlmNnknHyuRn> pEntity) {
        List<SortCondition<ZT_AlmNnknHyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AlmNnknHyuRn()).zrnnksyousyono, SortOrder.ASC));
        List<ZT_AlmNnknHyuRn> copyList = new ArrayList<ZT_AlmNnknHyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AlmNnknHyuRn(orders));
        return copyList;
    }

    
    public List<ZT_AlmNnknHyuRn> OrderZT_AlmNnknHyuRnByPkDesc(List<ZT_AlmNnknHyuRn> pEntity) {
        List<SortCondition<ZT_AlmNnknHyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AlmNnknHyuRn()).zrnnksyousyono, SortOrder.DESC));
        List<ZT_AlmNnknHyuRn> copyList = new ArrayList<ZT_AlmNnknHyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AlmNnknHyuRn(orders));
        return copyList;
    }
}
