package yuyu.batch.hozen.khansyuu.khminusuriagekykdtllistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_MinusUriageKykDtlList;

/**
 * 契約保全 案内収納 マイナス売上契約明細リスト作成DAOクラス
 */
public class KhMinusUriageKykDtlListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<MinusUriageKykDtlListSksTaisyouBean> getMinusUriageKykDtlListSksTaisyouBeans(
        String pKakutyoujobcd, BizDate pTaisyoukknfrom, BizDate pTaisyoukknto) {

        QIT_MinusUriageKykDtlList qIT_MinusUriageKykDtlList = new QIT_MinusUriageKykDtlList(
            "qIT_MinusUriageKykDtlList");

        String strSql = $SELECT + $NEW(MinusUriageKykDtlListSksTaisyouBean.class,
            qIT_MinusUriageKykDtlList.syono,
            qIT_MinusUriageKykDtlList.creditkessaiyouno,
            qIT_MinusUriageKykDtlList.uriagenengappi,
            qIT_MinusUriageKykDtlList.renno3keta,
            qIT_MinusUriageKykDtlList.jyuutouym,
            qIT_MinusUriageKykDtlList.syoriYmd,
            qIT_MinusUriageKykDtlList.credituriagegk.getTypeFieldName(),
            qIT_MinusUriageKykDtlList.credituriagegk.getValueFieldName(),
            qIT_MinusUriageKykDtlList.kinouId) +
            $FROM(qIT_MinusUriageKykDtlList) +
            $WHERE + qIT_MinusUriageKykDtlList.uriagenengappi.ge(pTaisyoukknfrom) +
            $AND + qIT_MinusUriageKykDtlList.uriagenengappi.le(pTaisyoukknto) +
            $ORDER_BY  (qIT_MinusUriageKykDtlList.uriagenengappi.asc(),
                qIT_MinusUriageKykDtlList.creditkessaiyouno.asc(),
                qIT_MinusUriageKykDtlList.kinouId.asc(),
                qIT_MinusUriageKykDtlList.jyuutouym.asc());

        ExDBResults<MinusUriageKykDtlListSksTaisyouBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, MinusUriageKykDtlListSksTaisyouBean.class).bind(qIT_MinusUriageKykDtlList).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public Integer deleteMinusUriageKykDtlList(BizDate pUriagenengappi) {

        QIT_MinusUriageKykDtlList qIT_MinusUriageKykDtlList = new QIT_MinusUriageKykDtlList(
            "qIT_MinusUriageKykDtlList");

        String strSql =  $DELETE_FROM(qIT_MinusUriageKykDtlList) +
            $WHERE + qIT_MinusUriageKykDtlList.uriagenengappi.lt(pUriagenengappi) ;

        return exDBEntityManager.createJPQL(strSql).bind(qIT_MinusUriageKykDtlList).executeUpdate();
    }
}
