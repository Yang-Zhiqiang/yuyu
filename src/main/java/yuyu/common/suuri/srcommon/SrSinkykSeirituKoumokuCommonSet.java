package yuyu.common.suuri.srcommon;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.SetManryoubi;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KknsmnKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriPWaribikitekiyouKbn;
import yuyu.def.classification.C_SuuriRyourituKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;

/**
 * 新契約成立項目共通設定
 */
public class SrSinkykSeirituKoumokuCommonSet {

    @Inject
    private static Logger logger;

    private static final int RENBAN1 = 1;
    private static final int RENBAN2 = 2;
    private static final String KETUGOUFILERENBAN1 = "1";
    private static final String KETUGOUFILERENBAN2 = "2";
    private static final String KETUGOUFILERENBAN3 = "3";
    private static final String KETUGOUFILERENBAN4 = "4";
    private static final String KETUGOUFILERENBAN5 = "5";
    private static final String KETUGOUFILERENBAN6 = "6";
    private static final String HONSYAKOUMOSI = "1";
    private static final String JYUUTOUSYOURYAKUKBN_GINKOUMADOHANNYUUKINSUKIIMUNONYUUKIN = "21";
    private static final String KEIYAKUSYASYOKUGYOUCD_SETTEINASI = "999";
    private static final String SEIKEIKEIROKBN_SONOHOKA = "90";
    private static final String TUUSINSAKIJYUUSYOKBN_SONOHOKA = "0";
    private static final String NENDOMATU0331 = "0331";
    private static final int GETU04 = 4;
    private static final int NEN = 1;

    boolean errorFlag;

    public SrSinkykSeirituKoumokuCommonSet() {
        super();
        errorFlag = false;
    }

    public boolean exec(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        HT_MosSyouhn pMossyouhn,
        List<HT_MosDairiten> pMosdairitenList,
        IT_KykUkt pKykukt,
        HT_Nyuukin pNyuukinMax,
        HT_Nyuukin pNyuukinMin,
        BM_SyouhnZokusei pSyouhnzokusei,
        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList,
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList,
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList,
        SinkeiyakuSeiritu1Param pSinkeiyakuseiritu1param,
        SinkeiyakuSeiritu2Param pSinkeiyakuseiritu2param,
        SinkeiyakuSeiritu3Param pSinkeiyakuseiritu3param,
        SinkeiyakuSeiritu4Param pSinkeiyakuseiritu4param,
        SinkeiyakuSeiritu5Param pSinkeiyakuseiritu5param,
        SinkeiyakuSeiritu6Param pSinkeiyakuseiritu6param,
        int pSyohinHanteiKbn,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        List<BT_DenpyoData> pDenpyoDataList
        ) {

        SrBoshuuDairiBean pSrboshuudairibean = setBosyuunindairitenjyouhou(pSrsinkykseiritucommonparam,
            pSinkeiyakuseirituinfoparam, pMosdairitenList);

        editKetugoukoumoku(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, pSinkeiyakuseiritu1param,
            pSinkeiyakuseiritu2param, pSinkeiyakuseiritu3param, pSinkeiyakuseiritu4param, pSinkeiyakuseiritu5param,
            pSinkeiyakuseiritu6param);

        editSinkeiyakuseiritu1(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, pMossyouhn,
            pSrboshuudairibean, pSinkeiyakuseiritu1param, pSyohinHanteiKbn, pDenpyoDataList);

        editSinkeiyakuseiritu2(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, pMossyouhn, pKykukt,
            pNyuukinMax, pSyouhnzokusei, pSinkeiyakuseiritu2param, pSyohinHanteiKbn);

        editSinkeiyakuseiritu3(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, pSrboshuudairibean,
            pSinkeiyakuseiritu3param);

        editSinkeiyakuseiritu4(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, pSinkeiyakuseiritu4param);

        editSinkeiyakuseiritu5(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, pMossyouhn,
            pSrboshuudairibean, pSinkeiyakuseiritu5param);

        editSinkeiyakuseiritu6(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, pMossyouhn, pNyuukinMin,
            pSyouhnzokusei, khHenkouRirekiBeanList,
            targetTokuyakuMokuhyoutiHistoryBeanList, targetTokuyakuKijyunKingakuHistoryBeanList, pSinkeiyakuseiritu6param,
            pSyohinHanteiKbn, pKhSisuurendoTmttkn);

        return errorFlag;
    }

