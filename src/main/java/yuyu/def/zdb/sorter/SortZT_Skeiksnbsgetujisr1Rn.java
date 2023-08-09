package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr1Rn;

public class SortZT_Skeiksnbsgetujisr1Rn {

    
    public List<ZT_Skeiksnbsgetujisr1Rn> OrderZT_Skeiksnbsgetujisr1RnByPkAsc(List<ZT_Skeiksnbsgetujisr1Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr1Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr1Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr1Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr1Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr1Rn(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr1Rn> OrderZT_Skeiksnbsgetujisr1RnByPkDesc(List<ZT_Skeiksnbsgetujisr1Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr1Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr1Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr1Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr1Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr1Rn(orders));
        return copyList;
    }
}
