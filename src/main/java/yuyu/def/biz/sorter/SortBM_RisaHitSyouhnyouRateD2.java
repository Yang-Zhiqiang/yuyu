package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.QBM_RisaHitSyouhnyouRateD2;

public class SortBM_RisaHitSyouhnyouRateD2 {

    public List<BM_RisaHitSyouhnyouRateD2> OrderBM_RisaHitSyouhnyouRateD2ByPkAsc(List<BM_RisaHitSyouhnyouRateD2> pEntity) {
        List<SortCondition<BM_RisaHitSyouhnyouRateD2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palpharaikomikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palannaihuyouriyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).ratetuukasyukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).ratedai1hknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).paldnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).paldratenaikakucode, SortOrder.ASC));
        List<BM_RisaHitSyouhnyouRateD2> copyList = new ArrayList<BM_RisaHitSyouhnyouRateD2>(pEntity);
        Collections.sort(copyList, new OrderBM_RisaHitSyouhnyouRateD2(orders));
        return copyList;
    }

    public List<BM_RisaHitSyouhnyouRateD2> OrderBM_RisaHitSyouhnyouRateD2ByPkDesc(List<BM_RisaHitSyouhnyouRateD2> pEntity) {
        List<SortCondition<BM_RisaHitSyouhnyouRateD2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palpharaikomikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).palannaihuyouriyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).ratetuukasyukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).ratedai1hknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).paldnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD2()).paldratenaikakucode, SortOrder.DESC));
        List<BM_RisaHitSyouhnyouRateD2> copyList = new ArrayList<BM_RisaHitSyouhnyouRateD2>(pEntity);
        Collections.sort(copyList, new OrderBM_RisaHitSyouhnyouRateD2(orders));
        return copyList;
    }
}
