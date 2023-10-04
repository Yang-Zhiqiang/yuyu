package yuyu.batch.hozen.khozen.khdhanei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khdhanei.dba.KhDHaneiDao;
import yuyu.batch.hozen.khozen.khdhanei.dba.KhHaitouTaisyouWKBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.haitou.CheckDSeigou;
import yuyu.common.hozen.haitou.DBAccessDCommon;
import yuyu.common.hozen.haitou.HaitouDetachProcess;
import yuyu.common.hozen.haitou.KeisanD;
import yuyu.common.hozen.haitou.KeisanDBean;
import yuyu.common.hozen.haitou.KeisanDGanrikin;
import yuyu.common.hozen.haitou.SetDNnd;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.hozen.khcommon.SetKhDshrTukiKykInfo;
import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSks;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 配当金反映
 */
public class KhDHaneiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhDHaneiDao khDHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private static final String TYSYTTAISYOU_TABLE_ID = "IW_KhHaitouTaisyouWK";

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private Set<HaitouDetachProcess> haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();

    private Set<HaitouDetachProcess> haitouDetachProcessOutLoopSet = new HashSet<HaitouDetachProcess>();

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kinouId = khozenCommonParam.getFunctionId();
        String kousinsyaId = khozenCommonParam.getUserID();
        String kousinTime = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), syoriYmd.toString()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ibKakutyoujobcd));

        try (ExDBResults<KhHaitouTaisyouWKBean> khHaitouTaisyouWKBeanLst =
            khDHaneiDao.getKhHaitouTaisyouWKByKakutyoujobcdSyoriYmd(ibKakutyoujobcd, syoriYmd);
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

            long htkinHaneiInputKensuu = 0;
            long haitouKanriOutKensuu = 0;
            long keiyakuKihonKosKensuu = 0;
            long khDshrtoukeiOutKensuu = 0;
            long missListOutKensuu = 0;
            long tumitateDKanriOutKensuu = 0;
            List<EditKhMisslstParam> editKhMisslstParamLst = new ArrayList<>();

            for (KhHaitouTaisyouWKBean khHaitouTaisyouWKBean : khHaitouTaisyouWKBeanLst) {

                String syono = khHaitouTaisyouWKBean.getSyono();
                C_HaitoujyoutaiHanteiKbn haitouJyoutaiHanteiKbn = khHaitouTaisyouWKBean.getHaitouJyoutaiHanteiKbn();
                BizDate haitoushrKijyunYmd = khHaitouTaisyouWKBean.getHaitoushrKijyunYmd();
                BizDate kykymd = khHaitouTaisyouWKBean.getKykymd();
                String syouhnCd = khHaitouTaisyouWKBean.getSyouhnCd();
                String ryourituSdno = khHaitouTaisyouWKBean.getRyourituSdno();
                BizNumber yoteiRiritu = khHaitouTaisyouWKBean.getYoteiRiritu();
                C_Hrkkaisuu hrkKaisuu = khHaitouTaisyouWKBean.getHrkKaisuu();
                C_Hhknsei hhknsei = khHaitouTaisyouWKBean.getHhknSei();
                Integer hhknNen = khHaitouTaisyouWKBean.getHhknNen();
                C_HknkknsmnKbn hknkknsmnKbn = khHaitouTaisyouWKBean.getHknKknSmnKbn();
                Integer hknKkn = khHaitouTaisyouWKBean.getHknKkn();
                Integer hrkKkn = khHaitouTaisyouWKBean.getHrkKkn();
                C_Kykjyoutai kykjyoutai = khHaitouTaisyouWKBean.getKykjyoutai();
                C_HrkkknsmnKbn hrkkknsmnkbn = khHaitouTaisyouWKBean.getHrkkknsmnkbn();
                Integer dai1hknkkn = khHaitouTaisyouWKBean.getDai1hknkkn();
                C_Tuukasyu tuukasyu = khHaitouTaisyouWKBean.getTuukasyu();
                BizCurrency kihonS = khHaitouTaisyouWKBean.getKihonS();

                C_UmuKbn seisikiwariateSksUmu = C_UmuKbn.NONE;
                BizDateY fstKariwariateDNendo = BizDateY.valueOf(0);
                BizCurrency tounendoD = BizCurrency.valueOf(0);
                int circlenaiHaitouKaisuu = 0;
                int tumitateNensuu = 0;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHaitouTaisyouWKBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                htkinHaneiInputKensuu++;

                BizDate yendthnkymd;
                if (BizDateUtil.compareYmd(haitoushrKijyunYmd, kykymd) != BizDateUtil.COMPARE_EQUAL) {

                    yendthnkymd = haitoushrKijyunYmd;
                }
                else {
                    yendthnkymd = null;
                }
                IT_KykKihon kykKihon = null;
                IT_KhHaitouKanri khHaitouKanri = null;
                IT_KhTumitateDKanri khTumitateDKanri = null;
                if (C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN2.eq(haitouJyoutaiHanteiKbn) ||
                    C_HaitoujyoutaiHanteiKbn.MF_HUSEIGOU.eq(haitouJyoutaiHanteiKbn)) {

                    missListOutKensuu = editMissList((int) missListOutKensuu, syono,
                        C_Dbhanei.NONE, haitouJyoutaiHanteiKbn.getContent(), editKhMisslstParamLst);

                    detach(kykKihon, khHaitouKanri, khTumitateDKanri);

                    continue;
                }

                DBAccessDCommon dBAccessDCommon = getInjectInstanceForInLoop(DBAccessDCommon.class);

                C_ErrorKbn errorKbn = dBAccessDCommon.getSaisinHaitouKanriSyu(syono);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        khozenCommonParam.getKinouNm()));
                }
                khHaitouKanri = dBAccessDCommon.getKhHaitouKanri();

                if (khHaitouKanri == null) {
                    fstKariwariateDNendo = khHaitouTaisyouWKBean.getKeisanDNendo();
                }
                else {
                    C_HaitoukinsksKbn haitoukinSksKbn = khHaitouKanri.getHaitoukinskskbn();

                    if (C_HaitoukinsksKbn.SEISIKI.eq(haitoukinSksKbn) ||
                        C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(haitoukinSksKbn)) {

                        fstKariwariateDNendo = khHaitouTaisyouWKBean.getKeisanDNendo();
                    }
                    else {
                        fstKariwariateDNendo = khHaitouKanri.getFstkariwariatednendo();
                    }
                }

                seisikiwariateSksUmu = C_UmuKbn.NONE;
                circlenaiHaitouKaisuu = khHaitouTaisyouWKBean.getKeisanDNendo().getYear()
                    - fstKariwariateDNendo.getYear();

                if (C_HaitouKbn.RISAHAI.eq(khHaitouTaisyouWKBean.getHaitouKbn())) {
                    tumitateNensuu = 5;
                }

                kykKihon = hozenDomManager.getKykKihon(syono);

                CheckDSeigou checkDSeigou = getInjectInstanceForInLoop(CheckDSeigou.class);

                errorKbn = checkDSeigou.exec(syono, kykKihon.getHaitounendo(), kykymd, yendthnkymd, syoriYmd);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        khozenCommonParam.getKinouNm()));
                }

                C_UmuKbn umuKbn = checkDSeigou.getDHuseigouUmu();

                if (C_UmuKbn.ARI.eq(umuKbn)) {

                    missListOutKensuu = editMissList((int) missListOutKensuu, syono,
                        C_Dbhanei.NONE, C_HaitoujyoutaiHanteiKbn.MF_HUSEIGOU.getContent(), editKhMisslstParamLst);

                    detach(kykKihon, khHaitouKanri, khTumitateDKanri);

                    continue;
                }

                if (circlenaiHaitouKaisuu == tumitateNensuu - 1) {

                    seisikiwariateSksUmu = C_UmuKbn.ARI;
                }

                if (C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN1.eq(haitouJyoutaiHanteiKbn)) {

                    missListOutKensuu = editMissList((int) missListOutKensuu, syono,
                        C_Dbhanei.SUMI, C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN1.getContent(), editKhMisslstParamLst);
                }

                BizDate wKariwariatedshrymd = getKariwariatedshrymd(khHaitouTaisyouWKBean.getKeisanDNendo(),
                    khHaitouTaisyouWKBean.getHaitoushrKijyunYmd());

                BizDateY zenkaiHaitouNendo;
                if (khHaitouKanri == null) {
                    SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
                    zenkaiHaitouNendo  = setKessanNensibi.exec(kykymd).getBizDateY();
                } else {
                    zenkaiHaitouNendo = khHaitouKanri.getHaitounendo();
                }
                SetDNnd setDNnd = getInjectInstanceForInLoop(SetDNnd.class);

                DRateBean dRateBean = setDNnd.exec(syouhnCd,
                    ryourituSdno,
                    yoteiRiritu,
                    hrkKaisuu,
                    hhknsei,
                    hhknNen,
                    hknkknsmnKbn,
                    hknKkn,
                    hrkKkn,
                    kykjyoutai,
                    hrkkknsmnkbn,
                    tuukasyu,
                    dai1hknkkn,
                    wKariwariatedshrymd,
                    kykymd,
                    yendthnkymd,
                    zenkaiHaitouNendo,
                    wKariwariatedshrymd,
                    syoriYmd,
                    C_UmuKbn.NONE);

                if (dRateBean == null) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        khozenCommonParam.getKinouNm()));
                }

                KeisanD keisanD = getInjectInstanceForInLoop(KeisanD.class);
                KeisanDBean keisanDBean = SWAKInjector.getInstance(KeisanDBean.class);

                keisanDBean.setDRateSyutokuInfoBean(dRateBean.getDRateSyutokuInfoBean());
                keisanDBean.setTuukasyu(tuukasyu);
                keisanDBean.setKihonS(kihonS);
                keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);
                keisanDBean.setHaitouKaisuuBeanList(dRateBean.getHaitouKaisuuBeanLst());

                errorKbn = keisanD.exec(keisanDBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        khozenCommonParam.getKinouNm()));
                }

                KeisanDGanrikin keisanDGanrikin = getInjectInstanceForInLoop(KeisanDGanrikin.class);
                BizCurrency kariwariatedGanrikin;
                if (khHaitouKanri != null) {
                    errorKbn = keisanDGanrikin.exec(khHaitouKanri,
                        wKariwariatedshrymd,
                        kykymd,
                        yendthnkymd,
                        syoriYmd,
                        C_UmuKbn.NONE);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                            khozenCommonParam.getKinouNm()));
                    }
                    kariwariatedGanrikin = keisanDGanrikin.getDGanrikin();
                }
                else {
                    kariwariatedGanrikin = BizCurrency.valueOf(0);
                }

                BizCurrency tumitateDGanrikin = BizCurrency.valueOf(0);
                errorKbn = dBAccessDCommon.getSaisinTumitateDKanri(syono);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        khozenCommonParam.getKinouNm()));
                }

                khTumitateDKanri = dBAccessDCommon.getKhTumitateDKanri();

                if (khTumitateDKanri != null) {

                    errorKbn =  keisanDGanrikin.exec(khTumitateDKanri,
                        wKariwariatedshrymd,
                        kykymd,
                        yendthnkymd,
                        syoriYmd,
                        C_UmuKbn.NONE);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                            khozenCommonParam.getKinouNm()));
                    }
                    tumitateDGanrikin = keisanDGanrikin.getDGanrikin();
                }

                BizDateY haitouNendo = khHaitouTaisyouWKBean.getKeisanDNendo();
                int renno = 0;
                C_HaitoukinsksKbn haitoukinSksKbn = C_HaitoukinsksKbn.BLNK;
                C_HaitoumeisaiKbn haitouMeisaiKbn = khHaitouTaisyouWKBean.getHaitouMeisaiKbn();

                if (khHaitouKanri != null && khHaitouKanri.getHaitounendo().compareTo(haitouNendo) == 0) {

                    renno = khHaitouKanri.getRenno() + 1;
                }
                else {

                    renno = 1;
                }

                if (circlenaiHaitouKaisuu == 0) {
                    haitoukinSksKbn = C_HaitoukinsksKbn.KARIWARIATE1;
                }
                else if (circlenaiHaitouKaisuu == 1) {
                    haitoukinSksKbn = C_HaitoukinsksKbn.KARIWARIATE2;
                }
                else if (circlenaiHaitouKaisuu == 2) {
                    haitoukinSksKbn = C_HaitoukinsksKbn.KARIWARIATE3;
                }
                else if (circlenaiHaitouKaisuu == 3) {
                    haitoukinSksKbn = C_HaitoukinsksKbn.KARIWARIATE4;
                }
                else if (circlenaiHaitouKaisuu == 4) {
                    haitoukinSksKbn = C_HaitoukinsksKbn.KARIWARIATE5;
                }

                if (khHaitouKanri == null || C_HaitoukinsksKbn.SEISIKI.eq(khHaitouKanri.getHaitoukinskskbn()) ||
                    C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(khHaitouKanri.getHaitoukinskskbn())) {

                    fstKariwariateDNendo = haitouNendo;
                }
                else {
                    fstKariwariateDNendo = khHaitouKanri.getFstkariwariatednendo();
                }

                IT_KhHaitouKanri kariwariateKhHaitouKanri = new IT_KhHaitouKanri(syono, haitouNendo,
                    renno, haitoukinSksKbn, haitouMeisaiKbn);

                kariwariateKhHaitouKanri.setFstkariwariatednendo(fstKariwariateDNendo);
                kariwariateKhHaitouKanri.setTounendod(keisanD.getD());
                kariwariateKhHaitouKanri.setNaiteikakuteikbn(keisanD.getDRateSyutokuInfoBean().getNaiteikakuteikbn());
                kariwariateKhHaitouKanri.setKariwariatedshrymd(wKariwariatedshrymd);
                kariwariateKhHaitouKanri.setKariwariatedruigk(kariwariatedGanrikin.add(keisanD.getD()));
                kariwariateKhHaitouKanri.setKariwariatedgngkkngk(BizCurrency.optional());
                kariwariateKhHaitouKanri.setKariwariatedshrgk(BizCurrency.optional());
                kariwariateKhHaitouKanri.setGyoumuKousinKinou(kinouId);
                kariwariateKhHaitouKanri.setGyoumuKousinsyaId(kousinsyaId);
                kariwariateKhHaitouKanri.setGyoumuKousinTime(kousinTime);

                BizPropertyInitializer.initialize(kariwariateKhHaitouKanri);

                multipleEntityInserter.add(kariwariateKhHaitouKanri);

                haitouKanriOutKensuu++;

                IT_KhTumitateDKanri risokukuriireKhTumitateDKanri = null;
                if (khTumitateDKanri != null) {

                    if (BizDateUtil.compareYmd(khTumitateDKanri.getTumitatedtumitateymd(), wKariwariatedshrymd)
                        == BizDateUtil.COMPARE_EQUAL) {

                        renno = khTumitateDKanri.getRenno() + 1;
                    }
                    else {

                        renno = 1;
                    }

                    risokukuriireKhTumitateDKanri = new IT_KhTumitateDKanri(syono, wKariwariatedshrymd, renno);
                    risokukuriireKhTumitateDKanri.setTumitatedskskbn(C_TumitateDSakuseiKbn.RISOKUKURIIRE);
                    risokukuriireKhTumitateDKanri.setTumitated(tumitateDGanrikin);
                    risokukuriireKhTumitateDKanri.setGyoumuKousinKinou(kinouId);
                    risokukuriireKhTumitateDKanri.setGyoumuKousinsyaId(kousinsyaId);
                    risokukuriireKhTumitateDKanri.setGyoumuKousinTime(kousinTime);

                    BizPropertyInitializer.initialize(risokukuriireKhTumitateDKanri);

                    multipleEntityInserter.add(risokukuriireKhTumitateDKanri);

                    tumitateDKanriOutKensuu++;
                }


                if (C_UmuKbn.ARI.eq(seisikiwariateSksUmu)) {


                    if (C_NaiteiKakuteiKbn.KAKUTEI.eq(kariwariateKhHaitouKanri.getNaiteikakuteikbn())) {

                        if (kariwariateKhHaitouKanri.getKariwariatedruigk().compareTo(BizCurrency.valueOf(0,
                            kariwariateKhHaitouKanri.getKariwariatedruigk().getType())) > 0) {

                            tounendoD = kariwariateKhHaitouKanri.getKariwariatedruigk();

                        }
                        else {
                            tounendoD = BizCurrency.valueOf(0);
                        }
                    }
                    else if (C_NaiteiKakuteiKbn.NAITEI.eq(kariwariateKhHaitouKanri.getNaiteikakuteikbn())) {

                        tounendoD = BizCurrency.valueOf(0);
                    }

                    IT_KhHaitouKanri seisikiKhHaitouKanri = new IT_KhHaitouKanri(kariwariateKhHaitouKanri.getSyono(),
                        kariwariateKhHaitouKanri.getHaitounendo(),
                        kariwariateKhHaitouKanri.getRenno() + 1,
                        C_HaitoukinsksKbn.SEISIKI,
                        kariwariateKhHaitouKanri.getHaitoumeisaikbn());

                    seisikiKhHaitouKanri.setFstkariwariatednendo(kariwariateKhHaitouKanri.getFstkariwariatednendo());
                    seisikiKhHaitouKanri.setTounendod(tounendoD);
                    seisikiKhHaitouKanri.setNaiteikakuteikbn(kariwariateKhHaitouKanri.getNaiteikakuteikbn());
                    seisikiKhHaitouKanri.setKariwariatedshrymd(kariwariateKhHaitouKanri.getKariwariatedshrymd());
                    seisikiKhHaitouKanri.setKariwariatedruigk(BizCurrency.valueOf(0));
                    seisikiKhHaitouKanri.setKariwariatedgngkkngk(kariwariateKhHaitouKanri.getKariwariatedgngkkngk());
                    seisikiKhHaitouKanri.setKariwariatedshrgk(kariwariateKhHaitouKanri.getKariwariatedshrgk());
                    seisikiKhHaitouKanri.setGyoumuKousinKinou(kariwariateKhHaitouKanri.getGyoumuKousinKinou());
                    seisikiKhHaitouKanri.setGyoumuKousinsyaId(kariwariateKhHaitouKanri.getGyoumuKousinsyaId());
                    seisikiKhHaitouKanri.setGyoumuKousinTime(kariwariateKhHaitouKanri.getGyoumuKousinTime());

                    BizPropertyInitializer.initialize(seisikiKhHaitouKanri);

                    multipleEntityInserter.add(seisikiKhHaitouKanri);

                    haitouKanriOutKensuu++;

                    if (risokukuriireKhTumitateDKanri != null) {
                        renno = risokukuriireKhTumitateDKanri.getRenno() + 1;
                    }
                    else {
                        renno = 1;
                    }

                    IT_KhTumitateDKanri seisikiKhTumitateDKanri = new IT_KhTumitateDKanri(seisikiKhHaitouKanri.getSyono(),
                        seisikiKhHaitouKanri.getKariwariatedshrymd(),
                        renno);

                    seisikiKhTumitateDKanri.setTumitatedskskbn(C_TumitateDSakuseiKbn.SEISIKI);
                    seisikiKhTumitateDKanri.setTumitated(tumitateDGanrikin.add(seisikiKhHaitouKanri.getTounendod()));
                    seisikiKhTumitateDKanri.setNaiteikakuteikbn(seisikiKhHaitouKanri.getNaiteikakuteikbn());
                    seisikiKhTumitateDKanri.setGyoumuKousinKinou(seisikiKhHaitouKanri.getGyoumuKousinKinou());
                    seisikiKhTumitateDKanri.setGyoumuKousinsyaId(seisikiKhHaitouKanri.getGyoumuKousinsyaId());
                    seisikiKhTumitateDKanri.setGyoumuKousinTime(seisikiKhHaitouKanri.getGyoumuKousinTime());

                    BizPropertyInitializer.initialize(seisikiKhTumitateDKanri);

                    multipleEntityInserter.add(seisikiKhTumitateDKanri);

                    tumitateDKanriOutKensuu++;


                    if (C_NaiteiKakuteiKbn.KAKUTEI.eq(keisanD.getDRateSyutokuInfoBean().getNaiteikakuteikbn())) {

                        IT_KhDshrTuki khDshrTuki1 = editKhDshrTuki(kykKihon, khozenCommonParam, syoriYmd, 1,
                            kariwariateKhHaitouKanri, risokukuriireKhTumitateDKanri);

                        BizPropertyInitializer.initialize(khDshrTuki1);

                        multipleEntityInserter.add(khDshrTuki1);

                        khDshrtoukeiOutKensuu++;

                        IT_KhDshrTuki khDshrTuki2 = editKhDshrTuki(kykKihon, khozenCommonParam, syoriYmd, 2,
                            seisikiKhHaitouKanri, seisikiKhTumitateDKanri);

                        BizPropertyInitializer.initialize(khDshrTuki2);

                        multipleEntityInserter.add(khDshrTuki2);

                        khDshrtoukeiOutKensuu++;
                    }
                }

                kykKihon.setHaitounendo(haitouNendo);
                kykKihon.setSyhenkouymd(syoriYmd);
                kykKihon.setGyoumuKousinKinou(kinouId);
                kykKihon.setGyoumuKousinsyaId(kousinsyaId);
                kykKihon.setGyoumuKousinTime(kousinTime);

                multipleEntityUpdater.add(kykKihon);

                keiyakuKihonKosKensuu++;

                detach(kykKihon, khHaitouKanri, khTumitateDKanri);
            }

            if (editKhMisslstParamLst.size() > 0) {
                KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                khozenTyouhyouCtl.setEditKkMisslstParam(editKhMisslstParamLst);

                C_SyoruiCdKbn[] syoruiCdKbnLst = new C_SyoruiCdKbn[1];

                syoruiCdKbnLst[0] = C_SyoruiCdKbn.KK_DHANEI_MISSLIST;

                khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoruiCdKbnLst, C_YouhiKbn.YOU);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(htkinHaneiInputKensuu)));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(haitouKanriOutKensuu),
                "配当管理テーブル"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(tumitateDKanriOutKensuu),
                "積立Ｄ管理テーブル"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(keiyakuKihonKosKensuu),
                "契約基本テーブル"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(khDshrtoukeiOutKensuu),
                "契約保全Ｄ支払統計テーブル"));

            if (editKhMisslstParamLst.size() > 0) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "ミスリスト", String.valueOf(missListOutKensuu)));
            }
        }

    }

    private int editMissList(int pMissListOutKensuu, String pSyono, C_Dbhanei pDbhanei, String pMissListMsg,
        List<EditKhMisslstParam> pEditKhMisslstParamLst) {

        int missListOutKensuu = pMissListOutKensuu + 1;
        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

        editKhMisslstParam.setDataNo(missListOutKensuu);
        editKhMisslstParam.setSeqNo(missListOutKensuu);
        editKhMisslstParam.setMisslistMsg(pMissListMsg);
        editKhMisslstParam.setDBhaneikbn(pDbhanei);
        editKhMisslstParam.setSyoNo(pSyono);

        pEditKhMisslstParamLst.add(editKhMisslstParam);

        return missListOutKensuu;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    private BizDate getKariwariatedshrymd(BizDateY pKeisanDNendo, BizDate pHaitoushrKijyunYmd) {

        BizDateY wKariwariatedshrymdY;

        if (pHaitoushrKijyunYmd.getMonth() == 1 || pHaitoushrKijyunYmd.getMonth() == 2
            || pHaitoushrKijyunYmd.getMonth() == 3) {
            wKariwariatedshrymdY = pKeisanDNendo.addYears(1);
        } else {
            wKariwariatedshrymdY = pKeisanDNendo;
        }

        return BizDate.valueOf(wKariwariatedshrymdY, pHaitoushrKijyunYmd.getBizDateMD()).getRekijyou();
    }

    private IT_KhDshrTuki editKhDshrTuki(IT_KykKihon pKykKihon, KhozenCommonParam pKhozenCommonParam,
        BizDate pSyoriYmd, int pRenno, IT_KhHaitouKanri pKhHaitouKanri, IT_KhTumitateDKanri pKhTumitateDKanri) {

        SetKhDshrTukiKykInfo setKhDshrTukiKykInfo = SWAKInjector.getInstance(SetKhDshrTukiKykInfo.class);

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = setKhDshrTukiKykInfo.exec(pKykKihon,
            pKhozenCommonParam, pKhHaitouKanri.getKariwariatedshrymd(), pSyoriYmd);

        editDshrTukiTanKoumokuBean.setRenno(pRenno);
        editDshrTukiTanKoumokuBean.setKhHaitouKanri(pKhHaitouKanri);
        editDshrTukiTanKoumokuBean.setKhTumitateDKanri(pKhTumitateDKanri);

        SrDshrTukiDataSks srDshrTukiDataSks = SWAKInjector.getInstance(SrDshrTukiDataSks.class);

        IT_KhDshrTuki khDshrTuki = srDshrTukiDataSks.execKhKsnNasi(editDshrTukiTanKoumokuBean);

        return khDshrTuki;
    }

    private void detach(IT_KykKihon pKykKihon,
        IT_KhHaitouKanri pKhHaitouKanri,
        IT_KhTumitateDKanri pKhTumitateDKanri) {

        sansyouTblDetach(pKhHaitouKanri, pKhTumitateDKanri);
        updateTblDetach(pKykKihon);
        haitouDetach();
    }

    private void sansyouTblDetach(IT_KhHaitouKanri pKhHaitouKanri,
        IT_KhTumitateDKanri pKhTumitateDKanri) {

        if (pKhHaitouKanri != null) {

            if (hozenDomManager.isManaged(pKhHaitouKanri)) {

                pKhHaitouKanri.detach();
            }
        }

        if (pKhTumitateDKanri != null) {

            if (hozenDomManager.isManaged(pKhTumitateDKanri)) {

                pKhTumitateDKanri.detach();
            }
        }
    }

    private void updateTblDetach(IT_KykKihon pKykKihon) {

        if (pKykKihon != null) {

            hozenDomManager.flush();

            if (hozenDomManager.isManaged(pKykKihon)) {

                pKykKihon.detach();
            }
        }
        else {
            return;
        }
    }

    private void haitouDetach() {

        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessInLoopSet) {
            haitouDetachProcess.detach();
        }
        for (HaitouDetachProcess haitouDetachProcess : haitouDetachProcessOutLoopSet) {
            haitouDetachProcess.detach();
        }
        haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();
    }

    private <T> T getInjectInstanceForInLoop(Class<T> pType) {
        T t = SWAKInjector.getInstance(pType);
        if (t instanceof HaitouDetachProcess) {
            haitouDetachProcessInLoopSet.add((HaitouDetachProcess) t);
        }
        return t;
    }

    private <T> T getInjectInstanceForOutLoop(Class<T> pType) {
        T t = SWAKInjector.getInstance(pType);
        if (t instanceof HaitouDetachProcess) {
            haitouDetachProcessOutLoopSet.add((HaitouDetachProcess) t);
        }
        return t;
    }
}
