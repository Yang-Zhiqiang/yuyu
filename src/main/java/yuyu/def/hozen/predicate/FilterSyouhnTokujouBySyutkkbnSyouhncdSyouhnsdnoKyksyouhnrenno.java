package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_SyouhnTokujou;

import com.google.common.base.Predicate;

/**
 * 商品特条テーブル用 Predicate<br/>
 * 主契約特約区分、商品コード、商品世代番号、契約商品連番（一致）
 */
public class FilterSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno implements Predicate<IT_SyouhnTokujou> {

    C_SyutkKbn syutkkbn;
    String syouhncd;
    Integer syouhnsdno;
    Integer kyksyouhnrenno;

    public FilterSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(C_SyutkKbn pSyutkkbn, String pSyouhncd,
            Integer pSyouhnsdno, Integer pKyksyouhnrenno) {
        super();
        syutkkbn = pSyutkkbn;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Override
    public boolean apply(IT_SyouhnTokujou syouhnTokujou) {
        if (syutkkbn.eq(syouhnTokujou.getSyutkkbn()) && syouhncd.equals(syouhnTokujou.getSyouhncd())
                && syouhnsdno.equals(syouhnTokujou.getSyouhnsdno())
                && kyksyouhnrenno.equals(syouhnTokujou.getKyksyouhnrenno())) {
            return true;
        }
        return false;
    }

}
