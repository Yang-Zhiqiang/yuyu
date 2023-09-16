package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiRn;
import yuyu.def.db.meta.QZT_KouzaHnknTuutiRn;

/**
 * 口座返金通知テーブル（連）(ZT_KouzaHnknTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzaHnknTuutiRnDao extends AbstractDao<ZT_KouzaHnknTuutiRn> {

    public ZT_KouzaHnknTuutiRnDao() {
        super(ZT_KouzaHnknTuutiRn.class);
    }

    public ZT_KouzaHnknTuutiRn getKouzaHnknTuutiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsikibetuno) {
        ZT_KouzaHnknTuutiRn zT_KouzaHnknTuutiRn =  new ZT_KouzaHnknTuutiRn();
        zT_KouzaHnknTuutiRn.setZrnsyono(pZrnsyono);
        zT_KouzaHnknTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_KouzaHnknTuutiRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_KouzaHnknTuutiRn);
    }

    public ExDBResults<ZT_KouzaHnknTuutiRn> selectAllZT_KouzaHnknTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzaHnknTuutiRn qZT_KouzaHnknTuutiRn =  new QZT_KouzaHnknTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KouzaHnknTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_KouzaHnknTuutiRn.ZT_KouzaHnknTuutiRn());
        jpql.append($ORDER_BY(qZT_KouzaHnknTuutiRn.zrnsyono.asc(), qZT_KouzaHnknTuutiRn.zrntyouhyouymd.asc(), qZT_KouzaHnknTuutiRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzaHnknTuutiRn).getResults();
    }
}
