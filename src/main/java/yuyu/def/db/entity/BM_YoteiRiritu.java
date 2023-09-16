package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenBM_YoteiRiritu;


/**
 * 予定利率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_YoteiRiritu} の JavaDoc を参照してください。<br />
 * @see     GenBM_YoteiRiritu<br />
 * @see     PKBM_YoteiRiritu<br />
 * @see     QBM_YoteiRiritu<br />
 * @see     GenQBM_YoteiRiritu<br />
 */
@Entity
public class BM_YoteiRiritu extends GenBM_YoteiRiritu {

    private static final long serialVersionUID = 1L;

    public BM_YoteiRiritu() {
    }

    public BM_YoteiRiritu(String pSyouhncd,C_Tuukasyu pTuukasyu,C_HhknNenKbn pHhknnenkbn,BizDate pKykfromymd,BizDate pKyktoymd) {
        super(pSyouhncd,pTuukasyu,pHhknnenkbn,pKykfromymd,pKyktoymd);
    }



}

