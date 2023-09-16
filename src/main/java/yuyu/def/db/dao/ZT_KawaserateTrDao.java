package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KawaserateTr;
import yuyu.def.db.meta.QZT_KawaserateTr;

/**
 * 為替レートテーブル（取）(ZT_KawaserateTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KawaserateTrDao extends AbstractDao<ZT_KawaserateTr> {

    public ZT_KawaserateTrDao() {
        super(ZT_KawaserateTr.class);
    }

    public ZT_KawaserateTr getKawaserateTr(String pZtrkwsratekjymd, String pZtrkawaserendoukbn) {
        ZT_KawaserateTr zT_KawaserateTr =  new ZT_KawaserateTr();
        zT_KawaserateTr.setZtrkwsratekjymd(pZtrkwsratekjymd);
        zT_KawaserateTr.setZtrkawaserendoukbn(pZtrkawaserendoukbn);
        return this.selectOne(zT_KawaserateTr);
    }

    public ExDBResults<ZT_KawaserateTr> selectAllZT_KawaserateTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_KawaserateTr qZT_KawaserateTr =  new QZT_KawaserateTr();
        jpql.append($SELECT);
        jpql.append(qZT_KawaserateTr);
        jpql.append($FROM);
        jpql.append(qZT_KawaserateTr.ZT_KawaserateTr());
        jpql.append($ORDER_BY(qZT_KawaserateTr.ztrkwsratekjymd.asc(), qZT_KawaserateTr.ztrkawaserendoukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KawaserateTr).getResults();
    }
}
