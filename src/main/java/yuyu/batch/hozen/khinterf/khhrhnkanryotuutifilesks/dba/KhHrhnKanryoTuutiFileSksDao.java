package yuyu.batch.hozen.khinterf.khhrhnkanryotuutifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_HrhnTtdkKan;

/**
 * 契約保全 インターフェイス 払変完了通知（ＤＮＰ）Ｆ作成DAOクラス
 */
public class KhHrhnKanryoTuutiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhHrhnKanryoTuutiBean> getKhHrhnKanryoTuutiBeans (String pKakutyoujobcd, BizDate pTyouhyouymd) {

        QIT_HrhnTtdkKan qIT_HrhnTtdkKan  = new QIT_HrhnTtdkKan("qIT_HrhnTtdkKan");

        String strSql = $SELECT + $NEW(KhHrhnKanryoTuutiBean.class,
            qIT_HrhnTtdkKan.kbnkey,
            qIT_HrhnTtdkKan.syono,
            qIT_HrhnTtdkKan.henkousikibetukey,
            qIT_HrhnTtdkKan.syoruiCd,
            qIT_HrhnTtdkKan.tyouhyouymd,
            qIT_HrhnTtdkKan.shskyno,
            qIT_HrhnTtdkKan.shsadr1kj,
            qIT_HrhnTtdkKan.shsadr2kj,
            qIT_HrhnTtdkKan.shsadr3kj,
            qIT_HrhnTtdkKan.shsnmkj,
            qIT_HrhnTtdkKan.toiawasesosikinmkj,
            qIT_HrhnTtdkKan.toiawaseyno,
            qIT_HrhnTtdkKan.toiawaseadr1kj,
            qIT_HrhnTtdkKan.toiawaseadr2kj,
            qIT_HrhnTtdkKan.toiawaseadr3kj,
            qIT_HrhnTtdkKan.toiawasetelno,
            qIT_HrhnTtdkKan.toiawaseteluktkkanou1,
            qIT_HrhnTtdkKan.toiawaseteluktkkanou2,
            qIT_HrhnTtdkKan.toiawasesosikinmkj2,
            qIT_HrhnTtdkKan.toiawasetelno2,
            qIT_HrhnTtdkKan.kouzamaskingmsg,
            qIT_HrhnTtdkKan.hrkkaisuutkiktbrisyu,
            qIT_HrhnTtdkKan.hrkkeiro,
            qIT_HrhnTtdkKan.hrkp.getTypeFieldName(),
            qIT_HrhnTtdkKan.hrkp.getValueFieldName(),
            qIT_HrhnTtdkKan.kouryokuhasseiym,
            qIT_HrhnTtdkKan.msgarea34keta1,
            qIT_HrhnTtdkKan.msgarea34keta2,
            qIT_HrhnTtdkKan.msgarea34keta3,
            qIT_HrhnTtdkKan.msgarea34keta4,
            qIT_HrhnTtdkKan.msgarea34keta5,
            qIT_HrhnTtdkKan.msgarea34keta6,
            qIT_HrhnTtdkKan.msgarea34keta7,
            qIT_HrhnTtdkKan.hrkykkmsg34keta1,
            qIT_HrhnTtdkKan.hrkykkmsg34keta2,
            qIT_HrhnTtdkKan.hrkykkmsg34keta3,
            qIT_HrhnTtdkKan.hrkykkmsg34keta4,
            qIT_HrhnTtdkKan.hrkykkmsg34keta5,
            qIT_HrhnTtdkKan.hrkykkmsg34keta6,
            qIT_HrhnTtdkKan.hrkykkmsg34keta7,
            qIT_HrhnTtdkKan.hrkykkmsg34keta8,
            qIT_HrhnTtdkKan.hrkykkmsg34keta9,
            qIT_HrhnTtdkKan.hrkykkmsg34keta10,
            qIT_HrhnTtdkKan.hrkykkmsg34keta11,
            qIT_HrhnTtdkKan.hrkykkmsg34keta12,
            qIT_HrhnTtdkKan.hrkykkmsg34keta13,
            qIT_HrhnTtdkKan.hrkykkmsg34keta14,
            qIT_HrhnTtdkKan.hrkykkmsg34keta15,
            qIT_HrhnTtdkKan.hrkykkmsg34keta16,
            qIT_HrhnTtdkKan.hrkykkmsg34keta17,
            qIT_HrhnTtdkKan.hrkykkmsg34keta18,
            qIT_HrhnTtdkKan.hrkykkmsg34keta19,
            qIT_HrhnTtdkKan.hrkykkmsg34keta20,
            qIT_HrhnTtdkKan.hrkykkmsg34keta21,
            qIT_HrhnTtdkKan.hrkykkmsg34keta22,
            qIT_HrhnTtdkKan.hrkykkmsg34keta23,
            qIT_HrhnTtdkKan.hrkykkmsg34keta24,
            qIT_HrhnTtdkKan.hrkykkmsg34keta25,
            qIT_HrhnTtdkKan.hrkykkmsg34keta26,
            qIT_HrhnTtdkKan.hrkykkmsg34keta27,
            qIT_HrhnTtdkKan.hrkykkmsg34keta28,
            qIT_HrhnTtdkKan.hassoukbn,
            qIT_HrhnTtdkKan.honsyakaisouriyuu) +
            $FROM(qIT_HrhnTtdkKan) +
            $WHERE + qIT_HrhnTtdkKan.tyouhyouymd.eq(pTyouhyouymd);

        ExDBResults<KhHrhnKanryoTuutiBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhHrhnKanryoTuutiBean.class)
            .bind(qIT_HrhnTtdkKan).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
