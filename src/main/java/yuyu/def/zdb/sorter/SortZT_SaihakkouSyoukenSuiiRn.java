package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.db.meta.QZT_SaihakkouSyoukenSuiiRn;
import yuyu.def.zdb.comparator.OrderZT_SaihakkouSyoukenSuiiRn;

public class SortZT_SaihakkouSyoukenSuiiRn {

    
    public List<ZT_SaihakkouSyoukenSuiiRn> OrderZT_SaihakkouSyoukenSuiiRnByPkAsc(List<ZT_SaihakkouSyoukenSuiiRn> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuiiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiRn()).zrnsuiihyouptn, SortOrder.ASC));
        List<ZT_SaihakkouSyoukenSuiiRn> copyList = new ArrayList<ZT_SaihakkouSyoukenSuiiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuiiRn(orders));
        return copyList;
    }

    
    public List<ZT_SaihakkouSyoukenSuiiRn> OrderZT_SaihakkouSyoukenSuiiRnByPkDesc(List<ZT_SaihakkouSyoukenSuiiRn> pEntity) {
        List<SortCondition<ZT_SaihakkouSyoukenSuiiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SaihakkouSyoukenSuiiRn()).zrnsuiihyouptn, SortOrder.DESC));
        List<ZT_SaihakkouSyoukenSuiiRn> copyList = new ArrayList<ZT_SaihakkouSyoukenSuiiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SaihakkouSyoukenSuiiRn(orders));
        return copyList;
    }
}
