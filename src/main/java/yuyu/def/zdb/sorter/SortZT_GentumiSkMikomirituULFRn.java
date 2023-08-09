package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFRn;
import yuyu.def.db.meta.QZT_GentumiSkMikomirituULFRn;
import yuyu.def.zdb.comparator.OrderZT_GentumiSkMikomirituULFRn;

public class SortZT_GentumiSkMikomirituULFRn {

    
    public List<ZT_GentumiSkMikomirituULFRn> OrderZT_GentumiSkMikomirituULFRnByPkAsc(List<ZT_GentumiSkMikomirituULFRn> pEntity) {
        List<SortCondition<ZT_GentumiSkMikomirituULFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GentumiSkMikomirituULFRn()).zrndatakanrino, SortOrder.ASC));
        List<ZT_GentumiSkMikomirituULFRn> copyList = new ArrayList<ZT_GentumiSkMikomirituULFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GentumiSkMikomirituULFRn(orders));
        return copyList;
    }

    
    public List<ZT_GentumiSkMikomirituULFRn> OrderZT_GentumiSkMikomirituULFRnByPkDesc(List<ZT_GentumiSkMikomirituULFRn> pEntity) {
        List<SortCondition<ZT_GentumiSkMikomirituULFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GentumiSkMikomirituULFRn()).zrndatakanrino, SortOrder.DESC));
        List<ZT_GentumiSkMikomirituULFRn> copyList = new ArrayList<ZT_GentumiSkMikomirituULFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GentumiSkMikomirituULFRn(orders));
        return copyList;
    }
}