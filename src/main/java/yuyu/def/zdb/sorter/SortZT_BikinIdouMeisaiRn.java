package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_BikinIdouMeisaiRn;
import yuyu.def.db.meta.QZT_BikinIdouMeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_BikinIdouMeisaiRn;

public class SortZT_BikinIdouMeisaiRn {

    
    public List<ZT_BikinIdouMeisaiRn> OrderZT_BikinIdouMeisaiRnByPkAsc(List<ZT_BikinIdouMeisaiRn> pEntity) {
        List<SortCondition<ZT_BikinIdouMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinIdouMeisaiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_BikinIdouMeisaiRn> copyList = new ArrayList<ZT_BikinIdouMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinIdouMeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_BikinIdouMeisaiRn> OrderZT_BikinIdouMeisaiRnByPkDesc(List<ZT_BikinIdouMeisaiRn> pEntity) {
        List<SortCondition<ZT_BikinIdouMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinIdouMeisaiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_BikinIdouMeisaiRn> copyList = new ArrayList<ZT_BikinIdouMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinIdouMeisaiRn(orders));
        return copyList;
    }
}
