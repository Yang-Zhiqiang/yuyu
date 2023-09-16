package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.mapping.GenBM_ChkJhTuusanS;


/**
 * 通算限度Ｓ事方書チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkJhTuusanS} の JavaDoc を参照してください。<br />
 * @see     GenBM_ChkJhTuusanS<br />
 * @see     PKBM_ChkJhTuusanS<br />
 * @see     QBM_ChkJhTuusanS<br />
 * @see     GenQBM_ChkJhTuusanS<br />
 */
@Entity
public class BM_ChkJhTuusanS extends GenBM_ChkJhTuusanS {

    private static final long serialVersionUID = 1L;

    public BM_ChkJhTuusanS() {
    }

    public BM_ChkJhTuusanS(BizNumber pHhknfromnen,BizNumber pHhkntonen) {
        super(pHhknfromnen,pHhkntonen);
    }



}

