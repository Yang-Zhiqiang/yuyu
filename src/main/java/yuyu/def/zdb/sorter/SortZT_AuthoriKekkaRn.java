package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_AuthoriKekkaRn;
import yuyu.def.db.meta.QZT_AuthoriKekkaRn;
import yuyu.def.zdb.comparator.OrderZT_AuthoriKekkaRn;

public class SortZT_AuthoriKekkaRn {

    
    public List<ZT_AuthoriKekkaRn> OrderZT_AuthoriKekkaRnByPkAsc(List<ZT_AuthoriKekkaRn> pEntity) {
        List<SortCondition<ZT_AuthoriKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaRn()).zrnrenno7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaRn()).zrncreditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaRn()).zrndatajyusinymd, SortOrder.ASC));
        List<ZT_AuthoriKekkaRn> copyList = new ArrayList<ZT_AuthoriKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AuthoriKekkaRn(orders));
        return copyList;
    }

    
    public List<ZT_AuthoriKekkaRn> OrderZT_AuthoriKekkaRnByPkDesc(List<ZT_AuthoriKekkaRn> pEntity) {
        List<SortCondition<ZT_AuthoriKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaRn()).zrnrenno7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaRn()).zrncreditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_AuthoriKekkaRn()).zrndatajyusinymd, SortOrder.DESC));
        List<ZT_AuthoriKekkaRn> copyList = new ArrayList<ZT_AuthoriKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AuthoriKekkaRn(orders));
        return copyList;
    }
}
