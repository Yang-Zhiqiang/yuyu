package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_HaitouRiritu;
import yuyu.def.db.mapping.GenBM_HaitouRiritu;
import yuyu.def.db.meta.GenQBM_HaitouRiritu;
import yuyu.def.db.meta.QBM_HaitouRiritu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 配当利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_HaitouRiritu} の JavaDoc を参照してください。
 * @see     GenBM_HaitouRiritu
 * @see     PKBM_HaitouRiritu
 * @see     QBM_HaitouRiritu
 * @see     GenQBM_HaitouRiritu
 */
@Entity
public class BM_HaitouRiritu extends GenBM_HaitouRiritu {

    private static final long serialVersionUID = 1L;

    public BM_HaitouRiritu() {
    }

    public BM_HaitouRiritu(BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        super(pKijyunfromymd, pKijyuntoymd);
    }

}
