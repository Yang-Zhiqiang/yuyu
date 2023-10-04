package yuyu.batch.direct.dskokyakukanri.dshanyoukokyakutuutisakusei;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsKokyakunoScrambleSyori;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DsHagakiSouhuJyoukyouKbn;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_DsHanyouKokTuutiError;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * ダイレクトサービス 顧客管理 ＤＳ汎用顧客宛通知作成クラス
 */
public class DsHanyouKokyakuTuutiSakuseiBatch implements Batch {

    private final String SYOUKAIFREEAREA1 = "【ご照会先】　スミセイコールセンター";

    private final String SYOUKAIFREEAREA2 = "通話料無料　℡０１２０－５０６０８１";

    private final String SYOUKAIFREEAREA3 = "";

    private final String SYOUKAIFREEAREA4 = "〒５４０－８５１２";

    private final String SYOUKAIFREEAREA5 = "大阪市中央区城見　１－４－３５";

    private final String CODE = "A02";

    private final String TUUTIMEI = "メール送信エラーのお知らせ";

    private final String BLANK = "";

    private final String FREEAREA1_1 = "いつもお引立てをいただき、ありがとうございます。";

    private final String FREEAREA1_3 = "このたび、スミセイダイレクトサービスにご登録のメールアドレスあ";

    private final String FREEAREA1_4 = "てに、メールをお送りさせていただいたところ、送信エラーとなりま";

    private final String FREEAREA1_5 = "したので、メール通知サービスを一時停止させていただきました。";

    private final String FREEAREA1_7 = "【送信先】";

    private final String FREEAREA1_8_63 = "ご登録のメールアドレスはスミセイダイレクトサービスにログインし";

    private final String FREEAREA1_9_63 = "てご確認ください。";

    private final String FREEAREA1_11 = "【送信日】";

    private final String FREEAREA1_14 = "【送信内容】";

    private final String FREEAREA1_17 = "つきましては、右記内容をご確認いただき、ご登録のメールアドレス";

    private final String FREEAREA1_18 = "の変更または再登録をお願いいたします。";

    private final String FREEAREA1_19 = "ご登録のメールアドレスの変更または再登録が完了次第、メール通知";

    private final String FREEAREA1_20 = "サービスを再開させていただきます。";

    private final String FREEAREA1_22 = "詳細はスミセイダイレクトサービスにログインしてご確認ください。";

    private final String FREEAREA2_1 = "メール送信エラー理由とサービスの再開方法について";

    private final String FREEAREA2_3 = "■左記送信先メールアドレスが誤っている場合";

    private final String FREEAREA2_4 = "　スミセイダイレクトサービスにログインして、ご登録のメールアドレスの変更";

    private final String FREEAREA2_5 = "　手続きをしてください。";

    private final String FREEAREA2_6 = "■迷惑メール対策を設定されている場合";

    private final String FREEAREA2_7 = "　（１）「ｓｕｍｉｓｅｉ＿ｍａｉｌ＠ａｍ．ｓｕｍｉｔｏｍｏｌｉｆｅ．ｃｏ．";

    private final String FREEAREA2_8 = "　　　　ｊｐ」からのメールを受信できるように設定してください。";

    private final String FREEAREA2_9 = "　（２）スミセイダイレクトサービスにログインして、メールアドレスを再登録（";

    private final String FREEAREA2_10 = "　　　　現在ご登録のメールアドレスを再度登録）してください。";

    private final String FREEAREA2_11 = "■ご契約のプロバイダでメール容量が不足している場合";

    private final String FREEAREA2_12 = "　（１）ご契約のインターネットプロバイダで設定されているメール容量をご確認";

    private final String FREEAREA2_13 = "　　　　いただき、保存メールの削除等、メール容量を確保してください。";

    private final String FREEAREA2_14 = "　（２）スミセイダイレクトサービスにログインして、メールアドレスを再登録（";

    private final String FREEAREA2_15 = "　　　　現在ご登録のメールアドレスを再度登録）してください。";

    private final String FREEAREA2_16 = "■その他";

    private final String FREEAREA2_17 = "　ご契約のインターネットプロバイダ内で、一時的に何らかの障害やエラーが発生";

    private final String FREEAREA2_18 = "　していた、または当社からのメールの受信を拒否している等の場合は、メール送";

    private final String FREEAREA2_19 = "　信エラーとなることがあります。";

