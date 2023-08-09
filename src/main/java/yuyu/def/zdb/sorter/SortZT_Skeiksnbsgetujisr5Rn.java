package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr5Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr5Rn;
import yuyu.def.zdb.comparator.OrderZT_Skeiksnbsgetujisr5Rn;

public class SortZT_Skeiksnbsgetujisr5Rn {

    
    public List<ZT_Skeiksnbsgetujisr5Rn> OrderZT_Skeiksnbsgetujisr5RnByPkAsc(List<ZT_Skeiksnbsgetujisr5Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr5Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr5Rn()).zrnktgysyono, SortOrder.ASC));
        List<ZT_Skeiksnbsgetujisr5Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr5Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr5Rn(orders));
        return copyList;
    }

    
    public List<ZT_Skeiksnbsgetujisr5Rn> OrderZT_Skeiksnbsgetujisr5RnByPkDesc(List<ZT_Skeiksnbsgetujisr5Rn> pEntity) {
        List<SortCondition<ZT_Skeiksnbsgetujisr5Rn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_Skeiksnbsgetujisr5Rn()).zrnktgysyono, SortOrder.DESC));
        List<ZT_Skeiksnbsgetujisr5Rn> copyList = new ArrayList<ZT_Skeiksnbsgetujisr5Rn>(pEntity);
        Collections.sort(copyList, new OrderZT_Skeiksnbsgetujisr5Rn(orders));
        return copyList;
    }
}
