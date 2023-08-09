package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.zdb.comparator.OrderZT_SaihakkouSyoukenSuiiTy;

public class SortZT_SaihakkouSyoukenSuiiTy {

    
    public List<ZT_SaihakkouSyoukenSuiiTy> OrderZT_SaihakkouSyoukenSuiiTyByPkAsc(List<ZT_SaihakkouSyoukenSuiiTy> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuiiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiTy()).ztysuiihyouptn, SortOrder.ASC));
        List<ZT_SaihakkouSyoukenSuiiTy> copyList = new ArrayList<ZT_SaihakkouSyoukenSuiiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuiiTy(orders));
        return copyList;
    }

    
    public List<ZT_SaihakkouSyoukenSuiiTy> OrderZT_SaihakkouSyoukenSuiiTyByPkDesc(List<ZT_SaihakkouSyoukenSuiiTy> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuiiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiTy()).ztysuiihyouptn, SortOrder.DESC));
        List<ZT_SaihakkouSyoukenSuiiTy> copyList = new ArrayList<ZT_SaihakkouSyoukenSuiiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuiiTy(orders));
        return copyList;
    }
}
