package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_RateV;


/**
 * Ｖレートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateV} の JavaDoc を参照してください。<br />
 * @see     GenBM_RateV<br />
 * @see     PKBM_RateV<br />
 * @see     QBM_RateV<br />
 * @see     GenQBM_RateV<br />
 */
@Entity
public class BM_RateV extends GenBM_RateV {

    private static final long serialVersionUID = 1L;

    public BM_RateV() {
    }

    public BM_RateV(String pPalhokensyuruikigou,String pPalhokensyuruikigousdicode,String pPalyoteiriritu,String pPalpmencode,String pPalharaikomikaisuu,String pPalhhknsei,String pPalkeiyakujihhknnen,String pPalsaimankihyouji,String pPalhokenkikan,String pPalpharaikomikikan) {
        super(pPalhokensyuruikigou,pPalhokensyuruikigousdicode,pPalyoteiriritu,pPalpmencode,pPalharaikomikaisuu,pPalhhknsei,pPalkeiyakujihhknnen,pPalsaimankihyouji,pPalhokenkikan,pPalpharaikomikikan);
    }



}

