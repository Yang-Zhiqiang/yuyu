package yuyu.batch.hozen.khinterf.khaeoirekinenhoukoku;

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
import yuyu.batch.hozen.khinterf.khaeoirekinenhoukoku.dba.AeoiInfoBean;
import yuyu.batch.hozen.khinterf.khaeoirekinenhoukoku.dba.KhAeoiRekinenHoukokuDao;
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
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
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
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.file.csv.KhAeoiRekinenHkkDataFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.sorter.SortIT_Zennou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス ＡＥＯＩ暦年報告抽出クラス
 */
public class KhAeoiRekinenHoukokuBatch implements Batch {


    private static final  String TABLEID = "IT_AeoiInfo";

    private static final String FILTERID = "Kh001";

    private BizCurrency keisanWK = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency haitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private BizCurrency mikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

    private C_ErrorKbn kaiyakuhrerrkbn =  C_ErrorKbn.OK;

    private C_ErrorKbn haitoukinerrkbn =  C_ErrorKbn.OK;

    private C_ErrorKbn mikeikaperrkbn =  C_ErrorKbn.OK;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhAeoiRekinenHoukokuDao khAeoiRekinenHoukokuDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private ConvertPALSyoumetucd convertPALSyoumetucd;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syorikensuu = 0;

        List<KhAeoiRekinenHkkDataFile> khAeoiRekinenHkkDataFileList = new ArrayList<KhAeoiRekinenHkkDataFile>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        BizDate syoriPriviousYMD = syoriYmd.getPreviousYear();

        BizDate syoriPriviousYearEnd = syoriPriviousYMD.getBizDateY().getLastMonth().getLastDay();

