package yuyu.batch.hozen.khozen.khkanyuusyanoinfosakujyo.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QIT_KhLincSousinData;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 契約保全 契約保全加入者番号情報削除の機能DAOクラス
 */
public class KhKanyuusyanoInfoSakujyoDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhLincSousinDataBean> getKhLincSousinData(String pKakutyoujobcd, BizDate pSyoriYmd) {
        QIT_KhLincSousinData qIT_KhLincSousinData = new QIT_KhLincSousinData("qIT_KhLincSousinData");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String strSql = $SELECT + $NEW(KhLincSousinDataBean.class,
            qIT_KhLincSousinData.kbnkey,
            qIT_KhLincSousinData.syono,
            qIT_KhLincSousinData.linchenkoutype) +
            $FROM(qIT_KhLincSousinData,
                qIT_KykSyouhn) +
            $WHERE + qIT_KhLincSousinData.syono.eq(qIT_KykSyouhn.syono) +
            $AND + qIT_KhLincSousinData.syoriYmd.eq(pSyoriYmd) +
            $AND + qIT_KhLincSousinData.lincsousinkbn.eq(C_SousinKbn.SOUSINMATI) +
            $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $ORDER_BY(qIT_KhLincSousinData.renno.desc());

        ExDBResults<KhLincSousinDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhLincSousinDataBean.class).bind(
            qIT_KhLincSousinData, qIT_KykSyouhn).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
