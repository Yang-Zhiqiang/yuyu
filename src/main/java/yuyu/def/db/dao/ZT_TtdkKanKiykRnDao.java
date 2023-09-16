package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TtdkKanKiykRn;
import yuyu.def.db.meta.QZT_TtdkKanKiykRn;

/**
 * 手続完了（解約）Ｆテーブル（連）(ZT_TtdkKanKiykRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TtdkKanKiykRnDao extends AbstractDao<ZT_TtdkKanKiykRn> {

    public ZT_TtdkKanKiykRnDao() {
        super(ZT_TtdkKanKiykRn.class);
    }

    public ZT_TtdkKanKiykRn getTtdkKanKiykRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        ZT_TtdkKanKiykRn zT_TtdkKanKiykRn =  new ZT_TtdkKanKiykRn();
        zT_TtdkKanKiykRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_TtdkKanKiykRn.setZrnsyono(pZrnsyono);
        zT_TtdkKanKiykRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_TtdkKanKiykRn);
    }

    public ExDBResults<ZT_TtdkKanKiykRn> selectAllZT_TtdkKanKiykRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TtdkKanKiykRn qZT_TtdkKanKiykRn =  new QZT_TtdkKanKiykRn();
        jpql.append($SELECT);
        jpql.append(qZT_TtdkKanKiykRn);
        jpql.append($FROM);
        jpql.append(qZT_TtdkKanKiykRn.ZT_TtdkKanKiykRn());
        jpql.append($ORDER_BY(qZT_TtdkKanKiykRn.zrntyouhyouymd.asc(), qZT_TtdkKanKiykRn.zrnsyono.asc(), qZT_TtdkKanKiykRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TtdkKanKiykRn).getResults();
    }
}
