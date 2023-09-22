package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.biz.bznayose.BzKeiyakuHozenSakuinKekkaBean;
import yuyu.common.biz.bznayose.BzKeiyakuMfSakuinKekkaBean;
import yuyu.common.biz.bznayose.BzMousikomiFSakuinKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.common.biz.bznayose.BzSentakuInfoFSakuinKekkaBean;
import yuyu.common.biz.bznayose.BzSinkeiyakuSakuinKekkaBean;
import yuyu.common.direct.dscommon.DsNayose;
import yuyu.common.direct.dscommon.DsNayoseBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykJyoutaiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tuusan;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 名寄せ処理
 */
public class Nayose {

    private final static String HIHOKENSYA = "HIHOKENSYA";

    private final static String KEIYAKUSYA = "KEIYAKUSYA";

    private final static String UKETORININ = "UKETORININ";

    private final static String KEIYAKUSYADAIRININ = "KEIYAKUSYADAIRININ";

    private final static String HIHOKENSYADAIRININ = "HIHOKENSYADAIRININ";

    private C_SinkihnkKbn sinkihnkKbn = C_SinkihnkKbn.BLNK;

    private C_KykKbn kykKbnHnkmae = C_KykKbn.BLNK;

    private C_UmuKbn hhknTeiseiUmu = C_UmuKbn.NONE;

    private C_UmuKbn kykTeiseiUmu = C_UmuKbn.NONE;

    private String taisyouNmKn = "";

    private String taisyouNmKj = "";

    private BizDate taisyouseiYmd = null;

    private String taisyouYno = "";

    private C_SakuintsnSyoukaiKbn sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.BLNK;

    private C_SakuintsnTaisyouKbn sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;

    private C_SakuintaisyoukykKbn sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.BLNK;

    private C_SysKbn sysKbn = C_SysKbn.SKEI;

    private C_UmuKbn nyskaihiUmuKbn = C_UmuKbn.NONE;

    private boolean msgFlg = false;

    private boolean hhknnayoseErrorFlg  = false;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public Nayose() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 名寄せ処理 開始");
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        String kosID = pMP.getKosID();
        sinkihnkKbn = pMP.getSinkiHnkKbn();
        kykKbnHnkmae = pMP.getKykKbn_HnkMae();
        hhknTeiseiUmu = pMP.getHhknTeisei();
        kykTeiseiUmu = pMP.getKykTeisei();
        sysKbn = pMP.getSysKbn();
        nyskaihiUmuKbn = pMP.getNayoseKaihiUmuKbn();
        msgFlg = false;
        hhknnayoseErrorFlg = false;
        BzSakuinTsnSyoukaiKekkaBean hhknSakuinTsnSyoukaiKekkaBean = null;
        BzSakuinTsnSyoukaiKekkaBean kykSakuinTsnSyoukaiKekkaBean = null;
        List<HT_SentakuJyouhou> hkgoSentakuJyouhouLst = new ArrayList<>();
        List<HT_NayoseKekka> hkgoNayoseKekkaLst = new ArrayList<>();
        boolean tuusanSetteiFlg = false;
        boolean hhknseiYmdFlg = false;
        boolean kykseiYmdFlg = false;
        List<BzSakuinTsnSyoukaiKekkaBean> uktSkinTsnSkKekkaBeanLst = new ArrayList<>();
        List<BzSakuinTsnSyoukaiKekkaBean> kykDrnSkinTsnSkKekkaBeanLst = new ArrayList<>();
        List<BzSakuinTsnSyoukaiKekkaBean> hhkDrnSkinTsnSkKekkaBeanLst = new ArrayList<>();
        boolean kykDrnTrkkzk1Flg = false;
        boolean kykDrnTrkkzk2Flg = false;
        List<String> skDjmosNoLstRay = new ArrayList<>();
        List<String> skDjmosNoLstPal = new ArrayList<>();

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        C_KykKbn kykKbn = mosKihon.getKykkbn();
        String hhknnmKn = mosKihon.getHhknnmkn();

