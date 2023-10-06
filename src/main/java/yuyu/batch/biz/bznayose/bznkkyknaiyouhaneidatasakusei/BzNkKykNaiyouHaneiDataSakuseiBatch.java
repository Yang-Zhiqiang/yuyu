package yuyu.batch.biz.bznayose.bznkkyknaiyouhaneidatasakusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;

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
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 名寄せ 年金支払用契約内容反映データ作成クラス
 */
public class BzNkKykNaiyouHaneiDataSakuseiBatch implements Batch {

    private final String NENKINKIHONFILTERID = "Nk001";

    private final String TJTIDOUNYNKID = "BT_TjtIdouNyNk";

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

        try (ExDBResults<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNksByKakutyoujobcdMaxRenno3keta(
            bzBatchParam.getIbKakutyoujobcd());

            EntityInserter<ZT_TjtIdouNaiyouTy> tjtIdouNaiyouTyInserter = new EntityInserter<>()) {

            long syoriKensuu = 0;

            for (BT_TjtIdouNyNk tjtIdouNyNk : tjtIdouNyNkLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TJTIDOUNYNKID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(NENKINKIHONFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(tjtIdouNyNk.getNksysyno());

                ZT_TjtIdouNaiyouTy tjtIdouNaiyouTy = new ZT_TjtIdouNaiyouTy();

                BT_IdouNkMeigi idouNkMeigi = tjtIdouNyNk.getIdouNkMeigi();

                BT_IdouNkBosyuudr idouNkBosyuudr = tjtIdouNyNk.getIdouNkBosyuudr();

                tjtIdouNaiyouTy.setZtyhuho2kyknokbn(C_Huho2kyknoKbn.NKSYSYNO.getValue());
                tjtIdouNaiyouTy.setZtyhuho2kykno(tjtIdouNyNk.getNksysyno());

                tjtIdouNaiyouTy.setZtyrecordsakujyohyouji(tjtIdouNyNk.getRecordsakujyohyouji().toString());
                tjtIdouNaiyouTy.setZtynksyouhncd(tjtIdouNyNk.getSyouhncd());
                if (tjtIdouNyNk.getNkshrstartymd() != null) {

                    tjtIdouNaiyouTy.setZtynknkshrstartymd(String.valueOf(tjtIdouNyNk.getNkshrstartymd()));
                }
                if (tjtIdouNyNk.getKykymd() != null) {

                    tjtIdouNaiyouTy.setZtynkkykymd(String.valueOf(tjtIdouNyNk.getKykymd()));
                }

                if (C_NkSyoumetuCd.BLNK.eq(tjtIdouNyNk.getNksyoumetucd())) {

                    tjtIdouNaiyouTy.setZtynknksyoumetucd("");
                }
                else {

                    tjtIdouNaiyouTy.setZtynknksyoumetucd(tjtIdouNyNk.getNksyoumetucd().getValue());
                }
                if (tjtIdouNyNk.getSyoumetuymd() != null) {

                    tjtIdouNaiyouTy.setZtynksyoumtymd(String.valueOf(tjtIdouNyNk.getSyoumetuymd()));
                }

                if (C_Tuukasyu.BLNK.eq(tjtIdouNyNk.getShrtuukasyu())) {

                    tjtIdouNaiyouTy.setZtynkshrtuukasyu("");
                }
                else {

                    tjtIdouNaiyouTy.setZtynkshrtuukasyu(tjtIdouNyNk.getShrtuukasyu().getValue());
                }
                tjtIdouNaiyouTy.setZtynkteinksyu(tjtIdouNyNk.getTeinksyu());
                tjtIdouNaiyouTy.setZtynktsnnkgns(tuukaTypebetuhenkan(tjtIdouNyNk.getTsnyounkgns()));

                tjtIdouNaiyouTy.setZtynknkukthhkndouhyouji(tjtIdouNyNk.getNkukthhkndouhyouji().toString());
                tjtIdouNaiyouTy.setZtynksyouhnsdno(
                    Strings.padStart(String.valueOf(tjtIdouNyNk.getSyouhnsdno()), 2, '0'));
                tjtIdouNaiyouTy.setZtyhhknmei(idouNkMeigi.getHhknnmkn());
                tjtIdouNaiyouTy.setZtyknjhhknmei(idouNkMeigi.getHhknnmkj());
                if (idouNkMeigi.getHhknseiymd() != null) {

                    tjtIdouNaiyouTy.setZtyhhknseiymd(String.valueOf(idouNkMeigi.getHhknseiymd()));
                }

                tjtIdouNaiyouTy.setZtyhhknseikbn(idouNkMeigi.getHhknsei().getValue());
                tjtIdouNaiyouTy.setZtyhhknnewyno(idouNkMeigi.getHhknyno());
                tjtIdouNaiyouTy.setZtyhhknadr(
                    StringUtils.defaultString(idouNkMeigi.getHhknadr1kj()).concat(
                        StringUtils.defaultString(idouNkMeigi.getHhknadr2kj())).concat(
                            StringUtils.defaultString(idouNkMeigi.getHhknadr3kj())));
                tjtIdouNaiyouTy.setZtyhhkntelno(idouNkMeigi.getHhkntelno());
                tjtIdouNaiyouTy.setZtyhhknsykgycd(idouNkMeigi.getHhknsykgycd());
                tjtIdouNaiyouTy.setZtynkuktnm(idouNkMeigi.getNenkinuktnmkana());
                tjtIdouNaiyouTy.setZtykjnkuktnm(idouNkMeigi.getNenkinuktnmkanji());
                if (idouNkMeigi.getNenkinuktseiymd() != null) {

                    tjtIdouNaiyouTy.setZtynenkinuktseiymd(String.valueOf(idouNkMeigi.getNenkinuktseiymd()));
                }

                tjtIdouNaiyouTy.setZtytsnsknewyno(idouNkMeigi.getTsinyno());
                tjtIdouNaiyouTy.setZtytsinadr(
                    StringUtils.defaultString(idouNkMeigi.getTsinadr1kj()).concat(
                        StringUtils.defaultString(idouNkMeigi.getTsinadr2kj())).concat(
                            StringUtils.defaultString(idouNkMeigi.getTsinadr3kj())));
                tjtIdouNaiyouTy.setZtytsintelno(idouNkMeigi.getTsintelno());
                tjtIdouNaiyouTy.setZtystdrsknm(idouNkMeigi.getStdrsknmkn());
                tjtIdouNaiyouTy.setZtykjstdrsknm(idouNkMeigi.getStdrsknmkj());
                tjtIdouNaiyouTy.setZtydairitencd1(idouNkBosyuudr.getDairitencd1());
                tjtIdouNaiyouTy.setZtybunwari1(Strings.padStart(idouNkBosyuudr.getBunwari1().toString(), 3, '0'));
                tjtIdouNaiyouTy.setZtydairitencd2(idouNkBosyuudr.getDairitencd2());
                tjtIdouNaiyouTy.setZtybunwari2(Strings.padStart(idouNkBosyuudr.getBunwari2().toString(), 3, '0'));
                tjtIdouNaiyouTy.setZtyaatukaisosikicd(idouNkBosyuudr.getKanrisosikicd1());
                tjtIdouNaiyouTy.setZtybatukaisosikicd(idouNkBosyuudr.getKanrisosikicd2());

                BizPropertyInitializer.initialize(tjtIdouNaiyouTy);
                tjtIdouNaiyouTyInserter.add(tjtIdouNaiyouTy);
                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(syoriKensuu), kinou.getKinouNm()));
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

        return convData;
    }
}
