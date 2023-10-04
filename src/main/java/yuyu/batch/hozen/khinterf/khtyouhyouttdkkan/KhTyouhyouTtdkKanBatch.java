package yuyu.batch.hozen.khinterf.khtyouhyouttdkkan;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Strings;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.db.entity.ZT_TtdkKanTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 手続完了Ｆ作成クラス
 */
public class KhTyouhyouTtdkKanBatch implements Batch {

    public final String TABLE_ID = "IT_TtdkKan";

    public final String FILTER_ID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;
        C_SyoruiCdKbn[] syoruiCdKbnLst = new C_SyoruiCdKbn[24];

        syoruiCdKbnLst[0] = C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR;
        syoruiCdKbnLst[1] = C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR;
        syoruiCdKbnLst[2] = C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR;
        syoruiCdKbnLst[3] = C_SyoruiCdKbn.KK_SEINENGAPPISEI_TTDKKR_SHRARI;
        syoruiCdKbnLst[4] = C_SyoruiCdKbn.KK_GENGAKU_TTDKKR;
        syoruiCdKbnLst[5] = C_SyoruiCdKbn.KK_GENGAKU_ZEITEKI_TTDKKR;
        syoruiCdKbnLst[6] = C_SyoruiCdKbn.KK_STDRHNK_TTDKKR;
        syoruiCdKbnLst[7] = C_SyoruiCdKbn.KK_KAIGOMAETKHNK_TTDKKR;
        syoruiCdKbnLst[8] = C_SyoruiCdKbn.KK_MKHGKHNK_TTDKKR;
        syoruiCdKbnLst[9] = C_SyoruiCdKbn.KK_TUMITATEKINITEN_TTDKKR;
        syoruiCdKbnLst[10] = C_SyoruiCdKbn.KK_KAIYAKU_TTDKKR;
        syoruiCdKbnLst[11] = C_SyoruiCdKbn.KK_SYOUMETU_GAIBU_TTDKKR;
        syoruiCdKbnLst[12] = C_SyoruiCdKbn.KK_YENDTHNKHNRKN_TTDKKR;
        syoruiCdKbnLst[13] = C_SyoruiCdKbn.KK_YENDTHNK_HNRKNSKS_TTDKKR;
        syoruiCdKbnLst[14] = C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR;
        syoruiCdKbnLst[15] = C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_3;
        syoruiCdKbnLst[16] = C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR_2;
        syoruiCdKbnLst[17] = C_SyoruiCdKbn.KK_YENDTHNK_TTDKKR_2;
        syoruiCdKbnLst[18] = C_SyoruiCdKbn.KK_YENDTHNK_NINI_TTDKKR;
        syoruiCdKbnLst[19] = C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR;
        syoruiCdKbnLst[20] = C_SyoruiCdKbn.KK_DTUIBARAI_TTDKKR_ZEIMUNASI;
        syoruiCdKbnLst[21] = C_SyoruiCdKbn.KK_KZKTRKKYKDRHNK_TTDKKR;
        syoruiCdKbnLst[22] = C_SyoruiCdKbn.KK_KZKTRKTYOKUSOU_TTDKKR;
        syoruiCdKbnLst[23] = C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR;

