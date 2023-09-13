package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.meta.QIT_KijituTouraiAnnai;
import yuyu.def.hozen.comparator.OrderIT_KijituTouraiAnnai;

public class SortIT_KijituTouraiAnnai {

    public List<IT_KijituTouraiAnnai> OrderIT_KijituTouraiAnnaiByPkAsc(List<IT_KijituTouraiAnnai> pEntity) {
        List<SortCondition<IT_KijituTouraiAnnai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KijituTouraiAnnai()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KijituTouraiAnnai()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KijituTouraiAnnai()).tyouhyouymd, SortOrder.ASC));
        List<IT_KijituTouraiAnnai> copyList = new ArrayList<IT_KijituTouraiAnnai>(pEntity);
        Collections.sort(copyList, new OrderIT_KijituTouraiAnnai(orders));
        return copyList;
    }

    public List<IT_KijituTouraiAnnai> OrderIT_KijituTouraiAnnaiByPkDesc(List<IT_KijituTouraiAnnai> pEntity) {
        List<SortCondition<IT_KijituTouraiAnnai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KijituTouraiAnnai()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KijituTouraiAnnai()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KijituTouraiAnnai()).tyouhyouymd, SortOrder.DESC));
        List<IT_KijituTouraiAnnai> copyList = new ArrayList<IT_KijituTouraiAnnai>(pEntity);
        Collections.sort(copyList, new OrderIT_KijituTouraiAnnai(orders));
        return copyList;
    }

}

