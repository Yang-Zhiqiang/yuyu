package yuyu.batch.biz.bzkaikei.bzkariukemeisailistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 業務共通 経理･会計 仮受計上明細リスト作成DAOクラスです。<br />
 */
public class BzKariukeMeisaiListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HijynbrsikinidougkDataBean> getHijynbrSikinidougk(BizDate pSyoriYmd) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBT_DenpyoData qBT_DenpyoData2 = new QBT_DenpyoData("qBT_DenpyoData2");

        String strSubSql1 = $SELECT + qBT_DenpyoData2.denrenno +
            $FROM(qBT_DenpyoData2) +
            $WHERE + qBT_DenpyoData2.densyskbn.eq(qBT_DenpyoData.densyskbn) +
            $AND + qBT_DenpyoData2.denrenno.eq(qBT_DenpyoData.denrenno) +
            $AND + qBT_DenpyoData2.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData2.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
            $AND + qBT_DenpyoData2.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO);

        String strSql = $SELECT + $NEW(HijynbrsikinidougkDataBean.class,
            qBT_DenpyoData.denrenno,
            qBT_DenpyoData.hijynbrsikinidougk.getTypeFieldName(),
            $SUM + $(qBT_DenpyoData.hijynbrsikinidougk.getValueFieldName())) +
            $FROM(qBT_DenpyoData,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qBT_DenpyoData.keirisyono.eq(qIT_KykKihon.syono) +
                $AND + qBT_DenpyoData.keirisyono.eq(qIT_KykSyouhn.syono) +
                $AND + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
                $AND + qBT_DenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KARIKATA) +
                $AND + qBT_DenpyoData.densyskbn.ne(C_DensysKbn.SKEI) +
                $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.BLNK) +
                $AND + qIT_KykKihon.hrkkaisuu.ne(C_Hrkkaisuu.ITIJI) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + $EXISTS(strSubSql1) +
                $GROUP_BY + qBT_DenpyoData.denrenno + "," +
                qBT_DenpyoData.hijynbrsikinidougk.getTypeFieldName();

        return exDBEntityManager.createJPQL(strSql, HijynbrsikinidougkDataBean.class).bind(qBT_DenpyoData,qIT_KykKihon,qIT_KykSyouhn,qBT_DenpyoData2)
            .getResults();
    }

    public ExDBResults<ItijibrsikinidougkDataBean> getItijibrsikinidougkDataBeans(BizDate pSyoriYmd) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QBT_DenpyoData qBT_DenpyoData2 = new QBT_DenpyoData("qBT_DenpyoData2");

        String strSubSql1 = $SELECT + qBT_DenpyoData2.denrenno +
            $FROM(qBT_DenpyoData2) +
            $WHERE + qBT_DenpyoData2.densyskbn.eq(qBT_DenpyoData.densyskbn) +
            $AND + qBT_DenpyoData2.denrenno.eq(qBT_DenpyoData.denrenno) +
            $AND + qBT_DenpyoData2.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData2.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
            $AND + qBT_DenpyoData2.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO);

        String strSql = $SELECT + $NEW(ItijibrsikinidougkDataBean.class,
            qBT_DenpyoData.denrenno,
            qBT_DenpyoData.keiyakutuukagk.getTypeFieldName(),
            $SUM + $(qBT_DenpyoData.keiyakutuukagk.getValueFieldName())) +
            $FROM(qBT_DenpyoData,
                qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qBT_DenpyoData.keirisyono.eq(qIT_KykKihon.syono) +
                $AND + qBT_DenpyoData.keirisyono.eq(qIT_KykSyouhn.syono) +
                $AND + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
                $AND + qBT_DenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KARIKATA) +
                $AND + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.ITIJI) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
                $AND + qIT_KykSyouhn.kyktuukasyu.ne(C_Tuukasyu.JPY) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + $EXISTS(strSubSql1) +
                $GROUP_BY + qBT_DenpyoData.denrenno + "," +
                qBT_DenpyoData.keiyakutuukagk.getTypeFieldName();

        return exDBEntityManager.createJPQL(strSql, ItijibrsikinidougkDataBean.class).bind(qBT_DenpyoData,qIT_KykKihon,qIT_KykSyouhn,qBT_DenpyoData2)
            .getResults();
    }

}
