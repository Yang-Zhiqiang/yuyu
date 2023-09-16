package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileTy;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileTy;

/**
 * 会計取引ファイルテーブル（中）(ZT_KaikeiTorihikiFileTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KaikeiTorihikiFileTyDao extends AbstractDao<ZT_KaikeiTorihikiFileTy> {

    public ZT_KaikeiTorihikiFileTyDao() {
        super(ZT_KaikeiTorihikiFileTy.class);
    }

    public ZT_KaikeiTorihikiFileTy getKaikeiTorihikiFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn, String pZtysuitoubumon, String pZtytekiyoucd) {
        ZT_KaikeiTorihikiFileTy zT_KaikeiTorihikiFileTy =  new ZT_KaikeiTorihikiFileTy();
        zT_KaikeiTorihikiFileTy.setZtytorihikiymd(pZtytorihikiymd);
        zT_KaikeiTorihikiFileTy.setZtytorihikinon7(pZtytorihikinon7);
        zT_KaikeiTorihikiFileTy.setZtytaisyakukbnn(pZtytaisyakukbnn);
        zT_KaikeiTorihikiFileTy.setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
        zT_KaikeiTorihikiFileTy.setZtysuitoubumon(pZtysuitoubumon);
        zT_KaikeiTorihikiFileTy.setZtytekiyoucd(pZtytekiyoucd);
        return this.selectOne(zT_KaikeiTorihikiFileTy);
    }

    public ExDBResults<ZT_KaikeiTorihikiFileTy> selectAllZT_KaikeiTorihikiFileTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KaikeiTorihikiFileTy qZT_KaikeiTorihikiFileTy =  new QZT_KaikeiTorihikiFileTy();
        jpql.append($SELECT);
        jpql.append(qZT_KaikeiTorihikiFileTy);
        jpql.append($FROM);
        jpql.append(qZT_KaikeiTorihikiFileTy.ZT_KaikeiTorihikiFileTy());
        jpql.append($ORDER_BY(qZT_KaikeiTorihikiFileTy.ztytorihikiymd.asc(), qZT_KaikeiTorihikiFileTy.ztytorihikinon7.asc(), qZT_KaikeiTorihikiFileTy.ztytaisyakukbnn.asc(), qZT_KaikeiTorihikiFileTy.ztykanjyoukamokucdn.asc(), qZT_KaikeiTorihikiFileTy.ztysuitoubumon.asc(), qZT_KaikeiTorihikiFileTy.ztytekiyoucd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KaikeiTorihikiFileTy).getResults();
    }
}
