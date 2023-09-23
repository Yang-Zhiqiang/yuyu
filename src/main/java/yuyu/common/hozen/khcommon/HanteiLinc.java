package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.string.ConvertUtil;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_LincgthtkekKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_BAK_HhknSya;
import yuyu.def.db.entity.IT_BAK_KykSya;
import yuyu.def.db.entity.IT_BAK_KykSyouhn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.sorter.SortIT_KhLincSousinData;

/**
 * 契約保全 契約保全共通 ＬＩＮＣ該当判定
 */
public class HanteiLinc {

    private static final int KBNVAL_1 = 1;

    private static final int KBNVAL_2 = 2;

    private static final String RAYKOYU_WGHANTEIYO_HOZEN = "H";

    private static final String KKRCODE_KEIYAKUSINSA = "S";

    private IT_KykKihon kykkihon;

    @Inject
    private static Logger logger;

    @Inject
    private BizDomManager bizDomManager;

    public HanteiLinc() {
        super();
    }

    public IT_KykKihon getKykkihon() {

        return kykkihon;
    }

    public C_ErrorKbn exec(HanteiLincBean pHanteiLincBean, KhozenCommonParam pKhozenCommonParam) {

        logger.debug("▽ ＬＩＮＣ該当判定 開始");

        IT_BAK_KykSya bakKykSya = null;
        IT_BAK_HhknSya bakHhknSya = null;
        IT_BAK_KykSyouhn bakKykSyouhn = null;
        IT_KykSya kykSya = pHanteiLincBean.getKykKihon().getKykSya();
        IT_HhknSya hhknSya = pHanteiLincBean.getKykKihon().getHhknSya();
        IT_KykSyouhn kykSyouhn = pHanteiLincBean.getKykKihon().getKykSyouhns().get(0);

        boolean jikkouKahi = false;
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pHanteiLincBean.getBakKykKihon() != null) {

            bakKykSya = pHanteiLincBean.getBakKykKihon().getBAKKykSya();
            bakHhknSya = pHanteiLincBean.getBakKykKihon().getBAKHhknSya();
            bakKykSyouhn = pHanteiLincBean.getBakKykKihon().getBAKKykSyouhns().get(0);
        }

