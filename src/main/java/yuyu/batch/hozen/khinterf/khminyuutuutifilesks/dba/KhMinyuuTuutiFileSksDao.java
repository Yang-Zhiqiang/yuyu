package yuyu.batch.hozen.khinterf.khminyuutuutifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.meta.QIT_KouzahuriMinyuTuuti;

/**
 * 契約保全 インターフェイス 未入通知Ｆ作成機能DAOクラス
 */
public class KhMinyuuTuutiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhMinyuuTuutiBean> getMinyuuTuutiBeans(String pKakutyoujobcd, BizDate pTyouhyouYmd) {

        QIT_KouzahuriMinyuTuuti qIT_KouzahuriMinyuTuuti = new QIT_KouzahuriMinyuTuuti("qIT_KouzahuriMinyuTuuti");

        String strSql = $SELECT + $NEW(KhMinyuuTuutiBean.class,
            qIT_KouzahuriMinyuTuuti.kbnkey,
            qIT_KouzahuriMinyuTuuti.syono,
            qIT_KouzahuriMinyuTuuti.tyouhyouymd,
            qIT_KouzahuriMinyuTuuti.syoruiCd,
            qIT_KouzahuriMinyuTuuti.hassoukbn,
            qIT_KouzahuriMinyuTuuti.shskyno,
            qIT_KouzahuriMinyuTuuti.shsadr1kj,
            qIT_KouzahuriMinyuTuuti.shsadr2kj,
            qIT_KouzahuriMinyuTuuti.shsadr3kj,
            qIT_KouzahuriMinyuTuuti.shsnmkj,
            qIT_KouzahuriMinyuTuuti.toiawasesosikinmkj,
            qIT_KouzahuriMinyuTuuti.toiawaseyno,
            qIT_KouzahuriMinyuTuuti.toiawaseadr1kj,
            qIT_KouzahuriMinyuTuuti.toiawaseadr2kj,
            qIT_KouzahuriMinyuTuuti.toiawaseadr3kj,
            qIT_KouzahuriMinyuTuuti.toiawasetelno,
            qIT_KouzahuriMinyuTuuti.toiawaseteluktkkanou1,
            qIT_KouzahuriMinyuTuuti.toiawaseteluktkkanou2,
            qIT_KouzahuriMinyuTuuti.toiawasesosikinmkj2,
            qIT_KouzahuriMinyuTuuti.toiawasetelno2,
            qIT_KouzahuriMinyuTuuti.tuutinm30keta,
            qIT_KouzahuriMinyuTuuti.minyuttmsg1,
            qIT_KouzahuriMinyuTuuti.minyuttmsg2,
            qIT_KouzahuriMinyuTuuti.minyuttmsg3,
            qIT_KouzahuriMinyuTuuti.minyuttmsg4,
            qIT_KouzahuriMinyuTuuti.minyuttmsg5,
            qIT_KouzahuriMinyuTuuti.minyuttmsg6,
            qIT_KouzahuriMinyuTuuti.minyuttmsg7,
            qIT_KouzahuriMinyuTuuti.minyuttmsg8,
            qIT_KouzahuriMinyuTuuti.minyuttmsg9,
            qIT_KouzahuriMinyuTuuti.minyuttmsg10,
            qIT_KouzahuriMinyuTuuti.minyuttmsg11,
            qIT_KouzahuriMinyuTuuti.minyuttmsg12,
            qIT_KouzahuriMinyuTuuti.pannainm,
            qIT_KouzahuriMinyuTuuti.hrkhou12keta,
            qIT_KouzahuriMinyuTuuti.hhknnmkj,
            qIT_KouzahuriMinyuTuuti.nexthurikaenaiyou1,
            qIT_KouzahuriMinyuTuuti.nexthurikaenaiyou2,
            qIT_KouzahuriMinyuTuuti.nexthurikaenaiyou3,
            qIT_KouzahuriMinyuTuuti.saikokutukiyykkn1,
            qIT_KouzahuriMinyuTuuti.saikokutukiyykkn2,
            qIT_KouzahuriMinyuTuuti.hrkmirmsg1,
            qIT_KouzahuriMinyuTuuti.hrkmirmsg2,
            qIT_KouzahuriMinyuTuuti.hrkmirmsg3,
            qIT_KouzahuriMinyuTuuti.zenhurikaenaiyou1,
            qIT_KouzahuriMinyuTuuti.zenhurikaenaiyou2,
            qIT_KouzahuriMinyuTuuti.zenhurikaenaiyou3,
            qIT_KouzahuriMinyuTuuti.zenhurikaenaiyou4,
            qIT_KouzahuriMinyuTuuti.hurikaekz37keta1,
            qIT_KouzahuriMinyuTuuti.hurikaekz37keta2,
            qIT_KouzahuriMinyuTuuti.hurikaekz37keta3,
            qIT_KouzahuriMinyuTuuti.hurikaekz37keta4,
            qIT_KouzahuriMinyuTuuti.hurikaekz37keta5,
            qIT_KouzahuriMinyuTuuti.hurikaekz37keta6,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg1,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg2,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg3,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg4,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg5,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg6,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg7,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg8,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg9,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg10,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg11,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg12,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg13,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg14,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg15,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg16,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg17,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg18,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg19,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg20,
            qIT_KouzahuriMinyuTuuti.minyuttaddmsg21,
            qIT_KouzahuriMinyuTuuti.tuutisyuruicd,
            qIT_KouzahuriMinyuTuuti.tyouhyoukigoukbn) +
            $FROM(qIT_KouzahuriMinyuTuuti) +
            $WHERE + qIT_KouzahuriMinyuTuuti.tyouhyouymd.eq(pTyouhyouYmd);

        ExDBResults<KhMinyuuTuutiBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhMinyuuTuutiBean.class).bind(qIT_KouzahuriMinyuTuuti).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
    public String getSyoricd (String pKinouId) {
        QAS_Kinou qAS_Kinou = new QAS_Kinou("qAS_Kinou");

        String strSql = $SELECT + qAS_Kinou.syoricd +
            $FROM(qAS_Kinou) +
            $WHERE + qAS_Kinou.kinouId.eq(pKinouId);

        return exDBEntityManager.createJPQL(strSql).bind(qAS_Kinou).getSingleResult();
    }

}
