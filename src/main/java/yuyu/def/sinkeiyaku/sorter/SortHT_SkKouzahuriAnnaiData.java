package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import yuyu.def.db.meta.QHT_SkKouzahuriAnnaiData;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkKouzahuriAnnaiData;

public class SortHT_SkKouzahuriAnnaiData {

    
    public List<HT_SkKouzahuriAnnaiData> OrderHT_SkKouzahuriAnnaiDataByPkAsc(List<HT_SkKouzahuriAnnaiData> pEntity) {
        List<SortCondition<HT_SkKouzahuriAnnaiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).nyknaiyoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).jyuutouym, SortOrder.ASC));
        List<HT_SkKouzahuriAnnaiData> copyList = new ArrayList<HT_SkKouzahuriAnnaiData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkKouzahuriAnnaiData(orders));
        return copyList;
    }

    
    public List<HT_SkKouzahuriAnnaiData> OrderHT_SkKouzahuriAnnaiDataByPkDesc(List<HT_SkKouzahuriAnnaiData> pEntity) {
        List<SortCondition<HT_SkKouzahuriAnnaiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).nyknaiyoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouzahuriAnnaiData()).jyuutouym, SortOrder.DESC));
        List<HT_SkKouzahuriAnnaiData> copyList = new ArrayList<HT_SkKouzahuriAnnaiData>(pEntity);
        Collections.sort(copyList, new OrderHT_SkKouzahuriAnnaiData(orders));
        return copyList;
    }

}

