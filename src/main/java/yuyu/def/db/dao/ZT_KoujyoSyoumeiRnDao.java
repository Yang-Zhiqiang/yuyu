package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiRn;

/**
 * 控除証明書Ｆテーブル（連）(ZT_KoujyoSyoumeiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KoujyoSyoumeiRnDao extends AbstractDao<ZT_KoujyoSyoumeiRn> {

    public ZT_KoujyoSyoumeiRnDao() {
        super(ZT_KoujyoSyoumeiRn.class);
    }

    public ZT_KoujyoSyoumeiRn getKoujyoSyoumeiRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsakunm15keta) {
        ZT_KoujyoSyoumeiRn zT_KoujyoSyoumeiRn =  new ZT_KoujyoSyoumeiRn();
        zT_KoujyoSyoumeiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_KoujyoSyoumeiRn.setZrnsyono(pZrnsyono);
        zT_KoujyoSyoumeiRn.setZrnsakunm15keta(pZrnsakunm15keta);
        return this.selectOne(zT_KoujyoSyoumeiRn);
    }

    public ExDBResults<ZT_KoujyoSyoumeiRn> selectAllZT_KoujyoSyoumeiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KoujyoSyoumeiRn qZT_KoujyoSyoumeiRn =  new QZT_KoujyoSyoumeiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KoujyoSyoumeiRn);
        jpql.append($FROM);
        jpql.append(qZT_KoujyoSyoumeiRn.ZT_KoujyoSyoumeiRn());
        jpql.append($ORDER_BY(qZT_KoujyoSyoumeiRn.zrntyouhyouymd.asc(), qZT_KoujyoSyoumeiRn.zrnsyono.asc(), qZT_KoujyoSyoumeiRn.zrnsakunm15keta.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KoujyoSyoumeiRn).getResults();
    }
}
