package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.mapping.GenHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.GenQHM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.meta.QHM_TokuteiKankeiHjnNmTotugou;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 特定関係法人名突合マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_TokuteiKankeiHjnNmTotugou} の JavaDoc を参照してください。
 * @see     GenHM_TokuteiKankeiHjnNmTotugou
 * @see     PKHM_TokuteiKankeiHjnNmTotugou
 * @see     QHM_TokuteiKankeiHjnNmTotugou
 * @see     GenQHM_TokuteiKankeiHjnNmTotugou
 */
@Entity
public class HM_TokuteiKankeiHjnNmTotugou extends GenHM_TokuteiKankeiHjnNmTotugou {

    private static final long serialVersionUID = 1L;

    public HM_TokuteiKankeiHjnNmTotugou() {
    }

    public HM_TokuteiKankeiHjnNmTotugou(
        String pTkhjnkinyuucd,
        BizNumber pMeisaino,
        Integer pRenno
    ) {
        super(
            pTkhjnkinyuucd,
            pMeisaino,
            pRenno
        );
    }

}
