package yuyu.batch.hozen.khinterf.khkzmeigisiteikensuudatasks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.meta.QIT_Kouza;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import jp.co.slcs.swak.db.ExDBEntityManager;

/**
 * 契約保全 インターフェイス 契約保全保険料払込口座名義指定件数データ作成Daoクラス<br />
 */
public class KhKzmeigiSiteiKensuuDataSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_KykKihon> getKhKzmeigiSiteiKensuuDataSksInfo() {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        QIT_Kouza qIT_Kouza = new QIT_Kouza("qIT_Kouza");

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");

        String sql = $SELECT + qIT_KykKihon +
            $FROM(qIT_KykKihon,
                qIT_Kouza,
                qIT_KykSyouhn) +
                $WHERE + qIT_KykKihon.syono.eq(qIT_Kouza.syono) +
                $AND + qIT_Kouza.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_Kouza.kzkykdoukbn.eq(C_KzkykdouKbn.SITEI) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + $(
                    qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.HRKMTYUU) +
                    $OR + qIT_KykSyouhn.kykjyoutai.eq(C_Kykjyoutai.IKKATUNK)
                    );

        return exDBEntityManager.createJPQL(sql).bind(qIT_KykKihon, qIT_Kouza, qIT_KykSyouhn).getResultList();

    }
}
