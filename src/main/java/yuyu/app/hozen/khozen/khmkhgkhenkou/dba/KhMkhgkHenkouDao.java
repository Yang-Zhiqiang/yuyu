package yuyu.app.hozen.khozen.khmkhgkhenkou.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QIT_KhHenkouUktk;

/**
 * 契約保全 契約保全 目標額変更DAOクラス
 */
public class KhMkhgkHenkouDao {

    @Inject
    private ExDBEntityManager em;

    public Long getHenkouUktkDwMkhgkHenkouUketukeCountBySyonoKijyunymd(String pSyono, BizDate pKijyunYmd) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        String strSql = $SELECT + $COUNT(qIT_KhHenkouUktk.syono) +
            $FROM (qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.MKHGKHNK) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.in(C_UktkJyoutaiKbn.MISYORI, C_UktkJyoutaiKbn.SYORIZUMI, C_UktkJyoutaiKbn.ERROR) +
            $AND + qIT_KhHenkouUktk.uktkymd.ge(pKijyunYmd);

        return em.createJPQL(strSql).bind(qIT_KhHenkouUktk).getSingleResult();
    }

}
