package yuyu.batch.hozen.khinterf.khsmbcgetujikykmeisaifsks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanGaisanPsougk;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkBean;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.result.bean.SmbckykdtlInfosByKakutyoujobcdBean;
import yuyu.def.hozen.sorter.SortIT_KhTtdkRireki;
import yuyu.def.hozen.sorter.SortIT_KykDairiten;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス ＳＭＢＣ月次契約明細Ｆ作成クラス
 */
public class KhSmbcGetujiKykMeisaiFSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_KykKihon";

    private static final String RECOVERYFILTERIDKBNID = "Kh001";

    private static final String USDDATECENT = "01";

    private static final String AUDCENT = "15";

    private static final String YENDATE= "17";

    private static final String BLANK = "";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;


    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        BizDateYM syoriYm = bzBatchParam.getSyoriYmd().getBizDateYM();
        BizNumber gtmtEigyoubiKawaserateUsd = BizNumber.valueOf(0);
        BizNumber gtmtEigyoubiKawaserateAud = BizNumber.valueOf(0);
        KeisanWExtBean keisanWExtBean = null;
        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        C_ErrorKbn errorKbn =  null;
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        C_ErrorKbn  keisanWErrorKbn = null;
        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNkgSyouhnBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);
        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNkgSyouhnBeanList = new ArrayList<>();
        KeisanIkkatuNyuukinGkBean keisanIkkatuNkgBean = SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);
        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        C_ErrorKbn getKawaseRateResult = getKawaseRate.exec(syoriYmd,
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.USD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTB,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.HUYOU);

        if(C_ErrorKbn.OK.eq(getKawaseRateResult)){

            gtmtEigyoubiKawaserateUsd = getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN);
        }
        else {

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1047,
                syoriYmd.toString(),
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                C_Tuukasyu.USD.getValue(),
                C_Tuukasyu.JPY.getValue(),
                C_KawasetekiyoKbn.TTB.getValue(),
                C_KawasetsryKbn.JISSEIRATE.getValue(),
                C_EigyoubiHoseiKbn.BLNK.getValue(),
                C_YouhiKbn.HUYOU.getValue()));
        }

        getKawaseRateResult = getKawaseRate.exec(syoriYmd,
            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
            C_Tuukasyu.AUD,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTB,
            C_KawasetsryKbn.JISSEIRATE,
            C_EigyoubiHoseiKbn.BLNK,
            C_YouhiKbn.HUYOU);

        if(C_ErrorKbn.OK.eq(getKawaseRateResult)){

            gtmtEigyoubiKawaserateAud = getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN);
        }
        else {

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1047,
                syoriYmd.toString(),
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                C_Tuukasyu.AUD.getValue(),
                C_Tuukasyu.JPY.getValue(),
                C_KawasetekiyoKbn.TTB.getValue(),
                C_KawasetsryKbn.JISSEIRATE.getValue(),
                C_EigyoubiHoseiKbn.BLNK.getValue(),
                C_YouhiKbn.HUYOU.getValue()));
        }

        try(ExDBResults<SmbckykdtlInfosByKakutyoujobcdBean> smbckykdtlInfos =
            hozenDomManager.getSmbckykdtlInfosByKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<ZT_SmbcGetujiKykMeisaiTy> smbcGetujiKykMeisaiTyInserter = new EntityInserter<>();){

            for(SmbckykdtlInfosByKakutyoujobcdBean smbckykdtlInfo : smbckykdtlInfos){

                ZT_SmbcGetujiKykMeisaiTy smbcGetujiKykMeisaiTy = new ZT_SmbcGetujiKykMeisaiTy();
                IT_KykKihon kykKihon = smbckykdtlInfo.getIT_KykKihon();
                IT_KykSyouhn kykSyouhn = smbckykdtlInfo.getIT_KykSyouhn();
                IT_KykSonotaTkyk kykSonotaTkyk = smbckykdtlInfo.getIT_KykSonotaTkyk();
                IT_KykSya kykSya = smbckykdtlInfo.getIT_KykSya();
                IT_HhknSya hhknSya = smbckykdtlInfo.getIT_HhknSya();
                IT_AnsyuKihon ansyuKihon = smbckykdtlInfo.getIT_AnsyuKihon();
                String syono = kykKihon.getSyono();
                String tuukacd = BLANK;
                BizCurrency kaiyakuhr = BizCurrency.valueOf(0);
                BizCurrency getumatuymdidouw = BizCurrency.valueOf(0);

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kykKihon.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                IT_KykKihon kykKihonDairiten = hozenDomManager.getKykKihon(syono);

                if(kykKihonDairiten.getKykDairitens() == null || kykKihonDairiten.getKykDairitens().isEmpty()){

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048, ResourceUtil.getApplicationResources().getString(IT_KykDairiten.TABLE_NAME) ,syono));
                }

                kykKihonDairiten = IT_KykKihonDetacher.detachKykDairitentouched(kykKihonDairiten);

                List<IT_KykDairiten> kykDairitenList = kykKihonDairiten.getKykDairitens();

                SortIT_KykDairiten sortIT_KykDairiten = SWAKInjector.getInstance(SortIT_KykDairiten.class);
                kykDairitenList = sortIT_KykDairiten.OrderIT_KykDairitenByPkAsc(kykDairitenList);

                C_UmuKbn drtenbunumu = kykDairitenList.get(0).getDrtenbunumu();
                String aAtukaiDairitencd = kykDairitenList.get(0).getDrtencd();
                String aAtukaiBosyuucd = kykDairitenList.get(0).getBosyuucd();
                String bAtukaiDairitencd = BLANK;
                String bAtukaiBosyuucd = "000000";

                if(C_UmuKbn.ARI.eq(drtenbunumu)){

                    bAtukaiDairitencd = kykDairitenList.get(1).getDrtencd();
                    bAtukaiBosyuucd = kykDairitenList.get(1).getBosyuucd();
                }

                String kyknmkn = kykSya.getKyknmkn();
                String kyknmkj = kykSya.getKyknmkj();
                String hhknnmkj = hhknSya.getHhknnmkj();

                String hknsyukigou = kykSyouhn.getSyouhncd().substring(0, 2);
                String hokensyuruikigousedaikbn = kykSyouhn.getRyouritusdno().substring(0, 1);
                String mdhnaisyoumeicd = kykKihon.getAisyoumeikbn().getValue();
                BizDate keiyakuYmd = kykSyouhn.getKykymd();
                C_Tuukasyu kyktuukasyu = kykSyouhn.getKyktuukasyu();
                BizNumber tousyokykjikawaserate = BizNumber.valueOf(0.00);
                BizNumber gmeigyoubijikawaserate = BizNumber.valueOf(0.00);

                if(C_Tuukasyu.USD.eq(kyktuukasyu)){

                    tuukacd = USDDATECENT;
                    gmeigyoubijikawaserate = gtmtEigyoubiKawaserateUsd;
                }
                else if(C_Tuukasyu.AUD.eq(kyktuukasyu)){

                    tuukacd = AUDCENT;
                    gmeigyoubijikawaserate = gtmtEigyoubiKawaserateAud;
                }
                else if(C_Tuukasyu.JPY.eq(kyktuukasyu)){
                    tuukacd = YENDATE;
                }

                if(C_Tuukasyu.USD.eq(kyktuukasyu) || C_Tuukasyu.AUD.eq(kyktuukasyu)){

                    getKawaseRateResult = getKawaseRate.exec(kykKihon.getFstpnyknymd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        kyktuukasyu,
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTB,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    if(C_ErrorKbn.OK.eq(getKawaseRateResult)){
                        tousyokykjikawaserate = getKawaseRate.getKawaserate().round(2, RoundingMode.DOWN);
                    }
                    else {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1047,
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                            kyktuukasyu.toString(),
                            kykKihon.getFstpnyknymd().toString(),
                            C_Tuukasyu.JPY.getValue(),
                            C_KawasetekiyoKbn.TTB.getValue(),
                            C_KawasetsryKbn.JISSEIRATE.getValue(),
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                            C_YouhiKbn.HUYOU.getValue()));
                    }

                }


                BizDate tmmsmhneiKiJyunYmd = null;

                C_UmuKbn tumimasiMihanei = C_UmuKbn.NONE;

                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    if (kykSyouhn.getYendthnkymd() == null &&
                        (BizDateUtil.compareYmd(keiyakuYmd, syoriYmd) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(keiyakuYmd, syoriYmd) == BizDateUtil.COMPARE_EQUAL)) {

                        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                            SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
                        hanteiTmttknJyoutaiBean.setSyono(syono);
                        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoriYmd);
                        hanteiTmttknJyoutaiBean.setKykymd(keiyakuYmd);

                        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                        if (!result) {
                            tumimasiMihanei = C_UmuKbn.ARI;

                            SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(syono, syoriYmd);

                            if (sisurendoTmttknInfoBean == null) {

                                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                    IT_KhSisuurendoTmttkn.TABLE_NAME, syono + "　計算基準日：" + syoriYmd));
                            }

                            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                            tmmsmhneiKiJyunYmd = setOutoubi.exec(
                                C_TykzentykgoKbn.TYKGO,
                                keiyakuYmd,
                                C_Hrkkaisuu.NEN,
                                BizDate.valueOf(sisurendoTmttknInfoBean.getTmttknTaisyouYM(), keiyakuYmd.getDay()).getRekijyou()
                                ).getPreviousDay();

                        }
                    }
                }

                BizDate keisanYmd = null;

                if(C_UmuKbn.ARI.eq(tumimasiMihanei)){

                    keisanYmd = tmmsmhneiKiJyunYmd;
                }
                else {

                    keisanYmd = syoriYmd;

                    if (kykSyouhn.getYendthnkymd() != null) {
                        if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                            keisanYmd = kykSyouhn.getYendthnkymd();
                        }
                    }
                    else {
                        if (kykSyouhn.getTmttknitenymd() != null && BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getTmttknitenymd()) == BizDateUtil.COMPARE_LESSER) {
                            keisanYmd = kykSyouhn.getTmttknitenymd();
                        }
                    }
                }

                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                BizDateYM kijunYm = keisanWKijunYM.exec(keiyakuYmd, keisanYmd, ansyuKihon.getJkipjytym(),
                    kykKihon.getHrkkaisuu(), kykSyouhn.getKykjyoutai(), kykSyouhn.getSyouhncd(), kykSyouhn.getYendthnkymd());

                keisanWExtBean = null;
                errorKbn =  keisanWExt.exec(syono, keisanYmd);
                if (C_ErrorKbn.OK.eq(errorKbn)) {

                    keisanWExtBean = keisanWExt.getKeisanWExtBean();
                }
                else {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "解約返戻金計算拡張情報作成" ,syono));

                }

                if ((BizDateUtil.compareYmd(keiyakuYmd, keisanYmd) == BizDateUtil.COMPARE_LESSER) ||
                    (BizDateUtil.compareYmd(keiyakuYmd, keisanYmd) == BizDateUtil.COMPARE_EQUAL)) {
                    keisanWErrorKbn = keisanW.exec(keisanYmd, kijunYm, keisanWExtBean);
                    if (C_ErrorKbn.OK.eq(keisanWErrorKbn)) {

                        BizCurrency kaiyakuhrTuukasyu = keisanW.getW();

                        if(C_Tuukasyu.JPY.eq(kyktuukasyu)){

                            kaiyakuhr = kaiyakuhrTuukasyu;
                        }

                        else if(C_Tuukasyu.USD.eq(kyktuukasyu) || C_Tuukasyu.AUD.eq(kyktuukasyu)){

                            kaiyakuhr = kaiyakuhrTuukasyu.multiply(100);
                        }
                    }
                    else {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "解約返戻金計算" ,syono));
                    }
                }

                String hrkhuhukbn = BLANK;
                long itijibrp = 0;
                long keip = 0;
                long zenkizennoup = 0;
                long tutakngk =0;
                String targettktoutatubi = "00000000";
                long mokuhyouti = 0;
                long mokuhyoukngk = 0;
                String hrkpjyuutouym = "000000";
                long kihrpruikeigk = 0;
                String mankiymd = "99999999";
                String ikkatubaraikbn = "0";
                String ikkatubaraikaisuu= "00";
                String syoumetuYmd= "00000000";

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno());
                if (syouhnZokusei == null) {
                    throw new  CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0005, ResourceUtil.getApplicationResources().getString(BM_SyouhnZokusei.TABLE_NAME), "商品コード", kykSyouhn.getSyouhncd(),
                        "商品世代番号", kykSyouhn.getSyouhnsdno().toString()));
                }

                if (C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {
                    if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        KeisanGaisanPsougk keisanGaisanPsougk = SWAKInjector.getInstance(KeisanGaisanPsougk.class);
                        zenkizennoup = Long.parseLong(keisanGaisanPsougk.exec(kykKihon.getHrkp(), kykKihon.getHrkkaisuu(),
                            kykSyouhn.getKykymd(), kykSyouhn.getHaraimanymd()).toAdsoluteString());
                    }
                    else{
                        zenkizennoup = Long.parseLong(kykSyouhn.getPharaikomisougaku().toAdsoluteString());
                    }
                }
                else {
                    zenkizennoup = 0;
                }

                if (kykSyouhn.getYendthnkymd() != null) {

                    IT_KykKihon itKykKihonTtdkRrk = hozenDomManager.getKykKihon(syono);

                    itKykKihonTtdkRrk = IT_KykKihonDetacher.detachKhTtdkRirekitouched(itKykKihonTtdkRrk);

                    List<IT_KhTtdkRireki> itKhTtdkRirekis =
                        itKykKihonTtdkRrk.getKhTtdkRirekisByGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK);

                    if (itKhTtdkRirekis.size() == 0){
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048, IT_KhTtdkRireki.TABLE_NAME ,syono));
                    }

                    SortIT_KhTtdkRireki sortIT_KhTtdkRireki = SWAKInjector.getInstance(SortIT_KhTtdkRireki.class);

                    itKhTtdkRirekis = sortIT_KhTtdkRireki.OrderIT_KhTtdkRirekiBySyoriYmdDesc(itKhTtdkRirekis);

                    if(C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(itKhTtdkRirekis.get(0).getSyorikbn())){
                        targettktoutatubi = kykSyouhn.getYendthnkymd().getPreviousDay().toString();
                    }
                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

                    mokuhyouti = kykSonotaTkyk.getTargettkmokuhyouti();
                    mokuhyoukngk = Long.parseLong(kykSonotaTkyk.getTargettkykkijyungk().toAdsoluteString());
                }

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    hrkpjyuutouym = ansyuKihon.getJkipjytym().getPreviousMonth().toString();
                }
                else {
                    hrkpjyuutouym = "000000";
                }

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    BizNumber phrruikeitukisuu = BizNumber.valueOf(ansyuKihon.getJkipjytym().subtractMonths(kykSyouhn.getKykymd().getBizDateYM()));
                    BizNumber phrruikeikaisuu = BizNumber.ZERO;

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

                        keisanIkkatuNkgSyouhnBeanList.clear();

                        keisanIkkatuNkgSyouhnBean.setSyouhnCd(kykSyouhn.getSyouhncd());
                        keisanIkkatuNkgSyouhnBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
                        keisanIkkatuNkgSyouhnBean.setRyouritusdNo(kykSyouhn.getRyouritusdno());
                        keisanIkkatuNkgSyouhnBean.setYoteiRiritu(BizNumber.ZERO);
                        keisanIkkatuNkgSyouhnBean.setHokenryou(kykSyouhn.getHokenryou());

                        keisanIkkatuNkgSyouhnBeanList.add(keisanIkkatuNkgSyouhnBean);

                        keisanIkkatuNkgBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(keisanIkkatuNkgSyouhnBeanList);
                        keisanIkkatuNkgBean.setJyuutoutuKisuu(Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().toString()));
                        keisanIkkatuNkgBean.setTkiktbrisyuruiKbn(kykKihon.getTikiktbrisyuruikbn());
                        keisanIkkatuNkgBean.setRstuukasyu(C_Tuukasyu.JPY);
                        keisanIkkatuNkgBean.setNyknaiyouKbn(C_NyknaiyouKbn.BLNK);
                        keisanIkkatuNkgBean.setNykkeiro(C_Nykkeiro.BLNK);
                        keisanIkkatuNkgBean.setSyokaiprsYmd(null);
                        keisanIkkatuNkgBean.setJyutoustartYm(null);

                        C_ErrorKbn keisanIkkatuNyuukinGkErrorKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNkgBean, false);

                        if (C_ErrorKbn.OK.eq(keisanIkkatuNyuukinGkErrorKbn)) {

                            phrruikeikaisuu = phrruikeitukisuu.divide(Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue()));
                            kihrpruikeigk = Long.parseLong(keisanTukiIkkatuNyuukinGk.getIktnyknkgk().multiply(phrruikeikaisuu).toString());
                        }
                        else {
                            throw new CommonBizAppException(
                                MessageUtil.getMessage(MessageId.EIA1010,
                                    "一括入金額計算",
                                    syono));
                        }
                    }
                    else {

                        phrruikeikaisuu = phrruikeitukisuu.divide(Integer.valueOf(kykKihon.getHrkkaisuu().getValue()));
                        kihrpruikeigk = Long.parseLong(kykSyouhn.getHokenryou().multiply(phrruikeikaisuu).toAdsoluteString().toString());
                    }
                }

                if (!C_UmuKbn.ARI.eq(syouhnZokusei.getSyuusinhknumu())) {

                    if (kykSyouhn.getHknkknmanryouymd() != null) {
                        mankiymd = kykSyouhn.getHknkknmanryouymd().getPreviousDay().toString();
                    }
                }

                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                    C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                    ikkatubaraikbn = "2";
                }
                else {
                    ikkatubaraikbn = "0";
                }

                if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                    ikkatubaraikaisuu = "06";
                }
                else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {
                    ikkatubaraikaisuu = "12";
                }
                else {
                    ikkatubaraikaisuu = "00";
                }

                if (BizDateUtil.compareYmd(kykSyouhn.getSyoumetuymd(), syoriYmd) == BizDateUtil.COMPARE_GREATER) {

                    syoumetuYmd = kykSyouhn.getSyoumetuymd().toString();
                }

                BizDate keisanYmdLastDay = null;

                if(C_UmuKbn.ARI.eq(tumimasiMihanei)){

                    keisanYmdLastDay = tmmsmhneiKiJyunYmd;
                }
                else {

                    keisanYmdLastDay = syoriYmd.getBizDateYM().getLastDay();

                    if (kykSyouhn.getYendthnkymd() != null) {
                        if (BizDateUtil.compareYmd(keisanYmdLastDay, kykSyouhn.getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                            keisanYmdLastDay = kykSyouhn.getYendthnkymd();
                        }
                    }
                    else {
                        if (kykSyouhn.getTmttknitenymd() != null && BizDateUtil.compareYmd(keisanYmdLastDay, kykSyouhn.getTmttknitenymd()) == BizDateUtil.COMPARE_LESSER) {
                            keisanYmdLastDay = kykSyouhn.getTmttknitenymd();
                        }
                    }
                }

                keisanWExtBean = null;
                errorKbn =  keisanWExt.exec(syono, keisanYmdLastDay);
                if (C_ErrorKbn.OK.eq(errorKbn)) {

                    keisanWExtBean = keisanWExt.getKeisanWExtBean();
                }
                else {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "解約返戻金計算拡張情報作成" ,syono));
                }
                if ((BizDateUtil.compareYmd(keiyakuYmd, keisanYmdLastDay) == BizDateUtil.COMPARE_LESSER) ||
                    (BizDateUtil.compareYmd(keiyakuYmd, keisanYmdLastDay) == BizDateUtil.COMPARE_EQUAL)) {
                    keisanWErrorKbn = keisanW.exec(keisanYmdLastDay, kijunYm, keisanWExtBean);
                    if (C_ErrorKbn.OK.eq(keisanWErrorKbn)) {

                        BizCurrency kaiyakuhrTuukasyu = keisanW.getW();

                        if(C_Tuukasyu.JPY.eq(kyktuukasyu)){

                            getumatuymdidouw = kaiyakuhrTuukasyu;

                        }else if(C_Tuukasyu.USD.eq(kyktuukasyu) || C_Tuukasyu.AUD.eq(kyktuukasyu)){

                            getumatuymdidouw = kaiyakuhrTuukasyu.multiply(100);
                        }

                    }
                    else {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "解約返戻金計算" ,syono));
                    }
                }

                C_ErrorKbn calcHkErrorKbn = calcHkShrKngk.exec(keisanWExtBean.getSyouhncd(),
                    keisanWExtBean.getSyouhnsdno(),
                    keisanWExtBean.getRyouritusdno(),
                    keisanWExtBean.getYoteiriritu(),
                    keisanWExtBean.getHrkkaisuu(),
                    keisanWExtBean.getHknkknsmnkbn(),
                    keisanWExtBean.getHknkkn(),
                    keisanWExtBean.getHrkkkn(),
                    keisanWExtBean.getHhknnen(),
                    keisanWExtBean.getHhknsei(),
                    keisanWExtBean.getKihons(),
                    keisanWExtBean.getKykymd(),
                    keisanYmdLastDay,
                    syono,
                    keisanWExtBean.getTuukasyu(),
                    kykSyouhn.getDai1hknkkn(),
                    C_SiinKbn.SP,
                    C_HokenkinsyuruiKbn.SBHOKENKIN,
                    keisanWExtBean.getHokenryou(),
                    keisanWExtBean.getKaiyakusjkkktyouseiriritu(),
                    keisanWExtBean.getKyksjkkktyouseiriritu(),
                    keisanWExtBean.getTmttkntaisyouym(),
                    keisanWExtBean.getTeiritutmttkngk(),
                    keisanWExtBean.getSisuurendoutmttkngk(),
                    keisanWExtBean.getTumitateriritu(),
                    keisanWExtBean.getHrkkknsmnkbn(),
                    keisanWExtBean.getJkipjytym(),
                    keisanWExtBean.getPtmttkngk(),
                    keisanWExtBean.getKihrkmpstgk(),
                    keisanWExtBean.getFstpryosyuymd(),
                    keisanWExtBean.getYoteirrthendohosyurrt(),
                    kykSyouhn.getKykjyoutai(),
                    keisanWExtBean.getYendthnkymd(),
                    kykKihon.getSdpdkbn(),
                    kykKihon.getHrkkeiro());

                BizCurrency getumatuymdsibous = BizCurrency.valueOf(0);

                if (C_ErrorKbn.OK.eq(calcHkErrorKbn)) {
                    CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

                    if(C_Tuukasyu.JPY.eq(kyktuukasyu)){

                        getumatuymdsibous = calcHkShrKngkBean.getHokenknGk();
                    }

                    else if(C_Tuukasyu.USD.eq(kyktuukasyu) || C_Tuukasyu.AUD.eq(kyktuukasyu)){

                        getumatuymdsibous = calcHkShrKngkBean.getHokenknGk().multiply(100);
                    }

                }
                else {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1010, "保険金額計算" ,syono));
                }

                smbcGetujiKykMeisaiTy.setZtydatakijyunymd(syoriYmd.toString());
                smbcGetujiKykMeisaiTy.setZtydatakijyunym(syoriYm.toString());
                smbcGetujiKykMeisaiTy.setZtysyono(syono);
                smbcGetujiKykMeisaiTy.setZtyaatukaidirtncd(aAtukaiDairitencd);
                smbcGetujiKykMeisaiTy.setZtybatukaidirtncd(bAtukaiDairitencd);
                smbcGetujiKykMeisaiTy.setZtyaatukaibosyuunincd(aAtukaiBosyuucd);
                smbcGetujiKykMeisaiTy.setZtybatukaibosyuunincd(bAtukaiBosyuucd);
                smbcGetujiKykMeisaiTy.setZtyhknsyukigou(hknsyukigou);
                smbcGetujiKykMeisaiTy.setZtyhknsyuruikigousedaikbn(hokensyuruikigousedaikbn);
                smbcGetujiKykMeisaiTy.setZtymdhnaisyoumeicd(mdhnaisyoumeicd);
                smbcGetujiKykMeisaiTy.setZtytuukacdsmbcgetuji(tuukacd);
                smbcGetujiKykMeisaiTy.setZtyhrkhuhukbn(hrkhuhukbn);
                smbcGetujiKykMeisaiTy.setZtykyknmknsmbcgetuji(kyknmkn);
                smbcGetujiKykMeisaiTy.setZtykyknmkjsmbcgetuji(kyknmkj);
                smbcGetujiKykMeisaiTy.setZtyhhknnmkjsmbcgetuji(hhknnmkj);
                smbcGetujiKykMeisaiTy.setZtyitijibrp(itijibrp);
                smbcGetujiKykMeisaiTy.setZtygoukeip2(keip);
                smbcGetujiKykMeisaiTy.setZtyzenkizennoup(zenkizennoup);
                smbcGetujiKykMeisaiTy.setZtytumitatekngk(tutakngk);
                smbcGetujiKykMeisaiTy.setZtytargettktoutatubi(targettktoutatubi);
                smbcGetujiKykMeisaiTy.setZtymokuhyouti(mokuhyouti);
                smbcGetujiKykMeisaiTy.setZtymokuhyoukngk(mokuhyoukngk);
                smbcGetujiKykMeisaiTy.setZtykaiyakuhr(new BigDecimal(kaiyakuhr.toString()).longValue());
                smbcGetujiKykMeisaiTy.setZtyhrkpjyuutouym(hrkpjyuutouym);
                smbcGetujiKykMeisaiTy.setZtykihrpruikeigk(kihrpruikeigk);
                smbcGetujiKykMeisaiTy.setZtytousyokykjikawaserate(tousyokykjikawaserate);
                smbcGetujiKykMeisaiTy.setZtykykymd(keiyakuYmd.toString());
                smbcGetujiKykMeisaiTy.setZtymankiymd(mankiymd);
                smbcGetujiKykMeisaiTy.setZtyikkatubaraikbn(ikkatubaraikbn);
                smbcGetujiKykMeisaiTy.setZtyikkatubaraikaisuu(ikkatubaraikaisuu);
                smbcGetujiKykMeisaiTy.setZtyyobiv56(BLANK);
                smbcGetujiKykMeisaiTy.setZtygmeigyoubijikawaserate(gmeigyoubijikawaserate);
                smbcGetujiKykMeisaiTy.setZtyyobiv16(BLANK);
                smbcGetujiKykMeisaiTy.setZtysymtymd(syoumetuYmd);
                smbcGetujiKykMeisaiTy.setZtygetumatuymdidouw(Long.parseLong(getumatuymdidouw.toString()));
                smbcGetujiKykMeisaiTy.setZtygetumatuymdsibous(Long.parseLong(getumatuymdsibous.toString())) ;
                smbcGetujiKykMeisaiTy.setZtyyobiv53(BLANK);

                BizPropertyInitializer.initialize(smbcGetujiKykMeisaiTy);

                smbcGetujiKykMeisaiTyInserter.add(smbcGetujiKykMeisaiTy);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001,String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
