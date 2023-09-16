package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.db.mapping.GenBM_PalSyoumetujiyuu;

/**
 * ＰＡＬ消滅事由マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_PalSyoumetujiyuu} の JavaDoc を参照してください。<br />
 * @see     GenBM_PalSyoumetujiyuu<br />
 * @see     PKBM_PalSyoumetujiyuu<br />
 * @see     QBM_PalSyoumetujiyuu<br />
 * @see     GenQBM_PalSyoumetujiyuu<br />
 */
@Entity
public class BM_PalSyoumetujiyuu extends GenBM_PalSyoumetujiyuu {

    private static final long serialVersionUID = 1L;

    public BM_PalSyoumetujiyuu() {
    }

    public BM_PalSyoumetujiyuu(String pPalsyoumetucd,C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        super(pPalsyoumetucd,pBetukutikeiyakukbn);
    }



}

