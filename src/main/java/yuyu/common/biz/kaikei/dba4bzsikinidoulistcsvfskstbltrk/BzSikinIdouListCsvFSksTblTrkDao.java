package yuyu.common.biz.kaikei.dba4bzsikinidoulistcsvfskstbltrk;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.db.meta.QBT_SikinIdouListCsvFSks;

/**
 * 業務共通 経理・会計 資金移動リストＣＳＶファイル作成用テーブル登録DAOクラス
 */
public class BzSikinIdouListCsvFSksTblTrkDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Integer delBzSikinIdouCsvFileSksTbl(BizDate pSyoriYmd, C_SikinidoulistKbn[] pSikinidoulistKbn) {

        QBT_SikinIdouListCsvFSks qBT_SikinIdouListCsvFSks = new QBT_SikinIdouListCsvFSks("qBT_SikinIdouListCsvFSks");

        String strSql =  $DELETE_FROM(qBT_SikinIdouListCsvFSks) +
            $WHERE + qBT_SikinIdouListCsvFSks.syoriYmd.eq(pSyoriYmd) +
            $AND   + qBT_SikinIdouListCsvFSks.sikinidoulistkbn.in(pSikinidoulistKbn);

        return exDBEntityManager.createJPQL(strSql).bind(qBT_SikinIdouListCsvFSks).executeUpdate();
    }
}
