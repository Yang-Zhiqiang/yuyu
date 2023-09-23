package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全共通 帳票本番確認保険証券判定
 */
public class CheckTyohyouHnbnKknSyouken {

    public static final String JYOUKENBUNRUI1_DEYUO = "020";

    public static final String JYOUKENBUNRUI1_YAKKANJYURYOUHOUKBN = "030";

    public static final String JYOUKENBUNRUI1_JGKAITEI = "040";

    public static final String JYOUKENBUNRUI1_SLM_050 = "050";

    public static final String JYOUKENBUNRUI1_SLM_060 = "060";

    public static final String JYOUKENBUNRUI1_CREDIT_070 = "070";

    public static final String JYOUKENBUNRUI1_CREDIT_080 = "080";

    public static final String JYOUKENBUNRUI1_SKHTIRASIDOHUU = "090";

    public static final String JYOUKENBUNRUI1_JGKAITEI_SINKIN = "091";

    public static final String JYOUKENBUNRUI1_GAUDEI = "100";

    public static final String JYOUKENBUNRUI1_KZKTTTKS = "110";

    public static final String JYOUKENBUNRUI1_JGKAITEI_YENDTHNK = "120";

    public static final String JYOUKENBUNRUI1_BORERO = "130";

    public static final Set<String> SET_KZKTRS_MSGCODE = new HashSet<>(Arrays.asList("13342","13343","13344")) ;

    @Inject
    private static Logger logger = LoggerFactory.getLogger(CheckTyohyouHnbnKknSyouken.class);

    public static HanteiKekkaBean exec(IT_KykKihon pKykKihon, IT_HokenSyouken pHokenSyouken,
        List<TyohyouHonbanKakuninBean> pJyoukenList) {

        logger.debug("▽ 帳票本番確認保険証券判定 開始");

        HanteiKekkaBean hanteiKekkaBean = SWAKInjector.getInstance(HanteiKekkaBean.class);
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = new ArrayList<>();

        C_SyoruiCdKbn syoruiCd = getHanteigoSyoruiCd(pHokenSyouken);

        hanteiKekkaBean.setKzkKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setHhkdrKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setSaiKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setSinFstCreditKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setSinKeiroKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setSaiCreditKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setSkhTirasiDouhuuuUmuKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setAllUpdKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setSinBoreroKbn(C_UmuKbn.NONE);
        hanteiKekkaBean.setSaiBoreroKbn(C_UmuKbn.NONE);

        for (TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean : pJyoukenList) {

            if (JYOUKENBUNRUI1_DEYUO.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())){
                boolean kousinHantei = check020(pKykKihon);
                if (kousinHantei) {
                    tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                }
            }

            if (JYOUKENBUNRUI1_YAKKANJYURYOUHOUKBN.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())){

                boolean kousinHantei = check030(pKykKihon);

                if (kousinHantei) {

                    tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                }
            }

            if (JYOUKENBUNRUI1_JGKAITEI.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean kousinHantei = check040(pKykKihon);

                    if (kousinHantei) {

                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if (JYOUKENBUNRUI1_SLM_050.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    BizDate mosYmd = pKykKihon.getMosymd();

                    if (BizDateUtil.compareYmd(mosYmd, BizDate.valueOf(2020, 4, 1)) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(mosYmd, BizDate.valueOf(2020, 4, 1)) == BizDateUtil.COMPARE_EQUAL) {

                        boolean updHanteiKzkTrkFlg = check050(pHokenSyouken);

                        if (updHanteiKzkTrkFlg) {

                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            hanteiKekkaBean.setKzkKbn(C_UmuKbn.ARI);
                        }
                    }
                }
                else if (C_SyoruiCdKbn.KK_SAISYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    hanteiKekkaBean.setSaiKbn(C_UmuKbn.ARI);
                }
            }

            if (JYOUKENBUNRUI1_SLM_060.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    BizDate mosYmd = pKykKihon.getMosymd();

                    if (BizDateUtil.compareYmd(mosYmd, BizDate.valueOf(2020, 4, 1)) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(mosYmd, BizDate.valueOf(2020, 4, 1)) == BizDateUtil.COMPARE_EQUAL) {

                        boolean updHanteiHhknDrFlg = check060(pHokenSyouken);

                        if (updHanteiHhknDrFlg) {

                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            hanteiKekkaBean.setHhkdrKbn(C_UmuKbn.ARI);
                        }
                    }
                }
            }

