package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.ChkSaikouSSTaniParam;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.id.PKBM_ChkJhSaikouSSTani;
import yuyu.def.db.mapping.GenBM_ChkJhSaikouSSTani;
import yuyu.def.db.meta.GenQBM_ChkJhSaikouSSTani;
import yuyu.def.db.meta.QBM_ChkJhSaikouSSTani;

/**
 * 最高ＳＳ単位事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhSaikouSSTani} の JavaDoc を参照してください。
 * @see     GenBM_ChkJhSaikouSSTani
 * @see     PKBM_ChkJhSaikouSSTani
 * @see     QBM_ChkJhSaikouSSTani
 * @see     GenQBM_ChkJhSaikouSSTani
 */
@Entity
public class BM_ChkJhSaikouSSTani extends GenBM_ChkJhSaikouSSTani implements ChkSaikouSSTaniParam {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhSaikouSSTani() {
    }

    public BM_ChkJhSaikouSSTani(
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
