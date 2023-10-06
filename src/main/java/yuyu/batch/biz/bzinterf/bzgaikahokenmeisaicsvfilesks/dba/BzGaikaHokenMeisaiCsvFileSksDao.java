package yuyu.batch.biz.bzinterf.bzgaikahokenmeisaicsvfilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QBT_KrDenpyoSelectJk;

/**
 * 業務共通 インターフェース 外貨建保険明細ＣＳＶファイル作成DAOクラスです。<br />
 */
public class BzGaikaHokenMeisaiCsvFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<KrDenpyoSelectJyokenBean> getKrDenpyoSelectJyokenBeans(BizDate pBatchExecDate) {

        QBT_KrDenpyoSelectJk qBT_KrDenpyoSelectJk = new QBT_KrDenpyoSelectJk("qBT_KrDenpyoSelectJk");

        String strSql = $SELECT + $NEW(KrDenpyoSelectJyokenBean.class,
            qBT_KrDenpyoSelectJk.syoriYmd,
            qBT_KrDenpyoSelectJk.syoriymdrenno,
            qBT_KrDenpyoSelectJk.taisyoukknfrom,
            qBT_KrDenpyoSelectJk.taisyoukknto,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd1,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd2,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd3,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd4,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd5,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd6,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd7,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd8,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd9,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd10,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd11,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd12,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd13,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd14,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd15,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd16,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd17,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd18,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd19,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd20,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd21,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd22,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd23,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd24,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd25,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd26,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd27,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd28,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd29,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd30,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd31,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd32,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd33,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd34,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd35,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd36,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd37,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd38,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd39,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd40,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd41,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd42,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd43,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd44,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd45,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd46,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd47,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd48,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd49,
            qBT_KrDenpyoSelectJk.kanjyoukmkcd50)  +
            $FROM(qBT_KrDenpyoSelectJk) +
            $WHERE + qBT_KrDenpyoSelectJk.syoriYmd.eq(pBatchExecDate) +
            $ORDER_BY (qBT_KrDenpyoSelectJk.syoriymdrenno.asc());

        return exDBEntityManager.createJPQL(strSql, KrDenpyoSelectJyokenBean.class).bind(qBT_KrDenpyoSelectJk)
            .getResultList();
    }

    public ExDBResults<GaikaHokenMeisaiDataBean> getGaikaHokenMeisaiDataBeans(BizDate pTaisyoukknFrom,
        BizDate pTaisyoukknTo, C_Kanjyoukmkcd[] pKanjyoukmkcds) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");

        QBT_DenpyoData qBT_DenpyoData2 = new QBT_DenpyoData("qBT_DenpyoData2");

        String strSubSql1 = $SELECT + qBT_DenpyoData2.denrenno +
            $FROM(qBT_DenpyoData2) +
            $WHERE + qBT_DenpyoData2.densyskbn.eq(qBT_DenpyoData.densyskbn) +
            $AND + qBT_DenpyoData2.denrenno.eq(qBT_DenpyoData.denrenno) +
            $AND + qBT_DenpyoData2.denymd.ge(pTaisyoukknFrom) +
            $AND + qBT_DenpyoData2.denymd.le(pTaisyoukknTo) +
            $AND + qBT_DenpyoData2.kanjyoukmkcd.in(pKanjyoukmkcds);

        String strSql = $SELECT + $NEW(GaikaHokenMeisaiDataBean.class,
            qBT_DenpyoData.densyskbn,
            qBT_DenpyoData.denrenno,
            qBT_DenpyoData.edano,
            qBT_DenpyoData.keirisyono,
            qBT_DenpyoData.denymd,
            qBT_DenpyoData.taisyakukbn,
            qBT_DenpyoData.kanjyoukmkcd,
            qBT_DenpyoData.suitoubumoncd,
            qBT_DenpyoData.tuukasyu,
            qBT_DenpyoData.dengaikagk.getTypeFieldName(),
            qBT_DenpyoData.dengaikagk.getValueFieldName(),
            qBT_DenpyoData.denkawaserate,
            qBT_DenpyoData.denyenkagk.getTypeFieldName(),
            qBT_DenpyoData.denyenkagk.getValueFieldName(),
            qBT_DenpyoData.syoriYmd,
            qBT_DenpyoData.syoricd,
            qBT_DenpyoData.kessantyouseikbn,
            qBT_DenpyoData.densyorikbn,
            qBT_DenpyoData.kykymd,
            qBT_DenpyoData.syouhnsdno,
            qBT_DenpyoData.sknnkaisiymd,
            qBT_DenpyoData.mosymd,
            qBT_DenpyoData.fstpryosyuymd,
            qBT_DenpyoData.kyktuukasyu,
            qBT_DenpyoData.keiyakutuukagk.getTypeFieldName(),
            qBT_DenpyoData.keiyakutuukagk.getValueFieldName()) +
            $FROM(qBT_DenpyoData) +
            $WHERE + qBT_DenpyoData.denymd.ge(pTaisyoukknFrom) +
            $AND + qBT_DenpyoData.denymd.le(pTaisyoukknTo) +
            $AND + $EXISTS(strSubSql1) +
            $ORDER_BY(qBT_DenpyoData.denymd.asc(),
                qBT_DenpyoData.densyskbn.asc(),
                qBT_DenpyoData.denrenno.asc(),
                qBT_DenpyoData.edano.asc());

        return exDBEntityManager.createJPQL(strSql, GaikaHokenMeisaiDataBean.class).bind(qBT_DenpyoData, qBT_DenpyoData2)
            .getResults();
    }

}
