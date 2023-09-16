package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;

/**
 * 前納経過利率マスタ(BM_ZennouKeikaRirituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouKeikaRirituDao extends AbstractDao<BM_ZennouKeikaRiritu> {

    public BM_ZennouKeikaRirituDao() {
        super(BM_ZennouKeikaRiritu.class);
    }

    public BM_ZennouKeikaRiritu getZennouKeikaRiritu(Integer pKeikatukisuu, String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouKeikaRiritu bM_ZennouKeikaRiritu =  new BM_ZennouKeikaRiritu();
        bM_ZennouKeikaRiritu.setKeikatukisuu(pKeikatukisuu);
        bM_ZennouKeikaRiritu.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouKeikaRiritu.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouKeikaRiritu);
    }

}
