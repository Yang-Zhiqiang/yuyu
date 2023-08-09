package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkGensiKtyRn;
import yuyu.def.db.meta.QZT_NkGensiKtyRn;
import yuyu.def.zdb.comparator.OrderZT_NkGensiKtyRn;

public class SortZT_NkGensiKtyRn {

    
    public List<ZT_NkGensiKtyRn> OrderZT_NkGensiKtyRnByPkAsc(List<ZT_NkGensiKtyRn> pEntity) {
        List<SortCondition<ZT_NkGensiKtyRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiKtyRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_NkGensiKtyRn> copyList = new ArrayList<ZT_NkGensiKtyRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiKtyRn(orders));
        return copyList;
    }

    
    public List<ZT_NkGensiKtyRn> OrderZT_NkGensiKtyRnByPkDesc(List<ZT_NkGensiKtyRn> pEntity) {
        List<SortCondition<ZT_NkGensiKtyRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiKtyRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_NkGensiKtyRn> copyList = new ArrayList<ZT_NkGensiKtyRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiKtyRn(orders));
        return copyList;
    }
}
