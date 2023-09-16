package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiRn;

/**
 * 有効性確認ＮＧ通知テーブル（連）(ZT_YuukouseiNgTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_YuukouseiNgTuutiRnDao extends AbstractDao<ZT_YuukouseiNgTuutiRn> {

    public ZT_YuukouseiNgTuutiRnDao() {
        super(ZT_YuukouseiNgTuutiRn.class);
    }

    public ZT_YuukouseiNgTuutiRn getYuukouseiNgTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_YuukouseiNgTuutiRn zT_YuukouseiNgTuutiRn =  new ZT_YuukouseiNgTuutiRn();
        zT_YuukouseiNgTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_YuukouseiNgTuutiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_YuukouseiNgTuutiRn);
    }

    public ExDBResults<ZT_YuukouseiNgTuutiRn> selectAllZT_YuukouseiNgTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_YuukouseiNgTuutiRn qZT_YuukouseiNgTuutiRn =  new QZT_YuukouseiNgTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_YuukouseiNgTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_YuukouseiNgTuutiRn.ZT_YuukouseiNgTuutiRn());
        jpql.append($ORDER_BY(qZT_YuukouseiNgTuutiRn.zrntyouhyouymd.asc(), qZT_YuukouseiNgTuutiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_YuukouseiNgTuutiRn).getResults();
    }
}
