package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoTr;
import yuyu.def.zdb.comparator.OrderZT_IjiToukeiIdouInfoTr;

public class SortZT_IjiToukeiIdouInfoTr {

    
    public List<ZT_IjiToukeiIdouInfoTr> OrderZT_IjiToukeiIdouInfoTrByPkAsc(List<ZT_IjiToukeiIdouInfoTr> pEntity) {
        List<SortCondition<ZT_IjiToukeiIdouInfoTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoTr()).ztrsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoTr()).ztrkykmfksnctr, SortOrder.ASC));
        List<ZT_IjiToukeiIdouInfoTr> copyList = new ArrayList<ZT_IjiToukeiIdouInfoTr>(pEntity);
        Collections.sort(copyList, new OrderZT_IjiToukeiIdouInfoTr(orders));
        return copyList;
    }

    
    public List<ZT_IjiToukeiIdouInfoTr> OrderZT_IjiToukeiIdouInfoTrByPkDesc(List<ZT_IjiToukeiIdouInfoTr> pEntity) {
        List<SortCondition<ZT_IjiToukeiIdouInfoTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoTr()).ztrsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoTr()).ztrkykmfksnctr, SortOrder.DESC));
        List<ZT_IjiToukeiIdouInfoTr> copyList = new ArrayList<ZT_IjiToukeiIdouInfoTr>(pEntity);
        Collections.sort(copyList, new OrderZT_IjiToukeiIdouInfoTr(orders));
        return copyList;
    }
}
