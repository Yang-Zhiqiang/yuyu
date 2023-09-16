package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.mapping.GenBM_FundIndexGetumatuCf;


/**
 * ファンドインデックス月末ＣＦマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_FundIndexGetumatuCf} の JavaDoc を参照してください。<br />
 * @see     GenBM_FundIndexGetumatuCf<br />
 * @see     PKBM_FundIndexGetumatuCf<br />
 * @see     QBM_FundIndexGetumatuCf<br />
 * @see     GenQBM_FundIndexGetumatuCf<br />
 */
@Entity
public class BM_FundIndexGetumatuCf extends GenBM_FundIndexGetumatuCf {

    private static final long serialVersionUID = 1L;

    public BM_FundIndexGetumatuCf() {
    }

    public BM_FundIndexGetumatuCf(C_UnitFundKbn pUnitfundkbn,BizDate pFundhyoukaymd,String pSegkey) {
        super(pUnitfundkbn,pFundhyoukaymd,pSegkey);
    }



}

