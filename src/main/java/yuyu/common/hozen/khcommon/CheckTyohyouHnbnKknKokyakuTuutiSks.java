package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 帳票本番確認 外貨建顧客通知作成 判定
 */
public class CheckTyohyouHnbnKknKokyakuTuutiSks {

    public static final String JYOUKENBUNRUI1_010 = "010";
    public static final String JYOUKENBUNRUI1_020 = "020";
    public static final String JYOUKENBUNRUI1_070 = "070";

    public static final String JYOUKENBUNRUI2_001 = "001";
    public static final String JYOUKENBUNRUI2_002 = "002";
    public static final String JYOUKENBUNRUI2_004 = "004";

    public static final String JYOUKENBUNRUI3_001 = "001";
    public static final String JYOUKENBUNRUI3_002 = "002";
    public static final String JYOUKENBUNRUI3_003 = "003";
    public static final String JYOUKENBUNRUI3_004 = "004";
    public static final String JYOUKENBUNRUI3_005 = "005";
    public static final String JYOUKENBUNRUI3_006 = "006";
    public static final String JYOUKENBUNRUI3_007 = "007";
    public static final String JYOUKENBUNRUI3_008 = "008";
    public static final String JYOUKENBUNRUI3_009 = "009";
    public static final String JYOUKENBUNRUI3_010 = "010";

    public static final Integer KAISOUCNT_5 = 5;

    public static final String LAYOUTPATTERN_DUO = "07";

    @Inject
    private static Logger logger = LoggerFactory.getLogger(CheckTyohyouHnbnKknSyouken.class);

    @Inject
    private HozenDomManager hozenDomManager;

