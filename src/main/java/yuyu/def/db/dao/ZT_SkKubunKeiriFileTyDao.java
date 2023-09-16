package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileTy;
import yuyu.def.db.meta.QZT_SkKubunKeiriFileTy;

/**
 * 新契約区分経理ファイルテーブル（中）(ZT_SkKubunKeiriFileTyDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKubunKeiriFileTyDao extends AbstractDao<ZT_SkKubunKeiriFileTy> {

    public ZT_SkKubunKeiriFileTyDao() {
        super(ZT_SkKubunKeiriFileTy.class);
    }

    public ZT_SkKubunKeiriFileTy getSkKubunKeiriFileTy(String pZtytorihikiymd, String pZtytorihikinon7, String pZtytaisyakukbnn, String pZtykanjyoukamokucdn, String pZtysuitoubumoncd, String pZtykizokusegment, String pZtyaitesegment) {
        ZT_SkKubunKeiriFileTy zT_SkKubunKeiriFileTy =  new ZT_SkKubunKeiriFileTy();
        zT_SkKubunKeiriFileTy.setZtytorihikiymd(pZtytorihikiymd);
        zT_SkKubunKeiriFileTy.setZtytorihikinon7(pZtytorihikinon7);
        zT_SkKubunKeiriFileTy.setZtytaisyakukbnn(pZtytaisyakukbnn);
        zT_SkKubunKeiriFileTy.setZtykanjyoukamokucdn(pZtykanjyoukamokucdn);
        zT_SkKubunKeiriFileTy.setZtysuitoubumoncd(pZtysuitoubumoncd);
        zT_SkKubunKeiriFileTy.setZtykizokusegment(pZtykizokusegment);
        zT_SkKubunKeiriFileTy.setZtyaitesegment(pZtyaitesegment);
        return this.selectOne(zT_SkKubunKeiriFileTy);
    }

    public ExDBResults<ZT_SkKubunKeiriFileTy> selectAllZT_SkKubunKeiriFileTy() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKubunKeiriFileTy qZT_SkKubunKeiriFileTy =  new QZT_SkKubunKeiriFileTy();
        jpql.append($SELECT);
        jpql.append(qZT_SkKubunKeiriFileTy);
        jpql.append($FROM);
        jpql.append(qZT_SkKubunKeiriFileTy.ZT_SkKubunKeiriFileTy());
        jpql.append($ORDER_BY(qZT_SkKubunKeiriFileTy.ztytorihikiymd.asc(), qZT_SkKubunKeiriFileTy.ztytorihikinon7.asc(), qZT_SkKubunKeiriFileTy.ztytaisyakukbnn.asc(), qZT_SkKubunKeiriFileTy.ztykanjyoukamokucdn.asc(), qZT_SkKubunKeiriFileTy.ztysuitoubumoncd.asc(), qZT_SkKubunKeiriFileTy.ztykizokusegment.asc(), qZT_SkKubunKeiriFileTy.ztyaitesegment.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKubunKeiriFileTy).getResults();
    }
}
