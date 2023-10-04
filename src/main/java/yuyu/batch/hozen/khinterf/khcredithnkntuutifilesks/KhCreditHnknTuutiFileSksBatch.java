package yuyu.batch.hozen.khinterf.khcredithnkntuutifilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.sequence.RenbanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.hozen.khinterf.khcredithnkntuutifilesks.dba.KhCreditHnknTuutiFileSksDao;
import yuyu.batch.hozen.khinterf.khcredithnkntuutifilesks.dba.KhCredithnknTuutiDataBean;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.AnsyuKokTyouhyouHensyuu;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfo;
import yuyu.common.hozen.khcommon.AnsyuuSetTetudukityuuiInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_NosyuruiKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.entity.IT_CreditHnknTuuti;
import yuyu.def.db.entity.ZT_CreditHnknTuutiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス クレカ返金通知Ｆ作成
 */
public class KhCreditHnknTuutiFileSksBatch implements Batch {

    private final static String TABLEID  = IT_CreditHnknTuuti.TABLE_NAME;

    private final static String FILTERID = "Kh001";

    private static final String KB_HNKNMSGMONGON1 = "いつもお引立てをいただきありがとうございます。";

    private static final String KB_HNKNMSGMONGON2 = "返金は、ご指定のクレジットカード会社に取消（返金）の売";

    private static final String KB_HNKNMSGMONGON3 = "上を行う方法です。";

    private static final String KB_HNKNMSGMONGON4 = "詳細については右ページをご確認ください。";

    private static final String KB_HNKNMSGMONGON5 = "今後とも変わらぬご愛顧を賜りますようお願いいたします。";

    private static final String KB_HNKNMSGMONGON_HRKHY1 = "本通知に記載のご契約はお払込不要となりましたので、クレ";

    private static final String KB_HNKNMSGMONGON_HRKHY2 = "ジットカードでお支払いいただきました以下の保険料を返金";

    private static final String KB_HNKNMSGMONGON_HRKHY3 = "させていただきます。";

    private static final String KB_HNKNMSGMONGON_NJYNYKN1 = "本通知に記載のご契約は二重にご入金いただきましたので、";

    private static final String KB_HNKNMSGMONGON_NJYNYKN2 = "クレジットカードでお支払いいただきました以下の保険料を";

    private static final String KB_HNKNMSGMONGON_NJYNYKN3 = "返金させていただきます。";

    private static final String KB_HNKNMSGMONGON_KAJYHS1 = "本通知に記載のご契約は、ご利用額を保険料に充当しました";

    private static final String KB_HNKNMSGMONGON_KAJYHS2 = "ところ過剰金が生じましたので、クレジットカードでお支払";

    private static final String KB_HNKNMSGMONGON_KAJYHS3 = "いいただきました以下の保険料を返金させていただきます。";

    private static final String KB_HNKNMSGMONGON_MSDHNKN1 = "本通知に記載のご契約の、クレジットカードでお支払いいた";

    private static final String KB_HNKNMSGMONGON_MSDHNKN2 = "だきました以下の保険料を返金させていただきます。";

    private static final String KB_HNKNMSGMONGON_MSDHNKN3 = "";

    private static final String KB_HNKNMSGMONGON_IGAI1 = "本通知に記載のご契約の、クレジットカードでお支払いいた";

    private static final String KB_HNKNMSGMONGON_IGAI2 = "だきました以下の保険料を返金させていただきます。";

    private static final String KB_HNKNMSGMONGON_IGAI3 = "";

    private static final String KB_SAKUSEIYMD = "作成日";

    private static final String KB_SYONO = "■証券番号";

    private static final String KB_ZENKAKUBLANK1 = "　";

    private static final String KB_ZENKAKUBLANK5 = "　　　　　";

    private static final String KB_ZENKAKUBLANK7 = "　　　　　　　";

    private static final String KB_ZENKAKUBLANK8 = "　　　　　　　　";

    private static final String KB_ZENKAKUBLANK12 = "　　　　　　　　　　　　";

    private static final String KB_DAI = "第";

    private static final String KB_GOU = "号";

    private static final String KB_HNKNGORYYMD = "■返金ご利用日";

    private static final String KB_HNKNGK = "■返金額";

    private static final String KB_YEN = "円";

    private static final String KB_HNKNTSHKR = "■返金対象となる保険料";

    private static final String KB_GORIYOUYMD = "・ご利用日";

