package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_DsKariPasswordTuutiTy;

public class SortZT_DsKariPasswordTuutiTy {

    
    public List<ZT_DsKariPasswordTuutiTy> OrderZT_DsKariPasswordTuutiTyByPkAsc(List<ZT_DsKariPasswordTuutiTy> pEntity) {
        List<SortCondition<ZT_DsKariPasswordTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsKariPasswordTuutiTy()).ztykrpasswordtuutikey, SortOrder.ASC));
        List<ZT_DsKariPasswordTuutiTy> copyList = new ArrayList<ZT_DsKariPasswordTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DsKariPasswordTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_DsKariPasswordTuutiTy> OrderZT_DsKariPasswordTuutiTyByPkDesc(List<ZT_DsKariPasswordTuutiTy> pEntity) {
        List<SortCondition<ZT_DsKariPasswordTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsKariPasswordTuutiTy()).ztykrpasswordtuutikey, SortOrder.DESC));
        List<ZT_DsKariPasswordTuutiTy> copyList = new ArrayList<ZT_DsKariPasswordTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DsKariPasswordTuutiTy(orders));
        return copyList;
    }
}
