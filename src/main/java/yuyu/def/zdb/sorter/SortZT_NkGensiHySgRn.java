package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkGensiHySgRn;
import yuyu.def.db.meta.QZT_NkGensiHySgRn;
import yuyu.def.zdb.comparator.OrderZT_NkGensiHySgRn;

public class SortZT_NkGensiHySgRn {

    
    public List<ZT_NkGensiHySgRn> OrderZT_NkGensiHySgRnByPkAsc(List<ZT_NkGensiHySgRn> pEntity) {
        List<SortCondition<ZT_NkGensiHySgRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiHySgRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_NkGensiHySgRn> copyList = new ArrayList<ZT_NkGensiHySgRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiHySgRn(orders));
        return copyList;
    }

    
    public List<ZT_NkGensiHySgRn> OrderZT_NkGensiHySgRnByPkDesc(List<ZT_NkGensiHySgRn> pEntity) {
        List<SortCondition<ZT_NkGensiHySgRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiHySgRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_NkGensiHySgRn> copyList = new ArrayList<ZT_NkGensiHySgRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiHySgRn(orders));
        return copyList;
    }
}
