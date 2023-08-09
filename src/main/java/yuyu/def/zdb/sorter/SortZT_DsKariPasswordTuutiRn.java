package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_DsKariPasswordTuutiRn;

public class SortZT_DsKariPasswordTuutiRn {

    
    public List<ZT_DsKariPasswordTuutiRn> OrderZT_DsKariPasswordTuutiRnByPkAsc(List<ZT_DsKariPasswordTuutiRn> pEntity) {
        List<SortCondition<ZT_DsKariPasswordTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsKariPasswordTuutiRn()).zrnkrpasswordtuutikey, SortOrder.ASC));
        List<ZT_DsKariPasswordTuutiRn> copyList = new ArrayList<ZT_DsKariPasswordTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DsKariPasswordTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_DsKariPasswordTuutiRn> OrderZT_DsKariPasswordTuutiRnByPkDesc(List<ZT_DsKariPasswordTuutiRn> pEntity) {
        List<SortCondition<ZT_DsKariPasswordTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DsKariPasswordTuutiRn()).zrnkrpasswordtuutikey, SortOrder.DESC));
        List<ZT_DsKariPasswordTuutiRn> copyList = new ArrayList<ZT_DsKariPasswordTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DsKariPasswordTuutiRn(orders));
        return copyList;
    }
}
