package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiRn;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiRn;

/**
 * 期日到来案内テーブル（連）(ZT_KijituTouraiAnnaiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_KijituTouraiAnnaiRnDao extends AbstractDao<ZT_KijituTouraiAnnaiRn> {

    public ZT_KijituTouraiAnnaiRnDao() {
        super(ZT_KijituTouraiAnnaiRn.class);
    }

    public ZT_KijituTouraiAnnaiRn getKijituTouraiAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        ZT_KijituTouraiAnnaiRn zT_KijituTouraiAnnaiRn =  new ZT_KijituTouraiAnnaiRn();
        zT_KijituTouraiAnnaiRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_KijituTouraiAnnaiRn.setZrnsyono(pZrnsyono);
        return this.selectOne(zT_KijituTouraiAnnaiRn);
    }

    public ExDBResults<ZT_KijituTouraiAnnaiRn> selectAllZT_KijituTouraiAnnaiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_KijituTouraiAnnaiRn qZT_KijituTouraiAnnaiRn =  new QZT_KijituTouraiAnnaiRn();
        jpql.append($SELECT);
        jpql.append(qZT_KijituTouraiAnnaiRn);
        jpql.append($FROM);
        jpql.append(qZT_KijituTouraiAnnaiRn.ZT_KijituTouraiAnnaiRn());
        jpql.append($ORDER_BY(qZT_KijituTouraiAnnaiRn.zrntyouhyouymd.asc(), qZT_KijituTouraiAnnaiRn.zrnsyono.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_KijituTouraiAnnaiRn).getResults();
    }
}
