package yuyu.batch.sinkeiyaku.skmousikomi.skpaperlessmousikomitorikomi;

import java.math.BigDecimal;
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
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skmousikomi.skpaperlessmousikomitorikomi.dba.SkPaperlessMousikomiTorikomiDao;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.bzcommon.ReplaceSkjResultBean;
import yuyu.common.biz.bzcommon.SkjStringUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.EditSeihoWebRenkeiKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SmbcPaperlessMosTrParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykymdtkrumu;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkkijiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_MobilebosyuuKbn;
import yuyu.def.classification.C_MosTourokuJyoukyouKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_PmnjtkhukaKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HT_BosDairiten;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.entity.HT_BosKokutisyo;
import yuyu.def.db.entity.HT_BosKoumokuCheckError;
import yuyu.def.db.entity.HT_BosKouzaJyouhou;
import yuyu.def.db.entity.HT_BosSyouhn;
import yuyu.def.db.entity.HT_BosTrkKzk;
import yuyu.def.db.entity.HT_BosUketoriKouzaJyouhou;
import yuyu.def.db.entity.HT_BosUketorinin;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos2Tr;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos1Tr;
import yuyu.def.db.entity.ZT_SmbcPaperlessMos2Tr;
import yuyu.def.db.mapping.GenHT_BosKihon;
import yuyu.def.sinkeiyaku.configuration.SkSeihoWebBosKoumokuCheckBean;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 申込入力 ペーパーレス申込情報取込
 */
public class SkPaperlessMousikomiTorikomiBatch implements Batch {

    private final String TABLEID1 = "ZT_SmbcPaperlessMos1Tr";

    private final String TABLEID2 = "ZT_SmbcPaperlessMos2Tr";

    private final String TABLEID3 = "ZT_HanyouPaperlessMos1Tr";

    private final String TABLEID4 = "ZT_HanyouPaperlessMos2Tr";

    private final String FILTERID = "Sk006";

    private final String MOSYMD = "mosymd";

    private final String SEKNO = "sekno";

    private final String MOSSAKUSEIYMD = "mossakuseiymd";

    private final String PPLESSMOSUKEYMD = "pplessmosukeymd";

    private final String PYKKIGENYMD = "pykkigenymd";

    private final String MOSCALCKIJYUNYMD = "moscalckijyunymd";

    private final String KYKNMKN = "kyknmkn";

    private final String KYKNMKJ = "kyknmkj";

    private final String KYKSEIYMD = "kykseiymd";

    private final String KYKKINMUSAKINM = "kykkinmusakinm";

    private final String TSINYNO = "tsinyno";

    private final String TSINADR1KJ = "tsinadr1kj";

    private final String TSINADR2KJ = "tsinadr2kj";

    private final String TSINADR3KJ = "tsinadr3kj";

    private final String TSINTELNO = "tsintelno";

    private final String HHKNNMKN = "hhknnmkn";

    private final String HHKNNMKJ = "hhknnmkj";

    private final String HHKNSEIYMD = "hhknseiymd";

    private final String KKTYMD = "kktymd";

    private final String HHKNSYKGYCD = "hhknsykgycd";

    private final String HHKNYNO = "hhknyno";

    private final String HHKNADR1KJ = "hhknadr1kj";

    private final String HHKNADR2KJ = "hhknadr2kj";

    private final String HHKNADR3KJ = "hhknadr3kj";

    private final String HHKNTELNO = "hhkntelno";

    private final String HHKNKINMUSAKINM = "hhknkinmusakinm";

    private final String SYUKIHONS = "syukihons";

    private final String MOSSYUKYKP = "mossyukykp";

    private final String NSTKSBNKKN = "nstksbnkkn";

    private final String SBUKTNIN = "sbuktnin";

    private final String SBUKTNMKN1 = "sbuktnmkn1";

    private final String SBUKTNMKJ1 = "sbuktnmkj1";

    private final String SBUKTSEIYMD1 = "sbuktseiymd1";

    private final String SBUKTBNWARI1 = "sbuktbnwari1";

    private final String SBUKTNMKN2 = "sbuktnmkn2";

    private final String SBUKTNMKJ2 = "sbuktnmkj2";

    private final String SBUKTSEIYMD2 = "sbuktseiymd2";

    private final String SBUKTBNWARI2 = "sbuktbnwari2";

    private final String SBUKTNMKN3 = "sbuktnmkn3";

    private final String SBUKTNMKJ3 = "sbuktnmkj3";

    private final String SBUKTSEIYMD3 = "sbuktseiymd3";

    private final String SBUKTBNWARI3 = "sbuktbnwari3";

    private final String SBUKTNMKN4 = "sbuktnmkn4";

    private final String SBUKTNMKJ4 = "sbuktnmkj4";

    private final String SBUKTSEIYMD4 = "sbuktseiymd4";

    private final String SBUKTBNWARI4 = "sbuktbnwari4";

    private final String NENKINUKTNMKANA = "nenkinuktnmkana";

    private final String NENKINUKTNMKANJI = "nenkinuktnmkanji";

    private final String NENKINUKTSEIYMD = "nenkinuktseiymd";

    private final String HKNKKN = "hknkkn";

    private final String HRKKKN = "hrkkkn";

    private final String SYUDAI1HKNKKN = "syudai1hknkkn";

    private  final String ZNNKAI = "znnkai";

    private  final String MOSIKKATUP = "mosikkatup";

    private  final String MOSZENNOUPSYOKAIARI = "moszennoupsyokaiari";

    private  final String KOUHURIKOUZAINFOSITENCD = "kouhurikouzainfositencd";

    private  final String KOUHURIKOUZAINFOKOUZANO = "kouhurikouzainfokouzano";

    private final String CIFCD = "cifcd";

    private final String UKTKID = "uktkid";

    private final String BOSYUUNINTOUROKUNO1 = "bosyuunintourokuno1";

    private final String DAIRITENKINYUUKIKANCD1 = "dairitenkinyuukikancd1";

    private final String DAIRITENKINYUUKIKANSITENCD1 = "dairitenkinyuukikansitencd1";

    private final String INPUTBOSYUUCD2 = "inputbosyuucd2";

    private final String DSMAILADDRESS = "dsmailaddress";

    private final String DSBANKCD = "dsbankcd";

    private final String DSSITENCD = "dssitencd";

    private final String DSKOUZANO = "dskouzano";

    private final String DSKZMEIGINMKN = "dskzmeiginmkn";

    private final String SINTYOU = "sintyou";

    private final String TAIJYUU = "taijyuu";

    private final String TRKKZKNMKN1 = "trkkzknmkn1";

    private final String TRKKZKNMKJ1 = "trkkzknmkj1";

    private final String TRKKZKSEIYMD1 = "trkkzkseiymd1";

    private final String TRKKZKYNO1 = "trkkzkyno1";

    private final String TRKKZKADR1KJ1 = "trkkzkadr1kj1";

    private final String TRKKZKADR2KJ1 = "trkkzkadr2kj1";

    private final String TRKKZKADR3KJ1 = "trkkzkadr3kj1";

    private final String TRKKZKTELNO1 = "trkkzktelno1";

    private final String HHKDRNMKN = "hhkdrnmkn";

    private final String HHKDRNMKJ = "hhkdrnmkj";

    private final String HHKDRSEIYMD = "hhkdrseiymd";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SkPaperlessMousikomiTorikomiBatchParam skPaperlessMousikomiTorikomiBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkPaperlessMousikomiTorikomiDao skPaperlessMousikomiTorikomiDao;

