package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HsgbnktAnnaihouhoukanri;
import yuyu.def.db.meta.QIT_HsgbnktAnnaihouhoukanri;
import yuyu.def.hozen.comparator.OrderIT_HsgbnktAnnaihouhoukanri;

public class SortIT_HsgbnktAnnaihouhoukanri {

    public List<IT_HsgbnktAnnaihouhoukanri> OrderIT_HsgbnktAnnaihouhoukanriByPkAsc(
        List<IT_HsgbnktAnnaihouhoukanri> pEntity) {
        List<SortCondition<IT_HsgbnktAnnaihouhoukanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HsgbnktAnnaihouhoukanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HsgbnktAnnaihouhoukanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HsgbnktAnnaihouhoukanri()).hsgymd, SortOrder.ASC));
        List<IT_HsgbnktAnnaihouhoukanri> copyList = new ArrayList<IT_HsgbnktAnnaihouhoukanri>(pEntity);
        Collections.sort(copyList, new OrderIT_HsgbnktAnnaihouhoukanri(orders));
        return copyList;
    }

    public List<IT_HsgbnktAnnaihouhoukanri> OrderIT_HsgbnktAnnaihouhoukanriByPkDesc(
        List<IT_HsgbnktAnnaihouhoukanri> pEntity) {
        List<SortCondition<IT_HsgbnktAnnaihouhoukanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HsgbnktAnnaihouhoukanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HsgbnktAnnaihouhoukanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HsgbnktAnnaihouhoukanri()).hsgymd, SortOrder.DESC));
        List<IT_HsgbnktAnnaihouhoukanri> copyList = new ArrayList<IT_HsgbnktAnnaihouhoukanri>(pEntity);
        Collections.sort(copyList, new OrderIT_HsgbnktAnnaihouhoukanri(orders));
        return copyList;
    }
}
