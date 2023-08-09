package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenRn;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenRn;
import yuyu.def.zdb.comparator.OrderZT_SbRituToukeiSeibiRenRn;

public class SortZT_SbRituToukeiSeibiRenRn {

    
    public List<ZT_SbRituToukeiSeibiRenRn> OrderZT_SbRituToukeiSeibiRenRnByPkAsc(List<ZT_SbRituToukeiSeibiRenRn> pEntity) {
        List<SortCondition<ZT_SbRituToukeiSeibiRenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituToukeiSeibiRenRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_SbRituToukeiSeibiRenRn> copyList = new ArrayList<ZT_SbRituToukeiSeibiRenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituToukeiSeibiRenRn(orders));
        return copyList;
    }

    
    public List<ZT_SbRituToukeiSeibiRenRn> OrderZT_SbRituToukeiSeibiRenRnByPkDesc(List<ZT_SbRituToukeiSeibiRenRn> pEntity) {
        List<SortCondition<ZT_SbRituToukeiSeibiRenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituToukeiSeibiRenRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_SbRituToukeiSeibiRenRn> copyList = new ArrayList<ZT_SbRituToukeiSeibiRenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituToukeiSeibiRenRn(orders));
        return copyList;
    }
}
