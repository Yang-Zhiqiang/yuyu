package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 領収通貨種類が一致、入金処理日<=I.入金処理日
 */
public class FilterNyuukinSumRsgakuByRstuukasyuNyksyoriymd implements Predicate<HT_Nyuukin>{

    C_Tuukasyu rstuukasyu;
    BizDate nyksyoriymd;

    public FilterNyuukinSumRsgakuByRstuukasyuNyksyoriymd(C_Tuukasyu pRstuukasyu,BizDate pNyksyoriymd){
        super();

        rstuukasyu = pRstuukasyu;
        nyksyoriymd = pNyksyoriymd;
    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {
        if (((rstuukasyu.eq(pNyuukin.getRstuukasyu())
            && pNyuukin.getNyksyoriymd() != null
            && nyksyoriymd.compareTo(pNyuukin.getNyksyoriymd()) >= 0))) {
            return true;
        }
        return false;
    }
}
