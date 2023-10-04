package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.meta.QIT_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_UriageSkDataSyuKnr;

/**
 * 契約保全 案内収納 売上請求結果ＴＲ作成DAOクラス
 */
public class KhUriageSeikyuuKekkaTrSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<UriageSeikyuuKekkaDataBean> getKhUriageSeikyuuKekkaData1(String pKakutyoujobcd, String pKbnkey) {

        QIT_KhUriageSeikyuuKekkaData qIT_KhUriageSeikyuuKekkaData =
            new QIT_KhUriageSeikyuuKekkaData("qIT_KhUriageSeikyuuKekkaData");
        QIT_UriageSeikyuuData qIT_UriageSeikyuuData = new QIT_UriageSeikyuuData("qIT_UriageSeikyuuData");
        QIT_UriageSkDataSyuKnr qIT_UriageSkDataSyuKnr = new QIT_UriageSkDataSyuKnr("qIT_UriageSkDataSyuKnr");

        String strWhere = "";

        if (!BizUtil.isBlank(pKbnkey)) {
            strWhere = $WHERE + qIT_KhUriageSeikyuuKekkaData.kbnkey.eq(pKbnkey);
        }

        String subQuery1 = $SELECT + qIT_UriageSeikyuuData.renno3keta + $AS + "uriageseikyuudatarenno3keta" +
            $FROM(qIT_UriageSeikyuuData) +
            $WHERE + qIT_UriageSeikyuuData.syono.eq(qIT_KhUriageSeikyuuKekkaData.syono) +
            $AND + qIT_UriageSeikyuuData.creditkessaiyouno.eq(qIT_KhUriageSeikyuuKekkaData.creditkessaiyouno) +
            $AND + qIT_UriageSeikyuuData.uriagenengappi.eq(qIT_KhUriageSeikyuuKekkaData.uriagenengappi) +
            $AND + qIT_UriageSeikyuuData.recordno.eq(qIT_KhUriageSeikyuuKekkaData.recordno) +
            $AND + qIT_UriageSeikyuuData.credituriagegk.eq(qIT_KhUriageSeikyuuKekkaData.credituriagegk) +
            $AND + qIT_UriageSeikyuuData.authorikbn.eq(qIT_KhUriageSeikyuuKekkaData.authorikbn);

        String subQuery3 = $SELECT + qIT_UriageSeikyuuData.credituriageseikyuukbn+
            $FROM(qIT_UriageSeikyuuData) +
            $WHERE + qIT_UriageSeikyuuData.syono.eq(qIT_KhUriageSeikyuuKekkaData.syono) +
            $AND + qIT_UriageSeikyuuData.creditkessaiyouno.eq(qIT_KhUriageSeikyuuKekkaData.creditkessaiyouno) +
            $AND + qIT_UriageSeikyuuData.uriagenengappi.eq(qIT_KhUriageSeikyuuKekkaData.uriagenengappi) +
            $AND + qIT_UriageSeikyuuData.recordno.eq(qIT_KhUriageSeikyuuKekkaData.recordno) +
            $AND + qIT_UriageSeikyuuData.credituriagegk.eq(qIT_KhUriageSeikyuuKekkaData.credituriagegk) +
            $AND + qIT_UriageSeikyuuData.authorikbn.eq(qIT_KhUriageSeikyuuKekkaData.authorikbn);

