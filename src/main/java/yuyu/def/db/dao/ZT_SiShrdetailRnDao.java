package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SiShrdetailRn;
import yuyu.def.db.meta.QZT_SiShrdetailRn;

/**
 * 保険金給付金支払明細書テーブル（連）(ZT_SiShrdetailRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SiShrdetailRnDao extends AbstractDao<ZT_SiShrdetailRn> {

    public ZT_SiShrdetailRnDao() {
        super(ZT_SiShrdetailRn.class);
    }

    public ZT_SiShrdetailRn getSiShrdetailRn(String pZrntyouhyouymd, String pZrnsyono, String pZrnsikibetuno) {
        ZT_SiShrdetailRn zT_SiShrdetailRn =  new ZT_SiShrdetailRn();
        zT_SiShrdetailRn.setZrntyouhyouymd(pZrntyouhyouymd);
        zT_SiShrdetailRn.setZrnsyono(pZrnsyono);
        zT_SiShrdetailRn.setZrnsikibetuno(pZrnsikibetuno);
        return this.selectOne(zT_SiShrdetailRn);
    }

    public ExDBResults<ZT_SiShrdetailRn> selectAllZT_SiShrdetailRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SiShrdetailRn qZT_SiShrdetailRn =  new QZT_SiShrdetailRn();
        jpql.append($SELECT);
        jpql.append(qZT_SiShrdetailRn);
        jpql.append($FROM);
        jpql.append(qZT_SiShrdetailRn.ZT_SiShrdetailRn());
        jpql.append($ORDER_BY(qZT_SiShrdetailRn.zrntyouhyouymd.asc(), qZT_SiShrdetailRn.zrnsyono.asc(), qZT_SiShrdetailRn.zrnsikibetuno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SiShrdetailRn).getResults();
    }
}
