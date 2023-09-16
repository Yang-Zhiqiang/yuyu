package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouGenkaRitu2;

/**
 * 前納現価率マスタ２(BM_ZennouGenkaRitu2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouGenkaRitu2Dao extends AbstractDao<BM_ZennouGenkaRitu2> {

    public BM_ZennouGenkaRitu2Dao() {
        super(BM_ZennouGenkaRitu2.class);
    }

    public BM_ZennouGenkaRitu2 getZennouGenkaRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pZennounensuu, String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouGenkaRitu2 bM_ZennouGenkaRitu2 =  new BM_ZennouGenkaRitu2();
        bM_ZennouGenkaRitu2.setTuukasyu(pTuukasyu);
        bM_ZennouGenkaRitu2.setZennoutkybr1(pZennoutkybr1);
        bM_ZennouGenkaRitu2.setZennoutkybr2(pZennoutkybr2);
        bM_ZennouGenkaRitu2.setZennoutkybr3(pZennoutkybr3);
        bM_ZennouGenkaRitu2.setZennounensuu(pZennounensuu);
        bM_ZennouGenkaRitu2.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouGenkaRitu2.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouGenkaRitu2);
    }

}
