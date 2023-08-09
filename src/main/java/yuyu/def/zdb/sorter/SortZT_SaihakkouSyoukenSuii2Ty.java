package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuii2Ty;
import yuyu.def.zdb.comparator.OrderZT_SaihakkouSyoukenSuii2Ty;

public class SortZT_SaihakkouSyoukenSuii2Ty {

    
    public List<ZT_SaihakkouSyoukenSuii2Ty> OrderZT_SaihakkouSyoukenSuii2TyByPkAsc(List<ZT_SaihakkouSyoukenSuii2Ty> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuii2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Ty()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Ty()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Ty()).ztysuiihyouptn, SortOrder.ASC));
        List<ZT_SaihakkouSyoukenSuii2Ty> copyList = new ArrayList<ZT_SaihakkouSyoukenSuii2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuii2Ty(orders));
        return copyList;
    }

    
    public List<ZT_SaihakkouSyoukenSuii2Ty> OrderZT_SaihakkouSyoukenSuii2TyByPkDesc(List<ZT_SaihakkouSyoukenSuii2Ty> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuii2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Ty()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Ty()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuii2Ty()).ztysuiihyouptn, SortOrder.DESC));
        List<ZT_SaihakkouSyoukenSuii2Ty> copyList = new ArrayList<ZT_SaihakkouSyoukenSuii2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuii2Ty(orders));
        return copyList;
    }
}
