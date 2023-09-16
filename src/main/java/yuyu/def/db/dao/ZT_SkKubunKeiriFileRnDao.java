package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileRn;
import yuyu.def.db.meta.QZT_SkKubunKeiriFileRn;

/**
 * 新契約区分経理ファイルテーブル（連）(ZT_SkKubunKeiriFileRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKubunKeiriFileRnDao extends AbstractDao<ZT_SkKubunKeiriFileRn> {

    public ZT_SkKubunKeiriFileRnDao() {
        super(ZT_SkKubunKeiriFileRn.class);
    }

    public ZT_SkKubunKeiriFileRn getSkKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn, String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {
        ZT_SkKubunKeiriFileRn zT_SkKubunKeiriFileRn =  new ZT_SkKubunKeiriFileRn();
        zT_SkKubunKeiriFileRn.setZrntorihikiymd(pZrntorihikiymd);
        zT_SkKubunKeiriFileRn.setZrntorihikinon7(pZrntorihikinon7);
        zT_SkKubunKeiriFileRn.setZrntaisyakukbnn(pZrntaisyakukbnn);
        zT_SkKubunKeiriFileRn.setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
        zT_SkKubunKeiriFileRn.setZrnsuitoubumoncd(pZrnsuitoubumoncd);
        zT_SkKubunKeiriFileRn.setZrnkizokusegment(pZrnkizokusegment);
        zT_SkKubunKeiriFileRn.setZrnaitesegment(pZrnaitesegment);
        return this.selectOne(zT_SkKubunKeiriFileRn);
    }

    public ExDBResults<ZT_SkKubunKeiriFileRn> selectAllZT_SkKubunKeiriFileRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKubunKeiriFileRn qZT_SkKubunKeiriFileRn =  new QZT_SkKubunKeiriFileRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkKubunKeiriFileRn);
        jpql.append($FROM);
        jpql.append(qZT_SkKubunKeiriFileRn.ZT_SkKubunKeiriFileRn());
        jpql.append($ORDER_BY(qZT_SkKubunKeiriFileRn.zrntorihikiymd.asc(), qZT_SkKubunKeiriFileRn.zrntorihikinon7.asc(), qZT_SkKubunKeiriFileRn.zrntaisyakukbnn.asc(), qZT_SkKubunKeiriFileRn.zrnkanjyoukamokucdn.asc(), qZT_SkKubunKeiriFileRn.zrnsuitoubumoncd.asc(), qZT_SkKubunKeiriFileRn.zrnkizokusegment.asc(), qZT_SkKubunKeiriFileRn.zrnaitesegment.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKubunKeiriFileRn).getResults();
    }
}
