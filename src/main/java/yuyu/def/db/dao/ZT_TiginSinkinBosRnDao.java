package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TiginSinkinBosRn;
import yuyu.def.db.meta.QZT_TiginSinkinBosRn;

/**
 * 地銀信金募集テーブル（連）(ZT_TiginSinkinBosRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TiginSinkinBosRnDao extends AbstractDao<ZT_TiginSinkinBosRn> {

    public ZT_TiginSinkinBosRnDao() {
        super(ZT_TiginSinkinBosRn.class);
    }

    public ZT_TiginSinkinBosRn getTiginSinkinBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno) {
        ZT_TiginSinkinBosRn zT_TiginSinkinBosRn =  new ZT_TiginSinkinBosRn();
        zT_TiginSinkinBosRn.setZrnseihowebidkbn(pZrnseihowebidkbn);
        zT_TiginSinkinBosRn.setZrnseihowebkojincd(pZrnseihowebkojincd);
        zT_TiginSinkinBosRn.setZrnseihowebitijihozonhyouji(pZrnseihowebitijihozonhyouji);
        zT_TiginSinkinBosRn.setZrnseihowebsekno(pZrnseihowebsekno);
        return this.selectOne(zT_TiginSinkinBosRn);
    }

    public ExDBResults<ZT_TiginSinkinBosRn> selectAllZT_TiginSinkinBosRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_TiginSinkinBosRn qZT_TiginSinkinBosRn =  new QZT_TiginSinkinBosRn();
        jpql.append($SELECT);
        jpql.append(qZT_TiginSinkinBosRn);
        jpql.append($FROM);
        jpql.append(qZT_TiginSinkinBosRn.ZT_TiginSinkinBosRn());
        jpql.append($ORDER_BY(qZT_TiginSinkinBosRn.zrnseihowebidkbn.asc(), qZT_TiginSinkinBosRn.zrnseihowebkojincd.asc(), qZT_TiginSinkinBosRn.zrnseihowebitijihozonhyouji.asc(), qZT_TiginSinkinBosRn.zrnseihowebsekno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TiginSinkinBosRn).getResults();
    }
}
