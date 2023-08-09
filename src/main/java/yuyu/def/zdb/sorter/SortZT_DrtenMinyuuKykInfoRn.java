package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoRn;
import yuyu.def.zdb.comparator.OrderZT_DrtenMinyuuKykInfoRn;

public class SortZT_DrtenMinyuuKykInfoRn {

    
    public List<ZT_DrtenMinyuuKykInfoRn> OrderZT_DrtenMinyuuKykInfoRnByPkAsc(List<ZT_DrtenMinyuuKykInfoRn> pEntity) {
        List<SortCondition<ZT_DrtenMinyuuKykInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuuKykInfoRn()).zrnsyono, SortOrder.ASC));
        List<ZT_DrtenMinyuuKykInfoRn> copyList = new ArrayList<ZT_DrtenMinyuuKykInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuuKykInfoRn(orders));
        return copyList;
    }

    
    public List<ZT_DrtenMinyuuKykInfoRn> OrderZT_DrtenMinyuuKykInfoRnByPkDesc(List<ZT_DrtenMinyuuKykInfoRn> pEntity) {
        List<SortCondition<ZT_DrtenMinyuuKykInfoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuuKykInfoRn()).zrnsyono, SortOrder.DESC));
        List<ZT_DrtenMinyuuKykInfoRn> copyList = new ArrayList<ZT_DrtenMinyuuKykInfoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuuKykInfoRn(orders));
        return copyList;
    }
}
