package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkaerrorlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_UriageSeikyuuKkErrorList;

/**
 * 契約保全 案内収納 売上請求結果エラーリスト作成DAOクラス
 */
public class KhUriageSeikyuuKekkaErrorListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<UriageSeikyuuKekkaErrorListSksTaisyouBean> getUriageSeikyuuKekkaErrorListSksTaisyouBeans(
        String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_UriageSeikyuuKkErrorList qIT_UriageSeikyuuKkErrorList = new QIT_UriageSeikyuuKkErrorList(
            "qIT_UriageSeikyuuKkErrorList");

        String strSql = $SELECT + $NEW(UriageSeikyuuKekkaErrorListSksTaisyouBean.class,
            qIT_UriageSeikyuuKkErrorList.syono,
            qIT_UriageSeikyuuKkErrorList.creditkessaiyouno,
            qIT_UriageSeikyuuKkErrorList.uriagenengappi,
            qIT_UriageSeikyuuKkErrorList.renno3keta,
            qIT_UriageSeikyuuKkErrorList.jyuutouym,
            qIT_UriageSeikyuuKkErrorList.syoriYmd,
            qIT_UriageSeikyuuKkErrorList.credituriagegk.getTypeFieldName(),
            qIT_UriageSeikyuuKkErrorList.credituriagegk.getValueFieldName(),
            qIT_UriageSeikyuuKkErrorList.uriageseikyuuerrorcd,
            qIT_UriageSeikyuuKkErrorList.credituriagengjiyuu,
            qIT_UriageSeikyuuKkErrorList.authorikbn,
            qIT_UriageSeikyuuKkErrorList.kinouId,
            qIT_UriageSeikyuuKkErrorList.credituriageseikyuukbn) +
            $FROM(qIT_UriageSeikyuuKkErrorList) +
            $WHERE + qIT_UriageSeikyuuKkErrorList.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY  (qIT_UriageSeikyuuKkErrorList.credituriagengjiyuu.asc(),
                qIT_UriageSeikyuuKkErrorList.creditkessaiyouno.asc(),
                qIT_UriageSeikyuuKkErrorList.syono.asc(),
                qIT_UriageSeikyuuKkErrorList.uriagenengappi.asc());


        ExDBResults<UriageSeikyuuKekkaErrorListSksTaisyouBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, UriageSeikyuuKekkaErrorListSksTaisyouBean.class).bind(qIT_UriageSeikyuuKkErrorList).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void deleteUriageSeikyuuKekkaErrorList(BizDate pSyoriYmd) {

        QIT_UriageSeikyuuKkErrorList qIT_UriageSeikyuuKkErrorList = new QIT_UriageSeikyuuKkErrorList(
            "qIT_UriageSeikyuuKkErrorList");

        String strSql =  $DELETE_FROM(qIT_UriageSeikyuuKkErrorList) +
            $WHERE + qIT_UriageSeikyuuKkErrorList.syoriYmd.lt(pSyoriYmd) ;

        exDBEntityManager.createJPQL(strSql).bind(qIT_UriageSeikyuuKkErrorList).executeUpdate();
    }
}
