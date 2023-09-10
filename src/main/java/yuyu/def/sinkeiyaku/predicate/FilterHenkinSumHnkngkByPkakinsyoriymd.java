package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * Ｐ過金処理日（一致）
 */
public class FilterHenkinSumHnkngkByPkakinsyoriymd implements Predicate<HT_Henkin>{

    BizDate pkakinsyoriymd;

    public FilterHenkinSumHnkngkByPkakinsyoriymd(BizDate pPkakinsyoriymd){
        super();

        pkakinsyoriymd = pPkakinsyoriymd;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {
        if (pHenkin.getPkakinsyoriymd() != null && pkakinsyoriymd.compareTo(pHenkin.getPkakinsyoriymd()) >= 0) {
            return true;
        }
        return false;
    }
}
