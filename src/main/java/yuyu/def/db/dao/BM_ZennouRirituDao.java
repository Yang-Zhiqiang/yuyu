package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_ZennouRiritu;

/**
 * 前納利率マスタ(BM_ZennouRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouRirituDao extends AbstractDao<BM_ZennouRiritu> {

    public BM_ZennouRirituDao() {
        super(BM_ZennouRiritu.class);
    }

    public BM_ZennouRiritu getZennouRiritu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouRiritu bM_ZennouRiritu =  new BM_ZennouRiritu();
        bM_ZennouRiritu.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouRiritu.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouRiritu);
    }

}
