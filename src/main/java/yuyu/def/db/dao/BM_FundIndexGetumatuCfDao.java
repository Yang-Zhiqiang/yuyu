package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexGetumatuCf;

/**
 * ファンドインデックス月末ＣＦマスタ(BM_FundIndexGetumatuCfDao) アクセス用の DAO クラスです。<br />
 */
public class BM_FundIndexGetumatuCfDao extends AbstractDao<BM_FundIndexGetumatuCf> {

    public BM_FundIndexGetumatuCfDao() {
        super(BM_FundIndexGetumatuCf.class);
    }

    public BM_FundIndexGetumatuCf getFundIndexGetumatuCf(C_UnitFundKbn pUnitfundkbn,
         BizDate pFundhyoukaymd,
         String pSegkey){
        BM_FundIndexGetumatuCf bM_FundIndexGetumatuCf =  new BM_FundIndexGetumatuCf();
        bM_FundIndexGetumatuCf.setUnitfundkbn(pUnitfundkbn);
        bM_FundIndexGetumatuCf.setFundhyoukaymd(pFundhyoukaymd);
        bM_FundIndexGetumatuCf.setSegkey(pSegkey);
        return this.selectOne(bM_FundIndexGetumatuCf);
    }
}