    @Override
    public BatchParam getParam() {

        return skPaperlessMousikomiTorikomiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(skPaperlessMousikomiTorikomiBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), skPaperlessMousikomiTorikomiBatchParam.getIbKakutyoujobcd()));

        String torikomumotocd = skPaperlessMousikomiTorikomiBatchParam.getTorikomumotocd();

        String tableid = "";

        String filterid = FILTERID;

        String kakutyoujobcd = skPaperlessMousikomiTorikomiBatchParam.getIbKakutyoujobcd();

        Iterator<?> smbcPaperlessMosTrTblParamLst= null;

        if ("1".equals(torikomumotocd)) {

            tableid = TABLEID1;

            try(ExDBResults<ZT_SmbcPaperlessMos1Tr> smbcPaperlessMos1TrLst =
                zdbDomManager.getSmbcPaperlessMos1TrsByKakutyoujobcd(kakutyoujobcd);

                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
                MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater()) {

                smbcPaperlessMosTrTblParamLst = smbcPaperlessMos1TrLst.iterator();

                doSkPaperlessMousikomiTorikomi(
                    smbcPaperlessMosTrTblParamLst, multipleEntityInserter, multipleEntityUpdater, tableid, filterid, kakutyoujobcd);
            }
        }
        else if ("2".equals(torikomumotocd)) {

            tableid = TABLEID2;

            try(ExDBResults<ZT_SmbcPaperlessMos2Tr>  smbcPaperlessMos2TrLst =
                zdbDomManager.getSmbcPaperlessMos2TrsByKakutyoujobcd(kakutyoujobcd);

                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
                MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater()) {

                smbcPaperlessMosTrTblParamLst = smbcPaperlessMos2TrLst.iterator();

                doSkPaperlessMousikomiTorikomi(
                    smbcPaperlessMosTrTblParamLst, multipleEntityInserter, multipleEntityUpdater, tableid, filterid, kakutyoujobcd);
            }
        }
        else if ("3".equals(torikomumotocd)) {

            tableid = TABLEID3;

            try(ExDBResults<ZT_HanyouPaperlessMos1Tr>  hanyouPaperlessMos1TrLst =
                skPaperlessMousikomiTorikomiDao.getHanyouPaperlessMos1TrByKakutyoujobcd(kakutyoujobcd);

                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
                MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater()) {

                smbcPaperlessMosTrTblParamLst = hanyouPaperlessMos1TrLst.iterator();

                doSkPaperlessMousikomiTorikomi(
                    smbcPaperlessMosTrTblParamLst, multipleEntityInserter, multipleEntityUpdater, tableid,
                    filterid, kakutyoujobcd);
            }
        }
        else if ("4".equals(torikomumotocd)) {

            tableid = TABLEID4;

            try(ExDBResults<ZT_HanyouPaperlessMos2Tr>  hanyouPaperlessMos2TrLst =
                skPaperlessMousikomiTorikomiDao.getHanyouPaperlessMos2TrByKakutyoujobcd(kakutyoujobcd);

                MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();
                MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater()) {

                smbcPaperlessMosTrTblParamLst = hanyouPaperlessMos2TrLst.iterator();

                doSkPaperlessMousikomiTorikomi(
                    smbcPaperlessMosTrTblParamLst, multipleEntityInserter, multipleEntityUpdater, tableid,
                    filterid, kakutyoujobcd);
            }
        }
        else {

            throw new BizAppException(MessageId.EBF0010, "取込元コード");
        }
    }

    private void doSkPaperlessMousikomiTorikomi(Iterator<?> pSmbcPaperlessMosTrTblParamLst,
        MultipleEntityInserter pMultipleEntityInserter, MultipleEntityUpdater pMultipleEntityUpdater,
        String pTableid, String pFilterid, String pKakutyoujobcd) {

        long syoriOKKensuu = 0;

        long syoriNGKensuu = 0;

        long syoriKensuu = 0;

        EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku =
            SWAKInjector.getInstance(EditSeihoWebRenkeiKoumoku.class);

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = new HT_MosMikakuteiJyouhouKanri();

        String gyoumuKousinsyaId = baseUserInfo.getUserId();

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        while(pSmbcPaperlessMosTrTblParamLst.hasNext()) {

            syoriKensuu = syoriKensuu + 1;

            SmbcPaperlessMosTrParam ztSmbcPaperlessMosTrTblParam =
                (SmbcPaperlessMosTrParam)pSmbcPaperlessMosTrTblParamLst.next();

            BM_SyouhnZokusei syouhnZokusei = null;

            Integer uktsyurenno = 1;

            Integer bosDairitenrenno = 1;

            C_UmuKbn bosInfoUm = C_UmuKbn.NONE;

            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(pKakutyoujobcd);

            bzRecoveryDatasikibetuBean.setIbTableid(pTableid);

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(pFilterid);

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(ztSmbcPaperlessMosTrTblParam.getZtrseihowebidkbn());

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkojincd());

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebitijihozonhyouji());

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey4(
                String.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebseknoc()));

            String mosno =
                editSeihoWebRenkeiKoumoku.mosnoHensyuu(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplmosnoc());
            if (!MousikomiNoCheck.isValid(mosno)) {
                batchLogger.error(MessageUtil.getMessage(MessageId.EBF0147, "申込番号"));

                throw new CommonBizAppException("申込番号=" + mosno);
            }

            C_HknsyuruiNo hknsyuruino =
                editSeihoWebRenkeiKoumoku.huho2EditHknsyuruino(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhknsyuruinoc());

            List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
                sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruinoHyoujidate(
                    hknsyuruino, skPaperlessMousikomiTorikomiBatchParam.getSyoriYmd());

            if (skHokenSyuruiNoLst.size() == 0) {

                batchLogger.error(MessageUtil.getMessage(MessageId.EBS0005, "HM_SkHokenSyuruiNo", "保険種類番号",
                    hknsyuruino.getValue(), "表示日", skPaperlessMousikomiTorikomiBatchParam.getSyoriYmd().toString()));

                throw new CommonBizAppException("申込番号=" + mosno);
            }

            HT_BosKihon bosKihonUpd= sinkeiyakuDomManager.getBosKihon(mosno);

            if (null != bosKihonUpd) {

                if (C_UmuKbn.ARI.eq(bosKihonUpd.getPplessdatasousinumukbn())) {

                    syoriNGKensuu = syoriNGKensuu + 1;
                    continue;
                }

                bosInfoUm = C_UmuKbn.ARI;
            }

            mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(mosno);

            if (mosMikakuteiJyouhouKanri == null) {
                batchLogger.error(MessageUtil.getMessage(MessageId.EBS0004, "HT_MosMikakuteiJyouhouKanri", "申込番号",
                    mosno));
                throw new CommonBizAppException("申込番号=" + mosno);
            }

            C_Tuukasyu tuukasyu  = editSeihoWebRenkeiKoumoku.tuukasyuHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsiteituukakbn());

            C_UmuKbn umuKbn = C_UmuKbn.NONE;
            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebyenhsyutkarihyj())) {
                umuKbn = C_UmuKbn.ARI;
            }

            C_Sknenkinsyu skNenkinSyu = editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebnksyuruikbn());

            C_UmuKbn teikisiharaikinUmu = C_UmuKbn.NONE;

            String syouhinHantei = editSeihoWebRenkeiKoumoku.syouhnhantei(hknsyuruino);

            if ("1".equals(syouhinHantei)) {

                List<BM_SyouhnZokusei> syouhnZokuseiLst =
                    bizDomManager.getSyouhnZokuseisByHknsyuruinoItems(
                        skPaperlessMousikomiTorikomiBatchParam.getSyoriYmd(),
                        C_SyutkKbn.SYU,
                        skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino(),
                        0,
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebdai1hknkknc(),
                        tuukasyu,
                        umuKbn,
                        skNenkinSyu,
                        teikisiharaikinUmu);

                if (syouhnZokuseiLst.size() == 0) {
                    batchLogger.error(MessageUtil.getMessage(
                        MessageId.EBS1011,
                        "BM_SyouhnZokusei",
                        "表示日",
                        String.valueOf(skPaperlessMousikomiTorikomiBatchParam.getSyoriYmd()),
                        "主契約特約区分",
                        C_SyutkKbn.SYU.getValue(),
                        "保険種類番号",
                        skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino().toString(),
                        "年金原資最低保証率",
                        "0",
                        "第１保険期間",
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebdai1hknkknc().toString(),
                        "通貨種類",
                        tuukasyu.getValue(),
                        "初期死亡時円換算最低保証特約適用有無",
                        umuKbn.getValue(),
                        "新契約年金種類",
                        skNenkinSyu.getValue(),
                        "定期支払金有無",
                        teikisiharaikinUmu.getValue()));

                    throw new CommonBizAppException("申込番号=" + mosno);
                }

                syouhnZokusei = syouhnZokuseiLst.get(0);
            }
            else {

                List<BM_SyouhnZokusei> syouhnZokuseiLst =
                    bizDomManager.getSyouhnZokuseisByHknsyuruinoItems2(
                        skPaperlessMousikomiTorikomiBatchParam.getSyoriYmd(),
                        C_SyutkKbn.SYU,
                        skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino(),
                        0,
                        umuKbn,
                        skNenkinSyu,
                        teikisiharaikinUmu);

                if (syouhnZokuseiLst.size() == 0) {
                    batchLogger.error(MessageUtil.getMessage(
                        MessageId.EBS1009,
                        "BM_SyouhnZokusei",
                        "表示日",
                        String.valueOf(skPaperlessMousikomiTorikomiBatchParam.getSyoriYmd()),
                        "主契約特約区分",
                        C_SyutkKbn.SYU.getValue(),
                        "保険種類番号",
                        skHokenSyuruiNoLst.get(0).getDaihyouhknsyuruino().toString(),
                        "年金原資最低保証率",
                        "0",
                        "初期死亡時円換算最低保証特約適用有無",
                        umuKbn.getValue(),
                        "新契約年金種類",
                        skNenkinSyu.getValue(),
                        "定期支払金有無",
                        teikisiharaikinUmu.getValue()));

                    throw new CommonBizAppException("申込番号=" + mosno);
                }

                syouhnZokusei = syouhnZokuseiLst.get(0);
            }

            String plKykKjnm = ztSmbcPaperlessMosTrTblParam.getZtrseihowebplkykkjnm();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplkykkjnm())) {
                plKykKjnm = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplkykkjnm());
            }

            String plTsinadrkai = ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltsinadrkai();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltsinadrkai())) {
                plTsinadrkai = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltsinadrkai());
            }

            String kykOttmsk = ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykottmsk();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykottmsk())) {
                kykOttmsk = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykottmsk());
            }

            String plHhknkjnm = ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhknkjnm();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhknkjnm())) {
                plHhknkjnm = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhknkjnm());
            }

            String plHhknadr = ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhknadr();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhknadr())) {
                plHhknadr = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhknadr());
            }

            String hhknOttmsk = ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknottmsk();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknottmsk())) {
                hhknOttmsk = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknottmsk());
            }

            String plSbuktkjnm = ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktkjnm();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktkjnm())) {
                plSbuktkjnm = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktkjnm());
            }

            String sbuktKjnm2 = ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm2();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm2())) {
                sbuktKjnm2 = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm2());
            }

            String sbuktKjnm3 = ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm3();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm3())) {
                sbuktKjnm3 = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm3());
            }

            String sbuktKjnm4 = ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm4();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm4())) {
                sbuktKjnm4 = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktkjnm4());
            }

            String hhkndrkjnm = ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrkjnm();

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrkjnm())) {
                hhkndrkjnm = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrkjnm());
            }

            String mnkUktKjnm = ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktkjnm();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktkjnm())) {

                mnkUktKjnm = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktkjnm());
            }

            String kzkkjnm1 = ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkkjnm1();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkkjnm1())) {

                kzkkjnm1 = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkkjnm1());
            }

            String kzkadr1 = ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkadr1();
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkadr1())) {

                kzkadr1 = SkjStringUtil.convInvalidChar(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkadr1());
            }

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykottmsk())) {

                ReplaceSkjResultBean rsrBean = SkjStringUtil.replaceSjk(kykOttmsk);

                if (rsrBean.isReplaced()){

                    kykOttmsk = rsrBean.getReplacedString();
                }
            }

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknottmsk())) {

                ReplaceSkjResultBean rsrBean = SkjStringUtil.replaceSjk(hhknOttmsk);

                if (rsrBean.isReplaced()){

                    hhknOttmsk = rsrBean.getReplacedString();
                }
            }

            String bosyuuninTourokuNo1 = "";
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebnrkbsyutrkno())) {

                bosyuuninTourokuNo1 = ztSmbcPaperlessMosTrTblParam.getZtrseihowebnrkbsyutrkno().toUpperCase();

            }
            else if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplbsyutrkno())) {

                bosyuuninTourokuNo1 = ztSmbcPaperlessMosTrTblParam.getZtrseihowebplbsyutrkno().toUpperCase();
            }

            String sakuseijisitencd = "";
            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsksjsitencd())) {

                sakuseijisitencd = Strings.padStart(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsksjsitencd(), 4, '0');
            }

            long hrktuukasyutkP = 0;
            long gkHrktuukasyutkP = 0;
            String mosTuukasyukbn = "";
            if (C_PtratkituukasiteiKbn.HRKTUUKA.eq(syouhnZokusei.getPtratkituukasiteikbn())) {

                hrktuukasyutkP = ztSmbcPaperlessMosTrTblParam.getZtrseihowebnykntuukanykngkc();
                gkHrktuukasyutkP = ztSmbcPaperlessMosTrTblParam.getZtrseihowebgnykntuknykngkc();
                mosTuukasyukbn = ztSmbcPaperlessMosTrTblParam.getZtrseihowebnykntuukakbn();
            }
            else {

                hrktuukasyutkP = ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosp1c();
                gkHrktuukasyutkP = ztSmbcPaperlessMosTrTblParam.getZtrseihowebgaikakihonpc();
                mosTuukasyukbn = ztSmbcPaperlessMosTrTblParam.getZtrseihowebsiteituukakbn();
            }

            Integer hknkkn = editSeihoWebRenkeiKoumoku.hknkknSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebhknkknc(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsueokikknc(),
                hknsyuruino);

            Integer znnkai =
                editSeihoWebRenkeiKoumoku.huho2GetZnnkai(ztSmbcPaperlessMosTrTblParam.getZtrseihowebzennoukknc());

            BizCurrency mosikkatup = editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebnykntuukakbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebikkatupc(),
                Long.valueOf(0));

            BizCurrency moszennoup = editSeihoWebRenkeiKoumoku.huho2GetMoszennoup(
                mosTuukasyukbn,
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebzennoupc(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebgaikazennoupc());

            SkSeihoWebBosKoumokuCheckBean skSeihoWebBosKoumokuCheckBean =
                SWAKInjector.getInstance(SkSeihoWebBosKoumokuCheckBean.class);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosymdc())) {
                skSeihoWebBosKoumokuCheckBean.setMosymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosymdc()));
            }

            skSeihoWebBosKoumokuCheckBean.setSekno(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtnskno());

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebfstmossksymdc())) {
                skSeihoWebBosKoumokuCheckBean.setMossakuseiymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebfstmossksymdc()));
            }

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosuktkymdc())) {
                skSeihoWebBosKoumokuCheckBean.setPplessmosukeymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosuktkymdc()));
            }

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsekykkigenymdc())) {
                skSeihoWebBosKoumokuCheckBean.setPykkigenymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsekykkigenymdc()));
            }

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebcalckijyunymdc())) {
                skSeihoWebBosKoumokuCheckBean.setMoscalckijyunymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebcalckijyunymdc()));
            }

            skSeihoWebBosKoumokuCheckBean.setKyknmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykknnm());
            skSeihoWebBosKoumokuCheckBean.setKyknmkj(plKykKjnm);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkyksyaseiymdc())) {
                skSeihoWebBosKoumokuCheckBean.setKykseiymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkyksyaseiymdc()));
            }

            skSeihoWebBosKoumokuCheckBean.setKykkinmusakinm(editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(kykOttmsk));
            skSeihoWebBosKoumokuCheckBean.setTsinyno(
                editSeihoWebRenkeiKoumoku.postalCdSyutoku(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplkihontikucd()));
            skSeihoWebBosKoumokuCheckBean.setTsinadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(plTsinadrkai));
            skSeihoWebBosKoumokuCheckBean.setTsinadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(plTsinadrkai));
            skSeihoWebBosKoumokuCheckBean.setTsinadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(plTsinadrkai));
            skSeihoWebBosKoumokuCheckBean.setTsintelno(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplkyktelno());

            skSeihoWebBosKoumokuCheckBean.setHhknnmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknknnm());
            skSeihoWebBosKoumokuCheckBean.setHhknnmkj(plHhknkjnm);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknseiymdc())) {
                skSeihoWebBosKoumokuCheckBean.setHhknseiymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknseiymdc()));
            }

            if (C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu())) {

                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkktymdc())) {
                    skSeihoWebBosKoumokuCheckBean.setKktymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkktymdc()));
                }
            }
            else if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyokugyoukktumu())) {
                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsyokugyoukktymdc())) {

                    skSeihoWebBosKoumokuCheckBean.setKktymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsyokugyoukktymdc()));
                }
            }

            skSeihoWebBosKoumokuCheckBean.setHhknsykgycd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknsykgycd());
            skSeihoWebBosKoumokuCheckBean.setHhknyno(
                editSeihoWebRenkeiKoumoku.postalCdSyutoku(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhiikihontikucd()));

            skSeihoWebBosKoumokuCheckBean.setHhknadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(plHhknadr));

            skSeihoWebBosKoumokuCheckBean.setHhknadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(plHhknadr));

            skSeihoWebBosKoumokuCheckBean.setHhknadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(plHhknadr));

            skSeihoWebBosKoumokuCheckBean.setHhkntelno(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhkntelno());
            skSeihoWebBosKoumokuCheckBean.setHhknkinmusakinm(editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(hhknOttmsk));

            skSeihoWebBosKoumokuCheckBean.setSyukihons(editSeihoWebRenkeiKoumoku.kihonsSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsiteituukakbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebkihonsc(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebgaikakihonsc()));

            skSeihoWebBosKoumokuCheckBean.setMossyukykp(editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(
                mosTuukasyukbn, hrktuukasyutkP, gkHrktuukasyutkP));

            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbnkkknc() != 0) {

                skSeihoWebBosKoumokuCheckBean.setNstksbnkkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbnkkknc());
            }

            skSeihoWebBosKoumokuCheckBean.setSbuktnin(editSeihoWebRenkeiKoumoku.ktninSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukthksuninzuuc(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn()));

            skSeihoWebBosKoumokuCheckBean.setSbuktnmkn1(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktknnm());
            skSeihoWebBosKoumokuCheckBean.setSbuktnmkj1(plSbuktkjnm);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktseiymdc())) {

                skSeihoWebBosKoumokuCheckBean.setSbuktseiymd1(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktseiymdc()));
            }

            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari1c() != 0) {

                skSeihoWebBosKoumokuCheckBean.setSbuktbnwari1(BizNumber.valueOf(
                    new BigDecimal(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari1c().toString())));
            }

            skSeihoWebBosKoumokuCheckBean.setSbuktnmkn2(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktknnm2());
            skSeihoWebBosKoumokuCheckBean.setSbuktnmkj2(sbuktKjnm2);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd2c())) {

                skSeihoWebBosKoumokuCheckBean.setSbuktseiymd2(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd2c()));
            }

            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari2c() != 0) {

                skSeihoWebBosKoumokuCheckBean.setSbuktbnwari2(BizNumber.valueOf(
                    new BigDecimal(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari2c().toString())));
            }

            skSeihoWebBosKoumokuCheckBean.setSbuktnmkn3(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktknnm3());
            skSeihoWebBosKoumokuCheckBean.setSbuktnmkj3(sbuktKjnm3);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd3c())) {

                skSeihoWebBosKoumokuCheckBean.setSbuktseiymd3(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd3c()));
            }

            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari3c() != 0) {

                skSeihoWebBosKoumokuCheckBean.setSbuktbnwari3(BizNumber.valueOf(
                    new BigDecimal(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari3c().toString())));
            }

            skSeihoWebBosKoumokuCheckBean.setSbuktnmkn4(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktknnm4());
            skSeihoWebBosKoumokuCheckBean.setSbuktnmkj4(sbuktKjnm4);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd4c())) {

                skSeihoWebBosKoumokuCheckBean.setSbuktseiymd4(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd4c()));
            }

            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari4c() != 0) {

                skSeihoWebBosKoumokuCheckBean.setSbuktbnwari4(BizNumber.valueOf(
                    new BigDecimal(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari4c().toString())));
            }

            skSeihoWebBosKoumokuCheckBean.setNenkinuktnmkana(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktknnm());
            skSeihoWebBosKoumokuCheckBean.setNenkinuktnmkanji(mnkUktKjnm);

            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktseiymdc())) {

                skSeihoWebBosKoumokuCheckBean.setNenkinuktseiymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktseiymdc()));
            }

            skSeihoWebBosKoumokuCheckBean.setHknkkn(hknkkn);
            skSeihoWebBosKoumokuCheckBean.setHrkkkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebphrkkiknc());
            skSeihoWebBosKoumokuCheckBean.setSyudai1hknkkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdai1hknkknc());
            skSeihoWebBosKoumokuCheckBean.setZnnkai(znnkai);
            skSeihoWebBosKoumokuCheckBean.setMosikkatup(mosikkatup);
            skSeihoWebBosKoumokuCheckBean.setMoszennoupsyokaiari(moszennoup);
            skSeihoWebBosKoumokuCheckBean.setKouhurikouzainfositencd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkouhurisitencd());
            skSeihoWebBosKoumokuCheckBean.setKouhurikouzainfokouzano(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkouhurikouzano());
            skSeihoWebBosKoumokuCheckBean.setCifcd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebankenkanrino());

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebuktkid())) {
                skSeihoWebBosKoumokuCheckBean.setUktkid(ztSmbcPaperlessMosTrTblParam.getZtrseihowebuktkid());
            }

            skSeihoWebBosKoumokuCheckBean.setBosyuunintourokuno1(bosyuuninTourokuNo1);

            skSeihoWebBosKoumokuCheckBean.setDairitenkinyuukikancd1(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebaatkisyaknyuucd());
            skSeihoWebBosKoumokuCheckBean.setDairitenkinyuukikansitencd1(sakuseijisitencd);

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkydbosyuukjncd())) {
                skSeihoWebBosKoumokuCheckBean.setInputbosyuucd2(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebkydbosyuukjncd());
            }

            skSeihoWebBosKoumokuCheckBean.setDsmailaddress(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsmailaddress());
            skSeihoWebBosKoumokuCheckBean.setDsbankcd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskinyuucd());
            skSeihoWebBosKoumokuCheckBean.setDssitencd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdssitencd());
            skSeihoWebBosKoumokuCheckBean.setDskouzano(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskouzano());
            skSeihoWebBosKoumokuCheckBean.setDskzmeiginmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsknkzmeigi());
            skSeihoWebBosKoumokuCheckBean.setSintyou(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknsintyouc());
            skSeihoWebBosKoumokuCheckBean.setTaijyuu(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkntaijyuuc());
            skSeihoWebBosKoumokuCheckBean.setTrkkzknmkn1(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkknnm1());
            skSeihoWebBosKoumokuCheckBean.setTrkkzknmkj1(kzkkjnm1);
            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkseiymd1c())) {

                skSeihoWebBosKoumokuCheckBean.setTrkkzkseiymd1(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkseiymd1c()));
            }
            skSeihoWebBosKoumokuCheckBean.setTrkkzkyno1(editSeihoWebRenkeiKoumoku.postalCdSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkyno1()));
            skSeihoWebBosKoumokuCheckBean.setTrkkzkadr1kj1(editSeihoWebRenkeiKoumoku.adr1Syutoku(kzkadr1));
            skSeihoWebBosKoumokuCheckBean.setTrkkzkadr2kj1(editSeihoWebRenkeiKoumoku.adr2Syutoku(kzkadr1));
            skSeihoWebBosKoumokuCheckBean.setTrkkzkadr3kj1(editSeihoWebRenkeiKoumoku.adr3Syutoku(kzkadr1));
            skSeihoWebBosKoumokuCheckBean.setTrkkzktelno1(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzktelno1());
            skSeihoWebBosKoumokuCheckBean.setHhkdrnmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrknnm());
            skSeihoWebBosKoumokuCheckBean.setHhkdrnmkj(hhkndrkjnm);
            if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrseiymdc())) {

                skSeihoWebBosKoumokuCheckBean.setHhkdrseiymd(
                    BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrseiymdc()));
            }

            Validator validator = SWAKInjector.getInstance(Validator.class);

            C_UmuKbn validationErrUmu = C_UmuKbn.NONE;

            C_UmuKbn mosymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn seknoErrUmu = C_UmuKbn.NONE;

            C_UmuKbn mossakuseiymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn pplessmosukeymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn pykkigenymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn moscalckijyunymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn kyknmknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn kyknmkjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn kykseiymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn kykkinmusakinmErrUmu = C_UmuKbn.NONE;

            C_UmuKbn tsinynoErrUmu = C_UmuKbn.NONE;

            C_UmuKbn tsinadr1kjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn tsinadr2kjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn tsinadr3kjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn tsintelnoErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknnmknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknnmkjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknseiymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn kktymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn syokugyoukktymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknsykgycdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknynoErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknadr1kjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknadr2kjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknadr3kjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhkntelnoErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhknkinmusakinmErrUmu = C_UmuKbn.NONE;

            C_UmuKbn syukihonsErrUmu = C_UmuKbn.NONE;

            C_UmuKbn mossyukykpValidateErrUmu = C_UmuKbn.NONE;

            C_UmuKbn nstksbnkknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktninErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkn1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkj1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktseiymd1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktbnwari1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkn2ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkj2ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktseiymd2ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktbnwari2ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkn3ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkj3ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktseiymd3ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktbnwari3ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkn4ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktnmkj4ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktseiymd4ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sbuktbnwari4ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn nenkinuktnmkanaErrUmu = C_UmuKbn.NONE;

            C_UmuKbn nenkinuktnmkanjiErrUmu = C_UmuKbn.NONE;

            C_UmuKbn nenkinuktseiymdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hknkknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hrkkknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn syudai1hknkknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn znnkaiErrUmu = C_UmuKbn.NONE;

            C_UmuKbn mosikkatupErrUmu = C_UmuKbn.NONE;

            C_UmuKbn moszennoupsyokaiariErrUmu = C_UmuKbn.NONE;

            C_UmuKbn kouhurikouzainfositencdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn kouhurikouzainfokouzanoErrUmu = C_UmuKbn.NONE;

            C_UmuKbn cifcdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn uktkidErrUmu = C_UmuKbn.NONE;

            C_UmuKbn bosyuunintourokuno1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn dairitenkinyuukikancd1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn dairitenkinyuukikansitencd1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn inputbosyuucd2ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn dsmailaddressErrUmu = C_UmuKbn.NONE;

            C_UmuKbn dsbankcdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn dssitencdErrUmu = C_UmuKbn.NONE;

            C_UmuKbn dskouzanoErrUmu = C_UmuKbn.NONE;

            C_UmuKbn dskzmeiginmknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn sintyouErrUmu = C_UmuKbn.NONE;

            C_UmuKbn taijyuuErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzknmkn1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzknmkj1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzkseiymd1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzkyno1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzkadr1kj1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzkadr2kj1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzkadr3kj1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn trkkzktelno1ErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhkdrnmknErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhkdrnmkjErrUmu = C_UmuKbn.NONE;

            C_UmuKbn hhkdrseiymdErrUmu = C_UmuKbn.NONE;

            Set<ConstraintViolation<SkSeihoWebBosKoumokuCheckBean>> chkKekkaSet =
                validator.validate(skSeihoWebBosKoumokuCheckBean);

            if (chkKekkaSet.size() != 0) {

                validationErrUmu = C_UmuKbn.ARI;

                for (ConstraintViolation<SkSeihoWebBosKoumokuCheckBean> chkKekka: chkKekkaSet) {

                    if (MOSYMD.equals(chkKekka.getPropertyPath().toString())) {

                        mosymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "申込日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SEKNO.equals(chkKekka.getPropertyPath().toString())) {

                        seknoErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "設計書番号＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (MOSSAKUSEIYMD.equals(chkKekka.getPropertyPath().toString())) {

                        mossakuseiymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "申込書作成日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (PPLESSMOSUKEYMD.equals(chkKekka.getPropertyPath().toString())) {

                        pplessmosukeymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "ペーパーレス申込書受付日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (PYKKIGENYMD.equals(chkKekka.getPropertyPath().toString())) {

                        pykkigenymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "保険料有効期限年月日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (MOSCALCKIJYUNYMD.equals(chkKekka.getPropertyPath().toString())) {

                        moscalckijyunymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "申込書計算基準日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (KYKNMKN.equals(chkKekka.getPropertyPath().toString())) {

                        kyknmknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "契約者名（カナ）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (KYKNMKJ.equals(chkKekka.getPropertyPath().toString())) {

                        kyknmkjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "契約者名（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (KYKSEIYMD.equals(chkKekka.getPropertyPath().toString())) {

                        kykseiymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "契約者生年月日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (KYKKINMUSAKINM.equals(chkKekka.getPropertyPath().toString())) {

                        kykkinmusakinmErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "契約者勤務先名＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TSINYNO.equals(chkKekka.getPropertyPath().toString())) {

                        tsinynoErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "通信先郵便番号＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TSINADR1KJ.equals(chkKekka.getPropertyPath().toString())) {

                        tsinadr1kjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "通信先住所１（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TSINADR2KJ.equals(chkKekka.getPropertyPath().toString())) {

                        tsinadr2kjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "通信先住所２（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TSINADR3KJ.equals(chkKekka.getPropertyPath().toString())) {

                        tsinadr3kjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "通信先住所３（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TSINTELNO.equals(chkKekka.getPropertyPath().toString())) {

                        tsintelnoErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "通信先電話番号＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNNMKN.equals(chkKekka.getPropertyPath().toString())) {

                        hhknnmknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者名（カナ）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNNMKJ.equals(chkKekka.getPropertyPath().toString())) {

                        hhknnmkjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者名（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNSEIYMD.equals(chkKekka.getPropertyPath().toString())) {

                        hhknseiymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者生年月日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (KKTYMD.equals(chkKekka.getPropertyPath().toString())) {
                        if (C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu())) {
                            kktymdErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(
                                MessageId.EHA1059, "告知日＝"+ chkKekka.getInvalidValue(), mosno));
                        }

                        else if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyokugyoukktumu())) {
                            syokugyoukktymdErrUmu = C_UmuKbn.ARI;
                            batchLogger.error(MessageUtil.getMessage(
                                MessageId.EHA1059, "職業告知日＝"+ chkKekka.getInvalidValue(), mosno));
                        }
                    }

                    if (HHKNSYKGYCD.equals(chkKekka.getPropertyPath().toString())) {

                        hhknsykgycdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者職業コード＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNYNO.equals(chkKekka.getPropertyPath().toString())) {

                        hhknynoErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者郵便番号＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNADR1KJ.equals(chkKekka.getPropertyPath().toString())) {

                        hhknadr1kjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者住所１（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNADR2KJ.equals(chkKekka.getPropertyPath().toString())) {

                        hhknadr2kjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者住所２（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNADR3KJ.equals(chkKekka.getPropertyPath().toString())) {

                        hhknadr3kjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者住所３（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNTELNO.equals(chkKekka.getPropertyPath().toString())) {

                        hhkntelnoErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者電話番号＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKNKINMUSAKINM.equals(chkKekka.getPropertyPath().toString())) {

                        hhknkinmusakinmErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者勤務先名＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SYUKIHONS.equals(chkKekka.getPropertyPath().toString())) {

                        syukihonsErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "主契約基本保険金額＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (MOSSYUKYKP.equals(chkKekka.getPropertyPath().toString())) {

                        mossyukykpValidateErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "申込主契約Ｐ＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (NSTKSBNKKN.equals(chkKekka.getPropertyPath().toString())) {

                        nstksbnkknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "年金支払特約死亡年金期間＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNIN.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktninErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人人数＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKN1.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkn1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（カナ）１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKJ1.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkj1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（漢字）１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTSEIYMD1.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktseiymd1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人生年月日１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTBNWARI1.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktbnwari1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人分割割合１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKN2.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkn2ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（カナ）２＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKJ2.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkj2ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（漢字）２＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTSEIYMD2.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktseiymd2ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人生年月日２＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTBNWARI2.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktbnwari2ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人分割割合２＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKN3.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkn3ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（カナ）３＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKJ3.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkj3ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（漢字）３＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTSEIYMD3.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktseiymd3ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人生年月日３＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTBNWARI3.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktbnwari3ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人分割割合３＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKN4.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkn4ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（カナ）４＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTNMKJ4.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktnmkj4ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人名（漢字）４＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTSEIYMD4.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktseiymd4ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人生年月日４＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SBUKTBNWARI4.equals(chkKekka.getPropertyPath().toString())) {

                        sbuktbnwari4ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "死亡受取人分割割合４＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (NENKINUKTNMKANA.equals(chkKekka.getPropertyPath().toString())) {

                        nenkinuktnmkanaErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "年金受取人名（カナ）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (NENKINUKTNMKANJI.equals(chkKekka.getPropertyPath().toString())) {

                        nenkinuktnmkanjiErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "年金受取人名（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (NENKINUKTSEIYMD.equals(chkKekka.getPropertyPath().toString())) {

                        nenkinuktseiymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "年金受取人生年月日＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HKNKKN.equals(chkKekka.getPropertyPath().toString())) {

                        hknkknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "保険期間＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HRKKKN.equals(chkKekka.getPropertyPath().toString())) {

                        hrkkknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "払込期間＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SYUDAI1HKNKKN.equals(chkKekka.getPropertyPath().toString())) {

                        syudai1hknkknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "主契約第１保険期間＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (ZNNKAI.equals(chkKekka.getPropertyPath().toString())) {

                        znnkaiErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "前納回数＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (MOSIKKATUP.equals(chkKekka.getPropertyPath().toString())) {

                        mosikkatupErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "申込一括払Ｐ＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (MOSZENNOUPSYOKAIARI.equals(chkKekka.getPropertyPath().toString())) {

                        moszennoupsyokaiariErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "申込前納Ｐ（初回含）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (KOUHURIKOUZAINFOSITENCD.equals(chkKekka.getPropertyPath().toString())) {

                        kouhurikouzainfositencdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "（口振口座情報）支店コード＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (KOUHURIKOUZAINFOKOUZANO.equals(chkKekka.getPropertyPath().toString())) {

                        kouhurikouzainfokouzanoErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "（口振口座情報）口座番号＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (CIFCD.equals(chkKekka.getPropertyPath().toString())) {

                        cifcdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "ＣＩＦコード＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (UKTKID.equals(chkKekka.getPropertyPath().toString())) {

                        uktkidErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "受付管理ＩＤ＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (BOSYUUNINTOUROKUNO1.equals(chkKekka.getPropertyPath().toString())) {

                        bosyuunintourokuno1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "募集人登録番号１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (DAIRITENKINYUUKIKANCD1.equals(chkKekka.getPropertyPath().toString())) {

                        dairitenkinyuukikancd1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "代理店金融機関コード１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (DAIRITENKINYUUKIKANSITENCD1.equals(chkKekka.getPropertyPath().toString())) {

                        dairitenkinyuukikansitencd1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "代理店金融機関支店コード１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (INPUTBOSYUUCD2.equals(chkKekka.getPropertyPath().toString())) {

                        inputbosyuucd2ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "入力募集人コード２＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (DSMAILADDRESS.equals(chkKekka.getPropertyPath().toString())) {

                        dsmailaddressErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "ＤＳメールアドレス＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (DSBANKCD.equals(chkKekka.getPropertyPath().toString())) {

                        dsbankcdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "ＤＳ銀行コード＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (DSSITENCD.equals(chkKekka.getPropertyPath().toString())) {

                        dssitencdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "ＤＳ支店コード＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (DSKOUZANO.equals(chkKekka.getPropertyPath().toString())) {

                        dskouzanoErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "ＤＳ口座番号＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (DSKZMEIGINMKN.equals(chkKekka.getPropertyPath().toString())) {

                        dskzmeiginmknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "ＤＳ口座名義人氏名（カナ）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (SINTYOU.equals(chkKekka.getPropertyPath().toString())) {

                        sintyouErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "身長＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TAIJYUU.equals(chkKekka.getPropertyPath().toString())) {

                        taijyuuErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "体重＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKNMKN1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzknmkn1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族名（カナ）１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKNMKJ1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzknmkj1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族名（漢字）１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKSEIYMD1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzkseiymd1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族生年月日１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKYNO1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzkyno1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族郵便番号１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKADR1KJ1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzkadr1kj1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族住所１（漢字）１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKADR2KJ1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzkadr2kj1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族住所２（漢字）１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKADR3KJ1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzkadr3kj1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族住所３（漢字）１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (TRKKZKTELNO1.equals(chkKekka.getPropertyPath().toString())) {

                        trkkzktelno1ErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "登録家族電話番号１＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKDRNMKN.equals(chkKekka.getPropertyPath().toString())) {

                        hhkdrnmknErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者代理人名（カナ）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKDRNMKJ.equals(chkKekka.getPropertyPath().toString())) {

                        hhkdrnmkjErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者代理人名（漢字）＝"+ chkKekka.getInvalidValue(), mosno));
                    }

                    if (HHKDRSEIYMD.equals(chkKekka.getPropertyPath().toString())) {

                        hhkdrseiymdErrUmu = C_UmuKbn.ARI;
                        batchLogger.error(MessageUtil.getMessage(
                            MessageId.EHA1059, "被保険者代理人生年月日＝"+ chkKekka.getInvalidValue(), mosno));
                    }
                }
            }

            HT_BosKihon bosKihonEntity = new HT_BosKihon();

            C_KykKbn kykKbn =
                editSeihoWebRenkeiKoumoku.kykkbnkyktdkkbnHenkan(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnsyukyktdkkbn());

            bosKihonEntity.setMosno(mosno);

            if (!C_UmuKbn.ARI.eq(seknoErrUmu)) {

                bosKihonEntity.setSekno(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtnskno());
            }

            bosKihonEntity.setMosuketukekbn(C_MosUketukeKbn.PAPERLESS);

            if (!C_UmuKbn.ARI.eq(mosymdErrUmu)) {
                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosymdc())) {

                    bosKihonEntity.setMosymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosymdc()));
                }
            }

            if (!C_UmuKbn.ARI.eq(mossakuseiymdErrUmu)) {
                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebfstmossksymdc())) {

                    bosKihonEntity.setMossakuseiymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebfstmossksymdc()));
                }
            }

            if (!C_UmuKbn.ARI.eq(pplessmosukeymdErrUmu)) {
                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosuktkymdc())) {

                    bosKihonEntity.setPplessmosukeymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmosuktkymdc()));
                }
            }

            if (!C_UmuKbn.ARI.eq(pykkigenymdErrUmu)) {
                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsekykkigenymdc())) {

                    bosKihonEntity.setPykkigenymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsekykkigenymdc()));
                }
            }
            if (C_UmuKbn.ARI.eq(syouhnZokusei.getSyokugyoukktumu())) {
                if (!C_UmuKbn.ARI.eq(syokugyoukktymdErrUmu)) {
                    if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsyokugyoukktymdc())) {

                        bosKihonEntity.setKktymd(
                            BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsyokugyoukktymdc()));
                    }
                }
            }

            if (!C_UmuKbn.ARI.eq(moscalckijyunymdErrUmu)) {
                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebcalckijyunymdc())) {

                    bosKihonEntity.setMoscalckijyunymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebcalckijyunymdc()));
                }
            }

            bosKihonEntity.setKykymdtkrumu(C_Kykymdtkrumu.NONE);

            bosKihonEntity.setKykkbn(kykKbn);

            if (!C_UmuKbn.ARI.eq(hhknnmknErrUmu)) {
                bosKihonEntity.setHhknnmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknknnm());
            }

            if (!C_UmuKbn.ARI.eq(hhknnmkjErrUmu)) {
                bosKihonEntity.setHhknnmkj(plHhknkjnm);
            }

            bosKihonEntity.setHhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);

            if (!C_UmuKbn.ARI.eq(hhknseiymdErrUmu)) {
                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknseiymdc())) {

                    bosKihonEntity.setHhknseiymd(
                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknseiymdc()));
                }
            }

            bosKihonEntity.setHhknsei(
                editSeihoWebRenkeiKoumoku.hhknseiHenkan(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknseikbn()));

            if (!C_UmuKbn.ARI.eq(hhknsykgycdErrUmu)) {
                bosKihonEntity.setHhknsykgycd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknsykgycd());
            }

            bosKihonEntity.setHhknnensyuukbn(editSeihoWebRenkeiKoumoku.hhknnensyuukbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknnensyuukbn()));

            bosKihonEntity.setTsindousiteikbn(C_TsindousiteiKbn.BLNK);

            if (!C_UmuKbn.ARI.eq(hhknynoErrUmu)) {
                bosKihonEntity.setHhknyno(editSeihoWebRenkeiKoumoku.postalCdSyutoku(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhiikihontikucd()));
            }

            if (!C_UmuKbn.ARI.eq(hhknadr1kjErrUmu) &&
                !C_UmuKbn.ARI.eq(hhknadr2kjErrUmu) &&
                !C_UmuKbn.ARI.eq(hhknadr3kjErrUmu)) {
                bosKihonEntity.setHhknadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(plHhknadr));

                bosKihonEntity.setHhknadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(plHhknadr));

                bosKihonEntity.setHhknadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(plHhknadr));
            }

            if (!C_UmuKbn.ARI.eq(hhkntelnoErrUmu)) {
                bosKihonEntity.setHhkntelno(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhhkntelno());
            }

            if (!C_UmuKbn.ARI.eq(hhknkinmusakinmErrUmu)) {
                bosKihonEntity.setHhknkinmusakinm(editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(hhknOttmsk));
            }


            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                if (!C_UmuKbn.ARI.eq(kyknmknErrUmu)) {

                    bosKihonEntity.setKyknmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykknnm());
                }
            }

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                if (!C_UmuKbn.ARI.eq(kyknmkjErrUmu)) {

                    bosKihonEntity.setKyknmkj(plKykKjnm);
                }
            }

            bosKihonEntity.setKyknmkjkhukakbn(C_KjkhukaKbn.BLNK);

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                if (!C_UmuKbn.ARI.eq(kykseiymdErrUmu)) {

                    if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkyksyaseiymdc())) {

                        bosKihonEntity.setKykseiymd(
                            BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkyksyaseiymdc()));
                    }
                }
            }

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                bosKihonEntity.setKyksei(
                    editSeihoWebRenkeiKoumoku.kykseiHenkan(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkyksyaseikbn()));

                bosKihonEntity.setKyktdk(editSeihoWebRenkeiKoumoku.zrnKykTdkKbn(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnsyukyktdkkbn()));
            }

            bosKihonEntity.setKyknensyuukbn(C_NensyuuKbn.BLNK);

            if (C_KykKbn.KEIHI_BETU.eq(kykKbn)) {

                if (!C_UmuKbn.ARI.eq(kykkinmusakinmErrUmu)) {

                    bosKihonEntity.setKykkinmusakinm(editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(kykOttmsk));
                }
            }

            bosKihonEntity.setHjndaiykkbn(C_HjndaiykKbn.BLNK);

            bosKihonEntity.setYakkanjyuryouhoukbn(editSeihoWebRenkeiKoumoku.huho2GetYakkanJyuryouKbn(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebyakkankbn()));

            if (!C_UmuKbn.ARI.eq(tsinynoErrUmu)) {

                bosKihonEntity.setTsinyno(editSeihoWebRenkeiKoumoku.postalCdSyutoku(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplkihontikucd()));
            }

            if (!C_UmuKbn.ARI.eq(tsinadr1kjErrUmu) &&
                !C_UmuKbn.ARI.eq(tsinadr2kjErrUmu) &&
                !C_UmuKbn.ARI.eq(tsinadr3kjErrUmu)) {

                bosKihonEntity.setTsinadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(plTsinadrkai));

                bosKihonEntity.setTsinadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(plTsinadrkai));

                bosKihonEntity.setTsinadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(plTsinadrkai));
            }

            if (!C_UmuKbn.ARI.eq(tsintelnoErrUmu)) {

                bosKihonEntity.setTsintelno(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplkyktelno());
            }

            bosKihonEntity.setFatcasnsikbn(
                C_FatcasnsiKbn.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebfatcasnsiarihyj()));

            bosKihonEntity.setBikkjnssinfokbn(
                C_BikkjnssinfoKbn.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebbikkjnssinfoari()));

            bosKihonEntity.setAeoisnsikbn(
                C_AeoisnsiKbn.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebaeoisnsiarihyj()));

            bosKihonEntity.setHknsyuruino(hknsyuruino);

            bosKihonEntity.setNkgnshosyouritukbn(C_NkgnsHosyourituKbn.BLNK);

            bosKihonEntity.setLivhukaumu(C_Livhukaumu.BLNK);

            bosKihonEntity.setPmnjtkhukakbn(C_PmnjtkhukaKbn.BLNK);

            bosKihonEntity.setPmnjtkkbn(C_PmnjtkKbn.NONE);

            bosKihonEntity.setKzktourokuservicetourokukbn(editSeihoWebRenkeiKoumoku.kzktourokumoskbnHenkan
                (ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzktrkmoskbn()));

            bosKihonEntity.setKykdrtkykhukakbn(editSeihoWebRenkeiKoumoku.kykdrtkykhukakbnHenkan
                (ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtkkbn()));

            bosKihonEntity.setStdrsktkyhkkbn(editSeihoWebRenkeiKoumoku.hhkdrtkykhukakbnHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtkkbn()));

            bosKihonEntity.setSdpdkbn(C_Sdpd.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsdpdkbn()));

            bosKihonEntity.setSntkhoukbn(editSeihoWebRenkeiKoumoku.sntkhoukbnHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhjkktkbn()));

            bosKihonEntity.setHaitoukbn(C_HaitouKbn.BLNK);

            bosKihonEntity.setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.BLNK);

            bosKihonEntity.setKyktuukasyu(editSeihoWebRenkeiKoumoku.tuukasyuHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsiteituukakbn()));

            bosKihonEntity.setHrktuukasyu(editSeihoWebRenkeiKoumoku.tuukasyuHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebnykntuukakbn()));

            bosKihonEntity.setYennykntkhkkbn(editSeihoWebRenkeiKoumoku.yennykntkhkkbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsiteituukakbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebnykntuukakbn()));

            bosKihonEntity.setGaikanykntkhkkbn(editSeihoWebRenkeiKoumoku.gaikanykntkhkkbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsiteituukakbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebnykntuukakbn()));

            bosKihonEntity.setYenshrtkhkkbn(C_Tkhukaumu.BLNK);

            if (!C_UmuKbn.ARI.eq(mossyukykpValidateErrUmu)) {

                bosKihonEntity.setMosheijyunp(editSeihoWebRenkeiKoumoku.huho2GetMosheijyunp(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebhrkkaisuukbn(),
                    mosTuukasyukbn,
                    hrktuukasyutkP,
                    gkHrktuukasyutkP));
            }

            bosKihonEntity.setIkkatubaraikbn(editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikbn(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebikkatubaraikbn()));

            bosKihonEntity.setIkkatubaraikaisuu(editSeihoWebRenkeiKoumoku.huho2GetIkkatubaraikaisuu(
                Strings.padStart(String.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebiktbrikaisuuc()), 2, '0')));

            if (!C_UmuKbn.ARI.eq(mosikkatupErrUmu)) {

                bosKihonEntity.setMosikkatup(editSeihoWebRenkeiKoumoku.huho2GetMosikkatup(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebnykntuukakbn(),
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebikkatupc(),
                    Long.valueOf(0)));
            }

            bosKihonEntity.setHrkkaisuu(editSeihoWebRenkeiKoumoku.hrkkaisuuHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebhrkkaisuukbn()));

            bosKihonEntity.setHrkkeiro(editSeihoWebRenkeiKoumoku.hrkkeiroHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhrkkeirokbn()));

            bosKihonEntity.setFstphrkkeirokbn(editSeihoWebRenkeiKoumoku.fstphrkkeiroHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebhrkkaisuukbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhrkkeirokbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebtkiyougyoutaikbn()));

            bosKihonEntity.setZennoumousideumu(editSeihoWebRenkeiKoumoku.huho2GetZennoumousideumu(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebzennouhyj()));

            bosKihonEntity.setZenkizennouumu(editSeihoWebRenkeiKoumoku.huho2GetZenkizennouumu(
                syouhnZokusei.getZenkizennoutekiumu(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebzennouhyj()));

            if (!C_UmuKbn.ARI.eq(znnkaiErrUmu)) {

                bosKihonEntity.setZnnkai(editSeihoWebRenkeiKoumoku.huho2GetZnnkai(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebzennoukknc()));
            }

            if (!C_UmuKbn.ARI.eq(moszennoupsyokaiariErrUmu)) {

                bosKihonEntity.setMoszennoupsyokaiari(moszennoup);
            }

            bosKihonEntity.setTargettkhkkbn(editSeihoWebRenkeiKoumoku.targettkhkkbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebtargettkarihyj()));

            bosKihonEntity.setTargettkkbn(editSeihoWebRenkeiKoumoku.targettkkbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebtargettkkbn()));

            if (0 != ztSmbcPaperlessMosTrTblParam.getZtrseihowebtargettkmkhtc()) {

                bosKihonEntity.setTargettkmkhtkbn(editSeihoWebRenkeiKoumoku.targettkmkhtkbnSyutoku(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebtargettkmkhtc()));
            }

            bosKihonEntity.setNstkhkkbn(editSeihoWebRenkeiKoumoku.nstkhkkbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplnkshrarihyj()));

            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplnkshrarihyj())) {

                bosKihonEntity.setNstksbnsyu(C_Nstknsyu.KAKUTEINENKIN);
            }

            if(!C_UmuKbn.ARI.eq(nstksbnkknErrUmu)){
                if (0 != ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbnkkknc()) {

                    bosKihonEntity.setNstksbnkkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbnkkknc());
                }
            }

            bosKihonEntity.setSyksbyensitihsyutkhkkbn(editSeihoWebRenkeiKoumoku.syksbYensitiHsyuTkhkKbn(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebyenhsyutkarihyj(),
                hknsyuruino));

            bosKihonEntity.setJyudkaigomehrtkhkkbn(editSeihoWebRenkeiKoumoku.jyudKaigoMehrTkhkKbn(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebkaigmehrtkarihyj()));

            bosKihonEntity.setKjnnkpzeitekitkhukakbn(editSeihoWebRenkeiKoumoku.huho2GetKjnnkpzeitekitkhukakbn(
                syouhnZokusei.getZeiseitekikakuumu(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd1(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd2(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd3(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd4(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd5()));

            bosKihonEntity.setTeikisiharaitkykhkkbn(
                editSeihoWebRenkeiKoumoku.teikisiharaitkykhkkbnSyutoku("0", hknsyuruino));

            if(!C_UmuKbn.ARI.eq(sbuktninErrUmu)){
                bosKihonEntity.setSbuktnin(editSeihoWebRenkeiKoumoku.ktninSyutoku(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukthksuninzuuc(),
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn()));
            }

            if (C_SkeijimuKbn.SMBC.eq(mosMikakuteiJyouhouKanri.getSkeijimukbn())) {

                bosKihonEntity.setKykhonninkakninsyoruikbn(
                    C_HonninkakuninSyoruiKbn.valueOf(editSeihoWebRendouKoumoku(mosno, "本人確認書類区分 ",
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkaksyoruikbn(), C_HonninkakuninSyoruiKbn.class)));

                bosKihonEntity.setSkskknhonninkakninsyoruikbn(
                    C_HonninkakuninSyoruiKbn.valueOf(editSeihoWebRendouKoumoku(mosno, "本人確認書類区分 ",
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebskskaksyoruikbn(), C_HonninkakuninSyoruiKbn.class)));
            }
            else {

                if ("00".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkaksyoruikbn())) {

                    bosKihonEntity.setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.BLNK);
                }
                else {

                    bosKihonEntity.setKykhonninkakninsyoruikbn(
                        C_HonninkakuninSyoruiKbn.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkaksyoruikbn()));
                }

                if ("00".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebskskaksyoruikbn())) {

                    bosKihonEntity.setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn.BLNK);
                }
                else {

                    bosKihonEntity.setSkskknhonninkakninsyoruikbn(
                        C_HonninkakuninSyoruiKbn.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebskskaksyoruikbn()));
                }
            }

            bosKihonEntity.setKoureikzksetumeihoukbn(editSeihoWebRenkeiKoumoku.koureikzksetumeihoukbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebkoureisyakakkbn1()));
            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkoureisyakakkbn2())) {
                bosKihonEntity.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.ARI);
            }
            else {
                bosKihonEntity.setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn.BLNK);
            }
            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkoureisyakakkbn3())) {
                bosKihonEntity.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.ARI);
            }
            else {
                bosKihonEntity.setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn.BLNK);
            }
            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdaihituarihyj())) {
                bosKihonEntity.setDaihituumukbn(C_UmuKbn.ARI);
            }
            else {
                bosKihonEntity.setDaihituumukbn(C_UmuKbn.NONE);
            }

            if(!C_UmuKbn.ARI.eq(uktkidErrUmu)){

                bosKihonEntity.setUktkid(ztSmbcPaperlessMosTrTblParam.getZtrseihowebuktkid());
            }

            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsmoshyj())) {

                bosKihonEntity.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            }
            else {

                bosKihonEntity.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);
            }

            if(!C_UmuKbn.ARI.eq(dsmailaddressErrUmu)){

                bosKihonEntity.setDsmailaddress(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsmailaddress());
            }

            bosKihonEntity.setYnkhrkmgkannituutikbn(editSeihoWebRenkeiKoumoku.ptuutihyjHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebptuutihyj(),
                hknsyuruino,
                bosKihonEntity.getZenkizennouumu(),
                bosKihonEntity.getHrktuukasyu()));

            bosKihonEntity.setTokuteitrhkansyono(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsansyono());

            bosKihonEntity.setPplessrenjidssymenttdkhyj(editSeihoWebRenkeiKoumoku.dsSyomenTtdkHyoujiHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebdssymnttdkhyj()));

            bosKihonEntity.setPplsrendoukouhurikousoukbn(editSeihoWebRenkeiKoumoku.huho2GetPplsrendoukouhurikousoukbn(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhrkkeirokbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebkuhrshmnttdkhyj()));

            bosKihonEntity.setPplessrendoucreditkousoukbn(editSeihoWebRenkeiKoumoku.huho2GetPplessrendoucreditkousoukbn(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhrkkeirokbn(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebkuhrshmnttdkhyj()));

            bosKihonEntity.setHnsstjmmouumukbn(C_UmuKbn.ARI);

            bosKihonEntity.setKjmeigihkhunouumukbn(editSeihoWebRenkeiKoumoku.kjmeigihkhunouumukbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd1(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd2(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd3(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd4(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd5()));

            bosKihonEntity.setTsryhshrkykumukbn(editSeihoWebRenkeiKoumoku.tsryhshrkykumukbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd1(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd2(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd3(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd4(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd5()));

            bosKihonEntity.setSyosisyatodokeumukbn(editSeihoWebRenkeiKoumoku.syosisyatodokeumukbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd1(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd2(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd3(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd4(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd5()));

            bosKihonEntity.setKakukisyouryakukbumukbn(editSeihoWebRenkeiKoumoku.kakukisyouryakukbumukbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd1(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd2(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd3(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd4(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd5()));

            bosKihonEntity.setSeiymdmosseitouumukbn(editSeihoWebRenkeiKoumoku.seiymdmosseitouumukbnSyutoku(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd1(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd2(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd3(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd4(),
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebpltksykmcd5()));

            bosKihonEntity.setIkokakninsyotokkijkumu(
                C_UmuKbn.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebikokakkjarihyj()));

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebtorihoutkjk1())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebtorihoutkjk2())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebtorihoutkjk3())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebtorihoutkjk4())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebtorihoutkjk5())) {

                bosKihonEntity.setTrtkhoukokusyotokkijkumu(C_UmuKbn.ARI);
            }

            else {
                bosKihonEntity.setTrtkhoukokusyotokkijkumu(C_UmuKbn.NONE);
            }

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkakhskjk1())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkakhskjk2())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkakhskjk3())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkakhskjk4())
                || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhnnkakhskjk5())) {

                bosKihonEntity.setHnnkakninhskjikouumukbn(C_UmuKbn.ARI);
            }
            else {

                bosKihonEntity.setHnnkakninhskjikouumukbn(C_UmuKbn.NONE);
            }

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhsktkjikou())) {

                bosKihonEntity.setHnnkakninhsktkjikouumukbn(C_UmuKbn.ARI);
            }
            else {

                bosKihonEntity.setHnnkakninhsktkjikouumukbn(C_UmuKbn.NONE);
            }

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebskshsktkjikou())) {

                bosKihonEntity.setSkskakninhsktkjikouumukbn(C_UmuKbn.ARI);
            }
            else {

                bosKihonEntity.setSkskakninhsktkjikouumukbn(C_UmuKbn.NONE);
            }

            bosKihonEntity.setMostourokujyoukyoukbn(C_MosTourokuJyoukyouKbn.MITOUROKU);

            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdatasousinzmhyj())) {

                bosKihonEntity.setPplessdatasousinumukbn(C_UmuKbn.ARI);
            }

            else {

                bosKihonEntity.setPplessdatasousinumukbn(C_UmuKbn.NONE);
            }

            if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebpsyouhyj())) {

                bosKihonEntity.setMobilebosyuukbn(C_MobilebosyuuKbn.MOBILEBOSYUU);
            }
            else {

                bosKihonEntity.setMobilebosyuukbn(C_MobilebosyuuKbn.BLNK);
            }

            bosKihonEntity.setTeirituhaibunwarikbn(editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebtrtrndhbnwrc(),
                syouhnZokusei.getTmttknhaibunwarisiteiumu()));

            bosKihonEntity.setSisuukbn(syouhnZokusei.getSisuukbn());

            bosKihonEntity.setSisuuhaibunwarikbn(editSeihoWebRenkeiKoumoku.tumitatekinHaibunWariKbnHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebssrndhbnwrc(),
                syouhnZokusei.getTmttknhaibunwarisiteiumu()));

            bosKihonEntity.setTrhkjikakkbn(C_TrhkjiKakKbn.BLNK);

            bosKihonEntity.setKoureitaioukbn(C_KoureisyaTaiouKbn.BLNK);

            bosKihonEntity.setGyoumuKousinsyaId(gyoumuKousinsyaId);

            bosKihonEntity.setGyoumuKousinTime(gyoumuKousinTime);

            BizPropertyInitializer.initialize(bosKihonEntity);

            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukthksuninzuuc() >= 2 &&
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukthksuninzuuc() <= 4) {

                for (int i = 0; i < ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukthksuninzuuc(); i++) {

                    HT_BosUketorinin bosUketorinin = bosKihonEntity.createBosUketorinin();

                    bosUketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);

                    bosUketorinin.setUktsyurenno(uktsyurenno);

                    if (1 == uktsyurenno) {

                        bosUketorinin.setUktkbn(editSeihoWebRenkeiKoumoku.uktkbnHenkan(
                            ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                            ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                            ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktknnm()));

                        if(!C_UmuKbn.ARI.eq(sbuktnmkn1ErrUmu)){

                            if (!"1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                                bosUketorinin.setUktnmkn(editSeihoWebRenkeiKoumoku.uktknnmSyutoku(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktknnm()));
                            }
                        }

                        if(!C_UmuKbn.ARI.eq(sbuktnmkj1ErrUmu)){

                            if (!"1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                                bosUketorinin.setUktnmkj(editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                                    plSbuktkjnm));
                            }
                        }

                        if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }
                        else {

                            bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.ukttdkSyutoku(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn()));
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktseiymd1ErrUmu)) {

                            if (!"1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                                String uktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktseiymdc());

                                if (!BizUtil.isBlank(uktseiymd)) {

                                    bosUketorinin.setUktseiymd(BizDate.valueOf(uktseiymd));
                                }
                            }
                        }


                        if (!C_UmuKbn.ARI.eq(sbuktbnwari1ErrUmu)) {

                            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari1c() != 0) {

                                bosUketorinin.setUktbnwari(BizNumber.valueOf(new BigDecimal(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari1c().toString())));
                            }
                        }

                    }
                    else if (2 == uktsyurenno) {

                        if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn2())) {

                            bosUketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);

                            bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn2()));
                        }
                        else {

                            bosUketorinin.setUktkbn(C_UktKbn.KYK);
                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktnmkn2ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn2())) {

                                bosUketorinin.setUktnmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktknnm2());
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktnmkj2ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn2())) {

                                bosUketorinin.setUktnmkj(sbuktKjnm2);
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktseiymd2ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn2())) {

                                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd2c())) {
                                    bosUketorinin.setUktseiymd(
                                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd2c()));
                                }
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktbnwari2ErrUmu)) {

                            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari2c() != 0) {

                                bosUketorinin.setUktbnwari(BizNumber.valueOf(new BigDecimal(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari2c().toString())));
                            }
                        }
                    }
                    else if (3 == uktsyurenno) {

                        if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn3())) {

                            bosUketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);

                            bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn3()));
                        }

                        else {

                            bosUketorinin.setUktkbn(C_UktKbn.KYK);
                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktnmkn3ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn3())) {

                                bosUketorinin.setUktnmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktknnm3());
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktnmkj3ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn3())) {

                                bosUketorinin.setUktnmkj(sbuktKjnm3);
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktseiymd3ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn3())) {

                                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd3c())) {
                                    bosUketorinin.setUktseiymd(
                                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd3c()));
                                }
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktbnwari3ErrUmu)) {

                            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari3c() != 0) {

                                bosUketorinin.setUktbnwari(BizNumber.valueOf(new BigDecimal(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari3c().toString())));
                            }
                        }
                    }
                    else {

                        if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn4())) {

                            bosUketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
                            bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.zrnUktTdkKbn(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn4()));
                        }
                        else {

                            bosUketorinin.setUktkbn(C_UktKbn.KYK);
                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktnmkn4ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn4())) {

                                bosUketorinin.setUktnmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktknnm4());
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktnmkj4ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn4())) {

                                bosUketorinin.setUktnmkj(sbuktKjnm4);
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktseiymd4ErrUmu)) {

                            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukttdkkbn4())) {

                                if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd4c())) {
                                    bosUketorinin.setUktseiymd(
                                        BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktseiymd4c()));
                                }
                            }
                        }

                        if (!C_UmuKbn.ARI.eq(sbuktbnwari4ErrUmu)) {

                            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari4c() != 0) {

                                bosUketorinin.setUktbnwari(BizNumber.valueOf(new BigDecimal(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari4c().toString())));
                            }
                        }
                    }

                    bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

                    bosUketorinin.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                    bosUketorinin.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosUketorinin);

                    uktsyurenno = uktsyurenno + 1;
                }
            }
            else {

                if (0 == ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbukthksuninzuuc()
                    && (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())
                        || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktknnm())
                        || !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktkjnm())
                        || !"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn())
                        || !"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktseiymdc())
                        )) {

                    HT_BosUketorinin bosUketorinin = bosKihonEntity.createBosUketorinin();

                    bosUketorinin.setUktsyukbn(C_UktsyuKbn.SBUKT);

                    bosUketorinin.setUktsyurenno(uktsyurenno);

                    bosUketorinin.setUktkbn(editSeihoWebRenkeiKoumoku.uktkbnHenkan(
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktknnm()));

                    if(!C_UmuKbn.ARI.eq(sbuktnmkn1ErrUmu)){

                        if (!"1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                            bosUketorinin.setUktnmkn(editSeihoWebRenkeiKoumoku.uktknnmSyutoku(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktknnm()));
                        }
                    }

                    if(!C_UmuKbn.ARI.eq(sbuktnmkj1ErrUmu)){

                        if (!"1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                            bosUketorinin.setUktnmkj(editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktkjnm()));
                        }
                    }

                    if ("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                        bosUketorinin.setUkttdk(C_Tdk.BLNK);
                    }
                    else {

                        bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.ukttdkSyutoku(
                            ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                            ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn()));
                    }

                    if (!C_UmuKbn.ARI.eq(sbuktseiymd1ErrUmu)) {

                        if (!"1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn())) {

                            String uktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktnrkkbn(),
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbukttdkkbn(),
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebplsbuktseiymdc());

                            if (!BizUtil.isBlank(uktseiymd)) {

                                bosUketorinin.setUktseiymd(BizDate.valueOf(uktseiymd));
                            }
                        }
                    }

                    if (1 == bosKihonEntity.getSbuktnin()) {
                        bosUketorinin.setUktbnwari(BizNumber.valueOf(100));
                    }
                    else {
                        if (!C_UmuKbn.ARI.eq(sbuktbnwari1ErrUmu)) {

                            if (ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari1c() != 0) {

                                bosUketorinin.setUktbnwari(BizNumber.valueOf(new BigDecimal(
                                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebsbuktbnwari1c().toString())));
                            }
                        }
                    }

                    bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

                    bosUketorinin.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                    bosUketorinin.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosUketorinin);

                    uktsyurenno = uktsyurenno + 1;
                }
            }

            if("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrtkkanouhyj())) {

                if("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtkkbn()) ||
                    "3".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtkkbn())) {

                    HT_BosUketorinin  bosUketorinin = bosKihonEntity.createBosUketorinin();

                    bosUketorinin.setUktsyukbn(C_UktsyuKbn.STDRSK);

                    bosUketorinin.setUktsyurenno(1);

                    bosUketorinin.setUktbnwari(BizNumber.valueOf(100));

                    if("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrnrkkbn())) {

                        bosUketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU1);

                        bosUketorinin.setUkttdk(C_Tdk.BLNK);
                    }

                    else if("2".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrnrkkbn())) {

                        bosUketorinin.setUktkbn(C_UktKbn.TOUROKUKAZOKU2);

                        bosUketorinin.setUkttdk(C_Tdk.BLNK);
                    }

                    else if("3".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrnrkkbn())) {

                        bosUketorinin.setUktkbn(C_UktKbn.KYK);

                        bosUketorinin.setUkttdk(C_Tdk.BLNK);
                    }

                    else if("4".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrnrkkbn())) {

                        bosUketorinin.setUktkbn(C_UktKbn.SBUK);

                        bosUketorinin.setUkttdk(C_Tdk.BLNK);
                    }

                    else if("5".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrnrkkbn())) {

                        if("0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrtdkkbn())) {

                            bosUketorinin.setUktkbn(C_UktKbn.KYK);

                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }

                        else if("7".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrtdkkbn())) {

                            bosUketorinin.setUktkbn(C_UktKbn.SBUK);

                            bosUketorinin.setUkttdk(C_Tdk.BLNK);
                        }

                        else {

                            bosUketorinin.setUktkbn(C_UktKbn.TOKUTEIMEIGI);

                            bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.hhkdrtdkkbnHenkan(
                                ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrtdkkbn()));

                            if(!C_UmuKbn.ARI.eq(hhkdrnmknErrUmu)) {

                                bosUketorinin.setUktnmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrknnm());
                            }

                            if(!C_UmuKbn.ARI.eq(hhkdrnmkjErrUmu)) {

                                bosUketorinin.setUktnmkj(hhkndrkjnm);
                            }

                            if(!C_UmuKbn.ARI.eq(hhkdrseiymdErrUmu)) {

                                if(!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrseiymdc())) {

                                    bosUketorinin.setUktseiymd(BizDate.valueOf
                                        (ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkndrseiymdc()));
                                }
                            }
                        }
                    }

                    bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

                    bosUketorinin.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                    bosUketorinin.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosUketorinin);
                }
            }

            if("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykdrtkkanouhyj())) {

                if("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtkkbn()) ||
                    "2".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdrtkkbn())) {

                    HT_BosUketorinin  bosUketorinin = bosKihonEntity.createBosUketorinin();

                    bosUketorinin.setUktsyukbn(C_UktsyuKbn.KYKDRN);

                    bosUketorinin.setUktsyurenno(1);

                    bosUketorinin.setUktkbn(editSeihoWebRenkeiKoumoku.kykdruktkbnHenkan(
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebkykdrnrkkbn()));

                    bosUketorinin.setUktbnwari(BizNumber.valueOf(100));

                    bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);

                    bosUketorinin.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                    bosUketorinin.setGyoumuKousinTime(gyoumuKousinTime);

                    BizPropertyInitializer.initialize(bosUketorinin);

                }
            }

            if (!"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktnrkkbn()) ||
                !"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkukttdkkbn()) ||
                !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktknnm()) ||
                !BizUtil.isBlank(mnkUktKjnm) ||
                !"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktseiymdc())) {

                HT_BosUketorinin  bosUketorinin = bosKihonEntity.createBosUketorinin();

                bosUketorinin.setUktsyukbn(C_UktsyuKbn.NKUKT);

                bosUketorinin.setUktsyurenno(1);

                bosUketorinin.setUktkbn(editSeihoWebRenkeiKoumoku.uktkbnHenkan(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktnrkkbn(),
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkukttdkkbn(),
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktknnm()));

                if (!C_UmuKbn.ARI.eq(nenkinuktnmkanaErrUmu)) {

                    bosUketorinin.setUktnmkn(editSeihoWebRenkeiKoumoku.uktknnmSyutoku(
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktnrkkbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkukttdkkbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktknnm()));
                }

                if (!C_UmuKbn.ARI.eq(nenkinuktnmkanjiErrUmu)) {

                    bosUketorinin.setUktnmkj(editSeihoWebRenkeiKoumoku.uktnmkjSyutoku(
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktnrkkbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkukttdkkbn(),
                        mnkUktKjnm));
                }

                bosUketorinin.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);


                bosUketorinin.setUkttdk(editSeihoWebRenkeiKoumoku.ukttdkSyutoku(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktnrkkbn(),
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkukttdkkbn()));

                bosUketorinin.setUktbnwari(BizNumber.valueOf(100));

                if (!C_UmuKbn.ARI.eq(nenkinuktseiymdErrUmu)) {

                    String uktseiymd = editSeihoWebRenkeiKoumoku.uktseiymdSyutoku(
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktnrkkbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkukttdkkbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebmnkuktseiymdc());

                    if (!BizUtil.isBlank(uktseiymd)) {

                        bosUketorinin.setUktseiymd(BizDate.valueOf(uktseiymd));
                    }
                }

                bosUketorinin.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                bosUketorinin.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(bosUketorinin);
            }

            HT_BosSyouhn bosSyouhn = bosKihonEntity.createBosSyouhn();

            bosSyouhn.setSyouhncd(syouhnZokusei.getSyouhncd());

            bosSyouhn.setSyutkkbn(C_SyutkKbn.SYU);

            bosSyouhn.setSknenkinsyu(editSeihoWebRenkeiKoumoku.sknenkinsyuHenkan(
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebnksyuruikbn()));

            if (C_UmuKbn.NONE.eq(syouhnZokusei.getHokenkngkyakujyouumu())) {
                HenkanTuuka HhenkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                bosSyouhn.setKihons(BizCurrency.valueOf(0,
                    HhenkanTuuka.henkanTuukaKbnToType(bosKihonEntity.getKyktuukasyu())));

            }
            else {
                if (!C_UmuKbn.ARI.eq(syukihonsErrUmu)) {

                    bosSyouhn.setKihons(editSeihoWebRenkeiKoumoku.kihonsSyutoku(
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebsiteituukakbn(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebkihonsc(),
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebgaikakihonsc()));
                }
            }

            if (!C_UmuKbn.ARI.eq(mossyukykpValidateErrUmu)) {
                bosSyouhn.setHrktuukasyutkp(editSeihoWebRenkeiKoumoku.mossyukykpSyutoku(
                    mosTuukasyukbn, hrktuukasyutkP, gkHrktuukasyutkP));
            }

            bosSyouhn.setKatakbn(C_KataKbn.BLNK);

            bosSyouhn.setKyhkatakbn(C_KyhgndkataKbn.BLNK);

            bosSyouhn.setSyukyhkinkatakbn(C_SyukyhkinkataKbn.BLNK);

            bosSyouhn.setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn.BLNK);

            bosSyouhn.setRokudaildkbn(C_6daiLdKbn.BLNK);

            if (!C_UmuKbn.ARI.eq(hknkknErrUmu)) {

                bosSyouhn.setHknkkn(hknkkn);
            }

            if (!C_UmuKbn.ARI.eq(hrkkknErrUmu)) {

                bosSyouhn.setHrkkkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebphrkkiknc());
            }

            bosSyouhn.setHknkknsmnkbn(
                C_HknkknsmnKbn.valueOf(editSeihoWebRendouKoumoku(mosno, "保険期間歳満期区分 ",
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebsaimankihyj(), C_HknkknsmnKbn.class)));

            bosSyouhn.setHrkkknsmnkbn(editSeihoWebRenkeiKoumoku.hrkkknsmnkbnSyutoku(
                hknsyuruino,
                ztSmbcPaperlessMosTrTblParam.getZtrseihowebphrkkiknc()));

            if (!C_UmuKbn.ARI.eq(syudai1hknkknErrUmu)) {

                bosSyouhn.setDai1hknkkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdai1hknkknc());
            }

            bosSyouhn.setGyoumuKousinsyaId(gyoumuKousinsyaId);

            bosSyouhn.setGyoumuKousinTime(gyoumuKousinTime);

            BizPropertyInitializer.initialize(bosSyouhn);

            HT_BosDairiten bosDairiten = bosKihonEntity.createBosDairiten();

            bosDairiten.setRenno(bosDairitenrenno);

            if (!C_UmuKbn.ARI.eq(dairitenkinyuukikancd1ErrUmu)) {

                bosDairiten.setKinyuucd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebaatkisyaknyuucd());
            }

            if (!C_UmuKbn.ARI.eq(dairitenkinyuukikansitencd1ErrUmu)) {

                bosDairiten.setKinyuusitencd(sakuseijisitencd);
            }

            if (!C_UmuKbn.ARI.eq(bosyuunintourokuno1ErrUmu)) {

                bosDairiten.setBosyuutrkno(bosyuuninTourokuNo1);
            }

            if (!C_UmuKbn.ARI.eq(cifcdErrUmu)) {

                bosDairiten.setCifcd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebankenkanrino());
            }

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkydbosyuukjncd())) {

                bosDairiten.setBunwari(BizNumber.valueOf(0));
            }
            else {

                bosDairiten.setBunwari(BizNumber.valueOf(100));
            }

            bosDairiten.setGyoumuKousinsyaId(gyoumuKousinsyaId);

            bosDairiten.setGyoumuKousinTime(gyoumuKousinTime);

            BizPropertyInitializer.initialize(bosDairiten);

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkydbosyuukjncd())) {
                HT_BosDairiten bosDairitenKydbosyuu = bosKihonEntity.createBosDairiten();

                bosDairitenKydbosyuu.setRenno(bosDairitenrenno + 1);

                if (!C_UmuKbn.ARI.eq(inputbosyuucd2ErrUmu)) {

                    bosDairitenKydbosyuu.setInputbosyuucd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkydbosyuukjncd());
                }

                bosDairitenKydbosyuu.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                bosDairitenKydbosyuu.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(bosDairitenKydbosyuu);
            }

            if ("2".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhjkktkbn())
                && C_UmuKbn.ARI.eq(syouhnZokusei.getKktumu())) {

                HT_BosKokutisyo bosKokutisyo = bosKihonEntity.createBosKokutisyo();

                if (!C_UmuKbn.ARI.eq(kktymdErrUmu)) {

                    if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkktymdc())) {

                        bosKokutisyo.setKktymd(BizDate.valueOf(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkktymdc()));
                    }
                }

                if (!C_UmuKbn.ARI.eq(sintyouErrUmu)) {

                    if (0 != ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknsintyouc()) {

                        bosKokutisyo.setSintyou(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhknsintyouc());
                    }
                }

                if (!C_UmuKbn.ARI.eq(taijyuuErrUmu)) {

                    if (0 != ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkntaijyuuc()) {

                        bosKokutisyo.setTaijyuu(ztSmbcPaperlessMosTrTblParam.getZtrseihowebhhkntaijyuuc());
                    }
                }

                bosKokutisyo.setKituenkbn(C_KituenKbn.BLNK);

                bosKokutisyo.setKijikbn(C_KijiKbn.NONE);

                bosKokutisyo.setKzkkijikbn(C_KzkkijiKbn.BLNK);

                bosKokutisyo.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                bosKokutisyo.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(bosKokutisyo);
            }

            if (!BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsknkzmeigi()) ||
                !"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskzsyuruikbn()) ||
                !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskinyuucd()) ||
                !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdssitencd()) ||
                !"0".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsyokinkbn()) ||
                !BizUtil.isBlank(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskouzano())) {

                HT_BosUketoriKouzaJyouhou bosUketoriKouzaJyouhou = bosKihonEntity.createBosUketoriKouzaJyouhou();

                bosUketoriKouzaJyouhou.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.DSSOUKINYOUKOUZA);

                bosUketoriKouzaJyouhou.setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn.BLNK);

                bosUketoriKouzaJyouhou.setKzsyuruikbn(editSeihoWebRenkeiKoumoku.kouzasyuruiKbnHenkan(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskzsyuruikbn()));

                if (!C_UmuKbn.ARI.eq(dsbankcdErrUmu)) {

                    bosUketoriKouzaJyouhou.setBankcd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskinyuucd());
                }

                if (!C_UmuKbn.ARI.eq(dssitencdErrUmu)) {

                    bosUketoriKouzaJyouhou.setSitencd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdssitencd());
                }

                bosUketoriKouzaJyouhou.setYokinkbn(editSeihoWebRenkeiKoumoku.yokinKbnHenkan(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsyokinkbn()));

                bosUketoriKouzaJyouhou.setKzkykdoukbn(C_KzkykdouKbn.BLNK);

                if (!C_UmuKbn.ARI.eq(dskouzanoErrUmu)) {

                    bosUketoriKouzaJyouhou.setKouzano(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdskouzano());
                }

                if (!C_UmuKbn.ARI.eq(dskzmeiginmknErrUmu)) {

                    bosUketoriKouzaJyouhou.setKzmeiginmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebdsknkzmeigi());
                }

                bosUketoriKouzaJyouhou.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                bosUketoriKouzaJyouhou.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(bosUketoriKouzaJyouhou);
            }

            if (C_Hrkkeiro.KOUHURI.eq(bosKihonEntity.getHrkkeiro())) {

                HT_BosKouzaJyouhou bosKouzaJyouhou = bosKihonEntity.createBosKouzaJyouhou();

                C_KzhuritourokuhouKbn kzhuritourokuhouKbn = editSeihoWebRenkeiKoumoku.kzhuritourokuhoukbnHenkan(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebplhrkkeirokbn(),
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebkuhrshmnttdkhyj(),
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebnetkhrzmhyj());

                if(C_KzhuritourokuhouKbn.PPLESS.eq(kzhuritourokuhouKbn)) {

                    bosKouzaJyouhou.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);

                    if (!C_UmuKbn.ARI.eq(dairitenkinyuukikancd1ErrUmu)) {

                        bosKouzaJyouhou.setBankcd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebaatkisyaknyuucd());
                    }

                    if (!C_UmuKbn.ARI.eq(kouhurikouzainfositencdErrUmu)) {

                        bosKouzaJyouhou.setSitencd(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkouhurisitencd());
                    }

                    bosKouzaJyouhou.setYokinkbn(
                        editSeihoWebRenkeiKoumoku.yokinKbnHenkan(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkouhuriyokinkbn()));

                    if (!C_UmuKbn.ARI.eq(kouhurikouzainfokouzanoErrUmu)) {

                        bosKouzaJyouhou.setKouzano(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkouhurikouzano());
                    }

                    bosKouzaJyouhou.setKouzakakuniniraikbn(C_YouhiblnkKbn.HUYOU);
                    bosKouzaJyouhou.setKzhuritourokuhoukbn(kzhuritourokuhouKbn);
                }

                else {

                    bosKouzaJyouhou.setKzhuritourokuhoukbn(kzhuritourokuhouKbn);
                }

                bosKouzaJyouhou.setGyoumuKousinsyaId(gyoumuKousinsyaId);
                bosKouzaJyouhou.setGyoumuKousinTime(gyoumuKousinTime);
                BizPropertyInitializer.initialize(bosKouzaJyouhou);
            }

            if (C_UmuKbn.ARI.eq(validationErrUmu)) {

                int renno = 1;

                for (ConstraintViolation<SkSeihoWebBosKoumokuCheckBean> chkKekka : chkKekkaSet) {
                    HT_BosKoumokuCheckError bosKoumokuCheckError = bosKihonEntity.createBosKoumokuCheckError();

                    bosKoumokuCheckError.setRenno3keta(renno++);
                    bosKoumokuCheckError.setErrorkm(chkKekka.getPropertyPath().toString());
                    bosKoumokuCheckError.setGyoumuKousinTime(gyoumuKousinTime);
                }
            }

            if("1".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzktrkmoskbn())) {

                HT_BosTrkKzk bosTrkKzk = bosKihonEntity.createBosTrkKzk();

                bosTrkKzk.setTrkkzkkbn(C_TrkKzkKbn.TRKKZK1);

                if(!C_UmuKbn.ARI.eq(trkkzknmkn1ErrUmu)) {

                    bosTrkKzk.setTrkkzknmkn(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkknnm1());
                }

                if(!C_UmuKbn.ARI.eq(trkkzknmkj1ErrUmu)) {

                    bosTrkKzk.setTrkkzknmkj(kzkkjnm1);
                }

                bosTrkKzk.setTrkkzknmkjkhukakbn(C_KjkhukaKbn.BLNK);

                if(!C_UmuKbn.ARI.eq(trkkzkseiymd1ErrUmu)) {

                    if (!"00000000".equals(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkseiymd1c())) {

                        bosTrkKzk.setTrkkzkseiymd(BizDate.valueOf
                            (ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkseiymd1c()));
                    }
                }

                bosTrkKzk.setTrkkzksei(editSeihoWebRenkeiKoumoku.kzkSeibetuHenkan(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkseikbn1()));

                bosTrkKzk.setTrkkzktdk(editSeihoWebRenkeiKoumoku.kzktdkkbnHenkan(
                    ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzktdkkbn1()));

                bosTrkKzk.setTrkkzktsindousiteikbn(C_TsindousiteiKbn.BLNK);

                if(!C_UmuKbn.ARI.eq(trkkzkyno1ErrUmu)) {

                    bosTrkKzk.setTrkkzkyno(editSeihoWebRenkeiKoumoku.postalCdSyutoku(
                        ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzkyno1()));
                }

                if(!C_UmuKbn.ARI.eq(trkkzkadr1kj1ErrUmu) &&
                    !C_UmuKbn.ARI.eq(trkkzkadr2kj1ErrUmu) &&
                    !C_UmuKbn.ARI.eq(trkkzkadr3kj1ErrUmu)) {

                    bosTrkKzk.setTrkkzkadr1kj(editSeihoWebRenkeiKoumoku.adr1Syutoku(kzkadr1));
                    bosTrkKzk.setTrkkzkadr2kj(editSeihoWebRenkeiKoumoku.adr2Syutoku(kzkadr1));
                    bosTrkKzk.setTrkkzkadr3kj(editSeihoWebRenkeiKoumoku.adr3Syutoku(kzkadr1));
                }

                if(!C_UmuKbn.ARI.eq(trkkzktelno1ErrUmu)) {

                    bosTrkKzk.setTrkkzktelno(ztSmbcPaperlessMosTrTblParam.getZtrseihowebkzktelno1());
                }

                bosTrkKzk.setGyoumuKousinsyaId(gyoumuKousinsyaId);

                bosTrkKzk.setGyoumuKousinTime(gyoumuKousinTime);

                BizPropertyInitializer.initialize(bosTrkKzk);
            }

            if (C_UmuKbn.ARI.eq(bosInfoUm)) {

                CopyHT_BosKihon copyBosKihon = new CopyHT_BosKihon();
                BeanUtil.copyProperties(copyBosKihon, bosKihonEntity);
                BeanUtil.copyProperties(bosKihonUpd, copyBosKihon);

                BizEntityUtil.exchange(bosKihonUpd.getBosUketorinins(), bosKihonEntity.getBosUketorinins());

                BizEntityUtil.exchange(bosKihonUpd.getBosSyouhns(), bosKihonEntity.getBosSyouhns());

                BizEntityUtil.exchange(bosKihonUpd.getBosDairitens(), bosKihonEntity.getBosDairitens());

                BizEntityUtil.exchange(bosKihonUpd.getBosKokutisyos(), bosKihonEntity.getBosKokutisyos());

                BizEntityUtil.exchange(bosKihonUpd.getBosUketoriKouzaJyouhous(), bosKihonEntity.getBosUketoriKouzaJyouhous());

                BizEntityUtil.exchange(bosKihonUpd.getBosKouzaJyouhous(), bosKihonEntity.getBosKouzaJyouhous());

                BizEntityUtil.exchange(bosKihonUpd.getBosKoumokuCheckErrors(), bosKihonEntity.getBosKoumokuCheckErrors());

                BizEntityUtil.exchange(bosKihonUpd.getBosTrkKzks(), bosKihonEntity.getBosTrkKzks());


                pMultipleEntityUpdater.add(bosKihonUpd);
            }
            else {
                pMultipleEntityInserter.add(bosKihonEntity);
            }

            syoriOKKensuu = syoriOKKensuu + 1;
        }

        if (0 == syoriKensuu) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0003));
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syoriOKKensuu), "ペーパーレス申込情報取込ＯＫ"));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(syoriNGKensuu), "ペーパーレス申込情報取込ＮＧ"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
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
}

class CopyHT_BosKihon extends GenHT_BosKihon {
    private static final long serialVersionUID = 1L;
}


