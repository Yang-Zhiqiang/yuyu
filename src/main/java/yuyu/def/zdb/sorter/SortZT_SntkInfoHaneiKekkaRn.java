package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.meta.QZT_SntkInfoHaneiKekkaRn;
import yuyu.def.zdb.comparator.OrderZT_SntkInfoHaneiKekkaRn;

public class SortZT_SntkInfoHaneiKekkaRn {

    
    public List<ZT_SntkInfoHaneiKekkaRn> OrderZT_SntkInfoHaneiKekkaRnByPkAsc(List<ZT_SntkInfoHaneiKekkaRn> pEntity) {
        List<SortCondition<ZT_SntkInfoHaneiKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaRn()).zrnsntkinfono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaRn()).zrnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaRn()).zrnsntkinfotourokusyskbn, SortOrder.ASC));
        List<ZT_SntkInfoHaneiKekkaRn> copyList = new ArrayList<ZT_SntkInfoHaneiKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoHaneiKekkaRn(orders));
        return copyList;
    }

    
    public List<ZT_SntkInfoHaneiKekkaRn> OrderZT_SntkInfoHaneiKekkaRnByPkDesc(List<ZT_SntkInfoHaneiKekkaRn> pEntity) {
        List<SortCondition<ZT_SntkInfoHaneiKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaRn()).zrnsntkinfono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaRn()).zrnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SntkInfoHaneiKekkaRn()).zrnsntkinfotourokusyskbn, SortOrder.DESC));
        List<ZT_SntkInfoHaneiKekkaRn> copyList = new ArrayList<ZT_SntkInfoHaneiKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SntkInfoHaneiKekkaRn(orders));
        return copyList;
    }
}
