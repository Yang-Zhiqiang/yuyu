package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.meta.QZT_SmbcPaperlessMos2Tr;

/**
 * ＳＭＢＣペーパーレス申込情報２テーブル（取）(ZT_SmbcPaperlessMos2TrDao) アクセス用の DAO クラスです。<br />
 */
public class ZT_SmbcPaperlessMos2TrDao extends AbstractDao<ZT_SmbcPaperlessMos2Tr> {

    public ZT_SmbcPaperlessMos2TrDao() {
        super(ZT_SmbcPaperlessMos2Tr.class);
    }

    public ZT_SmbcPaperlessMos2Tr getSmbcPaperlessMos2Tr(String pZtrseihowebidkbn, String pZtrseihowebkojincd, String pZtrseihowebitijihozonhyouji, Integer pZtrseihowebseknoc) {
        ZT_SmbcPaperlessMos2Tr zT_SmbcPaperlessMos2Tr =  new ZT_SmbcPaperlessMos2Tr();
        zT_SmbcPaperlessMos2Tr.setZtrseihowebidkbn(pZtrseihowebidkbn);
        zT_SmbcPaperlessMos2Tr.setZtrseihowebkojincd(pZtrseihowebkojincd);
        zT_SmbcPaperlessMos2Tr.setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
        zT_SmbcPaperlessMos2Tr.setZtrseihowebseknoc(pZtrseihowebseknoc);
        return this.selectOne(zT_SmbcPaperlessMos2Tr);
    }

    public ExDBResults<ZT_SmbcPaperlessMos2Tr> selectAllZT_SmbcPaperlessMos2Tr() {
        StringBuilder jpql = new StringBuilder();
        QZT_SmbcPaperlessMos2Tr qZT_SmbcPaperlessMos2Tr =  new QZT_SmbcPaperlessMos2Tr();
        jpql.append($SELECT);
        jpql.append(qZT_SmbcPaperlessMos2Tr);
        jpql.append($FROM);
        jpql.append(qZT_SmbcPaperlessMos2Tr.ZT_SmbcPaperlessMos2Tr());
        jpql.append($ORDER_BY(qZT_SmbcPaperlessMos2Tr.ztrseihowebidkbn.asc(), qZT_SmbcPaperlessMos2Tr.ztrseihowebkojincd.asc(), qZT_SmbcPaperlessMos2Tr.ztrseihowebitijihozonhyouji.asc(), qZT_SmbcPaperlessMos2Tr.ztrseihowebseknoc.asc()));
        return em.createJPQL(jpql.toString()).bind(qZT_SmbcPaperlessMos2Tr).getResults();
    }

    public ExDBResults<ZT_SmbcPaperlessMos2Tr> getSmbcPaperlessMos2TrsByKakutyoujobcd() {


        QZT_SmbcPaperlessMos2Tr qZT_SmbcPaperlessMos2Tr1 = new QZT_SmbcPaperlessMos2Tr("q1");


        String strSql = $SELECT + qZT_SmbcPaperlessMos2Tr1 +
            $FROM + qZT_SmbcPaperlessMos2Tr1.ZT_SmbcPaperlessMos2Tr() +
            $WHERE + $NOT + "(" + "(" + qZT_SmbcPaperlessMos2Tr1.ztrseihowebtkiyougyoutaikbn.eq("1") +
            $AND + qZT_SmbcPaperlessMos2Tr1.ztrseihowebidkbn.notIn("01", "05") + ")" +
            $OR + qZT_SmbcPaperlessMos2Tr1.ztrseihowebtkiyougyoutaikbn.eq("5") +
            $OR + qZT_SmbcPaperlessMos2Tr1.ztrseihowebplmosnoc.eq("000000000") + ")";

        return em.createJPQL(strSql).bind(qZT_SmbcPaperlessMos2Tr1).getResults();
    }

}
