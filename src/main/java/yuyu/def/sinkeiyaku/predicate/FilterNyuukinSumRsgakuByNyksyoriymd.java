package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 入金処理日 ≦ I．入金処理日
 */
public class FilterNyuukinSumRsgakuByNyksyoriymd implements Predicate<HT_Nyuukin>{

    BizDate nyksyoriymd;

    public FilterNyuukinSumRsgakuByNyksyoriymd(BizDate pNyksyoriymd){
        super();

        nyksyoriymd = pNyksyoriymd;
    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {
        if (pNyuukin.getNyksyoriymd() != null && nyksyoriymd.compareTo(pNyuukin.getNyksyoriymd()) >= 0) {
            return true;
        }
        return false;
    }
}
