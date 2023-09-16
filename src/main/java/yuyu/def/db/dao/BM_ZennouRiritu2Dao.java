package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouRiritu2;

/**
 * 前納利率マスタ２(BM_ZennouRiritu2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouRiritu2Dao extends AbstractDao<BM_ZennouRiritu2> {

    public BM_ZennouRiritu2Dao() {
        super(BM_ZennouRiritu2.class);
    }

    public BM_ZennouRiritu2 getZennouRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouRiritu2 bM_ZennouRiritu2 =  new BM_ZennouRiritu2();
        bM_ZennouRiritu2.setTuukasyu(pTuukasyu);
        bM_ZennouRiritu2.setZennoutkybr1(pZennoutkybr1);
        bM_ZennouRiritu2.setZennoutkybr2(pZennoutkybr2);
        bM_ZennouRiritu2.setZennoutkybr3(pZennoutkybr3);
        bM_ZennouRiritu2.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouRiritu2.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouRiritu2);
    }

}
