package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_SmbcPaperlessMos1Tr;

/**
 * ＳＭＢＣペーパーレス申込情報１テーブル（取）(ZT_SmbcPaperlessMos1TrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcPaperlessMos1TrDao extends AbstractDao<ZT_SmbcPaperlessMos1Tr> {

    public ZT_SmbcPaperlessMos1TrDao() {
        super(ZT_SmbcPaperlessMos1Tr.class);
    }

    public ZT_SmbcPaperlessMos1Tr getSmbcPaperlessMos1Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        ZT_SmbcPaperlessMos1Tr zT_SmbcPaperlessMos1Tr =  new ZT_SmbcPaperlessMos1Tr();
        zT_SmbcPaperlessMos1Tr.setZtrseihowebidkbn(pZtrseihowebidkbn);
        zT_SmbcPaperlessMos1Tr.setZtrseihowebkojincd(pZtrseihowebkojincd);
        zT_SmbcPaperlessMos1Tr.setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
        zT_SmbcPaperlessMos1Tr.setZtrseihowebseknoc(pZtrseihowebseknoc);
        return this.selectOne(zT_SmbcPaperlessMos1Tr);
    }

    public ExDBResults<ZT_SmbcPaperlessMos1Tr> selectAllZT_SmbcPaperlessMos1Tr() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcPaperlessMos1Tr qZT_SmbcPaperlessMos1Tr =  new QZT_SmbcPaperlessMos1Tr();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcPaperlessMos1Tr);
        jpql.append($FROM);
        jpql.append(qZT_SmbcPaperlessMos1Tr.ZT_SmbcPaperlessMos1Tr());
        jpql.append($ORDER_BY(qZT_SmbcPaperlessMos1Tr.ztrseihowebidkbn.asc(), qZT_SmbcPaperlessMos1Tr.ztrseihowebkojincd.asc(), qZT_SmbcPaperlessMos1Tr.ztrseihowebitijihozonhyouji.asc(), qZT_SmbcPaperlessMos1Tr.ztrseihowebseknoc.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcPaperlessMos1Tr).getResults();
    }

    public ExDBResults<ZT_SmbcPaperlessMos1Tr> getSmbcPaperlessMos1TrsByKakutyoujobcd() {


        QZT_SmbcPaperlessMos1Tr qZT_SmbcPaperlessMos1Tr1 = new QZT_SmbcPaperlessMos1Tr("q1");


        String strSql = $SELECT + qZT_SmbcPaperlessMos1Tr1 +
            $FROM + qZT_SmbcPaperlessMos1Tr1.ZT_SmbcPaperlessMos1Tr() +
            $WHERE + $NOT  + "(" + "(" + qZT_SmbcPaperlessMos1Tr1.ztrseihowebtkiyougyoutaikbn.eq("1") +
            $AND + qZT_SmbcPaperlessMos1Tr1.ztrseihowebidkbn.notIn("01", "05") + ")" +
            $OR + qZT_SmbcPaperlessMos1Tr1.ztrseihowebtkiyougyoutaikbn.eq("5") +
            $OR + qZT_SmbcPaperlessMos1Tr1.ztrseihowebplmosnoc.eq("000000000") + ")";

        return em.createJPQL(strSql).bind(qZT_SmbcPaperlessMos1Tr1).getResults();
    }

}
