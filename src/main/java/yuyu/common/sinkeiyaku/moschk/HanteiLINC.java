package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.sinkeiyaku.skcommon.GetLincTourokuS;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_LincdatasousinKbn;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_Znnkaisuukekka;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック LINC該当判定
 */
public class HanteiLINC {

    private static final int LINC_NON = 0;

    private static final int LINC_UPD = 1;

    private static final int LINC_REG = 2;

    @Inject
    private static Logger logger;

    @Inject
    private GetLincTourokuS getLincTourokuS;

    @Inject
    private HanteiZennouKaisuu hanteiZennouKaisuu;

    @Inject
    private BizDomManager bizDomManager;
    public HanteiLINC() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ ＬＩＮＣ該当判定 開始");
        }
        HT_SkLincTourokuInfo skLincTourokuInfo = null;
        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        C_LincjkKbn lincJkKbn = syoriCTL.getLincjkkbn();
        C_UmuKbn hhknNayosejissiUmuKbnSeijyou = pMP.getHhknNayosejissiUmuKbnSeijyou();
        C_UmuKbn checkspJissiUmuKbnSeijyou = pMP.getCheckspJissiUmuKbnSeijyou();
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        Integer hhknnen = mosKihon.getHhknnen();
        boolean wKLincHutuuSbSGtFlag = false;
        boolean wKLincSgSbSGtFlag = false;
        boolean wKLincSgNyuGtFlag = false;
        boolean wKLincSipNyuGtFlag = false;
        boolean wKLincSjNyuGtFlag = false;
        boolean wkLincSntNyuGtFlag = false;

        boolean wKLincGtFlag1 = false;
        boolean wKLincGtFlag2 = false;
        boolean wKLincGtFlag3 = false;
        boolean wKLincGtFlag4 = false;

        C_Hrkkaisuu hrkkaisuu = mosKihon.getHrkkaisuu();
        if (C_Hrkkaisuu.ITIJI.eq(hrkkaisuu)) {
            wKLincGtFlag1 = true;
        }

        C_Hrkkeiro hrkKeiRo = mosKihon.getHrkkeiro();
        if (C_Hrkkeiro.HURIKAE.eq(hrkKeiRo)) {
            C_Znnkaisuukekka znnKaiSuukekKa = hanteiZennouKaisuu.exec(pMP);
            if (!C_Znnkaisuukekka.ITIBU.eq(znnKaiSuukekKa)) {
                wKLincGtFlag2 = true;
            }
        }

        if (C_UmuKbn.NONE.eq(hhknNayosejissiUmuKbnSeijyou)) {
            wKLincGtFlag3 = true;
        }

        if (C_UmuKbn.NONE.eq(checkspJissiUmuKbnSeijyou)) {
            wKLincGtFlag4 = true;
        }

        if ((wKLincGtFlag1 == false) &&
            (wKLincGtFlag2 == false) &&
            (wKLincGtFlag3 == false) &&
            (wKLincGtFlag4 == false)) {
            getLincTourokuS.exec(pMP);

            BizCurrency wKLincHutuuSibouS = YuyuBizConfig.getInstance().getLincGtHutuuSbS();
            BizCurrency wKLincNyuinNg = YuyuBizConfig.getInstance().getLincGtNyuKyhkin();
            BizCurrency lincGtHutuuSbSSgSbSGoukeiTeinen = YuyuBizConfig.getInstance().getLincGtHutuuSbSSgSbSGoukeiTeinen();
            Integer lincGtHntiyuTeinenKijyun = YuyuBizConfig.getInstance().getLincGtHntiyuTeinenKijyun();

            if ((hhknnen < lincGtHntiyuTeinenKijyun) &&
                ((getLincTourokuS.getHutusibous().add(getLincTourokuS.getSaigaisibous())).compareTo
                    (lincGtHutuuSbSSgSbSGoukeiTeinen) >= 0)) {

                wKLincHutuuSbSGtFlag = true;
            }

            if ((hhknnen >= lincGtHntiyuTeinenKijyun) &&
                (getLincTourokuS.getHutusibous().compareTo(wKLincHutuuSibouS) >= 0)) {

                wKLincHutuuSbSGtFlag = true;
            }

            if (getLincTourokuS.getSaigainyuinng().compareTo(wKLincNyuinNg) >= 0) {
                wKLincSgNyuGtFlag = true;
            }
            if (getLincTourokuS.getSippeinyuinng().compareTo(wKLincNyuinNg) >= 0) {
                wKLincSipNyuGtFlag = true;
            }
            if (getLincTourokuS.getSeijinnyuinng().compareTo(wKLincNyuinNg) >= 0) {
                wKLincSjNyuGtFlag = true;
            }
            if (getLincTourokuS.getSonotanyuinng().compareTo(wKLincNyuinNg) >= 0) {
                wkLincSntNyuGtFlag = true;
            }

            if (logger.isDebugEnabled()) {
                logger.debug("｜ LINC普通死亡Ｓ該当フラグ = " + wKLincHutuuSbSGtFlag);
                logger.debug("｜ LINC災害死亡時加算Ｓ該当フラグ = " + wKLincSgSbSGtFlag);
                logger.debug("｜ LINC災害入院該当フラグ = " + wKLincSgNyuGtFlag);
                logger.debug("｜ LINC疾病入院該当フラグ = " + wKLincSipNyuGtFlag);
                logger.debug("｜ LINC成人病入院該当フラグ = " + wKLincSjNyuGtFlag);
                logger.debug("｜ LINCその他入院該当フラグ = " + wkLincSntNyuGtFlag);
            }
        }

        C_LincgthtkekKbn lincgthtkekKbn = null;

        if (wKLincGtFlag3 || wKLincGtFlag4) {
            lincgthtkekKbn = C_LincgthtkekKbn.MIHANTEI;
            syoriCTL.setLincgthtkekkbn(lincgthtkekKbn);
        }
        else if (wKLincHutuuSbSGtFlag || wKLincSgSbSGtFlag || wKLincSgNyuGtFlag ||
            wKLincSipNyuGtFlag || wKLincSjNyuGtFlag || wkLincSntNyuGtFlag) {
            lincgthtkekKbn = C_LincgthtkekKbn.SYOUKAITAISYOU;
            syoriCTL.setLincgthtkekkbn(lincgthtkekKbn);

        }
        else {
            lincgthtkekKbn = C_LincgthtkekKbn.SYOUKAITAISYOUGAI;
            syoriCTL.setLincgthtkekkbn(lincgthtkekKbn);
        }

        if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(lincgthtkekKbn)) {
            if (C_LincjkKbn.MIHANTEI.eq(lincJkKbn)) {
                syoriCTL.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);
                syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.TOUROKU);
            }
            else if ((C_LincjkKbn.SYOUKAITAISYOUGAI.eq(lincJkKbn)) ||
                (C_LincjkKbn.SYOUKAIMATI.eq(lincJkKbn))) {

                skLincTourokuInfo = syoriCTL.getSkLincTourokuInfo();
                if (skLincTourokuInfo != null) {
                    syoriCTL.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);
                    syoriCTL.setLinckknnjkkbn(C_LinckknnjkKbn.KAKUNINHUYOU);
                    syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.SAITOUROKU);
                }
                else {
                    syoriCTL.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);
                    syoriCTL.setLinckknnjkkbn(C_LinckknnjkKbn.KAKUNINHUYOU);
                    syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.TOUROKU);
                }
            }
            else if ((C_LincjkKbn.KAITOARI_TASYANASI.eq(lincJkKbn)) ||
                (C_LincjkKbn.KAITOARI_TASYAARI.eq(lincJkKbn))) {

                int wKLincUpdJky = getLincUpdJky(pMP, getLincTourokuS);

                if (wKLincUpdJky == LINC_REG) {
                    syoriCTL.setLincjkkbn(C_LincjkKbn.SYOUKAIMATI);
                    syoriCTL.setLinckknnjkkbn(C_LinckknnjkKbn.KAKUNINHUYOU);
                    syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.SAITOUROKU);
                }

                else if (wKLincUpdJky == LINC_UPD) {
                    syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.HENKOU);
                }
            }
        }
        else if (C_LincgthtkekKbn.SYOUKAITAISYOUGAI.eq(lincgthtkekKbn)) {

            if (!C_LincjkKbn.SYOUKAI.eq(lincJkKbn) &&
                !C_LincjkKbn.HANEIMATI.eq(lincJkKbn)) {

                skLincTourokuInfo = syoriCTL.getSkLincTourokuInfo();
                if (skLincTourokuInfo != null) {
                    syoriCTL.setLincjkkbn(C_LincjkKbn.SYOUKAITAISYOUGAI);
                    syoriCTL.setLinckknnjkkbn(C_LinckknnjkKbn.KAKUNINHUYOU);
                    syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.SAKUJO);
                }
                else {
                    syoriCTL.setLincjkkbn(C_LincjkKbn.SYOUKAITAISYOUGAI);
                    syoriCTL.setLinckknnjkkbn(C_LinckknnjkKbn.KAKUNINHUYOU);
                    syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.MISETTEI);
                }
            }
        }
        else if (C_LincgthtkekKbn.MIHANTEI.eq(lincgthtkekKbn)) {
            if (!C_LincjkKbn.MIHANTEI.eq(lincJkKbn) &&
                !C_LincjkKbn.SYOUKAI.eq(lincJkKbn) &&
                !C_LincjkKbn.HANEIMATI.eq(lincJkKbn)) {
                syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.MISETTEI);
            }
        }

        pMP.setDataSyoriControl(syoriCTL);

        if (logger.isDebugEnabled()) {
            logger.debug("△ ＬＩＮＣ該当判定 終了");
        }
    }

    private int getLincUpdJky(MosnaiCheckParam pMP, GetLincTourokuS pLincTourokuS) {

        HT_SkLincTourokuInfo skLincTourokuInfo = null;
        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();
        String wKYno = "";
        String wKHhknAdrKn = "";
        String wKHhknNmKj = "";
        String wKKykNmKn = "";
        String wKKykNmKj = "";
        C_Kyksei hhknseiKbn = C_Kyksei.BLNK;
        BizDate wKKykSeiYmd = null;
        String wKKykAdrKn = "";
        BizDate wKKykYtYmd = null;

        int wKLincUpdJky = LINC_NON;

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        String hhknYNo = mosKihon.getHhknyno();
        String hhknNmKn = mosKihon.getHhknnmkn();
        String hhknNmKj = mosKihon.getHhknnmkj();
        C_Hhknsei hhknsei = mosKihon.getHhknsei();
        BizDate hhknSeiYmd = mosKihon.getHhknseiymd();
        String tsinYNo = mosKihon.getTsinyno();

        skLincTourokuInfo = syoriCTL.getSkLincTourokuInfo();

        if (skLincTourokuInfo != null) {

            wKHhknNmKj = hhknNmKj;
            C_TsindousiteiKbn tsindousiteiKbn = mosKihon.getTsindousiteikbn();

            if (C_TsindousiteiKbn.ARI.eq(tsindousiteiKbn)) {

                wKYno = tsinYNo;
                wKHhknAdrKn = getAdrknHan(wKYno);
            }
            else {

                wKYno = hhknYNo;
                wKHhknAdrKn = getAdrknHan(wKYno);
            }

            C_KykKbn kykKbn = mosKihon.getKykkbn();

            if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
                wKKykNmKn = hhknNmKn;
                wKKykNmKj = hhknNmKj;
                hhknseiKbn = C_Kyksei.valueOf(hhknsei.getValue());
                wKKykSeiYmd = hhknSeiYmd;
            }
            else if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
                wKKykNmKn = mosKihon.getKyknmkn();
                wKKykNmKj = mosKihon.getKyknmkj();
                hhknseiKbn = mosKihon.getKyksei();
                wKKykSeiYmd = mosKihon.getKykseiymd();
            }

            if (C_TsindousiteiKbn.ARI.eq(tsindousiteiKbn)) {

                wKKykAdrKn = wKHhknAdrKn;
            }
            else {

                wKYno = tsinYNo;
                wKKykAdrKn = getAdrknHan(wKYno);
            }

            wKKykYtYmd = mosKihon.getKykymd();

            if (!skLincTourokuInfo.getHhknnmkn().equals(hhknNmKn) ||
                !skLincTourokuInfo.getHhknsei().eq(hhknsei) ||
                BizDateUtil.compareYmd(skLincTourokuInfo.getHhknseiymd(), hhknSeiYmd) != BizDateUtil.COMPARE_EQUAL) {

                wKLincUpdJky = LINC_REG;
            }

            else {
                if (!(skLincTourokuInfo.getHhknnmkj().equals(wKHhknNmKj)) ||
                    !(skLincTourokuInfo.getHhknadrlinckn30().equals(wKHhknAdrKn)) ||
                    !(skLincTourokuInfo.getKykkbn().eq(kykKbn)) ||
                    !(skLincTourokuInfo.getKyknmkn().equals(wKKykNmKn)) ||
                    !(skLincTourokuInfo.getKyknmkj().equals(wKKykNmKj)) ||
                    !(skLincTourokuInfo.getKyksei().eq(hhknseiKbn)) ||
                    (BizDateUtil.compareYmd(skLincTourokuInfo.getKykseiymd(), wKKykSeiYmd) != BizDateUtil.COMPARE_EQUAL) ||
                    !(skLincTourokuInfo.getKykadrlinckn30().equals(wKKykAdrKn)) ||
                    (BizDateUtil.compareYmd(skLincTourokuInfo.getKykytymd(), wKKykYtYmd) != BizDateUtil.COMPARE_EQUAL) ||
                    (skLincTourokuInfo.getSgnyung().compareTo(pLincTourokuS.getSaigainyuinng()) != 0) ||
                    (skLincTourokuInfo.getSipnyung().compareTo(pLincTourokuS.getSippeinyuinng()) != 0) ||
                    (skLincTourokuInfo.getSjnyung().compareTo(pLincTourokuS.getSeijinnyuinng()) != 0) ||
                    (skLincTourokuInfo.getSonotanyuinng().compareTo(pLincTourokuS.getSonotanyuinng()) != 0) ||
                    (skLincTourokuInfo.getHutuusb().compareTo(pLincTourokuS.getHutusibous()) != 0) ||
                    (skLincTourokuInfo.getSgsbksns().compareTo(pLincTourokuS.getSaigaisibous()) != 0)) {

                    wKLincUpdJky = LINC_UPD;
                }
            }
        }
        return wKLincUpdJky;
    }

    private String getAdrknHan(String pYno){

        List<BM_Address> addressLst = bizDomManager.getAddressesByPostalCd(pYno);

        if (addressLst == null || addressLst.size() == 0) {
            return "";
        }

        String jyuusyoKnHan = ConvertUtil.toHanAll(addressLst.get(0).getKnadrkyoutotuusyounmari(), 0, 1);

        if (jyuusyoKnHan.length() > addressLst.get(0).getKnsikugunnmketasuu()) {
            return jyuusyoKnHan.substring(0, addressLst.get(0).getKnsikugunnmketasuu());
        }

        return jyuusyoKnHan;
    }
}