        String subQuery2 = $SELECT + qIT_UriageSkDataSyuKnr.credituriagekekkahaneiymd +
            $FROM(qIT_UriageSkDataSyuKnr, qIT_UriageSeikyuuData) +
            $WHERE + qIT_UriageSeikyuuData.syono.eq(qIT_KhUriageSeikyuuKekkaData.syono) +
            $AND + qIT_UriageSeikyuuData.creditkessaiyouno.eq(qIT_KhUriageSeikyuuKekkaData.creditkessaiyouno) +
            $AND + qIT_UriageSeikyuuData.uriagenengappi.eq(qIT_KhUriageSeikyuuKekkaData.uriagenengappi) +
            $AND + qIT_UriageSeikyuuData.recordno.eq(qIT_KhUriageSeikyuuKekkaData.recordno) +
            $AND + qIT_UriageSeikyuuData.credituriagegk.eq(qIT_KhUriageSeikyuuKekkaData.credituriagegk) +
            $AND + qIT_UriageSeikyuuData.authorikbn.eq(qIT_KhUriageSeikyuuKekkaData.authorikbn) +
            $AND + qIT_UriageSeikyuuData.syono.eq(qIT_UriageSkDataSyuKnr.syono) +
            $AND + qIT_UriageSeikyuuData.creditkessaiyouno.eq(qIT_UriageSkDataSyuKnr.creditkessaiyouno) +
            $AND + qIT_UriageSeikyuuData.uriagenengappi.eq(qIT_UriageSkDataSyuKnr.uriagenengappi) +
            $AND + qIT_UriageSeikyuuData.renno3keta.eq(qIT_UriageSkDataSyuKnr.renno3keta);

        String strSql = $SELECT + $NEW(UriageSeikyuuKekkaDataBean.class,
            qIT_KhUriageSeikyuuKekkaData.creditkessaiyouno,
            qIT_KhUriageSeikyuuKekkaData.recordno,
            qIT_KhUriageSeikyuuKekkaData.syoriYmd,
            qIT_KhUriageSeikyuuKekkaData.syono,
            qIT_KhUriageSeikyuuKekkaData.uriagenengappi,
            qIT_KhUriageSeikyuuKekkaData.credituriagegk.getTypeFieldName(),
            qIT_KhUriageSeikyuuKekkaData.credituriagegk.getValueFieldName(),
            qIT_KhUriageSeikyuuKekkaData.credituriagengjiyuu,
            qIT_KhUriageSeikyuuKekkaData.jyuutouym,
            qIT_KhUriageSeikyuuKekkaData.authorikbn,
            qIT_KhUriageSeikyuuKekkaData.renno3keta + $AS + "uriageseikyuukekkadatarenno3keta",
            $(subQuery1),
            $(subQuery3),
            $(subQuery2)) +
            $FROM(qIT_KhUriageSeikyuuKekkaData)
            + strWhere +
            $ORDER_BY(qIT_KhUriageSeikyuuKekkaData.syono.asc(),
                qIT_KhUriageSeikyuuKekkaData.jyuutouym.asc());

        ExDBResults<UriageSeikyuuKekkaDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, UriageSeikyuuKekkaDataBean.class).bind(qIT_KhUriageSeikyuuKekkaData,
                qIT_UriageSeikyuuData, qIT_UriageSkDataSyuKnr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;

    }

    public ExDBResults<UriageSeikyuuKekkaData3Bean> getKhUriageSeikyuuKekkaData3(String pKakutyoujobcd,
        String pKbnkey) {

        QIT_KhUriageSeikyuuKekkaData qIT_KhUriageSeikyuuKekkaData =
            new QIT_KhUriageSeikyuuKekkaData("qIT_KhUriageSeikyuuKekkaData");
        QIT_UriageSeikyuuData qIT_UriageSeikyuuData = new QIT_UriageSeikyuuData("qIT_UriageSeikyuuData");
        QIT_AnsyuRireki qIT_AnsyuRireki = new QIT_AnsyuRireki("qIT_AnsyuRireki");

        String strWhere = $WHERE;

        if (!BizUtil.isBlank(pKbnkey)) {
            strWhere += qIT_KhUriageSeikyuuKekkaData.kbnkey.eq(pKbnkey) + $AND;
        }
        strWhere += qIT_UriageSeikyuuData.syono.eq(qIT_KhUriageSeikyuuKekkaData.syono) +
            $AND + qIT_UriageSeikyuuData.creditkessaiyouno.eq(qIT_KhUriageSeikyuuKekkaData.creditkessaiyouno) +
            $AND + qIT_UriageSeikyuuData.uriagenengappi.eq(qIT_KhUriageSeikyuuKekkaData.uriagenengappi) +
            $AND + qIT_UriageSeikyuuData.recordno.eq(qIT_KhUriageSeikyuuKekkaData.recordno) +
            $AND + qIT_UriageSeikyuuData.credituriagegk.eq(qIT_KhUriageSeikyuuKekkaData.credituriagegk) +
            $AND + qIT_UriageSeikyuuData.authorikbn.eq(qIT_KhUriageSeikyuuKekkaData.authorikbn);

        String subQuery1 = $SELECT + qIT_AnsyuRireki.nykkeiro +
            $FROM(qIT_AnsyuRireki) +
            $WHERE + qIT_AnsyuRireki.syono.eq(qIT_UriageSeikyuuData.syono) +
            $AND + qIT_AnsyuRireki.uriageymdkon.eq(qIT_UriageSeikyuuData.uriagenengappi) +
            $AND + qIT_AnsyuRireki.jyuutouym.eq(qIT_UriageSeikyuuData.jyuutouym) +
            $AND + qIT_AnsyuRireki.nyknaiyoukbn.eq(qIT_UriageSeikyuuData.nyknaiyoukbn);

        String strSql = $SELECT + $NEW(UriageSeikyuuKekkaData3Bean.class,
            qIT_KhUriageSeikyuuKekkaData.creditkessaiyouno,
            qIT_KhUriageSeikyuuKekkaData.syono,
            qIT_KhUriageSeikyuuKekkaData.uriagenengappi,
            qIT_KhUriageSeikyuuKekkaData.renno3keta,
            qIT_KhUriageSeikyuuKekkaData.credituriagegk.getTypeFieldName(),
            qIT_KhUriageSeikyuuKekkaData.credituriagegk.getValueFieldName(),
            qIT_KhUriageSeikyuuKekkaData.uriageseikyuuerrorcd,
            qIT_KhUriageSeikyuuKekkaData.credituriagengjiyuu,
            qIT_KhUriageSeikyuuKekkaData.jyuutouym,
            qIT_KhUriageSeikyuuKekkaData.authorikbn,
            qIT_UriageSeikyuuData.jyutoukaisuuy,
            qIT_UriageSeikyuuData.jyutoukaisuum,
            qIT_UriageSeikyuuData.nyknaiyoukbn,
            qIT_UriageSeikyuuData.hrkkaisuu,
            qIT_UriageSeikyuuData.tikiktbrisyuruikbn,
            qIT_UriageSeikyuuData.gyoumuKousinKinou,
            qIT_UriageSeikyuuData.credituriageseikyuukbn,
            $(subQuery1)) +
            $FROM(qIT_KhUriageSeikyuuKekkaData, qIT_UriageSeikyuuData) +
            strWhere;

        ExDBResults<UriageSeikyuuKekkaData3Bean> exDBResults = exDBEntityManager
            .createJPQL(strSql, UriageSeikyuuKekkaData3Bean.class).bind(qIT_KhUriageSeikyuuKekkaData,
                qIT_UriageSeikyuuData, qIT_AnsyuRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_KhUriageSeikyuuKekkaData getKhUriageSeikyuuKekkaData3(String pKbnkey, String pSyoNo, String pCreditkessaiyouNo,
        BizDate pUriageNengappi, Integer pRenno3keta) {

        QIT_KhUriageSeikyuuKekkaData qIT_KhUriageSeikyuuKekkaData =
            new QIT_KhUriageSeikyuuKekkaData("qIT_KhUriageSeikyuuKekkaData");

        String strWhere = $WHERE;

        if (!BizUtil.isBlank(pKbnkey)) {
            strWhere += qIT_KhUriageSeikyuuKekkaData.kbnkey.eq(pKbnkey) + $AND;
        }
        strWhere += qIT_KhUriageSeikyuuKekkaData.syono.eq(pSyoNo) +
            $AND + qIT_KhUriageSeikyuuKekkaData.creditkessaiyouno.eq(pCreditkessaiyouNo) +
            $AND + qIT_KhUriageSeikyuuKekkaData.uriagenengappi.eq(pUriageNengappi) +
            $AND + qIT_KhUriageSeikyuuKekkaData.renno3keta.eq(pRenno3keta);

        String strSql = $SELECT + qIT_KhUriageSeikyuuKekkaData +
            $FROM(qIT_KhUriageSeikyuuKekkaData) +
            strWhere;

        IT_KhUriageSeikyuuKekkaData khUriageSeikyuuKekkaData = exDBEntityManager
            .createJPQL(strSql).bind(qIT_KhUriageSeikyuuKekkaData).getSingleResult();

        return khUriageSeikyuuKekkaData;
    }

    public ExDBResults<UriageSeikyuuDataBean> getUriageSeikyuuData(String pKakutyoujobcd, String pKbnkey,
        BizDate pSyoriYmd) {

        QIT_UriageSeikyuuData qIT_UriageSeikyuuData = new QIT_UriageSeikyuuData("qIT_UriageSeikyuuData");
        QIT_UriageSkDataSyuKnr qIT_UriageSkDataSyuKnr = new QIT_UriageSkDataSyuKnr("qIT_UriageSkDataSyuKnr");

        String strWhere = $WHERE;

        if (!BizUtil.isBlank(pKbnkey)) {
            strWhere += qIT_UriageSeikyuuData.kbnkey.eq(pKbnkey) + $AND;
        }
        strWhere += $(qIT_UriageSeikyuuData.credituriageseikyuukbn.eq(C_CreditUriageSeikyuuKbn.TUUJYOU) + $AND +
            qIT_UriageSeikyuuData.uriagenengappi.le(pSyoriYmd) +
            $OR +
            qIT_UriageSeikyuuData.credituriageseikyuukbn.ne(C_CreditUriageSeikyuuKbn.TUUJYOU) + $AND +
            qIT_UriageSeikyuuData.uriagenengappi.le(pSyoriYmd.addBusinessDays(-1))) +$AND;

        String subQuery = $SELECT + qIT_UriageSkDataSyuKnr.kbnkey +
            $FROM(qIT_UriageSkDataSyuKnr) +
            $WHERE + qIT_UriageSeikyuuData.syono.eq(qIT_UriageSkDataSyuKnr.syono) +
            $AND + qIT_UriageSeikyuuData.creditkessaiyouno.eq(qIT_UriageSkDataSyuKnr.creditkessaiyouno) +
            $AND + qIT_UriageSeikyuuData.uriagenengappi.eq(qIT_UriageSkDataSyuKnr.uriagenengappi) +
            $AND + qIT_UriageSeikyuuData.renno3keta.eq(qIT_UriageSkDataSyuKnr.renno3keta) +
            $AND + $(qIT_UriageSkDataSyuKnr.credituriagekekkahaneiymd.isNotNull() +
                $OR + qIT_UriageSkDataSyuKnr.credituragskkkmhnkkchkzmflg.eq(true));

        String strSql = $SELECT + $NEW(UriageSeikyuuDataBean.class,
            qIT_UriageSeikyuuData.syono,
            qIT_UriageSeikyuuData.creditkessaiyouno,
            qIT_UriageSeikyuuData.uriagenengappi,
            qIT_UriageSeikyuuData.renno3keta,
            qIT_UriageSeikyuuData.recordno,
            qIT_UriageSeikyuuData.credituriagegk.getTypeFieldName(),
            qIT_UriageSeikyuuData.credituriagegk.getValueFieldName(),
            qIT_UriageSeikyuuData.jyuutouym) +
            $FROM(qIT_UriageSeikyuuData) +
            strWhere +
            $NOT_EXISTS + $(subQuery);

        ExDBResults<UriageSeikyuuDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, UriageSeikyuuDataBean.class).bind(qIT_UriageSeikyuuData,
                qIT_UriageSkDataSyuKnr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;

    }

}
