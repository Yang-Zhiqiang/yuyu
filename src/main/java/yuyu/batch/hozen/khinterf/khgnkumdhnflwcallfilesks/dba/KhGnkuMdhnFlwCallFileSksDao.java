package yuyu.batch.hozen.khinterf.khgnkumdhnflwcallfilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_GinkouMdhnFollowCall;

/**
 * 契約保全 インターフェイス 銀行窓販フォローコール対象Ｆ作成機能DAOクラス
 */
public class KhGnkuMdhnFlwCallFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhFollowCallTaisyouDataBean> getKhFollowCallTaisyouDataBeans(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_GinkouMdhnFollowCall qIT_GinkouMdhnFollowCall = new QIT_GinkouMdhnFollowCall("qIT_GinkouMdhnFollowCall");

        String strSql = $SELECT + $NEW(KhFollowCallTaisyouDataBean.class,
            qIT_GinkouMdhnFollowCall.kbnkey,
            qIT_GinkouMdhnFollowCall.syoriYmd,
            qIT_GinkouMdhnFollowCall.syono,
            qIT_GinkouMdhnFollowCall.kyksakuinmeino,
            qIT_GinkouMdhnFollowCall.kykseiymd,
            qIT_GinkouMdhnFollowCall.kyknmkj,
            qIT_GinkouMdhnFollowCall.kyknmkn,
            qIT_GinkouMdhnFollowCall.tsintelno,
            qIT_GinkouMdhnFollowCall.followcallsyorikbn,
            qIT_GinkouMdhnFollowCall.tsinyno,
            qIT_GinkouMdhnFollowCall.tsinadr1kj,
            qIT_GinkouMdhnFollowCall.tsinadr2kj,
            qIT_GinkouMdhnFollowCall.tsinadr3kj,
            qIT_GinkouMdhnFollowCall.bsyujdrtencd1,
            qIT_GinkouMdhnFollowCall.bsyujbosyuucd1,
            qIT_GinkouMdhnFollowCall.bsyujdrtencd2,
            qIT_GinkouMdhnFollowCall.bsyujbosyuucd2,
            qIT_GinkouMdhnFollowCall.bsyujdrtencd3,
            qIT_GinkouMdhnFollowCall.bsyujbosyuucd3,
            qIT_GinkouMdhnFollowCall.bsyujdrtencd4,
            qIT_GinkouMdhnFollowCall.bsyujbosyuucd4,
            qIT_GinkouMdhnFollowCall.bsyujdrtencd5,
            qIT_GinkouMdhnFollowCall.bsyujbosyuucd5,
            qIT_GinkouMdhnFollowCall.saisindrtencd,
            qIT_GinkouMdhnFollowCall.saisinbosyuucd,
            qIT_GinkouMdhnFollowCall.syouhnnm,
            qIT_GinkouMdhnFollowCall.kykymd,
            qIT_GinkouMdhnFollowCall.jkipjytym,
            qIT_GinkouMdhnFollowCall.annaigk.getTypeFieldName(),
            qIT_GinkouMdhnFollowCall.annaigk.getValueFieldName(),
            qIT_GinkouMdhnFollowCall.hrkkeiro,
            qIT_GinkouMdhnFollowCall.fchrkkaisuu,
            qIT_GinkouMdhnFollowCall.anniskcd,
            qIT_GinkouMdhnFollowCall.bankcd,
            qIT_GinkouMdhnFollowCall.sitencd,
            qIT_GinkouMdhnFollowCall.yokinkbn,
            qIT_GinkouMdhnFollowCall.kouzano,
            qIT_GinkouMdhnFollowCall.kzmeiginmkn,
            qIT_GinkouMdhnFollowCall.hhknnmkj,
            qIT_GinkouMdhnFollowCall.hhknnmkn,
            qIT_GinkouMdhnFollowCall.hhknsei,
            qIT_GinkouMdhnFollowCall.hhknseiymd,
            qIT_GinkouMdhnFollowCall.minyuym,
            qIT_GinkouMdhnFollowCall.kyknmhnykkbn,
            qIT_GinkouMdhnFollowCall.hhknnmhnykkbn ) +
            $FROM(qIT_GinkouMdhnFollowCall) +
            $WHERE + qIT_GinkouMdhnFollowCall.syoriYmd.eq(pSyoriYmd);

        ExDBResults<KhFollowCallTaisyouDataBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhFollowCallTaisyouDataBean.class).bind(qIT_GinkouMdhnFollowCall).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
