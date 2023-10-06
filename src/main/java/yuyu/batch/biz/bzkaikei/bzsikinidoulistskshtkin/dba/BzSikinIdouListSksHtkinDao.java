package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshtkin.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QBW_HtkinSikinIdouListSksWk;

/**
 * 業務共通 経理・会計 資金移動リスト作成(配当金)機能DAOクラス
 */
public class BzSikinIdouListSksHtkinDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HtkinSikinIdouListSksWkBean> getAllHtkinSikinIdouListSksWkBeans() {

        QBW_HtkinSikinIdouListSksWk qBW_HtkinSikinIdouListSksWk =
            new QBW_HtkinSikinIdouListSksWk("qBW_HtkinSikinIdouListSksWk");

        String querySql = $SELECT + $NEW(HtkinSikinIdouListSksWkBean.class,
            qBW_HtkinSikinIdouListSksWk.sikinidougroupkbn,
            qBW_HtkinSikinIdouListSksWk.siteituuka,
            qBW_HtkinSikinIdouListSksWk.siteituukagk.getTypeFieldName(),
            $SUM + $(qBW_HtkinSikinIdouListSksWk.siteituukagk.getValueFieldName()),
            qBW_HtkinSikinIdouListSksWk.trhktuuka,
            qBW_HtkinSikinIdouListSksWk.trhktuukagk.getTypeFieldName(),
            $SUM + $(qBW_HtkinSikinIdouListSksWk.trhktuukagk.getValueFieldName()),
            qBW_HtkinSikinIdouListSksWk.seg1cd) +
            $FROM + qBW_HtkinSikinIdouListSksWk.BW_HtkinSikinIdouListSksWk() +
            $GROUP_BY +qBW_HtkinSikinIdouListSksWk.sikinidougroupkbn + "," +
            qBW_HtkinSikinIdouListSksWk.siteituuka + "," +
            qBW_HtkinSikinIdouListSksWk.siteituukagk.getTypeFieldName() + "," +
            qBW_HtkinSikinIdouListSksWk.trhktuuka + "," +
            qBW_HtkinSikinIdouListSksWk.trhktuukagk.getTypeFieldName() + "," +
            qBW_HtkinSikinIdouListSksWk.seg1cd +
            $ORDER_BY(qBW_HtkinSikinIdouListSksWk.sikinidougroupkbn.asc(),
                qBW_HtkinSikinIdouListSksWk.siteituuka.asc(),
                qBW_HtkinSikinIdouListSksWk.trhktuuka.asc(),
                qBW_HtkinSikinIdouListSksWk.seg1cd.asc());

        return exDBEntityManager.createJPQL(querySql, HtkinSikinIdouListSksWkBean.class).bind(
            qBW_HtkinSikinIdouListSksWk).getResults();
    }

    public ExDBResults<HtkinSikinIdouListSksWkAllkmBean> getAllHtkinSikinIdouListSksWkAllkmBeans() {

        QBW_HtkinSikinIdouListSksWk qBW_HtkinSikinIdouListSksWk =
            new QBW_HtkinSikinIdouListSksWk("qBW_HtkinSikinIdouListSksWk");

        String querySql = $SELECT + $NEW(HtkinSikinIdouListSksWkAllkmBean.class,
            qBW_HtkinSikinIdouListSksWk.syono            ,
            qBW_HtkinSikinIdouListSksWk.kijyunymd,
            qBW_HtkinSikinIdouListSksWk.haitounendo,
            qBW_HtkinSikinIdouListSksWk.siteituuka,
            qBW_HtkinSikinIdouListSksWk.siteituukagk.getTypeFieldName(),
            qBW_HtkinSikinIdouListSksWk.siteituukagk.getValueFieldName(),
            qBW_HtkinSikinIdouListSksWk.trhktuuka,
            qBW_HtkinSikinIdouListSksWk.trhktuukagk.getTypeFieldName(),
            qBW_HtkinSikinIdouListSksWk.trhktuukagk.getValueFieldName(),
            qBW_HtkinSikinIdouListSksWk.seg1cd,
            qBW_HtkinSikinIdouListSksWk.sikinidougroupkbn,
            qBW_HtkinSikinIdouListSksWk.sikinidoukawaserate) +
            $FROM + qBW_HtkinSikinIdouListSksWk.BW_HtkinSikinIdouListSksWk() +
            $ORDER_BY(qBW_HtkinSikinIdouListSksWk.syono.asc());

        return exDBEntityManager.createJPQL(querySql, HtkinSikinIdouListSksWkAllkmBean.class).bind(
            qBW_HtkinSikinIdouListSksWk).getResults();
    }
}
