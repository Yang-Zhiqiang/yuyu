package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_YoteiRiritu3;
import yuyu.def.db.mapping.GenBM_YoteiRiritu3;
import yuyu.def.db.meta.GenQBM_YoteiRiritu3;
import yuyu.def.db.meta.QBM_YoteiRiritu3;
import yuyu.def.classification.C_Tuukasyu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 予定利率マスタ３ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_YoteiRiritu3} の JavaDoc を参照してください。
 * @see     GenBM_YoteiRiritu3
 * @see     PKBM_YoteiRiritu3
 * @see     QBM_YoteiRiritu3
 * @see     GenQBM_YoteiRiritu3
 */
@Entity
public class BM_YoteiRiritu3 extends GenBM_YoteiRiritu3 {

    private static final long serialVersionUID = 1L;

    public BM_YoteiRiritu3() {
    }

    public BM_YoteiRiritu3(
        String pSyouhncd,
        C_Tuukasyu pTuukasyu,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd
    ) {
        super(
            pSyouhncd,
            pTuukasyu,
            pYoteiriritutkybr1,
            pYoteiriritutkybr2,
            pKijyunfromymd,
            pKijyuntoymd
        );
    }

}
