package yuyu.batch.hozen.khozen.khbatchkaiyaku;

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
import yuyu.batch.hozen.khozen.khbatchkaiyaku.dba.KhBatchKaiyakuDao;
import yuyu.batch.hozen.khozen.khbatchkaiyaku.dba.KhHenkouUktkBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzdairiten.BzGetTuukeiBunwari;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSikinIdouRirekiTblSakusei;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTbl;
import yuyu.common.hozen.khcommon.EditHokenKykIdouRirekiTblBean;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdate;
import yuyu.common.hozen.khcommon.EditKaiyakuTblUpdateBean;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditTtdkKanryouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngk;
import yuyu.common.hozen.khcommon.GetKhTuusanyouKngkBean;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuOutBean;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.hozen.khcommon.KeisanSiharaibi;
import yuyu.common.hozen.khcommon.KeisanTienRisoku;
import yuyu.common.hozen.khcommon.KhCheckBankMaster;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.MiKeikaPBean;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.sorter.SortBT_TjtIdouNyKh;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_DiritenplannmKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TourokuRouteKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KhDenpyoData;
import yuyu.def.db.entity.IT_BAK_KhDshrTuki;
import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktk;
import yuyu.def.db.entity.IT_BAK_KhSntkInfoTouroku;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.hozen.file.csv.KhKaiyakuMousideUktkDataFile;
import yuyu.def.hozen.file.csv.KhSoukiKaiyakuDataFile;
import yuyu.def.hozen.file.csv.KhSoukiKaiyakuDataLayoutFile;
import yuyu.def.hozen.file.csv.KhSoukiKaiyakuHeaderRecordFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 バッチ解約
 */
