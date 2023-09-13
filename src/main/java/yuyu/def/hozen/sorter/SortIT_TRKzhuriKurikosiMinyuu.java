package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRKzhuriKurikosiMinyuu;
import yuyu.def.db.meta.QIT_TRKzhuriKurikosiMinyuu;
import yuyu.def.hozen.comparator.OrderIT_TRKzhuriKurikosiMinyuu;

public class SortIT_TRKzhuriKurikosiMinyuu {

    public List<IT_TRKzhuriKurikosiMinyuu> OrderIT_TRKzhuriKurikosiMinyuuByPkAsc(List<IT_TRKzhuriKurikosiMinyuu> pEntity) {
        List<SortCondition<IT_TRKzhuriKurikosiMinyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).minyuutrrenno, SortOrder.ASC));
        List<IT_TRKzhuriKurikosiMinyuu> copyList = new ArrayList<IT_TRKzhuriKurikosiMinyuu>(pEntity);
        Collections.sort(copyList, new OrderIT_TRKzhuriKurikosiMinyuu(orders));
        return copyList;
    }

    public List<IT_TRKzhuriKurikosiMinyuu> OrderIT_TRKzhuriKurikosiMinyuuByPkDesc(List<IT_TRKzhuriKurikosiMinyuu> pEntity) {
        List<SortCondition<IT_TRKzhuriKurikosiMinyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRKzhuriKurikosiMinyuu()).minyuutrrenno, SortOrder.DESC));
        List<IT_TRKzhuriKurikosiMinyuu> copyList = new ArrayList<IT_TRKzhuriKurikosiMinyuu>(pEntity);
        Collections.sort(copyList, new OrderIT_TRKzhuriKurikosiMinyuu(orders));
        return copyList;
    }
}
