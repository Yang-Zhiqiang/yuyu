package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.QZT_AiKyuubuByoumeiRn;
import yuyu.def.zdb.comparator.OrderZT_AiKyuubuByoumeiRn;

public class SortZT_AiKyuubuByoumeiRn {

    
    public List<ZT_AiKyuubuByoumeiRn> OrderZT_AiKyuubuByoumeiRnByPkAsc(List<ZT_AiKyuubuByoumeiRn> pEntity) {
        List<SortCondition<ZT_AiKyuubuByoumeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AiKyuubuByoumeiRn()).zrnbyoumeitourokuno, SortOrder.ASC));
        List<ZT_AiKyuubuByoumeiRn> copyList = new ArrayList<ZT_AiKyuubuByoumeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AiKyuubuByoumeiRn(orders));
        return copyList;
    }

    
    public List<ZT_AiKyuubuByoumeiRn> OrderZT_AiKyuubuByoumeiRnByPkDesc(List<ZT_AiKyuubuByoumeiRn> pEntity) {
        List<SortCondition<ZT_AiKyuubuByoumeiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_AiKyuubuByoumeiRn()).zrnbyoumeitourokuno, SortOrder.DESC));
        List<ZT_AiKyuubuByoumeiRn> copyList = new ArrayList<ZT_AiKyuubuByoumeiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_AiKyuubuByoumeiRn(orders));
        return copyList;
    }
}
