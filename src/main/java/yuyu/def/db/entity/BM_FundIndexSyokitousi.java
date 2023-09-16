package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenBM_FundIndexSyokitousi;


/**
 * ファンドインデックス初期投資マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_FundIndexSyokitousi} の JavaDoc を参照してください。<br />
 * @see     GenBM_FundIndexSyokitousi<br />
 * @see     PKBM_FundIndexSyokitousi<br />
 * @see     QBM_FundIndexSyokitousi<br />
 * @see     GenQBM_FundIndexSyokitousi<br />
 */
@Entity
public class BM_FundIndexSyokitousi extends GenBM_FundIndexSyokitousi {

    private static final long serialVersionUID = 1L;

    public BM_FundIndexSyokitousi() {
    }

    public BM_FundIndexSyokitousi(C_UnitFundKbn pUnitfundkbn,BizDate pFundhyoukaymd,String pSegkey) {
        super(pUnitfundkbn,pFundhyoukaymd,pSegkey);
    }



}

