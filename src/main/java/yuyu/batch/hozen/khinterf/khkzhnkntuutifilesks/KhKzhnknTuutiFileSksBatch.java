package yuyu.batch.hozen.khinterf.khkzhnkntuutifilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khkzhnkntuutifilesks.dba.KhKzhnknTuutiDataBean;
import yuyu.batch.hozen.khinterf.khkzhnkntuutifilesks.dba.KhKzhnknTuutiFileSksDao;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.KhozenEdit;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_KouzaHnknTuuti;
import yuyu.def.db.entity.ZT_KouzaHnknTuutiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 口座返金通知Ｆ作成
 */
public class KhKzhnknTuutiFileSksBatch implements Batch {

    private final static String TABLEID  = IT_KouzaHnknTuuti.TABLE_NAME;

    private final static String FILTERID = "Kh001";

    private static final String WAREKI_KANJI_YM_FORMAT = "GGyy年MM月";

    private static final String WAREKI_M_FORMAT = "MM";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKzhnknTuutiFileSksDao khKzhnknTuutiFileSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        long syoriKensuu = 0;
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();

        try (ExDBResults<KhKzhnknTuutiDataBean> khKzhnknTuutiDataBeanLst =
            khKzhnknTuutiFileSksDao.getKhKzhnknTuutiDataBeans(kakutyoujobCd, syoriYMD);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {

            for (KhKzhnknTuutiDataBean khKzhnknTuutiDataBean : khKzhnknTuutiDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khKzhnknTuutiDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khKzhnknTuutiDataBean.getSyono());
                long renNo = syoriKensuu + 1;
                String hnskariyuu = "000";

                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);
                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(khKzhnknTuutiDataBean.getSyono());
                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hnskariyuu = "Z01";
                }

                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);
                ansyuKokTyouhyouHensyuu.exec(khKzhnknTuutiDataBean.getSyono(), String.valueOf(renNo),
                    C_AsTyouhyoukigouKbn.AS_KZHENKINTUUTI, hnskariyuu);
                String sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();
                String sakuseiNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                C_HassouKbn hassoukbn = khKzhnknTuutiDataBean.getHassoukbn();
                if (!C_HassouKbn.HONSYAKAISOU.eq(hassoukbn) && C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hassoukbn = C_HassouKbn.HONSYAKAISOU;
                }

                String ztytyouhyouymdkj = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKzhnknTuutiDataBean.getTyouhyouymd());
                String ztyhrkymdmdkj = FixedDateFormatter.formatMDZenkakuKanji(khKzhnknTuutiDataBean.getRyosyuymd());
                String ztynyknymdseirekikj = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKzhnknTuutiDataBean.getRyosyuymd());

                String pjytym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(khKzhnknTuutiDataBean.getJyuutouym().getFirstDay()) + "から";
                if (khKzhnknTuutiDataBean.getJyutoukaisuuy() > 0) {

                    pjytym = pjytym + formatYMZenkakuBlankFill(khKzhnknTuutiDataBean.getJyutoukaisuuy()) + "年";
                }
                if (khKzhnknTuutiDataBean.getJyutoukaisuum() > 0) {

                    pjytym = pjytym + formatYMZenkakuBlankFill(khKzhnknTuutiDataBean.getJyutoukaisuum()) + "か月";
                }
                pjytym = pjytym + "分";

                String ztyhrkmymdseireki = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khKzhnknTuutiDataBean.getHurikomiymd());

                String shririyuu1 = "";
                if (C_KrkriyuuKbn.KAZYOUNYKN.eq(khKzhnknTuutiDataBean.getKrkriyuukbn())) {

                    shririyuu1 = "過剰にお払込みいただきましたので、返金させていただきます。";
                }
                else {
                    shririyuu1 = "お払込み不要のため、返金させていただきます。";
                }

                BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

                BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(khKzhnknTuutiDataBean.getBankcd(),
                    khKzhnknTuutiDataBean.getSitencd());

                String banknm = bzGetBankDataBean.getBankNmKj();
                String reportSitenNm = bzGetBankDataBean.getReportSitenNm();

                String kouzaNoMsk = ConvertUtil.toZenAll(KhozenEdit.editKouzaNo(khKzhnknTuutiDataBean.getBankcd(),
                    khKzhnknTuutiDataBean.getKouzano()),1,1);

                String siteikouza1 = "";
                String siteikouza2 = "";
                String siteikouza3 = "";
                String siteikouza4 = "";
                String siteikouza5 = "";
                if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(khKzhnknTuutiDataBean.getBankcd())) {

                    siteikouza1 = "　　" + banknm;
                    siteikouza2 = "　　" + reportSitenNm;
                    siteikouza3 = "　　通帳番号　" + kouzaNoMsk;
                    siteikouza4 = "　　口座名義人　" + khKzhnknTuutiDataBean.getKzmeiginmkn() + "　様";
                }
                else {
                    siteikouza1 = "　　" + banknm;
                    siteikouza2 = "　　" + reportSitenNm;
                    siteikouza3 = "　　" + khKzhnknTuutiDataBean.getYokinkbn().getContent(C_YokinKbn.PATTERN_TYOUHYOU) + "　口座番号　" + kouzaNoMsk;
                    siteikouza4 = "　　口座名義人　" + khKzhnknTuutiDataBean.getKzmeiginmkn() + "　様";
                }
                if (siteikouza4.length() > 32) {
                    siteikouza5 = "　　　　　　　　" + siteikouza4.substring(32);
                    siteikouza4 = siteikouza4.substring(0, 32);
                }

                String ztytyusyaku = "";
                if (IGkCommonKoumoku.BANKCD_YTGINKOU.equals(khKzhnknTuutiDataBean.getBankcd())) {
                    ztytyusyaku = "※お客さま情報保護のため、通帳番号の一部を＊にて表示しています。";
                }
                else {
                    ztytyusyaku = "※お客さま情報保護のため、口座番号の一部を＊にて表示しています。";
                }

                ZT_KouzaHnknTuutiTy kouzaHnknTuutiTy = new ZT_KouzaHnknTuutiTy();
                kouzaHnknTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.AS_KZHENKINTUUTI.getValue().toUpperCase());
                kouzaHnknTuutiTy.setZtyhassoukbn(hassoukbn.getValue());
                kouzaHnknTuutiTy.setZtytyouhyouymd(String.valueOf(khKzhnknTuutiDataBean.getTyouhyouymd()));
                kouzaHnknTuutiTy.setZtytyouhyouymdkj(ztytyouhyouymdkj);
                kouzaHnknTuutiTy.setZtysyono(khKzhnknTuutiDataBean.getSyono());
                kouzaHnknTuutiTy.setZtysikibetuno(khKzhnknTuutiDataBean.getHenkousikibetukey());
                kouzaHnknTuutiTy.setZtyshskyno(khKzhnknTuutiDataBean.getShskyno());
                kouzaHnknTuutiTy.setZtyshskadr1kj(khKzhnknTuutiDataBean.getShsadr1kj());
                kouzaHnknTuutiTy.setZtyshskadr2kj(khKzhnknTuutiDataBean.getShsadr2kj());
                kouzaHnknTuutiTy.setZtyshskadr3kj(khKzhnknTuutiDataBean.getShsadr3kj());
                kouzaHnknTuutiTy.setZtyshsnmkj(khKzhnknTuutiDataBean.getShsnmkj());
                kouzaHnknTuutiTy.setZtytawsosikikj(khKzhnknTuutiDataBean.getToiawasesosikinmkj());
                kouzaHnknTuutiTy.setZtytawyno(khKzhnknTuutiDataBean.getToiawaseyno());
                kouzaHnknTuutiTy.setZtytawadr1kj(khKzhnknTuutiDataBean.getToiawaseadr1kj());
                kouzaHnknTuutiTy.setZtytawadr2kj(khKzhnknTuutiDataBean.getToiawaseadr2kj());
                kouzaHnknTuutiTy.setZtytawadr3kj(khKzhnknTuutiDataBean.getToiawaseadr3kj());
                kouzaHnknTuutiTy.setZtytawtelnov14(khKzhnknTuutiDataBean.getToiawasetelno());
                kouzaHnknTuutiTy.setZtytawteluktkkanou1(khKzhnknTuutiDataBean.getToiawaseteluktkkanou1());
                kouzaHnknTuutiTy.setZtytawteluktkkanou2(khKzhnknTuutiDataBean.getToiawaseteluktkkanou2());
                kouzaHnknTuutiTy.setZtydai2tawsosikinmkj(khKzhnknTuutiDataBean.getToiawasesosikinmkj2());
                kouzaHnknTuutiTy.setZtydai2tawtelno(khKzhnknTuutiDataBean.getToiawasetelno2());
                kouzaHnknTuutiTy.setZtysclatosyono(sclatoSyono);
                kouzaHnknTuutiTy.setZtysakunm15keta(sakuseiNo);
                kouzaHnknTuutiTy.setZtytuutisakuseiymdV11(ztytyouhyouymdkj);
                kouzaHnknTuutiTy.setZtyhrkymdmdkj(ztyhrkymdmdkj);
                kouzaHnknTuutiTy.setZtynyknaiyoumidasi("振替");
                kouzaHnknTuutiTy.setZtysyono2(khKzhnknTuutiDataBean.getSyono());
                kouzaHnknTuutiTy.setZtyymdmidasi("振　替　日");
                kouzaHnknTuutiTy.setZtykingakumidasi("振　替　額");
                kouzaHnknTuutiTy.setZtynyknymdseirekikj(ztynyknymdseirekikj);
                kouzaHnknTuutiTy.setZtynyuukinngaku(khKzhnknTuutiDataBean.getRsgaku().toAdsoluteString());
                kouzaHnknTuutiTy.setZtypjyuutouym(pjytym);
                kouzaHnknTuutiTy.setZtyhrkmymdseireki(ztyhrkmymdseireki);
                kouzaHnknTuutiTy.setZtyshrgk(khKzhnknTuutiDataBean.getShrgk().toAdsoluteString());
                kouzaHnknTuutiTy.setZtyshririyuu1(shririyuu1);
                kouzaHnknTuutiTy.setZtysiteikouza1(siteikouza1);
                kouzaHnknTuutiTy.setZtysiteikouza2(siteikouza2);
                kouzaHnknTuutiTy.setZtysiteikouza3(siteikouza3);
                kouzaHnknTuutiTy.setZtysiteikouza4(siteikouza4);
                kouzaHnknTuutiTy.setZtysiteikouza5(siteikouza5);
                kouzaHnknTuutiTy.setZtytyusyaku(ztytyusyaku);

                BizPropertyInitializer.initialize(kouzaHnknTuutiTy);
                khKzhnknTuutiFileSksDao.addKouzaHnknTuutiTyInserter(multipleEntityInserter, kouzaHnknTuutiTy);

                String renbanKekka = RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO
                    .getValue()));
                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue()
                    + khKzhnknTuutiDataBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYMD);
                tuutirirekiMeisaiHokan.setTuutisakuseino(Integer.valueOf(0));
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYMD);

                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);
                khKzhnknTuutiFileSksDao.addTuutirirekiMeisaiHokanInserter(multipleEntityInserter, tuutirirekiMeisaiHokan);

                syoriKensuu++;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }


    private String formatYMZenkakuBlankFill(Integer pYearOrMonth) {

        String formatZenkaku;

        if (pYearOrMonth == null) {

            formatZenkaku = "";
        }
        else {

            BizDateFormat format = new BizDateFormat(WAREKI_M_FORMAT, FillStyle.Blank);

            formatZenkaku = format.format(BizDateYM.valueOf(pYearOrMonth));

            formatZenkaku = ConvertUtil.toZenAll(formatZenkaku, 1, 1);
        }

        return formatZenkaku;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}