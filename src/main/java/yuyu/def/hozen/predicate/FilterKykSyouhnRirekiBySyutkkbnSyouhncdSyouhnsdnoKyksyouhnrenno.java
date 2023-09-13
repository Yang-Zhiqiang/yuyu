package yuyu.def.hozen.predicate;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;

import com.google.common.base.Predicate;

/**
 * 契約商品履歴テーブル用 Predicate<br/>
 * 主契約特約区分、商品コード、商品世代番号、契約商品連番（一致）<br />
 */
public class FilterKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno implements Predicate<IT_KykSyouhnRireki>{

    C_SyutkKbn syutkkbn;
    String syouhncd;
    Integer syouhnsdno;
    Integer kyksyouhnrenno;

    public FilterKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(C_SyutkKbn pSyutkkbn,
            String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {

        super();

        syutkkbn = pSyutkkbn;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Override
    public boolean apply(IT_KykSyouhnRireki pKykSyouhnRireki) {

        if (syutkkbn.eq(pKykSyouhnRireki.getSyutkkbn()) && syouhncd.equals(pKykSyouhnRireki.getSyouhncd())
                && syouhnsdno.equals(pKykSyouhnRireki.getSyouhnsdno())
                && kyksyouhnrenno.equals(pKykSyouhnRireki.getKyksyouhnrenno())){

            return true;
        }

        return false;
    }
}
