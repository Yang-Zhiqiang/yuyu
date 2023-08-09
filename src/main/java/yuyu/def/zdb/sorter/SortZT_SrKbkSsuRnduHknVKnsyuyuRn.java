package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.db.meta.QZT_SrKbkSsuRnduHknVKnsyuyuRn;
import yuyu.def.zdb.comparator.OrderZT_SrKbkSsuRnduHknVKnsyuyuRn;

public class SortZT_SrKbkSsuRnduHknVKnsyuyuRn {

    
    public List<ZT_SrKbkSsuRnduHknVKnsyuyuRn> OrderZT_SrKbkSsuRnduHknVKnsyuyuRnByPkAsc(List<ZT_SrKbkSsuRnduHknVKnsyuyuRn> pEntity) {
        List<SortCondition<ZT_SrKbkSsuRnduHknVKnsyuyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SrKbkSsuRnduHknVKnsyuyuRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_SrKbkSsuRnduHknVKnsyuyuRn> copyList = new ArrayList<ZT_SrKbkSsuRnduHknVKnsyuyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SrKbkSsuRnduHknVKnsyuyuRn(orders));
        return copyList;
    }

    
    public List<ZT_SrKbkSsuRnduHknVKnsyuyuRn> OrderZT_SrKbkSsuRnduHknVKnsyuyuRnByPkDesc(List<ZT_SrKbkSsuRnduHknVKnsyuyuRn> pEntity) {
        List<SortCondition<ZT_SrKbkSsuRnduHknVKnsyuyuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SrKbkSsuRnduHknVKnsyuyuRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_SrKbkSsuRnduHknVKnsyuyuRn> copyList = new ArrayList<ZT_SrKbkSsuRnduHknVKnsyuyuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SrKbkSsuRnduHknVKnsyuyuRn(orders));
        return copyList;
    }
}
