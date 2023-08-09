package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoRn;
import yuyu.def.zdb.comparator.OrderZT_IjiToukeiIdouInfoRn;

public class SortZT_IjiToukeiIdouInfoRn {

    
    public List<ZT_IjiToukeiIdouInfoRn> OrderZT_IjiToukeiIdouInfoRnByPkAsc(List<ZT_IjiToukeiIdouInfoRn> pEntity) {
        List<SortCondition<ZT_IjiToukeiIdouInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoRn()).zrnkykmfksnctr, SortOrder.ASC));
        List<ZT_IjiToukeiIdouInfoRn> copyList = new ArrayList<ZT_IjiToukeiIdouInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IjiToukeiIdouInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_IjiToukeiIdouInfoRn> OrderZT_IjiToukeiIdouInfoRnByPkDesc(List<ZT_IjiToukeiIdouInfoRn> pEntity) {
        List<SortCondition<ZT_IjiToukeiIdouInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_IjiToukeiIdouInfoRn()).zrnkykmfksnctr, SortOrder.DESC));
        List<ZT_IjiToukeiIdouInfoRn> copyList = new ArrayList<ZT_IjiToukeiIdouInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IjiToukeiIdouInfoRn(orders));
        return copyList;
    }
}
