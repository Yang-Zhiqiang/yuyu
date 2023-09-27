package yuyu.common.direct.dscommon.dba4checkdsmkhgkhenkou;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktkMkhgkHnk;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ目標額変更共通チェックDAOクラス<br />
 */
public class CheckDsMkhgkHenkouDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public Long getKhHenkouUktkCountBySyono(String pSyono) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk();

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_KhHenkouUktk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.MKHGKHNK) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk).getSingleResult();
    }

    public List<KhHenkouUktkMkhgkHenkouInfoBean> getKhHenkouUktkMkhgkHenkouInfoBySyono(String pSyono) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk();

        QIT_KhHenkouUktkMkhgkHnk qIT_KhHenkouUktkMkhgkHnk = new QIT_KhHenkouUktkMkhgkHnk();

        String strSql = $SELECT + $NEW(KhHenkouUktkMkhgkHenkouInfoBean.class,
            qIT_KhHenkouUktkMkhgkHnk.targettkmokuhyouti) +
            $FROM(qIT_KhHenkouUktk, qIT_KhHenkouUktkMkhgkHnk) +
            $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
            $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.MKHGKHNK) +
            $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI) +
            $AND + qIT_KhHenkouUktk.syono.eq(qIT_KhHenkouUktkMkhgkHnk.syono) +
            $AND + qIT_KhHenkouUktk.hozenhenkouuktkrenno.eq(qIT_KhHenkouUktkMkhgkHnk.hozenhenkouuktkrenno) +
            $ORDER_BY(qIT_KhHenkouUktk.hozenhenkouuktkrenno.desc());

        return exDBEntityManager.createJPQL(strSql, KhHenkouUktkMkhgkHenkouInfoBean.class).bind(
            qIT_KhHenkouUktk, qIT_KhHenkouUktkMkhgkHnk).getResultList();
    }
}
