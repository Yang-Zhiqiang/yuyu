package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexCfGaku;

/**
 * ファンドインデックスＣＦ額マスタ(BM_FundIndexCfGakuDao) アクセス用の DAO クラスです。<br />
 */
public class BM_FundIndexCfGakuDao extends AbstractDao<BM_FundIndexCfGaku> {

    public BM_FundIndexCfGakuDao() {
        super(BM_FundIndexCfGaku.class);
    }

    public BM_FundIndexCfGaku getFundIndexCfGaku(C_UnitFundKbn pUnitfundkbn,
         BizDate pFundhyoukaymd,
         String pSegkey){
        BM_FundIndexCfGaku bM_FundIndexCfGaku =  new BM_FundIndexCfGaku();
        bM_FundIndexCfGaku.setUnitfundkbn(pUnitfundkbn);
        bM_FundIndexCfGaku.setFundhyoukaymd(pFundhyoukaymd);
        bM_FundIndexCfGaku.setSegkey(pSegkey);
        return this.selectOne(bM_FundIndexCfGaku);
    }
}
