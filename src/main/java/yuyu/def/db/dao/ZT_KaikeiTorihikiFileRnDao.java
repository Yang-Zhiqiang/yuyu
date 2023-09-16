package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileRn;

/**
 * 会計取引ファイルテーブル（連）(ZT_KaikeiTorihikiFileRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KaikeiTorihikiFileRnDao extends AbstractDao<ZT_KaikeiTorihikiFileRn> {

    public ZT_KaikeiTorihikiFileRnDao() {
        super(ZT_KaikeiTorihikiFileRn.class);
    }

    public ZT_KaikeiTorihikiFileRn getKaikeiTorihikiFileRn(String pZrntorihikiymd, String pZrntorihikinon7, String pZrntaisyakukbnn, String pZrnkanjyoukamokucdn, String pZrnsuitoubumon, String pZrntekiyoucd) {
        ZT_KaikeiTorihikiFileRn zT_KaikeiTorihikiFileRn =  new ZT_KaikeiTorihikiFileRn();
        zT_KaikeiTorihikiFileRn.setZrntorihikiymd(pZrntorihikiymd);
        zT_KaikeiTorihikiFileRn.setZrntorihikinon7(pZrntorihikinon7);
        zT_KaikeiTorihikiFileRn.setZrntaisyakukbnn(pZrntaisyakukbnn);
        zT_KaikeiTorihikiFileRn.setZrnkanjyoukamokucdn(pZrnkanjyoukamokucdn);
        zT_KaikeiTorihikiFileRn.setZrnsuitoubumon(pZrnsuitoubumon);
        zT_KaikeiTorihikiFileRn.setZrntekiyoucd(pZrntekiyoucd);
        return this.selectOne(zT_KaikeiTorihikiFileRn);
    }

    public ExDBResults<ZT_KaikeiTorihikiFileRn> selectAllZT_KaikeiTorihikiFileRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KaikeiTorihikiFileRn qZT_KaikeiTorihikiFileRn =  new QZT_KaikeiTorihikiFileRn();
        jpql.append($SELECT);
        jpql.append(qZT_KaikeiTorihikiFileRn);
        jpql.append($FROM);
        jpql.append(qZT_KaikeiTorihikiFileRn.ZT_KaikeiTorihikiFileRn());
        jpql.append($ORDER_BY(qZT_KaikeiTorihikiFileRn.zrntorihikiymd.asc(), qZT_KaikeiTorihikiFileRn.zrntorihikinon7.asc(), qZT_KaikeiTorihikiFileRn.zrntaisyakukbnn.asc(), qZT_KaikeiTorihikiFileRn.zrnkanjyoukamokucdn.asc(), qZT_KaikeiTorihikiFileRn.zrnsuitoubumon.asc(), qZT_KaikeiTorihikiFileRn.zrntekiyoucd.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KaikeiTorihikiFileRn).getResults();
    }
}
