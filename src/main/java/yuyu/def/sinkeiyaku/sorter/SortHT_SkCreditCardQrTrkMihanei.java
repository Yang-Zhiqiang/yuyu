package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import yuyu.def.db.meta.QHT_SkCreditCardQrTrkMihanei;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SkCreditCardQrTrkMihanei;

public class SortHT_SkCreditCardQrTrkMihanei {

    
    public List<HT_SkCreditCardQrTrkMihanei> OrderHT_SkCreditCardQrTrkMihaneiByPkAsc(List<HT_SkCreditCardQrTrkMihanei> pEntity) {
        List<SortCondition<HT_SkCreditCardQrTrkMihanei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).systemjyusinymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).systemjyusintime, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).creditkessaiyouno, SortOrder.ASC));
        List<HT_SkCreditCardQrTrkMihanei> copyList = new ArrayList<HT_SkCreditCardQrTrkMihanei>(pEntity);
        Collections.sort(copyList, new OrderHT_SkCreditCardQrTrkMihanei(orders));
        return copyList;
    }

    
    public List<HT_SkCreditCardQrTrkMihanei> OrderHT_SkCreditCardQrTrkMihaneiByPkDesc(List<HT_SkCreditCardQrTrkMihanei> pEntity) {
        List<SortCondition<HT_SkCreditCardQrTrkMihanei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).systemjyusinymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).systemjyusintime, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SkCreditCardQrTrkMihanei()).creditkessaiyouno, SortOrder.DESC));
        List<HT_SkCreditCardQrTrkMihanei> copyList = new ArrayList<HT_SkCreditCardQrTrkMihanei>(pEntity);
        Collections.sort(copyList, new OrderHT_SkCreditCardQrTrkMihanei(orders));
        return copyList;
    }
}
