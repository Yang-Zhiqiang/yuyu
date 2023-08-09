package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuiiTy;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuiiTy;
import yuyu.def.zdb.comparator.OrderZT_SinkeiyakuSyoukenSuiiTy;

public class SortZT_SinkeiyakuSyoukenSuiiTy {

    
    public List<ZT_SinkeiyakuSyoukenSuiiTy> OrderZT_SinkeiyakuSyoukenSuiiTyByPkAsc(List<ZT_SinkeiyakuSyoukenSuiiTy> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuiiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiTy()).ztysuiihyouptn, SortOrder.ASC));
        List<ZT_SinkeiyakuSyoukenSuiiTy> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuiiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuiiTy(orders));
        return copyList;
    }

    
    public List<ZT_SinkeiyakuSyoukenSuiiTy> OrderZT_SinkeiyakuSyoukenSuiiTyByPkDesc(List<ZT_SinkeiyakuSyoukenSuiiTy> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuiiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiTy()).ztysuiihyouptn, SortOrder.DESC));
        List<ZT_SinkeiyakuSyoukenSuiiTy> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuiiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuiiTy(orders));
        return copyList;
    }
}
