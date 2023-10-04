package yuyu.batch.hozen.khozen.khdseisan;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khdseisan.dba.KhDSeisanBean;
import yuyu.batch.hozen.khozen.khdseisan.dba.KhDSeisanDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanTienrisoku;
import yuyu.common.biz.bzcommon.KeisanTienrisokuBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutoku;
import yuyu.common.hozen.haitou.HaitouDetachProcess;
import yuyu.common.hozen.haitou.KeisanD;
import yuyu.common.hozen.haitou.KeisanDBean;
import yuyu.common.hozen.haitou.KeisanDGanrikin;
import yuyu.common.hozen.haitou.SetDNnd;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanKhGensen;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalc;
import yuyu.common.siharai.sicommon.SiMeisaiCommonCalcBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiTyousyo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.configuration.YuyuHozenConfig;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 契約保全 契約保全 Ｄ精算
 */
public class KhDSeisanBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = "IT_KykKihon";

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final int CSV_OUTJOUGEN_KENSUU = 2000;

    private List<SeisanDTuiHrtaisyouBean> seisanDTuiHrtaisyouBeanLst;

    private KhozenCommonParam khozenCommonParam;

    private Set<HaitouDetachProcess> haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();

    private Set<HaitouDetachProcess> haitouDetachProcessOutLoopSet = new HashSet<HaitouDetachProcess>();

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhDSeisanDao khDSeisanDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SiMeisaiCommonCalc siMeisaiCommonCalc;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobcd));

        C_Syoumetujiyuu[] syoumetuJiyuus = new C_Syoumetujiyuu[] { C_Syoumetujiyuu.KAIYAKU, C_Syoumetujiyuu.SBKAIJO,
            C_Syoumetujiyuu.MENSEKI, C_Syoumetujiyuu.SIBOU, C_Syoumetujiyuu.SIBOUKYUUHUKINSHR,
            C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU, C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI };

        BizDateY syoriY = syoriYmd.getBizDateY();

        BizDate kessanKijyunYmd = BizDate.valueOf(syoriY + YuyuHozenConfig.getInstance().getKessanKijunbi());

        BizDate drateKktiymd = BizDate.valueOf(syoriY + YuyuHozenConfig.getInstance().getDrateKakuteiMd());

        if (!drateKktiymd.isBusinessDay()) {
            drateKktiymd = drateKktiymd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        try (ExDBResults<KhDSeisanBean> khDSeisanBeanLst = khDSeisanDao
            .getKhDSeisanDaoByKessankijyunymdDratekakuteiymdSyoumetujiyuus(kessanKijyunYmd, drateKktiymd,
                syoumetuJiyuus, kakutyoujobcd);
            EntityInserter<IT_DSeisanTuibaraiKanri> bosyuuDSeisanTuibaraiKanriInserter = new EntityInserter<>()) {

            int dSeisanInputCount = 0;
            int dSeisanOutputCount = 0;
            int mislistOutputCount = 0;
            String missListMessage = "";
            int tdktyuuiKensuu = 0;
            List<EditKhMisslstParam> editKhMisslstParamLst = new ArrayList<>();
            khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            seisanDTuiHrtaisyouBeanLst = new ArrayList<>();

            for (KhDSeisanBean khDSeisanBean : khDSeisanBeanLst) {
                String syoNo = khDSeisanBean.getSyono();
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khDSeisanBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syoNo);

                if (BizDateUtil.compareYmd(khDSeisanBean.getSyoumetuymd(),
                    khDSeisanBean.getKykymd().addYears(1).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {
                    continue;
                }
                if (C_Syoumetujiyuu.KAIYAKU.eq(khDSeisanBean.getSyoumetujiyuu())
                    || C_Syoumetujiyuu.SBKAIJO.eq(khDSeisanBean.getSyoumetujiyuu())
                    || C_Syoumetujiyuu.MENSEKI.eq(khDSeisanBean.getSyoumetujiyuu())) {

                    if (khDSeisanBean.getYendthnkymd() == null && BizDateUtil.compareYmd(khDSeisanBean.getSyoumetuymd(),
                        khDSeisanBean.getKykymd().addYears(2).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {
                        continue;
                    }
                }

                BizDate haitouShrkiJyunyYmd = null;

                if (khDSeisanBean.getYendthnkymd() != null) {

                    haitouShrkiJyunyYmd = khDSeisanBean.getYendthnkymd();
                }
                else {

                    haitouShrkiJyunyYmd = khDSeisanBean.getKykymd();
                }

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                BizDate tykzenOutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, haitouShrkiJyunyYmd, C_Hrkkaisuu.NEN,
                    syoriYmd);

                if ((BizDateUtil.compareYmd(kessanKijyunYmd, tykzenOutouYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(kessanKijyunYmd, tykzenOutouYmd) == BizDateUtil.COMPARE_EQUAL) &&
                    (BizDateUtil.compareYmd(tykzenOutouYmd, khDSeisanBean.getSyoumetuymd()) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(tykzenOutouYmd, khDSeisanBean.getSyoumetuymd()) == BizDateUtil.COMPARE_EQUAL)) {
                }
                else {
                    continue;
                }

                if (C_Syoumetujiyuu.KAIYAKU.eq(khDSeisanBean.getSyoumetujiyuu()) ||
                    C_Syoumetujiyuu.SBKAIJO.eq(khDSeisanBean.getSyoumetujiyuu()) ||
                    C_Syoumetujiyuu.MENSEKI.eq(khDSeisanBean.getSyoumetujiyuu())) {

                    if (C_Kykjyoutai.HRKMTYUU.eq(khDSeisanBean.getKykjyoutai()) ||
                        C_Kykjyoutai.IKKATUNK.eq(khDSeisanBean.getKykjyoutai()) ||
                        C_Kykjyoutai.ZENNOU.eq(khDSeisanBean.getKykjyoutai())) {

                        BizDate jkiHrkpjytYmd = BizDate.valueOf(khDSeisanBean.getJkipjytym(),
                            khDSeisanBean.getKykymd().getDay()).getRekijyou();

                        if (BizDateUtil.compareYmd(tykzenOutouYmd, jkiHrkpjytYmd) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(tykzenOutouYmd, jkiHrkpjytYmd) == BizDateUtil.COMPARE_EQUAL) {

                        }
                        else {
                            continue;
                        }
                    }
                }

                if (khDSeisanBean.getYendthnkymd() != null &&
                    BizDateUtil.compareYmd(khDSeisanBean.getYendthnkymd(), tykzenOutouYmd) == BizDateUtil.COMPARE_EQUAL) {

                    missListMessage = "内定期間中に円建変更されたため、処理できません。ハンド作業にてＤ精算を行う必要があります。";

                    mislistOutputCount = misslistEdit(mislistOutputCount, syoNo, C_Dbhanei.NONE,
                        missListMessage, editKhMisslstParamLst);

                    continue;
                }

                IT_KykSyouhnRireki kykSyouhnRireki = khDSeisanDao
                    .getKhTtdkRirekiInfosBySyonoKouryokuhasseiymdGyoumukousinkinou(syoNo,
                        tykzenOutouYmd, khDSeisanBean.getSyoumetuymd(), IKhozenCommonConstants.KINOUID_GENGAKU);

                if (kykSyouhnRireki != null) {

                    missListMessage = "内定期間中に減額されたため、処理できません。ハンド作業にてＤ精算を行う必要があります。";

                    mislistOutputCount = misslistEdit(mislistOutputCount, syoNo, C_Dbhanei.NONE,
                        missListMessage, editKhMisslstParamLst);

                    detach(null, kykSyouhnRireki, null, null, null);

                    continue;
                }

                IT_KhHaitouKanri khHaitouKanri = khDSeisanDao.getKhHaitouKanriBySyonoHaitounendon(
                    syoNo, syoriYmd.getBizDateY().toString());

                if (khHaitouKanri == null || !C_NaiteiKakuteiKbn.NAITEI.eq(khHaitouKanri.getNaiteikakuteikbn())) {
                    continue;
                }

                dSeisanInputCount = dSeisanInputCount + 1;

                C_ShrhousiteiKbn shrhousiteiKbn = null;
                C_InputShrhousiteiKbn inputShrhousiteiKbn = null;
                C_DseisantetudukimeiKbn dseisantetudukimeiKbn = null;
                C_Tuukasyu tuukasyu = null;
                BizDate syoruiukeYmd = null;
                BizDate kouryokuhasseiYmd = null;
                C_UmuKbn gsbunritaisyou = null;
                C_UmuKbn yenshrtkumu = null;
                C_KouzasyuruiKbn kzsyuruikbn = null;
                String bankcd = "";
                String sitencd = "";
                C_YokinKbn yokinkbn = null;
                String kouzano = "";
                C_Kzdou kzdoukbn = null;
                String kzmeiginmkn = "";
                BizDate gaikashrkwsratekjnymd = null;
                BizNumber gaikashrkwsrate = BizNumber.valueOf(0);
                BizDate zeimukwsratekjnymd = null;
                BizNumber zeimukwsrate = BizNumber.valueOf(0);
                String nztodouhukencd = "";
                BizCurrency syoumetujiYenhtykeihi = BizCurrency.valueOf(0);
                BizCurrency syoumetujiYenshrkykhtykeihi = BizCurrency.valueOf(0);
                Integer kykhnkkaisuu = 0;
                C_YouhiKbn shrtysykurikosiyouhi = null;
                BizCurrency syoumetujiYensynykngk = BizCurrency.valueOf(0);
                BizCurrency syoumetujiYengstszeigk = BizCurrency.valueOf(0);
                C_UmuKbn tszeigkUmuFlg = null;
                C_UmuKbn penaltyUmuFlg = null;
                String syoumetujiSoukinsakinmkj = "";
                String syoumetujiSoukinsakiyno = "";
                String syoumetujiSoukinsakiadr1kj = "";
                String syoumetujiSoukinsakiadr2kj = "";
                String syoumetujiSoukinsakiadr3kj = "";
                String soukinsakinmkj = "";
                String soukinsakiyno = "";
                String soukinsakiadr1kj = "";
                String soukinsakiadr2kj = "";
                String soukinsakiadr3kj = "";
                C_Kaiyakujiyuu kaiyakujiyuu = null;
                C_YouhiKbn tsuhrYouhiKbn = null;
                C_YouhiKbn tuutisakuseiYouhiKbn = null;
                BizCurrency yenhtykeihi = BizCurrency.valueOf(0);
                BizCurrency yenshrkykhtykeihi = BizCurrency.valueOf(0);
                BizCurrency yenkztgk = BizCurrency.valueOf(0);
                BizCurrency yensynykngk = BizCurrency.valueOf(0);
                HaitouKinCalcBean haitouKinCalcBean = SWAKInjector.getInstance(HaitouKinCalcBean.class);
                BizCurrency seisSnd = null;
                IT_KhShrRireki khShrRireki = null;

                JT_Sk jtSk = null;
                C_ZeitratkiKbn zeitratkiKbn = null;
                JT_SiTyousyo siTyousyo = null;

                if (C_Syoumetujiyuu.KAIYAKU.eq(khDSeisanBean.getSyoumetujiyuu())
                    || C_Syoumetujiyuu.SBKAIJO.eq(khDSeisanBean.getSyoumetujiyuu())
                    || C_Syoumetujiyuu.MENSEKI.eq(khDSeisanBean.getSyoumetujiyuu())) {

                    khShrRireki = hozenDomManager
                        .getKhShrRirekiInfosBySyonoHenkousikibetukey(syoNo,
                            khDSeisanBean.getHenkousikibetukey()).get(0).getIT_KhShrRireki();

                    if (C_InputShrhousiteiKbn.FBSOUKIN.eq(khShrRireki.getInputshrhousiteikbn())) {

                        shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;

                        inputShrhousiteiKbn = C_InputShrhousiteiKbn.FBSOUKIN;
                    }
                    else if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(khShrRireki.getInputshrhousiteikbn()) ||
                        C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(khShrRireki.getInputshrhousiteikbn())) {

                        shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI;

                        inputShrhousiteiKbn = C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI;
                    }

                    if (C_Syoumetujiyuu.KAIYAKU.eq(khDSeisanBean.getSyoumetujiyuu())) {

                        dseisantetudukimeiKbn = C_DseisantetudukimeiKbn.KAIYAKU;
                    }
                    else if (C_Syoumetujiyuu.SBKAIJO.eq(khDSeisanBean.getSyoumetujiyuu()) ||
                        C_Syoumetujiyuu.MENSEKI.eq(khDSeisanBean.getSyoumetujiyuu())) {

                        dseisantetudukimeiKbn = C_DseisantetudukimeiKbn.SIBOU;
                    }

                    if (khShrRireki.getYengstszeigk().compareTo(
                        BizCurrency.valueOf(0, khShrRireki.getYengstszeigk().getType())) > 0) {

                        tszeigkUmuFlg = C_UmuKbn.ARI;
                    }
                    else {

                        tszeigkUmuFlg = C_UmuKbn.NONE;
                    }

                    if (C_HaitoukinsksKbn.KARIWARIATE5.eq(khHaitouKanri.getHaitoukinskskbn())) {

                        penaltyUmuFlg = C_UmuKbn.NONE;
                    }
                    else {

                        penaltyUmuFlg = C_UmuKbn.ARI;
                    }

                    tuukasyu = khShrRireki.getShrtuukasyu();
                    syoruiukeYmd = khShrRireki.getSyoruiukeymd();
                    kouryokuhasseiYmd = khShrRireki.getKouryokuhasseiymd();
                    gsbunritaisyou = khShrRireki.getGsbunritaisyou();
                    yenshrtkumu = khShrRireki.getYenshrtkumu();
                    kzsyuruikbn = khShrRireki.getKzsyuruikbn();
                    bankcd = khShrRireki.getBankcd();
                    sitencd = khShrRireki.getSitencd();
                    yokinkbn = khShrRireki.getYokinkbn();
                    kouzano = khShrRireki.getKouzano();
                    kzdoukbn = khShrRireki.getKzdoukbn();
                    kzmeiginmkn = khShrRireki.getKzmeiginmkn();
                    gaikashrkwsratekjnymd = khShrRireki.getGaikashrkwsratekjnymd();
                    gaikashrkwsrate = khShrRireki.getGaikashrkwsrate();
                    zeimukwsratekjnymd = khShrRireki.getZeimukwsratekjnymd();
                    zeimukwsrate = khShrRireki.getZeimukwsrate();
                    nztodouhukencd = khShrRireki.getNztodouhukencd();
                    syoumetujiYenhtykeihi = khShrRireki.getYenhtykeihi();
                    syoumetujiYenshrkykhtykeihi = khShrRireki.getYenshrkykhtykeihi();
                    kykhnkkaisuu = khShrRireki.getKykhnkkaisuu();
                    shrtysykurikosiyouhi = khShrRireki.getShrtysykurikosiyouhi();
                    syoumetujiYensynykngk = khShrRireki.getYensynykngk();
                    syoumetujiYengstszeigk = khShrRireki.getYengstszeigk();
                    zeitratkiKbn = C_ZeitratkiKbn.BLNK;

                    if (C_Syoumetujiyuu.KAIYAKU.eq(khDSeisanBean.getSyoumetujiyuu())) {

                        if (!Strings.isNullOrEmpty(khShrRireki.getKyksyaszkyno())) {

                            syoumetujiSoukinsakinmkj = khShrRireki.getKyksyaszknmkj();
                            syoumetujiSoukinsakiyno = khShrRireki.getKyksyaszkyno();
                            syoumetujiSoukinsakiadr1kj = khShrRireki.getKyksyaszkadr1kj();
                            syoumetujiSoukinsakiadr2kj = khShrRireki.getKyksyaszkadr2kj();
                            syoumetujiSoukinsakiadr3kj = khShrRireki.getKyksyaszkadr3kj();
                            kaiyakujiyuu = C_Kaiyakujiyuu.KYKSB;
                        }
                        else {

                            if (!Strings.isNullOrEmpty(khShrRireki.getSaikennyno())) {

                                kaiyakujiyuu = C_Kaiyakujiyuu.SKS;
                            }
                            else {

                                kaiyakujiyuu = C_Kaiyakujiyuu.TUUJYOU;
                            }
                        }
                    }
                    else if (C_Syoumetujiyuu.SBKAIJO.eq(khDSeisanBean.getSyoumetujiyuu()) ||
                        C_Syoumetujiyuu.MENSEKI.eq(khDSeisanBean.getSyoumetujiyuu())) {

                        if (!Strings.isNullOrEmpty(khShrRireki.getSoukinsakiyno())) {

                            syoumetujiSoukinsakinmkj = khShrRireki.getSoukinsakinmkj();
                            syoumetujiSoukinsakiyno = khShrRireki.getSoukinsakiyno();
                            syoumetujiSoukinsakiadr1kj = khShrRireki.getSoukinsakiadr1kj();
                            syoumetujiSoukinsakiadr2kj = khShrRireki.getSoukinsakiadr2kj();
                            syoumetujiSoukinsakiadr3kj = khShrRireki.getSoukinsakiadr3kj();
                            kaiyakujiyuu = C_Kaiyakujiyuu.BLNK;
                        }
                        else {

                            if (!Strings.isNullOrEmpty(khShrRireki.getKyksyaszkyno())) {

                                syoumetujiSoukinsakinmkj = khShrRireki.getKyksyaszknmkj();
                                syoumetujiSoukinsakiyno = khShrRireki.getKyksyaszkyno();
                                syoumetujiSoukinsakiadr1kj = khShrRireki.getKyksyaszkadr1kj();
                                syoumetujiSoukinsakiadr2kj = khShrRireki.getKyksyaszkadr2kj();
                                syoumetujiSoukinsakiadr3kj = khShrRireki.getKyksyaszkadr3kj();
                                kaiyakujiyuu = C_Kaiyakujiyuu.BLNK;
                            }
                            else {

                                kaiyakujiyuu = C_Kaiyakujiyuu.BLNK;
                            }
                        }
                    }
                }
                else {

                    jtSk = khDSeisanDao.getSkBySyono(syoNo);

                    String skNo = jtSk.getSkno();
                    JT_SiRireki siRireki = khDSeisanDao.getSiRirekiBySknoSyono(skNo, syoNo);

                    siTyousyo = khDSeisanDao.getSiTyousyoBySyono(syoNo);

                    if (C_InputShrhousiteiKbn.FBSOUKIN.eq(jtSk.getInputshrhousiteikbn())) {

                        shrhousiteiKbn = C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI;

                        inputShrhousiteiKbn = C_InputShrhousiteiKbn.FBSOUKIN;
                    }
                    else if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(jtSk.getInputshrhousiteikbn()) ||
                        C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(jtSk.getInputshrhousiteikbn())) {

                        shrhousiteiKbn = C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI;

                        inputShrhousiteiKbn = C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI;
                    }

                    if (jtSk.getHubikanryouymd() == null) {

                        syoruiukeYmd = jtSk.getSyoruiukeymd();
                    }
                    else {

                        syoruiukeYmd = jtSk.getHubikanryouymd();
                    }

                    if (C_Tuukasyu.JPY.eq(khDSeisanBean.getKyktuukasyu())) {

                        yenshrtkumu = C_UmuKbn.NONE;
                    }
                    else {

                        if (C_SiharaiTuukaKbn.YENSIHARAI.eq(jtSk.getSiharaituukakbn())) {

                            yenshrtkumu = C_UmuKbn.ARI;
                        }
                        else if (C_SiharaiTuukaKbn.GAIKASIHARAI.eq(jtSk.getSiharaituukakbn())) {

                            yenshrtkumu = C_UmuKbn.NONE;
                        }
                    }

                    if (C_InputShrhousiteiKbn.FBSOUKIN.eq(jtSk.getInputshrhousiteikbn())) {

                        if (C_Tuukasyu.JPY.eq(khDSeisanBean.getKyktuukasyu())) {

                            kzsyuruikbn = C_KouzasyuruiKbn.YENKOUZA;
                        }
                        else {

                            if (C_SiharaiTuukaKbn.YENSIHARAI.eq(jtSk.getSiharaituukakbn())) {

                                kzsyuruikbn = C_KouzasyuruiKbn.YENKOUZA;
                            }
                            else if (C_SiharaiTuukaKbn.GAIKASIHARAI.eq(jtSk.getSiharaituukakbn())) {

                                kzsyuruikbn = C_KouzasyuruiKbn.GAIKAKOUZA;
                            }
                        }
                    }
                    else {

                        kzsyuruikbn = C_KouzasyuruiKbn.BLNK;
                    }

                    if (siTyousyo != null) {

                        shrtysykurikosiyouhi = C_YouhiKbn.YOU;
                    }
                    else {

                        shrtysykurikosiyouhi = C_YouhiKbn.HUYOU;
                    }

                    dseisantetudukimeiKbn = C_DseisantetudukimeiKbn.SIBOU;
                    tuukasyu = jtSk.getShrtuukasyu();
                    kouryokuhasseiYmd = khDSeisanBean.getSyoumetuymd();
                    gsbunritaisyou = C_UmuKbn.NONE;
                    bankcd = jtSk.getBankcd();
                    sitencd = jtSk.getSitencd();
                    yokinkbn = jtSk.getYokinkbn();
                    kouzano = jtSk.getKouzano();
                    kzdoukbn = jtSk.getKzdoukbn();
                    kzmeiginmkn = jtSk.getKzmeiginmkn();
                    gaikashrkwsratekjnymd = jtSk.getGaikaknsnkwsratekjymd();
                    gaikashrkwsrate = jtSk.getGaikaknsnkwsrate();
                    zeimukwsratekjnymd = jtSk.getZeimukwsratekjnymd();
                    zeimukwsrate = jtSk.getZeimukwsrate();
                    nztodouhukencd = "";
                    syoumetujiYenhtykeihi = jtSk.getGoukeihituyoukeihi();
                    syoumetujiYenshrkykhtykeihi = jtSk.getShrkykhtykeihi();
                    kykhnkkaisuu = jtSk.getKykhnkkaisuu();
                    syoumetujiYengstszeigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    tszeigkUmuFlg = C_UmuKbn.NONE;
                    penaltyUmuFlg = C_UmuKbn.NONE;
                    syoumetujiSoukinsakinmkj = jtSk.getSeikyuusyanmkj();
                    syoumetujiSoukinsakiyno = jtSk.getTsinyno();
                    syoumetujiSoukinsakiadr1kj = jtSk.getTsinadr1kj();
                    syoumetujiSoukinsakiadr2kj = jtSk.getTsinadr2kj();
                    syoumetujiSoukinsakiadr3kj = jtSk.getTsinadr3kj();
                    kaiyakujiyuu = C_Kaiyakujiyuu.BLNK;
                    zeitratkiKbn = siRireki.getZeitratkikbn();

                    SiMeisaiCommonCalcBean siMeisaiCommonCalcBean = SWAKInjector.getInstance(SiMeisaiCommonCalcBean.class);

                    siMeisaiCommonCalcBean.setKykTuukasyu(jtSk.getKyktuukasyu());
                    siMeisaiCommonCalcBean.setShrTuukasyu(jtSk.getShrtuukasyu());
                    siMeisaiCommonCalcBean.setKawaseRate(jtSk.getShrkwsrate());
                    siMeisaiCommonCalcBean.setGaikaknsnkwsrate(jtSk.getGaikaknsnkwsrate());
                    siMeisaiCommonCalcBean.setZeimukwsrate(jtSk.getZeimukwsrate());
                    siMeisaiCommonCalcBean.setHokenkngkgoukei(jtSk.getHokenkngkgoukei());
                    siMeisaiCommonCalcBean.setZennouseisankgk(jtSk.getZennouseisankgk());
                    siMeisaiCommonCalcBean.setYenkazennouseisankgk(jtSk.getYenkazennouseisankgk());
                    siMeisaiCommonCalcBean.setMisyuup(jtSk.getMisyuup());
                    siMeisaiCommonCalcBean.setMikeikap(jtSk.getMikeikap());
                    siMeisaiCommonCalcBean.setYenkamikeikap(jtSk.getYenkamikeikap());
                    siMeisaiCommonCalcBean.setHaitoukin(jtSk.getHaitoukin());
                    siMeisaiCommonCalcBean.setYenkahaitoukin(jtSk.getYenkahaitoukin());
                    siMeisaiCommonCalcBean.setSonotahaitoukin(jtSk.getSonotahaitoukin());
                    siMeisaiCommonCalcBean.setYenkasonotahaitoukin(jtSk.getYenkasonotahaitoukin());
                    siMeisaiCommonCalcBean.setZitkazukarikingksiteituuka(jtSk.getZitkazukarikingksiteituuka());
                    siMeisaiCommonCalcBean.setZitkazukarikingkyen(jtSk.getZitkazukarikingkyen());
                    siMeisaiCommonCalcBean.setYenkakrkgk(jtSk.getYenkakrkgk());

                    if (C_SiharaiTuukaKbn.YENSIHARAI.eq(jtSk.getSiharaituukakbn())) {

                        siMeisaiCommonCalcBean.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);
                    }
                    else {

                        siMeisaiCommonCalcBean.setZeitratkikbn(zeitratkiKbn);
                    }

                    siMeisaiCommonCalcBean.setSyouhinCd(khDSeisanBean.getSyouhncd());

                    C_ErrorKbn errorKbn = siMeisaiCommonCalc.exec(siMeisaiCommonCalcBean);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new BizAppException(MessageId.EJA1004, khozenCommonParam.getKinouNm(), JT_SkKihon.SYONO, jtSk.getSyono());
                    }

                    if (C_SiharaiTuukaKbn.YENSIHARAI.eq(jtSk.getSiharaituukakbn())) {

                        syoumetujiYensynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
                    }
                    else if (C_SiharaiTuukaKbn.GAIKASIHARAI.eq(jtSk.getSiharaituukakbn())) {

                        if (C_ZeitratkiKbn.ITIJI.eq(zeitratkiKbn)) {

                            syoumetujiYensynykngk = siMeisaiCommonCalc.getShrmisisynykngk();
                        }
                        else {

                            syoumetujiYensynykngk = siMeisaiCommonCalc.getShrmisikztkgk();
                        }
                    }
                }

                haitouKinCalcBean = haitouKinCalc(khDSeisanBean, khHaitouKanri, tuukasyu, shrhousiteiKbn,
                    gaikashrkwsrate, zeimukwsrate, bankcd, yenshrtkumu, tszeigkUmuFlg, penaltyUmuFlg, syoriYmd);

                seisSnd = haitouKinCalcBean.getSeisand();

                if (seisSnd.compareTo(BizCurrency.valueOf(0, seisSnd.getType())) > 0) {

                    tsuhrYouhiKbn = C_YouhiKbn.YOU;
                    tuutisakuseiYouhiKbn = C_YouhiKbn.YOU;
                }
                else {

                    tsuhrYouhiKbn = C_YouhiKbn.HUYOU;
                    tuutisakuseiYouhiKbn = C_YouhiKbn.HUYOU;
                }

                if (syoumetujiYengstszeigk.compareTo(BizCurrency.valueOf(0, syoumetujiYengstszeigk.getType())) > 0) {

                    yenhtykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    yenshrkykhtykeihi = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    yenkztgk = seisSnd;
                    yensynykngk = seisSnd;
                }
                else {

                    yenhtykeihi = syoumetujiYenhtykeihi;
                    yenshrkykhtykeihi = syoumetujiYenshrkykhtykeihi;
                    yenkztgk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    yensynykngk = syoumetujiYensynykngk.add(seisSnd);
                }

                KhDSeisanTtdktyuuiBean khDSeisanTtdktyuuiBean = ttdktyuuiHantei(tdktyuuiKensuu, khDSeisanBean);

                tdktyuuiKensuu = khDSeisanTtdktyuuiBean.getTtdktyuuiKensuu();

                if (C_DseisansouhusakihnsyuKbn.SYOUMETUJISOUHUSAKI.eq(
                    khDSeisanTtdktyuuiBean.getDseisansouhusakihnsyuKbn())) {

                    soukinsakinmkj = syoumetujiSoukinsakinmkj;
                    soukinsakiyno = syoumetujiSoukinsakiyno;
                    soukinsakiadr1kj = syoumetujiSoukinsakiadr1kj;
                    soukinsakiadr2kj = syoumetujiSoukinsakiadr2kj;
                    soukinsakiadr3kj = syoumetujiSoukinsakiadr3kj;
                }

                seisanDTuiHrtaisyou(khDSeisanBean, khDSeisanTtdktyuuiBean.getTtdktyuuiNaiyou(), inputShrhousiteiKbn,
                    tuukasyu, haitouKinCalcBean, yensynykngk, yenhtykeihi, yenshrkykhtykeihi, kykhnkkaisuu,
                    gaikashrkwsrate, zeimukwsrate);

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                IT_DSeisanTuibaraiKanri dSeisanTuibaraiKanri = new IT_DSeisanTuibaraiKanri(
                    khDSeisanBean.getSyono(), khDSeisanBean.getHaitounendo());

                dSeisanTuibaraiKanri.setSyouhncd(khDSeisanBean.getSyouhncd());
                dSeisanTuibaraiKanri.setSyouhnsdno(khDSeisanBean.getSyouhnsdno());
                dSeisanTuibaraiKanri.setKykymd(khDSeisanBean.getKykymd());
                dSeisanTuibaraiKanri.setKyktuukasyu(khDSeisanBean.getKyktuukasyu());
                dSeisanTuibaraiKanri.setShrhousiteikbn(shrhousiteiKbn);
                dSeisanTuibaraiKanri.setInputshrhousiteikbn(inputShrhousiteiKbn);
                dSeisanTuibaraiKanri.setTuibaraiyouhikbn(tsuhrYouhiKbn);
                dSeisanTuibaraiKanri.setTuutisakuseiyouhikbn(tuutisakuseiYouhiKbn);
                dSeisanTuibaraiKanri.setDseisansouhusakihnsyukbn(khDSeisanTtdktyuuiBean.getDseisansouhusakihnsyuKbn());
                dSeisanTuibaraiKanri.setDseisantetudukimeikbn(dseisantetudukimeiKbn);
                dSeisanTuibaraiKanri.setShrymd(haitouKinCalcBean.getSiharaiYmd());
                dSeisanTuibaraiKanri.setShrtienrskkisanymd(khDSeisanBean.getSyoumetuymd());
                dSeisanTuibaraiKanri.setTienrsknissuu(haitouKinCalcBean.getKeisanTienrisokuBean().getShrtienNissuu());
                dSeisanTuibaraiKanri.setSyoruiukeymd(syoruiukeYmd);
                dSeisanTuibaraiKanri.setKouryokuhasseiymd(kouryokuhasseiYmd);
                dSeisanTuibaraiKanri.setShrtuukasyu(tuukasyu);
                dSeisanTuibaraiKanri.setGsbunritaisyou(gsbunritaisyou);
                dSeisanTuibaraiKanri.setYenshrtkumu(yenshrtkumu);
                dSeisanTuibaraiKanri.setKzsyuruikbn(kzsyuruikbn);
                dSeisanTuibaraiKanri.setBankcd(bankcd);
                dSeisanTuibaraiKanri.setSitencd(sitencd);
                dSeisanTuibaraiKanri.setYokinkbn(yokinkbn);
                dSeisanTuibaraiKanri.setKouzano(kouzano);
                dSeisanTuibaraiKanri.setKzdoukbn(kzdoukbn);
                dSeisanTuibaraiKanri.setKzmeiginmkn(kzmeiginmkn);
                dSeisanTuibaraiKanri.setGaikashrkwsratekjnymd(gaikashrkwsratekjnymd);
                dSeisanTuibaraiKanri.setGaikashrkwsrate(gaikashrkwsrate);
                dSeisanTuibaraiKanri.setZeimukwsratekjnymd(zeimukwsratekjnymd);
                dSeisanTuibaraiKanri.setZeimukwsrate(zeimukwsrate);
                dSeisanTuibaraiKanri.setNztodouhukencd(nztodouhukencd);
                dSeisanTuibaraiKanri.setYensynykngk(yensynykngk);
                dSeisanTuibaraiKanri.setYenhtykeihi(yenhtykeihi);
                dSeisanTuibaraiKanri.setYenkztgk(yenkztgk);
                dSeisanTuibaraiKanri.setYenshrkykhtykeihi(yenshrkykhtykeihi);
                dSeisanTuibaraiKanri.setKykhnkkaisuu(kykhnkkaisuu);
                dSeisanTuibaraiKanri.setShrtysykurikosiyouhi(shrtysykurikosiyouhi);
                dSeisanTuibaraiKanri.setShrtuukashrgkgoukei(haitouKinCalcBean.getSiharaiGk());
                dSeisanTuibaraiKanri.setSoukinsakinmkj(soukinsakinmkj);
                dSeisanTuibaraiKanri.setSoukinsakiyno(soukinsakiyno);
                dSeisanTuibaraiKanri.setSoukinsakiadr1kj(soukinsakiadr1kj);
                dSeisanTuibaraiKanri.setSoukinsakiadr2kj(soukinsakiadr2kj);
                dSeisanTuibaraiKanri.setSoukinsakiadr3kj(soukinsakiadr3kj);
                dSeisanTuibaraiKanri.setKaiyakujiyuu(kaiyakujiyuu);
                dSeisanTuibaraiKanri.setShrtuukashrtienrsk(haitouKinCalcBean.getKeisanTienrisokuBean().getShrtienrsk());
                dSeisanTuibaraiKanri.setShrtuukasonotashrkngk(haitouKinCalcBean.getSeisandShrTuukasyu());
                dSeisanTuibaraiKanri.setYenkansanhaitoukin(haitouKinCalcBean.getSeisand());
                dSeisanTuibaraiKanri.setYengstszeigk(haitouKinCalcBean.getKeisanGensenBean().getYenGensen());
                dSeisanTuibaraiKanri.setYengstszeigknationaltax(haitouKinCalcBean.getKeisanGensenBean()
                    .getYenGsTszeiGkKokuz());
                dSeisanTuibaraiKanri.setYengstszeigklocaltax(haitouKinCalcBean.getKeisanGensenBean()
                    .getYenGsTszeiGkTihouz());
                dSeisanTuibaraiKanri.setSonotashrkngkyen(haitouKinCalcBean.getSeisand());
                dSeisanTuibaraiKanri.setSonotashrkngksiteituuka(haitouKinCalcBean.getSeisandKykTuukasyu());
                dSeisanTuibaraiKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                dSeisanTuibaraiKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                dSeisanTuibaraiKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                dSeisanTuibaraiKanri.setZeitratkikbn(zeitratkiKbn);

                if (C_Tuukasyu.JPY.eq(tuukasyu)) {

                    dSeisanTuibaraiKanri.setShrtuukagstszeigk(haitouKinCalcBean.getKeisanGensenBean().getYenGensen());
                    dSeisanTuibaraiKanri.setYenshrgkgoukei(haitouKinCalcBean.getSiharaiGk());
                    dSeisanTuibaraiKanri.setYenshrtienrsk(haitouKinCalcBean.getKeisanTienrisokuBean().getShrtienrsk());
                }
                else {

                    dSeisanTuibaraiKanri.setShrtuukagstszeigk(haitouKinCalcBean.getKeisanGensenBean().getGensen());
                    dSeisanTuibaraiKanri.setYenshrgkgoukei(keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        haitouKinCalcBean.getSiharaiGk(), zeimukwsrate, C_HasuusyoriKbn.SUTE));
                    dSeisanTuibaraiKanri.setYenshrtienrsk(keisanGaikakanzan.exec(C_Tuukasyu.JPY, haitouKinCalcBean
                        .getKeisanTienrisokuBean().getShrtienrsk(), zeimukwsrate, C_HasuusyoriKbn.SUTE));
                }

                BizPropertyInitializer.initialize(dSeisanTuibaraiKanri);

                bosyuuDSeisanTuibaraiKanriInserter.add(dSeisanTuibaraiKanri);

                dSeisanOutputCount = dSeisanOutputCount + 1;

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                JT_SkKihon skKihon = null;

                if (jtSk != null) {

                    skKihon = jtSk.getSkKihon();
                }

                detach(kykKihon, null, khHaitouKanri, skKihon, siTyousyo);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            int renno = 1;

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            List<List<SeisanDTuiHrtaisyouBean>> seisanDTuiHrtaisyouBeanLsts = Lists.partition(
                seisanDTuiHrtaisyouBeanLst, CSV_OUTJOUGEN_KENSUU);

            for (List<SeisanDTuiHrtaisyouBean> seisanDTuiHrtaisyouBeanLst1 : seisanDTuiHrtaisyouBeanLsts) {

                C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.KH_SEISANDTUIHRTAISYOUDATA,
                    seisanDTuiHrtaisyouBeanLst1, true, "_" + String.valueOf(renno));

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                        khozenCommonParam.getKinouNm()));
                }

                renno++;
            }

            if (editKhMisslstParamLst.size() > 0) {

                KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

                khozenTyouhyouCtl.setEditKkMisslstParam(editKhMisslstParamLst);

                khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
                    new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_DSEISAN_MISSLIST }, C_YouhiKbn.YOU);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(dSeisanInputCount)));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(dSeisanOutputCount), "契約基本テーブル"));

            if (editKhMisslstParamLst.size() > 0) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "ミスリスト",
                    String.valueOf(editKhMisslstParamLst.size())));
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "精算Ｄ追払対象データ",
                String.valueOf(seisanDTuiHrtaisyouBeanLst.size())));

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "精算Ｄ追払対象データ（手続注意）",
                String.valueOf(tdktyuuiKensuu)));
        }
    }

    private HaitouKinCalcBean haitouKinCalc(KhDSeisanBean pKhDSeisanBean, IT_KhHaitouKanri pKhHaitouKanri,
        C_Tuukasyu pTuukasyu, C_ShrhousiteiKbn pShrhousiteiKbn, BizNumber pGaikashrkwsrate, BizNumber pZeimukwsrate,
        String pBankcd, C_UmuKbn pYenshrtkumu, C_UmuKbn pTszeigkUmuFlg, C_UmuKbn pBerinalUmuFlg, BizDate pSyoriYmd) {

        HaitouKinCalcBean haitouKinCalcBean = SWAKInjector.getInstance(HaitouKinCalcBean.class);

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        KeisanGensenBean keisanGensenBean = SWAKInjector.getInstance(KeisanGensenBean.class);

        KeisanTienrisokuBean keisanTienrisokuBean = SWAKInjector.getInstance(KeisanTienrisokuBean.class);

        CurrencyType syuTuukaType = henkanTuuka.henkanTuukaKbnToType(pKhDSeisanBean.getKyktuukasyu());

        CurrencyType shrTuukaType = henkanTuuka.henkanTuukaKbnToType(pTuukasyu);

        keisanGensenBean.setGensen(BizCurrency.valueOf(0, syuTuukaType));
        keisanGensenBean.setYenGensen(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        keisanGensenBean.setYenGsTszeiGkKokuz(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        keisanGensenBean.setYenGsTszeiGkTihouz(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        keisanTienrisokuBean.setShrtienrsk(BizCurrency.valueOf(0, shrTuukaType));
        haitouKinCalcBean.setHaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        haitouKinCalcBean.setKariwariatedGanrikin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        haitouKinCalcBean.setSeisand(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        haitouKinCalcBean.setSeisandShrTuukasyu(BizCurrency.valueOf(0, shrTuukaType));
        haitouKinCalcBean.setSeisandKykTuukasyu(BizCurrency.valueOf(0, syuTuukaType));
        haitouKinCalcBean.setSeisandShrTuukasyuGensenTusshkg(BizCurrency.valueOf(0, shrTuukaType));
        haitouKinCalcBean.setSiharaiGk(BizCurrency.valueOf(0, shrTuukaType));
        haitouKinCalcBean.setKeisanGensenBean(keisanGensenBean);
        haitouKinCalcBean.setKeisanTienrisokuBean(keisanTienrisokuBean);

        SetDNnd setDNnd = getInjectInstanceForInLoop(SetDNnd.class);
        DRateBean dRateBean = setDNnd.exec(pKhDSeisanBean.getSyouhncd(),
            pKhDSeisanBean.getRyouritusdno(),
            pKhDSeisanBean.getYoteiriritu(),
            pKhDSeisanBean.getHrkkaisuu(),
            pKhDSeisanBean.getHhknsei(),
            pKhDSeisanBean.getHhknnen(),
            pKhDSeisanBean.getHknkknsmnkbn(),
            pKhDSeisanBean.getHknkkn(),
            pKhDSeisanBean.getHrkkkn(),
            pKhDSeisanBean.getKykjyoutai(),
            pKhDSeisanBean.getHrkkknsmnkbn(),
            pKhDSeisanBean.getKyktuukasyu(),
            pKhDSeisanBean.getDai1hknkkn(),
            pKhHaitouKanri.getKariwariatedshrymd(),
            pKhDSeisanBean.getKykymd(),
            pKhDSeisanBean.getYendthnkymd(),
            pKhHaitouKanri.getHaitounendo().addYears(-1),
            pKhHaitouKanri.getKariwariatedshrymd(),
            pSyoriYmd,
            C_UmuKbn.NONE);

        KeisanDBean keisanDBean = SWAKInjector.getInstance(KeisanDBean.class);
        keisanDBean.setDRateSyutokuInfoBean(dRateBean.getDRateSyutokuInfoBean());
        keisanDBean.setTuukasyu(pKhDSeisanBean.getKyktuukasyu());
        keisanDBean.setKihonS(pKhDSeisanBean.getKihons());
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);
        keisanDBean.setHaitouKaisuuBeanList(dRateBean.getHaitouKaisuuBeanLst());

        KeisanD keisanD = getInjectInstanceForInLoop(KeisanD.class);
        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, khozenCommonParam.getKinouNm()));
        }
        haitouKinCalcBean.setHaitoukin(keisanD.getD());

        if (haitouKinCalcBean.getHaitoukin().add(pKhHaitouKanri.getKariwariatedruigk())
            .compareTo(BizCurrency.valueOf(0, pKhHaitouKanri.getKariwariatedruigk().getType())) > 0) {

        }
        else {

            return haitouKinCalcBean;
        }

        KeisanDGanrikin keisanDGanrikin = getInjectInstanceForInLoop(KeisanDGanrikin.class);

        keisanDGanrikin.exec(haitouKinCalcBean.getHaitoukin().add(pKhHaitouKanri.getKariwariatedruigk()),
            pKhHaitouKanri.getKariwariatedshrymd(), pKhDSeisanBean.getSyoumetuymd());

        haitouKinCalcBean.setKariwariatedGanrikin(keisanDGanrikin.getDGanrikin());

        if (C_UmuKbn.ARI.eq(pBerinalUmuFlg)) {

            haitouKinCalcBean.setSeisand(haitouKinCalcBean.getKariwariatedGanrikin().multiply(BizNumber.valueOf(0.75),
                0, RoundingMode.DOWN));
        }
        else {

            haitouKinCalcBean.setSeisand(haitouKinCalcBean.getKariwariatedGanrikin());
        }

        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

        if (C_Tuukasyu.JPY.eq(pKhDSeisanBean.getKyktuukasyu())) {

            haitouKinCalcBean.setSeisandShrTuukasyu(haitouKinCalcBean.getSeisand());
            haitouKinCalcBean.setSeisandKykTuukasyu(haitouKinCalcBean.getSeisand());
        }
        else {

            BizCurrency seisandKykTuukasyu = keisanGaikakanzan.execDivide(pKhDSeisanBean.getKyktuukasyu(),
                haitouKinCalcBean.getSeisand(), pGaikashrkwsrate, C_HasuusyoriKbn.AGE);

            haitouKinCalcBean.setSeisandKykTuukasyu(seisandKykTuukasyu);

            if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

                haitouKinCalcBean.setSeisandShrTuukasyu(haitouKinCalcBean.getSeisand());
            }
            else {

                haitouKinCalcBean.setSeisandShrTuukasyu(haitouKinCalcBean.getSeisandKykTuukasyu());
            }
        }

        KeisanKhGensen keisanKhGensen = SWAKInjector.getInstance(KeisanKhGensen.class);

        if (C_UmuKbn.ARI.eq(pTszeigkUmuFlg)) {

            C_ErrorKbn errorKbn1 = keisanKhGensen.execForDTuibarai(pKhDSeisanBean.getKyktuukasyu(), pYenshrtkumu,
                haitouKinCalcBean.getSeisand(), pZeimukwsrate);

            if (C_ErrorKbn.ERROR.eq(errorKbn1)) {

                throw new CommonBizAppException("源泉徴収額計算が実行できませんでした。" + "証券番号：" +
                    pKhDSeisanBean.getSyono());
            }

            keisanGensenBean.setGensen(keisanKhGensen.getGensen());
            keisanGensenBean.setYenGensen(keisanKhGensen.getYenGensen());
            keisanGensenBean.setYenGsTszeiGkKokuz(keisanKhGensen.getYenGsTszeiGkKokuz());
            keisanGensenBean.setYenGsTszeiGkTihouz(keisanKhGensen.getYenGsTszeiGkTihouz());
        }

        BzShiharaiDenpyouDateShutoku bzShiharaiDenpyouDateShutoku = SWAKInjector
            .getInstance(BzShiharaiDenpyouDateShutoku.class);

        BizDate siharaiYmd = bzShiharaiDenpyouDateShutoku.exec(pSyoriYmd, pShrhousiteiKbn, pTuukasyu, pBankcd);
        haitouKinCalcBean.setSiharaiYmd(siharaiYmd);

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            haitouKinCalcBean.setSeisandShrTuukasyuGensenTusshkg(haitouKinCalcBean.getSeisandShrTuukasyu().subtract(
                keisanGensenBean.getYenGensen()));
        }
        else {

            haitouKinCalcBean.setSeisandShrTuukasyuGensenTusshkg(haitouKinCalcBean.getSeisandShrTuukasyu().subtract(
                keisanGensenBean.getGensen()));
        }

        KeisanTienrisoku keisanTienrisoku = SWAKInjector.getInstance(KeisanTienrisoku.class);

        keisanTienrisokuBean = keisanTienrisoku.execHaitouKin(pKhDSeisanBean.getSyoumetuymd(),
            haitouKinCalcBean.getSiharaiYmd(), haitouKinCalcBean.getSeisandShrTuukasyuGensenTusshkg());

        haitouKinCalcBean.setKeisanTienrisokuBean(keisanTienrisokuBean);

        haitouKinCalcBean.setSiharaiGk(haitouKinCalcBean.getSeisandShrTuukasyuGensenTusshkg().add(
            keisanTienrisokuBean.getShrtienrsk()));

        return haitouKinCalcBean;
    }

    private KhDSeisanTtdktyuuiBean ttdktyuuiHantei(int pTtdktyuuiKensuu, KhDSeisanBean pKhDSeisanBean) {

        KhDSeisanTtdktyuuiBean khDSeisanTtdktyuuiBean = SWAKInjector.getInstance(KhDSeisanTtdktyuuiBean.class);

        IT_KhTtdkTyuui khTtdkTyuui = khozenCommonParam.getKkTetudukiTyuui(pKhDSeisanBean.getSyono());

        if (C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.eq(khTtdkTyuui.getTtdktyuuikbn5())) {

            khDSeisanTtdktyuuiBean.setTtdktyuuiNaiyou(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE.getContent());
            khDSeisanTtdktyuuiBean.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
            khDSeisanTtdktyuuiBean.setTtdktyuuiKensuu(pTtdktyuuiKensuu + 1);

            return khDSeisanTtdktyuuiBean;
        }

        if (C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.HASANOYOBITOUSAN.eq(khTtdkTyuui.getTtdktyuuikbn5())) {

            khDSeisanTtdktyuuiBean.setTtdktyuuiNaiyou(C_TtdktyuuiKbn.HASANOYOBITOUSAN.getContent());
            khDSeisanTtdktyuuiBean.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
            khDSeisanTtdktyuuiBean.setTtdktyuuiKensuu(pTtdktyuuiKensuu + 1);

            return khDSeisanTtdktyuuiBean;
        }

        if (C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.eq(khTtdkTyuui.getTtdktyuuikbn5())) {

            khDSeisanTtdktyuuiBean.setTtdktyuuiNaiyou(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE.getContent());
            khDSeisanTtdktyuuiBean.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
            khDSeisanTtdktyuuiBean.setTtdktyuuiKensuu(pTtdktyuuiKensuu + 1);

            return khDSeisanTtdktyuuiBean;
        }

        if (C_StknsetKbn.ARI.eq(pKhDSeisanBean.getStknsetkbn())) {

            khDSeisanTtdktyuuiBean.setTtdktyuuiNaiyou("質権設定あり");
            khDSeisanTtdktyuuiBean.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.HENSYUUNASI);
            khDSeisanTtdktyuuiBean.setTtdktyuuiKensuu(pTtdktyuuiKensuu + 1);

            return khDSeisanTtdktyuuiBean;
        }

        if (C_KktyuitaKbn.DNGNMEMOARI.eq(khTtdkTyuui.getKktyuitakbn())) {

            khDSeisanTtdktyuuiBean.setTtdktyuuiNaiyou(C_KktyuitaKbn.DNGNMEMOARI.getContent());
            khDSeisanTtdktyuuiBean.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.SYOUMETUJISOUHUSAKI);
            khDSeisanTtdktyuuiBean.setTtdktyuuiKensuu(pTtdktyuuiKensuu + 1);

            return khDSeisanTtdktyuuiBean;
        }

        khDSeisanTtdktyuuiBean.setTtdktyuuiNaiyou("設定なし");
        khDSeisanTtdktyuuiBean.setDseisansouhusakihnsyuKbn(C_DseisansouhusakihnsyuKbn.SYOUMETUJISOUHUSAKI);
        khDSeisanTtdktyuuiBean.setTtdktyuuiKensuu(pTtdktyuuiKensuu);

        return khDSeisanTtdktyuuiBean;
    }

    private void seisanDTuiHrtaisyou(KhDSeisanBean pKhDSeisanBean, String pTtdktyuuiNaiyou,
        C_InputShrhousiteiKbn pInputShrhousiteiKbn, C_Tuukasyu pTuukasyu, HaitouKinCalcBean pHaitouKinCalcBean,
        BizCurrency pSynykngk, BizCurrency pHtykeihi, BizCurrency pGenkykhtykeihi, Integer pKykhnkkaisuu,
        BizNumber pGaikashrkwsrate, BizNumber pZeimukwsrate) {

        SeisanDTuiHrtaisyouBean seisanDTuiHrtaisyouBean = SWAKInjector.getInstance(SeisanDTuiHrtaisyouBean.class);
        seisanDTuiHrtaisyouBean.setIfcYno(pKhDSeisanBean.getTsinyno());
        seisanDTuiHrtaisyouBean.setIfcKyksyamei(pKhDSeisanBean.getKyknmkj());
        seisanDTuiHrtaisyouBean.setIfcSyono(pKhDSeisanBean.getSyono());
        seisanDTuiHrtaisyouBean.setIfcSyoumetujiyuu(pKhDSeisanBean.getSyoumetujiyuu().getContent());
        seisanDTuiHrtaisyouBean.setIfcTtdktyuuinaiyou(pTtdktyuuiNaiyou);
        seisanDTuiHrtaisyouBean.setIfcShrhou(pInputShrhousiteiKbn.getContent());
        seisanDTuiHrtaisyouBean.setIfcTuukasyu(pTuukasyu.getContent());
        seisanDTuiHrtaisyouBean.setIfcShrgkgoukeibizc(pHaitouKinCalcBean.getSiharaiGk());
        seisanDTuiHrtaisyouBean.setIfcYenkahaitoukingkbizc(pHaitouKinCalcBean.getSeisand());
        seisanDTuiHrtaisyouBean.setIfcYenkahaitoukinbizc(pHaitouKinCalcBean.getSeisand());
        seisanDTuiHrtaisyouBean.setIfcYenkasonotahaitoukinbizc(BizCurrency.valueOf(0));
        seisanDTuiHrtaisyouBean.setIfcYenkagstszeigkbizc(pHaitouKinCalcBean.getKeisanGensenBean().getYenGensen());

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            seisanDTuiHrtaisyouBean.setIfcYenkashrtienrskbizc(pHaitouKinCalcBean.getKeisanTienrisokuBean().getShrtienrsk());
            seisanDTuiHrtaisyouBean.setIfcGaikahaitoukingkbizc(BizCurrency.valueOf(0));
            seisanDTuiHrtaisyouBean.setIfcGaikagstszeigkbizc(BizCurrency.valueOf(0));
            seisanDTuiHrtaisyouBean.setIfcGaikashrtienrskbizc(BizCurrency.valueOf(0));
            seisanDTuiHrtaisyouBean.setIfcGaikashrkwsrate(BizNumber.valueOf(0));
            seisanDTuiHrtaisyouBean.setIfcZeimukwsrate(BizNumber.valueOf(0));
        }
        else {

            seisanDTuiHrtaisyouBean.setIfcYenkashrtienrskbizc(BizCurrency.valueOf(0));
            seisanDTuiHrtaisyouBean.setIfcGaikahaitoukingkbizc(pHaitouKinCalcBean.getSeisandShrTuukasyu());
            seisanDTuiHrtaisyouBean.setIfcGaikagstszeigkbizc(pHaitouKinCalcBean.getKeisanGensenBean().getGensen());
            seisanDTuiHrtaisyouBean.setIfcGaikashrtienrskbizc(pHaitouKinCalcBean.getKeisanTienrisokuBean().getShrtienrsk());
            seisanDTuiHrtaisyouBean.setIfcGaikashrkwsrate(pGaikashrkwsrate);
            seisanDTuiHrtaisyouBean.setIfcZeimukwsrate(pZeimukwsrate);
        }

        seisanDTuiHrtaisyouBean.setIfcSynykngkbizc(pSynykngk);
        seisanDTuiHrtaisyouBean.setIfcHtykeihibizc(pHtykeihi);
        seisanDTuiHrtaisyouBean.setIfcGenkykhtykeihibizc(pGenkykhtykeihi);
        seisanDTuiHrtaisyouBean.setIfcKykhnkkaisuu(pKykhnkkaisuu);

        seisanDTuiHrtaisyouBeanLst.add(seisanDTuiHrtaisyouBean);

    }

    private int misslistEdit(int pMisslistOutputCount, String pSyono, C_Dbhanei pDbHaneiKbn, String pMisslistMsg,
        List<EditKhMisslstParam> pMisslistEditLst) {

        int missListOutputCount = pMisslistOutputCount + 1;

        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

        editKhMisslstParam.setDataNo(missListOutputCount);
        editKhMisslstParam.setSeqNo(missListOutputCount);
        editKhMisslstParam.setSyoNo(pSyono);
        editKhMisslstParam.setDBhaneikbn(pDbHaneiKbn);
        editKhMisslstParam.setMisslistMsg(pMisslistMsg);

        pMisslistEditLst.add(editKhMisslstParam);

        return missListOutputCount;
    }

    private void detach(IT_KykKihon pKykKihon, IT_KykSyouhnRireki pKykSyouhnRireki, IT_KhHaitouKanri pKhHaitouKanri,
        JT_SkKihon pJtSkKihon, JT_SiTyousyo pJtSiTyousyo) {

        if (pKykKihon != null) {

            pKykKihon.noCheckDetach();
        }

        if (pKykSyouhnRireki != null) {

            pKykSyouhnRireki.noCheckDetach();
        }

        if (pKhHaitouKanri != null) {

            pKhHaitouKanri.noCheckDetach();
        }

        if (pJtSkKihon != null) {

            pJtSkKihon.noCheckDetach();
        }

        if (pJtSiTyousyo != null) {

            pJtSiTyousyo.noCheckDetach();
        }

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

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
