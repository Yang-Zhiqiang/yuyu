package yuyu.common.biz.kaikei.dba4bzfbsoukinfilesks;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.meta.QBT_FBSoukinData;

/**
 * 業務共通 経理・会計 ＦＢ送金ファイル作成の機能DAOクラス
 */
public class BzFbSoukinFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<BT_FBSoukinData> getFBSoukinFileDatas(String pKakutyoujobcd,
        BizDate pSyoriYmd, C_FbSoukinBatchKbn pFbSoukinBatchKbn, C_ShrhousiteiKbn... pShrhousiteiKbn) {

        QBT_FBSoukinData qBT_FBSoukinData = new QBT_FBSoukinData
            ("qBT_FBSoukinData");

        String strSql = $SELECT + qBT_FBSoukinData +
            $FROM(qBT_FBSoukinData) +
            $WHERE + qBT_FBSoukinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_FBSoukinData.fbsoukinbatchkbn.eq(pFbSoukinBatchKbn) +
            $AND + qBT_FBSoukinData.shrhousiteikbn.in(pShrhousiteiKbn) +
            $ORDER_BY(qBT_FBSoukinData.gyoumucd.asc(),
                qBT_FBSoukinData.bankcd.asc(),
                qBT_FBSoukinData.sitencd.asc(),
                qBT_FBSoukinData.yokinkbn.asc(),
                qBT_FBSoukinData.kouzano.asc(),
                qBT_FBSoukinData.kzmeiginmkn.asc(),
                qBT_FBSoukinData.keirisyono.asc());

        ExDBResults<BT_FBSoukinData> exDBResults = exDBEntityManager
            .createJPQL(strSql)
            .bind(qBT_FBSoukinData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

}
