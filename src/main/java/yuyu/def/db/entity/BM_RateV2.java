package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_RateV2;
import yuyu.def.db.mapping.GenBM_RateV2;
import yuyu.def.db.meta.GenQBM_RateV2;
import yuyu.def.db.meta.QBM_RateV2;

/**
 * Ｖレートマスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateV2} の JavaDoc を参照してください。
 * @see     GenBM_RateV2
 * @see     PKBM_RateV2
 * @see     QBM_RateV2
 * @see     GenQBM_RateV2
 */
@Entity
public class BM_RateV2 extends GenBM_RateV2 {

    private static final long serialVersionUID = 1L;

    public BM_RateV2() {
    }

    public BM_RateV2(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan,
        String pPalannaihuyouriyuukbn,
        String pRatetuukasyukbn,
        String pRatedai1hknkkn
    ) {
        super(
            pPalhokensyuruikigou,
            pPalhokensyuruikigousdicode,
            pPalyoteiriritu,
            pPalpmencode,
            pPalharaikomikaisuu,
            pPalhhknsei,
            pPalkeiyakujihhknnen,
            pPalsaimankihyouji,
            pPalhokenkikan,
            pPalpharaikomikikan,
            pPalannaihuyouriyuukbn,
            pRatetuukasyukbn,
            pRatedai1hknkkn
        );
    }

}
