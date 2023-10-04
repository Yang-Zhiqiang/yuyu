package yuyu.batch.direct.dsneugokihantei.dsspiralmailhaisinsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.meta.QMT_DsMailHaisin;

/**
 * ダイレクトサービス 値動き判定 ＳＰＩＲＡＬメール配信Ｆ作成機能DAOクラス
 */
public class DsSpiralMailHaisinSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<MT_DsMailHaisin> getDsMailHaisinByDssousinmailsyubetukbn(
        C_DsSousinMailSyubetuKbn pDsSousinMailSyubetuKbn) {

        QMT_DsMailHaisin qMT_DsMailHaisin = new QMT_DsMailHaisin("qMT_DsMailHaisin");

        String strSql = $SELECT + qMT_DsMailHaisin +
            $FROM(qMT_DsMailHaisin) +
            $WHERE + qMT_DsMailHaisin.dssousinmailsyubetukbn.eq(pDsSousinMailSyubetuKbn);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisin).getResults();
    }

    public ExDBResults<MT_DsMailHaisin> getDsMailHaisinByDssousinmailsyubetukbn() {

        QMT_DsMailHaisin qMT_DsMailHaisin = new QMT_DsMailHaisin("qMT_DsMailHaisin");

        String strSql = $SELECT + qMT_DsMailHaisin +
            $FROM(qMT_DsMailHaisin) +
            $WHERE + qMT_DsMailHaisin.dssousinmailsyubetukbn.eq(C_DsSousinMailSyubetuKbn.CLEANINGMAIL) +
            $OR + qMT_DsMailHaisin.dssousinmailsyubetukbn.eq(C_DsSousinMailSyubetuKbn.HOKENRYOUYENOSIRASEMAIL);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_DsMailHaisin).getResults();
    }
}
