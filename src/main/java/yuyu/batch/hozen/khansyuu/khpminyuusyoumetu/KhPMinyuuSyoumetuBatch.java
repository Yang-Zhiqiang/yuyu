package yuyu.batch.hozen.khansyuu.khpminyuusyoumetu;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.file.util.SeparateConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khpminyuusyoumetu.dba.KhPMinyuuSyoumetuDao;
import yuyu.batch.hozen.khansyuu.khpminyuusyoumetu.dba.PMinyuuSyoumetuTaisyouDataBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdate;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateBean;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiLinc;
import yuyu.common.hozen.khcommon.HanteiLincBean;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HasseijikziEditShrtyousyotbl;
import yuyu.common.hozen.khcommon.HasseijikziEditShrtyousyotblParam;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KhCheckBankMaster;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.MiKeikaPBean;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakusei;
import yuyu.common.hozen.khcommon.PALKykNaiyouSakuseiBean;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasseijikazeisyoriKbn;
import yuyu.def.classification.C_HasseijikngksyuruiKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_JidousoukinHukaRiyuuKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykMsnKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_SyoumetuTuuti;
import yuyu.def.hozen.bean.report.KhSyoumetuKykListBean;
import yuyu.def.hozen.bean.report.KhSyoumetuKykListDataSourceBean;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.file.csv.KhSoukiSyoumetuDataRecordLayoutFile;
import yuyu.def.hozen.file.csv.KhSoukiSyoumetuHeaderRecordLayoutFile;
import yuyu.def.hozen.file.csv.KhSoukiSyoumetuLayoutFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 契約保全 案内収納 Ｐ未入消滅処理
 */
public class KhPMinyuuSyoumetuBatch implements Batch {

    private static final String TABLEID = IT_KykKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    private static final C_Kaiyakujiyuu KAIYAKUJIYUU = C_Kaiyakujiyuu.TUUJYOU;

    private static final C_Tuukasyu SHRTUUKASYU = C_Tuukasyu.JPY;

    private static final C_InputShrhousiteiKbn INPUTSHRHOUSITEIKBN = C_InputShrhousiteiKbn.FBSOUKIN;

    private static final BizCurrency SHRTYOUSYOSKSITAISYOUHANTEIGK = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

    private static final String SAKUSEISOSIKICD = C_Tantositucd.HOZENSIHARAISV + "0000";

    private static final String DATEFILETITLE = "早期消滅";

    private static final char KONMA = ',';

    private static final String MIDASIMOJIRETU = "証券番号,親代理店コード,新契約募集時代理店コード,代理店保有契約代理店コード,契約日,消滅日,募集代理店名,支店名,契約者名,商品名,募集担当者氏名";

    public List<IReportDataSouceBean> iReportDataSouceBeanLst;

    public List<KhSoukiSyoumetuDataRecordLayoutFile> khSoukiSyoumetuDataRecordLayoutFileLst;

    public List<EditKhMisslstParam> editMisslstParamLst;

    public BizDate syoriYmd;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhPMinyuuSyoumetuDao khPMinyuuSyoumetuDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        syoriYmd = bzBatchParam.getSyoriYmd();
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        iReportDataSouceBeanLst = new ArrayList<>();
        khSoukiSyoumetuDataRecordLayoutFileLst = new ArrayList<>();
        editMisslstParamLst = new ArrayList<>();

        long syoriKensuu = 0;
        int jidousoukinKaKensuu = 0;
        int jidousoukinhukaKensuu = 0;
        int miLstSeqNo = 0;

