package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyainMeiboRn;
import yuyu.def.db.meta.QZT_SyainMeiboRn;
import yuyu.def.zdb.comparator.OrderZT_SyainMeiboRn;

public class SortZT_SyainMeiboRn {

    
    public List<ZT_SyainMeiboRn> OrderZT_SyainMeiboRnByPkAsc(List<ZT_SyainMeiboRn> pEntity) {
        List<SortCondition<ZT_SyainMeiboRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyainMeiboRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SyainMeiboRn> copyList = new ArrayList<ZT_SyainMeiboRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyainMeiboRn(orders));
        return copyList;
    }

    
    public List<ZT_SyainMeiboRn> OrderZT_SyainMeiboRnByPkDesc(List<ZT_SyainMeiboRn> pEntity) {
        List<SortCondition<ZT_SyainMeiboRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyainMeiboRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SyainMeiboRn> copyList = new ArrayList<ZT_SyainMeiboRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyainMeiboRn(orders));
        return copyList;
    }
}
