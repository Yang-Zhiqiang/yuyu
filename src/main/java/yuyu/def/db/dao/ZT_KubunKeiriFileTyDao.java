package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KubunKeiriFileTy;
import yuyu.def.db.meta.QZT_KubunKeiriFileTy;

/**
 * 区分経理ファイルテーブル（中）(ZT_KubunKeiriFileTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KubunKeiriFileTyDao extends AbstractDao<ZT_KubunKeiriFileTy> {

    public ZT_KubunKeiriFileTyDao() {
        super(ZT_KubunKeiriFileTy.class);
    }

    public ZT_KubunKeiriFileTy getKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn, String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {
        ZT_KubunKeiriFileTy zT_KubunKeiriFileTy =  new ZT_KubunKeiriFileTy();
        zT_KubunKeiriFileTy.setZtytorihikiymd(pZtytorihikiymd);
        zT_KubunKeiriFileTy.setZtytorihikinon7(pZtytorihikinon7);
        zT_KubunKeiriFileTy.setZtytaisyakukbnn(pZtytaisyakukbnn);
        zT_KubunKeiriFileTy.setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
        zT_KubunKeiriFileTy.setZtysuitoubumoncd(pZtysuitoubumoncd);
        zT_KubunKeiriFileTy.setZtykizokusegment(pZtykizokusegment);
        zT_KubunKeiriFileTy.setZtyaitesegment(pZtyaitesegment);
        return this.selectOne(zT_KubunKeiriFileTy);
    }

    public ExDBResults<ZT_KubunKeiriFileTy> selectAllZT_KubunKeiriFileTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_KubunKeiriFileTy qZT_KubunKeiriFileTy =  new QZT_KubunKeiriFileTy();
        jpql.append($SELECT);
        jpql.append(qZT_KubunKeiriFileTy);
        jpql.append($FROM);
        jpql.append(qZT_KubunKeiriFileTy.ZT_KubunKeiriFileTy());
        jpql.append($ORDER_BY(qZT_KubunKeiriFileTy.ztytorihikiymd.asc(), qZT_KubunKeiriFileTy.ztytorihikinon7.asc(), qZT_KubunKeiriFileTy.ztytaisyakukbnn.asc(), qZT_KubunKeiriFileTy.ztykanjyoukamokucdn.asc(), qZT_KubunKeiriFileTy.ztysuitoubumoncd.asc(), qZT_KubunKeiriFileTy.ztykizokusegment.asc(), qZT_KubunKeiriFileTy.ztyaitesegment.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KubunKeiriFileTy).getResults();
    }
}
