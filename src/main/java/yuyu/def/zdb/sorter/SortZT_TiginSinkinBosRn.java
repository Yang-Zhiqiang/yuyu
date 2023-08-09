package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TiginSinkinBosRn;
import yuyu.def.db.meta.QZT_TiginSinkinBosRn;
import yuyu.def.zdb.comparator.OrderZT_TiginSinkinBosRn;

public class SortZT_TiginSinkinBosRn {

    
    public List<ZT_TiginSinkinBosRn> OrderZT_TiginSinkinBosRnByPkAsc(List<ZT_TiginSinkinBosRn> pEntity) {
        List<SortCondition<ZT_TiginSinkinBosRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebsekno, SortOrder.ASC));
        List<ZT_TiginSinkinBosRn> copyList = new ArrayList<ZT_TiginSinkinBosRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TiginSinkinBosRn(orders));
        return copyList;
    }

    
    public List<ZT_TiginSinkinBosRn> OrderZT_TiginSinkinBosRnByPkDesc(List<ZT_TiginSinkinBosRn> pEntity) {
        List<SortCondition<ZT_TiginSinkinBosRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TiginSinkinBosRn()).zrnseihowebsekno, SortOrder.DESC));
        List<ZT_TiginSinkinBosRn> copyList = new ArrayList<ZT_TiginSinkinBosRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TiginSinkinBosRn(orders));
        return copyList;
    }
}
