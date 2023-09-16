package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenBM_FundIndexKihon;


/**
 * ファンドインデックス基本マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_FundIndexKihon} の JavaDoc を参照してください。<br />
 * @see     GenBM_FundIndexKihon<br />
 * @see     PKBM_FundIndexKihon<br />
 * @see     QBM_FundIndexKihon<br />
 * @see     GenQBM_FundIndexKihon<br />
 */
@Entity
public class BM_FundIndexKihon extends GenBM_FundIndexKihon {

    private static final long serialVersionUID = 1L;

    public BM_FundIndexKihon() {
    }

    public BM_FundIndexKihon(C_UnitFundKbn pUnitfundkbn,BizDate pFundhyoukaymd) {
        super(pUnitfundkbn,pFundhyoukaymd);
    }



}

