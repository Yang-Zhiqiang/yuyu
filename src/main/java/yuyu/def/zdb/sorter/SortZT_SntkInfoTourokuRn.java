package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SntkInfoTourokuRn;
import yuyu.def.db.meta.QZT_SntkInfoTourokuRn;
import yuyu.def.zdb.comparator.OrderZT_SntkInfoTourokuRn;

public class SortZT_SntkInfoTourokuRn {

    
    public List<ZT_SntkInfoTourokuRn> OrderZT_SntkInfoTourokuRnByPkAsc(List<ZT_SntkInfoTourokuRn> pEntity) {
        List<SortCondition<ZT_SntkInfoTourokuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuRn()).zrnsntkinfono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuRn()).zrnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuRn()).zrnsntkinfotourokusyskbn, SortOrder.ASC));
        List<ZT_SntkInfoTourokuRn> copyList = new ArrayList<ZT_SntkInfoTourokuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoTourokuRn(orders));
        return copyList;
    }

    
    public List<ZT_SntkInfoTourokuRn> OrderZT_SntkInfoTourokuRnByPkDesc(List<ZT_SntkInfoTourokuRn> pEntity) {
        List<SortCondition<ZT_SntkInfoTourokuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuRn()).zrnsntkinfono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuRn()).zrnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoTourokuRn()).zrnsntkinfotourokusyskbn, SortOrder.DESC));
        List<ZT_SntkInfoTourokuRn> copyList = new ArrayList<ZT_SntkInfoTourokuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoTourokuRn(orders));
        return copyList;
    }
}
