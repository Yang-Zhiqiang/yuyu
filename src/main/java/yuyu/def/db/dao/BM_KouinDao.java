package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.def.db.meta.QBM_Kouin;

/**
 * 行員マスタ(BM_KouinDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KouinDao extends AbstractDao<BM_Kouin> {

    public BM_KouinDao() {
        super(BM_Kouin.class);
    }

    public BM_Kouin getKouin(String pKinyuucd,
            String pKouincd){
        BM_Kouin bM_Kouin =  new BM_Kouin();
        bM_Kouin.setKinyuucd(pKinyuucd);
        bM_Kouin.setKouincd(pKouincd);
        return this.selectOne(bM_Kouin);
    }

    public List<BM_Kouin> getKouinsBybosyuucd(String pBosyuucd) {
        BM_Kouin bM_Kouin =  new BM_Kouin();
        bM_Kouin.setBosyuucd(pBosyuucd);
        return this.select(bM_Kouin);
    }

    public List<BM_Kouin> getKouinsByKouincds(String pKinyuucd, String[] pKouincd) {


        QBM_Kouin qBM_Kouin = new QBM_Kouin();


        String querySql = $SELECT + qBM_Kouin +
                $FROM + qBM_Kouin.BM_Kouin() +
                $WHERE + qBM_Kouin.kinyuucd.eq(pKinyuucd) +
                $AND + qBM_Kouin.kouincd.in(pKouincd) +
                " order by" + " LENGTH(" + qBM_Kouin.kouincd + ")" + " ASC";

        return em.createJPQL(querySql).bind(qBM_Kouin).getResultList();
    }

}