    public HanteiKekkaKokyakuTuutiSksBean exec(
        List<TyohyouHonbanKakuninBean> pJyoukenList, HashMap<String, Boolean> pHnbnKknnFlgMap,
        IT_KykKihon pKhKykKihon, IT_KykSyouhn pKhKykSyouhn, ZT_GaikaKokyakuTuutiTy pKhGikKkykTutiTy) {

        logger.debug("▽ 帳票本番確認 外貨建顧客通知作成 判定 開始");

        HanteiKekkaKokyakuTuutiSksBean hanteiKekkaBean = SWAKInjector.getInstance(HanteiKekkaKokyakuTuutiSksBean.class);
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = new ArrayList<>();

        for (TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean : pJyoukenList) {

            String joukenbunruiKey = tyohyouHonbanKakuninBean.getJyoukenbunrui1() +
                tyohyouHonbanKakuninBean.getJyoukenbunrui2() + tyohyouHonbanKakuninBean.getJyoukenbunrui3();
            logger.debug("   帳票本番確認 判定条件 条件：" + joukenbunruiKey);

            String syono = pKhKykKihon.getSyono();

            if (JYOUKENBUNRUI1_070.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                IT_KykKihon kykKihonForSonotaTkyk = hozenDomManager.getKykKihon(syono);
                IT_KykKihonDetacher.detachKykSonotaTkyktouched(kykKihonForSonotaTkyk);
                IT_KykSonotaTkyk kKykSonotaTkyk = kykKihonForSonotaTkyk.getKykSonotaTkyk();

                IT_KykKihon kykKihonForTtdkRrk = hozenDomManager.getKykKihon(syono);
                IT_KykKihonDetacher.detachKhTtdkRirekitouched(kykKihonForTtdkRrk);
                List<IT_KhTtdkRireki> ttdkRirekiList =
                    kykKihonForTtdkRrk.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_GENGAKU);
                C_UmuKbn gengakuUmu = C_UmuKbn.NONE;
                if (ttdkRirekiList.size() > 0) {
                    gengakuUmu = C_UmuKbn.ARI;
                }

                if (JYOUKENBUNRUI2_001.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui2())) {
                    if (JYOUKENBUNRUI3_003.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei = check070001003(syono, pKhKykKihon, joukenbunruiKey, pHnbnKknnFlgMap);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            pHnbnKknnFlgMap.put(joukenbunruiKey, false);
                        }
                    }
                    if (JYOUKENBUNRUI3_004.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei = check070001004(syono, pKhKykKihon, joukenbunruiKey, pHnbnKknnFlgMap);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            pHnbnKknnFlgMap.put(joukenbunruiKey, false);
                        }
                    }
                    if (JYOUKENBUNRUI3_005.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei =
                            check070001005(syono, pKhKykKihon, pKhGikKkykTutiTy, joukenbunruiKey, pHnbnKknnFlgMap);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            pHnbnKknnFlgMap.put(joukenbunruiKey, false);
                        }
                    }
                    if (JYOUKENBUNRUI3_006.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei =
                            check070001006(syono, pKhKykKihon, pKhGikKkykTutiTy, joukenbunruiKey, pHnbnKknnFlgMap);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            pHnbnKknnFlgMap.put(joukenbunruiKey, false);
                        }
                    }
                    if (JYOUKENBUNRUI3_007.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei =
                            check070001007(syono, kKykSonotaTkyk, pKhGikKkykTutiTy, joukenbunruiKey, pHnbnKknnFlgMap, gengakuUmu);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            pHnbnKknnFlgMap.put(joukenbunruiKey, false);
                        }
                    }
                    if (JYOUKENBUNRUI3_008.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei =
                            check070001008(syono, kKykSonotaTkyk, pKhGikKkykTutiTy, joukenbunruiKey, pHnbnKknnFlgMap, gengakuUmu);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            pHnbnKknnFlgMap.put(joukenbunruiKey, false);
                        }
                    }
                    if (JYOUKENBUNRUI3_009.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui3())) {
                        boolean kousinHantei =
                            check070001009(syono, kKykSonotaTkyk, pKhGikKkykTutiTy, joukenbunruiKey, pHnbnKknnFlgMap);
                        if (kousinHantei) {
                            tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                            pHnbnKknnFlgMap.put(joukenbunruiKey, false);
                        }
                    }
                }
            }
        }
        hanteiKekkaBean.setUpdateKbn(C_UmuKbn.NONE);

        if (tyohyouHonbanKakuninBeanList.size() > 0) {

            hanteiKekkaBean.setTyohyouHonbanKakuninBeanList(tyohyouHonbanKakuninBeanList);
            hanteiKekkaBean.setUpdateKbn(C_UmuKbn.ARI);
        }

        hanteiKekkaBean.setTyouhyouHnbnKknnFlgMap(pHnbnKknnFlgMap);

        logger.debug("△ 帳票本番確認 外貨建顧客通知作成 判定 終了");

        return hanteiKekkaBean;
    }

    public HanteiKekkaKokyakuTuutiSksBean hanteiByCount(
        List<TyohyouHonbanKakuninBean> pJyoukenList, HashMap<String, Integer> pHnbnKknnCntMap,
        IT_KykKihon pKhKykKihon, IT_KykSyouhn pKhKykSyouhn, ZT_GaikaKokyakuTuutiTy pKhGikKkykTutiTy) {

        logger.debug("▽ 帳票本番確認 外貨建顧客通知作成 判定（回送件数管理） 開始");

        HanteiKekkaKokyakuTuutiSksBean hanteiKekkaBean = SWAKInjector.getInstance(HanteiKekkaKokyakuTuutiSksBean.class);
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = new ArrayList<>();

        for (TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean : pJyoukenList) {

            String joukenbunruiKey = tyohyouHonbanKakuninBean.getJyoukenbunrui1() +
                tyohyouHonbanKakuninBean.getJyoukenbunrui2() + tyohyouHonbanKakuninBean.getJyoukenbunrui3();
            logger.debug("   帳票本番確認 判定条件 条件：" + joukenbunruiKey);

            String syono = pKhKykKihon.getSyono();
            int kaisouCnt = 0;
            boolean kousinHantei = false;

            if (JYOUKENBUNRUI1_010.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                int syohinHanteiKbn = SyouhinUtil.henkouKubetuHantei(pKhKykSyouhn.getSyouhncd());

                if(pHnbnKknnCntMap.containsKey(joukenbunruiKey)) {
                    kaisouCnt = pHnbnKknnCntMap.get(joukenbunruiKey);
                }

                kousinHantei = check010_001_5(syono, syohinHanteiKbn, joukenbunruiKey, kaisouCnt);

                if (kousinHantei){
                    pHnbnKknnCntMap.put(joukenbunruiKey, kaisouCnt + 1);
                    tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                }
            }
            if (JYOUKENBUNRUI1_020.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if(pHnbnKknnCntMap.containsKey(joukenbunruiKey)) {
                    kaisouCnt = pHnbnKknnCntMap.get(joukenbunruiKey);
                }

                kousinHantei = check020_001_5(syono, pKhGikKkykTutiTy, joukenbunruiKey, kaisouCnt);

                if (kousinHantei){
                    pHnbnKknnCntMap.put(joukenbunruiKey, kaisouCnt + 1);
                    tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                }
            }
        }
        hanteiKekkaBean.setUpdateKbn(C_UmuKbn.NONE);

        if (tyohyouHonbanKakuninBeanList.size() > 0) {

            hanteiKekkaBean.setTyohyouHonbanKakuninBeanList(tyohyouHonbanKakuninBeanList);
            hanteiKekkaBean.setUpdateKbn(C_UmuKbn.ARI);
        }

        hanteiKekkaBean.setTyouhyouHnbnKknnCntMap(pHnbnKknnCntMap);

        logger.debug("△ 帳票本番確認 外貨建顧客通知作成 判定（回送件数管理） 終了");

        return hanteiKekkaBean;
    }

    protected boolean check010_001_5(String pSyono, int pSyohinHanteiKbn, String pJoukenbunruiKey, Integer pKaisouCnt) {
        boolean kousinHantei = false;

        if((((JYOUKENBUNRUI1_010+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_001).equals(pJoukenbunruiKey) && SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUMAE == pSyohinHanteiKbn ) ||
            ((JYOUKENBUNRUI1_010+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_002).equals(pJoukenbunruiKey) && SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_YENHENKOUGO == pSyohinHanteiKbn ) ||
            ((JYOUKENBUNRUI1_010+JYOUKENBUNRUI2_002+JYOUKENBUNRUI3_001).equals(pJoukenbunruiKey) && SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUMAE == pSyohinHanteiKbn ) ||
            ((JYOUKENBUNRUI1_010+JYOUKENBUNRUI2_002+JYOUKENBUNRUI3_002).equals(pJoukenbunruiKey) && SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_YENHENKOUGO == pSyohinHanteiKbn ) ||
            ((JYOUKENBUNRUI1_010+JYOUKENBUNRUI2_004+JYOUKENBUNRUI3_001).equals(pJoukenbunruiKey) && SyouhinUtil.HENKOUKUBETU_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19_YENHENKOUMAE == pSyohinHanteiKbn )) &&
            pKaisouCnt < KAISOUCNT_5 ){
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }
        return kousinHantei;
    }

    protected boolean check020_001_5(String pSyono, ZT_GaikaKokyakuTuutiTy pKhGikKkykTutiTy, String pJoukenbunruiKey, Integer pKaisouCnt) {
        boolean kousinHantei = false;

        if((((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_001).equals(pJoukenbunruiKey) && "01".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_002).equals(pJoukenbunruiKey) && "02".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_003).equals(pJoukenbunruiKey) && "03".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_004).equals(pJoukenbunruiKey) && "04".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_005).equals(pJoukenbunruiKey) && "05".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_006).equals(pJoukenbunruiKey) && "06".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_007).equals(pJoukenbunruiKey) && "07".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_008).equals(pJoukenbunruiKey) && "08".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_009).equals(pJoukenbunruiKey) && "09".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) ) ||
            ((JYOUKENBUNRUI1_020+JYOUKENBUNRUI2_001+JYOUKENBUNRUI3_010).equals(pJoukenbunruiKey) && "10".equals(pKhGikKkykTutiTy.getZtykoktuutireportlayoutptn()) )) &&
            pKaisouCnt < KAISOUCNT_5 ){
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }
        return kousinHantei;
    }

    protected boolean check070001003(String pSyono, IT_KykKihon pKykKihon, String pJoukenbunruiKey,
        HashMap<String, Boolean> pHnbnKknnFlgMap) {
        boolean kousinHantei = false;

        if (C_TkiktbrisyuruiKbn.NONE.eq(pKykKihon.getTikiktbrisyuruikbn()) &&
            pHnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }
        return kousinHantei;
    }

    protected boolean check070001004(String pSyono, IT_KykKihon pKykKihon, String pJoukenbunruiKey,
        HashMap<String, Boolean> pHnbnKknnFlgMap) {
        boolean kousinHantei = false;

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) &&
            pHnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }
        return kousinHantei;
    }

    protected boolean check070001005(String pSyono, IT_KykKihon pKykKihon, ZT_GaikaKokyakuTuutiTy pGikKkykTutiTy,
        String pJoukenbunruiKey, HashMap<String, Boolean> pHnbnKknnFlgMap) {
        boolean kousinHantei = false;
        if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) &&
            C_UmuKbn.NONE.toString().equals(pGikKkykTutiTy.getZtyzennouumu()) &&
            pHnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }
        return kousinHantei;
    }

    protected boolean check070001006(String pSyono, IT_KykKihon pKykKihon, ZT_GaikaKokyakuTuutiTy pGikKkykTutiTy,
        String pJoukenbunruiKey, HashMap<String, Boolean> pHnbnKknnFlgMap) {
        boolean kousinHantei = false;

        if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) &&
            C_UmuKbn.ARI.toString().equals(pGikKkykTutiTy.getZtyzennouumu()) &&
            pHnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }

        return kousinHantei;
    }

    protected boolean check070001007(String pSyono, IT_KykSonotaTkyk pKykSonotaTkyk, ZT_GaikaKokyakuTuutiTy pGikKkykTutiTy,
        String pJoukenbunruiKey, HashMap<String, Boolean> pHnbnKknnFlgMap, C_UmuKbn pGengakuUmu) {
        boolean kousinHantei = false;

        if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getZeiseitkkktkykhukaumu()) &&
            LAYOUTPATTERN_DUO.equals(pGikKkykTutiTy.getZtykoktuutireportlayoutptn()) &&
            C_UmuKbn.ARI.eq(pGengakuUmu) &&
            pHnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }

        return kousinHantei;
    }

    protected boolean check070001008(String pSyono, IT_KykSonotaTkyk pKykSonotaTkyk, ZT_GaikaKokyakuTuutiTy pGikKkykTutiTy,
        String pJoukenbunruiKey, HashMap<String, Boolean> pHnbnKknnFlgMap, C_UmuKbn pGengakuUmu) {
        boolean kousinHantei = false;

        if (C_UmuKbn.NONE.eq(pKykSonotaTkyk.getZeiseitkkktkykhukaumu()) &&
            LAYOUTPATTERN_DUO.equals(pGikKkykTutiTy.getZtykoktuutireportlayoutptn()) &&
            C_UmuKbn.ARI.eq(pGengakuUmu) &&
            pHnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }

        return kousinHantei;
    }

    protected boolean check070001009(String pSyono, IT_KykSonotaTkyk pKykSonotaTkyk,
        ZT_GaikaKokyakuTuutiTy pGikKkykTutiTy, String pJoukenbunruiKey, HashMap<String, Boolean> pHnbnKknnFlgMap) {
        boolean kousinHantei = false;

        if (LAYOUTPATTERN_DUO.equals(pGikKkykTutiTy.getZtykoktuutireportlayoutptn()) &&
            C_UmuKbn.NONE.toString().equals(pGikKkykTutiTy.getZtygengkumu()) &&
            pHnbnKknnFlgMap.get(pJoukenbunruiKey)==null) {
            kousinHantei = true;
            logger.info(MessageUtil.getMessage(MessageId.IIF1017, pJoukenbunruiKey, pSyono));
        }

        return kousinHantei;
    }
}