    private final String FREEAREA2_20 = "　（１）スミセイダイレクトサービスにログインして、メールアドレスを再登録（";

    private final String FREEAREA2_21 = "　　　　現在ご登録のメールアドレスを再度登録）してください。";

    private final String FREEAREA2_22 = "　（２）再登録いただいても、再度送信エラーとなった場合は、今後も送信エラー";

    private final String FREEAREA2_23 = "　　　　となる可能性が高いと考えられます。";

    private final String FREEAREA2_24 = "　　　　お手数ですが、スミセイダイレクトサービスにログインして、ご登録のメ";

    private final String FREEAREA2_25 = "　　　　ールアドレスの変更手続きをしてください。";

    private final String FREEAREA2_26 = "";

    private BizDate syoriYmd = null;

    private long syoriTaisyouKensuu = 0;

    private long sinkiErrorKensuu = 0;

    private long retryKeizokuKensuu = 0;

    private long retryKikanTyoukaKensuu = 0;

    private long hagakiSouhuKensuu = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DsHanyouKokyakuTuutiSakuseiDao dsHanyouKokyakuTuutiSakuseiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        emailSousinErrorTuutiDataSakusei();


        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "処理対象",
            String.valueOf(syoriTaisyouKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "新規エラー",
            String.valueOf(sinkiErrorKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "リトライ継続",
            String.valueOf(retryKeizokuKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "リトライ期間超過",
            String.valueOf(retryKikanTyoukaKensuu)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "ハガキ送付",
            String.valueOf(hagakiSouhuKensuu)));

    }

