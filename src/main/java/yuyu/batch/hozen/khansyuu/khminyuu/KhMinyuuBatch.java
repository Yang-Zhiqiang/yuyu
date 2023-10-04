package yuyu.batch.hozen.khansyuu.khminyuu;

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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.apache.commons.lang.StringUtils;

import yuyu.batch.hozen.khansyuu.khminyuu.dba.KhMinyuuDao;
import yuyu.batch.hozen.khansyuu.khminyuu.dba.MinyuuTRBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.EditCreditMinyuuTuutiParam;
import yuyu.common.hozen.ascommon.EditMinyuuTuuti;
import yuyu.common.hozen.ascommon.EditMinyuuTuutiParam;
import yuyu.common.hozen.ascommon.GetHrkKawaseRateKijyun;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgkOutBean;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKhMisslstTbl;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetYuuyokknmanryobi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_Dattaikeiro;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Skszumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_Yuukoukakkekka;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.db.entity.IT_DrtenMinyuKykTaisyo;
import yuyu.def.db.entity.IT_GinkouMdhnFollowCall;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.entity.IT_TRKzhuriKurikosiMinyuu;
import yuyu.def.db.entity.IT_TRMinyuu;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.db.entity.IT_YykIdouUktk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;

/**
 * 契約保全 案内収納 未入処理
 */
public class KhMinyuuBatch implements Batch {

    private static final String TABLEID = IT_TRMinyuu.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhMinyuuDao khMinyuuDao;

    private KhozenCommonParam khozenCommonParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private String kinouID;

    private String kosID;

    private String kosTime;

    private BizDate syoriYMD;

    private BizDateYM ryousyuuYm;

    private BizCurrency nextAnnaikg;

    private C_HassouKbn hassouKbn;

    private boolean minyuutuutiSakuseiFlg;

    private boolean drtnMinyuumeisaiSakuseiFlg;

    private boolean followcallSakuseiFlg;

    private boolean dattaiTrSakuseiFlg;

    private String tuutiSyuruiCd;

