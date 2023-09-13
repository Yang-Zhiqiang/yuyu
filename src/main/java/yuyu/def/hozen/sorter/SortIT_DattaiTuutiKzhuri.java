package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_DattaiTuutiKzhuri;
import yuyu.def.db.meta.QIT_DattaiTuutiKzhuri;
import yuyu.def.hozen.comparator.OrderIT_DattaiTuutiKzhuri;

public class SortIT_DattaiTuutiKzhuri {

    public List<IT_DattaiTuutiKzhuri> OrderIT_DattaiTuutiKzhuriByPkAsc(List<IT_DattaiTuutiKzhuri> pEntity) {
        List<SortCondition<IT_DattaiTuutiKzhuri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DattaiTuutiKzhuri()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DattaiTuutiKzhuri()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DattaiTuutiKzhuri()).tyouhyouymd, SortOrder.ASC));
        List<IT_DattaiTuutiKzhuri> copyList = new ArrayList<IT_DattaiTuutiKzhuri>(pEntity);
        Collections.sort(copyList, new OrderIT_DattaiTuutiKzhuri(orders));
        return copyList;
    }

    public List<IT_DattaiTuutiKzhuri> OrderIT_DattaiTuutiKzhuriByPkDesc(List<IT_DattaiTuutiKzhuri> pEntity) {
        List<SortCondition<IT_DattaiTuutiKzhuri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DattaiTuutiKzhuri()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DattaiTuutiKzhuri()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DattaiTuutiKzhuri()).tyouhyouymd, SortOrder.DESC));
        List<IT_DattaiTuutiKzhuri> copyList = new ArrayList<IT_DattaiTuutiKzhuri>(pEntity);
        Collections.sort(copyList, new OrderIT_DattaiTuutiKzhuri(orders));
        return copyList;
    }
}