    private void emailSousinErrorTuutiDataSakusei() {

        long sakuseiNo = 1;
        DsKokyakunoScrambleSyori dsKokyakunoScrambleSyori = SWAKInjector.getInstance(DsKokyakunoScrambleSyori.class);
        String kousinKinou = kinou.getKinouId();
        String kousinsyaId = baseUserInfo.getUserId();
        String kousinTime = BizDate.getSysDateTimeMilli();

        try (ExDBResults<DsHanyouKokyakuateTuuti2Bean> dsHanyouKokyakuateTuuti2BeanLst =
            dsHanyouKokyakuTuutiSakuseiDao.getDsHanyouKokyakuateTuutis2ByDsdatasakuseiymd(syoriYmd);
            EntityInserter<ZT_DsHanyouKokyakuTuutiTy> dsHanyouKokyakuTuutiTyInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutiRirekiMeisaiHokanInserter = new EntityInserter<>();
            EntityUpdater<MT_DsHanyouKokTuutiError> dsHanyouKokTuutiErrorUpdater = new EntityUpdater<>();
            EntityInserter<MT_DsHanyouKokTuutiError> dsHanyouKokTuutiErrorInserter = new EntityInserter<>();) {

            for (DsHanyouKokyakuateTuuti2Bean dsHanyouKokyakuateTuuti2Bean : dsHanyouKokyakuateTuuti2BeanLst) {

                String dskokNo = dsHanyouKokyakuateTuuti2Bean.getDskokno();
                String dssousinNo = dsHanyouKokyakuateTuuti2Bean.getDssousinno();
                String dskokyakutuutiRenno = dsHanyouKokyakuateTuuti2Bean.getDskoktuutirenno();
                C_DsHanyouKokyakuateTuutiKbn dshanyoukokyakuatetuutiKbn = dsHanyouKokyakuateTuuti2Bean.getDshanyoukokyakuatetuutikbn();
                String idoujyoutaiittiFlg = "0";
                String yuubinNo = "";
                String address1 = "";
                String address2 = "";
                String address3 = "";
                String kanjiKeiyakusyamei = "";

                MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(dskokNo);
                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = dsKokyakuKanri
                    .getDsKokyakuKeiyakusByDskykmukouhyj(C_MukouHyj.BLANK);

                syoriTaisyouKensuu++;

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyakudata : dsKokyakuKeiyakuLst) {

                    String syoNo = dsKokyakuKeiyakudata.getSyono();

                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo);
                    IT_KykSya kykSya = null;
                    try {
                        kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);
                        kykSya = kykKihon.getKykSya();
                    }
                    catch (EntityNotFoundException e) {
                    }
                    catch (NullPointerException e) {
                    }

                    if (kykKihon == null) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0004,
                            IT_KykKihon.TABLE_NAME, IT_KykKihon.SYONO, syoNo));
                    }

                    if (kykSya == null) {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0004,
                            IT_KykSya.TABLE_NAME, IT_KykSya.SYONO, syoNo));
                    }

                    if ((kykSya.getKyknmkn().equals(dsKokyakuKanri.getDskokyakunmkn())) &&
                        (kykSya.getKyknmkj().equals(dsKokyakuKanri.getDskokyakunmkj())) &&
                        (BizDateUtil.compareYmd(kykSya.getKykseiymd(), dsKokyakuKanri.getDskokyakuseiymd()) == BizDateUtil.COMPARE_EQUAL) &&
                        (kykSya.getTsinyno().equals(dsKokyakuKanri.getDskokyakuyno()))) {
                        idoujyoutaiittiFlg = "1";
                        yuubinNo = kykSya.getTsinyno();
                        address1 = kykSya.getTsinadr1kj();
                        address2 = kykSya.getTsinadr2kj();
                        address3 = kykSya.getTsinadr3kj();
                        kanjiKeiyakusyamei = kykSya.getKyknmkj();

                        break;
                    }
                }

                MT_DsHanyouKokTuutiError dsHanyouKokTuutiError = null;

                MT_DsHanyouKokyakuateTuuti2 dsHanyouKokyaku2Lst = dsHanyouKokyakuTuutiSakuseiDao.getDsHanyouKokTuuti2ByPK(
                    dsKokyakuKanri, dsHanyouKokyakuateTuuti2Bean.getDsdatasakuseiymd(), dskokyakutuutiRenno, dskokNo, dshanyoukokyakuatetuutiKbn);

                List<MT_DsHanyouKokTuutiError> mtDsHanyouKokTuutiErrorLst = dsHanyouKokyaku2Lst.getDsHanyouKokTuutiErrors();

                if (!mtDsHanyouKokTuutiErrorLst.isEmpty()) {
                    dsHanyouKokTuutiError = mtDsHanyouKokTuutiErrorLst.get(0);
                }

                if (idoujyoutaiittiFlg.equals("0")) {
                    if (dsHanyouKokTuutiError == null) {
                        dsHanyouKokTuutiError = new MT_DsHanyouKokTuutiError();

                        BizPropertyInitializer.initialize(dsHanyouKokTuutiError);

                        dsHanyouKokTuutiError.setDsdatasakuseiymd(syoriYmd);
                        dsHanyouKokTuutiError.setDskoktuutirenno(dskokyakutuutiRenno);
                        dsHanyouKokTuutiError.setDskokno(dskokNo);
                        dsHanyouKokTuutiError.setDshanyoukokyakuatetuutikbn(dshanyoukokyakuatetuutiKbn);
                        dsHanyouKokTuutiError.setDshagakisouhujyoukyoukbn(C_DsHagakiSouhuJyoukyouKbn.SOUHUMATI);
                        dsHanyouKokTuutiError.setGyoumuKousinKinou(kousinKinou);
                        dsHanyouKokTuutiError.setGyoumuKousinsyaId(kousinsyaId);
                        dsHanyouKokTuutiError.setGyoumuKousinTime(kousinTime);

                        dsHanyouKokTuutiErrorInserter.add(dsHanyouKokTuutiError);

                        sinkiErrorKensuu++;
                    }
                    else {
                        BizDate retryKikanHanteiday = dsHanyouKokTuutiError.getDsdatasakuseiymd();

                        if (BizDateUtil.compareYmd(syoriYmd, retryKikanHanteiday.addBusinessDays(5)) == BizDateUtil.COMPARE_GREATER) {

                            dsHanyouKokTuutiError.setDshagakisouhujyoukyoukbn(C_DsHagakiSouhuJyoukyouKbn.RETRYKIKANTYOUKA);
                            dsHanyouKokTuutiError.setGyoumuKousinKinou(kousinKinou);
                            dsHanyouKokTuutiError.setGyoumuKousinsyaId(kousinsyaId);
                            dsHanyouKokTuutiError.setGyoumuKousinTime(kousinTime);

                            dsHanyouKokTuutiErrorUpdater.add(dsHanyouKokTuutiError);

                            retryKikanTyoukaKensuu++;

                        }
                        else {
                            retryKeizokuKensuu++;
                        }
                    }
                    continue;
                }

                MT_DsMailHaisinRireki dsHaisinRireki = dsHanyouKokyakuTuutiSakuseiDao.getDsMailHaisinRirekiInfoByKoknoDssousinno(dskokNo, dssousinNo).get(0);

                ZT_DsHanyouKokyakuTuutiTy zDsHanyouKokyakuTuutiTy = new ZT_DsHanyouKokyakuTuutiTy();

                zDsHanyouKokyakuTuutiTy.setZtydshanyoukokatetuutikey(
                    String.valueOf(syoriYmd).concat(Strings.padStart(String.valueOf(sakuseiNo), 7, '0')));
                zDsHanyouKokyakuTuutiTy.setZtydskokno(dskokNo);
                zDsHanyouKokyakuTuutiTy.setZtydstuutikbn(
                    dsHanyouKokyakuateTuuti2Bean.getDshanyoukokyakuatetuutikbn().getValue().substring(0, 1));
                zDsHanyouKokyakuTuutiTy.setZtyatesakiyno(
                    ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL, BizUtil.editYno(yuubinNo)));
                zDsHanyouKokyakuTuutiTy.setZtyatesakiadr1(address1);
                zDsHanyouKokyakuTuutiTy.setZtyatesakiadr2(address2);
                zDsHanyouKokyakuTuutiTy.setZtyatesakiadr3(address3);
                zDsHanyouKokyakuTuutiTy.setZtyatena1(kanjiKeiyakusyamei);
                zDsHanyouKokyakuTuutiTy.setZtyatena2("");
                zDsHanyouKokyakuTuutiTy.setZtyatesakiynobarcode("");
                zDsHanyouKokyakuTuutiTy.setZtydai1syoukaifreearea11(SYOUKAIFREEAREA1);
                zDsHanyouKokyakuTuutiTy.setZtydai1syoukaifreearea12(SYOUKAIFREEAREA2);
                zDsHanyouKokyakuTuutiTy.setZtydai1syoukaifreearea13(SYOUKAIFREEAREA3);
                zDsHanyouKokyakuTuutiTy.setZtydai1syoukaifreearea14(SYOUKAIFREEAREA4);
                zDsHanyouKokyakuTuutiTy.setZtydai1syoukaifreearea15(SYOUKAIFREEAREA5);
                zDsHanyouKokyakuTuutiTy.setZtyscdai2syoukaifreearea1("");
                zDsHanyouKokyakuTuutiTy.setZtyscdai2syoukaifreearea2("");
                zDsHanyouKokyakuTuutiTy.setZtyscdai2syoukaifreearea3("");
                zDsHanyouKokyakuTuutiTy.setZtyscdai2syoukaifreearea4("");
                zDsHanyouKokyakuTuutiTy.setZtyscdai2syoukaifreearea5("");
                zDsHanyouKokyakuTuutiTy.setZtysakuseimd(String.valueOf(syoriYmd.getBizDateMD()));
                zDsHanyouKokyakuTuutiTy.setZtysclakadskokno(dsKokyakunoScrambleSyori.exec(dsKokyakuKanri.getDskokno()));
                zDsHanyouKokyakuTuutiTy.setZtyreigaisyorihyj("0");
                zDsHanyouKokyakuTuutiTy.setZtysakuseino(Strings.padStart(String.valueOf(sakuseiNo), 7, '0'));
                zDsHanyouKokyakuTuutiTy.setZtycode(CODE);
                zDsHanyouKokyakuTuutiTy.setZtytuutimei(TUUTIMEI);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea11(FREEAREA1_1);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea12(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea13(FREEAREA1_3);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea14(FREEAREA1_4);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea15(FREEAREA1_5);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea16(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea17(FREEAREA1_7);

                if (dsHaisinRireki.getHaisinjidsmailaddress().length() <= 62) {

                    if (dsHaisinRireki.getHaisinjidsmailaddress().length() >= 32) {

                        zDsHanyouKokyakuTuutiTy.setZtyfreearea18(ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_H2Z_ALL,
                            dsHaisinRireki.getHaisinjidsmailaddress().substring(0, 31)));
                    }
                    else {

                        zDsHanyouKokyakuTuutiTy.setZtyfreearea18(ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_H2Z_ALL, dsHaisinRireki.getHaisinjidsmailaddress()));
                    }
                }
                else {
                    zDsHanyouKokyakuTuutiTy.setZtyfreearea18(FREEAREA1_8_63);
                }

                if (dsHaisinRireki.getHaisinjidsmailaddress().length() <= 62) {

                    if (dsHaisinRireki.getHaisinjidsmailaddress().length() >= 32) {

                        zDsHanyouKokyakuTuutiTy.setZtyfreearea19(ConvertUtil.convZenHan(
                            IDataConvert.iCONVERT_H2Z_ALL,
                            dsHaisinRireki.getHaisinjidsmailaddress().substring(31)));
                    }
                    else {
                        zDsHanyouKokyakuTuutiTy.setZtyfreearea19(BLANK);
                    }
                }
                else {
                    zDsHanyouKokyakuTuutiTy.setZtyfreearea19(FREEAREA1_9_63);
                }

                zDsHanyouKokyakuTuutiTy.setZtyfreearea110(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea111(FREEAREA1_11);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea112(ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,
                    new BizDateFormat("yyyy年MM月dd日", FillStyle.Blank).format(dsHaisinRireki.getDsdatasakuseiymd())));
                zDsHanyouKokyakuTuutiTy.setZtyfreearea113(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea114(FREEAREA1_14);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea115(C_DsSousinMailSyubetuKbn.getContentByValue(
                    C_DsSousinMailSyubetuKbn.PATTERN_HAGAKIKISAINAIYOU, dsHaisinRireki.getDssousinmailsyubetukbn().getValue()));
                zDsHanyouKokyakuTuutiTy.setZtyfreearea116(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea117(FREEAREA1_17);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea118(FREEAREA1_18);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea119(FREEAREA1_19);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea120(FREEAREA1_20);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea121(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea122(FREEAREA1_22);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea123(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea124(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea125(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea126(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea127(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea128(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea21(FREEAREA2_1);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea22(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea23(FREEAREA2_3);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea24(FREEAREA2_4);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea25(FREEAREA2_5);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea26(FREEAREA2_6);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea27(FREEAREA2_7);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea28(FREEAREA2_8);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea29(FREEAREA2_9);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea210(FREEAREA2_10);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea211(FREEAREA2_11);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea212(FREEAREA2_12);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea213(FREEAREA2_13);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea214(FREEAREA2_14);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea215(FREEAREA2_15);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea216(FREEAREA2_16);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea217(FREEAREA2_17);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea218(FREEAREA2_18);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea219(FREEAREA2_19);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea220(FREEAREA2_20);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea221(FREEAREA2_21);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea222(FREEAREA2_22);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea223(FREEAREA2_23);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea224(FREEAREA2_24);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea225(FREEAREA2_25);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea226(FREEAREA2_26);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea227(BLANK);
                zDsHanyouKokyakuTuutiTy.setZtyfreearea228(BLANK);

                BizPropertyInitializer.initialize(zDsHanyouKokyakuTuutiTy);

                dsHanyouKokyakuTuutiTyInserter.add(zDsHanyouKokyakuTuutiTy);

                BT_TuutirirekiMeisaiHokan tuutiRirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutiRirekiMeisaiHokan.setTuutirirekirenno(
                    RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue())));
                tuutiRirekiMeisaiHokan.setTuutirirekino(
                    C_TuutirirekiTaisyouKbn.DSKOKYAKUNO.getValue() + "0" + dsKokyakuKanri.getDskokno());
                tuutiRirekiMeisaiHokan.setTuutisakuseiymd(syoriYmd);
                tuutiRirekiMeisaiHokan.setTuutisakuseino(0);
                tuutiRirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutiRirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYmd);

                BizPropertyInitializer.initialize(tuutiRirekiMeisaiHokan);

                tuutiRirekiMeisaiHokanInserter.add(tuutiRirekiMeisaiHokan);

                hagakiSouhuKensuu++;
                sakuseiNo++;

                if (dsHanyouKokTuutiError != null) {
                    dsHanyouKokTuutiError.setDshagakisouhujyoukyoukbn(C_DsHagakiSouhuJyoukyouKbn.SOUHUZUMI);
                    dsHanyouKokTuutiError.setGyoumuKousinKinou(kousinKinou);
                    dsHanyouKokTuutiError.setGyoumuKousinsyaId(kousinsyaId);
                    dsHanyouKokTuutiError.setGyoumuKousinTime(kousinTime);

                    dsHanyouKokTuutiErrorUpdater.add(dsHanyouKokTuutiError);
                }
            }
        }
    }
}
