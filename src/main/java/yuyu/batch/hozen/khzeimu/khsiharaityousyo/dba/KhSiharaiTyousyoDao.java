package yuyu.batch.hozen.khzeimu.khsiharaityousyo.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_KykSyouhn;


/**
 * 契約保全 税務 契約保全支払調書作成機能DAOクラス
 */
public class KhSiharaiTyousyoDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmdBean> getKhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmd(
        String pKakutyoujobcd, BizDate pSyoriYmd) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");

        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String strSql =$SELECT + $NEW(KhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmdBean.class,
            qIT_KhShrRireki,
            qIT_KykKihon,
            qIT_KykSyouhn,
            qIT_KykSya,
            qIT_HhknSya,
            qIT_KhTtdkRireki) +

            $FROM(qIT_KhShrRireki,
                qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_KykSya,
                qIT_HhknSya,
                qIT_KhTtdkRireki) +
                $WHERE + qIT_KhShrRireki.shrtysysyuruikbn.ne(C_HtsiryosyuKbn.BLNK) +
                $AND + qIT_KhShrRireki.shrsyoriymd.eq(pSyoriYmd) +
                $AND + qIT_KhShrRireki.syono.eq(qIT_KhTtdkRireki.syono) +
                $AND + qIT_KhShrRireki.henkousikibetukey.eq(qIT_KhTtdkRireki.henkousikibetukey) +
                $AND + qIT_KhShrRireki.syono.eq(qIT_KykKihon.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_HhknSya.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $ORDER_BY(qIT_KhShrRireki.syono.asc());

        ExDBResults<KhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmdBean> exDBResults = exDBEntityManager
            .createJPQL(strSql, KhSiharaiTyousyoInfosByKakutyoujobcdSyoriYmdBean.class)
            .bind(qIT_KhShrRireki, qIT_KykKihon, qIT_KykSyouhn, qIT_KykSya, qIT_HhknSya, qIT_KhTtdkRireki).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}