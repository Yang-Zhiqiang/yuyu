package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;

/**
 * 契約保全 契約保全共通 帳票本番確認手続完了通知判定
 */
public class CheckTyohyouHnbnKknTtdkKanryou {

    public static final String JYOUKENBUNRUI1_SUBETE = "010";

    public static final String JYOUKENBUNRUI1_KASUKEDO = "020";

    public static final String JYOUKENBUNRUI1_YENDTHNKKYK_KASUKEDO = "030";

    public static final String JYOUKENBUNRUI1_DELYUO = "040";

    public static final String JYOUKENBUNRUI1_KJNNKPZEITEKITK = "050";

    public static final String JYOUKENBUNRUI1_YENDTHNKKYK_k2 = "060";

    public static final String JYOUKENBUNRUI1_JGKAITEI = "070";

    public static final String JYOUKENBUNRUI1_KZKTRKTUTKBN = "080";

    public static final String JYOUKENBUNRUI1_GAUDEIGG = "090";

    public static final String JYOUKENBUNRUI1_KAZOKUTR = "100";

    public static final String JYOUKENBUNRUI1_JGKAITEI_YENDTHNK = "110";

    public static final String JYOUKENBUNRUI1_BORERO = "120";

    public static final String JYOUKENBUNRUI2_KYKOMTTUTKBN_01 = "001";

    public static final String JYOUKENBUNRUI2_KYKOMTTUTKBN_02 = "002";

    public static final String JYOUKENBUNRUI2_KYKOMTTUTKBN_03 = "003";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN1_01 = "004";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN2_01 = "005";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN1_02 = "006";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN2_02 = "007";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN1_03 = "008";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN2_03 = "009";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN1_04 = "010";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN2_04 = "011";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN1_05 = "012";

    public static final String JYOUKENBUNRUI2_KZKOMTTUTKBN2_05 = "013";

    public static final String JYOUKENBUNRUI2_HHKOMTTUTKBN_01 = "014";

    public static final String JYOUKENBUNRUI2_HHKOMTTUTKBN_02 = "015";

    public static final String JYOUKENBUNRUI2_KYKURTUTKBN_01 = "016";

    public static final String JYOUKENBUNRUI2_KYKURTUTKBN_02 = "017";

    public static final String JYOUKENBUNRUI2_KYKURTUTKBN_03 = "018";

    public static final String JYOUKENBUNRUI2_KZKURTUTKBN1_01 = "019";

    public static final String JYOUKENBUNRUI2_KZKURTUTKBN2_01 = "020";

    public static final String KZKTRKTUTKBN_KBN_01 = "01";

    public static final String KZKTRKTUTKBN_KBN_02 = "02";

    public static final String KZKTRKTUTKBN_KBN_03 = "03";

    public static final String KZKTRKTUTKBN_KBN_04 = "04";

    public static final String KZKTRKTUTKBN_KBN_05 = "05";

    @Inject
    private static Logger logger = LoggerFactory.getLogger(CheckTyohyouHnbnKknTtdkKanryou.class);

