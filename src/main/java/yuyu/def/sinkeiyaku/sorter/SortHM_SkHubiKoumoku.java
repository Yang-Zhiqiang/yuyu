package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.meta.QHM_SkHubiKoumoku;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkHubiKoumoku;

public class SortHM_SkHubiKoumoku {

    
    public List<HM_SkHubiKoumoku> OrderHM_SkHubiKoumokuByPkAsc(List<HM_SkHubiKoumoku> pEntity) {
        List<SortCondition<HM_SkHubiKoumoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiKoumoku()).syoruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkHubiKoumoku()).skhubikoumokucd, SortOrder.ASC));
        List<HM_SkHubiKoumoku> copyList = new ArrayList<HM_SkHubiKoumoku>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiKoumoku(orders));
        return copyList;
    }

    
    public List<HM_SkHubiKoumoku> OrderHM_SkHubiKoumokuByPkDesc(List<HM_SkHubiKoumoku> pEntity) {
        List<SortCondition<HM_SkHubiKoumoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiKoumoku()).syoruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkHubiKoumoku()).skhubikoumokucd, SortOrder.DESC));
        List<HM_SkHubiKoumoku> copyList = new ArrayList<HM_SkHubiKoumoku>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiKoumoku(orders));
        return copyList;
    }
    
    public List<HM_SkHubiKoumoku> OrderHM_SkHubiKoumokuByHyoujijyunAsc(List<HM_SkHubiKoumoku> pEntity) {
        List<SortCondition<HM_SkHubiKoumoku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHubiKoumoku()).hyoujijyun, SortOrder.ASC));
        List<HM_SkHubiKoumoku> copyList = new ArrayList<HM_SkHubiKoumoku>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHubiKoumoku(orders));
        return copyList;
    }


}

