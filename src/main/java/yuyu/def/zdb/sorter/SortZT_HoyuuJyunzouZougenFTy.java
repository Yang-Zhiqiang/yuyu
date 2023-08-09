package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HoyuuJyunzouZougenFTy;
import yuyu.def.db.meta.QZT_HoyuuJyunzouZougenFTy;
import yuyu.def.zdb.comparator.OrderZT_HoyuuJyunzouZougenFTy;

public class SortZT_HoyuuJyunzouZougenFTy {

    
    public List<ZT_HoyuuJyunzouZougenFTy> OrderZT_HoyuuJyunzouZougenFTyByPkAsc(List<ZT_HoyuuJyunzouZougenFTy> pEntity) {
        List<SortCondition<ZT_HoyuuJyunzouZougenFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuJyunzouZougenFTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_HoyuuJyunzouZougenFTy> copyList = new ArrayList<ZT_HoyuuJyunzouZougenFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuJyunzouZougenFTy(orders));
        return copyList;
    }

    
    public List<ZT_HoyuuJyunzouZougenFTy> OrderZT_HoyuuJyunzouZougenFTyByPkDesc(List<ZT_HoyuuJyunzouZougenFTy> pEntity) {
        List<SortCondition<ZT_HoyuuJyunzouZougenFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HoyuuJyunzouZougenFTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_HoyuuJyunzouZougenFTy> copyList = new ArrayList<ZT_HoyuuJyunzouZougenFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_HoyuuJyunzouZougenFTy(orders));
        return copyList;
    }
}
