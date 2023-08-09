package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenTy;
import yuyu.def.zdb.comparator.OrderZT_SaihakkouHokensyoukenTy;

public class SortZT_SaihakkouHokensyoukenTy {

    
    public List<ZT_SaihakkouHokensyoukenTy> OrderZT_SaihakkouHokensyoukenTyByPkAsc(List<ZT_SaihakkouHokensyoukenTy> pEntity) {
        List<SortCondition<ZT_SaihakkouHokensyoukenTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenTy()).ztysyono, SortOrder.ASC));
        List<ZT_SaihakkouHokensyoukenTy> copyList = new ArrayList<ZT_SaihakkouHokensyoukenTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouHokensyoukenTy(orders));
        return copyList;
    }

    
    public List<ZT_SaihakkouHokensyoukenTy> OrderZT_SaihakkouHokensyoukenTyByPkDesc(List<ZT_SaihakkouHokensyoukenTy> pEntity) {
        List<SortCondition<ZT_SaihakkouHokensyoukenTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenTy()).ztysyono, SortOrder.DESC));
        List<ZT_SaihakkouHokensyoukenTy> copyList = new ArrayList<ZT_SaihakkouHokensyoukenTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouHokensyoukenTy(orders));
        return copyList;
    }
}
