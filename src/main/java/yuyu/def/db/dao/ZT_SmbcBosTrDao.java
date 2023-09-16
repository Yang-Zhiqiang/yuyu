package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcBosTr;
import yuyu.def.db.meta.QZT_SmbcBosTr;

/**
 * ＳＭＢＣ募集テーブル（取）(ZT_SmbcBosTrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcBosTrDao extends AbstractDao<ZT_SmbcBosTr> {

    public ZT_SmbcBosTrDao() {
        super(ZT_SmbcBosTr.class);
    }

    public ZT_SmbcBosTr getSmbcBosTr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebsekno) {
        ZT_SmbcBosTr zT_SmbcBosTr =  new ZT_SmbcBosTr();
        zT_SmbcBosTr.setZtrseihowebidkbn(pZtrseihowebidkbn);
        zT_SmbcBosTr.setZtrseihowebkojincd(pZtrseihowebkojincd);
        zT_SmbcBosTr.setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
        zT_SmbcBosTr.setZtrseihowebsekno(pZtrseihowebsekno);
        return this.selectOne(zT_SmbcBosTr);
    }

    public ExDBResults<ZT_SmbcBosTr> selectAllZT_SmbcBosTr() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcBosTr qZT_SmbcBosTr =  new QZT_SmbcBosTr();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcBosTr);
        jpql.append($FROM);
        jpql.append(qZT_SmbcBosTr.ZT_SmbcBosTr());
        jpql.append($ORDER_BY(qZT_SmbcBosTr.ztrseihowebidkbn.asc(), qZT_SmbcBosTr.ztrseihowebkojincd.asc(), qZT_SmbcBosTr.ztrseihowebitijihozonhyouji.asc(), qZT_SmbcBosTr.ztrseihowebsekno.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcBosTr).getResults();
    }

    public ExDBResults<ZT_SmbcBosTr> getSmbcBosTrsByKakutyoujobcdItems(String pZtrseihowebitijihozonhyouji,
        String pZtrseihowebmosprtzmhyj, String pFstmossksymdFrom, String pFstmossksymdTo) {


        QZT_SmbcBosTr qZT_SmbcBosTr1 =  new QZT_SmbcBosTr("qzT_SmbcBosTr1");


        String strSql = $SELECT + qZT_SmbcBosTr1 +
            $FROM + qZT_SmbcBosTr1.ZT_SmbcBosTr() +
            $WHERE + $NOT + "(" + "(" + qZT_SmbcBosTr1.ztrseihowebtkiyougyoutaikbn.in("1", "6", "D", "E") +
            $AND + qZT_SmbcBosTr1.ztrseihowebidkbn.notIn("01", "05") + ")" +
            $OR + qZT_SmbcBosTr1.ztrseihowebtkiyougyoutaikbn.eq("5") +
            $OR + qZT_SmbcBosTr1.ztrseihowebmosno.eq("0") + ")" +
            $AND + qZT_SmbcBosTr1.ztrseihowebitijihozonhyouji.eq(pZtrseihowebitijihozonhyouji) +
            $AND + qZT_SmbcBosTr1.ztrseihowebmosprtzmhyj.eq(pZtrseihowebmosprtzmhyj) +
            $AND + qZT_SmbcBosTr1.ztrseihowebfstmossksymd.gt(pFstmossksymdFrom) +
            $AND + qZT_SmbcBosTr1.ztrseihowebfstmossksymd.le(pFstmossksymdTo);

        return em.createJPQL(strSql).bind(qZT_SmbcBosTr1).getResults();
    }

}
