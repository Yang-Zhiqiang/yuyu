package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenBM_NenkinYoteiRiritu;


/**
 * 年金開始後予定利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_NenkinYoteiRiritu} の JavaDoc を参照してください。<br />
 * @see     GenBM_NenkinYoteiRiritu<br />
 * @see     PKBM_NenkinYoteiRiritu<br />
 * @see     QBM_NenkinYoteiRiritu<br />
 * @see     GenQBM_NenkinYoteiRiritu<br />
 */
@Entity
public class BM_NenkinYoteiRiritu extends GenBM_NenkinYoteiRiritu {

    private static final long serialVersionUID = 1L;

    public BM_NenkinYoteiRiritu() {
    }

    public BM_NenkinYoteiRiritu(String pNenkinsyu,C_Tuukasyu pTuukasyu,BizDate pKykfromymd,BizDate pKyktoymd) {
        super(pNenkinsyu,pTuukasyu,pKykfromymd,pKyktoymd);
    }



}

