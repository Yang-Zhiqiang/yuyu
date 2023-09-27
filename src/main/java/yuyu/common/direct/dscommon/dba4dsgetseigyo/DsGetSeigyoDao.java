package yuyu.common.direct.dscommon.dba4dsgetseigyo;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ制御情報取得Daoクラス
 */
public class DsGetSeigyoDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public Long getKhHenkouUktkCountBySyonoUktksyorikbnUktkjyoutaikbn(String pSyoNo) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyoNo) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.TMTTKNITEN) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk).getSingleResult();
    }

    public Long getKhHenkouUktkYykCountBySyonoUktksyorikbnUktkjyoutaikbn(String pSyoNo) {

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("qMT_KhHenkouUktkYyk");

        String strSql = $SELECT + $COUNT + " (*) " +
            $FROM(qMT_KhHenkouUktkYyk) +
            $WHERE + qMT_KhHenkouUktkYyk.syono.eq(pSyoNo) +
            $AND + qMT_KhHenkouUktkYyk.uktksyorikbn.eq(C_UktkSyoriKbn.TMTTKNITEN) +
            $AND + qMT_KhHenkouUktkYyk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_KhHenkouUktkYyk).getSingleResult();
    }

}
