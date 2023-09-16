package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileTy;
import yuyu.def.db.meta.QZT_SkKaikeiTorihikiFileTy;

/**
 * 新契約会計取引ファイルテーブル（中）(ZT_SkKaikeiTorihikiFileTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKaikeiTorihikiFileTyDao extends AbstractDao<ZT_SkKaikeiTorihikiFileTy> {

    public ZT_SkKaikeiTorihikiFileTyDao() {
        super(ZT_SkKaikeiTorihikiFileTy.class);
    }

    public ZT_SkKaikeiTorihikiFileTy getSkKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn, String pZtysuitoubumon, String pZtytekiyoucd) {
        ZT_SkKaikeiTorihikiFileTy zT_SkKaikeiTorihikiFileTy =  new ZT_SkKaikeiTorihikiFileTy();
        zT_SkKaikeiTorihikiFileTy.setZtytorihikiymd(pZtytorihikiymd);
        zT_SkKaikeiTorihikiFileTy.setZtytorihikinon7(pZtytorihikinon7);
        zT_SkKaikeiTorihikiFileTy.setZtytaisyakukbnn(pZtytaisyakukbnn);
        zT_SkKaikeiTorihikiFileTy.setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
        zT_SkKaikeiTorihikiFileTy.setZtysuitoubumon(pZtysuitoubumon);
        zT_SkKaikeiTorihikiFileTy.setZtytekiyoucd(pZtytekiyoucd);
        return this.selectOne(zT_SkKaikeiTorihikiFileTy);
    }

    public ExDBResults<ZT_SkKaikeiTorihikiFileTy> selectAllZT_SkKaikeiTorihikiFileTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKaikeiTorihikiFileTy qZT_SkKaikeiTorihikiFileTy =  new QZT_SkKaikeiTorihikiFileTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkKaikeiTorihikiFileTy);
        jpql.append($FROM);
        jpql.append(qZT_SkKaikeiTorihikiFileTy.ZT_SkKaikeiTorihikiFileTy());
        jpql.append($ORDER_BY(qZT_SkKaikeiTorihikiFileTy.ztytorihikiymd.asc(), qZT_SkKaikeiTorihikiFileTy.ztytorihikinon7.asc(), qZT_SkKaikeiTorihikiFileTy.ztytaisyakukbnn.asc(), qZT_SkKaikeiTorihikiFileTy.ztykanjyoukamokucdn.asc(), qZT_SkKaikeiTorihikiFileTy.ztysuitoubumon.asc(), qZT_SkKaikeiTorihikiFileTy.ztytekiyoucd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKaikeiTorihikiFileTy).getResults();
    }
}
