package yuyu.batch.biz.bznayose.bzkhkyknaiyouhaneidatasakusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

import org.apache.commons.lang.StringUtils;

/**
 * 業務共通 名寄せ 契約保全用契約内容反映データ作成
 */
public class BzKhKykNaiyouHaneiDataSakuseiBatch implements Batch {

    private final String SYONOFILTER = "Bz001";

    private final String TABLEID = "BT_TjtIdouNyKh";

    private final String TUUKATYPE_YEN = "YEN";

    private final String ZERO_2KETA = "00";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean recoveryBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        long syoriKensuu = 0;

        try (ExDBResults<BT_TjtIdouNyKh> tjtIdouNyKhLst =
            bizDomManager.getTjtIdouNyKhsByKakutyoujobcdMaxRenno3keta(bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<ZT_TjtIdouNaiyouTy> tjtIdouNaiyouTyLst = new EntityInserter<ZT_TjtIdouNaiyouTy>();) {
            for (BT_TjtIdouNyKh tjtIdouNyKh : tjtIdouNyKhLst) {
                recoveryBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                recoveryBean.setIbTableid(TABLEID);
                recoveryBean.setIbRecoveryfilterid(SYONOFILTER);
                recoveryBean.setIbRecoveryfilterkey1(tjtIdouNyKh.getSyono());

                BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();

                BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();

                ZT_TjtIdouNaiyouTy tjtIdouNaiyouTy = new ZT_TjtIdouNaiyouTy();
                tjtIdouNaiyouTy.setZtyhuho2kyknokbn(C_Huho2kyknoKbn.SYONO.getValue());
                tjtIdouNaiyouTy.setZtyhuho2kykno(tjtIdouNyKh.getSyono());
                tjtIdouNaiyouTy.setZtyrecordsakujyohyouji(tjtIdouNyKh.getRecordsakujyohyouji().toString());
                tjtIdouNaiyouTy.setZtykhsyouhncd(tjtIdouNyKh.getSyouhncd());

                if (tjtIdouNyKh.getKykjyoutai().eq(C_Kykjyoutai.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhkykjyoutai("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhkykjyoutai(
                        Strings.padStart(tjtIdouNyKh.getKykjyoutai().getValue(), 2, '0'));
                }

                if (tjtIdouNyKh.getKykymd() != null) {
                    tjtIdouNaiyouTy.setZtykhkykymd(String.valueOf(tjtIdouNyKh.getKykymd()));
                }

                if (tjtIdouNyKh.getYuukousyoumetukbn().eq(C_YuukousyoumetuKbn.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhyuukousyoumetukbn("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhyuukousyoumetukbn(tjtIdouNyKh.getYuukousyoumetukbn().getValue());
                }

                if (tjtIdouNyKh.getSyoumetujiyuu().eq(C_Syoumetujiyuu.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhsyoumetujiyuu(ZERO_2KETA);
                }
                else {
                    tjtIdouNaiyouTy.setZtykhsyoumetujiyuu(tjtIdouNyKh.getSyoumetujiyuu().getValue());
                }

                if (tjtIdouNyKh.getSyoumetuymd() != null) {
                    tjtIdouNaiyouTy.setZtykhsyoumetuymd(String.valueOf(tjtIdouNyKh.getSyoumetuymd()));
                }

                if (C_Tuukasyu.BLNK.eq(tjtIdouNyKh.getTsntuukasyu())) {
                    tjtIdouNaiyouTy.setZtykhtsntuukasyu("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhtsntuukasyu(tjtIdouNyKh.getTsntuukasyu().getValue());
                }

                tjtIdouNaiyouTy.setZtykhtsnyousibous(tuukaTypebetuhenkan(tjtIdouNyKh.getTsnyousibous()));
                tjtIdouNaiyouTy.setZtykhtsnyouitijip(tuukaTypebetuhenkan(tjtIdouNyKh.getTsnyouitijip()));
                tjtIdouNaiyouTy.setZtykhtsnyounkgns(tuukaTypebetuhenkan(tjtIdouNyKh.getTsnyounkgns()));
                tjtIdouNaiyouTy.setZtykhhrkkkn(Strings.padStart(tjtIdouNyKh.getHrkkkn().toString(), 2, '0'));

                if (tjtIdouNyKh.getSntkhoukbn().eq(C_SntkhouKbn.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhsntkhoukbn("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhsntkhoukbn(
                        Strings.padStart(tjtIdouNyKh.getSntkhoukbn().getValue(), 2, '0'));
                }

                if (tjtIdouNyKh.getBosyuuym() != null) {
                    tjtIdouNaiyouTy.setZtykhbosyuuym(String.valueOf(tjtIdouNyKh.getBosyuuym()));
                }

                tjtIdouNaiyouTy.setZtykhkykhhkndouhyouji(tjtIdouNyKh.getKykhhkndouhyouji().toString());

                if (tjtIdouNyKh.getTtdktyuuikbn1().eq(C_TtdktyuuiKbn.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn1("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn1(tjtIdouNyKh.getTtdktyuuikbn1().getValue());
                }

                if (tjtIdouNyKh.getTtdktyuuikbn2().eq(C_TtdktyuuiKbn.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn2("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn2(tjtIdouNyKh.getTtdktyuuikbn2().getValue());
                }

                if (tjtIdouNyKh.getTtdktyuuikbn3().eq(C_TtdktyuuiKbn.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn3("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn3(tjtIdouNyKh.getTtdktyuuikbn3().getValue());
                }

                if (tjtIdouNyKh.getTtdktyuuikbn4().eq(C_TtdktyuuiKbn.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn4("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn4(tjtIdouNyKh.getTtdktyuuikbn4().getValue());
                }

                if (tjtIdouNyKh.getTtdktyuuikbn5().eq(C_TtdktyuuiKbn.BLNK)) {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn5("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhttdktyuuikbn5(tjtIdouNyKh.getTtdktyuuikbn5().getValue());
                }

                tjtIdouNaiyouTy.setZtykhsyouhnsdno(
                    Strings.padStart(String.valueOf(tjtIdouNyKh.getSyouhnsdno()), 2, '0'));

                tjtIdouNaiyouTy.setZtykhkaigomaehrtkykarihyj(tjtIdouNyKh.getKaigomaehrtkykumukbn().getValue());

                tjtIdouNaiyouTy.setZtykhpyennykntkykarihyj(tjtIdouNyKh.getPyennykntkykumukbn().getValue());

                tjtIdouNaiyouTy.setZtykhtsnyennyknkgk(tuukaTypebetuhenkan(tjtIdouNyKh.getTsnyennyknkgk()));

                tjtIdouNaiyouTy.setZtykhskmosno(tjtIdouNyKh.getSkjmosno());

                tjtIdouNaiyouTy.setZtykhhouteityotksyhnhyj(tjtIdouNyKh.getHouteityotkseisyouhnhyj().getValue());

                if (tjtIdouNyKh.getSeiritujitrhkjikakkbn().eq(C_TrhkjiKakKbn.BLNK)) {

                    tjtIdouNaiyouTy.setZtykhseiritujitrhkjikakkbn("");
                }
                else {
                    tjtIdouNaiyouTy.setZtykhseiritujitrhkjikakkbn(tjtIdouNyKh.getSeiritujitrhkjikakkbn().getValue());
                }
                if (C_Hrkkeiro.BLNK.eq(tjtIdouNyKh.getHrkkeiro())) {
                    tjtIdouNaiyouTy.setZtykhhrkkeirokbn("");
                }
                else if(C_Hrkkeiro.SYUUDAN.eq(tjtIdouNyKh.getHrkkeiro())){
                    tjtIdouNaiyouTy.setZtykhhrkkeirokbn(C_Hrkkeiro.CREDIT.getValue());
                }
                else {
                    tjtIdouNaiyouTy.setZtykhhrkkeirokbn(tjtIdouNyKh.getHrkkeiro().getValue());
                }
                tjtIdouNaiyouTy.setZtyhhknmei(idouKhMeigi.getHhknnmkn());
                tjtIdouNaiyouTy.setZtyknjhhknmei(idouKhMeigi.getHhknnmkj());
                if (idouKhMeigi.getHhknseiymd() != null) {
                    tjtIdouNaiyouTy.setZtyhhknseiymd(String.valueOf(idouKhMeigi.getHhknseiymd()));
                }
                tjtIdouNaiyouTy.setZtyhhknseikbn(idouKhMeigi.getHhknsei().getValue());
                tjtIdouNaiyouTy.setZtyhhknnewyno(idouKhMeigi.getHhknyno());
                tjtIdouNaiyouTy.setZtyhhknadr(
                    StringUtils.defaultString(idouKhMeigi.getHhknadr1kj()).concat(
                        StringUtils.defaultString(idouKhMeigi.getHhknadr2kj())).concat(
                            StringUtils.defaultString(idouKhMeigi.getHhknadr3kj())));
                tjtIdouNaiyouTy.setZtyhhkntelno(idouKhMeigi.getHhkntelno());
                tjtIdouNaiyouTy.setZtyhhknsykgycd(idouKhMeigi.getHhknsykgycd());
                tjtIdouNaiyouTy.setZtykyknm(idouKhMeigi.getKyknmkn());
                tjtIdouNaiyouTy.setZtykjkyknm(idouKhMeigi.getKyknmkj());
                if (idouKhMeigi.getKykseiymd() != null) {
                    tjtIdouNaiyouTy.setZtykyksyaseiymd(String.valueOf(idouKhMeigi.getKykseiymd()));
                }
                tjtIdouNaiyouTy.setZtynkuktnm(idouKhMeigi.getNenkinuktnmkana());
                tjtIdouNaiyouTy.setZtykjnkuktnm(idouKhMeigi.getNenkinuktnmkanji());
                if (idouKhMeigi.getNenkinuktseiymd() != null) {
                    tjtIdouNaiyouTy.setZtynenkinuktseiymd(String.valueOf(idouKhMeigi.getNenkinuktseiymd()));
                }
                tjtIdouNaiyouTy.setZtytsnsknewyno(idouKhMeigi.getTsinyno());
                tjtIdouNaiyouTy.setZtytsinadr(
                    StringUtils.defaultString(idouKhMeigi.getTsinadr1kj()).concat(
                        StringUtils.defaultString(idouKhMeigi.getTsinadr2kj())).concat(
                            StringUtils.defaultString(idouKhMeigi.getTsinadr3kj())));
                tjtIdouNaiyouTy.setZtytsintelno(idouKhMeigi.getTsintelno());
                tjtIdouNaiyouTy.setZtysbuktnm1(idouKhMeigi.getSbuktnmkn1());
                tjtIdouNaiyouTy.setZtykjsbuktnm1(idouKhMeigi.getSbuktnmkj1());
                tjtIdouNaiyouTy.setZtysbuktnm2(idouKhMeigi.getSbuktnmkn2());
                tjtIdouNaiyouTy.setZtykjsbuktnm2(idouKhMeigi.getSbuktnmkj2());
                tjtIdouNaiyouTy.setZtysbuktnm3(idouKhMeigi.getSbuktnmkn3());
                tjtIdouNaiyouTy.setZtykjsbuktnm3(idouKhMeigi.getSbuktnmkj3());
                tjtIdouNaiyouTy.setZtysbuktnm4(idouKhMeigi.getSbuktnmkn4());
                tjtIdouNaiyouTy.setZtykjsbuktnm4(idouKhMeigi.getSbuktnmkj4());
                tjtIdouNaiyouTy.setZtystdrsknm(idouKhMeigi.getStdrsknmkn());
                tjtIdouNaiyouTy.setZtykjstdrsknm(idouKhMeigi.getStdrsknmkj());
                tjtIdouNaiyouTy.setZtykykdairinm(idouKhMeigi.getKykdairinmkn());
                tjtIdouNaiyouTy.setZtykjkykdairinm(idouKhMeigi.getKykdairinmkj());
                if (StringUtils.isNotEmpty(idouKhMeigi.getBankcd()))  {
                    if(idouKhMeigi.getBankcd().length() < 4){
                        tjtIdouNaiyouTy.setZtybankcd(Strings.padStart(idouKhMeigi.getBankcd(), 4, '0'));
                    }
                    else{
                        tjtIdouNaiyouTy.setZtybankcd(idouKhMeigi.getBankcd());
                    }
                }
                else {
                    tjtIdouNaiyouTy.setZtybankcd(idouKhMeigi.getBankcd());
                }
                if (StringUtils.isNotEmpty(idouKhMeigi.getSitencd()))  {
                    if(idouKhMeigi.getSitencd().length() < 3){
                        tjtIdouNaiyouTy.setZtyshitencd(Strings.padStart(idouKhMeigi.getSitencd(),3, '0'));
                    }
                    else {
                        tjtIdouNaiyouTy.setZtyshitencd(idouKhMeigi.getSitencd());
                    }
                }
                else {
                    tjtIdouNaiyouTy.setZtyshitencd(idouKhMeigi.getSitencd());
                }

                if(C_YokinKbn.BLNK.eq(idouKhMeigi.getYokinkbn())){
                    tjtIdouNaiyouTy.setZtyyokinkbn("");
                }else {
                    tjtIdouNaiyouTy.setZtyyokinkbn(idouKhMeigi.getYokinkbn().getValue());
                }

                if (StringUtils.isNotEmpty(idouKhMeigi.getKouzano())){
                    if(idouKhMeigi.getKouzano().length() < 7){
                        tjtIdouNaiyouTy.setZtykouzano7keta(Strings.padStart(idouKhMeigi.getKouzano(), 7, '0'));
                    }
                    else if (idouKhMeigi.getKouzano().length() > 7){
                        tjtIdouNaiyouTy.setZtykouzano7keta(idouKhMeigi.getKouzano().substring( 0, 7));
                    }
                    else {
                        tjtIdouNaiyouTy.setZtykouzano7keta(idouKhMeigi.getKouzano());
                    }
                }
                else {
                    tjtIdouNaiyouTy.setZtykouzano7keta(idouKhMeigi.getKouzano());
                }
                tjtIdouNaiyouTy.setZtykzmeiginmei(idouKhMeigi.getKzmeiginmkn());

                if (C_KzkykdouKbn.BLNK.eq(idouKhMeigi.getKzkykdoukbn())){
                    tjtIdouNaiyouTy.setZtykzkykdouhyouji("");
                }
                else {
                    if (C_KzkykdouKbn.SITEI.eq(idouKhMeigi.getKzkykdoukbn())) {

                        tjtIdouNaiyouTy.setZtykzkykdouhyouji(C_KzkykdouKbn.BLNK.getValue());
                    }
                    else {

                        tjtIdouNaiyouTy.setZtykzkykdouhyouji(idouKhMeigi.getKzkykdoukbn().getValue());
                    }
                }
                tjtIdouNaiyouTy.setZtykzktourokunm1(idouKhMeigi.getKzktourokunmkn1());
                tjtIdouNaiyouTy.setZtykjkzktourokunm1(idouKhMeigi.getKzktourokunmkj1());
                tjtIdouNaiyouTy.setZtykzktourokunm2(idouKhMeigi.getKzktourokunmkn2());
                tjtIdouNaiyouTy.setZtykjkzktourokunm2(idouKhMeigi.getKzktourokunmkj2());
                tjtIdouNaiyouTy.setZtydairitencd1(idouKhBosyuudr.getDairitencd1());
                tjtIdouNaiyouTy.setZtybunwari1(Strings.padStart(idouKhBosyuudr.getBunwari1().toString(), 3, '0'));
                tjtIdouNaiyouTy.setZtydairitencd2(idouKhBosyuudr.getDairitencd2());
                tjtIdouNaiyouTy.setZtybunwari2(Strings.padStart(idouKhBosyuudr.getBunwari2().toString(), 3, '0'));
                tjtIdouNaiyouTy.setZtyaatukaisosikicd(idouKhBosyuudr.getKanrisosikicd1());
                tjtIdouNaiyouTy.setZtybatukaisosikicd(idouKhBosyuudr.getKanrisosikicd2());

                BizPropertyInitializer.initialize(tjtIdouNaiyouTy);
                tjtIdouNaiyouTyLst.add(tjtIdouNaiyouTy);
                syoriKensuu++;
            }

            recoveryBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
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
