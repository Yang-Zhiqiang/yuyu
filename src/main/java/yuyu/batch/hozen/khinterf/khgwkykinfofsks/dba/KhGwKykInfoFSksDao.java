package yuyu.batch.hozen.khinterf.khgwkykinfofsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JV_SmbcSibouInfoRendou;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSonotaTkyk;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QJV_SmbcSibouInfoRendou;

/**
 * 契約保全 インターフェイス 共同ＧＷ用契約情報Ｆ作成DAOクラス
 */
public class KhGwKykInfoFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<GwKykInfosBean> getSmbcSibouInfoRendouInfosByKakutyoujobcdSyoriYmdSyutkkbn(
        String pKakutyoujobcd, BizDate pSyoriYmd, C_SeikyuuSyubetu pSeikyuusyubetu, C_SyutkKbn pSyutkkbn) {

        QJV_SmbcSibouInfoRendou qJV_SmbcSibouInfoRendou = new QJV_SmbcSibouInfoRendou("qJV_SmbcSibouInfoRendou");
        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykSonotaTkyk qIT_KykSonotaTkyk = new QIT_KykSonotaTkyk("qIT_KykSonotaTkyk");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");
        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");
        QIT_KhTtdkRireki qIT_KhTtdkRirekiSub  = new QIT_KhTtdkRireki("qSubIT_KhTtdkRirekiSub");

        String subSql = $SELECT + qIT_KhTtdkRirekiSub.syono +
            $FROM(qIT_KhTtdkRirekiSub) +
            $WHERE + qIT_KhTtdkRirekiSub.syono.eq(qIT_KhTtdkRireki.syono) +
            $AND + qIT_KhTtdkRirekiSub.syoriYmd.le(pSyoriYmd) +
            $GROUP_BY + qIT_KhTtdkRirekiSub.syono +
            $HAVING + $MAX(qIT_KhTtdkRirekiSub.henkousikibetukey) + $EQ + qIT_KhTtdkRireki.henkousikibetukey;

        String strSql = $SELECT + $NEW(GwKykInfosBean.class,
            qJV_SmbcSibouInfoRendou,
            qIT_KykDairiten,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSonotaTkyk,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_KhTtdkRireki) +
            $FROM(qJV_SmbcSibouInfoRendou,
                qIT_KykDairiten,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSonotaTkyk,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_KhTtdkRireki) +
                $WHERE + qJV_SmbcSibouInfoRendou.syoriYmd.eq(pSyoriYmd) +
                $AND + qJV_SmbcSibouInfoRendou.seikyuusyubetu .eq(pSeikyuusyubetu) +
                $AND + qIT_KykDairiten.syono.eq(qJV_SmbcSibouInfoRendou.syono) +
                $AND + qIT_KykDairiten.drtenrenno.eq(1) +
                $AND + qIT_KykKihon.syono.eq(qJV_SmbcSibouInfoRendou.syono) +
                $AND + qIT_KykSyouhn.syono.eq(qJV_SmbcSibouInfoRendou.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(pSyutkkbn) +
                $AND + qIT_KykSonotaTkyk.syono.eq(qJV_SmbcSibouInfoRendou.syono) +
                $AND + qIT_KykSya.syono.eq(qJV_SmbcSibouInfoRendou.syono) +
                $AND + qIT_HhknSya.syono.eq(qJV_SmbcSibouInfoRendou.syono) +
                $AND + qIT_KhTtdkRireki.syono.eq(qJV_SmbcSibouInfoRendou.syono) +
                $AND + qIT_KhTtdkRireki.syoriYmd.le(pSyoriYmd) +
                $AND + $EXISTS(subSql) +
                $ORDER_BY (qJV_SmbcSibouInfoRendou.syono.asc(),
                    qJV_SmbcSibouInfoRendou.skno.asc());

        ExDBResults<GwKykInfosBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            GwKykInfosBean.class).bind(qJV_SmbcSibouInfoRendou, qIT_KykDairiten, qIT_KykKihon,
                qIT_KykSyouhn, qIT_KykSonotaTkyk, qIT_KykSya, qIT_HhknSya, qIT_KhTtdkRireki,qIT_KhTtdkRirekiSub).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public JV_SmbcSibouInfoRendou getSmbcSibouInfoRendouBySyonoSyoriymd(String pSyono, BizDate pSyoriYmd) {

        QJV_SmbcSibouInfoRendou qJV_SmbcSibouInfoRendou = new QJV_SmbcSibouInfoRendou("qJV_SmbcSibouInfoRendou");

        String strSql = $SELECT + qJV_SmbcSibouInfoRendou +
            $FROM + qJV_SmbcSibouInfoRendou.JV_SmbcSibouInfoRendou()  +
            $WHERE + qJV_SmbcSibouInfoRendou.syono.eq(pSyono) +
            $AND + qJV_SmbcSibouInfoRendou.syoriYmd.le(pSyoriYmd) +
            $ORDER_BY(qJV_SmbcSibouInfoRendou.syono.asc(),
                qJV_SmbcSibouInfoRendou.syoriYmd.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qJV_SmbcSibouInfoRendou).getSingleResult();

    }

}