    private BizDateYM tokusinEndYm;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            String.valueOf(bzBatchParam.getIbKakutyoujobcd())));

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        kinouID = khozenCommonParam.getFunctionId();
        kosID = khozenCommonParam.getUserID();
        kosTime = BizDate.getSysDateTimeMilli();
        syoriYMD = bzBatchParam.getSyoriYmd();

        long syoriKensuu = 0;
        int misslstcount = 0;
        List<EditKhMisslstParam> misslstPrmList = new ArrayList<>();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        ansyuuBatSyoriHunoKykMisslistSks.setErrerLimit(100);

        try (ExDBResults<MinyuuTRBean> minyuuTRBeanLst = khMinyuuDao.getTRMinyuus(kakutyoujobCd);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();
            MultipleEntityInserter entityInserter = new MultipleEntityInserter();) {

            for (MinyuuTRBean minyuuTRBean : minyuuTRBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(minyuuTRBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(minyuuTRBean.getSyono());

                syoriKensuu++;

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(minyuuTRBean.getSyono());
                if (kykKihon == null) {
                    throw new CommonBizAppException("契約基本TBLにデータが存在しません。");
                }
                List<IT_KykSyouhn> kykSyouhnSyuLst = khMinyuuDao.getKykSyouhnSyus(kykKihon);
                if (kykSyouhnSyuLst.size() == 0) {
                    throw new CommonBizAppException("契約商品TBLにデータが存在しません。");
                }
                IT_KykSyouhn kykSyouhnSyu = kykSyouhnSyuLst.get(0);

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(minyuuTRBean.getSyono());
                if (ansyuKihon == null) {
                    throw new CommonBizAppException("案内基本TBLにデータが存在しません。");
                }

                C_AnnaijkKbn annaijkKbn = C_AnnaijkKbn.MINYUU;

                if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {
                    annaijkKbn = C_AnnaijkKbn.ANNAI;
                }

                List<IT_AnsyuRireki> ansyuRirekiLst = khMinyuuDao.getAnsyuRirekis(ansyuKihon,
                    minyuuTRBean.getNyknaiyoukbn(),
                    minyuuTRBean.getJyuutouym(),
                    minyuuTRBean.getNykkeiro(),
                    minyuuTRBean.getJyutoukaisuuy(),
                    minyuuTRBean.getJyutoukaisuum(),
                    minyuuTRBean.getRsgaku(),
                    minyuuTRBean.getRyosyuymd(),
                    annaijkKbn);

                if (ansyuRirekiLst.size() == 0) {
                    annaijkKbn = C_AnnaijkKbn.MINYUU;

                    ansyuRirekiLst = khMinyuuDao.getAnsyuRirekis(ansyuKihon,
                        minyuuTRBean.getNyknaiyoukbn(),
                        minyuuTRBean.getJyuutouym(),
                        minyuuTRBean.getNykkeiro(),
                        minyuuTRBean.getJyutoukaisuuy(),
                        minyuuTRBean.getJyutoukaisuum(),
                        minyuuTRBean.getRsgaku(),
                        minyuuTRBean.getRyosyuymd(),
                        annaijkKbn);
                }

                if (ansyuRirekiLst.size() == 0) {

                    misslstcount++;

                    String msg = "未入TR情報と案内収納履歴情報の照合が出来ません。";

                    EditKhMisslstParam misslstPrm = SWAKInjector.getInstance(EditKhMisslstParam.class);

                    misslstPrm.setDataNo(misslstcount);
                    misslstPrm.setSeqNo(misslstcount);
                    misslstPrm.setMisslistMsg(msg);
                    misslstPrm.setDBhaneikbn(C_Dbhanei.NONE);
                    misslstPrm.setSyoNo(minyuuTRBean.getSyono());

                    misslstPrmList.add(misslstPrm);

                    continue;
                }
                IT_AnsyuRireki ansyuRireki = ansyuRirekiLst.get(0);

                C_UmuKbn kouzanHenkouumu = C_UmuKbn.NONE;

                if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro()) && C_Hrkkeiro.KOUHURI.eq(kykKihon.getHrkkeiro())) {

                    IT_Kouza kouza = kykKihon.getKouza();

                    if (!kouza.getBankcd().equals(ansyuRireki.getBankcd()) ||
                        !kouza.getSitencd().equals(ansyuRireki.getSitencd()) ||
                        !kouza.getYokinkbn().eq(ansyuRireki.getYokinkbn()) ||
                        !kouza.getKouzano().equals(ansyuRireki.getKouzano()) ||
                        !kouza.getKzmeiginmkn().equals(ansyuRireki.getKzmeiginmkn())) {
                        kouzanHenkouumu = C_UmuKbn.ARI;
                    }
                }

                IT_DattaiUktk dattaiUktk = ansyuKihon.getDattaiUktk();

                C_HurihunoKbn zenHurihunokbn = C_HurihunoKbn.BLNK;

                if (BizDateUtil.compareYm(ansyuKihon.getJkipjytym(), minyuuTRBean.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL) {

                    SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                    setHurikaebi.exec(ansyuRireki.getAnnaisakuseiymd());

                    List<IT_AnsyuRireki> zenAnsyuRirekiLst = khMinyuuDao.getAnsyuRirekis2(ansyuKihon,
                        minyuuTRBean.getNyknaiyoukbn(),
                        minyuuTRBean.getNykkeiro(),
                        setHurikaebi.getTyokuzenHurikaebi(),
                        C_AnnaijkKbn.MINYUU);

                    if (zenAnsyuRirekiLst.size() > 0) {
                        zenHurihunokbn = zenAnsyuRirekiLst.get(0).getHurihunokbn();
                    }
                }

                IT_Tokusin tokusin = ansyuKihon.getTokusin();

                if (tokusin != null) {
                    if ((C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro()) && tokusin.getTokusinendymd().getDay() < 27) ||
                        (C_Nykkeiro.CREDIT.eq(minyuuTRBean.getNykkeiro()) && tokusin.getTokusinendymd().getDay() < 15)) {

                        tokusinEndYm = tokusin.getTokusinendymd().getBizDateYM().getPreviousMonth();
                    }
                    else {

                        tokusinEndYm = tokusin.getTokusinendymd().getBizDateYM();
                    }
                }

                if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {
                    if (minyuuTRBean.getRyosyuymd().getDay() < 27) {
                        ryousyuuYm = minyuuTRBean.getRyosyuymd().getBizDateYM().getPreviousMonth();
                    }
                    else {
                        ryousyuuYm = minyuuTRBean.getRyosyuymd().getBizDateYM();
                    }
                }
                else if (C_Nykkeiro.CREDIT.eq(minyuuTRBean.getNykkeiro())) {
                    ryousyuuYm = minyuuTRBean.getRyosyuymd().getBizDateYM();
                }

                BizDate nextRyosyuYmd = null;
                BizDateYM nextRyosyuYm = null;

                if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {
                    SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);

                    setHurikaebi.exec(syoriYMD);

                    nextRyosyuYmd = setHurikaebi.getTyokugoHurikaebi();

                    if (nextRyosyuYmd.getDay() < 27) {
                        nextRyosyuYm = nextRyosyuYmd.getBizDateYM().getPreviousMonth();
                    }
                    else {
                        nextRyosyuYm = nextRyosyuYmd.getBizDateYM();
                    }
                }
                else if (C_Nykkeiro.CREDIT.eq(minyuuTRBean.getNykkeiro())) {
                    SetCreditUriageSeikyuubi setCreditUriageSeikyuubi = SWAKInjector.getInstance(SetCreditUriageSeikyuubi.class);

                    setCreditUriageSeikyuubi.exec(syoriYMD);

                    nextRyosyuYmd = setCreditUriageSeikyuubi.getJikaiUrskbi();

                    nextRyosyuYm = nextRyosyuYmd.getBizDateYM();
                }

                int nextAnnaijyuutougetusuu = 0;
                int jkiAnnaiJyuutouNensuu = 0;

                if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                    if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(kykKihon.getTikiktbrisyuruikbn()) ||
                        C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                        nextAnnaijyuutougetusuu = Integer.valueOf(kykKihon.getTikiktbrisyuruikbn().getValue());
                    }
                    else {

                        if (tokusin != null && C_TokusinKbn.HISAIGAI.eq(tokusin.getTokusinkbn()) &&
                            BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_LESSER) {

                            BizDateYM tokusinEndYmZenM = tokusinEndYm.getPreviousMonth();

                            if (BizDateUtil.compareYm(ryousyuuYm, tokusinEndYmZenM) == BizDateUtil.COMPARE_EQUAL) {

                                nextAnnaijyuutougetusuu = tokusinEndYm.subtractMonths(ansyuKihon.getJkipjytym());
                            }
                            else {
                                nextAnnaijyuutougetusuu = 1;
                            }
                        }
                        else {
                            nextAnnaijyuutougetusuu = nextRyosyuYm.subtractMonths(ansyuKihon.getJkipjytym()) + 1;

                            List<IT_YykIdouUktk> yykIdouUktkLst = khMinyuuDao.getYykIdouUktks(kykKihon);
                            int nextAnnaijyuutougetusuu_hennyuuYm = 0;
                            if (yykIdouUktkLst.size() > 0) {
                                BizDateYM yykIdouUktkSyoriYm = yykIdouUktkLst.get(0).getSyoriym();
                                nextAnnaijyuutougetusuu_hennyuuYm = yykIdouUktkSyoriYm.subtractMonths(ansyuKihon.getJkipjytym());
                            }
                            if (nextAnnaijyuutougetusuu_hennyuuYm > 0 && nextAnnaijyuutougetusuu > nextAnnaijyuutougetusuu_hennyuuYm) {
                                nextAnnaijyuutougetusuu = nextAnnaijyuutougetusuu_hennyuuYm;
                            }
                        }

                        int nextAnnaijyuutougetusuu_haraimanYm = ansyuKihon.getSyuharaimanymd().getBizDateYM().subtractMonths(ansyuKihon.getJkipjytym());
                        if (nextAnnaijyuutougetusuu_haraimanYm > 0 && nextAnnaijyuutougetusuu > nextAnnaijyuutougetusuu_haraimanYm) {
                            nextAnnaijyuutougetusuu = nextAnnaijyuutougetusuu_haraimanYm;
                        }
                    }
                }
                else if (C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())) {
                    nextAnnaijyuutougetusuu = Integer.valueOf(kykKihon.getHrkkaisuu().getValue());
                }
                else if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {
                    jkiAnnaiJyuutouNensuu = 1;
                }

                GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);
                getasPRsTuuka.exec(kykKihon.getSyono());
                C_Tuukasyu rstuukasyu = getasPRsTuuka.getRstuukasyu();

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu tuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(kykSyouhnSyu.getHokenryou().getType());

                if (!tuukaSyu.eq(rstuukasyu)) {

                    GetHrkKawaseRateKijyun getHrkKawaseRateKijyun = SWAKInjector.getInstance(GetHrkKawaseRateKijyun.class);

                    C_ErrorKbn getHrkKawaseRateKijyunResult = getHrkKawaseRateKijyun.exec(
                        minyuuTRBean.getNyknaiyoukbn(),
                        minyuuTRBean.getNykkeiro(),
                        nextRyosyuYmd,
                        ansyuKihon.getJkipjytym(),
                        jkiAnnaiJyuutouNensuu,
                        nextAnnaijyuutougetusuu,
                        kykKihon.getHrkkaisuu());

                    if (C_ErrorKbn.ERROR.eq(getHrkKawaseRateKijyunResult)) {

                        ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(), MessageUtil.getMessage(MessageId.EIA3055, getHrkKawaseRateKijyun.getErrorRiyuu()));

                        IT_TRKzhuriKurikosiMinyuu tRKzhuriKurikosiMinyuu = insertTRKzhuriKurikosiMinyuu(minyuuTRBean);

                        entityInserter.add(tRKzhuriKurikosiMinyuu);

                        ansyuRireki.setMinyusyoriymd(minyuuTRBean.getSyoriYmd());
                        
                        if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {
                        
                            ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.MINYUU);
                            ansyuRireki.setHurihunokbn(minyuuTRBean.getHurihunokbn());
                        }
                        ansyuRireki.setGyoumuKousinKinou(kinouID);
                        ansyuRireki.setGyoumuKousinsyaId(kosID);
                        ansyuRireki.setGyoumuKousinTime(kosTime);
                        
                        multipleEntityUpdater.add(hozenDomManager.getAnsyuKihon(minyuuTRBean.getSyono()));

                        continue;

                    }

                    BizDate kawaseRateKijyun = getHrkKawaseRateKijyun.getKawaseRateKijyun();

                    if (BizDateUtil.compareYmd(kawaseRateKijyun, syoriYMD) == BizDateUtil.COMPARE_GREATER) {

                        IT_TRKzhuriKurikosiMinyuu tRKzhuriKurikosiMinyuu = insertTRKzhuriKurikosiMinyuu(minyuuTRBean);

                        entityInserter.add(tRKzhuriKurikosiMinyuu);

                        ansyuRireki.setMinyusyoriymd(minyuuTRBean.getSyoriYmd());
                        
                        if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {
                        
                            ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.MINYUU);
                            ansyuRireki.setHurihunokbn(minyuuTRBean.getHurihunokbn());
                        }
                        ansyuRireki.setGyoumuKousinKinou(kinouID);
                        ansyuRireki.setGyoumuKousinsyaId(kosID);
                        ansyuRireki.setGyoumuKousinTime(kosTime);
                        
                        multipleEntityUpdater.add(hozenDomManager.getAnsyuKihon(minyuuTRBean.getSyono()));


                        continue;

                    }

                }

                KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                C_ErrorKbn keisanRsgakuErrorKbn = keisanRsgaku.exec(
                    kykKihon,
                    minyuuTRBean.getNykkeiro(),
                    minyuuTRBean.getNyknaiyoukbn(),
                    nextRyosyuYmd,
                    ansyuKihon.getJkipjytym(),
                    jkiAnnaiJyuutouNensuu,
                    nextAnnaijyuutougetusuu);

                if (C_ErrorKbn.ERROR.eq(keisanRsgakuErrorKbn)) {

                    ansyuuBatSyoriHunoKykMisslistSks.addErrerMsg(kykKihon.getSyono(), MessageUtil.getMessage(MessageId.EIA3055, keisanRsgaku.getErrorRiyuu()));

                    IT_TRKzhuriKurikosiMinyuu tRKzhuriKurikosiMinyuu = insertTRKzhuriKurikosiMinyuu(minyuuTRBean);

                    entityInserter.add(tRKzhuriKurikosiMinyuu);

                    ansyuRireki.setMinyusyoriymd(minyuuTRBean.getSyoriYmd());

                    if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {

                        ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.MINYUU);
                        ansyuRireki.setHurihunokbn(minyuuTRBean.getHurihunokbn());
                    }
                    ansyuRireki.setGyoumuKousinKinou(kinouID);
                    ansyuRireki.setGyoumuKousinsyaId(kosID);
                    ansyuRireki.setGyoumuKousinTime(kosTime);

                    multipleEntityUpdater.add(hozenDomManager.getAnsyuKihon(minyuuTRBean.getSyono()));

                    kykKihon.detach();

                    continue;

                }

                KeisanRsgkOutBean keisanRsgkOutBean = keisanRsgaku.getKeisanRsgkOutBean();

                nextAnnaikg = keisanRsgkOutBean.getRsgakuGoukei();

                hanteiTuutiSakusei(kykKihon, kykSyouhnSyu, minyuuTRBean, ansyuKihon, ansyuRireki, dattaiUktk, zenHurihunokbn, tokusin);

                IT_KouzahuriMinyuTuuti kouzahuriMinyuTuuti = null;

                C_Skszumiflg minyuutuutiSkszumiflg = C_Skszumiflg.MISAKUSEI;

                if (minyuutuutiSakuseiFlg) {

                    minyuutuutiSkszumiflg = C_Skszumiflg.SAKUSEIZUMI;

                    SetYuuyokknmanryobi setYuuyokknmanryobi = SWAKInjector.getInstance(SetYuuyokknmanryobi.class);
                    EditMinyuuTuuti editMinyuuTuuti = SWAKInjector.getInstance(EditMinyuuTuuti.class);

                    setYuuyokknmanryobi.exec(minyuuTRBean.getSyono(), ansyuKihon.getJkipjytym());

                    BizDate yuuyokknMnrybi = setYuuyokknmanryobi.getTksnYuuyokknMnrybi();

                    C_UmuKbn dattaiUktkUmu = C_UmuKbn.NONE;
                    C_DattairiyuuKbn dattaiRiyuuKbn = C_DattairiyuuKbn.BLNK;
                    C_Dattaikeiro dattaikeiro = C_Dattaikeiro.ONLINE;

                    if (dattaiUktk != null) {
                        dattaiUktkUmu = C_UmuKbn.ARI;
                        dattaiRiyuuKbn = dattaiUktk.getDattairiyuukbn();
                        dattaikeiro = dattaiUktk.getDattaikeiro();
                    }

                    if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {

                        EditMinyuuTuutiParam minyuuTuutiParam = SWAKInjector.getInstance(EditMinyuuTuutiParam.class);
                        Integer zenAnnaiJyuutouTukisuu = 0;
                        BizCurrency zenAnnaiKg = BizCurrency.valueOf(0);
                        Integer zenAnnaiJyuutouNennsuu = 0;

                        if (C_Hrkkaisuu.TUKI.eq(minyuuTRBean.getHrkkaisuu())) {

                            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(minyuuTRBean.getTikiktbrisyuruiKbn()) ||
                                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(minyuuTRBean.getTikiktbrisyuruiKbn())) {

                                zenAnnaiJyuutouTukisuu = Integer.valueOf(minyuuTRBean.getTikiktbrisyuruiKbn().getValue());
                                zenAnnaiKg = minyuuTRBean.getRsgaku();
                            }
                            else {

                                List<IT_AnsyuRireki> konkaiAnsyuRirekiLst = khMinyuuDao.getAnsyuRirekis2(ansyuKihon,
                                    minyuuTRBean.getNyknaiyoukbn(),
                                    minyuuTRBean.getNykkeiro(),
                                    minyuuTRBean.getRyosyuymd(),
                                    C_AnnaijkKbn.ANNAI);

                                if (konkaiAnsyuRirekiLst.size() == 0) {

                                    konkaiAnsyuRirekiLst = khMinyuuDao.getAnsyuRirekis2(ansyuKihon,
                                        minyuuTRBean.getNyknaiyoukbn(),
                                        minyuuTRBean.getNykkeiro(),
                                        minyuuTRBean.getRyosyuymd(),
                                        C_AnnaijkKbn.MINYUU);
                                }
                                for (IT_AnsyuRireki konkaiAnsyuRireki :konkaiAnsyuRirekiLst) {

                                    zenAnnaiJyuutouTukisuu = zenAnnaiJyuutouTukisuu + konkaiAnsyuRireki.getJyutoukaisuum();
                                    zenAnnaiKg = zenAnnaiKg.add(konkaiAnsyuRireki.getRsgaku());
                                }
                            }
                        }
                        else if (C_Hrkkaisuu.HALFY.eq(minyuuTRBean.getHrkkaisuu())) {

                            zenAnnaiJyuutouTukisuu = minyuuTRBean.getJyutoukaisuum();
                            zenAnnaiKg = minyuuTRBean.getRsgaku();
                        }
                        else if (C_Hrkkaisuu.NEN.eq(minyuuTRBean.getHrkkaisuu())) {

                            zenAnnaiJyuutouNennsuu = minyuuTRBean.getJyutoukaisuuy();
                            zenAnnaiKg = minyuuTRBean.getRsgaku();
                        }

                        minyuuTuutiParam.setDattaiUktkUmu(dattaiUktkUmu);
                        minyuuTuutiParam.setDattaiRiyuuKbn(dattaiRiyuuKbn);
                        minyuuTuutiParam.setHurihunoKbn(minyuuTRBean.getHurihunokbn());
                        minyuuTuutiParam.setZenHurihunoKbn(zenHurihunokbn);
                        minyuuTuutiParam.setJkiPJytYm(ansyuKihon.getJkipjytym());
                        minyuuTuutiParam.setHurikaeYm(ryousyuuYm);
                        minyuuTuutiParam.setYykknMnryYmd(yuuyokknMnrybi);
                        minyuuTuutiParam.setJkiHurikaeYmd(nextRyosyuYmd);
                        minyuuTuutiParam.setJkiAnnaiJyuutouTukisuu(nextAnnaijyuutougetusuu);
                        minyuuTuutiParam.setJkiAnnaiKg(nextAnnaikg);
                        minyuuTuutiParam.setZenHurikaeYmd(ansyuRireki.getHurikaeymd());
                        minyuuTuutiParam.setZenAnnaiJyutouYm(ansyuKihon.getJkipjytym());
                        minyuuTuutiParam.setZenAnnaiJyuutouTukisuu(zenAnnaiJyuutouTukisuu);
                        minyuuTuutiParam.setZenAnnaiKg(zenAnnaiKg);
                        minyuuTuutiParam.setKouzaHenkouUmuKbn(kouzanHenkouumu);
                        minyuuTuutiParam.setJkiAnnaiJyuutouNensuu(jkiAnnaiJyuutouNensuu);
                        minyuuTuutiParam.setZenAnnaiJyuutouNensuu(zenAnnaiJyuutouNennsuu);
                        minyuuTuutiParam.setAnnaijiHrkkaisuu(minyuuTRBean.getHrkkaisuu());

                        kouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam,
                            kykKihon,
                            minyuuTuutiParam,
                            syoriYMD,
                            hassouKbn,
                            tuutiSyuruiCd);
                    }
                    else if (C_Nykkeiro.CREDIT.eq(minyuuTRBean.getNykkeiro())) {

                        EditCreditMinyuuTuutiParam editCreditMinyuuTuutiParam = SWAKInjector
                            .getInstance(EditCreditMinyuuTuutiParam.class);

                        editCreditMinyuuTuutiParam.setDattaiUktkUmu(dattaiUktkUmu);
                        editCreditMinyuuTuutiParam.setDattaiRiyuuKbn(dattaiRiyuuKbn);
                        editCreditMinyuuTuutiParam.setJkiPJytYm(ansyuKihon.getJkipjytym());
                        editCreditMinyuuTuutiParam.setRyousyuuYm(ryousyuuYm);
                        editCreditMinyuuTuutiParam.setYykknMnryYmd(yuuyokknMnrybi);
                        editCreditMinyuuTuutiParam.setJikaiUrskbi(nextRyosyuYmd);
                        editCreditMinyuuTuutiParam.setDattaikeiro(dattaikeiro);
                        editCreditMinyuuTuutiParam.setYuukoukakkekka(C_Yuukoukakkekka.YUUKOUKAK_OK);
                        editCreditMinyuuTuutiParam.setCreditUriageNgJiyuuKbn(minyuuTRBean.getCreditUriageNgJiyuuKbn());
                        editCreditMinyuuTuutiParam.setAnnaiGetusuu(nextAnnaijyuutougetusuu);
                        editCreditMinyuuTuutiParam.setAnnaiKingaku(nextAnnaikg);

                        kouzahuriMinyuTuuti = editMinyuuTuuti.editTBL(khozenCommonParam,
                            kykKihon,
                            editCreditMinyuuTuutiParam,
                            syoriYMD,
                            hassouKbn,
                            tuutiSyuruiCd);
                    }
                }

                ansyuRireki.setMinyusyoriymd(minyuuTRBean.getSyoriYmd());

                if (C_Nykkeiro.KZHRK.eq(minyuuTRBean.getNykkeiro())) {

                    ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.MINYUU);
                    ansyuRireki.setHurihunokbn(minyuuTRBean.getHurihunokbn());
                }
                ansyuRireki.setMinyutuutizumiflg(minyuutuutiSkszumiflg);
                ansyuRireki.setGyoumuKousinKinou(kinouID);
                ansyuRireki.setGyoumuKousinsyaId(kosID);
                ansyuRireki.setGyoumuKousinTime(kosTime);

                IT_DrtenMinyuKykTaisyo drtenMinyuKykTaisyo = null;

                if (drtnMinyuumeisaiSakuseiFlg) {

                    drtenMinyuKykTaisyo = new IT_DrtenMinyuKykTaisyo(minyuuTRBean.getSyono(), syoriYMD, minyuuTRBean.getMinyuutrrenno());

                    drtenMinyuKykTaisyo.setNykkeiro(minyuuTRBean.getNykkeiro());
                    drtenMinyuKykTaisyo.setNyknaiyoukbn(minyuuTRBean.getNyknaiyoukbn());
                    drtenMinyuKykTaisyo.setJyuutouym(minyuuTRBean.getJyuutouym());
                    drtenMinyuKykTaisyo.setJyutoukaisuuy(minyuuTRBean.getJyutoukaisuuy());
                    drtenMinyuKykTaisyo.setJyutoukaisuum(minyuuTRBean.getJyutoukaisuum());
                    drtenMinyuKykTaisyo.setRsgaku(minyuuTRBean.getRsgaku());
                    drtenMinyuKykTaisyo.setRyosyuymd(minyuuTRBean.getRyosyuymd());
                    drtenMinyuKykTaisyo.setHurihunokbn(minyuuTRBean.getHurihunokbn());
                    drtenMinyuKykTaisyo.setBankcd(minyuuTRBean.getBankCd());
                    drtenMinyuKykTaisyo.setSitencd(minyuuTRBean.getSitenCd());
                    drtenMinyuKykTaisyo.setYokinkbn(minyuuTRBean.getYokinKbn());
                    drtenMinyuKykTaisyo.setKouzano(minyuuTRBean.getKouzaNo());
                    drtenMinyuKykTaisyo.setDantaikobetukbn(minyuuTRBean.getDantaiKobetuKbn());
                    drtenMinyuKykTaisyo.setHrkkaisuu(minyuuTRBean.getHrkkaisuu());
                    drtenMinyuKykTaisyo.setKzhurikaetkbtannaihyj(minyuuTRBean.getKzhurikaeTkbtannaiHyj());
                    drtenMinyuKykTaisyo.setTikiktbrisyuruikbn(minyuuTRBean.getTikiktbrisyuruiKbn());
                    drtenMinyuKykTaisyo.setJkipjytym(ansyuKihon.getJkipjytym());
                    drtenMinyuKykTaisyo.setJkiannaikg(nextAnnaikg);
                    drtenMinyuKykTaisyo.setJkijyutoukaisuuy(jkiAnnaiJyuutouNensuu);
                    drtenMinyuKykTaisyo.setJkijyutoukaisuum(nextAnnaijyuutougetusuu);
                    drtenMinyuKykTaisyo.setGyoumuKousinKinou(kinouID);
                    drtenMinyuKykTaisyo.setGyoumuKousinsyaId(kosID);
                    drtenMinyuKykTaisyo.setGyoumuKousinTime(kosTime);

                    BizPropertyInitializer.initialize(drtenMinyuKykTaisyo);
                }

                IT_GinkouMdhnFollowCall dinkouMdhnFollowCall = null;
                if (followcallSakuseiFlg) {
                    dinkouMdhnFollowCall = insertGinkouMdhnFollowCall(kykKihon,
                        kykSyouhnSyu,
                        minyuuTRBean,
                        ansyuKihon);
                }

                IT_TRDattai tRDattai = null;

                if (dattaiTrSakuseiFlg && C_UmuKbn.NONE.eq(kouzanHenkouumu)) {

                    tRDattai = new IT_TRDattai(minyuuTRBean.getSyono(),
                        minyuuTRBean.getSyoriYmd(), BizDate.getSysDateTimeMilli() + "1");

                    tRDattai.setDattaikeiro(C_Dattaikeiro.KOUHURI);
                    tRDattai.setSyuudaikocd(C_Syuudaikocd.BLNK);
                    tRDattai.setBankcd(minyuuTRBean.getBankCd());
                    tRDattai.setSitencd(minyuuTRBean.getSitenCd());
                    tRDattai.setYokinkbn(minyuuTRBean.getYokinKbn());
                    tRDattai.setKouzano(minyuuTRBean.getKouzaNo());
                    tRDattai.setHurihunokbn(minyuuTRBean.getHurihunokbn());
                    tRDattai.setHurikaeymd(minyuuTRBean.getRyosyuymd());
                    tRDattai.setDattaiym(minyuuTRBean.getJyuutouym());
                    tRDattai.setNykkeiro(minyuuTRBean.getNykkeiro());
                    tRDattai.setNyknaiyoukbn(minyuuTRBean.getNyknaiyoukbn());
                    tRDattai.setJyutoukaisuuy(minyuuTRBean.getJyutoukaisuuy());
                    tRDattai.setJyutoukaisuum(minyuuTRBean.getJyutoukaisuum());
                    tRDattai.setTikiktbrisyuruikbn(minyuuTRBean.getTikiktbrisyuruiKbn());
                    tRDattai.setGyoumuKousinKinou(kinouID);
                    tRDattai.setGyoumuKousinsyaId(kosID);
                    tRDattai.setGyoumuKousinTime(kosTime);

                    BizPropertyInitializer.initialize(tRDattai);
                }

                multipleEntityUpdater.add(hozenDomManager.getAnsyuKihon(minyuuTRBean.getSyono()));

                if (kouzahuriMinyuTuuti != null) {
                    entityInserter.add(kouzahuriMinyuTuuti);
                }

                if (drtenMinyuKykTaisyo != null) {
                    entityInserter.add(drtenMinyuKykTaisyo);
                }

                if (dinkouMdhnFollowCall != null) {
                    entityInserter.add(dinkouMdhnFollowCall);
                }

                if (tRDattai != null) {
                    entityInserter.add(tRDattai);
                }

                kykKihon.detach();
            }

            if (misslstcount > 0) {
                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
                EditKhMisslstTbl editKhMisslstTbl = SWAKInjector.getInstance(EditKhMisslstTbl.class);
                createReport.execNoCommit(editKhMisslstTbl.editBean(
                    C_SyoruiCdKbn.AS_MISSLIST_SYUUNOU ,
                    khozenCommonParam,
                    misslstPrmList,
                    syoriYMD));
            }

            if (ansyuuBatSyoriHunoKykMisslistSks.hasMisslistMsg()) {
                ansyuuBatSyoriHunoKykMisslistSks.createReport(khozenCommonParam, syoriYMD);
            }

            khMinyuuDao.deleteTRMinyuu();

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private void hanteiTuutiSakusei(
        IT_KykKihon pKykKihon,
        IT_KykSyouhn pKykSyouhn,
        MinyuuTRBean pMinyuuTRBean,
        IT_AnsyuKihon pAnsyuKihon,
        IT_AnsyuRireki pAnsyuRireki,
        IT_DattaiUktk pDattaiUktk,
        C_HurihunoKbn pZenHurihunokbn,
        IT_Tokusin pTokusin) {

        CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
        checkYuukouJyoutaiParam.setSyono(pMinyuuTRBean.getSyono());
        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
        C_YuukoujyotaichkKbn yuukoujyotaichkKbn =
            checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);

        IT_KhTtdkTyuui khTtdkTyuui = pKykKihon.getKhTtdkTyuui();

        List<IT_Kariukekin> kariukekinLst = khMinyuuDao.getKariukekins(pKykKihon);

        BizDateYM ryousyuuYmZenGetu  = ryousyuuYm.getPreviousMonth();
        BizDateYM ryousyuuYmZenZenGetu  = ryousyuuYmZenGetu.getPreviousMonth();
        BizDateYM ryousyuuYmZenZenZenGetu  = ryousyuuYmZenZenGetu.getPreviousMonth();

        minyuutuutiSakuseiFlg = true;
        followcallSakuseiFlg = true;
        drtnMinyuumeisaiSakuseiFlg = true;
        dattaiTrSakuseiFlg = false;
        hassouKbn = C_HassouKbn.TYOKUSOU;
        tuutiSyuruiCd = "";

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            minyuutuutiSakuseiFlg = false;
            followcallSakuseiFlg = false;
            drtnMinyuumeisaiSakuseiFlg = false;
        }

        if (pDattaiUktk != null) {
            if (C_Nykkeiro.KZHRK.eq(pMinyuuTRBean.getNykkeiro())) {

                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
            else if (C_Nykkeiro.CREDIT.eq(pMinyuuTRBean.getNykkeiro())) {

                minyuutuutiSakuseiFlg = false;
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
        }

        if (C_Nykkeiro.KZHRK.eq(pMinyuuTRBean.getNykkeiro())) {
            if (!C_Hrkkeiro.KOUHURI.eq(pKykKihon.getHrkkeiro())) {

                minyuutuutiSakuseiFlg = false;
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
        }
        else if (C_Nykkeiro.CREDIT.eq(pMinyuuTRBean.getNykkeiro())) {
            if (!C_Hrkkeiro.CREDIT.eq(pKykKihon.getHrkkeiro())) {

                minyuutuutiSakuseiFlg = false;
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
        }
        else {

            minyuutuutiSakuseiFlg = false;
            followcallSakuseiFlg = false;
            drtnMinyuumeisaiSakuseiFlg = false;
        }

        if (pMinyuuTRBean.getHrkkaisuu().eq(pKykKihon.getHrkkaisuu())) {
            if (!pMinyuuTRBean.getTikiktbrisyuruiKbn().eq(pKykKihon.getTikiktbrisyuruikbn())) {

                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
        }
        else {

            followcallSakuseiFlg = false;
            drtnMinyuumeisaiSakuseiFlg = false;
        }

        if (C_Kykjyoutai.HRKMTYUU.eq(pKykSyouhn.getKykjyoutai())) {
        }
        else if (C_Kykjyoutai.HARAIMAN.eq(pKykSyouhn.getKykjyoutai())) {
            followcallSakuseiFlg = false;
        }
        else {
            minyuutuutiSakuseiFlg = false;
            followcallSakuseiFlg = false;
            drtnMinyuumeisaiSakuseiFlg = false;
        }

        if (BizDateUtil.compareYm(pAnsyuKihon.getSyuharaimanymd().getBizDateYM(), pAnsyuKihon.getJkipjytym()) ==
            BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYm(pAnsyuKihon.getSyuharaimanymd().getBizDateYM(), pAnsyuKihon.getJkipjytym()) ==
            BizDateUtil.COMPARE_EQUAL) {
            minyuutuutiSakuseiFlg = false;
            followcallSakuseiFlg = false;
            drtnMinyuumeisaiSakuseiFlg = false;
        }
        else if (BizDateUtil.compareYm(pAnsyuKihon.getSyuharaimanymd().getBizDateYM(), ryousyuuYm) ==
            BizDateUtil.COMPARE_LESSER  ||
            BizDateUtil.compareYm(pAnsyuKihon.getSyuharaimanymd().getBizDateYM(), ryousyuuYm) ==
            BizDateUtil.COMPARE_EQUAL) {
            drtnMinyuumeisaiSakuseiFlg = false;
        }

        if (C_Nykkeiro.KZHRK.eq(pMinyuuTRBean.getNykkeiro())) {
            if (C_HurihunoKbn.YKNSYATUGOU.eq(pMinyuuTRBean.getHurihunokbn()) ||
                C_HurihunoKbn.NOKOUHURIIRAI.eq(pMinyuuTRBean.getHurihunokbn()) ||
                C_HurihunoKbn.ITKTUGOU.eq(pMinyuuTRBean.getHurihunokbn())) {

                if (pMinyuuTRBean.getHurihunokbn().eq(pZenHurihunokbn)) {
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                    dattaiTrSakuseiFlg = true;
                }
                else {
                    followcallSakuseiFlg = false;
                }
            }
            else if (C_HurihunoKbn.SIKINHUSOKU.eq(pMinyuuTRBean.getHurihunokbn())) {
            }
            else if (C_HurihunoKbn.NOKOZA.eq(pMinyuuTRBean.getHurihunokbn()) ||
                C_HurihunoKbn.OTHER.eq(pMinyuuTRBean.getHurihunokbn())) {
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
        }

        if (C_Nykkeiro.CREDIT.eq(pMinyuuTRBean.getNykkeiro())) {
            if (!C_CreditUriageNgJiyuuKbn.GENDOGAKUTYOUKA.eq(pMinyuuTRBean.getCreditUriageNgJiyuuKbn())) {

                minyuutuutiSakuseiFlg = false;
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
        }

        if (C_Hrkkaisuu.TUKI.eq(pMinyuuTRBean.getHrkkaisuu()) &&
            pTokusin != null &&
            (BizDateUtil.compareYmd(pTokusin.getTokusinendymd(), syoriYMD) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pTokusin.getTokusinendymd(), syoriYMD) == BizDateUtil.COMPARE_EQUAL) &&
            C_TokusinKbn.HISAIGAI.eq(pTokusin.getTokusinkbn())) {

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pMinyuuTRBean.getTikiktbrisyuruiKbn()) ||
                C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pMinyuuTRBean.getTikiktbrisyuruiKbn())) {

                if (BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_EQUAL) {
                    minyuutuutiSakuseiFlg = false;
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
                else {
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                    tuutiSyuruiCd = tuutiSyuruiCd + "2";
                }
            }
            else if (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), pMinyuuTRBean.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL) {

                if (BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_EQUAL) {
                    minyuutuutiSakuseiFlg = false;
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
                else {
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                    tuutiSyuruiCd = tuutiSyuruiCd + "2";
                }
            }
            else {
                minyuutuutiSakuseiFlg = false;
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
        }
        else if (C_Hrkkaisuu.HALFY.eq(pMinyuuTRBean.getHrkkaisuu()) &&
            pTokusin != null &&
            (BizDateUtil.compareYmd(pTokusin.getTokusinendymd(), syoriYMD) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pTokusin.getTokusinendymd(), syoriYMD) == BizDateUtil.COMPARE_EQUAL) &&
            C_TokusinKbn.HISAIGAI.eq(pTokusin.getTokusinkbn())) {

            if (BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_EQUAL) {
                minyuutuutiSakuseiFlg = false;
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
            else {
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
                tuutiSyuruiCd = tuutiSyuruiCd + "2";
            }
        }
        else if (C_Hrkkaisuu.NEN.eq(pMinyuuTRBean.getHrkkaisuu()) &&
            pTokusin != null &&
            (BizDateUtil.compareYmd(pTokusin.getTokusinendymd(), syoriYMD) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pTokusin.getTokusinendymd(), syoriYMD) == BizDateUtil.COMPARE_EQUAL) &&
            C_TokusinKbn.HISAIGAI.eq(pTokusin.getTokusinkbn())) {

            if (BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_EQUAL) {
                minyuutuutiSakuseiFlg = false;
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
            }
            else {
                followcallSakuseiFlg = false;
                drtnMinyuumeisaiSakuseiFlg = false;
                tuutiSyuruiCd = tuutiSyuruiCd + "2";
            }
        }

        if (BizUtil.isBlank(tuutiSyuruiCd) &&
            C_Hrkkaisuu.TUKI.eq(pMinyuuTRBean.getHrkkaisuu())) {

            if (C_TkiktbrisyuruiKbn.BLNK.eq(pMinyuuTRBean.getTikiktbrisyuruiKbn()) ||
                C_TkiktbrisyuruiKbn.NONE.eq(pMinyuuTRBean.getTikiktbrisyuruiKbn())) {

                if (BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenZenZenGetu) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenZenZenGetu) == BizDateUtil.COMPARE_EQUAL) {

                    if (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), pMinyuuTRBean.getJyuutouym()) == BizDateUtil.COMPARE_EQUAL) {

                        if ((BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYm) == BizDateUtil.COMPARE_EQUAL &&
                            (BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYm) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenGetu) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenZenGetu) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenZenZenGetu) == BizDateUtil.COMPARE_EQUAL)) ||
                            (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYmZenGetu) == BizDateUtil.COMPARE_EQUAL &&
                            (BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenGetu) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenZenGetu) == BizDateUtil.COMPARE_EQUAL ||
                            BizDateUtil.compareYm(pAnsyuRireki.getJkipjytym(), ryousyuuYmZenZenZenGetu) == BizDateUtil.COMPARE_EQUAL))) {
                        }
                        else if (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYmZenZenGetu) == BizDateUtil.COMPARE_EQUAL &&
                            pTokusin != null &&
                            C_TokusinKbn.OTHER.eq(pTokusin.getTokusinkbn())){

                            if (BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_LESSER) {
                                followcallSakuseiFlg = false;
                                drtnMinyuumeisaiSakuseiFlg = false;
                            }
                            else {
                                minyuutuutiSakuseiFlg = false;
                                followcallSakuseiFlg = false;
                                drtnMinyuumeisaiSakuseiFlg = false;
                            }
                        }
                        else {
                            minyuutuutiSakuseiFlg = false;
                            followcallSakuseiFlg = false;
                            drtnMinyuumeisaiSakuseiFlg = false;
                        }
                    }
                    else {
                        minyuutuutiSakuseiFlg = false;
                        followcallSakuseiFlg = false;
                        drtnMinyuumeisaiSakuseiFlg = false;
                    }
                }
                else {
                    minyuutuutiSakuseiFlg = false;
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }

            }

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pMinyuuTRBean.getTikiktbrisyuruiKbn())) {

                if (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYm) == BizDateUtil.COMPARE_EQUAL ||
                    BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYmZenGetu) == BizDateUtil.COMPARE_EQUAL) {
                }
                else if(pTokusin != null &&
                    C_TokusinKbn.OTHER.eq(pTokusin.getTokusinkbn()) &&
                    BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_LESSER &&
                    BizDateUtil.compareYm(ryousyuuYm, pAnsyuKihon.getJkipjytym().addMonths(5)) == BizDateUtil.COMPARE_LESSER) {
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
                else {
                    minyuutuutiSakuseiFlg = false;
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pMinyuuTRBean.getTikiktbrisyuruiKbn())) {

                if (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYm) == BizDateUtil.COMPARE_EQUAL ||
                    BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYmZenGetu) == BizDateUtil.COMPARE_EQUAL) {
                }
                else if(pTokusin != null &&
                    C_TokusinKbn.OTHER.eq(pTokusin.getTokusinkbn()) &&
                    BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_LESSER &&
                    BizDateUtil.compareYm(ryousyuuYm, pAnsyuKihon.getJkipjytym().addMonths(11)) == BizDateUtil.COMPARE_LESSER) {

                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
                else {
                    minyuutuutiSakuseiFlg = false;
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
            }
        }

        if (BizUtil.isBlank(tuutiSyuruiCd)) {

            if (C_Hrkkaisuu.HALFY.eq(pMinyuuTRBean.getHrkkaisuu())) {

                if (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYm) == BizDateUtil.COMPARE_EQUAL ||
                    BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYmZenGetu) == BizDateUtil.COMPARE_EQUAL) {
                }
                else if (pTokusin != null &&
                    C_TokusinKbn.OTHER.eq(pTokusin.getTokusinkbn()) &&
                    BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_LESSER &&
                    BizDateUtil.compareYm(ryousyuuYm, pAnsyuKihon.getJkipjytym().addMonths(5)) == BizDateUtil.COMPARE_LESSER) {

                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
                else {
                    minyuutuutiSakuseiFlg = false;
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
            }
            else if (C_Hrkkaisuu.NEN.eq(pMinyuuTRBean.getHrkkaisuu())) {
                if (BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYm) == BizDateUtil.COMPARE_EQUAL ||
                    BizDateUtil.compareYm(pAnsyuKihon.getJkipjytym(), ryousyuuYmZenGetu) == BizDateUtil.COMPARE_EQUAL) {
                }
                else if (pTokusin != null &&
                    C_TokusinKbn.OTHER.eq(pTokusin.getTokusinkbn()) &&
                    BizDateUtil.compareYm(ryousyuuYm, tokusinEndYm) == BizDateUtil.COMPARE_LESSER &&
                    BizDateUtil.compareYm(ryousyuuYm, pAnsyuKihon.getJkipjytym().addMonths(11)) == BizDateUtil.COMPARE_LESSER) {

                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
                else {
                    minyuutuutiSakuseiFlg = false;
                    followcallSakuseiFlg = false;
                    drtnMinyuumeisaiSakuseiFlg = false;
                }
            }

        }

        if (khTtdkTyuui != null &&
            C_KktyuitaKbn.DNGNMEMOARI.eq(khTtdkTyuui.getKktyuitakbn())) {
            followcallSakuseiFlg = false;
            tuutiSyuruiCd = tuutiSyuruiCd + "1";
        }

        if (kariukekinLst.size() != 0) {
            followcallSakuseiFlg = false;
            drtnMinyuumeisaiSakuseiFlg = false;
            tuutiSyuruiCd = tuutiSyuruiCd + "3";
        }

        if (!BizUtil.isBlank(tuutiSyuruiCd)) {

            hassouKbn = C_HassouKbn.HONSYAKAISOU;

            if (tuutiSyuruiCd.contains("1")) {
                tuutiSyuruiCd = "Z01";
            }
            else {
                if (tuutiSyuruiCd.contains("2")) {
                    tuutiSyuruiCd = "A01";
                }
                else {
                    tuutiSyuruiCd = "A02";
                }
            }
        }
    }

    private IT_GinkouMdhnFollowCall insertGinkouMdhnFollowCall(
        IT_KykKihon pKykKihon,
        IT_KykSyouhn pKykSyouhn,
        MinyuuTRBean pMinyuuTRBean,
        IT_AnsyuKihon pAnsyuKihon) {

        String bsyujDrtencds[] = new String[5];
        bsyujDrtencds[0] = "";
        bsyujDrtencds[1] = "";
        bsyujDrtencds[2] = "";
        bsyujDrtencds[3] = "";
        bsyujDrtencds[4] = "";

        String bsyujBosyuucds[] = new String[5];
        bsyujBosyuucds[0] = "";
        bsyujBosyuucds[1] = "";
        bsyujBosyuucds[2] = "";
        bsyujBosyuucds[3] = "";
        bsyujBosyuucds[4] = "";

        List<IT_KykDairiten> kykDairitenLst = pKykKihon.getKykDairitens();
        if (kykDairitenLst.size() == 0) {
            throw new CommonBizAppException("契約代理店TBLにデータが存在しません。");
        }

        for (int index = 0; index < kykDairitenLst.size(); index++) {
            bsyujDrtencds[index] = kykDairitenLst.get(index).getDrtencd();
            bsyujBosyuucds[index] = kykDairitenLst.get(index).getBosyuucd();
            if (index >= 4) {
                break;
            }
        }

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
        BzGetAgInfoBean agInfoBean = null;
        List<BzGetAgInfoBean> agInfoBeanLst = bzGetAgInfo.exec(bsyujDrtencds[0]);
        for (BzGetAgInfoBean bean : agInfoBeanLst) {
            if (bean.getDiritenJyouhouKbn().eq(C_DiritenjyouhouKbn.KEISYOUKO)) {
                agInfoBean = bean;
                break;
            }
        }

        String saisinBosyuucd = agInfoBean.getDaiBosyuuCd();

        IT_KykSya kykSya = pKykKihon.getKykSya();
        IT_HhknSya hhknSya = pKykKihon.getHhknSya();
        IT_Kouza kouza = pKykKihon.getKouza();

        String bankcd = "";
        String sitencd = "";
        C_YokinKbn yokinkbn = C_YokinKbn.BLNK;
        String kouzano = "";
        String kzmeiginmkn = "";

        if (kouza != null) {

            bankcd = kouza.getBankcd();
            sitencd = kouza.getSitencd();
            yokinkbn = kouza.getYokinkbn();
            kouzano = kouza.getKouzano();
            kzmeiginmkn = kouza.getKzmeiginmkn();
        }

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(
            pKykSyouhn.getSyouhncd(), pKykSyouhn.getSyouhnsdno());

        String fcHrkKaisuu = "";

        if (C_Hrkkaisuu.NEN.eq(pKykKihon.getHrkkaisuu())) {

            fcHrkKaisuu = "1";
        }
        else if (C_Hrkkaisuu.HALFY.eq(pKykKihon.getHrkkaisuu())) {

            fcHrkKaisuu = "2";
        }
        else if (C_Hrkkaisuu.TUKI.eq(pKykKihon.getHrkkaisuu())) {

            if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) ) {

                fcHrkKaisuu = "4";
            }
            else if (C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKykKihon.getTikiktbrisyuruikbn()) ) {

                fcHrkKaisuu = "5";
            }
            else {

                fcHrkKaisuu = "3";
            }
        }
        else {

            fcHrkKaisuu = "0";
        }

        IT_GinkouMdhnFollowCall ginkouMdhnFollowCall = new IT_GinkouMdhnFollowCall(syoriYMD, pMinyuuTRBean.getSyono());

        ginkouMdhnFollowCall.setKyksakuinmeino(kykSya.getKyksakuinmeino());
        ginkouMdhnFollowCall.setKykseiymd(kykSya.getKykseiymd());
        ginkouMdhnFollowCall.setKyknmkj(kykSya.getKyknmkj());
        ginkouMdhnFollowCall.setKyknmkn(kykSya.getKyknmkn());
        ginkouMdhnFollowCall.setTsintelno(kykSya.getTsintelno());
        ginkouMdhnFollowCall.setFollowcallsyorikbn("1");
        ginkouMdhnFollowCall.setTsinyno(kykSya.getTsinyno());

        ginkouMdhnFollowCall.setTsinadr1kj(kykSya.getTsinadr1kj());
        ginkouMdhnFollowCall.setTsinadr2kj(kykSya.getTsinadr2kj());
        ginkouMdhnFollowCall.setTsinadr3kj(kykSya.getTsinadr3kj());

        ginkouMdhnFollowCall.setBsyujdrtencd1(bsyujDrtencds[0]);
        ginkouMdhnFollowCall.setBsyujbosyuucd1(bsyujBosyuucds[0]);
        ginkouMdhnFollowCall.setBsyujdrtencd2(bsyujDrtencds[1]);
        ginkouMdhnFollowCall.setBsyujbosyuucd2(bsyujBosyuucds[1]);
        ginkouMdhnFollowCall.setBsyujdrtencd3(bsyujDrtencds[2]);
        ginkouMdhnFollowCall.setBsyujbosyuucd3(bsyujBosyuucds[2]);
        ginkouMdhnFollowCall.setBsyujdrtencd4(bsyujDrtencds[3]);
        ginkouMdhnFollowCall.setBsyujbosyuucd4(bsyujBosyuucds[3]);
        ginkouMdhnFollowCall.setBsyujdrtencd5(bsyujDrtencds[4]);
        ginkouMdhnFollowCall.setBsyujbosyuucd5(bsyujBosyuucds[4]);

        ginkouMdhnFollowCall.setSaisindrtencd(agInfoBean.getDrtenCd());
        ginkouMdhnFollowCall.setSaisinbosyuucd(saisinBosyuucd);

        if (syouhnZokusei.getSyouhnnmsyouken().length() > 11) {
            ginkouMdhnFollowCall.setSyouhnnm(
                StringUtils.right(syouhnZokusei.getSyouhnnmsyouken(), 11));
        }
        else {
            ginkouMdhnFollowCall.setSyouhnnm(syouhnZokusei.getSyouhnnmsyouken());
        }
        ginkouMdhnFollowCall.setKykymd(pKykSyouhn.getKykymd());
        ginkouMdhnFollowCall.setJkipjytym(pAnsyuKihon.getJkipjytym());

        if (C_Nykkeiro.KZHRK.eq(pMinyuuTRBean.getNykkeiro())) {
            ginkouMdhnFollowCall.setAnnaigk(nextAnnaikg);
        }

        ginkouMdhnFollowCall.setHrkkeiro(pKykKihon.getHrkkeiro());
        ginkouMdhnFollowCall.setFchrkkaisuu(fcHrkKaisuu);

        if (C_Nykkeiro.CREDIT.eq(pMinyuuTRBean.getNykkeiro())) {
            ginkouMdhnFollowCall.setAnniskcd("005");
        }

        ginkouMdhnFollowCall.setBankcd(bankcd);
        ginkouMdhnFollowCall.setSitencd(sitencd);
        ginkouMdhnFollowCall.setYokinkbn(yokinkbn);
        ginkouMdhnFollowCall.setKouzano(kouzano);
        ginkouMdhnFollowCall.setKzmeiginmkn(kzmeiginmkn);
        ginkouMdhnFollowCall.setHhknnmkj(hhknSya.getHhknnmkj());
        ginkouMdhnFollowCall.setHhknnmkn(hhknSya.getHhknnmkn());
        ginkouMdhnFollowCall.setHhknsei(hhknSya.getHhknsei());
        ginkouMdhnFollowCall.setHhknseiymd(hhknSya.getHhknseiymd());
        ginkouMdhnFollowCall.setKyknmhnykkbn("1");
        ginkouMdhnFollowCall.setHhknnmhnykkbn("1");
        ginkouMdhnFollowCall.setMinyuym(ryousyuuYm);
        ginkouMdhnFollowCall.setGyoumuKousinKinou(kinouID);
        ginkouMdhnFollowCall.setGyoumuKousinsyaId(kosID);
        ginkouMdhnFollowCall.setGyoumuKousinTime(kosTime);

        BizPropertyInitializer.initialize(ginkouMdhnFollowCall);
        return ginkouMdhnFollowCall;
    }

    private IT_TRKzhuriKurikosiMinyuu insertTRKzhuriKurikosiMinyuu(MinyuuTRBean pMinyuuTRBean) {

        IT_TRKzhuriKurikosiMinyuu tRKzhuriKurikosiMinyuu =  new IT_TRKzhuriKurikosiMinyuu(
            pMinyuuTRBean.getSyono(), pMinyuuTRBean.getSyoriYmd(), pMinyuuTRBean.getMinyuutrrenno());

        tRKzhuriKurikosiMinyuu.setNykkeiro(pMinyuuTRBean.getNykkeiro());
        tRKzhuriKurikosiMinyuu.setNyknaiyoukbn(pMinyuuTRBean.getNyknaiyoukbn());
        tRKzhuriKurikosiMinyuu.setJyuutouym(pMinyuuTRBean.getJyuutouym());
        tRKzhuriKurikosiMinyuu.setJyutoukaisuuy(pMinyuuTRBean.getJyutoukaisuuy());
        tRKzhuriKurikosiMinyuu.setJyutoukaisuum(pMinyuuTRBean.getJyutoukaisuum());
        tRKzhuriKurikosiMinyuu.setRsgaku(pMinyuuTRBean.getRsgaku());
        tRKzhuriKurikosiMinyuu.setRyosyuymd(pMinyuuTRBean.getRyosyuymd());
        tRKzhuriKurikosiMinyuu.setHurihunokbn(pMinyuuTRBean.getHurihunokbn());
        tRKzhuriKurikosiMinyuu.setBankcd(pMinyuuTRBean.getBankCd());
        tRKzhuriKurikosiMinyuu.setSitencd(pMinyuuTRBean.getSitenCd());
        tRKzhuriKurikosiMinyuu.setYokinkbn(pMinyuuTRBean.getYokinKbn());
        tRKzhuriKurikosiMinyuu.setKouzano(pMinyuuTRBean.getKouzaNo());
        tRKzhuriKurikosiMinyuu.setDantaikobetukbn(pMinyuuTRBean.getDantaiKobetuKbn());
        tRKzhuriKurikosiMinyuu.setHrkkaisuu(pMinyuuTRBean.getHrkkaisuu());
        tRKzhuriKurikosiMinyuu.setKzhurikaetkbtannaihyj(pMinyuuTRBean.getKzhurikaeTkbtannaiHyj());
        tRKzhuriKurikosiMinyuu.setTikiktbrisyuruikbn(pMinyuuTRBean.getTikiktbrisyuruiKbn());
        tRKzhuriKurikosiMinyuu.setCreditkessaiyouno(pMinyuuTRBean.getCreditkessaiyouno());
        tRKzhuriKurikosiMinyuu.setCredituriagengjiyuu(pMinyuuTRBean.getCreditUriageNgJiyuuKbn());
        tRKzhuriKurikosiMinyuu.setGyoumuKousinKinou(kinouID);
        tRKzhuriKurikosiMinyuu.setGyoumuKousinsyaId(kosID);
        tRKzhuriKurikosiMinyuu.setGyoumuKousinTime(kosTime);

        BizPropertyInitializer.initialize(tRKzhuriKurikosiMinyuu);

        return tRKzhuriKurikosiMinyuu;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
