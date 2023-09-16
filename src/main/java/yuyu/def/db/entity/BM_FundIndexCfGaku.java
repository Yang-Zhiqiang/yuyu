package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenBM_FundIndexCfGaku;


/**
 * ファンドインデックスＣＦ額マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_FundIndexCfGaku} の JavaDoc を参照してください。<br />
 * @see     GenBM_FundIndexCfGaku<br />
 * @see     PKBM_FundIndexCfGaku<br />
 * @see     QBM_FundIndexCfGaku<br />
 * @see     GenQBM_FundIndexCfGaku<br />
 */
@Entity
public class BM_FundIndexCfGaku extends GenBM_FundIndexCfGaku {

    private static final long serialVersionUID = 1L;

    public BM_FundIndexCfGaku() {
    }

    public BM_FundIndexCfGaku(C_UnitFundKbn pUnitfundkbn,BizDate pFundhyoukaymd,String pSegkey) {
        super(pUnitfundkbn,pFundhyoukaymd,pSegkey);
    }



}

