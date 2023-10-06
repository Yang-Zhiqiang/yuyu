package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyouzndksykilstsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;


import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QBT_KbtKarikanjyou;

/**
 * 業務共通 経理･会計 個別仮勘残高集計リスト作成機能DAOクラス。<br />
 */
public class BzKbtKarikanjyouZndksykilstSksDao {

    @Inject
    private ExDBEntityManager em;

    public ExDBResults<KbtKarikanjyouDataBean> getKbtKarikanjyouZndksyukilistByDenymd(BizDate pDenymdTo) {

        QBT_KbtKarikanjyou qBT_KbtKarikanjyou = new QBT_KbtKarikanjyou("qBT_KbtKarikanjyou");

        String sql = $SELECT + $NEW(KbtKarikanjyouDataBean.class,
            qBT_KbtKarikanjyou.huridenatesakicd,
            qBT_KbtKarikanjyou.kanjyoukmkcd,
            qBT_KbtKarikanjyou.denymd,
            qBT_KbtKarikanjyou.taisyakukbn,
            qBT_KbtKarikanjyou.denyenkagk.getTypeFieldName(),
            $SUM + $(qBT_KbtKarikanjyou.denyenkagk.getValueFieldName()) + $AS + "denyenkagk",
            $COUNT + "(*)"  + $AS + "kensuu") +
            $FROM(qBT_KbtKarikanjyou) +
            $WHERE + qBT_KbtKarikanjyou.denymd.le(pDenymdTo) +
            $AND + qBT_KbtKarikanjyou.kskmkanryouymd.isNull() +
            $GROUP_BY + qBT_KbtKarikanjyou.huridenatesakicd + "," +
            qBT_KbtKarikanjyou.kanjyoukmkcd + "," +
            qBT_KbtKarikanjyou.denymd + "," +
            qBT_KbtKarikanjyou.taisyakukbn + "," +
            qBT_KbtKarikanjyou.denyenkagk.getTypeFieldName() +
            $ORDER_BY(
                qBT_KbtKarikanjyou.huridenatesakicd.asc(),
                qBT_KbtKarikanjyou.kanjyoukmkcd.asc(),
                qBT_KbtKarikanjyou.denymd.asc(),
                qBT_KbtKarikanjyou.taisyakukbn.asc()
                );

        return em.createJPQL(sql, KbtKarikanjyouDataBean.class).bind(qBT_KbtKarikanjyou).getResults();
    }

    public ExDBResults<KbtKarikanjyouDataBean> getKbtKarikanjyouZndksyukilistGekkangkByDenymd(BizDate pDenymdTo) {

        QBT_KbtKarikanjyou qBT_KbtKarikanjyou = new QBT_KbtKarikanjyou("qBT_KbtKarikanjyou");

        String sql = $SELECT + $NEW(KbtKarikanjyouDataBean.class,
            qBT_KbtKarikanjyou.huridenatesakicd,
            qBT_KbtKarikanjyou.kanjyoukmkcd,
            qBT_KbtKarikanjyou.taisyakukbn,
            qBT_KbtKarikanjyou.denyenkagk.getTypeFieldName(),
            $SUM + $(qBT_KbtKarikanjyou.denyenkagk.getValueFieldName()) + $AS + "denyenkagk",
            $COUNT + "(*)"  + $AS + "kensuu") +
            $FROM(qBT_KbtKarikanjyou) +
            $WHERE + qBT_KbtKarikanjyou.denymd.le(pDenymdTo) +
            $AND + qBT_KbtKarikanjyou.kskmkanryouymd.isNull() +
            $GROUP_BY + qBT_KbtKarikanjyou.huridenatesakicd + "," +
            qBT_KbtKarikanjyou.kanjyoukmkcd + "," +
            qBT_KbtKarikanjyou.taisyakukbn + "," +
            qBT_KbtKarikanjyou.denyenkagk.getTypeFieldName();

        return em.createJPQL(sql, KbtKarikanjyouDataBean.class).bind(qBT_KbtKarikanjyou).getResults();
    }

    public ExDBResults<KbtKarikanjyouDataBean> getKbtKarikanjyouZndksyukilistKmkbetugkByDenymd(BizDate pDenymdTo) {

        QBT_KbtKarikanjyou qBT_KbtKarikanjyou = new QBT_KbtKarikanjyou("qBT_KbtKarikanjyou");

        String sql = $SELECT + $NEW(KbtKarikanjyouDataBean.class,
            qBT_KbtKarikanjyou.kanjyoukmkcd,
            qBT_KbtKarikanjyou.taisyakukbn,
            qBT_KbtKarikanjyou.denyenkagk.getTypeFieldName(),
            $SUM + $(qBT_KbtKarikanjyou.denyenkagk.getValueFieldName()) + $AS + "denyenkagk",
            $COUNT + "(*)"  + $AS + "kensuu") +
            $FROM(qBT_KbtKarikanjyou) +
            $WHERE + qBT_KbtKarikanjyou.denymd.le(pDenymdTo) +
            $AND + qBT_KbtKarikanjyou.kskmkanryouymd.isNull() +
            $GROUP_BY + qBT_KbtKarikanjyou.kanjyoukmkcd + "," +
            qBT_KbtKarikanjyou.taisyakukbn + "," +
            qBT_KbtKarikanjyou.denyenkagk.getTypeFieldName();

        return em.createJPQL(sql, KbtKarikanjyouDataBean.class).bind(qBT_KbtKarikanjyou).getResults();
    }
}
