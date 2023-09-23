package yuyu.common.siharai.sicommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.edittbl.SiMeigihenkouSateiParam;
import yuyu.common.siharai.edittbl.SiSateiIppanHanteiParam;
import yuyu.common.siharai.edittbl.SiSonotaSateiSbParam;
import yuyu.common.siharai.edittbl.SiToriatukaifuryouParam;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定結果入力チェッククラス
 */
public class SateiKekkaNyuuryokuChk {

    public static final String SOSIKICD = "0000";

    @Inject
    private static Logger logger;

    public SateiKekkaNyuuryokuChk() {
        super();
    }

    public void exec(CommonViewUiBeanParam pCommonViewUiBeanParam, JT_SkKihon pSkKihon,
        List<ChkKekkaBean> pChkKekkaBeanList, List<Message> pMessageList, C_UmuKbn pSaigaihosyouUmuKbn,
        C_SyorikekkaKbn pSyorikekkaKbn, C_SikinouModeIdKbn pSikinouModeIdKbn) {

        logger.debug("▽ 査定結果入力チェック 開始");

        if (pCommonViewUiBeanParam == null) {
            throw new BizAppException(MessageId.EJS1005, "pCommonViewUiBeanParam");
        }

        if (pSkKihon == null) {
            throw new BizAppException(MessageId.EJS1005, "pSkKihon");
        }

        if (pSikinouModeIdKbn == null) {
            throw new BizAppException(MessageId.EJS1005, "pSikinouModeIdKbn");
        }

        if (C_SikinouModeIdKbn.SATEI1.eq(pSikinouModeIdKbn)) {

            sateikekkaMinyuuryokuCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn());

            if (pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                if (C_SyorikekkaKbn.SIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())
                    || C_SyorikekkaKbn.HUSIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())
                        || C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                            .getSyorikekkakbn())) {
                    if (pCommonViewUiBeanParam instanceof SiSateiIppanHanteiParam) {

                        ippanHanteiErrCheck(((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuu1(),
                            ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuu2(),
                            ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuu3(),
                            ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuu4(),
                            ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuu5(),
                            ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuu6(),
                            ((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuugoukei());
                    }

                    if (pCommonViewUiBeanParam instanceof SiToriatukaifuryouParam) {

                        toriatukaiErrCheck(pCommonViewUiBeanParam);
                    }

                    if (pCommonViewUiBeanParam instanceof SiSonotaSateiSbParam) {

                        sonotaShiboErrCheck(pCommonViewUiBeanParam);
                    }

                    if (pCommonViewUiBeanParam instanceof ViewJyuukasituInfoUiBeanParam) {

                        juukasituErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getHushrgeninkbn(),
                            ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).getJuukasitucheck1(),
                            ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).getJuukasitucheck2(),
                            ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).getJuukasitucheck3(),
                            ((ViewJyuukasituInfoUiBeanParam) pCommonViewUiBeanParam).getJuukasitucheck4());
                    }
                }

                if (C_SyorikekkaKbn.HUSIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())
                    || C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())) {

                    sessyouyhErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSessyouyhkbn());
                }

                if (!BizUtil.isBlank(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSessyousisyacd())){

                    shisyacdErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSessyousisyacd());

                }

                if (C_SyorikekkaKbn.SIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn()) ||
                    C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())) {

                    if (pCommonViewUiBeanParam instanceof SiMeigihenkouSateiParam) {

                        meigihenkouErrCheck(pChkKekkaBeanList,
                            ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).getMeihenyuukoumukoukbn(),
                            ((SiMeigihenkouSateiParam) pCommonViewUiBeanParam).getMeihenuktkbn());
                    }
                }

                if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())) {

                    sibousSaigaihigaitouErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSaigaimousideumukbn(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getHushrgeninkbn(),
                        pSaigaihosyouUmuKbn);
                }

                if (C_SyorikekkaKbn.HUSIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())) {

                    higaitouErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSaigaimousideumukbn(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getHushrgeninkbn());
                }

                if (pCommonViewUiBeanParam instanceof ViewSiharaiInfoUiBeanParam) {

                    tyudannisuuErrCheck(((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).getDispsyoruiukeymd(),
                        BizDate.getSysDate(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getRikoukityuutuudannissuu(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSinsagendokknkbn());
                }

                tensousakiErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                    ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getTennousakisousasyacd());

                if (C_SyorikekkaKbn.SIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())
                    || C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())) {

                    tokuninnErrCheck(pMessageList);
                }
            }
        }

        else if (C_SikinouModeIdKbn.SATEI2.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                sateikekkaMinyuuryokuCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn());

                if (pCommonViewUiBeanParam instanceof ViewSiharaiInfoUiBeanParam) {

                    tyudannisuuErrCheck(((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).getDispsyoruiukeymd(),
                        BizDate.getSysDate(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getRikoukityuutuudannissuu(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSinsagendokknkbn());
                }

                tensousakiErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                    ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getTennousakisousasyacd());

                syorikekaSeigouseiCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                    pSyorikekkaKbn);

                if (C_SyorikekkaKbn.SIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())
                    || C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())) {

                    tokuninnErrCheck(pMessageList);
                }

                if (!C_SyorikekkaKbn.HORYUU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())
                    && !C_SyorikekkaKbn.TENSOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())
                        && !C_SyorikekkaKbn.KAKUNIN.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                            .getSyorikekkakbn())
                            && !C_SyorikekkaKbn.TYUUKANKAKUNIN.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                                .getSyorikekkakbn())
                                && !C_SyorikekkaKbn.TUIKAKAKUNIN.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                                    .getSyorikekkakbn())
                                    && !C_SyorikekkaKbn.SASIMODOSI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                                        .getSyorikekkakbn())) {
                    fubikanriErrCheck(((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).getSyono(),
                        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).getSkno());
                }
            }
        }

        else if (C_SikinouModeIdKbn.SATEI3.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                sateikekkaMinyuuryokuCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn());

                if (pCommonViewUiBeanParam instanceof ViewSiharaiInfoUiBeanParam) {

                    tyudannisuuErrCheck(((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).getDispsyoruiukeymd(),
                        BizDate.getSysDate(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getRikoukityuutuudannissuu(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSinsagendokknkbn());
                }

                tensousakiErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                    ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getTennousakisousasyacd());

                syorikekaSeigouseiCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                    pSyorikekkaKbn);

                if (C_SyorikekkaKbn.SIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())
                    || C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())) {

                    tokuninnErrCheck(pMessageList);
                }
            }
        }

        else if (C_SikinouModeIdKbn.SATEI4.eq(pSikinouModeIdKbn)) {

            sateikekkaMinyuuryokuCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn());

            if (pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                if (pCommonViewUiBeanParam instanceof ViewSiharaiInfoUiBeanParam) {

                    tyudannisuuErrCheck(((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).getDispsyoruiukeymd(),
                        BizDate.getSysDate(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getRikoukityuutuudannissuu(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSinsagendokknkbn());
                }

                tensousakiErrCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                    ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getTennousakisousasyacd());

                syorikekaSeigouseiCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn(),
                    pSyorikekkaKbn);

                if (C_SyorikekkaKbn.SIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                    .getSyorikekkakbn())
                    || C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn())) {

                    tokuninnErrCheck(pMessageList);
                }
            }
        }

        else if (C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.eq(pSikinouModeIdKbn)
            || C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof ViewSiharaiInfoUiBeanParam
                && pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                tyudannisuuErrCheck(((ViewSiharaiInfoUiBeanParam) pCommonViewUiBeanParam).getDispsyoruiukeymd(),
                    BizDate.getSysDate(),
                    ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getRikoukityuutuudannissuu(),
                    ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSinsagendokknkbn());
            }

            if (pCommonViewUiBeanParam instanceof ViewSateiKekkaUiBeanParam) {

                sateikekkaMinyuuryokuCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateisyorikekkakbn());

                if (!C_SyorikekkaKbn.HORYUU.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                    .getSateisyorikekkakbn())
                    && !C_SyorikekkaKbn.TENSOU.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                        .getSateisyorikekkakbn())
                        && !C_SyorikekkaKbn.HUBIKANRI.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                            .getSateisyorikekkakbn())
                            && !C_SyorikekkaKbn.SATEI_SIJI.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                                .getSateisyorikekkakbn())
                                && !C_SyorikekkaKbn.HUSYOUNIN.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                                    .getSateisyorikekkakbn())) {

                    fubikanriErrCheck(((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).getSyono(),
                        ((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).getSkno());
                }

                tensousakiErrCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateisyorikekkakbn(),
                    ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateitennousakisousasyacd());

                if (C_SyorikekkaKbn.SYOUNIN.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                    .getSateisyorikekkakbn())
                    || C_SyorikekkaKbn.SIHARAI.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                        .getSateisyorikekkakbn())
                        || C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                            .getSateisyorikekkakbn())){

                    tokuninnErrCheck(pMessageList);
                }
            }
        }

        else if (C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.eq(pSikinouModeIdKbn)
            || C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof ViewSateiKekkaUiBeanParam) {

                sateikekkaMinyuuryokuCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateisyorikekkakbn());

                tensousakiErrCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateisyorikekkakbn(),
                    ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateitennousakisousasyacd());
            }
        }

        else if (C_SikinouModeIdKbn.SESSYOU1.eq(pSikinouModeIdKbn)
            || C_SikinouModeIdKbn.SESSYOU2.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof ViewSateiKekkaUiBeanParam) {

                sateikekkaMinyuuryokuCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateisyorikekkakbn());

                tensousakiErrCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateisyorikekkakbn(),
                    ((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateitennousakisousasyacd());
            }
        }

        else if (C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.eq(pSikinouModeIdKbn)
            || C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof ViewSateiKekkaUiBeanParam) {

                sateikekkaMinyuuryokuCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getSateisyorikekkakbn());

                if (C_SyorikekkaKbn.KANRYOU.eq(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam)
                    .getSateisyorikekkakbn())) {

                    kaiketubiErrCheck(((ViewSateiKekkaUiBeanParam) pCommonViewUiBeanParam).getKaiketuymd());

                    keiyakutorikesiErrCheck(((ViewSkKihonUiBeanParam) pCommonViewUiBeanParam).getSyono(),
                        ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getHushrgeninkbn());
                }
            }
        }
        else if (C_SikinouModeIdKbn.KAKUNINIRAITYUU.eq(pSikinouModeIdKbn)
            ||C_SikinouModeIdKbn.HUBIKANRITYUU.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                sateikekkaMinyuuryokuCheck(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSyorikekkakbn());
            }
        }

        if (C_SikinouModeIdKbn.SATEI1.eq(pSikinouModeIdKbn) || C_SikinouModeIdKbn.SATEI2.eq(pSikinouModeIdKbn)
            || C_SikinouModeIdKbn.SATEI3.eq(pSikinouModeIdKbn) || C_SikinouModeIdKbn.SATEI4.eq(pSikinouModeIdKbn)) {

            if (pCommonViewUiBeanParam instanceof SiSateiIppanHanteiParam) {

                ippanHanteiWarningCheck(((SiSateiIppanHanteiParam) pCommonViewUiBeanParam).getIppanhanteitensuugoukei());
            }

            if (pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                kakuninnTourokuWarningCheck(pSkKihon.getKakninumukbn(),
                    ((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam).getSinsagendokknkbn());
            }

            if (C_SeikyuuSyubetu.SB.eq(pSkKihon.getSeikyuusyubetu())) {

                if (pCommonViewUiBeanParam instanceof ViewSiharaiSateiUiBeanParam) {

                    if (C_SyorikekkaKbn.SIHARAI.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                        .getSyorikekkakbn()) ||
                        C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(((ViewSiharaiSateiUiBeanParam) pCommonViewUiBeanParam)
                            .getSyorikekkakbn())) {

                        jisatuWarningcheck(pChkKekkaBeanList);
                    }
                }
            }
        }

        logger.debug("△ 査定結果入力チェック 終了");
    }

    private void ippanHanteiErrCheck(String pIppanhanteitensuu1, String pIppanhanteitensuu2,
        String pIppanhanteitensuu3, String pIppanhanteitensuu4, String pIppanhanteitensuu5,
        String pIppanhanteitensuu6, String pIppanhanteitensuugoukei) {

        int wIppanhanteitensuugoukei = Integer.valueOf(BizUtil.blank2zero(pIppanhanteitensuu1))
            + Integer.valueOf(BizUtil.blank2zero(pIppanhanteitensuu2))
            + Integer.valueOf(BizUtil.blank2zero(pIppanhanteitensuu3))
            + Integer.valueOf(BizUtil.blank2zero(pIppanhanteitensuu4))
            + Integer.valueOf(BizUtil.blank2zero(pIppanhanteitensuu5))
            + Integer.valueOf(BizUtil.blank2zero(pIppanhanteitensuu6));

        if (wIppanhanteitensuugoukei != Integer.valueOf(BizUtil.blank2zero(pIppanhanteitensuugoukei))) {
            throw new BizLogicException(MessageId.EBA0039, "一般判定点数合計");
        }
    }

    private void toriatukaiErrCheck(CommonViewUiBeanParam pCommonViewUiBeanParam) {

        if (((SiToriatukaifuryouParam) pCommonViewUiBeanParam).getTratkihuryouumukbn() == null) {

            throw new BizLogicException(MessageId.EBC0043, "取扱不良有無区分");
        }
    }

    private void sonotaShiboErrCheck(CommonViewUiBeanParam pCommonViewUiBeanParam) {

        if ((((SiSonotaSateiSbParam) pCommonViewUiBeanParam).getBengosikenkaiumukbn() == null)
            || (((SiSonotaSateiSbParam) pCommonViewUiBeanParam).getKujyouumukbn() == null)
            || (((SiSonotaSateiSbParam) pCommonViewUiBeanParam).getJimumissumukbn() == null)
            || (((SiSonotaSateiSbParam) pCommonViewUiBeanParam).getKyhgksitukaisouyouhikbn() == null)) {

            throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1036));
        }
    }

    private void tyudannisuuErrCheck(BizDate pSyoruiukeymd, BizDate sysDate, Integer pRikoukityuutuudannissuu,
        C_SinsaGendoKknKbn pSinsagendokknkbn) {

        Integer rikoukityuutuudannissuu = 0;

        if (pRikoukityuutuudannissuu != null) {

            rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
        }

        if (BizDateUtil.compareYmd(pSyoruiukeymd.addDays(rikoukityuutuudannissuu), sysDate)
            == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EJA0111);
        }

        if (C_SinsaGendoKknKbn.BD5.eq(pSinsagendokknkbn)) {
            if (rikoukityuutuudannissuu > 0) {
                throw new BizLogicException(MessageId.EJA0112);
            }
        }
    }

    private void shisyacdErrCheck(String pSessyousisyacd) {

        BzGetSosikiData getSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean sosikiJyouhou = getSosikiData.exec(pSessyousisyacd + SOSIKICD);

        if (C_SosikimasterUmuKbn.NONE.eq(sosikiJyouhou.getSosikimasterumukbn())) {
            throw new BizLogicException(MessageId.EJA1022);
        }
    }

    private void meigihenkouErrCheck(List<ChkKekkaBean> pChkKekkaBeanList, C_MeihenYuukouMukouKbn meihenyuukoumukoukbn,
        C_MeihenUktKbn meihenuktkbn) {

        for (ChkKekkaBean chkKekkaBean : pChkKekkaBeanList) {
            if (C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH.eq(chkKekkaBean.getSKNaiyouChkKbn())
                || C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI.eq(chkKekkaBean.getSKNaiyouChkKbn())
                || C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_SIBOUGO.eq(chkKekkaBean.getSKNaiyouChkKbn())) {
                if (C_MeihenYuukouMukouKbn.BLNK.eq(meihenyuukoumukoukbn) || C_MeihenUktKbn.BLNK.eq(meihenuktkbn)) {
                    throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1037));
                }
            }
        }
    }

    private void syorikekaSeigouseiCheck(C_SyorikekkaKbn pSyorikekkakbn, C_SyorikekkaKbn pKakuninSyorikekkakbn) {

        if (C_SyorikekkaKbn.SIHARAI.eq(pSyorikekkakbn)) {
            if (!C_SyorikekkaKbn.SIHARAI.eq(pKakuninSyorikekkakbn)) {
                throw new BizLogicException(MessageId.EJA1026);
            }
        }
        else if (C_SyorikekkaKbn.HUSIHARAI.eq(pSyorikekkakbn)) {
            if (!C_SyorikekkaKbn.HUSIHARAI.eq(pKakuninSyorikekkakbn)) {
                throw new BizLogicException(MessageId.EJA1026);
            }
        }
        else if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(pSyorikekkakbn)) {
            if (!C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(pKakuninSyorikekkakbn)) {
                throw new BizLogicException(MessageId.EJA1026);
            }
        }
    }

    private void fubikanriErrCheck(String pSyoNo, String pSkNo) {

        BzGetProcessSummaryInBean processSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        BzGetProcessSummary processSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        processSummaryInBean.setJimuTetuzukiCd(TeisuuSiharai.JIMUTETUZUKICD_SIHUBISIBOU);
        processSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        processSummaryInBean.setSyoNo(pSyoNo);
        processSummaryInBean.setSkNos(new String[]{pSkNo});
        processSummaryInBean.setSubSystemId(TeisuuSiharai.SUBSYSTEMID_SIHARAI);
        List<BzGetProcessSummaryOutBean> processSummaryOutBeans = processSummary.exec(processSummaryInBean);
        if (processSummaryOutBeans.size() > 0) {
            throw new BizLogicException(MessageId.EJA0099);
        }
    }

    private void kaiketubiErrCheck(BizDate pKaiketuymd) {

        if (pKaiketuymd == null) {
            throw new BizLogicException(MessageId.EBC0043, "解決日");
        }

        if (BizDateUtil.compareYmd(pKaiketuymd, BizDate.getSysDate())
            == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EBF0124, "解決日");
        }
    }

    private void tokuninnErrCheck(List<Message> pMessageList) {

        for (Message message : pMessageList) {
            if (message.getMessageId().startsWith("T")) {
                throw new BizLogicException(MessageId.EJA0033);
            }
        }
    }

    private void tensousakiErrCheck(C_SyorikekkaKbn pSyorikekkaKbn, String pTennousakisousasyacd) {

        if (C_SyorikekkaKbn.TENSOU.eq(pSyorikekkaKbn)) {
            if (BizUtil.isBlank(pTennousakisousasyacd)) {
                throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1033));
            }
        }
        else {
            if (!BizUtil.isBlank(pTennousakisousasyacd)) {
                throw new BizLogicException(MessageId.EBC0012, MessageUtil.getMessage(MessageId.IJW1033));
            }
        }
    }

    private void ippanHanteiWarningCheck(String pIppanHanteitensuuGoukei) {

        if (Integer.valueOf(BizUtil.blank2zero(pIppanHanteitensuuGoukei)) >= 11) {
            SiSetUiBean pSiSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
            pSiSetUiBean.addListWarningMessage(MessageId.WJA1001, MessageUtil.getMessage(MessageId.WJA1001));
        }
    }

    private void kakuninnTourokuWarningCheck(C_UmuKbn pkakninumukbn, C_SinsaGendoKknKbn pSinsagendokknkbn) {

        if (C_UmuKbn.ARI.eq(pkakninumukbn)) {
            if (C_SinsaGendoKknKbn.BD5.eq(pSinsagendokknkbn)) {
                SiSetUiBean pSiSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
                pSiSetUiBean.addListWarningMessage(MessageId.WJA1045, MessageUtil.getMessage(MessageId.WJA1045));
            }
        }
    }

    private void jisatuWarningcheck(List<ChkKekkaBean> pChkKekkaBeanList) {

        for (ChkKekkaBean chkKekkaBean : pChkKekkaBeanList) {
            if (C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI.eq(chkKekkaBean.getSKNaiyouChkKbn())) {
                SiSetUiBean pSiSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
                pSiSetUiBean.addListWarningMessage(MessageId.WJA1046, MessageUtil.getMessage(MessageId.WJA1046));
            }
        }
    }
    private void sessyouyhErrCheck(C_YouhiblnkKbn pSessyouyhkbn) {

        if (C_YouhiblnkKbn.BLNK.eq(pSessyouyhkbn)) {
            throw new BizLogicException(MessageId.EBC0043, "折衝要否");
        }
    }

    private void juukasituErrCheck(C_HushrGeninKbn pHushrGeninKbn, boolean pJuukasitucheck1,
        boolean pJuukasitucheck2, boolean pJuukasitucheck3, boolean pJuukasitucheck4) {

        if (C_HushrGeninKbn.SAI_MENSEKI_JKT.eq(pHushrGeninKbn)) {

            if (pJuukasitucheck1 == false
                || pJuukasitucheck2 == false
                || pJuukasitucheck3 == false
                || pJuukasitucheck4 == false) {
                throw new BizLogicException(MessageId.EBC0043, MessageUtil.getMessage(MessageId.IJW1076));
            }
        }
    }

    private void sibousSaigaihigaitouErrCheck(C_BlnktkumuKbn pSaigaimousideUmuKbn, C_SyorikekkaKbn pSyorikekkaKbn,
        C_HushrGeninKbn pHushrGeninKbn, C_UmuKbn pSaigaihosyouUmuKbn) {

        if (C_BlnktkumuKbn.BLNK.eq(pSaigaimousideUmuKbn)) {

            throw new BizLogicException(MessageId.EBC0043, "災害申出有無");
        }

        if (C_UmuKbn.NONE.eq(pSaigaihosyouUmuKbn)) {

            throw new BizLogicException(MessageId.EJA1036, pSyorikekkaKbn.getContent());
        }

        if (!C_HushrGeninKbn.SAI_GR.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_GH.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_JJ.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_SONOTA.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_MENSEKI_JKT.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_MENSEKI_SYK.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_MENSEKI_MMK.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_MENSEKI_SSN.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SAI_MENSEKI_SONOTA.eq(pHushrGeninKbn)) {

            throw new BizLogicException(MessageId.EBA0039, MessageUtil.getMessage(MessageId.IJW1071));
        }
    }

    private void higaitouErrCheck(C_BlnktkumuKbn pSaigaimousideUmuKbn, C_HushrGeninKbn pHushrGeninKbn) {

        if (C_BlnktkumuKbn.BLNK.eq(pSaigaimousideUmuKbn)) {

            throw new BizLogicException(MessageId.EBC0043, "災害申出有無");
        }

        if (!C_HushrGeninKbn.MENSEKI_SNDJST.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.MENSEKI_JNDJST.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.MENSEKI_TNDJST.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.KOI.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.SONOTA_MS.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.KAIJYO_JD.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.KAIJYO_SONOTA.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.MUKOU_SG.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.MUKOU_HHST.eq(pHushrGeninKbn)
            && !C_HushrGeninKbn.MUKOU_SONOTA.eq(pHushrGeninKbn)) {

            throw new BizLogicException(MessageId.EBA0039, MessageUtil.getMessage(MessageId.IJW1071));
        }
    }

    private void keiyakutorikesiErrCheck(String pSyoNo, C_HushrGeninKbn pHushrGeninKbn) {

        if (C_HushrGeninKbn.MENSEKI_SNDJST.eq(pHushrGeninKbn)
            || C_HushrGeninKbn.MENSEKI_JNDJST.eq(pHushrGeninKbn)
            || C_HushrGeninKbn.MENSEKI_TNDJST.eq(pHushrGeninKbn)
            || C_HushrGeninKbn.KOI.eq(pHushrGeninKbn)
            || C_HushrGeninKbn.SONOTA_MS.eq(pHushrGeninKbn)
            || C_HushrGeninKbn.KAIJYO_JD.eq(pHushrGeninKbn)
            || C_HushrGeninKbn.KAIJYO_SONOTA.eq(pHushrGeninKbn)
            || C_HushrGeninKbn.MUKOU_SONOTA.eq(pHushrGeninKbn)) {

            KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

            KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

            keiyakuPrm.setSyono(pSyoNo);
            keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

            keiyakuInfoSyutoku.getInfos(keiyakuPrm);

            if (keiyakuInfoSyutoku.getKykKihons().get(0) == null) {

                throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1001));
            }
            else if (C_YuukousyoumetuKbn.YUUKOU.eq(keiyakuInfoSyutoku.getKykKihons().get(0).getYuukousyoumetukbn())) {

                throw new BizLogicException(MessageId.EJA1037);
            }
        }
    }
    private void sateikekkaMinyuuryokuCheck(C_SyorikekkaKbn pSyorikekkakbn) {

        if (C_SyorikekkaKbn.BLNK.eq(pSyorikekkakbn)) {
            throw new BizLogicException(MessageId.EBC0043, "結果");
        }
    }
}
