package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金通貨種類、Ｐ過金処理日（一致）
 */
public class FilterHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd implements Predicate<HT_Henkin>{

    C_Tuukasyu hnkntuukasyu;
    BizDate pkakinsyoriymd;

    public FilterHenkinSumHnkngkByHnkntuukasyuPkakinsyoriymd(C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd){
        super();

        hnkntuukasyu = pHnkntuukasyu;
        pkakinsyoriymd = pPkakinsyoriymd;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {
        if (hnkntuukasyu.eq(pHenkin.getHnkntuukasyu())
                && pHenkin.getPkakinsyoriymd() != null
                && pkakinsyoriymd.compareTo(pHenkin.getPkakinsyoriymd()) >= 0) {
            return true;
        }
        return false;
    }
}
