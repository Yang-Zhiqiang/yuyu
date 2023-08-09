package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DattaiTuutiKzhuriRn;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriRn;
import yuyu.def.zdb.comparator.OrderZT_DattaiTuutiKzhuriRn;

public class SortZT_DattaiTuutiKzhuriRn {

    
    public List<ZT_DattaiTuutiKzhuriRn> OrderZT_DattaiTuutiKzhuriRnByPkAsc(List<ZT_DattaiTuutiKzhuriRn> pEntity) {
        List<SortCondition<ZT_DattaiTuutiKzhuriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriRn()).zrnsyono, SortOrder.ASC));
        List<ZT_DattaiTuutiKzhuriRn> copyList = new ArrayList<ZT_DattaiTuutiKzhuriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DattaiTuutiKzhuriRn(orders));
        return copyList;
    }

    
    public List<ZT_DattaiTuutiKzhuriRn> OrderZT_DattaiTuutiKzhuriRnByPkDesc(List<ZT_DattaiTuutiKzhuriRn> pEntity) {
        List<SortCondition<ZT_DattaiTuutiKzhuriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriRn()).zrnsyono, SortOrder.DESC));
        List<ZT_DattaiTuutiKzhuriRn> copyList = new ArrayList<ZT_DattaiTuutiKzhuriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DattaiTuutiKzhuriRn(orders));
        return copyList;
    }
}
