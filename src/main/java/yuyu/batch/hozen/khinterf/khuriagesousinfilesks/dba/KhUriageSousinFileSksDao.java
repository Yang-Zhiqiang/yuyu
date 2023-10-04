package yuyu.batch.hozen.khinterf.khuriagesousinfilesks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_UriageSeikyuuData;

/**
 * 契約保全 インターフェイス 売上送信Ｆ作成Daoクラス
 */
public class KhUriageSousinFileSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhUriageSeikyuuDataBean> getUriageSeikyuuDataBeans(String pKakutyouJobcd,BizDate pSyoriYmd,
        String pKbnkey) {

        QIT_UriageSeikyuuData qIT_UriageSeikyuuData = new QIT_UriageSeikyuuData("qIT_UriageSeikyuuData");

        String strWhere = $WHERE;
        if (!BizUtil.isBlank(pKbnkey)) {
            strWhere += qIT_UriageSeikyuuData.kbnkey.eq(pKbnkey) + $AND ;
        }
        strWhere += qIT_UriageSeikyuuData.syoriYmd.eq(pSyoriYmd);

        String strSql = $SELECT + $NEW(KhUriageSeikyuuDataBean.class,
            qIT_UriageSeikyuuData.kbnkey,
            qIT_UriageSeikyuuData.syono,
            qIT_UriageSeikyuuData.creditkessaiyouno,
            qIT_UriageSeikyuuData.uriagenengappi,
            qIT_UriageSeikyuuData.recordno,
            qIT_UriageSeikyuuData.syoriYmd,
            qIT_UriageSeikyuuData.credituriageseikyuukbn,
            qIT_UriageSeikyuuData.authorikbn,
            qIT_UriageSeikyuuData.credituriagegk.getTypeFieldName(),
            qIT_UriageSeikyuuData.credituriagegk.getValueFieldName(),
            qIT_UriageSeikyuuData.fukusuukameitennokey,
            qIT_UriageSeikyuuData.jyuutouym
            ) +
            $FROM(qIT_UriageSeikyuuData) +
            strWhere;

        ExDBResults<KhUriageSeikyuuDataBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, KhUriageSeikyuuDataBean.class).bind(qIT_UriageSeikyuuData).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyouJobcd));

        return exDBResults;
    }
}
