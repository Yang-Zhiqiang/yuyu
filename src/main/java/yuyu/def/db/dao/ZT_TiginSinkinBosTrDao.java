package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_TiginSinkinBosTr;
import yuyu.def.db.meta.QZT_TiginSinkinBosTr;

/**
 * 地銀信金募集テーブル（取）(ZT_TiginSinkinBosTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_TiginSinkinBosTrDao extends AbstractDao<ZT_TiginSinkinBosTr> {

    public ZT_TiginSinkinBosTrDao() {
        super(ZT_TiginSinkinBosTr.class);
    }

    public ZT_TiginSinkinBosTr getTiginSinkinBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno) {
        ZT_TiginSinkinBosTr zT_TiginSinkinBosTr =  new ZT_TiginSinkinBosTr();
        zT_TiginSinkinBosTr.setZtrseihowebidkbn(pZtrseihowebidkbn);
        zT_TiginSinkinBosTr.setZtrseihowebkojincd(pZtrseihowebkojincd);
        zT_TiginSinkinBosTr.setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
        zT_TiginSinkinBosTr.setZtrseihowebsekno(pZtrseihowebsekno);
        return this.selectOne(zT_TiginSinkinBosTr);
    }

    public ExDBResults<ZT_TiginSinkinBosTr> selectAllZT_TiginSinkinBosTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_TiginSinkinBosTr qZT_TiginSinkinBosTr =  new QZT_TiginSinkinBosTr();
        jpql.append($SELECT);
        jpql.append(qZT_TiginSinkinBosTr);
        jpql.append($FROM);
        jpql.append(qZT_TiginSinkinBosTr.ZT_TiginSinkinBosTr());
        jpql.append($ORDER_BY(qZT_TiginSinkinBosTr.ztrseihowebidkbn.asc(), qZT_TiginSinkinBosTr.ztrseihowebkojincd.asc(), qZT_TiginSinkinBosTr.ztrseihowebitijihozonhyouji.asc(), qZT_TiginSinkinBosTr.ztrseihowebsekno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_TiginSinkinBosTr).getResults();
    }

    public ExDBResults<ZT_TiginSinkinBosTr> getTiginSinkinBosTrsByKakutyoujobcdItems(
        String pZtrseihowebitijihozonhyouji, String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom,
        String pFstmossksymdTo) {


        QZT_TiginSinkinBosTr qZT_TiginSinkinBosTr1 = new QZT_TiginSinkinBosTr("q1");


        String strSql = $SELECT + qZT_TiginSinkinBosTr1 +
            $FROM + qZT_TiginSinkinBosTr1.ZT_TiginSinkinBosTr() +
            $WHERE + $NOT + "(" + "(" + qZT_TiginSinkinBosTr1.ztrseihowebtkiyougyoutaikbn.in("1", "6", "D", "E") +
            $AND + qZT_TiginSinkinBosTr1.ztrseihowebidkbn.notIn("01", "05") + ")" +
            $OR + qZT_TiginSinkinBosTr1.ztrseihowebtkiyougyoutaikbn.eq("5") +
            $OR + qZT_TiginSinkinBosTr1.ztrseihowebmosno.eq("0") + ")" +
            $AND + qZT_TiginSinkinBosTr1.ztrseihowebitijihozonhyouji.eq(pZtrseihowebitijihozonhyouji) +
            $AND + qZT_TiginSinkinBosTr1.ztrseihowebmosprtzmhyj.eq(pZtrseihowebmosprtzmhyj) +
            $AND + qZT_TiginSinkinBosTr1.ztrseihowebfstmossksymd.gt(pFstmossksymdFrom) +
            $AND + qZT_TiginSinkinBosTr1.ztrseihowebfstmossksymd.le(pFstmossksymdTo);

        return em.createJPQL(strSql).bind(qZT_TiginSinkinBosTr1).getResults();
    }

}
