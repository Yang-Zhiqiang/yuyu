package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiTy;
import yuyu.def.db.meta.QZT_SkKsnKaikeiTorihikiTy;

/**
 * 新契約決算用会計取引Ｆテーブル（中）(ZT_SkKsnKaikeiTorihikiTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnKaikeiTorihikiTyDao extends AbstractDao<ZT_SkKsnKaikeiTorihikiTy> {

    public ZT_SkKsnKaikeiTorihikiTyDao() {
        super(ZT_SkKsnKaikeiTorihikiTy.class);
    }

    public ZT_SkKsnKaikeiTorihikiTy getSkKsnKaikeiTorihikiTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn, String pZtysuitoubumon, String pZtytekiyoucd) {
        ZT_SkKsnKaikeiTorihikiTy zT_SkKsnKaikeiTorihikiTy =  new ZT_SkKsnKaikeiTorihikiTy();
        zT_SkKsnKaikeiTorihikiTy.setZtytorihikiymd(pZtytorihikiymd);
        zT_SkKsnKaikeiTorihikiTy.setZtytorihikinon7(pZtytorihikinon7);
        zT_SkKsnKaikeiTorihikiTy.setZtytaisyakukbnn(pZtytaisyakukbnn);
        zT_SkKsnKaikeiTorihikiTy.setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
        zT_SkKsnKaikeiTorihikiTy.setZtysuitoubumon(pZtysuitoubumon);
        zT_SkKsnKaikeiTorihikiTy.setZtytekiyoucd(pZtytekiyoucd);
        return this.selectOne(zT_SkKsnKaikeiTorihikiTy);
    }

    public ExDBResults<ZT_SkKsnKaikeiTorihikiTy> selectAllZT_SkKsnKaikeiTorihikiTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnKaikeiTorihikiTy qZT_SkKsnKaikeiTorihikiTy =  new QZT_SkKsnKaikeiTorihikiTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnKaikeiTorihikiTy);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnKaikeiTorihikiTy.ZT_SkKsnKaikeiTorihikiTy());
        jpql.append($ORDER_BY(qZT_SkKsnKaikeiTorihikiTy.ztytorihikiymd.asc(), qZT_SkKsnKaikeiTorihikiTy.ztytorihikinon7.asc(), qZT_SkKsnKaikeiTorihikiTy.ztytaisyakukbnn.asc(), qZT_SkKsnKaikeiTorihikiTy.ztykanjyoukamokucdn.asc(), qZT_SkKsnKaikeiTorihikiTy.ztysuitoubumon.asc(), qZT_SkKsnKaikeiTorihikiTy.ztytekiyoucd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnKaikeiTorihikiTy).getResults();
    }
}