    private static final String KB_GORIYOUGK = "・ご利用額";

    private static final String KB_PJYTYM = "・保険料充当年月";

    private static final String KB_KARA = "から";

    private static final String KB_KGTB = "か月分";

    private static final String KB_HNKNMSGHSK1 = "■クレジットカードを通じた返金について";

    private static final String KB_HNKNMSGHSK2 = "　クレジットカードを通じた返金は、マイナス金額のカード";

    private static final String KB_HNKNMSGHSK3 = "　のご利用として、当社からクレジットカード会社に売上請";

    private static final String KB_HNKNMSGHSK4 = "　求する方法で行います。";

    private static final String KB_HNKNMSGHSK5 = "　クレジットカード会社からお客さまへの返金は、クレジッ";

    private static final String KB_HNKNMSGHSK6 = "　トカード会社ごとに異なります（カードご利用代金の口座";

    private static final String KB_HNKNMSGHSK7 = "　引落し日が同日の、他のご利用代金総額から差し引きする";

    private static final String KB_HNKNMSGHSK8 = "　方法が一般的です）。";

    private static final String KB_HNKNMSGHSK9 = "　詳細はカード会社から発行されるご利用明細等にてご確認";

    private static final String KB_HNKNMSGHSK10 = "　いただくようお願いします。";

    private static final String KB_HNKNMSGHSK12 = "※ご照会・ご連絡は表面に記載の照会先へお申し付けください。";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhCreditHnknTuutiFileSksDao khCreditHnknTuutiFileSksDao;

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

        long syoriKensuu = 0;
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        String sclatoSyono = "";
        String sakuNo = "";
        String hnknmsgMongon1 = KB_HNKNMSGMONGON1;
        String hnknmsgMongon2 = "";
        String hnknmsgMongon3 = "";
        String hnknmsgMongon4 = "";
        String hnknmsgMongon5 = "";
        String hnknmsgMongon6 = KB_HNKNMSGMONGON2;
        String hnknmsgMongon7 = KB_HNKNMSGMONGON3;
        String hnknmsgMongon8 = KB_HNKNMSGMONGON4;
        String hnknmsgMongon9 = "";
        String hnknmsgMongon10 = KB_HNKNMSGMONGON5;
        String tyouhyouymdKj = "";
        String tuutisakuseiYmd = "";
        String syoNo = "";
        String hnknGk = "";
        String uriageymdKj = "";
        String goRiyougk = "";
        String jyutouKaisuum = "";
        String hnknnaiyouMongon1 = "";
        String hnknnaiyouMongon2 = "";
        String hnknnaiyouMongon3 = "";
        String hnknnaiyouMongon4 = "";
        String hnknnaiyouMongon5 = "";
        String hnknnaiyouMongon6 = "";
        String hnknnaiyouMongon7 = "";
        String hnknnaiyouMongon8 = "";
        String hnknmsgHsk1 = KB_HNKNMSGHSK1;
        String hnknmsgHsk2 = KB_HNKNMSGHSK2;
        String hnknmsgHsk3 = KB_HNKNMSGHSK3;
        String hnknmsgHsk4 = KB_HNKNMSGHSK4;
        String hnknmsgHsk5 = KB_HNKNMSGHSK5;
        String hnknmsgHsk6 = KB_HNKNMSGHSK6;
        String hnknmsgHsk7 = KB_HNKNMSGHSK7;
        String hnknmsgHsk8 = KB_HNKNMSGHSK8;
        String hnknmsgHsk9 = KB_HNKNMSGHSK9;
        String hnknmsgHsk10 = KB_HNKNMSGHSK10;
        String hnknmsgHsk11 = "";
        String hnknmsgHsk12 = KB_HNKNMSGHSK12;
        String hnknmsgHsk13 = "";
        String hnknmsgHsk14 = "";
        String hnknmsgHsk15 = "";
        String hnknmsgHsk16 = "";
        String hnknmsgHsk17 = "";
        String hnknmsgHsk18 = "";
        String hnknmsgHsk19 = "";
        String hnknmsgHsk20 = "";
        String hnskariyuu = "";
        C_HassouKbn hassouKbn = C_HassouKbn.BLNK;

