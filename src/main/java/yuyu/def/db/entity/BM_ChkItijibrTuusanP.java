package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkItijibrTuusanP;
import yuyu.def.db.mapping.GenBM_ChkItijibrTuusanP;
import yuyu.def.db.meta.GenQBM_ChkItijibrTuusanP;
import yuyu.def.db.meta.QBM_ChkItijibrTuusanP;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 一時払通算限度Ｐチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkItijibrTuusanP} の JavaDoc を参照してください。
 * @see     GenBM_ChkItijibrTuusanP
 * @see     PKBM_ChkItijibrTuusanP
 * @see     QBM_ChkItijibrTuusanP
 * @see     GenQBM_ChkItijibrTuusanP
 */
@Entity
public class BM_ChkItijibrTuusanP extends GenBM_ChkItijibrTuusanP {

    private static final long serialVersionUID = 1L;

    public BM_ChkItijibrTuusanP() {
    }

    public BM_ChkItijibrTuusanP(BizNumber pHhknfromnen, BizNumber pHhkntonen) {
        super(pHhknfromnen, pHhkntonen);
    }

}
