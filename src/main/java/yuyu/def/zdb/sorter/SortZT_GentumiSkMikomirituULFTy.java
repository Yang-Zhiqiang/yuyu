package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFTy;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFTy;
import yuyu.def.zdb.comparator.OrderZT_GentumiSkMikomirituULFTy;

public class SortZT_GentumiSkMikomirituULFTy {

    
    public List<ZT_GentumiSkMikomirituULFTy> OrderZT_GentumiSkMikomirituULFTyByPkAsc(List<ZT_GentumiSkMikomirituULFTy> pEntity) {
        List<SortCondition<ZT_GentumiSkMikomirituULFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GentumiSkMikomirituULFTy()).ztydatakanrino, SortOrder.ASC));
        List<ZT_GentumiSkMikomirituULFTy> copyList = new ArrayList<ZT_GentumiSkMikomirituULFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GentumiSkMikomirituULFTy(orders));
        return copyList;
    }

    
    public List<ZT_GentumiSkMikomirituULFTy> OrderZT_GentumiSkMikomirituULFTyByPkDesc(List<ZT_GentumiSkMikomirituULFTy> pEntity) {
        List<SortCondition<ZT_GentumiSkMikomirituULFTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GentumiSkMikomirituULFTy()).ztydatakanrino, SortOrder.DESC));
        List<ZT_GentumiSkMikomirituULFTy> copyList = new ArrayList<ZT_GentumiSkMikomirituULFTy>(pEntity);
        Collections.sort(copyList, new OrderZT_GentumiSkMikomirituULFTy(orders));
        return copyList;
    }
}