package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金処理日（一致）
 */
public class FilterHenkinByHnknsyoriymd implements Predicate<HT_Henkin> {

    BizDate hnknsyoriymd;

    public FilterHenkinByHnknsyoriymd(BizDate pHnknsyoriymd) {
        super();
        hnknsyoriymd = pHnknsyoriymd;
    }

    @Override
    public boolean apply(HT_Henkin henkin) {
        if (hnknsyoriymd.equals(henkin.getHnknsyoriymd())) {
            return true;
        }
        return false;
    }
}
