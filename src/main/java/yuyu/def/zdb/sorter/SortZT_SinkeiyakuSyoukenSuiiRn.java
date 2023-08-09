package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuiiRn;
import yuyu.def.db.meta.QZT_SinkeiyakuSyoukenSuiiRn;
import yuyu.def.zdb.comparator.OrderZT_SinkeiyakuSyoukenSuiiRn;

public class SortZT_SinkeiyakuSyoukenSuiiRn {

    
    public List<ZT_SinkeiyakuSyoukenSuiiRn> OrderZT_SinkeiyakuSyoukenSuiiRnByPkAsc(List<ZT_SinkeiyakuSyoukenSuiiRn> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuiiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiRn()).zrnsuiihyouptn, SortOrder.ASC));
        List<ZT_SinkeiyakuSyoukenSuiiRn> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuiiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuiiRn(orders));
        return copyList;
    }

    
    public List<ZT_SinkeiyakuSyoukenSuiiRn> OrderZT_SinkeiyakuSyoukenSuiiRnByPkDesc(List<ZT_SinkeiyakuSyoukenSuiiRn> pEntity) {
        List<SortCondition<ZT_SinkeiyakuSyoukenSuiiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuSyoukenSuiiRn()).zrnsuiihyouptn, SortOrder.DESC));
        List<ZT_SinkeiyakuSyoukenSuiiRn> copyList = new ArrayList<ZT_SinkeiyakuSyoukenSuiiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuSyoukenSuiiRn(orders));
        return copyList;
    }
}
