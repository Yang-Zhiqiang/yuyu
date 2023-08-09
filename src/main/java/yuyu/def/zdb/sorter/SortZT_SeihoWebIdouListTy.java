package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.QZT_SeihoWebIdouListTy;
import yuyu.def.zdb.comparator.OrderZT_SeihoWebIdouListTy;

public class SortZT_SeihoWebIdouListTy {

    
    public List<ZT_SeihoWebIdouListTy> OrderZT_SeihoWebIdouListTyByPkAsc(List<ZT_SeihoWebIdouListTy> pEntity) {
        List<SortCondition<ZT_SeihoWebIdouListTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztysakuseiymd7keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztybsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztytntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztyhasseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztyidoukbn1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztykydatkikbnkj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztykykyymm, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztycifcd, SortOrder.ASC));
        List<ZT_SeihoWebIdouListTy> copyList = new ArrayList<ZT_SeihoWebIdouListTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SeihoWebIdouListTy(orders));
        return copyList;
    }

    
    public List<ZT_SeihoWebIdouListTy> OrderZT_SeihoWebIdouListTyByPkDesc(List<ZT_SeihoWebIdouListTy> pEntity) {
        List<SortCondition<ZT_SeihoWebIdouListTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztysakuseiymd7keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztybsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztytntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztyhasseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztyidoukbn1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztykydatkikbnkj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztykykyymm, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SeihoWebIdouListTy()).ztycifcd, SortOrder.DESC));
        List<ZT_SeihoWebIdouListTy> copyList = new ArrayList<ZT_SeihoWebIdouListTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SeihoWebIdouListTy(orders));
        return copyList;
    }
}
