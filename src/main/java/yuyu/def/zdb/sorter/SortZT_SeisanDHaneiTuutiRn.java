package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_SeisanDHaneiTuutiRn;

public class SortZT_SeisanDHaneiTuutiRn {

    
    public List<ZT_SeisanDHaneiTuutiRn> OrderZT_SeisanDHaneiTuutiRnByPkAsc(List<ZT_SeisanDHaneiTuutiRn> pEntity) {
        List<SortCondition<ZT_SeisanDHaneiTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiRn()).zrnkeysyono, SortOrder.ASC));
        List<ZT_SeisanDHaneiTuutiRn> copyList = new ArrayList<ZT_SeisanDHaneiTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SeisanDHaneiTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_SeisanDHaneiTuutiRn> OrderZT_SeisanDHaneiTuutiRnByPkDesc(List<ZT_SeisanDHaneiTuutiRn> pEntity) {
        List<SortCondition<ZT_SeisanDHaneiTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeisanDHaneiTuutiRn()).zrnkeysyono, SortOrder.DESC));
        List<ZT_SeisanDHaneiTuutiRn> copyList = new ArrayList<ZT_SeisanDHaneiTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SeisanDHaneiTuutiRn(orders));
        return copyList;
    }
}