        try (ExDBResults<KhCredithnknTuutiDataBean> khCredithnknTuutiDataBeanList =
            khCreditHnknTuutiFileSksDao.getKhCredithnknTuutiDataBeans(kakutyoujobCd, syoriYmd);

            EntityInserter<ZT_CreditHnknTuutiTy> creditHnknTuutiTyEntityInserter = new EntityInserter<>();
            EntityInserter<BT_TuutirirekiMeisaiHokan> tuutirirekiMeisaiHokanEntityInserter = new EntityInserter<>();) {

            for (KhCredithnknTuutiDataBean khCredithnknTuutiDataBean : khCredithnknTuutiDataBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khCredithnknTuutiDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khCredithnknTuutiDataBean.getSyono());

                long renNo = syoriKensuu + 1;

                AnsyuuSetTetudukityuuiInfo ansyuuSetTetudukityuuiInfo = SWAKInjector.getInstance(AnsyuuSetTetudukityuuiInfo.class);
                AnsyuuSetTetudukityuuiInfoBean ansyuuSetTetudukityuuiInfoBean = ansyuuSetTetudukityuuiInfo.getAnsyuuSetTetudukityuuiInfo(khCredithnknTuutiDataBean.getSyono());

                C_KktyuitaKbn kktyuitaKbn = ansyuuSetTetudukityuuiInfo.exec(khCredithnknTuutiDataBean.getSyono());
                if (C_KktyuitaKbn.DNGNMEMOARI.eq(kktyuitaKbn)) {

                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                    hnskariyuu = "Z01";
                }

                else if (C_KykdrknHtdjytKbn.SETTEI.eq(ansyuuSetTetudukityuuiInfoBean.getKykdrknhatudoujyoutaiKbn())  &&
                    C_KrkriyuuKbn.BLNK.eq(khCredithnknTuutiDataBean.getKrkriyuukbn()) &&
                    !C_ShrriyuuKbn.BLNK.eq(khCredithnknTuutiDataBean.getShrriyuukbn())){

                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                    hnskariyuu = "Z02";
                }

                else if (C_HassouKbn.HONSYAKAISOU.eq(khCredithnknTuutiDataBean.getHassoukbn()) &&
                    C_KrkriyuuKbn.BLNK.eq(khCredithnknTuutiDataBean.getKrkriyuukbn()) &&
                    !C_ShrriyuuKbn.BLNK.eq(khCredithnknTuutiDataBean.getShrriyuukbn())) {

                    hassouKbn = C_HassouKbn.HONSYAKAISOU;
                    hnskariyuu = "000";
                }

                else {

                    hassouKbn = C_HassouKbn.TYOKUSOU;
                    hnskariyuu = "000";
                }


                AnsyuKokTyouhyouHensyuu ansyuKokTyouhyouHensyuu = SWAKInjector.getInstance(AnsyuKokTyouhyouHensyuu.class);
                ansyuKokTyouhyouHensyuu.exec(khCredithnknTuutiDataBean.getSyono(), String.valueOf(renNo),
                    C_AsTyouhyoukigouKbn.AS_CREDITHENKINTUUTI, hnskariyuu);
                sclatoSyono = ansyuKokTyouhyouHensyuu.getSclatoSyono();
                sakuNo = ansyuKokTyouhyouHensyuu.getSakuseino();

                tyouhyouymdKj = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khCredithnknTuutiDataBean.getTyouhyouymd());
                tuutisakuseiYmd = KB_ZENKAKUBLANK12  + KB_SAKUSEIYMD + KB_ZENKAKUBLANK1 + tyouhyouymdKj;

                hnknmsgMongon3 = KB_HNKNMSGMONGON_IGAI1;
                hnknmsgMongon4 = KB_HNKNMSGMONGON_IGAI2;
                hnknmsgMongon5 = KB_HNKNMSGMONGON_IGAI3;

                if (!C_KrkriyuuKbn.BLNK.eq(khCredithnknTuutiDataBean.getKrkriyuukbn()) &&
                    C_ShrriyuuKbn.BLNK.eq(khCredithnknTuutiDataBean.getShrriyuukbn())) {

                    if (C_KrkriyuuKbn.SYOUMETUGONYKN.eq(khCredithnknTuutiDataBean.getKrkriyuukbn()) ||
                        C_KrkriyuuKbn.KYUUSOKUTYUUNYKN.eq(khCredithnknTuutiDataBean.getKrkriyuukbn()) ||
                        C_KrkriyuuKbn.HENKINHITUYOU.eq(khCredithnknTuutiDataBean.getKrkriyuukbn())) {

                        hnknmsgMongon3 = KB_HNKNMSGMONGON_HRKHY1;
                        hnknmsgMongon4 = KB_HNKNMSGMONGON_HRKHY2;
                        hnknmsgMongon5 = KB_HNKNMSGMONGON_HRKHY3;
                    }

                    else if (C_KrkriyuuKbn.KAZYOUNYKN.eq(khCredithnknTuutiDataBean.getKrkriyuukbn())) {

                        hnknmsgMongon3 = KB_HNKNMSGMONGON_KAJYHS1;
                        hnknmsgMongon4 = KB_HNKNMSGMONGON_KAJYHS2;
                        hnknmsgMongon5 = KB_HNKNMSGMONGON_KAJYHS3;
                    }
                }

