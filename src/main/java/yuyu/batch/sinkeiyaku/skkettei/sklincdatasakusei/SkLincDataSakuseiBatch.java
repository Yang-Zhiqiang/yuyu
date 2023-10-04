package yuyu.batch.sinkeiyaku.skkettei.sklincdatasakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.sinkeiyaku.skkettei.sklincdatasakusei.dba.SkLincDataSakuseiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetKiteiCheckYenkansangk;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_LincdatasousinKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SkLincSousinData;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 決定 新契約ＬＩＮＣデータ作成のバッチクラスです。
 */
public class SkLincDataSakuseiBatch implements Batch {

    private static final String TABLE_ID = "HT_SyoriCTL";

    private static final String FILTER_ID = "Sk001";

    public static final String HANKAKU_SPACE = " ";

    public static final Integer RECORD_INSERT = 0;

    public static final Integer RECORD_UPDATE = 1;

    public static final Integer RECORD_DELETE = 2;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkLincDataSakuseiDao skLincDataSakuseiDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private String hhknnmkn;

    private String kyknmkn;

    private String kyknmkj;

    private BizDate kykseiymd;

    private String hhknadrkn;

    private String kykadrkn;

    private Integer kyksei;

    private Integer hhknsei;

    private BizCurrency hutuusb;

    private BizCurrency sgsbksns;

    private BizCurrency sgnyung;

    private BizCurrency sipnyung;

    private BizCurrency sjnyung;

    private BizCurrency sonotanyuinng;

