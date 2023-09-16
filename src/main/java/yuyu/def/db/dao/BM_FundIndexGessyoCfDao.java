package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexGessyoCf;

/**
 * ファンドインデックス月初ＣＦマスタ(BM_FundIndexGessyoCfDao) アクセス用の DAO クラスです。<br />
 */
public class BM_FundIndexGessyoCfDao extends AbstractDao<BM_FundIndexGessyoCf> {

    public BM_FundIndexGessyoCfDao() {
        super(BM_FundIndexGessyoCf.class);
    }

    public BM_FundIndexGessyoCf getFundIndexGessyoCf(C_UnitFundKbn pUnitfundkbn,
         BizDate pFundhyoukaymd,
         String pSegkey){
        BM_FundIndexGessyoCf bM_FundIndexGessyoCf =  new BM_FundIndexGessyoCf();
        bM_FundIndexGessyoCf.setUnitfundkbn(pUnitfundkbn);
        bM_FundIndexGessyoCf.setFundhyoukaymd(pFundhyoukaymd);
        bM_FundIndexGessyoCf.setSegkey(pSegkey);
        return this.selectOne(bM_FundIndexGessyoCf);
    }
}
