package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.mapping.GenBM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.meta.GenQBM_SjkkkTyouseiyouRiritu;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_HhknNenKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 市場価格調整用利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SjkkkTyouseiyouRiritu} の JavaDoc を参照してください。
 * @see     GenBM_SjkkkTyouseiyouRiritu
 * @see     PKBM_SjkkkTyouseiyouRiritu
 * @see     QBM_SjkkkTyouseiyouRiritu
 * @see     GenQBM_SjkkkTyouseiyouRiritu
 */
@Entity
public class BM_SjkkkTyouseiyouRiritu extends GenBM_SjkkkTyouseiyouRiritu {

    private static final long serialVersionUID = 1L;

    public BM_SjkkkTyouseiyouRiritu() {
    }

    public BM_SjkkkTyouseiyouRiritu(
        String pSyouhncd,
        C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknnenkbn,
        BizDate pKykfromymd,
        BizDate pKyktoymd
    ) {
        super(
            pSyouhncd,
            pTuukasyu,
            pHhknnenkbn,
            pKykfromymd,
            pKyktoymd
        );
    }

}
