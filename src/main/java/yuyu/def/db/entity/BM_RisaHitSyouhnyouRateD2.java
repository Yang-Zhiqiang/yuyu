package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.mapping.GenBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.GenQBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.QBM_RisaHitSyouhnyouRateD2;

/**
 * 利差配当商品用Ｄレートマスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RisaHitSyouhnyouRateD2} の JavaDoc を参照してください。
 * @see     GenBM_RisaHitSyouhnyouRateD2
 * @see     PKBM_RisaHitSyouhnyouRateD2
 * @see     QBM_RisaHitSyouhnyouRateD2
 * @see     GenQBM_RisaHitSyouhnyouRateD2
 */
@Entity
public class BM_RisaHitSyouhnyouRateD2 extends GenBM_RisaHitSyouhnyouRateD2 {

    private static final long serialVersionUID = 1L;

    public BM_RisaHitSyouhnyouRateD2() {
    }

    public BM_RisaHitSyouhnyouRateD2(
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
        String pPaldnendo,
        String pPaldratenaikakucode
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
            pPaldnendo,
            pPaldratenaikakucode
        );
    }

}
