package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SeisanDHaneiTuutiRn;
import yuyu.def.db.meta.QZT_SeisanDHaneiTuutiRn;

/**
 * 精算Ｄ反映通知テーブル（連）(ZT_SeisanDHaneiTuutiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SeisanDHaneiTuutiRnDao extends AbstractDao<ZT_SeisanDHaneiTuutiRn> {

    public ZT_SeisanDHaneiTuutiRnDao() {
        super(ZT_SeisanDHaneiTuutiRn.class);
    }

    public ZT_SeisanDHaneiTuutiRn getSeisanDHaneiTuutiRn(String pZrntyouhyouymd, String pZrnkeysyono) {
        ZT_SeisanDHaneiTuutiRn zT_SeisanDHaneiTuutiRn =  new ZT_SeisanDHaneiTuutiRn();
        zT_SeisanDHaneiTuutiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SeisanDHaneiTuutiRn.setZrnkeysyono(pZrnkeysyono);
        return this.selectOne(zT_SeisanDHaneiTuutiRn);
    }

    public ExDBResults<ZT_SeisanDHaneiTuutiRn> selectAllZT_SeisanDHaneiTuutiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SeisanDHaneiTuutiRn qZT_SeisanDHaneiTuutiRn =  new QZT_SeisanDHaneiTuutiRn();
        jpql.append($SELECT);
        jpql.append(qZT_SeisanDHaneiTuutiRn);
        jpql.append($FROM);
        jpql.append(qZT_SeisanDHaneiTuutiRn.ZT_SeisanDHaneiTuutiRn());
        jpql.append($ORDER_BY(qZT_SeisanDHaneiTuutiRn.zrntyouhyouymd.asc(), qZT_SeisanDHaneiTuutiRn.zrnkeysyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SeisanDHaneiTuutiRn).getResults();
    }
}
