package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriTy;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriTy;

/**
 * 新契約決算用区分経理Ｆテーブル（中）(ZT_SkKsnKubunKeiriTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnKubunKeiriTyDao extends AbstractDao<ZT_SkKsnKubunKeiriTy> {

    public ZT_SkKsnKubunKeiriTyDao() {
        super(ZT_SkKsnKubunKeiriTy.class);
    }

    public ZT_SkKsnKubunKeiriTy getSkKsnKubunKeiriTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn, String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {
        ZT_SkKsnKubunKeiriTy zT_SkKsnKubunKeiriTy =  new ZT_SkKsnKubunKeiriTy();
        zT_SkKsnKubunKeiriTy.setZtytorihikiymd(pZtytorihikiymd);
        zT_SkKsnKubunKeiriTy.setZtytorihikinon7(pZtytorihikinon7);
        zT_SkKsnKubunKeiriTy.setZtytaisyakukbnn(pZtytaisyakukbnn);
        zT_SkKsnKubunKeiriTy.setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
        zT_SkKsnKubunKeiriTy.setZtysuitoubumoncd(pZtysuitoubumoncd);
        zT_SkKsnKubunKeiriTy.setZtykizokusegment(pZtykizokusegment);
        zT_SkKsnKubunKeiriTy.setZtyaitesegment(pZtyaitesegment);
        return this.selectOne(zT_SkKsnKubunKeiriTy);
    }

    public ExDBResults<ZT_SkKsnKubunKeiriTy> selectAllZT_SkKsnKubunKeiriTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnKubunKeiriTy qZT_SkKsnKubunKeiriTy =  new QZT_SkKsnKubunKeiriTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnKubunKeiriTy);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnKubunKeiriTy.ZT_SkKsnKubunKeiriTy());
        jpql.append($ORDER_BY(qZT_SkKsnKubunKeiriTy.ztytorihikiymd.asc(), qZT_SkKsnKubunKeiriTy.ztytorihikinon7.asc(), qZT_SkKsnKubunKeiriTy.ztytaisyakukbnn.asc(), qZT_SkKsnKubunKeiriTy.ztykanjyoukamokucdn.asc(), qZT_SkKsnKubunKeiriTy.ztysuitoubumoncd.asc(), qZT_SkKsnKubunKeiriTy.ztykizokusegment.asc(), qZT_SkKsnKubunKeiriTy.ztyaitesegment.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnKubunKeiriTy).getResults();
    }
}
