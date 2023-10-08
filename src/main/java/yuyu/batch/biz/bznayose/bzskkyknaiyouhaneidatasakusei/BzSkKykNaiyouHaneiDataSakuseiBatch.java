package yuyu.batch.biz.bznayose.bzskkyknaiyouhaneidatasakusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.apache.commons.lang.StringUtils;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 名寄せ 新契約用契約内容反映データ作成クラス
 */
public class BzSkKykNaiyouHaneiDataSakuseiBatch implements Batch {

    private final String TJTIDOUNYSKFILTERID = "Sk001";

    private final String TJTIDOUNYSKID = "BT_TjtIdouNySk";

    private final String TUUKATYPE_YEN = "YEN";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        try (ExDBResults<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySksByKakutyoujobcdMaxRenno3keta(
            bzBatchParam.getIbKakutyoujobcd());

            EntityInserter<ZT_TjtIdouNaiyouTy> tjtIdouNaiyouTyInserter = new EntityInserter<>()) {
            long syoriKensuu = 0;

            for (BT_TjtIdouNySk tjtIdouNySk : tjtIdouNySkLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TJTIDOUNYSKID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(TJTIDOUNYSKFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(tjtIdouNySk.getMosno());

                ZT_TjtIdouNaiyouTy tjtIdouNaiyouTy = new ZT_TjtIdouNaiyouTy();

                BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();

                BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();

                tjtIdouNaiyouTy.setZtyhuho2kyknokbn(C_Huho2kyknoKbn.MOSNO.getValue());
                tjtIdouNaiyouTy.setZtyhuho2kykno(tjtIdouNySk.getMosno());
                tjtIdouNaiyouTy.setZtyrecordsakujyohyouji(tjtIdouNySk.getRecordsakujyohyouji().toString());
                tjtIdouNaiyouTy.setZtysksyouhncd(tjtIdouNySk.getSyouhncd());

                if (tjtIdouNySk.getMosymd() != null) {

                    tjtIdouNaiyouTy.setZtyskmosymd(String.valueOf(tjtIdouNySk.getMosymd()));
                }
                if (tjtIdouNySk.getKykymd() != null) {

                    tjtIdouNaiyouTy.setZtyskkykymd(String.valueOf(tjtIdouNySk.getKykymd()));
                }
                if (tjtIdouNySk.getSknnkaisiymd() != null) {

                    tjtIdouNaiyouTy.setZtysksknnkaisiymd(String.valueOf(tjtIdouNySk.getSknnkaisiymd()));
                }
                if (C_SeirituKbn.BLNK.eq(tjtIdouNySk.getSeiritukbn())) {

                    tjtIdouNaiyouTy.setZtyskseiritukbn("");
                }
                else {

                    tjtIdouNaiyouTy.setZtyskseiritukbn(tjtIdouNySk.getSeiritukbn().getValue());
                }
                if (tjtIdouNySk.getSrsyoriymd() != null) {

                    tjtIdouNaiyouTy.setZtysksrsyoriymd(String.valueOf(tjtIdouNySk.getSrsyoriymd()));
                }
                tjtIdouNaiyouTy.setZtyskmfrenflg(tjtIdouNySk.getMfrenflg().getValue());
                tjtIdouNaiyouTy.setZtysksyono(tjtIdouNySk.getSyono());

                if (C_Tuukasyu.BLNK.eq(tjtIdouNySk.getTsntuukasyu())) {

                    tjtIdouNaiyouTy.setZtysktsntuukasyu("");
                }
                else {

                    tjtIdouNaiyouTy.setZtysktsntuukasyu(tjtIdouNySk.getTsntuukasyu().getValue());
                }
                tjtIdouNaiyouTy.setZtysktsnyousibous(tuukaTypebetuhenkan(tjtIdouNySk.getTsnyousibous()));
                tjtIdouNaiyouTy.setZtysktsnyouitijip(tuukaTypebetuhenkan(tjtIdouNySk.getTsnyouitijip()));
                tjtIdouNaiyouTy.setZtysktsnyounkgns(tuukaTypebetuhenkan(tjtIdouNySk.getTsnyounkgns()));
                tjtIdouNaiyouTy.setZtyskhrkkkn(Strings.padStart(tjtIdouNySk.getHrkkkn().toString(), 2, '0'));
                if (C_SntkhouKbn.BLNK.eq(tjtIdouNySk.getSntkhoukbn())) {

                    tjtIdouNaiyouTy.setZtysksntkhoukbn("");
                }
                else {
                    tjtIdouNaiyouTy.setZtysksntkhoukbn(Strings.padStart(
                        tjtIdouNySk.getSntkhoukbn().getValue(), 2, '0'));
                }
                if (tjtIdouNySk.getBosyuuym() != null) {

                    tjtIdouNaiyouTy.setZtyskbosyuuym(String.valueOf(tjtIdouNySk.getBosyuuym()));
                }
                tjtIdouNaiyouTy.setZtyskkykhhkndouhyouji(tjtIdouNySk.getKykhhkndouhyouji().toString());

                tjtIdouNaiyouTy.setZtysksyouhnsdno(
                    Strings.padStart(String.valueOf(tjtIdouNySk.getSyouhnsdno()), 2, '0'));

                tjtIdouNaiyouTy.setZtyskkaigomaehrtkykarihyj(tjtIdouNySk.getKaigomaehrtkykumukbn().getValue());

                tjtIdouNaiyouTy.setZtyskpyennykntkykarihyj(tjtIdouNySk.getPyennykntkykumukbn().getValue());

                tjtIdouNaiyouTy.setZtysktsnyennyknkgk(tuukaTypebetuhenkan(tjtIdouNySk.getTsnyennyknkgk()));

                if (C_MossyoumetuKbn.BLNK.eq(tjtIdouNySk.getMossyoumetukbn())) {

                    tjtIdouNaiyouTy.setZtyskmossyoumetukbn("");
                }
                else {

                    tjtIdouNaiyouTy.setZtyskmossyoumetukbn(tjtIdouNySk.getMossyoumetukbn().getValue());
                }

                if (C_Hrkkeiro.BLNK.eq(tjtIdouNySk.getHrkkeiro())) {

                    tjtIdouNaiyouTy.setZtyskhrkkeirokbn("");
                }
                else if (C_Hrkkeiro.SYUUDAN.eq(tjtIdouNySk.getHrkkeiro())) {

                    tjtIdouNaiyouTy.setZtyskhrkkeirokbn(C_Hrkkeiro.CREDIT.getValue());

                }
                else {

                    tjtIdouNaiyouTy.setZtyskhrkkeirokbn(tjtIdouNySk.getHrkkeiro().getValue());
                }

                tjtIdouNaiyouTy.setZtyhhknmei(idouSkMeigi.getHhknnmkn());
                tjtIdouNaiyouTy.setZtyknjhhknmei(idouSkMeigi.getHhknnmkj());
                if (idouSkMeigi.getHhknseiymd() != null) {

                    tjtIdouNaiyouTy.setZtyhhknseiymd(String.valueOf(idouSkMeigi.getHhknseiymd()));
                }

                tjtIdouNaiyouTy.setZtyhhknseikbn(idouSkMeigi.getHhknsei().getValue());
                tjtIdouNaiyouTy.setZtyhhknnewyno(idouSkMeigi.getHhknyno());
                tjtIdouNaiyouTy.setZtyhhknadr(
                    StringUtils.defaultString(idouSkMeigi.getHhknadr1kj()).concat(
                        StringUtils.defaultString(idouSkMeigi.getHhknadr2kj())).concat(
                            StringUtils.defaultString(idouSkMeigi.getHhknadr3kj())));
                tjtIdouNaiyouTy.setZtyhhkntelno(idouSkMeigi.getHhkntelno());
                tjtIdouNaiyouTy.setZtyhhknsykgycd(idouSkMeigi.getHhknsykgycd());
                tjtIdouNaiyouTy.setZtykyknm(idouSkMeigi.getKyknmkn());
                tjtIdouNaiyouTy.setZtykjkyknm(idouSkMeigi.getKyknmkj());
                if (idouSkMeigi.getKykseiymd() != null) {

                    tjtIdouNaiyouTy.setZtykyksyaseiymd(String.valueOf(idouSkMeigi.getKykseiymd()));
                }
                tjtIdouNaiyouTy.setZtynkuktnm(idouSkMeigi.getNenkinuktnmkana());
                tjtIdouNaiyouTy.setZtykjnkuktnm(idouSkMeigi.getNenkinuktnmkanji());
                if (idouSkMeigi.getNenkinuktseiymd() != null) {

                    tjtIdouNaiyouTy.setZtynenkinuktseiymd(String.valueOf(idouSkMeigi.getNenkinuktseiymd()));
                }

                tjtIdouNaiyouTy.setZtytsnsknewyno(idouSkMeigi.getTsinyno());

                tjtIdouNaiyouTy.setZtytsinadr(
                    StringUtils.defaultString(idouSkMeigi.getTsinadr1kj()).concat(
                        StringUtils.defaultString(idouSkMeigi.getTsinadr2kj())).concat(
                            StringUtils.defaultString(idouSkMeigi.getTsinadr3kj())));
                tjtIdouNaiyouTy.setZtytsintelno(idouSkMeigi.getTsintelno());
                tjtIdouNaiyouTy.setZtysbuktnm1(idouSkMeigi.getSbuktnmkn1());
                tjtIdouNaiyouTy.setZtykjsbuktnm1(idouSkMeigi.getSbuktnmkj1());
                tjtIdouNaiyouTy.setZtysbuktnm2(idouSkMeigi.getSbuktnmkn2());
                tjtIdouNaiyouTy.setZtykjsbuktnm2(idouSkMeigi.getSbuktnmkj2());
                tjtIdouNaiyouTy.setZtysbuktnm3(idouSkMeigi.getSbuktnmkn3());
                tjtIdouNaiyouTy.setZtykjsbuktnm3(idouSkMeigi.getSbuktnmkj3());
                tjtIdouNaiyouTy.setZtysbuktnm4(idouSkMeigi.getSbuktnmkn4());
                tjtIdouNaiyouTy.setZtykjsbuktnm4(idouSkMeigi.getSbuktnmkj4());
                tjtIdouNaiyouTy.setZtystdrsknm(idouSkMeigi.getStdrsknmkn());
                tjtIdouNaiyouTy.setZtykjstdrsknm(idouSkMeigi.getStdrsknmkj());
                tjtIdouNaiyouTy.setZtykykdairinm(idouSkMeigi.getKykdairinmkn());
                tjtIdouNaiyouTy.setZtykjkykdairinm(idouSkMeigi.getKykdairinmkj());
                if (!Strings.isNullOrEmpty(idouSkMeigi.getBankcd())) {
                    if (idouSkMeigi.getBankcd().length() < 4) {

                        tjtIdouNaiyouTy.setZtybankcd(Strings.padStart(idouSkMeigi.getBankcd(), 4, '0'));
                    }
                    else {
                        tjtIdouNaiyouTy.setZtybankcd(idouSkMeigi.getBankcd());
                    }

                }
                else {

                    tjtIdouNaiyouTy.setZtybankcd(idouSkMeigi.getBankcd());
                }

                if (!Strings.isNullOrEmpty(idouSkMeigi.getSitencd())) {
                    if (idouSkMeigi.getSitencd().length() < 3) {

                        tjtIdouNaiyouTy.setZtyshitencd(Strings.padStart(idouSkMeigi.getSitencd(), 3, '0'));
                    }
                    else {
                        tjtIdouNaiyouTy.setZtyshitencd(idouSkMeigi.getSitencd());
                    }

                }
                else {

                    tjtIdouNaiyouTy.setZtyshitencd(idouSkMeigi.getSitencd());
                }

                if(C_YokinKbn.BLNK.eq(idouSkMeigi.getYokinkbn())){
                    tjtIdouNaiyouTy.setZtyyokinkbn("");
                }else{
                    tjtIdouNaiyouTy.setZtyyokinkbn(idouSkMeigi.getYokinkbn().getValue());
                }

                if (!Strings.isNullOrEmpty(idouSkMeigi.getKouzano())) {
                    if (idouSkMeigi.getKouzano().length() < 7) {
                        tjtIdouNaiyouTy.setZtykouzano7keta(Strings.padStart(idouSkMeigi.getKouzano(), 7, '0'));
                    }
                    else if (idouSkMeigi.getKouzano().length() > 7) {
                        tjtIdouNaiyouTy.setZtykouzano7keta(idouSkMeigi.getKouzano().substring(0, 7));
                    }
                    else {
                        tjtIdouNaiyouTy.setZtykouzano7keta(idouSkMeigi.getKouzano());
                    }
                }
                else {
                    tjtIdouNaiyouTy.setZtykouzano7keta(idouSkMeigi.getKouzano());
                }
                tjtIdouNaiyouTy.setZtykzmeiginmei(idouSkMeigi.getKzmeiginmkn());

                if(C_KzkykdouKbn.BLNK.eq(idouSkMeigi.getKzkykdoukbn())){
                    tjtIdouNaiyouTy.setZtykzkykdouhyouji("");
                }
                else {
                    if (C_KzkykdouKbn.SITEI.eq(idouSkMeigi.getKzkykdoukbn())){
                        tjtIdouNaiyouTy.setZtykzkykdouhyouji(C_KzkykdouKbn.BLNK.getValue());
                    }
                    else {
                        tjtIdouNaiyouTy.setZtykzkykdouhyouji(idouSkMeigi.getKzkykdoukbn().getValue());
                    }
                }

                tjtIdouNaiyouTy.setZtykzktourokunm1(idouSkMeigi.getKzktourokunmkn1());
                tjtIdouNaiyouTy.setZtykjkzktourokunm1(idouSkMeigi.getKzktourokunmkj1());
                tjtIdouNaiyouTy.setZtykzktourokunm2(idouSkMeigi.getKzktourokunmkn2());
                tjtIdouNaiyouTy.setZtykjkzktourokunm2(idouSkMeigi.getKzktourokunmkj2());
                tjtIdouNaiyouTy.setZtydairitencd1(idouSkBosyuudr.getDairitencd1());
                tjtIdouNaiyouTy.setZtybunwari1(Strings.padStart(idouSkBosyuudr.getBunwari1().toString(), 3, '0'));
                tjtIdouNaiyouTy.setZtydairitencd2(idouSkBosyuudr.getDairitencd2());
                tjtIdouNaiyouTy.setZtybunwari2(Strings.padStart(idouSkBosyuudr.getBunwari2().toString(), 3, '0'));
                tjtIdouNaiyouTy.setZtyaatukaisosikicd(idouSkBosyuudr.getKanrisosikicd1());
                tjtIdouNaiyouTy.setZtybatukaisosikicd(idouSkBosyuudr.getKanrisosikicd2());

                BizPropertyInitializer.initialize(tjtIdouNaiyouTy);
                tjtIdouNaiyouTyInserter.add(tjtIdouNaiyouTy);
                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
                kinou.getKinouNm()));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private String tuukaTypebetuhenkan(BizCurrency pvalue) {

        String convData = "";

        if (TUUKATYPE_YEN.equals(pvalue.getCurrencyType())) {

            convData = Strings.padStart(pvalue.toString(), 11, '0');
        }
        else {

            convData = Strings.padStart(pvalue.multiply(100).toString(), 11, '0');
        }

        if (convData.charAt(0) != '0'){
            return "09999999999";
        }

        return convData;
    }
}
