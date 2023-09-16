package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcBosRn;
import yuyu.def.db.meta.QZT_SmbcBosRn;

/**
 * ＳＭＢＣ募集テーブル（連）(ZT_SmbcBosRnDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcBosRnDao extends AbstractDao<ZT_SmbcBosRn> {

    public ZT_SmbcBosRnDao() {
        super(ZT_SmbcBosRn.class);
    }

    public ZT_SmbcBosRn getSmbcBosRn(String pZrnseihowebidkbn, String pZrnseihowebkojincd, String pZrnseihowebitijihozonhyouji, Integer pZrnseihowebsekno) {
        ZT_SmbcBosRn zT_SmbcBosRn =  new ZT_SmbcBosRn();
        zT_SmbcBosRn.setZrnseihowebidkbn(pZrnseihowebidkbn);
        zT_SmbcBosRn.setZrnseihowebkojincd(pZrnseihowebkojincd);
        zT_SmbcBosRn.setZrnseihowebitijihozonhyouji(pZrnseihowebitijihozonhyouji);
        zT_SmbcBosRn.setZrnseihowebsekno(pZrnseihowebsekno);
        return this.selectOne(zT_SmbcBosRn);
    }

    public ExDBResults<ZT_SmbcBosRn> selectAllZT_SmbcBosRn() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcBosRn qZT_SmbcBosRn =  new QZT_SmbcBosRn();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcBosRn);
        jpql.append($FROM);
        jpql.append(qZT_SmbcBosRn.ZT_SmbcBosRn());
        jpql.append($ORDER_BY(qZT_SmbcBosRn.zrnseihowebidkbn.asc(), qZT_SmbcBosRn.zrnseihowebkojincd.asc(), qZT_SmbcBosRn.zrnseihowebitijihozonhyouji.asc(), qZT_SmbcBosRn.zrnseihowebsekno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcBosRn).getResults();
    }
}