    private long syoriKns = 0;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));

        try (
            ExDBUpdatableResults<HT_SyoriCTL> syoriCTLLst =
            skLincDataSakuseiDao.getSyoriCTLsByKakutyoujobcd(kakutyouJobCd);

            EntityInserter<HT_SkLincSousinData> skLincSousinDataInsLst = new EntityInserter<>();) {

            for (HT_SyoriCTL syoriCTL : syoriCTLLst) {

                hhknnmkn = "";
                kyknmkn = "";
                kyknmkj = "";
                kykseiymd = null;
                hhknadrkn = "";
                kykadrkn = "";
                HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                hutuusb = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                sgsbksns = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                sgnyung = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                sipnyung = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                sjnyung = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                sonotanyuinng = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);
                GetKiteiCheckYenkansangk getKiteiCheckYenkansangk = SWAKInjector
                    .getInstance(GetKiteiCheckYenkansangk.class);

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoriCTL.getMosno());

                editPalRenkeiKoumoku.getSyuEntity(syoriCTL.getMosSyouhns());

                BM_SyouhnZokusei syouhnZokuseiSyu = editPalRenkeiKoumoku.getSyouhnZokusei();
                HT_MosSyouhn mosSyouhnSyu = editPalRenkeiKoumoku.getMosSyouhn();

                HT_SkLincTourokuInfo skLincTourokuInfo = syoriCTL.getSkLincTourokuInfo();

                if (C_UmuKbn.ARI.eq(syouhnZokuseiSyu.getHutuusbhsyumu())) {

                    if (C_Tuukasyu.JPY.eq(mosKihon.getKyktuukasyu())) {

                        hutuusb = mosSyouhnSyu.getSeitoukihons();
                    }
                    else {

                        hutuusb = getKiteiCheckYenkansangk.exec(mosKihon.getMosymd(),
                            mosSyouhnSyu.getSeitoukihons(), mosKihon.getKyktuukasyu());
                    }
                }

                Integer maxRenno = skLincDataSakuseiDao.getSkLincSousinDataMaxRennoByMosno(syoriCTL.getMosno());

                if (maxRenno == null) {

                    maxRenno = 1;
                }
                else {

                    maxRenno = maxRenno + 1;
                }

                hhknnmkn = ConvertUtil.toHanAll(mosKihon.getHhknnmkn(), 0, 1);

                hhknsei = convHhknsei(mosKihon.getHhknsei());

                if (C_TsindousiteiKbn.ARI.eq(mosKihon.getTsindousiteikbn())) {

                    hhknadrkn = adrknHan(mosKihon.getTsinyno());
                }
                else {

                    hhknadrkn = adrknHan(mosKihon.getHhknyno());
                }

                if (C_KykKbn.KEIHI_DOUITU.eq(mosKihon.getKykkbn())) {

                    kyknmkn = hhknnmkn;
                    kyknmkj = mosKihon.getHhknnmkj();
                    kykseiymd = mosKihon.getHhknseiymd();
                }
                else {

                    kyknmkn = ConvertUtil.toHanAll(mosKihon.getKyknmkn(), 0, 1);
                    kyknmkj = mosKihon.getKyknmkj();
                    kykseiymd = mosKihon.getKykseiymd();
                }

                kyksei = convKyksei(mosKihon.getKykkbn(), mosKihon.getHhknsei(), mosKihon.getKyksei());

                if (C_TsindousiteiKbn.ARI.eq(mosKihon.getTsindousiteikbn())) {

                    kykadrkn = hhknadrkn;
                }
                else {

                    kykadrkn = adrknHan(mosKihon.getTsinyno());
                }

                if (C_LincdatasousinKbn.TOUROKU.eq(syoriCTL.getLincdatasousinkbn())) {

                    editSkLincSousinDataTbl(RECORD_INSERT, syoriYmd, syoriCTL, mosKihon, maxRenno,
                        skLincSousinDataInsLst, skLincTourokuInfo);
                }
                else if (C_LincdatasousinKbn.SAITOUROKU.eq(syoriCTL.getLincdatasousinkbn())) {

                    editSkLincSousinDataTbl(RECORD_DELETE, syoriYmd, syoriCTL, mosKihon, maxRenno,
                        skLincSousinDataInsLst, skLincTourokuInfo);

                    editSkLincSousinDataTbl(RECORD_INSERT, syoriYmd, syoriCTL, mosKihon, maxRenno + 1,
                        skLincSousinDataInsLst, skLincTourokuInfo);
                }
                else if (C_LincdatasousinKbn.HENKOU.eq(syoriCTL.getLincdatasousinkbn())) {

                    editSkLincSousinDataTbl(RECORD_UPDATE, syoriYmd, syoriCTL, mosKihon, maxRenno,
                        skLincSousinDataInsLst, skLincTourokuInfo);
                }
                else if (C_LincdatasousinKbn.SAKUJO.eq(syoriCTL.getLincdatasousinkbn())) {

                    editSkLincSousinDataTbl(RECORD_DELETE, syoriYmd, syoriCTL, mosKihon, maxRenno,
                        skLincSousinDataInsLst, skLincTourokuInfo);
                }

                if (C_LincdatasousinKbn.TOUROKU.eq(syoriCTL.getLincdatasousinkbn())) {

                    HT_SkLincTourokuInfo skLincTourokuInfoInsert = syoriCTL.createSkLincTourokuInfo();

                    BizPropertyInitializer.initialize(skLincTourokuInfoInsert);

                    editSkLincTourokuInfoTbl(syoriYmd, mosKihon, skLincTourokuInfoInsert);
                }
                else if (C_LincdatasousinKbn.SAITOUROKU.eq(syoriCTL.getLincdatasousinkbn())) {

                    syoriCTL.getSkLincTourokuInfos().remove(skLincTourokuInfo);

                    sinkeiyakuDomManager.update(syoriCTL);

                    sinkeiyakuDomManager.flush();

                    HT_SkLincTourokuInfo skLincTourokuInfoInsert = syoriCTL.createSkLincTourokuInfo();

                    BizPropertyInitializer.initialize(skLincTourokuInfoInsert);

                    editSkLincTourokuInfoTbl(syoriYmd, mosKihon, skLincTourokuInfoInsert);
                }
                else if (C_LincdatasousinKbn.HENKOU.eq(syoriCTL.getLincdatasousinkbn())) {

                    editSkLincTourokuInfoTbl(syoriYmd, mosKihon, skLincTourokuInfo);
                }
                else if (C_LincdatasousinKbn.SAKUJO.eq(syoriCTL.getLincdatasousinkbn())) {

                    syoriCTL.getSkLincTourokuInfos().remove(skLincTourokuInfo);
                }

                if (C_LincdatasousinKbn.TOUROKU.eq(syoriCTL.getLincdatasousinkbn()) ||
                    C_LincdatasousinKbn.SAITOUROKU.eq(syoriCTL.getLincdatasousinkbn())) {

                    syoriCTL.setLincjkkbn(C_LincjkKbn.SYOUKAI);
                }
                syoriCTL.setLincdatasousinkbn(C_LincdatasousinKbn.MISETTEI);
                syoriCTL.setGyoumuKousinsyaId(bzBatchParam.getUserId());
                syoriCTL.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
                BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector
                    .getInstance(BzGetProcessSummaryInBean.class);
                BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

                bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                bzGetProcessSummaryInBean.setMosNo(syoriCTL.getMosno());

                List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
                    .exec(bzGetProcessSummaryInBean);

                bzOutputProcessRecord.exec(
                    bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId(),
                    ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
                    "",
                    "ＬＩＮＣデータ作成処理",
                    C_SyorikekkaKbn.KANRYOU);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKns), "新契約ＬＩＮＣデータ作成"));
    }

    private void editSkLincSousinDataTbl(Integer pRecord, BizDate pSyoriYmd, HT_SyoriCTL pSyoriCTL,
        HT_MosKihon pMosKihon, Integer pRenno, EntityInserter<HT_SkLincSousinData> pSkLincSousinDataInsLst,
        HT_SkLincTourokuInfo pSkLincTourokuInfo) {

        HT_SkLincSousinData skLincSousinData = new HT_SkLincSousinData();

        skLincSousinData.setMosno(pSyoriCTL.getMosno());
        skLincSousinData.setSyoriYmd(pSyoriYmd);
        skLincSousinData.setRenno(pRenno);
        skLincSousinData.setSyono(pSyoriCTL.getSyono());
        skLincSousinData.setLincsousinkbn(C_SousinKbn.SOUSINMATI);

        if (RECORD_INSERT == pRecord) {
            skLincSousinData.setLincrecordsyubetu(5);
            skLincSousinData.setLinchenkoutype(HANKAKU_SPACE);
            skLincSousinData.setLinckanyuusyano(0l);
        }
        else if (RECORD_UPDATE == pRecord) {
            skLincSousinData.setLincrecordsyubetu(21);
            skLincSousinData.setLinchenkoutype(YuyuBizConfig.getInstance().getLinchenkoutypekousin());
            skLincSousinData.setLinckanyuusyano(pSkLincTourokuInfo.getKanyuusyano());
        }
        else if (RECORD_DELETE == pRecord) {
            skLincSousinData.setLincrecordsyubetu(21);
            skLincSousinData.setLinchenkoutype(YuyuBizConfig.getInstance().getLinchenkoutypesakujyo());
            skLincSousinData.setLinckanyuusyano(pSkLincTourokuInfo.getKanyuusyano());
        }

        skLincSousinData.setLinchhknnmkn(editString(hhknnmkn, 32));
        skLincSousinData.setLinchhknnmkj(editString(pMosKihon.getHhknnmkj(), 30));
        skLincSousinData.setLinchhknsei(hhknsei);
        skLincSousinData.setLinchhknseiymd(pMosKihon.getHhknseiymd());
        skLincSousinData.setLinchhknadrkn(editString(hhknadrkn, 30));
        skLincSousinData.setLinckeihidjnhyouji(pMosKihon.getKykkbn());
        skLincSousinData.setLinckyknmkn(editString(kyknmkn, 42));
        skLincSousinData.setLinckyknmkj(editString(kyknmkj, 30));
        skLincSousinData.setLinckyksei(kyksei);
        skLincSousinData.setLinckykseiymd(kykseiymd);
        skLincSousinData.setLinckykadrkn(editString(kykadrkn, 30));
        skLincSousinData.setLinctrkmousideymd(pSyoriYmd);
        skLincSousinData.setLinckykytymd(pMosKihon.getKykymd());
        skLincSousinData.setLincsgnyukyhng(sgnyung);
        skLincSousinData.setLincsipnyukyhng(sipnyung);
        skLincSousinData.setLincsjnyukyhng(sjnyung);
        skLincSousinData.setLincsonotanyukyhng(sonotanyuinng);
        skLincSousinData.setLinchutuusbs(hutuusb);
        skLincSousinData.setLincsgsbksns(sgsbksns);
        skLincSousinData.setLinckakusyasiyouran(pSyoriCTL.getSyono() + pSyoriCTL.getMosno() +
            Strings.padEnd("", 18, ' ') + "SS");

        BizPropertyInitializer.initialize(skLincSousinData);

        pSkLincSousinDataInsLst.add(skLincSousinData);

        syoriKns = syoriKns + 1;
    }

    private void editSkLincTourokuInfoTbl(BizDate pSyoriYmd, HT_MosKihon pMosKihon,
        HT_SkLincTourokuInfo pSkLincTourokuInfo) {

        pSkLincTourokuInfo.setHhknnmkn(pMosKihon.getHhknnmkn());
        pSkLincTourokuInfo.setHhknnmkj(pMosKihon.getHhknnmkj());
        pSkLincTourokuInfo.setHhknsei(pMosKihon.getHhknsei());
        pSkLincTourokuInfo.setHhknseiymd(pMosKihon.getHhknseiymd());
        pSkLincTourokuInfo.setHhknadrlinckn30(editString(hhknadrkn, 30));
        pSkLincTourokuInfo.setKykkbn(pMosKihon.getKykkbn());
        pSkLincTourokuInfo.setKyknmkn(pMosKihon.getKyknmkn());
        pSkLincTourokuInfo.setKyknmkj(pMosKihon.getKyknmkj());
        pSkLincTourokuInfo.setKyksei(pMosKihon.getKyksei());
        pSkLincTourokuInfo.setKykseiymd(pMosKihon.getKykseiymd());
        pSkLincTourokuInfo.setKykadrlinckn30(editString(kykadrkn, 30));
        pSkLincTourokuInfo.setTrkmousideymd(pSyoriYmd);
        pSkLincTourokuInfo.setKykytymd(pMosKihon.getKykymd());
        pSkLincTourokuInfo.setSgnyung(sgnyung);
        pSkLincTourokuInfo.setSipnyung(sipnyung);
        pSkLincTourokuInfo.setSjnyung(sjnyung);
        pSkLincTourokuInfo.setSonotanyuinng(sonotanyuinng);
        pSkLincTourokuInfo.setHutuusb(hutuusb);
        pSkLincTourokuInfo.setSgsbksns(sgsbksns);
    }

    private Integer convHhknsei(C_Hhknsei pHhknsei) {

        if (C_Hhknsei.MALE.eq(pHhknsei)) {

            return 1;
        }
        else if (C_Hhknsei.FEMALE.eq(pHhknsei)) {

            return 2;
        }
        else {

            return 0;
        }
    }

    private Integer convKyksei(C_KykKbn pKykkbn, C_Hhknsei pHhknsei, C_Kyksei pKyksei) {

        if (C_KykKbn.KEIHI_DOUITU.eq(pKykkbn)) {

            if (C_Hhknsei.MALE.eq(pHhknsei)) {

                return 1;
            }
            else if (C_Hhknsei.FEMALE.eq(pHhknsei)) {

                return 2;
            }
            else {

                return 0;
            }
        }

        if (C_Kyksei.MALE.eq(pKyksei)) {

            return 1;
        }
        else if (C_Kyksei.FEMALE.eq(pKyksei)) {

            return 2;
        }
        else if (C_Kyksei.HJNKYK.eq(pKyksei)) {

            return 3;
        }
        else {

            return 0;
        }
    }

    private String adrknHan(String pPostalCd) {

        List<BM_Address> addressList = bizDomManager.getAddressesByPostalCd(pPostalCd);

        if (addressList == null || addressList.size() == 0) {

            return "";
        }

        String result = ConvertUtil.toHanAll(addressList.get(0).getKnadrkyoutotuusyounmari(), 0, 1);

        String newString = editString(result, addressList.get(0).getKnsikugunnmketasuu());

        return newString;
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

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}