package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexSyokitousi;

/**
 * ファンドインデックス初期投資マスタ(BM_FundIndexSyokitousiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_FundIndexSyokitousiDao extends AbstractDao<BM_FundIndexSyokitousi> {

    public BM_FundIndexSyokitousiDao() {
        super(BM_FundIndexSyokitousi.class);
    }

    public BM_FundIndexSyokitousi getFundIndexSyokitousi(C_UnitFundKbn pUnitfundkbn,
         BizDate pFundhyoukaymd,
         String pSegkey){
        BM_FundIndexSyokitousi bM_FundIndexSyokitousi =  new BM_FundIndexSyokitousi();
        bM_FundIndexSyokitousi.setUnitfundkbn(pUnitfundkbn);
        bM_FundIndexSyokitousi.setFundhyoukaymd(pFundhyoukaymd);
        bM_FundIndexSyokitousi.setSegkey(pSegkey);
        return this.selectOne(bM_FundIndexSyokitousi);
    }
}