        try(ExDBResults<AeoiInfoBean>
        aeoikbnBeanList =khAeoiRekinenHoukokuDao.
        getAeoiInfoBeanByKakutyoujobcdAeoikekkakbnAeoikouryokuendymdSyutkkbn(
            bzBatchParam.getIbKakutyoujobcd() ,
            C_AeoiKekkaKbn.HOUKOKUTAISYOU ,
            syoriPriviousYearEnd ,
            C_SyutkKbn.SYU
            )) {

            Iterator<AeoiInfoBean> nyknmeisaiIter =
                aeoikbnBeanList.iterator();

            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
            bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1("");
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2("");

            while (nyknmeisaiIter.hasNext()) {

                AeoiInfoBean aeoikbnBean = nyknmeisaiIter.next();

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(aeoikbnBean.getIT_AeoiInfo().getKbnkey());

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(aeoikbnBean.getIT_AeoiInfo().getSyono());

                KhAeoiRekinenHkkDataFile khAeoiRekinenHkkDataFile =
                    SWAKInjector.getInstance(KhAeoiRekinenHkkDataFile.class);

                keisanWK = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                haitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                mikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                BizCurrency ifcCashvaluegkkeigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                BizCurrency yendthnkhr = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                kaiyakuhrerrkbn = C_ErrorKbn.OK;

                String kaiyakuhrerrkbnHyoujy = " ";

                haitoukinerrkbn =  C_ErrorKbn.OK;

                String haitoukinerrkbnHyoujy = " ";

                mikeikaperrkbn =  C_ErrorKbn.OK;

                String mikeikaperrkbnHyoujy = " ";

                String cvkeisanhukahyouji = "0";

                String ifcLastmeighnksyoriymd = "";

                String ifcKykmeighnksyoriymd = "";

                String syoumetucd = "";

                String ifcSyoumetuymd = "";

                int syouhnHanteikbn = SyouhinUtil.hantei(aeoikbnBean.getIT_KykSyouhn().getSyouhncd());

                BizNumber kawaserate = BizNumber.valueOf(0);

                if (aeoikbnBean.getIT_KykSyouhn().getYendthnkymd() != null) {
                    List<IT_KhHenreikin> khHenreikinLst = hozenDomManager.getKhHenreikinYendtMbrsBySyono(
                        aeoikbnBean.getIT_AeoiInfo().getSyono());
                    if (khHenreikinLst.size() > 0) {
                        yendthnkhr = khHenreikinLst.get(0).getHenreikingk();
                    }
                }

                if(!aeoikbnBean.getIT_KykSyouhn().getSyoumetujiyuu().eq(C_Syoumetujiyuu.BLNK)){
                    syoumetucd = convertPALSyoumetucd.exec(aeoikbnBean.getIT_KykSyouhn().getSyoumetujiyuu());
                }

                if(aeoikbnBean.getIT_KykSyouhn().getSyoumetuymd() != null){

                    ifcSyoumetuymd = aeoikbnBean.getIT_KykSyouhn().getSyoumetuymd().toString();
                }

                String zrntsinkihontikucd = aeoikbnBean.getIT_KykSya().getTsinyno() + " ";

                BizDate pCalckijyunymd = null;
                if (C_YuukousyoumetuKbn.YUUKOU.eq(aeoikbnBean.getIT_KykSyouhn().getYuukousyoumetukbn())) {

                    pCalckijyunymd = bzBatchParam.getSyoriYmd().getBizDateY().getLastMonth().getLastDay();

                }
                else{
                    pCalckijyunymd =aeoikbnBean.getIT_KykSyouhn().getSyoumetuymd();
                }

                if (!(C_Tuukasyu.JPY.eq(aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu()))) {
                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                    C_ErrorKbn cErrorKbnResultKawase = getKawaseRate.exec(
                        pCalckijyunymd,
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTB,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    if(C_ErrorKbn.ERROR.eq(cErrorKbnResultKawase)){
                        throw new CommonBizAppException("為替レート取得に失敗しました。" +
                            "基準日：" + pCalckijyunymd +
                            "　種類区分：" + C_KawaserateSyuruiKbn.PM17JIKAWASERATE +
                            "　元通貨：" + aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu() +
                            "　換算通貨：" + C_Tuukasyu.JPY +
                            "　適用区分：" + C_KawasetekiyoKbn.TTB +
                            "　手数料区分：" + C_KawasetsryKbn.JISSEIRATE +
                            "　営業日補正区分：" + C_EigyoubiHoseiKbn.ZENEIGYOUBI +
                            "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
                    }

                    kawaserate = getKawaseRate.getKawaserate();
                }
                if (aeoikbnBean.getIT_KykSyouhn().getKykymd().compareTo(pCalckijyunymd) > 0) {
                    createKykbimaeKiykhnriknData(aeoikbnBean, pCalckijyunymd, syouhnHanteikbn, kawaserate);
                }
                else{
                    createKiykhnriknData(aeoikbnBean, pCalckijyunymd, yendthnkhr, syouhnHanteikbn, kawaserate);
                    createHaitoukinData(aeoikbnBean, pCalckijyunymd);
                    createMikeikapData(aeoikbnBean, pCalckijyunymd, syouhnHanteikbn, kawaserate);
                }

                if( C_ErrorKbn.OK.eq(kaiyakuhrerrkbn)) {

                    ifcCashvaluegkkeigk = keisanWK;
                }else{

                    kaiyakuhrerrkbnHyoujy = "1";
                }
                if (C_ErrorKbn.OK.eq(haitoukinerrkbn)) {
                    ifcCashvaluegkkeigk = ifcCashvaluegkkeigk.add(haitoukin);
                }
                else {
                    haitoukinerrkbnHyoujy = "1";
                }
                if (C_ErrorKbn.OK.eq(mikeikaperrkbn)) {
                    ifcCashvaluegkkeigk = ifcCashvaluegkkeigk.add(mikeikap);
                }
                else {
                    mikeikaperrkbnHyoujy = "1";
                }

                if(kaiyakuhrerrkbnHyoujy.equals("1") ||
                    haitoukinerrkbnHyoujy.equals("1") ||
                    mikeikaperrkbnHyoujy.equals("1")) {
                    cvkeisanhukahyouji = "1";
                }

                if(aeoikbnBean.getIT_KykKihon().getLastmeihenymd() != null) {

                    ifcLastmeighnksyoriymd = aeoikbnBean.getIT_KykKihon().getLastmeihenymd().toString();
                }

                if(aeoikbnBean.getIT_KykKihon().getLastkykmeighnkymd() != null) {

                    ifcKykmeighnksyoriymd = aeoikbnBean.getIT_KykKihon().getLastkykmeighnkymd().toString();
                }
                khAeoiRekinenHkkDataFile.
                setIfcAeoikaksyoriymd(aeoikbnBean.getIT_AeoiInfo().getAeoisyoriymd());

                khAeoiRekinenHkkDataFile.
                setIfcAeoikaksyorino(aeoikbnBean.getIT_AeoiInfo().getRenno());

                khAeoiRekinenHkkDataFile.
                setIfcAeoikaksyoricd(aeoikbnBean.getIT_AeoiInfo().getAeoisyorikbn());

                khAeoiRekinenHkkDataFile.
                setIfcAeoikaksyorisosikicd(aeoikbnBean.getIT_AeoiInfo().getAeoisyorisosikicd());

                khAeoiRekinenHkkDataFile.setIfcAeoikaktgkbn(aeoikbnBean.getIT_AeoiInfo().getAeoitaisyousyakbn());

                khAeoiRekinenHkkDataFile.setIfcAeoikakkekkakbn(aeoikbnBean.getIT_AeoiInfo().getAeoikekkakbn());

                khAeoiRekinenHkkDataFile.setIfcAeoikakhinsyuruikbn(aeoikbnBean.getIT_AeoiInfo().getAeoihoujinsyuruikbn());

                khAeoiRekinenHkkDataFile.setIfcAeoikakkrykstymd(aeoikbnBean.getIT_AeoiInfo().getAeoikouryokusttymd());

                khAeoiRekinenHkkDataFile.
                setIfcAeoikakkryksyryymd(aeoikbnBean.getIT_AeoiInfo().getAeoikouryokuendymd());

                khAeoiRekinenHkkDataFile.setIfcFilekbn("1");

                khAeoiRekinenHkkDataFile.setIfcSyono(aeoikbnBean.getIT_AeoiInfo().getSyono());

                khAeoiRekinenHkkDataFile.setIfcSyoumetucd(syoumetucd);

                khAeoiRekinenHkkDataFile.
                setIfcSyoumetuymd(ifcSyoumetuymd);

                khAeoiRekinenHkkDataFile.
                setIfcOkyksmno(Strings.padEnd("", 10, '0'));

                khAeoiRekinenHkkDataFile.setIfcHjncd(Strings.padEnd("", 9, '0'));

                khAeoiRekinenHkkDataFile.setIfcDntcd(Strings.padEnd("", 8, '0'));

                khAeoiRekinenHkkDataFile.
                setIfcKykknmeigi(ConvertUtil.fromZenKataKana(aeoikbnBean.getIT_KykSya().getKyknmkn(), 1));

                khAeoiRekinenHkkDataFile.setIfcKykkjmeigi(aeoikbnBean.getIT_KykSya().getKyknmkj());

                khAeoiRekinenHkkDataFile.
                setIfcKykseiymd(String.valueOf(aeoikbnBean.getIT_KykSya().getKykseiymd()));

                khAeoiRekinenHkkDataFile.setIfcHjndaiknmeigi(Strings.padEnd("", 30, ' '));

                khAeoiRekinenHkkDataFile.setIfcHjndaikjmeigi(Strings.padEnd("", 38, '　'));

                khAeoiRekinenHkkDataFile.setIfcHjndaiseiymd(Strings.padEnd("", 8, '0'));
                khAeoiRekinenHkkDataFile.setIfcTsinkihontikucd(zrntsinkihontikucd);

                khAeoiRekinenHkkDataFile.setIfcTsinkaiadr(aeoikbnBean.getIT_KykSya().getTsinadr1kj()
                    + aeoikbnBean.getIT_KykSya().getTsinadr2kj()
                    + aeoikbnBean.getIT_KykSya().getTsinadr3kj());

                khAeoiRekinenHkkDataFile.setIfcTsintelno(aeoikbnBean.getIT_KykSya().getTsintelno());

                khAeoiRekinenHkkDataFile.setIfcLastmeighnksyoriymd(ifcLastmeighnksyoriymd);

                khAeoiRekinenHkkDataFile.setIfcKykmeighnksyoriymd(ifcKykmeighnksyoriymd);

                khAeoiRekinenHkkDataFile.setIfcTysytkbn("01");

                khAeoiRekinenHkkDataFile.setIfcCashvaluegkkeigk(ifcCashvaluegkkeigk.toString());

                khAeoiRekinenHkkDataFile.setIfcKaiyakuhr(keisanWK.toString());

                khAeoiRekinenHkkDataFile.setIfcSznkyhkn("0");

                khAeoiRekinenHkkDataFile.setIfcHaitoukin(haitoukin.toString());

                khAeoiRekinenHkkDataFile.setIfcMikeikap(mikeikap.toString());

                khAeoiRekinenHkkDataFile.setIfcCvkeisanhukahyouji(cvkeisanhukahyouji);

                khAeoiRekinenHkkDataFile.setIfcKaiyakuhrerrkbn(kaiyakuhrerrkbnHyoujy);

                khAeoiRekinenHkkDataFile.setIfcSznkyhknerrkbn(" ");

                khAeoiRekinenHkkDataFile.setIfcHaitoukinerrkbn(haitoukinerrkbnHyoujy);

                khAeoiRekinenHkkDataFile.setIfcMikeikaperrkbn(mikeikaperrkbnHyoujy);

                khAeoiRekinenHkkDataFileList.add(khAeoiRekinenHkkDataFile);

                syorikensuu ++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_AEOIREKINENHKKDATA, khAeoiRekinenHkkDataFileList,false);

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syorikensuu)));

    }

    private void createKiykhnriknData(AeoiInfoBean
        aeoikbnBean, BizDate pCalckijyunymd, BizCurrency pYendthnkhr, int pSyouhnHanteikbn, BizNumber pKawaserate) {

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu());
        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        BizCurrency keisanYenHenkanMae = BizCurrency.valueOf(0, currencyType);
        BizCurrency yenAzukariganrikin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        Map<CurrencyType,BizCurrency> sumKrkgk = null;
        BizCurrency yenKrkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

        if ((pSyouhnHanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhnHanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            aeoikbnBean.getIT_KykSyouhn().getYendthnkymd() == null) {
            HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);
            HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);

            hanteiTmttknJyoutaiBean.setSyono(aeoikbnBean.getIT_AeoiInfo().getSyono());
            hanteiTmttknJyoutaiBean.setHanteiKijyunymd(pCalckijyunymd);
            hanteiTmttknJyoutaiBean.setKykymd(aeoikbnBean.getIT_KykSyouhn().getKykymd());
            boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);
            if (!result) {
                kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
                return;
            }

        }

        BizDateYM keisanWKijunYMWk = keisanWKijunYM.exec(aeoikbnBean.getIT_KykSyouhn().getKykymd(), pCalckijyunymd,
            aeoikbnBean.getIT_AnsyuKihon().getJkipjytym(),
            aeoikbnBean.getIT_KykKihon().getHrkkaisuu(),
            aeoikbnBean.getIT_KykSyouhn().getKykjyoutai(),
            aeoikbnBean.getIT_KykSyouhn().getSyouhncd(),
            aeoikbnBean.getIT_KykSyouhn().getYendthnkymd());

        C_ErrorKbn cErrorKbnResult = keisanWExt.exec(aeoikbnBean.getIT_AeoiInfo().getSyono(), pCalckijyunymd);
        if(C_ErrorKbn.ERROR.eq(cErrorKbnResult)) {
            kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
            return;
        }

        C_ErrorKbn kErrorKbnResult = keisanW.exec(pCalckijyunymd, keisanWKijunYMWk, keisanWExt.getKeisanWExtBean());

        if (C_ErrorKbn.OK.eq(kErrorKbnResult)) {
            keisanYenHenkanMae = keisanW.getW();
            KeisanAzukariGanrikin keisanAzukariGanrikin = SWAKInjector.getInstance(KeisanAzukariGanrikin.class);
            C_ErrorKbn errorKbn = keisanAzukariGanrikin.exec(aeoikbnBean.getIT_AeoiInfo().getSyono(),
                pCalckijyunymd, aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu());
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
                return;
            }
            keisanYenHenkanMae = keisanYenHenkanMae.add(keisanAzukariGanrikin.getAzukariGanrikinKyktuuka());
            yenAzukariganrikin = keisanAzukariGanrikin.getAzukariGanrikinYen();
            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(aeoikbnBean.getIT_AeoiInfo().getSyono());
            sumKrkgk = kykKihon.getKariukekinSumKrkgkByKrkseisanzumiflg(C_Krkseisanzumiflg.SUMI);
            if (sumKrkgk.size() != 0) {
                yenKrkgk = sumKrkgk.get(BizCurrencyTypes.YEN);
            }

            if (!(C_Tuukasyu.JPY.eq(aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu()))) {

                keisanWK = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    keisanYenHenkanMae,
                    pKawaserate,
                    C_HasuusyoriKbn.SUTE).add(yenAzukariganrikin).add(yenKrkgk);

            } else {
                keisanWK = keisanYenHenkanMae.add(pYendthnkhr).add(yenAzukariganrikin).add(yenKrkgk);
            }
        }else{
            kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private void createKykbimaeKiykhnriknData(AeoiInfoBean aeoikbnBean, BizDate pCalckijyunymd, int pSyouhnHanteikbn,
        BizNumber pKawaserate) {

        if ((pSyouhnHanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhnHanteikbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            aeoikbnBean.getIT_KykSyouhn().getYendthnkymd() == null) {
            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu());
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            BizCurrency keisanYenHenkanMae = BizCurrency.valueOf(0, currencyType);

            SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(
                aeoikbnBean.getIT_AeoiInfo().getSyono(), aeoikbnBean.getIT_KykSyouhn().getKykymd());

            keisanYenHenkanMae = sisurendoTmttknInfoBean.getTeirituTmttknGK().add(
                sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());

            keisanWK = keisanGaikakanzan.exec(
                C_Tuukasyu.JPY,
                keisanYenHenkanMae,
                pKawaserate,
                C_HasuusyoriKbn.SUTE);
        }
        else if (pSyouhnHanteikbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhnHanteikbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);
            C_ErrorKbn errorKbn = keisanKihrkP.exec(
                aeoikbnBean.getIT_AeoiInfo().getSyono(), aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu());
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                kaiyakuhrerrkbn = C_ErrorKbn.ERROR;
                return;
            }
            if (pSyouhnHanteikbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                keisanWK = keisanKihrkP.getYenKihrkP();
            }
            else {
                if ((C_Tuukasyu.JPY.eq(aeoikbnBean.getIT_KykSyouhn().getKyktuukasyu()))) {
                    keisanWK = keisanKihrkP.getYenKihrkP();
                }
                else {
                    BizCurrency keisanYenHenkanMae = keisanKihrkP.getKihrkP();
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                    keisanWK = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        keisanYenHenkanMae,
                        pKawaserate,
                        C_HasuusyoriKbn.SUTE);
                }
            }
        }
    }

    private void createHaitoukinData(AeoiInfoBean pAeoikbnBean, BizDate pCalckijyunymd) {
        CheckDShrKaiyaku checkDShrKaiyaku = SWAKInjector.getInstance(CheckDShrKaiyaku.class);
        C_YouhiKbn youhiKbn = null;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai())){

            youhiKbn = C_YouhiKbn.HUYOU;
        }
        else if (C_Kykjyoutai.HRKMTYUU.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai()) ||
            C_Kykjyoutai.ZENNOU.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai())) {

            youhiKbn = C_YouhiKbn.YOU;
        }

        C_ErrorKbn errorKbn = checkDShrKaiyaku.checkDShr(pAeoikbnBean.getIT_AeoiInfo().getSyono(), pCalckijyunymd,
            pAeoikbnBean.getIT_AnsyuKihon().getJkipjytym(), youhiKbn, pCalckijyunymd);
        if (C_ErrorKbn.ERROR.eq(errorKbn) ||
            C_SyorikahiKbn.SYORIHUKA.eq(checkDShrKaiyaku.getSyorikahiKbn())) {
            haitoukinerrkbn = C_ErrorKbn.ERROR;
            return;
        }
        KeisanDCommonKaiyaku keisanDCommonKaiyaku = SWAKInjector.getInstance(KeisanDCommonKaiyaku.class);
        errorKbn = keisanDCommonKaiyaku.calcDShrgk(pAeoikbnBean.getIT_AeoiInfo().getSyono(), pCalckijyunymd,
            pCalckijyunymd, pAeoikbnBean.getIT_AnsyuKihon().getJkipjytym());
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            haitoukinerrkbn = C_ErrorKbn.ERROR;
            return;
        }
        haitoukin = keisanDCommonKaiyaku.getDShrkn();
    }

    private void createMikeikapData(AeoiInfoBean pAeoikbnBean, BizDate pCalckijyunymd, int pSyouhnHanteikbn,
        BizNumber pKawaserate) {
        BizCurrency yenZennouseisangk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency yenMikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizDateYM jkipjytym = null;
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =  henkanTuuka.henkanTuukaKbnToType(
            pAeoikbnBean.getIT_KykSyouhn().getKyktuukasyu());
        BizCurrency zennouSeisanGkGaika = BizCurrency.valueOf(0, currencyType);
        BizCurrency mikeikapGaika = BizCurrency.valueOf(0, currencyType);
        BizCurrency mikeikapEnkansanzen = BizCurrency.valueOf(0, currencyType);
        if (C_Kykjyoutai.HRKMTYUU.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai()) ||
            C_Kykjyoutai.IKKATUNK.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai()) ||
            C_Kykjyoutai.ZENNOU.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai())) {
            if (C_Kykjyoutai.ZENNOU.eq(pAeoikbnBean.getIT_KykSyouhn().getKykjyoutai())) {

                SortIT_Zennou sortIT_Zennou = new SortIT_Zennou();

                IT_Zennou zennou = sortIT_Zennou.OrderIT_ZennouByPkDesc(pAeoikbnBean.getIT_AnsyuKihon().getZennous()).get(0);

                KeisanZennouSeisanGk2 KeisanZennouSeisanGk2 = SWAKInjector.getInstance(KeisanZennouSeisanGk2.class);

                C_ErrorKbn errorKbn = KeisanZennouSeisanGk2.exec(pCalckijyunymd, pAeoikbnBean.getIT_KykSyouhn().getKykymd(),
                    zennou.getZennoujihrkp(), zennou.getZennoukaisiymd(), zennou.getRyosyuymd(), zennou.getZennounyuukinkgk());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    mikeikaperrkbn = C_ErrorKbn.ERROR;
                    return;
                }

                if (pSyouhnHanteikbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                    yenZennouseisangk = KeisanZennouSeisanGk2.getZennouSeisanGk();
                }
                else {
                    if ((C_Tuukasyu.JPY.eq(pAeoikbnBean.getIT_KykSyouhn().getKyktuukasyu()))) {
                        yenZennouseisangk = KeisanZennouSeisanGk2.getZennouSeisanGk();
                    }
                    else {
                        zennouSeisanGkGaika = KeisanZennouSeisanGk2.getZennouSeisanGk();
                    }
                }
                jkipjytym = KeisanZennouSeisanGk2.getLastPJyuutouYm().addYears(1);
            }
            else {
                jkipjytym = pAeoikbnBean.getIT_AnsyuKihon().getJkipjytym();
            }

            KeisanMsyMkeiP keisanMsyMkeiP = SWAKInjector.getInstance(KeisanMsyMkeiP.class);
            keisanMsyMkeiP.exec(pAeoikbnBean.getIT_AeoiInfo().getSyono(), pCalckijyunymd, jkipjytym,
                pAeoikbnBean.getIT_KykSyouhn().getHokenryou(), C_MisyuptsKbn.MITS);
            if (pSyouhnHanteikbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                yenMikeikap = keisanMsyMkeiP.getMikeikaP();
            }
            else {
                if ((C_Tuukasyu.JPY.eq(pAeoikbnBean.getIT_KykSyouhn().getKyktuukasyu()))) {
                    yenMikeikap = keisanMsyMkeiP.getMikeikaP();
                }
                else {
                    mikeikapGaika = keisanMsyMkeiP.getMikeikaP();
                }
            }
            mikeikapEnkansanzen = zennouSeisanGkGaika.add(mikeikapGaika);
            if (BizCurrency.valueOf(0, mikeikapEnkansanzen.getType()).compareTo(mikeikapEnkansanzen) < 0) {
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                mikeikap = keisanGaikakanzan.exec(
                    C_Tuukasyu.JPY,
                    mikeikapEnkansanzen,
                    pKawaserate,
                    C_HasuusyoriKbn.SUTE);
            }
            else {
                mikeikap = yenZennouseisangk.add(yenMikeikap);
            }
        }
    }
}
