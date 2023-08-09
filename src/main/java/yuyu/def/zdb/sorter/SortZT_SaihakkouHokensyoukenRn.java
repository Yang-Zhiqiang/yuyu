package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenRn;
import yuyu.def.zdb.comparator.OrderZT_SaihakkouHokensyoukenRn;

public class SortZT_SaihakkouHokensyoukenRn {

    
    public List<ZT_SaihakkouHokensyoukenRn> OrderZT_SaihakkouHokensyoukenRnByPkAsc(List<ZT_SaihakkouHokensyoukenRn> pEntity) {
        List<SortCondition<ZT_SaihakkouHokensyoukenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SaihakkouHokensyoukenRn> copyList = new ArrayList<ZT_SaihakkouHokensyoukenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouHokensyoukenRn(orders));
        return copyList;
    }

    
    public List<ZT_SaihakkouHokensyoukenRn> OrderZT_SaihakkouHokensyoukenRnByPkDesc(List<ZT_SaihakkouHokensyoukenRn> pEntity) {
        List<SortCondition<ZT_SaihakkouHokensyoukenRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouHokensyoukenRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SaihakkouHokensyoukenRn> copyList = new ArrayList<ZT_SaihakkouHokensyoukenRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouHokensyoukenRn(orders));
        return copyList;
    }
}
