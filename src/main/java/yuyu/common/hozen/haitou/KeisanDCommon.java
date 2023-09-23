package yuyu.common.hozen.haitou;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.haitou.SetDNnd.DRateSyutokuInfoBean;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 配当 配当共通計算
 */
public class KeisanDCommon extends BaseDCommon {

    protected static final String ERRORCODE001 = "001";

    protected static final String ERRORCODE003 = "003";

    @Inject
    private static Logger logger;

    private KeisanD keisanD;

    private boolean syokaiHaitouMitouraiHaitoukin= false;

    private KeisanDGanrikin kariwariateKeisanDGanrikin;

    private boolean syokaiHaitouMitouraiKariwariateGanrikin = false;

    private IT_KhHaitouKanri khHaitouKanri;

    private KeisanDGanrikin tumitateKeisanDGanrikin;

    private boolean syokaiHaitouMitouraiTumitateGanrikin = false;

    private IT_KhTumitateDKanri khTumitateDKanri;

    private BizCurrency tkbtD;

    private Set<IT_KykKihon> kykKihonSet = new HashSet<IT_KykKihon>();

    private HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

    {
        regErrorInfo(ERRORCODE001, "入力値エラー", "必須項目にnullが含まれる");
        regErrorInfo(ERRORCODE003, "計算時エラー", "確定期間中に内定レコードを計算対象としている");
    }

    public C_ErrorKbn calcD(String pSyono, BizDate pDratekjymd, BizDate pCalckijyunymd, BizDate pSyoriYmd,
        C_UmuKbn pKessanumu) {

        logger.debug("▽ 配当共通計算 配当金計算 開始");

        clear();
        keisanD = null;
        syokaiHaitouMitouraiHaitoukin = false;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pDratekjymd == null || pCalckijyunymd == null || pSyoriYmd == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE001);

                logger.debug("△ 配当共通計算 配当金計算 終了");

                return errorKbn;
            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

            kykKihonSet.add(kykKihon);

            BizDate syokaiHaitouYmd = kykSyouhn.getKykymd().addYears(1).getRekijyou();
            if (pCalckijyunymd.compareTo(syokaiHaitouYmd) < 0) {
                syokaiHaitouMitouraiHaitoukin = true;

                logger.debug("△ 配当共通計算 配当金計算 終了");

                return errorKbn;
            }

            SetDNnd setDNnd = getInjectInstance(SetDNnd.class);

            KeisanDBean keisanDBean = SWAKInjector.getInstance(KeisanDBean.class);
            KeisanD keisand = getInjectInstance(KeisanD.class);

            DRateBean dRateBean = setDNnd.exec(kykKihon, kykSyouhn, pDratekjymd, pCalckijyunymd, pSyoriYmd, pKessanumu);

            if (dRateBean == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorLink(setDNnd);

                logger.debug("△ 配当共通計算 配当金計算 終了");

                return errorKbn;
            }

            DRateSyutokuInfoBean dRateSyutokuInfoBean = dRateBean.getDRateSyutokuInfoBean();
            List<HaitouKaisuuBean> haitouKaisuuBeanLst = dRateBean.getHaitouKaisuuBeanLst();

            keisanDBean.setDRateSyutokuInfoBean(dRateSyutokuInfoBean);
            keisanDBean.setTuukasyu(kykSyouhn.getKyktuukasyu());
            keisanDBean.setKihonS(kykSyouhn.getKihons());
            keisanDBean.setKsnSiyouUmu(pKessanumu);
            keisanDBean.setHaitouKaisuuBeanList(haitouKaisuuBeanLst);

            errorKbn = keisand.exec(keisanDBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setErrorLink(keisand);

                logger.debug("△ 配当共通計算 配当金計算 終了");

                return errorKbn;
            }

            keisanD = keisand;

            logger.debug("△ 配当共通計算 配当金計算 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn calcKariwariateDGanrikin(String pSyono, BizDate pCalckijyunymd) {

        logger.debug("▽ 配当共通計算 仮割当Ｄ元利金計算 開始");

        clear();
        kariwariateKeisanDGanrikin = null;
        syokaiHaitouMitouraiKariwariateGanrikin = false;
        khHaitouKanri = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        BizCurrency ruigk = BizCurrency.valueOf(0);

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE001);

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

