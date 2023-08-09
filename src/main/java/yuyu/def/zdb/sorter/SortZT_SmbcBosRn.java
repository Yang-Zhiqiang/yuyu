package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SmbcBosRn;
import yuyu.def.db.meta.QZT_SmbcBosRn;
import yuyu.def.zdb.comparator.OrderZT_SmbcBosRn;

public class SortZT_SmbcBosRn {

    
    public List<ZT_SmbcBosRn> OrderZT_SmbcBosRnByPkAsc(List<ZT_SmbcBosRn> pEntity) {
        List<SortCondition<ZT_SmbcBosRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebkojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebitijihozonhyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebsekno, SortOrder.ASC));
        List<ZT_SmbcBosRn> copyList = new ArrayList<ZT_SmbcBosRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcBosRn(orders));
        return copyList;
    }

    
    public List<ZT_SmbcBosRn> OrderZT_SmbcBosRnByPkDesc(List<ZT_SmbcBosRn> pEntity) {
        List<SortCondition<ZT_SmbcBosRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebkojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebitijihozonhyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SmbcBosRn()).zrnseihowebsekno, SortOrder.DESC));
        List<ZT_SmbcBosRn> copyList = new ArrayList<ZT_SmbcBosRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SmbcBosRn(orders));
        return copyList;
    }
}