    public static HanteiKekkaBean exec(IT_KykKihon pKykKihon, IT_TtdkKan pTtdkKan,
        List<TyohyouHonbanKakuninBean> pJyoukenList) {

        logger.debug("▽ 帳票本番確認手続完了通知判定 開始");

        HanteiKekkaBean hanteiKekkaBean = SWAKInjector.getInstance(HanteiKekkaBean.class);
        List<TyohyouHonbanKakuninBean> tyohyouHonbanKakuninBeanList = new ArrayList<>();

        for (TyohyouHonbanKakuninBean tyohyouHonbanKakuninBean : pJyoukenList) {

            C_SyoruiCdKbn syoruiCdMasuta = tyohyouHonbanKakuninBean.getSyoruiCd();
            C_SyoruiCdKbn syoruiCd = pTtdkKan.getSyoruiCd();

            if (JYOUKENBUNRUI1_SUBETE.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {

                if ((C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_STDRHNK_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR.eq(syoruiCdMasuta)) &&
                    syoruiCdMasuta.eq(syoruiCd)) {

                    tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                }
            }
            if (JYOUKENBUNRUI1_KASUKEDO.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if ((C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR.eq(syoruiCdMasuta)) &&
                    syoruiCdMasuta.eq(syoruiCd)) {

                    boolean kousinHantei = check020(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }
            if (JYOUKENBUNRUI1_YENDTHNKKYK_KASUKEDO.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if ((C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR.eq(syoruiCdMasuta)) &&
                    syoruiCdMasuta.eq(syoruiCd)) {

                    boolean kousinHantei = check030(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }
            if (JYOUKENBUNRUI1_DELYUO.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if ((C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCdMasuta)) &&
                    syoruiCdMasuta.eq(syoruiCd)) {
                    boolean kousinHantei = check040(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }
            if (JYOUKENBUNRUI1_KJNNKPZEITEKITK.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if (C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR.eq(syoruiCdMasuta) &&
                    syoruiCdMasuta.eq(syoruiCd)) {
                    boolean kousinHantei = check050(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }
            if (JYOUKENBUNRUI1_YENDTHNKKYK_k2.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if ((C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR.eq(syoruiCdMasuta)) &&
                    syoruiCdMasuta.eq(syoruiCd)) {

                    boolean kousinHantei = check060(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }
            if (JYOUKENBUNRUI1_JGKAITEI.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if (C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCdMasuta) &&
                    syoruiCdMasuta.eq(syoruiCd)) {

                    boolean kousinHantei = check070(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if(JYOUKENBUNRUI1_KZKTRKTUTKBN.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())){
                if((C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR.eq(syoruiCdMasuta) && syoruiCdMasuta.eq(syoruiCd)) ||
                    (C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR.eq(syoruiCdMasuta) && syoruiCdMasuta.eq(syoruiCd))){

                    boolean kousinHantei = check080(tyohyouHonbanKakuninBean, pTtdkKan);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if (JYOUKENBUNRUI1_GAUDEIGG.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if (C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCdMasuta) &&
                    syoruiCdMasuta.eq(syoruiCd)) {

                    boolean kousinHantei = check090(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if (JYOUKENBUNRUI1_KAZOKUTR.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if (C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR.eq(syoruiCdMasuta) &&
                    syoruiCdMasuta.eq(syoruiCd)) {

                    BizDate mosYmd = pKykKihon.getMosymd();

                    if (BizDateUtil.compareYmd(mosYmd, BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(mosYmd, BizDate.valueOf("20201001")) == BizDateUtil.COMPARE_EQUAL) {

                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if (JYOUKENBUNRUI1_JGKAITEI_YENDTHNK.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if((C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2.eq(syoruiCdMasuta) && syoruiCdMasuta.eq(syoruiCd)) ||
                    (C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3.eq(syoruiCdMasuta) && syoruiCdMasuta.eq(syoruiCd))){

                    boolean kousinHantei = check110(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }

            if (JYOUKENBUNRUI1_BORERO.equals(tyohyouHonbanKakuninBean.getJyoukenbunrui1())) {
                if((C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_GENGAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR.eq(syoruiCdMasuta) ||
                    C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR.eq(syoruiCdMasuta)) &&
                    syoruiCdMasuta.eq(syoruiCd)){

                    boolean kousinHantei = check120(pKykKihon);

                    if (kousinHantei) {
                        tyohyouHonbanKakuninBeanList.add(tyohyouHonbanKakuninBean);
                    }
                }
            }
        }
        hanteiKekkaBean.setUpdateKbn(C_UmuKbn.NONE);

        if (tyohyouHonbanKakuninBeanList.size() > 0) {

            hanteiKekkaBean.setTyohyouHonbanKakuninBeanList(tyohyouHonbanKakuninBeanList);
            hanteiKekkaBean.setUpdateKbn(C_UmuKbn.ARI);
        }

        logger.debug("△ 帳票本番確認手続完了通知判定 終了");

        return hanteiKekkaBean;
    }

    protected static boolean check020(IT_KykKihon pKykKihon){

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();
        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            kousinHantei = true;
        }
        return kousinHantei;
    }

    protected static boolean check030(IT_KykKihon pKykKihon){

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();
        BizDate yendthnkYmd = kykSyouhn.getYendthnkymd();
        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR && yendthnkYmd != null) {

            kousinHantei = true;
        }
        return kousinHantei;
    }

    protected static boolean check040(IT_KykKihon pKykKihon) {
        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();
        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
            kousinHantei = true;
        }
        return kousinHantei;
    }

    protected static boolean check050(IT_KykKihon pKykKihon) {
        IT_KykSonotaTkyk kykSonotaTkyk= pKykKihon.getKykSonotaTkyks().get(0);
        boolean kousinHantei = false;

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {
            kousinHantei = true;
        }
        return kousinHantei;
    }

    protected static boolean check060(IT_KykKihon pKykKihon){

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();
        BizDate yendthnkYmd = kykSyouhn.getYendthnkymd();
        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR && yendthnkYmd != null) {

            kousinHantei = true;
        }
        return kousinHantei;
    }

    protected static boolean check070(IT_KykKihon pKykKihon){

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();
        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            kousinHantei = true;
        }
        return kousinHantei;
    }

    protected static boolean check080(TyohyouHonbanKakuninBean pTyohyouHonbanKakuninBean,IT_TtdkKan pTtdkKan){

        String jyoukenbunrui2 = pTyohyouHonbanKakuninBean.getJyoukenbunrui2();

        boolean kousinHantei = false;

        if(JYOUKENBUNRUI2_KYKOMTTUTKBN_01.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_01.equals(pTtdkKan.getKykomttutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KYKOMTTUTKBN_02.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_02.equals(pTtdkKan.getKykomttutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KYKOMTTUTKBN_03.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_03.equals(pTtdkKan.getKykomttutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN1_01.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_01.equals(pTtdkKan.getKzkomttutkbn1())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN2_01.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_01.equals(pTtdkKan.getKzkomttutkbn2())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN1_02.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_02.equals(pTtdkKan.getKzkomttutkbn1())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN2_02.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_02.equals(pTtdkKan.getKzkomttutkbn2())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN1_03.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_03.equals(pTtdkKan.getKzkomttutkbn1())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN2_03.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_03.equals(pTtdkKan.getKzkomttutkbn2())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN1_04.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_04.equals(pTtdkKan.getKzkomttutkbn1())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN2_04.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_04.equals(pTtdkKan.getKzkomttutkbn2())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN1_05.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_05.equals(pTtdkKan.getKzkomttutkbn1())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKOMTTUTKBN2_05.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_05.equals(pTtdkKan.getKzkomttutkbn2())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_HHKOMTTUTKBN_01.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_01.equals(pTtdkKan.getHhkomttutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_HHKOMTTUTKBN_02.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_02.equals(pTtdkKan.getHhkomttutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KYKURTUTKBN_01.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_01.equals(pTtdkKan.getKykurtutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KYKURTUTKBN_02.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_02.equals(pTtdkKan.getKykurtutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KYKURTUTKBN_03.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_03.equals(pTtdkKan.getKykurtutkbn())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKURTUTKBN1_01.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_01.equals(pTtdkKan.getKzkurtutkbn1())){

                kousinHantei = true;
            }
        }

        if(JYOUKENBUNRUI2_KZKURTUTKBN2_01.equals(jyoukenbunrui2)){
            if(KZKTRKTUTKBN_KBN_01.equals(pTtdkKan.getKzkurtutkbn2())){

                kousinHantei = true;
            }
        }

        return kousinHantei;

    }

    protected static boolean check090(IT_KykKihon pKykKihon){

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();
        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            kousinHantei = true;
        }
        return kousinHantei;
    }

    protected static boolean check110(IT_KykKihon pKykKihon){

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

    protected static boolean check120(IT_KykKihon pKykKihon){

        IT_KykSyouhn kykSyouhn = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        String syouhnCd = kykSyouhn.getSyouhncd();
        boolean kousinHantei = false;

        int syohinHanteiKbn = SyouhinUtil.hantei(syouhnCd);

        if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ) {

            kousinHantei = true;
        }
        return kousinHantei;
    }
}
