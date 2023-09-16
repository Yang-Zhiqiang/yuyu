package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_YoteiRiritu2;
import yuyu.def.db.mapping.GenBM_YoteiRiritu2;
import yuyu.def.db.meta.GenQBM_YoteiRiritu2;
import yuyu.def.db.meta.QBM_YoteiRiritu2;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 予定利率マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_YoteiRiritu2} の JavaDoc を参照してください。
 * @see     GenBM_YoteiRiritu2
 * @see     PKBM_YoteiRiritu2
 * @see     QBM_YoteiRiritu2
 * @see     GenQBM_YoteiRiritu2
 */
@Entity
public class BM_YoteiRiritu2 extends GenBM_YoteiRiritu2 {

    private static final long serialVersionUID = 1L;

    public BM_YoteiRiritu2() {
    }

    public BM_YoteiRiritu2(
        String pSyouhncd,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd
    ) {
        super(
            pSyouhncd,
            pYoteiriritutkybr1,
            pYoteiriritutkybr2,
            pKijyunfromymd,
            pKijyuntoymd
        );
    }

}
