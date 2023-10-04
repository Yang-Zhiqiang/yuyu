package yuyu.batch.hozen.khinterf.khkijitutouraiannaifsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_KijituTouraiAnnai;

/**
 * 契約保全 インターフェイス 期日到来案内F作成DAO
 */
public class KhKijitutouraiAnnaiFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKijitutouraiAnnaiFSksBean> getKhKijitutouraiAnnaiFSksBean(String pKakutyoujobcd,
        BizDate pSyoriYmd) {

        QIT_KijituTouraiAnnai qIT_KijituTouraiAnnai = new QIT_KijituTouraiAnnai("qIT_KijituTouraiAnnai");

        String strSql = $SELECT + $NEW(KhKijitutouraiAnnaiFSksBean.class,
            qIT_KijituTouraiAnnai.kbnkey,
            qIT_KijituTouraiAnnai.syono,
            qIT_KijituTouraiAnnai.tyouhyouymd,
            qIT_KijituTouraiAnnai.syoruiCd,
            qIT_KijituTouraiAnnai.hassoukbn,
            qIT_KijituTouraiAnnai.shskyno,
            qIT_KijituTouraiAnnai.shsadr1kj,
            qIT_KijituTouraiAnnai.shsadr2kj,
            qIT_KijituTouraiAnnai.shsadr3kj,
            qIT_KijituTouraiAnnai.shsnmkj,
            qIT_KijituTouraiAnnai.toiawasesosikinmkj,
            qIT_KijituTouraiAnnai.toiawaseyno,
            qIT_KijituTouraiAnnai.toiawaseadr1kj,
            qIT_KijituTouraiAnnai.toiawaseadr2kj,
            qIT_KijituTouraiAnnai.toiawaseadr3kj,
            qIT_KijituTouraiAnnai.toiawasetelno,
            qIT_KijituTouraiAnnai.toiawaseteluktkkanou1,
            qIT_KijituTouraiAnnai.toiawaseteluktkkanou2,
            qIT_KijituTouraiAnnai.toiawasesosikinmkj2,
            qIT_KijituTouraiAnnai.toiawasetelno2,
            qIT_KijituTouraiAnnai.tuutinm20keta,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta1,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta2,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta3,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta4,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta5,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta6,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta7,
            qIT_KijituTouraiAnnai.hrkykkmsg32keta8,
            qIT_KijituTouraiAnnai.hrkkeiro,
            qIT_KijituTouraiAnnai.syouhnnm,
            qIT_KijituTouraiAnnai.kykymd,
            qIT_KijituTouraiAnnai.hhknnmkj,
            qIT_KijituTouraiAnnai.kjttrnnfreearea1,
            qIT_KijituTouraiAnnai.kjttrnnfreearea2,
            qIT_KijituTouraiAnnai.kjttrnnfreearea3,
            qIT_KijituTouraiAnnai.kjttrnnfreearea4,
            qIT_KijituTouraiAnnai.kjttrnnfreearea5,
            qIT_KijituTouraiAnnai.kjttrnnfreearea6,
            qIT_KijituTouraiAnnai.kjttrnnfreearea7,
            qIT_KijituTouraiAnnai.hurikaeymd,
            qIT_KijituTouraiAnnai.kzinfo1,
            qIT_KijituTouraiAnnai.kzinfo2,
            qIT_KijituTouraiAnnai.kzinfo3,
            qIT_KijituTouraiAnnai.kzinfo4,
            qIT_KijituTouraiAnnai.kzinfo5,
            qIT_KijituTouraiAnnai.kzinfo6,
            qIT_KijituTouraiAnnai.kzinfo7,
            qIT_KijituTouraiAnnai.kzinfo8,
            qIT_KijituTouraiAnnai.hknjytukikan,
            qIT_KijituTouraiAnnai.hrkgk1,
            qIT_KijituTouraiAnnai.hrkgk2,
            qIT_KijituTouraiAnnai.hrkgk3,
            qIT_KijituTouraiAnnai.hrkgk4,
            qIT_KijituTouraiAnnai.kjttrnnfreearea8,
            qIT_KijituTouraiAnnai.kjttrnnfreearea9,
            qIT_KijituTouraiAnnai.kjttrnnfreearea10,
            qIT_KijituTouraiAnnai.kjttrnnfreearea11,
            qIT_KijituTouraiAnnai.kjttrnnfreearea12,
            qIT_KijituTouraiAnnai.kjttrnnfreearea13) +
            $FROM(qIT_KijituTouraiAnnai) +
            $WHERE + qIT_KijituTouraiAnnai.tyouhyouymd.eq(pSyoriYmd);

        ExDBResults<KhKijitutouraiAnnaiFSksBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhKijitutouraiAnnaiFSksBean.class)
            .bind(qIT_KijituTouraiAnnai).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

}
