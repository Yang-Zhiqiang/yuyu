package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr3Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr3Rn;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr3Rn;

public class SortZT_Skeiksnbsgetujisr3Rn {

    
    public List<ZT_Skeiksnbsgetujisr3Rn> OrderZT_Skeiksnbsgetujisr3RnByPkAsc(List<ZT_Skeiksnbsgetujisr3Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr3Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr3Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr3Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr3Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr3Rn(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr3Rn> OrderZT_Skeiksnbsgetujisr3RnByPkDesc(List<ZT_Skeiksnbsgetujisr3Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr3Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr3Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr3Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr3Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr3Rn(orders));
        return copyList;
    }
}