        try (ExDBResults<IT_TtdkKan> ttdkKanLst = hozenDomManager.getTtdkKansByKakutyoujobcdTyouhyouymdSyoruiCds(
            bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd(), syoruiCdKbnLst);

            EntityInserter<ZT_TtdkKanTy> ttdkKanTyLst = new EntityInserter<>();) {

            for (IT_TtdkKan ttdkKan : ttdkKanLst) {

                C_UmuKbn umuKbn = null;
                BizCurrency ztyshrgkmeisai1 = null;
                BizCurrency ztyshrgkmeisai2 = null;
                BizCurrency ztyshrgkmeisai3 = null;
                BizCurrency ztyshrgkmeisai4 = null;
                BizCurrency ztyshrgkmeisai5 = null;
                BizCurrency ztyshrgkmeisai6 = null;
                BizCurrency ztyshrgkmeisai7 = null;
                BizCurrency ztyshrgkmeisai8 = null;
                BizCurrency ztyshrgkmeisai9 = null;
                BizCurrency ztyshrgkmeisai10 = null;
                BizCurrency shrgkkei = null;
                String htykeihituukasyu = null;
                String shrkykhtykeihituukasyu = null;
                String gsbunrihtykeihituukasyu = null;
                String gsbunrisaekituukasyu = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(ttdkKan.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(ttdkKan.getSyono());

                if (C_SyoruiCdKbn.KK_SYOSAIHK_TTDKKR.eq(ttdkKan.getSyoruiCd())) {

                    umuKbn = C_UmuKbn.NONE;
                }
                else {

                    umuKbn = ttdkKan.getSyoukendhumukbn();
                }

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai1().getType()))) {
                    ztyshrgkmeisai1 = ttdkKan.getKngkmeisai1().multiply(100);
                } else {
                    ztyshrgkmeisai1 = ttdkKan.getKngkmeisai1();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai2().getType()))) {
                    ztyshrgkmeisai2 = ttdkKan.getKngkmeisai2().multiply(100);
                } else {
                    ztyshrgkmeisai2 = ttdkKan.getKngkmeisai2();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai3().getType()))) {
                    ztyshrgkmeisai3 = ttdkKan.getKngkmeisai3().multiply(100);
                } else {
                    ztyshrgkmeisai3 = ttdkKan.getKngkmeisai3();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai4().getType()))) {
                    ztyshrgkmeisai4 = ttdkKan.getKngkmeisai4().multiply(100);
                } else {
                    ztyshrgkmeisai4 = ttdkKan.getKngkmeisai4();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai5().getType()))) {
                    ztyshrgkmeisai5 = ttdkKan.getKngkmeisai5().multiply(100);
                } else {
                    ztyshrgkmeisai5 = ttdkKan.getKngkmeisai5();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai6().getType()))) {
                    ztyshrgkmeisai6 = ttdkKan.getKngkmeisai6().multiply(100);
                } else {
                    ztyshrgkmeisai6 = ttdkKan.getKngkmeisai6();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai7().getType()))) {
                    ztyshrgkmeisai7 = ttdkKan.getKngkmeisai7().multiply(100);
                } else {
                    ztyshrgkmeisai7 = ttdkKan.getKngkmeisai7();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai8().getType()))) {
                    ztyshrgkmeisai8 = ttdkKan.getKngkmeisai8().multiply(100);
                } else {
                    ztyshrgkmeisai8 = ttdkKan.getKngkmeisai8();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai9().getType()))) {
                    ztyshrgkmeisai9 = ttdkKan.getKngkmeisai9().multiply(100);
                } else {
                    ztyshrgkmeisai9 = ttdkKan.getKngkmeisai9();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getKngkmeisai10().getType()))) {
                    ztyshrgkmeisai10 = ttdkKan.getKngkmeisai10().multiply(100);
                } else {
                    ztyshrgkmeisai10 = ttdkKan.getKngkmeisai10();
                }
                if (!C_Tuukasyu.JPY.eq(henkanTuuka.henkanTuukaTypeToKbn(ttdkKan.getShrgkkei().getType()))) {
                    shrgkkei = ttdkKan.getShrgkkei().multiply(100);
                } else {
                    shrgkkei = ttdkKan.getShrgkkei();
                }

                if (C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUNASI.equals(ttdkKan.getZeimunaiyouhensyuctrlkbn())) {
                    htykeihituukasyu = C_Tuukasyu.JPY.getValue();
                    shrkykhtykeihituukasyu = "";
                    gsbunrihtykeihituukasyu = "";
                    gsbunrisaekituukasyu = "";
                }
                else if (C_ZeimuNaiyouHnsyuCtrlKbn.KYKHENKOUKAISUUARI.equals(ttdkKan.getZeimunaiyouhensyuctrlkbn())) {
                    htykeihituukasyu = C_Tuukasyu.JPY.getValue();
                    shrkykhtykeihituukasyu = C_Tuukasyu.JPY.getValue();
                    gsbunrihtykeihituukasyu = "";
                    gsbunrisaekituukasyu = "";
                }
                else if (C_ZeimuNaiyouHnsyuCtrlKbn.KYKSYASIBOUKAIYAKU.equals(ttdkKan.getZeimunaiyouhensyuctrlkbn())) {
                    htykeihituukasyu = "";
                    shrkykhtykeihituukasyu = "";
                    gsbunrihtykeihituukasyu = "";
                    gsbunrisaekituukasyu = "";
                }
                else if (C_ZeimuNaiyouHnsyuCtrlKbn.GSTSZEIGK_ARI.eq(ttdkKan.getZeimunaiyouhensyuctrlkbn())) {
                    htykeihituukasyu = "";
                    shrkykhtykeihituukasyu = "";
                    gsbunrihtykeihituukasyu = C_Tuukasyu.JPY.getValue();
                    gsbunrisaekituukasyu = C_Tuukasyu.JPY.getValue();
                }
                else {
                    htykeihituukasyu = C_Tuukasyu.JPY.getValue();
                    shrkykhtykeihituukasyu = C_Tuukasyu.JPY.getValue();
                    gsbunrihtykeihituukasyu = "";
                    gsbunrisaekituukasyu = "";
                }

                ZT_TtdkKanTy ttdkKanTy = new ZT_TtdkKanTy();

                ttdkKanTy.setZtysyoruicd(ttdkKan.getSyoruiCd().getValue().toUpperCase());
                ttdkKanTy.setZtytyouhyouymd(getStirngValueByBN(ttdkKan.getTyouhyouymd()));
                ttdkKanTy.setZtytyouhyouymdwa(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(ttdkKan.getTyouhyouymd()));
                ttdkKanTy.setZtysyono(ttdkKan.getSyono());
                ttdkKanTy.setZtyhassoukbn(ttdkKan.getHassoukbn().getValue());
                ttdkKanTy.setZtytantousitukbn(ttdkKan.getTantousitukbn().getValue());
                ttdkKanTy.setZtysyodouhuukbn(ttdkKan.getSyoukendhumukbn().getValue());
                ttdkKanTy.setZtysikibetuno(ttdkKan.getHenkousikibetukey());
                ttdkKanTy.setZtyyobiv21("");
                ttdkKanTy.setZtyshskyno(ttdkKan.getShskyno());
                ttdkKanTy.setZtyshskadr1kj(ttdkKan.getShsadr1kj());
                ttdkKanTy.setZtyshskadr2kj(ttdkKan.getShsadr2kj());
                ttdkKanTy.setZtyshskadr3kj(ttdkKan.getShsadr3kj());
                ttdkKanTy.setZtyshsnmkjttdk(ttdkKan.getShsnmkj());
                ttdkKanTy.setZtyshsnmkjttdk2(ttdkKan.getShsnmkj2());
                ttdkKanTy.setZtyyobiv3("");
                ttdkKanTy.setZtytawyno(ttdkKan.getToiawaseyno());
                ttdkKanTy.setZtytawadr1kj(ttdkKan.getToiawaseadr1kj());
                ttdkKanTy.setZtytawadr2kj(ttdkKan.getToiawaseadr2kj());
                ttdkKanTy.setZtytoiawasekaisyanmkj(ttdkKan.getToiawasekaisyanmkj());
                ttdkKanTy.setZtytawsosikikj(ttdkKan.getToiawasesosikinmkj());
                ttdkKanTy.setZtytawtelnov14(ttdkKan.getToiawasetelno());
                ttdkKanTy.setZtytawteluktkkanou1x18keta(ttdkKan.getToiawaseteluktkkanou1());
                ttdkKanTy.setZtytawteluktkkanou2x18keta(ttdkKan.getToiawaseteluktkkanou2());
                ttdkKanTy.setZtyyobiv26("");
                ttdkKanTy.setZtytetudukisyunm(ttdkKan.getTetudukisyukbn().getContent(C_TetudukisyuKbn.PATTERN_REPORT));
                ttdkKanTy.setZtysyokakmngnumkbn(umuKbn.getValue());
                ttdkKanTy.setZtysyono2(ttdkKan.getSyono());
                ttdkKanTy.setZtykyknmkj(ttdkKan.getKyknmkj());
                ttdkKanTy.setZtyhhknnmkj(ttdkKan.getHhknnmkj());
                ttdkKanTy.setZtyyobiv28("");
                ttdkKanTy.setZtyttdknaiyou1(ttdkKan.getTtdknaiyou1());
                ttdkKanTy.setZtyttdknaiyou2(ttdkKan.getTtdknaiyou2());
                ttdkKanTy.setZtyttdknaiyou3(ttdkKan.getTtdknaiyou3());
                ttdkKanTy.setZtyttdknaiyou4(ttdkKan.getTtdknaiyou4());
                ttdkKanTy.setZtyttdknaiyou5(ttdkKan.getTtdknaiyou5());
                ttdkKanTy.setZtyttdknaiyou6(ttdkKan.getTtdknaiyou6());
                ttdkKanTy.setZtyttdknaiyou7(ttdkKan.getTtdknaiyou7());
                ttdkKanTy.setZtyttdknaiyou8(ttdkKan.getTtdknaiyou8());
                ttdkKanTy.setZtyttdknaiyou9(ttdkKan.getTtdknaiyou9());
                ttdkKanTy.setZtyttdknaiyou10(ttdkKan.getTtdknaiyou10());
                ttdkKanTy.setZtyttdknaiyouumukbn(ttdkKan.getTtdknaiyouumukbn().getValue());
                ttdkKanTy.setZtykykniyuhnkkbn(ttdkKan.getKykniyuhnkkbn().getValue());
                ttdkKanTy.setZtykykniyuhnkymd(
                    FixedDateFormatter.formatYMDZenkakuSeirekiKanji(ttdkKan.getKykniyuhnkymd()));
                ttdkKanTy.setZtykykniyuhnkinfo(ttdkKan.getKykniyuhnkinfo());
                ttdkKanTy.setZtykykniyuhnkkngkhugou1(ttdkKan.getKykniyuhnkgkhugou1().getValue());
                ttdkKanTy.setZtykykniyuhnkkngk1(getStringValueByBC(ttdkKan.getKykniyuhnkkngk1()));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKykniyuhnkkngktuksyu1())) {
                    ttdkKanTy.setZtykykniyuhnkkngktuksyu1("");
                }
                else {
                    ttdkKanTy.setZtykykniyuhnkkngktuksyu1(ttdkKan.getKykniyuhnkkngktuksyu1().getValue());
                }
                ttdkKanTy.setZtykykniyuhnkkngkhugou2(ttdkKan.getKykniyuhnkkngkhugou2().getValue());
                ttdkKanTy.setZtykykniyuhnkkngk2(getStringValueByBC(ttdkKan.getKykniyuhnkkngk2()));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKykniyuhnkkngktuksyu2())) {
                    ttdkKanTy.setZtykykniyuhnkkngktuksyu2("");
                }
                else {
                    ttdkKanTy.setZtykykniyuhnkkngktuksyu2(ttdkKan.getKykniyuhnkkngktuksyu2().getValue());
                }
                ttdkKanTy.setZtyyobiv102("");
                ttdkKanTy.setZtysiharaibiwareki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(ttdkKan.getShrymd()));
                ttdkKanTy.setZtykaiyakuymdwa(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(ttdkKan.getKaiykymd()));
                ttdkKanTy.setZtytekiyou1(ttdkKan.getTekiyou1());
                ttdkKanTy.setZtyshrkngkmeisaihugou1(ttdkKan.getShrkngkmeisaihugou1().getValue());
                ttdkKanTy.setZtyshrgkmeisai1(getStringValueByBC(ztyshrgkmeisai1));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu1())) {
                    ttdkKanTy.setZtyshrgktuukasyu1("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu1(ttdkKan.getKngkmisituukasyu1().getValue());
                }
                ttdkKanTy.setZtybikou1(ttdkKan.getBikou1());
                ttdkKanTy.setZtytekiyou2(ttdkKan.getTekiyou2());
                ttdkKanTy.setZtyshrkngkmeisaihugou2(ttdkKan.getShrkngkmeisaihugou2().getValue());
                ttdkKanTy.setZtyshrgkmeisai2(getStringValueByBC(ztyshrgkmeisai2));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu2())) {
                    ttdkKanTy.setZtyshrgktuukasyu2("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu2(ttdkKan.getKngkmisituukasyu2().getValue());
                }
                ttdkKanTy.setZtybikou2(ttdkKan.getBikou2());
                ttdkKanTy.setZtytekiyou3(ttdkKan.getTekiyou3());
                ttdkKanTy.setZtyshrkngkmeisaihugou3(ttdkKan.getShrkngkmeisaihugou3().getValue());
                ttdkKanTy.setZtyshrgkmeisai3(getStringValueByBC(ztyshrgkmeisai3));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu3())) {
                    ttdkKanTy.setZtyshrgktuukasyu3("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu3(ttdkKan.getKngkmisituukasyu3().getValue());
                }
                ttdkKanTy.setZtybikou3(ttdkKan.getBikou3());
                ttdkKanTy.setZtytekiyou4(ttdkKan.getTekiyou4());
                ttdkKanTy.setZtyshrkngkmeisaihugou4(ttdkKan.getShrkngkmeisaihugou4().getValue());
                ttdkKanTy.setZtyshrgkmeisai4(getStringValueByBC(ztyshrgkmeisai4));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu4())) {
                    ttdkKanTy.setZtyshrgktuukasyu4("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu4(ttdkKan.getKngkmisituukasyu4().getValue());
                }
                ttdkKanTy.setZtybikou4(ttdkKan.getBikou4());
                ttdkKanTy.setZtytekiyou5(ttdkKan.getTekiyou5());
                ttdkKanTy.setZtyshrkngkmeisaihugou5(ttdkKan.getShrkngkmeisaihugou5().getValue());
                ttdkKanTy.setZtyshrgkmeisai5(getStringValueByBC(ztyshrgkmeisai5));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu5())) {
                    ttdkKanTy.setZtyshrgktuukasyu5("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu5(ttdkKan.getKngkmisituukasyu5().getValue());
                }
                ttdkKanTy.setZtybikou5(ttdkKan.getBikou5());
                ttdkKanTy.setZtytekiyou6(ttdkKan.getTekiyou6());
                ttdkKanTy.setZtyshrkngkmeisaihugou6(ttdkKan.getShrkngkmeisaihugou6().getValue());
                ttdkKanTy.setZtyshrgkmeisai6(getStringValueByBC(ztyshrgkmeisai6));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu6())) {
                    ttdkKanTy.setZtyshrgktuukasyu6("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu6(ttdkKan.getKngkmisituukasyu6().getValue());
                }
                ttdkKanTy.setZtybikou6(ttdkKan.getBikou6());
                ttdkKanTy.setZtytekiyou7(ttdkKan.getTekiyou7());
                ttdkKanTy.setZtyshrkngkmeisaihugou7(ttdkKan.getShrkngkmeisaihugou7().getValue());
                ttdkKanTy.setZtyshrgkmeisai7(getStringValueByBC(ztyshrgkmeisai7));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu7())) {
                    ttdkKanTy.setZtyshrgktuukasyu7("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu7(ttdkKan.getKngkmisituukasyu7().getValue());
                }
                ttdkKanTy.setZtybikou7(ttdkKan.getBikou7());
                ttdkKanTy.setZtytekiyou8(ttdkKan.getTekiyou8());
                ttdkKanTy.setZtyshrkngkmeisaihugou8(ttdkKan.getShrkngkmeisaihugou8().getValue());
                ttdkKanTy.setZtyshrgkmeisai8(getStringValueByBC(ztyshrgkmeisai8));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu8())) {
                    ttdkKanTy.setZtyshrgktuukasyu8("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu8(ttdkKan.getKngkmisituukasyu8().getValue());
                }
                ttdkKanTy.setZtybikou8(ttdkKan.getBikou8());
                ttdkKanTy.setZtytekiyou9(ttdkKan.getTekiyou9());
                ttdkKanTy.setZtyshrkngkmeisaihugou9(ttdkKan.getShrkngkmeisaihugou9().getValue());
                ttdkKanTy.setZtyshrgkmeisai9(getStringValueByBC(ztyshrgkmeisai9));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu9())) {
                    ttdkKanTy.setZtyshrgktuukasyu9("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu9(ttdkKan.getKngkmisituukasyu9().getValue());
                }
                ttdkKanTy.setZtybikou9(ttdkKan.getBikou9());
                ttdkKanTy.setZtytekiyou10(ttdkKan.getTekiyou10());
                ttdkKanTy.setZtyshrkngkmeisaihugou10(ttdkKan.getShrkngkmeisaihugou10().getValue());
                ttdkKanTy.setZtyshrgkmeisai10(getStringValueByBC(ztyshrgkmeisai10));
                if (C_Tuukasyu.BLNK.eq(ttdkKan.getKngkmisituukasyu10())) {
                    ttdkKanTy.setZtyshrgktuukasyu10("");
                }
                else {
                    ttdkKanTy.setZtyshrgktuukasyu10(ttdkKan.getKngkmisituukasyu10().getValue());
                }
                ttdkKanTy.setZtybikou10(ttdkKan.getBikou10());
                ttdkKanTy.setZtyshrgkgoukei(getStringValueByBC(shrgkkei));
                ttdkKanTy.setZtyshrtuukasyu(ttdkKan.getShrtuukasyu().getValue());
                ttdkKanTy.setZtydseisanshrttdknm(ttdkKan.getDseisanshrttdknm());
                ttdkKanTy.setZtyyobiv26x3("");
                ttdkKanTy.setZtybanknmkj(ttdkKan.getBanknmkj());
                ttdkKanTy.setZtysitennmkj(ttdkKan.getSitennmkj());
                ttdkKanTy.setZtyyokinkbn(ttdkKan.getYokinkbn().getValue());
                ttdkKanTy.setZtykouzano12keta(ttdkKan.getKouzano());
                ttdkKanTy.setZtykzmeiginmknhan(ttdkKan.getKzmeiginmkn());
                ttdkKanTy.setZtykouzasyuruikbn(ttdkKan.getKzsyuruikbn().getValue());
                ttdkKanTy.setZtyyobiv26x2("");
                ttdkKanTy.setZtysynykngk(getStringValueByBC(ttdkKan.getSynykngk()));
                ttdkKanTy.setZtysynykngktuukasyu(String.valueOf(C_Tuukasyu.JPY));
                ttdkKanTy.setZtyhtykeihi(getStringValueByBC(ttdkKan.getHtykeihi()));
                ttdkKanTy.setZtyhtykeihituukasyu(htykeihituukasyu);
                ttdkKanTy.setZtygsbnrkzthtykeihi(getStringValueByBC(ttdkKan.getHtykeihi()));
                ttdkKanTy.setZtygsbnrkzthtykeihituksyu(gsbunrihtykeihituukasyu);
                ttdkKanTy.setZtygsbnrkztsaeki(getStringValueByBC(ttdkKan.getGsbnrkztsaeki()));
                ttdkKanTy.setZtygsbnrkztsaekituksyu(gsbunrisaekituukasyu);
                ttdkKanTy.setZtyshrkyksyahtykeihi(getStringValueByBC(ttdkKan.getShrkykhtykeihi()));
                ttdkKanTy.setZtyshrkykhtykeihituukasyu(shrkykhtykeihituukasyu);
                ttdkKanTy.setZtyzeimunaiyouhensyuctrlkbn(ttdkKan.getZeimunaiyouhensyuctrlkbn().getValue());
                ttdkKanTy.setZtyzeimumongonoutkbn(ttdkKan.getZeimumongonoutkbn().getValue());
                ttdkKanTy.setZtyzeimumongon1(ttdkKan.getZeimumongon1());
                ttdkKanTy.setZtyzeimumongon2(ttdkKan.getZeimumongon2());
                ttdkKanTy.setZtyzeimumongon3(ttdkKan.getZeimumongon3());
                ttdkKanTy.setZtyzeimumongon4(ttdkKan.getZeimumongon4());
                ttdkKanTy.setZtyzeimumongon5(ttdkKan.getZeimumongon5());
                ttdkKanTy.setZtyyendthnkzeimuinfohskkbn(ttdkKan.getYendthnkzeimuinfohskkbn().getValue());
                ttdkKanTy.setZtyyobiv36("");
                ttdkKanTy.setZtyosirasehyoudai(ttdkKan.getOsirasemongonhyoudai());
                ttdkKanTy.setZtyosirasemongon1(ttdkKan.getOsirasemongon1());
                ttdkKanTy.setZtyosirasemongon2(ttdkKan.getOsirasemongon2());
                ttdkKanTy.setZtyosirasemongon3(ttdkKan.getOsirasemongon3());
                ttdkKanTy.setZtyosirasemongon4(ttdkKan.getOsirasemongon4());
                ttdkKanTy.setZtyosirasemongon5(ttdkKan.getOsirasemongon5());
                ttdkKanTy.setZtyosirasemongon6(ttdkKan.getOsirasemongon6());
                ttdkKanTy.setZtyosirasemongon7(ttdkKan.getOsirasemongon7());
                ttdkKanTy.setZtyosirasemongon8(ttdkKan.getOsirasemongon8());
                ttdkKanTy.setZtyosirasemongon9(ttdkKan.getOsirasemongon9());
                ttdkKanTy.setZtyosirasemongon10(ttdkKan.getOsirasemongon10());
                ttdkKanTy.setZtyosirasemongon11(ttdkKan.getOsirasemongon11());
                ttdkKanTy.setZtyosirasemongon12(ttdkKan.getOsirasemongon12());
                ttdkKanTy.setZtyosirasemongon13(ttdkKan.getOsirasemongon13());
                ttdkKanTy.setZtyosirasemongon14(ttdkKan.getOsirasemongon14());
                ttdkKanTy.setZtyosirasemongon15(ttdkKan.getOsirasemongon15());
                ttdkKanTy.setZtyosirasemongon16(ttdkKan.getOsirasemongon16());
                ttdkKanTy.setZtyosirasemongon17(ttdkKan.getOsirasemongon17());
                ttdkKanTy.setZtyosirasemongon18(ttdkKan.getOsirasemongon18());
                ttdkKanTy.setZtyosirasemongon19(ttdkKan.getOsirasemongon19());
                ttdkKanTy.setZtyosirasemongon20(ttdkKan.getOsirasemongon20());
                ttdkKanTy.setZtyosirasemongon21(ttdkKan.getOsirasemongon21());
                ttdkKanTy.setZtyosirasemongon22(ttdkKan.getOsirasemongon22());
                ttdkKanTy.setZtyosirasemongon23(ttdkKan.getOsirasemongon23());
                ttdkKanTy.setZtyosirasemongon24(ttdkKan.getOsirasemongon24());
                ttdkKanTy.setZtyosirasemongon25(ttdkKan.getOsirasemongon25());
                ttdkKanTy.setZtyosirasemongon26(ttdkKan.getOsirasemongon26());
                ttdkKanTy.setZtyosirasemongon27(ttdkKan.getOsirasemongon27());
                ttdkKanTy.setZtyosirasemongon28(ttdkKan.getOsirasemongon28());
                ttdkKanTy.setZtyosirasemongon29(ttdkKan.getOsirasemongon29());
                ttdkKanTy.setZtyosirasemongon30(ttdkKan.getOsirasemongon30());
                ttdkKanTy.setZtyosirasemongon31(ttdkKan.getOsirasemongon31());
                ttdkKanTy.setZtyosirasemongon32(ttdkKan.getOsirasemongon32());
                ttdkKanTy.setZtyosirasemongon33(ttdkKan.getOsirasemongon33());
                ttdkKanTy.setZtyosirasemongon34(ttdkKan.getOsirasemongon34());
                ttdkKanTy.setZtyosirasemongon35(ttdkKan.getOsirasemongon35());
                ttdkKanTy.setZtyosirasemongon36(ttdkKan.getOsirasemongon36());
                ttdkKanTy.setZtyosirasemongon37(ttdkKan.getOsirasemongon37());
                ttdkKanTy.setZtyosirasemongon38(ttdkKan.getOsirasemongon38());
                ttdkKanTy.setZtyosirasemongon39(ttdkKan.getOsirasemongon39());
                ttdkKanTy.setZtyosirasemongon40(ttdkKan.getOsirasemongon40());
                ttdkKanTy.setZtyosirasemongon41(ttdkKan.getOsirasemongon41());
                ttdkKanTy.setZtyosirasemongon42(ttdkKan.getOsirasemongon42());
                ttdkKanTy.setZtyosirasemongon43(ttdkKan.getOsirasemongon43());
                ttdkKanTy.setZtyosirasemongon44(ttdkKan.getOsirasemongon44());
                ttdkKanTy.setZtyosirasemongon45(ttdkKan.getOsirasemongon45());
                ttdkKanTy.setZtyosirasemongon46(ttdkKan.getOsirasemongon46());
                ttdkKanTy.setZtyosirasemongon47(ttdkKan.getOsirasemongon47());
                ttdkKanTy.setZtyosirasemongon48(ttdkKan.getOsirasemongon48());
                ttdkKanTy.setZtyosirasemongon49(ttdkKan.getOsirasemongon49());
                ttdkKanTy.setZtyosirasemongon50(ttdkKan.getOsirasemongon50());
                ttdkKanTy.setZtyosiraseinjihuyouhyouji(Strings.padStart(ttdkKan.getOsiraseinjihuyouhyouji(), 1, '0'));
                ttdkKanTy.setZtyyobiv254("");
                ttdkKanTy.setZtyshrnaiyouhskmongon1(ttdkKan.getShrnaiyouhskmongon1());
                ttdkKanTy.setZtyshrnaiyouhskmongon2(ttdkKan.getShrnaiyouhskmongon2());
                ttdkKanTy.setZtydocumentid(ttdkKan.getDocumentid());
                ttdkKanTy.setZtysksmongonkbn1(ttdkKan.getSksmongonkbn1().getValue());
                ttdkKanTy.setZtysksmongonkbn2(ttdkKan.getSksmongonkbn2().getValue());
                ttdkKanTy.setZtytoritugisyasyozokunm(ttdkKan.getToritugisyasyozokunm());
                ttdkKanTy.setZtytoritugisyakjncd(ttdkKan.getToritugisyakjncd());
                ttdkKanTy.setZtytoritugisyanm(ttdkKan.getToritugisyanm());
                if (ttdkKan.getHozonKikan() != null) {
                    ttdkKanTy.setZtyhozonkkny(String.valueOf(ttdkKan.getHozonKikan()));
                }
                ttdkKanTy.setZtytsintelno(ttdkKan.getTsintelno());
                ttdkKanTy.setZtyyobiv141("");

                if (C_TrkKzkKbn.BLNK.eq(ttdkKan.getTrkkzkkbn1())) {

                    if ("03".equals(ttdkKan.getKzkomttutkbn1()) && !BizUtil.isBlank(ttdkKan.getTrkkzknmkj1())) {
                        ttdkKanTy.setZtytrkkzkkbn1("3");
                    }
                    else if ("04".equals(ttdkKan.getKzkomttutkbn1()) && !BizUtil.isBlank(ttdkKan.getTrkkzknmkj1())) {
                        ttdkKanTy.setZtytrkkzkkbn1("3");
                    }
                    else {
                        ttdkKanTy.setZtytrkkzkkbn1(ttdkKan.getTrkkzkkbn1().getValue());
                    }
                }
                else {
                    ttdkKanTy.setZtytrkkzkkbn1(ttdkKan.getTrkkzkkbn1().getValue());
                }

                ttdkKanTy.setZtytrkkzknmkj1(ttdkKan.getTrkkzknmkj1());
                ttdkKanTy.setZtytrkkzkseiymd1zenkaku(FixedDateFormatter.formatYMDZenkakuWarekiKanji(ttdkKan.getTrkkzkseiymd1()));
                ttdkKanTy.setZtytrkkzkyno1(ttdkKan.getTrkkzkyno1());
                ttdkKanTy.setZtytrkkzkadr1kj1(ttdkKan.getTrkkzkadr1kj1());
                ttdkKanTy.setZtytrkkzkadr2kj1(ttdkKan.getTrkkzkadr2kj1());
                ttdkKanTy.setZtytrkkzkadr3kj1(ttdkKan.getTrkkzkadr3kj1());
                ttdkKanTy.setZtytrkkzktelno1(ttdkKan.getTrkkzktelno1());
                ttdkKanTy.setZtytrkkzktelnomtrkhyouji1(Strings.padStart(ttdkKan.getTrkkzktelnomtrkhyouji1(), 1, '0'));

                if (C_TrkKzkKbn.BLNK.eq(ttdkKan.getTrkkzkkbn2())) {

                    if ("03".equals(ttdkKan.getKzkomttutkbn2()) && !BizUtil.isBlank(ttdkKan.getTrkkzknmkj2())) {
                        ttdkKanTy.setZtytrkkzkkbn2("3");
                    }
                    else if ("04".equals(ttdkKan.getKzkomttutkbn2()) && !BizUtil.isBlank(ttdkKan.getTrkkzknmkj2())) {
                        ttdkKanTy.setZtytrkkzkkbn2("3");
                    }
                    else {
                        ttdkKanTy.setZtytrkkzkkbn2(ttdkKan.getTrkkzkkbn2().getValue());
                    }
                }
                else {
                    ttdkKanTy.setZtytrkkzkkbn2(ttdkKan.getTrkkzkkbn2().getValue());
                }

                ttdkKanTy.setZtytrkkzknmkj2(ttdkKan.getTrkkzknmkj2());
                ttdkKanTy.setZtytrkkzkseiymd2zenkaku(FixedDateFormatter.formatYMDZenkakuWarekiKanji(ttdkKan.getTrkkzkseiymd2()));
                ttdkKanTy.setZtytrkkzkyno2(ttdkKan.getTrkkzkyno2());
                ttdkKanTy.setZtytrkkzkadr1kj2(ttdkKan.getTrkkzkadr1kj2());
                ttdkKanTy.setZtytrkkzkadr2kj2(ttdkKan.getTrkkzkadr2kj2());
                ttdkKanTy.setZtytrkkzkadr3kj2(ttdkKan.getTrkkzkadr3kj2());
                ttdkKanTy.setZtytrkkzktelno2(ttdkKan.getTrkkzktelno2());
                ttdkKanTy.setZtykykdairinmkj(ttdkKan.getKykdairinmkj());
                ttdkKanTy.setZtykykomttutkbn(Strings.padStart(ttdkKan.getKykomttutkbn(), 2, '0'));
                ttdkKanTy.setZtykzkomttutkbn1(Strings.padStart(ttdkKan.getKzkomttutkbn1(), 2, '0'));
                ttdkKanTy.setZtykzkomttutkbn2(Strings.padStart(ttdkKan.getKzkomttutkbn2(), 2, '0'));
                ttdkKanTy.setZtyhhkomttutkbn(Strings.padStart(ttdkKan.getHhkomttutkbn(), 2, '0'));
                ttdkKanTy.setZtyhhkdromttutkbn(Strings.padStart(ttdkKan.getHhkdromttutkbn(), 2, '0'));
                ttdkKanTy.setZtykykdairiomttutkbn(Strings.padStart(ttdkKan.getKykdairiomttutkbn(), 2, '0'));
                ttdkKanTy.setZtykykurtutkbn(Strings.padStart(ttdkKan.getKykurtutkbn(), 2, '0'));
                ttdkKanTy.setZtykzkurtutkbn1(Strings.padStart(ttdkKan.getKzkurtutkbn1(), 2, '0'));
                ttdkKanTy.setZtykzkurtutkbn2(Strings.padStart(ttdkKan.getKzkurtutkbn2(), 2, '0'));
                ttdkKanTy.setZtyhhkdrurtutkbn(Strings.padStart(ttdkKan.getHhkdrurtutkbn(), 2, '0'));
                ttdkKanTy.setZtykykdairiurtutkbn(Strings.padStart(ttdkKan.getKykdairiurtutkbn(), 2, '0'));
                ttdkKanTy.setZtykykaistmsgkbn(Strings.padStart(ttdkKan.getKykaistmsgkbn(), 2, '0'));
                ttdkKanTy.setZtykzkaistmsgkbn1(Strings.padStart(ttdkKan.getKzkaistmsgkbn1(), 2, '0'));
                ttdkKanTy.setZtykzkaistmsgkbn2(Strings.padStart(ttdkKan.getKzkaistmsgkbn2(), 2, '0'));
                ttdkKanTy.setZtyhhkaistmsgkbn(Strings.padStart(ttdkKan.getHhkaistmsgkbn(), 2, '0'));
                ttdkKanTy.setZtyhhkdraistmsgkbn(Strings.padStart(ttdkKan.getHhkdraistmsgkbn(), 2, '0'));
                ttdkKanTy.setZtykykdairiaistmsgkbn(Strings.padStart(ttdkKan.getKykdairiaistmsgkbn(), 2, '0'));
                ttdkKanTy.setZtysakujyokzknmkj(ttdkKan.getSakujyokzknmkj());
                ttdkKanTy.setZtyttdknaiyoukbn(Strings.padStart(ttdkKan.getTtdknaiyoukbn(), 2, '0'));
                ttdkKanTy.setZtykzktaisyoukykkbn(Strings.padStart(ttdkKan.getKzktaisyoukykkbn(), 1, '0'));
                ttdkKanTy.setZtyhhkdrtaisyoukykkbn(Strings.padStart(ttdkKan.getHhkdrtaisyoukykkbn(), 1, '0'));
                ttdkKanTy.setZtykykdairitaisyoukykkbn(Strings.padStart(ttdkKan.getKykdairitaisyoukykkbn(), 1, '0'));
                ttdkKanTy.setZtymoshnkniymsgkbn1(Strings.padStart(ttdkKan.getMoshnkniymsgkbn1(), 2, '0'));
                ttdkKanTy.setZtykykmoshnkniymsg2(Strings.padStart(ttdkKan.getKykmoshnkniymsg2(), 2, '0'));
                ttdkKanTy.setZtykzkmoshnkniymsg21(Strings.padStart(ttdkKan.getKzkmoshnkniymsg21(), 2, '0'));
                ttdkKanTy.setZtykzkmoshnkniymsg22(Strings.padStart(ttdkKan.getKzkmoshnkniymsg22(), 2, '0'));
                ttdkKanTy.setZtyhhkdrmoshnkniymsg2(Strings.padStart(ttdkKan.getHhkdrmoshnkniymsg2(), 2, '0'));
                ttdkKanTy.setZtykykdairimoshnkniymsg2(Strings.padStart(ttdkKan.getKykdairimoshnkniymsg2(), 2, '0'));
                ttdkKanTy.setZtykykdrmsgkbn(Strings.padStart(ttdkKan.getKykdrmsgkbn(), 2, '0'));
                ttdkKanTy.setZtykykhhkdrmsg(Strings.padStart(ttdkKan.getKykhhkdrmsg(), 2, '0'));
                ttdkKanTy.setZtykzkhhkdrmsg1(Strings.padStart(ttdkKan.getKzkhhkdrmsg1(), 2, '0'));
                ttdkKanTy.setZtykzkhhkdrmsg2(Strings.padStart(ttdkKan.getKzkhhkdrmsg2(), 2, '0'));
                ttdkKanTy.setZtyhhkdrnmkj(ttdkKan.getHhkdrnmkj());
                ttdkKanTy.setZtyduhubutumsg1(Strings.padStart(ttdkKan.getDuhubutumsg1(), 2, '0'));
                ttdkKanTy.setZtyduhubutumsg2(Strings.padStart(ttdkKan.getDuhubutumsg2(), 2, '0'));
                ttdkKanTy.setZtyduhubutumsg3(Strings.padStart(ttdkKan.getDuhubutumsg3(), 2, '0'));
                ttdkKanTy.setZtyduhubutumsg4(Strings.padStart(ttdkKan.getDuhubutumsg4(), 2, '0'));
                ttdkKanTy.setZtyduhubutumsg5(Strings.padStart(ttdkKan.getDuhubutumsg5(), 2, '0'));
                ttdkKanTy.setZtyduhubutumsg6(Strings.padStart(ttdkKan.getDuhubutumsg6(), 2, '0'));
                ttdkKanTy.setZtyduhubutumsg7(Strings.padStart(ttdkKan.getDuhubutumsg7(), 2, '0'));
                ttdkKanTy.setZtykykigaidhbtmsg1(Strings.padStart(ttdkKan.getKykigaidhbtmsg1(), 2, '0'));
                ttdkKanTy.setZtykykigaidhbtmsg2(Strings.padStart(ttdkKan.getKykigaidhbtmsg2(), 2, '0'));
                ttdkKanTy.setZtykykigaidhbtmsg3(Strings.padStart(ttdkKan.getKykigaidhbtmsg3(), 2, '0'));
                ttdkKanTy.setZtykykigaidhbtmsg4(Strings.padStart(ttdkKan.getKykigaidhbtmsg4(), 2, '0'));
                ttdkKanTy.setZtyyakkankiyakuhunyuuhyouji(Strings.padStart(ttdkKan.getYakkankiyakuhunyuuhyouji(), 1, '0'));
                ttdkKanTy.setZtykyktrktrshuunyuuhyouji(Strings.padStart(ttdkKan.getKyktrktrshuunyuuhyouji(), 1, '0'));
                ttdkKanTy.setZtykzktrktrshuunyuuhyouji1(Strings.padStart(ttdkKan.getKzktrktrshuunyuuhyouji1(), 1, '0'));
                ttdkKanTy.setZtykzktrktrshuunyuuhyouji2(Strings.padStart(ttdkKan.getKzktrktrshuunyuuhyouji2(), 1, '0'));
                ttdkKanTy.setZtykykdrhuunyuuhyouji(Strings.padStart(ttdkKan.getKykdrhuunyuuhyouji(), 1, '0'));
                ttdkKanTy.setZtyhhkdrhuunyuuhyouji(Strings.padStart(ttdkKan.getHhkdrhuunyuuhyouji(), 1, '0'));
                ttdkKanTy.setZtykykdairinmkj2(ttdkKan.getKykdairinmkj2());
                ttdkKanTy.setZtykykdrseiymd(FixedDateFormatter.formatYMDZenkakuWarekiKanji(ttdkKan.getKykdrseiymd()));
                ttdkKanTy.setZtykykdryno(ttdkKan.getKykdryno());
                ttdkKanTy.setZtykykdradr1kj(ttdkKan.getKykdradr1kj());
                ttdkKanTy.setZtykykdradr2kj(ttdkKan.getKykdradr2kj());
                ttdkKanTy.setZtykykdradr3kj(ttdkKan.getKykdradr3kj());
                ttdkKanTy.setZtykykdrtelno(ttdkKan.getKykdrtelno());
                ttdkKanTy.setZtyhhkdrnmkj2(ttdkKan.getHhkdrnmkj2());
                ttdkKanTy.setZtyhhkdrseiymd(FixedDateFormatter.formatYMDZenkakuWarekiKanji(ttdkKan.getHhkdrseiymd()));
                ttdkKanTy.setZtyhhkdryno(ttdkKan.getHhkdryno());
                ttdkKanTy.setZtyhhkdradr1kj(ttdkKan.getHhkdradr1kj());
                ttdkKanTy.setZtyhhkdradr2kj(ttdkKan.getHhkdradr2kj());
                ttdkKanTy.setZtyhhkdradr3kj(ttdkKan.getHhkdradr3kj());
                ttdkKanTy.setZtyhhkdrtelno(ttdkKan.getHhkdrtelno());
                ttdkKanTy.setZtyhhkdrtelnomtrkhyouji(Strings.padStart(ttdkKan.getHhkdrtelnomtrkhyouji(), 1, '0'));
                ttdkKanTy.setZtykhsyono2(Strings.padStart(ttdkKan.getKhsyono2(), 11, '0'));
                ttdkKanTy.setZtykhsyono3(Strings.padStart(ttdkKan.getKhsyono3(), 11, '0'));
                ttdkKanTy.setZtykhsyono4(Strings.padStart(ttdkKan.getKhsyono4(), 11, '0'));
                ttdkKanTy.setZtykhsyono5(Strings.padStart(ttdkKan.getKhsyono5(), 11, '0'));
                ttdkKanTy.setZtykhsyono6(Strings.padStart(ttdkKan.getKhsyono6(), 11, '0'));
                ttdkKanTy.setZtykhsyono7(Strings.padStart(ttdkKan.getKhsyono7(), 11, '0'));
                ttdkKanTy.setZtykhsyono8(Strings.padStart(ttdkKan.getKhsyono8(), 11, '0'));
                ttdkKanTy.setZtykhsyono9(Strings.padStart(ttdkKan.getKhsyono9(), 11, '0'));
                ttdkKanTy.setZtykhsyono10(Strings.padStart(ttdkKan.getKhsyono10(), 11, '0'));
                ttdkKanTy.setZtykhmosno1(Strings.padStart(ttdkKan.getKhmosno1(), 9, '0'));
                ttdkKanTy.setZtykhmosno2(Strings.padStart(ttdkKan.getKhmosno2(), 9, '0'));
                ttdkKanTy.setZtykhmosno3(Strings.padStart(ttdkKan.getKhmosno3(), 9, '0'));
                ttdkKanTy.setZtykhmosno4(Strings.padStart(ttdkKan.getKhmosno4(), 9, '0'));
                ttdkKanTy.setZtykhmosno5(Strings.padStart(ttdkKan.getKhmosno5(), 9, '0'));
                ttdkKanTy.setZtykhmosno6(Strings.padStart(ttdkKan.getKhmosno6(), 9, '0'));
                ttdkKanTy.setZtykhmosno7(Strings.padStart(ttdkKan.getKhmosno7(), 9, '0'));
                ttdkKanTy.setZtykhmosno8(Strings.padStart(ttdkKan.getKhmosno8(), 9, '0'));
                ttdkKanTy.setZtykhmosno9(Strings.padStart(ttdkKan.getKhmosno9(), 9, '0'));
                ttdkKanTy.setZtykhmosno10(Strings.padStart(ttdkKan.getKhmosno10(), 9, '0'));
                ttdkKanTy.setZtyhnsnhutouhuunyuuhyouji(Strings.padStart(ttdkKan.getHnsnhutouhuunyuuhyouji(), 1, '0'));
                ttdkKanTy.setZtyyobiv204("");
                ttdkKanTy.setZtyyobiv255x2("");
                ttdkKanTy.setZtyyobiv255x3("");
                ttdkKanTy.setZtyyobiv255x4("");

                BizPropertyInitializer.initialize(ttdkKanTy);

                ttdkKanTyLst.add(ttdkKanTy);

                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private String getStringValueByBC(BizCurrency pBCValue) {
        String sValue = null;
        if (null == pBCValue) {
            sValue = "";
        }
        sValue = String.valueOf(pBCValue);
        return sValue;
    }

    private String getStirngValueByBN(BizDate pBDValue) {
        String sValue = null;
        if (null == pBDValue) {
            sValue = "";
        }
        sValue = String.valueOf(pBDValue);
        return sValue;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
