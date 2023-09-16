package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_TantouCd;
/**
 * 担当コードマスタ(BM_TantouCdDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TantouCdDao extends AbstractDao<BM_TantouCd> {

    public BM_TantouCdDao() {
        super(BM_TantouCd.class);
    }

    public BM_TantouCd getTantouCd(C_TantouCdKbn pTantocd){
        BM_TantouCd bM_TantouCd =  new BM_TantouCd();
        bM_TantouCd.setTantocd(pTantocd);
        return this.selectOne(bM_TantouCd);
    }
}
