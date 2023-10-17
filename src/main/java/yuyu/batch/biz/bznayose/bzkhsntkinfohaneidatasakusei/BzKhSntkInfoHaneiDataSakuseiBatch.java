package yuyu.batch.biz.bznayose.bzkhsntkinfohaneidatasakusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Strings;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.sinkeiyaku.skcommon.EditPalRenkeiKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_DecKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoKykTorikesiKbn;
import yuyu.def.classification.C_SntkInfoTourokuSysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 名寄せ 契約保全用選択情報反映データ作成
 */
public class BzKhSntkInfoHaneiDataSakuseiBatch implements Batch {

    private final String SYONOFILTER = "Bz002";

    private final String TABLEID = "IT_KhSntkInfoTouroku";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

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

        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTourokuLst =
            hozenDomManager.getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg(bzBatchParam.getIbKakutyoujobcd(),
                C_Syorizumiflg.MISYORI);

            EntityInserter<ZT_SntkInfoTourokuTy> sntkInfoTourokuTyLst = new EntityInserter<>()){
            EditPalRenkeiKoumoku editPalRenkeiKoumoku = SWAKInjector.getInstance(EditPalRenkeiKoumoku.class);

            for (IT_KhSntkInfoTouroku khSntkInfoTouroku : khSntkInfoTourokuLst) {

                recoveryBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                recoveryBean.setIbTableid(TABLEID);
                recoveryBean.setIbRecoveryfilterid(SYONOFILTER);
                recoveryBean.setIbRecoveryfilterkey1(khSntkInfoTouroku.getSyono());
                recoveryBean.setIbRecoveryfilterkey2(khSntkInfoTouroku.getRenno().toString());

                ZT_SntkInfoTourokuTy sntkInfoTourokuTy = new ZT_SntkInfoTourokuTy();

                sntkInfoTourokuTy.setZtysntkinfono(khSntkInfoTouroku.getSyono());
                sntkInfoTourokuTy.setZtyrenno(Strings.padStart(khSntkInfoTouroku.getRenno().toString(), 2, '0'));
                sntkInfoTourokuTy.setZtysntkinfotourokusyskbn(C_SntkInfoTourokuSysKbn.HOZEN.getValue());
                if (khSntkInfoTouroku.getSyoriYmd() != null) {
                    sntkInfoTourokuTy.setZtysyoriymd(String.valueOf(khSntkInfoTouroku.getSyoriYmd()));
                }
                sntkInfoTourokuTy.setZtyhuho2kyknokbn(khSntkInfoTouroku.getHuho2kyknokbn().getValue());

                sntkInfoTourokuTy.setZtyhuho2kykno(khSntkInfoTouroku.getHuho2kykno());

                sntkInfoTourokuTy.setZtysyouhncd(khSntkInfoTouroku.getSyouhncd());

                if (khSntkInfoTouroku.getSntkinfokankeisyakbn().eq(C_KankeisyaKbn.BLNK)) {
                    sntkInfoTourokuTy.setZtysntkinfofsegkbn("");
                }
                else {
                    sntkInfoTourokuTy.setZtysntkinfofsegkbn(
                        khSntkInfoTouroku.getSntkinfokankeisyakbn().getValue());
                }

                sntkInfoTourokuTy.setZtysntkinfofkojinkbn("00");
                sntkInfoTourokuTy.setZtytaisyounm(khSntkInfoTouroku.getTaisyounmkn());
                sntkInfoTourokuTy.setZtykjtaisyounm(khSntkInfoTouroku.getTaisyounmkj());
                if (khSntkInfoTouroku.getTaisyouseiymd() != null) {
                    sntkInfoTourokuTy.setZtytaisyouseiymd(String.valueOf(khSntkInfoTouroku.getTaisyouseiymd()));
                }
                sntkInfoTourokuTy.setZtytaisyouseibetu(khSntkInfoTouroku.getTaisyouseibetu().getValue());

                sntkInfoTourokuTy.setZtydakuhiketnaiyouarihyj(
                    convBlnktkumukbn(khSntkInfoTouroku.getDakuhiketnaiyouumukbn()));

                sntkInfoTourokuTy.setZtykktnaiyouarihyj(
                    convBlnktkumukbn(khSntkInfoTouroku.getKktnaiyouumukbn()));

                sntkInfoTourokuTy.setZtykijinaiyouarihyj(convBlnktkumukbn(khSntkInfoTouroku.getKijinaiyouumukbn()));

                sntkInfoTourokuTy.setZtymrarihyj(convBlnktkumukbn(khSntkInfoTouroku.getMrumukbn()));

                sntkInfoTourokuTy.setZtykoudosyougaiarihyj(convBlnktkumukbn(khSntkInfoTouroku.getKoudosyougaiumukbn()));

                sntkInfoTourokuTy.setZtytorikaijoarihyj(convBlnktkumukbn(khSntkInfoTouroku.getTorikaijoumukbn()));

                if (C_SeirituKbn.HUSEIRITU.eq(khSntkInfoTouroku.getSeiritukbn())) {

                    sntkInfoTourokuTy.setZtyskhuseirituhyouji("1");
                }
                else {
                    sntkInfoTourokuTy.setZtyskhuseirituhyouji("0");
                }

                if (khSntkInfoTouroku.getDeckbn().eq(C_DecKbn.BLNK)) {
                    sntkInfoTourokuTy.setZtydeckbn("");
                }
                else {
                    sntkInfoTourokuTy.setZtydeckbn(khSntkInfoTouroku.getDeckbn().getValue());
                }

                if (khSntkInfoTouroku.getKetymd() != null) {
                    sntkInfoTourokuTy.setZtyketymd(String.valueOf(khSntkInfoTouroku.getKetymd()));
                }

                sntkInfoTourokuTy.setZtyketkekkacd(
                    editPalRenkeiKoumoku.editDakuhiKtkekkaCd(khSntkInfoTouroku.getKetkekkacd()));

                if (khSntkInfoTouroku.getKetriyuucd1().eq(C_Ketriyuucd.BLNK)) {
                    sntkInfoTourokuTy.setZtyketriyuucd1("");
                }
                else {
                    sntkInfoTourokuTy.setZtyketriyuucd1(khSntkInfoTouroku.getKetriyuucd1().getValue());
                }

                if (khSntkInfoTouroku.getKetriyuucd2().eq(C_Ketriyuucd.BLNK)) {
                    sntkInfoTourokuTy.setZtyketriyuucd2("");
                }
                else {
                    sntkInfoTourokuTy.setZtyketriyuucd2(khSntkInfoTouroku.getKetriyuucd2().getValue());
                }

                if (khSntkInfoTouroku.getKetriyuucd3().eq(C_Ketriyuucd.BLNK)) {
                    sntkInfoTourokuTy.setZtyketriyuucd3("");
                }
                else {
                    sntkInfoTourokuTy.setZtyketriyuucd3(khSntkInfoTouroku.getKetriyuucd3().getValue());
                }

                if (khSntkInfoTouroku.getKetriyuucd4().eq(C_Ketriyuucd.BLNK)) {
                    sntkInfoTourokuTy.setZtyketriyuucd4("");
                }
                else {
                    sntkInfoTourokuTy.setZtyketriyuucd4(khSntkInfoTouroku.getKetriyuucd4().getValue());
                }

                sntkInfoTourokuTy.setZtyketsyacd(khSntkInfoTouroku.getPalketsyacd());

                sntkInfoTourokuTy.setZtysntkinfosintyou(
                    Strings.padStart(khSntkInfoTouroku.getSintyou().toString(), 3, '0'));

                sntkInfoTourokuTy.setZtysntkinfotaijyuu(
                    Strings.padStart(khSntkInfoTouroku.getTaijyuu().toString(), 3, '0'));

                if (khSntkInfoTouroku.getKktymd() != null) {
                    sntkInfoTourokuTy.setZtykokutiymd(String.valueOf(khSntkInfoTouroku.getKktymd()));
                }

                sntkInfoTourokuTy.setZtysyoubyoucd1(khSntkInfoTouroku.getSyoubyoucd1());

                if (khSntkInfoTouroku.getSyoubyoujyoutaikbn1().eq(C_SyoubyoujyoutaiKbn.KANTI)) {
                    if (khSntkInfoTouroku.getKantiym1() != null) {
                        sntkInfoTourokuTy.setZtykantiym1(String.valueOf(khSntkInfoTouroku.getKantiym1()));
                    }
                }
                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn1().eq(C_SyoubyoujyoutaiKbn.GENSYOUTYUU)) {
                    sntkInfoTourokuTy.setZtykantiym1("999999");
                }
                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn1().eq(C_SyoubyoujyoutaiKbn.TOKIDOKI)) {
                    sntkInfoTourokuTy.setZtykantiym1("888888");
                }
                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn1().eq(C_SyoubyoujyoutaiKbn.SUUNENMAE)) {
                    sntkInfoTourokuTy.setZtykantiym1("777777");
                }

                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn1().eq(C_SyoubyoujyoutaiKbn.HUMEI)) {
                    sntkInfoTourokuTy.setZtykantiym1("666666");
                }

                sntkInfoTourokuTy.setZtysyoubyoucd2(khSntkInfoTouroku.getSyoubyoucd2());

                if (khSntkInfoTouroku.getSyoubyoujyoutaikbn2().eq(C_SyoubyoujyoutaiKbn.KANTI)) {
                    if (khSntkInfoTouroku.getKantiym2() != null) {
                        sntkInfoTourokuTy.setZtykantiym2(String.valueOf(khSntkInfoTouroku.getKantiym2()));
                    }
                }
                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn2().eq(C_SyoubyoujyoutaiKbn.GENSYOUTYUU)) {
                    sntkInfoTourokuTy.setZtykantiym2("999999");
                }
                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn2().eq(C_SyoubyoujyoutaiKbn.TOKIDOKI)) {
                    sntkInfoTourokuTy.setZtykantiym2("888888");
                }
                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn2().eq(C_SyoubyoujyoutaiKbn.SUUNENMAE)) {
                    sntkInfoTourokuTy.setZtykantiym2("777777");
                }

                else if (khSntkInfoTouroku.getSyoubyoujyoutaikbn2().eq(C_SyoubyoujyoutaiKbn.HUMEI)) {
                    sntkInfoTourokuTy.setZtykantiym2("666666");
                }

                if (khSntkInfoTouroku.getMrriyuucdkbn().eq(C_MrRiyuucdKbn.BLNK)) {
                    sntkInfoTourokuTy.setZtymrriyuucdkbn("");
                }
                else {
                    sntkInfoTourokuTy.setZtymrriyuucdkbn(khSntkInfoTouroku.getMrriyuucdkbn().getValue());
                }

                if (khSntkInfoTouroku.getSntkinfokyktorikesikbn().eq(C_SntkInfoKykTorikesiKbn.BLNK)) {
                    sntkInfoTourokuTy.setZtysntkinfokyktorikesikbn("");
                }
                else {
                    sntkInfoTourokuTy.setZtysntkinfokyktorikesikbn(
                        khSntkInfoTouroku.getSntkinfokyktorikesikbn().getValue());
                }

                BizPropertyInitializer.initialize(sntkInfoTourokuTy);

                khSntkInfoTouroku.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                khSntkInfoTouroku.setGyoumuKousinKinou(kinou.getKinouId());
                khSntkInfoTouroku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                khSntkInfoTouroku.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                sntkInfoTourokuTyLst.add(sntkInfoTourokuTy);

                syoriKensuu++;
            }

            recoveryBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
    }

    private String convBlnktkumukbn(C_BlnktkumuKbn pBefore) {

        String after ="";

        if (C_BlnktkumuKbn.BLNK.eq(pBefore)) {
            after = "";
        }
        else if (C_BlnktkumuKbn.ARI.eq(pBefore)) {
            after = "1";
        }
        else {
            after = "0";
        }

        return after;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
