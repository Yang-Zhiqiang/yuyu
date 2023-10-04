package yuyu.batch.hozen.khansyuu.khuriageseikyuudel.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import yuyu.def.db.meta.QIT_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_UriageSkDataSyuKnr;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

/**
 * 契約保全 案内収納 売上請求データ削除の機能DAOクラスです。
 */
public class KhUriageSeikyuuDelDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<UriageSeikyuuDataBean> getUriageSeikyuuData(
        String pKakutyoujobcd, BizDate pCreditUriageKekkaHaneiYmd) {

        QIT_UriageSkDataSyuKnr qIT_UriageSkDataSyuKnr = new QIT_UriageSkDataSyuKnr("qIT_UriageSkDataSyuKnr");

        QIT_UriageSeikyuuData qIT_UriageSeikyuuData = new QIT_UriageSeikyuuData("qIT_UriageSeikyuuData");

        String subSql = $SELECT + qIT_UriageSeikyuuData.syono + $AS + "uriageseikyuudatasyono" +
            $FROM(qIT_UriageSeikyuuData) +
            $WHERE + qIT_UriageSkDataSyuKnr.kbnkey.eq(qIT_UriageSeikyuuData.kbnkey) +
            $AND + qIT_UriageSkDataSyuKnr.syono.eq(qIT_UriageSeikyuuData.syono) +
            $AND + qIT_UriageSkDataSyuKnr.creditkessaiyouno.eq(qIT_UriageSeikyuuData.creditkessaiyouno) +
            $AND + qIT_UriageSkDataSyuKnr.uriagenengappi.eq(qIT_UriageSeikyuuData.uriagenengappi) +
            $AND + qIT_UriageSkDataSyuKnr.renno3keta.eq(qIT_UriageSeikyuuData.renno3keta);

        String sql = $SELECT + $NEW(UriageSeikyuuDataBean.class,
            qIT_UriageSkDataSyuKnr.kbnkey,
            qIT_UriageSkDataSyuKnr.syono,
            qIT_UriageSkDataSyuKnr.creditkessaiyouno,
            qIT_UriageSkDataSyuKnr.uriagenengappi,
            qIT_UriageSkDataSyuKnr.renno3keta,
            qIT_UriageSkDataSyuKnr.credituriagekekkahaneiymd,
            $(subSql)) +
            $FROM (qIT_UriageSkDataSyuKnr) +
            $WHERE + qIT_UriageSkDataSyuKnr.credituriagekekkahaneiymd.lt(pCreditUriageKekkaHaneiYmd) +
            $ORDER_BY (qIT_UriageSkDataSyuKnr.syono.asc(),
                qIT_UriageSkDataSyuKnr.creditkessaiyouno.asc(),
                qIT_UriageSkDataSyuKnr.uriagenengappi.asc(),
                qIT_UriageSkDataSyuKnr.renno3keta.asc());

        ExDBResults<UriageSeikyuuDataBean> exDBResults = exDBEntityManager.createJPQL(
            sql, UriageSeikyuuDataBean.class).bind(qIT_UriageSkDataSyuKnr, qIT_UriageSeikyuuData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_UriageSkDataSyuKnr getUriageSkDataSyuKnr(
        String pSyono, String pCreditkessaiyouno, BizDate pUriagenengappi, Integer pRenno3keta) {

        QIT_UriageSkDataSyuKnr qIT_UriageSkDataSyuKnr = new QIT_UriageSkDataSyuKnr("qIT_UriageSkDataSyuKnr");

        String sql = $SELECT  + qIT_UriageSkDataSyuKnr +
            $FROM(qIT_UriageSkDataSyuKnr) +
            $WHERE + qIT_UriageSkDataSyuKnr.syono.eq(pSyono) +
            $AND + qIT_UriageSkDataSyuKnr.creditkessaiyouno.eq(pCreditkessaiyouno) +
            $AND + qIT_UriageSkDataSyuKnr.uriagenengappi.eq(pUriagenengappi) +
            $AND + qIT_UriageSkDataSyuKnr.renno3keta.eq(pRenno3keta);

        return  exDBEntityManager.createJPQL(sql).setFirstResult(0).setMaxResults(1).bind(qIT_UriageSkDataSyuKnr)
            .getSingleResult();
    }
}
