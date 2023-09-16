package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu2;

/**
 * 前納経過利率マスタ２(BM_ZennouKeikaRiritu2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouKeikaRiritu2Dao extends AbstractDao<BM_ZennouKeikaRiritu2> {

    public BM_ZennouKeikaRiritu2Dao() {
        super(BM_ZennouKeikaRiritu2.class);
    }

    public BM_ZennouKeikaRiritu2 getZennouKeikaRiritu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, Integer pKeikatukisuu, String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouKeikaRiritu2 bM_ZennouKeikaRiritu2 =  new BM_ZennouKeikaRiritu2();
        bM_ZennouKeikaRiritu2.setTuukasyu(pTuukasyu);
        bM_ZennouKeikaRiritu2.setZennoutkybr1(pZennoutkybr1);
        bM_ZennouKeikaRiritu2.setZennoutkybr2(pZennoutkybr2);
        bM_ZennouKeikaRiritu2.setZennoutkybr3(pZennoutkybr3);
        bM_ZennouKeikaRiritu2.setKeikatukisuu(pKeikatukisuu);
        bM_ZennouKeikaRiritu2.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouKeikaRiritu2.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouKeikaRiritu2);
    }

}
