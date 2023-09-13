package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;
import yuyu.def.db.meta.QIT_DSeisanTuibaraiKanri;
import yuyu.def.hozen.comparator.OrderIT_DSeisanTuibaraiKanri;

public class SortIT_DSeisanTuibaraiKanri {

    public List<IT_DSeisanTuibaraiKanri> OrderIT_DSeisanTuibaraiKanriByPkAsc(List<IT_DSeisanTuibaraiKanri> pEntity) {
        List<SortCondition<IT_DSeisanTuibaraiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DSeisanTuibaraiKanri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DSeisanTuibaraiKanri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DSeisanTuibaraiKanri()).haitounendo, SortOrder.ASC));
        List<IT_DSeisanTuibaraiKanri> copyList = new ArrayList<IT_DSeisanTuibaraiKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_DSeisanTuibaraiKanri(orders));
        return copyList;
    }

    public List<IT_DSeisanTuibaraiKanri> OrderIT_DSeisanTuibaraiKanriByPkDesc(List<IT_DSeisanTuibaraiKanri> pEntity) {
        List<SortCondition<IT_DSeisanTuibaraiKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DSeisanTuibaraiKanri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DSeisanTuibaraiKanri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DSeisanTuibaraiKanri()).haitounendo, SortOrder.DESC));
        List<IT_DSeisanTuibaraiKanri> copyList = new ArrayList<IT_DSeisanTuibaraiKanri>(pEntity);
        Collections.sort(copyList, new OrderIT_DSeisanTuibaraiKanri(orders));
        return copyList;
    }
}