public class KhBatchKaiyakuBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KhHenkouUktk.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final String EXFILENM = "BatchKaiyaku";

    private static final BizCurrency SHRTYSYSKS_TAISYOU_HANTEIGK = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);

    private static final char KANMA = ',';

    private static final String TITLE = "早期解約";

    private static final String MIDASI = "証券番号,親代理店コード,新契約募集時代理店コード,代理店保有契約代理店コード,契約日,解約受付日,募集代理店名,支店名,契約者名,商品名,募集担当者氏名";

    private KhozenCommonParam khozenCommonParam = null;

    private List<EditKhMisslstParam> editKhMisslstParamLst = new ArrayList<>();

    private int dataRenno = 0;

    private List<KhKaiyakuMousideUktkDataFile> khKaiyakuMousideUktkDataFileLst = new ArrayList<>();

    private List<KhSoukiKaiyakuDataFile> khSoukiKaiyakuDataFileLst = new ArrayList<>();

    private int khSoukiKaiyakuDataFileSyoriKensu = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhBatchKaiyakuDao khBatchKaiyakuDao;

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

        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ibKakutyoujobCd));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        int count = 0;
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        try (
            ExDBResults<KhHenkouUktkBean> khHenkouUktkBeanLst = khBatchKaiyakuDao.getKhHenkouUktkBeans(syoriYmd,
                ibKakutyoujobCd);
            MultipleEntityUpdater dataUpd = new MultipleEntityUpdater();
            MultipleEntityInserter dataIns = new MultipleEntityInserter();) {

            for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHenkouUktkBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khHenkouUktkBean.getSyono());

                dataRenno++;
                C_Tuukasyu shrtuukasyu = C_Tuukasyu.BLNK;
                C_KouzasyuruiKbn kouzasyuruiKbn = C_KouzasyuruiKbn.BLNK;
                BizDate yenshrratetekiYmd = null;
                BizNumber yenshrratek = BizNumber.valueOf(0);
                BizDate gkshrkwsrateymd = null;
                BizNumber gkshrkwsrate = BizNumber.valueOf(0);
                BizCurrency kaiyakuhryen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizNumber sjkkktyouseiritu = BizNumber.valueOf(0);
                BizNumber kaiyakusjkkktyouseiriritu = BizNumber.valueOf(0);
                BizCurrency synykngk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency htykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                int kykhnkkaisuu = 0;
                BizCurrency yenshrkykhtykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizDate shrymd = null;
                C_ShrhousiteiKbn shrhousiteiKbn = C_ShrhousiteiKbn.BLNK;
                BizCurrency jpyshrtienrsk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizDate jpytienrisokukisanYmd = null;
                int jpytienrsknissuu = 0;
                BizCurrency jpyshrgkgoukeikakunin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizDate shrtienrskkisanYmd = null;
                int tienrsknissuu = 0;
                BizNumber zeimukwsrate = BizNumber.valueOf(0);
                BizDate zeimukwsratekjnYmd = null;
                BizCurrency zeimukaiyakuhryen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                C_UktkJyoutaiKbn uktkjyoutaiKbn = C_UktkJyoutaiKbn.SYORIZUMI;
                EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = new EditKaiyakuTblUpdateBean();
                int misslistSeqNo = 0;
                String misslistMsg = "";
                CheckKaiyakuBean checkKaiyakuBean = new CheckKaiyakuBean();
                EditTtdkKanryouParam editTtdkKanryouParam = new EditTtdkKanryouParam();
                C_HtsiryosyuKbn shrtysysyuruiKbn = C_HtsiryosyuKbn.BLNK;
                C_Segcd seg1cd = C_Segcd.BLNK;
                C_Segcd seg2cd = C_Segcd.BLNK;
                BizCurrency jpygstszeigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yengstszeigknationaltax = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yengstszeigklocaltax = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                C_UmuKbn gsbunritaisyouFlg = C_UmuKbn.NONE;
                C_Tuukasyu  tsntuukasyu = C_Tuukasyu.BLNK;
                BizCurrency tsnyennyknkgk = BizCurrency.valueOf(0);
                BizCurrency tsnyousibous = BizCurrency.valueOf(0);
                BizCurrency tsnyouitijip = BizCurrency.valueOf(0);
                BizCurrency tsnyounkgns = BizCurrency.valueOf(0);
                BizNumber kaiyakukoujyoritu = BizNumber.valueOf(0);
                BizCurrency yengstszeitsaeki = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency sonotaseisan = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;
                BizCurrency yenkiykhrgoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yensonotashrgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yenkamikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yenkazennouseisankgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency azukarikinkykhnkmikeikap = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yenkahaitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yentkbthaitoukin = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizCurrency yenkakrkgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                BizDateYM mikeikapjyutouym = null;
                int mikeikapjyutoukaisuuy = 0;
                int mikeikapjyutoukaisuum = 0;
                MiKeikaPBean[] pdtlmikeikap = null;
                BizCurrency jpyshrgkgoukeisyoukai = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                C_Kaiyakujiyuu kaiyakujiyuu = C_Kaiyakujiyuu.TUUJYOU;
                C_ErrorKbn errorKbn = C_ErrorKbn.OK;

                IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk(khHenkouUktkBean.getSyono(),
                    khHenkouUktkBean.getHozenhenkouuktkrenno());

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(khHenkouUktkBean.getSyono());

                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector
                    .getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(khHenkouUktkBean.getSyono());
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                    checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                    misslistSeqNo++;
                    misslistMsg = MessageUtil.getMessage(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());

                    syoriKahiHanteiErrSyori(
                        khHenkouUktk,
                        kykKihon,
                        misslistSeqNo,
                        misslistMsg,
                        kinouId,
                        userId,
                        sysDateTimeMilli,
                        dataUpd);

                    continue;

                }

                HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, khHenkouUktkBean.getSyono());
                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

                    misslistSeqNo++;
                    misslistMsg = MessageUtil.getMessage(MessageId.EIA1006, hanteiTetuduki.getMessageParam());

                    syoriKahiHanteiErrSyori(
                        khHenkouUktk,
                        kykKihon,
                        misslistSeqNo,
                        misslistMsg,
                        kinouId,
                        userId,
                        sysDateTimeMilli,
                        dataUpd);

                    continue;

                }

                IT_KhTtdkTyuui khTtdkTyuui = khozenCommonParam.getKkTetudukiTyuui(khHenkouUktkBean.getSyono());
                if ((khTtdkTyuui != null && (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn1())
                    || C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn1())
                    || C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn1())
                    || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn2())
                    || C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn2())
                    || C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn2())
                    || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn3())
                    || C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn3())
                    || C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn3())
                    || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn4())
                    || C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn4())
                    || C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn4())
                    || C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn5())
                    || C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn5())
                    || C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn5())))
                    || C_StknsetKbn.ARI.eq(kykKihon.getStknsetkbn())) {

                    misslistSeqNo++;
                    misslistMsg = MessageUtil.getMessage(MessageId.EIF1027);

                    syoriKahiHanteiErrSyori(
                        khHenkouUktk,
                        kykKihon,
                        misslistSeqNo,
                        misslistMsg,
                        kinouId,
                        userId,
                        sysDateTimeMilli,
                        dataUpd);

                    continue;

                }

                IT_KhHenkouUktkKaiyaku khHenkouUktkKaiyaku = khHenkouUktk.getKhHenkouUktkKaiyaku();

                List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
                if (kykSyouhnLst.size() > 0) {
                    kykSyouhn = kykSyouhnLst.get(0);
                }

                int syouhinhanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(kykSyouhn.getKyktuukasyu());
                BizCurrency kaiyakuhr = BizCurrency.valueOf(0, currencyType);
                BizCurrency kiykhrsyousaiptumitatekin = BizCurrency.valueOf(0, currencyType);
                BizCurrency kiykhrsyousaisjkkktyouseigk = BizCurrency.valueOf(0, currencyType);
                BizCurrency shrtienrsk = BizCurrency.valueOf(0, currencyType);
                BizCurrency shrgkgoukeikakunin = BizCurrency.valueOf(0, currencyType);
                BizCurrency gstszeigk = BizCurrency.valueOf(0, currencyType);
                BizCurrency teiritutmttkngk = BizCurrency.valueOf(0, currencyType);
                BizCurrency sisuurendoutmttkngk = BizCurrency.valueOf(0, currencyType);
                BizCurrency kaiyakukjgk = BizCurrency.valueOf(0, currencyType);
                BizCurrency kaiyakuhrgoukei = BizCurrency.valueOf(0, currencyType);
                BizCurrency azukarikinkykhnkkaiyakuhr = BizCurrency.valueOf(0, currencyType);
                BizCurrency sonotashrgk = BizCurrency.valueOf(0, currencyType);
                BizCurrency shrgkgoukeisyoukai = BizCurrency.valueOf(0, currencyType);
                BizCurrency gaikamikeikap = BizCurrency.valueOf(0, currencyType);
                BizCurrency gaikazennouseisank = BizCurrency.valueOf(0, currencyType);

                if (C_UmuKbn.ARI.eq(khHenkouUktkKaiyaku.getYenshrtkhkumu())
                    || C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    shrtuukasyu = C_Tuukasyu.JPY;
                    kouzasyuruiKbn = C_KouzasyuruiKbn.YENKOUZA;
                }
                else {
                    shrtuukasyu = kykSyouhn.getKyktuukasyu();
                    kouzasyuruiKbn = C_KouzasyuruiKbn.GAIKAKOUZA;
                }

                KhCheckBankMaster khCheckBankMaster = SWAKInjector.getInstance(KhCheckBankMaster.class);
                int errNaiyou = khCheckBankMaster.checkBankMaster(shrtuukasyu, khHenkouUktkKaiyaku.getBankcd(),
                    khHenkouUktkKaiyaku.getSitencd());
                if (errNaiyou != KhCheckBankMaster.SYORI_OK) {
                    misslistSeqNo++;
                    String errMsgId = "";
                    if (errNaiyou == KhCheckBankMaster.BANK_SONZAI_ERR) {
                        errMsgId = MessageId.EBC1007;
                    }
                    else if (errNaiyou == KhCheckBankMaster.BANK_YUUKOU_HANTEI_ERR) {
                        errMsgId = MessageId.EBC1008;
                    }
                    else if (errNaiyou == KhCheckBankMaster.BANK_YTGINKOU_SOUKIN_ERR) {
                        errMsgId = MessageId.EBC1009;
                    }
                    else if (errNaiyou == KhCheckBankMaster.GAIKAKOUZA_SOUKIN_ERR) {
                        errMsgId = MessageId.EBC1010;
                    }

                    misslistMsg = MessageUtil.getMessage(errMsgId);

                    syoriKahiHanteiErrSyori(
                        khHenkouUktk,
                        kykKihon,
                        misslistSeqNo,
                        misslistMsg,
                        kinouId,
                        userId,
                        sysDateTimeMilli,
                        dataUpd);

                    continue;

                }
                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(khHenkouUktkBean.getSyono());

                checkKaiyakuBean.setSyoruiukeYmd(khHenkouUktkBean.getKouryokuhasseiymd());
                checkKaiyakuBean.setSyukykYmd(kykSyouhn.getKykymd());
                checkKaiyakuBean.setYendthnkYmd(kykSyouhn.getYendthnkymd());
                checkKaiyakuBean.setSyoriYmd(syoriYmd);
                checkKaiyakuBean.setKykKihon(kykKihon);
                checkKaiyakuBean.setAnsyuKihon(ansyuKihon);
                CheckKaiyaku checkKaiyaku = SWAKInjector.getInstance(CheckKaiyaku.class);
                C_KaiyakuchkkekkaKbn kaiyakuchkkekkaKbn = checkKaiyaku.exec(CheckKaiyaku.KINOUBUNRUI_BATCH, "", checkKaiyakuBean);
                if (C_KaiyakuchkkekkaKbn.ERROR.eq(kaiyakuchkkekkaKbn)) {

                    misslistSeqNo++;
                    misslistMsg = checkKaiyaku.getErrorMessage();

                    syoriKahiHanteiErrSyori(
                        khHenkouUktk,
                        kykKihon,
                        misslistSeqNo,
                        misslistMsg,
                        kinouId,
                        userId,
                        sysDateTimeMilli,
                        dataUpd);

                    continue;

                }

                khozenCommonParam.setSikibetuKey(null);
                String sikibetuKey = khozenCommonParam.getSikibetuKey(khHenkouUktkBean.getSyono());

                KeisanCommonKaiyaku keisanCommonKaiyaku = SWAKInjector.getInstance(KeisanCommonKaiyaku.class);

                KeisanKaiyakuBean keisanKaiyakuBean = SWAKInjector.getInstance(KeisanKaiyakuBean.class);

                KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean = SWAKInjector.getInstance(KeisanCommonKaiyakuOutBean.class);

                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    errorKbn = getKawaseRate.exec(
                        khHenkouUktkBean.getKouryokuhasseiymd(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.SYUKKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException("為替レート取得が実行できませんでした。証券番号："
                            + khHenkouUktkBean.getSyono());
                    }

                    yenshrratetekiYmd = getKawaseRate.getKwsrateKjYmd();

                    yenshrratek = getKawaseRate.getKawaserate();

                    errorKbn = getKawaseRate.exec(
                        khHenkouUktkBean.getKouryokuhasseiymd(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.NYUKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.YOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException("為替レート取得が実行できませんでした。証券番号："
                            + khHenkouUktkBean.getSyono());
                    }

                    gkshrkwsrateymd = getKawaseRate.getKwsrateKjYmd();

                    gkshrkwsrate = getKawaseRate.getKawaserate();
                }

                keisanKaiyakuBean.setSyoruiukeymd(khHenkouUktkBean.getKouryokuhasseiymd());

                keisanKaiyakuBean.setKaiykymd(khHenkouUktkBean.getKouryokuhasseiymd());

                keisanKaiyakuBean.setYenshrkwsrate(yenshrratek);

                keisanKaiyakuBean.setGkshrkwsrate(gkshrkwsrate);

                errorKbn = keisanCommonKaiyaku.keisanKaiyakuseisankin(
                    KeisanCommonKaiyaku.KINOUBUNRUI_BATCH,
                    kykKihon,
                    syoriYmd,
                    keisanKaiyakuBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(keisanCommonKaiyaku.getErrorMessage() + "証券番号：" +
                        khHenkouUktkBean.getSyono());
                }

                keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();

                kaiyakuhr = keisanCommonKaiyakuOutBean.getKaiyakuHr();

                kaiyakuhryen = keisanCommonKaiyakuOutBean.getKaiyakuHrYen();

                kiykhrsyousaiptumitatekin = keisanCommonKaiyakuOutBean.getPtumitatekin();

                kiykhrsyousaisjkkktyouseigk = keisanCommonKaiyakuOutBean.getSjkkkTyouseiGk();

                sjkkktyouseiritu = keisanCommonKaiyakuOutBean.getSjkkkTyouseiRitu();

                kaiyakusjkkktyouseiriritu = keisanCommonKaiyakuOutBean.getKaiyakusjkkktyouseiriritu();

                teiritutmttkngk = keisanCommonKaiyakuOutBean.getTeiriTutmttKngk();

                sisuurendoutmttkngk = keisanCommonKaiyakuOutBean.getSisuuRendouTmttKngkl();

                kaiyakukjgk = keisanCommonKaiyakuOutBean.getKaiyakuKjgk();

                kaiyakukoujyoritu = keisanCommonKaiyakuOutBean.getKaiyakuKjRitu();

                sonotaseisan = keisanCommonKaiyakuOutBean.getSonotaseisan();

                seg1cd = keisanCommonKaiyakuOutBean.getSegcdOne();

                seg2cd = keisanCommonKaiyakuOutBean.getSegcdTwo();

                kaiyakuhrgoukei = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeigk();

                yenkiykhrgoukei = keisanCommonKaiyakuOutBean.getKaiyakuhrgoukeiYen();

                azukarikinkykhnkkaiyakuhr = keisanCommonKaiyakuOutBean.getAzukariGanrikingk();

                sonotashrgk = keisanCommonKaiyakuOutBean.getSonotashrgkgk();

                yensonotashrgk = keisanCommonKaiyakuOutBean.getSonotashrgkYen();

                gaikamikeikap = keisanCommonKaiyakuOutBean.getMikeikapGk();

                yenkamikeikap = keisanCommonKaiyakuOutBean.getMikeikapYen();

                gaikazennouseisank = keisanCommonKaiyakuOutBean.getZennouseisankGk();

                yenkazennouseisankgk = keisanCommonKaiyakuOutBean.getZennouseisankYen();

                azukarikinkykhnkmikeikap = keisanCommonKaiyakuOutBean.getAzukariGanrikinYen();

                yenkahaitoukin = keisanCommonKaiyakuOutBean.getHaitoukinYen();

                yentkbthaitoukin = keisanCommonKaiyakuOutBean.getYentkbthaitoukin();

                yenkakrkgk = keisanCommonKaiyakuOutBean.getKrkgkYen();

                mikeikapjyutouym = keisanCommonKaiyakuOutBean.getMikeikaPjyutouYm();

                mikeikapjyutoukaisuuy = keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuY();

                mikeikapjyutoukaisuum = keisanCommonKaiyakuOutBean.getMikeikaPJyutouKaisuuM();

                pdtlmikeikap = keisanCommonKaiyakuOutBean.getMiKeikaPBeans();

                gstszeigk = keisanCommonKaiyakuOutBean.getGstszeigk();

                gsbunritaisyouFlg = keisanCommonKaiyakuOutBean.getGsbunritaisyouFlg();

                shrgkgoukeisyoukai = keisanCommonKaiyakuOutBean.getShrgkkeigk();

                jpyshrgkgoukeisyoukai = keisanCommonKaiyakuOutBean.getShrgkkeiYen();

                if (C_UmuKbn.ARI.eq(khHenkouUktkKaiyaku.getYenshrtkhkumu())
                    || C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    jpygstszeigk = keisanCommonKaiyakuOutBean.getJpygstszeigk();

                    yengstszeigknationaltax = keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkKokuz();

                    yengstszeigklocaltax = keisanCommonKaiyakuOutBean.getJpyShrjiYengstszeigkTihouz();

                    yengstszeitsaeki = keisanCommonKaiyakuOutBean.getJpykaShrYenGsTsTaisyouSaeki();

                    htykeihi = keisanCommonKaiyakuOutBean.getJpyShrjiYenhtykeihi();
                }
                else {

                    jpygstszeigk = keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigk();

                    yengstszeigknationaltax = keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkKokuz();

                    yengstszeigklocaltax = keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsZeigkTihouz();

                    yengstszeitsaeki = keisanCommonKaiyakuOutBean.getGaikaShrYenGsTsTaisyouSaeki();

                    htykeihi = keisanCommonKaiyakuOutBean.getGaikaShrYenHtyKeihi();
                }

                if (C_UmuKbn.NONE.eq(gsbunritaisyouFlg)) {
                    if (C_UmuKbn.NONE.eq(khHenkouUktkKaiyaku.getYenshrtkhkumu())
                        && !C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                        errorKbn = getKawaseRate.exec(
                            khHenkouUktkBean.getKouryokuhasseiymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException("為替レート取得が実行できませんでした。証券番号："
                                + khHenkouUktkBean.getSyono());
                        }

                        keisanCommonKaiyakuOutBean.setZeimuRatesyutokuYmd(getKawaseRate.getKwsrateKjYmd());
                        keisanCommonKaiyakuOutBean.setZeimukwsrate(getKawaseRate.getKawaserate());
                    }
                }

                keisanCommonKaiyaku.keisanZeimuinfo(
                    KeisanCommonKaiyaku.KINOUBUNRUI_BATCH,
                    kykKihon,
                    syoriYmd,
                    shrtuukasyu,
                    kaiyakujiyuu,
                    keisanKaiyakuBean,
                    keisanCommonKaiyakuOutBean);

                synykngk = keisanCommonKaiyakuOutBean.getSynykngk();

                htykeihi = keisanCommonKaiyakuOutBean.getHtykeihi();

                kykhnkkaisuu = keisanCommonKaiyakuOutBean.getKykhnkkaisuu();

                yenshrkykhtykeihi = keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi();

                yengstszeitsaeki = keisanCommonKaiyakuOutBean.getYengststaisyousaeki();

                zeimukwsratekjnYmd = keisanCommonKaiyakuOutBean.getZeimuRatesyutokuYmd();

                zeimukwsrate = keisanCommonKaiyakuOutBean.getZeimukwsrate();

                if (C_UmuKbn.ARI.eq(khHenkouUktkKaiyaku.getYenshrtkhkumu()) ||
                    C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    zeimukaiyakuhryen = kaiyakuhryen;
                }
                else {
                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    zeimukaiyakuhryen = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kaiyakuhr,
                        zeimukwsrate, C_HasuusyoriKbn.SUTE);
                }

                if (C_UmuKbn.NONE.eq(gsbunritaisyouFlg)) {
                    if (zeimukaiyakuhryen.compareTo(SHRTYSYSKS_TAISYOU_HANTEIGK) > 0
                        && (kykhnkkaisuu > 0
                            || (kykhnkkaisuu == 0 && synykngk.subtract(htykeihi).compareTo(
                                BizCurrency.valueOf(0, BizCurrencyTypes.YEN)) > 0))) {
                        shrtysysyuruiKbn = C_HtsiryosyuKbn.ITJKNSHRTYOUSYO;
                    }
                }

                KeisanSiharaibi keisanSiharaibi = SWAKInjector.getInstance(KeisanSiharaibi.class);
                shrymd = keisanSiharaibi.exec(syoriYmd,
                    khHenkouUktkKaiyaku.getInputshrhousiteikbn(), shrtuukasyu, khHenkouUktkKaiyaku.getBankcd());
                shrhousiteiKbn = keisanSiharaibi.getShrhousiteiKbn();

                KeisanTienRisoku keisanTienRisoku = SWAKInjector.getInstance(KeisanTienRisoku.class);
                if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    keisanTienRisoku.exec(khHenkouUktkBean.getKouryokuhasseiymd(), shrymd, jpyshrgkgoukeisyoukai);

                    KeisanTienrisokuBean keisanTienrisokuBean = keisanTienRisoku.getKeisanTienrisokuBean();
                    shrtienrsk = keisanTienrisokuBean.getShrtienrsk();
                    jpyshrtienrsk = keisanTienrisokuBean.getShrtienrsk();
                    shrtienrskkisanYmd = khHenkouUktkBean.getKouryokuhasseiymd();
                    jpytienrisokukisanYmd = khHenkouUktkBean.getKouryokuhasseiymd();
                    tienrsknissuu = keisanTienrisokuBean.getShrtienNissuu();
                    jpytienrsknissuu = keisanTienrisokuBean.getShrtienNissuu();

                    shrgkgoukeikakunin = jpyshrgkgoukeisyoukai.add(shrtienrsk);
                    jpyshrgkgoukeikakunin = jpyshrgkgoukeisyoukai.add(shrtienrsk);

                }
                else {

                    if (C_UmuKbn.ARI.eq(khHenkouUktkKaiyaku.getYenshrtkhkumu())) {

                        keisanTienRisoku.exec(khHenkouUktkBean.getKouryokuhasseiymd(), shrymd, jpyshrgkgoukeisyoukai);

                        KeisanTienrisokuBean keisanTienrisokuBean = keisanTienRisoku.getKeisanTienrisokuBean();
                        jpyshrtienrsk = keisanTienrisokuBean.getShrtienrsk();
                        jpytienrisokukisanYmd = khHenkouUktkBean.getKouryokuhasseiymd();
                        jpytienrsknissuu = keisanTienrisokuBean.getShrtienNissuu();
                        jpyshrgkgoukeikakunin = jpyshrgkgoukeisyoukai.add(jpyshrtienrsk);

                    }

                    keisanTienRisoku.exec(khHenkouUktkBean.getKouryokuhasseiymd(), shrymd, shrgkgoukeisyoukai);

                    KeisanTienrisokuBean keisanTienrisokuBean = keisanTienRisoku.getKeisanTienrisokuBean();
                    shrtienrsk = keisanTienrisokuBean.getShrtienrsk();
                    shrtienrskkisanYmd = khHenkouUktkBean.getKouryokuhasseiymd();
                    tienrsknissuu = keisanTienrisokuBean.getShrtienNissuu();
                    shrgkgoukeikakunin = shrgkgoukeisyoukai.add(shrtienrsk);

                }

                TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
                tableMaintenanceUtil.backUp(khHenkouUktkBean.getSyono(), sikibetuKey);

                count++;

                createKaiyakuUktkCsvDataSyori(khHenkouUktk, kykKihon);

                editKaiyakuTblUpdateBean.setSyono(khHenkouUktkBean.getSyono());
                editKaiyakuTblUpdateBean.setSyoruiukeymd(khHenkouUktkBean.getKouryokuhasseiymd());
                editKaiyakuTblUpdateBean.setKaiykymd(khHenkouUktkBean.getKouryokuhasseiymd());
                editKaiyakuTblUpdateBean.setYenshrtkumu(khHenkouUktkKaiyaku.getYenshrtkhkumu());
                editKaiyakuTblUpdateBean.setInputshrhousiteikbn(khHenkouUktkKaiyaku.getInputshrhousiteikbn());
                editKaiyakuTblUpdateBean.setKaiyakujiyuu(kaiyakujiyuu);
                editKaiyakuTblUpdateBean.setKaiyakuhrgoukei(kaiyakuhrgoukei);
                editKaiyakuTblUpdateBean.setKaiyakuhrgoukeiyen(yenkiykhrgoukei);
                editKaiyakuTblUpdateBean.setKaiyakuhr(kaiyakuhr);
                editKaiyakuTblUpdateBean.setKaiyakuhryen(kaiyakuhryen);
                editKaiyakuTblUpdateBean.setYenshrrate(yenshrratek);
                editKaiyakuTblUpdateBean.setYenshrratetekiymd(yenshrratetekiYmd);
                editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(kiykhrsyousaiptumitatekin);
                editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(kiykhrsyousaisjkkktyouseigk);
                editKaiyakuTblUpdateBean.setKaiyakukjgk(kaiyakukjgk);
                editKaiyakuTblUpdateBean.setSjkkktyouseiritu(sjkkktyouseiritu);
                editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(kaiyakusjkkktyouseiriritu);
                editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(kaiyakukoujyoritu);
                editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(azukarikinkykhnkkaiyakuhr);
                editKaiyakuTblUpdateBean.setShrtienrsk(shrtienrsk);
                editKaiyakuTblUpdateBean.setShrtienrskkisanymd(shrtienrskkisanYmd);
                editKaiyakuTblUpdateBean.setTienrsknissuu(tienrsknissuu);
                editKaiyakuTblUpdateBean.setJpyshrtienrsk(jpyshrtienrsk);
                editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(jpytienrisokukisanYmd);
                editKaiyakuTblUpdateBean.setJpytienrsknissuu(jpytienrsknissuu);
                editKaiyakuTblUpdateBean.setGksonotashrgk(sonotashrgk);
                editKaiyakuTblUpdateBean.setJpysonotashrgk(yensonotashrgk);
                editKaiyakuTblUpdateBean.setGkshrrate(gkshrkwsrate);
                editKaiyakuTblUpdateBean.setGkshrratetekiymd(gkshrkwsrateymd);
                editKaiyakuTblUpdateBean.setJpymikeikap(yenkamikeikap);
                editKaiyakuTblUpdateBean.setMikeikapjyutouym(mikeikapjyutouym);
                editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(mikeikapjyutoukaisuuy);
                editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(mikeikapjyutoukaisuum);
                editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(pdtlmikeikap);
                editKaiyakuTblUpdateBean.setJpyzennouseisankgk(yenkazennouseisankgk);
                editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(azukarikinkykhnkmikeikap);
                editKaiyakuTblUpdateBean.setJpykariukekin(yenkakrkgk);
                editKaiyakuTblUpdateBean.setJpyhaitoukin(yenkahaitoukin);
                editKaiyakuTblUpdateBean.setJpytkbthaitoukin(yentkbthaitoukin);
                editKaiyakuTblUpdateBean.setYendthnkhr(sonotaseisan);
                editKaiyakuTblUpdateBean.setGstszeigk(gstszeigk);
                editKaiyakuTblUpdateBean.setJpygstszeigk(jpygstszeigk);
                editKaiyakuTblUpdateBean.setYengstszeigknationaltax(yengstszeigknationaltax);
                editKaiyakuTblUpdateBean.setYengstszeigklocaltax(yengstszeigklocaltax);
                editKaiyakuTblUpdateBean.setGsbunritaisyouflg(gsbunritaisyouFlg);
                editKaiyakuTblUpdateBean.setYengststaisyousaeki(yengstszeitsaeki);
                editKaiyakuTblUpdateBean.setTeiritutmttkngk(teiritutmttkngk);
                editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(sisuurendoutmttkngk);
                editKaiyakuTblUpdateBean.setShrgkkei(shrgkgoukeikakunin);
                editKaiyakuTblUpdateBean.setJpyshrgkgoukei(jpyshrgkgoukeikakunin);
                editKaiyakuTblUpdateBean.setZeimukwsrate(zeimukwsrate);
                editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(zeimukwsratekjnYmd);
                editKaiyakuTblUpdateBean.setSynykngk(synykngk);
                editKaiyakuTblUpdateBean.setHtykeihi(htykeihi);
                editKaiyakuTblUpdateBean.setKykhnkkaisuu(kykhnkkaisuu);
                editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(yenshrkykhtykeihi);
                editKaiyakuTblUpdateBean.setShrymd(shrymd);
                editKaiyakuTblUpdateBean.setShrtuukasyu(shrtuukasyu);
                editKaiyakuTblUpdateBean.setShrhousiteikbn(shrhousiteiKbn);
                editKaiyakuTblUpdateBean.setBankcd(khHenkouUktkKaiyaku.getBankcd());
                editKaiyakuTblUpdateBean.setSitencd(khHenkouUktkKaiyaku.getSitencd());
                editKaiyakuTblUpdateBean.setYokinkbn(khHenkouUktkKaiyaku.getYokinkbn());
                editKaiyakuTblUpdateBean.setKouzano(khHenkouUktkKaiyaku.getKouzano());
                editKaiyakuTblUpdateBean.setKzmeiginmkn(khHenkouUktkKaiyaku.getKzmeiginmkn());
                editKaiyakuTblUpdateBean.setKzsyuruikbn(kouzasyuruiKbn);
                editKaiyakuTblUpdateBean.setKzdoukbn(khHenkouUktkKaiyaku.getKzdoukbn());
                editKaiyakuTblUpdateBean.setShrtysysyuruikbn(shrtysysyuruiKbn);
                editKaiyakuTblUpdateBean.setSeg1cd(seg1cd);
                editKaiyakuTblUpdateBean.setSeg2cd(seg2cd);
                editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
                editKaiyakuTblUpdateBean.setLastPJyuutouYm(keisanCommonKaiyakuOutBean.getLastpjytoym());
                editKaiyakuTblUpdateBean.setNaiteikakuteikbn(keisanCommonKaiyakuOutBean.
                    getKhHaitouKanriNaiteiKakuteiKbn());
                editKaiyakuTblUpdateBean.setEditDshrTukiDKoumokuBean(keisanCommonKaiyakuOutBean.getEditDshrTukiDKoumokuBean());

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syouhinhanteiKbn ||
                    C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    editKaiyakuTblUpdateBean.setMikeikap(yenkamikeikap);
                    editKaiyakuTblUpdateBean.setZennouseisankgk(yenkazennouseisankgk);
                }
                else {
                    editKaiyakuTblUpdateBean.setMikeikap(gaikamikeikap);
                    editKaiyakuTblUpdateBean.setZennouseisankgk(gaikazennouseisank);
                }

                EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
                editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
                    tableMaintenanceUtil.getBakKykKihon());

                IT_KykSya kykSya = kykKihon.getKykSya();
                IT_HhknSya hhknSya = kykKihon.getHhknSya();
                List<IT_KykUkt> sbuktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
                List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();
                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekis();
                IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
                List<IT_KykUkt> stdrskLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);
                List<IT_KykUkt> kykUktLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.KYKDRN);

                List<IT_TrkKzk> trkKzkLst = kykKihon.getTrkKzks();
                IT_TrkKzk trkKzk1 = null;
                IT_TrkKzk trkKzk2 = null;

                for (IT_TrkKzk trkKzk : trkKzkLst) {

                    if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {
                        trkKzk1 = trkKzk;
                    }
                    else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {
                        trkKzk2 = trkKzk;
                    }
                }

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(),
                    kykSyouhn.getSyouhnsdno());

                GetKhTuusanyouKngk getKhTuusanyouKngk = SWAKInjector.getInstance(GetKhTuusanyouKngk.class);

                GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = getKhTuusanyouKngk.getAlltsnkngk(
                    syouhnZokusei,
                    kykSyouhn,
                    nyknJissekiRirekiLst.get(0),
                    kykSonotaTkyk);

                tsntuukasyu = getKhTuusanyouKngkBean.getTsnyouTuukasyu();

                tsnyousibous = getKhTuusanyouKngkBean.getTsnyouSibous();

                tsnyouitijip = getKhTuusanyouKngkBean.getTsnyouItijip();

                tsnyounkgns = getKhTuusanyouKngkBean.getTsnyouNkgns();

                tsnyennyknkgk = getKhTuusanyouKngkBean.getTsnyouYennyknkgk();

                HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(
                    HanteiTyotikuseihokenBean.class);

                SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(
                    SetTyotikuseihokenhyouji.class);

                hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhn.getSyouhncd());
                hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
                hanteiTyotikuseihokenBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
                hanteiTyotikuseihokenBean.setHrkkeiro(kykKihon.getHrkkeiro());

                setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);

                C_UmuKbn houteityotkhknhyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj();

                BT_TjtIdouNyKh tjtIdouNyKh = new BT_TjtIdouNyKh();
                List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhsBySyono(khHenkouUktkBean.getSyono());
                int renno3keta = 1;
                if (tjtIdouNyKhLst.size() > 0) {
                    SortBT_TjtIdouNyKh sort = SWAKInjector.getInstance(SortBT_TjtIdouNyKh.class);
                    tjtIdouNyKhLst = sort.OrderBT_TjtIdouNyKhByPkDesc(tjtIdouNyKhLst);
                    renno3keta = tjtIdouNyKhLst.get(0).getRenno3keta() + 1;
                }

                tjtIdouNyKh.setSyono(khHenkouUktkBean.getSyono());
                tjtIdouNyKh.setRenno3keta(renno3keta);
                tjtIdouNyKh.setRecordsakujyohyouji(0);
                tjtIdouNyKh.setYoukyuuno("");
                tjtIdouNyKh.setSyouhncd(kykSyouhn.getSyouhncd());
                tjtIdouNyKh.setKykjyoutai(kykSyouhn.getKykjyoutai());
                tjtIdouNyKh.setKykymd(kykSyouhn.getKykymd());
                tjtIdouNyKh.setYuukousyoumetukbn(kykSyouhn.getYuukousyoumetukbn());
                tjtIdouNyKh.setSyoumetujiyuu(kykSyouhn.getSyoumetujiyuu());
                tjtIdouNyKh.setSyoumetuymd(kykSyouhn.getSyoumetuymd());
                tjtIdouNyKh.setKyktuukasyu(kykSyouhn.getKyktuukasyu());
                tjtIdouNyKh.setTsntuukasyu(tsntuukasyu);
                tjtIdouNyKh.setTsnyousibous(tsnyousibous);
                tjtIdouNyKh.setTsnyouitijip(tsnyouitijip);
                tjtIdouNyKh.setTsnyounkgns(tsnyounkgns);
                tjtIdouNyKh.setHrkkkn(kykSyouhn.getHrkkkn());
                tjtIdouNyKh.setSntkhoukbn(kykKihon.getSntkhoukbn());
                tjtIdouNyKh.setBosyuuym(kykKihon.getBosyuuym());
                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {
                    tjtIdouNyKh.setKykhhkndouhyouji(1);
                }
                else {
                    tjtIdouNyKh.setKykhhkndouhyouji(0);
                }
                if (khTtdkTyuui != null) {
                    tjtIdouNyKh.setTtdktyuuikbn1(khTtdkTyuui.getTtdktyuuikbn1());
                    tjtIdouNyKh.setTtdktyuuikbn2(khTtdkTyuui.getTtdktyuuikbn2());
                    tjtIdouNyKh.setTtdktyuuikbn3(khTtdkTyuui.getTtdktyuuikbn3());
                    tjtIdouNyKh.setTtdktyuuikbn4(khTtdkTyuui.getTtdktyuuikbn4());
                    tjtIdouNyKh.setTtdktyuuikbn5(khTtdkTyuui.getTtdktyuuikbn5());
                }
                tjtIdouNyKh.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
                tjtIdouNyKh.setKaigomaehrtkykumukbn(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu());
                tjtIdouNyKh.setPyennykntkykumukbn(kykSonotaTkyk.getYennykntkhkumu());
                tjtIdouNyKh.setTsnyennyknkgk(tsnyennyknkgk);
                tjtIdouNyKh.setSkjmosno(kykKihon.getSkjmosno());
                tjtIdouNyKh.setGyoumuKousinKinou(kinouId);
                tjtIdouNyKh.setGyoumuKousinsyaId(userId);
                tjtIdouNyKh.setGyoumuKousinTime(sysDateTimeMilli);
                tjtIdouNyKh.setSeiritujitrhkjikakkbn(kykKihon.getSeiritujitrhkjikakkbn());
                if (C_UmuKbn.ARI.eq(houteityotkhknhyj)) {
                    tjtIdouNyKh.setHouteityotkseisyouhnhyj(C_HouteiTyotkseiSyouhnHyjKbn.GAITOU);
                }
                else {
                    tjtIdouNyKh.setHouteityotkseisyouhnhyj(C_HouteiTyotkseiSyouhnHyjKbn.HIGAITOU);
                }

                tjtIdouNyKh.setHrkkeiro(kykKihon.getHrkkeiro());

                BizPropertyInitializer.initialize(tjtIdouNyKh);

                BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.createIdouKhMeigi();

                idouKhMeigi.setHhknnmkn(hhknSya.getHhknnmkn());
                if (C_KjkhukaKbn.KJKHUKA.eq(hhknSya.getHhknnmkjkhukakbn())) {
                    idouKhMeigi.setHhknnmkj("");
                }
                else {
                    idouKhMeigi.setHhknnmkj(hhknSya.getHhknnmkj());
                }
                idouKhMeigi.setHhknseiymd(hhknSya.getHhknseiymd());
                idouKhMeigi.setHhknsei(hhknSya.getHhknsei());
                idouKhMeigi.setHhknyno(hhknSya.getHhknyno());
                idouKhMeigi.setHhknadr1kj("");
                idouKhMeigi.setHhknadr2kj("");
                idouKhMeigi.setHhknadr3kj("");
                idouKhMeigi.setHhkntelno("");
                idouKhMeigi.setHhknsykgycd(kykKihon.getHhknsykgycd());
                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {
                    idouKhMeigi.setKyknmkn("");
                    idouKhMeigi.setKyknmkj("");
                    idouKhMeigi.setKykseiymd(null);
                }
                else {
                    idouKhMeigi.setKyknmkn(kykSya.getKyknmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(kykSya.getKyknmkjkhukakbn())) {
                        idouKhMeigi.setKyknmkj("");
                    }
                    else {
                        idouKhMeigi.setKyknmkj(kykSya.getKyknmkj());
                    }
                    idouKhMeigi.setKykseiymd(kykSya.getKykseiymd());
                }
                idouKhMeigi.setNenkinuktnmkana("");
                idouKhMeigi.setNenkinuktnmkanji("");
                idouKhMeigi.setNenkinuktseiymd(null);
                idouKhMeigi.setTsinyno(kykSya.getTsinyno());
                idouKhMeigi.setTsinadr1kj(kykSya.getTsinadr1kj());
                idouKhMeigi.setTsinadr2kj(kykSya.getTsinadr2kj());
                idouKhMeigi.setTsinadr3kj(kykSya.getTsinadr3kj());
                idouKhMeigi.setTsintelno(kykSya.getTsintelno());

                if (sbuktLst.size() > 0) {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(sbuktLst.get(0).getUktkbn())) {
                        idouKhMeigi.setSbuktnmkn1(sbuktLst.get(0).getUktnmkn());
                        if (C_KjkhukaKbn.KJKHUKA.eq(sbuktLst.get(0).getUktnmkjkhukakbn())) {
                            idouKhMeigi.setSbuktnmkj1("");
                        }
                        else {
                            idouKhMeigi.setSbuktnmkj1(sbuktLst.get(0).getUktnmkj());
                        }
                    }
                    else {
                        idouKhMeigi.setSbuktnmkn1("");
                        idouKhMeigi.setSbuktnmkj1("");
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn1("");
                    idouKhMeigi.setSbuktnmkj1("");
                }

                if (sbuktLst.size() > 1) {
                    idouKhMeigi.setSbuktnmkn2(sbuktLst.get(1).getUktnmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(sbuktLst.get(1).getUktnmkjkhukakbn())) {
                        idouKhMeigi.setSbuktnmkj2("");
                    }
                    else {
                        idouKhMeigi.setSbuktnmkj2(sbuktLst.get(1).getUktnmkj());
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn2("");
                    idouKhMeigi.setSbuktnmkj2("");
                }

                if (sbuktLst.size() > 2) {
                    idouKhMeigi.setSbuktnmkn3(sbuktLst.get(2).getUktnmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(sbuktLst.get(2).getUktnmkjkhukakbn())) {
                        idouKhMeigi.setSbuktnmkj3("");
                    }
                    else {
                        idouKhMeigi.setSbuktnmkj3(sbuktLst.get(2).getUktnmkj());
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn3("");
                    idouKhMeigi.setSbuktnmkj3("");
                }

                if (sbuktLst.size() > 3) {
                    idouKhMeigi.setSbuktnmkn4(sbuktLst.get(3).getUktnmkn());
                    if (C_KjkhukaKbn.KJKHUKA.eq(sbuktLst.get(3).getUktnmkjkhukakbn())) {
                        idouKhMeigi.setSbuktnmkj4("");
                    }
                    else {
                        idouKhMeigi.setSbuktnmkj4(sbuktLst.get(3).getUktnmkj());
                    }
                }
                else {
                    idouKhMeigi.setSbuktnmkn4("");
                    idouKhMeigi.setSbuktnmkj4("");
                }

                if (stdrskLst.size() > 0) {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(stdrskLst.get(0).getUktkbn())) {
                        idouKhMeigi.setStdrsknmkn(stdrskLst.get(0).getUktnmkn());
                        if (C_KjkhukaKbn.KJKHUKA.eq(stdrskLst.get(0).getUktnmkjkhukakbn())) {
                            idouKhMeigi.setStdrsknmkj("");
                        }
                        else {
                            idouKhMeigi.setStdrsknmkj(stdrskLst.get(0).getUktnmkj());
                        }
                    }
                    else {
                        idouKhMeigi.setStdrsknmkn("");
                        idouKhMeigi.setStdrsknmkj("");
                    }
                }
                else {
                    idouKhMeigi.setStdrsknmkn("");
                    idouKhMeigi.setStdrsknmkj("");
                }

                if (kykUktLst.size() > 0) {
                    if (C_UktKbn.TOKUTEIMEIGI.eq(kykUktLst.get(0).getUktkbn())) {
                        idouKhMeigi.setKykdairinmkn(kykUktLst.get(0).getUktnmkn());

                        if (C_KjkhukaKbn.KJKHUKA.eq(kykUktLst.get(0).getUktnmkjkhukakbn())) {
                            idouKhMeigi.setKykdairinmkj("");
                        }
                        else {
                            idouKhMeigi.setKykdairinmkj(kykUktLst.get(0).getUktnmkj());
                        }
                    }
                    else {
                        idouKhMeigi.setKykdairinmkn("");
                        idouKhMeigi.setKykdairinmkj("");
                    }
                }
                else {
                    idouKhMeigi.setKykdairinmkn("");
                    idouKhMeigi.setKykdairinmkj("");
                }

                if (C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {
                    idouKhMeigi.setBankcd(khHenkouUktkKaiyaku.getBankcd());
                    idouKhMeigi.setSitencd(khHenkouUktkKaiyaku.getSitencd());
                    idouKhMeigi.setYokinkbn(khHenkouUktkKaiyaku.getYokinkbn());
                    idouKhMeigi.setKouzano(khHenkouUktkKaiyaku.getKouzano());
                    idouKhMeigi.setKzmeiginmkn(khHenkouUktkKaiyaku.getKzmeiginmkn());
                    if (C_Kzdou.DOUITU.eq(khHenkouUktkKaiyaku.getKzdoukbn())) {

                        idouKhMeigi.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
                    }
                    else {

                        idouKhMeigi.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
                    }
                }

                if (trkKzk1 != null) {
                    idouKhMeigi.setKzktourokunmkn1(trkKzk1.getTrkkzknmkn());

                    if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk1.getTrkkzknmkjkhukakbn())) {
                        idouKhMeigi.setKzktourokunmkj1("");
                    }
                    else {
                        idouKhMeigi.setKzktourokunmkj1(trkKzk1.getTrkkzknmkj());
                    }
                }
                else {
                    idouKhMeigi.setKzktourokunmkn1("");
                    idouKhMeigi.setKzktourokunmkj1("");
                }

                if (trkKzk2 != null) {
                    idouKhMeigi.setKzktourokunmkn2(trkKzk2.getTrkkzknmkn());

                    if (C_KjkhukaKbn.KJKHUKA.eq(trkKzk2.getTrkkzknmkjkhukakbn())) {
                        idouKhMeigi.setKzktourokunmkj2("");
                    }
                    else {
                        idouKhMeigi.setKzktourokunmkj2(trkKzk2.getTrkkzknmkj());
                    }
                }
                else {
                    idouKhMeigi.setKzktourokunmkn2("");
                    idouKhMeigi.setKzktourokunmkj2("");
                }

                BizPropertyInitializer.initialize(idouKhMeigi);

                BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.createIdouKhBosyuudr();
                String drtencd1 = "";
                BizNumber bunwari1 = BizNumber.valueOf(0);
                String drtencd2 = "";
                BizNumber bunwari2 = BizNumber.valueOf(0);
                String kanrisosikicd1 = "";
                String kanrisosikicd2 = "";
                if (kykDairitenLst.size() == 1) {
                    drtencd1 = kykDairitenLst.get(0).getDrtencd();
                    bunwari1 = kykDairitenLst.get(0).getBunwari();
                    drtencd2 = "";
                    bunwari2 = BizNumber.valueOf(0);
                    kanrisosikicd1 = kykDairitenLst.get(0).getDrtenkanrisosikicd();
                    kanrisosikicd2 = "";
                }
                else if (kykDairitenLst.size() == 2) {
                    BzGetTuukeiBunwari bzGetTuukeiBunwari = SWAKInjector.getInstance(BzGetTuukeiBunwari.class);
                    bzGetTuukeiBunwari.exec(
                        kykDairitenLst.get(0).getDrtencd(),
                        kykDairitenLst.get(0).getOyadrtencd(),
                        kykDairitenLst.get(0).getBunwari(),
                        kykDairitenLst.get(1).getDrtencd(),
                        kykDairitenLst.get(1).getOyadrtencd(),
                        kykDairitenLst.get(1).getBunwari(),
                        kykKihon.getSeirituymd().getBizDateYM(),
                        syouhnZokusei.getDrtsyouhinsikibetukbn(),
                        kykKihon.getHrkkaisuu(),
                        C_DiritenplannmKbn.BLNK);
                    if (C_ErrorKbn.ERROR.eq(bzGetTuukeiBunwari.getErrorKbn())) {
                        throw new CommonBizAppException("通計用代理店分担割合取得が実行できませんでした。");
                    }
                    drtencd1 = bzGetTuukeiBunwari.getDrtencd1();
                    bunwari1 = bzGetTuukeiBunwari.getBuntanWariai1();
                    drtencd2 = bzGetTuukeiBunwari.getDrtencd2();
                    bunwari2 = bzGetTuukeiBunwari.getBuntanWariai2();
                    kanrisosikicd1 = kykDairitenLst.get(0).getDrtenkanrisosikicd();
                    kanrisosikicd2 = kykDairitenLst.get(1).getDrtenkanrisosikicd();
                }
                idouKhBosyuudr.setDairitencd1(drtencd1);
                idouKhBosyuudr.setBunwari1(bunwari1);
                idouKhBosyuudr.setDairitencd2(drtencd2);
                idouKhBosyuudr.setBunwari2(bunwari2);
                idouKhBosyuudr.setKanrisosikicd1(kanrisosikicd1);
                idouKhBosyuudr.setKanrisosikicd2(kanrisosikicd2);
                BizPropertyInitializer.initialize(idouKhBosyuudr);

                EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

                if (C_TourokuRouteKbn.DS.eq(khHenkouUktkBean.getTourokuroute())) {
                    syoriKbn = C_SyoriKbn.KAIYAKU_DIRECTSERVICE;

                }
                else if (C_TourokuRouteKbn.TEL.eq(khHenkouUktkBean.getTourokuroute())) {
                    syoriKbn = C_SyoriKbn.KAIYAKU_TEL;
                }

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(khHenkouUktkBean.getSyono());
                editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.ARI);
                editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
                editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);

                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                EditHokenKykIdouRirekiTblBean editHokenKykIdouRirekiTblBean = SWAKInjector.getInstance(
                    EditHokenKykIdouRirekiTblBean.class);
                EditHokenKykIdouRirekiTbl editHokenKykIdouRirekiTbl = SWAKInjector.getInstance(
                    EditHokenKykIdouRirekiTbl.class);

                editHokenKykIdouRirekiTblBean.setKhozenCommonParam(khozenCommonParam);
                editHokenKykIdouRirekiTblBean.setSyoNo(khHenkouUktkBean.getSyono());
                editHokenKykIdouRirekiTblBean.setSyoriYmd(syoriYmd);
                editHokenKykIdouRirekiTblBean.setSyoriKbn(C_SyoriKbn.BLNK);
                editHokenKykIdouRirekiTblBean.setSysDateTime(sysDateTimeMilli);

                if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syouhinhanteiKbn
                    || C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    editHokenKykIdouRirekiTblBean.setMikeikaP(yenkamikeikap);
                    editHokenKykIdouRirekiTblBean.setZennouseisanKin(yenkazennouseisankgk);
                }
                else {
                    editHokenKykIdouRirekiTblBean.setMikeikaP(gaikamikeikap);
                    editHokenKykIdouRirekiTblBean.setZennouseisanKin(gaikazennouseisank);
                }

                editHokenKykIdouRirekiTbl.exec(editHokenKykIdouRirekiTblBean);

                KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                editTtdkKanryouParam.setTetudukiSyu(C_TetudukisyuKbn.KAIYAKU);
                editTtdkKanryouParam.setKouryokuYMD(khHenkouUktkBean.getKouryokuhasseiymd());
                editTtdkKanryouParam.setSyoruiCdKbn(C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR);
                editTtdkKanryouParam.setSyokenDoufuUmu(C_UmuKbn.NONE);
                editTtdkKanryouParam.setCalckijyunYMD(khHenkouUktkBean.getKouryokuhasseiymd());
                if (shrgkgoukeikakunin.compareTo(BizCurrency.valueOf(0, shrgkgoukeikakunin.getType())) > 0) {
                    editTtdkKanryouParam.setSiharaiUmu(C_UmuKbn.ARI);
                }
                editTtdkKanryouParam.setKaiyakuJiyuu(C_Kaiyakujiyuu.TUUJYOU);
                editTtdkKanryouParam.setGsbunritaisyouFlg(gsbunritaisyouFlg);

                khozenTyouhyouCtl.setEditTtdkKanryouParam(editTtdkKanryouParam);
                khozenTyouhyouCtl.setHassoukbn(C_HassouKbn.TYOKUSOU);

                khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, khHenkouUktkBean.getSyono(),
                    new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR }, C_YouhiKbn.HUYOU);

                khHenkouUktk.setUktkjyoutaikbn(uktkjyoutaiKbn);
                khHenkouUktk.setGyoumuKousinKinou(kinouId);
                khHenkouUktk.setGyoumuKousinsyaId(userId);
                khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);

                dataUpd.add(editKaiyakuTblUpdate.getKykKihon());

                if (yenkazennouseisankgk.compareTo(BizCurrency.valueOf(0, yenkazennouseisankgk.getType())) > 0 ||
                    gaikazennouseisank.compareTo(BizCurrency.valueOf(0, gaikazennouseisank.getType())) > 0) {

                    dataUpd.add(editKaiyakuTblUpdate.getAnsyuKihon());
                }

                List<IT_KhDenpyoData> khDenpyoDataLst = editKaiyakuTblUpdate.getKhDenpyoDatas();
                if (khDenpyoDataLst.size() != 0) {
                    for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
                        dataIns.add(khDenpyoData);
                    }
                }

                IT_KhFBSoukinData khFBSoukinData = editKaiyakuTblUpdate.getKhFBSoukinData();
                if (khFBSoukinData != null) {
                    dataIns.add(khFBSoukinData);
                }

                IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
                if (khGaikaFBSoukinData != null) {
                    dataIns.add(khGaikaFBSoukinData);
                }

                dataIns.add(tjtIdouNyKh);

                IT_KhDshrTuki khDshrTuki = editKaiyakuTblUpdate.getKhDshrTuki();
                if (khDshrTuki != null) {
                    dataIns.add(khDshrTuki);
                }

                BT_SikinIdouRireki sikinIdouRirek = editKaiyakuTblUpdate.getSikinIdouRireki();
                if (sikinIdouRirek != null) {
                    BzSikinIdouRirekiTblSakusei bzSikinIdouRirekiTblSakusei = SWAKInjector.getInstance(
                        BzSikinIdouRirekiTblSakusei.class);
                    bzSikinIdouRirekiTblSakusei.insertSikinIdouRirekiTblOne(sikinIdouRirek);
                }

                IT_BAK_KykKihon bAKKykKihon = tableMaintenanceUtil.getBakKykKihon();
                if (bAKKykKihon != null) {
                    dataIns.add(bAKKykKihon);
                }

                IT_BAK_AnsyuKihon bAKAnsyuKihon = tableMaintenanceUtil.getBakAnsyuKihon();
                if (bAKAnsyuKihon != null) {
                    dataIns.add(bAKAnsyuKihon);
                }

                List<IT_BAK_KhDenpyoData> bakKhDenpyoDataLst = tableMaintenanceUtil.getBakKhDenpyoDataList();
                if (bakKhDenpyoDataLst.size() != 0) {
                    for (IT_BAK_KhDenpyoData bakKhDenpyoData : bakKhDenpyoDataLst) {
                        dataIns.add(bakKhDenpyoData);
                    }
                }

                List<IT_BAK_KhFBSoukinData> bakKhFBSoukinDataLst = tableMaintenanceUtil.getBakKhFBSoukinDataList();
                if (bakKhFBSoukinDataLst.size() != 0) {
                    for (IT_BAK_KhFBSoukinData bakKhFBSoukinData : bakKhFBSoukinDataLst) {
                        dataIns.add(bakKhFBSoukinData);
                    }
                }

                List<IT_BAK_KhGaikaFBSoukinData> bakKhGaikaFBSoukinDataLst = tableMaintenanceUtil
                    .getBakKhGaikaFBSoukinDataList();
                if (bakKhGaikaFBSoukinDataLst.size() != 0) {
                    for (IT_BAK_KhGaikaFBSoukinData bakKhGaikaFBSoukinData : bakKhGaikaFBSoukinDataLst) {
                        dataIns.add(bakKhGaikaFBSoukinData);
                    }
                }

                List<IT_BAK_KhSntkInfoTouroku> bakKhSntkInfoTourokuLst = tableMaintenanceUtil
                    .getBakKhSntkInfoTourokuList();
                if (bakKhSntkInfoTourokuLst.size() != 0) {
                    for (IT_BAK_KhSntkInfoTouroku bakKhSntkInfoTouroku : bakKhSntkInfoTourokuLst) {
                        dataIns.add(bakKhSntkInfoTouroku);
                    }
                }

                List<HT_BAK_SmbcStyKanri> bakSmbcStyKanriLst = tableMaintenanceUtil.getBakSmbcStyKanriList();
                if (bakSmbcStyKanriLst.size() != 0) {
                    for (HT_BAK_SmbcStyKanri bakSmbcStyKanri : bakSmbcStyKanriLst) {
                        dataIns.add(bakSmbcStyKanri);
                    }
                }

                List<IT_BAK_KhHenkouUktk> bAKKhHenkouUktkLst = tableMaintenanceUtil.getBakKhHenkouUktkList();
                if (bAKKhHenkouUktkLst.size() != 0) {
                    for (IT_BAK_KhHenkouUktk bAKKhHenkouUktk : bAKKhHenkouUktkLst) {
                        dataIns.add(bAKKhHenkouUktk);
                    }
                }

                List<IT_BAK_KhDshrTuki> baKKhDshrTukiLst = tableMaintenanceUtil.getBakKhDshrTukiList();
                if (baKKhDshrTukiLst.size() != 0) {
                    for (IT_BAK_KhDshrTuki baKKhDshrTuki : baKKhDshrTukiLst) {
                        dataIns.add(baKKhDshrTuki);
                    }
                }

                dataUpd.add(khHenkouUktk);
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        List<KhSoukiKaiyakuDataLayoutFile> soukiKaiyakuKeiyakuBeanDataLst = new ArrayList<KhSoukiKaiyakuDataLayoutFile>();
        for (KhSoukiKaiyakuDataFile khSoukiKaiyakuDataFile : khSoukiKaiyakuDataFileLst) {

            KhSoukiKaiyakuDataLayoutFile soukiKaiyakuKeiyakuBean = SWAKInjector
                .getInstance(KhSoukiKaiyakuDataLayoutFile.class);
            String dataRecord = SeparateConvertUtil.beanToStringForSeparate(khSoukiKaiyakuDataFile, KANMA);
            soukiKaiyakuKeiyakuBean.setIfcSoukikaiyakudata(dataRecord);
            soukiKaiyakuKeiyakuBeanDataLst.add(soukiKaiyakuKeiyakuBean);
        }

        KhSoukiKaiyakuHeaderRecordFile khSoukiKaiyakuHeaderRecordFile = SWAKInjector.getInstance(KhSoukiKaiyakuHeaderRecordFile.class);
        KhSoukiKaiyakuDataLayoutFile khSoukiKaiyakuDataLayoutFile = SWAKInjector.getInstance(KhSoukiKaiyakuDataLayoutFile.class);
        KhSoukiKaiyakuDataLayoutFile khSoukiKaiyakuDataLayoutFileMidasi = SWAKInjector.getInstance(KhSoukiKaiyakuDataLayoutFile.class);
        List<KhSoukiKaiyakuDataLayoutFile> KhSoukiKaiyakuDataLayoutFileLst = new ArrayList<KhSoukiKaiyakuDataLayoutFile>();

        khSoukiKaiyakuHeaderRecordFile.setIfcTitle(TITLE);
        String headRecord = SeparateConvertUtil.beanToStringForSeparate(khSoukiKaiyakuHeaderRecordFile, KANMA);
        khSoukiKaiyakuDataLayoutFile.setIfcSoukikaiyakudata(headRecord);
        KhSoukiKaiyakuDataLayoutFileLst.add(khSoukiKaiyakuDataLayoutFile);

        khSoukiKaiyakuDataLayoutFileMidasi.setIfcSoukikaiyakudata(MIDASI);
        KhSoukiKaiyakuDataLayoutFileLst.add(khSoukiKaiyakuDataLayoutFileMidasi);

        KhSoukiKaiyakuDataLayoutFileLst.addAll(soukiKaiyakuKeiyakuBeanDataLst);

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_KAIYAKUMOUSIDEUKTKDATA, khKaiyakuMousideUktkDataFileLst, false,
            EXFILENM);
        bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_SOUKIKAIYAKUDATA, KhSoukiKaiyakuDataLayoutFileLst, false, EXFILENM);

        if (editKhMisslstParamLst.size() > 0) {

            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

            khozenTyouhyouCtl.setEditKkMisslstParam(editKhMisslstParamLst);
            khozenTyouhyouCtl.setSyoriYmd(syoriYmd);

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
                new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_BATCHKAIYAKU_MISSLIST }, C_YouhiKbn.HUYOU);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(dataRenno)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), "契約基本テーブル"));
        if (editKhMisslstParamLst.size() > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "ミスリスト",
                String.valueOf(editKhMisslstParamLst.size())));
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "解約申出受付データ",
            String.valueOf(khKaiyakuMousideUktkDataFileLst.size())));
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "早期解約契約一覧",
            String.valueOf(khSoukiKaiyakuDataFileSyoriKensu)));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private void createKaiyakuUktkCsvDataSyori(IT_KhHenkouUktk pKhHenkouUktk, IT_KykKihon pKykKihon) {

        String kydatkidrtenCd = "";
        String skeibsyknjdrtenCd = "";
        String skeibsyknjdrten = "";
        String knjoyadrtennm = "";
        String oyadrtenCd = "";
        String bosyuuCd = "";
        String bosyuunm = "";
        String keisyousakiKodrtenCd = "";
        String keisyousakiKodrtennm = "";
        String daibunCd = "";
        String dairitenCd = "";
        String sitennmkj = "";
        String kinyuuCd = "";
        String kinyuusitenCd = "";
        String bankCd = "";
        String sitenCd = "";
        String syouhnnm = "";
        String gensyojiyuKbn = "  ";
        String idoKbn = "  ";
        String zennouhyouji = "0";
        BizCurrency keip = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        if (kykSyouhnLst.size() > 0) {
            kykSyouhn = kykSyouhnLst.get(0);
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(kykSyouhn.getSyouhncd(),
            kykSyouhn.getSyouhnsdno());

        IT_KykSya kykSya = pKykKihon.getKykSya();

        IT_HhknSya hhknSya = pKykKihon.getHhknSya();

        List<IT_KykDairiten> kykDairitenLst = pKykKihon.getKykDairitens();
        for (IT_KykDairiten kykDairiten : kykDairitenLst) {
            if (kykDairiten.getDrtenrenno() == 1) {
                dairitenCd = kykDairiten.getDrtencd();
                bosyuuCd = kykDairiten.getBosyuucd();
                daibunCd = kykDairiten.getBunwari().toString();
            }
            else if (kykDairiten.getDrtenrenno() == 2) {
                kydatkidrtenCd = kykDairiten.getDrtencd();
            }
        }

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        List<BzGetAgInfoBean> bzGetAgInfoBeanLst = bzGetAgInfo.exec(dairitenCd);
        for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanLst) {
            if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                skeibsyknjdrten = bzGetAgInfoBean.getKanjiDairitenNm();
                knjoyadrtennm = bzGetAgInfoBean.getKanjiHoujinSyougou();
                kinyuuCd = bzGetAgInfoBean.getKinyuuCd();
                kinyuusitenCd = bzGetAgInfoBean.getKinyuuSitenCd();
                skeibsyknjdrtenCd = bzGetAgInfoBean.getDrtenCd();
            }
            else if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                oyadrtenCd = bzGetAgInfoBean.getDrtenCd();
            }
            else if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {
                keisyousakiKodrtenCd = bzGetAgInfoBean.getDrtenCd();
                keisyousakiKodrtennm = bzGetAgInfoBean.getKanjiDairitenNm();
            }
        }

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(bosyuuCd);
        if (bzGetBsInfoBean != null) {
            bosyuunm = bzGetBsInfoBean.getKanjiBosyuuninNm();
        }

        List<IT_KhTtdkRireki> khTtdkRirekiLst = pKykKihon.getKhTtdkRirekis();
        for (IT_KhTtdkRireki khTtdkRireki : khTtdkRirekiLst) {
            if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khTtdkRireki.getGyoumuKousinKinou())) {
                gensyojiyuKbn = "6";
                idoKbn = "42";

                break;
            }
        }

        String hrkkaisuu = "0";
        if (C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu())) {

            if (C_TkiktbrisyuruiKbn.BLNK.eq(pKykKihon.getTikiktbrisyuruikbn()) ||
                C_TkiktbrisyuruiKbn.NONE.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                hrkkaisuu = "8";
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                hrkkaisuu = "6";
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn())) {

                hrkkaisuu = "5";
            }
        }
        else if (C_Hrkkaisuu.HALFY.eq(pKykKihon.getHrkkaisuu())) {
            hrkkaisuu = "6";
        }
        else if (C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())) {
            hrkkaisuu = "5";
        }
        else if (C_Hrkkaisuu.ITIJI.eq(pKykKihon.getHrkkaisuu())) {
            hrkkaisuu = "1";
        }

        syouhnnm = syouhnZokusei.getSyouhnnmsyouken() + "「" + pKykKihon.getAisyoumeikbn().getContent() + "」";

        if(C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())){

            zennouhyouji = "1";
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getItijibrumu())) {

            keip = pKykKihon.getHrkp();
        }
        else {

            KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);

            C_ErrorKbn errorKbn = keisanKihrkP.exec(pKykKihon.getSyono(),kykSyouhn.getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("既払込Ｐ計算が実行できませんでした。");
            }
            if (SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn &&
                !C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                keip = keisanKihrkP.getKihrkP();
            }
            else {
                keip = keisanKihrkP.getYenKihrkP();
            }
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu hrkpTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pKykKihon.getHrkp().getType());

        KhKaiyakuMousideUktkDataFile khKaiyakuMousideUktkDataFile = SWAKInjector
            .getInstance(KhKaiyakuMousideUktkDataFile.class);
        khKaiyakuMousideUktkDataFile.setIfcSyonosyuban(pKykKihon.getSyono());
        khKaiyakuMousideUktkDataFile.setIfcSkeibsyknjdrten(skeibsyknjdrten);
        khKaiyakuMousideUktkDataFile.setIfcKnjoyadrtennm(knjoyadrtennm);
        khKaiyakuMousideUktkDataFile.setIfcKnjkyksyamei(kykSya.getKyknmkj());
        khKaiyakuMousideUktkDataFile.setIfcMusymd(pKykKihon.getMosymd().toString());
        khKaiyakuMousideUktkDataFile.setIfcKnjsyuhsynm(syouhnnm);
        khKaiyakuMousideUktkDataFile.setIfcZennouhyouji(zennouhyouji);
        khKaiyakuMousideUktkDataFile.setIfcHrkp(pKykKihon.getHrkp().toAdsoluteString());
        khKaiyakuMousideUktkDataFile.setIfcHrkptuukasyu(hrkpTuukasyu.getValue());
        khKaiyakuMousideUktkDataFile.setIfcOyadrtencd(oyadrtenCd);
        khKaiyakuMousideUktkDataFile.setIfcKeip(keip.toAdsoluteString());
        khKaiyakuMousideUktkDataFile.setIfcHrkhou(hrkkaisuu);
        khKaiyakuMousideUktkDataFile.setIfcSkeibsyknjdrtencd(dairitenCd);
        khKaiyakuMousideUktkDataFile.setIfcKydatkidrtencd(kydatkidrtenCd);
        khKaiyakuMousideUktkDataFile.setIfcBosyuucd(bosyuuCd);
        khKaiyakuMousideUktkDataFile.setIfcBosyuunm(bosyuunm);
        khKaiyakuMousideUktkDataFile.setIfcKnjhknmei(hhknSya.getHhknnmkj());
        khKaiyakuMousideUktkDataFile.setIfcDrtenhydrtencd(keisyousakiKodrtenCd);
        khKaiyakuMousideUktkDataFile.setIfcKnjdrtennm(keisyousakiKodrtennm);
        khKaiyakuMousideUktkDataFile.setIfcDaibuncd(daibunCd);
        khKaiyakuMousideUktkDataFile.setIfcDrtenzksidrtencd(keisyousakiKodrtenCd);
        khKaiyakuMousideUktkDataFile.setIfcGensyojiyukbn(gensyojiyuKbn);
        khKaiyakuMousideUktkDataFile.setIfcIdoKbn(idoKbn);
        khKaiyakuMousideUktkDataFile.setIfcKykmfkykjyutikbn("6");
        khKaiyakuMousideUktkDataFile.setIfcKiykinfoymd(pKhHenkouUktk.getKouryokuhasseiymd().toString());

        khKaiyakuMousideUktkDataFileLst.add(khKaiyakuMousideUktkDataFile);

        BizDateYM syoriYM = pKhHenkouUktk.getKouryokuhasseiymd().getBizDateYM().addMonths(-4).getRekijyou();
        BizDateYM mosYM = pKykKihon.getMosymd().getBizDateYM();
        if (BizDateUtil.compareYm(mosYM, syoriYM) == BizDateUtil.COMPARE_GREATER
            || BizDateUtil.compareYm(mosYM, syoriYM) == BizDateUtil.COMPARE_EQUAL) {
            bankCd = kinyuuCd;
            if (!BizUtil.isBlank(kinyuusitenCd)) {
                sitenCd = kinyuusitenCd.substring(1);
            }
            if (!BizUtil.isBlank(bankCd) && !BizUtil.isBlank(sitenCd)) {
                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                sitennmkj = bzGetBankData.exec(bankCd, sitenCd, pKhHenkouUktk.getKouryokuhasseiymd()).getSitenNmKj();
            }

            KhSoukiKaiyakuDataFile khSoukiKaiyakuDataFile = SWAKInjector.getInstance(KhSoukiKaiyakuDataFile.class);
            khSoukiKaiyakuDataFile.setIfcSyono(pKykKihon.getSyono());
            khSoukiKaiyakuDataFile.setIfcOyadrtencd(oyadrtenCd);
            khSoukiKaiyakuDataFile.setIfcSkeibsyknjdrtencd(skeibsyknjdrtenCd);
            khSoukiKaiyakuDataFile.setIfcDrtenhydrtencd(keisyousakiKodrtenCd);
            khSoukiKaiyakuDataFile.setIfcKykymd(kykSyouhn.getKykymd());
            khSoukiKaiyakuDataFile.setIfcKaiyakuymd(pKhHenkouUktk.getKouryokuhasseiymd().toString());
            khSoukiKaiyakuDataFile.setIfcBosyudrtennm(skeibsyknjdrten);
            khSoukiKaiyakuDataFile.setIfcSitennm(sitennmkj);
            khSoukiKaiyakuDataFile.setIfcKyksyamei(kykSya.getKyknmkj());
            khSoukiKaiyakuDataFile.setIfcSyouhnnm(syouhnnm);
            khSoukiKaiyakuDataFile.setIfcBosyuTntnm(bosyuunm);

            khSoukiKaiyakuDataFileLst.add(khSoukiKaiyakuDataFile);

            khSoukiKaiyakuDataFileSyoriKensu++;
        }
    }

    private void syoriKahiHanteiErrSyori(IT_KhHenkouUktk pKhHenkouUktk, IT_KykKihon pKykKihon, int pMisslistSeqNo,
        String pMisslistMsg, String pKinouId, String pUserId, String pSysDateTimeMilli,
        MultipleEntityUpdater pDateUpdater) {

        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
        editKhMisslstParam.setDataNo(dataRenno);
        editKhMisslstParam.setSeqNo(pMisslistSeqNo);
        editKhMisslstParam.setMisslistMsg(pMisslistMsg);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
        editKhMisslstParam.setSyoNo(pKhHenkouUktk.getSyono());

        editKhMisslstParamLst.add(editKhMisslstParam);

        createKaiyakuUktkCsvDataSyori(pKhHenkouUktk, pKykKihon);

        C_UktkJyoutaiKbn uktkJyoutaiKbn = C_UktkJyoutaiKbn.ERROR;
        pKhHenkouUktk.setUktkjyoutaikbn(uktkJyoutaiKbn);
        pKhHenkouUktk.setGyoumuKousinKinou(pKinouId);
        pKhHenkouUktk.setGyoumuKousinsyaId(pUserId);
        pKhHenkouUktk.setGyoumuKousinTime(pSysDateTimeMilli);

        pDateUpdater.add(pKhHenkouUktk);

        pKykKihon.detach();

    }
}
