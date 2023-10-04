package yuyu.batch.hozen.khinterf.khyuukouseikekkaftrkm.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_YuukouKakKekkaKikyk;
import yuyu.def.db.meta.QIT_YuukouKakKekkaSk;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFTr;

/**
 * 契約保全 インターフェイス 有効性確認結果Ｆ取込機能DAOクラス
 */
public class KhYuukouseiKekkaFTrkmDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<YuukouKakKekkaDataBean> getYuukouKakKekkaDataBeans(String pKakutyoujobcd) {

        QZT_YuukouKakKekkaFTr qZT_YuukouKakKekkaFTr = new QZT_YuukouKakKekkaFTr("qZT_YuukouKakKekkaFTr");

        String sql = $SELECT + $NEW(YuukouKakKekkaDataBean.class,
            qZT_YuukouKakKekkaFTr.ztrcreditkessaiyouno,
            qZT_YuukouKakKekkaFTr.ztrcardno,
            qZT_YuukouKakKekkaFTr.ztrcardyuukoukigen,
            qZT_YuukouKakKekkaFTr.ztryuukouhanteikekka,
            qZT_YuukouKakKekkaFTr.ztrcreditkigyoucd) +
            $FROM(qZT_YuukouKakKekkaFTr);

        ExDBResults<YuukouKakKekkaDataBean> exDBResults = exDBEntityManager.createJPQL(
            sql, YuukouKakKekkaDataBean.class).bind(qZT_YuukouKakKekkaFTr).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public void deleteYuukouKakKekkaShinkyk() {

        QIT_YuukouKakKekkaSk qIT_YuukouKakKekkaSk = new QIT_YuukouKakKekkaSk("qIT_YuukouKakKekkaSk");

        String sql = $DELETE_FROM(qIT_YuukouKakKekkaSk);

        exDBEntityManager.createJPQL(sql).bind(qIT_YuukouKakKekkaSk).executeUpdate();
    }

    public void deleteYuukouKakKekkaKikyk() {

        QIT_YuukouKakKekkaKikyk qIT_YuukouKakKekkaKikyk = new QIT_YuukouKakKekkaKikyk("qIT_YuukouKakKekkaKikyk");

        String sql = $DELETE_FROM(qIT_YuukouKakKekkaKikyk);

        exDBEntityManager.createJPQL(sql).bind(qIT_YuukouKakKekkaKikyk).executeUpdate();
    }
}
