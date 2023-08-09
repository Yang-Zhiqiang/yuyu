package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.def.zdb.comparator.OrderZT_SrKbkSsuRnduHknVKnsyuyuTy;

public class SortZT_SrKbkSsuRnduHknVKnsyuyuTy {

    
    public List<ZT_SrKbkSsuRnduHknVKnsyuyuTy> OrderZT_SrKbkSsuRnduHknVKnsyuyuTyByPkAsc(List<ZT_SrKbkSsuRnduHknVKnsyuyuTy> pEntity) {
        List<SortCondition<ZT_SrKbkSsuRnduHknVKnsyuyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SrKbkSsuRnduHknVKnsyuyuTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_SrKbkSsuRnduHknVKnsyuyuTy> copyList = new ArrayList<ZT_SrKbkSsuRnduHknVKnsyuyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SrKbkSsuRnduHknVKnsyuyuTy(orders));
        return copyList;
    }

    
    public List<ZT_SrKbkSsuRnduHknVKnsyuyuTy> OrderZT_SrKbkSsuRnduHknVKnsyuyuTyByPkDesc(List<ZT_SrKbkSsuRnduHknVKnsyuyuTy> pEntity) {
        List<SortCondition<ZT_SrKbkSsuRnduHknVKnsyuyuTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SrKbkSsuRnduHknVKnsyuyuTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_SrKbkSsuRnduHknVKnsyuyuTy> copyList = new ArrayList<ZT_SrKbkSsuRnduHknVKnsyuyuTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SrKbkSsuRnduHknVKnsyuyuTy(orders));
        return copyList;
    }
}
