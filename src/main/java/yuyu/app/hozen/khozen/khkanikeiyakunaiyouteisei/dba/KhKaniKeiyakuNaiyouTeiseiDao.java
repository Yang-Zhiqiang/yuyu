package yuyu.app.hozen.khozen.khkanikeiyakunaiyouteisei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.meta.QBT_YendthnkSikinIdouData;
import yuyu.def.db.meta.QIT_KhDenpyoData;
import yuyu.def.db.meta.QIT_KhHenreikin;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;

/**
 * 契約保全 契約保全 契約保全簡易契約内容訂正DAOクラス
 */
public class KhKaniKeiyakuNaiyouTeiseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<IT_KhHenreikin> getKhHenreikinYendMbrSiharaizumiBySyono(String pSyono,BizDate pHrhsiymd) {

        QIT_KhHenreikin qIT_KhHenreikin = new QIT_KhHenreikin("qIT_KhHenreikin");

        String strSql = $SELECT + qIT_KhHenreikin +
            $FROM(qIT_KhHenreikin) +
            $WHERE + qIT_KhHenreikin.syono.eq(pSyono) +
            $AND + qIT_KhHenreikin.hrsyuruikbn.eq(C_HrsyuruiKbn.YENDTHNKHENREI) +
            $AND + qIT_KhHenreikin.hrhsiymd.eq(pHrhsiymd) +
            $AND + $(qIT_KhHenreikin.hrsiharaijyoutaikbn.eq(C_Siharaijyoutaikbn.MBR) +
                $OR + qIT_KhHenreikin.hrsiharaijyoutaikbn.eq(C_Siharaijyoutaikbn.SIHARAIZUMI)) +
                $ORDER_BY(qIT_KhHenreikin.hrhsisyoriymd.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenreikin).getResultList();
    }

    public BizCurrency getKhDenpyoDataDenyenkagkBySyonoHuridenatesakicdTantocdSyoricdSeg1cdSeg1cd(String pSyono,
        String pHuridenatesakicd, C_TantouCdKbn pTantouCdKbn, String pSyoricd, C_Segcd pSeg1cd, C_Segcd pSeg2cd) {

        QIT_KhDenpyoData qIT_KhDenpyoData = new QIT_KhDenpyoData("qIT_KhDenpyoData");

        String strSql = $SELECT + $NEW(BizCurrencySum.class,
            qIT_KhDenpyoData.denyenkagk.getTypeFieldName(),
            qIT_KhDenpyoData.denyenkagk.getValueFieldName()) +
            $FROM(qIT_KhDenpyoData) +
            $WHERE + qIT_KhDenpyoData.syono.eq(pSyono) +
            $AND + qIT_KhDenpyoData.huridenatesakicd.eq(pHuridenatesakicd) +
            $AND + qIT_KhDenpyoData.tantocd.eq(pTantouCdKbn) +
            $AND + qIT_KhDenpyoData.syoricd.eq(pSyoricd) +
            $AND + qIT_KhDenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KARIKATA) +
            $AND + qIT_KhDenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V) +
            $AND + qIT_KhDenpyoData.seg1cd.eq(pSeg1cd) +
            $AND + qIT_KhDenpyoData.seg2cd.eq(pSeg2cd) +
            $ORDER_BY(qIT_KhDenpyoData.gyoumuKousinTime.desc());

        BizCurrencySum result = exDBEntityManager.createJPQL(
            strSql,BizCurrencySum.class).setFirstResult(0).setMaxResults(1).bind(qIT_KhDenpyoData).getSingleResult();

        if (result == null) {
            return BizCurrency.valueOf(0);
        }

        return result.toBizCurrency();
    }

    public YendthnkSikinIdouDataKingakuBean getYendthnkSikinIdouDataKingakuBeanBySyonoSyouhncdSyouhnsdno(String pSyono,
        String pSyouhnCd, Integer pSyouhnsdNo) {

        QBT_YendthnkSikinIdouData qBT_YendthnkSikinIdouData = new QBT_YendthnkSikinIdouData("qBT_YendthnkSikinIdouData");

        String strSql = $SELECT + $NEW(YendthnkSikinIdouDataKingakuBean.class,
            qBT_YendthnkSikinIdouData.siteituuka,
            qBT_YendthnkSikinIdouData.siteituukagk.getTypeFieldName(),
            qBT_YendthnkSikinIdouData.siteituukagk.getValueFieldName(),
            qBT_YendthnkSikinIdouData.trhktuuka,
            qBT_YendthnkSikinIdouData.trhktuukagk.getTypeFieldName(),
            qBT_YendthnkSikinIdouData.trhktuukagk.getValueFieldName()) +
            $FROM(qBT_YendthnkSikinIdouData) +
            $WHERE + qBT_YendthnkSikinIdouData.syono.eq(pSyono) +
            $AND + qBT_YendthnkSikinIdouData.keiriyendthnkkbn.eq(C_KeiriyendthnkKbn.HENKOU) +
            $AND + qBT_YendthnkSikinIdouData.syouhncd.eq(pSyouhnCd) +
            $AND + qBT_YendthnkSikinIdouData.syouhnsdno.eq(pSyouhnsdNo) +
            $ORDER_BY(qBT_YendthnkSikinIdouData.syoriYmd.desc());

        return  exDBEntityManager.createJPQL(strSql,
            YendthnkSikinIdouDataKingakuBean.class).setFirstResult(0).setMaxResults(1).bind(
                qBT_YendthnkSikinIdouData).getSingleResult();
    }

    public IT_KihrkmpSeisanRireki getKihrkmpSeisanRirekiBySyonoGyoumuKousinKinou (String pSyono,String pGyoumuKousinKinou) {


        QIT_KihrkmpSeisanRireki qIT_KihrkmpSeisanRireki = new QIT_KihrkmpSeisanRireki("qIT_KihrkmpSeisanRireki");

        String strSql = $SELECT + qIT_KihrkmpSeisanRireki +
            $FROM(qIT_KihrkmpSeisanRireki) +
            $WHERE + qIT_KihrkmpSeisanRireki.syono.eq(pSyono) +
            $AND + qIT_KihrkmpSeisanRireki.gyoumuKousinKinou.eq(pGyoumuKousinKinou) +
            $ORDER_BY(qIT_KihrkmpSeisanRireki.renno.desc());

        return  exDBEntityManager.createJPQL(
            strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KihrkmpSeisanRireki).getSingleResult();
    }

    public IT_KhSisuurendoTmttkn getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymd(String pSyono,
        BizDate pTmttknkouryokukaisiymd) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn("qIT_KhSisuurendoTmttkn");

        String strSql = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM(qIT_KhSisuurendoTmttkn) +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.le(pTmttknkouryokukaisiymd) +
            $ORDER_BY(qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return  exDBEntityManager.createJPQL(
            strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhSisuurendoTmttkn).getSingleResult();
    }

    public IT_KykSyouhnRireki getKykSyouhnRirekiBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki("qIT_KykSyouhnRireki");

        String strSql = $SELECT + qIT_KykSyouhnRireki +
            $FROM (qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey.lt(pHenkousikibetukey) +
            $ORDER_BY(qIT_KykSyouhnRireki.henkousikibetukey.desc());

        return  exDBEntityManager.createJPQL(
            strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KykSyouhnRireki).getSingleResult();
    }

    public IT_KhTtdkRireki getKhTtdkRirekiBySyonoSyorikbn(String pSyono, C_SyoriKbn pSyorikbn) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki("qIT_KhTtdkRireki");

        String strSql = $SELECT + qIT_KhTtdkRireki +
            $FROM (qIT_KhTtdkRireki) +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syorikbn.eq(pSyorikbn) +
            $ORDER_BY(qIT_KhTtdkRireki.henkousikibetukey.desc());

        return  exDBEntityManager.createJPQL(
            strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhTtdkRireki).getSingleResult();
    }
}
