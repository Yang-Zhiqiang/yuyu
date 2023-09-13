package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRCreditKurikosiMinyuu;
import yuyu.def.db.meta.QIT_TRCreditKurikosiMinyuu;
import yuyu.def.hozen.comparator.OrderIT_TRCreditKurikosiMinyuu;

public class SortIT_TRCreditKurikosiMinyuu {

    public List<IT_TRCreditKurikosiMinyuu> OrderIT_TRCreditKurikosiMinyuuByPkAsc(List<IT_TRCreditKurikosiMinyuu> pEntity) {
        List<SortCondition<IT_TRCreditKurikosiMinyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).minyuutrrenno, SortOrder.ASC));
        List<IT_TRCreditKurikosiMinyuu> copyList = new ArrayList<IT_TRCreditKurikosiMinyuu>(pEntity);
        Collections.sort(copyList, new OrderIT_TRCreditKurikosiMinyuu(orders));
        return copyList;
    }

    public List<IT_TRCreditKurikosiMinyuu> OrderIT_TRCreditKurikosiMinyuuByPkDesc(List<IT_TRCreditKurikosiMinyuu> pEntity) {
        List<SortCondition<IT_TRCreditKurikosiMinyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRCreditKurikosiMinyuu()).minyuutrrenno, SortOrder.DESC));
        List<IT_TRCreditKurikosiMinyuu> copyList = new ArrayList<IT_TRCreditKurikosiMinyuu>(pEntity);
        Collections.sort(copyList, new OrderIT_TRCreditKurikosiMinyuu(orders));
        return copyList;
    }
}
