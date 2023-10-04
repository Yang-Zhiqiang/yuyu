package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomihuittilistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.db.entity.HW_NyuukinJyouhouHuittiWk;
import yuyu.def.db.meta.QHW_NyuukinJyouhouHuittiWk;

/**
 * 新契約 入金 振込入金不一致リスト作成Daoクラス
 */
public class SkHurikomiHuittiListSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HW_NyuukinJyouhouHuittiWk> getNyuukinJyouhouHuittiWksBySyoriYmdNyktyhyoutlst(BizDate pSyoriYmd, C_NyktyhyoutKbn... pNyktyhyOutLst) {

        QHW_NyuukinJyouhouHuittiWk qHW_NyuukinJyouhouHuittiWk = new QHW_NyuukinJyouhouHuittiWk("qHW_NyuukinJyouhouHuittiWk");

        String strSql = $SELECT + qHW_NyuukinJyouhouHuittiWk +
            $FROM(qHW_NyuukinJyouhouHuittiWk) +
            $WHERE + qHW_NyuukinJyouhouHuittiWk.syoriYmd.eq(pSyoriYmd) +
            $AND + qHW_NyuukinJyouhouHuittiWk.nyktyhyoutkbn.in(pNyktyhyOutLst) +
            $ORDER_BY(qHW_NyuukinJyouhouHuittiWk.oyadrtencd.asc(),
                qHW_NyuukinJyouhouHuittiWk.knjyymd.asc(),
                qHW_NyuukinJyouhouHuittiWk.nykmosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHW_NyuukinJyouhouHuittiWk).getResults();
    }
}
