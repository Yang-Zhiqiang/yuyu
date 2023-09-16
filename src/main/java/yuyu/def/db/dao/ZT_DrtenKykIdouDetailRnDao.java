package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailRn;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailRn;

/**
 * 代理店契約異動明細テーブル（連）(ZT_DrtenKykIdouDetailRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenKykIdouDetailRnDao extends AbstractDao<ZT_DrtenKykIdouDetailRn> {

    public ZT_DrtenKykIdouDetailRnDao() {
        super(ZT_DrtenKykIdouDetailRn.class);
    }

    public ZT_DrtenKykIdouDetailRn getDrtenKykIdouDetailRn(String pZrnbsydrtencd, String pZrnbosyuunincd, String pZrnsyono, String pZrnidouhasseiymd, String pZrnidoukbn) {
        ZT_DrtenKykIdouDetailRn zT_DrtenKykIdouDetailRn =  new ZT_DrtenKykIdouDetailRn();
        zT_DrtenKykIdouDetailRn.setZrnbsydrtencd(pZrnbsydrtencd);
        zT_DrtenKykIdouDetailRn.setZrnbosyuunincd(pZrnbosyuunincd);
        zT_DrtenKykIdouDetailRn.setZrnsyono(pZrnsyono);
        zT_DrtenKykIdouDetailRn.setZrnidouhasseiymd(pZrnidouhasseiymd);
        zT_DrtenKykIdouDetailRn.setZrnidoukbn(pZrnidoukbn);
        return this.selectOne(zT_DrtenKykIdouDetailRn);
    }

    public ExDBResults<ZT_DrtenKykIdouDetailRn> selectAllZT_DrtenKykIdouDetailRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenKykIdouDetailRn qZT_DrtenKykIdouDetailRn =  new QZT_DrtenKykIdouDetailRn();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenKykIdouDetailRn);
        jpql.append($FROM);
        jpql.append(qZT_DrtenKykIdouDetailRn.ZT_DrtenKykIdouDetailRn());
        jpql.append($ORDER_BY(qZT_DrtenKykIdouDetailRn.zrnbsydrtencd.asc(), qZT_DrtenKykIdouDetailRn.zrnbosyuunincd.asc(), qZT_DrtenKykIdouDetailRn.zrnsyono.asc(), qZT_DrtenKykIdouDetailRn.zrnidouhasseiymd.asc(), qZT_DrtenKykIdouDetailRn.zrnidoukbn.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenKykIdouDetailRn).getResults();
    }
}