            if (JYOUKENBUNRUI1_CREDIT_070.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean updFlg = check070Sin(pKykKihon);
                    if (updFlg) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        hanteiKekkaBean.setSinFstCreditKbn(C_UmuKbn.ARI);
                    }
                }
                else if (C_SyoruiCdKbn.KK_SAISYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean updFlg = check070Sai(pKykKihon);
                    if (updFlg) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        hanteiKekkaBean.setSaiCreditKbn(C_UmuKbn.ARI);
                    }
                }
            }

            if (JYOUKENBUNRUI1_CREDIT_080.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean updFlg = check080(pKykKihon);
                    if (updFlg) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        hanteiKekkaBean.setSinKeiroKbn(C_UmuKbn.ARI);
                    }
                }
            }

            if (JYOUKENBUNRUI1_SKHTIRASIDOHUU.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean updFlg = check090(pHokenSyouken);
                    if (updFlg) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        hanteiKekkaBean.setSkhTirasiDouhuuuUmuKbn(C_UmuKbn.ARI);
                    }
                }
            }

            if (JYOUKENBUNRUI1_JGKAITEI_SINKIN.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean updFlg = check091(pKykKihon);
                    if (updFlg) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        hanteiKekkaBean.setAllUpdKbn(C_UmuKbn.ARI);
                    }
                }
            }

            if (JYOUKENBUNRUI1_GAUDEI.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if ((C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) ||
                    (C_SyoruiCdKbn.KK_SAISYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd()))) {

                    boolean kousinHantei = check100(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if (JYOUKENBUNRUI1_KZKTTTKS.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    BizDate mosYmd = pKykKihon.getMosymd();

                    if (BizDateUtil.compareYmd(mosYmd, BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(mosYmd, BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_EQUAL) {

                        boolean updHanteiHhknDrFlg = check110(pHokenSyouken);

                        if (updHanteiHhknDrFlg) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        }
                    }
                }
            }

            if (JYOUKENBUNRUI1_JGKAITEI_YENDTHNK.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SAISYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean kousinHantei = check120(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if (JYOUKENBUNRUI1_BORERO.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if (C_SyoruiCdKbn.KK_SKSYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean kousinHantei = check130(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        hanteiKekkaBean.setSinBoreroKbn(C_UmuKbn.ARI);
                    }
                }

                if (C_SyoruiCdKbn.KK_SAISYOUKEN.eq(syoruiCd) && syoruiCd.eq(tyohyouHonbanKakuninBean.getSyoruiCd())) {

                    boolean kousinHantei = check130(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                        hanteiKekkaBean.setSaiBoreroKbn(C_UmuKbn.ARI);
                    }
                }
            }
        }

        hanteiKekkaBean.setUpdateKbn(C_UmuKbn.NONE);

        if (tyohyouHonbanKakuninBeanList.size() > 0) {

            hanteiKekkaBean.setTyohyouHonbanKakuninBeanList(tyohyouHonbanKakuninBeanList);
            hanteiKekkaBean.setUpdateKbn(C_UmuKbn.ARI);
        }

        logger.debug("△ 帳票本番確認保険証券判定 終了");

        return hanteiKekkaBean;
    }

    private static C_SyoruiCdKbn getHanteigoSyoruiCd(IT_HokenSyouken pHokenSyouken) {

        C_SyoruiCdKbn syoruiCd = C_SyoruiCdKbn.BLNK;

        C_SinsaihkKbn sinsaihkKbn = pHokenSyouken.getSinsaihkkbn();

        C_SyoukensaihkKbn syoukensaihkKbn = pHokenSyouken.getSyoukensaihkkbn();

        if (C_SinsaihkKbn.SIN.eq(sinsaihkKbn) || (C_SinsaihkKbn.SAI.eq(sinsaihkKbn) && C_SyoukensaihkKbn.
            SINKEIYAKUSAISAKUSEI.eq(syoukensaihkKbn))) {

            syoruiCd = C_SyoruiCdKbn.KK_SKSYOUKEN;
        }
        else if (C_SinsaihkKbn.SAI.eq(sinsaihkKbn) && C_SyoukensaihkKbn.SYOUKENSAIHAKKOU.eq(syoukensaihkKbn)) {

            syoruiCd = C_SyoruiCdKbn.KK_SAISYOUKEN;
        }

        return syoruiCd;
    }

    protected static boolean check020(IT_KykKihon pKykKihon) {

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();

        boolean kousinHantei = false;
        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);
        if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check030(IT_KykKihon pKykKihon) {

        boolean kousinHantei = false;

        if (!C_YakkanJyuryouKbn.BLNK.eq(pKykKihon.getYakkanjyuryouhoukbn())) {

            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check040(IT_KykKihon pKykKihon) {

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();

        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check050(IT_HokenSyouken pHokenSyouken) {

        C_UmuKbn kzktirasidouhuukbn1 = C_UmuKbn.NONE;
        C_UmuKbn kzktirasidouhuukbn2 = C_UmuKbn.NONE;
        boolean kousinHantei = false;

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = pHokenSyouken.getHokenSyoukenHukaInfo();

        if (hokenSyoukenHukaInfo != null) {
            kzktirasidouhuukbn1 = hokenSyoukenHukaInfo.getKzktirasidouhuukbn1();
            kzktirasidouhuukbn2 = hokenSyoukenHukaInfo.getKzktirasidouhuukbn2();
        }

        if (C_UmuKbn.ARI.eq(kzktirasidouhuukbn1) || C_UmuKbn.ARI.eq(kzktirasidouhuukbn2)) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check060(IT_HokenSyouken pHokenSyouken) {

        C_UmuKbn kzktirasidouhuukbn1 = C_UmuKbn.NONE;
        C_UmuKbn kzktirasidouhuukbn2 = C_UmuKbn.NONE;
        C_UmuKbn kykdairitirasidouhuukbn = C_UmuKbn.NONE;
        boolean kousinHantei = false;

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = pHokenSyouken.getHokenSyoukenHukaInfo();

        if (hokenSyoukenHukaInfo != null) {
            kzktirasidouhuukbn1 = hokenSyoukenHukaInfo.getKzktirasidouhuukbn1();
            kzktirasidouhuukbn2 = hokenSyoukenHukaInfo.getKzktirasidouhuukbn2();
            kykdairitirasidouhuukbn = hokenSyoukenHukaInfo.getKykdairitirasidouhuukbn();
        }

        C_UmuKbn stdrsktirasidouhuukbn = pHokenSyouken.getStdrsktirasidouhuukbn();

        if (C_UmuKbn.NONE.eq(kzktirasidouhuukbn1) &&
            C_UmuKbn.NONE.eq(kzktirasidouhuukbn2) &&
            C_UmuKbn.NONE.eq(kykdairitirasidouhuukbn)) {

            if (C_UmuKbn.ARI.eq(stdrsktirasidouhuukbn)) {
                kousinHantei = true;
            }
        }

        return kousinHantei;
    }

    protected static boolean check070Sin(IT_KykKihon pKykKihon) {

        boolean kousinHantei = false;

        C_FstphrkkeiroKbn fstphrkkeirokbn = pKykKihon.getFstphrkkeirokbn();

        if (C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeirokbn)) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check070Sai(IT_KykKihon pKykKihon) {

        boolean kousinHantei = false;

        C_FstphrkkeiroKbn fstphrkkeirokbn = pKykKihon.getFstphrkkeirokbn();
        C_Hrkkeiro hrkkeiro = pKykKihon.getHrkkeiro();

        if (C_FstphrkkeiroKbn.CREDIT.eq(fstphrkkeirokbn) ||
            C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check080(IT_KykKihon pKykKihon) {

        boolean kousinHantei = false;

        C_Hrkkeiro hrkkeiro = pKykKihon.getHrkkeiro();

        if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check090(IT_HokenSyouken pHokenSyouken) {

        C_UmuKbn skhtirasidouhuukbn = C_UmuKbn.NONE;
        boolean kousinHantei = false;

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = pHokenSyouken.getHokenSyoukenHukaInfo();

        if (hokenSyoukenHukaInfo != null) {
            skhtirasidouhuukbn = hokenSyoukenHukaInfo.getSkhtirasidouhuukbn();
        }

        if (C_UmuKbn.ARI.eq(skhtirasidouhuukbn)) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check091(IT_KykKihon pKykKihon) {

        boolean kousinHantei = false;

        C_AisyoumeiKbn aisyoumeiKbn = pKykKihon.getAisyoumeikbn();

        if (C_AisyoumeiKbn.GAIKASYUUSIN_19_SINKIN.eq(aisyoumeiKbn)) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check100(IT_KykKihon pKykKihon) {

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();

        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check110(IT_HokenSyouken pHokenSyouken) {

        String kzktourokuservicemsg4 = "";
        String kzktourokuservicemsg5 = "";
        boolean kousinHantei = false;

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = pHokenSyouken.getHokenSyoukenHukaInfo();

        if (hokenSyoukenHukaInfo != null) {
            kzktourokuservicemsg4 = hokenSyoukenHukaInfo.getKzktourokuservicemsg4();
            kzktourokuservicemsg5 = hokenSyoukenHukaInfo.getKzktourokuservicemsg5();
        }

        if (SET_KZKTRS_MSGCODE.contains(kzktourokuservicemsg4) || SET_KZKTRS_MSGCODE.contains(kzktourokuservicemsg5)) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check120(IT_KykKihon pKykKihon) {

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();

        BizDate yendthnkYmd = kykSyouhn.getYendthnkymd();

        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 && yendthnkYmd != null) {
            kousinHantei = true;
        }

        return kousinHantei;
    }

    protected static boolean check130(IT_KykKihon pKykKihon) {

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();

        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            kousinHantei = true;
        }

        return kousinHantei;
    }
}
