package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_ZennouTumitateRitu;

/**
 * 前納積立率マスタ(BM_ZennouTumitateRituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouTumitateRituDao extends AbstractDao<BM_ZennouTumitateRitu> {

    public BM_ZennouTumitateRituDao() {
        super(BM_ZennouTumitateRitu.class);
    }

    public BM_ZennouTumitateRitu getZennouTumitateRitu(String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouTumitateRitu bM_ZennouTumitateRitu =  new BM_ZennouTumitateRitu();
        bM_ZennouTumitateRitu.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouTumitateRitu.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouTumitateRitu);
    }

}
