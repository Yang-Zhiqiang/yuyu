package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiRn;

/**
 * 口座振替未入通知テーブル（連）(ZT_KouzahuriMinyuTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KouzahuriMinyuTuutiRnDao extends AbstractDao<ZT_KouzahuriMinyuTuutiRn> {

    public ZT_KouzahuriMinyuTuutiRnDao() {
        super(ZT_KouzahuriMinyuTuutiRn.class);
    }

    public ZT_KouzahuriMinyuTuutiRn getKouzahuriMinyuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_KouzahuriMinyuTuutiRn zT_KouzahuriMinyuTuutiRn =  new ZT_KouzahuriMinyuTuutiRn();
        zT_KouzahuriMinyuTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_KouzahuriMinyuTuutiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_KouzahuriMinyuTuutiRn);
    }

    public ExDBResults<ZT_KouzahuriMinyuTuutiRn> selectAllZT_KouzahuriMinyuTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KouzahuriMinyuTuutiRn qZT_KouzahuriMinyuTuutiRn =  new QZT_KouzahuriMinyuTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KouzahuriMinyuTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_KouzahuriMinyuTuutiRn.ZT_KouzahuriMinyuTuutiRn());
        jpql.append($ORDER_BY(qZT_KouzahuriMinyuTuutiRn.zrntyouhyouymd.asc(), qZT_KouzahuriMinyuTuutiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KouzahuriMinyuTuutiRn).getResults();
    }
}