            kykKihonSet.add(kykKihon);

            BizDate syokaiHaitouYmd = kykSyouhn.getKykymd().addYears(1).getRekijyou();
            if (pCalckijyunymd.compareTo(syokaiHaitouYmd) < 0) {
                syokaiHaitouMitouraiKariwariateGanrikin = true;

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            SetDNnd setDNnd = getInjectInstance(SetDNnd.class);

            DRateBean dRateBean = setDNnd.exec(kykSyouhn.getKykymd(), kykSyouhn.getYendthnkymd(), pSyono, pCalckijyunymd);

            if (dRateBean == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorLink(setDNnd);

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            List<HaitouKaisuuBean> haitouKaisuuBeanLst = dRateBean.getHaitouKaisuuBeanLst();
            BizDate calckijyunfromymd = haitouKaisuuBeanLst.get(0).getKikanfrom();
            BizDate calckijyuntoymd = haitouKaisuuBeanLst.get(haitouKaisuuBeanLst.size() - 1).getKikanto();

            DBAccessDCommon dBAccessDCommon = getInjectInstance(DBAccessDCommon.class);

            dBAccessDCommon.getKijyunymdTykzenHaitouKanriSyu(pSyono, calckijyuntoymd);

            khHaitouKanri = dBAccessDCommon.getKhHaitouKanri();

            if (khHaitouKanri != null) {

                ruigk = khHaitouKanri.getKariwariatedruigk();
            }

            KeisanDGanrikin keisanDGanrikin = getInjectInstance(KeisanDGanrikin.class);

            errorKbn = keisanDGanrikin.exec(ruigk, calckijyunfromymd, calckijyuntoymd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setErrorLink(keisanDGanrikin);

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            kariwariateKeisanDGanrikin = keisanDGanrikin;

            logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn calcKariwariateDGanrikin(String pSyono, BizDate pCalckijyunymd, BizDate pCalckijyunymdTyouseiz) {

        logger.debug("▽ 配当共通計算 仮割当Ｄ元利金計算 開始");

        clear();
        kariwariateKeisanDGanrikin = null;
        syokaiHaitouMitouraiKariwariateGanrikin = false;
        khHaitouKanri = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        BizCurrency ruigk = BizCurrency.valueOf(0);

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pCalckijyunymdTyouseiz == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE001);

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

            kykKihonSet.add(kykKihon);

            BizDate syokaiHaitouYmd = kykSyouhn.getKykymd().addYears(1).getRekijyou();
            if (BizDateUtil.compareYmd(pCalckijyunymdTyouseiz, syokaiHaitouYmd) == BizDateUtil.COMPARE_LESSER) {
                syokaiHaitouMitouraiKariwariateGanrikin = true;

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            SetDNnd setDNnd = getInjectInstance(SetDNnd.class);

            List<DRateBean> dRateBeanLst = setDNnd.execCorrespoindingOverAYear(kykSyouhn.getKykymd(), pSyono,
                pCalckijyunymd, pCalckijyunymdTyouseiz);

            if (dRateBeanLst.size() == 0) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorLink(setDNnd);

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            DBAccessDCommon dBAccessDCommon = getInjectInstance(DBAccessDCommon.class);

            dBAccessDCommon.getKijyunymdTykzenHaitouKanriSyu(pSyono, pCalckijyunymdTyouseiz);

            khHaitouKanri = dBAccessDCommon.getKhHaitouKanri();

            if (khHaitouKanri != null) {

                ruigk = khHaitouKanri.getKariwariatedruigk();
            }

            KeisanDGanrikin keisanDGanrikin = getInjectInstance(KeisanDGanrikin.class);

            errorKbn = keisanDGanrikin.execAllowOverAYear(ruigk, dRateBeanLst);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setErrorLink(keisanDGanrikin);

                logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

                return errorKbn;
            }

            kariwariateKeisanDGanrikin = keisanDGanrikin;

            logger.debug("△ 配当共通計算 仮割当Ｄ元利金計算 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn calcTumitateDGanrikin(String pSyono, BizDate pCalckijyunymd) {

        logger.debug("▽ 配当共通計算 積立Ｄ元利金計算 開始");

        clear();
        tumitateKeisanDGanrikin = null;
        khTumitateDKanri = null;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        BizCurrency ruigk = BizCurrency.valueOf(0);

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE001);

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

            kykKihonSet.add(kykKihon);

            BizDate syokaiHaitouYmd = kykSyouhn.getKykymd().addYears(1).getRekijyou();
            if (pCalckijyunymd.compareTo(syokaiHaitouYmd) < 0) {
                syokaiHaitouMitouraiTumitateGanrikin = true;

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            SetDNnd setDNnd = getInjectInstance(SetDNnd.class);

            DRateBean dRateBean = setDNnd.exec(kykSyouhn.getKykymd(), kykSyouhn.getYendthnkymd(), pSyono, pCalckijyunymd);

            if (dRateBean == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorLink(setDNnd);

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            List<HaitouKaisuuBean> haitouKaisuuBeanLst = dRateBean.getHaitouKaisuuBeanLst();
            BizDate calckijyunfromymd = haitouKaisuuBeanLst.get(0).getKikanfrom();
            BizDate calckijyuntoymd = haitouKaisuuBeanLst.get(haitouKaisuuBeanLst.size() - 1).getKikanto();

            DBAccessDCommon dBAccessDCommon = getInjectInstance(DBAccessDCommon.class);

            dBAccessDCommon.getKijyunymdTykzenTumitateDKanri(pSyono, calckijyuntoymd);

            khTumitateDKanri = dBAccessDCommon.getKhTumitateDKanri();

            if (khTumitateDKanri != null) {

                ruigk = khTumitateDKanri.getTumitated();
            }

            KeisanDGanrikin keisanDGanrikin = getInjectInstance(KeisanDGanrikin.class);

            errorKbn = keisanDGanrikin.exec(ruigk, calckijyunfromymd, calckijyuntoymd);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setErrorLink(keisanDGanrikin);

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            tumitateKeisanDGanrikin = keisanDGanrikin;

            logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public C_ErrorKbn calcTumitateDGanrikin(String pSyono, BizDate pCalckijyunymd, BizDate pCalckijyunymdTyouseiz) {

        logger.debug("▽ 配当共通計算 積立Ｄ元利金計算 開始");

        clear();
        tumitateKeisanDGanrikin = null;
        khTumitateDKanri = null;
        syokaiHaitouMitouraiTumitateGanrikin = false;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        BizCurrency ruigk = BizCurrency.valueOf(0);

        final boolean collectEntityFlg = getCollectEntityFlg();

        try {
            if (BizUtil.isBlank(pSyono) || pCalckijyunymd == null || pCalckijyunymdTyouseiz == null) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorInfo(ERRORCODE001);

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
            IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

            kykKihonSet.add(kykKihon);

            BizDate syokaiHaitouYmd = kykSyouhn.getKykymd().addYears(1).getRekijyou();
            if (BizDateUtil.compareYmd(pCalckijyunymdTyouseiz, syokaiHaitouYmd) == BizDateUtil.COMPARE_LESSER) {
                syokaiHaitouMitouraiTumitateGanrikin = true;

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            SetDNnd setDNnd = getInjectInstance(SetDNnd.class);

            List<DRateBean> dRateBeanLst = setDNnd.execCorrespoindingOverAYear(kykSyouhn.getKykymd(), pSyono,
                pCalckijyunymd, pCalckijyunymdTyouseiz);

            if (dRateBeanLst.size() == 0) {

                errorKbn = C_ErrorKbn.ERROR;

                setErrorLink(setDNnd);

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            DBAccessDCommon dBAccessDCommon = getInjectInstance(DBAccessDCommon.class);

            dBAccessDCommon.getKijyunymdTykzenTumitateDKanri(pSyono, pCalckijyunymdTyouseiz);

            khTumitateDKanri = dBAccessDCommon.getKhTumitateDKanri();

            if (khTumitateDKanri != null) {

                ruigk = khTumitateDKanri.getTumitated();
            }

            KeisanDGanrikin keisanDGanrikin = getInjectInstance(KeisanDGanrikin.class);

            errorKbn = keisanDGanrikin.execAllowOverAYear(ruigk, dRateBeanLst);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                setErrorLink(keisanDGanrikin);

                logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

                return errorKbn;
            }

            tumitateKeisanDGanrikin = keisanDGanrikin;

            logger.debug("△ 配当共通計算 積立Ｄ元利金計算 終了");

            return errorKbn;
        }
        finally {
            collectEntity(collectEntityFlg);
        }
    }

    public BizDate getCoordinatedCalcYmd(BizDate pKykymd, BizDate pCalckijyunymd, BizDateYM pJkipjytym) {

        logger.debug("▽ 配当共通計算 調整済計算基準日取得 開始");

        BizDate jikaiHokenryouJyuutouYmd = BizDate.valueOf(pJkipjytym, pKykymd.getDay()).getRekijyou();

        if (BizDateUtil.compareYmd(pCalckijyunymd, jikaiHokenryouJyuutouYmd) != BizDateUtil.COMPARE_GREATER) {

            logger.debug("△ 配当共通計算 調整済計算基準日取得 終了");

            return pCalckijyunymd;
        }

        logger.debug("△ 配当共通計算 調整済計算基準日取得 終了");

        return jikaiHokenryouJyuutouYmd;

    }

    public BizCurrency calcWrmdsKngk(BizCurrency pWrmdsBfGk, List<BizNumber> pHaitouRirituLst) {

        logger.debug("▽ 配当共通計算 割戻し金額計算 開始");

        BizCurrency wrmdsAfGk = pWrmdsBfGk;

        for (int n = pHaitouRirituLst.size() - 1; n >= 0; n--) {

            wrmdsAfGk = wrmdsAfGk.divide(pHaitouRirituLst.get(n).add(BizNumber.valueOf(1)), 0, RoundingMode.UP);
        }

        logger.debug("△ 配当共通計算 割戻し金額計算 終了");

        return wrmdsAfGk;

    }

    public KeisanD getKeisanD() {

        return keisanD;
    }

    public BizCurrency getD() {

        if (syokaiHaitouMitouraiHaitoukin) {
            return BizCurrency.valueOf(0);
        }
        return keisanD.getD();
    }

    public C_NaiteiKakuteiKbn getDNaiteiKakuteiKbn() {

        return keisanD.getDRateSyutokuInfoBean().getNaiteikakuteikbn();
    }

    public KeisanDGanrikin getKariwariateKeisanDGanrikin() {

        return kariwariateKeisanDGanrikin;
    }

    public BizCurrency getKariwariateDGanrikin() {

        if (syokaiHaitouMitouraiKariwariateGanrikin) {
            return BizCurrency.valueOf(0);
        }

        return kariwariateKeisanDGanrikin.getDGanrikin();
    }

    public List<BizNumber> getKariwariateDRirituList() {

        if (syokaiHaitouMitouraiKariwariateGanrikin) {

            return new ArrayList<>();
        }
        return kariwariateKeisanDGanrikin.getHaitouRirituList();
    }

    public IT_KhHaitouKanri getKhHaitouKanri() {

        return khHaitouKanri;
    }

    public C_NaiteiKakuteiKbn getKhHaitouKanriNaiteiKakuteiKbn() {

        if (khHaitouKanri == null) {
            return null;
        }
        return khHaitouKanri.getNaiteikakuteikbn();
    }

    public KhHaitouKanriKeyinfoBean getKeyInfoKhHaitouKanriBean() {

        if (khHaitouKanri == null) {

            return null;
        }

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono(khHaitouKanri.getSyono());
        khHaitouKanriKeyinfoBean.setHaitounendo(khHaitouKanri.getHaitounendo());
        khHaitouKanriKeyinfoBean.setRenno(khHaitouKanri.getRenno());
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(khHaitouKanri.getHaitoukinskskbn());
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(khHaitouKanri.getHaitoumeisaikbn());

        return khHaitouKanriKeyinfoBean;
    }

    public KeisanDGanrikin getTumitateKeisanDGanrikin() {

        return tumitateKeisanDGanrikin;
    }

    public BizCurrency getTumitateDGanrikin() {

        if (syokaiHaitouMitouraiTumitateGanrikin) {
            return BizCurrency.valueOf(0);
        }
        return tumitateKeisanDGanrikin.getDGanrikin();
    }

    public List<BizNumber> getTumitateDRirituList() {

        if (syokaiHaitouMitouraiTumitateGanrikin) {

            return new ArrayList<>();
        }
        return tumitateKeisanDGanrikin.getHaitouRirituList();
    }

    public IT_KhTumitateDKanri getKhTumitateDKanri() {

        return khTumitateDKanri;
    }

    public C_NaiteiKakuteiKbn getKhTumitateDKanriNaiteiKakuteiKbn() {

        if (khTumitateDKanri == null) {
            return null;
        }
        return khTumitateDKanri.getNaiteikakuteikbn();
    }

    public KhTumitateDKanriKeyinfoBean getKeyInfoKhTumitateDKanriBean() {

        if (khTumitateDKanri == null) {

            return null;
        }

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector
            .getInstance(KhTumitateDKanriKeyinfoBean.class);

        khTumitateDKanriKeyinfoBean.setSyono(khTumitateDKanri.getSyono());
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(khTumitateDKanri.getTumitatedtumitateymd());
        khTumitateDKanriKeyinfoBean.setRenno(khTumitateDKanri.getRenno());

        return khTumitateDKanriKeyinfoBean;
    }

    public BizCurrency getTkbtD() {

        return BizCurrency.valueOf(0);
    }

    public void detachKykKihon() {

        for (IT_KykKihon kykKihon : kykKihonSet) {
            kykKihon.noCheckDetach();
        }
    }

    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {

        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);

        if (keisanD != null) {

            editDshrTukiDKoumokuBean.setDkeisanhaitouKin(keisanD.getD());
            editDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(keisanD.getDRateSyutokuInfoBean().getNaiteikakuteikbn());
        }
        editDshrTukiDKoumokuBean.setTkbtHaitou(getTkbtD());

        if (khHaitouKanri != null) {

            editDshrTukiDKoumokuBean.setHaitounendo2(khHaitouKanri.getHaitounendo());
            editDshrTukiDKoumokuBean.setHaitoukinskskbn(khHaitouKanri.getHaitoukinskskbn());
            editDshrTukiDKoumokuBean.setHaitoumeisaikbn(khHaitouKanri.getHaitoumeisaikbn());
            editDshrTukiDKoumokuBean.setFstkariwariatedNendo(khHaitouKanri.getFstkariwariatednendo());
            editDshrTukiDKoumokuBean.setTounendod(khHaitouKanri.getTounendod());
            editDshrTukiDKoumokuBean.setNaiteikakuteiKbn(khHaitouKanri.getNaiteikakuteikbn());
            editDshrTukiDKoumokuBean.setKariwariatedshrYmd(khHaitouKanri.getKariwariatedshrymd());
            editDshrTukiDKoumokuBean.setKariwariatedruiGk2(khHaitouKanri.getKariwariatedruigk());
            editDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(khHaitouKanri.getKariwariatedgngkkngk());
            editDshrTukiDKoumokuBean.setKariwariatedshrGk2(khHaitouKanri.getKariwariatedshrgk());
        }

        if (khTumitateDKanri != null) {

            editDshrTukiDKoumokuBean.setTumitatedtumitateYmd(khTumitateDKanri.getTumitatedtumitateymd());
            editDshrTukiDKoumokuBean.setTumitatedsksKbn(khTumitateDKanri.getTumitatedskskbn());
            editDshrTukiDKoumokuBean.setTumitated2(khTumitateDKanri.getTumitated());
            editDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(khTumitateDKanri.getTumitatedshrkrkymd());
            editDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(khTumitateDKanri.getNaiteikakuteikbn());
        }

        if (kariwariateKeisanDGanrikin != null) {

            editDshrTukiDKoumokuBean.setHaitouganrikincalcKari(kariwariateKeisanDGanrikin.getDGanrikin());
            editDshrTukiDKoumokuBean.setGanrikincalcKariwariatedRirituLst(kariwariateKeisanDGanrikin.getHaitouRirituList());
        }

        if (tumitateKeisanDGanrikin != null) {

            editDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(tumitateKeisanDGanrikin.getDGanrikin());
            editDshrTukiDKoumokuBean.setGanrikincalcTumitatedRirituLst(tumitateKeisanDGanrikin.getHaitouRirituList());
        }

        return editDshrTukiDKoumokuBean;
    }
}
