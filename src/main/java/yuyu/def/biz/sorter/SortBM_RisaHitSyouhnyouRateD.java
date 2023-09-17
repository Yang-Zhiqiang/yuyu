package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_RisaHitSyouhnyouRateD;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD;
import yuyu.def.db.meta.QBM_RisaHitSyouhnyouRateD;

public class SortBM_RisaHitSyouhnyouRateD {

    public List<BM_RisaHitSyouhnyouRateD> OrderBM_RisaHitSyouhnyouRateDByPkAsc(List<BM_RisaHitSyouhnyouRateD> pEntity) {
        List<SortCondition<BM_RisaHitSyouhnyouRateD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhokensyuruikigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhokensyuruikigousdicode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palyoteiriritu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palpmencode, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palharaikomikaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhhknsei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palkeiyakujihhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palsaimankihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhokenkikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palpharaikomikikan, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).paldnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).paldratenaikakucode, SortOrder.ASC));
        List<BM_RisaHitSyouhnyouRateD> copyList = new ArrayList<BM_RisaHitSyouhnyouRateD>(pEntity);
        Collections.sort(copyList, new OrderBM_RisaHitSyouhnyouRateD(orders));
        return copyList;
    }

    public List<BM_RisaHitSyouhnyouRateD> OrderBM_RisaHitSyouhnyouRateDByPkDesc(List<BM_RisaHitSyouhnyouRateD> pEntity) {
        List<SortCondition<BM_RisaHitSyouhnyouRateD>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhokensyuruikigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhokensyuruikigousdicode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palyoteiriritu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palpmencode, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palharaikomikaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhhknsei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palkeiyakujihhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palsaimankihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palhokenkikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).palpharaikomikikan, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).paldnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_RisaHitSyouhnyouRateD()).paldratenaikakucode, SortOrder.DESC));
        List<BM_RisaHitSyouhnyouRateD> copyList = new ArrayList<BM_RisaHitSyouhnyouRateD>(pEntity);
        Collections.sort(copyList, new OrderBM_RisaHitSyouhnyouRateD(orders));
        return copyList;
    }
}
