package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_SkKaikeiTorihikiFileRn;

/**
 * 新契約会計取引ファイルテーブル（連）(ZT_SkKaikeiTorihikiFileRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SkKaikeiTorihikiFileRnDao extends AbstractDao<ZT_SkKaikeiTorihikiFileRn> {

    public ZT_SkKaikeiTorihikiFileRnDao() {
        super(ZT_SkKaikeiTorihikiFileRn.class);
    }

    public ZT_SkKaikeiTorihikiFileRn getSkKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn, String pZrnsuitoubumon, String pZrntekiyoucd) {
        ZT_SkKaikeiTorihikiFileRn zT_SkKaikeiTorihikiFileRn =  new ZT_SkKaikeiTorihikiFileRn();
        zT_SkKaikeiTorihikiFileRn.setZrntorihikiymd(pZrntorihikiymd);
        zT_SkKaikeiTorihikiFileRn.setZrntorihikinon7(pZrntorihikinon7);
        zT_SkKaikeiTorihikiFileRn.setZrntaisyakukbnn(pZrntaisyakukbnn);
        zT_SkKaikeiTorihikiFileRn.setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
        zT_SkKaikeiTorihikiFileRn.setZrnsuitoubumon(pZrnsuitoubumon);
        zT_SkKaikeiTorihikiFileRn.setZrntekiyoucd(pZrntekiyoucd);
        return this.selectOne(zT_SkKaikeiTorihikiFileRn);
    }

    public ExDBResults<ZT_SkKaikeiTorihikiFileRn> selectAllZT_SkKaikeiTorihikiFileRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SkKaikeiTorihikiFileRn qZT_SkKaikeiTorihikiFileRn =  new QZT_SkKaikeiTorihikiFileRn();
        jpql.append($SELECT);
        jpql.append(qZT_SkKaikeiTorihikiFileRn);
        jpql.append($FROM);
        jpql.append(qZT_SkKaikeiTorihikiFileRn.ZT_SkKaikeiTorihikiFileRn());
        jpql.append($ORDER_BY(qZT_SkKaikeiTorihikiFileRn.zrntorihikiymd.asc(), qZT_SkKaikeiTorihikiFileRn.zrntorihikinon7.asc(), qZT_SkKaikeiTorihikiFileRn.zrntaisyakukbnn.asc(), qZT_SkKaikeiTorihikiFileRn.zrnkanjyoukamokucdn.asc(), qZT_SkKaikeiTorihikiFileRn.zrnsuitoubumon.asc(), qZT_SkKaikeiTorihikiFileRn.zrntekiyoucd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SkKaikeiTorihikiFileRn).getResults();
    }
}