                else if (!C_ShrriyuuKbn.BLNK.eq(khCredithnknTuutiDataBean.getShrriyuukbn())) {

                    if (C_ShrriyuuKbn.HARAIKOMIHUYOU.eq(khCredithnknTuutiDataBean.getShrriyuukbn()) ||
                        C_ShrriyuuKbn.HRHNGONYKN.eq(khCredithnknTuutiDataBean.getShrriyuukbn()) ||
                        C_ShrriyuuKbn.YUYOKKNGONYKN.eq(khCredithnknTuutiDataBean.getShrriyuukbn())) {

                        hnknmsgMongon3 = KB_HNKNMSGMONGON_HRKHY1;
                        hnknmsgMongon4 = KB_HNKNMSGMONGON_HRKHY2;
                        hnknmsgMongon5 = KB_HNKNMSGMONGON_HRKHY3;
                    }

                    else if (C_ShrriyuuKbn.NIZYUNYKN.eq(khCredithnknTuutiDataBean.getShrriyuukbn())) {

                        hnknmsgMongon3 = KB_HNKNMSGMONGON_NJYNYKN1;
                        hnknmsgMongon4 = KB_HNKNMSGMONGON_NJYNYKN2;
                        hnknmsgMongon5 = KB_HNKNMSGMONGON_NJYNYKN3;
                    }

                    else if (C_ShrriyuuKbn.KAZYOUNYKN.eq(khCredithnknTuutiDataBean.getShrriyuukbn())) {

                        hnknmsgMongon3 = KB_HNKNMSGMONGON_KAJYHS1;
                        hnknmsgMongon4 = KB_HNKNMSGMONGON_KAJYHS2;
                        hnknmsgMongon5 = KB_HNKNMSGMONGON_KAJYHS3;
                    }

                    else if (C_ShrriyuuKbn.OHTHER_MOUSIDE.eq(khCredithnknTuutiDataBean.getShrriyuukbn()) ||
                        C_ShrriyuuKbn.OHTHER.eq(khCredithnknTuutiDataBean.getShrriyuukbn())) {

                        hnknmsgMongon3 = KB_HNKNMSGMONGON_MSDHNKN1;
                        hnknmsgMongon4 = KB_HNKNMSGMONGON_MSDHNKN2;
                        hnknmsgMongon5 = KB_HNKNMSGMONGON_MSDHNKN3;
                    }
                }

                syoNo = ConvertUtil.toZenAll(khCredithnknTuutiDataBean.getSyono(), 1, 1);
                hnknnaiyouMongon1 = KB_SYONO + KB_ZENKAKUBLANK7 + KB_DAI + syoNo + KB_GOU;

