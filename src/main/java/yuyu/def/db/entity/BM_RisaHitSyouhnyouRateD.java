package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_RisaHitSyouhnyouRateD;
import yuyu.def.db.mapping.GenBM_RisaHitSyouhnyouRateD;
import yuyu.def.db.meta.GenQBM_RisaHitSyouhnyouRateD;
import yuyu.def.db.meta.QBM_RisaHitSyouhnyouRateD;

/**
 * 利差配当商品用Ｄレートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RisaHitSyouhnyouRateD} の JavaDoc を参照してください。
 * @see     GenBM_RisaHitSyouhnyouRateD
 * @see     PKBM_RisaHitSyouhnyouRateD
 * @see     QBM_RisaHitSyouhnyouRateD
 * @see     GenQBM_RisaHitSyouhnyouRateD
 */
@Entity
public class BM_RisaHitSyouhnyouRateD extends GenBM_RisaHitSyouhnyouRateD {

    private static final long serialVersionUID = 1L;

    public BM_RisaHitSyouhnyouRateD() {
    }

    public BM_RisaHitSyouhnyouRateD(
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
            pPaldnendo,
            pPaldratenaikakucode
        );
    }

}
