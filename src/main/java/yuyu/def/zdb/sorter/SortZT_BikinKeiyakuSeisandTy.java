package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandTy;
import yuyu.def.db.meta.QZT_BikinKeiyakuSeisandTy;
import yuyu.def.zdb.comparator.OrderZT_BikinKeiyakuSeisandTy;

public class SortZT_BikinKeiyakuSeisandTy {

    
    public List<ZT_BikinKeiyakuSeisandTy> OrderZT_BikinKeiyakuSeisandTyByPkAsc(List<ZT_BikinKeiyakuSeisandTy> pEntity) {
        List<SortCondition<ZT_BikinKeiyakuSeisandTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinKeiyakuSeisandTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_BikinKeiyakuSeisandTy> copyList = new ArrayList<ZT_BikinKeiyakuSeisandTy>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinKeiyakuSeisandTy(orders));
        return copyList;
    }

    
    public List<ZT_BikinKeiyakuSeisandTy> OrderZT_BikinKeiyakuSeisandTyByPkDesc(List<ZT_BikinKeiyakuSeisandTy> pEntity) {
        List<SortCondition<ZT_BikinKeiyakuSeisandTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_BikinKeiyakuSeisandTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_BikinKeiyakuSeisandTy> copyList = new ArrayList<ZT_BikinKeiyakuSeisandTy>(pEntity);
        Collections.sort(copyList, new OrderZT_BikinKeiyakuSeisandTy(orders));
        return copyList;
    }
}
