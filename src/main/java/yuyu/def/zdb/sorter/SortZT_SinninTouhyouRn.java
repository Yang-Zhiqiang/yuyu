package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinninTouhyouRn;
import yuyu.def.db.meta.QZT_SinninTouhyouRn;
import yuyu.def.zdb.comparator.OrderZT_SinninTouhyouRn;

public class SortZT_SinninTouhyouRn {

    
    public List<ZT_SinninTouhyouRn> OrderZT_SinninTouhyouRnByPkAsc(List<ZT_SinninTouhyouRn> pEntity) {
        List<SortCondition<ZT_SinninTouhyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinninTouhyouRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SinninTouhyouRn> copyList = new ArrayList<ZT_SinninTouhyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinninTouhyouRn(orders));
        return copyList;
    }

    
    public List<ZT_SinninTouhyouRn> OrderZT_SinninTouhyouRnByPkDesc(List<ZT_SinninTouhyouRn> pEntity) {
        List<SortCondition<ZT_SinninTouhyouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinninTouhyouRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SinninTouhyouRn> copyList = new ArrayList<ZT_SinninTouhyouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SinninTouhyouRn(orders));
        return copyList;
    }
}