                String uriageseikyuuymdKj = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khCredithnknTuutiDataBean.getUriageseikyuuymd());
                hnknnaiyouMongon2 = KB_HNKNGORYYMD + KB_ZENKAKUBLANK5 + uriageseikyuuymdKj;

                hnknGk = ConvertUtil.toZenAll(BizUtil.comma(khCredithnknTuutiDataBean.getHnkngk().toString()), 1, 1);
                hnknnaiyouMongon3 = KB_HNKNGK + KB_ZENKAKUBLANK8 + hnknGk + KB_ZENKAKUBLANK1 + KB_YEN;

                if (C_UmuKbn.ARI.eq(khCredithnknTuutiDataBean.getHnkntaisyouinjiflg())) {

                    uriageymdKj = FixedDateFormatter.formatYMDZenkakuSeirekiKanji(khCredithnknTuutiDataBean.getUriageymd());
                    hnknnaiyouMongon5 = KB_HNKNTSHKR;
                    hnknnaiyouMongon6 = KB_GORIYOUYMD + KB_ZENKAKUBLANK7 + uriageymdKj;
                    goRiyougk = ConvertUtil.toZenAll(BizUtil.comma(khCredithnknTuutiDataBean.getUriagegk().toString()), 1, 1);
                    hnknnaiyouMongon7 = KB_GORIYOUGK + KB_ZENKAKUBLANK7 + goRiyougk + KB_ZENKAKUBLANK1 + KB_YEN;
                    String pjytYm = FixedDateFormatter.formatYMZenkakuSeirekiKanji(khCredithnknTuutiDataBean.getJyuutouym().getFirstDay());
                    jyutouKaisuum = ConvertUtil.toZenAll(String.valueOf(khCredithnknTuutiDataBean.getJyutoukaisuum()), 1, 1);
                    hnknnaiyouMongon8 = KB_PJYTYM + pjytYm + KB_KARA + jyutouKaisuum + KB_KGTB;
                }

                else {

                    hnknnaiyouMongon5 = "";
                    hnknnaiyouMongon6 = "";
                    hnknnaiyouMongon7 = "";
                    hnknnaiyouMongon8 = "";
                }

                ZT_CreditHnknTuutiTy creditHnknTuutiTy = new ZT_CreditHnknTuutiTy();
                creditHnknTuutiTy.setZtysyoruicd(C_SyoruiCdKbn.AS_CREDITHENKINTUUTI.getValue().toUpperCase());
                creditHnknTuutiTy.setZtyhassoukbn(hassouKbn.getValue());
                creditHnknTuutiTy.setZtytyouhyouymd(String.valueOf(khCredithnknTuutiDataBean.getTyouhyouymd()));
                creditHnknTuutiTy.setZtytyouhyouymdkj(tyouhyouymdKj);
                creditHnknTuutiTy.setZtysyono(khCredithnknTuutiDataBean.getSyono());
                creditHnknTuutiTy.setZtysikibetuno(khCredithnknTuutiDataBean.getHenkousikibetukey());
                creditHnknTuutiTy.setZtyshskyno(khCredithnknTuutiDataBean.getShskyno());
                creditHnknTuutiTy.setZtyshskadr1kj(khCredithnknTuutiDataBean.getShsadr1kj());
                creditHnknTuutiTy.setZtyshskadr2kj(khCredithnknTuutiDataBean.getShsadr2kj());
                creditHnknTuutiTy.setZtyshskadr3kj(khCredithnknTuutiDataBean.getShsadr3kj());
                creditHnknTuutiTy.setZtyshsnmkj(khCredithnknTuutiDataBean.getShsnmkj());
                creditHnknTuutiTy.setZtytawsosikikj(khCredithnknTuutiDataBean.getToiawasesosikinmkj());
                creditHnknTuutiTy.setZtytawyno(khCredithnknTuutiDataBean.getToiawaseyno());
                creditHnknTuutiTy.setZtytawadr1kj(khCredithnknTuutiDataBean.getToiawaseadr1kj());
                creditHnknTuutiTy.setZtytawadr2kj(khCredithnknTuutiDataBean.getToiawaseadr2kj());
                creditHnknTuutiTy.setZtytawadr3kj(khCredithnknTuutiDataBean.getToiawaseadr3kj());
                creditHnknTuutiTy.setZtytawtelnov14(khCredithnknTuutiDataBean.getToiawasetelno());
                creditHnknTuutiTy.setZtytawteluktkkanou1(khCredithnknTuutiDataBean.getToiawaseteluktkkanou1());
                creditHnknTuutiTy.setZtytawteluktkkanou2(khCredithnknTuutiDataBean.getToiawaseteluktkkanou2());
                creditHnknTuutiTy.setZtydai2tawsosikinmkj(khCredithnknTuutiDataBean.getToiawasesosikinmkj2());
                creditHnknTuutiTy.setZtydai2tawtelno(khCredithnknTuutiDataBean.getToiawasetelno2());
                creditHnknTuutiTy.setZtysclatosyono(sclatoSyono);
                creditHnknTuutiTy.setZtysakunm15keta(sakuNo);
                creditHnknTuutiTy.setZtyhnknmsgmongon1(hnknmsgMongon1);
                creditHnknTuutiTy.setZtyhnknmsgmongon2(hnknmsgMongon2);
                creditHnknTuutiTy.setZtyhnknmsgmongon3(hnknmsgMongon3);
                creditHnknTuutiTy.setZtyhnknmsgmongon4(hnknmsgMongon4);
                creditHnknTuutiTy.setZtyhnknmsgmongon5(hnknmsgMongon5);
                creditHnknTuutiTy.setZtyhnknmsgmongon6(hnknmsgMongon6);
                creditHnknTuutiTy.setZtyhnknmsgmongon7(hnknmsgMongon7);
                creditHnknTuutiTy.setZtyhnknmsgmongon8(hnknmsgMongon8);
                creditHnknTuutiTy.setZtyhnknmsgmongon9(hnknmsgMongon9);
                creditHnknTuutiTy.setZtyhnknmsgmongon10(hnknmsgMongon10);
                creditHnknTuutiTy.setZtytuutisakuseiymdv32(tuutisakuseiYmd);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon1(hnknnaiyouMongon1);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon2(hnknnaiyouMongon2);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon3(hnknnaiyouMongon3);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon4(hnknnaiyouMongon4);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon5(hnknnaiyouMongon5);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon6(hnknnaiyouMongon6);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon7(hnknnaiyouMongon7);
                creditHnknTuutiTy.setZtyhnknnaiyoumongon8(hnknnaiyouMongon8);
                creditHnknTuutiTy.setZtyhnknmsghsk1(hnknmsgHsk1);
                creditHnknTuutiTy.setZtyhnknmsghsk2(hnknmsgHsk2);
                creditHnknTuutiTy.setZtyhnknmsghsk3(hnknmsgHsk3);
                creditHnknTuutiTy.setZtyhnknmsghsk4(hnknmsgHsk4);
                creditHnknTuutiTy.setZtyhnknmsghsk5(hnknmsgHsk5);
                creditHnknTuutiTy.setZtyhnknmsghsk6(hnknmsgHsk6);
                creditHnknTuutiTy.setZtyhnknmsghsk7(hnknmsgHsk7);
                creditHnknTuutiTy.setZtyhnknmsghsk8(hnknmsgHsk8);
                creditHnknTuutiTy.setZtyhnknmsghsk9(hnknmsgHsk9);
                creditHnknTuutiTy.setZtyhnknmsghsk10(hnknmsgHsk10);
                creditHnknTuutiTy.setZtyhnknmsghsk11(hnknmsgHsk11);
                creditHnknTuutiTy.setZtyhnknmsghsk12(hnknmsgHsk12);
                creditHnknTuutiTy.setZtyhnknmsghsk13(hnknmsgHsk13);
                creditHnknTuutiTy.setZtyhnknmsghsk14(hnknmsgHsk14);
                creditHnknTuutiTy.setZtyhnknmsghsk15(hnknmsgHsk15);
                creditHnknTuutiTy.setZtyhnknmsghsk16(hnknmsgHsk16);
                creditHnknTuutiTy.setZtyhnknmsghsk17(hnknmsgHsk17);
                creditHnknTuutiTy.setZtyhnknmsghsk18(hnknmsgHsk18);
                creditHnknTuutiTy.setZtyhnknmsghsk19(hnknmsgHsk19);
                creditHnknTuutiTy.setZtyhnknmsghsk20(hnknmsgHsk20);
                BizPropertyInitializer.initialize(creditHnknTuutiTy);
                creditHnknTuutiTyEntityInserter.add(creditHnknTuutiTy);

                String renbanKekka = RenbanUtil.getRenbanAsString(Integer.parseInt(C_NosyuruiKbn.TUUTIRIREKIRENNO.getValue()));
                BT_TuutirirekiMeisaiHokan tuutirirekiMeisaiHokan = new BT_TuutirirekiMeisaiHokan();
                tuutirirekiMeisaiHokan.setTuutirirekirenno(renbanKekka);
                tuutirirekiMeisaiHokan.setTuutirirekino(C_TuutirirekiTaisyouKbn.SYOUKENNO.getValue() + khCredithnknTuutiDataBean.getSyono());
                tuutirirekiMeisaiHokan.setTuutisakuseiymd(syoriYmd);
                tuutirirekiMeisaiHokan.setTuutisakuseino(Integer.valueOf(0));
                tuutirirekiMeisaiHokan.setTuutisyuruicd(kinou.getSyoricd() + "0001");
                tuutirirekiMeisaiHokan.setHyoujiyoutuutisakuseiymd(syoriYmd);
                BizPropertyInitializer.initialize(tuutirirekiMeisaiHokan);
                tuutirirekiMeisaiHokanEntityInserter.add(tuutirirekiMeisaiHokan);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
