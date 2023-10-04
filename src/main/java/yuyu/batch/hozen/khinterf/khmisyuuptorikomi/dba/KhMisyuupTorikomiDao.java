package yuyu.batch.hozen.khinterf.khmisyuuptorikomi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QJT_MisyuupRendo;

/**
 * 契約保全 インターフェイス 未収Ｐ情報取込DAOクラス
 */
public class KhMisyuupTorikomiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<MisyuupRendoBean> getMisyuupRendoBean(String pKakutyoujobcd, BizDate pSyoriYmd) {

        QJT_MisyuupRendo qJT_MisyuupRendo = new QJT_MisyuupRendo("qJT_MisyuupRendo");

        String strSql = $SELECT + $NEW(MisyuupRendoBean.class,
            qJT_MisyuupRendo.syono,
            qJT_MisyuupRendo.datarenno,
            qJT_MisyuupRendo.nykkeiro,
            qJT_MisyuupRendo.hrkkaisuu,
            qJT_MisyuupRendo.nyknaiyoukbn,
            qJT_MisyuupRendo.iktnyuukinnumu,
            qJT_MisyuupRendo.misyuupjyuutouym,
            qJT_MisyuupRendo.misyuupjyuutoukaisuuy,
            qJT_MisyuupRendo.misyuupjyuutoukaisuum,
            qJT_MisyuupRendo.misyuup.getTypeFieldName(),
            qJT_MisyuupRendo.misyuup.getValueFieldName(),
            qJT_MisyuupRendo.ryosyuymd,
            qJT_MisyuupRendo.denymd,
            qJT_MisyuupRendo.tikiktbrisyuruikbn,
            qJT_MisyuupRendo.shrtuukasyu,
            qJT_MisyuupRendo.nyknkwsratekijyunymd) +
            $FROM(qJT_MisyuupRendo) +
            $WHERE + qJT_MisyuupRendo.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qJT_MisyuupRendo.syono.asc(),
                qJT_MisyuupRendo.datarenno.asc());

        ExDBResults<MisyuupRendoBean> exDBResults = exDBEntityManager.createJPQL(strSql, MisyuupRendoBean.class)
            .bind(qJT_MisyuupRendo).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}