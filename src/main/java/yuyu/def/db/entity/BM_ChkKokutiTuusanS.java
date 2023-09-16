package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkKokutiTuusanS;
import yuyu.def.db.mapping.GenBM_ChkKokutiTuusanS;
import yuyu.def.db.meta.GenQBM_ChkKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkKokutiTuusanS;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KijiKbn;

/**
 * 告知扱通算限度Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkKokutiTuusanS} の JavaDoc を参照してください。
 * @see     GenBM_ChkKokutiTuusanS
 * @see     PKBM_ChkKokutiTuusanS
 * @see     QBM_ChkKokutiTuusanS
 * @see     GenQBM_ChkKokutiTuusanS
 */
@Entity
public class BM_ChkKokutiTuusanS extends GenBM_ChkKokutiTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkKokutiTuusanS() {
    }

    public BM_ChkKokutiTuusanS(
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        C_KijiKbn pKijikbn,
        Integer pIktkktkbnfrom,
        Integer pIktkktkbnto
        ) {
        super(
            pHhknfromnen,
            pHhkntonen,
            pKijikbn,
            pIktkktkbnfrom,
            pIktkktkbnto
            );
    }

}
