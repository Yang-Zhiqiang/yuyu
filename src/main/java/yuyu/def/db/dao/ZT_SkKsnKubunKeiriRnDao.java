package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriRn;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriRn;

/**
 * 新契約決算用区分経理Ｆテーブル（連）(ZT_SkKsnKubunKeiriRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnKubunKeiriRnDao extends AbstractDao<ZT_SkKsnKubunKeiriRn> {

    public ZT_SkKsnKubunKeiriRnDao() {
        super(ZT_SkKsnKubunKeiriRn.class);
    }

    public ZT_SkKsnKubunKeiriRn getSkKsnKubunKeiriRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn, String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {
        ZT_SkKsnKubunKeiriRn zT_SkKsnKubunKeiriRn =  new ZT_SkKsnKubunKeiriRn();
        zT_SkKsnKubunKeiriRn.setZrntorihikiymd(pZrntorihikiymd);
        zT_SkKsnKubunKeiriRn.setZrntorihikinon7(pZrntorihikinon7);
        zT_SkKsnKubunKeiriRn.setZrntaisyakukbnn(pZrntaisyakukbnn);
        zT_SkKsnKubunKeiriRn.setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
        zT_SkKsnKubunKeiriRn.setZrnsuitoubumoncd(pZrnsuitoubumoncd);
        zT_SkKsnKubunKeiriRn.setZrnkizokusegment(pZrnkizokusegment);
        zT_SkKsnKubunKeiriRn.setZrnaitesegment(pZrnaitesegment);
        return this.selectOne(zT_SkKsnKubunKeiriRn);
    }

    public ExDBResults<ZT_SkKsnKubunKeiriRn> selectAllZT_SkKsnKubunKeiriRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnKubunKeiriRn qZT_SkKsnKubunKeiriRn =  new QZT_SkKsnKubunKeiriRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnKubunKeiriRn);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnKubunKeiriRn.ZT_SkKsnKubunKeiriRn());
        jpql.append($ORDER_BY(qZT_SkKsnKubunKeiriRn.zrntorihikiymd.asc(), qZT_SkKsnKubunKeiriRn.zrntorihikinon7.asc(), qZT_SkKsnKubunKeiriRn.zrntaisyakukbnn.asc(), qZT_SkKsnKubunKeiriRn.zrnkanjyoukamokucdn.asc(), qZT_SkKsnKubunKeiriRn.zrnsuitoubumoncd.asc(), qZT_SkKsnKubunKeiriRn.zrnkizokusegment.asc(), qZT_SkKsnKubunKeiriRn.zrnaitesegment.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnKubunKeiriRn).getResults();
    }
}
