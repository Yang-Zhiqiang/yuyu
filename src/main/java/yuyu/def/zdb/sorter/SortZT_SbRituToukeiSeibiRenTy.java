package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SbRituToukeiSeibiRenTy;
import yuyu.def.db.meta.QZT_SbRituToukeiSeibiRenTy;
import yuyu.def.zdb.comparator.OrderZT_SbRituToukeiSeibiRenTy;

public class SortZT_SbRituToukeiSeibiRenTy {

    
    public List<ZT_SbRituToukeiSeibiRenTy> OrderZT_SbRituToukeiSeibiRenTyByPkAsc(List<ZT_SbRituToukeiSeibiRenTy> pEntity) {
        List<SortCondition<ZT_SbRituToukeiSeibiRenTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituToukeiSeibiRenTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_SbRituToukeiSeibiRenTy> copyList = new ArrayList<ZT_SbRituToukeiSeibiRenTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituToukeiSeibiRenTy(orders));
        return copyList;
    }

    
    public List<ZT_SbRituToukeiSeibiRenTy> OrderZT_SbRituToukeiSeibiRenTyByPkDesc(List<ZT_SbRituToukeiSeibiRenTy> pEntity) {
        List<SortCondition<ZT_SbRituToukeiSeibiRenTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SbRituToukeiSeibiRenTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_SbRituToukeiSeibiRenTy> copyList = new ArrayList<ZT_SbRituToukeiSeibiRenTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SbRituToukeiSeibiRenTy(orders));
        return copyList;
    }
}
