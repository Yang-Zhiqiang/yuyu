package yuyu.batch.sinkeiyaku.sknyuukin.skmosmatikeikalistsakusei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.QHW_MosMatiKknKeikaWk;

/**
 * 新契約 入金 申込書類未到着期間経過リスト作成Daoクラス
 */
public class SkMosmatiKeikaListSakuseiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HW_MosMatiKknKeikaWk> getMosMatiKknKeikaWksBySyoriYmdRstuukasyuNyktyhyoutlst(BizDate pSyoriYmd,
        C_Tuukasyu pRstuukasyu, C_NyktyhyoutKbn... pNyktyhyoutKbnLst) {

        QHW_MosMatiKknKeikaWk qHW_MosMatiKknKeikaWk = new QHW_MosMatiKknKeikaWk("qHW_MosMatiKknKeikaWk");

        String strSql = $SELECT + qHW_MosMatiKknKeikaWk +
            $FROM(qHW_MosMatiKknKeikaWk) +
            $WHERE + qHW_MosMatiKknKeikaWk.syoriYmd.eq(pSyoriYmd) +
            $AND + qHW_MosMatiKknKeikaWk.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHW_MosMatiKknKeikaWk.nyktyhyoutkbn.in(pNyktyhyoutKbnLst) +
            $ORDER_BY (qHW_MosMatiKknKeikaWk.oyadrtencd.asc(),
                qHW_MosMatiKknKeikaWk.knjyymd.asc(),
                qHW_MosMatiKknKeikaWk.mosno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qHW_MosMatiKknKeikaWk).getResults();
    }

}
