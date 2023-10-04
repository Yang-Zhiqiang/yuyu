package yuyu.batch.hozen.khinterf.khkzhurikaisiannaifsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_KouzahuriStartAnnai;

/**
 * 契約保全 インターフェイス 口座振替開始案内Ｆ作成Daoクラス
 */
public class KhKzhuriKaisiAnnaiFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKzhuriKaisiAnnaiFSksBean> getKhKzhuriKaisiAnnaiFSksBean(String pKakutyoujobcd,
        BizDate pSyoriYmd) {

        QIT_KouzahuriStartAnnai qIT_KouzahuriStartAnnai = new QIT_KouzahuriStartAnnai("qIT_KouzahuriStartAnnai");

        String strSql = $SELECT + $NEW(KhKzhuriKaisiAnnaiFSksBean.class,
            qIT_KouzahuriStartAnnai.kbnkey,
            qIT_KouzahuriStartAnnai.syono,
            qIT_KouzahuriStartAnnai.tyouhyouymd,
            qIT_KouzahuriStartAnnai.syoruiCd,
            qIT_KouzahuriStartAnnai.hassoukbn,
            qIT_KouzahuriStartAnnai.tsinyno,
            qIT_KouzahuriStartAnnai.tsinadr1kj,
            qIT_KouzahuriStartAnnai.tsinadr2kj,
            qIT_KouzahuriStartAnnai.tsinadr3kj,
            qIT_KouzahuriStartAnnai.kyknmkj,
            qIT_KouzahuriStartAnnai.toiawasesosikinmkj,
            qIT_KouzahuriStartAnnai.toiawaseyno,
            qIT_KouzahuriStartAnnai.toiawaseadr1kj,
            qIT_KouzahuriStartAnnai.toiawaseadr2kj,
            qIT_KouzahuriStartAnnai.toiawaseadr3kj,
            qIT_KouzahuriStartAnnai.toiawasetelno,
            qIT_KouzahuriStartAnnai.toiawaseteluktkkanou1,
            qIT_KouzahuriStartAnnai.toiawaseteluktkkanou2,
            qIT_KouzahuriStartAnnai.toiawasesosikinmkj2,
            qIT_KouzahuriStartAnnai.toiawasetelno2,
            qIT_KouzahuriStartAnnai.tuutinm,
            qIT_KouzahuriStartAnnai.aisatumongon1,
            qIT_KouzahuriStartAnnai.aisatumongon2,
            qIT_KouzahuriStartAnnai.aisatumongon3,
            qIT_KouzahuriStartAnnai.aisatumongon4,
            qIT_KouzahuriStartAnnai.aisatumongon5,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai1,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai2,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai3,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai4,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai5,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai6,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai7,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai8,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai9,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai10,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai11,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai12,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai13,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai14,
            qIT_KouzahuriStartAnnai.kzhurikaeonegai15,
            qIT_KouzahuriStartAnnai.syouhnnm,
            qIT_KouzahuriStartAnnai.kykymd,
            qIT_KouzahuriStartAnnai.tkbriphurikaeyoteigk,
            qIT_KouzahuriStartAnnai.hhknnmkj,
            qIT_KouzahuriStartAnnai.hurikaekzhosokumongon,
            qIT_KouzahuriStartAnnai.hurikaekz1,
            qIT_KouzahuriStartAnnai.hurikaekz2,
            qIT_KouzahuriStartAnnai.hurikaekz3,
            qIT_KouzahuriStartAnnai.hurikaekz4,
            qIT_KouzahuriStartAnnai.hurikaekz5,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea1,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea2,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea3,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea4,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea5,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea6,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea7,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea8,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea9,
            qIT_KouzahuriStartAnnai.kzhuristartanfreearea10) +
            $FROM(qIT_KouzahuriStartAnnai) +
            $WHERE + qIT_KouzahuriStartAnnai.tyouhyouymd.eq(pSyoriYmd);

        ExDBResults<KhKzhuriKaisiAnnaiFSksBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, KhKzhuriKaisiAnnaiFSksBean.class).bind(qIT_KouzahuriStartAnnai).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;

    }
}
