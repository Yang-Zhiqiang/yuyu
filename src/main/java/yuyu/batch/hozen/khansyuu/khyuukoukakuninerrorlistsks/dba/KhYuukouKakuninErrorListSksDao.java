package yuyu.batch.hozen.khansyuu.khyuukoukakuninerrorlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_YuukouKakErrorList;

/**
 * 契約保全 案内収納 有効確認エラーリスト作成の機能DAOクラス
 */
public class KhYuukouKakuninErrorListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<YuukouKakErrorListBean> getYuukouKakErrorListBeans(String pKakutyoujobcd,
        BizDateYM pSyoriYM) {
        QIT_YuukouKakErrorList qIT_YuukouKakErrorList = new QIT_YuukouKakErrorList("qIT_YuukouKakErrorList");

        String sql = $SELECT + $NEW(YuukouKakErrorListBean.class,
            qIT_YuukouKakErrorList.syono,
            qIT_YuukouKakErrorList.creditkessaiyouno,
            qIT_YuukouKakErrorList.credityuukoukakym,
            qIT_YuukouKakErrorList.credityuukoukakkekka) +
            $FROM (qIT_YuukouKakErrorList) +
            $WHERE + (qIT_YuukouKakErrorList.syoriym.eq(pSyoriYM)) +
            $ORDER_BY (qIT_YuukouKakErrorList.credityuukoukakkekka.asc() ,
                qIT_YuukouKakErrorList.creditkessaiyouno.asc() ,
                qIT_YuukouKakErrorList.syono.asc());

        ExDBResults<YuukouKakErrorListBean> exDBResults = exDBEntityManager.createJPQL(sql,
            YuukouKakErrorListBean.class).bind(qIT_YuukouKakErrorList).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public Integer deleteYuukouKakErrorList(BizDateYM pSyoriYM) {
        QIT_YuukouKakErrorList qIT_YuukouKakErrorList = new QIT_YuukouKakErrorList("qIT_YuukouKakErrorList");

        String sql = $DELETE_FROM(qIT_YuukouKakErrorList) +
            $WHERE + qIT_YuukouKakErrorList.syoriym.lt(pSyoriYM);

        return exDBEntityManager.createJPQL(sql).bind(qIT_YuukouKakErrorList).executeUpdate();
    }
}
