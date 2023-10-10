package yuyu.app.hozen.khozen.khkeiyakusyoukai.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_KhHenkouUktkYendtHnk;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.db.meta.QIT_KhHenkouUktk;
import yuyu.def.db.meta.QIT_KhHenkouUktkYendtHnk;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_TtdkKan;
import yuyu.def.db.meta.QMT_DsKokyakuKeiyaku;
import yuyu.def.db.meta.QMT_DsMailAddress;

/**
 * 契約保全 契約保全 契約内容照会機能DAOクラス
 */
public class KhKeiyakuSyoukaiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_AnsyuRireki> getAnsyuRirekiBean3monthBySyono(String pSyono) {

        QIT_AnsyuRireki qIT_AnsyuRireki1 = new QIT_AnsyuRireki("qIT_AnsyuRireki1");

        QIT_AnsyuRireki qIT_AnsyuRireki2 = new QIT_AnsyuRireki("qIT_AnsyuRireki2");

        String subStrSql = $SELECT + qIT_AnsyuRireki1.annaisakuseiymd +
            $FROM(qIT_AnsyuRireki1) +
            $WHERE + qIT_AnsyuRireki1.syono.eq(pSyono) +
            $GROUP_BY + qIT_AnsyuRireki1.annaisakuseiymd +
            $ORDER_BY(qIT_AnsyuRireki1.annaisakuseiymd.desc());

        List<BizDate> bizDateLst = exDBEntityManager.createJPQL(subStrSql).bind(
            qIT_AnsyuRireki1).setFirstResult(0).setMaxResults(3).getResultList();

        String strSql = $SELECT + qIT_AnsyuRireki2 +
            $FROM(qIT_AnsyuRireki2) +
            $WHERE + qIT_AnsyuRireki2.syono.eq(pSyono);
        if (bizDateLst.size() > 0) {
            strSql = strSql + $AND + qIT_AnsyuRireki2.annaisakuseiymd.in(bizDateLst);
        }
        strSql = strSql +  $ORDER_BY(qIT_AnsyuRireki2.annaisakuseiymd.desc(),
            qIT_AnsyuRireki2.jyuutouym.desc(),
            qIT_AnsyuRireki2.annaino.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AnsyuRireki2).getResultList();
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknsBySyonoTmttknkouryokukaisiymd(String pSyono,
        BizDate pTmttknKouryokuKaisiymd) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM(qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.le(pTmttknKouryokuKaisiymd) +
            $ORDER_BY(qIT_KhSisuurendoTmttkn.tmttkntaisyouym.asc(), qIT_KhSisuurendoTmttkn.renno.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhSisuurendoTmttkn).getResultList();
    }

    public List<IT_TtdkKan> getTtdkKanBySyonoSyoruiCdTyouhyouymd(String pSyono, C_SyoruiCdKbn pSyoruiCdKbn,
        BizDate pTyouhyouymd) {

        QIT_TtdkKan qIT_TtdkKan = new QIT_TtdkKan("qIT_TtdkKan");

        String strSql = $SELECT + qIT_TtdkKan +
            $FROM(qIT_TtdkKan) +
            $WHERE + qIT_TtdkKan.syono.eq(pSyono) +
            $AND + qIT_TtdkKan.syoruiCd.eq(pSyoruiCdKbn) +
            $AND + qIT_TtdkKan.tyouhyouymd.eq(pTyouhyouymd) +
            $ORDER_BY(qIT_TtdkKan.henkousikibetukey.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_TtdkKan).getResultList();
    }

