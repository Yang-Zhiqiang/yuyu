package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;

/**
 * 前納積立率マスタ２(BM_ZennouTumitateRitu2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_ZennouTumitateRitu2Dao extends AbstractDao<BM_ZennouTumitateRitu2> {

    public BM_ZennouTumitateRitu2Dao() {
        super(BM_ZennouTumitateRitu2.class);
    }

    public BM_ZennouTumitateRitu2 getZennouTumitateRitu2(C_Tuukasyu pTuukasyu, String pZennoutkybr1, String pZennoutkybr2, String pZennoutkybr3, String pTekiyoukknfrom, String pTekiyoukknkto) {
        BM_ZennouTumitateRitu2 bM_ZennouTumitateRitu2 =  new BM_ZennouTumitateRitu2();
        bM_ZennouTumitateRitu2.setTuukasyu(pTuukasyu);
        bM_ZennouTumitateRitu2.setZennoutkybr1(pZennoutkybr1);
        bM_ZennouTumitateRitu2.setZennoutkybr2(pZennoutkybr2);
        bM_ZennouTumitateRitu2.setZennoutkybr3(pZennoutkybr3);
        bM_ZennouTumitateRitu2.setTekiyoukknfrom(pTekiyoukknfrom);
        bM_ZennouTumitateRitu2.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(bM_ZennouTumitateRitu2);
    }

}