        try (
            ExDBResults<PMinyuuSyoumetuTaisyouDataBean> pMinyuuSyoumetuTaisyouDataBeanLst =
            khPMinyuuSyoumetuDao.getPMinyuuSyoumetuTaisyouDataBean(kakutyoujobCd, syoriYmd.getBizDateYM());
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            for (PMinyuuSyoumetuTaisyouDataBean pMinyuuSyoumetuTaisyouDataBean : pMinyuuSyoumetuTaisyouDataBeanLst) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(pMinyuuSyoumetuTaisyouDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(pMinyuuSyoumetuTaisyouDataBean.getSyono());

                String syoNo = pMinyuuSyoumetuTaisyouDataBean.getSyono();
                BizDateYM jkipjytYm = pMinyuuSyoumetuTaisyouDataBean.getJkipjytym();
                C_HtsiryosyuKbn shrtysySyuruiKbn = C_HtsiryosyuKbn.BLNK;
                BizCurrency shrtienRsk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency jpyShrtienRsk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
                setYuuyokknmanryobi.exec(syoNo, jkipjytYm);
                BizDate syoumetuBi = setYuuyokknmanryobi.getSyoumetubi();
                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo);
                IT_Kouza kouza = kykKihon.getKouza();

                CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
                boolean checkResult = checkYuuyokkngai.exec(syoNo, syoriYmd);
                if (checkResult) {
                    continue;
                }

                syoriKensuu = syoriKensuu + 1;

                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam =
                    SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(syoNo);

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    miLstSeqNo = miLstSeqNo + 1;
                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
                    String pMisslistMsg = MessageUtil.getMessage(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
                    editKhMisslstParam.setDataNo((int)syoriKensuu);
                    editKhMisslstParam.setSeqNo(miLstSeqNo);
                    editKhMisslstParam.setMisslistMsg(pMisslistMsg);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(syoNo);
                    editMisslstParamLst.add(editKhMisslstParam);
                    continue;
                }

                HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, syoNo);
                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
                    miLstSeqNo = miLstSeqNo + 1;
                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
                    String pMisslistMsg = MessageUtil.getMessage(MessageId.EIA1006, hanteiTetuduki.getMessageParam());
                    editKhMisslstParam.setDataNo((int)syoriKensuu);
                    editKhMisslstParam.setSeqNo(miLstSeqNo);
                    editKhMisslstParam.setMisslistMsg(pMisslistMsg);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(syoNo);
                    editMisslstParamLst.add(editKhMisslstParam);
                    continue;
                }

                List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

                CheckKaiyakuBean checkKaiyakuBean = SWAKInjector.getInstance(CheckKaiyakuBean.class);
                checkKaiyakuBean.setSyoruiukeYmd(syoumetuBi);
                checkKaiyakuBean.setSyukykYmd(kykSyouhn.getKykymd());
                checkKaiyakuBean.setYendthnkYmd(kykSyouhn.getYendthnkymd());
                checkKaiyakuBean.setSyoriYmd(syoriYmd);
                checkKaiyakuBean.setKykKihon(kykKihon);
                checkKaiyakuBean.setAnsyuKihon(ansyuKihon);

                CheckKaiyaku checkKaiyaku = SWAKInjector.getInstance(CheckKaiyaku.class);
                C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec(CheckKaiyaku.KINOUBUNRUI_BATCH, "", checkKaiyakuBean);
                if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {
                    miLstSeqNo = miLstSeqNo + 1;
                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
                    String pMisslistMsg = checkKaiyaku.getErrorMessage();
                    editKhMisslstParam.setDataNo((int)syoriKensuu);
                    editKhMisslstParam.setSeqNo(miLstSeqNo);
                    editKhMisslstParam.setMisslistMsg(pMisslistMsg);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(syoNo);
                    editMisslstParamLst.add(editKhMisslstParam);
                    continue;
                }

                C_JidousoukinHukaRiyuuKbn jidousoukinHukaRiyuuKbn = checkJidousoukinKahi(
                    yuukoujyotaichkKbn,
                    syorikahiKbn,
                    kykKihon,
                    ansyuKihon,
                    kouza);
                C_KahiKbn jidousoukinKahiKbn;
                if (C_JidousoukinHukaRiyuuKbn.BLNK.eq(jidousoukinHukaRiyuuKbn)) {
                    jidousoukinKahiKbn = C_KahiKbn.KA;
                }
                else {
                    jidousoukinKahiKbn = C_KahiKbn.HUKA;
                }

                if (C_KahiKbn.KA.eq(jidousoukinKahiKbn)) {
                    jidousoukinKaKensuu = jidousoukinKaKensuu + 1;
                }
                else {
                    jidousoukinhukaKensuu = jidousoukinhukaKensuu + 1;
                }

                khozenCommonParam.setSikibetuKey(null);
                String sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);


                BizDate yenShrratetekiYmd = null;
                BizNumber yenShrratek = BizNumber.valueOf(0);
                BizDate gkShrkwsrateymd = null;
                BizNumber gkShrkwsrate = BizNumber.valueOf(0);
                C_ErrorKbn errorKbn = C_ErrorKbn.OK;

                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                    errorKbn = getKawaseRate.exec(
                        syoumetuBi,
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.SYUKKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException("為替レート取得が実行できませんでした。証券番号：" + syoNo);
                    }
                    yenShrratetekiYmd = getKawaseRate.getKwsrateKjYmd();
                    yenShrratek = getKawaseRate.getKawaserate();

                    errorKbn = getKawaseRate.exec(
                        syoumetuBi,
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.NYUKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException("為替レート取得が実行できませんでした。証券番号：" + syoNo);
                    }
                    gkShrkwsrateymd = getKawaseRate.getKwsrateKjYmd();
                    gkShrkwsrate = getKawaseRate.getKawaserate();
                }

                KeisanKaiyakuBean keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);
                keisanKaiyakuBean.setSyoruiukeymd(null);
                keisanKaiyakuBean.setKaiykymd(syoumetuBi);
                keisanKaiyakuBean.setYenshrkwsrate(yenShrratek);
                keisanKaiyakuBean.setGkshrkwsrate(gkShrkwsrate);

                KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);
                errorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
                    KeisanCommonKaiyaku.KINOUBUNRUI_BATCH,
                    kykKihon,
                    syoriYmd,
                    keisanKaiyakuBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(keisanCommonKaiyaku.getErrorMessage() + "証券番号：" + syoNo);
                }
                KeisanCommonKaiyakuOutBean keisanKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
                BizCurrency kaiyakuHr = keisanKaiyakuOutBean.getKaiyakuHr();
                BizCurrency kaiyakuHrYen = keisanKaiyakuOutBean.getKaiyakuHrYen();
                BizCurrency ptumitatekin = keisanKaiyakuOutBean.getPtumitatekin();
                BizCurrency sjkkkTyouseiGk = keisanKaiyakuOutBean.getSjkkkTyouseiGk();
                BizNumber sjkkkTyouseiRitu = keisanKaiyakuOutBean.getSjkkkTyouseiRitu();
                BizNumber kaiyakusjkkktyouseiriRitu = keisanKaiyakuOutBean.getKaiyakusjkkktyouseiriritu();
                BizCurrency teiriTutmttKngk = keisanKaiyakuOutBean.getTeiriTutmttKngk();
                BizCurrency sisuuRendouTmttKngkl = keisanKaiyakuOutBean.getSisuuRendouTmttKngkl();
                BizCurrency kaiyakuKjgk = keisanKaiyakuOutBean.getKaiyakuKjgk();
                BizNumber kaiyakuKjRitu = keisanKaiyakuOutBean.getKaiyakuKjRitu();
                BizCurrency sonotaseisan = keisanKaiyakuOutBean.getSonotaseisan();
                C_Segcd segcdOne = keisanKaiyakuOutBean.getSegcdOne();
                C_Segcd segcdTwo = keisanKaiyakuOutBean.getSegcdTwo();
                BizCurrency kaiyakuhrgoukeigk = keisanKaiyakuOutBean.getKaiyakuhrgoukeigk();
                BizCurrency kaiyakuhrgoukeiYen = keisanKaiyakuOutBean.getKaiyakuhrgoukeiYen();
                BizCurrency azukariGanrikingk = keisanKaiyakuOutBean.getAzukariGanrikingk();
                BizCurrency sonotashrgkgk = keisanKaiyakuOutBean.getSonotashrgkgk();
                BizCurrency sonotashrgkYen = keisanKaiyakuOutBean.getSonotashrgkYen();
                BizCurrency mikeikapYen = keisanKaiyakuOutBean.getMikeikapYen();
                BizCurrency mikeikapGk = keisanKaiyakuOutBean.getMikeikapGk();
                BizCurrency zennouseisankYen = keisanKaiyakuOutBean.getZennouseisankYen();
                BizCurrency zennouseisankGk = keisanKaiyakuOutBean.getZennouseisankGk();
                BizCurrency azukariGanrikinYen = keisanKaiyakuOutBean.getAzukariGanrikinYen();
                BizCurrency haitoukinYen = keisanKaiyakuOutBean.getHaitoukinYen();
                BizCurrency yentkbthaitoukin = keisanKaiyakuOutBean.getYentkbthaitoukin();
                BizCurrency krkgkYenKzShr = keisanKaiyakuOutBean.getKrkgkYen();
                BizDateYM mikeikaPjyutouYm = keisanKaiyakuOutBean.getMikeikaPjyutouYm();
                Integer mikeikaPJyutouKaisuuY = keisanKaiyakuOutBean.getMikeikaPJyutouKaisuuY();
                Integer mikeikaPJyutouKaisuuM = keisanKaiyakuOutBean.getMikeikaPJyutouKaisuuM();
                MiKeikaPBean[] miKeikaPBeans = keisanKaiyakuOutBean.getMiKeikaPBeans();
                BizCurrency gstszeigk = keisanKaiyakuOutBean.getGstszeigk();
                BizCurrency jpygstszeigk = keisanKaiyakuOutBean.getJpygstszeigk();
                BizCurrency jpyShrjiYengstszeigkKokuz = keisanKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz();
                BizCurrency jpyShrjiYengstszeigkTihouz = keisanKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz();
                C_UmuKbn gsbunritaisyouFlg = keisanKaiyakuOutBean.getGsbunritaisyouFlg();
                BizCurrency shrgkkeigk = keisanKaiyakuOutBean.getShrgkkeigk();
                BizCurrency krkgkYen;
                BizCurrency shrgkkeiYen;
                EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = keisanKaiyakuOutBean.getEditDshrTukiDKoumokuBean();
                if (C_KahiKbn.KA.eq(jidousoukinKahiKbn)) {
                    krkgkYen = keisanKaiyakuOutBean.getKrkgkYen();
                    shrgkkeiYen =  keisanKaiyakuOutBean.getShrgkkeiYen();
                }
                else {
                    krkgkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    shrgkkeiYen = kaiyakuhrgoukeiYen.add(azukariGanrikinYen).add(haitoukinYen).add(
                        yentkbthaitoukin).subtract(jpygstszeigk);
                }

                keisanCommonKaiyaku.keisanZeimuinfo(
                    KeisanCommonKaiyaku.KINOUBUNRUI_BATCH,
                    kykKihon,
                    syoriYmd,
                    SHRTUUKASYU,
                    KAIYAKUJIYUU,
                    keisanKaiyakuBean,
                    keisanKaiyakuOutBean);

                KeisanCommonKaiyakuOutBean zeimuinfoKeisanKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
                BizCurrency synykngk = zeimuinfoKeisanKaiyakuOutBean.getSynykngk();
                BizCurrency htykeihi = zeimuinfoKeisanKaiyakuOutBean.getHtykeihi();
                Integer kykhnkkaisuu = zeimuinfoKeisanKaiyakuOutBean.getKykhnkkaisuu();
                BizCurrency yenShrKykHtyKeihi = zeimuinfoKeisanKaiyakuOutBean.getYenShrKykHtyKeihi();
                BizCurrency yengststaisyousaeki = zeimuinfoKeisanKaiyakuOutBean.getYengststaisyousaeki();
                BizDate zeimuRatekijyunYmd = zeimuinfoKeisanKaiyakuOutBean.getZeimuRatesyutokuYmd();
                BizNumber zeimukwsrate = zeimuinfoKeisanKaiyakuOutBean.getZeimukwsrate();

                if (C_UmuKbn.NONE.eq(gsbunritaisyouFlg)) {
                    if (kaiyakuHrYen.compareTo(SHRTYOUSYOSKSITAISYOUHANTEIGK) > 0 &&
                        (kykhnkkaisuu > 0 ||
                            (kykhnkkaisuu == 0 && synykngk.compareTo(htykeihi) > 0))) {
                        shrtysySyuruiKbn = C_HtsiryosyuKbn.ITJKNSHRTYOUSYO;
                    }
                }

                BizDate shrYmd = null;
                C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;
                if (C_KahiKbn.KA.eq(jidousoukinKahiKbn)) {
                    KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);
                    shrYmd = keisanSiharaibi.exec(syoriYmd,
                        INPUTSHRHOUSITEIKBN, SHRTUUKASYU, kouza.getBankcd());
                    shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();
                }

                TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
                tableMaintenanceUtil.backUp(syoNo, sikibetuKey);
                EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
                IT_KhTyousyo khTyousyo = null;
                if (C_KahiKbn.KA.eq(jidousoukinKahiKbn)) {
                    EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = new EditKaiyakuTblUpdateBean();
                    editKaiyakuTblUpdateBean.setSyono(syoNo);
                    editKaiyakuTblUpdateBean.setSyoruiukeymd(null);
                    editKaiyakuTblUpdateBean.setKaiykymd(syoumetuBi);
                    editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.ARI);
                    editKaiyakuTblUpdateBean.setInputshrhousiteikbn(INPUTSHRHOUSITEIKBN);
                    editKaiyakuTblUpdateBean.setKaiyakujiyuu(KAIYAKUJIYUU);
                    editKaiyakuTblUpdateBean.setKaiyakuhrgoukei(kaiyakuhrgoukeigk);
                    editKaiyakuTblUpdateBean.setKaiyakuhrgoukeiyen(kaiyakuhrgoukeiYen);
                    editKaiyakuTblUpdateBean.setKaiyakuhr(kaiyakuHr);
                    editKaiyakuTblUpdateBean.setKaiyakuhryen(kaiyakuHrYen);
                    editKaiyakuTblUpdateBean.setYenshrrate(yenShrratek);
                    editKaiyakuTblUpdateBean.setYenshrratetekiymd(yenShrratetekiYmd);
                    editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(ptumitatekin);
                    editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(sjkkkTyouseiGk);
                    editKaiyakuTblUpdateBean.setKaiyakukjgk(kaiyakuKjgk);
                    editKaiyakuTblUpdateBean.setSjkkktyouseiritu(sjkkkTyouseiRitu);
                    editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(kaiyakusjkkktyouseiriRitu);
                    editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(kaiyakuKjRitu);
                    editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(azukariGanrikingk);
                    editKaiyakuTblUpdateBean.setShrtienrsk(shrtienRsk);
                    editKaiyakuTblUpdateBean.setShrtienrskkisanymd(null);
                    editKaiyakuTblUpdateBean.setTienrsknissuu(0);
                    editKaiyakuTblUpdateBean.setJpyshrtienrsk(jpyShrtienRsk);
                    editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(null);
                    editKaiyakuTblUpdateBean.setJpytienrsknissuu(0);
                    editKaiyakuTblUpdateBean.setGksonotashrgk(sonotashrgkgk);
                    editKaiyakuTblUpdateBean.setJpysonotashrgk(sonotashrgkYen);
                    editKaiyakuTblUpdateBean.setGkshrrate(gkShrkwsrate);
                    editKaiyakuTblUpdateBean.setGkshrratetekiymd(gkShrkwsrateymd);
                    editKaiyakuTblUpdateBean.setJpymikeikap(mikeikapYen);
                    if(kykSyouhn.getKyktuukasyu().eq(C_Tuukasyu.JPY)){
                        editKaiyakuTblUpdateBean.setMikeikap(mikeikapYen);
                    }
                    else{
                        editKaiyakuTblUpdateBean.setMikeikap(mikeikapGk);
                    }
                    editKaiyakuTblUpdateBean.setMikeikapjyutouym(mikeikaPjyutouYm);
                    editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(mikeikaPJyutouKaisuuY);
                    editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(mikeikaPJyutouKaisuuM);
                    editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(miKeikaPBeans);
                    editKaiyakuTblUpdateBean.setJpyzennouseisankgk(zennouseisankYen);
                    if(kykSyouhn.getKyktuukasyu().eq(C_Tuukasyu.JPY)){
                        editKaiyakuTblUpdateBean.setZennouseisankgk(zennouseisankYen);
                    }
                    else{
                        editKaiyakuTblUpdateBean.setZennouseisankgk(zennouseisankGk);
                    }
                    editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(azukariGanrikinYen);
                    editKaiyakuTblUpdateBean.setJpykariukekin(krkgkYen);
                    editKaiyakuTblUpdateBean.setJpyhaitoukin(haitoukinYen);
                    editKaiyakuTblUpdateBean.setJpytkbthaitoukin(yentkbthaitoukin);
                    editKaiyakuTblUpdateBean.setYendthnkhr(sonotaseisan);
                    editKaiyakuTblUpdateBean.setGstszeigk(gstszeigk);
                    editKaiyakuTblUpdateBean.setJpygstszeigk(jpygstszeigk);
                    editKaiyakuTblUpdateBean.setYengstszeigknationaltax(jpyShrjiYengstszeigkKokuz);
                    editKaiyakuTblUpdateBean.setYengstszeigklocaltax(jpyShrjiYengstszeigkTihouz);
                    editKaiyakuTblUpdateBean.setGsbunritaisyouflg(gsbunritaisyouFlg);
                    editKaiyakuTblUpdateBean.setYengststaisyousaeki(yengststaisyousaeki);
                    editKaiyakuTblUpdateBean.setTeiritutmttkngk(teiriTutmttKngk);
                    editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(sisuuRendouTmttKngkl);
                    editKaiyakuTblUpdateBean.setShrgkkei(shrgkkeigk);
                    editKaiyakuTblUpdateBean.setJpyshrgkgoukei(shrgkkeiYen);
                    editKaiyakuTblUpdateBean.setZeimukwsrate(zeimukwsrate);
                    editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(zeimuRatekijyunYmd);
                    editKaiyakuTblUpdateBean.setSynykngk(synykngk);
                    editKaiyakuTblUpdateBean.setHtykeihi(htykeihi);
                    editKaiyakuTblUpdateBean.setKykhnkkaisuu(kykhnkkaisuu);
                    editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(yenShrKykHtyKeihi);
                    editKaiyakuTblUpdateBean.setShrymd(shrYmd);
                    editKaiyakuTblUpdateBean.setShrtuukasyu(SHRTUUKASYU);
                    editKaiyakuTblUpdateBean.setShrhousiteikbn(shrhousiteiKbn);
                    editKaiyakuTblUpdateBean.setBankcd(kouza.getBankcd());
                    editKaiyakuTblUpdateBean.setSitencd(kouza.getSitencd());
                    editKaiyakuTblUpdateBean.setYokinkbn(kouza.getYokinkbn());
                    editKaiyakuTblUpdateBean.setKouzano(kouza.getKouzano());
                    editKaiyakuTblUpdateBean.setKzmeiginmkn(kouza.getKzmeiginmkn());
                    editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
                    editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.valueOf(kouza.getKzkykdoukbn().getValue()));
                    editKaiyakuTblUpdateBean.setShrtysysyuruikbn(shrtysySyuruiKbn);
                    editKaiyakuTblUpdateBean.setSeg1cd(segcdOne);
                    editKaiyakuTblUpdateBean.setSeg2cd(segcdTwo);
                    editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
                    editKaiyakuTblUpdateBean.setEditDshrTukiDKoumokuBean(editDshrTukiDKoumokuBean);
                    editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
                        tableMaintenanceUtil.getBakKykKihon());
                }
                else {
                    HasseijikziInfoSksParam hasseijikziInfoSksParam =  SWAKInjector.getInstance(HasseijikziInfoSksParam.class);
                    hasseijikziInfoSksParam.setShrtysysyuruiKbn(shrtysySyuruiKbn);
                    hasseijikziInfoSksParam.setShrgkkeiYen(shrgkkeiYen);
                    hasseijikziInfoSksParam.setKaiyakuHrYen(kaiyakuHrYen);
                    hasseijikziInfoSksParam.setHaitoukinYen(haitoukinYen);
                    hasseijikziInfoSksParam.setYentkbthaitoukin(yentkbthaitoukin);
                    hasseijikziInfoSksParam.setMihrkmp(krkgkYenKzShr);
                    hasseijikziInfoSksParam.setShrkwsratekjnymd(yenShrratetekiYmd);
                    hasseijikziInfoSksParam.setShrkwsrate(yenShrratek);
                    hasseijikziInfoSksParam.setSynykngk(synykngk);
                    hasseijikziInfoSksParam.setHtykeihi(htykeihi);
                    hasseijikziInfoSksParam.setYenShrkykhtykeihi(yenShrKykHtyKeihi);
                    hasseijikziInfoSksParam.setKykhnkKaisuu(kykhnkkaisuu);
                    hasseijikziInfoSksParam.setGsbunritaisyouFlg(gsbunritaisyouFlg);

                    UpdateDbInfoJidousoukinfukaKekkaBean updateDbInfoJidousoukinfukaKekkaBean =
                        updateDbInfoJidousoukinfuka(khozenCommonParam, kykKihon, ansyuKihon, syoumetuBi, sikibetuKey, hasseijikziInfoSksParam);
                    khTyousyo = updateDbInfoJidousoukinfukaKekkaBean.getKhTyousyo();
                }
                IT_PMinyuuSyoumetuInfo pMinyuuSyoumetuInfo = kykKihon.createPMinyuuSyoumetuInfo();
                pMinyuuSyoumetuInfo.setHenkousikibetukey(sikibetuKey);
                pMinyuuSyoumetuInfo.setSyoriYmd(syoriYmd);
                pMinyuuSyoumetuInfo.setSyoriym(syoriYmd.getBizDateYM());
                pMinyuuSyoumetuInfo.setSyoumetuymd(syoumetuBi);
                if (C_KahiKbn.HUKA.eq(jidousoukinKahiKbn)) {
                    pMinyuuSyoumetuInfo.setJidousoukinhukariyuu(jidousoukinHukaRiyuuKbn);
                    pMinyuuSyoumetuInfo.setTtdktyuuihanteikekka(syorikahiKbn);
                    pMinyuuSyoumetuInfo.setStknsetkbn(kykKihon.getStknsetkbn());
                }
                pMinyuuSyoumetuInfo.setShrgkkei(shrgkkeiYen);
                pMinyuuSyoumetuInfo.setShrtuukasyu(SHRTUUKASYU);
                pMinyuuSyoumetuInfo.setShrkwsrate(yenShrratek);
                pMinyuuSyoumetuInfo.setShrtuukakaiyakuhrkngkkei(kaiyakuhrgoukeiYen);
                pMinyuuSyoumetuInfo.setKaiyakuhrkngkkeisiteituuka(kaiyakuhrgoukeigk);
                pMinyuuSyoumetuInfo.setSonotaseisan(azukariGanrikinYen.add(krkgkYen));
                pMinyuuSyoumetuInfo.setYenkansanhaitoukin(haitoukinYen);
                pMinyuuSyoumetuInfo.setYensonotahaitoukin(yentkbthaitoukin);
                pMinyuuSyoumetuInfo.setShrtuukagstszeigk(jpygstszeigk);
                pMinyuuSyoumetuInfo.setZitkazukarikingksiteituuka(azukariGanrikingk);
                pMinyuuSyoumetuInfo.setZitkazukarikingkyen(azukariGanrikinYen);
                pMinyuuSyoumetuInfo.setKaiyakuhrknsiteituuka(kaiyakuHr);
                pMinyuuSyoumetuInfo.setKaiyakuhryen(kaiyakuHrYen);
                pMinyuuSyoumetuInfo.setYenkrkgk(krkgkYen);
                pMinyuuSyoumetuInfo.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                pMinyuuSyoumetuInfo.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                pMinyuuSyoumetuInfo.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                BizPropertyInitializer.initialize(pMinyuuSyoumetuInfo);

                PALKykNaiyouSakuseiBean pALKykNaiyouSakuseiBean = SWAKInjector.getInstance(PALKykNaiyouSakuseiBean.class);
                pALKykNaiyouSakuseiBean.setKykKihon(kykKihon);

                PALKykNaiyouSakusei pALKykNaiyouSakusei = SWAKInjector.getInstance(PALKykNaiyouSakusei.class);
                errorKbn = pALKykNaiyouSakusei.exec(pALKykNaiyouSakuseiBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException("当日異動内容契約保全テーブルの作成に失敗しました。");
                }

                if (C_KahiKbn.HUKA.eq(jidousoukinKahiKbn)) {
                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(kykSyouhn.getKyktuukasyu());

                    EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.getInstance(EditDairitenTesuuryouTbl.class);
                    editDairitenTesuuryouTbl.exec(khozenCommonParam,
                        syoNo,
                        C_TsrysyoriKbn.SIKKOU,
                        null,
                        0,
                        0,
                        BizCurrency.valueOf(0, BizCurrencyTypes.YEN),
                        BizCurrency.valueOf(0, currencyType),
                        tableMaintenanceUtil.getBakKykKihon());
                }

                C_SyoriKbn syoriKbn = C_SyoriKbn.JIDOUSOUKINSEISANZUMI;
                if (C_KahiKbn.HUKA.eq(jidousoukinKahiKbn)) {
                    syoriKbn = C_SyoriKbn.MISEISAN;
                }

                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(syoNo);
                editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
                editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
                editTtdkRirekiTblParam.setSysTime(BizDate.getSysDateTimeMilli());
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

                EditTtdkRirekiTbl  editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(EditHokenKykIdouRirekiTblBean.class);
                editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
                editHokenKykIdouRirekiTblBean.setSyoNo(syoNo);
                editHokenKykIdouRirekiTblBean.setSyoriYmd(syoriYmd);
                editHokenKykIdouRirekiTblBean.setSysDateTime(BizDate.getSysDateTimeMilli());
                EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(EditHokenKykIdouRirekiTbl.class);
                editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

                if (C_KahiKbn.HUKA.eq(jidousoukinKahiKbn)) {
                    IT_KhLincKihon khLincKihon = kykKihon.getKhLincKihon();
                    long lincKanyuusyaNo = 0;
                    if (khLincKihon != null) {
                        lincKanyuusyaNo = khLincKihon.getLinckanyuusyano();
                    }

                    HanteiLincBean hanteiLincBean = SWAKInjector.getInstance(HanteiLincBean.class);
                    hanteiLincBean.setSyoriYmd(syoriYmd);
                    hanteiLincBean.setBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                    hanteiLincBean.setKykKihon(kykKihon);
                    hanteiLincBean.setKanyuusyaNo(lincKanyuusyaNo);
                    HanteiLinc hanteiLinc = SWAKInjector.getInstance(HanteiLinc.class);
                    C_ErrorKbn hanteiLincErrorKbn = hanteiLinc.exec(hanteiLincBean, khozenCommonParam);

                    if(C_ErrorKbn.ERROR.eq(hanteiLincErrorKbn)){
                        throw new CommonBizAppException("ＬＩＮＣ該当判定処理に失敗しました。");
                    }
                }

                C_HassouKbn hassouKbn = setHassouKbn(kykKihon, yuukoujyotaichkKbn, syorikahiKbn, jidousoukinKahiKbn);
                SyoumetuTuutiSksParam syoumetuTuutiSksParam = SWAKInjector.getInstance(SyoumetuTuutiSksParam.class);
                syoumetuTuutiSksParam.setHenkouSikibetukey(sikibetuKey);
                syoumetuTuutiSksParam.setHassouKbn(hassouKbn);
                syoumetuTuutiSksParam.setSyoumetuYmd(syoumetuBi);
                if (C_KahiKbn.KA.eq(jidousoukinKahiKbn)) {
                    syoumetuTuutiSksParam.setShrYmd(shrYmd);
                }
                syoumetuTuutiSksParam.setKykYmd(kykSyouhn.getKykymd());
                syoumetuTuutiSksParam.setYenShrrate(yenShrratek);
                syoumetuTuutiSksParam.setShrtuukaKaiyakuhrkngkkei(kaiyakuhrgoukeiYen);
                syoumetuTuutiSksParam.setKaiyakuHrkngkkeiSiteituuka(kaiyakuhrgoukeigk);
                syoumetuTuutiSksParam.setSonotaSeisan(azukariGanrikinYen.add(krkgkYen));
                syoumetuTuutiSksParam.setYenkansanhaitoukin(haitoukinYen);
                syoumetuTuutiSksParam.setYenSonotaHaitoukin(yentkbthaitoukin);
                syoumetuTuutiSksParam.setShrtuukaGstszeigk(jpygstszeigk);
                syoumetuTuutiSksParam.setZitkazukarikingkSiteituuka(azukariGanrikingk);
                syoumetuTuutiSksParam.setShrgkkei(shrgkkeiYen);
                syoumetuTuutiSksParam.setSynykngk(synykngk);
                syoumetuTuutiSksParam.setHtykeihi(htykeihi);
                syoumetuTuutiSksParam.setYenShrkykhtykeihi(yenShrKykHtyKeihi);
                syoumetuTuutiSksParam.setKykhnkKaisuu(kykhnkkaisuu);
                syoumetuTuutiSksParam.setShrtysysyuruiKbn(shrtysySyuruiKbn);

                IT_SyoumetuTuuti syoumetuTuuti = createSyoumetuTuuti(khozenCommonParam,
                    kykKihon, kouza, jidousoukinKahiKbn, syoumetuTuutiSksParam);

                if (C_KahiKbn.HUKA.eq(jidousoukinKahiKbn)) {
                    KhSyoumetuKykListDataSourceBean khSyoumetuKykListDataSourceBean = createSyoumetuKykList(kykKihon,
                        syoumetuBi, kykSyouhn.getKykymd(), jidousoukinHukaRiyuuKbn, syorikahiKbn, shrgkkeiYen);
                    iReportDataSouceBeanLst.add(khSyoumetuKykListDataSourceBean);
                }

                boolean result = checkSoukiSyoumetuCsvSakusei(kykKihon,
                    ansyuKihon.getJkipjytym(), kykSyouhn.getKykymd());
                if (result) {
                    KhSoukiSyoumetuDataRecordLayoutFile khSoukiSyoumetuDataRecordLayoutFile =
                        createSoukiSyoumetuData(kykKihon, kykSyouhn, syoumetuBi);
                    khSoukiSyoumetuDataRecordLayoutFileLst.add(khSoukiSyoumetuDataRecordLayoutFile);
                }

                multipleEntityUpdater.add(kykKihon);

                if (C_KahiKbn.KA.eq(jidousoukinKahiKbn)) {
                    List<IT_KhDenpyoData> khDenpyoDataLst = editKaiyakuTblUpdate.getKhDenpyoDatas();
                    for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
                        multipleEntityInserter.add(khDenpyoData);
                    }

                    IT_KhFBSoukinData khFBSoukinData = editKaiyakuTblUpdate.getKhFBSoukinData();
                    if (khFBSoukinData != null) {
                        multipleEntityInserter.add(khFBSoukinData);
                    }

                    IT_KhDshrTuki khDshrTuki = editKaiyakuTblUpdate.getKhDshrTuki();
                    if (khDshrTuki != null) {
                        multipleEntityInserter.add(khDshrTuki);
                    }

                    BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector.getInstance(BzSikinIdouRirekiTblSakusei.class);
                    BT_SikinIdouRireki sikinIdouRireki = editKaiyakuTblUpdate.getSikinIdouRireki();
                    bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRireki);
                }

                multipleEntityInserter.add(syoumetuTuuti);
                if (khTyousyo != null) {
                    multipleEntityInserter.add(khTyousyo);
                }
                BT_TjtIdouNyKh tjtIdouNyKh = pALKykNaiyouSakusei.getTjtIdouNyKh();
                if (tjtIdouNyKh != null) {
                    multipleEntityInserter.add(tjtIdouNyKh);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (iReportDataSouceBeanLst.size() > 0) {
                outputSyoumetuKeiyakuLst();
            }

            outputSoukiSyoumetuFile();

            if (editMisslstParamLst.size() > 0) {
                EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);
                ReportServicesBean reportServicesBean = editKhMisslstTbl.editBean(C_SyoruiCdKbn.AS_PMINYUUSYOUMETU_MISSLIST,
                    SWAKInjector.getInstance(KhozenCommonParam.class),
                    editMisslstParamLst,
                    syoriYmd);

                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
                createReport.execNoCommit(reportServicesBean);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(syoriKensuu)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IAC1001, "消滅通知（自動送金可）", String.valueOf(jidousoukinKaKensuu)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IAC1001, "消滅通知（自動送金不可）", String.valueOf(jidousoukinhukaKensuu)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IAC1001, "消滅契約リスト", String.valueOf(iReportDataSouceBeanLst.size())));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IAC1001, "早期消滅ＣＳＶ", String.valueOf(khSoukiSyoumetuDataRecordLayoutFileLst.size())));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IAC1001, "ミスリスト", String.valueOf(editMisslstParamLst.size())));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private C_JidousoukinHukaRiyuuKbn checkJidousoukinKahi(C_YuukoujyotaichkKbn pYuukoujyotaichkKbn, C_SyorikahiKbn pSyorikahiKbn,
        IT_KykKihon pKykKihon, IT_AnsyuKihon pAnsyuKihon, IT_Kouza pKouza) {

        C_JidousoukinHukaRiyuuKbn jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.BLNK;

        if (!C_Hrkkeiro.KOUHURI.eq(pKykKihon.getHrkkeiro())) {
            jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.KZHURIATKIIGAI;
            return jidousoukinHukaRiyuuKbn;
        }

        if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(pYuukoujyotaichkKbn)) {
            jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.YUUKOUJTCHKERR_HKTTDKARI;
            return jidousoukinHukaRiyuuKbn;
        }

        if (C_SyorikahiKbn.TYUUITRATKIKA.eq(pSyorikahiKbn)) {
            jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.TTDKTYUUISETKYK;
            return jidousoukinHukaRiyuuKbn;
        }

        if (C_StknsetKbn.ARI.eq(pKykKihon.getStknsetkbn())) {
            jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.STKNSETKYK;
            return jidousoukinHukaRiyuuKbn;
        }

        IT_DattaiUktk dattaiUktk = pAnsyuKihon.getDattaiUktk();

        if (pKouza == null) {
            jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.HRKMKZINFOMUKOU_KZINFOMTRK;
            return jidousoukinHukaRiyuuKbn;
        }

        if (dattaiUktk != null) {
            jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.HRKMKZINFOMUKOU_DATTAITYUUKYK;
            return jidousoukinHukaRiyuuKbn;
        }

        KhCheckBankMaster khCheckBankMaster = SWAKInjector.getInstance(KhCheckBankMaster.class);
        int errNaiyou = khCheckBankMaster.checkBankMaster(SHRTUUKASYU, pKouza.getBankcd(), pKouza.getSitencd());
        if (errNaiyou != KhCheckBankMaster.SYORI_OK) {
            if (errNaiyou == KhCheckBankMaster.BANK_SONZAI_ERR) {
                jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.HRKMKZINFOMUKOU_BANKHUZAI;
            }
            else if (errNaiyou == KhCheckBankMaster.BANK_YUUKOU_HANTEI_ERR) {
                jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.HRKMKZINFOMUKOU_BANKMUKOU;
            }
            else if (errNaiyou == KhCheckBankMaster.BANK_YTGINKOU_SOUKIN_ERR) {
                jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.HRKMKZINFOMUKOU_YENSHRHUKA;
            }

            return jidousoukinHukaRiyuuKbn;
        }

        IT_KykSya kykSya = pKykKihon.getKykSya();
        if (!pKouza.getKzmeiginmkn().equals(kykSya.getKyknmkn())) {
            jidousoukinHukaRiyuuKbn = C_JidousoukinHukaRiyuuKbn.KZMGNNKYKSYAIGAI;
            return jidousoukinHukaRiyuuKbn;
        }

        return jidousoukinHukaRiyuuKbn;
    }

    private UpdateDbInfoJidousoukinfukaKekkaBean updateDbInfoJidousoukinfuka (KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon, IT_AnsyuKihon pAnsyuKihon, BizDate pSyoumetuymd, String pSikibetuKey,
        HasseijikziInfoSksParam pHasjKzInfoSksParam) {
        pKykKihon.setSyhenkouymd(syoriYmd);
        pKykKihon.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        pKykKihon.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        pKykKihon.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        pKhozenCommonParam.setBatchKeiyakuKihon(pKykKihon);
        pKhozenCommonParam.setBatchAnsyuKihon(pAnsyuKihon);
        EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
        editKykSyhnRirekiTbl.exec(pKhozenCommonParam, pKykKihon.getSyono());
        List<IT_KykSyouhn> kykSyouhnLst =  pKykKihon.getKykSyouhns();
        for (IT_KykSyouhn kykSyouhn : kykSyouhnLst) {
            kykSyouhn.setHenkousikibetukey(pSikibetuKey);
            kykSyouhn.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
            kykSyouhn.setSyoumetujiyuu(C_Syoumetujiyuu.PMNYSYMET_MSSN);
            kykSyouhn.setSyoumetuymd(pSyoumetuymd);
            kykSyouhn.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            kykSyouhn.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            kykSyouhn.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        }
        List<IT_SyouhnTokujou> syouhnTokujouLst = pKykKihon.getSyouhnTokujous();
        for (IT_SyouhnTokujou syouhnTokujou : syouhnTokujouLst) {
            syouhnTokujou.setHenkousikibetukey(pSikibetuKey);
            syouhnTokujou.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
            syouhnTokujou.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            syouhnTokujou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        }

        IT_KykSya kykSya = pKykKihon.getKykSya();

        IT_KhTtdkRireki khTtdkRireki = pKykKihon.createKhTtdkRireki();
        khTtdkRireki.setHenkousikibetukey(pSikibetuKey);

        IT_KhHasseijiKazeiRireki khHasseijiKazeiRireki = khTtdkRireki.createKhHasseijiKazeiRireki();
        khHasseijiKazeiRireki.setSyoriYmd(syoriYmd);
        khHasseijiKazeiRireki.setHasseijikazeisyorikbn(C_HasseijikazeisyoriKbn.PMINYUUSYOUMETU);
        khHasseijiKazeiRireki.setTorikesiflg(C_UmuKbn.NONE);
        khHasseijiKazeiRireki.setKouryokuhasseiymd(pSyoumetuymd);
        if (C_HtsiryosyuKbn.BLNK.eq(pHasjKzInfoSksParam.getShrtysysyuruiKbn())) {
            khHasseijiKazeiRireki.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
        }
        else if (pHasjKzInfoSksParam.getKykhnkKaisuu() > 0){
            khHasseijiKazeiRireki.setZeitratkikbn(C_ZeitratkiKbn.ZOUYO);
        }
        else {
            khHasseijiKazeiRireki.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
        }
        khHasseijiKazeiRireki.setGsbunritaisyou(pHasjKzInfoSksParam.getGsbunritaisyouFlg());
        khHasseijiKazeiRireki.setHasseijikngksyuruikbn(C_HasseijikngksyuruiKbn.KAIYAKUHR);
        khHasseijiKazeiRireki.setHasseijikngk(pHasjKzInfoSksParam.getShrgkkeiYen());
        khHasseijiKazeiRireki.setHasseijigstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khHasseijiKazeiRireki.setYenkansangkgoukei(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khHasseijiKazeiRireki.setYenkansansyukngkgoukei(pHasjKzInfoSksParam.getKaiyakuHrYen());
        khHasseijiKazeiRireki.setYengstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khHasseijiKazeiRireki.setYengstszeigknationaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khHasseijiKazeiRireki.setYengstszeigklocaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khHasseijiKazeiRireki.setHtykeihi(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khHasseijiKazeiRireki.setKztgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        khHasseijiKazeiRireki.setYenhtykeihi(pHasjKzInfoSksParam.getHtykeihi());
        khHasseijiKazeiRireki.setYenkztgk(pHasjKzInfoSksParam.getSynykngk());
        khHasseijiKazeiRireki.setZeimukwsratekjnymd(pHasjKzInfoSksParam.getShrkwsratekjnymd());
        khHasseijiKazeiRireki.setZeimukwsrate(pHasjKzInfoSksParam.getShrkwsrate());
        khHasseijiKazeiRireki.setKyknmkn(kykSya.getKyknmkn());
        khHasseijiKazeiRireki.setKyknmkj(kykSya.getKyknmkj());
        khHasseijiKazeiRireki.setKykyno(kykSya.getTsinyno());
        khHasseijiKazeiRireki.setKykadr1kj(kykSya.getTsinadr1kj());
        khHasseijiKazeiRireki.setKykadr2kj(kykSya.getTsinadr2kj());
        khHasseijiKazeiRireki.setKykadr3kj(kykSya.getTsinadr3kj());
        khHasseijiKazeiRireki.setKykmnmeigibangou("");
        khHasseijiKazeiRireki.setUktmnmeigibangou("");
        khHasseijiKazeiRireki.setShrtysysyuruikbn(pHasjKzInfoSksParam.getShrtysysyuruiKbn());
        khHasseijiKazeiRireki.setYenshrkykhtykeihi(pHasjKzInfoSksParam.getYenShrkykhtykeihi());
        khHasseijiKazeiRireki.setKykhnkkaisuu(pHasjKzInfoSksParam.getKykhnkKaisuu());
        khHasseijiKazeiRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        khHasseijiKazeiRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        khHasseijiKazeiRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(khHasseijiKazeiRireki);

        UpdateDbInfoJidousoukinfukaKekkaBean updateDbInfoJidousoukinfukaKekkaBean =
            SWAKInjector.getInstance(UpdateDbInfoJidousoukinfukaKekkaBean.class);

        IT_KhTyousyo khTyousyo = null;
        if (!C_HtsiryosyuKbn.BLNK.eq(pHasjKzInfoSksParam.getShrtysysyuruiKbn())) {

            HasseijikziEditShrtyousyotblParam hasseijikziEditShrtyousyotblParam =
                SWAKInjector.getInstance(HasseijikziEditShrtyousyotblParam.class);
            hasseijikziEditShrtyousyotblParam.setSyoriymd(syoriYmd);
            hasseijikziEditShrtyousyotblParam.setShrsyoriKbn(C_ShrsyoriKbn.PMINYUUSYOUMETU);
            hasseijikziEditShrtyousyotblParam.setKouryokuhasseiYmd(pSyoumetuymd);
            hasseijikziEditShrtyousyotblParam.setMfadrsiyouhyouji(C_UmuKbn.ARI);
            hasseijikziEditShrtyousyotblParam.setShrgk(pHasjKzInfoSksParam.getKaiyakuHrYen());
            hasseijikziEditShrtyousyotblParam.setYenkansansonotaseisank(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            hasseijikziEditShrtyousyotblParam.setYenhaitoukin(pHasjKzInfoSksParam.getHaitoukinYen());
            hasseijikziEditShrtyousyotblParam.setYensonotahaitoukin(pHasjKzInfoSksParam.getYentkbthaitoukin());
            hasseijikziEditShrtyousyotblParam.setSynykngk(pHasjKzInfoSksParam.getSynykngk());
            hasseijikziEditShrtyousyotblParam.setMihrkmp(pHasjKzInfoSksParam.getMihrkmp());
            hasseijikziEditShrtyousyotblParam.setShrymd(pSyoumetuymd);
            hasseijikziEditShrtyousyotblParam.setSyorisosikicd(C_Tantositucd.HOZENSIHARAISV.getValue() + "0000");
            hasseijikziEditShrtyousyotblParam.setShrtysytsinyno("");
            hasseijikziEditShrtyousyotblParam.setShrtysyadr1kj("");
            hasseijikziEditShrtyousyotblParam.setShrtysyadr2kj("");
            hasseijikziEditShrtyousyotblParam.setShrtysyadr3kj("");
            hasseijikziEditShrtyousyotblParam.setUktnmkj("");
            hasseijikziEditShrtyousyotblParam.setHtsiryosyuKbn(pHasjKzInfoSksParam.getShrtysysyuruiKbn());
            hasseijikziEditShrtyousyotblParam.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
            hasseijikziEditShrtyousyotblParam.setKihrkmp(pHasjKzInfoSksParam.getHtykeihi());
            hasseijikziEditShrtyousyotblParam.setKykmnmeigibangou("");
            hasseijikziEditShrtyousyotblParam.setUktmnmeigibangou("");
            hasseijikziEditShrtyousyotblParam.setKykhnkkaisuu(pHasjKzInfoSksParam.getKykhnkKaisuu());
            hasseijikziEditShrtyousyotblParam.setShrkykhtykeihi(pHasjKzInfoSksParam.getYenShrkykhtykeihi());

            HasseijikziEditShrtyousyotbl hasseijikziEditShrtyousyotbl =
                SWAKInjector.getInstance(HasseijikziEditShrtyousyotbl.class);
            khTyousyo = hasseijikziEditShrtyousyotbl.exec(pKhozenCommonParam, hasseijikziEditShrtyousyotblParam);
        }
        updateDbInfoJidousoukinfukaKekkaBean.setKhTyousyo(khTyousyo);

        return updateDbInfoJidousoukinfukaKekkaBean;
    }

    private IT_SyoumetuTuuti createSyoumetuTuuti (KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon, IT_Kouza pKouza, C_KahiKbn pKahiKbn,
        SyoumetuTuutiSksParam pSyoumetuTuutiSksParam) {
        IT_KykSya kykSya = pKykKihon.getKykSya();
        IT_HhknSya hhknSya = pKykKihon.getHhknSya();
        String bankNmKj = "";
        String reportSitenNm = "";
        if (pKouza != null) {
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pKouza.getBankcd(), pKouza.getSitencd());
            bankNmKj = bzGetBankDataBean.getBankNmKj();
            reportSitenNm = bzGetBankDataBean.getReportSitenNm();
        }
        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        BzGetSosikiMadogutiInfoKekkaBean bzSosikiBean = bzGetSosikiMadogutiInfo.exec(
            YuyuBizConfig.getInstance().getCallcentersosikicd());

        C_ZeimuNaiyouHnsyuCtrlKbn zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.BLNK;
        if (C_KahiKbn.KA.eq(pKahiKbn)) {
            if (pSyoumetuTuutiSksParam.getKykhnkKaisuu() == 0) {
                zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI;
            }
            else if (pSyoumetuTuutiSksParam.getKykhnkKaisuu() > 0){
                zeimuNaiyouHnsyuCtrlKbn = C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI;
            }
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int kyknen = setNenrei.exec(
            syoriYmd,
            kykSya.getKykseiymd());
        int seijinNenrei = YuyuHozenConfig.getInstance().getSeijinNenrei();
        C_KykMsnKbn kykMsnKbn;
        if (kyknen < seijinNenrei) {
            kykMsnKbn = C_KykMsnKbn.MISEINEN;
        }
        else {
            kykMsnKbn = C_KykMsnKbn.SEINEN;
        }

        IT_SyoumetuTuuti syoumetuTuuti = new IT_SyoumetuTuuti(pKykKihon.getSyono(), syoriYmd);
        syoumetuTuuti.setHenkousikibetukey(pSyoumetuTuutiSksParam.getHenkouSikibetukey());
        syoumetuTuuti.setHassoukbn(pSyoumetuTuutiSksParam.getHassouKbn());
        if (C_KahiKbn.KA.eq(pKahiKbn)) {
            syoumetuTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_SYOUMETUTUUTI);
            syoumetuTuuti.setSksdoufuukbn(C_UmuKbn.NONE);
        }
        else {
            syoumetuTuuti.setSyoruiCd(C_SyoruiCdKbn.AS_SYOUMETUTUUTI_SHRSKS);
            syoumetuTuuti.setSksdoufuukbn(C_UmuKbn.ARI);
        }
        if (C_KahiKbn.HUKA.eq(pKahiKbn) &&
            C_HtsiryosyuKbn.ITJKNSHRTYOUSYO.eq(pSyoumetuTuutiSksParam.getShrtysysyuruiKbn())) {
            syoumetuTuuti.setMynosinkokuiraidoufuukbn(C_UmuKbn.ARI);
        }
        else {
            syoumetuTuuti.setMynosinkokuiraidoufuukbn(C_UmuKbn.NONE);
        }
        syoumetuTuuti.setShskyno(kykSya.getTsinyno());
        syoumetuTuuti.setShsadr1kj(kykSya.getTsinadr1kj());
        syoumetuTuuti.setShsadr2kj(kykSya.getTsinadr2kj());
        syoumetuTuuti.setShsadr3kj(kykSya.getTsinadr3kj());
        syoumetuTuuti.setShsnmkj(kykSya.getKyknmkj());
        syoumetuTuuti.setToiawaseyno(bzSosikiBean.getPostalCd());
        syoumetuTuuti.setToiawaseadr1kj(bzSosikiBean.getKanjisosikiadr1());
        syoumetuTuuti.setToiawaseadr2kj(bzSosikiBean.getKanjisosikiadr2());
        syoumetuTuuti.setToiawaseadr3kj(bzSosikiBean.getKanjisosikiadr3());
        syoumetuTuuti.setToiawasekaisyanmkj(YuyuBizConfig.getInstance().getHokenKaisyaNmKanji());
        syoumetuTuuti.setToiawasesosikinmkj(bzSosikiBean.getKanjisosikinm());
        syoumetuTuuti.setToiawasetelno(bzSosikiBean.getTelno());
        syoumetuTuuti.setToiawaseteluktkkanou1(YuyuBizConfig.getInstance().getUketimecallcenter1());
        syoumetuTuuti.setToiawaseteluktkkanou2(YuyuBizConfig.getInstance().getUketimecallcenter2());
        syoumetuTuuti.setSyoumetuymd(pSyoumetuTuutiSksParam.getSyoumetuYmd());
        syoumetuTuuti.setShrymd(pSyoumetuTuutiSksParam.getShrYmd());
        syoumetuTuuti.setKyknmkj(kykSya.getKyknmkj());
        syoumetuTuuti.setHhknnmkj(hhknSya.getHhknnmkj());
        syoumetuTuuti.setKeiyakuymd(pSyoumetuTuutiSksParam.getKykYmd());
        syoumetuTuuti.setShrtuukakaiyakuhrkngkkei(pSyoumetuTuutiSksParam.getShrtuukaKaiyakuhrkngkkei());
        syoumetuTuuti.setKaiyakuhrkngkkeisiteituuka(pSyoumetuTuutiSksParam.getKaiyakuHrkngkkeiSiteituuka());
        syoumetuTuuti.setSonotaseisan(pSyoumetuTuutiSksParam.getSonotaSeisan());
        syoumetuTuuti.setYenkansanhaitoukin(pSyoumetuTuutiSksParam.getYenkansanhaitoukin());
        syoumetuTuuti.setYensonotahaitoukin(pSyoumetuTuutiSksParam.getYenSonotaHaitoukin());
        syoumetuTuuti.setShrtuukagstszeigk(pSyoumetuTuutiSksParam.getShrtuukaGstszeigk());
        syoumetuTuuti.setZitkazukarikingksiteituuka(pSyoumetuTuutiSksParam.getZitkazukarikingkSiteituuka());
        syoumetuTuuti.setShrgkkei(pSyoumetuTuutiSksParam.getShrgkkei());
        syoumetuTuuti.setShrtuukasyu(SHRTUUKASYU);
        syoumetuTuuti.setShrkwsrate(pSyoumetuTuutiSksParam.getYenShrrate());
        if (pKouza != null) {
            syoumetuTuuti.setBankcd(pKouza.getBankcd());
            syoumetuTuuti.setSitencd(pKouza.getSitencd());
            syoumetuTuuti.setBanknmkj(bankNmKj);
            syoumetuTuuti.setSitennmkj(reportSitenNm);
            syoumetuTuuti.setYokinkbn(pKouza.getYokinkbn());
            syoumetuTuuti.setKouzano(pKouza.getKouzano());
            syoumetuTuuti.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
            syoumetuTuuti.setKzmeiginmkn(pKouza.getKzmeiginmkn());
        }
        syoumetuTuuti.setHtsiryosyukbn(pSyoumetuTuutiSksParam.getShrtysysyuruiKbn());
        syoumetuTuuti.setSynykngk(pSyoumetuTuutiSksParam.getSynykngk());
        syoumetuTuuti.setHtykeihi(pSyoumetuTuutiSksParam.getHtykeihi());
        syoumetuTuuti.setShrkykhtykeihi(pSyoumetuTuutiSksParam.getYenShrkykhtykeihi());
        syoumetuTuuti.setZeimunaiyouhensyuctrlkbn(zeimuNaiyouHnsyuCtrlKbn);
        syoumetuTuuti.setKykhnkkaisuu(pSyoumetuTuutiSksParam.getKykhnkKaisuu());
        syoumetuTuuti.setKykmsnkbn(kykMsnKbn);
        if (C_KahiKbn.HUKA.eq(pKahiKbn)) {
            syoumetuTuuti.setLastsyosaihkymd(pKykKihon.getLastsyosaihkymd());
            syoumetuTuuti.setTsinyno(kykSya.getTsinyno());
            syoumetuTuuti.setTsintelno(kykSya.getTsintelno());
            syoumetuTuuti.setTsinadr1kj(kykSya.getTsinadr1kj());
            syoumetuTuuti.setTsinadr2kj(kykSya.getTsinadr2kj());
            syoumetuTuuti.setTsinadr3kj(kykSya.getTsinadr3kj());
        }
        syoumetuTuuti.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());
        syoumetuTuuti.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
        syoumetuTuuti.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(syoumetuTuuti);
        return syoumetuTuuti;
    }

    private KhSyoumetuKykListDataSourceBean createSyoumetuKykList (
        IT_KykKihon pKykKihon, BizDate pSyoumetuymd, BizDate pKykYmd,
        C_JidousoukinHukaRiyuuKbn pJidousoukinHukaRiyuuKbn, C_SyorikahiKbn pSyorikahiKbn, BizCurrency pKaiyakuhr) {

        IT_KykSya kykSya = pKykKihon.getKykSya();
        IT_HhknSya hhknSya = pKykKihon.getHhknSya();
        KhSyoumetuKykListDataSourceBean khSyoumetuKykListDataSourceBean =
            SWAKInjector.getInstance(KhSyoumetuKykListDataSourceBean.class);
        khSyoumetuKykListDataSourceBean.setIrSyoumetuymd(pSyoumetuymd.toString());
        khSyoumetuKykListDataSourceBean.setIrSyono(pKykKihon.getSyono());
        khSyoumetuKykListDataSourceBean.setIrKykymd(pKykYmd.toString());
        khSyoumetuKykListDataSourceBean.setIrKyknmkj(kykSya.getKyknmkj());
        khSyoumetuKykListDataSourceBean.setIrHhknnmkj(hhknSya.getHhknnmkj());
        khSyoumetuKykListDataSourceBean.setIrJidousoukinhukariyuukbn(pJidousoukinHukaRiyuuKbn);
        khSyoumetuKykListDataSourceBean.setIrTtdktyuuihanteikekka(pSyorikahiKbn);
        khSyoumetuKykListDataSourceBean.setIrStknsetkbn(pKykKihon.getStknsetkbn());
        khSyoumetuKykListDataSourceBean.setIrKaiyakuhr(pKaiyakuhr);
        khSyoumetuKykListDataSourceBean.setIrAisyoumeikbn(pKykKihon.getAisyoumeikbn());

        return khSyoumetuKykListDataSourceBean;
    }

    private boolean checkSoukiSyoumetuCsvSakusei (IT_KykKihon pKykKihon, BizDateYM pJkipjytYm, BizDate pKykYmd) {

        if (!C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu())) {
            return false;
        }

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {
            return false;
        }

        if (BizDateUtil.compareYm(pJkipjytYm, pKykYmd.addMonths(2).getBizDateYM()) != BizDateUtil.COMPARE_GREATER) {
            return true;
        }

        return false;
    }

    private KhSoukiSyoumetuDataRecordLayoutFile createSoukiSyoumetuData(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn,
        BizDate pSyoumetuymd) {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pKykSyouhn.getSyouhncd(), pKykSyouhn.getSyouhnsdno());
        IT_KykSya kykSya = pKykKihon.getKykSya();
        List<IT_KykDairiten> kykDairitenLst = pKykKihon.getKykDairitens();
        String drtenCd = kykDairitenLst.get(0).getDrtencd();
        String bosyuuCd = kykDairitenLst.get(0).getBosyuucd();
        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(drtenCd);
        String skeibsyknjDrten = "";
        String oyadrtenCd = "";
        String kinyuuCd = "";
        String kinyuusitenCd = "";
        String keisyousakidrtenCd = "";
        String skeibsyknjdrtenCd = "";
        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
            if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                skeibsyknjDrten = bzGetAgInfoBean.getKanjiDairitenNm();
                kinyuuCd = bzGetAgInfoBean.getKinyuuCd();
                kinyuusitenCd = bzGetAgInfoBean.getKinyuuSitenCd();
                skeibsyknjdrtenCd = bzGetAgInfoBean.getDrtenCd();
            }
            else if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                oyadrtenCd = bzGetAgInfoBean.getDrtenCd();
            }
            else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                keisyousakidrtenCd = bzGetAgInfoBean.getDrtenCd();
            }
        }
        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);
        String bosyuuninNm = "";
        if (bzGetBsInfoBean != null) {
            bosyuuninNm = bzGetBsInfoBean.getKanjiBosyuuninNm();
        }
        String syouhnNm = syouhnZokusei.getSyouhnnmsyouken() + "「" + pKykKihon.getAisyoumeikbn().getContent() + "」";
        String bankCd = kinyuuCd;
        String sitenCd = "";
        if (!BizUtil.isBlank(kinyuusitenCd)) {
            sitenCd = kinyuusitenCd.substring(1);
        }
        String sitenNmKj = "";
        if (!BizUtil.isBlank(bankCd) && !BizUtil.isBlank(sitenCd) ) {
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankCd, sitenCd, pSyoumetuymd);
            sitenNmKj = bzGetBankDataBean.getSitenNmKj();
        }
        KhSoukiSyoumetuDataRecordLayoutFile khSoukiSyoumetuDataRecordLayoutFile =
            SWAKInjector.getInstance(KhSoukiSyoumetuDataRecordLayoutFile.class);
        khSoukiSyoumetuDataRecordLayoutFile.setIfcSyono(pKykKihon.getSyono());
        khSoukiSyoumetuDataRecordLayoutFile.setIfcOyadrtencd(oyadrtenCd);
        khSoukiSyoumetuDataRecordLayoutFile.setIfcSkeibsyknjdrtencd(skeibsyknjdrtenCd);
        khSoukiSyoumetuDataRecordLayoutFile.setIfcDrtenhydrtencd(keisyousakidrtenCd);
        khSoukiSyoumetuDataRecordLayoutFile.setIfcKykymd(pKykSyouhn.getKykymd());
        khSoukiSyoumetuDataRecordLayoutFile.setIfcSyoumetuymd(pSyoumetuymd.toString());
        khSoukiSyoumetuDataRecordLayoutFile.setIfcBosyudrtennm(skeibsyknjDrten);
        khSoukiSyoumetuDataRecordLayoutFile.setIfcSitennm(sitenNmKj);
        khSoukiSyoumetuDataRecordLayoutFile.setIfcKyksyamei(kykSya.getKyknmkj());
        khSoukiSyoumetuDataRecordLayoutFile.setIfcSyouhnnm(syouhnNm);
        khSoukiSyoumetuDataRecordLayoutFile.setIfcBosyuTntnm(bosyuuninNm);

        return khSoukiSyoumetuDataRecordLayoutFile;
    }

    private C_HassouKbn setHassouKbn(IT_KykKihon pKykKihon, C_YuukoujyotaichkKbn pYuukoujyotaichkKbn,
        C_SyorikahiKbn pSyorikahiKbn, C_KahiKbn pKahiKbn) {
        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;
        C_KktyuitaKbn kktyuitaKbn = C_KktyuitaKbn.BLNK;

        AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);
        kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(pKykKihon.getSyono());

        if (C_KahiKbn.KA.eq(pKahiKbn)) {
            if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {
                hassouKbn = C_HassouKbn.HONSYAKAISOU;
            }
            else {
                hassouKbn = C_HassouKbn.TYOKUSOU;
            }
        }
        else {
            if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn) ||
                C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(pYuukoujyotaichkKbn) ||
                C_SyorikahiKbn.TYUUITRATKIKA.eq(pSyorikahiKbn) ||
                C_StknsetKbn.ARI.eq(pKykKihon.getStknsetkbn())) {
                hassouKbn = C_HassouKbn.HONSYAKAISOU;
            }
            else {
                hassouKbn = C_HassouKbn.TYOKUSOU;
            }
        }
        return hassouKbn;
    }

    private void outputSyoumetuKeiyakuLst () {
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(SAKUSEISOSIKICD);
        String sakuseiSosikiNm = "";
        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
            sakuseiSosikiNm = bzGetSosikiDataBean.getKanjisosikinm20();
        }

        Ordering<IReportDataSouceBean> ordering = Ordering.from(new KhSyoumetuKykListDataSourceBeanSortComparator());
        iReportDataSouceBeanLst = ordering.sortedCopy(iReportDataSouceBeanLst);

        KhSyoumetuKykListBean khSyoumetuKykListBean = SWAKInjector.getInstance(KhSyoumetuKykListBean.class);
        khSyoumetuKykListBean.setIrSyoriymd(syoriYmd.toString());
        khSyoumetuKykListBean.setIrKensuu(iReportDataSouceBeanLst.size());
        khSyoumetuKykListBean.setIrSakuseisosiki(sakuseiSosikiNm);

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.AS_SYOUMETUKEIYAKULIST);

        reportServicesBean.addParamObjects(iReportDataSouceBeanLst, khSyoumetuKykListBean);
        reportServicesBean.setSyoriYmd(syoriYmd);
        createReport.execNoCommit(reportServicesBean);
    }

    private void outputSoukiSyoumetuFile () {
        List<KhSoukiSyoumetuLayoutFile> khSoukiSyoumetuLayoutFileLst = new ArrayList<>();
        KhSoukiSyoumetuLayoutFile khSoukiSyoumetuLayoutFile;

        KhSoukiSyoumetuHeaderRecordLayoutFile khSoukiSyoumetuHeaderRecordLayoutFile =
            SWAKInjector.getInstance(KhSoukiSyoumetuHeaderRecordLayoutFile.class);
        khSoukiSyoumetuHeaderRecordLayoutFile.setIfcTitle(DATEFILETITLE);

        String headerRecord = SeparateConvertUtil.beanToStringForSeparate(khSoukiSyoumetuHeaderRecordLayoutFile, KONMA);
        khSoukiSyoumetuLayoutFile = SWAKInjector.getInstance(KhSoukiSyoumetuLayoutFile.class);
        khSoukiSyoumetuLayoutFile.setIfcSoukisyoumetudata(headerRecord);
        khSoukiSyoumetuLayoutFileLst.add(khSoukiSyoumetuLayoutFile);

        khSoukiSyoumetuLayoutFile = SWAKInjector.getInstance(KhSoukiSyoumetuLayoutFile.class);
        khSoukiSyoumetuLayoutFile.setIfcSoukisyoumetudata(MIDASIMOJIRETU);
        khSoukiSyoumetuLayoutFileLst.add(khSoukiSyoumetuLayoutFile);

        for (KhSoukiSyoumetuDataRecordLayoutFile khSoukiSyoumetuDataRecordLayoutFile : khSoukiSyoumetuDataRecordLayoutFileLst) {
            String dataRecord = SeparateConvertUtil.beanToStringForSeparate(khSoukiSyoumetuDataRecordLayoutFile, KONMA);
            khSoukiSyoumetuLayoutFile = SWAKInjector.getInstance(KhSoukiSyoumetuLayoutFile.class);
            khSoukiSyoumetuLayoutFile.setIfcSoukisyoumetudata(dataRecord);
            khSoukiSyoumetuLayoutFileLst.add(khSoukiSyoumetuLayoutFile);
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.AS_SOUKISYOUMETUDATA,
            khSoukiSyoumetuLayoutFileLst,
            false,
            null);
    }
}
