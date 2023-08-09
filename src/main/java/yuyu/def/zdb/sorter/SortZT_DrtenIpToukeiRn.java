package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.QZT_DrtenIpToukeiRn;
import yuyu.def.zdb.comparator.OrderZT_DrtenIpToukeiRn;

public class SortZT_DrtenIpToukeiRn {

    
    public List<ZT_DrtenIpToukeiRn> OrderZT_DrtenIpToukeiRnByPkAsc(List<ZT_DrtenIpToukeiRn> pEntity) {
        List<SortCondition<ZT_DrtenIpToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrneigyouhonbusisyacd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnsosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnatukaikojincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnmosym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnmosno, SortOrder.ASC));
        List<ZT_DrtenIpToukeiRn> copyList = new ArrayList<ZT_DrtenIpToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenIpToukeiRn(orders));
        return copyList;
    }

    
    public List<ZT_DrtenIpToukeiRn> OrderZT_DrtenIpToukeiRnByPkDesc(List<ZT_DrtenIpToukeiRn> pEntity) {
        List<SortCondition<ZT_DrtenIpToukeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrneigyouhonbusisyacd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnsosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnatukaikojincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnmosym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenIpToukeiRn()).zrnmosno, SortOrder.DESC));
        List<ZT_DrtenIpToukeiRn> copyList = new ArrayList<ZT_DrtenIpToukeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenIpToukeiRn(orders));
        return copyList;
    }
}
