package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.zdb.comparator.OrderZT_KyhknShrJyoukyouRnrkTy;

public class SortZT_KyhknShrJyoukyouRnrkTy {

    
    public List<ZT_KyhknShrJyoukyouRnrkTy> OrderZT_KyhknShrJyoukyouRnrkTyByPkAsc(List<ZT_KyhknShrJyoukyouRnrkTy> pEntity) {
        List<SortCondition<ZT_KyhknShrJyoukyouRnrkTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KyhknShrJyoukyouRnrkTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KyhknShrJyoukyouRnrkTy> copyList = new ArrayList<ZT_KyhknShrJyoukyouRnrkTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KyhknShrJyoukyouRnrkTy(orders));
        return copyList;
    }

    
    public List<ZT_KyhknShrJyoukyouRnrkTy> OrderZT_KyhknShrJyoukyouRnrkTyByPkDesc(List<ZT_KyhknShrJyoukyouRnrkTy> pEntity) {
        List<SortCondition<ZT_KyhknShrJyoukyouRnrkTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KyhknShrJyoukyouRnrkTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KyhknShrJyoukyouRnrkTy> copyList = new ArrayList<ZT_KyhknShrJyoukyouRnrkTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KyhknShrJyoukyouRnrkTy(orders));
        return copyList;
    }
}
