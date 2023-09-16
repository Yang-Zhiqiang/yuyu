package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFRn;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFRn;

/**
 * 銀行窓販未収情報Ｆテーブル（連）(ZT_GinkouMdhnMisyuuInfoFRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_GinkouMdhnMisyuuInfoFRnDao extends AbstractDao<ZT_GinkouMdhnMisyuuInfoFRn> {

    public ZT_GinkouMdhnMisyuuInfoFRnDao() {
        super(ZT_GinkouMdhnMisyuuInfoFRn.class);
    }

    public ZT_GinkouMdhnMisyuuInfoFRn getGinkouMdhnMisyuuInfoFRn(String pZrnbsydrtencd, String pZrndatasakuseiymd, String pZrnsyonosyuban) {
        ZT_GinkouMdhnMisyuuInfoFRn zT_GinkouMdhnMisyuuInfoFRn =  new ZT_GinkouMdhnMisyuuInfoFRn();
        zT_GinkouMdhnMisyuuInfoFRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_GinkouMdhnMisyuuInfoFRn.setZrndatasakuseiymd(pZrndatasakuseiymd);
        zT_GinkouMdhnMisyuuInfoFRn.setZrnsyonosyuban(pZrnsyonosyuban);
        return this.selectOne(zT_GinkouMdhnMisyuuInfoFRn);
    }

    public ExDBResults<ZT_GinkouMdhnMisyuuInfoFRn> selectAllZT_GinkouMdhnMisyuuInfoFRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_GinkouMdhnMisyuuInfoFRn qZT_GinkouMdhnMisyuuInfoFRn =  new QZT_GinkouMdhnMisyuuInfoFRn();
        jpql.append($SELECT);
        jpql.append(qZT_GinkouMdhnMisyuuInfoFRn);
        jpql.append($FROM);
        jpql.append(qZT_GinkouMdhnMisyuuInfoFRn.ZT_GinkouMdhnMisyuuInfoFRn());
        jpql.append($ORDER_BY(qZT_GinkouMdhnMisyuuInfoFRn.zrnbsydrtencd.asc(), qZT_GinkouMdhnMisyuuInfoFRn.zrndatasakuseiymd.asc(), qZT_GinkouMdhnMisyuuInfoFRn.zrnsyonosyuban.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_GinkouMdhnMisyuuInfoFRn).getResults();
    }
}
