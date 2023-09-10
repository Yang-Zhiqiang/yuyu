package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.QHT_SkKouhuriUkTrkMihanei;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkKouhuriUkTrkMihanei;

public class SortHT_SkKouhuriUkTrkMihanei {

    
    public List<HT_SkKouhuriUkTrkMihanei> OrderHT_SkKouhuriUkTrkMihaneiByPkAsc(List<HT_SkKouhuriUkTrkMihanei> pEntity) {
        List<SortCondition<HT_SkKouhuriUkTrkMihanei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).syukkncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kinyuucd8keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kinyuukkntratkiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kinyuukkntratkitime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kouhuriokyakusamano, SortOrder.ASC));
        List<HT_SkKouhuriUkTrkMihanei> copyList = new ArrayList<HT_SkKouhuriUkTrkMihanei>(pEntity);
        Collections.sort(copyList, new OrderHT_SkKouhuriUkTrkMihanei(orders));
        return copyList;
    }

    
    public List<HT_SkKouhuriUkTrkMihanei> OrderHT_SkKouhuriUkTrkMihaneiByPkDesc(List<HT_SkKouhuriUkTrkMihanei> pEntity) {
        List<SortCondition<HT_SkKouhuriUkTrkMihanei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).syukkncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kinyuucd8keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kinyuukkntratkiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kinyuukkntratkitime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkKouhuriUkTrkMihanei()).kouhuriokyakusamano, SortOrder.DESC));
        List<HT_SkKouhuriUkTrkMihanei> copyList = new ArrayList<HT_SkKouhuriUkTrkMihanei>(pEntity);
        Collections.sort(copyList, new OrderHT_SkKouhuriUkTrkMihanei(orders));
        return copyList;
    }
}
