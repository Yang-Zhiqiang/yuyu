package yuyu.app.hozen.khansyuu.khharaikatahenkou.dba;

import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約商品テーブル用Predicateクラス１
 */
public class FilterKykSyouhn1 implements Predicate<IT_KykSyouhn>{

    String syouhncd;
    Integer syouhnsdno;
    Integer kyksyouhnrenno;

    public FilterKykSyouhn1(String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {
        super();
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyksyouhnrenno = pKyksyouhnrenno;
    }

    @Override
    public boolean apply(IT_KykSyouhn pKykSyouhn) {
        if(syouhncd.equals(pKykSyouhn.getSyouhncd()) &&
            syouhnsdno.equals(pKykSyouhn.getSyouhnsdno()) &&
            kyksyouhnrenno.equals(pKykSyouhn.getKyksyouhnrenno())){
            return true ;
        }
        return false;
    }

}
