package yuyu.common.direct.dscommon.dba4dstumitatekinitencheck;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ積立金移転共通チェックDAOクラス<br />
 */
public class DsTumitatekinItenCheckDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public long getKhHenkouUktkCountBySyonoUktksyorikbnUktkjyoutaikbn(String pSyono) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $COUNT + " (*) " +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.TMTTKNITEN) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk).getSingleResult();
    }

    public long getKhHenkouUktkYykCountBySyonoUktksyorikbnUktkjyoutaikbn(String pSyono) {

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("qMT_KhHenkouUktkYyk");

        String strSql = $SELECT + $COUNT + " (*) " +
            $FROM(qMT_KhHenkouUktkYyk) +
            $WHERE + qMT_KhHenkouUktkYyk.syono.eq(pSyono) +
            $AND + qMT_KhHenkouUktkYyk.uktksyorikbn.eq(C_UktkSyoriKbn.TMTTKNITEN) +
            $AND + qMT_KhHenkouUktkYyk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI);

        return exDBEntityManager.createJPQL(strSql).bind(qMT_KhHenkouUktkYyk).getSingleResult();
    }
}
