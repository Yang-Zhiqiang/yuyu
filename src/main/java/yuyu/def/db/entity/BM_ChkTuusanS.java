package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_ChkTuusanS;


/**
 * 通算限度Ｓチェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkTuusanS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkTuusanS<br />
 * @see     PKBM_ChkTuusanS<br />
 * @see     QBM_ChkTuusanS<br />
 * @see     GenQBM_ChkTuusanS<br />
 */
@Entity
public class BM_ChkTuusanS extends GenBM_ChkTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkTuusanS() {
    }

    public BM_ChkTuusanS(BizNumber pHhknfromnen,BizNumber pHhkntonen) {
        super(pHhknfromnen,pHhkntonen);
    }



}

