package yuyu.common.direct.dscommon.dba4checkdskaiyaku;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ解約共通チェックDAOクラス<br />
 */
public class CheckDsKaiyakuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getKhHenkouUktkCountBySyono(String pSyono){

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("QIT_KhHenkouUktk");

        String strSql = $SELECT + $COUNT(qIT_KhHenkouUktk.syono) +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.KAIYAKU) +
            $AND + (qIT_KhHenkouUktk.uktkjyoutaikbn.
                in(C_UktkJyoutaiKbn.MISYORI, C_UktkJyoutaiKbn.ERROR));

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk).getSingleResult();
    }

    public Long getKhHenkouUktkYykCountBySyono(String pSyono){

        QMT_KhHenkouUktkYyk qMT_KhHenkouUktkYyk = new QMT_KhHenkouUktkYyk("QMT_KhHenkouUktkYyk");

        String strSql = $SELECT + $COUNT(qMT_KhHenkouUktkYyk.syono) +
            $FROM(qMT_KhHenkouUktkYyk) +
            $WHERE + qMT_KhHenkouUktkYyk.syono.eq(pSyono) +
            $AND + qMT_KhHenkouUktkYyk.uktksyorikbn.eq(C_UktkSyoriKbn.KAIYAKU) +
            $AND + (qMT_KhHenkouUktkYyk.uktkjyoutaikbn.
                in(C_UktkJyoutaiKbn.MISYORI, C_UktkJyoutaiKbn.ERROR));

        return exDBEntityManager.createJPQL(strSql).bind(qMT_KhHenkouUktkYyk).getSingleResult();
    }
}
