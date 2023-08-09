package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.def.zdb.comparator.OrderZT_RrtHndugtHknVKnsyuyuTy;

public class SortZT_RrtHndugtHknVKnsyuyuTy {

    
    public List<ZT_RrtHndugtHknVKnsyuyuTy> OrderZT_RrtHndugtHknVKnsyuyuTyByPkAsc(List<ZT_RrtHndugtHknVKnsyuyuTy> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknVKnsyuyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknVKnsyuyuTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_RrtHndugtHknVKnsyuyuTy> copyList = new ArrayList<ZT_RrtHndugtHknVKnsyuyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknVKnsyuyuTy(orders));
        return copyList;
    }

    
    public List<ZT_RrtHndugtHknVKnsyuyuTy> OrderZT_RrtHndugtHknVKnsyuyuTyByPkDesc(List<ZT_RrtHndugtHknVKnsyuyuTy> pEntity) {
        List<SortCondition<ZT_RrtHndugtHknVKnsyuyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_RrtHndugtHknVKnsyuyuTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_RrtHndugtHknVKnsyuyuTy> copyList = new ArrayList<ZT_RrtHndugtHknVKnsyuyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_RrtHndugtHknVKnsyuyuTy(orders));
        return copyList;
    }
}
