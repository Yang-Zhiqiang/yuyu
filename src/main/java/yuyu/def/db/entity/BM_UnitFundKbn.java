package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenBM_UnitFundKbn;


/**
 * ユニットファンド区分マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_UnitFundKbn} の JavaDoc を参照してください。<br />
 * @see     GenBM_UnitFundKbn<br />
 * @see     PKBM_UnitFundKbn<br />
 * @see     QBM_UnitFundKbn<br />
 * @see     GenQBM_UnitFundKbn<br />
 */
@Entity
public class BM_UnitFundKbn extends GenBM_UnitFundKbn {

    private static final long serialVersionUID = 1L;

    public BM_UnitFundKbn() {
    }

    public BM_UnitFundKbn(String pSyouhncd,Integer pSyouhnsdno,C_Tuukasyu pTuukasyu,Integer pRenno) {
        super(pSyouhncd,pSyouhnsdno,pTuukasyu,pRenno);
    }



}

