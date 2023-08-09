package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkRn;
import yuyu.def.zdb.comparator.OrderZT_KyhknShrJyoukyouRnrkRn;

public class SortZT_KyhknShrJyoukyouRnrkRn {

    
    public List<ZT_KyhknShrJyoukyouRnrkRn> OrderZT_KyhknShrJyoukyouRnrkRnByPkAsc(List<ZT_KyhknShrJyoukyouRnrkRn> pEntity) {
        List<SortCondition<ZT_KyhknShrJyoukyouRnrkRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KyhknShrJyoukyouRnrkRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KyhknShrJyoukyouRnrkRn> copyList = new ArrayList<ZT_KyhknShrJyoukyouRnrkRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KyhknShrJyoukyouRnrkRn(orders));
        return copyList;
    }

    
    public List<ZT_KyhknShrJyoukyouRnrkRn> OrderZT_KyhknShrJyoukyouRnrkRnByPkDesc(List<ZT_KyhknShrJyoukyouRnrkRn> pEntity) {
        List<SortCondition<ZT_KyhknShrJyoukyouRnrkRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KyhknShrJyoukyouRnrkRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KyhknShrJyoukyouRnrkRn> copyList = new ArrayList<ZT_KyhknShrJyoukyouRnrkRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KyhknShrJyoukyouRnrkRn(orders));
        return copyList;
    }
}
