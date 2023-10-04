package yuyu.batch.hozen.khozen.khkanryoutuutijigosgylistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_TtdkKan;

/**
 * 契約保全 契約保全 完了通知事後作業リスト作成の機能DAOクラス
 */
public class KhKanryouTuutiJigoSgyListSksDao {

    @Inject
    protected ExDBEntityManager exDBEntityManager;

    public ExDBResults<TtdkKanBean> getTtdkKanryouInfo(String pKakutyoujobcd,
        BizDate pTstyouhyouymd, C_SyoruiCdKbn pSyoruiCdKbn, C_HassouKbn pHassouKbn) {

        QIT_TtdkKan qIT_TtdkKan = new QIT_TtdkKan("qIT_TtdkKan");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String strSql = $SELECT + $NEW(TtdkKanBean.class,
            qIT_TtdkKan.kbnkey,
            qIT_TtdkKan.syono,
            qIT_TtdkKan.shsnmkj,
            qIT_TtdkKan.kyknmkj,
            qIT_KykKihon.sbuktnin) +
            $FROM(qIT_TtdkKan,
                qIT_KykKihon) +
                $WHERE + qIT_TtdkKan.tyouhyouymd.eq(pTstyouhyouymd) +
                $AND + qIT_TtdkKan.syoruiCd.eq(pSyoruiCdKbn) +
                $AND + qIT_TtdkKan.hassoukbn.eq(pHassouKbn) +
                $AND + qIT_TtdkKan.syono.eq(qIT_KykKihon.syono) +
                $ORDER_BY(qIT_TtdkKan.syono.asc(),
                    qIT_TtdkKan.henkousikibetukey.asc());

        ExDBResults<TtdkKanBean> exDBResults = exDBEntityManager.createJPQL(strSql, TtdkKanBean.class)
            .bind(qIT_TtdkKan, qIT_KykKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
