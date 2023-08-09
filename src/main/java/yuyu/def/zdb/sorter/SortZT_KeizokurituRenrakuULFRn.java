package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFRn;
import yuyu.def.zdb.comparator.OrderZT_KeizokurituRenrakuULFRn;

public class SortZT_KeizokurituRenrakuULFRn {

    
    public List<ZT_KeizokurituRenrakuULFRn> OrderZT_KeizokurituRenrakuULFRnByPkAsc(List<ZT_KeizokurituRenrakuULFRn> pEntity) {
        List<SortCondition<ZT_KeizokurituRenrakuULFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KeizokurituRenrakuULFRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_KeizokurituRenrakuULFRn> copyList = new ArrayList<ZT_KeizokurituRenrakuULFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KeizokurituRenrakuULFRn(orders));
        return copyList;
    }

    
    public List<ZT_KeizokurituRenrakuULFRn> OrderZT_KeizokurituRenrakuULFRnByPkDesc(List<ZT_KeizokurituRenrakuULFRn> pEntity) {
        List<SortCondition<ZT_KeizokurituRenrakuULFRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KeizokurituRenrakuULFRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_KeizokurituRenrakuULFRn> copyList = new ArrayList<ZT_KeizokurituRenrakuULFRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KeizokurituRenrakuULFRn(orders));
        return copyList;
    }
}
