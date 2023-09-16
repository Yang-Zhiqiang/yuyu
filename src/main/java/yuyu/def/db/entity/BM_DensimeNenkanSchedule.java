package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.db.mapping.GenBM_DensimeNenkanSchedule;


/**
 * 伝票締切日年間スケジュールマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_DensimeNenkanSchedule} の JavaDoc を参照してください。<br />
 * @see     GenBM_DensimeNenkanSchedule<br />
 * @see     PKBM_DensimeNenkanSchedule<br />
 * @see     QBM_DensimeNenkanSchedule<br />
 * @see     GenQBM_DensimeNenkanSchedule<br />
 */
@Entity
public class BM_DensimeNenkanSchedule extends GenBM_DensimeNenkanSchedule {

    private static final long serialVersionUID = 1L;

    public BM_DensimeNenkanSchedule() {
    }

    public BM_DensimeNenkanSchedule(BizDateYM pSyoriym) {
        super(pSyoriym);
    }



}

