package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_UnitFundKbn;

/**
 * ユニットファンド区分マスタ(BM_UnitFundKbnDao) アクセス用の DAO クラスです。<br />
 */
public class BM_UnitFundKbnDao extends AbstractDao<BM_UnitFundKbn> {

    public BM_UnitFundKbnDao() {
        super(BM_UnitFundKbn.class);
    }

    public BM_UnitFundKbn getUnitFundKbn(String pSyouhncd,
         Integer pSyouhnsdno,
         C_Tuukasyu pTuukasyu,
         Integer pRenno){
        BM_UnitFundKbn bM_UnitFundKbn =  new BM_UnitFundKbn();
        bM_UnitFundKbn.setSyouhncd(pSyouhncd);
        bM_UnitFundKbn.setSyouhnsdno(pSyouhnsdno);
        bM_UnitFundKbn.setTuukasyu(pTuukasyu);
        bM_UnitFundKbn.setRenno(pRenno);
        return this.selectOne(bM_UnitFundKbn);
    }
}
