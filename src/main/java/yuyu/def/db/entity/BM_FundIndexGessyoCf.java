package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenBM_FundIndexGessyoCf;


/**
 * ファンドインデックス月初ＣＦマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_FundIndexGessyoCf} の JavaDoc を参照してください。<br />
 * @see     GenBM_FundIndexGessyoCf<br />
 * @see     PKBM_FundIndexGessyoCf<br />
 * @see     QBM_FundIndexGessyoCf<br />
 * @see     GenQBM_FundIndexGessyoCf<br />
 */
@Entity
public class BM_FundIndexGessyoCf extends GenBM_FundIndexGessyoCf {

    private static final long serialVersionUID = 1L;

    public BM_FundIndexGessyoCf() {
    }

    public BM_FundIndexGessyoCf(C_UnitFundKbn pUnitfundkbn,BizDate pFundhyoukaymd,String pSegkey) {
        super(pUnitfundkbn,pFundhyoukaymd,pSegkey);
    }



}

