package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TtdkKanRn;
import yuyu.def.db.meta.QZT_TtdkKanRn;

/**
 * 手続完了Ｆテーブル（連）(ZT_TtdkKanRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TtdkKanRnDao extends AbstractDao<ZT_TtdkKanRn> {

    public ZT_TtdkKanRnDao() {
        super(ZT_TtdkKanRn.class);
    }

    public ZT_TtdkKanRn getTtdkKanRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        ZT_TtdkKanRn zT_TtdkKanRn =  new ZT_TtdkKanRn();
        zT_TtdkKanRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_TtdkKanRn.setZrnsyono(pZrnsyono);
        zT_TtdkKanRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_TtdkKanRn);
    }

    public ExDBResults<ZT_TtdkKanRn> selectAllZT_TtdkKanRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TtdkKanRn qZT_TtdkKanRn =  new QZT_TtdkKanRn();
        jpql.append($SELECT);
        jpql.append(qZT_TtdkKanRn);
        jpql.append($FROM);
        jpql.append(qZT_TtdkKanRn.ZT_TtdkKanRn());
        jpql.append($ORDER_BY(qZT_TtdkKanRn.zrntyouhyouymd.asc(), qZT_TtdkKanRn.zrnsyono.asc(), qZT_TtdkKanRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TtdkKanRn).getResults();
    }
}
