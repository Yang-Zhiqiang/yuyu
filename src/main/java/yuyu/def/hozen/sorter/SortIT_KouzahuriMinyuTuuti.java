package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.QIT_KouzahuriMinyuTuuti;
import yuyu.def.hozen.comparator.OrderIT_KouzahuriMinyuTuuti;

public class SortIT_KouzahuriMinyuTuuti {

    public List<IT_KouzahuriMinyuTuuti> OrderIT_KouzahuriMinyuTuutiByPkAsc(List<IT_KouzahuriMinyuTuuti> pEntity) {
        List<SortCondition<IT_KouzahuriMinyuTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzahuriMinyuTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzahuriMinyuTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KouzahuriMinyuTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_KouzahuriMinyuTuuti> copyList = new ArrayList<IT_KouzahuriMinyuTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzahuriMinyuTuuti(orders));
        return copyList;
    }

    public List<IT_KouzahuriMinyuTuuti> OrderIT_KouzahuriMinyuTuutiByPkDesc(List<IT_KouzahuriMinyuTuuti> pEntity) {
        List<SortCondition<IT_KouzahuriMinyuTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KouzahuriMinyuTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzahuriMinyuTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KouzahuriMinyuTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_KouzahuriMinyuTuuti> copyList = new ArrayList<IT_KouzahuriMinyuTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_KouzahuriMinyuTuuti(orders));
        return copyList;
    }

}

