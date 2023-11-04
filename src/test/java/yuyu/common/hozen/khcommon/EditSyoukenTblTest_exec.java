package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_Dairiten;
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険証券TBL編集クラスのメソッド {@link EditSyoukenTbl#editTBL(KhozenCommonParam,IT_KykKihon,List,IT_KykSonotaTkyk,List,IT_SyouhnTokujou,IT_KykSya,IT_HhknSya,IT_KykUkt,IT_KykUkt,List,IT_KhTtdkTyuui,List,List,EditHokenSyoukenParam,BizDate,C_SinsaihkKbn,C_TetudukisyuKbn,C_HassouKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSyoukenTblTest_exec {

    private final static String syoNo1 = "20806000019";

    private final static String syoNo2 = "20806000020";

    private final static String syoNo3 = "20806000031";

    private final static String syoNo4 = "20806000042";

    private final static String syoNo5 = "20806000053";

    private final static String syoNo6 = "20806000064";

    private final static String syoNo7 = "20806000075";

    private final static String syoNo8 = "20806000086";

    private final static String syoNo9 = "20806000097";

    private final static String syoNo10 = "12806345672";

    private final static String syoNo11 = "12806345683";

    private final static String syoNo12 = "12806345694";

    private final static String syoNo13 = "12806345708";

    private final static String syoNo14 = "12806345753";

    private final static String syoNo15 = "12806345764";

    private final static String syoNo16 = "17808149974";

    private final static String syoNo17 = "17808149985";

    private final static String syoNo18 = "17808149996";

    private final static String syoNo19 = "17808150004";

    private final static String syoNo20 = "12806345775";

    private final static String kbnKey1 = "01";

    private final static String kbnKey2 = "02";

    private final static String kbnKey3 = "03";

    private final static String kbnKey4 = "04";

    private final static String kbnKey5 = "05";

    private final static String kbnKey6 = "06";

    private final static String kbnKey7 = "07";

    private final static String kbnKey8 = "08";

    private final static String kbnKey9 = "09";

    private final static String kbnKey10 = "07";

    private final static String kbnKey11 = "08";

    private final static String kbnKey12 = "09";

    private final static String kbnKey13 = "00";

    private final static String kbnKey14 = "05";

    private final static String kbnKey15 = "06";

    private final static String kbnKey16 = "07";

    private final static String kbnKey17 = "08";

    private final static String kbnKey18 = "09";

    private final static String kbnKey19 = "00";

    private final static String kbnKey20 = "07";


    @Inject
    private EditSyoukenTbl editSyoukenTbl;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private EditHokenSyoukenParam editHokenSyoukenParam;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon(syoNo1);

        if (kykKihon1 == null) {

            kykKihon1 = new IT_KykKihon(kbnKey1, syoNo1);
            kykKihon1.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon1.setHrkp(BizCurrency.valueOf(123));
            kykKihon1.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon1.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon1.setSbuktnin(5);
            kykKihon1.setFstphrkkeirokbn(C_FstphrkkeiroKbn.CREDIT);
            kykKihon1.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon1.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon1.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160612));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon1.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(10);

            IT_KykUkt kykUkt = kykKihon1.createKykUkt();
            kykUkt.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt.setUktsyurenno(1);
            kykUkt.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
            kykUkt.setUktnmkj("受取人名００１");
            kykUkt.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt.setUktbnwari(BizNumber.valueOf(111));

            IT_KykUkt kykUkt1 = kykKihon1.createKykUkt();

            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(2);
            kykUkt1.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(222));

            IT_HhknSya hhknSya = kykKihon1.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon1.createKykSya();
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setKyknmkn("カナ");
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon1.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRKAKUNINUKE);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRKAKUNINUKE);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRKAKUNINUKE);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRKAKUNINUKE);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRKAKUNINUKE);

            IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
            kykDairiten1.setDrtenrenno(1);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
            nyknJissekiRireki1.setSyono("20806000019");
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.JPY);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            BM_SyouhnZokusei syouhnZokusei1 = bizDomManager.getSyouhnZokusei("M900", 1);

            if (syouhnZokusei1 == null) {
                syouhnZokusei1 = new BM_SyouhnZokusei("M900", 1);

                syouhnZokusei1.setYoteirirituhosyoukkn(5);
                syouhnZokusei1.setTeikisiharaikinumu(C_UmuKbn.NONE);
                syouhnZokusei1.setHengakuumu(C_UmuKbn.NONE);
                syouhnZokusei1.setSyuusinhknumu(C_UmuKbn.NONE);
                syouhnZokusei1.setMvatekikkn(20);
                syouhnZokusei1.setDai1hknkkn(1);
                syouhnZokusei1.setSyouhnnmsyouken("商品名");

                bizDomManager.insert(syouhnZokusei1);
            }
            BM_KawaseRate kawaseRate = bizDomManager.getKawaseRate(BizDate.valueOf(20170313),
                C_KwsrendouKbn.KOUJIKAWASERATE2,
                C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE);
            if (kawaseRate == null) {

                kawaseRate = new BM_KawaseRate(BizDate.valueOf(20170313), C_KwsrendouKbn.KOUJIKAWASERATE2,
                    C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE);
                kawaseRate.setKawaserate(BizNumber.valueOf(1.23));

                bizDomManager.insert(kawaseRate);
            }
            BM_TantouCd tantouCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUKANRI);
            if (tantouCd == null) {

                tantouCd = new BM_TantouCd(C_TantouCdKbn.DAIRITENJIMUKANRI);
                tantouCd.setBusitunm("部・室名部・室");
                tantouCd.setBusitucd("111");
                tantouCd.setTantounm("担当名");

                bizDomManager.insert(tantouCd);

            }

            BM_Dairiten dairiten1 = bizDomManager.getDairiten("1110001");

            if (dairiten1 == null) {
                dairiten1 = new BM_Dairiten("1110001");

                dairiten1.setDrtennm("代理店名００１");
                dairiten1.setKanjidairitennm("漢字代理店名００１");
                dairiten1.setKeisyousakidrtencd("1111000");
                dairiten1.setOyadrtencd("1110100");

                bizDomManager.insert(dairiten1);
            }

            BM_Dairiten dairiten2 = bizDomManager.getDairiten("1110010");

            if (dairiten2 == null) {
                dairiten2 = new BM_Dairiten("1110010");

                dairiten2.setOyadrtencd("1101000");

                bizDomManager.insert(dairiten2);
            }

            BM_Dairiten dairiten3 = bizDomManager.getDairiten("1110100");

            if (dairiten3 == null) {
                dairiten3 = new BM_Dairiten("1110100");

                bizDomManager.insert(dairiten3);
            }

            BM_Dairiten dairiten4 = bizDomManager.getDairiten("1111000");

            if (dairiten4 == null) {
                dairiten4 = new BM_Dairiten("1111000");

                dairiten4.setOyadrtencd("1110010");

                bizDomManager.insert(dairiten4);
            }

            BM_Dairiten dairiten5 = bizDomManager.getDairiten("2110001");

            if (dairiten5 == null) {
                dairiten5 = new BM_Dairiten("2110001");

                dairiten5.setDrtennm("代理店名００２");
                dairiten5.setKanjidairitennm("漢字代理店名００２");
                dairiten5.setKeisyousakidrtencd("2111000");
                dairiten5.setOyadrtencd("2110100");

                bizDomManager.insert(dairiten5);
            }

            BM_Dairiten dairiten6 = bizDomManager.getDairiten("2110010");

            if (dairiten6 == null) {
                dairiten6 = new BM_Dairiten("2110010");

                dairiten6.setOyadrtencd("2101000");

                bizDomManager.insert(dairiten6);
            }

            BM_Dairiten dairiten7 = bizDomManager.getDairiten("2110100");

            if (dairiten7 == null) {
                dairiten7 = new BM_Dairiten("2110100");

                bizDomManager.insert(dairiten7);
            }

            BM_Dairiten dairiten8 = bizDomManager.getDairiten("2111000");

            if (dairiten8 == null) {
                dairiten8 = new BM_Dairiten("2111000");

                dairiten8.setOyadrtencd("2110010");

                bizDomManager.insert(dairiten8);
            }

            BM_Dairiten dairiten9 = bizDomManager.getDairiten("5110001");

            if (dairiten9 == null) {
                dairiten9 = new BM_Dairiten("5110001");

                dairiten9.setDrtennm("代理店名００３");
                dairiten9.setKanjidairitennm("漢字代理店名００３");
                dairiten9.setKeisyousakidrtencd("5111000");
                dairiten9.setOyadrtencd("5110100");

                bizDomManager.insert(dairiten9);
            }

            BM_Dairiten dairiten10 = bizDomManager.getDairiten("5110010");

            if (dairiten10 == null) {
                dairiten10 = new BM_Dairiten("5110010");

                dairiten10.setOyadrtencd("5101000");

                bizDomManager.insert(dairiten10);
            }

            BM_Dairiten dairiten11 = bizDomManager.getDairiten("5110100");

            if (dairiten11 == null) {
                dairiten11 = new BM_Dairiten("5110100");

                bizDomManager.insert(dairiten11);
            }

            BM_Dairiten dairiten12 = bizDomManager.getDairiten("5111000");

            if (dairiten12 == null) {
                dairiten12 = new BM_Dairiten("5111000");

                dairiten12.setOyadrtencd("5110010");

                bizDomManager.insert(dairiten12);
            }

            BM_Dairiten dairiten13 = bizDomManager.getDairiten("7110001");

            if (dairiten13 == null) {
                dairiten13 = new BM_Dairiten("7110001");

                dairiten13.setDrtennm("代理店名００４");
                dairiten13.setKanjidairitennm("漢字代理店名００４");
                dairiten13.setKeisyousakidrtencd("7111000");
                dairiten13.setOyadrtencd("7110100");

                bizDomManager.insert(dairiten13);
            }

            BM_Dairiten dairiten14 = bizDomManager.getDairiten("7110010");

            if (dairiten14 == null) {
                dairiten14 = new BM_Dairiten("7110010");

                dairiten14.setOyadrtencd("7101000");

                bizDomManager.insert(dairiten14);
            }

            BM_Dairiten dairiten15 = bizDomManager.getDairiten("7110100");

            if (dairiten15 == null) {
                dairiten15 = new BM_Dairiten("7110100");

                bizDomManager.insert(dairiten15);
            }

            BM_Dairiten dairiten16 = bizDomManager.getDairiten("7111000");

            if (dairiten16 == null) {
                dairiten16 = new BM_Dairiten("7111000");

                dairiten16.setOyadrtencd("7110010");

                bizDomManager.insert(dairiten16);
            }

            BM_DairitenSyougou dairitenSyougou1 = bizDomManager.getDairitenSyougou("1101000");

            if (dairitenSyougou1 == null) {
                dairitenSyougou1 = new BM_DairitenSyougou("1101000");

                dairitenSyougou1.setKanjihoujinsyougou("漢字法人商号００１");

                bizDomManager.insert(dairitenSyougou1);
            }

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon(syoNo2);

        if (kykKihon2 == null) {

            kykKihon2 = new IT_KykKihon(kbnKey2, syoNo2);
            kykKihon2.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon2.setHrkp(BizCurrency.valueOf(123));
            kykKihon2.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon2.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon2.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon2.setSbuktnin(2);
            kykKihon2.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon2.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon2.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon2.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160612));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon2.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(10);

            IT_KykUkt kykUkt1 = kykKihon2.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon2.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon2.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon2.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            BM_KawaseRate kawaseRate = bizDomManager.getKawaseRate(BizDate.valueOf(20160613),
                C_KwsrendouKbn.KOUJIKAWASERATE2,
                C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
            if (kawaseRate == null) {

                kawaseRate = new BM_KawaseRate(BizDate.valueOf(20160613), C_KwsrendouKbn.KOUJIKAWASERATE2,
                    C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
                kawaseRate.setKawaserate(BizNumber.valueOf(2.22));

                bizDomManager.insert(kawaseRate);
            }

            IT_KykDairiten kykDairiten1 = kykKihon2.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon2.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon(syoNo3);

        if (kykKihon3 == null) {

            kykKihon3 = new IT_KykKihon(kbnKey3, syoNo3);
            kykKihon3.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon3.setHrkp(BizCurrency.valueOf(123));
            kykKihon3.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon3.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon3.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon3.setSbuktnin(2);
            kykKihon3.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon3.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon3.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon3.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160612));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon3.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(10);

            IT_KykUkt kykUkt1 = kykKihon3.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon3.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon3.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon3.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);


            IT_KykDairiten kykDairiten1 = kykKihon3.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon3.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon3);
        }

        IT_KykKihon kykKihon4 = hozenDomManager.getKykKihon(syoNo4);

        if (kykKihon4 == null) {

            kykKihon4 = new IT_KykKihon(kbnKey4, syoNo4);
            kykKihon4.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon4.setHrkp(BizCurrency.valueOf(123));
            kykKihon4.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon4.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon4.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon4.setSbuktnin(2);
            kykKihon4.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon4.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon4.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon4.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon4.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(10);

            IT_KykUkt kykUkt1 = kykKihon4.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon4.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon4.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon4.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon4.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon4.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon4.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon4);
        }

        IT_KykKihon kykKihon5 = hozenDomManager.getKykKihon(syoNo5);

        if (kykKihon5 == null) {

            kykKihon5 = new IT_KykKihon(kbnKey5, syoNo5);
            kykKihon5.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon5.setHrkp(BizCurrency.valueOf(123));
            kykKihon5.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon5.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon5.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon5.setSbuktnin(2);
            kykKihon5.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon5.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon5.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon5.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(105);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon5.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(1);

            IT_KykUkt kykUkt1 = kykKihon5.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon5.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon5.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon5.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon5.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon5.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon5.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon5);
        }

        IT_KykKihon kykKihon6 = hozenDomManager.getKykKihon(syoNo6);

        if (kykKihon6 == null) {

            kykKihon6 = new IT_KykKihon(kbnKey6, syoNo6);
            kykKihon6.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon6.setHrkp(BizCurrency.valueOf(123));
            kykKihon6.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon6.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon6.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon6.setSbuktnin(2);
            kykKihon6.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon6.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon6.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon6.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(104);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon6.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon6.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon6.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon6.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon6.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon6.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon6.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon6.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon6);
        }

        IT_KykKihon kykKihon7 = hozenDomManager.getKykKihon(syoNo7);

        if (kykKihon7 == null) {

            kykKihon7 = new IT_KykKihon(kbnKey7, syoNo7);
            kykKihon7.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon7.setHrkp(BizCurrency.valueOf(123));
            kykKihon7.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon7.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon7.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon7.setSbuktnin(2);
            kykKihon7.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon7.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon7.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon7.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon7.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(-1);

            IT_KykUkt kykUkt1 = kykKihon7.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon7.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon7.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon7.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon7.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon7.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon7.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon7);
        }

        IT_KykKihon kykKihon8 = hozenDomManager.getKykKihon(syoNo8);

        if (kykKihon8 == null) {

            kykKihon8 = new IT_KykKihon(kbnKey8, syoNo8);
            kykKihon8.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon8.setHrkp(BizCurrency.valueOf(123));
            kykKihon8.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon8.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon8.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon8.setSbuktnin(2);
            kykKihon8.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon8.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon8.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon8.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon8.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon8.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon8.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon8.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon8.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon8.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon8.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon8.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon8);
        }

        IT_KykKihon kykKihon9 = hozenDomManager.getKykKihon(syoNo9);

        if (kykKihon9 == null) {

            kykKihon9 = new IT_KykKihon(kbnKey9, syoNo9);
            kykKihon9.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon9.setHrkp(BizCurrency.valueOf(123));
            kykKihon9.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon9.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon9.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon9.setSbuktnin(2);
            kykKihon9.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon9.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon9.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon9.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon9.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon9.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon9.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon9.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon9.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon9.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon9.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon9.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon9);
        }
        IT_KykKihon kykKihon10 = hozenDomManager.getKykKihon(syoNo10);

        if (kykKihon10 == null) {

            kykKihon10 = new IT_KykKihon(kbnKey10, syoNo10);
            kykKihon10.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon10.setHrkp(BizCurrency.valueOf(123));
            kykKihon10.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon10.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon10.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon10.setSbuktnin(2);
            kykKihon10.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon10.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon10.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon10.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon10.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(10);

            IT_KykUkt kykUkt1 = kykKihon10.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon10.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon10.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon10.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon10.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon10.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon10.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon10);
        }

        IT_KykKihon kykKihon11 = hozenDomManager.getKykKihon(syoNo11);

        if (kykKihon11 == null) {

            kykKihon11 = new IT_KykKihon(kbnKey11, syoNo11);
            kykKihon11.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon11.setHrkp(BizCurrency.valueOf(123));
            kykKihon11.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon11.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon11.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon11.setSbuktnin(2);
            kykKihon11.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon11.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon11.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon11.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(105);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon11.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(1);

            IT_KykUkt kykUkt1 = kykKihon11.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon11.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon11.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon11.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon11.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon11.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon11.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon11);
        }

        IT_KykKihon kykKihon12 = hozenDomManager.getKykKihon(syoNo12);

        if (kykKihon12 == null) {

            kykKihon12 = new IT_KykKihon(kbnKey12, syoNo12);
            kykKihon12.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon12.setHrkp(BizCurrency.valueOf(123));
            kykKihon12.setFstpnyknymd(BizDate.valueOf(20160612));
            kykKihon12.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon12.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon12.setSbuktnin(2);
            kykKihon12.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon12.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon12.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon12.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(104);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon12.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon12.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon12.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon12.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon12.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon12.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon12.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon12.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon12);
        }

        IT_KykKihon kykKihon13 = hozenDomManager.getKykKihon(syoNo13);

        if (kykKihon13 == null) {

            kykKihon13 = new IT_KykKihon(kbnKey13, syoNo13);
            kykKihon13.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon13.setHrkp(BizCurrency.valueOf(123));
            kykKihon13.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon13.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon13.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon13.setSbuktnin(2);
            kykKihon13.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon13.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon13.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon13.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon13.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(-1);

            BM_KawaseRate kawaseRate = bizDomManager.getKawaseRate(BizDate.valueOf(20160712),
                C_KwsrendouKbn.KOUJIKAWASERATE2,
                C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
            if (kawaseRate == null) {

                kawaseRate = new BM_KawaseRate(BizDate.valueOf(20160712), C_KwsrendouKbn.KOUJIKAWASERATE2,
                    C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
                kawaseRate.setKawaserate(BizNumber.valueOf(1.23));

                bizDomManager.insert(kawaseRate);
            }

            IT_KykUkt kykUkt1 = kykKihon13.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon13.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon13.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon13.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon13.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon13.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon13.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon13);
        }

        IT_KykKihon kykKihon14 = hozenDomManager.getKykKihon(syoNo14);

        if (kykKihon14 == null) {

            kykKihon14 = new IT_KykKihon(kbnKey14, syoNo14);
            kykKihon14.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon14.setHrkp(BizCurrency.valueOf(123));
            kykKihon14.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon14.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon14.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon14.setSbuktnin(2);
            kykKihon14.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon14.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon14.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon14.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.AUD);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon14.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon14.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            BM_KawaseRate kawaseRate = bizDomManager.getKawaseRate(BizDate.valueOf(20160712),
                C_KwsrendouKbn.KOUJIKAWASERATE2,
                C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
            if (kawaseRate == null) {

                kawaseRate = new BM_KawaseRate(BizDate.valueOf(20160712), C_KwsrendouKbn.KOUJIKAWASERATE2,
                    C_Tuukasyu.AUD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
                kawaseRate.setKawaserate(BizNumber.valueOf(1.23));

                bizDomManager.insert(kawaseRate);
            }

            IT_HhknSya hhknSya = kykKihon14.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon14.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon14.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon14.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon14.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon14.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon14);
        }

        IT_KykKihon kykKihon15 = hozenDomManager.getKykKihon(syoNo15);

        if (kykKihon15 == null) {

            kykKihon15 = new IT_KykKihon(kbnKey15, syoNo15);
            kykKihon15.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon15.setHrkp(BizCurrency.valueOf(123));
            kykKihon15.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon15.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon15.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon15.setSbuktnin(2);
            kykKihon15.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon15.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);
            kykKihon15.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon15.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon15.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            BM_KawaseRate kawaseRate = bizDomManager.getKawaseRate(BizDate.valueOf(20160712),
                C_KwsrendouKbn.KOUJIKAWASERATE1,
                C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
            if (kawaseRate == null) {

                kawaseRate = new BM_KawaseRate(BizDate.valueOf(20160712), C_KwsrendouKbn.KOUJIKAWASERATE1,
                    C_Tuukasyu.USD, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
                kawaseRate.setKawaserate(BizNumber.valueOf(1.23));

                bizDomManager.insert(kawaseRate);
            }

            IT_KykUkt kykUkt1 = kykKihon15.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon15.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon15.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon15.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon15.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon15.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon15.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon15);
        }

        IT_KykKihon kykKihon16 = hozenDomManager.getKykKihon(syoNo16);

        if (kykKihon16 == null) {

            kykKihon16 = new IT_KykKihon(kbnKey16, syoNo16);
            kykKihon16.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon16.setHrkp(BizCurrency.valueOf(123));
            kykKihon16.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon16.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon16.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon16.setSbuktnin(2);
            kykKihon16.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon16.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon16.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon16.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon16.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon16.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon16.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon16.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon16.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon16.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon16.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon16.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon16);
        }

        IT_KykKihon kykKihon17 = hozenDomManager.getKykKihon(syoNo17);

        if (kykKihon17 == null) {

            kykKihon17 = new IT_KykKihon(kbnKey17, syoNo17);
            kykKihon17.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon17.setHrkp(BizCurrency.valueOf(123));
            kykKihon17.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon17.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon17.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon17.setSbuktnin(2);
            kykKihon17.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon17.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
            kykKihon17.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon17.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon17.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon17.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon17.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon17.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon17.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon17.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon17.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon17.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon17);
        }

        IT_KykKihon kykKihon18 = hozenDomManager.getKykKihon(syoNo18);

        if (kykKihon18 == null) {

            kykKihon18 = new IT_KykKihon(kbnKey18, syoNo18);
            kykKihon18.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon18.setHrkp(BizCurrency.valueOf(123));
            kykKihon18.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon18.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon18.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon18.setSbuktnin(2);
            kykKihon18.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon18.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);
            kykKihon18.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon18.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon18.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon18.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon18.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon18.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon18.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon18.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon18.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon18.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon18);
        }

        IT_KykKihon kykKihon19 = hozenDomManager.getKykKihon(syoNo19);

        if (kykKihon19 == null) {

            kykKihon19 = new IT_KykKihon(kbnKey19, syoNo19);
            kykKihon19.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon19.setHrkp(BizCurrency.valueOf(123));
            kykKihon19.setFstpnyknymd(BizDate.valueOf(20160712));
            kykKihon19.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon19.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon19.setSbuktnin(2);
            kykKihon19.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon19.setDrctservicemoskbn(C_DirectServiceMosKbn.CHECK);
            kykKihon19.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon19.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20160212));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setRyouritusdno("123");
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon19.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(0);

            IT_KykUkt kykUkt1 = kykKihon19.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.KYK);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_HhknSya hhknSya = kykKihon19.createHhknSya();
            hhknSya.setHhknnmkn("アイ");
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon19.createKykSya();
            kykSya.setKyknmkn("カナ");
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon19.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KhTtdkRireki khTtdkRireki = kykKihon19.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("000000000000000010");
            khTtdkRireki.setGyoumuKousinKinou("khgengaku");

            IT_KykDairiten kykDairiten1 = kykKihon19.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon19.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon19);
        }

        IT_KykKihon kykKihon20 = hozenDomManager.getKykKihon(syoNo20);

        if (kykKihon20 == null) {

            kykKihon20 = new IT_KykKihon(kbnKey20, syoNo20);
            kykKihon20.setHrkkaisuu(C_Hrkkaisuu.TUKI);
            kykKihon20.setHrkp(BizCurrency.valueOf(123));
            kykKihon20.setAisyoumeikbn(C_AisyoumeiKbn.SOKUJIHSY_MDHN);
            kykKihon20.setStknsetkbn(C_StknsetKbn.BLNK);
            kykKihon20.setSbuktnin(1);
            kykKihon20.setFstphrkkeirokbn(C_FstphrkkeiroKbn.BLNK);
            kykKihon20.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);
            kykKihon20.setStknsetkbn(C_StknsetKbn.ARI);

            IT_KykSyouhn kykSyouhn = kykKihon20.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("M900");
            kykSyouhn.setSyouhnsdno(1);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKykymd(BizDate.valueOf(20060315));
            kykSyouhn.setHhknnen(103);
            kykSyouhn.setHknkknmanryouymd(BizDate.valueOf(20160512));
            kykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160612));
            kykSyouhn.setKihons(BizCurrency.valueOf(222));
            kykSyouhn.setHokenryou(BizCurrency.valueOf(11));
            kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
            kykSyouhn.setYoteiriritu(BizNumber.valueOf(1));
            kykSyouhn.setYoteirrthendohosyurrt(BizNumber.valueOf(2));
            kykSyouhn.setNenkinkkn(10);
            kykSyouhn.setHknkkn(1);
            kykSyouhn.setHrkkkn(1);
            kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
            kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(1));

            IT_KykSonotaTkyk kykSonotaTkyk = kykKihon20.createKykSonotaTkyk();
            kykSonotaTkyk.setStdrsktkyhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setYennykntkhkumu(C_UmuKbn.NONE);
            kykSonotaTkyk.setGaikanykntkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setJyudkaigomeharaitkhukaumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setTargettkhkumu(C_UmuKbn.ARI);
            kykSonotaTkyk.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(10));
            kykSonotaTkyk.setTargettkmokuhyouti(10);

            IT_KykUkt kykUkt1 = kykKihon20.createKykUkt();
            kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
            kykUkt1.setUktsyurenno(1);
            kykUkt1.setUktkbn(C_UktKbn.HHKN);
            kykUkt1.setUktnmkj("受取人名００１");
            kykUkt1.setUktnmkjkhukakbn(C_KjkhukaKbn.BLNK);
            kykUkt1.setUktbnwari(BizNumber.valueOf(111));

            IT_KykUkt kykUkt2 = kykKihon20.createKykUkt();

            kykUkt2.setUktsyukbn(C_UktsyuKbn.STDRSK);
            kykUkt2.setUktsyurenno(2);
            kykUkt2.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
            kykUkt2.setUktnmkj("受取人名００１");
            kykUkt2.setUktnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykUkt2.setUktbnwari(BizNumber.valueOf(444));

            IT_HhknSya hhknSya = kykKihon20.createHhknSya();
            hhknSya.setHhknnmkj("被保険者名００１");
            hhknSya.setHhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            hhknSya.setHhknseiymd(BizDate.valueOf(20160601));
            hhknSya.setHhknsei(C_Hhknsei.MALE);

            IT_KykSya kykSya = kykKihon20.createKykSya();
            kykSya.setKyknmkj("契約者名００１");
            kykSya.setKyknmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);
            kykSya.setTsinyno("1234567");
            kykSya.setTsinadr2kj("通信先住所２");
            kykSya.setTsinadr3kj("通信先住所３");

            IT_KhTtdkTyuui khTtdkTyuui = kykKihon20.createKhTtdkTyuui();
            khTtdkTyuui.setKktyuitakbn(C_KktyuitaKbn.DNGNMEMOARI);
            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.ADRHUMEI);
            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);

            IT_KykDairiten kykDairiten1 = kykKihon20.createKykDairiten();
            kykDairiten1.setDrtenrenno(2);
            kykDairiten1.setDrtencd("5110001");

            IT_KykDairiten kykDairiten2 = kykKihon20.createKykDairiten();
            kykDairiten2.setDrtenrenno(1);
            kykDairiten2.setDrtencd("5110001");

            IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon20.createNyknJissekiRireki();
            nyknJissekiRireki1.setRsgaku(BizCurrency.valueOf(10));
            nyknJissekiRireki1.setRstuukasyu(C_Tuukasyu.BLNK);
            nyknJissekiRireki1.setRyosyukwsrate(BizNumber.valueOf(10));
            nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201201));
            nyknJissekiRireki1.setRenno(1);
            nyknJissekiRireki1.setYenkansannyknkingk(BizCurrency.valueOf(1));
            nyknJissekiRireki1.setRyosyuymd(BizDate.valueOf(20100101));

            hozenDomManager.insert(kykKihon20);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllDairitenSyougou());
        bizDomManager.delete(bizDomManager.getAllTantouCd());
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo1);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05040", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09024", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09084", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09038", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09040", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09050", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09070", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09072", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.JPY, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "円", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(10), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(10), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13020", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14032", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14050", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14060", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09030", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09034", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09086", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09040", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09050", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09070", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09072", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(123), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(2.22), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(123), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(10), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13020", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14034", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14050", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14060", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09086", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09040", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09050", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09070", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09072", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(123), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(2.22), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(123), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(10), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13020", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14034", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14050", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14060", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }


    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09022", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09024", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09032", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09038", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09040", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09050", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09060", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(10), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14050", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09022", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09024", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09032", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09040", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09070", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "09072", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(10), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(10), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13020", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09022", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09024", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09032", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09040", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09070", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "09074", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(10), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13022", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14050", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14062", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09022", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09024", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09032", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09040", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09070", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "09074", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(10), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13022", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14050", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14062", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09022", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09024", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09032", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09050", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09060", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14050", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_A9() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09022", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09024", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09032", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09034", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09038", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09050", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09060", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09070", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "09074", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(10), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "13022", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14050", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14062", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_A10() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo10);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09032", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09038", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09040", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09050", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09090", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09100", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(2.22), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(2.22), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13200", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_A11() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo11);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09032", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09040", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09050", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09070", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09090", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09100", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(2.22), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(2.22), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(10), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13010", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "13210", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14060", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_A12() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo12);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09032", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09040", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09050", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09090", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09100", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(2.22), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(2.22), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "13210", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14070", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_A13() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo13);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09032", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09040", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09050", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09090", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09100", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "13210", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14070", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_A14() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo14);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09050", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09090", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09100", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13210", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_A15() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo15);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09032", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09038", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09050", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09090", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09100", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(1.23), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14070", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_A16() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo16);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09030", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09034", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09038", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09080", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09090", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09100", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(123), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(1.23), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "13200", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14070", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15042", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_A17() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo17);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09030", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09034", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09050", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09080", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09090", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09100", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(123), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(1.23), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "13020", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "13220", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14070", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_A18() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo18);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09030", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09034", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09038", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09050", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09090", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09100", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(123), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(1.23), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13200", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_A19() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo19);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160612));

        BizDate syoriYMD = BizDate.valueOf(20170314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09030", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09050", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09090", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09100", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(1.23), "その他内容欄指定外通貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exStringEquals(hokenSyoukenLst.get(0).getShsnmkj(), "契約者名００１", "送付先氏名（漢字）");
        exStringEquals(hokenSyoukenLst.get(0).getHosyounyhihknsyameikanji(), "被保険者名００１", "保障内容被保険者名（漢字）");

        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");

        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "カナ", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "アイ", "被保険者名（カナ）");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_A20() {

        //        MockObjectManager.initialize();
        //        EditSuiihyouTblMock.caller = EditSyoukenTbltest_editTBL.class;
        //        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        khozenCommonParam.setSikibetuKey("10000000001");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo20);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_KykSyouhn> tkKykSyouhnLst = null;

        IT_SyouhnTokujou syouhnTokujou = null;

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt sibouHenkan = null;

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 2);

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.HUYOU);

        BizDate syoriYMD = BizDate.valueOf(20160314);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        try {
            editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
                tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
                sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);
        } catch(CommonBizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。基準金額が取得できませんでした。", "エラーメッセージ");
        }

    }

}
