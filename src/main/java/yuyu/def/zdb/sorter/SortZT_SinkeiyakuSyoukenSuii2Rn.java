package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuii2Rn;
import yuyu.def.zdb.comparator.OrderZT_SinkeiyakuSyoukenSuii2Rn;

public class SortZT_SinkeiyakuSyoukenSuii2Rn {

    
    public List<ZT_SinkeiyakuSyoukenSuii2Rn> OrderZT_SinkeiyakuSyoukenSuii2RnByPkAsc(List<ZT_SinkeiyakuSyoukenSuii2Rn> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuii2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Rn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Rn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Rn()).zrnsuiihyouptn, SortOrder.ASC));
        List<ZT_SinkeiyakuSyoukenSuii2Rn> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuii2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuii2Rn(orders));
        return copyList;
    }

    
    public List<ZT_SinkeiyakuSyoukenSuii2Rn> OrderZT_SinkeiyakuSyoukenSuii2RnByPkDesc(List<ZT_SinkeiyakuSyoukenSuii2Rn> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuii2Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Rn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Rn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuii2Rn()).zrnsuiihyouptn, SortOrder.DESC));
        List<ZT_SinkeiyakuSyoukenSuii2Rn> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuii2Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuii2Rn(orders));
        return copyList;
    }
}
