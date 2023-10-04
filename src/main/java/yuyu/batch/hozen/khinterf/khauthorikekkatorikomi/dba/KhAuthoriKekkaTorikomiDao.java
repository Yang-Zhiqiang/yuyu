package yuyu.batch.hozen.khinterf.khauthorikekkatorikomi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.QZT_AuthoriKekkaTr;

/**
 * 契約保全 インターフェイス オーソリ結果Ｆ取込機能DAOクラス
 */
public class KhAuthoriKekkaTorikomiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<AuthoriKekkaDataBean> getAuthoriKekkaDataBeans(String pKakutyoujobcd) {

        QZT_AuthoriKekkaTr qZT_AuthoriKekkaTr = new QZT_AuthoriKekkaTr("qZT_AuthoriKekkaTr");

        String sql = $SELECT + $NEW(AuthoriKekkaDataBean.class,
            qZT_AuthoriKekkaTr.ztrkaiintourokukbn,
            qZT_AuthoriKekkaTr.ztrcreditkessaiyouno,
            qZT_AuthoriKekkaTr.ztrcardno,
            qZT_AuthoriKekkaTr.ztrcardyuukoukigen,
            qZT_AuthoriKekkaTr.ztrauthorigkjyusin,
            qZT_AuthoriKekkaTr.ztrauthorikekkaerrorcd,
            qZT_AuthoriKekkaTr.ztrbluegateerrorcd,
            qZT_AuthoriKekkaTr.ztrhisimukekaisyacd,
            qZT_AuthoriKekkaTr.ztrwentryuserid,
            qZT_AuthoriKekkaTr.ztrerrorcomment,
            qZT_AuthoriKekkaTr.ztrniniinfo,
            qZT_AuthoriKekkaTr.ztrdatasyorijyoukyou,
            qZT_AuthoriKekkaTr.ztrdatajyusinymd,
            qZT_AuthoriKekkaTr.ztrrenno7) +
            $FROM(qZT_AuthoriKekkaTr) +
            $ORDER_BY(
                qZT_AuthoriKekkaTr.ztrcreditkessaiyouno.asc(),
                qZT_AuthoriKekkaTr.ztrdatajyusinymd.desc(),
                qZT_AuthoriKekkaTr.ztrrenno7.asc()
                );

        ExDBResults<AuthoriKekkaDataBean> exDBResults = exDBEntityManager.createJPQL(
            sql, AuthoriKekkaDataBean.class).bind(qZT_AuthoriKekkaTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public int deleteBunrimaeAuthoriKekka() {

        QIT_BunrimaeAuthoriKekka qIT_BunrimaeAuthoriKekka = new QIT_BunrimaeAuthoriKekka("qIT_BunrimaeAuthoriKekka");

        String sql = $DELETE_FROM(qIT_BunrimaeAuthoriKekka);

        return exDBEntityManager.createJPQL(sql).bind(qIT_BunrimaeAuthoriKekka).executeUpdate();
    }

}
