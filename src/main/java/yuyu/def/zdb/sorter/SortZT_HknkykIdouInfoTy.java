package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.QZT_HknkykIdouInfoTy;
import yuyu.def.zdb.comparator.OrderZT_HknkykIdouInfoTy;

public class SortZT_HknkykIdouInfoTy {

    
    public List<ZT_HknkykIdouInfoTy> OrderZT_HknkykIdouInfoTyByPkAsc(List<ZT_HknkykIdouInfoTy> pEntity) {
        List<SortCondition<ZT_HknkykIdouInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztykyktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztyidouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztyidoujiyuukbnzfi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztydatakanrino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztyrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztytumitatekinkbn, SortOrder.ASC));
        List<ZT_HknkykIdouInfoTy> copyList = new ArrayList<ZT_HknkykIdouInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HknkykIdouInfoTy(orders));
        return copyList;
    }

    
    public List<ZT_HknkykIdouInfoTy> OrderZT_HknkykIdouInfoTyByPkDesc(List<ZT_HknkykIdouInfoTy> pEntity) {
        List<SortCondition<ZT_HknkykIdouInfoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztykyktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztyidouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztyidoujiyuukbnzfi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztydatakanrino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztyrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HknkykIdouInfoTy()).ztytumitatekinkbn, SortOrder.DESC));
        List<ZT_HknkykIdouInfoTy> copyList = new ArrayList<ZT_HknkykIdouInfoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HknkykIdouInfoTy(orders));
        return copyList;
    }
}
