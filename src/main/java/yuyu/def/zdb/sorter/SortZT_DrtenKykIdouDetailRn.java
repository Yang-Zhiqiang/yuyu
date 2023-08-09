package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailRn;
import yuyu.def.zdb.comparator.OrderZT_DrtenKykIdouDetailRn;

public class SortZT_DrtenKykIdouDetailRn {

    
    public List<ZT_DrtenKykIdouDetailRn> OrderZT_DrtenKykIdouDetailRnByPkAsc(List<ZT_DrtenKykIdouDetailRn> pEntity) {
        List<SortCondition<ZT_DrtenKykIdouDetailRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnbosyuunincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnidouhasseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnidoukbn, SortOrder.ASC));
        List<ZT_DrtenKykIdouDetailRn> copyList = new ArrayList<ZT_DrtenKykIdouDetailRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenKykIdouDetailRn(orders));
        return copyList;
    }

    
    public List<ZT_DrtenKykIdouDetailRn> OrderZT_DrtenKykIdouDetailRnByPkDesc(List<ZT_DrtenKykIdouDetailRn> pEntity) {
        List<SortCondition<ZT_DrtenKykIdouDetailRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnbosyuunincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnidouhasseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenKykIdouDetailRn()).zrnidoukbn, SortOrder.DESC));
        List<ZT_DrtenKykIdouDetailRn> copyList = new ArrayList<ZT_DrtenKykIdouDetailRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenKykIdouDetailRn(orders));
        return copyList;
    }
}
