package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiRn;
import yuyu.def.db.meta.QZT_SkKsnKaikeiTorihikiRn;

/**
 * 新契約決算用会計取引Ｆテーブル（連）(ZT_SkKsnKaikeiTorihikiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKsnKaikeiTorihikiRnDao extends AbstractDao<ZT_SkKsnKaikeiTorihikiRn> {

    public ZT_SkKsnKaikeiTorihikiRnDao() {
        super(ZT_SkKsnKaikeiTorihikiRn.class);
    }

    public ZT_SkKsnKaikeiTorihikiRn getSkKsnKaikeiTorihikiRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn, String pZrnsuitoubumon, String pZrntekiyoucd) {
        ZT_SkKsnKaikeiTorihikiRn zT_SkKsnKaikeiTorihikiRn =  new ZT_SkKsnKaikeiTorihikiRn();
        zT_SkKsnKaikeiTorihikiRn.setZrntorihikiymd(pZrntorihikiymd);
        zT_SkKsnKaikeiTorihikiRn.setZrntorihikinon7(pZrntorihikinon7);
        zT_SkKsnKaikeiTorihikiRn.setZrntaisyakukbnn(pZrntaisyakukbnn);
        zT_SkKsnKaikeiTorihikiRn.setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
        zT_SkKsnKaikeiTorihikiRn.setZrnsuitoubumon(pZrnsuitoubumon);
        zT_SkKsnKaikeiTorihikiRn.setZrntekiyoucd(pZrntekiyoucd);
        return this.selectOne(zT_SkKsnKaikeiTorihikiRn);
    }

    public ExDBResults<ZT_SkKsnKaikeiTorihikiRn> selectAllZT_SkKsnKaikeiTorihikiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKsnKaikeiTorihikiRn qZT_SkKsnKaikeiTorihikiRn =  new QZT_SkKsnKaikeiTorihikiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkKsnKaikeiTorihikiRn);
        jpql.append($FROM);
        jpql.append(qZT_SkKsnKaikeiTorihikiRn.ZT_SkKsnKaikeiTorihikiRn());
        jpql.append($ORDER_BY(qZT_SkKsnKaikeiTorihikiRn.zrntorihikiymd.asc(), qZT_SkKsnKaikeiTorihikiRn.zrntorihikinon7.asc(), qZT_SkKsnKaikeiTorihikiRn.zrntaisyakukbnn.asc(), qZT_SkKsnKaikeiTorihikiRn.zrnkanjyoukamokucdn.asc(), qZT_SkKsnKaikeiTorihikiRn.zrnsuitoubumon.asc(), qZT_SkKsnKaikeiTorihikiRn.zrntekiyoucd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKsnKaikeiTorihikiRn).getResults();
    }
}
