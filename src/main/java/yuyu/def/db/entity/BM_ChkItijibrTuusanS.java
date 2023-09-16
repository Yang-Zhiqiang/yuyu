package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.mapping.GenBM_ChkItijibrTuusanS;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 一時払通算限度Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkItijibrTuusanS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkItijibrTuusanS<br />
 * @see     PKBM_ChkItijibrTuusanS<br />
 * @see     QBM_ChkItijibrTuusanS<br />
 * @see     GenQBM_ChkItijibrTuusanS<br />
 */
@Entity
public class BM_ChkItijibrTuusanS extends GenBM_ChkItijibrTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkItijibrTuusanS() {
    }

    public BM_ChkItijibrTuusanS(BizNumber pHhknfromnen,BizNumber pHhkntonen) {
        super(pHhknfromnen,pHhkntonen);
    }

}
