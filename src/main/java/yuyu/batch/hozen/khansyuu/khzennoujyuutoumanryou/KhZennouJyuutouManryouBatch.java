package yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou.dba.KhZennouJyuutouManryouDao;
import yuyu.batch.hozen.khansyuu.khzennoujyuutoumanryou.dba.ZennouJyuutouManryouDataBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditDairitenTesuuryouTbl;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.ZennouKoujyogakuKeisanParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 契約保全 案内収納 前納充当・満了処理
 */
public class KhZennouJyuutouManryouBatch implements Batch {

    private static final String TABLEID = IT_KykKihon.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhZennouJyuutouManryouDao khZennouJyuutouManryouDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        String kinouID = khozenCommonParam.getFunctionId();
        String kosID = khozenCommonParam.getUserID();
        String kosTime = BizDate.getSysDateTimeMilli();
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        BizDateYM syoriYM = syoriYMD.getBizDateYM();
        long zennouJyuutouSyoriKensuu = 0;
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), ibKakutyoujobcd));

        try (ExDBResults<ZennouJyuutouManryouDataBean> zennouJyuutouManryouDataBeanList =
            khZennouJyuutouManryouDao.getZennouJyuutouManryouDataBeans(syoriYM, ibKakutyoujobcd);

            EntityInserter<IT_KhDenpyoData> khDenpyoDataEntityInserter = new EntityInserter<>();
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

            CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = null;
            CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
            HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

            for (ZennouJyuutouManryouDataBean zennouJyuutouManryouDataBean : zennouJyuutouManryouDataBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(zennouJyuutouManryouDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(zennouJyuutouManryouDataBean.getSyono());

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(zennouJyuutouManryouDataBean.getSyono());

                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

                List<IT_KykSyouhn> kykSyouhnLst = khZennouJyuutouManryouDao.getKykSyouhns(kykKihon);
                IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);
                BizDate kykOutoubiZenYmd = BizDate.valueOf(zennouJyuutouManryouDataBean.getJikaipym(), kykSyouhn.getKykymd().getDay()).getRekijyou().addBusinessDays(-1);
                BizDate skipEndOutoubiZenYmd = BizDate.valueOf(zennouJyuutouManryouDataBean.getJikaipym().addMonths(3), kykSyouhn.getKykymd().getDay()).getRekijyou().addBusinessDays(-1);

                if (((BizDateUtil.compareYmd(kykOutoubiZenYmd, syoriYMD) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(kykOutoubiZenYmd, syoriYMD) == BizDateUtil.COMPARE_EQUAL) &&
                    (BizDateUtil.compareYmd(syoriYMD, skipEndOutoubiZenYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(syoriYMD, skipEndOutoubiZenYmd) == BizDateUtil.COMPARE_EQUAL)) ||
                    BizDateUtil.compareYm(zennouJyuutouManryouDataBean.getJikaipym(), zennouJyuutouManryouDataBean.getAnnaisaikaiym()) == BizDateUtil.COMPARE_EQUAL) {
                    checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                    checkYuukouJyoutaiParam.setSyono(zennouJyuutouManryouDataBean.getSyono());
                    C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam,
                        checkYuukouJyoutaiParam);
                    if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                        if (BizDateUtil.compareYmd(skipEndOutoubiZenYmd, syoriYMD) == BizDateUtil.COMPARE_LESSER ||
                            BizDateUtil.compareYmd(skipEndOutoubiZenYmd, syoriYMD) == BizDateUtil.COMPARE_EQUAL) {

                            EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.
                                getInstance(EditJimuRenrakusyuunouParam.class);

                            EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.
                                getInstance(EditJimuRenrakusyuunou.class);

                            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

                            List<String> jimurenrakuMsgLst = Lists.newArrayList();

                            jimurenrakuMsgLst.add("前納充当・満了処理でエラーが発生しました。");
                            jimurenrakuMsgLst.add("次回Ｐ充当年月を確認の上、訂正して下さい。");

                            editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimurenrakuMsgLst);

                            ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(
                                khozenCommonParam,
                                zennouJyuutouManryouDataBean.getSyono(),
                                C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,
                                editJimuRenrakusyuunouParam ,
                                syoriYMD);

                            createReport.execNoCommit(reportServicesBean);
                        }
                        checkYuukouJyoutai.detachAllEntities(zennouJyuutouManryouDataBean.getSyono());

                        continue;
                    }

                    C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam,
                        zennouJyuutouManryouDataBean.getSyono());

                    if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
                        continue;
                    }

                    IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(
                        zennouJyuutouManryouDataBean.getSyono());

                    khozenCommonParam.setSikibetuKey(null);
                    khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                    List<IT_KhDenpyoData> khDenpyoDataList = Lists.newArrayList();
                    C_YouhiKbn youhiKbn = C_YouhiKbn.HUYOU;
                    C_SyoriKbn syoriKbn = C_SyoriKbn.BLNK;

                    if (BizDateUtil.compareYm(zennouJyuutouManryouDataBean.getJikaipym(), zennouJyuutouManryouDataBean.getAnnaisaikaiym()) != BizDateUtil.COMPARE_EQUAL) {

                        IT_NyknJissekiRireki maxrenbannyknJissekiRireki =
                            khZennouJyuutouManryouDao.getNyknJissekiRirekiMaxRenno(kykKihon, zennouJyuutouManryouDataBean.getJikaipym());

                        IT_Zennou zennou =
                            khZennouJyuutouManryouDao
                            .getZennou(ansyuKihon,
                                zennouJyuutouManryouDataBean.getZennoukaisiymd(),
                                zennouJyuutouManryouDataBean.getRenno());

                        BizDate ryousyuuYmd = BizDate.valueOf(zennouJyuutouManryouDataBean.getJikaipym(), kykSyouhn.getKykymd().getDay()).getRekijyou();

                        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                        C_Tuukasyu hrkpTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(zennou.getZennoujihrkp().getType());

                        BizCurrency rsGaku = null;
                        if (zennou.getRstuukasyu() != null && !hrkpTuukasyu.eq(zennou.getRstuukasyu())) {

                            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                            rsGaku  = keisanGaikakanzan.exec(
                                zennou.getRstuukasyu(),
                                zennou.getZennoujihrkp(),
                                zennou.getRyosyukwsrate(),
                                C_HasuusyoriKbn.SUTE);
                        }
                        else {

                            rsGaku = zennou.getZennoujihrkp();
                        }

                        int jyuutouNensuu = 0;
                        int jyuutouTukisuu = 0;
                        C_UmuKbn iktNyuukinNumu = null;
                        BizCurrency iktWaribikikgk = null;

                        if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                            jyuutouNensuu = 1;
                            jyuutouTukisuu = 0;
                            iktNyuukinNumu = C_UmuKbn.NONE;
                            iktWaribikikgk = BizCurrency.valueOf(0, rsGaku.getType());
                        }
                        else {

                            jyuutouNensuu = 0;
                            jyuutouTukisuu = 12;
                            iktNyuukinNumu = C_UmuKbn.ARI;
                            KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                            C_ErrorKbn keisanRsgakuErrorKbn = keisanRsgaku.exec(
                                kykKihon,
                                C_Nykkeiro.ZENNOUJYUUTOU,
                                C_NyknaiyouKbn.ZENNOUP,
                                ryousyuuYmd,
                                zennouJyuutouManryouDataBean.getJikaipym(),
                                jyuutouNensuu,
                                jyuutouTukisuu);

                            if (C_ErrorKbn.ERROR.eq(keisanRsgakuErrorKbn)) {

                                ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(
                                    zennouJyuutouManryouDataBean.getSyono(),
                                    MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu())
                                    );

                                continue;
                            }

                            iktWaribikikgk = keisanRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei();
                        }

                        IT_NyknJissekiRireki nyknJissekiRireki = kykKihon.createNyknJissekiRireki();

                        nyknJissekiRireki.setJyutoustartym(zennouJyuutouManryouDataBean.getJikaipym());
                        if (null == maxrenbannyknJissekiRireki) {
                            nyknJissekiRireki.setRenno(1);
                        } else {
                            nyknJissekiRireki.setRenno(maxrenbannyknJissekiRireki.getRenno() + 1);
                        }
                        nyknJissekiRireki.setJyutouendym(zennouJyuutouManryouDataBean.getJikaipym().addMonths(11));
                        nyknJissekiRireki.setRsgaku(rsGaku);
                        nyknJissekiRireki.setRstuukasyu(zennou.getRstuukasyu());
                        nyknJissekiRireki.setRyosyukwsratekjymd(zennou.getRyosyukwsratekjymd());
                        nyknJissekiRireki.setRyosyukwsrate(zennou.getRyosyukwsrate());
                        nyknJissekiRireki.setHrkp(kykKihon.getHrkp());
                        nyknJissekiRireki.setIktwaribikikgk(iktWaribikikgk);
                        nyknJissekiRireki.setNyksyoriymd(syoriYMD);
                        nyknJissekiRireki.setRyosyuymd(ryousyuuYmd);
                        nyknJissekiRireki.setNykkeiro(C_Nykkeiro.ZENNOUJYUUTOU);
                        nyknJissekiRireki.setHrkkaisuu(kykKihon.getHrkkaisuu());
                        nyknJissekiRireki.setJyutoukaisuuy(jyuutouNensuu);
                        nyknJissekiRireki.setJyutoukaisuum(jyuutouTukisuu);
                        nyknJissekiRireki.setNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);
                        nyknJissekiRireki.setIktnyuukinnumu(iktNyuukinNumu);
                        nyknJissekiRireki.setHenkousikibetukey(kykSyouhn.getHenkousikibetukey());
                        nyknJissekiRireki.setGyoumuKousinKinou(kinouID);
                        nyknJissekiRireki.setGyoumuKousinsyaId(kosID);
                        nyknJissekiRireki.setGyoumuKousinTime(kosTime);
                        nyknJissekiRireki.setTikiktbrisyuruikbn(kykKihon.getTikiktbrisyuruikbn());

                        BizPropertyInitializer.initialize(nyknJissekiRireki);

                        EditKoujyonaiyouTbl editKoujyonaiyouTbl = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);
                        editKoujyonaiyouTbl.setIkkatuNyknUmu(C_UmuKbn.NONE);
                        editKoujyonaiyouTbl.setNyknJskStartYm(nyknJissekiRireki.getJyutoustartym());
                        editKoujyonaiyouTbl.setNyknJskEndYm(nyknJissekiRireki.getJyutouendym());
                        editKoujyonaiyouTbl.setNyknJskRenno(nyknJissekiRireki.getRenno());
                        editKoujyonaiyouTbl.setNyknJskRyosyuYmd(nyknJissekiRireki.getRyosyuymd());
                        editKoujyonaiyouTbl.setNyknJskJytKaisuuY(nyknJissekiRireki.getJyutoukaisuuy());
                        editKoujyonaiyouTbl.setNyknJskJytKaisuuM(nyknJissekiRireki.getJyutoukaisuum());
                        editKoujyonaiyouTbl.setNyknJskRysKwsrate(nyknJissekiRireki.getRyosyukwsrate());

                        List<KykSyouhnCommonParam> kykSyouhnCommonParams = new ArrayList<>();
                        kykSyouhnCommonParams.addAll(kykSyouhnLst);
                        editKoujyonaiyouTbl.setKykSyouhnLst(kykSyouhnCommonParams);

                        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = SWAKInjector.getInstance(ZennouKoujyogakuKeisanParam.class);
                        zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(zennou.getKjsmyouzennoukaisiymd());
                        zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(zennou.getKjsmyouzennoukikanm());
                        zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(zennou.getKjsmyouzennounyuukinkgk());
                        zennouKoujyogakuKeisanParam.setHrkp(kykKihon.getHrkp());
                        zennouKoujyogakuKeisanParam.setHrkkaisuu(kykKihon.getHrkkaisuu());
                        zennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());
                        zennouKoujyogakuKeisanParam.setZennourenno(zennou.getRenno());
                        zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(zennou.getKjsmyouyenkansankwsrate());
                        editKoujyonaiyouTbl.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);

                        editKoujyonaiyouTbl.exec(khozenCommonParam, zennouJyuutouManryouDataBean.getSyono(),
                            C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, syoriYMD);

                        EditDairitenTesuuryouTbl editDairitenTesuuryouTbl = SWAKInjector.
                            getInstance(EditDairitenTesuuryouTbl.class);
                        editDairitenTesuuryouTbl.setBatchSyoriYmd(syoriYMD);
                        editDairitenTesuuryouTbl.exec(khozenCommonParam,
                            zennouJyuutouManryouDataBean.getSyono(),
                            C_TsrysyoriKbn.KEIZOKUPNYUUKIN,
                            nyknJissekiRireki.getJyutoustartym(),
                            nyknJissekiRireki.getJyutoukaisuuy(),
                            nyknJissekiRireki.getJyutoukaisuum(),
                            BizCurrency.valueOf(0),
                            BizCurrency.valueOf(0),
                            syoriYMD,
                            null);

                        ansyuKihon.setJkipjytym(ansyuKihon.getJkipjytym().addYears(1));
                        ansyuKihon.setGyoumuKousinKinou(kinouID);
                        ansyuKihon.setGyoumuKousinsyaId(kosID);
                        ansyuKihon.setGyoumuKousinTime(kosTime);

                        syoriKbn = C_SyoriKbn.JYUUTOU;

                        zennouJyuutouSyoriKensuu = zennouJyuutouSyoriKensuu + 1;


                    }
                    else {
                        //
                        //                    IT_KykSyouhn kykSyouhn = khZennouJyuutouManryouDao.getKykSyouhns(kykKihon).get(0);
                        //                    kykSyouhn.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
                        //                    kykSyouhn.setGyoumuKousinKinou(kinouID);
                        //                    kykSyouhn.setGyoumuKousinsyaId(kosID);
                        //                    kykSyouhn.setGyoumuKousinTime(kosTime);
                        //
                        //                    IT_Zennou zennou =
                        //                        khZennouJyuutouManryouDao
                        //                        .getZennou(ansyuKihon, zennouJyuutouManryouDataBean.getZennoukaisiym());
                        //
                        //                    BizDate zennoumanryouYMD = BizDate.valueOf(zennou.getAnnaisaikaiym(),
                        //                        kykSyouhn.getKykymd().getDay()).getRekijyou().addDays(-1);
                        //
                        //                    KeisanZennouSeisanGk keisanZennouSeisanGk = SWAKInjector.getInstance(KeisanZennouSeisanGk.class);
                        //
                        //                    // TODO 前納精算額計算の納品後、コメントアウトの解除および修正を行う。
                        //                    //                    keisanZennouSeisanGk.exec(zennoumanryouYMD, kykSyouhn.getSyouhncd(), kykSyouhn.getKykymd(),
                        //                    //                        kykKihon.getHrkp(), zennou.getZennoustartym(), zennou.getRyosyuymd(),
                        //                    //                        zennou.getZennounyuukinkgk(), C_ZennouSyoriKbn.ZENNOU_MANRYOU);
                        //
                        //                    BizCurrency zennouSeisanGk = keisanZennouSeisanGk.getZennouSeisanGk();
                        //
                        //                    if (zennouSeisanGk.compareTo(BizCurrency.valueOf(0)) > 0) {
                        //
                        //                        AnsyuuCommonSiwake ansyuuCommonSiwake = SWAKInjector.getInstance(AnsyuuCommonSiwake.class);
                        //                        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean =
                        //                            SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
                        //                        AnsyuuTaisyouGkBean ansyuuTaisyouGkBeanseisan = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
                        //                        AnsyuuTaisyouGkBean ansyuuTaisyouGkBeankeijyou = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
                        //                        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanList = Lists.newArrayList();
                        //
                        //                        BM_SyouhnZokusei syouhnZokusei = khZennouJyuutouManryouDao.getSyouhnZokusei(kykSyouhn);
                        //
                        //                        ansyuuTaisyouGkBeanseisan.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
                        //                        ansyuuTaisyouGkBeanseisan.setTaisyouGk(zennouSeisanGk);
                        //                        ansyuuTaisyouGkBeanseisan.setKeiyakutuukaGk(zennouSeisanGk);
                        //                        ansyuuTaisyouGkBeanseisan.setNykdenYmd(zennou.getZennounyuukindenymd());
                        //                        ansyuuTaisyouGkBeanseisan.setHrkkaisuu(C_Hrkkaisuu.NEN);
                        //                        ansyuuTaisyouGkBeanseisan.setJyutouStartYm(zennou.getZennoustartym());
                        //                        ansyuuTaisyouGkBeanseisan.setJyutouKaisuuY(Integer.valueOf(zennou.getZennoukikan()));
                        //                        ansyuuTaisyouGkBeanseisan.setJyutouKaisuuM(0);
                        //                        ansyuuTaisyouGkBeanList.add(ansyuuTaisyouGkBeanseisan);
                        //
                        //                        ansyuuTaisyouGkBeankeijyou.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
                        //                        ansyuuTaisyouGkBeankeijyou.setTaisyouGk(zennouSeisanGk);
                        //                        ansyuuTaisyouGkBeankeijyou.setKeiyakutuukaGk(zennouSeisanGk);
                        //                        ansyuuTaisyouGkBeanList.add(ansyuuTaisyouGkBeankeijyou);
                        //
                        //                        ansyuuCommonSiwakeInBean.setKinouId(kinouID);
                        //                        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.HOZEN);
                        //                        ansyuuCommonSiwakeInBean.setSegcd1(syouhnZokusei.getSeg1cd());
                        //                        ansyuuCommonSiwakeInBean.setSegcd2(syouhnZokusei.getSeg2cd());
                        //                        ansyuuCommonSiwakeInBean.setDenYmd(zennoumanryouYMD);
                        //                        ansyuuCommonSiwakeInBean.setSyoriYmd(syoriYMD);
                        //                        ansyuuCommonSiwakeInBean.setKykYmd(kykSyouhn.getKykymd());
                        //                        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(ansyuuTaisyouGkBeanList);
                        //
                        //                        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);
                        //
                        //                        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
                        //                        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean =
                        //                            SWAKInjector.getInstance(BzDenpyouDataTourokuBean.class);
                        //
                        //                        bzDenpyouDataTourokuBean.setIbSyono(zennouJyuutouManryouDataBean.getSyono());
                        //                        bzDenpyouDataTourokuBean.setIbHuridenatesakicd(commonSiwakeOutBean.getHuridenatesakiCd());
                        //                        bzDenpyouDataTourokuBean.setIbTantocd(commonSiwakeOutBean.getTantoCd());
                        //                        bzDenpyouDataTourokuBean.setIbDenymd(commonSiwakeOutBean.getDenyMd());
                        //                        bzDenpyouDataTourokuBean.setIbTuukasyu(commonSiwakeOutBean.getTuukasyu());
                        //                        bzDenpyouDataTourokuBean.setIbHuridenskskbn(commonSiwakeOutBean.getHuridensksKbn());
                        //                        bzDenpyouDataTourokuBean.setIbDenhnknhoukbn(commonSiwakeOutBean.getDenhnknhouKbn());
                        //                        bzDenpyouDataTourokuBean.setIbDenshrhoukbn(commonSiwakeOutBean.getDenshrhouKbn());
                        //                        bzDenpyouDataTourokuBean.setIbSyoriymd(commonSiwakeOutBean.getSyoriYmd());
                        //                        bzDenpyouDataTourokuBean.setIbSyoricd(commonSiwakeOutBean.getSyoriCd());
                        //                        bzDenpyouDataTourokuBean.setIbSyorisosikicd(commonSiwakeOutBean.getHuridenatesakiCd() + "0000");
                        //                        bzDenpyouDataTourokuBean.setIbKyktuukasyu(C_Tuukasyu.JPY);
                        //                        bzDenpyouDataTourokuBean.setIbGyoumuKousinsyaId(kosID);
                        //                        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiflg(false);
                        //                        bzDenpyouDataTourokuBean.setIbKakokawaserateshiteiymd(null);
                        //                        bzDenpyouDataTourokuBean.setBzSiwakeMeisaiBeanList(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst());
                        //
                        //                        khDenpyoDataList = bzDenpyouDataSks.execKh(bzDenpyouDataTourokuBean);
                        //
                        //                        IT_Kariukekin maxkariukekin = khZennouJyuutouManryouDao.getKariukekinMaxKrkno(kykKihon);
                        //
                        //                        IT_Kariukekin kariukekin = khZennouJyuutouManryouDao.createKariukekin(kykKihon);
                        //
                        //                        if (null == maxkariukekin) {
                        //                            kariukekin.setKrkno(1);
                        //                        } else {
                        //                            kariukekin.setKrkno(maxkariukekin.getKrkno() + 1);
                        //                        }
                        //                        kariukekin.setKrkkeijyoymd(syoriYMD);
                        //                        kariukekin.setKrkgk(zennouSeisanGk);
                        //                        kariukekin.setHasseidenymd(zennoumanryouYMD);
                        //                        kariukekin.setNyknaiyoukbn(C_NyknaiyouKbn.ZENNOUP);
                        //                        kariukekin.setNykkeiro(C_Nykkeiro.ZENNOUJYUUTOU);
                        //                        kariukekin.setJyuutouym(zennouJyuutouManryouDataBean.getJikaipym());
                        //                        kariukekin.setJyutoukaisuuy(1);
                        //                        kariukekin.setRyosyuymd(zennoumanryouYMD);
                        //                        kariukekin.setGyoumuKousinKinou(kinouID);
                        //                        kariukekin.setGyoumuKousinsyaId(kosID);
                        //                        kariukekin.setGyoumuKousinTime(kosTime);
                        //
                        //                        BizPropertyInitializer.initialize(kariukekin);
                        //                    }
                        //
                        //                    zennou.setZennouseisankbn(C_ZennouSeisanKbn.SEISANZUMI);
                        //                    zennou.setZennouseisansyoriymd(syoriYMD);
                        //                    zennou.setZennouseisankgk(zennouSeisanGk);
                        //                    zennou.setZennouseisankijyunymd(keisanZennouSeisanGk.getZennouSeisanKijyunYmd());
                        //
                        //                    if (zennouSeisanGk.compareTo(BizCurrency.valueOf(0)) > 0) {
                        //                        zennou.setZennouseisandenymd(zennoumanryouYMD);
                        //                    }
                        //                    zennou.setGyoumuKousinKinou(kinouID);
                        //                    zennou.setGyoumuKousinsyaId(kosID);
                        //                    zennou.setGyoumuKousinTime(kosTime);
                        //
                        //                    List<String> jimurenrakumsgList = Lists.newArrayList();
                        //                    jimurenrakumsgList.add("前納Ｐ残高を仮受金に計上しました。");
                        //                    jimurenrakumsgList.add("返金、次回Ｐ充当を確認のうえ、仮受訂正で精算してください。");
                        //                    jimurenrakumsgList.add("");
                        //                    jimurenrakumsgList.add("仮受金額／" + BizUtil.comma(zennouSeisanGk.toString()) + "円");
                        //
                        //                    EditJimuRenrakuhyouParam editJimuRenrakuhyouParam =
                        //                        SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);
                        //
                        //                    editJimuRenrakuhyouParam.setJimurenrakuMsgList(jimurenrakumsgList);
                        //
                        //                    KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
                        //
                        //                    khozenTyouhyouCtl.setSyoriYmd(syoriYMD);
                        //
                        //                    khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);
                        //
                        //                    khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, zennouJyuutouManryouDataBean.getSyono(),
                        //                        new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_JIMURENRAKU }, C_YouhiKbn.HUYOU);

                    }

                    IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

                    khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(
                        zennouJyuutouManryouDataBean.getSyono()));

                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(zennouJyuutouManryouDataBean.getSyono());
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYMD);
                    editTtdkRirekiTblParam.setSyoriKbn(syoriKbn);
                    editTtdkRirekiTblParam.setSysTime(kosTime);
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(youhiKbn);

                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                    for (IT_KhDenpyoData khDenpyoData : khDenpyoDataList) {

                        khDenpyoDataEntityInserter.add(khDenpyoData);
                    }

                    multipleEntityUpdater.add(ansyuKihon);

                    multipleEntityUpdater.add(kykKihon);
                }
                else {
                    kykKihon.detach();
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {

                ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYMD);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "前納充当処理", String.valueOf(zennouJyuutouSyoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.
            getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
