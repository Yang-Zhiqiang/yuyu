package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.QZT_HnsyScrMeigiRn;

/**
 * 反社スクリーニング用名義データテーブル（連）(ZT_HnsyScrMeigiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_HnsyScrMeigiRnDao extends AbstractDao<ZT_HnsyScrMeigiRn> {

    public ZT_HnsyScrMeigiRnDao() {
        super(ZT_HnsyScrMeigiRn.class);
    }

    public ZT_HnsyScrMeigiRn getHnsyScrMeigiRn(String pZrntaisyounmkn, String pZrntaisyounmkj, String pZrntaisyouseiymd, String pZrnnayosetaisyousegkbn, String pZrnsyono) {
        ZT_HnsyScrMeigiRn zT_HnsyScrMeigiRn =  new ZT_HnsyScrMeigiRn();
        zT_HnsyScrMeigiRn.setZrntaisyounmkn(pZrntaisyounmkn);
        zT_HnsyScrMeigiRn.setZrntaisyounmkj(pZrntaisyounmkj);
        zT_HnsyScrMeigiRn.setZrntaisyouseiymd(pZrntaisyouseiymd);
        zT_HnsyScrMeigiRn.setZrnnayosetaisyousegkbn(pZrnnayosetaisyousegkbn);
        zT_HnsyScrMeigiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_HnsyScrMeigiRn);
    }

    public ExDBResults<ZT_HnsyScrMeigiRn> selectAllZT_HnsyScrMeigiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_HnsyScrMeigiRn qZT_HnsyScrMeigiRn =  new QZT_HnsyScrMeigiRn();
        jpql.append($SELECT);
        jpql.append(qZT_HnsyScrMeigiRn);
        jpql.append($FROM);
        jpql.append(qZT_HnsyScrMeigiRn.ZT_HnsyScrMeigiRn());
        jpql.append($ORDER_BY(qZT_HnsyScrMeigiRn.zrntaisyounmkn.asc(), qZT_HnsyScrMeigiRn.zrntaisyounmkj.asc(), qZT_HnsyScrMeigiRn.zrntaisyouseiymd.asc(), qZT_HnsyScrMeigiRn.zrnnayosetaisyousegkbn.asc(), qZT_HnsyScrMeigiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_HnsyScrMeigiRn).getResults();
    }
}
