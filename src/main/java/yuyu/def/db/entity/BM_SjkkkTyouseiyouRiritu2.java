package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.mapping.GenBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.GenQBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu2;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 市場価格調整用利率マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SjkkkTyouseiyouRiritu2} の JavaDoc を参照してください。
 * @see     GenBM_SjkkkTyouseiyouRiritu2
 * @see     PKBM_SjkkkTyouseiyouRiritu2
 * @see     QBM_SjkkkTyouseiyouRiritu2
 * @see     GenQBM_SjkkkTyouseiyouRiritu2
 */
@Entity
public class BM_SjkkkTyouseiyouRiritu2 extends GenBM_SjkkkTyouseiyouRiritu2 {

    private static final long serialVersionUID = 1L;

    public BM_SjkkkTyouseiyouRiritu2() {
    }

    public BM_SjkkkTyouseiyouRiritu2(
        String pSyouhncd,
        String pSjkkktyouseiriritutkybr1,
        String pSjkkktyouseiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd
    ) {
        super(
            pSyouhncd,
            pSjkkktyouseiriritutkybr1,
            pSjkkktyouseiriritutkybr2,
            pKijyunfromymd,
            pKijyuntoymd
        );
    }

}
