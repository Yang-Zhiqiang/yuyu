package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金通貨種類、返金処理日（一致）
 */
public class FilterHenkinSumHnkngkByHnkntuukasyuHnknsyoriymdLe implements Predicate<HT_Henkin>{

    C_Tuukasyu hnkntuukasyu;
    BizDate hnknsyoriymd;

    public FilterHenkinSumHnkngkByHnkntuukasyuHnknsyoriymdLe(C_Tuukasyu pHnkntuukasyu, BizDate pHnknsyoriymd){
        super();

        hnkntuukasyu = pHnkntuukasyu;
        hnknsyoriymd = pHnknsyoriymd;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {
        if (hnkntuukasyu.eq(pHenkin.getHnkntuukasyu())
                && pHenkin.getHnknsyoriymd() != null
                && hnknsyoriymd.compareTo(pHenkin.getHnknsyoriymd()) >= 0) {
            return true;
        }
        return false;
    }
}
