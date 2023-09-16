package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.QZT_DrtenIpToukeiRn;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（連）(ZT_DrtenIpToukeiRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_DrtenIpToukeiRnDao extends AbstractDao<ZT_DrtenIpToukeiRn> {

    public ZT_DrtenIpToukeiRnDao() {
        super(ZT_DrtenIpToukeiRn.class);
    }

    public ZT_DrtenIpToukeiRn getDrtenIpToukeiRn(String pZrneigyouhonbusisyacd, String pZrnsosikicd, String pZrnatukaikojincd, String pZrnmosym, String pZrnmosno) {
        ZT_DrtenIpToukeiRn zT_DrtenIpToukeiRn =  new ZT_DrtenIpToukeiRn();
        zT_DrtenIpToukeiRn.setZrneigyouhonbusisyacd(pZrneigyouhonbusisyacd);
        zT_DrtenIpToukeiRn.setZrnsosikicd(pZrnsosikicd);
        zT_DrtenIpToukeiRn.setZrnatukaikojincd(pZrnatukaikojincd);
        zT_DrtenIpToukeiRn.setZrnmosym(pZrnmosym);
        zT_DrtenIpToukeiRn.setZrnmosno(pZrnmosno);
        return this.selectOne(zT_DrtenIpToukeiRn);
    }

    public ExDBResults<ZT_DrtenIpToukeiRn> selectAllZT_DrtenIpToukeiRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_DrtenIpToukeiRn qZT_DrtenIpToukeiRn =  new QZT_DrtenIpToukeiRn();
        jpql.append($SELECT);
        jpql.append(qZT_DrtenIpToukeiRn);
        jpql.append($FROM);
        jpql.append(qZT_DrtenIpToukeiRn.ZT_DrtenIpToukeiRn());
        jpql.append($ORDER_BY(qZT_DrtenIpToukeiRn.zrneigyouhonbusisyacd.asc(), qZT_DrtenIpToukeiRn.zrnsosikicd.asc(), qZT_DrtenIpToukeiRn.zrnatukaikojincd.asc(), qZT_DrtenIpToukeiRn.zrnmosym.asc(), qZT_DrtenIpToukeiRn.zrnmosno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_DrtenIpToukeiRn).getResults();
    }
}
