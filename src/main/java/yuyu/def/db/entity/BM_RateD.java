package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_RateD;


/**
 * Ｄレートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateD} の JavaDoc を参照してください。<br />
 * @see     GenBM_RateD<br />
 * @see     PKBM_RateD<br />
 * @see     QBM_RateD<br />
 * @see     GenQBM_RateD<br />
 */
@Entity
public class BM_RateD extends GenBM_RateD {

    private static final long serialVersionUID = 1L;

    public BM_RateD() {
    }

    public BM_RateD(String pPalhokensyuruikigou,String pPalhokensyuruikigousdicode,String pPalyoteiriritu,String pPalpmencode,String pPalharaikomikaisuu,String pPalhhknsei,String pPalkeiyakujihhknnen,String pPalsaimankihyouji,String pPalhokenkikan,String pPalpharaikomikikan,String pPaldnendo,String pPaldratenaikakucode) {
        super(pPalhokensyuruikigou,pPalhokensyuruikigousdicode,pPalyoteiriritu,pPalpmencode,pPalharaikomikaisuu,pPalhhknsei,pPalkeiyakujihhknnen,pPalsaimankihyouji,pPalhokenkikan,pPalpharaikomikikan,pPaldnendo,pPaldratenaikakucode);
    }



}

