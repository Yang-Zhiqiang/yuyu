package yuyu.batch.direct.dskokyakukanri.dskaripasswordtuutisakusei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsKokyakunoScrambleSyori;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuBean;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.common.direct.dsninsyou.DsKariHonninKakuninCdScrambleSyori;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.direct.bean.report.DsKaripwtuutiTyuudanListBean;
import yuyu.def.direct.bean.report.DsKaripwtuutiTyuudanListDataSourceBean;
import yuyu.def.direct.configuration.YuyuDirectConfig;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.direct.result.bean.DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス 顧客管理 仮パスワード通知作成クラス
 */
public class DsKariPasswordTuutiSakuseiBatch implements Batch {

    private final String YUUBINNO = "５４０－８７２０";

    private final String YUUBINSAKIADR = "大阪東郵便局私書箱第１７３号";

    private final String SYOUKAIFREEAREA1 = "【ご照会先】　スミセイコールセンター";

    private final String SYOUKAIFREEAREA2 = "通話料無料　℡０１２０－５０６０８１";

    private final String SYOUKAIFREEAREA3 = "";

    private final String SYOUKAIFREEAREA4 = "〒５４０－８５１２";

    private final String SYOUKAIFREEAREA5 = "大阪市中央区城見　１－４－３５";

    private final String FREEAREA1 = "いつもお引立てをいただきありがとうございます。";

    private final String FREEAREA2 = "お申し込みいただきましたスミセイダイレクトサービスのご利用に";

    private final String FREEAREA3 = "必要な仮パスワードをお知らせいたします。";

    private final String FREEAREA4 = "本はがきに記載の手順に沿って、ご希望のパスワードを簡単に";

    private final String FREEAREA5 = "ご登録いただけますので、是非ご登録をお願いいたします。";

    private final String TYUUIJIKOU1 = "";

    private final String TYUUIJIKOU2 = "";

    private final String TYUUIJIKOU3 = "";

    private final String TYUUIJIKOU4 = "";

    private final String TYUUIJIKOU5 = "";

    private final String TYUUIJIKOU6 = "";

    private final String TYUUIJIKOU7 = "";

    private final String DSKOKNOPAKUN = "^\\d{10}$";

    private final String DENWABANGOUPAKUN = "^\\d{10,11}$";

    private final String DSKRPASSWORDPAKUN = "^\\d{4}$";

    private final int RETRYKAISUU = 10;

    private final int ZENKETAINSUU = 1111;

    private final int TUUTI_SHIFT_DAYS = -3;


    @Inject
    private BatchLogger batchLogger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private CreateReport createReport;

    private long syoriKensuu = 0;

    private long syorinasiKensuu = 0;

