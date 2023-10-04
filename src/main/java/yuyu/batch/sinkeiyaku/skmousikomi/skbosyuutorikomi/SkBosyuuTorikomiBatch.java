package yuyu.batch.sinkeiyaku.skmousikomi.skbosyuutorikomi;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.bzcommon.SkjStringUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.BosTrParam;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DrtensyKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykymdtkrumu;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_MobilebosyuuKbn;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_PmnjtkhukaKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuuseiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_BosDairiten;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.entity.HT_BosSyouhn;
import yuyu.def.db.entity.HT_BosTrkKzk;
import yuyu.def.db.entity.HT_BosUketorinin;
import yuyu.def.db.entity.ZT_SmbcBosTr;
import yuyu.def.db.entity.ZT_TiginSinkinBosTr;
import yuyu.def.sinkeiyaku.configuration.SkSeihoWebBosKoumokuCheckBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 申込入力 募集情報取込
 */
public class SkBosyuuTorikomiBatch implements Batch {

    private static final int RENNO = 1;

    private static final int UKTSYURENNOSB = 1;

    private static final int UKTSYURENNONK = 1;

    private static final int UKTSYURENNOHH = 1;

    private static final int UKTSYURENNOKK = 1;

    private static final String INITYMD = "0";

    private static final String INITKINYUUKIKANCD = "0000";

    private static final String SEKNO = "sekno";

    private static final String MOSSAKUSEIYMD = "mossakuseiymd";

    private static final String PYKKIGENYMD = "pykkigenymd";

    private static final String MOSCALCKIJYUNYMD = "moscalckijyunymd";

    private static final String KYKNMKN = "kyknmkn";

    private static final String KYKNMKJ = "kyknmkj";

    private static final String KYKSEIYMD = "kykseiymd";

    private static final String KYKKINMUSAKINM = "kykkinmusakinm";

    private static final String TSINYNO = "tsinyno";

    private static final String TSINADR1KJ = "tsinadr1kj";

    private static final String TSINADR2KJ = "tsinadr2kj";

    private static final String TSINADR3KJ = "tsinadr3kj";

    private static final String TSINTELNO = "tsintelno";

    private static final String HHKNNMKN = "hhknnmkn";

    private static final String HHKNNMKJ = "hhknnmkj";

    private static final String HHKNSEIYMD = "hhknseiymd";

    private static final String HHKNSYKGYCD = "hhknsykgycd";

    private static final String HHKNYNO = "hhknyno";

    private static final String HHKNADR1KJ = "hhknadr1kj";

    private static final String HHKNADR2KJ = "hhknadr2kj";

    private static final String HHKNADR3KJ = "hhknadr3kj";

    private static final String HHKNTELNO = "hhkntelno";

    private static final String HHKNKINMUSAKINM = "hhknkinmusakinm";

    private static final String SYUKIHONS = "syukihons";

    private static final String MOSSYUKYKP = "mossyukykp";

    private static final String SBUKTNMKN1 = "sbuktnmkn1";

    private static final String SBUKTNMKJ1 = "sbuktnmkj1";

    private static final String SBUKTSEIYMD1 = "sbuktseiymd1";

    private static final String NENKINUKTNMKANA = "nenkinuktnmkana";

    private static final String NENKINUKTNMKANJI = "nenkinuktnmkanji";

    private static final String NENKINUKTSEIYMD = "nenkinuktseiymd";

    private static final String HKNKKN = "hknkkn";

    private static final String HRKKKN = "hrkkkn";

    private static final String SYUDAI1HKNKKN = "syudai1hknkkn";

    private static final String ZNNKAI = "znnkai";

    private static final String MOSIKKATUP = "mosikkatup";

    private static final String MOSZENNOUPSYOKAIARI = "moszennoupsyokaiari";

    private static final String CIFCD = "cifcd";

    private static final String DRTENJIMCD1 = "drtenjimcd1";

    private static final String BOSYUUNINTOUROKUNO1 = "bosyuunintourokuno1";

    private static final String DAIRITENKINYUUKIKANCD1 = "dairitenkinyuukikancd1";

    private static final String DAIRITENKINYUUKIKANSITENCD1 = "dairitenkinyuukikansitencd1";

    private static final String INPUTBOSYUUCD2 = "inputbosyuucd2";

    private static final String TRKKZKNMKN1 = "trkkzknmkn1";

    private static final String TRKKZKNMKJ1 = "trkkzknmkj1";

    private static final String TRKKZKSEIYMD1 = "trkkzkseiymd1";

    private static final String TRKKZKYNO1 = "trkkzkyno1";

    private static final String TRKKZKADR1KJ1 = "trkkzkadr1kj1";

    private static final String TRKKZKADR2KJ1 = "trkkzkadr2kj1";

    private static final String TRKKZKADR3KJ1 = "trkkzkadr3kj1";

    private static final String TRKKZKTELNO1 = "trkkzktelno1";

    private static final String HHKDRNMKN = "hhkdrnmkn";

    private static final String HHKDRNMKJ = "hhkdrnmkj";

    private static final String HHKDRSEIYMD = "hhkdrseiymd";

    private static final String DRTKKANOUHYJ_HUKAKANO = "1";

    private static final String DRTKKANOUHYJ_NONE = "0";

