package yuyu.app.dsweb.dwmail.dwrealtimemailsousin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QMT_DsMailHaisinRireki;

/**
 * ダイレクトサービス（Ｗｅｂ） メール DSリアルタイムメール送信DAOクラス
 */
public class DwRealTimeMailSousinDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public Integer getDsMailHaisinRirekiMaxDsMailHaisinRenNo(BizDate pDsDataSakuseiYmd) {

        QMT_DsMailHaisinRireki qMT_DsMailHaisinRireki = new QMT_DsMailHaisinRireki("qMT_DsMailHaisinRireki");

        String strSql = $SELECT + $MAX(qMT_DsMailHaisinRireki.dsmailhaisinrenban)   +
            $FROM(qMT_DsMailHaisinRireki)                                           +
            $WHERE + qMT_DsMailHaisinRireki.dsdatasakuseiymd.eq(pDsDataSakuseiYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisinRireki).getSingleResult();
    }
}
