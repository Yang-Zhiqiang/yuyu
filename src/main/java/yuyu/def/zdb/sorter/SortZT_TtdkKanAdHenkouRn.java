package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouRn;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouRn;
import yuyu.def.zdb.comparator.OrderZT_TtdkKanAdHenkouRn;

public class SortZT_TtdkKanAdHenkouRn {

    
    public List<ZT_TtdkKanAdHenkouRn> OrderZT_TtdkKanAdHenkouRnByPkAsc(List<ZT_TtdkKanAdHenkouRn> pEntity) {
        List<SortCondition<ZT_TtdkKanAdHenkouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouRn()).zrnsikibetuno, SortOrder.ASC));
        List<ZT_TtdkKanAdHenkouRn> copyList = new ArrayList<ZT_TtdkKanAdHenkouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanAdHenkouRn(orders));
        return copyList;
    }

    
    public List<ZT_TtdkKanAdHenkouRn> OrderZT_TtdkKanAdHenkouRnByPkDesc(List<ZT_TtdkKanAdHenkouRn> pEntity) {
        List<SortCondition<ZT_TtdkKanAdHenkouRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TtdkKanAdHenkouRn()).zrnsikibetuno, SortOrder.DESC));
        List<ZT_TtdkKanAdHenkouRn> copyList = new ArrayList<ZT_TtdkKanAdHenkouRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TtdkKanAdHenkouRn(orders));
        return copyList;
    }
}
