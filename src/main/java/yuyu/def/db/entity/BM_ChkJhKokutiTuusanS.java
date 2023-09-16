package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkJhKokutiTuusanS;
import yuyu.def.db.mapping.GenBM_ChkJhKokutiTuusanS;
import yuyu.def.db.meta.GenQBM_ChkJhKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkJhKokutiTuusanS;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KijiKbn;

/**
 * 告知扱通算限度Ｓ事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhKokutiTuusanS} の JavaDoc を参照してください。
 * @see     GenBM_ChkJhKokutiTuusanS
 * @see     PKBM_ChkJhKokutiTuusanS
 * @see     QBM_ChkJhKokutiTuusanS
 * @see     GenQBM_ChkJhKokutiTuusanS
 */
@Entity
public class BM_ChkJhKokutiTuusanS extends GenBM_ChkJhKokutiTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhKokutiTuusanS() {
    }

    public BM_ChkJhKokutiTuusanS(
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
