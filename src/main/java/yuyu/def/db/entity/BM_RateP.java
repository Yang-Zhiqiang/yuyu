package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_RateP;


/**
 * Ｐレートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateP} の JavaDoc を参照してください。<br />
 * @see     GenBM_RateP<br />
 * @see     PKBM_RateP<br />
 * @see     QBM_RateP<br />
 * @see     GenQBM_RateP<br />
 */
@Entity
public class BM_RateP extends GenBM_RateP {

    private static final long serialVersionUID = 1L;

    public BM_RateP() {
    }

    public BM_RateP(String pPalhokensyuruikigou,String pPalhokensyuruikigousdicode,String pPalyoteiriritu,String pPalpmencode,String pPalharaikomikaisuu,String pPalhhknsei,String pPalkeiyakujihhknnen,String pPalsaimankihyouji,String pPalhokenkikan,String pPalpharaikomikikan) {
        super(pPalhokensyuruikigou,pPalhokensyuruikigousdicode,pPalyoteiriritu,pPalpmencode,pPalharaikomikaisuu,pPalhhknsei,pPalkeiyakujihhknnen,pPalsaimankihyouji,pPalhokenkikan,pPalpharaikomikikan);
    }



}

