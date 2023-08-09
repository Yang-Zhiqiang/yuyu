package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkeiyakuHokensyoukenRn;
import yuyu.def.db.meta.QZT_SinkeiyakuHokensyoukenRn;
import yuyu.def.zdb.comparator.OrderZT_SinkeiyakuHokensyoukenRn;

public class SortZT_SinkeiyakuHokensyoukenRn {

    
    public List<ZT_SinkeiyakuHokensyoukenRn> OrderZT_SinkeiyakuHokensyoukenRnByPkAsc(List<ZT_SinkeiyakuHokensyoukenRn> pEntity) {
        List<SortCondition<ZT_SinkeiyakuHokensyoukenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SinkeiyakuHokensyoukenRn> copyList = new ArrayList<ZT_SinkeiyakuHokensyoukenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuHokensyoukenRn(orders));
        return copyList;
    }

    
    public List<ZT_SinkeiyakuHokensyoukenRn> OrderZT_SinkeiyakuHokensyoukenRnByPkDesc(List<ZT_SinkeiyakuHokensyoukenRn> pEntity) {
        List<SortCondition<ZT_SinkeiyakuHokensyoukenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SinkeiyakuHokensyoukenRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SinkeiyakuHokensyoukenRn> copyList = new ArrayList<ZT_SinkeiyakuHokensyoukenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkeiyakuHokensyoukenRn(orders));
        return copyList;
    }
}
