package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaRn;
import yuyu.def.zdb.comparator.OrderZT_KykIdouHaneiKekkaRn;

public class SortZT_KykIdouHaneiKekkaRn {

    
    public List<ZT_KykIdouHaneiKekkaRn> OrderZT_KykIdouHaneiKekkaRnByPkAsc(List<ZT_KykIdouHaneiKekkaRn> pEntity) {
        List<SortCondition<ZT_KykIdouHaneiKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaRn()).zrnhuho2kyknokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaRn()).zrnhuho2kykno, SortOrder.ASC));
        List<ZT_KykIdouHaneiKekkaRn> copyList = new ArrayList<ZT_KykIdouHaneiKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KykIdouHaneiKekkaRn(orders));
        return copyList;
    }

    
    public List<ZT_KykIdouHaneiKekkaRn> OrderZT_KykIdouHaneiKekkaRnByPkDesc(List<ZT_KykIdouHaneiKekkaRn> pEntity) {
        List<SortCondition<ZT_KykIdouHaneiKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaRn()).zrnhuho2kyknokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KykIdouHaneiKekkaRn()).zrnhuho2kykno, SortOrder.DESC));
        List<ZT_KykIdouHaneiKekkaRn> copyList = new ArrayList<ZT_KykIdouHaneiKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KykIdouHaneiKekkaRn(orders));
        return copyList;
    }
}
