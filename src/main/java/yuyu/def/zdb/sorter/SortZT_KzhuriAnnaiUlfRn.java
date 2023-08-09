package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfRn;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfRn;
import yuyu.def.zdb.comparator.OrderZT_KzhuriAnnaiUlfRn;

public class SortZT_KzhuriAnnaiUlfRn {

    
    public List<ZT_KzhuriAnnaiUlfRn> OrderZT_KzhuriAnnaiUlfRnByPkAsc(List<ZT_KzhuriAnnaiUlfRn> pEntity) {
        List<SortCondition<ZT_KzhuriAnnaiUlfRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfRn()).zrnjyuutouym, SortOrder.ASC));
        List<ZT_KzhuriAnnaiUlfRn> copyList = new ArrayList<ZT_KzhuriAnnaiUlfRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriAnnaiUlfRn(orders));
        return copyList;
    }

    
    public List<ZT_KzhuriAnnaiUlfRn> OrderZT_KzhuriAnnaiUlfRnByPkDesc(List<ZT_KzhuriAnnaiUlfRn> pEntity) {
        List<SortCondition<ZT_KzhuriAnnaiUlfRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KzhuriAnnaiUlfRn()).zrnjyuutouym, SortOrder.DESC));
        List<ZT_KzhuriAnnaiUlfRn> copyList = new ArrayList<ZT_KzhuriAnnaiUlfRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriAnnaiUlfRn(orders));
        return copyList;
    }
}
