package yuyu.batch.hozen.khozen.khseisandhanei;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khseisandhanei.dba.KhHaitouKanriBean;
import yuyu.batch.hozen.khozen.khseisandhanei.dba.KhSeisanDHaneiDao;
import yuyu.batch.hozen.khozen.khseisandhanei.dba.KhTumitateDKanriBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.haitou.HaitouDetachProcess;
import yuyu.common.hozen.haitou.KeisanD;
import yuyu.common.hozen.haitou.KeisanDBean;
import yuyu.common.hozen.haitou.KeisanDGanrikin;
import yuyu.common.hozen.haitou.SetDNnd;
import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.haitou.SetHokenNnd;
import yuyu.common.hozen.haitou.SetHokenNnd.HokenNndBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;
import yuyu.def.db.mapping.AbstractExDBEntity;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 精算Ｄ反映
 */
public class KhSeisanDHaneiBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = "IT_KhHaitouKanri";

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private SaisinRecInfo saisinRecInfo = new SaisinRecInfo();

    private long syoriTaisyouSyonoKensuu = 0;

    private long haitouKanriTBLOutKensuu = 0;

    private long tumitateDKanriTBLOutKensuu = 0;

    private long seisanDHaneiTuutiTBLOutKensuu = 0;

    private long kariwaRiateDhaneinenjiHaitouSyoriKensuu = 0;

    private long seisiRiwariateDhaneinenjiHaitouSyoriKensuu = 0;

    private long kariwaRiateDhaneiYendthnkSyoriKensuu = 0;

    private long seisiRiwariateDhaneiYendthnkSyoriKensuu = 0;

    private long kariwaRiateDhaneiGengkSyoriKensuu = 0;

    private HashSet<String> haitouKanriTBLaddTargetSyonoSet = new HashSet<String>();

    private HashSet<String> tumitateDKanriTBLaddTargetSyonoSet = new HashSet<String>();

    private HashSet<AbstractExDBEntity<?,?>> detachTargetEntitySet = new HashSet<AbstractExDBEntity<?,?>>();

    private KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

    private Set<HaitouDetachProcess> haitouDetachProcessInLoopSet = new HashSet<HaitouDetachProcess>();

    private Set<HaitouDetachProcess> haitouDetachProcessOutLoopSet = new HashSet<HaitouDetachProcess>();

    private IT_SeisanDHaneiTuuti seisanDHaneiTuuti = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    protected HozenDomManager hozenDomManager;

    @Inject
    protected KhSeisanDHaneiDao khSeisanDHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @SuppressWarnings("null")
    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();


        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobcd));

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

        BizDateY syoriYmdNoJigyounendo = setKessanNensibi.exec(syoriYmd).getBizDateY();
        Long count = 0L;

        try (
            ExDBResults<KhHaitouKanriBean> khHaitouKanriBeanNaiteiList = khSeisanDHaneiDao
            .getKhHaitouKanriBeans(kakutyoujobcd, syoriYmdNoJigyounendo);
            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            BizCurrency seisikiwariateTaisyouTumitatedKakutei = BizCurrency.valueOf(0);
            BizCurrency seisikiwariateTaisyouTumitatedNaitei = BizCurrency.valueOf(0);
            KhHaitouKanriBean kariWariateKhHaitouKanriKktBeantouNendoKakutei = null;
            String syoriTaisyouSyono = null;

            for (KhHaitouKanriBean khHaitouKanriBeanNaitei : khHaitouKanriBeanNaiteiList) {

                count = count + 1;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHaitouKanriBeanNaitei.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khHaitouKanriBeanNaitei.getSyono());

                if (syoriTaisyouSyono == null || !syoriTaisyouSyono.equals(khHaitouKanriBeanNaitei.getSyono())) {
                    seisanDHaneiTuutiInfoTourokuSyori(multipleEntityInserter);
                    detach();
                    saisinRecInfo = new SaisinRecInfo();

                    seisikiwariateTaisyouTumitatedKakutei = BizCurrency.valueOf(0);
                    seisikiwariateTaisyouTumitatedNaitei = BizCurrency.valueOf(0);
                    kariWariateKhHaitouKanriKktBeantouNendoKakutei = null;
                    syoriTaisyouSyonoKensuu = syoriTaisyouSyonoKensuu + 1;
                    syoriTaisyouSyono = khHaitouKanriBeanNaitei.getSyono();
                }
                if (C_HaitoukinsksKbn.KARIWARIATE1.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn()) ||
                    C_HaitoukinsksKbn.KARIWARIATE2.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn()) ||
                    C_HaitoukinsksKbn.KARIWARIATE3.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn()) ||
                    C_HaitoukinsksKbn.KARIWARIATE4.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn()) ||
                    C_HaitoukinsksKbn.KARIWARIATE5.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn())) {
                    kariWariateRecordSyori(khHaitouKanriBeanNaitei, multipleEntityInserter);
                    kariWariateKhHaitouKanriKktBeantouNendoKakutei = saisinRecInfo
                        .getKhHaitouKanriKktBeanKakutei(khHaitouKanriBeanNaitei.getSyono());
                }
                else if (C_HaitoukinsksKbn.SEISIKI.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn())) {
                    seisikiWariateRecordSyori(khHaitouKanriBeanNaitei, multipleEntityInserter);
                    int kensuu = itibuHikidasiAndZenHikidasiSyori(khHaitouKanriBeanNaitei.getSyono(),
                        multipleEntityInserter);
                    KhHaitouKanriBean khHaitouKanriBean = saisinRecInfo
                        .getKhHaitouKanriKktBeanKakutei(khHaitouKanriBeanNaitei.getSyono());

                    seisikiwariateTaisyouTumitatedKakutei =
                        seisikiwariateTaisyouTumitatedKakutei.add(khHaitouKanriBean.getTounendod());
                    seisikiwariateTaisyouTumitatedNaitei =
                        seisikiwariateTaisyouTumitatedNaitei.add(khHaitouKanriBeanNaitei.getTounendod());
                    seisanDHaneiTuutiInfoSakuseiSyori(
                        khHaitouKanriBeanNaitei.getKbnkey(),
                        khHaitouKanriBeanNaitei.getSyono(),
                        khHaitouKanriBeanNaitei.getHaitounendo(),
                        seisikiwariateTaisyouTumitatedKakutei,
                        seisikiwariateTaisyouTumitatedNaitei,
                        kensuu);
                }
                else if (C_HaitoukinsksKbn.YENDTHNKKARIWARIATE.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn())) {
                    yendthnkKariWariateRecordSyori(khHaitouKanriBeanNaitei, multipleEntityInserter);
                }
                else if (C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn())) {
                    yendthnkSeisikiWariateRecordSyori(khHaitouKanriBeanNaitei, multipleEntityInserter);
                    int kensuu = itibuHikidasiAndZenHikidasiSyori(khHaitouKanriBeanNaitei.getSyono(),
                        multipleEntityInserter);
                    KhHaitouKanriBean khHaitouKanriBean = saisinRecInfo
                        .getKhHaitouKanriKktBeanKakutei(khHaitouKanriBeanNaitei.getSyono());

                    seisikiwariateTaisyouTumitatedKakutei =
                        seisikiwariateTaisyouTumitatedKakutei.add(khHaitouKanriBean.getTounendod());
                    seisikiwariateTaisyouTumitatedNaitei =
                        seisikiwariateTaisyouTumitatedNaitei.add(khHaitouKanriBeanNaitei.getTounendod());
                    seisanDHaneiTuutiInfoSakuseiSyori(
                        khHaitouKanriBeanNaitei.getKbnkey(),
                        khHaitouKanriBeanNaitei.getSyono(),
                        khHaitouKanriBeanNaitei.getHaitounendo(),
                        seisikiwariateTaisyouTumitatedKakutei,
                        seisikiwariateTaisyouTumitatedNaitei,
                        kensuu);
                }
                else if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(khHaitouKanriBeanNaitei.getHaitoukinskskbn())) {
                    kariDshrSyori(khHaitouKanriBeanNaitei,
                        kariWariateKhHaitouKanriKktBeantouNendoKakutei.getTounendod(),
                        multipleEntityInserter);
                }
            }

            seisanDHaneiTuutiInfoTourokuSyori(multipleEntityInserter);

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count), "抽出レコード件数"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriTaisyouSyonoKensuu),
                "抽出契約件数"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(kariwaRiateDhaneinenjiHaitouSyoriKensuu), "仮割当D反映 年次配当"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(seisiRiwariateDhaneinenjiHaitouSyoriKensuu), "正式割当D反映 年次配当"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(kariwaRiateDhaneiYendthnkSyoriKensuu), "仮割当D反映 円建変更"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(seisiRiwariateDhaneiYendthnkSyoriKensuu), "正式割当D反映 円建変更"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(kariwaRiateDhaneiGengkSyoriKensuu), "仮割当D反映 減額"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(haitouKanriTBLOutKensuu),
                "配当管理TBL　レコード件数"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(haitouKanriTBLaddTargetSyonoSet.size()), "配当管理TBL　契約件数"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(tumitateDKanriTBLOutKensuu),
                "積立D管理TBL　レコード件数"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(tumitateDKanriTBLaddTargetSyonoSet.size()), "積立D管理TBL　契約件数"));
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(seisanDHaneiTuutiTBLOutKensuu), "精算Ｄ反映通知TBL　レコード件数"));
        }
    }

    private void kariWariateRecordSyori(KhHaitouKanriBean pKhHaitouKanriBeanNaitei,
        MultipleEntityInserter pMultipleEntityInserter) {

        IT_KhHaitouKanri addTargetkhHaitouKanri = new IT_KhHaitouKanri();
        BizCurrency kariwariatedruigk = null;
        BizDate kijyunYmd = null;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pKhHaitouKanriBeanNaitei.getSyono());

        detachTargetEntitySet.add(kykKihon);

        KykSyouhnCommonParam kykSyouhnCommonParam = getKijyunYmdjitenNoKykSyouhn(kykKihon, C_SyutkKbn.SYU,
            pKhHaitouKanriBeanNaitei.getKariwariatedshrymd().getPreviousDay());

        BizCurrency touNendodKakutei = touNendoDSsy(kykKihon, kykSyouhnCommonParam, pKhHaitouKanriBeanNaitei
            .getKariwariatedshrymd(), pKhHaitouKanriBeanNaitei.getKariwariatedshrymd());

        KhHaitouKanriBean khHaitouKanriBean = saisinRecInfo.getKhHaitouKanriKktBeanKakutei(pKhHaitouKanriBeanNaitei
            .getSyono());

        if (khHaitouKanriBean == null) {
            kariwariatedruigk = BizCurrency.valueOf(0);
        }
        else {
            kariwariatedruigk = khHaitouKanriBean.getKariwariatedruigk();
        }

        if (kykSyouhnCommonParam.getYendthnkymd() != null) {
            kijyunYmd = kykSyouhnCommonParam.getYendthnkymd();
        }
        else {
            kijyunYmd = kykSyouhnCommonParam.getKykymd();
        }
        BizDate tykzenoutouymd = BizDate.valueOf(pKhHaitouKanriBeanNaitei.getKariwariatedshrymd().getBizDateY()
            .addYears(-1), kijyunYmd.getBizDateMD()).getRekijyou();

        KeisanDGanrikin keisanDGanrikin = getInjectInstanceForInLoop(KeisanDGanrikin.class);

        C_ErrorKbn errorKbn = keisanDGanrikin.exec(kariwariatedruigk, tykzenoutouymd,
            pKhHaitouKanriBeanNaitei.getKariwariatedshrymd());

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, khozenCommonParam.getKinouNm()));
        }

        BizCurrency kariwariatedGanriKin = keisanDGanrikin.getDGanrikin();

        addTargetkhHaitouKanri.setKbnkey(pKhHaitouKanriBeanNaitei.getKbnkey());
        addTargetkhHaitouKanri.setSyono(pKhHaitouKanriBeanNaitei.getSyono());
        addTargetkhHaitouKanri.setHaitounendo(pKhHaitouKanriBeanNaitei.getHaitounendo());
        addTargetkhHaitouKanri.setHaitoukinskskbn(pKhHaitouKanriBeanNaitei.getHaitoukinskskbn());
        addTargetkhHaitouKanri.setHaitoumeisaikbn(pKhHaitouKanriBeanNaitei.getHaitoumeisaikbn());
        addTargetkhHaitouKanri.setFstkariwariatednendo(pKhHaitouKanriBeanNaitei.getFstkariwariatednendo());
        addTargetkhHaitouKanri.setTounendod(touNendodKakutei);
        addTargetkhHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        addTargetkhHaitouKanri.setKariwariatedshrymd(pKhHaitouKanriBeanNaitei.getKariwariatedshrymd());
        addTargetkhHaitouKanri.setKariwariatedruigk(kariwariatedGanriKin.add(touNendodKakutei));
        addTargetkhHaitouKanri.setKariwariatedgngkkngk(pKhHaitouKanriBeanNaitei.getKariwariatedgngkkngk());
        addTargetkhHaitouKanri.setKariwariatedshrgk(pKhHaitouKanriBeanNaitei.getKariwariatedshrgk());
        addTargetkhHaitouKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        addTargetkhHaitouKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        addTargetkhHaitouKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
        haitouKanriTBLEntityInserterSyori(addTargetkhHaitouKanri, pMultipleEntityInserter);

        kariwaRiateDhaneinenjiHaitouSyoriKensuu = kariwaRiateDhaneinenjiHaitouSyoriKensuu + 1;
    }

    private void seisikiWariateRecordSyori(KhHaitouKanriBean pKhHaitouKanriBeanNaitei,
        MultipleEntityInserter pMultipleEntityInserter) {

        IT_KhHaitouKanri addTargetkhHaitouKanri = new IT_KhHaitouKanri();
        BizCurrency tumiTatedGanriKin = null;
        IT_KhTumitateDKanri addTargetkhTumitateDKanri = new IT_KhTumitateDKanri();

        KhHaitouKanriBean khHaitouKanriBean = saisinRecInfo.getKhHaitouKanriKktBeanKakutei(pKhHaitouKanriBeanNaitei
            .getSyono());
        BizCurrency kariwariatedruigk = khHaitouKanriBean.getKariwariatedruigk();
        if (kariwariatedruigk.compareTo(BizCurrency.valueOf(0, kariwariatedruigk.getType())) < 0) {
            kariwariatedruigk = BizCurrency.valueOf(0);
        }

        addTargetkhHaitouKanri.setKbnkey(pKhHaitouKanriBeanNaitei.getKbnkey());
        addTargetkhHaitouKanri.setSyono(pKhHaitouKanriBeanNaitei.getSyono());
        addTargetkhHaitouKanri.setHaitounendo(pKhHaitouKanriBeanNaitei.getHaitounendo());
        addTargetkhHaitouKanri.setHaitoukinskskbn(pKhHaitouKanriBeanNaitei.getHaitoukinskskbn());
        addTargetkhHaitouKanri.setHaitoumeisaikbn(pKhHaitouKanriBeanNaitei.getHaitoumeisaikbn());
        addTargetkhHaitouKanri.setFstkariwariatednendo(pKhHaitouKanriBeanNaitei.getFstkariwariatednendo());
        addTargetkhHaitouKanri.setTounendod(kariwariatedruigk);
        addTargetkhHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        addTargetkhHaitouKanri.setKariwariatedshrymd(pKhHaitouKanriBeanNaitei.getKariwariatedshrymd());
        addTargetkhHaitouKanri.setKariwariatedruigk(pKhHaitouKanriBeanNaitei.getKariwariatedruigk());
        addTargetkhHaitouKanri.setKariwariatedgngkkngk(pKhHaitouKanriBeanNaitei.getKariwariatedgngkkngk());
        addTargetkhHaitouKanri.setKariwariatedshrgk(pKhHaitouKanriBeanNaitei.getKariwariatedshrgk());
        addTargetkhHaitouKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        addTargetkhHaitouKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        addTargetkhHaitouKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        haitouKanriTBLEntityInserterSyori(addTargetkhHaitouKanri, pMultipleEntityInserter);

        KhTumitateDKanriBean khTumitateDKanriBean = khSeisanDHaneiDao
            .getKhTumitateDKanriBeanBySyonoTumitatedtumitateymdTumitatedskskbn(pKhHaitouKanriBeanNaitei.getSyono(),
                pKhHaitouKanriBeanNaitei.getKariwariatedshrymd(), C_TumitateDSakuseiKbn.SEISIKI);

        KhTumitateDKanriBean khTumitateDKanriBeanKakutei = saisinRecInfo
            .getKhTumitateDKanriBeanKakutei(pKhHaitouKanriBeanNaitei.getSyono());
        if (khTumitateDKanriBeanKakutei != null) {
            tumiTatedGanriKin = khTumitateDKanriBeanKakutei.getTumitated();
        }
        else {
            tumiTatedGanriKin = BizCurrency.valueOf(0);
        }

        addTargetkhTumitateDKanri.setKbnkey(khTumitateDKanriBean.getKbnkey());
        addTargetkhTumitateDKanri.setSyono(khTumitateDKanriBean.getSyono());
        addTargetkhTumitateDKanri.setTumitatedtumitateymd(khTumitateDKanriBean.getTumitatedtumitateymd());
        addTargetkhTumitateDKanri.setTumitatedskskbn(khTumitateDKanriBean.getTumitatedskskbn());
        addTargetkhTumitateDKanri.setTumitated(tumiTatedGanriKin.add(kariwariatedruigk));
        addTargetkhTumitateDKanri.setTumitatedshrkrkymd(khTumitateDKanriBean.getTumitatedshrkrkymd());
        addTargetkhTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        addTargetkhTumitateDKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        addTargetkhTumitateDKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        addTargetkhTumitateDKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        tumitatedKanriTBLEntityInserterSyori(addTargetkhTumitateDKanri, pMultipleEntityInserter);
        seisiRiwariateDhaneinenjiHaitouSyoriKensuu = seisiRiwariateDhaneinenjiHaitouSyoriKensuu + 1;
    }

    private void yendthnkKariWariateRecordSyori(KhHaitouKanriBean pKhHaitouKanriBeanNaitei,
        MultipleEntityInserter pMultipleEntityInserter) {

        BizDate yendthnkymd = pKhHaitouKanriBeanNaitei.getKariwariatedshrymd();
        BizDate mkhgktttymd = pKhHaitouKanriBeanNaitei.getKariwariatedshrymd().getPreviousDay();
        IT_KhHaitouKanri addTargetkhHaitouKanri = new IT_KhHaitouKanri();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pKhHaitouKanriBeanNaitei.getSyono());
        detachTargetEntitySet.add(kykKihon);
        KykSyouhnCommonParam kykSyouhnCommonParam = getKijyunYmdjitenNoKykSyouhn(kykKihon, C_SyutkKbn.SYU,
            mkhgktttymd);
        BizCurrency touNendodKakutei = touNendoDSsy(kykKihon, kykSyouhnCommonParam, yendthnkymd, yendthnkymd);
        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        BizDate outouymd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, kykSyouhnCommonParam.getKykymd(), C_Hrkkaisuu.NEN,
            mkhgktttymd);
        BizCurrency kariwariatedruigk = saisinRecInfo
            .getKhHaitouKanriKktBeanKakutei(pKhHaitouKanriBeanNaitei.getSyono())
            .getKariwariatedruigk();

        KeisanDGanrikin keisanDGanrikin = getInjectInstanceForInLoop(KeisanDGanrikin.class);
        C_ErrorKbn errorKbn = keisanDGanrikin.exec(kariwariatedruigk, outouymd, yendthnkymd);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, khozenCommonParam.getKinouNm()));
        }
        BizCurrency kariwariatedGanriKin = keisanDGanrikin.getDGanrikin();

        addTargetkhHaitouKanri.setKbnkey(pKhHaitouKanriBeanNaitei.getKbnkey());
        addTargetkhHaitouKanri.setSyono(pKhHaitouKanriBeanNaitei.getSyono());
        addTargetkhHaitouKanri.setHaitounendo(pKhHaitouKanriBeanNaitei.getHaitounendo());
        addTargetkhHaitouKanri.setHaitoukinskskbn(pKhHaitouKanriBeanNaitei.getHaitoukinskskbn());
        addTargetkhHaitouKanri.setHaitoumeisaikbn(pKhHaitouKanriBeanNaitei.getHaitoumeisaikbn());
        addTargetkhHaitouKanri.setFstkariwariatednendo(pKhHaitouKanriBeanNaitei.getFstkariwariatednendo());
        addTargetkhHaitouKanri.setTounendod(touNendodKakutei);
        addTargetkhHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        addTargetkhHaitouKanri.setKariwariatedshrymd(pKhHaitouKanriBeanNaitei.getKariwariatedshrymd());
        addTargetkhHaitouKanri.setKariwariatedruigk(kariwariatedGanriKin.add(touNendodKakutei));
        addTargetkhHaitouKanri.setKariwariatedgngkkngk(pKhHaitouKanriBeanNaitei.getKariwariatedgngkkngk());
        addTargetkhHaitouKanri.setKariwariatedshrgk(pKhHaitouKanriBeanNaitei.getKariwariatedshrgk());
        addTargetkhHaitouKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        addTargetkhHaitouKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        addTargetkhHaitouKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        haitouKanriTBLEntityInserterSyori(addTargetkhHaitouKanri, pMultipleEntityInserter);
        kariwaRiateDhaneiYendthnkSyoriKensuu = kariwaRiateDhaneiYendthnkSyoriKensuu + 1;
    }

    private void yendthnkSeisikiWariateRecordSyori(KhHaitouKanriBean pKhHaitouKanriBeanNaitei,
        MultipleEntityInserter pMultipleEntityInserter) {

        IT_KhHaitouKanri addTargetkhHaitouKanri = new IT_KhHaitouKanri();
        BizCurrency tumiTatedGanriKin = null;
        IT_KhTumitateDKanri addTargetkhTumitateDKanri = new IT_KhTumitateDKanri();

        BizCurrency kariwariatedruigk = saisinRecInfo
            .getKhHaitouKanriKktBeanKakutei(pKhHaitouKanriBeanNaitei.getSyono())
            .getKariwariatedruigk();
        if (kariwariatedruigk.compareTo(BizCurrency.valueOf(0, kariwariatedruigk.getType())) < 0) {
            kariwariatedruigk = BizCurrency.valueOf(0);
        }

        addTargetkhHaitouKanri.setKbnkey(pKhHaitouKanriBeanNaitei.getKbnkey());
        addTargetkhHaitouKanri.setSyono(pKhHaitouKanriBeanNaitei.getSyono());
        addTargetkhHaitouKanri.setHaitounendo(pKhHaitouKanriBeanNaitei.getHaitounendo());
        addTargetkhHaitouKanri.setHaitoukinskskbn(pKhHaitouKanriBeanNaitei.getHaitoukinskskbn());
        addTargetkhHaitouKanri.setHaitoumeisaikbn(pKhHaitouKanriBeanNaitei.getHaitoumeisaikbn());
        addTargetkhHaitouKanri.setFstkariwariatednendo(pKhHaitouKanriBeanNaitei.getFstkariwariatednendo());
        addTargetkhHaitouKanri.setTounendod(kariwariatedruigk);
        addTargetkhHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        addTargetkhHaitouKanri.setKariwariatedshrymd(pKhHaitouKanriBeanNaitei.getKariwariatedshrymd());
        addTargetkhHaitouKanri.setKariwariatedruigk(pKhHaitouKanriBeanNaitei.getKariwariatedruigk());
        addTargetkhHaitouKanri.setKariwariatedgngkkngk(pKhHaitouKanriBeanNaitei.getKariwariatedgngkkngk());
        addTargetkhHaitouKanri.setKariwariatedshrgk(pKhHaitouKanriBeanNaitei.getKariwariatedshrgk());
        addTargetkhHaitouKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        addTargetkhHaitouKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        addTargetkhHaitouKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        haitouKanriTBLEntityInserterSyori(addTargetkhHaitouKanri, pMultipleEntityInserter);
        KhTumitateDKanriBean khTumitateDKanriBeanNaitei = khSeisanDHaneiDao
            .getKhTumitateDKanriBeanBySyonoTumitatedtumitateymdTumitatedskskbn(pKhHaitouKanriBeanNaitei.getSyono(),
                pKhHaitouKanriBeanNaitei.getKariwariatedshrymd(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        KhTumitateDKanriBean khTumitateDKanriBeanKakutei = saisinRecInfo
            .getKhTumitateDKanriBeanKakutei(pKhHaitouKanriBeanNaitei.getSyono());
        if (khTumitateDKanriBeanKakutei != null) {
            KeisanDGanrikin keisanDGanrikin = getInjectInstanceForInLoop(KeisanDGanrikin.class);
            C_ErrorKbn errorKbn = keisanDGanrikin.exec(khTumitateDKanriBeanKakutei.getTumitated(),
                khTumitateDKanriBeanKakutei.getTumitatedtumitateymd(),
                khTumitateDKanriBeanNaitei.getTumitatedtumitateymd());
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                    khozenCommonParam.getKinouNm()));
            }
            tumiTatedGanriKin = keisanDGanrikin.getDGanrikin();
        }
        else {
            tumiTatedGanriKin = BizCurrency.valueOf(0);
        }
        addTargetkhTumitateDKanri.setKbnkey(khTumitateDKanriBeanNaitei.getKbnkey());
        addTargetkhTumitateDKanri.setSyono(khTumitateDKanriBeanNaitei.getSyono());
        addTargetkhTumitateDKanri.setTumitatedtumitateymd(khTumitateDKanriBeanNaitei.getTumitatedtumitateymd());
        addTargetkhTumitateDKanri.setTumitatedskskbn(khTumitateDKanriBeanNaitei.getTumitatedskskbn());
        addTargetkhTumitateDKanri.setTumitated(tumiTatedGanriKin.add(kariwariatedruigk));
        addTargetkhTumitateDKanri.setTumitatedshrkrkymd(khTumitateDKanriBeanNaitei.getTumitatedshrkrkymd());
        addTargetkhTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        addTargetkhTumitateDKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        addTargetkhTumitateDKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        addTargetkhTumitateDKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        tumitatedKanriTBLEntityInserterSyori(addTargetkhTumitateDKanri, pMultipleEntityInserter);
        seisiRiwariateDhaneiYendthnkSyoriKensuu = seisiRiwariateDhaneiYendthnkSyoriKensuu + 1;
    }

    private void kariDshrSyori(KhHaitouKanriBean pKhHaitouKanriBeanNaitei, BizCurrency pTykzenoutouYmdTounendodKakutei,
        MultipleEntityInserter pMultipleEntityInserter) {

        IT_KhHaitouKanri khHaitouKanri = new IT_KhHaitouKanri();

        khHaitouKanri.setKbnkey(pKhHaitouKanriBeanNaitei.getKbnkey());
        khHaitouKanri.setSyono(pKhHaitouKanriBeanNaitei.getSyono());
        khHaitouKanri.setHaitounendo(pKhHaitouKanriBeanNaitei.getHaitounendo());
        khHaitouKanri.setHaitoukinskskbn(pKhHaitouKanriBeanNaitei.getHaitoukinskskbn());
        khHaitouKanri.setHaitoumeisaikbn(pKhHaitouKanriBeanNaitei.getHaitoumeisaikbn());
        khHaitouKanri.setFstkariwariatednendo(pKhHaitouKanriBeanNaitei.getFstkariwariatednendo());
        khHaitouKanri.setTounendod(pKhHaitouKanriBeanNaitei.getTounendod());
        khHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        khHaitouKanri.setKariwariatedshrymd(pKhHaitouKanriBeanNaitei.getKariwariatedshrymd());
        khHaitouKanri.setKariwariatedruigk(pKhHaitouKanriBeanNaitei.getKariwariatedruigk().add(
            pTykzenoutouYmdTounendodKakutei));
        khHaitouKanri.setKariwariatedgngkkngk(pKhHaitouKanriBeanNaitei.getKariwariatedgngkkngk());
        khHaitouKanri.setKariwariatedshrgk(pKhHaitouKanriBeanNaitei.getKariwariatedshrgk());
        khHaitouKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        khHaitouKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        khHaitouKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        haitouKanriTBLEntityInserterSyori(khHaitouKanri, pMultipleEntityInserter);
        kariwaRiateDhaneiGengkSyoriKensuu = kariwaRiateDhaneiGengkSyoriKensuu + 1;
    }

    private int itibuHikidasiAndZenHikidasiSyori(String pSyono, MultipleEntityInserter pMultipleEntityInserter) {

        KhTumitateDKanriBean khTumitateDKanriBean = saisinRecInfo.getKhTumitateDKanriBeanKakutei(pSyono);
        List<KhTumitateDKanriBean> khTumitateDKanriBeanList = khSeisanDHaneiDao
            .getKhTumitateDKanriBeansBySyonoTumitatedtumitateymdTumitatedskskbn(pSyono,
                khTumitateDKanriBean.getTumitatedtumitateymd());
        if (khTumitateDKanriBeanList.size() > 0) {

            List<IT_KhShrRireki> khShrRirekiList = khSeisanDHaneiDao.getKhShrRirekisBySyonoShrsyoriymd(pSyono,
                khTumitateDKanriBean.getTumitatedtumitateymd());

            int doujituCount = 0;
            BizDate tumitatedshrkrkymd = null;

            for (int n = 0; n < khTumitateDKanriBeanList.size(); n++) {

                IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();

                KhTumitateDKanriBean khTumitateDKanriBeanHikidasi = khTumitateDKanriBeanList.get(n);

                if (tumitatedshrkrkymd == null
                    || !tumitatedshrkrkymd.equals(khTumitateDKanriBeanHikidasi.getTumitatedshrkrkymd())) {
                    doujituCount = 0;
                    tumitatedshrkrkymd = khTumitateDKanriBeanHikidasi.getTumitatedshrkrkymd();
                } else {
                    doujituCount++;
                }

                BizCurrency hikidasikg = getHikidasikgList(khTumitateDKanriBeanHikidasi.getTumitatedshrkrkymd(),
                    khShrRirekiList).get(doujituCount);

                BizCurrency tumitated = hikiDasiGoTumitateDSsy(saisinRecInfo.getKhTumitateDKanriBeanKakutei(pSyono)
                    .getTumitated(),
                    khTumitateDKanriBeanHikidasi.getTumitatedtumitateymd(),
                    khTumitateDKanriBeanHikidasi.getTumitatedshrkrkymd(),
                    hikidasikg);

                khTumitateDKanri.setKbnkey(khTumitateDKanriBeanHikidasi.getKbnkey());
                khTumitateDKanri.setSyono(khTumitateDKanriBeanHikidasi.getSyono());
                khTumitateDKanri.setTumitatedtumitateymd(khTumitateDKanriBeanHikidasi.getTumitatedtumitateymd());
                khTumitateDKanri.setTumitatedskskbn(khTumitateDKanriBeanHikidasi.getTumitatedskskbn());
                khTumitateDKanri.setTumitated(tumitated);
                khTumitateDKanri.setTumitatedshrkrkymd(khTumitateDKanriBeanHikidasi.getTumitatedshrkrkymd());
                khTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
                khTumitateDKanri.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khTumitateDKanri.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khTumitateDKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                tumitatedKanriTBLEntityInserterSyori(khTumitateDKanri, pMultipleEntityInserter);
            }

        }
        return khTumitateDKanriBeanList.size();
    }

    private List<BizCurrency> getHikidasikgList(BizDate pShrsyoriymd, List<IT_KhShrRireki> pKhShrRirekiList) {

        List<BizCurrency> hikidasikgList = new ArrayList<>();

        for (IT_KhShrRireki khShrRireki : pKhShrRirekiList) {
            if (khShrRireki.getShrsyoriymd().equals(pShrsyoriymd)) {
                hikidasikgList.add(khShrRireki.getHaitoukin());
            }
        }
        return hikidasikgList;
    }

    private BizCurrency hikiDasiGoTumitateDSsy(BizCurrency pRuigk, BizDate pTumitatedtumitateymd,
        BizDate pTumitatedshrkrkymd, BizCurrency pHikidasikg) {

        KeisanDGanrikin keisanDGanrikin = getInjectInstanceForInLoop(KeisanDGanrikin.class);
        C_ErrorKbn errorKbn = keisanDGanrikin.exec(pRuigk, pTumitatedtumitateymd, pTumitatedshrkrkymd);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, khozenCommonParam.getKinouNm()));
        }
        BizCurrency tumiTatedGanriKin = keisanDGanrikin.getDGanrikin();
        BizNumber haitouriritu = keisanDGanrikin.getHaitouRirituList().get(0);
        BizCurrency wrmdsMaeTumitated = tumiTatedGanriKin.subtract(pHikidasikg);
        BizCurrency wrmdsAtoTumitated = wrmdsMaeTumitated.divide(haitouriritu.add(BizNumber.valueOf(1)), 0,
            RoundingMode.UP);
        return wrmdsAtoTumitated;
    }

    private BizCurrency touNendoDSsy(IT_KykKihon pKykKihon, KykSyouhnCommonParam pKykSyouhnCommonParam,
        BizDate pCalckiJyunYmd, BizDate pDrateKijyunYmd) {

        KhHaitouKanriBean khHaitouKanriBean = saisinRecInfo
            .getKhHaitouKanriKktBeanKakutei(pKykKihon.getSyono());

        BizDateY tyokuzenHaitounendo;

        if (khHaitouKanriBean == null) {
            BizDate kykymd = pKykSyouhnCommonParam.getKykymd();

            SetHokenNnd setHokenNnd = getInjectInstanceForInLoop(SetHokenNnd.class);
            HokenNndBean hokenNndBean = setHokenNnd.exec(kykymd, kykymd);

            if (hokenNndBean == null) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                    khozenCommonParam.getKinouNm()));
            }

            tyokuzenHaitounendo = hokenNndBean.getHokenNnd();
        } else {
            tyokuzenHaitounendo = khHaitouKanriBean.getHaitounendo();
        }

        SetDNnd setDNnd = getInjectInstanceForInLoop(SetDNnd.class);
        DRateBean drateNendoCount = setDNnd.exec(pKykSyouhnCommonParam.getSyouhncd(),
            pKykSyouhnCommonParam.getRyouritusdno(), pKykSyouhnCommonParam.getYoteiriritu(),
            pKykKihon.getHrkkaisuu(), pKykSyouhnCommonParam.getHhknsei(), pKykSyouhnCommonParam.getHhknnen(),
            pKykSyouhnCommonParam.getHknkknsmnkbn(), pKykSyouhnCommonParam.getHknkkn(),
            pKykSyouhnCommonParam.getHrkkkn(), pKykSyouhnCommonParam.getKykjyoutai(),
            pKykSyouhnCommonParam.getHrkkknsmnkbn(), pKykSyouhnCommonParam.getKyktuukasyu(),
            pKykSyouhnCommonParam.getDai1hknkkn(), pDrateKijyunYmd, pKykSyouhnCommonParam.getKykymd(),
            pKykSyouhnCommonParam.getYendthnkymd(), tyokuzenHaitounendo, pCalckiJyunYmd, bzBatchParam.getSyoriYmd(),
            C_UmuKbn.ARI);

        if (drateNendoCount == null) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, khozenCommonParam.getKinouNm()));
        }

        KeisanDBean keisanDBean = new KeisanDBean();
        KeisanD keisanD = getInjectInstanceForInLoop(KeisanD.class);
        keisanDBean.setDRateSyutokuInfoBean(drateNendoCount.getDRateSyutokuInfoBean());
        keisanDBean.setTuukasyu(pKykSyouhnCommonParam.getKyktuukasyu());
        keisanDBean.setKihonS(pKykSyouhnCommonParam.getKihons());
        keisanDBean.setKsnSiyouUmu(C_UmuKbn.NONE);
        keisanDBean.setHaitouKaisuuBeanList(drateNendoCount.getHaitouKaisuuBeanLst());

        C_ErrorKbn errorKbn = keisanD.exec(keisanDBean);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129, khozenCommonParam.getKinouNm()));
        }
        return keisanD.getD();
    }

    private KykSyouhnCommonParam getKijyunYmdjitenNoKykSyouhn(IT_KykKihon pKykKihon, C_SyutkKbn pSyutkKbn,
        BizDate pKijyunYmd) {

        KykSyouhnCommonParam kykSyouhnCommonParam = pKykKihon.getKykSyouhnsBySyutkkbn(pSyutkKbn).get(0);

        if (BizDateUtil.compareYmd(
            kykSyouhnCommonParam.getKouryokuhasseiymd(), pKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(
                kykSyouhnCommonParam.getKouryokuhasseiymd(), pKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {
            return kykSyouhnCommonParam;
        }
        IT_KykSyouhnRireki kykSyouhnRireki = khSeisanDHaneiDao.getKykSyouhnRirekiBySyonoKijyunymd(pKykKihon.getSyono(),
            pKijyunYmd);
        detachTargetEntitySet.add(kykSyouhnRireki);

        return kykSyouhnRireki;
    }

    private void haitouKanriTBLEntityInserterSyori(IT_KhHaitouKanri pKhHaitouKanri,
        MultipleEntityInserter pMultipleEntityInserter) {

        Integer renban = saisinRecInfo.getSaisinKhHaitouKanriKktRenno(pKhHaitouKanri.getSyono(),
            pKhHaitouKanri.getHaitounendo()) + 1;
        pKhHaitouKanri.setRenno(renban);
        saisinRecInfo.setSaisinKhHaitouKanriKktRenno(renban);

        BizPropertyInitializer.initialize(pKhHaitouKanri);

        pMultipleEntityInserter.add(pKhHaitouKanri);
        haitouKanriTBLOutKensuu = haitouKanriTBLOutKensuu + 1;
        haitouKanriTBLaddTargetSyonoSet.add(pKhHaitouKanri.getSyono());

        saisinRecInfo.setKhHaitouKanriKktBeanKakutei(khHaitouKanriBeanSakuseiSyori(pKhHaitouKanri));
    }

    private void tumitatedKanriTBLEntityInserterSyori(IT_KhTumitateDKanri pKhTumitateDKanri,
        MultipleEntityInserter pMultipleEntityInserter) {

        Integer renban = saisinRecInfo.getSaisinKhTumitateDKanriRenno(pKhTumitateDKanri.getSyono(),
            pKhTumitateDKanri.getTumitatedtumitateymd()) + 1;
        pKhTumitateDKanri.setRenno(renban);
        saisinRecInfo.setSaisinKhTumitateDKanriRennoMap(pKhTumitateDKanri.getTumitatedtumitateymd(), renban);

        BizPropertyInitializer.initialize(pKhTumitateDKanri);

        pMultipleEntityInserter.add(pKhTumitateDKanri);
        tumitateDKanriTBLOutKensuu = tumitateDKanriTBLOutKensuu + 1;
        tumitateDKanriTBLaddTargetSyonoSet.add(pKhTumitateDKanri.getSyono());
        saisinRecInfo.setKhTumitateDKanriBeanKakutei(khTumitateDKanriBeanSakuseiSyori(pKhTumitateDKanri));
    }

    private KhHaitouKanriBean khHaitouKanriBeanSakuseiSyori(IT_KhHaitouKanri pKhHaitouKanri) {

        KhHaitouKanriBean khHaitouKanriBean = new KhHaitouKanriBean();

        khHaitouKanriBean.setKbnkey(pKhHaitouKanri.getKbnkey());
        khHaitouKanriBean.setSyono(pKhHaitouKanri.getSyono());
        khHaitouKanriBean.setHaitounendo(pKhHaitouKanri.getHaitounendo());
        khHaitouKanriBean.setRenno(pKhHaitouKanri.getRenno());
        khHaitouKanriBean.setHaitoukinskskbn(pKhHaitouKanri.getHaitoukinskskbn());
        khHaitouKanriBean.setHaitoumeisaikbn(pKhHaitouKanri.getHaitoumeisaikbn());
        khHaitouKanriBean.setFstkariwariatednendo(pKhHaitouKanri.getFstkariwariatednendo());
        khHaitouKanriBean.setTounendod(pKhHaitouKanri.getTounendod());
        khHaitouKanriBean.setNaiteikakuteikbn(pKhHaitouKanri.getNaiteikakuteikbn());
        khHaitouKanriBean.setKariwariatedshrymd(pKhHaitouKanri.getKariwariatedshrymd());
        khHaitouKanriBean.setKariwariatedruigk(pKhHaitouKanri.getKariwariatedruigk());
        khHaitouKanriBean.setKariwariatedgngkkngk(pKhHaitouKanri.getKariwariatedgngkkngk());
        khHaitouKanriBean.setKariwariatedshrgk(pKhHaitouKanri.getKariwariatedshrgk());

        return khHaitouKanriBean;
    }

    private KhTumitateDKanriBean khTumitateDKanriBeanSakuseiSyori(IT_KhTumitateDKanri pKhTumitateDKanri) {

        KhTumitateDKanriBean khTumitateDKanriBean = new KhTumitateDKanriBean();

        khTumitateDKanriBean.setKbnkey(pKhTumitateDKanri.getKbnkey());
        khTumitateDKanriBean.setSyono(pKhTumitateDKanri.getSyono());
        khTumitateDKanriBean.setTumitatedtumitateymd(pKhTumitateDKanri.getTumitatedtumitateymd());
        khTumitateDKanriBean.setRenno(pKhTumitateDKanri.getRenno());
        khTumitateDKanriBean.setTumitatedskskbn(pKhTumitateDKanri.getTumitatedskskbn());
        khTumitateDKanriBean.setTumitated(pKhTumitateDKanri.getTumitated());
        khTumitateDKanriBean.setTumitatedshrkrkymd(pKhTumitateDKanri.getTumitatedshrkrkymd());
        khTumitateDKanriBean.setNaiteikakuteikbn(pKhTumitateDKanri.getNaiteikakuteikbn());

        return khTumitateDKanriBean;
    }

    private void seisanDHaneiTuutiInfoSakuseiSyori(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo,
        BizCurrency pSeisikiwariateTaisyouTumitatedKakutei, BizCurrency pSeisikiwariateTaisyouTumitatedNaitei, int pKensuu) {

        if (pKensuu > 0) {
            BizCurrency seisikiwariateTaisyouTumitatedSagaku =
                pSeisikiwariateTaisyouTumitatedKakutei.subtract(pSeisikiwariateTaisyouTumitatedNaitei);

            if (seisikiwariateTaisyouTumitatedSagaku.compareTo(
                BizCurrency.valueOf(0, seisikiwariateTaisyouTumitatedSagaku.getType())) > 0) {
                seisanDHaneiTuuti = new IT_SeisanDHaneiTuuti(pKbnkey, pSyono, pHaitounendo);
                seisanDHaneiTuuti.setKakuteitounendod(pSeisikiwariateTaisyouTumitatedKakutei);
                seisanDHaneiTuuti.setNaiteitounendod(pSeisikiwariateTaisyouTumitatedNaitei);
                seisanDHaneiTuuti.setSeisandkgk(seisikiwariateTaisyouTumitatedSagaku);
                seisanDHaneiTuuti.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                seisanDHaneiTuuti.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                seisanDHaneiTuuti.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            }
        }
    }

    private void seisanDHaneiTuutiInfoTourokuSyori(MultipleEntityInserter pMultipleEntityInserter) {

        if (seisanDHaneiTuuti != null) {
            pMultipleEntityInserter.add(seisanDHaneiTuuti);
            seisanDHaneiTuuti = null;
            seisanDHaneiTuutiTBLOutKensuu = seisanDHaneiTuutiTBLOutKensuu + 1;
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void detach() {

        for (AbstractExDBEntity abstractExDBEntity : detachTargetEntitySet) {
            if (hozenDomManager.isManaged(abstractExDBEntity)) {
                abstractExDBEntity.detach();
            }
        }
        detachTargetEntitySet = new HashSet<AbstractExDBEntity<?, ?>>();
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

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class SaisinRecInfo {

        private KhHaitouKanriBean khHaitouKanriKktBeanKakutei;

        private KhTumitateDKanriBean khTumitateDKanriBeanKakutei;

        private Integer saisinKhHaitouKanriKktRenno;

        private Map<BizDate, Integer> saisinKhTumitateDKanriRennoMap = new HashMap<BizDate, Integer>();

        public KhHaitouKanriBean getKhHaitouKanriKktBeanKakutei(String pSyono) {

            if (khHaitouKanriKktBeanKakutei == null) {
                khHaitouKanriKktBeanKakutei = khSeisanDHaneiDao.getKhHaitouKanriBeanBySyonoHaitoumeisaikbn(pSyono,
                    C_HaitoumeisaiKbn.SYU);
            }
            return khHaitouKanriKktBeanKakutei;
        }

        public KhTumitateDKanriBean getKhTumitateDKanriBeanKakutei(String pSyono) {

            if (khTumitateDKanriBeanKakutei == null) {
                khTumitateDKanriBeanKakutei = khSeisanDHaneiDao.getKhTumitateDKanriBeanBySyono(pSyono);
            }
            return khTumitateDKanriBeanKakutei;
        }

        public Integer getSaisinKhHaitouKanriKktRenno(String pSyono, BizDateY pHaitounendo) {

            if (saisinKhHaitouKanriKktRenno == null) {
                saisinKhHaitouKanriKktRenno = khSeisanDHaneiDao
                    .getKhHaitouKanriRennoBySyonoHaitoumeisaikbnHhaitounendo(
                        pSyono, C_HaitoumeisaiKbn.SYU, pHaitounendo);
            }
            return saisinKhHaitouKanriKktRenno;
        }

        public Integer getSaisinKhTumitateDKanriRenno(String pSyono, BizDate pKariwariatedshrymd) {

            if (!saisinKhTumitateDKanriRennoMap.containsKey(pKariwariatedshrymd)) {
                Integer renno = khSeisanDHaneiDao.getKhTumitateDKanriRennoBySyonoTumitatedtumitateymd(
                    pSyono, pKariwariatedshrymd);
                saisinKhTumitateDKanriRennoMap.put(pKariwariatedshrymd, renno);
            }
            return saisinKhTumitateDKanriRennoMap.get(pKariwariatedshrymd);
        }

        public void setKhHaitouKanriKktBeanKakutei(KhHaitouKanriBean pKhHaitouKanriKktBeanKakutei) {
            this.khHaitouKanriKktBeanKakutei = pKhHaitouKanriKktBeanKakutei;
        }

        public void setKhTumitateDKanriBeanKakutei(KhTumitateDKanriBean pKhTumitateDKanriBeanKakutei) {
            this.khTumitateDKanriBeanKakutei = pKhTumitateDKanriBeanKakutei;
        }

        public void setSaisinKhHaitouKanriKktRenno(Integer pSaisinKhHaitouKanriKktRenno) {
            this.saisinKhHaitouKanriKktRenno = pSaisinKhHaitouKanriKktRenno;
        }

        public void setSaisinKhTumitateDKanriRennoMap(BizDate pKariwariatedshrymd, Integer pRenban) {
            this.saisinKhTumitateDKanriRennoMap.put(pKariwariatedshrymd, pRenban);
        }

    }
}
