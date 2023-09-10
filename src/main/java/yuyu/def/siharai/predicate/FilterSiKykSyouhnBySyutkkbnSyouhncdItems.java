package yuyu.def.siharai.predicate;

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;

import com.google.common.base.Predicate;

/**
 * 支払契約商品テーブル 用 Predicate<br />
 * 主キー範囲（一致）<br />
 */
public class FilterSiKykSyouhnBySyutkkbnSyouhncdItems implements Predicate<JT_SiKykSyouhn> {

    C_SyutkKbn syutkKbn;
    String syouhncd;
    C_KyhgndkataKbn kyhgndkatakbn;
    Integer syouhnsdno;
    Integer kyksyouhnrenno;

    public FilterSiKykSyouhnBySyutkkbnSyouhncdItems(C_SyutkKbn pSyutkkbn, String pSyouhncd,
            C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {

        super();

        syutkKbn = pSyutkkbn;
        syouhncd = pSyouhncd;
        kyhgndkatakbn = pKyhgndkatakbn;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Override
    public boolean apply(JT_SiKykSyouhn pSiKykSyouhn) {

        if (syutkKbn.eq(pSiKykSyouhn.getSyutkkbn()) &&
                syouhncd.equals(pSiKykSyouhn.getSyouhncd()) &&
                kyhgndkatakbn.eq(pSiKykSyouhn.getKyhgndkatakbn()) &&
                syouhnsdno.equals(pSiKykSyouhn.getSyouhnsdno()) &&
                kyksyouhnrenno.equals(pSiKykSyouhn.getKyksyouhnrenno())) {

            return true;
        }

        return false;
    }
}
