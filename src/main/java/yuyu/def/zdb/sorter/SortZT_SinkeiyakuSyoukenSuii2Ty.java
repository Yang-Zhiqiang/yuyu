package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.zdb.comparator.OrderZT_SinkeiyakuSyoukenSuii2Ty;

public class SortZT_SinkeiyakuSyoukenSuii2Ty {

    
    public List<ZT_SinkeiyakuSyoukenSuii2Ty> OrderZT_SinkeiyakuSyoukenSuii2TyByPkAsc(List<ZT_SinkeiyakuSyoukenSuii2Ty> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuii2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Ty()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Ty()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Ty()).ztysuiihyouptn, SortOrder.ASC));
        List<ZT_SinkeiyakuSyoukenSuii2Ty> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuii2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuii2Ty(orders));
        return copyList;
    }

    
    public List<ZT_SinkeiyakuSyoukenSuii2Ty> OrderZT_SinkeiyakuSyoukenSuii2TyByPkDesc(List<ZT_SinkeiyakuSyoukenSuii2Ty> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuii2Ty>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Ty()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Ty()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Ty()).ztysuiihyouptn, SortOrder.DESC));
        List<ZT_SinkeiyakuSyoukenSuii2Ty> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuii2Ty>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuii2Ty(orders));
        return copyList;
    }
}
