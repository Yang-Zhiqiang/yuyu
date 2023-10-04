package yuyu.batch.hozen.khinterf.khkzhuriannaifilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.QIT_KhKouzahuriAnnaiData;

/**
 * 契約保全 インターフェイス 口座振替案内Ｆ作成DAO
 */
public class KhKzhuriAnnaiFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhKzhuriAnnaiDataBean> getKzhuriAnnaiDataBeans(String pKakutyoujobcd,
        BizDate pSyoriYmd, String pKbnkey) {

        QIT_KhKouzahuriAnnaiData qIT_KhKouzahuriAnnaiData = new QIT_KhKouzahuriAnnaiData("qIT_KhKouzahuriAnnaiData");

        String strSql = $SELECT + $NEW(KhKzhuriAnnaiDataBean.class,
            qIT_KhKouzahuriAnnaiData.kbnkey,
            qIT_KhKouzahuriAnnaiData.ansyuusyskbn,
            qIT_KhKouzahuriAnnaiData.syoriYmd,
            qIT_KhKouzahuriAnnaiData.syono,
            qIT_KhKouzahuriAnnaiData.nyknaiyoukbn,
            qIT_KhKouzahuriAnnaiData.jyuutouym,
            qIT_KhKouzahuriAnnaiData.jyutoukaisuuy,
            qIT_KhKouzahuriAnnaiData.jyutoukaisuum,
            qIT_KhKouzahuriAnnaiData.rsgaku.getTypeFieldName(),
            qIT_KhKouzahuriAnnaiData.rsgaku.getValueFieldName(),
            qIT_KhKouzahuriAnnaiData.hurikaeymd,
            qIT_KhKouzahuriAnnaiData.syuudaikocd,
            qIT_KhKouzahuriAnnaiData.bankcd,
            qIT_KhKouzahuriAnnaiData.sitencd,
            qIT_KhKouzahuriAnnaiData.yokinkbn,
            qIT_KhKouzahuriAnnaiData.kouzano,
            qIT_KhKouzahuriAnnaiData.kzmeiginmkn,
            qIT_KhKouzahuriAnnaiData.sinkeizkkbn,
            qIT_KhKouzahuriAnnaiData.hrkkaisuu,
            qIT_KhKouzahuriAnnaiData.dantaikobetukbn,
            qIT_KhKouzahuriAnnaiData.kykymd) +
            $FROM(qIT_KhKouzahuriAnnaiData) +
            $WHERE + qIT_KhKouzahuriAnnaiData.syoriYmd.eq(pSyoriYmd) +
            $AND  + qIT_KhKouzahuriAnnaiData.kbnkey.in(pKbnkey);

        ExDBResults<KhKzhuriAnnaiDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, KhKzhuriAnnaiDataBean.class)
            .bind(qIT_KhKouzahuriAnnaiData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void addInsertEntity(EntityInserter<ZT_KzhuriAnnaiUlfTy> pInserter, ZT_KzhuriAnnaiUlfTy pKzhuriAnnaiUlfTy) {
        pInserter.add(pKzhuriAnnaiUlfTy);
    }
}
