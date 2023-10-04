package yuyu.batch.hozen.khozen.khmeigihenkoukouteijidouseni.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.def.db.meta.QIW_KhMeigiHenkouWk;

/**
 * 契約保全 契約保全 名義変更工程自動遷移
 */
public class KhMeigihenkouKouteiJidouSeniDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<IW_KhMeigiHenkouWk> getKhMeigiHenkouWkByKakutyoujobcdMeigihnkjiyuu(String pKakutyoujobcd,
        C_Meigihnkjiyuu pMeigihnkjiyuu) {

        QIW_KhMeigiHenkouWk qIW_KhMeigiHenkouWk = new QIW_KhMeigiHenkouWk("q");

        String strSql = $SELECT + qIW_KhMeigiHenkouWk +
            $FROM(qIW_KhMeigiHenkouWk) +
            $WHERE + qIW_KhMeigiHenkouWk.meigihnkjiyuu.eq(pMeigihnkjiyuu);

        ExDBResults<IW_KhMeigiHenkouWk> exDBResults = exDBEntityManager.createJPQL(strSql).bind(qIW_KhMeigiHenkouWk)
            .getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