    private SrBoshuuDairiBean setBosyuunindairitenjyouhou(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        List<HT_MosDairiten> pMosdairitenList
        ) {


        SrSuuriKbnHenkanSet srKbnHenkan = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean;

        SrBoshuuDairiBean srBoshuuDairiBean = SWAKInjector.getInstance(SrBoshuuDairiBean.class);


        for (HT_MosDairiten mosDairiten : pMosdairitenList) {

            if (mosDairiten.getRenno() == RENBAN1) {

                srBoshuuDairiBean.setaAtsukaishaSoshikiCd(mosDairiten.getDrtenkanrisosikicd());
                srBoshuuDairiBean.setaAtukaiKojinCd(mosDairiten.getDaibosyuucd());
                srBoshuuDairiBean.setaAtukaisyaDirtnBsynnHyj(SrCommonConstants.HYOUJI_ARI);
                srBoshuuDairiBean.setDirtnAAtukaisyaKojinCd(mosDairiten.getBosyuucd());
                srBoshuuDairiBean.setaAtukaisyaBosyuuDirtnCd(mosDairiten.getTratkiagcd());
                srBoshuuDairiBean.setaAtukaisyaSisyaCd(mosDairiten.getDrtenkanrisosikicd().substring(0, 3));
                srBoshuuDairiBean.setCifCd(mosDairiten.getCifcd());

                srSuuriKbnHenkanBean = srKbnHenkan.exec(C_SrKbnHenkanKbn.DAIRITENGYOUSYU, mosDairiten.getTratkiagcd());
                if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                    String message = MessageUtil.getMessage(
                        MessageId.ESA1002,
                        C_SrKbnHenkanKbn.DAIRITENGYOUSYU.getContent(),
                        pSinkeiyakuseirituinfoparam.getSyono(),
                        mosDairiten.getTratkiagcd()
                        );
                    errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
                }
                else {
                    srBoshuuDairiBean.setBosyuuDairitenGyousyuKbn(srSuuriKbnHenkanBean.getHenkanAtoKbn());
                }

                srSuuriKbnHenkanBean = srKbnHenkan.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI, mosDairiten.getTratkiagcd());
                if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {
                    String message = MessageUtil.getMessage(
                        MessageId.ESA1002,
                        C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                        pSinkeiyakuseirituinfoparam.getSyono(),
                        mosDairiten.getTratkiagcd()
                        );
                    errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
                }
                else {
                    srBoshuuDairiBean.setBosyuuKeitaiKbn(srSuuriKbnHenkanBean.getHenkanAtoKbn());
                }

            }
            else if (mosDairiten.getRenno() == RENBAN2) {

                srBoshuuDairiBean.setbAtsukaishaSoshikiCd(mosDairiten.getDrtenkanrisosikicd());
                srBoshuuDairiBean.setbAtukaiKojinCd(mosDairiten.getDaibosyuucd());
                srBoshuuDairiBean.setbAtukaisyaDirtnBsynnHyj(SrCommonConstants.HYOUJI_ARI);
                srBoshuuDairiBean.setDirtnBAtukaisyaKojinCd(mosDairiten.getBosyuucd());
                srBoshuuDairiBean.setbAtukaisyaBosyuuDirtnCd(mosDairiten.getTratkiagcd());
            }
        }

        return srBoshuuDairiBean;
    }

    private void editKetugoukoumoku(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        SinkeiyakuSeiritu1Param pSinkeiyakuseiritu1param,
        SinkeiyakuSeiritu2Param pSinkeiyakuseiritu2param,
        SinkeiyakuSeiritu3Param pSinkeiyakuseiritu3param,
        SinkeiyakuSeiritu4Param pSinkeiyakuseiritu4param,
        SinkeiyakuSeiritu5Param pSinkeiyakuseiritu5param,
        SinkeiyakuSeiritu6Param pSinkeiyakuseiritu6param
        ) {

        pSinkeiyakuseiritu1param.setZtyktgysyrymd(pSrsinkykseiritucommonparam.getSyoriYmd().toString());
        pSinkeiyakuseiritu1param.setZtyktgysyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu1param.setZtyktgyfilerenno(KETUGOUFILERENBAN1);

        pSinkeiyakuseiritu2param.setZtyktgysyrymd(pSrsinkykseiritucommonparam.getSyoriYmd().toString());
        pSinkeiyakuseiritu2param.setZtyktgysyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu2param.setZtyktgyfilerenno(KETUGOUFILERENBAN2);

        pSinkeiyakuseiritu3param.setZtyktgysyrymd(pSrsinkykseiritucommonparam.getSyoriYmd().toString());
        pSinkeiyakuseiritu3param.setZtyktgysyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu3param.setZtyktgyfilerenno(KETUGOUFILERENBAN3);

        pSinkeiyakuseiritu4param.setZtyktgysyrymd(pSrsinkykseiritucommonparam.getSyoriYmd().toString());
        pSinkeiyakuseiritu4param.setZtyktgysyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu4param.setZtyktgyfilerenno(KETUGOUFILERENBAN4);

        pSinkeiyakuseiritu5param.setZtyktgysyrymd(pSrsinkykseiritucommonparam.getSyoriYmd().toString());
        pSinkeiyakuseiritu5param.setZtyktgysyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu5param.setZtyktgyfilerenno(KETUGOUFILERENBAN5);

        pSinkeiyakuseiritu6param.setZtyktgysyrymd(pSrsinkykseiritucommonparam.getSyoriYmd().toString());
        pSinkeiyakuseiritu6param.setZtyktgysyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu6param.setZtyktgyfilerenno(KETUGOUFILERENBAN6);

        return;
    }

    private void editSinkeiyakuseiritu1(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        HT_MosSyouhn pMossyouhn,
        SrBoshuuDairiBean pSrboshuudairibean,
        SinkeiyakuSeiritu1Param pSinkeiyakuseiritu1param,
        int pSyohinHanteiKbn,
        List<BT_DenpyoData> pDenpyoDataList
        ) {


        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean;
        String kykHhknDouHyouji = "";
        String kigetuSmkrgKykHyj = "";
        String keiyakubiSiteiHyouji = "";
        String tokuninHyouji = "";
        String keiyakuKakuninSyuruikbn = "";
        String hensyuuKeiyakusyamei = "";
        String hnsyuknjKyksynm = "";
        BizDate kykSeiymd = null;
        String kyksyaSeikbn = "";
        int kykNen = 0;
        String saimnkKykhyj = "";
        String hrkkaisuuKbn = "";
        String hrkkeiroKbn = "";
        String ryouritukbn = "";



        BizCurrency kihons = pMossyouhn.getSeitoukihons();
        BizCurrency sibous = pMossyouhn.getSyutkp();

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            kihons = BizCurrency.valueOf(0);
            sibous = BizCurrency.valueOf(0);
        }

        BizCurrency syokaiHaraikomiP = pSinkeiyakuseirituinfoparam.getHyouteip();

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            syokaiHaraikomiP = pSinkeiyakuseirituinfoparam.getHeijyunp();
        }

        BizCurrency syuuKykP = pMossyouhn.getSyutkp();

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            syuuKykP = pMossyouhn.getHrktuukasyutkp();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KAISUU, pSinkeiyakuseirituinfoparam.getHrkkaisuu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pSinkeiyakuseirituinfoparam.getHrkkaisuu().getValue()
                );

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {

            hrkkaisuuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KEIRO, pSinkeiyakuseirituinfoparam.getHrkkeiro().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.HRK_KEIRO.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pSinkeiyakuseirituinfoparam.getHrkkeiro().getValue()
                );

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {

            hrkkeiroKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_Hrkkaisuu.ITIJI.eq(pSinkeiyakuseirituinfoparam.getHrkkaisuu()) ||
                C_Hrkkaisuu.NEN.eq(pSinkeiyakuseirituinfoparam.getHrkkaisuu()) ||
                C_Hrkkaisuu.HALFY.eq(pSinkeiyakuseirituinfoparam.getHrkkaisuu())) {
            ryouritukbn = C_SuuriRyourituKbn.OTHER.getValue();
        }
        else {
            if (C_Hrkkeiro.HURIKAE.eq(pSinkeiyakuseirituinfoparam.getHrkkeiro())) {
                ryouritukbn = C_SuuriRyourituKbn.OTHER.getValue();
            }
            else if (C_Hrkkeiro.KOUHURI.eq(pSinkeiyakuseirituinfoparam.getHrkkeiro())) {
                ryouritukbn = C_SuuriRyourituKbn.KOUHURI.getValue();
            }
            else if (C_Hrkkeiro.CREDIT.eq(pSinkeiyakuseirituinfoparam.getHrkkeiro())) {
                ryouritukbn = C_SuuriRyourituKbn.CREDIT.getValue();
            }
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU, pSinkeiyakuseirituinfoparam.getKykkbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pSinkeiyakuseirituinfoparam.getKykkbn().getValue()
                );

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {

            kykHhknDouHyouji = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (BizDateUtil.compareYm(pSinkeiyakuseirituinfoparam.getSeisekiym(), pSinkeiyakuseirituinfoparam.getMosym()) ==
            BizDateUtil.COMPARE_GREATER) {

            kigetuSmkrgKykHyj = SrCommonConstants.HYOUJI_ARI;

        }
        else {

            BizDate mosYmd = BizDate.valueOf(pSinkeiyakuseirituinfoparam.getMosym().addMonths(1), 1).addBusinessDays(
                - SrCommonConstants.DAY_1D);

            if (BizDateUtil.compareYmd(pSinkeiyakuseirituinfoparam.getSrsyoriymd(), mosYmd) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(pSinkeiyakuseirituinfoparam.getSrsyoriymd(), mosYmd) == BizDateUtil.COMPARE_EQUAL) {

                kigetuSmkrgKykHyj = SrCommonConstants.HYOUJI_NASI;
            }
            else {

                kigetuSmkrgKykHyj = SrCommonConstants.HYOUJI_ARI;
            }
        }

        if (pSinkeiyakuseirituinfoparam.getSkykymd() != null) {

            keiyakubiSiteiHyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            keiyakubiSiteiHyouji = SrCommonConstants.HYOUJI_NASI;
        }

        if (C_SpgndtknKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getSpgndtknkbn()) ||
            C_NenkkntknKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getNenkkntknkbn()) ||
            C_TsngndtknKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getTsngndtknkbn()) ||
            C_SentakuinfotknKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getSentakuinfotknkbn()) ||
            C_SignalkaihiKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getSignalkaihikbn()) ||
            C_SonotaTokuninKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getSonotatknkbn()) ||
            C_KakoymdkyytknKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getKakoymdkyytknkbn()) ||
            C_SaiteiptknKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getSaiteiptknkbn())) {

            tokuninHyouji = SrCommonConstants.HYOUJI_ARI;
        }

        if(pSinkeiyakuseirituinfoparam.getKykkaksyrui() != null) {

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU,
                pSinkeiyakuseirituinfoparam.getKykkaksyrui().getValue());

            if(C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1002,
                    C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU.getContent(),
                    pSinkeiyakuseirituinfoparam.getSyono(),
                    pSinkeiyakuseirituinfoparam.getKykkaksyrui().getValue()
                    );

                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {

                keiyakuKakuninSyuruikbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }

        String aAtukaisyaSisyaCd = pSrboshuudairibean.getaAtukaisyaSisyaCd();
        String aAtsukaishaSoshikiCd = pSrboshuudairibean.getaAtsukaishaSoshikiCd();
        String aAtukaiKojinCd = pSrboshuudairibean.getaAtukaiKojinCd();
        String bAtukaiSosikiCd = pSrboshuudairibean.getbAtsukaishaSoshikiCd();
        String bAtukaiKojinCd = pSrboshuudairibean.getbAtukaiKojinCd();

        if (C_KykKbn.KEIHI_DOUITU.eq(pSinkeiyakuseirituinfoparam.getKykkbn())) {

            hensyuuKeiyakusyamei= pSinkeiyakuseirituinfoparam.getHhknnmkn();
            hnsyuknjKyksynm= pSinkeiyakuseirituinfoparam.getHhknnmkj();
            kykSeiymd = pSinkeiyakuseirituinfoparam.getHhknseiymd();
            kyksyaSeikbn = pSinkeiyakuseirituinfoparam.getHhknsei().getValue();
            kykNen = pSinkeiyakuseirituinfoparam.getHhknnen();
        }
        else {

            hensyuuKeiyakusyamei= pSinkeiyakuseirituinfoparam.getKyknmkn();
            hnsyuknjKyksynm= pSinkeiyakuseirituinfoparam.getKyknmkj();
            kykSeiymd = pSinkeiyakuseirituinfoparam.getKykseiymd();
            kyksyaSeikbn = pSinkeiyakuseirituinfoparam.getKyksei().getValue();

            if(pSinkeiyakuseirituinfoparam.getKyknen() > 99) {

                kykNen = 0;
            }
            else {

                kykNen = pSinkeiyakuseirituinfoparam.getKyknen();
            }
        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(pMossyouhn.getHknkknsmnkbn())) {
            saimnkKykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimnkKykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        Integer znnkai = 0;
        if (pSinkeiyakuseirituinfoparam.getZnnkai() != 0) {

            znnkai = pSinkeiyakuseirituinfoparam.getZnnkai() + 1;
        }

        BizCurrency syonendoSyokaip = pSinkeiyakuseirituinfoparam.getHyouteip();
        BizCurrency syonendo2KaimeIkoup = BizCurrency.valueOf(0);
        BizCurrency jinendoIkoup = BizCurrency.valueOf(0);
        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            for (BT_DenpyoData denpyoData : pDenpyoDataList) {
                if (C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD.eq(denpyoData.getKanjyoukmkcd())) {
                    syonendoSyokaip = denpyoData.getDenyenkagk();
                }
                else if (C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD.eq(denpyoData.getKanjyoukmkcd())) {
                    syonendo2KaimeIkoup = denpyoData.getDenyenkagk();
                }
                else {
                    jinendoIkoup = denpyoData.getDenyenkagk();
                }
            }
        }

        String anniskcd = "";

        if (C_Hrkkeiro.CREDIT.eq(pSinkeiyakuseirituinfoparam.getHrkkeiro())) {

            anniskcd = SrCommonConstants.ANNISKCD_CREDITHR;
        }


        pSinkeiyakuseiritu1param.setZtysyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu1param.setZtyaatukaisyasisyacd(aAtukaisyaSisyaCd);
        pSinkeiyakuseiritu1param.setZtymosno(pSinkeiyakuseirituinfoparam.getMosno());
        pSinkeiyakuseiritu1param.setZtyhknsyukigou(pMossyouhn.getSyouhncd());
        pSinkeiyakuseiritu1param.setZtykykymd(pSinkeiyakuseirituinfoparam.getKykymd().toString());
        pSinkeiyakuseiritu1param.setZtyhknkkn(String.valueOf(pMossyouhn.getHknkkn()));
        pSinkeiyakuseiritu1param.setZtyphrkkikn(pMossyouhn.getHrkkkn().toString());
        pSinkeiyakuseiritu1param.setZtysaimnkkykhyj(saimnkKykhyj);
        pSinkeiyakuseiritu1param.setZtykihons(new BigDecimal(kihons.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu1param.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu1param.setZtysyokaiharaikomip(new BigDecimal(
            syokaiHaraikomiP.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu1param.setZtysyukeiyakup(new BigDecimal(syuuKykP.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu1param.setZtyhrkkaisuukbn(hrkkaisuuKbn);
        pSinkeiyakuseiritu1param.setZtyhrkkeirokbn(hrkkeiroKbn);
        pSinkeiyakuseiritu1param.setZtyryouritukbn(ryouritukbn);
        pSinkeiyakuseiritu1param.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pSinkeiyakuseiritu1param.setZtysdpdkbn(pSinkeiyakuseirituinfoparam.getSdpdkbn().getValue());
        pSinkeiyakuseiritu1param.setZtyanniskcd(anniskcd);
        pSinkeiyakuseiritu1param.setZtyduketorihouhoukbn(
            pSinkeiyakuseirituinfoparam.getHaitoukinuketorihoukbn().getValue());
        pSinkeiyakuseiritu1param.setZtykyksyhhknsydouituhyouji(kykHhknDouHyouji);
        pSinkeiyakuseiritu1param.setZtynenkinzeiseitokuyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pSinkeiyakuseiritu1param.setZtysyusseimaekanyuukykkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pSinkeiyakuseiritu1param.setZtykazokukeiyakuhyouji(SrCommonConstants.HYOUJI_NASI);
        pSinkeiyakuseiritu1param.setZtyjikokykhyj(SrCommonConstants.HYOUJI_NASI);
        pSinkeiyakuseiritu1param.setZtytuusyoumeisiyouhyouji(SrCommonConstants.HYOUJI_NASI);
        pSinkeiyakuseiritu1param.setZtysethokenkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pSinkeiyakuseiritu1param.setZtyteikeisyouhinkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pSinkeiyakuseiritu1param.setZtysykgycd(pSinkeiyakuseirituinfoparam.getHhknsykgycd());
        pSinkeiyakuseiritu1param.setZtyseisekiym(pSinkeiyakuseirituinfoparam.getSeisekiym().toString());
        pSinkeiyakuseiritu1param.setZtyaatukaisisyatodouhukencd(pSinkeiyakuseirituinfoparam.getDrtenkanritodoufukencd());
        pSinkeiyakuseiritu1param.setZtyaatukaisosikicd(aAtsukaishaSoshikiCd);
        pSinkeiyakuseiritu1param.setZtyaatukaikojincd(aAtukaiKojinCd);
        pSinkeiyakuseiritu1param.setZtybatukaisosikicd(bAtukaiSosikiCd);
        pSinkeiyakuseiritu1param.setZtybatukaisyakojincd(bAtukaiKojinCd);
        pSinkeiyakuseiritu1param.setZtysekininkaisiymd(pSinkeiyakuseirituinfoparam.getSknnkaisiymd().toString());
        pSinkeiyakuseiritu1param.setZtykigetusmkrgkykhyj(kigetuSmkrgKykHyj);
        pSinkeiyakuseiritu1param.setZtyhensyuusyoriymd(pSrsinkykseiritucommonparam.getSyoriYmd().toString());
        pSinkeiyakuseiritu1param.setZtykeiyakubisiteihyouji(keiyakubiSiteiHyouji);
        pSinkeiyakuseiritu1param.setZtytokuninhyouji(tokuninHyouji);
        pSinkeiyakuseiritu1param.setZtykeiyakusyasyokugyoucd(KEIYAKUSYASYOKUGYOUCD_SETTEINASI);
        pSinkeiyakuseiritu1param.setZtyseikeikeirokbn(SEIKEIKEIROKBN_SONOHOKA);
        pSinkeiyakuseiritu1param.setZtyhhknmei(pSinkeiyakuseirituinfoparam.getHhknnmkn());
        pSinkeiyakuseiritu1param.setZtyknjhhknmei(pSinkeiyakuseirituinfoparam.getHhknnmkj());
        pSinkeiyakuseiritu1param.setZtyhhknseiymd(pSinkeiyakuseirituinfoparam.getHhknseiymd().toString());
        pSinkeiyakuseiritu1param.setZtyhhknseikbn(pSinkeiyakuseirituinfoparam.getHhknsei().getValue());
        pSinkeiyakuseiritu1param.setZtyhihokensyaagev2(String.valueOf(pSinkeiyakuseirituinfoparam.getHhknnen()));
        pSinkeiyakuseiritu1param.setZtyhensyuukeiyakusyamei(hensyuuKeiyakusyamei);
        pSinkeiyakuseiritu1param.setZtyhnsyuknjkyksynm(hnsyuknjKyksynm);
        pSinkeiyakuseiritu1param.setZtykyksyaseiymd(kykSeiymd.toString());
        pSinkeiyakuseiritu1param.setZtykyksyaseikbn(kyksyaSeikbn);
        pSinkeiyakuseiritu1param.setZtykyksyanen(String.valueOf(kykNen));
        pSinkeiyakuseiritu1param.setZtyhknsyuruikigousedaikbn(pMossyouhn.getRyouritusdno());
        pSinkeiyakuseiritu1param.setZtytsnsknewyno(pSinkeiyakuseirituinfoparam.getTsinyno());
        pSinkeiyakuseiritu1param.setZtymossyumtkktymd(pSinkeiyakuseirituinfoparam.getSrsyoriymd().toString());
        pSinkeiyakuseiritu1param.setZtytuusinsakijyuusyokbn(TUUSINSAKIJYUUSYOKBN_SONOHOKA);
        pSinkeiyakuseiritu1param.setZtyiktkaisuu(pSinkeiyakuseirituinfoparam.getIkkatubaraikaisuu().getValue());
        pSinkeiyakuseiritu1param.setZtyznnkai(znnkai.toString());
        pSinkeiyakuseiritu1param.setZtykeiyakukakuninsyuruikbn(keiyakuKakuninSyuruikbn);
        pSinkeiyakuseiritu1param.setZtysyonendosyokaip(new BigDecimal(syonendoSyokaip.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu1param.setZtysyonendo2kaimeikoup(new BigDecimal(
            syonendo2KaimeIkoup.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu1param.setZtyjinendoikoup(new BigDecimal(jinendoIkoup.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu1param.setZtysuuriyousyoriym(pSrsinkykseiritucommonparam.getTyuusyututaisyouym().toString());

        return;
    }

    private void editSinkeiyakuseiritu2(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        HT_MosSyouhn pMossyouhn,
        IT_KykUkt pKykukt,
        HT_Nyuukin pNyuukinMax,
        BM_SyouhnZokusei pSyouhnzokusei,
        SinkeiyakuSeiritu2Param pSinkeiyakuseiritu2param,
        int pSyohinHanteiKbn
        ) {


        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean;
        String siteiDairininKbn = "";
        String haitouSiharaiKbn = "";
        String kbnKeiriyouSegCd = "";
        String sinsaKbn = "";
        String toukeiyouSinsaKbn = "";
        String kokutiTuusantaisyous = "";
        String syukeiyakupWaribikiKbn = "";


        if (C_Tkhukaumu.HUKA.eq(pSinkeiyakuseirituinfoparam.getStdrsktkyhkkbn())) {

            C_UktKbn uktKbn= pKykukt.getUktkbn();

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SHITEI_DAIRININ, uktKbn.getValue());

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SHITEI_DAIRININ.getContent(),
                    pSinkeiyakuseirituinfoparam.getSyono(),
                    uktKbn.getValue()
                    );

                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {

                siteiDairininKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (pSinkeiyakuseirituinfoparam.getHeijyunp().compareTo(BizCurrency.valueOf(
                SrCommonConstants.YEN_15000, pSinkeiyakuseirituinfoparam.getHeijyunp().getType())) < 0) {
                syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_NONE.getValue();
            }
            else if (pSinkeiyakuseirituinfoparam.getHeijyunp().compareTo(BizCurrency.valueOf(
                SrCommonConstants.YEN_30000, pSinkeiyakuseirituinfoparam.getHeijyunp().getType())) < 0) {
                syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK01.getValue();
            }
            else {
                syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK02.getValue();
            }
        }
        else {
            syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_NONE.getValue();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_HAITOU, pSinkeiyakuseirituinfoparam.getHaitoukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pSinkeiyakuseirituinfoparam.getHaitoukbn().getValue()
                );

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {

            haitouSiharaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pMossyouhn.getSyouhncd(), pSinkeiyakuseirituinfoparam.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1007,
                SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pSinkeiyakuseirituinfoparam.getSyono(),
                pMossyouhn.getSyouhncd(),
                pSinkeiyakuseirituinfoparam.getKyktuukasyu().getValue());

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);

        }
        else {

            kbnKeiriyouSegCd = syouhinbetuSegmentBean.getSegcd1().getValue();
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ||
            pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            sinsaKbn = SrCommonConstants.SINSAKBN_SONOTA;
        }
        else {
            sinsaKbn = SrCommonConstants.SINSAKBN_KOKUTI;
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ||
            pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            toukeiyouSinsaKbn = SrCommonConstants.TOUKEIYOUSINSAKBN_MUSENTAKU;
        }
        else {
            toukeiyouSinsaKbn = SrCommonConstants.TOUKEIYOUSINSAKBN_KOKUTISYO;
        }

        if (C_SntkhouKbn.KKT.eq(pSinkeiyakuseirituinfoparam.getSntkhoukbn())) {

            kokutiTuusantaisyous = pMossyouhn.getSeitoukihons().toAdsoluteString();
        }
        else {

            kokutiTuusantaisyous = String.valueOf(0);
        }


        pSinkeiyakuseiritu2param.setZtysiteidairininkbn(siteiDairininKbn);
        if (C_Tkhukaumu.HUKA.eq(pSinkeiyakuseirituinfoparam.getStdrsktkyhkkbn())) {
            pSinkeiyakuseiritu2param.setZtystdairiseikyuutkykarihyj(SrCommonConstants.HYOUJI_ARI);
        }
        else {
            pSinkeiyakuseiritu2param.setZtystdairiseikyuutkykarihyj(SrCommonConstants.HYOUJI_NASI);
        }

        if (C_Tkhukaumu.HUKA.eq(pSinkeiyakuseirituinfoparam.getKykdrtkykhukakbn())) {
            pSinkeiyakuseiritu2param.setZtykykdrtkykarihyj(SrCommonConstants.HYOUJI_ARI);
        }
        else {
            pSinkeiyakuseiritu2param.setZtykykdrtkykarihyj(SrCommonConstants.HYOUJI_NASI);
        }

        pSinkeiyakuseiritu2param.setZtysyukeiyakupwaribikikbn(syukeiyakupWaribikiKbn);
        pSinkeiyakuseiritu2param.setZtyalmyoukijyunym(pSrsinkykseiritucommonparam.getTyuusyututaisyouym().toString());
        pSinkeiyakuseiritu2param.setZtyhaitousiharaikbn(haitouSiharaiKbn);
        pSinkeiyakuseiritu2param.setZtysuryusykykpwrbkkbn(syukeiyakupWaribikiKbn);
        pSinkeiyakuseiritu2param.setZtysyokaipryosyuymd(pNyuukinMax.getRyosyuymd().toString());
        pSinkeiyakuseiritu2param.setZtykbnkeiriyousegcd(kbnKeiriyouSegCd);
        pSinkeiyakuseiritu2param.setZtysinsakbn(sinsaKbn);
        pSinkeiyakuseiritu2param.setZtytoukeiyousinsakbn(toukeiyouSinsaKbn);
        pSinkeiyakuseiritu2param.setZtykokutituusantaisyous(new BigDecimal(kokutiTuusantaisyous).longValue());

        return;
    }

    private void editSinkeiyakuseiritu3(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        SrBoshuuDairiBean pSrboshuudairibean,
        SinkeiyakuSeiritu3Param pSinkeiyakuseiritu3param
        ) {


        String aAtukaisyaDirtnbsynnHyj = pSrboshuudairibean.getaAtukaisyaDirtnBsynnHyj();
        String aAtukaiKojinCd = pSrboshuudairibean.getaAtukaiKojinCd();
        String cifCd = pSrboshuudairibean.getCifCd();
        String bAtukaisyaDirtnBsynnHyj = pSrboshuudairibean.getbAtukaisyaDirtnBsynnHyj();
        String bAtukaiKojinCd = pSrboshuudairibean.getbAtukaiKojinCd();
        String bosyuuDairitenGyousyuKbn = pSrboshuudairibean.getBosyuuDairitenGyousyuKbn();


        pSinkeiyakuseiritu3param.setZtybosyuudairitengyousyukbn(bosyuuDairitenGyousyuKbn);
        pSinkeiyakuseiritu3param.setZtycifcd(cifCd);
        pSinkeiyakuseiritu3param.setZtytokusyujimutoriatukaikbn(HONSYAKOUMOSI);
        pSinkeiyakuseiritu3param.setZtykanyujisyono(pSinkeiyakuseirituinfoparam.getSyono());
        pSinkeiyakuseiritu3param.setZtykanyujikykymd(pSinkeiyakuseirituinfoparam.getKykymd().toString());
        pSinkeiyakuseiritu3param.setZtykanyuujihihokensyaage(String.valueOf(pSinkeiyakuseirituinfoparam.getHhknnen()));
        pSinkeiyakuseiritu3param.setZtyaatukaisyadirtnbsynnhyj(aAtukaisyaDirtnbsynnHyj);
        pSinkeiyakuseiritu3param.setZtybatkisyadirtnbosyuninhyj(bAtukaisyaDirtnBsynnHyj);
        pSinkeiyakuseiritu3param.setZtydirtnaatukaisyakojincd(aAtukaiKojinCd);
        pSinkeiyakuseiritu3param.setZtydirtnbatukaisyakojincd(bAtukaiKojinCd);
        pSinkeiyakuseiritu3param.setZtyhokensyuruikigouyobi1x1(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pSinkeiyakuseiritu3param.setZtyhokensyuruikigouyobi1x2(SrCommonConstants.HKNSYKGUYBI1X2_MANNENREIHOUSIKI);
        pSinkeiyakuseiritu3param.setZtyhokensyuruikigouyobi1x3(SrCommonConstants.HKNSYKGUYBI1X3_SINHOKENHOUTEKIYOU);
        pSinkeiyakuseiritu3param.setZtyhokensyuruikigouyobi1x4(SrCommonConstants.HKNSYKGUYBI1X4_SINTOKUJYOUTEKIYOU);
        pSinkeiyakuseiritu3param.setZtyhokensyuruikigouyobi3x1(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pSinkeiyakuseiritu3param.setZtyhokensyuruikigouyobi3x2(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);

        return;
    }

    private void editSinkeiyakuseiritu4(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        SinkeiyakuSeiritu4Param pSinkeiyakuseiritu4param
        ) {

        return;
    }

    private void editSinkeiyakuseiritu5(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        HT_MosSyouhn pMossyouhn,
        SrBoshuuDairiBean pSrboshuudairibean,
        SinkeiyakuSeiritu5Param pSinkeiyakuseiritu5param
        ) {


        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        String hhknNenTysihyj = "";
        String aAtukaisyaBosyuuDirtnCd = "";
        String bAtukaisyaBosyuuDirtnCd = "";
        String bosyuuKeitaiKbn = "";
        String mosnyuuryokuYmd = "";
        String mossyosakuseiYmd = "";
        String kokutiYmd = "";


        int hhknNen = setHokenNenrei.exec(pSinkeiyakuseirituinfoparam.getKykymd(),
            pSinkeiyakuseirituinfoparam.getHhknseiymd());

        if (pSinkeiyakuseirituinfoparam.getHhknnen() != hhknNen) {

            hhknNenTysihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            hhknNenTysihyj = SrCommonConstants.HYOUJI_NASI;
        }

        aAtukaisyaBosyuuDirtnCd = pSrboshuudairibean.getaAtukaisyaBosyuuDirtnCd();
        bAtukaisyaBosyuuDirtnCd = pSrboshuudairibean.getbAtukaisyaBosyuuDirtnCd();
        bosyuuKeitaiKbn = pSrboshuudairibean.getBosyuuKeitaiKbn();

        if(pSinkeiyakuseirituinfoparam.getMosnrkymd() != null) {

            mosnyuuryokuYmd = pSinkeiyakuseirituinfoparam.getMosnrkymd().toString();
        }
        else{

            mosnyuuryokuYmd = "";
        }

        if(pSinkeiyakuseirituinfoparam.getMossakuseiymd() != null) {

            mossyosakuseiYmd = pSinkeiyakuseirituinfoparam.getMossakuseiymd().toString();
        }
        else{

            mossyosakuseiYmd = "";
        }

        if (pSinkeiyakuseirituinfoparam.getKktymd() == null) {
            kokutiYmd = pSinkeiyakuseirituinfoparam.getMosymd().toString();
        }
        else {
            kokutiYmd = pSinkeiyakuseirituinfoparam.getKktymd().toString();
        }


        pSinkeiyakuseiritu5param.setZtyaatukaisyabosyuudirtncd(aAtukaisyaBosyuuDirtnCd);
        pSinkeiyakuseiritu5param.setZtybatukaisyabosyuudirtncd(bAtukaisyaBosyuuDirtnCd);
        pSinkeiyakuseiritu5param.setZtybosyuukeitaikbn(bosyuuKeitaiKbn);
        pSinkeiyakuseiritu5param.setZtykessankeijyouym(pSrsinkykseiritucommonparam.getTyuusyututaisyouym().toString());
        pSinkeiyakuseiritu5param.setZtymusymd(pSinkeiyakuseirituinfoparam.getMosymd().toString());
        pSinkeiyakuseiritu5param.setZtymosnyuuryokuymd(mosnyuuryokuYmd);
        pSinkeiyakuseiritu5param.setZtymossyosakuseiymd(mossyosakuseiYmd);
        pSinkeiyakuseiritu5param.setZtykokutiymd(kokutiYmd);
        pSinkeiyakuseiritu5param.setZtyjyuuryousyouryakukbn(JYUUTOUSYOURYAKUKBN_GINKOUMADOHANNYUUKINSUKIIMUNONYUUKIN);
        pSinkeiyakuseiritu5param.setZtyhhknnentysihyj(hhknNenTysihyj);
        pSinkeiyakuseiritu5param.setZtysinkeiyakujiyoteiriritu(pMossyouhn.getYoteiriritu());

        return;
    }

    private void editSinkeiyakuseiritu6(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        HT_MosSyouhn pMossyouhn,
        HT_Nyuukin pNyuukinMin,
        BM_SyouhnZokusei pSyouhnzokusei,
        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList,
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuMokuhyoutiHistoryBeanList,
        List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuKijyunKingakuHistoryBeanList,
        SinkeiyakuSeiritu6Param pSinkeiyakuseiritu6param,
        int pSyohinHanteiKbn,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn
        ) {


        SrSuuriKbnHenkanSet srKbnHenkan = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean;
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        C_ErrorKbn kawaserateKekka = null;
        String gaikaKbn = "";
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = null;
        C_KawasetsryKbn kawasetsryKbn = null;
        BizNumber kykjikwsrate = BizNumber.ZERO;
        String kykjiKawaserateTkyuYmd = "";
        BizNumber kyksjkkktyouseiRiritu = BizNumber.ZERO;
        BizCurrency enkdtsbujsitihsyukngk = null;
        String kaigomaeBaraitkykAriHyj = "";
        BizNumber mvaTyouseijikou = null;
        String nyuukinTuukaKbn = "";
        String wyendttargetmokuhyouritu = "";
        BizCurrency yendttargetkijyunkingaku = null;
        BizNumber kawaseRate = BizNumber.ZERO;
        BizNumber crossRate = BizNumber.ZERO;
        BizNumber tumitateRiritu = null;
        String sisuurendouRate = "";
        String sisuuKbn = "";
        BizNumber tmttknZoukarituJygn = null;
        BizNumber setteiBairitu = null;
        BizNumber kykymdSisuu = null;
        BizNumber rendouritu = null;
        String tuukasyukbn = "";
        BizCurrency sisuurenTumitatekin = null;
        BizCurrency tirttmttTumitatekin = null;
        BizCurrency nksjitirtTumitatekin = BizCurrency.valueOf(0);
        BizCurrency nendomatutirtTumitatekin = BizCurrency.valueOf(0);
        String kawaserateTkyuYmd = "";
        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);
        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd  = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);
        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
        C_SrKbnHenkanKbn srKbnHenkanKbn = null;
        BizCurrency gaikadateNkGns = BizCurrency.valueOf(0);
        BizDate kwsrateKjYmd = null;
        BizCurrency syuptumitatekin = null;
        BizCurrency tumitatekin = null;
        BizCurrency kiharaikomip = null;
        BizCurrency gaikadatesyukeiyakup = null;


        srSuuriKbnHenkanBean = srKbnHenkan.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA, pSinkeiyakuseirituinfoparam
            .getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pSinkeiyakuseirituinfoparam.getKyktuukasyu().getValue()
                );

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {

            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (!C_Tuukasyu.JPY.eq(pSinkeiyakuseirituinfoparam.getKyktuukasyu())) {

            if(C_Tuukasyu.JPY.eq(pSinkeiyakuseirituinfoparam.getHrktuukasyu())) {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                kawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
            }
            else {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
            }

            if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                (pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                C_UmuKbn.NONE.eq(pSinkeiyakuseirituinfoparam.getZennoumousideumu()))) {

                kwsrateKjYmd = pNyuukinMin.getRyosyuymd().addBusinessDays(-1);
            }
            else {
                kwsrateKjYmd = pNyuukinMin.getRyosyuymd();
            }

            kawaserateKekka = getKawaseRate.exec(
                kwsrateKjYmd,
                kawaserateSyuruiKbn,
                pSinkeiyakuseirituinfoparam.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                kawasetsryKbn,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU
                );

            if (C_ErrorKbn.ERROR.eq(kawaserateKekka)) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1004,
                    pNyuukinMin.getRyosyuymd().toString(),
                    kawaserateSyuruiKbn.getValue(),
                    pSinkeiyakuseirituinfoparam.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    kawasetsryKbn.getValue(),
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue()
                    );

                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {
                kawaseRate = getKawaseRate.getKawaserate();
                kawaserateTkyuYmd = getKawaseRate.getKwsrateKjYmd().toString();
                kykjikwsrate = getKawaseRate.getKawaserate();
                kykjiKawaserateTkyuYmd = getKawaseRate.getKwsrateKjYmd().toString();


            }

            if (!pSinkeiyakuseirituinfoparam.getKyktuukasyu().eq(pSinkeiyakuseirituinfoparam.getHrktuukasyu()) &&
                (C_Tuukasyu.AUD.eq(pSinkeiyakuseirituinfoparam.getHrktuukasyu()) ||
                    C_Tuukasyu.USD.eq(pSinkeiyakuseirituinfoparam.getHrktuukasyu()))) {

                kawaserateKekka = getKawaseRate.exec(
                    pNyuukinMin.getRyosyuymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pSinkeiyakuseirituinfoparam.getKyktuukasyu(),
                    pSinkeiyakuseirituinfoparam.getHrktuukasyu(),
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU
                    );

                if (C_ErrorKbn.ERROR.eq(kawaserateKekka)) {

                    String message = MessageUtil.getMessage(
                        MessageId.ESA1004,
                        pNyuukinMin.getRyosyuymd().toString(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                        pSinkeiyakuseirituinfoparam.getKyktuukasyu().getValue(),
                        pSinkeiyakuseirituinfoparam.getHrktuukasyu().getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.NYUKINRATE.getValue(),
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue()
                        );

                    errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
                }
                else {
                    crossRate = getKawaseRate.getKawaserate();
                }

                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean = srSuuriGouseiRateKeisan.exec(
                    pNyuukinMin.getRyosyuymd(),
                    pSinkeiyakuseirituinfoparam.getHrktuukasyu(),
                    crossRate
                    );
                SetErrMessageInfoBean errMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

                if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

                    String message = MessageUtil.getMessage(
                        MessageId.ESA1004,
                        errMessageInfoBean.getKwsrateKjYmd().toString(),
                        errMessageInfoBean.getKawaserateSyuruiKbn().getValue(),
                        errMessageInfoBean.getMotoTuukasyu().getValue(),
                        errMessageInfoBean.getKansanTuukasyu().getValue(),
                        errMessageInfoBean.getKawasetekiyoKbn().getValue(),
                        errMessageInfoBean.getKawasetsryKbn().getValue(),
                        errMessageInfoBean.getEigyoubiHoseiKbn().getValue(),
                        errMessageInfoBean.getYouhiKbn().getValue()
                        + "：合成レート"
                        );

                    errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
                }
                else {
                    kykjikwsrate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
                }
            }
        }

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
            SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

        if (C_UmuKbn.NONE.eq(pSyouhnzokusei.getMvatekiumu())) {
            kyksjkkktyouseiRiritu = BizNumber.ZERO;
        }
        else {
            if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) {
                getSjkkktyouseiyourirituBean.setKijyunymd(pSinkeiyakuseirituinfoparam.getSknnkaisiymd());
            }
            else {
                getSjkkktyouseiyourirituBean.setKijyunymd(pSinkeiyakuseirituinfoparam.getKykymd());
            }
            getSjkkktyouseiyourirituBean.setSyouhncd(pMossyouhn.getSyouhncd());
            getSjkkktyouseiyourirituBean.setHknkkn(pMossyouhn.getHknkkn());
            getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pMossyouhn.getHknkknsmnkbn());
            getSjkkktyouseiyourirituBean.setHhknnen(pSinkeiyakuseirituinfoparam.getHhknnen());

            kawaserateKekka = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

            if (C_ErrorKbn.ERROR.eq(kawaserateKekka)) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "市場価格調整用利率",
                    pSinkeiyakuseirituinfoparam.getSyono()
                    );

                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {
                kyksjkkktyouseiRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
            }
        }



        if (C_UmuKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getInitsbjiyensitihsytkhukaumu())) {

            if (khHenkouRirekiBeanList == null || khHenkouRirekiBeanList.size() == 0) {

                enkdtsbujsitihsyukngk = pSinkeiyakuseirituinfoparam.getInitsbjiyenkasaiteihsygk();
            }
            else {
                String kingakuStr = khHenkouRirekiBeanList.get(0).getBfrnaiyouoriginal();
                enkdtsbujsitihsyukngk = BizCurrency.valueOf(new BigDecimal(kingakuStr));
            }
        }
        else {

            enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
        }

        if (C_UmuKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getJyudkaigomeharaitkhukaumu())) {

            kaigomaeBaraitkykAriHyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kaigomaeBaraitkykAriHyj = SrCommonConstants.HYOUJI_NASI;
        }


        mvaTyouseijikou = pSyouhnzokusei.getMvatyouseijikou();

        srSuuriKbnHenkanBean = srKbnHenkan.exec(C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA, pSinkeiyakuseirituinfoparam
            .getHrktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pSinkeiyakuseirituinfoparam.getHrktuukasyu().getValue()
                );

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {

            nyuukinTuukaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_UmuKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getTargettkhkumu())) {
            if (targetTokuyakuMokuhyoutiHistoryBeanList == null || targetTokuyakuMokuhyoutiHistoryBeanList.size() == 0) {
                wyendttargetmokuhyouritu = pSinkeiyakuseirituinfoparam.getTargettkmokuhyouti().toString();
            }
            else {
                KhHenkouRirekiTargetBefaAftNaiyouOriginalBean indexOfZero = targetTokuyakuMokuhyoutiHistoryBeanList.get(0);
                wyendttargetmokuhyouritu = indexOfZero.getBfrnaiyouoriginal();
            }
        }
        else {
            wyendttargetmokuhyouritu = SrCommonConstants.DEFAULT_STRING_ZERO_1;
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (C_TumitatekinHaibunWariKbn.BLNK.eq(pSinkeiyakuseirituinfoparam.getSisuuhaibunwarikbn())) {
                sisuurendouRate = "";
            }
            else {
                sisuurendouRate = pSinkeiyakuseirituinfoparam.getSisuuhaibunwarikbn().getValue();
            }
        }
        else {
            sisuurendouRate = "";
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (C_TumitatekinHaibunWariKbn.WARIAI000.equals(pSinkeiyakuseirituinfoparam.getSisuuhaibunwarikbn())) {
                sisuuKbn = C_Sisuukbn.BLNK.getValue();
            }
            else {
                sisuuKbn = pSinkeiyakuseirituinfoparam.getSisuukbn().getValue();
            }

            srSuuriKbnHenkanBean = srKbnHenkan.exec(C_SrKbnHenkanKbn.SUURI_SISUU, sisuuKbn);
            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_SISUU.getContent(),
                    pSinkeiyakuseirituinfoparam.getSyono(),
                    pSinkeiyakuseirituinfoparam.getSisuukbn().getValue()
                    );

                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {
                sisuuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }
        else {
            sisuuKbn = "";
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            tmttknZoukarituJygn = pMossyouhn.getTmttknzoukaritujygn();
        }
        else {
            tmttknZoukarituJygn = BizNumber.valueOf(0);
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            setteiBairitu = pMossyouhn.getSetteibairitu();
        }
        else {
            setteiBairitu = BizNumber.valueOf(0);
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            kykymdSisuu = pKhSisuurendoTmttkn.getTmttknhaneisisuu();

            if (!C_TumitatekinHaibunWariKbn.WARIAI000.equals(pSinkeiyakuseirituinfoparam.getSisuuhaibunwarikbn()) &&
                BizNumber.valueOf(0).equals(kykymdSisuu)) {

                BizDate sisuuSyutokuYmd = null;
                sisuuSyutokuYmd = pSrsinkykseiritucommonparam.getTyuusyututaisyouym().getLastDay();

                C_ErrorKbn errorKbn = getSisuu.exec(
                    pSinkeiyakuseirituinfoparam.getSisuukbn(), sisuuSyutokuYmd, C_YouhiKbn.YOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    String message = MessageUtil.getMessage(
                        MessageId.ESA1001, "指数取得：契約日指数", pSinkeiyakuseirituinfoparam.getSyono());

                    errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
                }
                else {
                    kykymdSisuu = getSisuu.getSisuu();
                }
            }
        }
        else {
            kykymdSisuu = BizNumber.valueOf(0);
        }

        if(pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 &&
            !C_TumitatekinHaibunWariKbn.BLNK.eq(pSinkeiyakuseirituinfoparam.getSisuuhaibunwarikbn()) &&
            !C_TumitatekinHaibunWariKbn.WARIAI000.eq(pSinkeiyakuseirituinfoparam.getSisuuhaibunwarikbn())) {

            rendouritu = pMossyouhn.getRendouritu();
        }
        else {

            rendouritu = BizNumber.valueOf(0);
        }

        srSuuriKbnHenkanBean =
            srKbnHenkan.exec(C_SrKbnHenkanKbn.TUUKA_SYU, pSinkeiyakuseirituinfoparam.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pSinkeiyakuseirituinfoparam.getKyktuukasyu().getValue());

            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {

            tuukasyukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_UmuKbn.ARI.eq(pSinkeiyakuseirituinfoparam.getTargettkhkumu())) {
            if (targetTokuyakuKijyunKingakuHistoryBeanList == null || targetTokuyakuKijyunKingakuHistoryBeanList.size() == 0) {
                yendttargetkijyunkingaku = pSinkeiyakuseirituinfoparam.getTargettkykkijyungk();
            }
            else {
                KhHenkouRirekiTargetBefaAftNaiyouOriginalBean indexOfZero = targetTokuyakuKijyunKingakuHistoryBeanList.get(0);
                yendttargetkijyunkingaku = BizCurrency.valueOf(new BigDecimal(indexOfZero.getBfrnaiyouoriginal()));
            }
        }
        else {
            yendttargetkijyunkingaku = BizCurrency.valueOf(0);
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            sisuurenTumitatekin = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
        }
        else {
            sisuurenTumitatekin = BizCurrency.valueOf(0);
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            tirttmttTumitatekin = pKhSisuurendoTmttkn.getTeiritutmttkngk();
        }
        else {
            tirttmttTumitatekin = BizCurrency.valueOf(0);
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
            BizDate hknkknmanryouYmd = setManryoubi.exec(
                pSinkeiyakuseirituinfoparam.getKykymd(),
                pSinkeiyakuseirituinfoparam.getHhknnen(),
                pMossyouhn.getHknkkn(),
                C_KknsmnKbn.valueOf(pMossyouhn.getHknkknsmnkbn().getValue())
                );

            kawaserateKekka = keisanSisuuRendouNkTmttknOverNnd.exec(
                pSinkeiyakuseirituinfoparam.getKykymd(),
                pMossyouhn.getHknkkn(),
                pSinkeiyakuseirituinfoparam.getTeikishrtkykhukaumu(),
                pSinkeiyakuseirituinfoparam.getKyktuukasyu(),
                hknkknmanryouYmd,
                hknkknmanryouYmd.getBizDateYM(),
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pMossyouhn.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk()
                );

            if (C_ErrorKbn.ERROR.eq(kawaserateKekka)) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "年金開始時定率積立金",
                    pSinkeiyakuseirituinfoparam.getSyono()
                    );

                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {
                nksjitirtTumitatekin = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
            }
        }
        else {
            nksjitirtTumitatekin = BizCurrency.valueOf(0);
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            BizDate calcKijyunYmd;
            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            if (pSinkeiyakuseirituinfoparam.getSkeikeijyouym().getMonth() < GETU04) {
                calcKijyunYmd = BizDate.valueOf(pSinkeiyakuseirituinfoparam.getSkeikeijyouym().getYear() + NENDOMATU0331);
            }
            else {
                calcKijyunYmd = BizDate.valueOf(pSinkeiyakuseirituinfoparam.getSkeikeijyouym().getYear() + NEN + NENDOMATU0331);
            }

            BizDateYM calcKijyunYm = keisanWKijunYM.exec(
                pSinkeiyakuseirituinfoparam.getKykymd(),
                calcKijyunYmd,
                null,
                null,
                C_Kykjyoutai.ITIJIBARAI,
                pMossyouhn.getSyouhncd(),
                null
                );

            kawaserateKekka = keisanSisuuRendouNkTmttknOverNnd.exec(
                pSinkeiyakuseirituinfoparam.getKykymd(),
                pMossyouhn.getHknkkn(),
                pSinkeiyakuseirituinfoparam.getTeikishrtkykhukaumu(),
                pSinkeiyakuseirituinfoparam.getKyktuukasyu(),
                calcKijyunYmd,
                calcKijyunYm   ,
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pMossyouhn.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk()
                );

            if (C_ErrorKbn.ERROR.eq(kawaserateKekka)) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "年度末定率部分積立金",
                    pSinkeiyakuseirituinfoparam.getSyono()
                    );

                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {
                nendomatutirtTumitatekin = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
            }
        }
        else {
            nendomatutirtTumitatekin = BizCurrency.valueOf(0);
        }

        String sibouhyouKbn = "";
        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2;
        }
        else {
            srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        }

        srSuuriKbnHenkanBean = srKbnHenkan.exec(srKbnHenkanKbn, pMossyouhn.getRyouritusdno());
        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String message = MessageUtil.getMessage(
                MessageId.ESA1002,
                srKbnHenkanKbn.getContent(),
                pSinkeiyakuseirituinfoparam.getSyono(),
                pMossyouhn.getRyouritusdno()
                );
            errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
        }
        else {
            sibouhyouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        BizNumber yoteiIjihirituVhirei =  null;
        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            SetManryoubi setManryoubi = SWAKInjector.getInstance(SetManryoubi.class);
            BizDate kikanManryouYmd = setManryoubi.exec(
                pSinkeiyakuseirituinfoparam.getKykymd(),
                pSinkeiyakuseirituinfoparam.getHhknnen(),
                pMossyouhn.getHknkkn(),
                C_KknsmnKbn.valueOf(pMossyouhn.getHknkknsmnkbn().getValue())
                );

            BizDateYM hknkknmanryouYm = null;

            if (kikanManryouYmd != null) {
                hknkknmanryouYm = kikanManryouYmd.getBizDateYM();
            }

            KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);
            KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

            keisanVHeijyunBean.setSyouhncd(pMossyouhn.getSyouhncd());
            keisanVHeijyunBean.setRyouritusdno(pMossyouhn.getRyouritusdno());
            keisanVHeijyunBean.setCalckijyunYm(hknkknmanryouYm);
            keisanVHeijyunBean.setKykymd(pSinkeiyakuseirituinfoparam.getKykymd());
            keisanVHeijyunBean.setHokenryou(pSinkeiyakuseirituinfoparam.getHeijyunp());
            keisanVHeijyunBean.setKyktuukasyu(pSinkeiyakuseirituinfoparam.getKyktuukasyu());
            keisanVHeijyunBean.setHhknsei(pSinkeiyakuseirituinfoparam.getHhknsei());
            keisanVHeijyunBean.setHhknnen(pSinkeiyakuseirituinfoparam.getHhknnen());
            keisanVHeijyunBean.setHknkkn(pMossyouhn.getHknkkn());
            keisanVHeijyunBean.setHknkknsmnkbn(pMossyouhn.getHknkknsmnkbn());
            keisanVHeijyunBean.setHrkkkn(pMossyouhn.getHrkkkn());
            keisanVHeijyunBean.setHrkkknsmnkbn(pMossyouhn.getHrkkknsmnkbn());
            keisanVHeijyunBean.setHrkkaisuu(pSinkeiyakuseirituinfoparam.getHrkkaisuu());
            keisanVHeijyunBean.setFstpryosyu(pNyuukinMin.getRyosyuymd());
            keisanVHeijyunBean.setSitihsyuriritu(pSyouhnzokusei.getYoteirirituminhosyouritu());
            keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
            keisanVHeijyunBean.setSisansyoriYmd(pSinkeiyakuseirituinfoparam.getKykymd());
            keisanVHeijyunBean.setSisanyoteiriritu(pSyouhnzokusei.getYoteirirituminhosyouritu());
            keisanVHeijyunBean.setSisankawaserate(pSinkeiyakuseirituinfoparam.getNyknkwsrate());

            C_ErrorKbn keisanVHeijyunErrorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);

            yoteiIjihirituVhirei = keisanVHeijyun.getYoteiIjihirituVhirei();

            if (C_ErrorKbn.ERROR.eq(keisanVHeijyunErrorKbn)) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "外貨建主契約Ｐ",
                    pSinkeiyakuseirituinfoparam.getSyono()
                    );
                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {
                gaikadateNkGns = keisanVHeijyun.getV();
            }
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 ) {
            tumitateRiritu = pMossyouhn.getTumitateriritu();
        }
        else if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);
            KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

            keisanVHeijyunBean.setSyouhncd(pMossyouhn.getSyouhncd());
            keisanVHeijyunBean.setRyouritusdno(pMossyouhn.getRyouritusdno());
            keisanVHeijyunBean.setCalckijyunYm(
                pSinkeiyakuseirituinfoparam.getKykymd().getBizDateYM().addMonths(SrCommonConstants.KIKAN_1M));
            keisanVHeijyunBean.setKykymd(pSinkeiyakuseirituinfoparam.getKykymd());
            keisanVHeijyunBean.setHokenryou(pSinkeiyakuseirituinfoparam.getHeijyunp());
            keisanVHeijyunBean.setKyktuukasyu(pSinkeiyakuseirituinfoparam.getKyktuukasyu());
            keisanVHeijyunBean.setHhknsei(pSinkeiyakuseirituinfoparam.getHhknsei());
            keisanVHeijyunBean.setHhknnen(pSinkeiyakuseirituinfoparam.getHhknnen());
            keisanVHeijyunBean.setHknkkn(pMossyouhn.getHknkkn());
            keisanVHeijyunBean.setHknkknsmnkbn(pMossyouhn.getHknkknsmnkbn());
            keisanVHeijyunBean.setHrkkkn(pMossyouhn.getHrkkkn());
            keisanVHeijyunBean.setHrkkknsmnkbn(pMossyouhn.getHrkkknsmnkbn());
            keisanVHeijyunBean.setHrkkaisuu(pSinkeiyakuseirituinfoparam.getHrkkaisuu());
            keisanVHeijyunBean.setFstpryosyu(pNyuukinMin.getRyosyuymd());
            keisanVHeijyunBean.setSitihsyuriritu(pSyouhnzokusei.getYoteirirituminhosyouritu());
            keisanVHeijyunBean.setTmttkntaisyouym(null);
            keisanVHeijyunBean.setCalckaisiYmjitenv(null);
            keisanVHeijyunBean.setCalckaisiYmjitensump(null);
            keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
            keisanVHeijyunBean.setSisansyoriYmd(pSinkeiyakuseirituinfoparam.getKykymd());
            keisanVHeijyunBean.setSisanyoteiriritu(pSyouhnzokusei.getYoteirirituminhosyouritu());
            keisanVHeijyunBean.setSisankawaserate(pSinkeiyakuseirituinfoparam.getNyknkwsrate());

            C_ErrorKbn keisanVHeijyunErrorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);

            if (C_ErrorKbn.ERROR.eq(keisanVHeijyunErrorKbn)) {

                String message = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "積立利率",
                    pSinkeiyakuseirituinfoparam.getSyono()
                    );
                errorProcess(pSrsinkykseiritucommonparam, pSinkeiyakuseirituinfoparam, message);
            }
            else {
                tumitateRiritu = pMossyouhn.getYoteiriritu().subtract(keisanVHeijyun.getYoteiIjihirituVhirei());
            }
        }
        else {
            tumitateRiritu = BizNumber.ZERO;
        }

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            syuptumitatekin = pSinkeiyakuseirituinfoparam.getHyouteip();
            tumitatekin = pSinkeiyakuseirituinfoparam.getHyouteip();
            kiharaikomip = pSinkeiyakuseirituinfoparam.getHyouteip();
            gaikadatesyukeiyakup = pSinkeiyakuseirituinfoparam.getHyouteip();
        }
        else {
            syuptumitatekin = BizCurrency.valueOf(0);
            tumitatekin = BizCurrency.valueOf(0);
            kiharaikomip = BizCurrency.valueOf(0);
            gaikadatesyukeiyakup = BizCurrency.valueOf(0);
        }

        pSinkeiyakuseiritu6param.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pSinkeiyakuseiritu6param.setZtygaikakbn(gaikaKbn);
        pSinkeiyakuseiritu6param.setZtykawaserate(kawaseRate);
        pSinkeiyakuseiritu6param.setZtykawaseratetekiyouymd(kawaserateTkyuYmd);
        pSinkeiyakuseiritu6param.setZtykykjikawaserate(kykjikwsrate);
        pSinkeiyakuseiritu6param.setZtykykjikawaseratetkyuymd(kykjiKawaserateTkyuYmd);
        pSinkeiyakuseiritu6param.setZtykeiyakujiyoteiriritu(
            pMossyouhn.getYoteiriritu());
        pSinkeiyakuseiritu6param.setZtytumitateriritu(tumitateRiritu);
        pSinkeiyakuseiritu6param.setZtysrkyksjkkktyouseiriritu(
            kyksjkkktyouseiRiritu);
        pSinkeiyakuseiritu6param.setZtyenkdtsbujsitihsyukngk(
            new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtykaigomaebaraitkykarihyj(kaigomaeBaraitkykAriHyj);
        pSinkeiyakuseiritu6param.setZtysibouhyoukbn(sibouhyouKbn);
        pSinkeiyakuseiritu6param.setZtymvatyouseikou(mvaTyouseijikou);
        pSinkeiyakuseiritu6param.setZtynyuukintuukakbn(nyuukinTuukaKbn);

        pSinkeiyakuseiritu6param.setZtywyendttargetmokuhyouritu(wyendttargetmokuhyouritu);
        pSinkeiyakuseiritu6param.setZtysisuurendourate(sisuurendouRate);
        pSinkeiyakuseiritu6param.setZtysisuukbn(sisuuKbn);
        pSinkeiyakuseiritu6param.setZtysrdai1hknkkn(String.valueOf(pMossyouhn.getDai1hknkkn()));
        pSinkeiyakuseiritu6param.setZtytmttknzoukaritujygn(tmttknZoukarituJygn);
        pSinkeiyakuseiritu6param.setZtysetteibairitu(setteiBairitu);
        pSinkeiyakuseiritu6param.setZtykykymdsisuu(kykymdSisuu);
        pSinkeiyakuseiritu6param.setZtyrendouritu(rendouritu);
        pSinkeiyakuseiritu6param.setZtytuukasyukbn(tuukasyukbn);
        pSinkeiyakuseiritu6param.setZtyyendttargetkijyunkingaku(
            new BigDecimal(yendttargetkijyunkingaku.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtysisuurentumitatekin(new BigDecimal(sisuurenTumitatekin.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtytirttmtttumitatekin(new BigDecimal(tirttmttTumitatekin.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtynksjitirttmttkn(new BigDecimal(nksjitirtTumitatekin.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtynendomatutirttumitatekin(new BigDecimal(nendomatutirtTumitatekin.toAdsoluteString()).longValue());

        pSinkeiyakuseiritu6param.setZtysyuptumitatekin(new BigDecimal(syuptumitatekin.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtygaikadatenkgns(new BigDecimal(gaikadateNkGns.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtytumitatekin(new BigDecimal(tumitatekin.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtykiharaikomip(new BigDecimal(kiharaikomip.toAdsoluteString()).longValue());
        pSinkeiyakuseiritu6param.setZtygaikadatesyukeiyakup(new BigDecimal(gaikadatesyukeiyakup.toAdsoluteString()).longValue());

        return;
    }

    private void errorProcess(
        SrSinkykSeirituCommonParam pSrsinkykseiritucommonparam,
        SinkeiyakuSeirituInfoParam pSinkeiyakuseirituinfoparam,
        String message
        ) {


        logger.warn(message);


        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
        suuriyouErrJyouhou.setSyoriYmd(pSrsinkykseiritucommonparam.getSyoriYmd());
        suuriyouErrJyouhou.setKakutyoujobcd(pSrsinkykseiritucommonparam.getIbKakutyoujobcd());
        suuriyouErrJyouhou.setSyono(pSinkeiyakuseirituinfoparam.getSyono());
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(message);
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        BizPropertyInitializer.initialize(suuriyouErrJyouhou);
        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);


        pSrsinkykseiritucommonparam.setErrorsyorikensuu(pSrsinkykseiritucommonparam.getErrorsyorikensuu() + 1);


        errorFlag = true;

        return;
    }

}
