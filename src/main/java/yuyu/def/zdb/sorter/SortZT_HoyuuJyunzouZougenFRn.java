package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFRn;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFRn;
import yuyu.def.zdb.comparator.OrderZT_HoyuuJyunzouZougenFRn;

public class SortZT_HoyuuJyunzouZougenFRn {

    
    public List<ZT_HoyuuJyunzouZougenFRn> OrderZT_HoyuuJyunzouZougenFRnByPkAsc(List<ZT_HoyuuJyunzouZougenFRn> pEntity) {
        List<SortCondition<ZT_HoyuuJyunzouZougenFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuJyunzouZougenFRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_HoyuuJyunzouZougenFRn> copyList = new ArrayList<ZT_HoyuuJyunzouZougenFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuJyunzouZougenFRn(orders));
        return copyList;
    }

    
    public List<ZT_HoyuuJyunzouZougenFRn> OrderZT_HoyuuJyunzouZougenFRnByPkDesc(List<ZT_HoyuuJyunzouZougenFRn> pEntity) {
        List<SortCondition<ZT_HoyuuJyunzouZougenFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuJyunzouZougenFRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_HoyuuJyunzouZougenFRn> copyList = new ArrayList<ZT_HoyuuJyunzouZougenFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuJyunzouZougenFRn(orders));
        return copyList;
    }
}
