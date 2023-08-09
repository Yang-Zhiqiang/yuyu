package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkGensiRigRn;
import yuyu.def.db.meta.QZT_NkGensiRigRn;
import yuyu.def.zdb.comparator.OrderZT_NkGensiRigRn;

public class SortZT_NkGensiRigRn {

    
    public List<ZT_NkGensiRigRn> OrderZT_NkGensiRigRnByPkAsc(List<ZT_NkGensiRigRn> pEntity) {
        List<SortCondition<ZT_NkGensiRigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiRigRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_NkGensiRigRn> copyList = new ArrayList<ZT_NkGensiRigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiRigRn(orders));
        return copyList;
    }

    
    public List<ZT_NkGensiRigRn> OrderZT_NkGensiRigRnByPkDesc(List<ZT_NkGensiRigRn> pEntity) {
        List<SortCondition<ZT_NkGensiRigRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiRigRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_NkGensiRigRn> copyList = new ArrayList<ZT_NkGensiRigRn>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiRigRn(orders));
        return copyList;
    }
}