        kykkihon = pHanteiLincBean.getKykKihon();

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());

        C_UmuKbn sbhkuktUmu = syouhnZokusei.getSbhkuktumu();

        if (C_UmuKbn.NONE.eq(sbhkuktUmu)) {

            jikkouKahi = false;
        }
        else {

            if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pKhozenCommonParam.getFunctionId())||
                IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pKhozenCommonParam.getFunctionId())) {

                jikkouKahi = true;
            }
            else {

                if (!bakKykSyouhn.getYuukousyoumetukbn().equals(kykSyouhn.getYuukousyoumetukbn()) ||
                    !bakKykSya.getKyknmkn().equals(kykSya.getKyknmkn()) ||
                    !bakKykSya.getKyknmkj().equals(kykSya.getKyknmkj()) ||
                    !bakKykSya.getKykseiymd().equals(kykSya.getKykseiymd()) ||
                    !bakKykSya.getKyksei().equals(kykSya.getKyksei()) ||
                    !bakKykSya.getTsinyno().equals(kykSya.getTsinyno()) ||
                    !bakHhknSya.getHhknnmkn().equals(hhknSya.getHhknnmkn()) ||
                    !bakHhknSya.getHhknnmkj().equals(hhknSya.getHhknnmkj()) ||
                    !bakKykSyouhn.getKihons().equals(kykSyouhn.getKihons())) {

                    jikkouKahi = true;
                }
                else {

                    jikkouKahi = false;
                }
            }
        }

        if (jikkouKahi) {

            BizDate mosYmd = null;
            String mosYm = "";
            BizCurrency henkougoKihons = BizCurrency.valueOf(0);
            BizNumber kjngkhntiyuKawaserate = BizNumber.valueOf(0);
            KeisanGaikakanzan keisanGaikakanzan  = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                mosYmd = kykkihon.getMosymd();

                if (mosYmd.getMonth() <= 3) {

                    mosYm = mosYmd.getBizDateY().addYears(-1).toString();
                }
                else {

                    mosYm = mosYmd.getBizDateY().toString();
                }

                BM_KijyungkHanteiKawaseRate kijyungkHanteiKawaseRate =
                    bizDomManager.getKijyungkHanteiKawaseRate(mosYm, kykSyouhn.getKyktuukasyu());

                kjngkhntiyuKawaserate = kijyungkHanteiKawaseRate.getKjngkhntiyukawaserate();

                henkougoKihons = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    kykSyouhn.getKihons(),
                    kjngkhntiyuKawaserate,
                    C_HasuusyoriKbn.SUTE);
            }
            else {

                henkougoKihons = kykSyouhn.getKihons();
            }


            int renno = 0;
            String lincHenkouType = null;
            int lincRecordSyubetu = 0;
            boolean sousinTargetFlg = false;
            boolean sousinDataSakujyoFlg = false;

            List<IT_KhLincSousinData> khLincSousinDataLst = new ArrayList<>();

            if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pKhozenCommonParam.getFunctionId())) {

                renno = renno + 1;

                lincRecordSyubetu = YuyuBizConfig.getInstance().getLincrecordsyubetusirtsyurkmusd();

                sousinTargetFlg = true;
            }
            else {

                lincRecordSyubetu = YuyuBizConfig.getInstance().getLincrecordsyubetuturkniyuhnkumusd();

                khLincSousinDataLst = kykkihon.getKhLincSousinDatas(pHanteiLincBean.getSyoriYmd());
                SortIT_KhLincSousinData khLincSousinDataSort = SWAKInjector.getInstance(SortIT_KhLincSousinData.class);
                khLincSousinDataLst = khLincSousinDataSort.OrderIT_KhLincSousinDataByPkDesc(khLincSousinDataLst);

                if (khLincSousinDataLst.size() == 0) {

                    BizCurrency henkoumaeiKihons;

                    if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                        henkoumaeiKihons = keisanGaikakanzan.exec(
                            C_Tuukasyu.JPY,
                            bakKykSyouhn.getKihons(),
                            kjngkhntiyuKawaserate,
                            C_HasuusyoriKbn.SUTE);
                    }
                    else {

                        henkoumaeiKihons = bakKykSyouhn.getKihons();
                    }

                    C_LincgthtkekKbn henkoumaeHanteiLinc = hanteiLincSousinYouhi(
                        pHanteiLincBean.getSyoriYmd(),
                        bakKykSyouhn.getKykymd(),
                        bakKykSyouhn.getYuukousyoumetukbn(),
                        bakKykSyouhn.getKykjyoutai(),
                        henkoumaeiKihons);

                    C_LincgthtkekKbn henkougoHanteiLinc = hanteiLincSousinYouhi(
                        pHanteiLincBean.getSyoriYmd(),
                        kykSyouhn.getKykymd(),
                        kykSyouhn.getYuukousyoumetukbn(),
                        kykSyouhn.getKykjyoutai(),
                        henkougoKihons);

                    if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(henkoumaeHanteiLinc)) {
                        if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(henkougoHanteiLinc)) {

                            lincHenkouType = YuyuBizConfig.getInstance().getLinchenkoutypekousin();
                        }
                        else {

                            lincHenkouType = YuyuBizConfig.getInstance().getLinchenkoutypesakujyo();
                        }
                    }
                    else {
                        if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(henkougoHanteiLinc)) {

                            lincHenkouType = YuyuBizConfig.getInstance().getLinchenkoutypetuika();
                        }
                    }

                    if (lincHenkouType != null) {

                        renno = renno + 1;

                        sousinTargetFlg = true;
                    }
                }
                else {

                    String lincHenkouType1 = khLincSousinDataLst.get(0).getLinchenkoutype();

                    C_LincgthtkekKbn lincgthtkekKbn2 = hanteiLincSousinYouhi(
                        pHanteiLincBean.getSyoriYmd(),
                        kykSyouhn.getKykymd(),
                        kykSyouhn.getYuukousyoumetukbn(),
                        kykSyouhn.getKykjyoutai(),
                        henkougoKihons);

                    if (YuyuBizConfig.getInstance().getLinchenkoutypetuika().equals(lincHenkouType1)) {

                        if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(lincgthtkekKbn2)) {

                            lincHenkouType = YuyuBizConfig.getInstance().getLinchenkoutypetuika();
                        }
                        else {

                            sousinDataSakujyoFlg = true;
                        }
                    }
                    else if (YuyuBizConfig.getInstance().getLinchenkoutypekousin().equals(lincHenkouType1)) {

                        if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(lincgthtkekKbn2)) {

                            lincHenkouType = YuyuBizConfig.getInstance().getLinchenkoutypekousin();
                        }
                        else {

                            lincHenkouType = YuyuBizConfig.getInstance().getLinchenkoutypesakujyo();
                        }
                    }
                    else if (YuyuBizConfig.getInstance().getLinchenkoutypesakujyo().equals(lincHenkouType1)) {

                        if (C_LincgthtkekKbn.SYOUKAITAISYOU.eq(lincgthtkekKbn2)) {

                            lincHenkouType = YuyuBizConfig.getInstance().getLinchenkoutypekousin();
                        }
                    }

                    if (lincHenkouType != null) {

                        renno = khLincSousinDataLst.get(0).getRenno() + 1;

                        sousinTargetFlg = true;
                    }
                }
            }

            C_SousinKbn lincSousinKbn;
            Integer lincKyksei = 0;
            C_KykKbn lincKeihidjnhyouji = C_KykKbn.BLNK;
            String lincHhknnmKn = "";
            Integer lincHhknsei = 0;
            BizDate lincHhknseiymd = null;
            String lincHhknadrKn = "";
            String lincKykadrKn ="";
            String lincKakusyaSiyouran = "";

            if (sousinTargetFlg) {

                if ((pHanteiLincBean.getKanyuusyaNo() == null ||
                    pHanteiLincBean.getKanyuusyaNo() == 0) &&
                    (YuyuBizConfig.getInstance().getLinchenkoutypekousin().equals(lincHenkouType) ||
                        YuyuBizConfig.getInstance().getLinchenkoutypesakujyo().equals(lincHenkouType))) {

                    lincSousinKbn = C_SousinKbn.MISOUSIN;
                }
                else {

                    lincSousinKbn = C_SousinKbn.SOUSINMATI;
                }

                String lincKyknmKn  = ConvertUtil.toHanAll(kykSya.getKyknmkn(), 0, 1);

                if (C_Kyksei.MALE.eq(kykSya.getKyksei())) {

                    lincKyksei = KBNVAL_1;
                }
                else if (C_Kyksei.FEMALE.eq(kykSya.getKyksei())) {

                    lincKyksei = KBNVAL_2;
                }

                List<BM_Address> addressList = bizDomManager.getAddressesByPostalCd(kykSya.getTsinyno());

                if (addressList == null || addressList.size() == 0) {


                }
                else {
                    lincKykadrKn = ConvertUtil.toHanAll(addressList.get(0).getKnadrkyoutotuusyounmari(), 0, 1);

                    Integer knsikuGunnmketasuu = addressList.get(0).getKnsikugunnmketasuu();

                    lincKykadrKn = editString(lincKykadrKn, knsikuGunnmketasuu);

                }

                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {

                    lincKeihidjnhyouji = C_KykKbn.KEIHI_DOUITU;
                }
                else {

                    lincKeihidjnhyouji = C_KykKbn.KEIHI_BETU;
                }

                if (C_KykKbn.KEIHI_DOUITU.eq(lincKeihidjnhyouji)) {

                    lincHhknnmKn = lincKyknmKn;
                    lincHhknsei = lincKyksei;
                    lincHhknseiymd = kykSya.getKykseiymd();
                    lincHhknadrKn = lincKykadrKn;
                }
                else {

                    lincHhknnmKn = ConvertUtil.toHanAll(hhknSya.getHhknnmkn(), 0, 1);

                    if (C_Hhknsei.MALE.eq(hhknSya.getHhknsei())) {

                        lincHhknsei = KBNVAL_1;
                    }
                    else if (C_Hhknsei.FEMALE.eq(hhknSya.getHhknsei())) {

                        lincHhknsei = KBNVAL_2;
                    }

                    lincHhknseiymd = hhknSya.getHhknseiymd();

                    List<BM_Address> hhknsyaAddressList = bizDomManager.getAddressesByPostalCd(hhknSya.getHhknyno());

                    if (hhknsyaAddressList == null || hhknsyaAddressList.size() == 0) {


                    }
                    else{

                        lincHhknadrKn = ConvertUtil.toHanAll(hhknsyaAddressList.get(0).getKnadrkyoutotuusyounmari(), 0, 1);

                        Integer hhkKnsikuGunnmketasuu = hhknsyaAddressList.get(0).getKnsikugunnmketasuu();

                        lincHhknadrKn = editString(lincHhknadrKn, hhkKnsikuGunnmketasuu);

                    }
                }

                if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pKhozenCommonParam.getFunctionId())) {

                    lincKakusyaSiyouran = kykkihon.getSyono() +
                        kykkihon.getSkjmosno() +
                        "                  " +
                        RAYKOYU_WGHANTEIYO_HOZEN +
                        KKRCODE_KEIYAKUSINSA;
                }
                else {
                    lincKakusyaSiyouran = kykkihon.getSyono() +
                        "                           " +
                        RAYKOYU_WGHANTEIYO_HOZEN +
                        " ";
                }

                IT_KhLincSousinData khLincSousinData = kykkihon.createKhLincSousinData();

                khLincSousinData.setMosno(kykkihon.getSkjmosno());
                khLincSousinData.setSyono(kykkihon.getSyono());
                khLincSousinData.setSyoriYmd(pHanteiLincBean.getSyoriYmd());
                khLincSousinData.setRenno(renno);
                khLincSousinData.setLincsousinkbn(lincSousinKbn);
                khLincSousinData.setLincrecordsyubetu(lincRecordSyubetu);
                khLincSousinData.setLinchenkoutype(lincHenkouType);
                khLincSousinData.setLinckanyuusyano(pHanteiLincBean.getKanyuusyaNo());
                khLincSousinData.setLinchhknnmkn(editString(lincHhknnmKn, 32));
                khLincSousinData.setLinchhknnmkj(hhknSya.getHhknnmkj());
                khLincSousinData.setLinchhknsei(lincHhknsei);
                khLincSousinData.setLinchhknseiymd(lincHhknseiymd);
                khLincSousinData.setLinchhknadrkn(editString(lincHhknadrKn, 30));
                khLincSousinData.setLinckeihidjnhyouji(lincKeihidjnhyouji);
                khLincSousinData.setLinckyknmkn(editString(lincKyknmKn, 42));
                khLincSousinData.setLinckyknmkj(kykSya.getKyknmkj());
                khLincSousinData.setLinckyksei(lincKyksei);
                khLincSousinData.setLinckykseiymd(kykSya.getKykseiymd());
                khLincSousinData.setLinckykadrkn(editString(lincKykadrKn, 30));
                khLincSousinData.setLinctrkmousideymd(pHanteiLincBean.getSyoriYmd());
                khLincSousinData.setLinckykymd(kykSyouhn.getKykymd());
                khLincSousinData.setLinchutuusbs(henkougoKihons);
                khLincSousinData.setLinckakusyasiyouran(lincKakusyaSiyouran);
                khLincSousinData.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
                khLincSousinData.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
                khLincSousinData.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BizPropertyInitializer.initialize(khLincSousinData);
            }

            if (sousinDataSakujyoFlg) {

                kykkihon.getKhLincSousinDatas().removeAll(khLincSousinDataLst);
            }
        }

        logger.debug("△ ＬＩＮＣ該当判定 終了");

        return errorKbn;
    }

    private C_LincgthtkekKbn hanteiLincSousinYouhi(BizDate pSyoriYmd, BizDate pKykYmd,
        C_YuukousyoumetuKbn pYuukousyoumetuKbn, C_Kykjyoutai pKykJyoutai, BizCurrency pYenkihons) {

        BizDate gonengoKykOutoubi = pKykYmd.addYears(5).getRekijyou();

        C_LincgthtkekKbn lincgthtkekKbn;

        if (BizDateUtil.compareYmd(gonengoKykOutoubi, pSyoriYmd) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(gonengoKykOutoubi, pSyoriYmd) == BizDateUtil.COMPARE_EQUAL) {

            lincgthtkekKbn = C_LincgthtkekKbn.SYOUKAITAISYOUGAI;
        }
        else {

            if (C_YuukousyoumetuKbn.SYOUMETU.eq(pYuukousyoumetuKbn)) {

                lincgthtkekKbn = C_LincgthtkekKbn.SYOUKAITAISYOUGAI;
            }
            else {

                if (C_Kykjyoutai.ITIJIBARAI.eq(pKykJyoutai) ||
                    C_Kykjyoutai.ZENNOU.eq(pKykJyoutai)) {

                    lincgthtkekKbn = C_LincgthtkekKbn.SYOUKAITAISYOUGAI;
                }
                else {

                    if (pYenkihons.compareTo(YuyuBizConfig.getInstance().getLincGtHutuuSbS()) < 0) {

                        lincgthtkekKbn = C_LincgthtkekKbn.SYOUKAITAISYOUGAI;
                    }
                    else {

                        lincgthtkekKbn = C_LincgthtkekKbn.SYOUKAITAISYOU;
                    }
                }
            }
        }

        return lincgthtkekKbn;
    }
    private String editString(String pEditString, int pNum) {
        String editString = pEditString;

        if (pEditString == null) {
            editString = "";
        }
        else if (pEditString.length() > pNum) {
            editString = pEditString.substring(0, pNum);
        }

        return editString;
    }

}
