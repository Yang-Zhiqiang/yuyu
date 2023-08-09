package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouRn;
import yuyu.def.zdb.comparator.OrderZT_TjtIdouNaiyouRn;

public class SortZT_TjtIdouNaiyouRn {

    
    public List<ZT_TjtIdouNaiyouRn> OrderZT_TjtIdouNaiyouRnByPkAsc(List<ZT_TjtIdouNaiyouRn> pEntity) {
        List<SortCondition<ZT_TjtIdouNaiyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouRn()).zrnhuho2kyknokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouRn()).zrnhuho2kykno, SortOrder.ASC));
        List<ZT_TjtIdouNaiyouRn> copyList = new ArrayList<ZT_TjtIdouNaiyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjtIdouNaiyouRn(orders));
        return copyList;
    }

    
    public List<ZT_TjtIdouNaiyouRn> OrderZT_TjtIdouNaiyouRnByPkDesc(List<ZT_TjtIdouNaiyouRn> pEntity) {
        List<SortCondition<ZT_TjtIdouNaiyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouRn()).zrnhuho2kyknokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TjtIdouNaiyouRn()).zrnhuho2kykno, SortOrder.DESC));
        List<ZT_TjtIdouNaiyouRn> copyList = new ArrayList<ZT_TjtIdouNaiyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TjtIdouNaiyouRn(orders));
        return copyList;
    }
}
