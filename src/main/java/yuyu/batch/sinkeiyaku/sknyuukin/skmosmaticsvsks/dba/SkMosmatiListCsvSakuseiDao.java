package yuyu.batch.sinkeiyaku.sknyuukin.skmosmaticsvsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.QHV_MosSyoruiMitoutyakuList;

/**
 * 新契約 入金 申込書類未到着CSV作成DAOクラスです
 */
public class SkMosmatiListCsvSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HV_MosSyoruiMitoutyakuList> getMosSyoruiMitoutyakuListsBySyoriYmdNyktyhyoutlst(BizDate pKnjyymd,
        C_NyktyhyoutKbn... pNyktyhyoutList) {

        QHV_MosSyoruiMitoutyakuList qHV_MosSyoruiMitoutyakuList = new QHV_MosSyoruiMitoutyakuList();

        String strSql = $SELECT + qHV_MosSyoruiMitoutyakuList +
            $FROM(qHV_MosSyoruiMitoutyakuList) +
            $WHERE + qHV_MosSyoruiMitoutyakuList.knjyymd.le(pKnjyymd) +
            $AND + qHV_MosSyoruiMitoutyakuList.nyktyhyoutkbn.in(pNyktyhyoutList) +
            $ORDER_BY(qHV_MosSyoruiMitoutyakuList.oyadrtencd.asc(),
                qHV_MosSyoruiMitoutyakuList.knjyymd.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHV_MosSyoruiMitoutyakuList).getResults();
    }

}
