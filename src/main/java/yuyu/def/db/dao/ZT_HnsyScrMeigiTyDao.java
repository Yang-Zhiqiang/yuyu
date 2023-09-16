package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.QZT_HnsyScrMeigiTy;

/**
 * 反社スクリーニング用名義データテーブル（中）(ZT_HnsyScrMeigiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HnsyScrMeigiTyDao extends AbstractDao<ZT_HnsyScrMeigiTy> {

    public ZT_HnsyScrMeigiTyDao() {
        super(ZT_HnsyScrMeigiTy.class);
    }

    public ZT_HnsyScrMeigiTy getHnsyScrMeigiTy(String pZtytaisyounmkn, String pZtytaisyounmkj, String pZtytaisyouseiymd, String pZtynayosetaisyousegkbn, String pZtysyono) {
        ZT_HnsyScrMeigiTy zT_HnsyScrMeigiTy =  new ZT_HnsyScrMeigiTy();
        zT_HnsyScrMeigiTy.setZtytaisyounmkn(pZtytaisyounmkn);
        zT_HnsyScrMeigiTy.setZtytaisyounmkj(pZtytaisyounmkj);
        zT_HnsyScrMeigiTy.setZtytaisyouseiymd(pZtytaisyouseiymd);
        zT_HnsyScrMeigiTy.setZtynayosetaisyousegkbn(pZtynayosetaisyousegkbn);
        zT_HnsyScrMeigiTy.setZtysyono(pZtysyono);
        return this.selectOne(zT_HnsyScrMeigiTy);
    }

    public ExDBResults<ZT_HnsyScrMeigiTy> selectAllZT_HnsyScrMeigiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_HnsyScrMeigiTy qZT_HnsyScrMeigiTy =  new QZT_HnsyScrMeigiTy();
        jpql.append($SELECT);
        jpql.append(qZT_HnsyScrMeigiTy);
        jpql.append($FROM);
        jpql.append(qZT_HnsyScrMeigiTy.ZT_HnsyScrMeigiTy());
        jpql.append($ORDER_BY(qZT_HnsyScrMeigiTy.ztytaisyounmkn.asc(), qZT_HnsyScrMeigiTy.ztytaisyounmkj.asc(), qZT_HnsyScrMeigiTy.ztytaisyouseiymd.asc(), qZT_HnsyScrMeigiTy.ztynayosetaisyousegkbn.asc(), qZT_HnsyScrMeigiTy.ztysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HnsyScrMeigiTy).getResults();
    }
}
