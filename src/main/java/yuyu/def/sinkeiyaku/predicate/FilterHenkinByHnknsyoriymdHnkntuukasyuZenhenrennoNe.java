package yuyu.def.sinkeiyaku.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金処理日、返金通貨種類（一致）、全額返金連番（不一致）
 */
public class FilterHenkinByHnknsyoriymdHnkntuukasyuZenhenrennoNe implements Predicate<HT_Henkin>{

    BizDate hnknsyoriymd;

    C_Tuukasyu hnkntuukasyu;

    Integer zenhnknrenno;

    public FilterHenkinByHnknsyoriymdHnkntuukasyuZenhenrennoNe(BizDate pHnknsyoriymd,
        C_Tuukasyu pHnkntuukasyu, Integer pZenhnknrenno){
        super();
        hnknsyoriymd = pHnknsyoriymd;
        hnkntuukasyu = pHnkntuukasyu;
        zenhnknrenno = pZenhnknrenno;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {

        if (BizDateUtil.compareYmd(hnknsyoriymd, pHenkin.getHnknsyoriymd()) == BizDateUtil.COMPARE_EQUAL
            && hnkntuukasyu.eq(pHenkin.getHnkntuukasyu()) && !zenhnknrenno.equals(pHenkin.getZenhnknrenno())) {

            return true;
        }
        return false;
    }
}
