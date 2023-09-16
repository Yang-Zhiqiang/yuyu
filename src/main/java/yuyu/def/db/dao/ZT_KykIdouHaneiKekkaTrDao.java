package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaTr;

/**
 * 普保Ⅱ契約異動反映結果テーブル（取）(ZT_KykIdouHaneiKekkaTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KykIdouHaneiKekkaTrDao extends AbstractDao<ZT_KykIdouHaneiKekkaTr> {

    public ZT_KykIdouHaneiKekkaTrDao() {
        super(ZT_KykIdouHaneiKekkaTr.class);
    }

    public ZT_KykIdouHaneiKekkaTr getKykIdouHaneiKekkaTr(String pZtrhuho2kyknokbn, String pZtrhuho2kykno) {
        ZT_KykIdouHaneiKekkaTr zT_KykIdouHaneiKekkaTr =  new ZT_KykIdouHaneiKekkaTr();
        zT_KykIdouHaneiKekkaTr.setZtrhuho2kyknokbn(pZtrhuho2kyknokbn);
        zT_KykIdouHaneiKekkaTr.setZtrhuho2kykno(pZtrhuho2kykno);
        return this.selectOne(zT_KykIdouHaneiKekkaTr);
    }

    public ExDBResults<ZT_KykIdouHaneiKekkaTr> selectAllZT_KykIdouHaneiKekkaTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_KykIdouHaneiKekkaTr qZT_KykIdouHaneiKekkaTr =  new QZT_KykIdouHaneiKekkaTr();
        jpql.append($SELECT);
        jpql.append(qZT_KykIdouHaneiKekkaTr);
        jpql.append($FROM);
        jpql.append(qZT_KykIdouHaneiKekkaTr.ZT_KykIdouHaneiKekkaTr());
        jpql.append($ORDER_BY(qZT_KykIdouHaneiKekkaTr.ztrhuho2kyknokbn.asc(), qZT_KykIdouHaneiKekkaTr.ztrhuho2kykno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KykIdouHaneiKekkaTr).getResults();
    }
}
