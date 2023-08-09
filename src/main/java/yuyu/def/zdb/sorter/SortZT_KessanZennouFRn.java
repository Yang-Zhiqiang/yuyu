package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KessanZennouFRn;
import yuyu.def.db.meta.QZT_KessanZennouFRn;
import yuyu.def.zdb.comparator.OrderZT_KessanZennouFRn;

public class SortZT_KessanZennouFRn {

    
    public List<ZT_KessanZennouFRn> OrderZT_KessanZennouFRnByPkAsc(List<ZT_KessanZennouFRn> pEntity) {
        List<SortCondition<ZT_KessanZennouFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnkbnkeiriyousegmentcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnzennoutoukeilistkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnzennoukbn, SortOrder.ASC));
        List<ZT_KessanZennouFRn> copyList = new ArrayList<ZT_KessanZennouFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanZennouFRn(orders));
        return copyList;
    }

    
    public List<ZT_KessanZennouFRn> OrderZT_KessanZennouFRnByPkDesc(List<ZT_KessanZennouFRn> pEntity) {
        List<SortCondition<ZT_KessanZennouFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnkbnkeiriyousegmentcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnzennoutoukeilistkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanZennouFRn()).zrnzennoukbn, SortOrder.DESC));
        List<ZT_KessanZennouFRn> copyList = new ArrayList<ZT_KessanZennouFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanZennouFRn(orders));
        return copyList;
    }
}