    public List<IT_KihrkmpSeisanRireki> getKihrkmpSeisanRirekiBySyonoHenkousikibetukeyKiharaiPseisanNaiyouKbn(
        String pSyono, String pHenkousikibetukey, C_KiharaiPseisanNaiyouKbn pKihrkpssnaiyoukbn) {

        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        String strSql = $SELECT + qIT_KihrkmpSeisanRireki +
            $FROM(qIT_KihrkmpSeisanRireki) +
            $WHERE + qIT_KihrkmpSeisanRireki.syono.eq(pSyono) +
            $AND + qIT_KihrkmpSeisanRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KihrkmpSeisanRireki.kihrkpssnaiyoukbn.eq(pKihrkpssnaiyoukbn) +
            $ORDER_BY(qIT_KihrkmpSeisanRireki.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KihrkmpSeisanRireki).getResultList();
    }

    public List<DsMailAddressInfosBySyonoBean> getDsMailAddressInfosBySyono(String pSyono) {

        QMT_DsKokyakuKeiyaku qMT_DsKokyakuKeiyaku = new QMT_DsKokyakuKeiyaku("qMT_DsKokyakuKeiyaku");
        QMT_DsMailAddress qMT_DsMailAddress = new QMT_DsMailAddress("qMT_DsMailAddress");

        String strSql = $SELECT + $NEW(DsMailAddressInfosBySyonoBean.class,
            qMT_DsMailAddress.dsmailsousinjyoutaikbn,
            qMT_DsMailAddress.dsmailsousintisrykbn) +
            $FROM(qMT_DsKokyakuKeiyaku,
                qMT_DsMailAddress) +
                $WHERE + qMT_DsKokyakuKeiyaku.syono.eq(pSyono) +
                $AND + qMT_DsKokyakuKeiyaku.dskokno.eq(qMT_DsMailAddress.dskokno) +
                $AND + qMT_DsKokyakuKeiyaku.dskykmukouhyj.eq(C_MukouHyj.BLANK);

        return exDBEntityManager.createJPQL(strSql, DsMailAddressInfosBySyonoBean.class).bind(
            qMT_DsKokyakuKeiyaku, qMT_DsMailAddress).getResultList();
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekiLst(String pSyono, C_SyoriKbn pSyoriKbn, BizDate pSyoriYmd) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String strSql = $SELECT + qIT_KhTtdkRireki +
            $FROM(qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syorikbn.eq(pSyoriKbn) +
            $AND + qIT_KhTtdkRireki.syoriYmd.ge(pSyoriYmd) +
            $ORDER_BY(qIT_KhTtdkRireki.gyoumuKousinTime.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki).getResultList();
    }

    public List<IT_KhHenkouUktkYendtHnk> getKhHenkouUktkYendtHnkLst(String pSyono, C_UktkSyoriKbn pUktkSyoriKbn, C_UktkJyoutaiKbn pUktkJyoutaiKbn) {

        QIT_KhHenkouUktk qIT_KhHenkouUktk = new QIT_KhHenkouUktk("qIT_KhHenkouUktk");
        QIT_KhHenkouUktkYendtHnk qIT_KhHenkouUktkYendtHnk = new QIT_KhHenkouUktkYendtHnk("qIT_KhHenkouUktkYendtHnk");

        String strSql = $SELECT + qIT_KhHenkouUktkYendtHnk +
            $FROM(qIT_KhHenkouUktk,
                qIT_KhHenkouUktkYendtHnk) +
                $WHERE + qIT_KhHenkouUktk.syono.eq(pSyono) +
                $AND + qIT_KhHenkouUktk.syono.eq(qIT_KhHenkouUktkYendtHnk.syono) +
                $AND + qIT_KhHenkouUktk.hozenhenkouuktkrenno.eq(qIT_KhHenkouUktkYendtHnk.hozenhenkouuktkrenno) +
                $AND + qIT_KhHenkouUktk.uktksyorikbn.eq(pUktkSyoriKbn) +
                $AND + qIT_KhHenkouUktk.uktkjyoutaikbn.eq(pUktkJyoutaiKbn) +
                $ORDER_BY(qIT_KhHenkouUktkYendtHnk.hozenhenkouuktkrenno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouUktk, qIT_KhHenkouUktkYendtHnk).getResultList();
    }

}
