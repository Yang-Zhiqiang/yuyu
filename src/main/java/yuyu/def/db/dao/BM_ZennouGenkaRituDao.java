package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_ZennouGenkaRitu;

/**
 * 前納現価率マスタ(BM_ZennouGenkaRituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouGenkaRituDao extends AbstractDao<BM_ZennouGenkaRitu> {

    public BM_ZennouGenkaRituDao() {
        super(BM_ZennouGenkaRitu.class);
    }

    public BM_ZennouGenkaRitu getZennouGenkaRitu(Integer pZennounensuu, String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouGenkaRitu bM_ZennouGenkaRitu =  new BM_ZennouGenkaRitu();
        bM_ZennouGenkaRitu.setZennounensuu(pZennounensuu);
        bM_ZennouGenkaRitu.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouGenkaRitu.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouGenkaRitu);
    }

}
