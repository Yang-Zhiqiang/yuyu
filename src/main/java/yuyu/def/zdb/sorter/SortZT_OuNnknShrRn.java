package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_OuNnknShrRn;
import yuyu.def.db.meta.QZT_OuNnknShrRn;
import yuyu.def.zdb.comparator.OrderZT_OuNnknShrRn;

public class SortZT_OuNnknShrRn {

    
    public List<ZT_OuNnknShrRn> OrderZT_OuNnknShrRnByPkAsc(List<ZT_OuNnknShrRn> pEntity) {
        List<SortCondition<ZT_OuNnknShrRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OuNnknShrRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_OuNnknShrRn> copyList = new ArrayList<ZT_OuNnknShrRn>(pEntity);
        Collections.sort(copyList, new OrderZT_OuNnknShrRn(orders));
        return copyList;
    }

    
    public List<ZT_OuNnknShrRn> OrderZT_OuNnknShrRnByPkDesc(List<ZT_OuNnknShrRn> pEntity) {
        List<SortCondition<ZT_OuNnknShrRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_OuNnknShrRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_OuNnknShrRn> copyList = new ArrayList<ZT_OuNnknShrRn>(pEntity);
        Collections.sort(copyList, new OrderZT_OuNnknShrRn(orders));
        return copyList;
    }
}
