package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuRn;
import yuyu.def.zdb.comparator.OrderZT_RrtHndugtHknVKnsyuyuRn;

public class SortZT_RrtHndugtHknVKnsyuyuRn {

    
    public List<ZT_RrtHndugtHknVKnsyuyuRn> OrderZT_RrtHndugtHknVKnsyuyuRnByPkAsc(List<ZT_RrtHndugtHknVKnsyuyuRn> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknVKnsyuyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknVKnsyuyuRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_RrtHndugtHknVKnsyuyuRn> copyList = new ArrayList<ZT_RrtHndugtHknVKnsyuyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknVKnsyuyuRn(orders));
        return copyList;
    }

    
    public List<ZT_RrtHndugtHknVKnsyuyuRn> OrderZT_RrtHndugtHknVKnsyuyuRnByPkDesc(List<ZT_RrtHndugtHknVKnsyuyuRn> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknVKnsyuyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknVKnsyuyuRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_RrtHndugtHknVKnsyuyuRn> copyList = new ArrayList<ZT_RrtHndugtHknVKnsyuyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknVKnsyuyuRn(orders));
        return copyList;
    }
}
