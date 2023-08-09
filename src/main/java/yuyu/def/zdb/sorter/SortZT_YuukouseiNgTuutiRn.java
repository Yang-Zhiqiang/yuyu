package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_YuukouseiNgTuutiRn;

public class SortZT_YuukouseiNgTuutiRn {

    
    public List<ZT_YuukouseiNgTuutiRn> OrderZT_YuukouseiNgTuutiRnByPkAsc(List<ZT_YuukouseiNgTuutiRn> pEntity) {
        List<SortCondition<ZT_YuukouseiNgTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_YuukouseiNgTuutiRn> copyList = new ArrayList<ZT_YuukouseiNgTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouseiNgTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_YuukouseiNgTuutiRn> OrderZT_YuukouseiNgTuutiRnByPkDesc(List<ZT_YuukouseiNgTuutiRn> pEntity) {
        List<SortCondition<ZT_YuukouseiNgTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuukouseiNgTuutiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_YuukouseiNgTuutiRn> copyList = new ArrayList<ZT_YuukouseiNgTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YuukouseiNgTuutiRn(orders));
        return copyList;
    }
}
