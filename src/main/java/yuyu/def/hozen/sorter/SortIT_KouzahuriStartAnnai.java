package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import yuyu.def.db.meta.QIT_KouzahuriStartAnnai;
import yuyu.def.hozen.comparator.OrderIT_KouzahuriStartAnnai;

public class SortIT_KouzahuriStartAnnai {

    public List<IT_KouzahuriStartAnnai> OrderIT_KouzahuriStartAnnaiByPkAsc(List<IT_KouzahuriStartAnnai> pEntity) {
        List<SortCondition<IT_KouzahuriStartAnnai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzahuriStartAnnai()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzahuriStartAnnai()).syono, SortOrder.ASC));
        List<IT_KouzahuriStartAnnai> copyList = new ArrayList<IT_KouzahuriStartAnnai>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzahuriStartAnnai(orders));
        return copyList;
    }

    public List<IT_KouzahuriStartAnnai> OrderIT_KouzahuriStartAnnaiByPkDesc(List<IT_KouzahuriStartAnnai> pEntity) {
        List<SortCondition<IT_KouzahuriStartAnnai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzahuriStartAnnai()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzahuriStartAnnai()).syono, SortOrder.DESC));
        List<IT_KouzahuriStartAnnai> copyList = new ArrayList<IT_KouzahuriStartAnnai>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzahuriStartAnnai(orders));
        return copyList;
    }

}

