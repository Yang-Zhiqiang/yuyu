package yuyu.batch.hozen.khinterf.khsoukikaiyakukensuudatasks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;

/**
 * 契約保全 インターフェイス 契約保全早期解約件数データ作成DAOクラス
 */
public class KhSoukiKaiyakuKensuuDataSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<KhSoukiKaiyakuKensuuDataBean> getKhSoukiKaiyakuKensuuDataBean(BizDate pTaisyouKknFrom,
        BizDate pTaisyouKknTo) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String sql = $SELECT + $NEW(KhSoukiKaiyakuKensuuDataBean.class,
            qIT_KykKihon,
            qIT_KykSyouhn) +
            $FROM(qIT_KykKihon,
                qIT_KykSyouhn) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.syoumetujiyuu.eq(C_Syoumetujiyuu.KAIYAKU) +
                $AND + qIT_KykSyouhn.syoumetuymd.ge(pTaisyouKknFrom) +
                $AND + qIT_KykSyouhn.syoumetuymd.le(pTaisyouKknTo);

        ExDBResults<KhSoukiKaiyakuKensuuDataBean> exDBResults = exDBEntityManager.createJPQL(sql,
            KhSoukiKaiyakuKensuuDataBean.class).bind(qIT_KykKihon, qIT_KykSyouhn).getResults();

        return exDBResults;
    }
}


