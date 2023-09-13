package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約商品テーブル用 Predicate<br/>
 * 主契約特約区分、商品コード、商品世代番号、契約商品連番（一致）
 */
public class FilterKykSyouhnBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno implements Predicate<IT_KykSyouhn> {

    C_SyutkKbn pSyutkkbn;
    String pSyouhncd;
    Integer pSyouhnsdno;
    Integer pKyksyouhnrenno;

    public FilterKykSyouhnBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(C_SyutkKbn syutkkbn, String syouhncd,
            Integer syouhnsdno, Integer kyksyouhnrenno) {
        super();
        pSyutkkbn = syutkkbn;
        pSyouhncd = syouhncd;
        pSyouhnsdno = syouhnsdno;
        pKyksyouhnrenno = kyksyouhnrenno;
    }

    @Override
    public boolean apply(IT_KykSyouhn kykSyouhn) {

        if (pSyutkkbn.eq(kykSyouhn.getSyutkkbn()) && pSyouhncd.equals(kykSyouhn.getSyouhncd())
                && pSyouhnsdno.equals(kykSyouhn.getSyouhnsdno()) && pKyksyouhnrenno.equals(kykSyouhn.getKyksyouhnrenno())) {
            return true;
        }
        return false;
    }

}
