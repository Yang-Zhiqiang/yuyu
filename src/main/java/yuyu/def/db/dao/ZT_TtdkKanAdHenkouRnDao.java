package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TtdkKanAdHenkouRn;
import yuyu.def.db.meta.QZT_TtdkKanAdHenkouRn;

/**
 * 手続完了（住所変更）Ｆテーブル（連）(ZT_TtdkKanAdHenkouRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TtdkKanAdHenkouRnDao extends AbstractDao<ZT_TtdkKanAdHenkouRn> {

    public ZT_TtdkKanAdHenkouRnDao() {
        super(ZT_TtdkKanAdHenkouRn.class);
    }

    public ZT_TtdkKanAdHenkouRn getTtdkKanAdHenkouRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        ZT_TtdkKanAdHenkouRn zT_TtdkKanAdHenkouRn =  new ZT_TtdkKanAdHenkouRn();
        zT_TtdkKanAdHenkouRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_TtdkKanAdHenkouRn.setZrnsyono(pZrnsyono);
        zT_TtdkKanAdHenkouRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_TtdkKanAdHenkouRn);
    }

    public ExDBResults<ZT_TtdkKanAdHenkouRn> selectAllZT_TtdkKanAdHenkouRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TtdkKanAdHenkouRn qZT_TtdkKanAdHenkouRn =  new QZT_TtdkKanAdHenkouRn();
        jpql.append($SELECT);
        jpql.append(qZT_TtdkKanAdHenkouRn);
        jpql.append($FROM);
        jpql.append(qZT_TtdkKanAdHenkouRn.ZT_TtdkKanAdHenkouRn());
        jpql.append($ORDER_BY(qZT_TtdkKanAdHenkouRn.zrntyouhyouymd.asc(), qZT_TtdkKanAdHenkouRn.zrnsyono.asc(), qZT_TtdkKanAdHenkouRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TtdkKanAdHenkouRn).getResults();
    }
}
