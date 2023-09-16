package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.ChkSaikouSSTaniParam;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.id.PKBM_ChkSaikouSSTani;
import yuyu.def.db.mapping.GenBM_ChkSaikouSSTani;
import yuyu.def.db.meta.GenQBM_ChkSaikouSSTani;
import yuyu.def.db.meta.QBM_ChkSaikouSSTani;

/**
 * 最高ＳＳ単位チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkSaikouSSTani} の JavaDoc を参照してください。
 * @see     GenBM_ChkSaikouSSTani
 * @see     PKBM_ChkSaikouSSTani
 * @see     QBM_ChkSaikouSSTani
 * @see     GenQBM_ChkSaikouSSTani
 */
@Entity
public class BM_ChkSaikouSSTani extends GenBM_ChkSaikouSSTani implements ChkSaikouSSTaniParam {

    private static final long serialVersionUID = 1L;

    public BM_ChkSaikouSSTani() {
    }

    public BM_ChkSaikouSSTani(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        Integer pMoskbnfrom,
        Integer pMoskbnto,
        C_Tuukasyu pTuukasyu
        ) {
        super(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknfromnen,
            pHhkntonen,
            pMoskbnfrom,
            pMoskbnto,
            pTuukasyu
            );
    }

}
