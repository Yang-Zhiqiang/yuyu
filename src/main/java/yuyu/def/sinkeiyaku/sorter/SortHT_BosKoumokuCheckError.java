package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_BosKoumokuCheckError;
import yuyu.def.db.meta.QHT_BosKoumokuCheckError;
import yuyu.def.sinkeiyaku.comparator.OrderHT_BosKoumokuCheckError;

public class SortHT_BosKoumokuCheckError {

    
    public List<HT_BosKoumokuCheckError> OrderHT_BosKoumokuCheckErrorByPkAsc(List<HT_BosKoumokuCheckError> pEntity) {
        List<SortCondition<HT_BosKoumokuCheckError>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKoumokuCheckError()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_BosKoumokuCheckError()).renno3keta, SortOrder.ASC));
        List<HT_BosKoumokuCheckError> copyList = new ArrayList<HT_BosKoumokuCheckError>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKoumokuCheckError(orders));
        return copyList;
    }

    
    public List<HT_BosKoumokuCheckError> OrderHT_BosKoumokuCheckErrorByPkDesc(List<HT_BosKoumokuCheckError> pEntity) {
        List<SortCondition<HT_BosKoumokuCheckError>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_BosKoumokuCheckError()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_BosKoumokuCheckError()).renno3keta, SortOrder.DESC));
        List<HT_BosKoumokuCheckError> copyList = new ArrayList<HT_BosKoumokuCheckError>(pEntity);
        Collections.sort(copyList, new OrderHT_BosKoumokuCheckError(orders));
        return copyList;
    }
}
