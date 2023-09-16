package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_RateP2;
import yuyu.def.db.mapping.GenBM_RateP2;
import yuyu.def.db.meta.GenQBM_RateP2;
import yuyu.def.db.meta.QBM_RateP2;

/**
 * Ｐレートマスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateP2} の JavaDoc を参照してください。
 * @see     GenBM_RateP2
 * @see     PKBM_RateP2
 * @see     QBM_RateP2
 * @see     GenQBM_RateP2
 */
@Entity
public class BM_RateP2 extends GenBM_RateP2 {

    private static final long serialVersionUID = 1L;

    public BM_RateP2() {
    }

    public BM_RateP2(
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
        String pRatedai1hknkkn,
        String pPalryouritukbn
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
            pRatedai1hknkkn,
            pPalryouritukbn
        );
    }

}
