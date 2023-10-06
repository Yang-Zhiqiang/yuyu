package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshtkin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QBW_HtkinSikinIdouListSksWk;
import yuyu.def.db.meta.QBW_HtkinSikinIdouWk;

/**
 * 業務共通 経理・会計 資金移動リストデータ作成(配当金)機能DAOクラス
 */
public class BzSikinIdouListDataSksHtkinDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public void delAllHtkinSikinIdouListSksWk() {

        QBW_HtkinSikinIdouListSksWk qBW_HtkinSikinIdouListSksWk = new QBW_HtkinSikinIdouListSksWk("qBW_HtkinSikinIdouListSksWk");

        String strSql = $DELETE_FROM(qBW_HtkinSikinIdouListSksWk);

        exDBEntityManager.createJPQL(strSql).bind(qBW_HtkinSikinIdouListSksWk).executeUpdate();
    }

    public ExDBResults<HtkinSikinIdouWkBean> getAllHtkinSikinIdouWkBeans(String pKakutyoujobcd) {

        QBW_HtkinSikinIdouWk qBW_HtkinSikinIdouWk = new QBW_HtkinSikinIdouWk("qBW_HtkinSikinIdouWk");

        String strSql = $SELECT + $NEW(HtkinSikinIdouWkBean.class,
            qBW_HtkinSikinIdouWk.syono,
            qBW_HtkinSikinIdouWk.kijyunymd,
            qBW_HtkinSikinIdouWk.haitounendo,
            qBW_HtkinSikinIdouWk.kyktuukasyu,
            qBW_HtkinSikinIdouWk.seisikiwariategaku.getTypeFieldName(),
            qBW_HtkinSikinIdouWk.seisikiwariategaku.getValueFieldName(),
            qBW_HtkinSikinIdouWk.seg1cd,
            qBW_HtkinSikinIdouWk.sikinidoukawaserate) +
            $FROM(qBW_HtkinSikinIdouWk) +
            $ORDER_BY(qBW_HtkinSikinIdouWk.syono.asc());

        ExDBResults<HtkinSikinIdouWkBean> exDBResults = exDBEntityManager.createJPQL(strSql, HtkinSikinIdouWkBean.class)
            .bind(qBW_HtkinSikinIdouWk).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
