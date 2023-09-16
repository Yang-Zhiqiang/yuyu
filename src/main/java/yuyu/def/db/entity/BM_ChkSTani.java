package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkSTani;
import yuyu.def.db.mapping.GenBM_ChkSTani;
import yuyu.def.db.meta.GenQBM_ChkSTani;
import yuyu.def.db.meta.QBM_ChkSTani;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;

/**
 * Ｓ単位チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkSTani} の JavaDoc を参照してください。
 * @see     GenBM_ChkSTani
 * @see     PKBM_ChkSTani
 * @see     QBM_ChkSTani
 * @see     GenQBM_ChkSTani
 */
@Entity
public class BM_ChkSTani extends GenBM_ChkSTani {

    private static final long serialVersionUID = 1L;

    public BM_ChkSTani() {
    }

    public BM_ChkSTani(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        C_Tuukasyu pTuukasyu
    ) {
        super(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknfromnen,
            pHhkntonen,
            pTuukasyu
        );
    }

}
