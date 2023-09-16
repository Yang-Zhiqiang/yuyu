package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexKihon;

/**
 * ファンドインデックス基本マスタ(BM_FundIndexKihonDao) アクセス用の DAO クラスです。<br />
 */
public class BM_FundIndexKihonDao extends AbstractDao<BM_FundIndexKihon> {

    public BM_FundIndexKihonDao() {
        super(BM_FundIndexKihon.class);
    }

    public BM_FundIndexKihon getFundIndexKihon(C_UnitFundKbn pUnitfundkbn,
         BizDate pFundhyoukaymd){
        BM_FundIndexKihon bM_FundIndexKihon =  new BM_FundIndexKihon();
        bM_FundIndexKihon.setUnitfundkbn(pUnitfundkbn);
        bM_FundIndexKihon.setFundhyoukaymd(pFundhyoukaymd);
        return this.selectOne(bM_FundIndexKihon);
    }
}
