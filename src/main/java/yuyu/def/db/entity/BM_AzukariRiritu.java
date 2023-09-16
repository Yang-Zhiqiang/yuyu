package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_AzukariRiritu;
import yuyu.def.db.mapping.GenBM_AzukariRiritu;
import yuyu.def.db.meta.GenQBM_AzukariRiritu;
import yuyu.def.db.meta.QBM_AzukariRiritu;
import yuyu.def.classification.C_Tuukasyu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 預り利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_AzukariRiritu} の JavaDoc を参照してください。
 * @see     GenBM_AzukariRiritu
 * @see     PKBM_AzukariRiritu
 * @see     QBM_AzukariRiritu
 * @see     GenQBM_AzukariRiritu
 */
@Entity
public class BM_AzukariRiritu extends GenBM_AzukariRiritu {

    private static final long serialVersionUID = 1L;

    public BM_AzukariRiritu() {
    }

    public BM_AzukariRiritu(
        C_Tuukasyu pTuukasyu,
        BizDate pTkyfromymd,
        BizDate pTkytoymd
    ) {
        super(
            pTuukasyu,
            pTkyfromymd,
            pTkytoymd
        );
    }

}