    private BizDate syoriYmd;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        kariPasswordTuutiSakusei();

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(syoriKensuu)));

        if (syorinasiKensuu > 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IMA1009, String.valueOf(syorinasiKensuu)));
        }
    }

    private void kariPasswordTuutiSakusei() {

        String sysTime = BizDate.getSysDateTimeMilli();
        long sakuseiNo = 1;
        HozenKeiyakuIdouJyoutaiSyutoku keiyakuIdouJyoutaiSyutoku =
            SWAKInjector.getInstance(HozenKeiyakuIdouJyoutaiSyutoku.class);
        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);
        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
        DsKokyakunoScrambleSyori dsKokyakunoScrambleSyori = SWAKInjector.getInstance(DsKokyakunoScrambleSyori.class);
        YuyuDirectConfig config = YuyuDirectConfig.getInstance();
        DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl =
            SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);
        DsTetudukiRirekiTableEdit editDSTtdkRirekiTbl = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);


        BizDate tuutiConditionsDate = bzBatchParam.getSyoriYmd().addBusinessDays(TUUTI_SHIFT_DAYS);

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> dsKokyakuKanriLst =
            directDomManager. getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn.YOU, tuutiConditionsDate);
            EntityInserter<MT_BAK_DsKokyakuKanri> bakDsKokyakuKanriInserter = new EntityInserter<>();
            EntityInserter<ZT_DsKariPasswordTuutiTy> dsKariPasswordTuutiTyInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutiRirekiMeisaiHokanInserter = new EntityInserter<>();) {

            for (MT_DsKokyakuKanri dsKokyakuKanri : dsKokyakuKanriLst) {

                String syoNo = "";
                String dskrhnnkakCd = "";
                boolean taisyougaiFlg = false;
                String dskokNo = dsKokyakuKanri.getDskokno();
                C_DsKrHnnKakCdTtTydnJyKbn tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.BLNK;

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuLst) {

                    if (C_MukouHyj.MUKOU.eq(dsKokyakuKeiyaku.getDskykmukouhyj())) {

                        continue;
                    }

                    syoNo = dsKokyakuKeiyaku.getSyono();

                    HozenKeiyakuIdouJyoutaiSyutokuBean hozenKeiyakuIdouJyoutaiSyutokuBean =
                        keiyakuIdouJyoutaiSyutoku.hozenKeiyakuIdouJyoutaiSyutoku(syoNo);
                    C_IdoutyuuHanteiKekkaKbn idoutyuuHanteiKekkaKbn =
                        hozenKeiyakuIdouJyoutaiSyutokuBean.getIdoutyuuKbn();
                    C_UmuKbn yotenSouiUmuKbn = hozenKeiyakuIdouJyoutaiSyutokuBean.getYotenSouiUmuKbn();
                    C_UmuKbn juushoHenkouUmuKbn = hozenKeiyakuIdouJyoutaiSyutokuBean.getJuushoHenkouUmuKbn();
                    C_UmuKbn meigiHenkouUmuKbn = hozenKeiyakuIdouJyoutaiSyutokuBean.getMeigiHenkouUmuKbn();
                    C_UmuKbn srJuushoHenkouUmuKbn = hozenKeiyakuIdouJyoutaiSyutokuBean.getSrJuushoHenkouUmuKbn();
                    C_UmuKbn srMeigiHenkouUmuKbn = hozenKeiyakuIdouJyoutaiSyutokuBean.getSrMeigiHenkouUmuKbn();

                    if (C_IdoutyuuHanteiKekkaKbn.ERROR.eq(idoutyuuHanteiKekkaKbn)) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                            MessageUtil.getMessage(MessageId.EMW1008)));

                    }
                    else if (C_IdoutyuuHanteiKekkaKbn.IDOUTYUU.eq(idoutyuuHanteiKekkaKbn)) {

                        taisyougaiFlg = true;

                        tydnJyKbn = dsKrPasswordTuutiSakuseiTydnJySettei(
                            yotenSouiUmuKbn, juushoHenkouUmuKbn, meigiHenkouUmuKbn,
                            srJuushoHenkouUmuKbn, srMeigiHenkouUmuKbn);

                        break;
                    }
                }

                if (BizUtil.isBlank(syoNo)) {

                    continue;
                }

                String dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(
                    dskokNo, dsHenkouSikibetukey);
                if (bakDsKokyakuKanri == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMA1009, dskokNo));
                }

                MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();
                if (dsHonninKakuninCd == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0004,
                        MT_DsHonninKakuninCd.TABLE_NAME, MT_DsHonninKakuninCd.DSKOKNO, dskokNo));
                }

                if (taisyougaiFlg) {

                    dsHonninKakuninCd.setDskrhnnkakcdttshjyhsymd(syoriYmd);
                    dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
                    dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(tydnJyKbn);
                    dsHonninKakuninCd.setGyoumuKousinKinou(kinou.getKinouId());
                    dsHonninKakuninCd.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    dsHonninKakuninCd.setGyoumuKousinTime(sysTime);
                }
                else {
                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);

                    IT_KykSya kykSya = null;

                    try {
                        kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);

                        kykSya = kykKihon.getKykSya();
                    }
                    catch (EntityNotFoundException e) {
                    }
                    catch (NullPointerException e) {
                    }

                    if (kykKihon == null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0004,
                            IT_KykKihon.TABLE_NAME, IT_KykKihon.SYONO, syoNo));
                    }

                    if (kykSya == null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0004,
                            IT_KykSya.TABLE_NAME, IT_KykSya.SYONO, syoNo));
                    }

                    DsKrHonninKakuninCdBean dsKrHonninKakuninCdBean = dsKrHonninKakuninCdSettei(dskokNo,
                        dsKokyakuKanri.getDskokyakuseiymd(),
                        kykSya.getTsintelno(),
                        dsHonninKakuninCd.getZenkaidskrhnnkakcd(),
                        syoriYmd);

                    dskrhnnkakCd = dsKrHonninKakuninCdBean.getDsKrHnnKakCd();
                    String dsKariPasswordYoken = dsKrHonninKakuninCdBean.getDsKariPasswordYoken();

                    String scrambleDskokNo = dsKokyakunoScrambleSyori.exec(dskokNo);

                    BizDate ztyKrpasswordyuukouYmd =
                        syoriYmd.addYears(config.getDsKrHnnKakCdYuukouKikan()).getRekijyou();

                    if (!ztyKrpasswordyuukouYmd.isBusinessDay()) {
                        ztyKrpasswordyuukouYmd = ztyKrpasswordyuukouYmd.getBusinessDay(CHolidayAdjustingMode.NEXT);
                    }

                    ZT_DsKariPasswordTuutiTy dsKariPasswordTuutiTy = new ZT_DsKariPasswordTuutiTy();
                    dsKariPasswordTuutiTy.setZtykrpasswordtuutikey(
                        syoriYmd.toString().concat(Strings.padStart(
                            String.valueOf(sakuseiNo), 7, '0')));

                    dsKariPasswordTuutiTy.setZtydskokno(dskokNo);

                    dsKariPasswordTuutiTy.setZtyatesakiyno(ConvertUtil.convZenHan(
                        IDataConvert.iCONVERT_H2Z_ALL, BizUtil.editYno(kykSya.getTsinyno())));

                    dsKariPasswordTuutiTy.setZtysakuseimd(
                        syoriYmd.getBizDateMD().toString());
                    dsKariPasswordTuutiTy.setZtysclakadskokno(scrambleDskokNo);
                    dsKariPasswordTuutiTy.setZtyreigaisyorihyj("0");
                    dsKariPasswordTuutiTy.setZtyyuubinbutukanpusakiyno(YUUBINNO);
                    dsKariPasswordTuutiTy.setZtyyuubinbutukanpusakiadr(YUUBINSAKIADR);
                    dsKariPasswordTuutiTy.setZtyatesakiadr1(kykSya.getTsinadr1kj());
                    dsKariPasswordTuutiTy.setZtyatesakiadr2(kykSya.getTsinadr2kj());
                    dsKariPasswordTuutiTy.setZtyatesakiadr3(kykSya.getTsinadr3kj());
                    dsKariPasswordTuutiTy.setZtyatena1(kykSya.getKyknmkj());
                    dsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea1(SYOUKAIFREEAREA1);
                    dsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea2(SYOUKAIFREEAREA2);
                    dsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea3(SYOUKAIFREEAREA3);
                    dsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea4(SYOUKAIFREEAREA4);
                    dsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea5(SYOUKAIFREEAREA5);
                    dsKariPasswordTuutiTy.setZtysakuseino(Strings.padStart(
                        String.valueOf(sakuseiNo), 7, '0'));
                    dsKariPasswordTuutiTy.setZtyokyakusamanm(kykSya.getKyknmkj());
                    dsKariPasswordTuutiTy.setZtyhkymd(ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                        DateFormatUtil.dateKANJISeirekiNoZero(syoriYmd)));
                    dsKariPasswordTuutiTy.setZtydskrhnnkakcdyoken(dsKariPasswordYoken);
                    dsKariPasswordTuutiTy.setZtykrpasswordyuukouymd(ConvertUtil.convZenHan(
                        IDataConvert.iCONVERT_H2Z_ALL, DateFormatUtil.dateKANJISeirekiNoZero(ztyKrpasswordyuukouYmd)));
                    dsKariPasswordTuutiTy.setZtyfreearea1(FREEAREA1);
                    dsKariPasswordTuutiTy.setZtyfreearea2(FREEAREA2);
                    dsKariPasswordTuutiTy.setZtyfreearea3(FREEAREA3);
                    dsKariPasswordTuutiTy.setZtyfreearea4(FREEAREA4);
                    dsKariPasswordTuutiTy.setZtyfreearea5(FREEAREA5);
                    dsKariPasswordTuutiTy.setZtytyuuijikou1(TYUUIJIKOU1);
                    dsKariPasswordTuutiTy.setZtytyuuijikou2(TYUUIJIKOU2);
                    dsKariPasswordTuutiTy.setZtytyuuijikou3(TYUUIJIKOU3);
                    dsKariPasswordTuutiTy.setZtytyuuijikou4(TYUUIJIKOU4);
                    dsKariPasswordTuutiTy.setZtytyuuijikou5(TYUUIJIKOU5);
                    dsKariPasswordTuutiTy.setZtytyuuijikou6(TYUUIJIKOU6);
                    dsKariPasswordTuutiTy.setZtytyuuijikou7(TYUUIJIKOU7);

                    BizPropertyInitializer.initialize(dsKariPasswordTuutiTy);
                    dsKariPasswordTuutiTyInserter.add(dsKariPasswordTuutiTy);

                    dsHonninKakuninCd.setDskrhnnkakcd(dskrhnnkakCd);
                    dsHonninKakuninCd.setDskrhnnkakcdsetymd(syoriYmd);
                    dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(ztyKrpasswordyuukouYmd);
                    dsHonninKakuninCd.setZenkaidskrhnnkakcd(dskrhnnkakCd);
                    dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.BLNK);
                    dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.BLNK);
                    dsHonninKakuninCd.setGyoumuKousinKinou(kinou.getKinouId());
                    dsHonninKakuninCd.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    dsHonninKakuninCd.setGyoumuKousinTime(sysTime);

                    BT_TuutirirekiMeisaiHokan tuutiRirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                    tuutiRirekiMeisaiHokan.setTuutirirekirenno(RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue())));
                    tuutiRirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.DSKOKYAKUNO.getValue() + "0" + dsKokyakuKanri.getDskokno());
                    tuutiRirekiMeisaiHokan.setTuutisakuseiymd(syoriYmd);
                    tuutiRirekiMeisaiHokan.setTuutisakuseino(0);
                    tuutiRirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                    tuutiRirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYmd);

                    BizPropertyInitializer.initialize(tuutiRirekiMeisaiHokan);

                    tuutiRirekiMeisaiHokanInserter.add(tuutiRirekiMeisaiHokan);

                    syoriKensuu++;
                    sakuseiNo++;
                }

                dsTetudukiRirekiTableEditParamImpl.setDskokno(dskokNo);
                dsTetudukiRirekiTableEditParamImpl.setDsKokyakuKanri(dsKokyakuKanri);
                dsTetudukiRirekiTableEditParamImpl.setBakDsKokyakuKanri(bakDsKokyakuKanri);
                dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(dsHenkouSikibetukey);
                dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(syoriYmd);
                dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(C_DsSyoriKbn.KR_PASSWORD_TUUTI_SAKUSEI);
                dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParamImpl);

                bakDsKokyakuKanriInserter.add(bakDsKokyakuKanri);
            }
        }

        List<IReportDataSouceBean> dsKaripwtuutiTyuudanListDataSourceBeanLst =
            new ArrayList<>();
        DsKaripwtuutiTyuudanListBean dsKaripwtuutiTyuudanListBean =
            SWAKInjector.getInstance(DsKaripwtuutiTyuudanListBean.class);

        try (ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean>  dsKokKnrInfosLst =
            directDomManager.getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(syoriYmd);) {
            for (DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean dsKokKnrInfo : dsKokKnrInfosLst) {
                syorinasiKensuu++;
                MT_DsKokyakuKanri dsKokyakuKanri = dsKokKnrInfo.getMT_DsKokyakuKanri();
                MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();

                DsKaripwtuutiTyuudanListDataSourceBean dsKaripwtuutiTyuudanListDataSourceBean =
                    SWAKInjector.getInstance(DsKaripwtuutiTyuudanListDataSourceBean.class);

                dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokno(dsHonninKakuninCd.getDskokno());
                dsKaripwtuutiTyuudanListDataSourceBean.setIrDskokyakunmkj(dsKokyakuKanri.getDskokyakunmkj());
                dsKaripwtuutiTyuudanListDataSourceBean.setIrDskrhnnkakcdtttydnjykbn(
                    dsHonninKakuninCd.getDskrhnnkakcdtttydnjykbn());
                dsKaripwtuutiTyuudanListDataSourceBean.setIrMemo("");
                dsKaripwtuutiTyuudanListDataSourceBeanLst.add(dsKaripwtuutiTyuudanListDataSourceBean);
            }
        }

        String syoriYmdSeireki = DateFormatUtil.dateKANJISeirekiNoZero(syoriYmd);
        dsKaripwtuutiTyuudanListBean.setIrSakuseiymd(syoriYmdSeireki);
        dsKaripwtuutiTyuudanListBean.setIrKensuu((int)syorinasiKensuu);

        ReportServicesBean serviceBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.DS_KARIPWTUUTITYUUDANLIST);

        serviceBean.addParamObjects(dsKaripwtuutiTyuudanListDataSourceBeanLst, dsKaripwtuutiTyuudanListBean);
        serviceBean.setSyoriYmd(syoriYmd);

        createReport.execNoCommit(serviceBean);
    }

    private C_DsKrHnnKakCdTtTydnJyKbn dsKrPasswordTuutiSakuseiTydnJySettei(
        C_UmuKbn pYotenSouiUmuKbn, C_UmuKbn pJuushoHenkouUmuKbn, C_UmuKbn pMeigiHenkouUmuKbn,
        C_UmuKbn pSrJuushoHenkouUmuKbn, C_UmuKbn pSrMeigiHenkouUmuKbn) {

        C_DsKrHnnKakCdTtTydnJyKbn tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.BLNK;

        if (C_UmuKbn.ARI.eq(pYotenSouiUmuKbn)) {
            if (C_UmuKbn.ARI.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS;
            }
            else if (C_UmuKbn.ARI.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS;
            }
            else if (C_UmuKbn.ARI.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS_JSHT;
            }
            else if (C_UmuKbn.ARI.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGS_JSHT_MGHT;
            }
            else if (C_UmuKbn.ARI.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_JSHT;
            }
            else if (C_UmuKbn.ARI.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_JSHT_MGHT;
            }
            else if (C_UmuKbn.ARI.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSS_MGHT;
            }
            else if (C_UmuKbn.NONE.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_MGS;
            }
            else if (C_UmuKbn.NONE.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_MGS_JSHT;
            }
            else if (C_UmuKbn.NONE.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_MGS_JSHT_MGHT;
            }
            else if (C_UmuKbn.NONE.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSHT;
            }
            else if (C_UmuKbn.NONE.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_JSHT_MGHT;
            }
            else if (C_UmuKbn.NONE.eq(pJuushoHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pMeigiHenkouUmuKbn) &&
                C_UmuKbn.NONE.eq(pSrJuushoHenkouUmuKbn) &&
                C_UmuKbn.ARI.eq(pSrMeigiHenkouUmuKbn)) {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.NYSHK_MGHT;
            }
            else {

                tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.BLNK;
            }
        }
        else {

            tydnJyKbn = C_DsKrHnnKakCdTtTydnJyKbn.BLNK;
        }

        return tydnJyKbn;
    }

    private DsKrHonninKakuninCdBean dsKrHonninKakuninCdSettei(String pDskokNo, BizDate pSeiymd, String pDenwabangou,
        String pZenkaidskrhnnkakcd, BizDate pHakkubi) {

        DsKrHonninKakuninCdBean dsKrHonninKakuninCdBean = SWAKInjector.getInstance(DsKrHonninKakuninCdBean.class);
        DsKariHonninKakuninCdScrambleSyori dsKariHonninKakuninCdScrambleSyori = SWAKInjector.getInstance(
            DsKariHonninKakuninCdScrambleSyori.class);

        if (BizUtil.isBlank(pDskokNo) ||
            pSeiymd == null ||
            BizUtil.isBlank(pDenwabangou) ||
            pHakkubi == null) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                MessageUtil.getMessage(MessageId.EMW1010)));
        }


        boolean hanteiHekka = pDskokNo.matches(DSKOKNOPAKUN);

        if (!hanteiHekka) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                MessageUtil.getMessage(MessageId.EMW1010)));
        }


        String denwaBangou = pDenwabangou.replace("-", "");
        hanteiHekka = denwaBangou.matches(DENWABANGOUPAKUN);
        if (!hanteiHekka) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                MessageUtil.getMessage(MessageId.EMW1010)));
        }

        int yoKen = (Integer.parseInt(String.valueOf(pHakkubi.getBizDateMD())) +
            Integer.parseInt(pDskokNo.substring(pDskokNo.length() - 4, pDskokNo.length()))) % 10000;

        for (int n = 0; n <= RETRYKAISUU - 1; n++) {

            String dskrPassword = dsKariHonninKakuninCdScrambleSyori.exec(Strings.padStart(String.valueOf(yoKen), 4,
                '0'));

            String dsKrHonninKakuninCd = dsKariHonninKakuninCdScrambleSyori.exec(dskrPassword);

            if (pZenkaidskrhnnkakcd != null && pZenkaidskrhnnkakcd.equals(dsKrHonninKakuninCd)) {

                yoKen++;

                continue;
            }


            boolean checkKekka = dsKrPasswordZokuseiBangouCheck(dskrPassword, pSeiymd, denwaBangou);
            if (!checkKekka) {

                yoKen = (yoKen + 1) % 10000;

                continue;
            }

            dsKrHonninKakuninCdBean.setDsKariPasswordYoken(Strings.padStart(String.valueOf(yoKen), 4, '0'));
            dsKrHonninKakuninCdBean.setDsKrHnnKakCd(dsKrHonninKakuninCd);

            return dsKrHonninKakuninCdBean;
        }

        throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
            MessageUtil.getMessage(MessageId.EMW1010)));
    }

    private boolean dsKrPasswordZokuseiBangouCheck(String pDskrPassword, BizDate pSeiymd, String pDenwabangou) {


        boolean hanteiHekka = pDskrPassword.matches(DSKRPASSWORDPAKUN);
        if (!hanteiHekka) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                MessageUtil.getMessage(MessageId.EMW1010)));
        }


        if (pSeiymd == null) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                MessageUtil.getMessage(MessageId.EMW1010)));
        }

        hanteiHekka = pDenwabangou.matches(DENWABANGOUPAKUN);
        if (!hanteiHekka) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                MessageUtil.getMessage(MessageId.EMW1010)));

        }

        String nenSeireki = String.valueOf(pSeiymd.getYear());
        String nenSeirekiNiketa = nenSeireki.substring(2, 4);
        String nenWareki = new BizDateFormat("Gyy", FillStyle.Zero).format(pSeiymd).toString().substring(1, 3);
        String tukiStr = pSeiymd.toString().substring(4, 6);
        String nichiStr = pSeiymd.toString().substring(6, 8);
        String tukinichiStr = tukiStr.substring(1, 2) + nichiStr.substring(1, 2);

        List<String> patternLst = new ArrayList<>();
        patternLst.add(nenWareki + tukiStr);
        patternLst.add(nenWareki + tukinichiStr);
        patternLst.add(tukiStr + nichiStr);
        patternLst.add(nenWareki + nichiStr);
        patternLst.add(tukiStr + nenWareki);
        patternLst.add(nichiStr + tukiStr);
        patternLst.add(nichiStr + nenWareki);
        patternLst.add(tukinichiStr + nenWareki);
        patternLst.add(nenSeireki);
        patternLst.add(nenSeirekiNiketa + tukinichiStr);
        patternLst.add(nenSeirekiNiketa + nichiStr);
        patternLst.add(nenSeirekiNiketa + tukiStr);
        patternLst.add(pDenwabangou.substring(pDenwabangou.length() - 4, pDenwabangou.length()));

        int checkKekka = Integer.parseInt(pDskrPassword) % ZENKETAINSUU;

        if (checkKekka == 0) {

            return false;
        }

        for (int n = 0; n < patternLst.size(); n++) {

            if (pDskrPassword.equals(patternLst.get(n))) {

                return false;
            }
        }
        return true;
    }
}
