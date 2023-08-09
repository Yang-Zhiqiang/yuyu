package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.db.meta.QZT_IdCardKihonRn;
import yuyu.def.zdb.comparator.OrderZT_IdCardKihonRn;

public class SortZT_IdCardKihonRn {

    
    public List<ZT_IdCardKihonRn> OrderZT_IdCardKihonRnByPkAsc(List<ZT_IdCardKihonRn> pEntity) {
        List<SortCondition<ZT_IdCardKihonRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdCardKihonRn()).zrnidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_IdCardKihonRn()).zrnidcd, SortOrder.ASC));
        List<ZT_IdCardKihonRn> copyList = new ArrayList<ZT_IdCardKihonRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IdCardKihonRn(orders));
        return copyList;
    }

    
    public List<ZT_IdCardKihonRn> OrderZT_IdCardKihonRnByPkDesc(List<ZT_IdCardKihonRn> pEntity) {
        List<SortCondition<ZT_IdCardKihonRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdCardKihonRn()).zrnidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_IdCardKihonRn()).zrnidcd, SortOrder.DESC));
        List<ZT_IdCardKihonRn> copyList = new ArrayList<ZT_IdCardKihonRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IdCardKihonRn(orders));
        return copyList;
    }
}
