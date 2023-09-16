package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_RateW;
import yuyu.def.db.mapping.GenBM_RateW;
import yuyu.def.db.meta.GenQBM_RateW;
import yuyu.def.db.meta.QBM_RateW;

/**
 * Ｗレートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RateW} の JavaDoc を参照してください。
 * @see     GenBM_RateW
 * @see     PKBM_RateW
 * @see     QBM_RateW
 * @see     GenQBM_RateW
 */
@Entity
public class BM_RateW extends GenBM_RateW {

    private static final long serialVersionUID = 1L;

    public BM_RateW() {
    }

    public BM_RateW(
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
