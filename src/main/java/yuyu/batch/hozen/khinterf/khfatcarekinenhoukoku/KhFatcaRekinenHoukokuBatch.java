package yuyu.batch.hozen.khinterf.khfatcarekinenhoukoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.haitou.CheckDShrKaiyaku;
import yuyu.common.hozen.haitou.KeisanDCommonKaiyaku;
import yuyu.common.hozen.khcommon.ConvertPALSyoumetucd;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.hozen.khcommon.KeisanMsyMkeiP;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.file.csv.KhFatcaRekinenHkkDataFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス ＦＡＴＣＡ暦年報告抽出クラス
 */

public class KhFatcaRekinenHoukokuBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private static final String TABLEID = "IT_FatcaInfo";

    private static final String FILTERID = "Kh001";

    public BizCurrency keisanWK;

    public BizCurrency haitoukin;

    public BizCurrency mikeikap;

    public C_ErrorKbn kaiyakuhrerrkbn;

    public C_ErrorKbn haitoukinErrkbn;

    public C_ErrorKbn mikeikapErrkbn;

    public BizNumber kawaserate;

    @Inject
    private ConvertPALSyoumetucd convertPALSyoumetucd;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syorikensuu = 0;

        List<KhFatcaRekinenHkkDataFile> khFatcaRekinenHkkDataFileList = new ArrayList<KhFatcaRekinenHkkDataFile>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        BizDate syoriPriviousYMD = bzBatchParam.getSyoriYmd().getPreviousYear();

        BizDate syoriPriviousYearEnd = syoriPriviousYMD.getBizDateY().getLastMonth().getLastDay();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        try (ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean>
        fattatckbnBeanList = hozenDomManager.
        getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(
            bzBatchParam.getIbKakutyoujobcd(),
            syoriPriviousYearEnd,
            C_SyutkKbn.SYU,
            C_FatcakekKbn.TOKUTEIAMERICAN,
            C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU)) {

            Iterator<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> nyknmeisaiIter =
                fattatckbnBeanList.iterator();

            while (nyknmeisaiIter.hasNext()) {


                FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean fattatckbnBean = nyknmeisaiIter
                    .next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(fattatckbnBean.getIT_FatcaInfo().getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(fattatckbnBean.getIT_FatcaInfo().getSyono());

                KhFatcaRekinenHkkDataFile khFatcaRekinenHkkDataFile =
                    SWAKInjector.getInstance(KhFatcaRekinenHkkDataFile.class);

                String ifcLastmeighnksyoriymd = "";

                String ifcKykmeighnksyoriymd = "";

                keisanWK = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                haitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                mikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                BizCurrency ifcCashvaluegkkeigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                kaiyakuhrerrkbn = C_ErrorKbn.OK;
                haitoukinErrkbn = C_ErrorKbn.OK;
                mikeikapErrkbn = C_ErrorKbn.OK;

                kawaserate = BizNumber.valueOf(0);

                String kaiyakuhrerrkbnHyoujy = " ";

                String haitoukinErrkbnHyoujy = " ";

                String mikeikapErrkbnHyoujy = " ";

                String ifcKouryokuEndymd = "";

                String syoumetucd = "";

                String ifcSyoumetuymd = "";

                int syohinHanteiKbn = SyouhinUtil.hantei(fattatckbnBean.getIT_KykSyouhn().getSyouhncd());

                BizCurrency yendthnkhr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                if (fattatckbnBean.getIT_KykSyouhn().getYendthnkymd() != null) {
                    List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(
                        fattatckbnBean.getIT_FatcaInfo().getSyono());
                    if (khHenreikinLst.size() > 0) {
                        yendthnkhr = khHenreikinLst.get(0).getHenreikingk();
                    }
                }


                if (!fattatckbnBean.getIT_KykSyouhn().getSyoumetujiyuu().eq(C_Syoumetujiyuu.BLNK)) {
                    syoumetucd = convertPALSyoumetucd.exec(fattatckbnBean.getIT_KykSyouhn().getSyoumetujiyuu());
                }

                String zrntsinkihontikucd = fattatckbnBean.getIT_KykSya().getTsinyno() + " ";

                if (C_YuukousyoumetuKbn.YUUKOU.eq(fattatckbnBean.getIT_KykSyouhn().getYuukousyoumetukbn())) {

                    BizDate pCalckijyunymd = bzBatchParam.getSyoriYmd().getBizDateY().getLastMonth().getLastDay();

                    getKawaseRate(pCalckijyunymd, fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu());

                    if (fattatckbnBean.getIT_KykSyouhn().getKykymd().compareTo(pCalckijyunymd) > 0) {
                        createKykbimaeKiykhnriknData(fattatckbnBean, pCalckijyunymd, syohinHanteiKbn, kawaserate);
                    }
                    else{
                        createKiykhnriknData(fattatckbnBean, pCalckijyunymd, yendthnkhr, syohinHanteiKbn, kawaserate);
                        createHaitoukinData(fattatckbnBean, pCalckijyunymd);
                        createMikeikapData(fattatckbnBean, pCalckijyunymd, syohinHanteiKbn, kawaserate);

                    }
                }

                else {

                    BizDate pCalckijyunymd = fattatckbnBean.getIT_KykSyouhn().getSyoumetuymd();

                    getKawaseRate(pCalckijyunymd, fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu());
                    createKiykhnriknData(fattatckbnBean, pCalckijyunymd, yendthnkhr, syohinHanteiKbn, kawaserate);
                    createHaitoukinData(fattatckbnBean, pCalckijyunymd);
                    createMikeikapData(fattatckbnBean, pCalckijyunymd, syohinHanteiKbn, kawaserate);

                }

                if (C_ErrorKbn.OK.eq(kaiyakuhrerrkbn)) {

                    ifcCashvaluegkkeigk = keisanWK;
                }

                if (C_ErrorKbn.OK.eq(haitoukinErrkbn)) {
                    ifcCashvaluegkkeigk = ifcCashvaluegkkeigk.add(haitoukin);
                }
                if (C_ErrorKbn.OK.eq(mikeikapErrkbn)) {
                    ifcCashvaluegkkeigk = ifcCashvaluegkkeigk.add(mikeikap);
                }

                if (fattatckbnBean.getIT_KykKihon().getLastmeihenymd() != null) {

                    ifcLastmeighnksyoriymd = fattatckbnBean.getIT_KykKihon().getLastmeihenymd().toString();
                }

                if (fattatckbnBean.getIT_KykKihon().getLastkykmeighnkymd() != null) {

                    ifcKykmeighnksyoriymd = fattatckbnBean.getIT_KykKihon().getLastkykmeighnkymd().toString();
                }

                if (fattatckbnBean.getIT_FatcaInfo().getKouryokuendymd() != null) {

                    ifcKouryokuEndymd = fattatckbnBean.getIT_FatcaInfo().getKouryokuendymd().toString();
                }

                if (fattatckbnBean.getIT_KykSyouhn().getSyoumetuymd() != null) {

                    ifcSyoumetuymd = fattatckbnBean.getIT_KykSyouhn().getSyoumetuymd().toString();
                }

                if (C_ErrorKbn.ERROR.eq(kaiyakuhrerrkbn)) {
                    kaiyakuhrerrkbnHyoujy = "1";
                }

                if (C_ErrorKbn.ERROR.eq(haitoukinErrkbn)) {
                    haitoukinErrkbnHyoujy = "1";
                }

                if (C_ErrorKbn.ERROR.eq(mikeikapErrkbn)) {
                    mikeikapErrkbnHyoujy = "1";
                }

                khFatcaRekinenHkkDataFile.
                setIfcFatcakaksyoriymd(String.valueOf(fattatckbnBean.getIT_FatcaInfo().getSyoriYmd()));

                khFatcaRekinenHkkDataFile.
                setIfcFatcakaksyorino(String.valueOf(fattatckbnBean.getIT_FatcaInfo().getRenno()));

                khFatcaRekinenHkkDataFile.
                setIfcFatcakaksyoricd(fattatckbnBean.getIT_FatcaInfo().getFatcahankeiikbn());

                khFatcaRekinenHkkDataFile.
                setIfcFatcakaksyorisosikicd(fattatckbnBean.getIT_FatcaInfo().getSyorisosikicd());

                khFatcaRekinenHkkDataFile.setIfcFatcakaktgkbn(fattatckbnBean.getIT_FatcaInfo().getFatcatgkbn());

                khFatcaRekinenHkkDataFile.setIfcFatcakakkekkakbn(fattatckbnBean.getIT_FatcaInfo().getFatcakekkbn());

                khFatcaRekinenHkkDataFile.setIfcFatcakakhingyoutaikbn("0");

                khFatcaRekinenHkkDataFile.setIfcFatcakakbikknzsyno(fattatckbnBean.getIT_FatcaInfo().getBikknzsyno());

                khFatcaRekinenHkkDataFile.setIfcFatcakakkryksyryymd(ifcKouryokuEndymd);

                khFatcaRekinenHkkDataFile.setIfcSyono(fattatckbnBean.getIT_FatcaInfo().getSyono());

                khFatcaRekinenHkkDataFile.setIfcSyoumetucd(syoumetucd);

                khFatcaRekinenHkkDataFile.setIfcSyoumetuymd(ifcSyoumetuymd);

                khFatcaRekinenHkkDataFile.
                setIfcOkyksmno(Strings.padEnd("", 10, '0'));

                khFatcaRekinenHkkDataFile.setIfcHjncd(Strings.padEnd("", 9, '0'));

                khFatcaRekinenHkkDataFile.setIfcDntcd(Strings.padEnd("", 8, '0'));

                khFatcaRekinenHkkDataFile.
                setIfcKykknmeigi(ConvertUtil.fromZenKataKana(fattatckbnBean.getIT_KykSya().getKyknmkn(), 1));

                khFatcaRekinenHkkDataFile.setIfcKykkjmeigi(fattatckbnBean.getIT_KykSya().getKyknmkj());

                khFatcaRekinenHkkDataFile.
                setIfcKykseiymd(String.valueOf(fattatckbnBean.getIT_KykSya().getKykseiymd()));

                khFatcaRekinenHkkDataFile.setIfcHjndaiknmeigi(Strings.padEnd("", 30, ' '));

                khFatcaRekinenHkkDataFile.setIfcHjndaikjmeigi(Strings.padEnd("", 38, '　'));

                khFatcaRekinenHkkDataFile.setIfcHjndaiseiymd(Strings.padEnd("", 8, '0'));
                khFatcaRekinenHkkDataFile.setIfcTsinkihontikucd(zrntsinkihontikucd);

                khFatcaRekinenHkkDataFile.setIfcTsinkaiadr(fattatckbnBean.getIT_KykSya().getTsinadr1kj()
                    + fattatckbnBean.getIT_KykSya().getTsinadr2kj()
                    + fattatckbnBean.getIT_KykSya().getTsinadr3kj());

                khFatcaRekinenHkkDataFile.setIfcTsintelno(fattatckbnBean.getIT_KykSya().getTsintelno());

                khFatcaRekinenHkkDataFile.setIfcLastmeighnksyoriymd(ifcLastmeighnksyoriymd);

                khFatcaRekinenHkkDataFile.setIfcKykmeighnksyoriymd(ifcKykmeighnksyoriymd);

                khFatcaRekinenHkkDataFile.setIfcTysytkbn("01");

                khFatcaRekinenHkkDataFile.setIfcCashvaluegkkeigk(ifcCashvaluegkkeigk.toString());

                khFatcaRekinenHkkDataFile.setIfcKaiyakuhr(keisanWK.toString());

                khFatcaRekinenHkkDataFile.setIfcSznkyhkn("0");

                khFatcaRekinenHkkDataFile.setIfcHaitoukin(haitoukin.toString());

                khFatcaRekinenHkkDataFile.setIfcMikeikap(mikeikap.toString());

                if (C_ErrorKbn.OK.eq(kaiyakuhrerrkbn) &&
                    C_ErrorKbn.OK.eq(haitoukinErrkbn) &&
                    C_ErrorKbn.OK.eq(mikeikapErrkbn) ) {

                    khFatcaRekinenHkkDataFile.setIfcCvkeisanhukahyouji("0");

                } else {

                    khFatcaRekinenHkkDataFile.setIfcCvkeisanhukahyouji("1");
                }

                khFatcaRekinenHkkDataFile.setIfcKaiyakuhrerrkbn(kaiyakuhrerrkbnHyoujy);

                khFatcaRekinenHkkDataFile.setIfcSznkyhknerrkbn(" ");

                khFatcaRekinenHkkDataFile.setIfcHaitoukinerrkbn(haitoukinErrkbnHyoujy);

                khFatcaRekinenHkkDataFile.setIfcMikeikaperrkbn(mikeikapErrkbnHyoujy);

                khFatcaRekinenHkkDataFileList.add(khFatcaRekinenHkkDataFile);

                syorikensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_FATCAREKINENHKKDATA, khFatcaRekinenHkkDataFileList, false);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syorikensuu)));

    }

    private void createKiykhnriknData(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean
        fattatckbnBean, BizDate pCalckijyunymd, BizCurrency pYendthnkhr, int pSyohinHanteiKbn, BizNumber pKawaserate) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu());
        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency keisanYenHenkanMae = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenAzukariganrikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        Map<CurrencyType, BizCurrency> tuukasyuKrkgkGoukeiMap = null;
        BizCurrency yenKakrkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyohinHanteiKbn) &&
            fattatckbnBean.getIT_KykSyouhn().getYendthnkymd() == null) {
            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai = SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
            hanteiTmttknJyoutaiBean.setSyono(fattatckbnBean.getIT_FatcaInfo().getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(pCalckijyunymd);
            hanteiTmttknJyoutaiBean.setKykymd(fattatckbnBean.getIT_KykSyouhn().getKykymd());
            boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);
            if (!result) {
                kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
                return;
            }
        }

        BizDate yendthnkymd = null;
        if (fattatckbnBean.getIT_KykSyouhn().getYendthnkymd() != null) {
            yendthnkymd = fattatckbnBean.getIT_KykSyouhn().getYendthnkymd();
        }
        BizDateYM keisanWKijunYMWk = keisanWKijunYM.exec(fattatckbnBean.getIT_KykSyouhn().getKykymd(),
            pCalckijyunymd,
            fattatckbnBean.getIT_AnsyuKihon().getJkipjytym(),
            fattatckbnBean.getIT_KykKihon().getHrkkaisuu(),
            fattatckbnBean.getIT_KykSyouhn().getKykjyoutai(),
            fattatckbnBean.getIT_KykSyouhn().getSyouhncd(),
            yendthnkymd);

        C_ErrorKbn cErrorKbnResult = keisanWExt.exec(fattatckbnBean.getIT_FatcaInfo().getSyono(), pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(cErrorKbnResult)) {
            kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
            return;
        }

        C_ErrorKbn kErrorKbnResult = keisanW.exec(pCalckijyunymd, keisanWKijunYMWk, keisanWExt.getKeisanWExtBean());

        if (C_ErrorKbn.OK.eq(kErrorKbnResult)) {
            keisanYenHenkanMae = keisanW.getW();

            KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);

            C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(
                fattatckbnBean.getIT_FatcaInfo().getSyono(),
                pCalckijyunymd,
                fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
                return;
            }

            keisanYenHenkanMae = keisanYenHenkanMae.add(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka());
            yenAzukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();

            tuukasyuKrkgkGoukeiMap = fattatckbnBean.getIT_KykKihon().getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
            if (tuukasyuKrkgkGoukeiMap.size() != 0) {
                yenKakrkgk = tuukasyuKrkgkGoukeiMap.get(BizCurrencyTypes.YEN);
            }

            if (!(C_Tuukasyu.JPY.eq(fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu()))) {

                keisanWK = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    keisanYenHenkanMae,
                    pKawaserate,
                    C_HasuusyoriKbn.SUTE).add(yenAzukariganrikin).add(yenKakrkgk);

            } else {
                keisanWK = keisanYenHenkanMae.add(pYendthnkhr).add(yenAzukariganrikin).add(yenKakrkgk);
            }

        } else {
            kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private void createKykbimaeKiykhnriknData(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean
        fattatckbnBean, BizDate pCalckijyunymd, int pSyohinHanteiKbn, BizNumber pKawaserate) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu());
        BizCurrency keisanYenHenkanMae = BizCurrency.valueOf(0, currencyType);

        if ((SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == pSyohinHanteiKbn ||
            SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 == pSyohinHanteiKbn)
            && fattatckbnBean.getIT_KykSyouhn().getYendthnkymd() == null) {

            SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(
                fattatckbnBean.getIT_FatcaInfo().getSyono(), fattatckbnBean.getIT_KykSyouhn().getKykymd());

            keisanYenHenkanMae = sisurendoTmttknInfoBean.getTeirituTmttknGK().add(
                sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());

            keisanWK = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                keisanYenHenkanMae,
                pKawaserate,
                C_HasuusyoriKbn.SUTE);
        }
        else if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == pSyohinHanteiKbn ||
            SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == pSyohinHanteiKbn) {
            KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);
            C_ErrorKbn errorKbn = keisanKihrkP.exec(
                fattatckbnBean.getIT_FatcaInfo().getSyono(),
                fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
                return;
            }

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == pSyohinHanteiKbn) {

                keisanWK = keisanKihrkP.getYenKihrkP();
            }
            else {

                if (C_Tuukasyu.JPY.eq(fattatckbnBean.getIT_KykSyouhn().getKyktuukasyu())) {

                    keisanWK = keisanKihrkP.getYenKihrkP();
                }
                else {

                    keisanYenHenkanMae = keisanKihrkP.getKihrkP();

                    keisanWK = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        keisanYenHenkanMae,
                        pKawaserate,
                        C_HasuusyoriKbn.SUTE);
                }
            }
        }
    }

    private void createHaitoukinData(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean
        pFattatckbnBean, BizDate pCalckijyunymd) {
        CheckDShrKaiyaku checkDShrKaiyaku = SWAKInjector.getInstance(CheckDShrKaiyaku.class);

        C_YouhiKbn pMinyuuCheckYouhi = null;

        if(C_Kykjyoutai.ITIJIBARAI.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())){

            pMinyuuCheckYouhi = C_YouhiKbn.HUYOU;
        }
        else if (C_Kykjyoutai.HRKMTYUU.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())
            || C_Kykjyoutai.IKKATUNK.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())
            || C_Kykjyoutai.ZENNOU.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())) {

            pMinyuuCheckYouhi = C_YouhiKbn.YOU;
        }

        C_ErrorKbn errorKbn = checkDShrKaiyaku.checkDShr(
            pFattatckbnBean.getIT_FatcaInfo().getSyono(),
            pCalckijyunymd,
            pFattatckbnBean.getIT_AnsyuKihon().getJkipjytym(),
            pMinyuuCheckYouhi,
            pCalckijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn) ||
            C_SyorikahiKbn.SYORIHUKA.eq(checkDShrKaiyaku.getSyorikahiKbn())) {
            haitoukinErrkbn = C_ErrorKbn.ERROR;
            return;
        }

        KeisanDCommonKaiyaku keisanDCommonKaiyaku = SWAKInjector.getInstance(KeisanDCommonKaiyaku.class);
        errorKbn = keisanDCommonKaiyaku.calcDShrgk(
            pFattatckbnBean.getIT_FatcaInfo().getSyono(),
            pCalckijyunymd,
            pCalckijyunymd,
            pFattatckbnBean.getIT_AnsyuKihon().getJkipjytym());
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            haitoukinErrkbn = C_ErrorKbn.ERROR;
            return;
        }
        haitoukin = keisanDCommonKaiyaku.getDShrkn();
    }

    private void createMikeikapData(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean
        pFattatckbnBean, BizDate pCalckijyunymd, int pSyohinHanteiKbn, BizNumber pKawaserate) {

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pFattatckbnBean.getIT_KykSyouhn().getKyktuukasyu());

        BizCurrency yenZennouseisangk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenMikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizDateYM jkipjytYm = null;
        BizCurrency gaiZennouseisangk = BizCurrency.valueOf(0, currencyType);
        BizCurrency gaiMikeikap = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenksMaeMikeikap = BizCurrency.valueOf(0, currencyType);

        if (C_Kykjyoutai.HRKMTYUU.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())
            || C_Kykjyoutai.IKKATUNK.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())
            || C_Kykjyoutai.ZENNOU.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())) {

            if (C_Kykjyoutai.ZENNOU.eq(pFattatckbnBean.getIT_KykSyouhn().getKykjyoutai())) {

                SortIT_Zennou sortIT_Zennou = new SortIT_Zennou();

                IT_Zennou zennou = sortIT_Zennou.OrderIT_ZennouByPkDesc(pFattatckbnBean.getIT_AnsyuKihon().getZennous()).get(0);

                KeisanZennouSeisanGk2 keisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(pCalckijyunymd, pFattatckbnBean.getIT_KykSyouhn().getKykymd(),
                    zennou.getZennoujihrkp(), zennou.getZennoukaisiymd(), zennou.getRyosyuymd(), zennou.getZennounyuukinkgk());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    mikeikapErrkbn = C_ErrorKbn.ERROR;
                    return;
                }

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == pSyohinHanteiKbn) {

                    yenZennouseisangk = keisanZennouSeisanGk2.getZennouSeisanGk();
                }
                else {

                    if (C_Tuukasyu.JPY.eq(pFattatckbnBean.getIT_KykSyouhn().getKyktuukasyu())) {

                        yenZennouseisangk = keisanZennouSeisanGk2.getZennouSeisanGk();
                    }
                    else {

                        gaiZennouseisangk = keisanZennouSeisanGk2.getZennouSeisanGk();
                    }
                }

                jkipjytYm = keisanZennouSeisanGk2.getLastPJyuutouYm().addYears(1);

            }
            else {
                jkipjytYm = pFattatckbnBean.getIT_AnsyuKihon().getJkipjytym();
            }

            KeisanMsyMkeiP keisanMsyMkeiPMae = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
            keisanMsyMkeiPMae.exec(pFattatckbnBean.getIT_FatcaInfo().getSyono(),
                pCalckijyunymd,
                jkipjytYm,
                pFattatckbnBean.getIT_KykSyouhn().getHokenryou(),
                C_MisyuptsKbn.MITS);

            if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == pSyohinHanteiKbn) {

                yenMikeikap = keisanMsyMkeiPMae.getMikeikaP();
            }
            else {

                if (C_Tuukasyu.JPY.eq(pFattatckbnBean.getIT_KykSyouhn().getKyktuukasyu())) {

                    yenMikeikap = keisanMsyMkeiPMae.getMikeikaP();
                }
                else {

                    gaiMikeikap = keisanMsyMkeiPMae.getMikeikaP();
                }
            }

            yenksMaeMikeikap = gaiZennouseisangk.add(gaiMikeikap);

            if (yenksMaeMikeikap.compareTo(BizCurrency.valueOf(0, yenksMaeMikeikap.getType())) > 0) {

                mikeikap = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    yenksMaeMikeikap,
                    pKawaserate,
                    C_HasuusyoriKbn.SUTE);
            }
            else {

                mikeikap = yenZennouseisangk.add(yenMikeikap);
            }
        }
    }

    private void getKawaseRate(BizDate pKwsratekjYmd, C_Tuukasyu pKyktuukasyu) {

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        if (!C_Tuukasyu.JPY.eq(pKyktuukasyu)) {

            C_ErrorKbn errorKbn = getKawaseRate.exec(
                pKwsratekjYmd,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pKyktuukasyu,
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("為替レート取得に失敗しました。" +
                    "基準日：" + pKwsratekjYmd +
                    "　種類区分：" + C_KawaserateSyuruiKbn.PM17JIKAWASERATE +
                    "　元通貨：" + pKyktuukasyu +
                    "　換算通貨：" + C_Tuukasyu.JPY +
                    "　適用区分：" + C_KawasetekiyoKbn.TTM +
                    "　手数料区分：" + C_KawasetsryKbn.JISSEIRATE +
                    "　営業日補正区分：" + C_EigyoubiHoseiKbn.ZENEIGYOUBI +
                    "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
            }

            kawaserate = getKawaseRate.getKawaserate();
        }

    }
}
