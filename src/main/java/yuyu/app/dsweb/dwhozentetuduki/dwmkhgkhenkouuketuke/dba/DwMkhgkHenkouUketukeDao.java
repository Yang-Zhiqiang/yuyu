package yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.meta.QBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktkMkhgkHnk;

/**
 * ＤＳ目標額変更受付DAOクラスです。
 */
public class DwMkhgkHenkouUketukeDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<KhHenkouUktkMkhgkHenkouInfoBean> getKhHenkouUktkMkhgkHenkouInfoBySyono(String pSyono) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");

        QIT_KhHenkouUktkMkhgkHnk qIT_KhHenkouUktkMkhgkHnk = new QIT_KhHenkouUktkMkhgkHnk("qIT_KhHenkouUktkMkhgkHnk");

        String mainQuery = $SELECT + $NEW(KhHenkouUktkMkhgkHenkouInfoBean.class,
            qIT_KhHenkouUktk.syono,
            qIT_KhHenkouUktk.hozenhenkouuktkrenno,
            qIT_KhHenkouUktkMkhgkHnk.targettkmokuhyouti) +
            $FROM (qIT_KhHenkouUktk,
                qIT_KhHenkouUktkMkhgkHnk) +
                $WHERE  + $(qIT_KhHenkouUktk.syono.eq(pSyono) +
                    $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(C_UktkSyoriKbn.MKHGKHNK) +
                    $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(C_UktkJyoutaiKbn.MISYORI) +
                    $AND + qIT_KhHenkouUktk.syono.eq(qIT_KhHenkouUktkMkhgkHnk.syono) +
                    $AND  + qIT_KhHenkouUktk.hozenhenkouuktkrenno.eq(qIT_KhHenkouUktkMkhgkHnk.hozenhenkouuktkrenno)) +
                    $ORDER_BY(qIT_KhHenkouUktk.hozenhenkouuktkrenno.desc());

        return  exDBEntityManager.createJPQL(mainQuery, KhHenkouUktkMkhgkHenkouInfoBean.class).bind(
            qIT_KhHenkouUktk, qIT_KhHenkouUktkMkhgkHnk).getResultList();
    }

    public List<Integer> getChkTargetTkMokuhyoutisBySyouhncdSyusyouhnsdnoChannelcd(
        String pSyouhncd, Integer pSyusyouhnsdno, C_Channelcd pChannelcd) {

        QBM_ChkTargetTkMokuhyouti qBM_ChkTargetTkMokuhyouti = new QBM_ChkTargetTkMokuhyouti("qBM_ChkTargetTkMokuhyouti");

        String strSql = $SELECT + qBM_ChkTargetTkMokuhyouti.targettkmokuhyouti +
            $FROM(qBM_ChkTargetTkMokuhyouti) +
            $WHERE + qBM_ChkTargetTkMokuhyouti.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkTargetTkMokuhyouti.syusyouhnsdnofrom.le(pSyusyouhnsdno) +
            $AND + qBM_ChkTargetTkMokuhyouti.syusyouhnsdnoto.ge(pSyusyouhnsdno) +
            $AND + qBM_ChkTargetTkMokuhyouti.channelcd.eq(pChannelcd) +
            $AND + qBM_ChkTargetTkMokuhyouti.targettkmokuhyouti.ne(999);

        return exDBEntityManager.createJPQL(strSql).bind(qBM_ChkTargetTkMokuhyouti).getResultList();
    }
}
