package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KubunKeiriFileRn;
import yuyu.def.db.meta.QZT_KubunKeiriFileRn;

/**
 * 区分経理ファイルテーブル（連）(ZT_KubunKeiriFileRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KubunKeiriFileRnDao extends AbstractDao<ZT_KubunKeiriFileRn> {

    public ZT_KubunKeiriFileRnDao() {
        super(ZT_KubunKeiriFileRn.class);
    }

    public ZT_KubunKeiriFileRn getKubunKeiriFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn, String pZrnsuitoubumoncd, String pZrnkizokusegment, String pZrnaitesegment) {
        ZT_KubunKeiriFileRn zT_KubunKeiriFileRn =  new ZT_KubunKeiriFileRn();
        zT_KubunKeiriFileRn.setZrntorihikiymd(pZrntorihikiymd);
        zT_KubunKeiriFileRn.setZrntorihikinon7(pZrntorihikinon7);
        zT_KubunKeiriFileRn.setZrntaisyakukbnn(pZrntaisyakukbnn);
        zT_KubunKeiriFileRn.setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
        zT_KubunKeiriFileRn.setZrnsuitoubumoncd(pZrnsuitoubumoncd);
        zT_KubunKeiriFileRn.setZrnkizokusegment(pZrnkizokusegment);
        zT_KubunKeiriFileRn.setZrnaitesegment(pZrnaitesegment);
        return this.selectOne(zT_KubunKeiriFileRn);
    }

    public ExDBResults<ZT_KubunKeiriFileRn> selectAllZT_KubunKeiriFileRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KubunKeiriFileRn qZT_KubunKeiriFileRn =  new QZT_KubunKeiriFileRn();
        jpql.append($SELECT);
        jpql.append(qZT_KubunKeiriFileRn);
        jpql.append($FROM);
        jpql.append(qZT_KubunKeiriFileRn.ZT_KubunKeiriFileRn());
        jpql.append($ORDER_BY(qZT_KubunKeiriFileRn.zrntorihikiymd.asc(), qZT_KubunKeiriFileRn.zrntorihikinon7.asc(), qZT_KubunKeiriFileRn.zrntaisyakukbnn.asc(), qZT_KubunKeiriFileRn.zrnsuitoubumoncd.asc(), qZT_KubunKeiriFileRn.zrnkizokusegment.asc(), qZT_KubunKeiriFileRn.zrnaitesegment.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KubunKeiriFileRn).getResults();
    }
}
