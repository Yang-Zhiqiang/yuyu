package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiRn;
import yuyu.def.zdb.comparator.OrderZT_GaikaKokyakuTuutiRn;

public class SortZT_GaikaKokyakuTuutiRn {

    
    public List<ZT_GaikaKokyakuTuutiRn> OrderZT_GaikaKokyakuTuutiRnByPkAsc(List<ZT_GaikaKokyakuTuutiRn> pEntity) {
        List<SortCondition<ZT_GaikaKokyakuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_GaikaKokyakuTuutiRn> copyList = new ArrayList<ZT_GaikaKokyakuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GaikaKokyakuTuutiRn(orders));
        return copyList;
    }

    
    public List<ZT_GaikaKokyakuTuutiRn> OrderZT_GaikaKokyakuTuutiRnByPkDesc(List<ZT_GaikaKokyakuTuutiRn> pEntity) {
        List<SortCondition<ZT_GaikaKokyakuTuutiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_GaikaKokyakuTuutiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_GaikaKokyakuTuutiRn> copyList = new ArrayList<ZT_GaikaKokyakuTuutiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_GaikaKokyakuTuutiRn(orders));
        return copyList;
    }
}