        String hhknnmKj = "";
        if (!C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getHhknnmkjkhukakbn())) {
            hhknnmKj = mosKihon.getHhknnmkj();
        }
        else {
            hhknnmKj = "";
        }

        String kyknmKn = mosKihon.getKyknmkn();
        String kyknmKj = "";
        if (!C_KjkhukaKbn.KJKHUKA.eq(mosKihon.getKyknmkjkhukakbn())) {
            kyknmKj = mosKihon.getKyknmkj();
        }
        else {
            kyknmKj = "";
        }

        BizDate hhknseiYmd = mosKihon.getHhknseiymd();
        BizDate kykseiYmd = mosKihon.getKykseiymd();
        String tsinyNo = mosKihon.getTsinyno();
        String hhknyNo = "";
        if (C_TsindousiteiKbn.ARI.eq(mosKihon.getTsindousiteikbn())) {
            hhknyNo = mosKihon.getTsinyno();
        }
        else {
            hhknyNo = mosKihon.getHhknyno();
        }

        HT_Tuusan tuusan = syoriCTL.getTuusan();

        if (tuusan != null){
            tuusan.setTsnsibous(BizCurrency.valueOf(0));
            tuusan.setTsnninenmikeikas(BizCurrency.valueOf(0));
            tuusan.setTsnninenkeikas(BizCurrency.valueOf(0));
            tuusan.setTsnninenmikeikahtnkns(BizCurrency.valueOf(0));
            tuusan.setTsnninenkeikadfp(BizCurrency.valueOf(0));
            tuusan.setTsnketsibous(BizCurrency.valueOf(0));
            tuusan.setTsnketsibous2(BizCurrency.valueOf(0));
            tuusan.setTsnsoukktjituhsgk(BizCurrency.valueOf(0));
            tuusan.setTsnkktjituhsgk1(BizCurrency.valueOf(0));
            tuusan.setTsnkktjituhsgk2(BizCurrency.valueOf(0));
            tuusan.setTsnkktitijibrsysnjs(BizCurrency.valueOf(0));
            tuusan.setTsnnkgns(BizCurrency.valueOf(0));
            tuusan.setTsnmsnynenbtsousbus(BizCurrency.valueOf(0));
            tuusan.setTsnnenbtitijibrssbs(BizCurrency.valueOf(0));
            tuusan.setTsnitijibrsysnp(BizCurrency.valueOf(0));
            tuusan.setTsnsntktuukahijynsysns(BizCurrency.valueOf(0));
            tuusan.setKykdrtentsns(BizCurrency.valueOf(0));
            tuusan.setTsnkaigomehrtkumukbn(C_UmuKbn.NONE);
        }

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<HT_Uketorinin> uktHhkdrninLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK);

        List<HT_Uketorinin> uktKykdrninLst = syoriCTL.getUketorininsByUktsyukbn(C_UktsyuKbn.KYKDRN);

        List<HT_MosTrkKzk> mosTrkKzkLst = syoriCTL.getMosTrkKzks();

        HT_MosTrkKzk mosTrkKzk1 = null;
        HT_MosTrkKzk mosTrkKzk2 = null;

        if (mosTrkKzkLst != null && mosTrkKzkLst.size() != 0) {

            for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {
                if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                    mosTrkKzk1 = mosTrkKzk;
                }
                else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                    mosTrkKzk2 = mosTrkKzk;
                }
            }
        }

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_UmuKbn.ARI.eq(nyskaihiUmuKbn)) {

            logger.debug("△ 名寄せ処理 終了");

            return;
        }

        if ((C_SinkihnkKbn.SINKIMOSNYUURYOKU.eq(sinkihnkKbn) && C_KykKbn.KEIHI_BETU.eq(kykKbn))
            || (C_SinkihnkKbn.MEIGIINFOHENKOU.eq(sinkihnkKbn) && C_KykKbn.KEIHI_BETU.eq(kykKbn)
                && C_KykKbn.KEIHI_DOUITU.eq(kykKbnHnkmae))) {

            taisyouNmKn = hhknnmKn;
            taisyouNmKj = hhknnmKj;
            taisyouseiYmd = hhknseiYmd;
            taisyouYno = hhknyNo;
            sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.MEIGISYOUKAI;
            sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;
            sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

            hhknSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, HIHOKENSYA);

            taisyouNmKn = kyknmKn;
            taisyouNmKj = kyknmKj;
            taisyouseiYmd = kykseiYmd;
            taisyouYno = tsinyNo;

            kykSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, KEIYAKUSYA);
        }

        if ((C_SinkihnkKbn.SINKIMOSNYUURYOKU.eq(sinkihnkKbn) && C_KykKbn.KEIHI_DOUITU.eq(kykKbn))
            || (C_SinkihnkKbn.MEIGIINFOHENKOU.eq(sinkihnkKbn) && C_KykKbn.KEIHI_DOUITU.eq(kykKbn)
                && C_KykKbn.KEIHI_DOUITU.eq(kykKbnHnkmae))
                || (C_SinkihnkKbn.MEIGIINFOHENKOU.eq(sinkihnkKbn) && C_KykKbn.KEIHI_DOUITU.eq(kykKbn)
                    && C_KykKbn.KEIHI_BETU.eq(kykKbnHnkmae))) {

            taisyouNmKn = hhknnmKn;
            taisyouNmKj = hhknnmKj;
            taisyouseiYmd = hhknseiYmd;
            taisyouYno = hhknyNo;
            sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.MEIGISYOUKAI;
            sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;
            sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

            hhknSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, HIHOKENSYA);

            kykSakuinTsnSyoukaiKekkaBean = hhknSakuinTsnSyoukaiKekkaBean;
        }

        if (C_SinkihnkKbn.MEIGIINFOHENKOU.eq(sinkihnkKbn) &&
            C_KykKbn.KEIHI_BETU.eq(kykKbn) &&
            C_KykKbn.KEIHI_BETU.eq(kykKbnHnkmae)) {

            taisyouNmKn = hhknnmKn;
            taisyouNmKj = hhknnmKj;
            taisyouseiYmd = hhknseiYmd;
            taisyouYno = hhknyNo;
            sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

            if (C_UmuKbn.ARI.eq(hhknTeiseiUmu)) {

                sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.MEIGISYOUKAI;
                sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;
            }
            else {

                sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI;
                sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.HHKN;
            }

            hhknSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, HIHOKENSYA);

            taisyouNmKn = kyknmKn;
            taisyouNmKj = kyknmKj;
            taisyouseiYmd = kykseiYmd;
            taisyouYno = tsinyNo;
            sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

            if (C_UmuKbn.ARI.eq(kykTeiseiUmu)) {

                sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.MEIGISYOUKAI;
                sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;
            }
            else {

                sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI;
                sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.KYK;
            }

            kykSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, KEIYAKUSYA);
        }

        if (C_SinkihnkKbn.BLNK.eq(sinkihnkKbn) && C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

            taisyouNmKn = kyknmKn;
            taisyouNmKj = kyknmKj;
            taisyouseiYmd = kykseiYmd;
            taisyouYno = tsinyNo;
            sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI;
            sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.KYK;
            sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

            kykSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, KEIYAKUSYA);

            taisyouNmKn = hhknnmKn;
            taisyouNmKj = hhknnmKj;
            taisyouseiYmd = hhknseiYmd;
            taisyouYno = hhknyNo;
            sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI;
            sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.HHKN;

            hhknSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, HIHOKENSYA);

        }

        if (C_SinkihnkKbn.BLNK.eq(sinkihnkKbn) && C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {

            taisyouNmKn = hhknnmKn;
            taisyouNmKj = hhknnmKj;
            taisyouseiYmd = hhknseiYmd;
            taisyouYno = hhknyNo;
            sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI;
            sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.HHKN;
            sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

            hhknSakuinTsnSyoukaiKekkaBean = nayose(pMP, mosKihon, HIHOKENSYA);

            kykSakuinTsnSyoukaiKekkaBean = hhknSakuinTsnSyoukaiKekkaBean;
        }

        if (!hhknnayoseErrorFlg) {

            pMP.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        }

        for (HT_Uketorinin uketorinin : uketorininLst) {

            if (C_UktKbn.TOKUTEIMEIGI.eq(uketorinin.getUktkbn())) {

                taisyouNmKn = uketorinin.getUktnmkn();

                if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                    taisyouNmKj = uketorinin.getUktnmkj();
                }
                else {
                    taisyouNmKj = "";
                }

                taisyouseiYmd = uketorinin.getUktseiymd();
                taisyouYno = tsinyNo;
                sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.MEIGISYOUKAI;
                sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;
                sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

                BzSakuinTsnSyoukaiKekkaBean uktSkinTsnSkKekkaResult = nayose(pMP, mosKihon, UKETORININ);
                if (uktSkinTsnSkKekkaResult != null) {

                    uktSkinTsnSkKekkaBeanLst.add(uktSkinTsnSkKekkaResult);
                }
            }
        }

        if (BizDateUtil.compareYmd(mosKihon.getMosymd(),
            YuyuSinkeiyakuConfig.getInstance().getKykdaririTkykHukaYmd()) != BizDateUtil.COMPARE_LESSER) {

            for (HT_Uketorinin uktKykdrnin : uktKykdrninLst) {
                kykDrnTrkkzk1Flg = false;
                kykDrnTrkkzk2Flg = false;
                boolean kykDrNayosejissiYohi = false;

                if (C_UktKbn.TOUROKUKAZOKU1.eq(uktKykdrnin.getUktkbn()) && mosTrkKzk1 != null) {

                    taisyouNmKn = mosTrkKzk1.getTrkkzknmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk1.getTrkkzknmkjkhukakbn())) {
                        taisyouNmKj = mosTrkKzk1.getTrkkzknmkj();
                    }
                    else {
                        taisyouNmKj = "";
                    }

                    taisyouseiYmd = mosTrkKzk1.getTrkkzkseiymd();

                    if (C_TsindousiteiKbn.ARI.eq(mosTrkKzk1.getTrkkzktsindousiteikbn())) {
                        taisyouYno = tsinyNo;
                    }
                    else {
                        taisyouYno = mosTrkKzk1.getTrkkzkyno();
                    }

                    kykDrnTrkkzk1Flg = true;
                    kykDrNayosejissiYohi = true;
                }
                else if (C_UktKbn.TOUROKUKAZOKU2.eq(uktKykdrnin.getUktkbn()) && mosTrkKzk2 != null) {

                    taisyouNmKn = mosTrkKzk2.getTrkkzknmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk2.getTrkkzknmkjkhukakbn())) {
                        taisyouNmKj = mosTrkKzk2.getTrkkzknmkj();
                    }
                    else {
                        taisyouNmKj = "";
                    }

                    taisyouseiYmd = mosTrkKzk2.getTrkkzkseiymd();

                    if (C_TsindousiteiKbn.ARI.eq(mosTrkKzk2.getTrkkzktsindousiteikbn())) {
                        taisyouYno = tsinyNo;
                    }
                    else {
                        taisyouYno = mosTrkKzk2.getTrkkzkyno();
                    }

                    kykDrnTrkkzk2Flg = true;
                    kykDrNayosejissiYohi = true;
                }

                if (kykDrNayosejissiYohi) {
                    sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.MEIGISYOUKAI;
                    sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;
                    sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

                    BzSakuinTsnSyoukaiKekkaBean kykDrnSkinTsnSkKekkaResult = nayose(pMP, mosKihon, KEIYAKUSYADAIRININ);
                    if (kykDrnSkinTsnSkKekkaResult != null) {
                        kykDrnSkinTsnSkKekkaBeanLst.add(kykDrnSkinTsnSkKekkaResult);
                    }
                }
            }

            for (HT_Uketorinin uktHhkdrnin : uktHhkdrninLst) {

                boolean uktHhkdrNayosejissiYohi = false;

                if (C_UktKbn.KYK.eq(uktHhkdrnin.getUktkbn()) || C_UktKbn.SBUK.eq(uktHhkdrnin.getUktkbn()) ||
                    (C_UktKbn.TOUROKUKAZOKU1.eq(uktHhkdrnin.getUktkbn()) && kykDrnTrkkzk1Flg) ||
                    (C_UktKbn.TOUROKUKAZOKU2.eq(uktHhkdrnin.getUktkbn()) && kykDrnTrkkzk2Flg)) {

                    continue;
                }
                else if (C_UktKbn.TOKUTEIMEIGI.eq(uktHhkdrnin.getUktkbn())) {

                    taisyouNmKn = uktHhkdrnin.getUktnmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(uktHhkdrnin.getUktnmkjkhukakbn())) {
                        taisyouNmKj = uktHhkdrnin.getUktnmkj();
                    }
                    else {
                        taisyouNmKj = "";
                    }

                    taisyouseiYmd = uktHhkdrnin.getUktseiymd();
                    taisyouYno = tsinyNo;
                    uktHhkdrNayosejissiYohi = true;
                }
                else if (C_UktKbn.TOUROKUKAZOKU1.eq(uktHhkdrnin.getUktkbn()) && mosTrkKzk1 != null) {

                    taisyouNmKn = mosTrkKzk1.getTrkkzknmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk1.getTrkkzknmkjkhukakbn())) {
                        taisyouNmKj = mosTrkKzk1.getTrkkzknmkj();
                    }
                    else {
                        taisyouNmKj = "";
                    }

                    taisyouseiYmd = mosTrkKzk1.getTrkkzkseiymd();

                    if (C_TsindousiteiKbn.ARI.eq(mosTrkKzk1.getTrkkzktsindousiteikbn())) {
                        taisyouYno = tsinyNo;
                    }
                    else {
                        taisyouYno = mosTrkKzk1.getTrkkzkyno();
                    }

                    uktHhkdrNayosejissiYohi = true;
                }
                else if (C_UktKbn.TOUROKUKAZOKU2.eq(uktHhkdrnin.getUktkbn()) && mosTrkKzk2 != null) {

                    taisyouNmKn = mosTrkKzk2.getTrkkzknmkn();

                    if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk2.getTrkkzknmkjkhukakbn())) {
                        taisyouNmKj = mosTrkKzk2.getTrkkzknmkj();
                    }
                    else {
                        taisyouNmKj = "";
                    }

                    taisyouseiYmd = mosTrkKzk2.getTrkkzkseiymd();

                    if (C_TsindousiteiKbn.ARI.eq(mosTrkKzk2.getTrkkzktsindousiteikbn())) {
                        taisyouYno = tsinyNo;
                    }
                    else {
                        taisyouYno = mosTrkKzk2.getTrkkzkyno();
                    }

                    uktHhkdrNayosejissiYohi = true;
                }

                if (uktHhkdrNayosejissiYohi) {

                    sakuintsnSyoukaiKbn = C_SakuintsnSyoukaiKbn.MEIGISYOUKAI;
                    sakuintsnTaisyouKbn = C_SakuintsnTaisyouKbn.BLNK;
                    sakuinTaisyoukykKbn = C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN;

                    BzSakuinTsnSyoukaiKekkaBean hhkDrnSkinTsnSkKekkaResult = nayose(pMP, mosKihon, HIHOKENSYADAIRININ);
                    if (hhkDrnSkinTsnSkKekkaResult != null) {
                        hhkDrnSkinTsnSkKekkaBeanLst.add(hhkDrnSkinTsnSkKekkaResult);
                    }
                }
            }
        }

        if (hhknSakuinTsnSyoukaiKekkaBean != null) {

            if (C_BlnktkumuKbn.ARI.eq(hhknSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn())) {

                pMP.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);
            }
            else {

                pMP.setHhknTratkityuiUmuKbnMr(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(hhknSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn())) {
                pMP.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
            }
            else{
                pMP.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(hhknSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn())) {

                pMP.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
            }
            else {

                pMP.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(hhknSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn())) {

                pMP.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
            }
            else {

                pMP.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(hhknSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn())) {
                pMP.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);
            }
            else {
                pMP.setHhknGaikokupepsumukbn(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(hhknSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn())) {

                pMP.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);
            }
            else {

                pMP.setHhknSinsntkhnsyumukbn(C_UmuKbn.NONE);
            }

            pMP.setHhknItekisntkhndktYhKbn(hhknSakuinTsnSyoukaiKekkaBean.getItekisntkhndktyhkbn());
            pMP.setHhknTtdkTyuuiKnkHndktYhKbn(hhknSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn());
            pMP.setHhknKyhkinUktkAriItkHndktYhKbn(hhknSakuinTsnSyoukaiKekkaBean.getKyhkinuktkariitkhndktyhkbn());

            if (C_YouhiblnkKbn.YOU.eq(hhknSakuinTsnSyoukaiKekkaBean.getDoujimositekihndktyhkbn())) {

                pMP.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.YOU);
            }

            if (C_YouhiblnkKbn.YOU.eq(hhknSakuinTsnSyoukaiKekkaBean.getDoujimosknkhndktyhkbn())) {

                pMP.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
            }
        }

        if (kykSakuinTsnSyoukaiKekkaBean != null) {

            if (C_BlnktkumuKbn.ARI.eq(kykSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn())) {

                pMP.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);
            }
            else {

                pMP.setKykTratkityuiUmuKbnMr(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(kykSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn())) {
                pMP.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
            }
            else{
                pMP.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(kykSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn())) {

                pMP.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
            }
            else {

                pMP.setKykTratkityuiUmuKbnSignal(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(kykSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn())) {

                pMP.setKykInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
            }
            else {

                pMP.setKykInfohnsyUmuKbnSignal(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(kykSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn())) {
                pMP.setKykGaikokupepsumukbn(C_UmuKbn.ARI);
            }
            else {
                pMP.setKykGaikokupepsumukbn(C_UmuKbn.NONE);
            }
            if (C_BlnktkumuKbn.ARI.eq(kykSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn())) {

                pMP.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);
            }
            else {

                pMP.setKykSinsntkhnsyumukbn(C_UmuKbn.NONE);
            }
            pMP.setKykTtdkTyuuiKnkHndktYhKbn(kykSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn());

            if (C_SysKbn.SKEI.eq(pMP.getSysKbn())) {

                for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getMosfkensuu(); n++) {

                    BzMousikomiFSakuinKekkaBean mosFSakuinKekkaBean =
                        kykSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist().get(n);

                    if (!BizUtil.isBlank(mosFSakuinKekkaBean.getMosfmosno())
                        && C_MossyoumetuKbn.MIKAKUTEI.eq(mosFSakuinKekkaBean.getMosfmossyoumetukbn())
                        && (C_KankeisyaKbn.KYK.eq(mosFSakuinKekkaBean.getMosfmoskankeisyakbn())
                            || C_KankeisyaKbn.HHKN_KYKDOUITU.eq(mosFSakuinKekkaBean.getMosfmoskankeisyakbn())
                            || C_KankeisyaKbn.DAI2HHKN_KYKDOUITU.eq(mosFSakuinKekkaBean.getMosfmoskankeisyakbn()))) {

                        skDjmosNoLstPal.add(mosFSakuinKekkaBean.getMosfmosno());
                    }
                }

                for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getSkkensuu(); n++) {

                    BzSinkeiyakuSakuinKekkaBean sinkeiyakuSakuinKekkaBean =
                        kykSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist().get(n);

                    if (!BizUtil.isBlank(sinkeiyakuSakuinKekkaBean.getSkmosno()) &&
                        !C_SeirituKbn.SEIRITU.eq(sinkeiyakuSakuinKekkaBean.getSkseiritukbn()) &&
                        !C_SeirituKbn.HUSEIRITU.eq(sinkeiyakuSakuinKekkaBean.getSkseiritukbn()) &&
                        !sinkeiyakuSakuinKekkaBean.getSkmosno().equals(mosNo)
                        && (C_KankeisyaKbn.KYK.eq(sinkeiyakuSakuinKekkaBean.getSkmoskankeisyakbn())
                            || C_KankeisyaKbn.HHKN_KYKDOUITU.eq(sinkeiyakuSakuinKekkaBean.getSkmoskankeisyakbn())
                            || C_KankeisyaKbn.DAI2HHKN_KYKDOUITU.eq(sinkeiyakuSakuinKekkaBean.getSkmoskankeisyakbn()))) {

                        skDjmosNoLstRay.add(sinkeiyakuSakuinKekkaBean.getSkmosno());
                    }
                }

                CheckDoujiMos checkDoujiMos = SWAKInjector.getInstance(CheckDoujiMos.class);
                checkDoujiMos.exec(pMP, skDjmosNoLstRay, skDjmosNoLstPal);
            }
        }

        if (uktSkinTsnSkKekkaBeanLst != null && uktSkinTsnSkKekkaBeanLst.size() != 0) {

            for (BzSakuinTsnSyoukaiKekkaBean ukeSkinTsnSkKekkaBean : uktSkinTsnSkKekkaBeanLst) {

                if (C_BlnktkumuKbn.ARI.eq(ukeSkinTsnSkKekkaBean.getSntkinfomrumukbn())) {

                    pMP.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(ukeSkinTsnSkKekkaBean.getSntkinfohnsyumukbn())) {

                    pMP.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(ukeSkinTsnSkKekkaBean.getSignalinfoumukbn())) {

                    pMP.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(ukeSkinTsnSkKekkaBean.getSignalinfohnsyumukbn())) {

                    pMP.setUktInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(ukeSkinTsnSkKekkaBean.getGaikokupepsumukbn())) {

                    pMP.setUktGaikokupepsumukbn(C_UmuKbn.ARI);
                }
                if (C_BlnktkumuKbn.ARI.eq(ukeSkinTsnSkKekkaBean.getSinsntkhnsyumukbn())) {

                    pMP.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);
                }

                if (C_YouhiblnkKbn.YOU.eq(ukeSkinTsnSkKekkaBean.getUktttdktyuuiknkhndktyhkbn())) {

                    pMP.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
                }
            }
        }

        if (kykDrnSkinTsnSkKekkaBeanLst != null && kykDrnSkinTsnSkKekkaBeanLst.size() != 0) {

            for (BzSakuinTsnSyoukaiKekkaBean kykDrnSkinTsnSkKekkaBean : kykDrnSkinTsnSkKekkaBeanLst) {

                if (C_BlnktkumuKbn.ARI.eq(kykDrnSkinTsnSkKekkaBean.getSntkinfomrumukbn())) {

                    pMP.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(kykDrnSkinTsnSkKekkaBean.getSntkinfohnsyumukbn())) {

                    pMP.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(kykDrnSkinTsnSkKekkaBean.getSignalinfoumukbn())) {

                    pMP.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(kykDrnSkinTsnSkKekkaBean.getSignalinfohnsyumukbn())) {

                    pMP.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(kykDrnSkinTsnSkKekkaBean.getGaikokupepsumukbn())) {

                    pMP.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(kykDrnSkinTsnSkKekkaBean.getSinsntkhnsyumukbn())) {

                    pMP.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
                }

                if (C_YouhiblnkKbn.YOU.eq(kykDrnSkinTsnSkKekkaBean.getUktttdktyuuiknkhndktyhkbn())) {

                    pMP.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
                }
            }
        }

        if (hhkDrnSkinTsnSkKekkaBeanLst != null && hhkDrnSkinTsnSkKekkaBeanLst.size() != 0) {

            for (BzSakuinTsnSyoukaiKekkaBean hhkDrnSkinTsnSkKekkaBean : hhkDrnSkinTsnSkKekkaBeanLst) {

                if (C_BlnktkumuKbn.ARI.eq(hhkDrnSkinTsnSkKekkaBean.getSntkinfomrumukbn())) {

                    pMP.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(hhkDrnSkinTsnSkKekkaBean.getSntkinfohnsyumukbn())) {

                    pMP.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(hhkDrnSkinTsnSkKekkaBean.getSignalinfoumukbn())) {

                    pMP.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(hhkDrnSkinTsnSkKekkaBean.getSignalinfohnsyumukbn())) {

                    pMP.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(hhkDrnSkinTsnSkKekkaBean.getGaikokupepsumukbn())) {

                    pMP.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);
                }

                if (C_BlnktkumuKbn.ARI.eq(hhkDrnSkinTsnSkKekkaBean.getSinsntkhnsyumukbn())) {

                    pMP.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);
                }

                if (C_YouhiblnkKbn.YOU.eq(hhkDrnSkinTsnSkKekkaBean.getUktttdktyuuiknkhndktyhkbn())) {

                    pMP.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.YOU);
                }
            }
        }

        if (hhknSakuinTsnSyoukaiKekkaBean != null) {

            HT_NayoseKekka nayoseKekka = new HT_NayoseKekka();

            if (C_SysKbn.SKEI.eq(sysKbn)) {
                if (C_UmuKbn.NONE.eq(mosKihon.getSeiymdmosseitouumukbn())) {

                    for (int n = 0; n < hhknSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(); n++) {

                        BzKeiyakuMfSakuinKekkaBean kykMfSakuinKekkaBean =
                            hhknSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().get(n);

                        if (C_KykJyoutaiKbn.YUUKOU.eq((kykMfSakuinKekkaBean.getKykmfkykjyoutaikbn())) &&
                            BizDateUtil.compareYmd(hhknseiYmd,
                                kykMfSakuinKekkaBean.getKykmftaisyouseiymd()) != BizDateUtil.COMPARE_EQUAL) {

                            setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                C_SpKeisanKahiKbn.SPKEISANKA,
                                C_HubisyubetusyousaiKbn.NONE,
                                makeMsg(MessageId.EHC1018, MessageId.EHC1018, ICommonKoumoku.DISP_S_HHKNSEIYMD),
                                pMP,
                                C_TknKbn.NONE,
                                C_MsgKbn.ERROR);

                            hhknseiYmdFlg = true;
                            break;
                        }
                    }

                    if (!hhknseiYmdFlg) {

                        for (int n = 0; n < hhknSakuinTsnSyoukaiKekkaBean.getKhkensuu(); n++) {

                            BzKeiyakuHozenSakuinKekkaBean kykHozenSakuinKekkaBean =
                                hhknSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(n);

                            if (C_YuukousyoumetuKbn.YUUKOU.eq((kykHozenSakuinKekkaBean.getKhyuukousyoumetukbn())) &&
                                BizDateUtil.compareYmd(
                                    hhknseiYmd, kykHozenSakuinKekkaBean.getKhtaisyouseiymd()) != BizDateUtil.COMPARE_EQUAL) {

                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    C_SpKeisanKahiKbn.SPKEISANKA,
                                    C_HubisyubetusyousaiKbn.NONE,
                                    makeMsg(MessageId.EHC1018, MessageId.EHC1018, ICommonKoumoku.DISP_S_HHKNSEIYMD),
                                    pMP,
                                    C_TknKbn.NONE,
                                    C_MsgKbn.ERROR);

                                break;
                            }
                        }
                    }
                }
            }

            if (C_SysKbn.SKEI.eq(sysKbn)) {

                nayoseKekka.setSyoriCTL(syoriCTL);
                nayoseKekka.setMosno(mosNo);
                nayoseKekka.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYA);
                nayoseKekka.setEdano(1);
                nayoseKekka.setSakuinnmno(hhknSakuinTsnSyoukaiKekkaBean.getSakuinnmno());
                nayoseKekka.setNysjissikekkakbn(hhknSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn());
                nayoseKekka.setNysjyoutaikbn(hhknSakuinTsnSyoukaiKekkaBean.getNysjyoutaikbn());
                nayoseKekka.setSakuininfosyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn());
                nayoseKekka.setMrsyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn());
                nayoseKekka.setSignalsyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getSignalsyoukaierrkbn());
                nayoseKekka.setSinsntkhnsysyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn());
                nayoseKekka.setTsngksyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getTsngksyoukaierrkbn());
                nayoseKekka.setKykdrtentsnssyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn());
                nayoseKekka.setMossakuseikahisyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getMossakuseikahisyoukaierrkbn());
                nayoseKekka.setHndketyhsyoukaierrkbn(hhknSakuinTsnSyoukaiKekkaBean.getHndketyhsyoukaierrkbn());
                nayoseKekka.setSntkinfomrumukbn(hhknSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn());
                nayoseKekka.setSntkinfohnsyumukbn(hhknSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn());
                nayoseKekka.setSignalsetteiumukbn(hhknSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn());
                nayoseKekka.setSignalinfohnsyumukbn(hhknSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn());
                nayoseKekka.setGaikokupepsumukbn(hhknSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn());
                nayoseKekka.setSinsntkhnsyumukbn(hhknSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn());
                nayoseKekka.setItekisntkhndktyhkbn(hhknSakuinTsnSyoukaiKekkaBean.getItekisntkhndktyhkbn());
                nayoseKekka.setTtdktyuuiknkhndktyhkbn(hhknSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn());
                nayoseKekka.setKyhkinuktkariitkhndktyhkbn(hhknSakuinTsnSyoukaiKekkaBean.getKyhkinuktkariitkhndktyhkbn());
                nayoseKekka.setDoujimositekihndktyhkbn(hhknSakuinTsnSyoukaiKekkaBean.getDoujimositekihndktyhkbn());
                nayoseKekka.setDoujimosknkhndktyhkbn(hhknSakuinTsnSyoukaiKekkaBean.getDoujimosknkhndktyhkbn());
                nayoseKekka.setGyoumuKousinsyaId(kosID);
                nayoseKekka.setGyoumuKousinTime(pMP.getKosTime());

                BizPropertyInitializer.initialize(nayoseKekka);
                hkgoNayoseKekkaLst.add(nayoseKekka);
            }

            if (C_SysKbn.SKEI.eq(sysKbn)) {

                sentakujohokousin(hhknSakuinTsnSyoukaiKekkaBean,
                    hkgoSentakuJyouhouLst,
                    C_SntkInfoTaisyousyaKbn.HIHOKENSYA,
                    mosNo,
                    syoriCTL,
                    1,
                    kosID,
                    pMP.getKosTime());
            }

            if (tuusan == null) {

                tuusan = syoriCTL.createTuusan();
            }

            tuusan.setTsnsibous(hhknSakuinTsnSyoukaiKekkaBean.getTsnsibous());
            tuusan.setTsnninenmikeikas(hhknSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikas());
            tuusan.setTsnninenkeikas(hhknSakuinTsnSyoukaiKekkaBean.getTsnninenkeikas());
            tuusan.setTsnninenmikeikahtnkns(hhknSakuinTsnSyoukaiKekkaBean.getTsnninenmikeikahtnkns());
            tuusan.setTsnninenkeikadfp(hhknSakuinTsnSyoukaiKekkaBean.getTsnninenkeikadfp());
            tuusan.setTsnketsibous(hhknSakuinTsnSyoukaiKekkaBean.getTsnketsibous());
            tuusan.setTsnketsibous2(hhknSakuinTsnSyoukaiKekkaBean.getTsnketsibous2());
            tuusan.setTsnsoukktjituhsgk(hhknSakuinTsnSyoukaiKekkaBean.getTsnsoukktjituhsgk());
            tuusan.setTsnkktjituhsgk1(hhknSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk1());
            tuusan.setTsnkktjituhsgk2(hhknSakuinTsnSyoukaiKekkaBean.getTsnkktjituhsgk2());
            tuusan.setTsnkktitijibrsysnjs(hhknSakuinTsnSyoukaiKekkaBean.getTsnkktitijibrsysnjs());
            tuusan.setTsnnkgns(hhknSakuinTsnSyoukaiKekkaBean.getTsnnkgns());
            tuusan.setTsnmsnynenbtsousbus(hhknSakuinTsnSyoukaiKekkaBean.getTsnmsnynenbtsousbus());
            tuusan.setTsnnenbtitijibrssbs(hhknSakuinTsnSyoukaiKekkaBean.getTsnnenbtitijibrssbs());
            tuusan.setTsnitijibrsysnp(hhknSakuinTsnSyoukaiKekkaBean.getTsnitijibrsysnp());
            tuusan.setTsnsntktuukahijynsysns(hhknSakuinTsnSyoukaiKekkaBean.getTsnsntktuukahijynsysns());
            tuusan.setTsnkaigomehrtkumukbn(hhknSakuinTsnSyoukaiKekkaBean.getTsnkaigomehrtkumukbn());
            tuusan.setGyoumuKousinsyaId(kosID);
            tuusan.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(tuusan);

            tuusanSetteiFlg = true;
        }

        if (kykSakuinTsnSyoukaiKekkaBean != null) {

            HT_NayoseKekka nayoseKekka = new HT_NayoseKekka();
            boolean sirajiKykkbnFlg = false;

            for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(); n++) {

                BzKeiyakuMfSakuinKekkaBean kykMfSakuinKekkaBean =
                    kykSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().get(n);

                if (C_KykJyoutaiKbn.YUUKOU.eq(kykMfSakuinKekkaBean.getKykmfkykjyoutaikbn()) &&
                    (C_KankeisyaKbn.KYK.eq(kykMfSakuinKekkaBean.getKykmfkykkankeisyakbn())
                        || C_KankeisyaKbn.HHKN_KYKDOUITU.eq(kykMfSakuinKekkaBean.getKykmfkykkankeisyakbn()))) {

                    sirajiKykkbnFlg = true;
                }
            }

            if (!sirajiKykkbnFlg) {

                for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getKhkensuu(); n++) {

                    BzKeiyakuHozenSakuinKekkaBean kykHozenSakuinKekkaBean =
                        kykSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(n);

                    if (C_YuukousyoumetuKbn.YUUKOU.eq(kykHozenSakuinKekkaBean.getKhyuukousyoumetukbn()) &&
                        (C_KankeisyaKbn.KYK.eq(kykHozenSakuinKekkaBean.getKhkykkankeisyakbn()) ||
                            C_KankeisyaKbn.HHKN_KYKDOUITU.eq(kykHozenSakuinKekkaBean.getKhkykkankeisyakbn()))) {

                        sirajiKykkbnFlg = true;
                    }
                }
            }

            if (!sirajiKykkbnFlg) {

                for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getMosfkensuu(); n++) {

                    BzMousikomiFSakuinKekkaBean mosFSakuinKekkaBean =
                        kykSakuinTsnSyoukaiKekkaBean.getBzmousikomifsakuinkekkabeanlist().get(n);

                    if ((C_MossyoumetuKbn.MIKAKUTEI.eq(mosFSakuinKekkaBean.getMosfmossyoumetukbn()) ||
                        C_MossyoumetuKbn.SEIRITU.eq(mosFSakuinKekkaBean.getMosfmossyoumetukbn()) ||
                        C_MossyoumetuKbn.KOKOSEIRITU_KARISEIRITU.eq(mosFSakuinKekkaBean.getMosfmossyoumetukbn())) &&
                        (C_KankeisyaKbn.KYK.eq(mosFSakuinKekkaBean.getMosfmoskankeisyakbn()) ||
                            C_KankeisyaKbn.HHKN_KYKDOUITU.eq(mosFSakuinKekkaBean.getMosfmoskankeisyakbn()))) {

                        sirajiKykkbnFlg = true;
                    }
                }
            }

            if (!sirajiKykkbnFlg) {

                for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getSkkensuu(); n++) {

                    BzSinkeiyakuSakuinKekkaBean skeiSakuinKekkaBean =
                        kykSakuinTsnSyoukaiKekkaBean.getBzsinkeiyakusakuinkekkabeanlist().get(n);

                    if ((C_SeirituKbn.NONE.eq(skeiSakuinKekkaBean.getSkseiritukbn()) ||
                        C_SeirituKbn.SEIRITU.eq(skeiSakuinKekkaBean.getSkseiritukbn()) ||
                        C_SeirituKbn.ITIPMATI.eq(skeiSakuinKekkaBean.getSkseiritukbn())) &&
                        (C_KankeisyaKbn.KYK.eq(skeiSakuinKekkaBean.getSkmoskankeisyakbn()) ||
                            C_KankeisyaKbn.HHKN_KYKDOUITU.eq(skeiSakuinKekkaBean.getSkmoskankeisyakbn()))) {

                        sirajiKykkbnFlg = true;
                    }
                }
            }

            C_SirajiKykKbn sirajiKykKbn;
            if (sirajiKykkbnFlg) {

                sirajiKykKbn = C_SirajiKykKbn.SIRAJIKEIYAKUIGAI;
            }
            else {

                sirajiKykKbn = C_SirajiKykKbn.SIRAJIKEIYAKU;
            }

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    if (C_UmuKbn.NONE.eq(mosKihon.getSeiymdmosseitouumukbn())) {

                        for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getKykmfkensuu(); n++) {

                            BzKeiyakuMfSakuinKekkaBean kykMfSakuinKekkaBean =
                                kykSakuinTsnSyoukaiKekkaBean.getBzkeiyakumfsakuinkekkabeanlist().get(n);

                            if (C_KykJyoutaiKbn.YUUKOU.eq((kykMfSakuinKekkaBean.getKykmfkykjyoutaikbn())) &&
                                BizDateUtil.compareYmd(
                                    kykseiYmd, kykMfSakuinKekkaBean.getKykmftaisyouseiymd()) != BizDateUtil.COMPARE_EQUAL) {

                                setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                    C_SpKeisanKahiKbn.SPKEISANKA,
                                    C_HubisyubetusyousaiKbn.NONE,
                                    makeMsg(MessageId.EHC1018, MessageId.EHC1018, ICommonKoumoku.DISP_S_KYKSEIYMD),
                                    pMP,
                                    C_TknKbn.NONE,
                                    C_MsgKbn.ERROR);

                                kykseiYmdFlg = true;
                                break;
                            }
                        }

                        if (!kykseiYmdFlg) {

                            for (int n = 0; n < kykSakuinTsnSyoukaiKekkaBean.getKhkensuu(); n++) {

                                BzKeiyakuHozenSakuinKekkaBean kykHozenSakuinKekkaBean =
                                    kykSakuinTsnSyoukaiKekkaBean.getBzkeiyakuhozensakuinkekkabeanlist().get(n);

                                if (C_YuukousyoumetuKbn.YUUKOU.eq((kykHozenSakuinKekkaBean.getKhyuukousyoumetukbn())) &&
                                    BizDateUtil.compareYmd(
                                        kykseiYmd, kykHozenSakuinKekkaBean.getKhtaisyouseiymd()) != BizDateUtil.COMPARE_EQUAL) {

                                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                                        C_SpKeisanKahiKbn.SPKEISANKA,
                                        C_HubisyubetusyousaiKbn.NONE,
                                        makeMsg(MessageId.EHC1018, MessageId.EHC1018, ICommonKoumoku.DISP_S_KYKSEIYMD),
                                        pMP,
                                        C_TknKbn.NONE,
                                        C_MsgKbn.ERROR);

                                    break;
                                }
                            }
                        }
                    }

                }
            }

            if (C_SysKbn.SKEI.eq(sysKbn)) {

                nayoseKekka.setSyoriCTL(syoriCTL);
                nayoseKekka.setMosno(mosNo);
                nayoseKekka.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYA);
                nayoseKekka.setEdano(1);
                nayoseKekka.setSakuinnmno(kykSakuinTsnSyoukaiKekkaBean.getSakuinnmno());
                nayoseKekka.setNysjissikekkakbn(kykSakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn());
                nayoseKekka.setNysjyoutaikbn(kykSakuinTsnSyoukaiKekkaBean.getNysjyoutaikbn());
                nayoseKekka.setSakuininfosyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getSakuininfosyoukaierrkbn());
                nayoseKekka.setMrsyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn());
                nayoseKekka.setSignalsyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getSignalsyoukaierrkbn());
                nayoseKekka.setSinsntkhnsysyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn());
                nayoseKekka.setTsngksyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getTsngksyoukaierrkbn());
                nayoseKekka.setKykdrtentsnssyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getKykdrtentsnssyoukaierrkbn());
                nayoseKekka.setMossakuseikahisyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getMossakuseikahisyoukaierrkbn());
                nayoseKekka.setHndketyhsyoukaierrkbn(kykSakuinTsnSyoukaiKekkaBean.getHndketyhsyoukaierrkbn());
                nayoseKekka.setSntkinfomrumukbn(kykSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn());
                nayoseKekka.setSntkinfohnsyumukbn(kykSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn());
                nayoseKekka.setSignalsetteiumukbn(kykSakuinTsnSyoukaiKekkaBean.getSignalinfoumukbn());
                nayoseKekka.setSignalinfohnsyumukbn(kykSakuinTsnSyoukaiKekkaBean.getSignalinfohnsyumukbn());
                nayoseKekka.setGaikokupepsumukbn(kykSakuinTsnSyoukaiKekkaBean.getGaikokupepsumukbn());
                nayoseKekka.setSinsntkhnsyumukbn(kykSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn());
                nayoseKekka.setItekisntkhndktyhkbn(kykSakuinTsnSyoukaiKekkaBean.getItekisntkhndktyhkbn());
                nayoseKekka.setTtdktyuuiknkhndktyhkbn(kykSakuinTsnSyoukaiKekkaBean.getTtdktyuuiknkhndktyhkbn());
                nayoseKekka.setKyhkinuktkariitkhndktyhkbn(kykSakuinTsnSyoukaiKekkaBean.getKyhkinuktkariitkhndktyhkbn());
                nayoseKekka.setDoujimositekihndktyhkbn(kykSakuinTsnSyoukaiKekkaBean.getDoujimositekihndktyhkbn());
                nayoseKekka.setDoujimosknkhndktyhkbn(kykSakuinTsnSyoukaiKekkaBean.getDoujimosknkhndktyhkbn());
                nayoseKekka.setSirajikykkbn(sirajiKykKbn);
                nayoseKekka.setGyoumuKousinsyaId(kosID);
                nayoseKekka.setGyoumuKousinTime(pMP.getKosTime());

                BizPropertyInitializer.initialize(nayoseKekka);

                hkgoNayoseKekkaLst.add(nayoseKekka);

            }

            if (C_SysKbn.SKEI.eq(sysKbn)) {

                if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                    sentakujohokousin(kykSakuinTsnSyoukaiKekkaBean,
                        hkgoSentakuJyouhouLst,
                        C_SntkInfoTaisyousyaKbn.KEIYAKUSYA,
                        mosNo,
                        syoriCTL,
                        1,
                        kosID,
                        pMP.getKosTime());
                }
            }

            if (!tuusanSetteiFlg) {

                if (tuusan == null) {

                    tuusan = syoriCTL.createTuusan();
                }

                tuusan.setGyoumuKousinsyaId(kosID);
                tuusan.setGyoumuKousinTime(pMP.getKosTime());
            }

            tuusan.setKykdrtentsns(kykSakuinTsnSyoukaiKekkaBean.getKykdrtentsns());

            BizPropertyInitializer.initialize(tuusan);

            tuusanSetteiFlg = true;
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {

            if (uktSkinTsnSkKekkaBeanLst != null && uktSkinTsnSkKekkaBeanLst.size() != 0) {

                for (int n = 0; n <  uktSkinTsnSkKekkaBeanLst.size(); n++) {

                    HT_NayoseKekka nayoseKekka = new HT_NayoseKekka();

                    nayoseKekka.setSyoriCTL(syoriCTL);
                    nayoseKekka.setMosno(mosNo);
                    nayoseKekka.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.UKETORININ);
                    nayoseKekka.setEdano(n + 1);
                    nayoseKekka.setNysjissikekkakbn(uktSkinTsnSkKekkaBeanLst.get(n).getNysjissikekkakbn());
                    nayoseKekka.setNysjyoutaikbn(uktSkinTsnSkKekkaBeanLst.get(n).getNysjyoutaikbn());
                    nayoseKekka.setSakuininfosyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getSakuininfosyoukaierrkbn());
                    nayoseKekka.setMrsyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getMrsyoukaierrkbn());
                    nayoseKekka.setSignalsyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getSignalsyoukaierrkbn());
                    nayoseKekka.setSinsntkhnsysyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getSinsntkhnsysyoukaierrkbn());
                    nayoseKekka.setTsngksyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getTsngksyoukaierrkbn());
                    nayoseKekka.setKykdrtentsnssyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getKykdrtentsnssyoukaierrkbn());
                    nayoseKekka.setMossakuseikahisyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getMossakuseikahisyoukaierrkbn());
                    nayoseKekka.setHndketyhsyoukaierrkbn(uktSkinTsnSkKekkaBeanLst.get(n).getHndketyhsyoukaierrkbn());
                    nayoseKekka.setSntkinfomrumukbn(uktSkinTsnSkKekkaBeanLst.get(n).getSntkinfomrumukbn());
                    nayoseKekka.setSntkinfohnsyumukbn(uktSkinTsnSkKekkaBeanLst.get(n).getSntkinfohnsyumukbn());
                    nayoseKekka.setSignalsetteiumukbn(uktSkinTsnSkKekkaBeanLst.get(n).getSignalinfoumukbn());
                    nayoseKekka.setSignalinfohnsyumukbn(uktSkinTsnSkKekkaBeanLst.get(n).getSignalinfohnsyumukbn());
                    nayoseKekka.setGaikokupepsumukbn(uktSkinTsnSkKekkaBeanLst.get(n).getGaikokupepsumukbn());
                    nayoseKekka.setSinsntkhnsyumukbn(uktSkinTsnSkKekkaBeanLst.get(n).getSinsntkhnsyumukbn());
                    nayoseKekka.setTtdktyuuiknkhndktyhkbn(uktSkinTsnSkKekkaBeanLst.get(n).getUktttdktyuuiknkhndktyhkbn());
                    nayoseKekka.setGyoumuKousinsyaId(kosID);
                    nayoseKekka.setGyoumuKousinTime(pMP.getKosTime());

                    BizPropertyInitializer.initialize(nayoseKekka);

                    hkgoNayoseKekkaLst.add(nayoseKekka);

                    sentakujohokousin(uktSkinTsnSkKekkaBeanLst.get(n),
                        hkgoSentakuJyouhouLst,
                        C_SntkInfoTaisyousyaKbn.UKETORININ,
                        mosNo,
                        syoriCTL,
                        n + 1,
                        kosID,
                        pMP.getKosTime());
                }
            }

            if (kykDrnSkinTsnSkKekkaBeanLst != null && kykDrnSkinTsnSkKekkaBeanLst.size() != 0) {

                for (int n = 0; n <  kykDrnSkinTsnSkKekkaBeanLst.size(); n++) {

                    HT_NayoseKekka nayoseKekka = new HT_NayoseKekka();

                    nayoseKekka.setSyoriCTL(syoriCTL);
                    nayoseKekka.setMosno(mosNo);
                    nayoseKekka.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ);
                    nayoseKekka.setEdano(n + 1);
                    nayoseKekka.setNysjissikekkakbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getNysjissikekkakbn());
                    nayoseKekka.setNysjyoutaikbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getNysjyoutaikbn());
                    nayoseKekka.setSakuininfosyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSakuininfosyoukaierrkbn());
                    nayoseKekka.setMrsyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getMrsyoukaierrkbn());
                    nayoseKekka.setSignalsyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSignalsyoukaierrkbn());
                    nayoseKekka.setSinsntkhnsysyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSinsntkhnsysyoukaierrkbn());
                    nayoseKekka.setTsngksyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getTsngksyoukaierrkbn());
                    nayoseKekka.setKykdrtentsnssyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getKykdrtentsnssyoukaierrkbn());
                    nayoseKekka.setMossakuseikahisyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getMossakuseikahisyoukaierrkbn());
                    nayoseKekka.setHndketyhsyoukaierrkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getHndketyhsyoukaierrkbn());
                    nayoseKekka.setSntkinfomrumukbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSntkinfomrumukbn());
                    nayoseKekka.setSntkinfohnsyumukbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSntkinfohnsyumukbn());
                    nayoseKekka.setSignalsetteiumukbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSignalinfoumukbn());
                    nayoseKekka.setSignalinfohnsyumukbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSignalinfohnsyumukbn());
                    nayoseKekka.setGaikokupepsumukbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getGaikokupepsumukbn());
                    nayoseKekka.setSinsntkhnsyumukbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getSinsntkhnsyumukbn());
                    nayoseKekka.setTtdktyuuiknkhndktyhkbn(kykDrnSkinTsnSkKekkaBeanLst.get(n).getUktttdktyuuiknkhndktyhkbn());
                    nayoseKekka.setGyoumuKousinsyaId(kosID);
                    nayoseKekka.setGyoumuKousinTime(pMP.getKosTime());

                    BizPropertyInitializer.initialize(nayoseKekka);

                    hkgoNayoseKekkaLst.add(nayoseKekka);

                    sentakujohokousin(kykDrnSkinTsnSkKekkaBeanLst.get(n),
                        hkgoSentakuJyouhouLst,
                        C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ,
                        mosNo,
                        syoriCTL,
                        n + 1,
                        kosID,
                        pMP.getKosTime());
                }
            }

            if (hhkDrnSkinTsnSkKekkaBeanLst != null && hhkDrnSkinTsnSkKekkaBeanLst.size() != 0) {

                for (int n = 0; n <  hhkDrnSkinTsnSkKekkaBeanLst.size(); n++) {

                    HT_NayoseKekka nayoseKekka = new HT_NayoseKekka();

                    nayoseKekka.setSyoriCTL(syoriCTL);
                    nayoseKekka.setMosno(mosNo);
                    nayoseKekka.setSntkinfotaisyousyakbn(C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ);
                    nayoseKekka.setEdano(n + 1);
                    nayoseKekka.setNysjissikekkakbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getNysjissikekkakbn());
                    nayoseKekka.setNysjyoutaikbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getNysjyoutaikbn());
                    nayoseKekka.setSakuininfosyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSakuininfosyoukaierrkbn());
                    nayoseKekka.setMrsyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getMrsyoukaierrkbn());
                    nayoseKekka.setSignalsyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSignalsyoukaierrkbn());
                    nayoseKekka.setSinsntkhnsysyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSinsntkhnsysyoukaierrkbn());
                    nayoseKekka.setTsngksyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getTsngksyoukaierrkbn());
                    nayoseKekka.setKykdrtentsnssyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getKykdrtentsnssyoukaierrkbn());
                    nayoseKekka.setMossakuseikahisyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getMossakuseikahisyoukaierrkbn());
                    nayoseKekka.setHndketyhsyoukaierrkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getHndketyhsyoukaierrkbn());
                    nayoseKekka.setSntkinfomrumukbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSntkinfomrumukbn());
                    nayoseKekka.setSntkinfohnsyumukbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSntkinfohnsyumukbn());
                    nayoseKekka.setSignalsetteiumukbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSignalinfoumukbn());
                    nayoseKekka.setSignalinfohnsyumukbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSignalinfohnsyumukbn());
                    nayoseKekka.setGaikokupepsumukbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getGaikokupepsumukbn());
                    nayoseKekka.setSinsntkhnsyumukbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getSinsntkhnsyumukbn());
                    nayoseKekka.setTtdktyuuiknkhndktyhkbn(hhkDrnSkinTsnSkKekkaBeanLst.get(n).getUktttdktyuuiknkhndktyhkbn());
                    nayoseKekka.setGyoumuKousinsyaId(kosID);
                    nayoseKekka.setGyoumuKousinTime(pMP.getKosTime());

                    BizPropertyInitializer.initialize(nayoseKekka);

                    hkgoNayoseKekkaLst.add(nayoseKekka);

                    sentakujohokousin(hhkDrnSkinTsnSkKekkaBeanLst.get(n),
                        hkgoSentakuJyouhouLst,
                        C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ,
                        mosNo,
                        syoriCTL,
                        n + 1,
                        kosID,
                        pMP.getKosTime());
                }
            }
        }

        if (C_SysKbn.ESHIEN.eq(sysKbn) && C_KouzokujkKbn.NONE.eq(pMP.getKouzokuSyoriJikkouKbn())) {

            logger.debug("△ 名寄せ処理 終了");

            return;
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {

            if (hkgoNayoseKekkaLst != null && hkgoNayoseKekkaLst.size() > 0) {

                List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();

                BizEntityUtil.exchange(nayoseKekkaLst, hkgoNayoseKekkaLst);
            }
            else {

                List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();

                if (nayoseKekkaLst != null && nayoseKekkaLst.size() > 0) {

                    nayoseKekkaLst.clear();
                }
            }

            if (hkgoSentakuJyouhouLst != null && hkgoSentakuJyouhouLst.size() > 0) {

                List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();

                BizEntityUtil.exchange(sentakuJyouhouLst, hkgoSentakuJyouhouLst);
            }
            else {

                List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();

                if (sentakuJyouhouLst != null && sentakuJyouhouLst.size() > 0) {

                    sentakuJyouhouLst.clear();
                }
            }

        }

        if (tuusan != null && !tuusanSetteiFlg) {
            syoriCTL.setTuusan(null);
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            dskoknokousin(mosKihon);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 名寄せ処理 終了");
        }
    }

    private BzSakuinTsnSyoukaiKekkaBean nayose(MosnaiCheckParam pMP, HT_MosKihon pMosKihon, String pShubetu) {

        if (BizUtil.isBlank(taisyouNmKn) || taisyouseiYmd == null) {

            return null;
        }

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        HT_MosKihon mosKihon = pMosKihon;
        String mosNo = syoriCTL.getMosno();
        BzSakuinTsnSyoukaiYokenBean skinTsnSkYokenBean = SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);
        List<String> kankeisyaNmKnLst = new ArrayList<>();
        List<String> kankeisyaNmKjLst = new ArrayList<>();
        String bancd = "";
        String sitencd = "";
        C_YokinKbn yokinkbn = C_YokinKbn.BLNK;
        String kouzano = "";
        String msg = null;
        C_YouhiKbn sakuinjhSkYhkbn = C_YouhiKbn.HUYOU;
        C_SakuintaisyoukykKbn sakuinTaisyouKykKbn = C_SakuintaisyoukykKbn.BLNK;
        C_Huho2kyknoKbn sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
        String sakuinHuho2Kykno = "";
        BizDate sakuinKijunYmd = null;
        C_YouhiKbn mrSignalSyoukaiYhkbn = C_YouhiKbn.HUYOU;
        C_MrsignalhanteigyoumuKbn mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.BLNK;
        C_YouhiKbn tsngkSyoukaiYhkbn = C_YouhiKbn.HUYOU;
        C_Huho2kyknoKbn tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
        String tsnTsgHuho2Kykno = "";
        BizDate tsnKijunYmd = null;
        C_YouhiKbn kykdrtenTsnsSkYhkbn = C_YouhiKbn.HUYOU;
        C_Huho2kyknoKbn drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
        String drtenTsnTsgHuho2Kykno = "";
        BizDate kykdrtenTsnKijyunYmd = null;
        String drtenCd1 = "";
        String drtenCd2 = "";
        C_YouhiKbn mosSakuseiKahiSkYhkbn = C_YouhiKbn.HUYOU;
        C_YouhiKbn handKetteiYhkbn = C_YouhiKbn.HUYOU;
        boolean enKouzaHanteiFlag = false;

        if (C_SysKbn.ESHIEN.eq(pMP.getSysKbn())) {

            if (KEIYAKUSYA.equals(pShubetu)) {

                sakuinjhSkYhkbn = C_YouhiKbn.YOU;
                sakuinTaisyouKykKbn = sakuinTaisyoukykKbn;
                sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                sakuinHuho2Kykno = "";
                sakuinKijunYmd = pMP.getSysDate();
                mrSignalSyoukaiYhkbn = C_YouhiKbn.YOU;
                mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI;
                tsngkSyoukaiYhkbn = C_YouhiKbn.HUYOU;
                tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                tsnTsgHuho2Kykno = "";
                tsnKijunYmd = null;
                kykdrtenTsnsSkYhkbn = C_YouhiKbn.HUYOU;
                drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                drtenTsnTsgHuho2Kykno = "";
                kykdrtenTsnKijyunYmd = null;
                mosSakuseiKahiSkYhkbn = C_YouhiKbn.HUYOU;
                handKetteiYhkbn = C_YouhiKbn.YOU;
            }

            if (HIHOKENSYA.equals(pShubetu)) {

                sakuinjhSkYhkbn = C_YouhiKbn.YOU;
                sakuinTaisyouKykKbn = sakuinTaisyoukykKbn;
                sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                sakuinHuho2Kykno = "";
                sakuinKijunYmd = pMP.getSysDate();
                mrSignalSyoukaiYhkbn = C_YouhiKbn.YOU;
                mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI;
                tsngkSyoukaiYhkbn = C_YouhiKbn.YOU;
                tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                tsnTsgHuho2Kykno = "";
                tsnKijunYmd = pMosKihon.getMosymd();
                kykdrtenTsnsSkYhkbn = C_YouhiKbn.HUYOU;
                drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                drtenTsnTsgHuho2Kykno = "";
                kykdrtenTsnKijyunYmd = null;
                mosSakuseiKahiSkYhkbn = C_YouhiKbn.YOU;
                handKetteiYhkbn = C_YouhiKbn.YOU;
            }

            if (UKETORININ.equals(pShubetu) ||
                KEIYAKUSYADAIRININ.equals(pShubetu) ||
                HIHOKENSYADAIRININ.equals(pShubetu)) {

                sakuinjhSkYhkbn = C_YouhiKbn.HUYOU;
                sakuinTaisyouKykKbn = C_SakuintaisyoukykKbn.BLNK;
                sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                sakuinHuho2Kykno = "";
                sakuinKijunYmd = null;
                mrSignalSyoukaiYhkbn = C_YouhiKbn.YOU;
                mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI;
                tsngkSyoukaiYhkbn = C_YouhiKbn.HUYOU;
                tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                tsnTsgHuho2Kykno = "";
                tsnKijunYmd = null;
                kykdrtenTsnsSkYhkbn = C_YouhiKbn.HUYOU;
                drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                drtenTsnTsgHuho2Kykno = "";
                kykdrtenTsnKijyunYmd = null;
                mosSakuseiKahiSkYhkbn = C_YouhiKbn.HUYOU;
                handKetteiYhkbn = C_YouhiKbn.YOU;
            }
        }
        else {

            if (KEIYAKUSYA.equals(pShubetu)) {

                sakuinjhSkYhkbn = C_YouhiKbn.YOU;
                sakuinTaisyouKykKbn = sakuinTaisyoukykKbn;
                sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                sakuinHuho2Kykno = mosNo;
                sakuinKijunYmd = pMP.getSysDate();
                mrSignalSyoukaiYhkbn = C_YouhiKbn.YOU;
                mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.SKEI;
                tsngkSyoukaiYhkbn = C_YouhiKbn.HUYOU;
                tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                tsnTsgHuho2Kykno = "";
                tsnKijunYmd = null;
                kykdrtenTsnsSkYhkbn = C_YouhiKbn.YOU;
                drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                drtenTsnTsgHuho2Kykno = mosNo;
                kykdrtenTsnKijyunYmd = pMosKihon.getMosymd();
                mosSakuseiKahiSkYhkbn = C_YouhiKbn.HUYOU;
                handKetteiYhkbn = C_YouhiKbn.YOU;

                List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
                int mosDairitenCounter = 0;
                for (HT_MosDairiten mosDairiten : mosDairitenLst) {

                    if (mosDairitenCounter == 0) {

                        drtenCd1 = mosDairiten.getOyadrtencd();
                    }
                    else {

                        drtenCd2 = mosDairiten.getOyadrtencd();
                    }

                    mosDairitenCounter = mosDairitenCounter + 1;
                }
            }

            if (HIHOKENSYA.equals(pShubetu)) {
                if (C_KykKbn.KEIHI_DOUITU.eq(pMosKihon.getKykkbn())) {
                    sakuinjhSkYhkbn = C_YouhiKbn.YOU;
                    sakuinTaisyouKykKbn = sakuinTaisyoukykKbn;
                    sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                    sakuinHuho2Kykno = mosNo;
                    sakuinKijunYmd = pMP.getSysDate();
                    mrSignalSyoukaiYhkbn = C_YouhiKbn.YOU;
                    mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.SKEI;
                    tsngkSyoukaiYhkbn = C_YouhiKbn.YOU;
                    tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                    tsnTsgHuho2Kykno = mosNo;
                    tsnKijunYmd = pMosKihon.getMosymd();
                    kykdrtenTsnsSkYhkbn = C_YouhiKbn.YOU;
                    drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                    drtenTsnTsgHuho2Kykno = mosNo;
                    kykdrtenTsnKijyunYmd = pMosKihon.getMosymd();
                    mosSakuseiKahiSkYhkbn = C_YouhiKbn.HUYOU;
                    handKetteiYhkbn = C_YouhiKbn.YOU;

                    List<HT_MosDairiten> mosDairitenLst = syoriCTL.getMosDairitens();
                    int mosDairitenCounter = 0;
                    for (HT_MosDairiten mosDairiten : mosDairitenLst) {

                        if (mosDairitenCounter == 0) {

                            drtenCd1 = mosDairiten.getOyadrtencd();
                        }
                        else {

                            drtenCd2 = mosDairiten.getOyadrtencd();
                        }

                        mosDairitenCounter = mosDairitenCounter + 1;
                    }
                }
                else {
                    sakuinjhSkYhkbn = C_YouhiKbn.YOU;
                    sakuinTaisyouKykKbn = sakuinTaisyoukykKbn;
                    sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                    sakuinHuho2Kykno = mosNo;
                    sakuinKijunYmd = pMP.getSysDate();
                    mrSignalSyoukaiYhkbn = C_YouhiKbn.YOU;
                    mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.SKEI;
                    tsngkSyoukaiYhkbn = C_YouhiKbn.YOU;
                    tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                    tsnTsgHuho2Kykno = mosNo;
                    tsnKijunYmd = pMosKihon.getMosymd();
                    kykdrtenTsnsSkYhkbn = C_YouhiKbn.HUYOU;
                    drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                    drtenTsnTsgHuho2Kykno = "";
                    kykdrtenTsnKijyunYmd = null;
                    mosSakuseiKahiSkYhkbn = C_YouhiKbn.HUYOU;
                    handKetteiYhkbn = C_YouhiKbn.YOU;
                }
            }

            if (UKETORININ.equals(pShubetu) ||
                KEIYAKUSYADAIRININ.equals(pShubetu) ||
                HIHOKENSYADAIRININ.equals(pShubetu)) {

                sakuinjhSkYhkbn = C_YouhiKbn.YOU;
                sakuinTaisyouKykKbn = sakuinTaisyoukykKbn;
                sakuinHuho2KyknoKbn = C_Huho2kyknoKbn.MOSNO;
                sakuinHuho2Kykno = mosNo;
                sakuinKijunYmd = pMP.getSysDate();
                mrSignalSyoukaiYhkbn = C_YouhiKbn.YOU;
                mrSignalHanteiGyoumuKbn = C_MrsignalhanteigyoumuKbn.SKEI;
                tsngkSyoukaiYhkbn = C_YouhiKbn.HUYOU;
                tsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                tsnTsgHuho2Kykno = "";
                tsnKijunYmd = null;
                kykdrtenTsnsSkYhkbn = C_YouhiKbn.HUYOU;
                drtenTsnTsgHuho2KyknoKbn = C_Huho2kyknoKbn.BLNK;
                drtenTsnTsgHuho2Kykno = "";
                kykdrtenTsnKijyunYmd = null;
                mosSakuseiKahiSkYhkbn = C_YouhiKbn.HUYOU;
                handKetteiYhkbn = C_YouhiKbn.YOU;
            }
        }

        HT_KouzaJyouhou kouzaJyouhou = null;

        if (C_Hrkkeiro.KOUHURI.eq(mosKihon.getHrkkeiro())) {

            kouzaJyouhou = pMP.getDataSyoriControl().getKouzaJyouhou();

            if (kouzaJyouhou != null) {

                if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                    bancd = kouzaJyouhou.getBankcd();
                    sitencd = kouzaJyouhou.getSitencd();
                    yokinkbn = kouzaJyouhou.getYokinkbn();
                    kouzano = kouzaJyouhou.getKouzano();
                    enKouzaHanteiFlag = true;
                }
            }
        }

        if (C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI.eq(sakuintsnSyoukaiKbn)) {


            skinTsnSkYokenBean.setSkintsnsyoukaikbn(sakuintsnSyoukaiKbn);
            skinTsnSkYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);
            skinTsnSkYokenBean.setHuho2kykno(mosNo);
            skinTsnSkYokenBean.setSkintsntaisyoukbn(sakuintsnTaisyouKbn);
            skinTsnSkYokenBean.setTaisyounmkn("");
            skinTsnSkYokenBean.setTaisyounmkj("");
            skinTsnSkYokenBean.setTaisyouseiymd(null);
            skinTsnSkYokenBean.setTaisyouyno("");
            skinTsnSkYokenBean.setHhknyno("");
            skinTsnSkYokenBean.setHhknsykgycd("");
            skinTsnSkYokenBean.setKankeinmkn1("");
            skinTsnSkYokenBean.setKankeinmkj1("");
            skinTsnSkYokenBean.setKankeinmkn2("");
            skinTsnSkYokenBean.setKankeinmkj2("");
            skinTsnSkYokenBean.setKankeinmkn3("");
            skinTsnSkYokenBean.setKankeinmkj3("");
            skinTsnSkYokenBean.setKankeinmkn4("");
            skinTsnSkYokenBean.setKankeinmkj4("");
            skinTsnSkYokenBean.setKankeinmkn5("");
            skinTsnSkYokenBean.setKankeinmkj5("");
            skinTsnSkYokenBean.setKanrisosikicd1("");
            skinTsnSkYokenBean.setKanrisosikicd2("");
            skinTsnSkYokenBean.setTsintelno("");
            skinTsnSkYokenBean.setHrkkeiro(C_Hrkkeiro.BLNK);
            skinTsnSkYokenBean.setBankcd("");
            skinTsnSkYokenBean.setShitencd("");
            skinTsnSkYokenBean.setYokinkbn(C_YokinKbn.BLNK);
            skinTsnSkYokenBean.setKouzano("");
            skinTsnSkYokenBean.setSkininfosyoukaiyhkbn(sakuinjhSkYhkbn);
            skinTsnSkYokenBean.setSkintaisyoukykkbn(sakuinTaisyouKykKbn);
            skinTsnSkYokenBean.setSkintsghuho2kyknokbn(sakuinHuho2KyknoKbn);
            skinTsnSkYokenBean.setSkintsghuho2kykno(sakuinHuho2Kykno);
            skinTsnSkYokenBean.setSkinkijyunymd(sakuinKijunYmd);
            skinTsnSkYokenBean.setMrsignalsyoukaiyhkbn(mrSignalSyoukaiYhkbn);
            skinTsnSkYokenBean.setMrsignalhanteigyoumukbn(mrSignalHanteiGyoumuKbn);
            skinTsnSkYokenBean.setTsngksyoukaiyhkbn(tsngkSyoukaiYhkbn);
            skinTsnSkYokenBean.setTsntsghuho2kyknokbn(tsnTsgHuho2KyknoKbn);
            skinTsnSkYokenBean.setTsntsghuho2kykno(tsnTsgHuho2Kykno);
            skinTsnSkYokenBean.setTsnkijyunymd(tsnKijunYmd);
            skinTsnSkYokenBean.setKykdrtentsnsssyoukaiyhkbn(kykdrtenTsnsSkYhkbn);
            skinTsnSkYokenBean.setDrtentsntsghuho2kyknokbn(drtenTsnTsgHuho2KyknoKbn);
            skinTsnSkYokenBean.setDrtentsntsghuho2kykno(drtenTsnTsgHuho2Kykno);
            skinTsnSkYokenBean.setKykdrtentsnkijyunymd(kykdrtenTsnKijyunYmd);
            skinTsnSkYokenBean.setDairitencd1(drtenCd1);
            skinTsnSkYokenBean.setDairitencd2(drtenCd2);
            skinTsnSkYokenBean.setMossakuseikahisyoukaiyhkbn(mosSakuseiKahiSkYhkbn);
            skinTsnSkYokenBean.setHndketyhsyoukaiyhkbn(handKetteiYhkbn);
        }
        if (C_SakuintsnSyoukaiKbn.MEIGISYOUKAI.eq(sakuintsnSyoukaiKbn)) {

            setKankeisyasimei(pMP, mosKihon, pShubetu, kankeisyaNmKnLst, kankeisyaNmKjLst, kouzaJyouhou,
                enKouzaHanteiFlag);

            skinTsnSkYokenBean.setSkintsnsyoukaikbn(sakuintsnSyoukaiKbn);
            skinTsnSkYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
            skinTsnSkYokenBean.setHuho2kykno("");
            skinTsnSkYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.BLNK);
            skinTsnSkYokenBean.setTaisyounmkn(taisyouNmKn);
            skinTsnSkYokenBean.setTaisyounmkj(taisyouNmKj);
            skinTsnSkYokenBean.setTaisyouseiymd(taisyouseiYmd);
            skinTsnSkYokenBean.setTaisyouyno(taisyouYno);
            skinTsnSkYokenBean.setHhknyno(mosKihon.getHhknyno());
            skinTsnSkYokenBean.setHhknsykgycd(mosKihon.getHhknsykgycd());

            if (kankeisyaNmKnLst.size() > 0 && kankeisyaNmKnLst.get(0) != null) {

                skinTsnSkYokenBean.setKankeinmkn1(kankeisyaNmKnLst.get(0));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkn1("");
            }

            if (kankeisyaNmKjLst.size() > 0 && kankeisyaNmKjLst.get(0) != null) {

                skinTsnSkYokenBean.setKankeinmkj1(kankeisyaNmKjLst.get(0));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkj1("");
            }

            if (kankeisyaNmKnLst.size() > 1 && kankeisyaNmKnLst.get(1) != null) {

                skinTsnSkYokenBean.setKankeinmkn2(kankeisyaNmKnLst.get(1));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkn2("");
            }

            if (kankeisyaNmKjLst.size() > 1 && kankeisyaNmKjLst.get(1) != null) {

                skinTsnSkYokenBean.setKankeinmkj2(kankeisyaNmKjLst.get(1));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkj2("");
            }

            if (kankeisyaNmKnLst.size() > 2 && kankeisyaNmKnLst.get(2) != null) {

                skinTsnSkYokenBean.setKankeinmkn3(kankeisyaNmKnLst.get(2));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkn3("");
            }

            if (kankeisyaNmKjLst.size() > 2 && kankeisyaNmKjLst.get(2) != null) {

                skinTsnSkYokenBean.setKankeinmkj3(kankeisyaNmKjLst.get(2));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkj3("");
            }

            if (kankeisyaNmKnLst.size() > 3 && kankeisyaNmKnLst.get(3) != null) {

                skinTsnSkYokenBean.setKankeinmkn4(kankeisyaNmKnLst.get(3));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkn4("");
            }

            if (kankeisyaNmKjLst.size() > 3 && kankeisyaNmKjLst.get(3) != null) {

                skinTsnSkYokenBean.setKankeinmkj4(kankeisyaNmKjLst.get(3));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkj4("");
            }

            if (kankeisyaNmKnLst.size() > 4 && kankeisyaNmKnLst.get(4) != null) {

                skinTsnSkYokenBean.setKankeinmkn5(kankeisyaNmKnLst.get(4));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkn5("");
            }

            if (kankeisyaNmKjLst.size() > 4 && kankeisyaNmKjLst.get(4) != null) {

                skinTsnSkYokenBean.setKankeinmkj5(kankeisyaNmKjLst.get(4));
            }
            else {

                skinTsnSkYokenBean.setKankeinmkj5("");
            }

            skinTsnSkYokenBean.setKanrisosikicd1("");
            skinTsnSkYokenBean.setKanrisosikicd2("");
            skinTsnSkYokenBean.setTsintelno(mosKihon.getTsintelno());
            skinTsnSkYokenBean.setHrkkeiro(mosKihon.getHrkkeiro());
            skinTsnSkYokenBean.setBankcd(bancd);
            skinTsnSkYokenBean.setShitencd(sitencd);
            skinTsnSkYokenBean.setYokinkbn(yokinkbn);
            skinTsnSkYokenBean.setKouzano(kouzano);
            skinTsnSkYokenBean.setSkininfosyoukaiyhkbn(sakuinjhSkYhkbn);
            skinTsnSkYokenBean.setSkintaisyoukykkbn(sakuinTaisyouKykKbn);
            skinTsnSkYokenBean.setSkintsghuho2kyknokbn(sakuinHuho2KyknoKbn);
            skinTsnSkYokenBean.setSkintsghuho2kykno(sakuinHuho2Kykno);
            skinTsnSkYokenBean.setSkinkijyunymd(sakuinKijunYmd);
            skinTsnSkYokenBean.setMrsignalsyoukaiyhkbn(mrSignalSyoukaiYhkbn);
            skinTsnSkYokenBean.setMrsignalhanteigyoumukbn(mrSignalHanteiGyoumuKbn);
            skinTsnSkYokenBean.setTsngksyoukaiyhkbn(tsngkSyoukaiYhkbn);
            skinTsnSkYokenBean.setTsntsghuho2kyknokbn(tsnTsgHuho2KyknoKbn);
            skinTsnSkYokenBean.setTsntsghuho2kykno(tsnTsgHuho2Kykno);
            skinTsnSkYokenBean.setTsnkijyunymd(tsnKijunYmd);
            skinTsnSkYokenBean.setKykdrtentsnsssyoukaiyhkbn(kykdrtenTsnsSkYhkbn);
            skinTsnSkYokenBean.setDrtentsntsghuho2kyknokbn(drtenTsnTsgHuho2KyknoKbn);
            skinTsnSkYokenBean.setDrtentsntsghuho2kykno(drtenTsnTsgHuho2Kykno);
            skinTsnSkYokenBean.setKykdrtentsnkijyunymd(kykdrtenTsnKijyunYmd);
            skinTsnSkYokenBean.setDairitencd1(drtenCd1);
            skinTsnSkYokenBean.setDairitencd2(drtenCd2);
            skinTsnSkYokenBean.setMossakuseikahisyoukaiyhkbn(mosSakuseiKahiSkYhkbn);
            skinTsnSkYokenBean.setHndketyhsyoukaiyhkbn(handKetteiYhkbn);

        }

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiKekkaBean sakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq.exec(skinTsnSkYokenBean);

        String tsysy = "";
        if (HIHOKENSYA.equals(pShubetu)) {

            tsysy = "被保険者";
        }
        else if (KEIYAKUSYA.equals(pShubetu)) {

            tsysy = "契約者";
        }
        else if (UKETORININ.equals(pShubetu)) {

            tsysy = "受取人";
        }
        else if (KEIYAKUSYADAIRININ.equals(pShubetu)) {

            tsysy = "契約者代理人";
        }
        else if (HIHOKENSYADAIRININ.equals(pShubetu)) {

            tsysy = "被保険者代理人";
        }

        msg = "";

        if (C_SysKbn.SKEI.eq(sysKbn)) {

            if (C_MQSyorikekkaKbn.ERROR.eq(sakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())){
                if(!msgFlg) {
                    msg = MessageId.EHC1016 + " " + MessageUtil.getMessage(MessageId.EHC1016);
                    msgFlg = true;
                    if (HIHOKENSYA.equals(pShubetu)) {

                        hhknnayoseErrorFlg = true;
                    }
                }
            }
            else if (C_PalSyoukaiJissiumuKbn.NONE.eq(sakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())) {
                if(!msgFlg) {
                    msg = MessageId.EHC1019 + " " + MessageUtil.getMessage(MessageId.EHC1019);
                    msgFlg = true;
                    if (HIHOKENSYA.equals(pShubetu)) {

                        hhknnayoseErrorFlg = true;
                    }
                }
            }
            else if ((sakuintsnSyoukaiKbn.eq(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI) &&
                !C_NayoseJyoutaiKbn.NAYOSEZUMI.eq(sakuinTsnSyoukaiKekkaBean.getNysjyoutaikbn())) ||
                (sakuintsnSyoukaiKbn.eq(C_SakuintsnSyoukaiKbn.MEIGISYOUKAI) &&
                    !C_NayoseJissiKekkaKbn.DOUITUARI.eq(sakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn()) &&
                    !C_NayoseJissiKekkaKbn.DOUITUNONE.eq(sakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn()))) {

                if (UKETORININ.equals(pShubetu)) {
                    pMP.setUktNayosehumeiuUmuKbn(C_UmuKbn.ARI);
                }
                else  if (KEIYAKUSYADAIRININ.equals(pShubetu)) {
                    pMP.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
                }
                else  if (HIHOKENSYADAIRININ.equals(pShubetu)) {
                    pMP.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);
                }
                else {
                    msg = MessageId.EHC1020 + " " + MessageUtil.getMessage(MessageId.EHC1020, tsysy);
                    setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, msg, pMP, C_TknKbn.NONE);
                    if (HIHOKENSYA.equals(pShubetu)) {

                        hhknnayoseErrorFlg = true;
                    }
                }

                return sakuinTsnSyoukaiKekkaBean;
            }
        }
        if (C_SysKbn.ESHIEN.eq(sysKbn) && !msgFlg) {

            if (C_MQSyorikekkaKbn.ERROR.eq(sakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn()) ||
                C_PalSyoukaiJissiumuKbn.NONE.eq(sakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn()) && !msgFlg) {
                msg = MessageId.EGA1036 + " " + MessageUtil.getMessage(MessageId.EGA1036);
                msgFlg = true;
                if (HIHOKENSYA.equals(pShubetu)) {

                    hhknnayoseErrorFlg = true;
                }
            }
            else if (!C_MQSyorikekkaKbn.ERROR.eq(sakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn()) &&
                !C_NayoseJissiKekkaKbn.DOUITUARI.eq(sakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn()) &&
                !C_NayoseJissiKekkaKbn.DOUITUNONE.eq(sakuinTsnSyoukaiKekkaBean.getNysjissikekkakbn())) {

                if (HIHOKENSYA.equals(pShubetu)) {
                    pMP.setSekmossakuseiNayoseHumeiKbn(C_UmuKbn.ARI);

                    hhknnayoseErrorFlg = true;
                }
            }
        }

        if (msg != null && msg.length() > 0) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, msg, pMP, C_TknKbn.NONE);

            return null;
        }

        return sakuinTsnSyoukaiKekkaBean;
    }

    private void sentakujohokousin(BzSakuinTsnSyoukaiKekkaBean pSakuinTsnSyoukaiKekkaBean,
        List<HT_SentakuJyouhou> pSentakuJyouhouLst, C_SntkInfoTaisyousyaKbn pSntkInfoTaisyousyaKbn,
        String pMosNo, HT_SyoriCTL pSyoriCTL, int pEdano, String pGyoumuKousinsyaId, String pGyoumuKousinTime) {

        if (pSakuinTsnSyoukaiKekkaBean != null) {

            for (int index = 0; index < pSakuinTsnSyoukaiKekkaBean.getSntkfkensuu(); index++) {

                BzSentakuInfoFSakuinKekkaBean sentakuInfoFSakuinKekkaBean =
                    pSakuinTsnSyoukaiKekkaBean.getBzsentakuinfofsakuinkekkabeanlist().get(index);

                C_BlnktkumuKbn huho2MrUmuKbn;
                if (C_BlnktkumuKbn.ARI.eq(sentakuInfoFSakuinKekkaBean.getHuho2mrumukbn())) {

                    huho2MrUmuKbn = C_BlnktkumuKbn.ARI;
                }
                else {

                    huho2MrUmuKbn = C_BlnktkumuKbn.NONE;
                }

                C_BlnktkumuKbn huho2DecUmuKbn;
                if (C_BlnktkumuKbn.ARI.eq(sentakuInfoFSakuinKekkaBean.getHuho2decumukbn())) {

                    huho2DecUmuKbn = C_BlnktkumuKbn.ARI;
                }
                else {

                    huho2DecUmuKbn = C_BlnktkumuKbn.NONE;
                }

                C_BlnktkumuKbn huho2KdUmuKbn;
                if (C_BlnktkumuKbn.ARI.eq(sentakuInfoFSakuinKekkaBean.getHuho2kdumukbn())) {

                    huho2KdUmuKbn = C_BlnktkumuKbn.ARI;
                }
                else {

                    huho2KdUmuKbn = C_BlnktkumuKbn.NONE;
                }

                C_BlnktkumuKbn huho2ToriKaijoUmuKbn;
                if (C_BlnktkumuKbn.ARI.eq(sentakuInfoFSakuinKekkaBean.getHuho2torikaijoumukbn())) {

                    huho2ToriKaijoUmuKbn = C_BlnktkumuKbn.ARI;
                }
                else {

                    huho2ToriKaijoUmuKbn = C_BlnktkumuKbn.NONE;
                }

                HT_SentakuJyouhou sentakuJyouhou = new HT_SentakuJyouhou();

                C_SysCdKbn sysCdKbn;
                if (C_BlnktkumuKbn.ARI.eq(huho2MrUmuKbn) ||
                    C_BlnktkumuKbn.ARI.eq(huho2DecUmuKbn)||
                    C_BlnktkumuKbn.ARI.eq(huho2KdUmuKbn) ||
                    C_BlnktkumuKbn.ARI.eq(huho2ToriKaijoUmuKbn)) {

                    sysCdKbn = C_SysCdKbn.RAY;
                }
                else {

                    sysCdKbn = C_SysCdKbn.PAL;
                }

                sentakuJyouhou.setSyoriCTL(pSyoriCTL);
                sentakuJyouhou.setMosno(pMosNo);
                sentakuJyouhou.setSntkinfotaisyousyakbn(pSntkInfoTaisyousyaKbn);
                sentakuJyouhou.setEdano(pEdano);
                sentakuJyouhou.setSntkinfono(sentakuInfoFSakuinKekkaBean.getSntkinfono());
                sentakuJyouhou.setSyscdkbn(sysCdKbn);
                sentakuJyouhou.setSntkinfokankeisyakbn(sentakuInfoFSakuinKekkaBean.getSntkinfokankeisyakbn());
                sentakuJyouhou.setSntkinfofkojinkbn(sentakuInfoFSakuinKekkaBean.getSntkinfofkojinkbn());
                sentakuJyouhou.setSntkinfokbn(sentakuInfoFSakuinKekkaBean.getSntkinfokbn());
                sentakuJyouhou.setSntkinfosakuseiymd(sentakuInfoFSakuinKekkaBean.getSntkinfosakuseiymd());
                sentakuJyouhou.setMrumukbn(sentakuInfoFSakuinKekkaBean.getMrumukbn());
                sentakuJyouhou.setDecumukbn(sentakuInfoFSakuinKekkaBean.getDecumukbn());
                sentakuJyouhou.setInfokoukanumukbn(sentakuInfoFSakuinKekkaBean.getInfokoukanumukbn());
                sentakuJyouhou.setNyuuinkyhkshrumukbn(sentakuInfoFSakuinKekkaBean.getNyuuinkyhkshrumukbn());
                sentakuJyouhou.setSyujyutukyhkshrumukbn(sentakuInfoFSakuinKekkaBean.getSyujyutukyhkshrumukbn());
                sentakuJyouhou.setSyougaikyhkshrumukbn(sentakuInfoFSakuinKekkaBean.getSyougaikyhkshrumukbn());
                sentakuJyouhou.setKoudosyougaiumukbn(sentakuInfoFSakuinKekkaBean.getKoudosyougaiumukbn());
                sentakuJyouhou.setPmenumukbn(sentakuInfoFSakuinKekkaBean.getPmenumukbn());
                sentakuJyouhou.setTorikaijoumukbn(sentakuInfoFSakuinKekkaBean.getTorikaijoumukbn());
                sentakuJyouhou.setSoukikeakyhkshrumukbn(sentakuInfoFSakuinKekkaBean.getSoukikeakyhkshrumukbn());
                sentakuJyouhou.setSonotakyhkshrumukbn(sentakuInfoFSakuinKekkaBean.getSonotakyhkshrumukbn());
                sentakuJyouhou.setKghsjjtkyhkshrumukbn(sentakuInfoFSakuinKekkaBean.getKghsjjtkyhkshrumukbn());
                sentakuJyouhou.setHuho2mrumukbn(sentakuInfoFSakuinKekkaBean.getHuho2mrumukbn());
                sentakuJyouhou.setHuho2decumukbn(sentakuInfoFSakuinKekkaBean.getHuho2decumukbn());
                sentakuJyouhou.setHuho2kdumukbn(sentakuInfoFSakuinKekkaBean.getHuho2kdumukbn());
                sentakuJyouhou.setHuho2torikaijoumukbn(sentakuInfoFSakuinKekkaBean.getHuho2torikaijoumukbn());
                sentakuJyouhou.setGyoumuKousinsyaId(pGyoumuKousinsyaId);
                sentakuJyouhou.setGyoumuKousinTime(pGyoumuKousinTime);

                BizPropertyInitializer.initialize(sentakuJyouhou);

                pSentakuJyouhouLst.add(sentakuJyouhou);
            }
        }
    }

    private void setKankeisyasimei(MosnaiCheckParam pMP, HT_MosKihon pMosKihon, String pTaisyouseiSyubetu,
        List<String> pKankeisyaNmKnLst, List<String> pKankeisyaNmKjLst, HT_KouzaJyouhou pKouzaJyouhou,
        boolean pEnKouzaHanteiFlag) {

        if ((C_KykKbn.KEIHI_BETU.eq(pMosKihon.getKykkbn()) && HIHOKENSYA.equals(pTaisyouseiSyubetu))
            || (C_KykKbn.KEIHI_BETU.eq(pMosKihon.getKykkbn()) && UKETORININ.equals(pTaisyouseiSyubetu))
            || (C_KykKbn.KEIHI_BETU.eq(pMosKihon.getKykkbn()) && KEIYAKUSYADAIRININ.equals(pTaisyouseiSyubetu))
            || (C_KykKbn.KEIHI_BETU.eq(pMosKihon.getKykkbn()) && HIHOKENSYADAIRININ.equals(pTaisyouseiSyubetu))) {

            pKankeisyaNmKnLst.add(pMosKihon.getKyknmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(pMosKihon.getKyknmkjkhukakbn())) {
                pKankeisyaNmKjLst.add(pMosKihon.getKyknmkj());
            }
            else {
                pKankeisyaNmKjLst.add("");
            }
        }

        if ((C_KykKbn.KEIHI_BETU.eq(pMosKihon.getKykkbn()) && KEIYAKUSYA.equals(pTaisyouseiSyubetu))
            || UKETORININ.equals(pTaisyouseiSyubetu)
            || KEIYAKUSYADAIRININ.equals(pTaisyouseiSyubetu)
            || HIHOKENSYADAIRININ.equals(pTaisyouseiSyubetu)) {

            pKankeisyaNmKnLst.add(pMosKihon.getHhknnmkn());

            if (!C_KjkhukaKbn.KJKHUKA.eq(pMosKihon.getHhknnmkjkhukakbn())) {
                pKankeisyaNmKjLst.add(pMosKihon.getHhknnmkj());
            }
            else {
                pKankeisyaNmKjLst.add("");
            }
        }

        List<HT_MosTrkKzk> mosTrkKzkLst = pMP.getDataSyoriControl().getMosTrkKzks();

        if (mosTrkKzkLst != null && mosTrkKzkLst.size() > 0) {

            for (HT_MosTrkKzk mosTrkKzk : mosTrkKzkLst) {
                String trkkzknmkj = "";
                if (!C_KjkhukaKbn.KJKHUKA.eq(mosTrkKzk.getTrkkzknmkjkhukakbn())) {
                    trkkzknmkj = mosTrkKzk.getTrkkzknmkj();
                }

                if (C_TrkKzkKbn.TRKKZK1.eq(mosTrkKzk.getTrkkzkkbn())) {
                    if (mosTrkKzk.getTrkkzknmkn().equals(taisyouNmKn) && trkkzknmkj.equals(taisyouNmKj)) {

                        continue;
                    }

                    pKankeisyaNmKnLst.add(mosTrkKzk.getTrkkzknmkn());
                    pKankeisyaNmKjLst.add(trkkzknmkj);
                }
                else if (C_TrkKzkKbn.TRKKZK2.eq(mosTrkKzk.getTrkkzkkbn())) {
                    if (mosTrkKzk.getTrkkzknmkn().equals(taisyouNmKn) && trkkzknmkj.equals(taisyouNmKj)) {

                        continue;
                    }

                    pKankeisyaNmKnLst.add(mosTrkKzk.getTrkkzknmkn());
                    pKankeisyaNmKjLst.add(trkkzknmkj);
                }
            }
        }

        List<HT_Uketorinin> sbUketorininLst = pMP.getDataSyoriControl().getUketorininsByUktsyukbn(C_UktsyuKbn.SBUKT);

        if (sbUketorininLst != null && sbUketorininLst.size() > 0) {

            String uktnmKj;
            for (HT_Uketorinin uketorinin : sbUketorininLst) {

                if (!C_KjkhukaKbn.KJKHUKA.eq(uketorinin.getUktnmkjkhukakbn())) {
                    uktnmKj = uketorinin.getUktnmkj();
                }
                else {
                    uktnmKj = "";
                }

                if (C_UktKbn.TOKUTEIMEIGI.eq(uketorinin.getUktkbn())) {

                    if (UKETORININ.equals(pTaisyouseiSyubetu)
                        && taisyouNmKn.equals(uketorinin.getUktnmkn())
                        && taisyouNmKj.equals(uketorinin.getUktnmkj())) {

                        continue;
                    }

                    pKankeisyaNmKnLst.add(uketorinin.getUktnmkn());
                    pKankeisyaNmKjLst.add(uktnmKj);
                }
            }
        }

        if (!HIHOKENSYADAIRININ.equals(pTaisyouseiSyubetu)) {

            List<HT_Uketorinin> stDrSkUketorininLst = pMP.getDataSyoriControl().getUketorininsByUktsyukbn(C_UktsyuKbn.STDRSK);

            if (stDrSkUketorininLst != null && stDrSkUketorininLst.size() > 0) {

                if (C_UktKbn.TOKUTEIMEIGI.eq(stDrSkUketorininLst.get(0).getUktkbn())) {
                    pKankeisyaNmKnLst.add(stDrSkUketorininLst.get(0).getUktnmkn());

                    if (!C_KjkhukaKbn.KJKHUKA.eq(stDrSkUketorininLst.get(0).getUktnmkjkhukakbn())) {
                        pKankeisyaNmKjLst.add(stDrSkUketorininLst.get(0).getUktnmkj());
                    }
                    else {
                        pKankeisyaNmKjLst.add("");
                    }
                }
            }
        }

        if (pEnKouzaHanteiFlag) {

            if (C_KzkykdouKbn.SITEI.eq(pKouzaJyouhou.getKzkykdoukbn())) {
                pKankeisyaNmKnLst.add(pKouzaJyouhou.getKzmeiginmkn());
                pKankeisyaNmKjLst.add("");
            }

        }
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1) {

        StringBuffer ret = new StringBuffer();

        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1));

        return ret.toString();
    }

    private void dskoknokousin(HT_MosKihon pMosKihon) {

        HT_MosKihon mosKihon = pMosKihon;
        C_KykKbn kykKbn = mosKihon.getKykkbn();
        String kyknmkn = "";
        String kyknmkj = "";
        BizDate kykseiymd = null;
        String tsinyno = "";
        if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
            kyknmkn = mosKihon.getKyknmkn();
            kyknmkj = mosKihon.getKyknmkj();
            kykseiymd = mosKihon.getKykseiymd();
            tsinyno = mosKihon.getTsinyno();
        }
        else {
            kyknmkn = mosKihon.getHhknnmkn();
            kyknmkj = mosKihon.getHhknnmkj();
            kykseiymd = mosKihon.getHhknseiymd();
            if (C_TsindousiteiKbn.ARI.eq(mosKihon.getTsindousiteikbn())) {
                tsinyno = mosKihon.getTsinyno();
            }
            else {
                tsinyno = mosKihon.getHhknyno();
            }
        }

        DsNayose dsNayose = SWAKInjector.getInstance(DsNayose.class);
        DsNayoseBean dsNayoseBean = dsNayose.exec(kyknmkn, kyknmkj, kykseiymd, tsinyno);
        C_NayoseJissiKekkaKbn nayoseJissiKekkaKbn = dsNayoseBean.getNayoseJissiKekkaKbn();
        String kokno = dsNayoseBean.getKokno();
        if (C_NayoseJissiKekkaKbn.DOUITUARI.eq(nayoseJissiKekkaKbn)) {
            mosKihon.setDskokno(kokno);
        }
        else {
            mosKihon.setDskokno("");
        }
    }
}