    private static final String KZKTRKMOSKBN_MITEI = "3";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SkBosyuuTorikomiBatchParam skBosyuuTorikomiBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return skBosyuuTorikomiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = skBosyuuTorikomiBatchParam.getSyoriYmd();
        String kakutyoujobcd = skBosyuuTorikomiBatchParam.getIbKakutyoujobcd();
        String torikomumotocd = skBosyuuTorikomiBatchParam.getTorikomumotocd();
        String recoveryfilterId = "Sk005";

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobcd));

        BizDate zenEigyoubi = syoriYmd.addBusinessDays(-1);

        Iterator<?> bosTrParamLst = null;
        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        if ("1".equals(torikomumotocd)) {

            try (ExDBResults<ZT_SmbcBosTr> smbcBosTrLst = zdbDomManager.getSmbcBosTrsByKakutyoujobcdItems(
                kakutyoujobcd, "0", "1", String.valueOf(zenEigyoubi), String.valueOf(syoriYmd));

                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter()) {

                bosTrParamLst = smbcBosTrLst.iterator();

                doSkBosyuuTorikomi(bosTrParamLst, multipleEntityInserter, "ZT_SmbcBosTr", recoveryfilterId,
                    kakutyoujobcd, syoriYmd, gyoumuKousinTime);
            }
        }
        else if ("2".equals(torikomumotocd)) {

            try (ExDBResults<ZT_TiginSinkinBosTr> tiginSinkinBosTrLst = zdbDomManager
                .getTiginSinkinBosTrsByKakutyoujobcdItems(
                    kakutyoujobcd, "0", "1", String.valueOf(zenEigyoubi), String.valueOf(syoriYmd));

                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter()) {

                bosTrParamLst = tiginSinkinBosTrLst.iterator();

                doSkBosyuuTorikomi(bosTrParamLst, multipleEntityInserter, "ZT_TiginSinkinBosTr", recoveryfilterId,
                    kakutyoujobcd, syoriYmd, gyoumuKousinTime);
            }
        }
        else {

            throw new BizAppException(MessageId.EBF0010, "取込元コード");
        }
    }

    private void doSkBosyuuTorikomi(Iterator<?> pBosTrParamLst,
        MultipleEntityInserter pMultipleEntityInserter, String pTableId, String pRecoveryfilterId,
        String pKakutyoujobCd, BizDate pSyoriYmd, String pGyoumuKousinTime) {

        if (!pBosTrParamLst.hasNext()) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0003));
        }
        else {
            long syoriOKKensuu = 0;
            long syoriNGKensuu = 0;
            EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku =
                SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);
            Validator validator = SWAKInjector.getInstance(Validator.class);

            while (pBosTrParamLst.hasNext()) {
                BosTrParam bosTrParam = (BosTrParam) pBosTrParamLst.next();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(pKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(pTableId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(pRecoveryfilterId);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bosTrParam.getZtrseihowebidkbn());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(bosTrParam.getZtrseihowebkojincd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3(bosTrParam.getZtrseihowebitijihozonhyouji());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey4(String.valueOf(bosTrParam.getZtrseihowebsekno()));

                String mosno = editSeihoWebRenkeiKoumoku.mosnoHensyuu(bosTrParam.getZtrseihowebmosno());
                boolean result = MousikomiNoCheck.isValid(mosno);
                if (!result) {
                    batchLogger.error(MessageUtil.getMessage(MessageId.EBF0147, "申込番号"));

                    throw new CommonBizAppException("申込番号=" + mosno);
                }

                C_HknsyuruiNo hknsyuruino = editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(
                    bosTrParam.getZtrseihowebhknsyuruino());

                List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager
                    .getSkHokenSyuruiNosByHknsyuruinoHyoujidate(hknsyuruino, pSyoriYmd);

                if (skHokenSyuruiNoLst.size() == 0) {
                    batchLogger.error(MessageUtil.getMessage(MessageId.EBS0005, "HM_SkHokenSyuruiNo", "保険種類番号",
                        hknsyuruino.getValue(), "表示日", String.valueOf(pSyoriYmd)));

                    throw new CommonBizAppException("申込番号=" + mosno);
                }

                HT_BosKihon bosKihon = sinkeiyakuDomManager.getBosKihon(mosno);
                if (bosKihon != null) {
                    syoriNGKensuu++;
                    continue;
                }

                C_Tuukasyu tuukasyu = C_Tuukasyu.BLNK;
                C_UmuKbn umuKbn = C_UmuKbn.NONE;

                tuukasyu = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(bosTrParam.getZtrseihowebsiteituukakbn());

                if ("1".equals(bosTrParam.getZtrseihowebyenhsyutkarihyj())) {
                    umuKbn = C_UmuKbn.ARI;
                }

                C_Sknenkinsyu sknenkinsyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan(bosTrParam.getZtrseihowebnksyuruikbn());

                C_UmuKbn teikisiharaikinUmu = C_UmuKbn.NONE;

                String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(hknsyuruino);
                BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

                if ("1".equals(syouhinHantei)) {

                    List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager
                        .getSyouhnZokuseisByHknsyuruinoItems(pSyoriYmd, C_SyutkKbn.SYU,
                            skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino(), 0, bosTrParam.getZtrseihowebdai1hknkkn(),
                            tuukasyu, umuKbn, sknenkinsyu, teikisiharaikinUmu);

                    if (syouhnZokuseiLst.size() == 0) {
                        batchLogger.error(
                            MessageUtil.getMessage(MessageId.EBS1011, "BM_SyouhnZokusei", "表示日",
                                String.valueOf(pSyoriYmd), "主契約特約区分", C_SyutkKbn.SYU.getValue(), "保険種類番号",
                                skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino().getValue(), "年金原資最低保証率", "0",
                                "第１保険期間", String.valueOf(bosTrParam.getZtrseihowebdai1hknkkn()), "通貨種類",
                                tuukasyu.getValue(), "初期死亡時円換算最低保証特約適用有無", umuKbn.getValue(),
                                "新契約年金種類", sknenkinsyu.getValue(), "定期支払金有無", teikisiharaikinUmu.getValue()));

                        throw new CommonBizAppException("申込番号=" + mosno);
                    }

                    syouhnZokusei = syouhnZokuseiLst.get(0);
                }
                else {

                    List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager
                        .getSyouhnZokuseisByHknsyuruinoItems2(pSyoriYmd, C_SyutkKbn.SYU,
                            skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino(), 0, umuKbn, sknenkinsyu, teikisiharaikinUmu);

                    if (syouhnZokuseiLst.size() == 0) {
                        batchLogger.error(
                            MessageUtil.getMessage(MessageId.EBS1009,
                                "BM_SyouhnZokusei", "表示日", String.valueOf(pSyoriYmd),
                                "主契約特約区分", C_SyutkKbn.SYU.getValue(),
                                "保険種類番号", skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino().getValue(),
                                "年金原資最低保証率", "0",
                                "初期死亡時円換算最低保証特約適用有無", umuKbn.getValue(),
                                "新契約年金種類", sknenkinsyu.getValue(),
                                "定期支払金有無", teikisiharaikinUmu.getValue()));

                        throw new CommonBizAppException("申込番号=" + mosno);
                    }

                    syouhnZokusei = syouhnZokuseiLst.get(0);
                }

                String hhknkjnm = "";
                String kykkjnm = "";
                String hrkkeirokbn = "";
                String sbuktnrkkbn = "";
                String sbukttdkkbn = "";
                String sbuktknnm = "";
                String sbuktkjnm = "";
                String sbuktseiymd = "";
                String hhkntelno = "";
                String kyktelno = "";
                String kykkihontikucd = "";
                String kykadr = "";
                String mrhkihontikucd = "";
                String hhknadr = "";
                String kykottmsk = "";
                String hhknottmsk = "";
                String hhknsykgycd = "";
                String sakuseijisitencd = "";
                String dairitenkinyuukikancd1 = "";
                String dairitenkinyuukikansitencd1 = "";
                String drtenjimcd1 = "";
                String mkuktkjnm = "";
                C_KykKbn kykKbn = null;
                String hhkndrkjnm = "";
                String kzkkjnm1 = "";
                String kzkadr1 = "";
                long hrktuukasyutkP = 0;
                long gkHrktuukasyutkP = 0;
                String mosTuukasyukbn = "";

                if ("1".equals(bosTrParam.getZtrseihowebhnyppltzmhyj())) {
                    hhknkjnm = bosTrParam.getZtrseihowebplhhknkjnm();
                    kykkjnm = bosTrParam.getZtrseihowebplkykkjnm();
                    hrkkeirokbn = bosTrParam.getZtrseihowebplhrkkeirokbn();
                    sbuktnrkkbn = bosTrParam.getZtrseihowebplsbuktnrkkbn();
                    sbukttdkkbn = bosTrParam.getZtrseihowebplsbukttdkkbn();
                    sbuktknnm = bosTrParam.getZtrseihowebplsbuktknnm();
                    sbuktkjnm = bosTrParam.getZtrseihowebplsbuktkjnm();
                    sbuktseiymd = bosTrParam.getZtrseihowebplsbuktseiymd();
                    hhkntelno = bosTrParam.getZtrseihowebplhhkntelno();
                    kyktelno = bosTrParam.getZtrseihowebplkyktelno();
                    kykkihontikucd = bosTrParam.getZtrseihowebplkihontikucd();
                    kykadr = bosTrParam.getZtrseihowebpltsinadrkai();
                    mrhkihontikucd = bosTrParam.getZtrseihowebplhiikihontikucd();
                    hhknadr = bosTrParam.getZtrseihowebplhhknadr();
                    kykottmsk = bosTrParam.getZtrseihowebkykottmsk();
                    hhknottmsk = bosTrParam.getZtrseihowebhhknottmsk();
                    hhknsykgycd = bosTrParam.getZtrseihowebhhknsykgycd();
                }
                else {
                    hhknkjnm = bosTrParam.getZtrseihowebhhknkjnm();
                    kykkjnm = bosTrParam.getZtrseihowebkykkjnm();
                    hrkkeirokbn = bosTrParam.getZtrseihowebhrkkeirokbn();
                    sbuktnrkkbn = bosTrParam.getZtrseihowebsbuktnrkkbn();
                    sbukttdkkbn = bosTrParam.getZtrseihowebsbukttdkkbn();
                    sbuktknnm = bosTrParam.getZtrseihowebsbuktknnm();
                    sbuktkjnm = bosTrParam.getZtrseihowebsbuktkjnm();
                    sbuktseiymd = bosTrParam.getZtrseihowebsbuktseiymd();
                    hhkntelno = bosTrParam.getZtrseihowebhhkntelno();
                    kyktelno = bosTrParam.getZtrseihowebkyktelno();
                    kykkihontikucd = bosTrParam.getZtrseihowebkykkihontikucd();
                    kykadr = bosTrParam.getZtrseihowebkykadr();
                    mrhkihontikucd = bosTrParam.getZtrseihowebmrhkihontikucd();
                    hhknadr = bosTrParam.getZtrseihowebhhknadr();
                    kykottmsk = "";
                    hhknottmsk = "";
                    hhknsykgycd = "";
                }


                if (!BizUtil.isBlank(kykkjnm)) {
                    kykkjnm = SkjStringUtil.convInvalidChar(kykkjnm);
                }

                if (!BizUtil.isBlank(kykadr)) {
                    kykadr = SkjStringUtil.convInvalidChar(kykadr);
                }

                if (!BizUtil.isBlank(hhknkjnm)) {
                    hhknkjnm = SkjStringUtil.convInvalidChar(hhknkjnm);
                }

                if (!BizUtil.isBlank(hhknadr)) {
                    hhknadr = SkjStringUtil.convInvalidChar(hhknadr);
                }

                if (!BizUtil.isBlank(sbuktkjnm)) {
                    sbuktkjnm = SkjStringUtil.convInvalidChar(sbuktkjnm);
                }

                if (!BizUtil.isBlank(bosTrParam.getZtrseihowebhhkndrkjnm())) {

                    hhkndrkjnm = SkjStringUtil.convInvalidChar(bosTrParam.getZtrseihowebhhkndrkjnm());
                }
                else {
                    hhkndrkjnm = bosTrParam.getZtrseihowebhhkndrkjnm();
                }

                if (!BizUtil.isBlank(bosTrParam.getZtrseihowebmnkuktkjnm())) {
                    mkuktkjnm = SkjStringUtil.convInvalidChar(bosTrParam.getZtrseihowebmnkuktkjnm());
                }

                if (!BizUtil.isBlank(bosTrParam.getZtrseihowebkzkkjnm1())) {

                    kzkkjnm1 = SkjStringUtil.convInvalidChar(bosTrParam.getZtrseihowebkzkkjnm1());
                }
                else {
                    kzkkjnm1 = bosTrParam.getZtrseihowebkzkkjnm1();
                }

                if (!BizUtil.isBlank(bosTrParam.getZtrseihowebkzkadr1())) {

                    kzkadr1 =  SkjStringUtil.convInvalidChar(bosTrParam.getZtrseihowebkzkadr1());
                }
                else {

                    kzkadr1 = bosTrParam.getZtrseihowebkzkadr1();
                }

                if (!BizUtil.isBlank(kykottmsk)) {
                    kykottmsk = SkjStringUtil.convInvalidChar(kykottmsk);
                }

                if (!BizUtil.isBlank(hhknottmsk)) {
                    hhknottmsk = SkjStringUtil.convInvalidChar(hhknottmsk);
                }

                if (!BizUtil.isBlank(kykottmsk)) {
                    if (SkjStringUtil.replaceSjk(kykottmsk).isReplaced()) {
                        kykottmsk = SkjStringUtil.replaceSjk(kykottmsk).getReplacedString();
                    }
                }

                if (!BizUtil.isBlank(hhknottmsk)) {
                    if (SkjStringUtil.replaceSjk(hhknottmsk).isReplaced()) {
                        hhknottmsk = SkjStringUtil.replaceSjk(hhknottmsk).getReplacedString();
                    }
                }

                if (!BizUtil.isBlank(bosTrParam.getZtrseihowebsksjsitencd())) {

                    sakuseijisitencd = Strings.padStart(bosTrParam.getZtrseihowebsksjsitencd(), 4, '0');
                }

                if (BizUtil.isBlank(bosTrParam.getZtrseihowebaatkisyaknyuucd())
                    || INITKINYUUKIKANCD.equals(bosTrParam.getZtrseihowebaatkisyaknyuucd())) {
                    dairitenkinyuukikancd1 = "";
                    dairitenkinyuukikansitencd1 = "";
                    drtenjimcd1 = sakuseijisitencd;
                }
                else {
                    dairitenkinyuukikancd1 = bosTrParam.getZtrseihowebaatkisyaknyuucd();
                    dairitenkinyuukikansitencd1 = sakuseijisitencd;
                    drtenjimcd1 = "";
                }

                if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {

                    hrktuukasyutkP = bosTrParam.getZtrseihowebnykntuukanykngk();
                    gkHrktuukasyutkP = bosTrParam.getZtrseihowebgnykntuknykngk();
                    mosTuukasyukbn = bosTrParam.getZtrseihowebnykntuukakbn();
                }
                else {

                    hrktuukasyutkP = bosTrParam.getZtrseihowebmosp1();
                    gkHrktuukasyutkP = bosTrParam.getZtrseihowebgaikakihonp();
                    mosTuukasyukbn = bosTrParam.getZtrseihowebsiteituukakbn();
                }

                Integer hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(bosTrParam.getZtrseihowebhknkkn(),
                    bosTrParam.getZtrseihowebsueokikkn(),
                    hknsyuruino);

                SkSeihoWebBosKoumokuCheckBean skSeihoWebBosKoumokuCheckBean = SWAKInjector
                    .getInstance(SkSeihoWebBosKoumokuCheckBean.class);

                String tsinyNo = editSeihoWebRenkeiKoumoku.postalCdSyutoku(kykkihontikucd);
                String adr1 = editSeihoWebRenkeiKoumoku.adr1Syutoku(kykadr);
                String adr2 = editSeihoWebRenkeiKoumoku.adr2Syutoku(kykadr);
                String adr3 = editSeihoWebRenkeiKoumoku.adr3Syutoku(kykadr);
                String hhknyNo = editSeihoWebRenkeiKoumoku.postalCdSyutoku(mrhkihontikucd);
                String hhknadr1 = editSeihoWebRenkeiKoumoku.adr1Syutoku(hhknadr);
                String hhknadr2 = editSeihoWebRenkeiKoumoku.adr2Syutoku(hhknadr);
                String hhknadr3 = editSeihoWebRenkeiKoumoku.adr3Syutoku(hhknadr);
                BizCurrency kihons = editSeihoWebRenkeiKoumoku.kihonsSyutoku(bosTrParam.getZtrseihowebsiteituukakbn(),
                    bosTrParam.getZtrseihowebkihons(), bosTrParam.getZtrseihowebgaikakihons());
                BizCurrency mossyukykP = editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(
                    mosTuukasyukbn, hrktuukasyutkP, gkHrktuukasyutkP);
                kykottmsk = editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(kykottmsk);
                hhknottmsk = editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(hhknottmsk);

                Integer znnkai = editSeihoWebRenkeiKoumoku.huho2GetZnnkai(bosTrParam.getZtrseihowebzennoukkn());

                BizCurrency mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
                    bosTrParam.getZtrseihowebnykntuukakbn(), bosTrParam.getZtrseihowebikkatup(), Long.valueOf(0));

                BizCurrency moszennoupsyokaiari = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
                    mosTuukasyukbn, bosTrParam.getZtrseihowebzennoup(), bosTrParam.getZtrseihowebgaikazennoup());

                skSeihoWebBosKoumokuCheckBean.setSekno(bosTrParam.getZtrseihowebdrtnskno());
                if (!INITYMD.equals(bosTrParam.getZtrseihowebfstmossksymd())) {
                    skSeihoWebBosKoumokuCheckBean.setMossakuseiymd(BizDate.valueOf(bosTrParam
                        .getZtrseihowebfstmossksymd()));
                }
                if (!INITYMD.equals(bosTrParam.getZtrseihowebsekykkigenymd())) {
                    skSeihoWebBosKoumokuCheckBean.setPykkigenymd(BizDate.valueOf(bosTrParam
                        .getZtrseihowebsekykkigenymd()));
                }
                if (!INITYMD.equals(bosTrParam.getZtrseihowebcalckijyunymd())) {
                    skSeihoWebBosKoumokuCheckBean.setMoscalckijyunymd(BizDate.valueOf(bosTrParam
                        .getZtrseihowebcalckijyunymd()));
                }
                skSeihoWebBosKoumokuCheckBean.setKyknmkn(bosTrParam.getZtrseihowebkykknnm());
                skSeihoWebBosKoumokuCheckBean.setKyknmkj(kykkjnm);
                if (!INITYMD.equals(bosTrParam.getZtrseihowebkyksyaseiymd())) {
                    skSeihoWebBosKoumokuCheckBean.setKykseiymd(
                        BizDate.valueOf(bosTrParam.getZtrseihowebkyksyaseiymd()));
                }
                skSeihoWebBosKoumokuCheckBean.setKykkinmusakinm(kykottmsk);
                skSeihoWebBosKoumokuCheckBean.setTsinyno(tsinyNo);
                skSeihoWebBosKoumokuCheckBean.setTsinadr1kj(adr1);
                skSeihoWebBosKoumokuCheckBean.setTsinadr2kj(adr2);
                skSeihoWebBosKoumokuCheckBean.setTsinadr3kj(adr3);
                skSeihoWebBosKoumokuCheckBean.setTsintelno(kyktelno);
                skSeihoWebBosKoumokuCheckBean.setHhknnmkn(bosTrParam.getZtrseihowebhhknknnm());
                skSeihoWebBosKoumokuCheckBean.setHhknnmkj(hhknkjnm);
                if (!INITYMD.equals(bosTrParam.getZtrseihowebhhknseiymd())) {
                    skSeihoWebBosKoumokuCheckBean.setHhknseiymd(BizDate.valueOf(bosTrParam.getZtrseihowebhhknseiymd()));
                }
                skSeihoWebBosKoumokuCheckBean.setHhknsykgycd(hhknsykgycd);
                skSeihoWebBosKoumokuCheckBean.setHhknyno(hhknyNo);
                skSeihoWebBosKoumokuCheckBean.setHhknadr1kj(hhknadr1);
                skSeihoWebBosKoumokuCheckBean.setHhknadr2kj(hhknadr2);
                skSeihoWebBosKoumokuCheckBean.setHhknadr3kj(hhknadr3);
                skSeihoWebBosKoumokuCheckBean.setHhkntelno(hhkntelno);
                skSeihoWebBosKoumokuCheckBean.setHhknkinmusakinm(hhknottmsk);
                skSeihoWebBosKoumokuCheckBean.setSyukihons(kihons);
                skSeihoWebBosKoumokuCheckBean.setMossyukykp(mossyukykP);
                skSeihoWebBosKoumokuCheckBean.setSbuktnmkn1(sbuktknnm);
                skSeihoWebBosKoumokuCheckBean.setSbuktnmkj1(sbuktkjnm);
                if (!INITYMD.equals(sbuktseiymd)) {
                    skSeihoWebBosKoumokuCheckBean.setSbuktseiymd1(
                        BizDate.valueOf(sbuktseiymd));
                }
                skSeihoWebBosKoumokuCheckBean.setNenkinuktnmkana(bosTrParam.getZtrseihowebmnkuktknnm());
                skSeihoWebBosKoumokuCheckBean.setNenkinuktnmkanji(mkuktkjnm);
                if (!INITYMD.equals(bosTrParam.getZtrseihowebmnkuktseiymd())) {
                    skSeihoWebBosKoumokuCheckBean.setNenkinuktseiymd(
                        BizDate.valueOf(bosTrParam.getZtrseihowebmnkuktseiymd()));
                }
                skSeihoWebBosKoumokuCheckBean.setHknkkn(hknkkn);
                skSeihoWebBosKoumokuCheckBean.setHrkkkn(bosTrParam.getZtrseihowebphrkkikn());
                skSeihoWebBosKoumokuCheckBean.setSyudai1hknkkn(bosTrParam.getZtrseihowebdai1hknkkn());
                skSeihoWebBosKoumokuCheckBean.setZnnkai(znnkai);
                skSeihoWebBosKoumokuCheckBean.setMosikkatup(mosikkatup);
                skSeihoWebBosKoumokuCheckBean.setMoszennoupsyokaiari(moszennoupsyokaiari);
                skSeihoWebBosKoumokuCheckBean.setCifcd(bosTrParam.getZtrseihowebankenkanrino());
                if ("6".equals(bosTrParam.getZtrseihowebtkiyougyoutaikbn())) {
                }
                else {
                    skSeihoWebBosKoumokuCheckBean.setDrtenjimcd1(drtenjimcd1);
                    skSeihoWebBosKoumokuCheckBean.setBosyuunintourokuno1(bosTrParam.getZtrseihowebbsyutrkno());
                    skSeihoWebBosKoumokuCheckBean.setDairitenkinyuukikansitencd1(dairitenkinyuukikansitencd1);

                }
                skSeihoWebBosKoumokuCheckBean.setDairitenkinyuukikancd1(dairitenkinyuukikancd1);

                skSeihoWebBosKoumokuCheckBean.setInputbosyuucd2(bosTrParam.getZtrseihowebkydbosyuukjncd());

                String trkkzkyno1 = editSeihoWebRenkeiKoumoku.postalCdSyutoku(bosTrParam.getZtrseihowebkzkyno1());
                String trkkzkadr1kj1= editSeihoWebRenkeiKoumoku.adr1Syutoku(kzkadr1);
                String trkkzkadr2kj1= editSeihoWebRenkeiKoumoku.adr2Syutoku(kzkadr1);
                String trkkzkadr3kj1= editSeihoWebRenkeiKoumoku.adr3Syutoku(kzkadr1);

                skSeihoWebBosKoumokuCheckBean.setTrkkzknmkn1(bosTrParam.getZtrseihowebkzkknnm1());
                skSeihoWebBosKoumokuCheckBean.setTrkkzknmkj1(kzkkjnm1);

                if (!INITYMD.equals(bosTrParam.getZtrseihowebkzkseiymd1())) {

                    skSeihoWebBosKoumokuCheckBean.setTrkkzkseiymd1(
                        BizDate.valueOf(bosTrParam.getZtrseihowebkzkseiymd1()) );
                }

                skSeihoWebBosKoumokuCheckBean.setTrkkzkyno1(trkkzkyno1);
                skSeihoWebBosKoumokuCheckBean.setTrkkzkadr1kj1(trkkzkadr1kj1);
                skSeihoWebBosKoumokuCheckBean.setTrkkzkadr2kj1(trkkzkadr2kj1);
                skSeihoWebBosKoumokuCheckBean.setTrkkzkadr3kj1(trkkzkadr3kj1);
                skSeihoWebBosKoumokuCheckBean.setTrkkzktelno1(bosTrParam.getZtrseihowebkzktelno1());
                skSeihoWebBosKoumokuCheckBean.setHhkdrnmkn(bosTrParam.getZtrseihowebhhkndrknnm());
                skSeihoWebBosKoumokuCheckBean.setHhkdrnmkj(hhkndrkjnm);

                if (!INITYMD.equals(bosTrParam.getZtrseihowebhhkndrseiymd())) {

                    skSeihoWebBosKoumokuCheckBean.setHhkdrseiymd(
                        BizDate.valueOf(bosTrParam.getZtrseihowebhhkndrseiymd()));
                }

                Set<ConstraintViolation<SkSeihoWebBosKoumokuCheckBean>> skSeihoWebBosKoumokuCheckBeanSet =
                    validator.validate(skSeihoWebBosKoumokuCheckBean);

                C_UmuKbn sekNoValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn mossakuseiYmdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hkryoYkkigenYmdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn mosCalckijyunYmdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn kyknmKnValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn kyknmKjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn kykseiYmdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn kykkinmusakinmValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn tsinyNoValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn tsinadr1KjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn tsinadr2KjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn tsinadr3KjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn tsinTelnoValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknnmKnValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknnmKjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknseiYmdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknsykgycdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknyNoValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknadr1KjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknadr2KjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknadr3KjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknTelnoValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhknkinmusakinmValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn syuKihonKingakuValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn mossyukykpValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn sbUktnmKn1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn sbUktnmKj1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn sbUktseiYmd1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn nenkinUktnmKanaValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn nenkinUktnmKanjiValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn nenkinUktSeiymdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hknKknValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hrkKknValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn syudai1HknkknValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn znnkaiValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn mosikkatupValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn moszennoupsyokaiariValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn cifCdValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn drtenjimcd1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn bosyuuninTourokuNo1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn dairitenKinyuukikanCd1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn dairitenKinyuukikanSitencd1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn inputbosyuuCd2ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzknmkn1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzknmkj1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzkseiymd1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzkyno1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzkadr1kj1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzkadr2kj1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzkadr3kj1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn trkkzktelno1ValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhkdrnmknValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhkdrnmkjValidateErrUmu = C_UmuKbn.NONE;
                C_UmuKbn hhkdrseiymdValidateErrUmu = C_UmuKbn.NONE;

                if (skSeihoWebBosKoumokuCheckBeanSet.size() > 0) {
                    for (ConstraintViolation<SkSeihoWebBosKoumokuCheckBean> beanTemp : skSeihoWebBosKoumokuCheckBeanSet) {
                        if (SEKNO.equals(beanTemp.getPropertyPath().toString())) {
                            sekNoValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "設計書番号＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (MOSSAKUSEIYMD.equals(beanTemp.getPropertyPath().toString())) {
                            mossakuseiYmdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "申込書作成日＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (PYKKIGENYMD.equals(beanTemp.getPropertyPath().toString())) {
                            hkryoYkkigenYmdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "保険料有効期限年月日＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (MOSCALCKIJYUNYMD.equals(beanTemp.getPropertyPath().toString())) {
                            mosCalckijyunYmdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "申込書計算基準日＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (KYKNMKN.equals(beanTemp.getPropertyPath().toString())) {
                            kyknmKnValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "契約者名（カナ）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (KYKNMKJ.equals(beanTemp.getPropertyPath().toString())) {
                            kyknmKjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "契約者名（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (KYKSEIYMD.equals(beanTemp.getPropertyPath().toString())) {
                            kykseiYmdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "契約者生年月日＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (KYKKINMUSAKINM.equals(beanTemp.getPropertyPath().toString())) {
                            kykkinmusakinmValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "契約者勤務先名＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TSINYNO.equals(beanTemp.getPropertyPath().toString())) {
                            tsinyNoValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "通信先郵便番号＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TSINADR1KJ.equals(beanTemp.getPropertyPath().toString())) {
                            tsinadr1KjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "通信先住所１（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TSINADR2KJ.equals(beanTemp.getPropertyPath().toString())) {
                            tsinadr2KjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "通信先住所２（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TSINADR3KJ.equals(beanTemp.getPropertyPath().toString())) {
                            tsinadr3KjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "通信先住所３（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TSINTELNO.equals(beanTemp.getPropertyPath().toString())) {
                            tsinTelnoValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "通信先電話番号＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNNMKN.equals(beanTemp.getPropertyPath().toString())) {
                            hhknnmKnValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者名（カナ）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNNMKJ.equals(beanTemp.getPropertyPath().toString())) {
                            hhknnmKjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者名（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNSEIYMD.equals(beanTemp.getPropertyPath().toString())) {
                            hhknseiYmdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者生年月日＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNSYKGYCD.equals(beanTemp.getPropertyPath().toString())) {
                            hhknsykgycdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者職業コード＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNYNO.equals(beanTemp.getPropertyPath().toString())) {
                            hhknyNoValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者郵便番号＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNADR1KJ.equals(beanTemp.getPropertyPath().toString())) {
                            hhknadr1KjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者住所１（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNADR2KJ.equals(beanTemp.getPropertyPath().toString())) {
                            hhknadr2KjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者住所２（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNADR3KJ.equals(beanTemp.getPropertyPath().toString())) {
                            hhknadr3KjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者住所３（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNTELNO.equals(beanTemp.getPropertyPath().toString())) {
                            hhknTelnoValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者電話番号＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKNKINMUSAKINM.equals(beanTemp.getPropertyPath().toString())) {
                            hhknkinmusakinmValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者勤務先名＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (SYUKIHONS.equals(beanTemp.getPropertyPath().toString())) {
                            syuKihonKingakuValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "主契約基本保険金額＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (MOSSYUKYKP.equals(beanTemp.getPropertyPath().toString())) {
                            mossyukykpValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "申込主契約Ｐ＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (SBUKTNMKN1.equals(beanTemp.getPropertyPath().toString())) {
                            sbUktnmKn1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "死亡受取人名（カナ）１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (SBUKTNMKJ1.equals(beanTemp.getPropertyPath().toString())) {
                            sbUktnmKj1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "死亡受取人名（漢字）１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (SBUKTSEIYMD1.equals(beanTemp.getPropertyPath().toString())) {
                            sbUktseiYmd1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "死亡受取人生年月日１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (NENKINUKTNMKANA.equals(beanTemp.getPropertyPath().toString())) {
                            nenkinUktnmKanaValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "年金受取人名（カナ）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (NENKINUKTNMKANJI.equals(beanTemp.getPropertyPath().toString())) {
                            nenkinUktnmKanjiValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "年金受取人名（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (NENKINUKTSEIYMD.equals(beanTemp.getPropertyPath().toString())) {
                            nenkinUktSeiymdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "年金受取人生年月日＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HKNKKN.equals(beanTemp.getPropertyPath().toString())) {
                            hknKknValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "保険期間＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HRKKKN.equals(beanTemp.getPropertyPath().toString())) {
                            hrkKknValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "払込期間＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (SYUDAI1HKNKKN.equals(beanTemp.getPropertyPath().toString())) {
                            syudai1HknkknValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "主契約第１保険期間＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (ZNNKAI.equals(beanTemp.getPropertyPath().toString())) {
                            znnkaiValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "前納回数＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (MOSIKKATUP.equals(beanTemp.getPropertyPath().toString())) {
                            mosikkatupValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "申込一括払Ｐ＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (MOSZENNOUPSYOKAIARI.equals(beanTemp.getPropertyPath().toString())) {
                            moszennoupsyokaiariValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "申込前納Ｐ（初回含）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (CIFCD.equals(beanTemp.getPropertyPath().toString())) {
                            cifCdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "ＣＩＦコード＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (DRTENJIMCD1.equals(beanTemp.getPropertyPath().toString())) {
                            drtenjimcd1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "代理店事務所コード１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (BOSYUUNINTOUROKUNO1.equals(beanTemp.getPropertyPath().toString())) {
                            bosyuuninTourokuNo1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "募集人登録番号１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (DAIRITENKINYUUKIKANCD1.equals(beanTemp.getPropertyPath().toString())) {
                            dairitenKinyuukikanCd1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "代理店金融機関コード１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (DAIRITENKINYUUKIKANSITENCD1.equals(beanTemp.getPropertyPath().toString())) {
                            dairitenKinyuukikanSitencd1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "代理店金融機関支店コード１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (INPUTBOSYUUCD2.equals(beanTemp.getPropertyPath().toString())) {
                            inputbosyuuCd2ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "入力募集人コード２＝" + beanTemp.getInvalidValue(), mosno));
                        }

                        if (TRKKZKNMKN1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzknmkn1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族名（カナ）１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TRKKZKNMKJ1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzknmkj1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族名（漢字）１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TRKKZKSEIYMD1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzkseiymd1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族生年月日１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TRKKZKYNO1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzkyno1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族郵便番号１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TRKKZKADR1KJ1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzkadr1kj1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族住所１（漢字）１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TRKKZKADR2KJ1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzkadr2kj1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族住所２（漢字）１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TRKKZKADR3KJ1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzkadr3kj1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族住所３（漢字）１＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (TRKKZKTELNO1.equals(beanTemp.getPropertyPath().toString())) {

                            trkkzktelno1ValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "登録家族電話番号１＝" + beanTemp.getInvalidValue(), mosno));
                        }

                        if (HHKDRNMKN.equals(beanTemp.getPropertyPath().toString())) {

                            hhkdrnmknValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者代理人名（カナ）＝" + beanTemp.getInvalidValue(), mosno));

                        }
                        if (HHKDRNMKJ.equals(beanTemp.getPropertyPath().toString())) {

                            hhkdrnmkjValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者代理人名（漢字）＝" + beanTemp.getInvalidValue(), mosno));
                        }
                        if (HHKDRSEIYMD.equals(beanTemp.getPropertyPath().toString())) {
                            hhkdrseiymdValidateErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(MessageId.EHA1059,
                                "被保険者代理人生年月日＝" + beanTemp.getInvalidValue(), mosno));
                        }
                    }
                }


                kykKbn = editSeihoWebRenkeiKoumoku.kykkbnkyktdkkbnHenkan(bosTrParam.getZtrseihowebhnsyukyktdkkbn());

                HT_BosKihon bosKihonIns = new HT_BosKihon();

                bosKihonIns.setMosno(mosno);
                if (!C_UmuKbn.ARI.eq(sekNoValidateErrUmu)) {
                    bosKihonIns.setSekno(bosTrParam.getZtrseihowebdrtnskno());
                }
                bosKihonIns.setMosuketukekbn(C_MosUketukeKbn.SEIHOWEB);
                if (!C_UmuKbn.ARI.eq(mossakuseiYmdValidateErrUmu)) {
                    if (!INITYMD.equals(bosTrParam.getZtrseihowebfstmossksymd())) {
                        bosKihonIns.setMossakuseiymd(BizDate.valueOf(bosTrParam.getZtrseihowebfstmossksymd()));
                    }
                }
                if (!C_UmuKbn.ARI.eq(hkryoYkkigenYmdValidateErrUmu)) {
                    if (!INITYMD.equals(bosTrParam.getZtrseihowebsekykkigenymd())) {
                        bosKihonIns.setPykkigenymd(BizDate.valueOf(bosTrParam.getZtrseihowebsekykkigenymd()));
                    }
                }
                if (!C_UmuKbn.ARI.eq(mosCalckijyunYmdValidateErrUmu)) {
                    if (!INITYMD.equals(bosTrParam.getZtrseihowebcalckijyunymd())) {
                        bosKihonIns.setMoscalckijyunymd(BizDate.valueOf(bosTrParam.getZtrseihowebcalckijyunymd()));
                    }
                }
                bosKihonIns.setKykymdtkrumu(C_Kykymdtkrumu.NONE);
                bosKihonIns.setKykkbn(kykKbn);
                if (!C_UmuKbn.ARI.eq(hhknnmKnValidateErrUmu)) {
                    bosKihonIns.setHhknnmkn(bosTrParam.getZtrseihowebhhknknnm());
                }
                if (!C_UmuKbn.ARI.eq(hhknnmKjValidateErrUmu)) {
                    bosKihonIns.setHhknnmkj(hhknkjnm);
                }
                bosKihonIns.setHhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                if (!C_UmuKbn.ARI.eq(hhknseiYmdValidateErrUmu)) {
                    if (!INITYMD.equals(bosTrParam.getZtrseihowebhhknseiymd())) {
                        bosKihonIns.setHhknseiymd(BizDate.valueOf(bosTrParam.getZtrseihowebhhknseiymd()));
                    }
                }
                bosKihonIns.setHhknsei(editSeihoWebRenkeiKoumoku.hhknseiHenkan(bosTrParam
                    .getZtrseihowebhhknseikbn()));
                if (!C_UmuKbn.ARI.eq(hhknsykgycdValidateErrUmu) && !"000".equals(hhknsykgycd)) {
                    bosKihonIns.setHhknsykgycd(hhknsykgycd);
                }
                bosKihonIns.setHhknnensyuukbn(C_NensyuuKbn.BLNK);
                bosKihonIns.setTsindousiteikbn(C_TsindousiteiKbn.BLNK);
                if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
                    if (!C_UmuKbn.ARI.eq(tsinyNoValidateErrUmu)) {
                        bosKihonIns.setHhknyno(tsinyNo);
                    }
                }
                else {
                    if (!C_UmuKbn.ARI.eq(hhknyNoValidateErrUmu)) {
                        bosKihonIns.setHhknyno(hhknyNo);
                    }
                }
                if (!C_UmuKbn.ARI.eq(hhknTelnoValidateErrUmu)) {
                    bosKihonIns.setHhkntelno(hhkntelno);
                }
                if (!C_UmuKbn.ARI.eq(hhknkinmusakinmValidateErrUmu)) {
                    bosKihonIns.setHhknkinmusakinm(hhknottmsk);
                }
                if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
                    if (!C_UmuKbn.ARI.eq(kyknmKnValidateErrUmu)) {
                        bosKihonIns.setKyknmkn(bosTrParam.getZtrseihowebkykknnm());
                    }
                }
                if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
                    if (!C_UmuKbn.ARI.eq(kyknmKjValidateErrUmu)) {
                        bosKihonIns.setKyknmkj(kykkjnm);
                    }
                }
                bosKihonIns.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);
                if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
                    if (!C_UmuKbn.ARI.eq(kykseiYmdValidateErrUmu)) {
                        if (!INITYMD.equals(bosTrParam.getZtrseihowebkyksyaseiymd())) {
                            bosKihonIns.setKykseiymd(BizDate.valueOf(bosTrParam.getZtrseihowebkyksyaseiymd()));
                        }
                    }
                }
                bosKihonIns.setKyknensyuukbn(C_NensyuuKbn.BLNK);
                if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {
                    if (!C_UmuKbn.ARI.eq(kykkinmusakinmValidateErrUmu)) {
                        bosKihonIns.setKykkinmusakinm(kykottmsk);
                    }
                }
                bosKihonIns.setHjndaiykkbn(C_HjndaiykKbn.BLNK);
                if (!C_UmuKbn.ARI.eq(tsinyNoValidateErrUmu)) {
                    bosKihonIns.setTsinyno(tsinyNo);
                }
                if (!C_UmuKbn.ARI.eq(tsinadr1KjValidateErrUmu) && !C_UmuKbn.ARI.eq(tsinadr2KjValidateErrUmu)
                    && !C_UmuKbn.ARI.eq(tsinadr3KjValidateErrUmu)) {
                    bosKihonIns.setTsinadr1kj(adr1);
                    bosKihonIns.setTsinadr2kj(adr2);
                    bosKihonIns.setTsinadr3kj(adr3);
                }
                if (!C_UmuKbn.ARI.eq(tsinTelnoValidateErrUmu)) {
                    bosKihonIns.setTsintelno(kyktelno);
                }
                bosKihonIns.setFatcasnsikbn(C_FatcasnsiKbn.BLNK);
                bosKihonIns.setBikkjnssinfokbn(C_BikkjnssinfoKbn.BLNK);
                bosKihonIns.setAeoisnsikbn(C_AeoisnsiKbn.BLNK);
                bosKihonIns.setHknsyuruino(hknsyuruino);
                bosKihonIns.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.BLNK);
                bosKihonIns.setLivhukaumu(C_Livhukaumu.BLNK);
                bosKihonIns.setPmnjtkhukakbn(C_PmnjtkhukaKbn.BLNK);
                bosKihonIns.setPmnjtkkbn(C_PmnjtkKbn.NONE);
                bosKihonIns.setKzktourokuservicetourokukbn(editSeihoWebRenkeiKoumoku.kzktourokumoskbnHenkan(
                    bosTrParam.getZtrseihowebkzktrkmoskbn()));

                C_Tkhukaumu kykdrtkykhukakbn = editSeihoWebRenkeiKoumoku.kykdrtkykhukakbnHenkan(bosTrParam
                    .getZtrseihowebdrtkkbn());
                if (C_Tkhukaumu.BLNK.eq(kykdrtkykhukakbn)) {

                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getKykdrtkykumu())) {
                        if (DRTKKANOUHYJ_HUKAKANO.equals(bosTrParam.getZtrseihowebkykdrtkkanouhyj())) {
                            if (KZKTRKMOSKBN_MITEI.equals(bosTrParam.getZtrseihowebkzktrkmoskbn())) {
                                bosKihonIns.setKykdrtkykhukakbn(C_Tkhukaumu.BLNK);
                            }
                            else {
                                bosKihonIns.setKykdrtkykhukakbn(C_Tkhukaumu.NONE);
                            }
                        }
                        else if (DRTKKANOUHYJ_NONE.equals(bosTrParam.getZtrseihowebkykdrtkkanouhyj())) {
                            bosKihonIns.setKykdrtkykhukakbn(C_Tkhukaumu.NONE);
                        }
                        else {
                            bosKihonIns.setKykdrtkykhukakbn(C_Tkhukaumu.BLNK);
                        }
                    }
                    else {
                        bosKihonIns.setKykdrtkykhukakbn(C_Tkhukaumu.BLNK);
                    }
                }
                else {
                    bosKihonIns.setKykdrtkykhukakbn(kykdrtkykhukakbn);
                }

                C_Tkhukaumu stdrsktkyhkkbn =editSeihoWebRenkeiKoumoku.hhkdrtkykhukakbnHenkan(
                    bosTrParam.getZtrseihowebdrtkkbn());
                if (C_Tkhukaumu.BLNK.eq(stdrsktkyhkkbn)) {

                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getStdrsktkumu())) {
                        if (DRTKKANOUHYJ_HUKAKANO.equals(bosTrParam.getZtrseihowebhhkndrtkkanouhyj())) {
                            if (KZKTRKMOSKBN_MITEI.equals(bosTrParam.getZtrseihowebkzktrkmoskbn())) {
                                bosKihonIns.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
                            }
                            else {
                                bosKihonIns.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
                            }
                        }
                        else if (DRTKKANOUHYJ_NONE.equals(bosTrParam.getZtrseihowebhhkndrtkkanouhyj())) {
                            bosKihonIns.setStdrsktkyhkkbn(C_Tkhukaumu.NONE);
                        }
                        else {
                            bosKihonIns.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
                        }
                    }
                    else {
                        bosKihonIns.setStdrsktkyhkkbn(C_Tkhukaumu.BLNK);
                    }
                }
                else {
                    bosKihonIns.setStdrsktkyhkkbn(stdrsktkyhkkbn);
                }

                bosKihonIns.setSdpdkbn(C_Sdpd.valueOf(bosTrParam.getZtrseihowebsdpdkbn()));
                bosKihonIns.setSntkhoukbn(editSeihoWebRenkeiKoumoku
                    .sntkhoukbnHenkan(bosTrParam.getZtrseihowebhjkktkbn()));
                bosKihonIns.setHaitoukbn(C_HaitouKbn.BLNK);
                bosKihonIns.setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.BLNK);
                bosKihonIns.setKyktuukasyu(editSeihoWebRenkeiKoumoku.tuukasyuHenkan(bosTrParam
                    .getZtrseihowebsiteituukakbn()));
                bosKihonIns.setHrktuukasyu(editSeihoWebRenkeiKoumoku.tuukasyuHenkan(bosTrParam
                    .getZtrseihowebnykntuukakbn()));
                bosKihonIns.setYennykntkhkkbn(editSeihoWebRenkeiKoumoku.yennykntkhkkbnSyutoku(
                    bosTrParam.getZtrseihowebsiteituukakbn(),
                    bosTrParam.getZtrseihowebnykntuukakbn()));
                bosKihonIns.setGaikanykntkhkkbn(editSeihoWebRenkeiKoumoku.gaikanykntkhkkbnSyutoku(
                    bosTrParam.getZtrseihowebsiteituukakbn(),
                    bosTrParam.getZtrseihowebnykntuukakbn()));
                bosKihonIns.setYenshrtkhkkbn(C_Tkhukaumu.BLNK);
                if (!C_UmuKbn.ARI.eq(mossyukykpValidateErrUmu)) {
                    bosKihonIns.setMosheijyunp(editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
                        bosTrParam.getZtrseihowebhrkkaisuukbn(),
                        mosTuukasyukbn,
                        hrktuukasyutkP,
                        gkHrktuukasyutkP));
                }
                bosKihonIns.setIkkatubaraikbn(editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikbn(
                    bosTrParam.getZtrseihowebikkatubaraikbn()));
                bosKihonIns.setIkkatubaraikaisuu(editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(
                    Strings.padStart(String.valueOf(bosTrParam.getZtrseihowebiktbrikaisuu()), 2, '0')));
                if (!C_UmuKbn.ARI.eq(mosikkatupValidateErrUmu)) {
                    bosKihonIns.setMosikkatup(editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
                        bosTrParam.getZtrseihowebnykntuukakbn(), bosTrParam.getZtrseihowebikkatup(), Long.valueOf(0)));
                }
                bosKihonIns.setHrkkaisuu(editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(bosTrParam
                    .getZtrseihowebhrkkaisuukbn()));
                bosKihonIns.setHrkkeiro(editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(hrkkeirokbn));
                bosKihonIns.setFstphrkkeirokbn(editSeihoWebRenkeiKoumoku.fstphrkkeiroHenkan(
                    bosTrParam.getZtrseihowebhrkkaisuukbn(),
                    hrkkeirokbn,
                    bosTrParam.getZtrseihowebtkiyougyoutaikbn()
                    ));
                bosKihonIns.setZennoumousideumu(editSeihoWebRenkeiKoumoku.huho2GetZennoumousideumu(
                    bosTrParam.getZtrseihowebzennouhyj()));
                bosKihonIns.setZenkizennouumu(editSeihoWebRenkeiKoumoku.huho2GetZenkizennouumu(
                    syouhnZokusei.getZenkizennoutekiumu(), bosTrParam.getZtrseihowebzennouhyj()));
                if (!C_UmuKbn.ARI.eq(znnkaiValidateErrUmu)) {
                    bosKihonIns.setZnnkai(editSeihoWebRenkeiKoumoku.huho2GetZnnkai(bosTrParam.getZtrseihowebzennoukkn()));
                }
                if (!C_UmuKbn.ARI.eq(moszennoupsyokaiariValidateErrUmu)) {
                    bosKihonIns.setMoszennoupsyokaiari(editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
                        mosTuukasyukbn, bosTrParam.getZtrseihowebzennoup(), bosTrParam.getZtrseihowebgaikazennoup()));
                }
                bosKihonIns.setTargettkhkkbn(editSeihoWebRenkeiKoumoku
                    .targettkhkkbnSyutoku(bosTrParam.getZtrseihowebtargettkarihyj()));
                bosKihonIns.setTargettkkbn(editSeihoWebRenkeiKoumoku
                    .targettkkbnSyutoku(bosTrParam.getZtrseihowebtargettkkbn()));

                if (0 != bosTrParam.getZtrseihowebtargettkmkht()) {
                    bosKihonIns.setTargettkmkhtkbn(editSeihoWebRenkeiKoumoku
                        .targettkmkhtkbnSyutoku(bosTrParam.getZtrseihowebtargettkmkht()));
                }
                else if ("1".equals(bosTrParam.getZtrseihowebtargettkarihyj())
                    && ("1".equals(bosTrParam.getZtrseihowebtargettkkbn()) || "2".equals(bosTrParam
                        .getZtrseihowebtargettkkbn()))) {
                    bosKihonIns.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.NOTARGET);
                }
                else {
                    bosKihonIns.setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn.BLNK);
                }

                bosKihonIns.setNstkhkkbn(editSeihoWebRenkeiKoumoku.nstkhkkbnSyutoku(bosTrParam
                    .getZtrseihowebnkshrarihyj()));

                if ("1".equals(bosTrParam.getZtrseihowebnkshrarihyj())) {
                    bosKihonIns.setNstksbnsyu(C_Nstknsyu.KAKUTEINENKIN);
                }

                bosKihonIns.setSyksbyensitihsyutkhkkbn(editSeihoWebRenkeiKoumoku.syksbYensitiHsyuTkhkKbn(
                    bosTrParam.getZtrseihowebyenhsyutkarihyj(), hknsyuruino));

                C_Tkhukaumu jyudKaigomeHrtkhkKbn = C_Tkhukaumu.BLNK;

                C_Tkhukaumu tkjukaUmuHantei2 = editSeihoWebRenkeiKoumoku.jyudKaigoMehrTkhkKbn(bosTrParam.getZtrseihowebkaigmehrtkarihyj());

                if (C_Tkhukaumu.BLNK.eq(tkjukaUmuHantei2)) {

                    if (C_UmuKbn.ARI.eq(syouhnZokusei.getJyudkaigomehrtktekiumu())) {

                        jyudKaigomeHrtkhkKbn = C_Tkhukaumu.NONE;
                    }
                    else {

                        jyudKaigomeHrtkhkKbn = C_Tkhukaumu.BLNK;
                    }
                }
                else {

                    jyudKaigomeHrtkhkKbn = tkjukaUmuHantei2;
                }

                bosKihonIns.setJyudkaigomehrtkhkkbn(jyudKaigomeHrtkhkKbn);
                bosKihonIns.setKjnnkpzeitekitkhukakbn(editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
                    syouhnZokusei.getZeiseitekikakuumu(),
                    bosTrParam.getZtrseihowebtksykmcd1(),
                    bosTrParam.getZtrseihowebtksykmcd2(),
                    bosTrParam.getZtrseihowebtksykmcd3(),
                    bosTrParam.getZtrseihowebtksykmcd4(),
                    bosTrParam.getZtrseihowebtksykmcd5()));

                bosKihonIns.setTeikisiharaitkykhkkbn(editSeihoWebRenkeiKoumoku.teikisiharaitkykhkkbnSyutoku("0", hknsyuruino));

                if ("1".equals(sbuktnrkkbn) || "4".equals(sbuktnrkkbn)) {
                    bosKihonIns.setSbuktnin(1);
                }
                else {
                    bosKihonIns.setSbuktnin(0);
                }

                bosKihonIns.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.BLNK);
                bosKihonIns.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.BLNK);

                if ("E".equals(bosTrParam.getZtrseihowebtkiyougyoutaikbn())) {
                    if (BizDateUtil.compareYmd(BizDate.valueOf(bosTrParam.getZtrseihowebfstmossksymd()),
                        YuyuSinkeiyakuConfig.getInstance().getMizuhoDirectServiceKaisiYmd()) ==
                        BizDateUtil.COMPARE_GREATER ||
                        BizDateUtil.compareYmd(BizDate.valueOf(bosTrParam.getZtrseihowebfstmossksymd()),
                            YuyuSinkeiyakuConfig.getInstance().getMizuhoDirectServiceKaisiYmd()) ==
                            BizDateUtil.COMPARE_EQUAL) {
                        bosKihonIns.setDrctservicemoskbn(C_DirectServiceMosKbn.BLNK);
                    }
                    else{
                        bosKihonIns.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);
                    }
                }
                else {
                    bosKihonIns.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
                }

                bosKihonIns.setPplsrendoukouhurikousoukbn(C_PplessrendoukouhurikousouKbn.OTHER);
                bosKihonIns.setPplessrendoucreditkousoukbn(C_PplessrendoucreditkousouKbn.OTHER);
                bosKihonIns.setHnsstjmmouumukbn(C_UmuKbn.ARI);
                bosKihonIns.setKjmeigihkhunouumukbn(editSeihoWebRenkeiKoumoku.kjmeigihkhunouumukbnSyutoku(
                    bosTrParam.getZtrseihowebtksykmcd1(),
                    bosTrParam.getZtrseihowebtksykmcd2(),
                    bosTrParam.getZtrseihowebtksykmcd3(),
                    bosTrParam.getZtrseihowebtksykmcd4(),
                    bosTrParam.getZtrseihowebtksykmcd5()));
                bosKihonIns.setTsryhshrkykumukbn(editSeihoWebRenkeiKoumoku.tsryhshrkykumukbnSyutoku(
                    bosTrParam.getZtrseihowebtksykmcd1(),
                    bosTrParam.getZtrseihowebtksykmcd2(),
                    bosTrParam.getZtrseihowebtksykmcd3(),
                    bosTrParam.getZtrseihowebtksykmcd4(),
                    bosTrParam.getZtrseihowebtksykmcd5()));
                bosKihonIns.setSyosisyatodokeumukbn(editSeihoWebRenkeiKoumoku.syosisyatodokeumukbnSyutoku(
                    bosTrParam.getZtrseihowebtksykmcd1(),
                    bosTrParam.getZtrseihowebtksykmcd2(),
                    bosTrParam.getZtrseihowebtksykmcd3(),
                    bosTrParam.getZtrseihowebtksykmcd4(),
                    bosTrParam.getZtrseihowebtksykmcd5()));
                bosKihonIns.setKakukisyouryakukbumukbn(editSeihoWebRenkeiKoumoku.kakukisyouryakukbumukbnSyutoku(
                    bosTrParam.getZtrseihowebtksykmcd1(),
                    bosTrParam.getZtrseihowebtksykmcd2(),
                    bosTrParam.getZtrseihowebtksykmcd3(),
                    bosTrParam.getZtrseihowebtksykmcd4(),
                    bosTrParam.getZtrseihowebtksykmcd5()));
                bosKihonIns.setSeiymdmosseitouumukbn(editSeihoWebRenkeiKoumoku.seiymdmosseitouumukbnSyutoku(
                    bosTrParam.getZtrseihowebtksykmcd1(),
                    bosTrParam.getZtrseihowebtksykmcd2(),
                    bosTrParam.getZtrseihowebtksykmcd3(),
                    bosTrParam.getZtrseihowebtksykmcd4(),
                    bosTrParam.getZtrseihowebtksykmcd5()));
                bosKihonIns.setIkokakninsyotokkijkumu(C_UmuKbn.NONE);
                bosKihonIns.setTrtkhoukokusyotokkijkumu(C_UmuKbn.NONE);
                bosKihonIns.setHnnkakninhskjikouumukbn(C_UmuKbn.NONE);
                bosKihonIns.setHnnkakninhsktkjikouumukbn(C_UmuKbn.NONE);
                bosKihonIns.setSkskakninhsktkjikouumukbn(C_UmuKbn.NONE);
                bosKihonIns.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);
                bosKihonIns.setPplessdatasousinumukbn(C_UmuKbn.NONE);
                bosKihonIns.setMobilebosyuukbn(C_MobilebosyuuKbn.BLNK);
                bosKihonIns.setTeirituhaibunwarikbn(editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(
                    bosTrParam.getZtrseihowebtrtrndhbnwr(),
                    syouhnZokusei.getTmttknhaibunwarisiteiumu()));
                bosKihonIns.setSisuukbn(syouhnZokusei.getSisuukbn());
                bosKihonIns.setSisuuhaibunwarikbn(editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(
                    bosTrParam.getZtrseihowebssrndhbnwr(),
                    syouhnZokusei.getTmttknhaibunwarisiteiumu()));
                bosKihonIns.setTrhkjikakkbn(C_TrhkjiKakKbn.BLNK);
                bosKihonIns.setKoureitaioukbn(C_KoureisyaTaiouKbn.BLNK);

                bosKihonIns.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                bosKihonIns.setGyoumuKousinTime(pGyoumuKousinTime);

                if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
                    if (!C_UmuKbn.ARI.eq(tsinadr1KjValidateErrUmu) && !C_UmuKbn.ARI.eq(tsinadr2KjValidateErrUmu)
                        && !C_UmuKbn.ARI.eq(tsinadr3KjValidateErrUmu)) {
                        bosKihonIns.setHhknadr1kj(adr1);
                        bosKihonIns.setHhknadr2kj(adr2);
                        bosKihonIns.setHhknadr3kj(adr3);
                    }
                }
                else {
                    if (!C_UmuKbn.ARI.eq(hhknadr1KjValidateErrUmu) && !C_UmuKbn.ARI.eq(hhknadr2KjValidateErrUmu)
                        && !C_UmuKbn.ARI.eq(hhknadr3KjValidateErrUmu)) {
                        bosKihonIns.setHhknadr1kj(hhknadr1);
                        bosKihonIns.setHhknadr2kj(hhknadr2);
                        bosKihonIns.setHhknadr3kj(hhknadr3);
                    }
                    bosKihonIns.setKyksei(
                        editSeihoWebRenkeiKoumoku.kykseiHenkan(bosTrParam.getZtrseihowebkyksyaseikbn()));
                    bosKihonIns.setKyktdk(
                        editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(bosTrParam.getZtrseihowebhnsyukyktdkkbn()));

                }

                BizPropertyInitializer.initialize(bosKihonIns);

                if (!"0".equals(sbuktnrkkbn)
                    || !BizUtil.isBlank(sbuktknnm)
                    || !BizUtil.isBlank(sbuktkjnm)
                    || !"0".equals(sbukttdkkbn)
                    || !"0".equals(sbuktseiymd)) {

                    HT_BosUketorinin bosUketorinin = bosKihonIns.createBosUketorinin();

                    bosUketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);
                    bosUketorinin.setUktsyurenno(UKTSYURENNOSB);
                    if ("2".equals(sbuktnrkkbn)) {
                        bosUketorinin.setUktkbn(C_UktKbn.BLNK);
                    }
                    else {
                        bosUketorinin.setUktkbn(editSeihoWebRenkeiKoumoku.uktkbnHenkan(
                            sbuktnrkkbn,
                            sbukttdkkbn,
                            sbuktknnm));
                    }
                    if (!C_UmuKbn.ARI.eq(sbUktnmKn1ValidateErrUmu)) {
                        if ("1".equals(sbuktnrkkbn) || "2".equals(sbuktnrkkbn)) {
                        }
                        else {
                            bosUketorinin.setUktnmkn(editSeihoWebRenkeiKoumoku.uktknnmSyutoku(
                                sbuktnrkkbn,
                                sbukttdkkbn,
                                sbuktknnm));
                        }
                    }
                    if (!C_UmuKbn.ARI.eq(sbUktnmKj1ValidateErrUmu)) {
                        if ("1".equals(sbuktnrkkbn) || "2".equals(sbuktnrkkbn)) {
                        }
                        else {
                            bosUketorinin.setUktnmkj(editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(
                                sbuktnrkkbn,
                                sbukttdkkbn,
                                sbuktkjnm));
                        }
                    }
                    bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

                    if ("2".equals(sbuktnrkkbn)){
                        bosUketorinin.setUkttdk(C_Tdk.BLNK);
                    }
                    else {
                        bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.ukttdkSyutoku(
                            sbuktnrkkbn,
                            sbukttdkkbn));
                    }

                    if (!C_UmuKbn.ARI.eq(sbUktseiYmd1ValidateErrUmu)) {
                        if ("1".equals(sbuktnrkkbn) || "2".equals(sbuktnrkkbn)) {
                        }
                        else {
                            String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(
                                sbuktnrkkbn,
                                sbukttdkkbn,
                                sbuktseiymd);

                            if (!BizUtil.isBlank(ktseiymd)) {
                                bosUketorinin.setUktseiymd(BizDate.valueOf(ktseiymd));
                            }

                        }
                    }

                    bosUketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    bosUketorinin.setGyoumuKousinTime(pGyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosUketorinin);
                }

                if ("1".equals(bosTrParam.getZtrseihowebhhkndrtkkanouhyj())) {

                    if ("1".equals(bosTrParam.getZtrseihowebdrtkkbn()) ||
                        "3".equals(bosTrParam.getZtrseihowebdrtkkbn())) {

                        HT_BosUketorinin bosUketorinin = bosKihonIns.createBosUketorinin();

                        bosUketorinin.setUktsyukbn(C_UktsyuKbn.STDRSK);
                        bosUketorinin.setUktsyurenno(UKTSYURENNOHH);
                        bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                        bosUketorinin.setUktbnwari(BizNumber.valueOf(100));
                        bosUketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        bosUketorinin.setGyoumuKousinTime(pGyoumuKousinTime);

                        if ("1".equals(bosTrParam.getZtrseihowebhhkndrnrkkbn())) {

                            bosUketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU1);
                            bosUketorinin.setUkttdk(C_Tdk.BLNK);

                        }
                        else if ("2".equals(bosTrParam.getZtrseihowebhhkndrnrkkbn())) {

                            bosUketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);
                            bosUketorinin.setUkttdk(C_Tdk.BLNK);

                        }
                        else if ("3".equals(bosTrParam.getZtrseihowebhhkndrnrkkbn())) {

                            bosUketorinin.setUktkbn(C_UktKbn.KYK);
                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }
                        else if ("4".equals(bosTrParam.getZtrseihowebhhkndrnrkkbn())) {

                            bosUketorinin.setUktkbn(C_UktKbn.SBUK);
                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }
                        else if ("5".equals(bosTrParam.getZtrseihowebhhkndrnrkkbn())) {
                            if("0".equals(bosTrParam.getZtrseihowebhhkndrtdkkbn())) {

                                bosUketorinin.setUktkbn(C_UktKbn.KYK);

                                bosUketorinin.setUkttdk(C_Tdk.BLNK);
                            }

                            else if("7".equals(bosTrParam.getZtrseihowebhhkndrtdkkbn())) {

                                bosUketorinin.setUktkbn(C_UktKbn.SBUK);

                                bosUketorinin.setUkttdk(C_Tdk.BLNK);
                            }

                            else {
                                bosUketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                                bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(
                                    bosTrParam.getZtrseihowebhhkndrtdkkbn()));

                                if (!C_UmuKbn.ARI.eq(hhkdrnmknValidateErrUmu)) {

                                    bosUketorinin.setUktnmkn(bosTrParam.getZtrseihowebhhkndrknnm());
                                }

                                if (!C_UmuKbn.ARI.eq(hhkdrnmkjValidateErrUmu)) {

                                    bosUketorinin.setUktnmkj(hhkndrkjnm);
                                }

                                if (!C_UmuKbn.ARI.eq(hhkdrseiymdValidateErrUmu)) {

                                    if (!INITYMD.equals(bosTrParam.getZtrseihowebhhkndrseiymd())) {

                                        bosUketorinin.setUktseiymd(
                                            BizDate.valueOf(bosTrParam.getZtrseihowebhhkndrseiymd()));
                                    }
                                }
                            }
                        }
                        BizPropertyInitializer.initialize(bosUketorinin);
                    }
                }

                if (!"0".equals(bosTrParam.getZtrseihowebmnkuktnrkkbn())
                    || !"0".equals(bosTrParam.getZtrseihowebmnkukttdkkbn())
                    || !BizUtil.isBlank(bosTrParam.getZtrseihowebmnkuktknnm())
                    || !BizUtil.isBlank(mkuktkjnm)
                    || !"0".equals(bosTrParam.getZtrseihowebmnkuktseiymd())) {

                    HT_BosUketorinin bosUketorinin = bosKihonIns.createBosUketorinin();

                    bosUketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);
                    bosUketorinin.setUktsyurenno(UKTSYURENNONK);

                    bosUketorinin.setUktkbn(editSeihoWebRenkeiKoumoku.uktkbnHenkan(
                        bosTrParam.getZtrseihowebmnkuktnrkkbn(),
                        bosTrParam.getZtrseihowebmnkukttdkkbn(),
                        bosTrParam.getZtrseihowebmnkuktknnm()));

                    if (!C_UmuKbn.ARI.eq(nenkinUktnmKanaValidateErrUmu)) {

                        bosUketorinin.setUktnmkn(editSeihoWebRenkeiKoumoku.uktknnmSyutoku(
                            bosTrParam.getZtrseihowebmnkuktnrkkbn(),
                            bosTrParam.getZtrseihowebmnkukttdkkbn(),
                            bosTrParam.getZtrseihowebmnkuktknnm()));
                    }

                    if (!C_UmuKbn.ARI.eq(nenkinUktnmKanjiValidateErrUmu)) {

                        bosUketorinin.setUktnmkj(editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(
                            bosTrParam.getZtrseihowebmnkuktnrkkbn(),
                            bosTrParam.getZtrseihowebmnkukttdkkbn(),
                            mkuktkjnm));
                    }

                    bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

                    bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.ukttdkSyutoku(
                        bosTrParam.getZtrseihowebmnkuktnrkkbn(),
                        bosTrParam.getZtrseihowebmnkukttdkkbn()));

                    if (!C_UmuKbn.ARI.eq(nenkinUktSeiymdValidateErrUmu)) {

                        String ktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(
                            bosTrParam.getZtrseihowebmnkuktnrkkbn(),
                            bosTrParam.getZtrseihowebmnkukttdkkbn(),
                            bosTrParam.getZtrseihowebmnkuktseiymd());

                        if (!BizUtil.isBlank(ktseiymd)) {
                            bosUketorinin.setUktseiymd(BizDate.valueOf(ktseiymd));
                        }
                    }

                    bosUketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    bosUketorinin.setGyoumuKousinTime(pGyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosUketorinin);
                }

                if ("1".equals(bosTrParam.getZtrseihowebkykdrtkkanouhyj())) {

                    if ("1".equals(bosTrParam.getZtrseihowebdrtkkbn()) ||
                        "2".equals(bosTrParam.getZtrseihowebdrtkkbn())) {

                        HT_BosUketorinin bosUketorinin = bosKihonIns.createBosUketorinin();

                        bosUketorinin.setUktsyukbn(C_UktsyuKbn.KYKDRN);
                        bosUketorinin.setUktsyurenno(UKTSYURENNOKK);
                        bosUketorinin.setUktkbn(editSeihoWebRenkeiKoumoku.kykdruktkbnHenkan(
                            bosTrParam.getZtrseihowebkykdrnrkkbn()));
                        bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
                        bosUketorinin.setUktbnwari(BizNumber.valueOf(100));
                        bosUketorinin.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        bosUketorinin.setGyoumuKousinTime(pGyoumuKousinTime);

                        BizPropertyInitializer.initialize(bosUketorinin);
                    }
                }

                HT_BosSyouhn bosSyouhn = bosKihonIns.createBosSyouhn();

                bosSyouhn.setSyouhncd(syouhnZokusei.getSyouhncd());
                bosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
                bosSyouhn.setSknenkinsyu(sknenkinsyu);
                if (C_UmuKbn.NONE.eq(syouhnZokusei.getHokenkngkyakujyouumu())) {
                    HenkanTuuka HhenkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    bosSyouhn.setKihons(BizCurrency.valueOf(0,
                        HhenkanTuuka.henkanTuukaKbnToType(bosKihonIns.getKyktuukasyu())));
                }
                else {
                    if (!C_UmuKbn.ARI.eq(syuKihonKingakuValidateErrUmu)) {
                        bosSyouhn.setKihons(kihons);
                    }
                }
                if (!C_UmuKbn.ARI.eq(mossyukykpValidateErrUmu)) {
                    bosSyouhn.setHrktuukasyutkp(mossyukykP);
                }
                bosSyouhn.setKatakbn(C_KataKbn.BLNK);
                bosSyouhn.setKyhkatakbn(C_KyhgndkataKbn.BLNK);
                bosSyouhn.setSyukyhkinkatakbn(C_SyukyhkinkataKbn.BLNK);
                bosSyouhn.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.BLNK);
                bosSyouhn.setRokudaildkbn(C_6daiLdKbn.BLNK);
                if (!C_UmuKbn.ARI.eq(hknKknValidateErrUmu)) {
                    bosSyouhn.setHknkkn(hknkkn);
                }
                if (!C_UmuKbn.ARI.eq(hrkKknValidateErrUmu)) {
                    bosSyouhn.setHrkkkn(bosTrParam.getZtrseihowebphrkkikn());
                }

                bosSyouhn.setHknkknsmnkbn(
                    C_HknkknsmnKbn.valueOf(editSeihoWebRendouKoumoku(mosno, "保険期間歳満期区分 ",
                        bosTrParam.getZtrseihowebsaimankihyj(), C_HknkknsmnKbn.class)));

                bosSyouhn.setHrkkknsmnkbn(editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(hknsyuruino, bosTrParam
                    .getZtrseihowebphrkkikn()));

                if (!C_UmuKbn.ARI.eq(syudai1HknkknValidateErrUmu)) {
                    bosSyouhn.setDai1hknkkn(bosTrParam.getZtrseihowebdai1hknkkn());
                }

                bosSyouhn.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                bosSyouhn.setGyoumuKousinTime(pGyoumuKousinTime);

                BizPropertyInitializer.initialize(bosSyouhn);

                HT_BosDairiten bosDairiten = bosKihonIns.createBosDairiten();

                bosDairiten.setRenno(RENNO);
                bosDairiten.setDrtensykbn(C_DrtensyKbn.BLNK);
                if (!C_UmuKbn.ARI.eq(dairitenKinyuukikanCd1ValidateErrUmu)) {
                    bosDairiten.setKinyuucd(dairitenkinyuukikancd1);
                }
                if (!C_UmuKbn.ARI.eq(dairitenKinyuukikanSitencd1ValidateErrUmu)) {
                    if ("6".equals(bosTrParam.getZtrseihowebtkiyougyoutaikbn())) {
                    }
                    else {
                        bosDairiten.setKinyuusitencd(dairitenkinyuukikansitencd1);
                    }
                }
                if (!C_UmuKbn.ARI.eq(drtenjimcd1ValidateErrUmu)) {
                    if ("6".equals(bosTrParam.getZtrseihowebtkiyougyoutaikbn())) {
                    }
                    else {
                        bosDairiten.setJimusyocd(drtenjimcd1);
                    }
                }
                if (!C_UmuKbn.ARI.eq(bosyuuninTourokuNo1ValidateErrUmu)) {
                    if ("6".equals(bosTrParam.getZtrseihowebtkiyougyoutaikbn())) {
                    }
                    else {
                        bosDairiten.setBosyuutrkno(bosTrParam.getZtrseihowebbsyutrkno());
                    }
                }
                if (!C_UmuKbn.ARI.eq(cifCdValidateErrUmu)) {
                    if ("E".equals(bosTrParam.getZtrseihowebtkiyougyoutaikbn())) {
                        bosDairiten.setCifcd(bosTrParam.getZtrseihowebankenkanrino());
                    }
                }
                bosDairiten.setYuuseikbn(C_YuuseiKbn.BLNK);

                bosDairiten.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                bosDairiten.setGyoumuKousinTime(pGyoumuKousinTime);

                BizPropertyInitializer.initialize(bosDairiten);

                if (!BizUtil.isBlank(bosTrParam.getZtrseihowebkydbosyuukjncd())) {
                    HT_BosDairiten bosDairiten1 = bosKihonIns.createBosDairiten();

                    bosDairiten1.setRenno(RENNO + 1);
                    bosDairiten1.setDrtensykbn(C_DrtensyKbn.BLNK);

                    if(!C_UmuKbn.ARI.eq(inputbosyuuCd2ValidateErrUmu)){

                        bosDairiten1.setInputbosyuucd(bosTrParam.getZtrseihowebkydbosyuukjncd());
                    }
                    bosDairiten1.setYuuseikbn(C_YuuseiKbn.BLNK);

                    bosDairiten1.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    bosDairiten1.setGyoumuKousinTime(pGyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosDairiten1);
                }
                if ("1".equals(bosTrParam.getZtrseihowebkzktrkmoskbn())) {

                    HT_BosTrkKzk bosTrkKzk = bosKihonIns.createBosTrkKzk();

                    bosTrkKzk.setTrkkzkkbn(C_TrkKzkKbn.TRKKZK1);
                    if (!C_UmuKbn.ARI.eq(trkkzknmkn1ValidateErrUmu)) {

                        bosTrkKzk.setTrkkzknmkn(bosTrParam.getZtrseihowebkzkknnm1());
                    }
                    if (!C_UmuKbn.ARI.eq(trkkzknmkj1ValidateErrUmu)) {

                        bosTrkKzk.setTrkkzknmkj(kzkkjnm1);
                    }
                    bosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.BLNK);

                    if (!C_UmuKbn.ARI.eq(trkkzkseiymd1ValidateErrUmu)) {
                        if (!INITYMD.equals(bosTrParam.getZtrseihowebkzkseiymd1())) {

                            bosTrkKzk.setTrkkzkseiymd(BizDate.valueOf(bosTrParam.getZtrseihowebkzkseiymd1()));
                        }
                    }

                    bosTrkKzk.setTrkkzksei(editSeihoWebRenkeiKoumoku.kzkSeibetuHenkan(
                        bosTrParam.getZtrseihowebkzkseikbn1()));
                    bosTrkKzk.setTrkkzktdk(editSeihoWebRenkeiKoumoku.kzktdkkbnHenkan(
                        bosTrParam.getZtrseihowebkzktdkkbn1()));
                    bosTrkKzk.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.BLNK);

                    if (!C_UmuKbn.ARI.eq(trkkzkyno1ValidateErrUmu)) {

                        bosTrkKzk.setTrkkzkyno(editSeihoWebRenkeiKoumoku.postalCdSyutoku(
                            bosTrParam.getZtrseihowebkzkyno1()));
                    }

                    if (!C_UmuKbn.ARI.eq(trkkzkadr1kj1ValidateErrUmu) &&
                        !C_UmuKbn.ARI.eq(trkkzkadr2kj1ValidateErrUmu) &&
                        !C_UmuKbn.ARI.eq(trkkzkadr3kj1ValidateErrUmu)) {

                        bosTrkKzk.setTrkkzkadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(kzkadr1));
                        bosTrkKzk.setTrkkzkadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(kzkadr1));
                        bosTrkKzk.setTrkkzkadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(kzkadr1));
                    }

                    if (!C_UmuKbn.ARI.eq(trkkzktelno1ValidateErrUmu)) {

                        bosTrkKzk.setTrkkzktelno(bosTrParam.getZtrseihowebkzktelno1());
                    }

                    bosTrkKzk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    bosTrkKzk.setGyoumuKousinTime(pGyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosTrkKzk);

                }

                pMultipleEntityInserter.add(bosKihonIns);

                syoriOKKensuu++;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(syoriOKKensuu), "募集情報取込ＯＫ"));

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(syoriNGKensuu), "募集情報取込ＮＧ"));

        }
    }

    private String editSeihoWebRendouKoumoku(String pMosno, String pKbnname, String pBefore, Class<?> pClazz) {

        String kbnData = "";

        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(pBefore, pClazz, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        if (!kbnInfoBean.isHenkanFlg()) {

            throw new CommonBizAppException("申込番号=" + pMosno + "他システム連動用区分値変換に失敗しました。"
                + "区分名：" + pKbnname + "　　区分値：" + pBefore);
        }

        kbnData = kbnInfoBean.getKbnData();
        return kbnData;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
