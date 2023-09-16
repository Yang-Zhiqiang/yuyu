package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzaHrkmTuutiRn;
import yuyu.def.db.meta.QZT_KouzaHrkmTuutiRn;

/**
 * 口座振込通知テーブル（連）(ZT_KouzaHrkmTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzaHrkmTuutiRnDao extends AbstractDao<ZT_KouzaHrkmTuutiRn> {

    public ZT_KouzaHrkmTuutiRnDao() {
        super(ZT_KouzaHrkmTuutiRn.class);
    }

    public ZT_KouzaHrkmTuutiRn getKouzaHrkmTuutiRn(String pZrnsyono, String pZrntyouhyouymd, String pZrnsikibetuno) {
        ZT_KouzaHrkmTuutiRn zT_KouzaHrkmTuutiRn =  new ZT_KouzaHrkmTuutiRn();
        zT_KouzaHrkmTuutiRn.setZrnsyono(pZrnsyono);
        zT_KouzaHrkmTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_KouzaHrkmTuutiRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_KouzaHrkmTuutiRn);
    }

    public ExDBResults<ZT_KouzaHrkmTuutiRn> selectAllZT_KouzaHrkmTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzaHrkmTuutiRn qZT_KouzaHrkmTuutiRn =  new QZT_KouzaHrkmTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KouzaHrkmTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_KouzaHrkmTuutiRn.ZT_KouzaHrkmTuutiRn());
        jpql.append($ORDER_BY(qZT_KouzaHrkmTuutiRn.zrnsyono.asc(), qZT_KouzaHrkmTuutiRn.zrntyouhyouymd.asc(), qZT_KouzaHrkmTuutiRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzaHrkmTuutiRn).getResults();
    }
}
