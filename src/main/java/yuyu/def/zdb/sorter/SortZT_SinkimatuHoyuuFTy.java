package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SinkimatuHoyuuFTy;
import yuyu.def.db.meta.QZT_SinkimatuHoyuuFTy;
import yuyu.def.zdb.comparator.OrderZT_SinkimatuHoyuuFTy;

public class SortZT_SinkimatuHoyuuFTy {

    
    public List<ZT_SinkimatuHoyuuFTy> OrderZT_SinkimatuHoyuuFTyByPkAsc(List<ZT_SinkimatuHoyuuFTy> pEntity) {
        List<SortCondition<ZT_SinkimatuHoyuuFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkimatuHoyuuFTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_SinkimatuHoyuuFTy> copyList = new ArrayList<ZT_SinkimatuHoyuuFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkimatuHoyuuFTy(orders));
        return copyList;
    }

    
    public List<ZT_SinkimatuHoyuuFTy> OrderZT_SinkimatuHoyuuFTyByPkDesc(List<ZT_SinkimatuHoyuuFTy> pEntity) {
        List<SortCondition<ZT_SinkimatuHoyuuFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SinkimatuHoyuuFTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_SinkimatuHoyuuFTy> copyList = new ArrayList<ZT_SinkimatuHoyuuFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SinkimatuHoyuuFTy(orders));
        return copyList;
    }
}
