package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkeiyakuHokensyoukenTy;
import yuyu.def.db.meta.QZT_SinkeiyakuHokensyoukenTy;
import yuyu.def.zdb.comparator.OrderZT_SinkeiyakuHokensyoukenTy;

public class SortZT_SinkeiyakuHokensyoukenTy {

    
    public List<ZT_SinkeiyakuHokensyoukenTy> OrderZT_SinkeiyakuHokensyoukenTyByPkAsc(List<ZT_SinkeiyakuHokensyoukenTy> pEntity) {
        List<SortCondition<ZT_SinkeiyakuHokensyoukenTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenTy()).ztysyono, SortOrder.ASC));
        List<ZT_SinkeiyakuHokensyoukenTy> copyList = new ArrayList<ZT_SinkeiyakuHokensyoukenTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuHokensyoukenTy(orders));
        return copyList;
    }

    
    public List<ZT_SinkeiyakuHokensyoukenTy> OrderZT_SinkeiyakuHokensyoukenTyByPkDesc(List<ZT_SinkeiyakuHokensyoukenTy> pEntity) {
        List<SortCondition<ZT_SinkeiyakuHokensyoukenTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenTy()).ztysyono, SortOrder.DESC));
        List<ZT_SinkeiyakuHokensyoukenTy> copyList = new ArrayList<ZT_SinkeiyakuHokensyoukenTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuHokensyoukenTy(orders));
        return copyList;
    }
}
