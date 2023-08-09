package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFTy;
import yuyu.def.zdb.comparator.OrderZT_KeizokurituRenrakuULFTy;

public class SortZT_KeizokurituRenrakuULFTy {

    
    public List<ZT_KeizokurituRenrakuULFTy> OrderZT_KeizokurituRenrakuULFTyByPkAsc(List<ZT_KeizokurituRenrakuULFTy> pEntity) {
        List<SortCondition<ZT_KeizokurituRenrakuULFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KeizokurituRenrakuULFTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_KeizokurituRenrakuULFTy> copyList = new ArrayList<ZT_KeizokurituRenrakuULFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KeizokurituRenrakuULFTy(orders));
        return copyList;
    }

    
    public List<ZT_KeizokurituRenrakuULFTy> OrderZT_KeizokurituRenrakuULFTyByPkDesc(List<ZT_KeizokurituRenrakuULFTy> pEntity) {
        List<SortCondition<ZT_KeizokurituRenrakuULFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KeizokurituRenrakuULFTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_KeizokurituRenrakuULFTy> copyList = new ArrayList<ZT_KeizokurituRenrakuULFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KeizokurituRenrakuULFTy(orders));
        return copyList;
    }
}
