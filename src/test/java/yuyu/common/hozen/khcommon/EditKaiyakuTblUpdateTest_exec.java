package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzGetAdrDataMockForHozen;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.biz.kaikei.BzFbSoukinDataSks;
import yuyu.common.biz.kaikei.BzFbSoukinDataSksBean;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSks;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSksMockForHozen;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_HrsyuruiKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MisyuumikeikaKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Siharaijyoutaikbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhHenreikin;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhShrRirekiDetail;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約処理テーブル更新値編集クラスのメソッド {@link EditKaiyakuTblUpdate#exec(KhozenCommonParam, IT_KykKihon, BizDate,
 * EditKaiyakuTblUpdateBean, IT_BAK_KykKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKaiyakuTblUpdateTest_exec {

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約処理テーブル更新値編集";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(EditKykSyhnRirekiTbl.class).to(EditKykSyhnRirekiTblMockForHozen.class);
                bind(CommonSiwake.class).to(CommonSiwakeMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
                bind(BzGetAdrData.class).to(BzGetAdrDataMockForHozen.class);
                bind(EditDairitenTesuuryouTbl.class).to(EditDairitenTesuuryouTblMockForHozen.class);
                bind(CommonSiwakeUtil.class).to(CommonSiwakeUtilMockForHozen.class);
                bind(EditKoujyonaiyouTbl.class).to(EditKoujyonaiyouTblMockForHozen.class);
                bind(KykHenkoujiZnnJytTrksKsn.class).to(KykHenkoujiZnnJytTrksKsnMockForHozen.class);
                bind(SrDshrTukiDataSks.class).to(SrDshrTukiDataSksMockForHozen.class);
                bind(SetKhDshrTukiKykInfo.class).to(SetKhDshrTukiKykInfoMockForHozen.class);
                bind(HanteiLinc.class).to(HanteiLincMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        EditKykSyhnRirekiTblMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        CommonSiwakeMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        KeisanGaikakanzanMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        BzGetAdrDataMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        EditDairitenTesuuryouTblMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        CommonSiwakeUtilMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        EditKoujyonaiyouTblMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        KykHenkoujiZnnJytTrksKsnMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        SrDshrTukiDataSksMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        SetKhDshrTukiKykInfoMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
        HanteiLincMockForHozen.caller = EditKaiyakuTblUpdateTest_exec.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKaiyakuTblUpdateTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from IT_KykKihon").executeUpdate();
        em.createJPQL("delete from IT_KykSyouhn").executeUpdate();
        em.createJPQL("delete from IT_SyouhnTokujou").executeUpdate();
        em.createJPQL("delete from IT_BAK_KykKihon").executeUpdate();
        em.createJPQL("delete from IT_KhHenreikin").executeUpdate();
        em.createJPQL("delete from IT_AnsyuKihon").executeUpdate();
        em.createJPQL("delete from IT_KykSyouhnRireki").executeUpdate();
        em.createJPQL("delete from IT_KhTtdkRireki").executeUpdate();
        em.createJPQL("delete from IT_KhShrRireki").executeUpdate();
        em.createJPQL("delete from IT_KhShrRirekiDetail").executeUpdate();
        em.createJPQL("delete from IT_SyouhnTokujouRireki").executeUpdate();
        em.createJPQL("delete from BT_SikinIdouRireki").executeUpdate();
        em.createJPQL("delete from IT_KhLincSousinData").executeUpdate();

    }
    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        EditKykSyhnRirekiTblMockForHozen.caller = null;
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = null;

        CommonSiwakeMockForHozen.caller = null;
        CommonSiwakeMockForHozen.SYORIPTN = null;

        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        BzGetAdrDataMockForHozen.caller = null;
        BzGetAdrDataMockForHozen.SYORIPTN = null;

        EditDairitenTesuuryouTblMockForHozen.caller = null;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = null;

        EditKoujyonaiyouTblMockForHozen.caller = null;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = null;

        KykHenkoujiZnnJytTrksKsnMockForHozen.caller = null;
        KykHenkoujiZnnJytTrksKsnMockForHozen.SYORIPTN = null;

        SrDshrTukiDataSksMockForHozen.caller = null;
        SrDshrTukiDataSksMockForHozen.SYORIPTN = null;

        SetKhDshrTukiKykInfoMockForHozen.caller = null;
        SetKhDshrTukiKykInfoMockForHozen.SYORIPTN = null;

        HanteiLincMockForHozen.caller = null;
        HanteiLincMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN1;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = EditKoujyonaiyouTblMockForHozen.TESTPATTERN4;
        SrDshrTukiDataSksMockForHozen.SYORIPTN = SrDshrTukiDataSksMockForHozen.TESTPATTERN1;
        SetKhDshrTukiKykInfoMockForHozen.SYORIPTN = SetKhDshrTukiKykInfoMockForHozen.TESTPATTERN1;
        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000013");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180115"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5500));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20000));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(500));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(70000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.1));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(15);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1800));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(25);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(70001));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(70002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(70003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(70004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(70005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(70006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(70007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(70008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7300));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5600));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(2);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2500));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.JPY);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        editKaiyakuTblUpdateBean.setBankcd("5005");
        editKaiyakuTblUpdateBean.setSitencd("505");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.BLNK);
        editKaiyakuTblUpdateBean.setKouzano("M4725");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.DOUITU);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001001");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名");
        editKaiyakuTblUpdateBean.setSaikennyno("2002002");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("707");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("808");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000013");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(-2000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setGkshrratetekiymd(BizDate.valueOf(20181212));
        editKaiyakuTblUpdateBean.setGkshrrate(BizNumber.valueOf(123.123));
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(10);
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(20);
        editKaiyakuTblUpdateBean.setMikeikapjyutouym(BizDateYM.valueOf("201812"));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(9000));
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(120));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
        miKeikaPBean1.setMkeiPJytKaisuuM(12);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf("201812"));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf("20181212"));
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(130));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.NEN);
        miKeikaPBean2.setMkeiPJytKaisuuM(11);
        miKeikaPBean2.setMkeiPJytKaisuuY(2);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf("201811"));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf("20181213"));
        MiKeikaPBean[] miKeikaPBean = {miKeikaPBean1, miKeikaPBean2};
        editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(miKeikaPBean);
        editKaiyakuTblUpdateBean.setLastPJyuutouYm(BizDateYM.valueOf("201712"));
        EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = new EditDshrTukiDKoumokuBean();
        editDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20181001"));
        editDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20181002"));
        editKaiyakuTblUpdateBean.setEditDshrTukiDKoumokuBean(editDshrTukiDKoumokuBean);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000013", "1001");

        kinou.setKinouKbn(C_KinouKbn.BATCH);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000013", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180129"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "01", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000013", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "01", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000013", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180120"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180115"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180119"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 25, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.ARI, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6000), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(7300), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(5500), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(70001), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(70003), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(1800), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(7300), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(5500), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(70001), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(9000), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(70003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(70004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(70005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "01", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(1800), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3000), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(70006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180117"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(1), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180121"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(2), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001001", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002002", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.BLNK,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5005", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "505", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4725", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "707", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "707", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2500), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 2, "契約者変更回数");
        exBizCalcbleEquals(khShrRireki.getZennomikeikap(), BizCurrency.valueOf(0), "前納未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYenzennomikeikap(), BizCurrency.valueOf(3000), "円換算前納未経過保険料");
        exBizCalcbleEquals(khShrRireki.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(2000), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getZitkazukarikingkyen(), BizCurrency.valueOf(-2000), "税適預り金額（円貨）");
        exBizCalcbleEquals(khShrRireki.getYensonotahaitoukin(), BizCurrency.valueOf(12000), "円換算その他配当金");
        exBizCalcbleEquals(khShrRireki.getYenkrkgk(), BizCurrency.valueOf(6000), "円換算仮受金額");
        exDateEquals(khShrRireki.getGaikashrkwsratekjnymd(), BizDate.valueOf("20181212"), "外貨支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getGaikashrkwsrate(), BizNumber.valueOf(123.123), "外貨支払時為替レート");
        exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizCurrency.valueOf(5500), "解約返戻金額合計（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getShrtuukakaiyakuhrkngkkei(), BizCurrency.valueOf(5500), "支払通貨解約返戻金額合計");
        exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeiyen(), BizCurrency.valueOf(5500), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(khShrRireki.getSonotashrkngksiteituuka(), BizCurrency.valueOf(97001), "その他支払金額（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotashrkngk(), BizCurrency.valueOf(97001), "支払通貨その他支払金額");
        exBizCalcbleEquals(khShrRireki.getSonotashrkngkyen(), BizCurrency.valueOf(97001), "その他支払金額（円貨）");
        exBizCalcbleEquals(khShrRireki.getYensynykngk(), BizCurrency.valueOf(5600), "円換算収入金額");

        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "01", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000013", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 2, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6000), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20000), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(500), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.1), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.2),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(70000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.3), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(70007), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(70008), "指数連動積立金額");

        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = khTtdkRireki.getKykSyouhnRirekis();
        exStringEquals(kykSyouhnRirekiList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyono(), "17806000013", "証券番号");
        exClassificationEquals(kykSyouhnRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiList = khTtdkRireki.getSyouhnTokujouRirekis();
        exStringEquals(syouhnTokujouRirekiList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyono(), "17806000013", "証券番号");
        exClassificationEquals(syouhnTokujouRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000013", "証券番号");
        exClassificationEquals(kykSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.ZENNOU, "契約状態");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.SIKKOUKAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exDateEquals(kykSyouhnList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20170201"), "効力発生日");
        exDateEquals(kykSyouhnList.get(0).getKykymd(), BizDate.valueOf("20180118"), "契約日");
        exClassificationEquals(kykSyouhnList.get(0).getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnList.get(0).getSknnkaisiymd(), BizDate.valueOf("20170301"), "責任開始日");
        exDateEquals(kykSyouhnList.get(0).getGansknnkaisiymd(), BizDate.valueOf("20170401"), "がん責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHksknnkaisiymd(), BizDate.valueOf("20170501"), "復活責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHkgansknnkaisiymd(), BizDate.valueOf("20170601"), "復活がん責任開始日");
        exClassificationEquals(kykSyouhnList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHknkkn(), 1, "保険期間");
        exClassificationEquals(kykSyouhnList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHrkkkn(), 5, "払込期間");
        exNumericEquals(kykSyouhnList.get(0).getKyknen(), 30, "契約者年齢");
        exNumericEquals(kykSyouhnList.get(0).getHhknnen(), 10, "被保険者年齢");
        exDateEquals(kykSyouhnList.get(0).getHhknseiymd(), BizDate.valueOf("20100101"), "被保険者生年月日");
        exClassificationEquals(kykSyouhnList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(kykSyouhnList.get(0).getHaraimanymd(), BizDate.valueOf("20170701"), "払満日");
        exDateEquals(kykSyouhnList.get(0).getHknkknmanryouymd(), BizDate.valueOf("20170801"), "保険期間満了日");
        exClassificationEquals(kykSyouhnList.get(0).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI,
            "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnList.get(0).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKihons(), BizCurrency.valueOf(100), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnList.get(0).getHokenryou(), BizCurrency.valueOf(500), "保険料");
        exClassificationEquals(kykSyouhnList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(kykSyouhnList.get(0).getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(1), "予定利率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(5),
            "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnList.get(0).getYtirrthndmnskaisuu(), 10, "予定利率変動見直回数");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(4),
            "契約時市場価格調整用利率");
        exClassificationEquals(kykSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnList.get(0).getNenkinkkn(), 4, "年金期間");
        exNumericEquals(kykSyouhnList.get(0).getNkgnshosyouritu(), 8, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1000), "年金原資最低保証額");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(kykSyouhnList.get(0).getGengakugoyenitijibrpstgk(), BizCurrency.valueOf(7000),
            "減額後円換算一時払保険料相当額");
        exDateEquals(kykSyouhnList.get(0).getYendthnkymd(), BizDate.valueOf("20170901"), "円建変更日");
        exBizCalcbleEquals(kykSyouhnList.get(0).getSetteibairitu(), BizNumber.valueOf(9), "設定倍率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTmttknzoukaritujygn(), BizNumber.valueOf(8), "積立金増加率上限");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTumitateriritu(), BizNumber.valueOf(7), "積立利率");
        exClassificationEquals(kykSyouhnList.get(0).getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.BLNK,
            "積立金配分状態");
        exClassificationEquals(kykSyouhnList.get(0).getSisuukbn(), C_Sisuukbn.BLNK, "指数区分");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunrikzkakuninumu(), C_UmuKbn.NONE, "源泉分離課税確認有無");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000013", "証券番号");
        exClassificationEquals(syouhnTokujouList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyhyouten(), C_Tkjyhyouten.HYOUTEN100, "特条標点");
        exBizCalcbleEquals(syouhnTokujouList.get(0).getTkjyp(), BizCurrency.valueOf(400), "特条保険料");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "特条削減期間");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd1(), "11", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn1(), C_Htnpkkn.BLNK, "不担保期間１");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd2(), "21", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn2(), C_Htnpkkn.ONE, "不担保期間２");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd3(), "31", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn3(), C_Htnpkkn.TOW, "不担保期間３");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd4(), "41", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn4(), C_Htnpkkn.FOUR, "不担保期間４");
        exClassificationEquals(syouhnTokujouList.get(0).getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK,
            "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        IT_KhHenreikin khHenreikin = resultKykKihon.getKhHenreikins().get(0);
        exStringEquals(khHenreikin.getKbnkey(), "01", "区分キー");
        exStringEquals(khHenreikin.getSyono(), "17806000013", "証券番号");
        exClassificationEquals(khHenreikin.getHrsyuruikbn(), C_HrsyuruiKbn.YENDTHNKHENREI, "返戻金種類区分");
        exDateEquals(khHenreikin.getShrymd(), BizDate.valueOf("20180120"), "支払日");
        exDateEquals(khHenreikin.getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exDateEquals(khHenreikin.getHrhsisyoriymd(), BizDate.valueOf("20180103"), "返戻金発生処理日");
        exDateEquals(khHenreikin.getHrhsiymd(), BizDate.valueOf("20180104"), "返戻金発生日");
        exBizCalcbleEquals(khHenreikin.getHenreikingk(), BizCurrency.valueOf(2000), "返戻金額");
        exClassificationEquals(khHenreikin.getHrsiharaijyoutaikbn(), C_Siharaijyoutaikbn.SIHARAIZUMI,
            "返戻金支払状態区分");
        exClassificationEquals(khHenreikin.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(khHenreikin.getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exClassificationEquals(khHenreikin.getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exStringEquals(khHenreikin.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khHenreikin.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(khHenreikin.getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
        exBooleanEquals(khGaikaFBSoukinData == null, true, "契約保全外貨ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exStringEquals(batchKykKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(batchKykKihon.getSyono(), "17806000013", "証券番号");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exStringEquals(batchAnsyuKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(batchAnsyuKihon.getSyono(), "17806000013", "証券番号");

        IT_KhDshrTuki resultKhDshrTuki = editKaiyakuTblUpdate.getKhDshrTuki();
        exDateEquals(resultKhDshrTuki.getCalckijyunymd(), BizDate.valueOf("20181001"), "計算基準日");
        exStringEquals(resultKhDshrTuki.getHenkousikibetukey(), "1001", "変更識別キー");
        exBizCalcbleEquals(resultKhDshrTuki.getSiharaid(), BizCurrency.valueOf(15000), "支払Ｄ");
        exStringEquals(resultKhDshrTuki.getDshrtoukeisikibetukey(), "1111", "Ｄ支払統計識別キー");
        exNumericEquals(resultKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(resultKhDshrTuki.getSyono(), "17806000013", "証券番号");

        KhozenCommonParam khozenCommonParam1 = (KhozenCommonParam) MockObjectManager.getArgument(
            EditKykSyhnRirekiTblMockForHozen.class, "exec", 0);
        exStringEquals(khozenCommonParam1.getBatchKeiyakuKihon().getSyono(), "17806000013", "証券番号");
        MockObjectManager.assertArgumentPassed(EditKykSyhnRirekiTblMockForHozen.class, "exec", 1, "17806000013");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exStringEquals(commonSiwakeInBeanParam.getKinouId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        exDateEquals(commonSiwakeInBeanParam.getDenYmd(), BizDate.valueOf("20180120"), "伝票日付");
        exClassificationEquals(commonSiwakeInBeanParam.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals(commonSiwakeInBeanParam.getSyoriYmd(), BizDate.valueOf("20180129"), "処理年月日");
        exDateEquals(commonSiwakeInBeanParam.getKykYmd(), BizDate.valueOf("20180118"), "契約日");
        exStringEquals(commonSiwakeInBeanParam.getSyouhnCd(), "ﾕﾁ", "商品コード");
        exNumericEquals(commonSiwakeInBeanParam.getSyouhnsdNo(), 1, "商品世代番号");
        exClassificationEquals(commonSiwakeInBeanParam.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(commonSiwakeInBeanParam.getShrhousiteiKbn(), C_ShrhousiteiKbn.FB_YOKUJITU,
            "支払方法指定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTuukasyuKansanKawaserate(), BizNumber.valueOf(1),
            "契約通貨換算為替レート");
        exClassificationEquals(commonSiwakeInBeanParam.getGstszeigkUmuKbn(), C_UmuKbn.ARI, "源泉徴収税額有無区分");
        exClassificationEquals(commonSiwakeInBeanParam.getHijynbrKanritukaHantKbn(), C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI, "平準払管理通貨判定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getAzukarikinUmuKbn(), C_UmuKbn.ARI, "預り金有無区分");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getTaisyouGk(),
            BizCurrency.valueOf(5500), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKeiyakutuukaGk(),
            BizCurrency.valueOf(6000), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRTIENRSK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getTaisyouGk(),
            BizCurrency.valueOf(1800), "対象金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
            BizCurrency.valueOf(70003), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
            BizCurrency.valueOf(70002), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getTaisyouGk(),
            BizCurrency.valueOf(7300), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKeiyakutuukaGk(),
            BizCurrency.valueOf(8000), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getTaisyouGk(),
            BizCurrency.valueOf(6000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_D, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getTaisyouGk(),
            BizCurrency.valueOf(27000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getTaisyouGk(),
            BizCurrency.valueOf(0), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getTaisyouGk(),
            BizCurrency.valueOf(150), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getTaisyouGk(),
            BizCurrency.valueOf(200), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getTaisyouGk(),
            BizCurrency.valueOf(100), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        C_Tuukasyu tuukasyu = (C_Tuukasyu) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = (List<BzSiwakeMeisaiBean>) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 1);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenyenkagk(), BizCurrency.valueOf(400, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");

        MockObjectManager.assertArgumentPassed(BzGetAdrDataMockForHozen.class, "execTodouhukenCdByPostalcd", 0, "1011001");

        KhozenCommonParam khozenCommonParam2 = (KhozenCommonParam) MockObjectManager.getArgument(
            EditDairitenTesuuryouTblMockForHozen.class, "exec", 0);
        exStringEquals(khozenCommonParam2.getBatchKeiyakuKihon().getSyono(), "17806000013", "証券番号");
        exStringEquals(khozenCommonParam2.getBatchAnsyuKihon().getSyono(), "17806000013", "証券番号");
        exStringEquals(khozenCommonParam2.getFunctionId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 1, "17806000013");
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 2, C_TsrysyoriKbn.SIKKOU);
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 3, null);
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 4, 10);
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 5, 20);
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 6, BizCurrency.valueOf(9000));
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 7, BizCurrency.valueOf(0));
        IT_BAK_KykKihon bAK_KykKihon = (IT_BAK_KykKihon) MockObjectManager.getArgument(
            EditDairitenTesuuryouTblMockForHozen.class, "exec", 8);
        exStringEquals(bAK_KykKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(bAK_KykKihon.getSyono(), "17806000013", "証券番号");
        exStringEquals(bAK_KykKihon.getTrkssikibetukey(), "1001", "取消識別キー");
        BizDate denYmd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 0);
        exDateEquals(denYmd, BizDate.valueOf("20180120"), "伝票日付");
        BizDate kykymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 1);
        exDateEquals(kykymd, BizDate.valueOf("20180118"), "契約日");
        BizCurrency jpyzennouseisankgk = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 2);
        exBizCalcbleEquals(jpyzennouseisankgk, BizCurrency.valueOf(3000), "前納精算金");
        BizDate ryosyuymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 3);
        exDateEquals(ryosyuymd, BizDate.valueOf("20181219"), "領収日");
        BizDateYM jkipjytym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 4);
        exDateYMEquals(jkipjytym, BizDateYM.valueOf("201812"), "次回Ｐ充当年月");
        BizCurrency jpymikeikap = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 5);
        exBizCalcbleEquals(jpymikeikap, BizCurrency.valueOf(9000), "未経過Ｐ");
        BizDateYM mikeikapjyutouym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 6);
        exDateYMEquals(mikeikapjyutouym, BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        MiKeikaPBean[] miKeikaPBeanTest = (MiKeikaPBean[]) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 7);
        exBizCalcbleEquals(miKeikaPBeanTest[0].getMiKeikaP(), BizCurrency.valueOf(120), "明細未経過Ｐ");
        exClassificationEquals(miKeikaPBeanTest[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuM(), 12, "明細未経過Ｐ充当回数（月）");
        exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuY(), 1, "明細未経過Ｐ充当回数（年）");
        exDateYMEquals(miKeikaPBeanTest[0].getMkeiPJytYm(), BizDateYM.valueOf("201812"), "明細未経過Ｐ充当年月");
        exDateEquals(miKeikaPBeanTest[0].getMkeiPNykDenYmd(), BizDate.valueOf("20181212"), "明細未経過Ｐ入金伝票日付");
        String functionId = (String) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 8);
        exStringEquals(functionId, "EditKaiyakuTblUpdateTest_exec", "機能ＩＤ");
        C_SyoriKbn syoriKbn = (C_SyoriKbn) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 9);
        exClassificationEquals(syoriKbn, C_SyoriKbn.BLNK, "処理区分");
        C_Hrkkaisuu hrkkaisuu = (C_Hrkkaisuu) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 10);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.TUKI, "払込回数");
        C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = (C_TkiktbrisyuruiKbn) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 11);
        exClassificationEquals(tkiktbrisyuruiKbn, C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");

        List<IT_Azukarikin> azukarikinList = editKaiyakuTblUpdate.getKykKihon().getAzukarikins();
        exDateEquals(azukarikinList.get(0).getShrymd(), BizDate.valueOf("20180118"), "支払日");
        exDateEquals(azukarikinList.get(0).getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exStringEquals(azukarikinList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(azukarikinList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        List<IT_Kariukekin> kariukekinList = editKaiyakuTblUpdate.getKykKihon().getKariukekins();
        exClassificationEquals(kariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        exStringEquals(kariukekinList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kariukekinList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        IT_AnsyuKihon ansyuKihon1 = editKaiyakuTblUpdate.getAnsyuKihon();
        exStringEquals(ansyuKihon1.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(ansyuKihon1.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        List<IT_Zennou> zennouLst = ansyuKihon1.getZennous();
        exClassificationEquals(zennouLst.get(0).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        exDateEquals(zennouLst.get(0).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        exBizCalcbleEquals(zennouLst.get(0).getZennouseisankgk(), BizCurrency.valueOf(3000), "前納精算金額");
        exDateEquals(zennouLst.get(0).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        exDateEquals(zennouLst.get(0).getZennouseisandenymd(), BizDate.valueOf("20180118"), "前納精算伝票日付");
        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiList = resultKykKihon.getKihrkmpSeisanRirekis();
        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getRenno(), 1, "連番");
        exDateEquals(kihrkmpSeisanRirekiList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getKihrkpssnaiyoukbn(), C_KiharaiPseisanNaiyouKbn.SEISANP, "既払込Ｐ精算内容区分");
        exDateYMEquals(kihrkmpSeisanRirekiList.get(0).getJyuutouym(), BizDateYM.valueOf("201812"), "充当年月");
        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuum(), 20, "精算充当回数（月）");
        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuuy(), 10, "精算充当回数（年）");
        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getMisyuumikeikakbn(), C_MisyuumikeikaKbn.MIKEIKAP, "未収未経過区分");
        exDateEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = (ZennouKoujyogakuKeisanParam) MockObjectManager.getArgument(
            EditKoujyonaiyouTblMockForHozen.class, "setZennouKoujyogakuKeisanParam", 0);
        exDateEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20181224"), "控除証明用前納開始年月日");
        exStringEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(), "30", "控除証明用前納期間（月）");
        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(123456789), "控除証明用前納入金額");
        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getHrkp(), BizCurrency.valueOf(122345789), "払込保険料");
        exClassificationEquals(zennouKoujyogakuKeisanParam.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exDateEquals(zennouKoujyogakuKeisanParam.getZennoukaisiymd(), BizDate.valueOf("20181212"), "前納開始年月日");
        exNumericEquals(zennouKoujyogakuKeisanParam.getZennourenno(), 2, "前納連番");
        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getKjsmyouyenknsnkawaserate(), BizNumber.valueOf(11), "控除証明用円換算為替レート");
        BizDate calcKjnYmd = (BizDate) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setCalcKjnYmd", 0);
        exDateEquals(calcKjnYmd, BizDate.valueOf("20180116"), "計算基準日");
        BizDateYM henmaeJkipJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setHenmaeJkipJytYm", 0);
        exDateYMEquals(henmaeJkipJytYm, BizDateYM.valueOf("201812"), "変更前次回P充当年月");
        int kihrkpSeisanRenno = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setKihrkpSeisanRenno", 0);
        exNumericEquals(kihrkpSeisanRenno, 1, "既払込Ｐ精算連番");
        BizDateYM kihrkpSeisanJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setKihrkpSeisanJytYm", 0);
        exDateYMEquals(kihrkpSeisanJytYm, BizDateYM.valueOf("201812"), "既払込Ｐ精算充当年月");
        int kihrkpSeisanJytKaisuuY = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setKihrkpSeisanJytKaisuuY", 0);
        exNumericEquals(kihrkpSeisanJytKaisuuY, 10, "既払込Ｐ精算充当回数（年）");
        int kihrkpSeisanJytKaisuuM = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setKihrkpSeisanJytKaisuuM", 0);
        exNumericEquals(kihrkpSeisanJytKaisuuM, 20, "既払込Ｐ精算充当回数（月）");
        BizCurrency mkkp = (BizCurrency) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setMkkp", 0);
        exBizCalcbleEquals(mkkp, null, "未経過Ｐ");
        BizNumber seisanjiYenkansanKwsrate = (BizNumber) MockObjectManager.getArgument(EditKoujyonaiyouTblMockForHozen.class, "setSeisanjiYenkansanKwsrate", 0);
        exBizCalcbleEquals(seisanjiYenkansanKwsrate, null, "精算時円換算為替レート");

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean2 = (EditDshrTukiTanKoumokuBean) MockObjectManager.getArgument(
            SrDshrTukiDataSksMockForHozen.class, "execKhKsnAri", 0);
        exStringEquals(editDshrTukiTanKoumokuBean2.getHenkousikibetuKey(), khozenCommonParam.getSikibetuKey(editKaiyakuTblUpdateBean.getSyono()), "変更識別キー");
        exBizCalcbleEquals(editDshrTukiTanKoumokuBean2.getSiharaid(), BizCurrency.valueOf(15000), "支払Ｄ");
        exNumericEquals(editDshrTukiTanKoumokuBean2.getRenno(), 1, "連番");
        exStringEquals(editDshrTukiTanKoumokuBean2.getSkno(), "001", "請求番号");
        exStringEquals(editDshrTukiTanKoumokuBean2.getSyono(), "17806000013", "証券番号");
        exDateEquals(editDshrTukiTanKoumokuBean2.getSyoriYmd(), BizDate.valueOf("20180129"), "処理年月日");

        IT_KhHaitouKanri khHaitouKanri2 = editDshrTukiTanKoumokuBean2.getKhHaitouKanri();
        exBooleanEquals(khHaitouKanri2 == null, true, "配当管理テーブルエンティティ");
        IT_KhTumitateDKanri khTumitateDKanri2 = editDshrTukiTanKoumokuBean2.getKhTumitateDKanri();
        exBooleanEquals(khTumitateDKanri2 == null, true, "積立Ｄ管理テーブルエンティティ");
        exStringEquals(editDshrTukiTanKoumokuBean2.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exStringEquals(editDshrTukiTanKoumokuBean2.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");

        editDshrTukiDKoumokuBean = (EditDshrTukiDKoumokuBean) MockObjectManager.getArgument(
            SrDshrTukiDataSksMockForHozen.class, "execKhKsnAri", 1);
        exDateEquals(editDshrTukiDKoumokuBean.getCalckijyunYmd(), BizDate.valueOf("20181001"), "計算基準日");
        exDateEquals(editDshrTukiDKoumokuBean.getSyoriYmd2(), BizDate.valueOf("20181002"), "処理年月日２");

        IT_KykKihon kykKihon2 = (IT_KykKihon) MockObjectManager.getArgument( SetKhDshrTukiKykInfoMockForHozen.class, "exec", 0);
        exStringEquals(kykKihon2.getSyono(), "17806000013", "証券番号");
        KhozenCommonParam khozenCommonParam3 = (KhozenCommonParam) MockObjectManager.getArgument(
            SetKhDshrTukiKykInfoMockForHozen.class, "exec", 1);
        exStringEquals(khozenCommonParam3.getBatchKeiyakuKihon().getSyono(), "17806000013", "証券番号");
        exStringEquals(khozenCommonParam3.getBatchAnsyuKihon().getSyono(), "17806000013", "証券番号");

        exDateEquals((BizDate) MockObjectManager.getArgument(
            SetKhDshrTukiKykInfoMockForHozen.class, "exec", 2), BizDate.valueOf(20180120), "伝票日付");
        exDateEquals((BizDate) MockObjectManager.getArgument(
            SetKhDshrTukiKykInfoMockForHozen.class, "exec", 3), BizDate.valueOf(20180129), "処理年月日");

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = (BzFbSoukinDataSksBean) MockObjectManager. getArgument(BzFbSoukinDataSks.class, "execKh", 0);
        exBizCalcbleEquals(bzFbSoukinDataSksBean.getGaikaTaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨対価額");
        exBizCalcbleEquals(bzFbSoukinDataSksBean.getSoukinKwsRate(), BizNumber.valueOf(0), "送金用為替レート");

        BT_SikinIdouRireki sikinIdouRireki = editKaiyakuTblUpdate.getSikinIdouRireki();
        exDateEquals(sikinIdouRireki.getSyoriYmd(), syoriYmd, "処理年月日");
        exStringEquals(sikinIdouRireki.getKeirisyorirenno(), "", "経理用処理連番");
        exStringEquals(sikinIdouRireki.getSyono(), editKaiyakuTblUpdateBean.getSyono(), "証券番号");
        exStringEquals(sikinIdouRireki.getHenkousikibetukey(), khozenCommonParam.getSikibetuKey(editKaiyakuTblUpdateBean.getSyono()), "変更識別キー");
        exStringEquals(sikinIdouRireki.getTargetKinouId(), khozenCommonParam.getFunctionId(), "対象機能ＩＤ");
        exStringEquals(sikinIdouRireki.getSkno(), "", "請求番号");
        exNumericEquals(sikinIdouRireki.getSeikyuurirekino(), 0, "請求履歴番号");
        exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(sikinIdouRireki.getNykshrkbn(), C_NykshrKbn.SIHARAI, "入金支払区分");
        exStringEquals(sikinIdouRireki.getSyoricd(), "9001", "処理コード");
        exClassificationEquals(sikinIdouRireki.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exClassificationEquals(sikinIdouRireki.getSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(sikinIdouRireki.getKyktuukasyu(), kykSyouhnList.get(0).getKyktuukasyu(), "契約通貨種類");
        exClassificationEquals(sikinIdouRireki.getSyutkkbn(),  C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(sikinIdouRireki.getHrkkaisuu(), kykKihon.getHrkkaisuu(), "払込回数");
        exStringEquals(sikinIdouRireki.getSyouhncd(), kykSyouhnList.get(0).getSyouhncd(), "商品コード");
        exNumericEquals(sikinIdouRireki.getSyouhnsdno(), kykSyouhnList.get(0).getSyouhnsdno(), "商品世代番号");
        exNumericEquals(sikinIdouRireki.getKyksyouhnrenno(), kykSyouhnList.get(0).getKyksyouhnrenno(), "契約商品連番");
        exClassificationEquals(sikinIdouRireki.getShrhousiteikbn(), editKaiyakuTblUpdateBean.getShrhousiteikbn(), "支払方法指定区分");
        exDateYMEquals(sikinIdouRireki.getPhendoukaisiym(), null, "Ｐ変動開始年月");
        exBizCalcbleEquals(sikinIdouRireki.getPhendoumaegk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "Ｐ変動前金額");
        exBizCalcbleEquals(sikinIdouRireki.getPhendougogk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "Ｐ変動後金額");
        exDateEquals(sikinIdouRireki.getKykymd(), kykSyouhnList.get(0).getKykymd(), "契約日");
        exDateEquals(sikinIdouRireki.getSeirituymd(), kykKihon.getSeirituymd(), "成立日");
        exDateEquals(sikinIdouRireki.getSyoumetuymd(), editKaiyakuTblUpdateBean.getKaiykymd(), "消滅日");
        exDateYMEquals(sikinIdouRireki.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exClassificationEquals(sikinIdouRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(sikinIdouRireki.getSeikyuusyubetu(), C_SeikyuuSyubetu.BLNK, "請求種別");
        exClassificationEquals(sikinIdouRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.KAIYAKU, "消滅事由");
        exDateYMEquals(sikinIdouRireki.getJkipjytym(), null, "次回Ｐ充当年月");
        exDateYMEquals(sikinIdouRireki.getJyutoustartym(), null, "充当開始年月");
        exDateYMEquals(sikinIdouRireki.getJyutouendym(), null, "充当終了年月");
        exClassificationEquals(sikinIdouRireki.getNykkeiro(), C_Nykkeiro.BLNK, "入金経路");
        exClassificationEquals(sikinIdouRireki.getNyknaiyoukbn(), C_NyknaiyouKbn.BLNK, "入金内容区分");
        exClassificationEquals(sikinIdouRireki.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exBizCalcbleEquals(sikinIdouRireki.getHrkp(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "払込保険料");
        exBizCalcbleEquals(sikinIdouRireki.getHokenryou(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料");

        HanteiLincBean hanteiLincBean = (HanteiLincBean) MockObjectManager.getArgument(HanteiLincMockForHozen.class, "exec", 0);
        exDateEquals(hanteiLincBean.getSyoriYmd(), syoriYmd, "処理年月日");
        exStringEquals(hanteiLincBean.getBakKykKihon().getSyono(), editKaiyakuTblUpdateBean.getSyono(), "証券番号");
        exStringEquals(hanteiLincBean.getKykKihon().getSyono(), editKaiyakuTblUpdateBean.getSyono(), "証券番号");
        exStringEquals(String.valueOf(hanteiLincBean.getKanyuusyaNo()) , "null", "加入者番号");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = EditKoujyonaiyouTblMockForHozen.TESTPATTERN2;

        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");

        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000024");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.KYKSB);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6001));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5501));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20001));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(501));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(80000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.4));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(16);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1801));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(26);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(-80002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(80003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(80004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(80005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(80006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(80007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(80008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(3));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180122"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5601));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3001));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(3);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2501));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.USD);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5006");
        editKaiyakuTblUpdateBean.setSitencd("506");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.HUTUU);
        editKaiyakuTblUpdateBean.setKouzano("M4726");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.SITEI);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名２");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001002");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３２");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名２");
        editKaiyakuTblUpdateBean.setSaikennyno("2002003");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１２");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３２");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("708");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("809");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.BLNK);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.JPYSYUUSIN);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000024");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(-2000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setGkshrratetekiymd(BizDate.valueOf(20181212));
        editKaiyakuTblUpdateBean.setGkshrrate(BizNumber.valueOf(123.123));
        editKaiyakuTblUpdateBean.setKaiyakuhrgoukei(BizCurrency.valueOf(1234));
        editKaiyakuTblUpdateBean.setKaiyakuhrgoukeiyen(BizCurrency.valueOf(1233));
        editKaiyakuTblUpdateBean.setGksonotashrgk(BizCurrency.valueOf(1232));
        editKaiyakuTblUpdateBean.setJpysonotashrgk(BizCurrency.valueOf(1231));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(-2000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(9000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setMikeikapjyutouym(BizDateYM.valueOf("201812"));
        MiKeikaPBean miKeikaPBean0 = new MiKeikaPBean();
        miKeikaPBean0.setMiKeikaP(BizCurrency.valueOf(120));
        miKeikaPBean0.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
        miKeikaPBean0.setMkeiPJytKaisuuM(12);
        miKeikaPBean0.setMkeiPJytKaisuuY(1);
        miKeikaPBean0.setMkeiPJytYm(BizDateYM.valueOf("201812"));
        miKeikaPBean0.setMkeiPNykDenYmd(BizDate.valueOf("20181212"));
        MiKeikaPBean[] miKeikaPBean = {miKeikaPBean0};
        editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(miKeikaPBean);
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setMikeikapjyutouym(BizDateYM.valueOf("201812"));
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(10);
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(20);
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(9000));
        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000024", "1002");

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "02", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000024", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180130"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "02", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000024", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "02", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000024", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180121"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180130"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180116"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180119"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 16, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.NONE, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6001), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(9000), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.USD, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(-2000), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(6001), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(0), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(-80002), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(0), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(1000), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(1000), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(0), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(0), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(80003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(80004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(80005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "01", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(1000), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3001), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(80006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180118"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(2), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180121"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(2), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナカナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名２", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001002", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１２", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３２", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名２", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002003", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１２", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３２", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.GAIKAKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5006", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "506", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4726", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナカナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "708", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "809", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.NNKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2501), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 3, "契約者変更回数");
        exBizCalcbleEquals(khShrRireki.getZennomikeikap(), BizCurrency.valueOf(-3000), "前納未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYenzennomikeikap(), BizCurrency.valueOf(0), "円換算前納未経過保険料");
        exBizCalcbleEquals(khShrRireki.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(-2000), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getZitkazukarikingkyen(), BizCurrency.valueOf(2000), "税適預り金額（円貨）");
        exBizCalcbleEquals(khShrRireki.getYensonotahaitoukin(), BizCurrency.valueOf(12000), "円換算その他配当金");
        exBizCalcbleEquals(khShrRireki.getYenkrkgk(), BizCurrency.valueOf(6000), "円換算仮受金額");
        exDateEquals(khShrRireki.getGaikashrkwsratekjnymd(), BizDate.valueOf("20181212"), "外貨支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getGaikashrkwsrate(), BizNumber.valueOf(123.123), "外貨支払時為替レート");
        exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizCurrency.valueOf(1234), "解約返戻金額合計（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getShrtuukakaiyakuhrkngkkei(), BizCurrency.valueOf(1234), "支払通貨解約返戻金額合計");
        exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeiyen(), BizCurrency.valueOf(1233), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(khShrRireki.getSonotashrkngksiteituuka(), BizCurrency.valueOf(1232), "その他支払金額（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotashrkngk(), BizCurrency.valueOf(1232), "支払通貨その他支払金額");
        exBizCalcbleEquals(khShrRireki.getSonotashrkngkyen(), BizCurrency.valueOf(1231), "その他支払金額（円貨）");
        exBizCalcbleEquals(khShrRireki.getYensynykngk(), BizCurrency.valueOf(5601), "円換算収入金額");
        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "02", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000024", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 2, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 3, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6001), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20001), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(501), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.2), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.3),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(80000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.4), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(80007), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(80008), "指数連動積立金額");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "02", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000024", "証券番号");
        exClassificationEquals(kykSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 2, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 3, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exDateEquals(kykSyouhnList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20170202"), "効力発生日");
        exDateEquals(kykSyouhnList.get(0).getKykymd(), BizDate.valueOf("20180108"), "契約日");
        exClassificationEquals(kykSyouhnList.get(0).getKykymdsiteiumukbn(), C_UmuKbn.ARI, "契約日指定有無区分");
        exDateEquals(kykSyouhnList.get(0).getSknnkaisiymd(), BizDate.valueOf("20170302"), "責任開始日");
        exDateEquals(kykSyouhnList.get(0).getGansknnkaisiymd(), BizDate.valueOf("20170402"), "がん責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHksknnkaisiymd(), BizDate.valueOf("20170502"), "復活責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHkgansknnkaisiymd(), BizDate.valueOf("20170602"), "復活がん責任開始日");
        exClassificationEquals(kykSyouhnList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHknkkn(), 2, "保険期間");
        exClassificationEquals(kykSyouhnList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHrkkkn(), 6, "払込期間");
        exNumericEquals(kykSyouhnList.get(0).getKyknen(), 40, "契約者年齢");
        exNumericEquals(kykSyouhnList.get(0).getHhknnen(), 20, "被保険者年齢");
        exDateEquals(kykSyouhnList.get(0).getHhknseiymd(), BizDate.valueOf("20100102"), "被保険者生年月日");
        exClassificationEquals(kykSyouhnList.get(0).getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exDateEquals(kykSyouhnList.get(0).getHaraimanymd(), BizDate.valueOf("20170702"), "払満日");
        exDateEquals(kykSyouhnList.get(0).getHknkknmanryouymd(), BizDate.valueOf("20170802"), "保険期間満了日");
        exClassificationEquals(kykSyouhnList.get(0).getKatakbn(), C_KataKbn.HONNIN_TUMA, "型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE60, "給付限度型区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI,
            "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnList.get(0).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.SANDAISIPPMNJTOK, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKihons(), BizCurrency.valueOf(200), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnList.get(0).getHokenryou(), BizCurrency.valueOf(600), "保険料");
        exClassificationEquals(kykSyouhnList.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(kykSyouhnList.get(0).getRyouritusdno(), "102", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(2), "予定利率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(6),
            "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnList.get(0).getYtirrthndmnskaisuu(), 11, "予定利率変動見直回数");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(5),
            "契約時市場価格調整用利率");
        exClassificationEquals(kykSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(kykSyouhnList.get(0).getNenkinkkn(), 3, "年金期間");
        exNumericEquals(kykSyouhnList.get(0).getNkgnshosyouritu(), 7, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(2000), "年金原資最低保証額");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(kykSyouhnList.get(0).getGengakugoyenitijibrpstgk(), BizCurrency.valueOf(7001),
            "減額後円換算一時払保険料相当額");
        exDateEquals(kykSyouhnList.get(0).getYendthnkymd(), BizDate.valueOf("20170902"), "円建変更日");
        exBizCalcbleEquals(kykSyouhnList.get(0).getSetteibairitu(), BizNumber.valueOf(8), "設定倍率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTmttknzoukaritujygn(), BizNumber.valueOf(7), "積立金増加率上限");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTumitateriritu(), BizNumber.valueOf(6), "積立利率");
        exClassificationEquals(kykSyouhnList.get(0).getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY,
            "積立金配分状態");
        exClassificationEquals(kykSyouhnList.get(0).getSisuukbn(), C_Sisuukbn.BLCON1, "指数区分");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunrikzkakuninumu(), C_UmuKbn.ARI, "源泉分離課税確認有無");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunritaisyou(), C_UmuKbn.NONE, "源泉分離課税対象");
        exStringEquals(kykSyouhnList.get(1).getKbnkey(), "02", "区分キー");
        exStringEquals(kykSyouhnList.get(1).getSyono(), "17806000024", "証券番号");
        exClassificationEquals(kykSyouhnList.get(1).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exStringEquals(kykSyouhnList.get(1).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(kykSyouhnList.get(1).getSyouhnsdno(), 3, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(1).getKyksyouhnrenno(), 4, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(1).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(1).getKykjyoutai(), C_Kykjyoutai.HARAIMAN, "契約状態");
        exClassificationEquals(kykSyouhnList.get(1).getSyoumetujiyuu(), C_Syoumetujiyuu.SIKKOUKAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(1).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exDateEquals(kykSyouhnList.get(1).getKouryokuhasseiymd(), BizDate.valueOf("20170203"), "効力発生日");
        exDateEquals(kykSyouhnList.get(1).getKykymd(), BizDate.valueOf("20180109"), "契約日");
        exClassificationEquals(kykSyouhnList.get(1).getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnList.get(1).getSknnkaisiymd(), BizDate.valueOf("20170303"), "責任開始日");
        exDateEquals(kykSyouhnList.get(1).getGansknnkaisiymd(), BizDate.valueOf("20170403"), "がん責任開始日");
        exDateEquals(kykSyouhnList.get(1).getHksknnkaisiymd(), BizDate.valueOf("20170503"), "復活責任開始日");
        exDateEquals(kykSyouhnList.get(1).getHkgansknnkaisiymd(), BizDate.valueOf("20170603"), "復活がん責任開始日");
        exClassificationEquals(kykSyouhnList.get(1).getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(1).getHknkkn(), 3, "保険期間");
        exClassificationEquals(kykSyouhnList.get(1).getHrkkknsmnkbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(1).getHrkkkn(), 7, "払込期間");
        exNumericEquals(kykSyouhnList.get(1).getKyknen(), 50, "契約者年齢");
        exNumericEquals(kykSyouhnList.get(1).getHhknnen(), 30, "被保険者年齢");
        exDateEquals(kykSyouhnList.get(1).getHhknseiymd(), BizDate.valueOf("20100103"), "被保険者生年月日");
        exClassificationEquals(kykSyouhnList.get(1).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(kykSyouhnList.get(1).getHaraimanymd(), BizDate.valueOf("20170703"), "払満日");
        exDateEquals(kykSyouhnList.get(1).getHknkknmanryouymd(), BizDate.valueOf("20170803"), "保険期間満了日");
        exClassificationEquals(kykSyouhnList.get(1).getKatakbn(), C_KataKbn.HONIN_KO, "型区分");
        exClassificationEquals(kykSyouhnList.get(1).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE120, "給付限度型区分");
        exClassificationEquals(kykSyouhnList.get(1).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU1, "手術給付金型区分");
        exClassificationEquals(kykSyouhnList.get(1).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.BLNK,
            "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnList.get(1).getRokudaildkbn(), C_6daiLdKbn.NONE, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnList.get(1).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnList.get(1).getKihons(), BizCurrency.valueOf(300), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnList.get(1).getHokenryou(), BizCurrency.valueOf(700), "保険料");
        exClassificationEquals(kykSyouhnList.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(kykSyouhnList.get(1).getRyouritusdno(), "103", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnList.get(1).getYoteiriritu(), BizNumber.valueOf(3), "予定利率");
        exBizCalcbleEquals(kykSyouhnList.get(1).getYoteirrthendohosyurrt(), BizNumber.valueOf(7),
            "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnList.get(1).getYtirrthndmnskaisuu(), 12, "予定利率変動見直回数");
        exBizCalcbleEquals(kykSyouhnList.get(1).getKyksjkkktyouseiriritu(), BizNumber.valueOf(6),
            "契約時市場価格調整用利率");
        exClassificationEquals(kykSyouhnList.get(1).getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnList.get(1).getNenkinkkn(), 2, "年金期間");
        exNumericEquals(kykSyouhnList.get(1).getNkgnshosyouritu(), 6, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnList.get(1).getNkgnshosyougk(), BizCurrency.valueOf(3000), "年金原資最低保証額");
        exStringEquals(kykSyouhnList.get(1).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(1).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(1).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(kykSyouhnList.get(1).getGengakugoyenitijibrpstgk(), BizCurrency.valueOf(7002),
            "減額後円換算一時払保険料相当額");
        exDateEquals(kykSyouhnList.get(1).getYendthnkymd(), BizDate.valueOf("20170903"), "円建変更日");
        exBizCalcbleEquals(kykSyouhnList.get(1).getSetteibairitu(), BizNumber.valueOf(7), "設定倍率");
        exBizCalcbleEquals(kykSyouhnList.get(1).getTmttknzoukaritujygn(), BizNumber.valueOf(6), "積立金増加率上限");
        exBizCalcbleEquals(kykSyouhnList.get(1).getTumitateriritu(), BizNumber.valueOf(5), "積立利率");
        exClassificationEquals(kykSyouhnList.get(1).getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.SISUU_ONLY,
            "積立金配分状態");
        exClassificationEquals(kykSyouhnList.get(1).getSisuukbn(), C_Sisuukbn.BLCON2, "指数区分");
        exClassificationEquals(kykSyouhnList.get(1).getGsbunrikzkakuninumu(), C_UmuKbn.NONE, "源泉分離課税確認有無");
        exClassificationEquals(kykSyouhnList.get(1).getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");
        exStringEquals(kykSyouhnList.get(2).getKbnkey(), "02", "区分キー");
        exStringEquals(kykSyouhnList.get(2).getSyono(), "17806000024", "証券番号");
        exClassificationEquals(kykSyouhnList.get(2).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exStringEquals(kykSyouhnList.get(2).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(kykSyouhnList.get(2).getSyouhnsdno(), 4, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(2).getKyksyouhnrenno(), 5, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(2).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(2).getKykjyoutai(), C_Kykjyoutai.HARAIZUMI, "契約状態");
        exClassificationEquals(kykSyouhnList.get(2).getSyoumetujiyuu(), C_Syoumetujiyuu.KAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(2).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exDateEquals(kykSyouhnList.get(2).getKouryokuhasseiymd(), BizDate.valueOf("20170204"), "効力発生日");
        exDateEquals(kykSyouhnList.get(2).getKykymd(), BizDate.valueOf("20180110"), "契約日");
        exClassificationEquals(kykSyouhnList.get(2).getKykymdsiteiumukbn(), C_UmuKbn.ARI, "契約日指定有無区分");
        exDateEquals(kykSyouhnList.get(2).getSknnkaisiymd(), BizDate.valueOf("20170304"), "責任開始日");
        exDateEquals(kykSyouhnList.get(2).getGansknnkaisiymd(), BizDate.valueOf("20170404"), "がん責任開始日");
        exDateEquals(kykSyouhnList.get(2).getHksknnkaisiymd(), BizDate.valueOf("20170504"), "復活責任開始日");
        exDateEquals(kykSyouhnList.get(2).getHkgansknnkaisiymd(), BizDate.valueOf("20170604"), "復活がん責任開始日");
        exClassificationEquals(kykSyouhnList.get(2).getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(2).getHknkkn(), 4, "保険期間");
        exClassificationEquals(kykSyouhnList.get(2).getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(2).getHrkkkn(), 8, "払込期間");
        exNumericEquals(kykSyouhnList.get(2).getKyknen(), 60, "契約者年齢");
        exNumericEquals(kykSyouhnList.get(2).getHhknnen(), 40, "被保険者年齢");
        exDateEquals(kykSyouhnList.get(2).getHhknseiymd(), BizDate.valueOf("20100104"), "被保険者生年月日");
        exClassificationEquals(kykSyouhnList.get(2).getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exDateEquals(kykSyouhnList.get(2).getHaraimanymd(), BizDate.valueOf("20170704"), "払満日");
        exDateEquals(kykSyouhnList.get(2).getHknkknmanryouymd(), BizDate.valueOf("20170804"), "保険期間満了日");
        exClassificationEquals(kykSyouhnList.get(2).getKatakbn(), C_KataKbn.HONNIN_SAISI, "型区分");
        exClassificationEquals(kykSyouhnList.get(2).getKyhgndkatakbn(), C_KyhgndkataKbn.TYPE180, "給付限度型区分");
        exClassificationEquals(kykSyouhnList.get(2).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.SYU2, "手術給付金型区分");
        exClassificationEquals(kykSyouhnList.get(2).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.ITIBAI,
            "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnList.get(2).getRokudaildkbn(), C_6daiLdKbn.BLNK, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnList.get(2).getPmnjtkkbn(), C_PmnjtkKbn.SANDAISIPPMNJTOK, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnList.get(2).getKihons(), BizCurrency.valueOf(400), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnList.get(2).getHokenryou(), BizCurrency.valueOf(800), "保険料");
        exClassificationEquals(kykSyouhnList.get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(kykSyouhnList.get(2).getRyouritusdno(), "104", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnList.get(2).getYoteiriritu(), BizNumber.valueOf(4), "予定利率");
        exBizCalcbleEquals(kykSyouhnList.get(2).getYoteirrthendohosyurrt(), BizNumber.valueOf(8),
            "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnList.get(2).getYtirrthndmnskaisuu(), 13, "予定利率変動見直回数");
        exBizCalcbleEquals(kykSyouhnList.get(2).getKyksjkkktyouseiriritu(), BizNumber.valueOf(7),
            "契約時市場価格調整用利率");
        exClassificationEquals(kykSyouhnList.get(2).getNksyukbn(), C_Nenkinsyu.KAKUTEINENKIN, "年金種類区分");
        exNumericEquals(kykSyouhnList.get(2).getNenkinkkn(), 1, "年金期間");
        exNumericEquals(kykSyouhnList.get(2).getNkgnshosyouritu(), 5, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnList.get(2).getNkgnshosyougk(), BizCurrency.valueOf(4000), "年金原資最低保証額");
        exStringEquals(kykSyouhnList.get(2).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(2).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(2).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(kykSyouhnList.get(2).getGengakugoyenitijibrpstgk(), BizCurrency.valueOf(7003),
            "減額後円換算一時払保険料相当額");
        exDateEquals(kykSyouhnList.get(2).getYendthnkymd(), BizDate.valueOf("20170904"), "円建変更日");
        exBizCalcbleEquals(kykSyouhnList.get(2).getSetteibairitu(), BizNumber.valueOf(6), "設定倍率");
        exBizCalcbleEquals(kykSyouhnList.get(2).getTmttknzoukaritujygn(), BizNumber.valueOf(5), "積立金増加率上限");
        exBizCalcbleEquals(kykSyouhnList.get(2).getTumitateriritu(), BizNumber.valueOf(4), "積立利率");
        exClassificationEquals(kykSyouhnList.get(2).getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU,
            "積立金配分状態");
        exClassificationEquals(kykSyouhnList.get(2).getSisuukbn(), C_Sisuukbn.BLNK, "指数区分");
        exClassificationEquals(kykSyouhnList.get(2).getGsbunrikzkakuninumu(), C_UmuKbn.ARI, "源泉分離課税確認有無");
        exClassificationEquals(kykSyouhnList.get(2).getGsbunritaisyou(), C_UmuKbn.NONE, "源泉分離課税対象");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "02", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000024", "証券番号");
        exClassificationEquals(syouhnTokujouList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 2, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 3, "契約商品連番");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyhyouten(), C_Tkjyhyouten.HYOUTEN125, "特条標点");
        exBizCalcbleEquals(syouhnTokujouList.get(0).getTkjyp(), BizCurrency.valueOf(500), "特条保険料");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyskgnkkn(), C_Tkjyskgnkkn.Y1, "特条削減期間");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd1(), "12", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn1(), C_Htnpkkn.ONE, "不担保期間１");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd2(), "22", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn2(), C_Htnpkkn.TOW, "不担保期間２");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd3(), "32", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn3(), C_Htnpkkn.THREE, "不担保期間３");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd4(), "42", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn4(), C_Htnpkkn.THREE, "不担保期間４");
        exClassificationEquals(syouhnTokujouList.get(0).getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.ARI,
            "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");
        exStringEquals(syouhnTokujouList.get(1).getKbnkey(), "02", "区分キー");
        exStringEquals(syouhnTokujouList.get(1).getSyono(), "17806000024", "証券番号");
        exClassificationEquals(syouhnTokujouList.get(1).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exStringEquals(syouhnTokujouList.get(1).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(1).getSyouhnsdno(), 3, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(1).getKyksyouhnrenno(), 4, "契約商品連番");
        exClassificationEquals(syouhnTokujouList.get(1).getTkjyhyouten(), C_Tkjyhyouten.HYOUTEN150, "特条標点");
        exBizCalcbleEquals(syouhnTokujouList.get(1).getTkjyp(), BizCurrency.valueOf(600), "特条保険料");
        exClassificationEquals(syouhnTokujouList.get(1).getTkjyskgnkkn(), C_Tkjyskgnkkn.Y2, "特条削減期間");
        exStringEquals(syouhnTokujouList.get(1).getHtnpbuicd1(), "13", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouList.get(1).getHtnpkkn1(), C_Htnpkkn.TOW, "不担保期間１");
        exStringEquals(syouhnTokujouList.get(1).getHtnpbuicd2(), "23", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouList.get(1).getHtnpkkn2(), C_Htnpkkn.THREE, "不担保期間２");
        exStringEquals(syouhnTokujouList.get(1).getHtnpbuicd3(), "33", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouList.get(1).getHtnpkkn3(), C_Htnpkkn.FOUR, "不担保期間３");
        exStringEquals(syouhnTokujouList.get(1).getHtnpbuicd4(), "43", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouList.get(1).getHtnpkkn4(), C_Htnpkkn.TOW, "不担保期間４");
        exClassificationEquals(syouhnTokujouList.get(1).getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK,
            "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouList.get(1).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(1).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(1).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");
        exStringEquals(syouhnTokujouList.get(2).getKbnkey(), "02", "区分キー");
        exStringEquals(syouhnTokujouList.get(2).getSyono(), "17806000024", "証券番号");
        exClassificationEquals(syouhnTokujouList.get(2).getSyutkkbn(), C_SyutkKbn.TK, "主契約特約区分");
        exStringEquals(syouhnTokujouList.get(2).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(2).getSyouhnsdno(), 4, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(2).getKyksyouhnrenno(), 5, "契約商品連番");
        exClassificationEquals(syouhnTokujouList.get(2).getTkjyhyouten(), C_Tkjyhyouten.HYOUTEN175, "特条標点");
        exBizCalcbleEquals(syouhnTokujouList.get(2).getTkjyp(), BizCurrency.valueOf(700), "特条保険料");
        exClassificationEquals(syouhnTokujouList.get(2).getTkjyskgnkkn(), C_Tkjyskgnkkn.Y3, "特条削減期間");
        exStringEquals(syouhnTokujouList.get(2).getHtnpbuicd1(), "14", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouList.get(2).getHtnpkkn1(), C_Htnpkkn.THREE, "不担保期間１");
        exStringEquals(syouhnTokujouList.get(2).getHtnpbuicd2(), "24", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouList.get(2).getHtnpkkn2(), C_Htnpkkn.FOUR, "不担保期間２");
        exStringEquals(syouhnTokujouList.get(2).getHtnpbuicd3(), "34", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouList.get(2).getHtnpkkn3(), C_Htnpkkn.FIVE, "不担保期間３");
        exStringEquals(syouhnTokujouList.get(2).getHtnpbuicd4(), "44", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouList.get(2).getHtnpkkn4(), C_Htnpkkn.ONE, "不担保期間４");
        exClassificationEquals(syouhnTokujouList.get(2).getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.ARI,
            "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouList.get(2).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(2).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(2).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        IT_KhFBSoukinData khFBSoukinData = editKaiyakuTblUpdate.getKhFBSoukinData();
        exBooleanEquals(khFBSoukinData == null, true, "契約保全ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exBooleanEquals(batchKykKihon == null, true, "（バッチ用）契約基本テーブルエンティティ");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exBooleanEquals(batchAnsyuKihon == null, true, "（バッチ用）案内収納基本テーブルエンティティ");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exStringEquals(commonSiwakeInBeanParam.getKinouId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        exDateEquals(commonSiwakeInBeanParam.getDenYmd(), BizDate.valueOf("20180121"), "伝票日付");
        exClassificationEquals(commonSiwakeInBeanParam.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exDateEquals(commonSiwakeInBeanParam.getSyoriYmd(), BizDate.valueOf("20180130"), "処理年月日");
        exDateEquals(commonSiwakeInBeanParam.getKykYmd(), BizDate.valueOf("20180108"), "契約日");
        exStringEquals(commonSiwakeInBeanParam.getSyouhnCd(), "ﾕｱ", "商品コード");
        exNumericEquals(commonSiwakeInBeanParam.getSyouhnsdNo(), 2, "商品世代番号");
        exClassificationEquals(commonSiwakeInBeanParam.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(commonSiwakeInBeanParam.getShrhousiteiKbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI,
            "支払方法指定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTuukasyuKansanKawaserate(), BizNumber.valueOf(2),
            "契約通貨換算為替レート");
        exClassificationEquals(commonSiwakeInBeanParam.getAzukarikinUmuKbn(), C_UmuKbn.NONE, "預り金有無区分");
        exClassificationEquals(commonSiwakeInBeanParam.getHijynbrKanritukaHantKbn(), C_HijynbrKanritukaHantKbn.BLNK, "平準払管理通貨判定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getTaisyouGk(),
            BizCurrency.valueOf(6001), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKeiyakutuukaGk(),
            BizCurrency.valueOf(6001), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRTIENRSK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getTaisyouGk(),
            BizCurrency.valueOf(0), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
            BizCurrency.valueOf(-80002), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
            BizCurrency.valueOf(-80002), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getTaisyouGk(),
            BizCurrency.valueOf(-2000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKeiyakutuukaGk(),
            BizCurrency.valueOf(-2000), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getTaisyouGk(),
            BizCurrency.valueOf(6000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0.00,BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_D, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getTaisyouGk(),
            BizCurrency.valueOf(27000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0.00,BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getTaisyouGk(),
            BizCurrency.valueOf(0), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getTaisyouGk(),
            BizCurrency.valueOf(150), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0.00,BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getTaisyouGk(),
            BizCurrency.valueOf(200), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0.00,BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getTaisyouGk(),
            BizCurrency.valueOf(100), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0.00,BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(10).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_YENDTHNKHR, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(10).getTaisyouGk(),
            BizCurrency.valueOf(0), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(10).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(10).getSeg1cd(),
            C_Segcd.BLNK, "セグメント1コード");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(10).getSeg2cd(),
            C_Segcd.JPYSYUUSIN, "セグメント2コード");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(-2000), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(2), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.SUTE, "端数処理区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(6001), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(2), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 1, 3), C_HasuusyoriKbn.SUTE, "端数処理区分");

        MockObjectManager.assertArgumentPassed(BzGetAdrDataMockForHozen.class, "execTodouhukenCdByPostalcd", 0, "1001002");

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = (List<BzSiwakeMeisaiBean>) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 1);
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanListTest = new ArrayList<BzSiwakeMeisaiBean>();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBeanListTest.add(bzSiwakeMeisaiBean1);
        bzSiwakeMeisaiBeanListTest.add(bzSiwakeMeisaiBean2);
        bzSiwakeMeisaiBeanListTest.add(bzSiwakeMeisaiBean3);
        BizDate denYmd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 0);
        exDateEquals(denYmd, BizDate.valueOf("20180121"), "伝票日付");

        BizDate kykymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 1);
        exDateEquals(kykymd, BizDate.valueOf("20180108"), "契約日");

        BizCurrency jpyzennouseisankgk = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 2);
        exBizCalcbleEquals(jpyzennouseisankgk, BizCurrency.valueOf(-3000), "前納精算金");

        BizDate ryosyuymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 3);
        exDateEquals(ryosyuymd, null, "領収日");

        BizDateYM jkipjytym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 4);
        exDateYMEquals(jkipjytym, BizDateYM.valueOf("201812"), "次回Ｐ充当年月");

        BizCurrency jpymikeikap = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 5);
        exBizCalcbleEquals(jpymikeikap, BizCurrency.valueOf(9000), "未経過Ｐ");

        BizDateYM mikeikapjyutouym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 6);
        exDateYMEquals(mikeikapjyutouym, BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");

        MiKeikaPBean[] miKeikaPBeanTest = (MiKeikaPBean[]) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 7);
        exBizCalcbleEquals(miKeikaPBeanTest[0].getMiKeikaP(), miKeikaPBean[0].getMiKeikaP(), "明細未経過Ｐ");
        exClassificationEquals(miKeikaPBeanTest[0].getMkeiPHrkKaisuu(), miKeikaPBean[0].getMkeiPHrkKaisuu(), "明細未経過Ｐ払込回数");
        exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuM(), miKeikaPBean[0].getMkeiPJytKaisuuM(), "明細未経過Ｐ充当回数（月）");
        exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuY(), miKeikaPBean[0].getMkeiPJytKaisuuY(), "明細未経過Ｐ充当回数（年）");
        exDateYMEquals(miKeikaPBeanTest[0].getMkeiPJytYm(), miKeikaPBean[0].getMkeiPJytYm(), "明細未経過Ｐ充当年月");
        exDateEquals(miKeikaPBeanTest[0].getMkeiPNykDenYmd(), miKeikaPBean[0].getMkeiPNykDenYmd(), "明細未経過Ｐ入金伝票日付");

        String functionId = (String) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 8);
        exStringEquals(functionId, "EditKaiyakuTblUpdateTest_exec", "機能ＩＤ");

        C_SyoriKbn syoriKbn = (C_SyoriKbn) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execPKanjokamokuHantei", 9);

        exClassificationEquals(syoriKbn, C_SyoriKbn.BLNK, "処理区分");
        List<IT_Azukarikin> azukarikinList = editKaiyakuTblUpdate.getKykKihon().getAzukarikins();
        exDateEquals(azukarikinList.get(0).getShrymd(), BizDate.valueOf("20180119"), "支払日");
        exDateEquals(azukarikinList.get(0).getShrsyoriymd(), BizDate.valueOf("20180130"), "支払処理日");
        exStringEquals(azukarikinList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(azukarikinList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        List<IT_Kariukekin> kariukekinList = editKaiyakuTblUpdate.getKykKihon().getKariukekins();

        exClassificationEquals(kariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        exStringEquals(kariukekinList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kariukekinList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        IT_AnsyuKihon ansyuKihon1 = editKaiyakuTblUpdate.getAnsyuKihon();
        exStringEquals(ansyuKihon1.getGyoumuKousinKinou(), "init", "業務用更新機能ＩＤ");
        exStringEquals(ansyuKihon1.getGyoumuKousinsyaId(), "init", "業務用更新者ＩＤ");
        List<IT_Zennou> zennouLst = ansyuKihon1.getZennous();
        exClassificationEquals(zennouLst.get(0).getZennouseisankbn(), C_ZennouSeisanKbn.MISEISAN, "前納精算区分");
        exDateEquals(zennouLst.get(0).getZennouseisansyoriymd(), BizDate.valueOf("20181212"), "前納精算処理日");
        exBizCalcbleEquals(zennouLst.get(0).getZennouseisankgk(), BizCurrency.valueOf(12597), "前納精算金額");
        exDateEquals(zennouLst.get(0).getZennouseisankijyunymd(), BizDate.valueOf("20181211"), "前納精算基準日");
        exDateEquals(zennouLst.get(0).getZennouseisandenymd(), BizDate.valueOf("20181210"), "前納精算伝票日付");
        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), "init", "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), "init", "業務用更新者ＩＤ");
        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiList = resultKykKihon.getKihrkmpSeisanRirekis();
        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getRenno(), 1, "連番");
        exDateEquals(kihrkmpSeisanRirekiList.get(0).getKouryokuhasseiymd(), null, "効力発生日");
        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getKihrkpssnaiyoukbn(), null, "既払込Ｐ精算内容区分");
        exDateYMEquals(kihrkmpSeisanRirekiList.get(0).getJyuutouym(), null, "充当年月");
        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuum(), 20, "精算充当回数（月）");
        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuuy(), 10, "精算充当回数（年）");
        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getMisyuumikeikakbn(), null, "未収未経過区分");
        exDateEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsrate(), null, "税務用為替レート");
        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinKinou(), "init", "業務用更新機能ＩＤ");
        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinsyaId(), "init", "業務用更新者ＩＤ");
        exNumericEquals(kihrkmpSeisanRirekiList.get(1).getRenno(), 2, "連番");
        exDateEquals(kihrkmpSeisanRirekiList.get(1).getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exClassificationEquals(kihrkmpSeisanRirekiList.get(1).getKihrkpssnaiyoukbn(), C_KiharaiPseisanNaiyouKbn.SEISANP, "既払込Ｐ精算内容区分");
        exDateYMEquals(kihrkmpSeisanRirekiList.get(1).getJyuutouym(), BizDateYM.valueOf("201812"), "充当年月");
        exNumericEquals(kihrkmpSeisanRirekiList.get(1).getSeijyutoukaisuum(), 20, "精算充当回数（月）");
        exNumericEquals(kihrkmpSeisanRirekiList.get(1).getSeijyutoukaisuuy(), 10, "精算充当回数（年）");
        exClassificationEquals(kihrkmpSeisanRirekiList.get(1).getMisyuumikeikakbn(), C_MisyuumikeikaKbn.MIKEIKAP, "未収未経過区分");
        exDateEquals(kihrkmpSeisanRirekiList.get(1).getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(kihrkmpSeisanRirekiList.get(1).getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exStringEquals(kihrkmpSeisanRirekiList.get(1).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kihrkmpSeisanRirekiList.get(1).getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");

        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 1, "17806000024");
        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMockForHozen.class, "exec", 2, C_TsrysyoriKbn.KAIYAKU);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN2;
        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000035");
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000035");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000035", "1003");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(-9000));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setLastPJyuutouYm(BizDateYM.valueOf("201801"));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(-9000));
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "03", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000035", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180129"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "03", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000035", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exBooleanEquals(khShrRireki == null, false, "契約保全支払履歴テーブルエンティティ");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "03", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000035", "証券番号");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 9, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 9, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.SIKKOUKAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exNumericEquals(syouhnTokujouList.size(), 0, "商品特条テーブルエンティティリストの件数");

        List<IT_KhDenpyoData> khDenpyoDataList = editKaiyakuTblUpdate.getKhDenpyoDatas();
        exNumericEquals(khDenpyoDataList.size(), 3, "契約保全伝票データテーブルエンティティリストの件数");

        IT_KhFBSoukinData khFBSoukinData = editKaiyakuTblUpdate.getKhFBSoukinData();
        exBooleanEquals(khFBSoukinData == null, true, "契約保全ＦＢ送金データテーブルエンティティ");

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
        exBooleanEquals(khGaikaFBSoukinData == null, true, "契約保全外貨ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exStringEquals(batchKykKihon.getKbnkey(), "03", "区分キー");
        exStringEquals(batchKykKihon.getSyono(), "17806000035", "証券番号");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exStringEquals(batchAnsyuKihon.getKbnkey(), "03", "区分キー");
        exStringEquals(batchAnsyuKihon.getSyono(), "17806000035", "証券番号");
        List<IT_Zennou> zennouLst = ansyuKihon.getZennous();
        exClassificationEquals(zennouLst.get(0).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        exDateEquals(zennouLst.get(0).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        exBizCalcbleEquals(zennouLst.get(0).getZennouseisankgk(), BizCurrency.valueOf(3000), "前納精算金額");
        exDateEquals(zennouLst.get(0).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        exDateEquals(zennouLst.get(0).getZennouseisandenymd(), BizDate.valueOf("20181210"), "前納精算伝票日付");
        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exClassificationEquals(zennouLst.get(1).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        exDateEquals(zennouLst.get(1).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        exBizCalcbleEquals(zennouLst.get(1).getZennouseisankgk(), BizCurrency.valueOf(3000), "前納精算金額");
        exDateEquals(zennouLst.get(1).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        exDateEquals(zennouLst.get(1).getZennouseisandenymd(), BizDate.valueOf("20181210"), "前納精算伝票日付");
        exStringEquals(zennouLst.get(1).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(1).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exClassificationEquals(zennouLst.get(2).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        exDateEquals(zennouLst.get(2).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        exBizCalcbleEquals(zennouLst.get(2).getZennouseisankgk(), BizCurrency.valueOf(3000), "前納精算金額");
        exDateEquals(zennouLst.get(2).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        exDateEquals(zennouLst.get(2).getZennouseisandenymd(), BizDate.valueOf("20181210"), "前納精算伝票日付");
        exStringEquals(zennouLst.get(2).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(2).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        List<IT_Azukarikin> azukarikinList = editKaiyakuTblUpdate.getKykKihon().getAzukarikins();
        exDateEquals(azukarikinList.get(0).getShrymd(), BizDate.valueOf("20180119"), "支払日");
        exDateEquals(azukarikinList.get(0).getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exStringEquals(azukarikinList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(azukarikinList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exDateEquals(azukarikinList.get(1).getShrymd(), BizDate.valueOf("20180119"), "支払日");
        exDateEquals(azukarikinList.get(1).getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exStringEquals(azukarikinList.get(1).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(azukarikinList.get(1).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exDateEquals(azukarikinList.get(2).getShrymd(), BizDate.valueOf("20180119"), "支払日");
        exDateEquals(azukarikinList.get(2).getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exStringEquals(azukarikinList.get(2).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(azukarikinList.get(2).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        List<IT_Kariukekin> kariukekinList = editKaiyakuTblUpdate.getKykKihon().getKariukekins();
        exClassificationEquals(kariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        exStringEquals(kariukekinList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kariukekinList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exClassificationEquals(kariukekinList.get(1).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        exStringEquals(kariukekinList.get(1).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kariukekinList.get(1).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exClassificationEquals(kariukekinList.get(2).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        exStringEquals(kariukekinList.get(2).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kariukekinList.get(2).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN3;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000046");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180115"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5500));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20000));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(500));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(70000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.1));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(15);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1800));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(25);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(70002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(70003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(70004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(70005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(70006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(70007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(70008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7300));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5600));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(2);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2500));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.JPY);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5005");
        editKaiyakuTblUpdateBean.setSitencd("505");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.BLNK);
        editKaiyakuTblUpdateBean.setKouzano("M4725");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.DOUITU);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001001");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名");
        editKaiyakuTblUpdateBean.setSaikennyno("2002002");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("707");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("808");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000046");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000046", "1004");

        kinou.setKinouKbn(C_KinouKbn.ONLINE);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(1000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(-9000));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(-9000));

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "04", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000046", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180129"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "04", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000046", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "04", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000046", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180120"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180115"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180119"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 25, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.NONE, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.ARI, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6000), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(-9000), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getZennomikeikap(), BizCurrency.valueOf(-3000), "前納未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(2000), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(5500), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(0), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(70003), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(1800), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(2000), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(5500), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(0), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(0), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(70003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(70004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(70005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(1800), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3000), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(70006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180117"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(1), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180121"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(2), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001001", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002002", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.BLNK,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5005", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "505", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4725", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "707", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "707", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2500), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 2, "契約者変更回数");

        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "04", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000046", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 5, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 6, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6000), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20000), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(500), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.1), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.2),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(70000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.3), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(70007), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(70008), "指数連動積立金額");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "04", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000046", "証券番号");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 5, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 6, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "04", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000046", "証券番号");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 5, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 6, "契約商品連番");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
        exBooleanEquals(khGaikaFBSoukinData == null, true, "契約保全外貨ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exBooleanEquals(batchKykKihon == null, true, "（バッチ用）契約基本テーブルエンティティ");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exBooleanEquals(batchAnsyuKihon == null, true, "（バッチ用）案内収納基本テーブルエンティティ");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exStringEquals(commonSiwakeInBeanParam.getKinouId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        exDateEquals(commonSiwakeInBeanParam.getDenYmd(), BizDate.valueOf("20180120"), "伝票日付");
        exClassificationEquals(commonSiwakeInBeanParam.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals(commonSiwakeInBeanParam.getSyoriYmd(), BizDate.valueOf("20180129"), "処理年月日");
        exDateEquals(commonSiwakeInBeanParam.getKykYmd(), BizDate.valueOf("20180119"), "契約日");
        exStringEquals(commonSiwakeInBeanParam.getSyouhnCd(), "ﾕｱ", "商品コード");
        exNumericEquals(commonSiwakeInBeanParam.getSyouhnsdNo(), 5, "商品世代番号");
        exClassificationEquals(commonSiwakeInBeanParam.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(commonSiwakeInBeanParam.getShrhousiteiKbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI,
            "支払方法指定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTuukasyuKansanKawaserate(), BizNumber.valueOf(1),
            "契約通貨換算為替レート");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getTaisyouGk(),
            BizCurrency.valueOf(5500), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKeiyakutuukaGk(),
            BizCurrency.valueOf(6000), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRTIENRSK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getTaisyouGk(),
            BizCurrency.valueOf(1800), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKeiyakutuukaGk(),
            null, "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
            BizCurrency.valueOf(70003), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
            BizCurrency.valueOf(70002), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getTaisyouGk(),
            BizCurrency.valueOf(2000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKeiyakutuukaGk(),
            BizCurrency.valueOf(1000), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getTaisyouGk(),
            BizCurrency.valueOf(6000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN4;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");

        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000057");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6001));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5501));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20001));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(501));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(80000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.4));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2001));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(16);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1801));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(26);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(80002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(80003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(80004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(80005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(80006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.optional());
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(80008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(3));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180122"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5601));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3001));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(3);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2501));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.USD);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5006");
        editKaiyakuTblUpdateBean.setSitencd("506");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.HUTUU);
        editKaiyakuTblUpdateBean.setKouzano("M4726");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.SITEI);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名２");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001002");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３２");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名２");
        editKaiyakuTblUpdateBean.setSaikennyno("2002003");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１２");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３２");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("708");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("809");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000057");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000057", "1005");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(-1000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(0));

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "05", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000057", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180130"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "05", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000057", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "05", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000057", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180121"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180130"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180116"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180117"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180119"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 16, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.NONE, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.NONE, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6001), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.USD, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(7301), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(5501), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(0), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(80003), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(2001), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(7301), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(5501), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(0), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(0), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(80003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(80004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(80005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(1801), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3001), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(80006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180118"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(2), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180122"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(3), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナカナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名２", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001002", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１２", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３２", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名２", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002003", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１２", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３２", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.GAIKAKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5006", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "506", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4726", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナカナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "708", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "708", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.NNKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2501), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 3, "契約者変更回数");

        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "05", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000057", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 6, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 7, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6001), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20001), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(501), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.2), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.3),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(80000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.4), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(0), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(80008), "指数連動積立金額");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "05", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000057", "証券番号");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 6, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 7, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.KAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180117"), "消滅日");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "05", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000057", "証券番号");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 6, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 7, "契約商品連番");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        IT_KhFBSoukinData khFBSoukinData = editKaiyakuTblUpdate.getKhFBSoukinData();
        exBooleanEquals(khFBSoukinData == null, true, "契約保全ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exStringEquals(batchKykKihon.getKbnkey(), "05", "区分キー");
        exStringEquals(batchKykKihon.getSyono(), "17806000057", "証券番号");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exStringEquals(batchAnsyuKihon.getKbnkey(), "05", "区分キー");
        exStringEquals(batchAnsyuKihon.getSyono(), "17806000057", "証券番号");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();


        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN5;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000068");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180115"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.BLNK);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5500));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20000));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(500));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(70000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.1));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(15);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(25);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(70002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(70003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(70004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(70005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(70006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(70007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(70008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7300));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5600));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(2);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2500));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.JPY);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setBankcd("5005");
        editKaiyakuTblUpdateBean.setSitencd("505");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.BLNK);
        editKaiyakuTblUpdateBean.setKouzano("M4725");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.DOUITU);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001001");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名");
        editKaiyakuTblUpdateBean.setSaikennyno("2002002");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("707");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("808");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000068");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000068", "1006");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(1000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(-9000));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(-9000));

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "06", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000068", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180129"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "06", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000068", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "06", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000068", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180120"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180115"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180119"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 25, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.NONE, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.ARI, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6000), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(2000), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(5500), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(0), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(70003), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(0), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(2000), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(5500), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(0), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(-9000), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(70003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(70004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(70005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(0), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3000), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(70006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180117"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(1), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180121"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(2), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001001", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002002", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.BLNK,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5005", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "505", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4725", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "707", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2500), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 2, "契約者変更回数");

        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "06", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000068", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 7, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 8, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6000), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20000), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(500), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.1), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.2),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(70000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.3), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(70007), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(70008), "指数連動積立金額");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "06", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000068", "証券番号");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 7, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 8, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.SIKKOUKAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "06", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000068", "証券番号");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 7, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 8, "契約商品連番");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        IT_KhFBSoukinData khFBSoukinData = editKaiyakuTblUpdate.getKhFBSoukinData();
        exBooleanEquals(khFBSoukinData == null, true, "契約保全ＦＢ送金データテーブルエンティティ");

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
        exBooleanEquals(khGaikaFBSoukinData == null, true, "契約保全外貨ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exStringEquals(batchKykKihon.getKbnkey(), "06", "区分キー");
        exStringEquals(batchKykKihon.getSyono(), "17806000068", "証券番号");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exStringEquals(batchAnsyuKihon.getKbnkey(), "06", "区分キー");
        exStringEquals(batchAnsyuKihon.getSyono(), "17806000068", "証券番号");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exStringEquals(commonSiwakeInBeanParam.getKinouId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        exDateEquals(commonSiwakeInBeanParam.getDenYmd(), BizDate.valueOf("20180120"), "伝票日付");
        exClassificationEquals(commonSiwakeInBeanParam.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals(commonSiwakeInBeanParam.getSyoriYmd(), BizDate.valueOf("20180129"), "処理年月日");
        exDateEquals(commonSiwakeInBeanParam.getKykYmd(), BizDate.valueOf("20180118"), "契約日");
        exStringEquals(commonSiwakeInBeanParam.getSyouhnCd(), "ﾆｱ", "商品コード");
        exNumericEquals(commonSiwakeInBeanParam.getSyouhnsdNo(), 7, "商品世代番号");
        exClassificationEquals(commonSiwakeInBeanParam.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(commonSiwakeInBeanParam.getShrhousiteiKbn(), C_ShrhousiteiKbn.BLNK,
            "支払方法指定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTuukasyuKansanKawaserate(), BizNumber.valueOf(1),
            "契約通貨換算為替レート");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getTaisyouGk(),
            BizCurrency.valueOf(5500), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKeiyakutuukaGk(),
            BizCurrency.valueOf(6000), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRTIENRSK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getTaisyouGk(),
            BizCurrency.valueOf(0), "対象金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
            BizCurrency.valueOf(70003), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
            BizCurrency.valueOf(70002), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SHRGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getTaisyouGk(),
            BizCurrency.valueOf(2000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKeiyakutuukaGk(),
            BizCurrency.valueOf(1000), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getTaisyouGk(),
            BizCurrency.valueOf(6000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_D, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getTaisyouGk(),
            BizCurrency.valueOf(27000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getTaisyouGk(),
            BizCurrency.valueOf(0), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getTaisyouGk(),
            BizCurrency.valueOf(150), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getTaisyouGk(),
            BizCurrency.valueOf(200), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(8).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getTaisyouGk(),
            BizCurrency.valueOf(3100), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN2;
        KykHenkoujiZnnJytTrksKsnMockForHozen.SYORIPTN = KykHenkoujiZnnJytTrksKsnMockForHozen.TESTPATTERN1;
        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000079");
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000079");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000079", "1003");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(-9000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(9000));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));

        editKaiyakuTblUpdateBean.setLastPJyuutouYm(BizDateYM.valueOf("201711"));

        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "07", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000079", "証券番号");

        List<IT_Zennou> zennouLst = ansyuKihon.getZennous();
        exBizCalcbleEquals(zennouLst.get(0).getZennouseisankgk(), BizCurrency.valueOf(-3000), "前納精算金額");
        exDateEquals(zennouLst.get(0).getZennouseisandenymd(), BizDate.valueOf("20180119"), "前納精算伝票日付");
        exClassificationEquals(zennouLst.get(0).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        exDateEquals(zennouLst.get(0).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        exDateEquals(zennouLst.get(0).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        KhozenCommonParam pKhozenCommonParam = (KhozenCommonParam) MockObjectManager. getArgument(KykHenkoujiZnnJytTrksKsnMockForHozen.class, "exec", 0);
        exStringEquals(pKhozenCommonParam.getBatchKeiyakuKihon().getSyono(), "17806000079", "証券番号");
        exStringEquals(pKhozenCommonParam.getBatchAnsyuKihon().getSyono(), "17806000079", "証券番号");

        String pSyoNo = (String) MockObjectManager. getArgument(KykHenkoujiZnnJytTrksKsnMockForHozen.class, "exec", 1);
        exStringEquals(pSyoNo, "17806000079", "証券番号");

        BizDate pSyoriYmd = (BizDate) MockObjectManager. getArgument(KykHenkoujiZnnJytTrksKsnMockForHozen.class, "exec", 2);
        exDateEquals(pSyoriYmd, BizDate.valueOf("20180129"), "処理日");

        BizDateYM pZennouseisankgkStartYmd = (BizDateYM) MockObjectManager. getArgument(KykHenkoujiZnnJytTrksKsnMockForHozen.class, "exec", 3);
        exDateYMEquals(pZennouseisankgkStartYmd, BizDateYM.valueOf("201811"), "前納精算金開始年月");

        C_ZennouSeisanSyoriKbn pZennouSeisanSyoriKbn = (C_ZennouSeisanSyoriKbn) MockObjectManager. getArgument(KykHenkoujiZnnJytTrksKsnMockForHozen.class, "exec", 4);
        exClassificationEquals(pZennouSeisanSyoriKbn, C_ZennouSeisanSyoriKbn.SYOUMETU, "前納精算処理区分");


    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN4;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");

        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000080");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6001));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5501));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20001));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(501));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(80000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.4));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2001));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(16);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1801));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(26);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(80002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(80003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(80004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(80005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(80006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(80007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(80008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(3));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180122"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5601));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3001));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(3);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2501));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.USD);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5006");
        editKaiyakuTblUpdateBean.setSitencd("506");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.HUTUU);
        editKaiyakuTblUpdateBean.setKouzano("M4726");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.SITEI);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名２");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001002");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３２");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名２");
        editKaiyakuTblUpdateBean.setSaikennyno("2002003");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１２");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３２");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("708");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("809");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000080");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000080", "1005");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(-1000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(9000));

        khozenCommonParam.setFunctionId("khpminyuusyoumetu");
        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "08", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000080", "証券番号");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "khpminyuusyoumetu", "業務用更新機能ＩＤ");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "08", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000080", "証券番号");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "08", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000080", "証券番号");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.PMINYUUSYOUMETU, "支払処理区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "khpminyuusyoumetu", "業務用更新機能ＩＤ");
        exClassificationEquals(khShrRireki.getShrtysykurikosiyouhi(), C_YouhiKbn.HUYOU, "要否区分");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM, "消滅事由");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
            BizCurrency.valueOf(80003), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
            BizCurrency.valueOf(80003), "契約通貨金額");

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN1;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = EditKoujyonaiyouTblMockForHozen.TESTPATTERN4;

        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000091");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000091");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180115"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5500));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20000));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(500));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(70000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.1));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(15);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1800));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(25);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(70002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(70003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(70004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(70005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(70006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(70007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(70008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7300));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5600));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(2);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2500));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180101"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.JPY);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        editKaiyakuTblUpdateBean.setBankcd("5005");
        editKaiyakuTblUpdateBean.setSitencd("505");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.BLNK);
        editKaiyakuTblUpdateBean.setKouzano("M4725");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.DOUITU);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001001");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名");
        editKaiyakuTblUpdateBean.setSaikennyno("2002002");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("707");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("808");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000091");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setGkshrratetekiymd(BizDate.valueOf(20181212));
        editKaiyakuTblUpdateBean.setGkshrrate(BizNumber.valueOf(123.123));
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(10);
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(20);
        editKaiyakuTblUpdateBean.setMikeikapjyutouym(BizDateYM.valueOf("201812"));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(9000));
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(120));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
        miKeikaPBean1.setMkeiPJytKaisuuM(12);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf("201812"));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf("20181212"));
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(130));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.NEN);
        miKeikaPBean2.setMkeiPJytKaisuuM(11);
        miKeikaPBean2.setMkeiPJytKaisuuY(2);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf("201811"));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf("20181213"));
        MiKeikaPBean[] miKeikaPBean = {miKeikaPBean1, miKeikaPBean2};
        editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(miKeikaPBean);
        editKaiyakuTblUpdateBean.setLastPJyuutouYm(BizDateYM.valueOf("201712"));

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000091", "1001");

        kinou.setKinouKbn(C_KinouKbn.BATCH);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "09", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000091", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180129"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "09", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000091", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "09", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000091", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180101"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180115"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180118"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 15, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.NONE, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6000), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(7300), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(5500), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(0), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(70003), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(2000), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(7300), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(5500), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(0), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(9000), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(70003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(70004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(70005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "01", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(1800), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3000), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(70006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180117"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(1), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180121"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(2), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001001", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002002", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.BLNK,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5005", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "505", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4725", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "707", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "707", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2500), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 2, "契約者変更回数");
        exBizCalcbleEquals(khShrRireki.getZennomikeikap(), BizCurrency.valueOf(0), "前納未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYenzennomikeikap(), BizCurrency.valueOf(3000), "円換算前納未経過保険料");

        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "09", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000091", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 2, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6000), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20000), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(500), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.1), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.2),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(70000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.3), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(70007), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(70008), "指数連動積立金額");

        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = khTtdkRireki.getKykSyouhnRirekis();
        exStringEquals(kykSyouhnRirekiList.get(0).getKbnkey(), "09", "区分キー");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyono(), "17806000091", "証券番号");
        exClassificationEquals(kykSyouhnRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiList = khTtdkRireki.getSyouhnTokujouRirekis();
        exStringEquals(syouhnTokujouRirekiList.get(0).getKbnkey(), "09", "区分キー");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyono(), "17806000091", "証券番号");
        exClassificationEquals(syouhnTokujouRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "09", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000091", "証券番号");
        exClassificationEquals(kykSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.ZENNOU, "契約状態");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.SIKKOUKAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exDateEquals(kykSyouhnList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20170201"), "効力発生日");
        exDateEquals(kykSyouhnList.get(0).getKykymd(), BizDate.valueOf("20180118"), "契約日");
        exClassificationEquals(kykSyouhnList.get(0).getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnList.get(0).getSknnkaisiymd(), BizDate.valueOf("20170301"), "責任開始日");
        exDateEquals(kykSyouhnList.get(0).getGansknnkaisiymd(), BizDate.valueOf("20170401"), "がん責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHksknnkaisiymd(), BizDate.valueOf("20170501"), "復活責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHkgansknnkaisiymd(), BizDate.valueOf("20170601"), "復活がん責任開始日");
        exClassificationEquals(kykSyouhnList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHknkkn(), 1, "保険期間");
        exClassificationEquals(kykSyouhnList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHrkkkn(), 5, "払込期間");
        exNumericEquals(kykSyouhnList.get(0).getKyknen(), 30, "契約者年齢");
        exNumericEquals(kykSyouhnList.get(0).getHhknnen(), 10, "被保険者年齢");
        exDateEquals(kykSyouhnList.get(0).getHhknseiymd(), BizDate.valueOf("20100101"), "被保険者生年月日");
        exClassificationEquals(kykSyouhnList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(kykSyouhnList.get(0).getHaraimanymd(), BizDate.valueOf("20170701"), "払満日");
        exDateEquals(kykSyouhnList.get(0).getHknkknmanryouymd(), BizDate.valueOf("20170801"), "保険期間満了日");
        exClassificationEquals(kykSyouhnList.get(0).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI,
            "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnList.get(0).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKihons(), BizCurrency.valueOf(100), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnList.get(0).getHokenryou(), BizCurrency.valueOf(500), "保険料");
        exClassificationEquals(kykSyouhnList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(kykSyouhnList.get(0).getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(1), "予定利率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(5),
            "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnList.get(0).getYtirrthndmnskaisuu(), 10, "予定利率変動見直回数");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(4),
            "契約時市場価格調整用利率");
        exClassificationEquals(kykSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnList.get(0).getNenkinkkn(), 4, "年金期間");
        exNumericEquals(kykSyouhnList.get(0).getNkgnshosyouritu(), 8, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1000), "年金原資最低保証額");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(kykSyouhnList.get(0).getGengakugoyenitijibrpstgk(), BizCurrency.valueOf(7000),
            "減額後円換算一時払保険料相当額");
        exDateEquals(kykSyouhnList.get(0).getYendthnkymd(), BizDate.valueOf("20170901"), "円建変更日");
        exBizCalcbleEquals(kykSyouhnList.get(0).getSetteibairitu(), BizNumber.valueOf(9), "設定倍率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTmttknzoukaritujygn(), BizNumber.valueOf(8), "積立金増加率上限");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTumitateriritu(), BizNumber.valueOf(7), "積立利率");
        exClassificationEquals(kykSyouhnList.get(0).getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.BLNK,
            "積立金配分状態");
        exClassificationEquals(kykSyouhnList.get(0).getSisuukbn(), C_Sisuukbn.BLNK, "指数区分");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunrikzkakuninumu(), C_UmuKbn.NONE, "源泉分離課税確認有無");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "09", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000091", "証券番号");
        exClassificationEquals(syouhnTokujouList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyhyouten(), C_Tkjyhyouten.HYOUTEN100, "特条標点");
        exBizCalcbleEquals(syouhnTokujouList.get(0).getTkjyp(), BizCurrency.valueOf(400), "特条保険料");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "特条削減期間");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd1(), "11", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn1(), C_Htnpkkn.BLNK, "不担保期間１");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd2(), "21", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn2(), C_Htnpkkn.ONE, "不担保期間２");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd3(), "31", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn3(), C_Htnpkkn.TOW, "不担保期間３");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd4(), "41", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn4(), C_Htnpkkn.FOUR, "不担保期間４");
        exClassificationEquals(syouhnTokujouList.get(0).getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK,
            "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");
        //
        //        IT_KhHenreikin khHenreikin = resultKykKihon.getKhHenreikins().get(0);
        //        exStringEquals(khHenreikin.getKbnkey(), "09", "区分キー");
        //        exStringEquals(khHenreikin.getSyono(), "17806000091", "証券番号");
        //        exStringEquals(khHenreikin.getHenkousikibetukey(), "1001", "変更識別キー");
        //        exClassificationEquals(khHenreikin.getHrsyuruikbn(), C_HrsyuruiKbn.YENDTHNKHENREI, "返戻金種類区分");
        //        exDateEquals(khHenreikin.getShrymd(), BizDate.valueOf("20180101"), "支払日");
        //        exDateEquals(khHenreikin.getShrsyoriymd(), BizDate.valueOf("20180102"), "支払処理日");
        //        exDateEquals(khHenreikin.getHrhsisyoriymd(), BizDate.valueOf("20180103"), "返戻金発生処理日");
        //        exDateEquals(khHenreikin.getHrhsiymd(), BizDate.valueOf("20180104"), "返戻金発生日");
        //        exBizCalcbleEquals(khHenreikin.getHenreikingk(), BizCurrency.valueOf(2000), "返戻金額");
        //        exClassificationEquals(khHenreikin.getHrsiharaijyoutaikbn(), C_Siharaijyoutaikbn.MBR,
        //            "返戻金支払状態区分");
        //        exClassificationEquals(khHenreikin.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        //        exClassificationEquals(khHenreikin.getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        //        exClassificationEquals(khHenreikin.getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        //

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
        exBooleanEquals(khGaikaFBSoukinData == null, true, "契約保全外貨ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exStringEquals(batchKykKihon.getKbnkey(), "09", "区分キー");
        exStringEquals(batchKykKihon.getSyono(), "17806000091", "証券番号");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exStringEquals(batchAnsyuKihon.getKbnkey(), "09", "区分キー");
        exStringEquals(batchAnsyuKihon.getSyono(), "17806000091", "証券番号");

        KhozenCommonParam khozenCommonParam1 = (KhozenCommonParam) MockObjectManager.getArgument(
            EditKykSyhnRirekiTblMockForHozen.class, "exec", 0);
        exStringEquals(khozenCommonParam1.getBatchKeiyakuKihon().getSyono(), "17806000091", "証券番号");
        MockObjectManager.assertArgumentPassed(EditKykSyhnRirekiTblMockForHozen.class, "exec", 1, "17806000091");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exStringEquals(commonSiwakeInBeanParam.getKinouId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        exDateEquals(commonSiwakeInBeanParam.getDenYmd(), BizDate.valueOf("20180101"), "伝票日付");
        exClassificationEquals(commonSiwakeInBeanParam.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals(commonSiwakeInBeanParam.getSyoriYmd(), BizDate.valueOf("20180129"), "処理年月日");
        exDateEquals(commonSiwakeInBeanParam.getKykYmd(), BizDate.valueOf("20180118"), "契約日");
        exStringEquals(commonSiwakeInBeanParam.getSyouhnCd(), "ﾆｱ", "商品コード");
        exNumericEquals(commonSiwakeInBeanParam.getSyouhnsdNo(), 1, "商品世代番号");
        exClassificationEquals(commonSiwakeInBeanParam.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(commonSiwakeInBeanParam.getShrhousiteiKbn(), C_ShrhousiteiKbn.FB_YOKUJITU,
            "支払方法指定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTuukasyuKansanKawaserate(), BizNumber.valueOf(1),
            "契約通貨換算為替レート");
        exClassificationEquals(commonSiwakeInBeanParam.getAzukarikinUmuKbn(), C_UmuKbn.ARI, "預り金有無区分");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getTaisyouGk(),
        //            BizCurrency.valueOf(6000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(6000), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SHRTIENRSK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getTaisyouGk(),
        //            BizCurrency.valueOf(2000), "対象金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
        //            BizCurrency.valueOf(70003), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(70003), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SHRGK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getTaisyouGk(),
        //            BizCurrency.valueOf(8000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(8000), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getTaisyouGk(),
        //            BizCurrency.valueOf(0), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_D, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getTaisyouGk(),
        //            BizCurrency.valueOf(27000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getTaisyouGk(),
        //            BizCurrency.valueOf(150), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getTaisyouGk(),
        //            BizCurrency.valueOf(200), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getTaisyouGk(),
            BizCurrency.valueOf(2018), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        C_Tuukasyu tuukasyu = (C_Tuukasyu) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = (List<BzSiwakeMeisaiBean>) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 1);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenyenkagk(), BizCurrency.valueOf(400, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");

        MockObjectManager.assertArgumentPassed(BzGetAdrDataMockForHozen.class, "execTodouhukenCdByPostalcd", 0, "1011001");

        //        KhozenCommonParam khozenCommonParam2 = (KhozenCommonParam) MockObjectManager.getArgument(
        //            EditDairitenTesuuryouTblMock.class, "exec", 0);
        //        exStringEquals(khozenCommonParam2.getBatchKeiyakuKihon().getSyono(), "17806000091", "証券番号");
        //        exStringEquals(khozenCommonParam2.getBatchAnsyuKihon().getSyono(), "17806000091", "証券番号");
        //        exStringEquals(khozenCommonParam2.getFunctionId(), "khsyoukenmeisailistsks", "機能ID");
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 1, "17806000091");
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 2, C_TsrysyoriKbn.SIKKOU);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 3, null);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 4, 10);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 5, 20);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 6, BizCurrency.valueOf(9000));
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 7, BizCurrency.valueOf(0));
        //                IT_BAK_KykKihon bAK_KykKihon = (IT_BAK_KykKihon) MockObjectManager.getArgument(
        //                    EditDairitenTesuuryouTblMock.class, "exec", 8);
        //                exStringEquals(bAK_KykKihon.getKbnkey(), "09", "区分キー");
        //                exStringEquals(bAK_KykKihon.getSyono(), "17806000091", "証券番号");
        //                exStringEquals(bAK_KykKihon.getTrkssikibetukey(), "1001", "取消識別キー");
        //                BizDate denYmd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 0);
        //                exDateEquals(denYmd, BizDate.valueOf("20180120"), "伝票日付");
        //                BizDate kykymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 1);
        //                exDateEquals(kykymd, BizDate.valueOf("20180118"), "契約日");
        //                BizCurrency jpyzennouseisankgk = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 2);
        //                exBizCalcbleEquals(jpyzennouseisankgk, BizCurrency.valueOf(3000), "前納精算金");
        //                BizDate ryosyuymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 3);
        //                exDateEquals(ryosyuymd, BizDate.valueOf("20181219"), "領収日");
        //                BizDateYM jkipjytym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 4);
        //                exDateYMEquals(jkipjytym, BizDateYM.valueOf("201812"), "次回Ｐ充当年月");
        //                BizCurrency jpymikeikap = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 5);
        //                exBizCalcbleEquals(jpymikeikap, BizCurrency.valueOf(9000), "未経過Ｐ");
        //                BizDateYM mikeikapjyutouym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 6);
        //                exDateYMEquals(mikeikapjyutouym, BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        //                MiKeikaPBean[] miKeikaPBeanTest = (MiKeikaPBean[]) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 7);
        //                exBizCalcbleEquals(miKeikaPBeanTest[0].getMiKeikaP(), BizCurrency.valueOf(120), "明細未経過Ｐ");
        //                exClassificationEquals(miKeikaPBeanTest[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        //                exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuM(), 12, "明細未経過Ｐ充当回数（月）");
        //                exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuY(), 1, "明細未経過Ｐ充当回数（年）");
        //                exDateYMEquals(miKeikaPBeanTest[0].getMkeiPJytYm(), BizDateYM.valueOf("201812"), "明細未経過Ｐ充当年月");
        //                exDateEquals(miKeikaPBeanTest[0].getMkeiPNykDenYmd(), BizDate.valueOf("20181212"), "明細未経過Ｐ入金伝票日付");
        //                String functionId = (String) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 8);
        //                exStringEquals(functionId, "khsyoukenmeisailistsks", "機能ＩＤ");
        //                C_SyoriKbn syoriKbn = (C_SyoriKbn) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 9);
        //                exClassificationEquals(syoriKbn, C_SyoriKbn.BLNK, "処理区分");
        //                exBizCalcbleEquals(khShrRireki.getYenzennomikeikap(), BizCurrency.valueOf(3000), "円換算前納未経過保険料");
        //                exBizCalcbleEquals(khShrRireki.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(2000), "税適預り金額（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getZitkazukarikingkyen(), BizCurrency.valueOf(2000), "税適預り金額（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getYensonotahaitoukin(), BizCurrency.valueOf(12000), "円換算その他配当金");
        //                exBizCalcbleEquals(khShrRireki.getYenkrkgk(), BizCurrency.valueOf(6000), "円換算仮受金額");
        //                exDateEquals(khShrRireki.getGaikashrkwsratekjnymd(), BizDate.valueOf("20181212"), "外貨支払時為替レート基準日");
        //                exBizCalcbleEquals(khShrRireki.getGaikashrkwsrate(), BizNumber.valueOf(123.123), "外貨支払時為替レート");
        //                exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizCurrency.valueOf(6000), "解約返戻金額合計（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getShrtuukakaiyakuhrkngkkei(), BizCurrency.valueOf(5500), "支払通貨解約返戻金額合計");
        //                exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeiyen(), BizCurrency.valueOf(5500), "解約返戻金額合計（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getSonotashrkngksiteituuka(), BizCurrency.valueOf(97001), "その他支払金額（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getShrtuukasonotashrkngk(), BizCurrency.valueOf(97001), "支払通貨その他支払金額");
        //                exBizCalcbleEquals(khShrRireki.getSonotashrkngkyen(), BizCurrency.valueOf(97001), "その他支払金額（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getYensynykngk(), BizCurrency.valueOf(5600), "円換算収入金額");
        //        List<IT_Azukarikin> azukarikinList = editKaiyakuTblUpdate.getKykKihon().getAzukarikins();
        //        exDateEquals(azukarikinList.get(0).getShrymd(), BizDate.valueOf("20180118"), "支払日");
        //        exDateEquals(azukarikinList.get(0).getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        //        exStringEquals(azukarikinList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(azukarikinList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_Kariukekin> kariukekinList = editKaiyakuTblUpdate.getKykKihon().getKariukekins();
        //        exClassificationEquals(kariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        //        exStringEquals(kariukekinList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(kariukekinList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        IT_AnsyuKihon ansyuKihon1 = editKaiyakuTblUpdate.getAnsyuKihon();
        //        exStringEquals(ansyuKihon1.getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(ansyuKihon1.getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_Zennou> zennouLst = ansyuKihon1.getZennous();
        //        exClassificationEquals(zennouLst.get(0).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        //        exDateEquals(zennouLst.get(0).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        //        exBizCalcbleEquals(zennouLst.get(0).getZennouseisankgk(), BizCurrency.valueOf(3000), "前納精算金額");
        //        exDateEquals(zennouLst.get(0).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        //        exDateEquals(zennouLst.get(0).getZennouseisandenymd(), BizDate.valueOf("20180118"), "前納精算伝票日付");
        //        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiList = resultKykKihon.getKihrkmpSeisanRirekis();
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getRenno(), 1, "連番");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getHenkousikibetukey(), "1001", "変更識別キー");
        //        exDateEquals(kihrkmpSeisanRirekiList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        //        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getKihrkpssnaiyoukbn(), C_KiharaiPseisanNaiyouKbn.SEISANP, "既払込Ｐ精算内容区分");
        //        exDateYMEquals(kihrkmpSeisanRirekiList.get(0).getJyuutouym(), BizDateYM.valueOf("201812"), "充当年月");
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuum(), 20, "精算充当回数（月）");
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuuy(), 10, "精算充当回数（年）");
        //        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getMisyuumikeikakbn(), C_MisyuumikeikaKbn.MIKEIKAP, "未収未経過区分");
        //        exDateEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsratekjnymd(), BizDate.valueOf("20180117"), "税務用為替レート基準日");
        //        exBizCalcbleEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsrate(), BizNumber.valueOf(1), "税務用為替レート");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = (ZennouKoujyogakuKeisanParam) MockObjectManager.getArgument(
        //            EditKoujyonaiyouTblMock.class, "setZennouKoujyogakuKeisanParam", 0);
        //        exDateEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20181224"), "控除証明用前納開始年月日");
        //        exStringEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(), "30", "控除証明用前納期間（月）");
        //        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(123456789), "控除証明用前納入金額");
        //        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getHrkp(), BizCurrency.valueOf(122345789), "払込保険料");
        //        exClassificationEquals(zennouKoujyogakuKeisanParam.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        //        exDateEquals(zennouKoujyogakuKeisanParam.getZennoukaisiymd(), BizDate.valueOf("20181212"), "前納開始年月日");
        //        exNumericEquals(zennouKoujyogakuKeisanParam.getZennourenno(), 2, "前納連番");
        //        BizDate calcKjnYmd = (BizDate) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setCalcKjnYmd", 0);
        //        exDateEquals(calcKjnYmd, BizDate.valueOf("20180116"), "計算基準日");
        //        BizDateYM henmaeJkipJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setHenmaeJkipJytYm", 0);
        //        exDateYMEquals(henmaeJkipJytYm, BizDateYM.valueOf("201812"), "変更前次回P充当年月");
        //        String henmaeHenkousikibetukey = (String) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setHenmaeHenkousikibetukey", 0);
        //        exStringEquals(henmaeHenkousikibetukey, "1001", "変更前変更識別キー");
        //        int kihrkpSeisanRenno = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanRenno", 0);
        //        exNumericEquals(kihrkpSeisanRenno, 1, "既払込Ｐ精算連番");
        //        BizDateYM kihrkpSeisanJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytYm", 0);
        //        exDateYMEquals(kihrkpSeisanJytYm, BizDateYM.valueOf("201812"), "既払込Ｐ精算充当年月");
        //        int kihrkpSeisanJytKaisuuY = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytKaisuuY", 0);
        //        exNumericEquals(kihrkpSeisanJytKaisuuY, 10, "既払込Ｐ精算充当回数（年）");
        //        int kihrkpSeisanJytKaisuuM = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytKaisuuM", 0);
        //        exNumericEquals(kihrkpSeisanJytKaisuuM, 20, "既払込Ｐ精算充当回数（月）");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN1;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = EditKoujyonaiyouTblMockForHozen.TESTPATTERN4;
        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000105");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000105");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180115"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5500));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20000));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(500));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(70000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.1));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(15);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1800));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(25);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(70002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(70003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(70004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(70005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(70006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(70007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(70008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7300));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5600));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(2);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2500));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180101"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.JPY);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        editKaiyakuTblUpdateBean.setBankcd("5005");
        editKaiyakuTblUpdateBean.setSitencd("505");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.BLNK);
        editKaiyakuTblUpdateBean.setKouzano("M4725");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.DOUITU);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001001");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名");
        editKaiyakuTblUpdateBean.setSaikennyno("2002002");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("707");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("808");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000105");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(5000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setGkshrratetekiymd(BizDate.valueOf(20181212));
        editKaiyakuTblUpdateBean.setGkshrrate(BizNumber.valueOf(123.123));
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(10);
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(20);
        editKaiyakuTblUpdateBean.setMikeikapjyutouym(BizDateYM.valueOf("201812"));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(9000));
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(120));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
        miKeikaPBean1.setMkeiPJytKaisuuM(12);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf("201812"));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf("20181212"));
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(130));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.NEN);
        miKeikaPBean2.setMkeiPJytKaisuuM(11);
        miKeikaPBean2.setMkeiPJytKaisuuY(2);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf("201811"));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf("20181213"));
        MiKeikaPBean[] miKeikaPBean = {miKeikaPBean1, miKeikaPBean2};
        editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(miKeikaPBean);
        editKaiyakuTblUpdateBean.setLastPJyuutouYm(BizDateYM.valueOf("201712"));

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000105", "1001");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "00", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000105", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180129"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "00", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000105", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "00", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000105", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180101"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180115"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180118"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 15, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.NONE, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6000), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(7300), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(5500), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(0), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(70003), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(2000), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(7300), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(5500), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(0), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(9000), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(70003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(70004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(70005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "01", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(1800), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3000), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(70006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180117"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(1), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180121"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(2), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001001", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002002", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.BLNK,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5005", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "505", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4725", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "707", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "707", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2500), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 2, "契約者変更回数");
        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "00", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000105", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 2, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6000), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20000), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(500), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.1), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.2),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(70000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.3), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(70007), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(70008), "指数連動積立金額");

        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = khTtdkRireki.getKykSyouhnRirekis();
        exStringEquals(kykSyouhnRirekiList.get(0).getKbnkey(), "00", "区分キー");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyono(), "17806000105", "証券番号");
        exClassificationEquals(kykSyouhnRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiList = khTtdkRireki.getSyouhnTokujouRirekis();
        exStringEquals(syouhnTokujouRirekiList.get(0).getKbnkey(), "00", "区分キー");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyono(), "17806000105", "証券番号");
        exClassificationEquals(syouhnTokujouRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "00", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000105", "証券番号");
        exClassificationEquals(kykSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.ZENNOU, "契約状態");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.SIKKOUKAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exDateEquals(kykSyouhnList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20170201"), "効力発生日");
        exDateEquals(kykSyouhnList.get(0).getKykymd(), BizDate.valueOf("20180118"), "契約日");
        exClassificationEquals(kykSyouhnList.get(0).getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnList.get(0).getSknnkaisiymd(), BizDate.valueOf("20170301"), "責任開始日");
        exDateEquals(kykSyouhnList.get(0).getGansknnkaisiymd(), BizDate.valueOf("20170401"), "がん責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHksknnkaisiymd(), BizDate.valueOf("20170501"), "復活責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHkgansknnkaisiymd(), BizDate.valueOf("20170601"), "復活がん責任開始日");
        exClassificationEquals(kykSyouhnList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHknkkn(), 1, "保険期間");
        exClassificationEquals(kykSyouhnList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHrkkkn(), 5, "払込期間");
        exNumericEquals(kykSyouhnList.get(0).getKyknen(), 30, "契約者年齢");
        exNumericEquals(kykSyouhnList.get(0).getHhknnen(), 10, "被保険者年齢");
        exDateEquals(kykSyouhnList.get(0).getHhknseiymd(), BizDate.valueOf("20100101"), "被保険者生年月日");
        exClassificationEquals(kykSyouhnList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(kykSyouhnList.get(0).getHaraimanymd(), BizDate.valueOf("20170701"), "払満日");
        exDateEquals(kykSyouhnList.get(0).getHknkknmanryouymd(), BizDate.valueOf("20170801"), "保険期間満了日");
        exClassificationEquals(kykSyouhnList.get(0).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI,
            "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnList.get(0).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKihons(), BizCurrency.valueOf(100), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnList.get(0).getHokenryou(), BizCurrency.valueOf(500), "保険料");
        exClassificationEquals(kykSyouhnList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(kykSyouhnList.get(0).getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(1), "予定利率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(5),
            "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnList.get(0).getYtirrthndmnskaisuu(), 10, "予定利率変動見直回数");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(4),
            "契約時市場価格調整用利率");
        exClassificationEquals(kykSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnList.get(0).getNenkinkkn(), 4, "年金期間");
        exNumericEquals(kykSyouhnList.get(0).getNkgnshosyouritu(), 8, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1000), "年金原資最低保証額");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(kykSyouhnList.get(0).getGengakugoyenitijibrpstgk(), BizCurrency.valueOf(7000),
            "減額後円換算一時払保険料相当額");
        exDateEquals(kykSyouhnList.get(0).getYendthnkymd(), BizDate.valueOf("20170901"), "円建変更日");
        exBizCalcbleEquals(kykSyouhnList.get(0).getSetteibairitu(), BizNumber.valueOf(9), "設定倍率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTmttknzoukaritujygn(), BizNumber.valueOf(8), "積立金増加率上限");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTumitateriritu(), BizNumber.valueOf(7), "積立利率");
        exClassificationEquals(kykSyouhnList.get(0).getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.BLNK,
            "積立金配分状態");
        exClassificationEquals(kykSyouhnList.get(0).getSisuukbn(), C_Sisuukbn.BLNK, "指数区分");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunrikzkakuninumu(), C_UmuKbn.NONE, "源泉分離課税確認有無");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "00", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000105", "証券番号");
        exClassificationEquals(syouhnTokujouList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyhyouten(), C_Tkjyhyouten.HYOUTEN100, "特条標点");
        exBizCalcbleEquals(syouhnTokujouList.get(0).getTkjyp(), BizCurrency.valueOf(400), "特条保険料");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "特条削減期間");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd1(), "11", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn1(), C_Htnpkkn.BLNK, "不担保期間１");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd2(), "21", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn2(), C_Htnpkkn.ONE, "不担保期間２");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd3(), "31", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn3(), C_Htnpkkn.TOW, "不担保期間３");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd4(), "41", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn4(), C_Htnpkkn.FOUR, "不担保期間４");
        exClassificationEquals(syouhnTokujouList.get(0).getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK,
            "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        //        IT_KhHenreikin khHenreikin = resultKykKihon.getKhHenreikins().get(0);
        //        exStringEquals(khHenreikin.getKbnkey(), "00", "区分キー");
        //        exStringEquals(khHenreikin.getSyono(), "17806000105", "証券番号");
        //        exStringEquals(khHenreikin.getHenkousikibetukey(), "1001", "変更識別キー");
        //        exClassificationEquals(khHenreikin.getHrsyuruikbn(), C_HrsyuruiKbn.YENDTHNKHENREI, "返戻金種類区分");
        //        exDateEquals(khHenreikin.getShrymd(), BizDate.valueOf("20180101"), "支払日");
        //        exDateEquals(khHenreikin.getShrsyoriymd(), BizDate.valueOf("20180102"), "支払処理日");
        //        exDateEquals(khHenreikin.getHrhsisyoriymd(), BizDate.valueOf("20180103"), "返戻金発生処理日");
        //        exDateEquals(khHenreikin.getHrhsiymd(), BizDate.valueOf("20180104"), "返戻金発生日");
        //        exBizCalcbleEquals(khHenreikin.getHenreikingk(), BizCurrency.valueOf(2000), "返戻金額");
        //        exClassificationEquals(khHenreikin.getHrsiharaijyoutaikbn(), C_Siharaijyoutaikbn.MBR,
        //            "返戻金支払状態区分");
        //        exClassificationEquals(khHenreikin.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        //        exClassificationEquals(khHenreikin.getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        //        exClassificationEquals(khHenreikin.getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
        exBooleanEquals(khGaikaFBSoukinData == null, true, "契約保全外貨ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exStringEquals(batchKykKihon.getKbnkey(), "00", "区分キー");
        exStringEquals(batchKykKihon.getSyono(), "17806000105", "証券番号");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exStringEquals(batchAnsyuKihon.getKbnkey(), "00", "区分キー");
        exStringEquals(batchAnsyuKihon.getSyono(), "17806000105", "証券番号");

        KhozenCommonParam khozenCommonParam1 = (KhozenCommonParam) MockObjectManager.getArgument(
            EditKykSyhnRirekiTblMockForHozen.class, "exec", 0);
        exStringEquals(khozenCommonParam1.getBatchKeiyakuKihon().getSyono(), "17806000105", "証券番号");
        MockObjectManager.assertArgumentPassed(EditKykSyhnRirekiTblMockForHozen.class, "exec", 1, "17806000105");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exStringEquals(commonSiwakeInBeanParam.getKinouId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        exDateEquals(commonSiwakeInBeanParam.getDenYmd(), BizDate.valueOf("20180101"), "伝票日付");
        exClassificationEquals(commonSiwakeInBeanParam.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals(commonSiwakeInBeanParam.getSyoriYmd(), BizDate.valueOf("20180129"), "処理年月日");
        exDateEquals(commonSiwakeInBeanParam.getKykYmd(), BizDate.valueOf("20180118"), "契約日");
        exStringEquals(commonSiwakeInBeanParam.getSyouhnCd(), "ﾕﾁ", "商品コード");
        exNumericEquals(commonSiwakeInBeanParam.getSyouhnsdNo(), 1, "商品世代番号");
        exClassificationEquals(commonSiwakeInBeanParam.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(commonSiwakeInBeanParam.getShrhousiteiKbn(), C_ShrhousiteiKbn.FB_YOKUJITU,
            "支払方法指定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTuukasyuKansanKawaserate(), BizNumber.valueOf(1),
            "契約通貨換算為替レート");
        exClassificationEquals(commonSiwakeInBeanParam.getAzukarikinUmuKbn(), C_UmuKbn.ARI, "預り金有無区分");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getTaisyouGk(),
        //            BizCurrency.valueOf(6000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(6000), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SHRTIENRSK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getTaisyouGk(),
        //            BizCurrency.valueOf(2000), "対象金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
        //            BizCurrency.valueOf(70003), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(70003), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SHRGK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getTaisyouGk(),
        //            BizCurrency.valueOf(8000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(8000), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getTaisyouGk(),
        //            BizCurrency.valueOf(0), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_D, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getTaisyouGk(),
        //            BizCurrency.valueOf(27000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getTaisyouGk(),
        //            BizCurrency.valueOf(150), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getTaisyouGk(),
        //            BizCurrency.valueOf(200), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getTaisyouGk(),
            BizCurrency.valueOf(5001), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        C_Tuukasyu tuukasyu = (C_Tuukasyu) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = (List<BzSiwakeMeisaiBean>) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 1);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenyenkagk(), BizCurrency.valueOf(400, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");

        MockObjectManager.assertArgumentPassed(BzGetAdrDataMockForHozen.class, "execTodouhukenCdByPostalcd", 0, "1011001");

        //        KhozenCommonParam khozenCommonParam2 = (KhozenCommonParam) MockObjectManager.getArgument(
        //            EditDairitenTesuuryouTblMock.class, "exec", 0);
        //        exStringEquals(khozenCommonParam2.getBatchKeiyakuKihon().getSyono(), "17806000105", "証券番号");
        //        exStringEquals(khozenCommonParam2.getBatchAnsyuKihon().getSyono(), "17806000105", "証券番号");
        //        exStringEquals(khozenCommonParam2.getFunctionId(), "khsyoukenmeisailistsks", "機能ID");
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 1, "17806000105");
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 2, C_TsrysyoriKbn.SIKKOU);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 3, null);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 4, 10);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 5, 20);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 6, BizCurrency.valueOf(9000));
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 7, BizCurrency.valueOf(0));
        //                IT_BAK_KykKihon bAK_KykKihon = (IT_BAK_KykKihon) MockObjectManager.getArgument(
        //                    EditDairitenTesuuryouTblMock.class, "exec", 8);
        //                exStringEquals(bAK_KykKihon.getKbnkey(), "00", "区分キー");
        //                exStringEquals(bAK_KykKihon.getSyono(), "17806000105", "証券番号");
        //                exStringEquals(bAK_KykKihon.getTrkssikibetukey(), "1001", "取消識別キー");
        //                BizDate denYmd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 0);
        //                exDateEquals(denYmd, BizDate.valueOf("20180120"), "伝票日付");
        //                BizDate kykymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 1);
        //                exDateEquals(kykymd, BizDate.valueOf("20180118"), "契約日");
        //                BizCurrency jpyzennouseisankgk = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 2);
        //                exBizCalcbleEquals(jpyzennouseisankgk, BizCurrency.valueOf(3000), "前納精算金");
        //                BizDate ryosyuymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 3);
        //                exDateEquals(ryosyuymd, BizDate.valueOf("20181219"), "領収日");
        //                BizDateYM jkipjytym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 4);
        //                exDateYMEquals(jkipjytym, BizDateYM.valueOf("201812"), "次回Ｐ充当年月");
        //                BizCurrency jpymikeikap = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 5);
        //                exBizCalcbleEquals(jpymikeikap, BizCurrency.valueOf(9000), "未経過Ｐ");
        //                BizDateYM mikeikapjyutouym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 6);
        //                exDateYMEquals(mikeikapjyutouym, BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        //                MiKeikaPBean[] miKeikaPBeanTest = (MiKeikaPBean[]) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 7);
        //                exBizCalcbleEquals(miKeikaPBeanTest[0].getMiKeikaP(), BizCurrency.valueOf(120), "明細未経過Ｐ");
        //                exClassificationEquals(miKeikaPBeanTest[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        //                exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuM(), 12, "明細未経過Ｐ充当回数（月）");
        //                exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuY(), 1, "明細未経過Ｐ充当回数（年）");
        //                exDateYMEquals(miKeikaPBeanTest[0].getMkeiPJytYm(), BizDateYM.valueOf("201812"), "明細未経過Ｐ充当年月");
        //                exDateEquals(miKeikaPBeanTest[0].getMkeiPNykDenYmd(), BizDate.valueOf("20181212"), "明細未経過Ｐ入金伝票日付");
        //                String functionId = (String) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 8);
        //                exStringEquals(functionId, "khsyoukenmeisailistsks", "機能ＩＤ");
        //                C_SyoriKbn syoriKbn = (C_SyoriKbn) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 9);
        //                exClassificationEquals(syoriKbn, C_SyoriKbn.BLNK, "処理区分");
        //                exBizCalcbleEquals(khShrRireki.getYenzennomikeikap(), BizCurrency.valueOf(3000), "円換算前納未経過保険料");
        //                exBizCalcbleEquals(khShrRireki.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(5000), "税適預り金額（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getZitkazukarikingkyen(), BizCurrency.valueOf(2000), "税適預り金額（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getYensonotahaitoukin(), BizCurrency.valueOf(12000), "円換算その他配当金");
        //                exBizCalcbleEquals(khShrRireki.getYenkrkgk(), BizCurrency.valueOf(6000), "円換算仮受金額");
        //                exDateEquals(khShrRireki.getGaikashrkwsratekjnymd(), BizDate.valueOf("20181212"), "外貨支払時為替レート基準日");
        //                exBizCalcbleEquals(khShrRireki.getGaikashrkwsrate(), BizNumber.valueOf(123.123), "外貨支払時為替レート");
        //                exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizCurrency.valueOf(6000), "解約返戻金額合計（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getShrtuukakaiyakuhrkngkkei(), BizCurrency.valueOf(6000), "支払通貨解約返戻金額合計");
        //                exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeiyen(), BizCurrency.valueOf(5500), "解約返戻金額合計（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getSonotashrkngksiteituuka(), BizCurrency.valueOf(97001), "その他支払金額（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getShrtuukasonotashrkngk(), BizCurrency.valueOf(97001), "支払通貨その他支払金額");
        //                exBizCalcbleEquals(khShrRireki.getSonotashrkngkyen(), BizCurrency.valueOf(97001), "その他支払金額（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getYensynykngk(), BizCurrency.valueOf(5600), "円換算収入金額");
        //        List<IT_Azukarikin> azukarikinList = editKaiyakuTblUpdate.getKykKihon().getAzukarikins();
        //        exDateEquals(azukarikinList.get(0).getShrymd(), BizDate.valueOf("20180118"), "支払日");
        //        exDateEquals(azukarikinList.get(0).getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        //        exStringEquals(azukarikinList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(azukarikinList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_Kariukekin> kariukekinList = editKaiyakuTblUpdate.getKykKihon().getKariukekins();
        //        exClassificationEquals(kariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        //        exStringEquals(kariukekinList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(kariukekinList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        IT_AnsyuKihon ansyuKihon1 = editKaiyakuTblUpdate.getAnsyuKihon();
        //        exStringEquals(ansyuKihon1.getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(ansyuKihon1.getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_Zennou> zennouLst = ansyuKihon1.getZennous();
        //        exClassificationEquals(zennouLst.get(0).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        //        exDateEquals(zennouLst.get(0).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        //        exBizCalcbleEquals(zennouLst.get(0).getZennouseisankgk(), BizCurrency.valueOf(3000), "前納精算金額");
        //        exDateEquals(zennouLst.get(0).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        //        exDateEquals(zennouLst.get(0).getZennouseisandenymd(), BizDate.valueOf("20180118"), "前納精算伝票日付");
        //        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiList = resultKykKihon.getKihrkmpSeisanRirekis();
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getRenno(), 1, "連番");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getHenkousikibetukey(), "1001", "変更識別キー");
        //        exDateEquals(kihrkmpSeisanRirekiList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        //        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getKihrkpssnaiyoukbn(), C_KiharaiPseisanNaiyouKbn.SEISANP, "既払込Ｐ精算内容区分");
        //        exDateYMEquals(kihrkmpSeisanRirekiList.get(0).getJyuutouym(), BizDateYM.valueOf("201812"), "充当年月");
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuum(), 20, "精算充当回数（月）");
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuuy(), 10, "精算充当回数（年）");
        //        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getMisyuumikeikakbn(), C_MisyuumikeikaKbn.MIKEIKAP, "未収未経過区分");
        //        exDateEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsratekjnymd(), BizDate.valueOf("20180117"), "税務用為替レート基準日");
        //        exBizCalcbleEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsrate(), BizNumber.valueOf(1), "税務用為替レート");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = (ZennouKoujyogakuKeisanParam) MockObjectManager.getArgument(
        //            EditKoujyonaiyouTblMock.class, "setZennouKoujyogakuKeisanParam", 0);
        //        exDateEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20181224"), "控除証明用前納開始年月日");
        //        exStringEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(), "30", "控除証明用前納期間（月）");
        //        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(123456789), "控除証明用前納入金額");
        //        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getHrkp(), BizCurrency.valueOf(122345789), "払込保険料");
        //        exClassificationEquals(zennouKoujyogakuKeisanParam.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        //        exDateEquals(zennouKoujyogakuKeisanParam.getZennoukaisiymd(), BizDate.valueOf("20181212"), "前納開始年月日");
        //        exNumericEquals(zennouKoujyogakuKeisanParam.getZennourenno(), 2, "前納連番");
        //        BizDate calcKjnYmd = (BizDate) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setCalcKjnYmd", 0);
        //        exDateEquals(calcKjnYmd, BizDate.valueOf("20180116"), "計算基準日");
        //        BizDateYM henmaeJkipJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setHenmaeJkipJytYm", 0);
        //        exDateYMEquals(henmaeJkipJytYm, BizDateYM.valueOf("201812"), "変更前次回P充当年月");
        //        String henmaeHenkousikibetukey = (String) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setHenmaeHenkousikibetukey", 0);
        //        exStringEquals(henmaeHenkousikibetukey, "1001", "変更前変更識別キー");
        //        int kihrkpSeisanRenno = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanRenno", 0);
        //        exNumericEquals(kihrkpSeisanRenno, 1, "既払込Ｐ精算連番");
        //        BizDateYM kihrkpSeisanJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytYm", 0);
        //        exDateYMEquals(kihrkpSeisanJytYm, BizDateYM.valueOf("201812"), "既払込Ｐ精算充当年月");
        //        int kihrkpSeisanJytKaisuuY = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytKaisuuY", 0);
        //        exNumericEquals(kihrkpSeisanJytKaisuuY, 10, "既払込Ｐ精算充当回数（年）");
        //        int kihrkpSeisanJytKaisuuM = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytKaisuuM", 0);
        //        exNumericEquals(kihrkpSeisanJytKaisuuM, 20, "既払込Ｐ精算充当回数（月）");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        String gyoumuKousinTime = BizDate.getSysDateTimeMilli();

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN1;
        BzGetAdrDataMockForHozen.SYORIPTN = BzGetAdrDataMockForHozen.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;
        EditKoujyonaiyouTblMockForHozen.SYORIPTN = EditKoujyonaiyouTblMockForHozen.TESTPATTERN4;
        HanteiLincMockForHozen.SYORIPTN = HanteiLincMockForHozen.TESTPATTERN2;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000116");

        BizDate syoriYmd = BizDate.valueOf("20180129");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000116");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180115"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.TUUJYOU);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5500));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(1));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20000));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(500));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(70000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.1));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2000));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(15);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1800));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(25);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(70002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(70003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(70004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(70005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.ARI);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(70006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.valueOf(70007));
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(70008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8000));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7300));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5600));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(2);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2500));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180101"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.JPY);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        editKaiyakuTblUpdateBean.setBankcd("5005");
        editKaiyakuTblUpdateBean.setSitencd("505");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.BLNK);
        editKaiyakuTblUpdateBean.setKouzano("M4725");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.YENKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.DOUITU);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001001");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名");
        editKaiyakuTblUpdateBean.setSaikennyno("2002002");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("707");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("808");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000116");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(5000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(-2000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setGkshrratetekiymd(BizDate.valueOf(20181212));
        editKaiyakuTblUpdateBean.setGkshrrate(BizNumber.valueOf(123.123));
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuuy(10);
        editKaiyakuTblUpdateBean.setMikeikapjyutoukaisuum(20);
        editKaiyakuTblUpdateBean.setMikeikapjyutouym(BizDateYM.valueOf("201812"));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(9000));
        MiKeikaPBean miKeikaPBean1 = new MiKeikaPBean();
        miKeikaPBean1.setMiKeikaP(BizCurrency.valueOf(120));
        miKeikaPBean1.setMkeiPHrkKaisuu(C_Hrkkaisuu.HALFY);
        miKeikaPBean1.setMkeiPJytKaisuuM(12);
        miKeikaPBean1.setMkeiPJytKaisuuY(1);
        miKeikaPBean1.setMkeiPJytYm(BizDateYM.valueOf("201812"));
        miKeikaPBean1.setMkeiPNykDenYmd(BizDate.valueOf("20181212"));
        MiKeikaPBean miKeikaPBean2 = new MiKeikaPBean();
        miKeikaPBean2.setMiKeikaP(BizCurrency.valueOf(130));
        miKeikaPBean2.setMkeiPHrkKaisuu(C_Hrkkaisuu.NEN);
        miKeikaPBean2.setMkeiPJytKaisuuM(11);
        miKeikaPBean2.setMkeiPJytKaisuuY(2);
        miKeikaPBean2.setMkeiPJytYm(BizDateYM.valueOf("201811"));
        miKeikaPBean2.setMkeiPNykDenYmd(BizDate.valueOf("20181213"));
        MiKeikaPBean[] miKeikaPBean = {miKeikaPBean1, miKeikaPBean2};
        editKaiyakuTblUpdateBean.setMiKeikaPBeanHrt(miKeikaPBean);
        editKaiyakuTblUpdateBean.setLastPJyuutouYm(BizDateYM.valueOf("201712"));

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000116", "1001");

        kinou.setKinouKbn(C_KinouKbn.BATCH);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();
        exStringEquals(resultKykKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(resultKykKihon.getSyono(), "17806000116", "証券番号");
        exDateEquals(resultKykKihon.getSyhenkouymd(), BizDate.valueOf("20180129"), "最終変更日");
        exStringEquals(resultKykKihon.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(resultKykKihon.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);
        exStringEquals(khTtdkRireki.getKbnkey(), "01", "区分キー");
        exStringEquals(khTtdkRireki.getSyono(), "17806000116", "証券番号");
        exDateEquals(khTtdkRireki.getSyoriYmd(), null, "処理年月日");
        exStringEquals(khTtdkRireki.getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(khTtdkRireki.getShrsyousaiumu(), C_UmuKbn.NONE, "支払詳細有無区分");
        exClassificationEquals(khTtdkRireki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(khTtdkRireki.getHonninkakninkekkakbn(), C_HonninKakninKekkaKbn.BLNK, "本人確認結果区分");
        exClassificationEquals(khTtdkRireki.getHenkourrkumu(), C_UmuKbn.NONE, "変更履歴有無");
        exStringEquals(khTtdkRireki.getSmbckanriid(), "", "ＳＭＢＣ受付管理ＩＤ");
        exStringEquals(khTtdkRireki.getNayosekihontblskbtkey(), "", "名寄せ基本テーブル識別キー");
        exStringEquals(khTtdkRireki.getKouteikanriid(), "", "工程管理ＩＤ");
        exStringEquals(khTtdkRireki.getYoukyuuno(), "", "要求通番");
        exStringEquals(khTtdkRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khTtdkRireki.getGyoumuKousinTime(), "", "業務用更新時間");

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "01", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000116", "証券番号");
        exDateEquals(khShrRireki.getShrymd(), BizDate.valueOf("20180101"), "支払日");
        exDateEquals(khShrRireki.getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        exClassificationEquals(khShrRireki.getShrsyorikbn(), C_ShrsyoriKbn.KAIYAKU, "支払処理区分");
        exClassificationEquals(khShrRireki.getTorikesiflg(), C_UmuKbn.NONE, "取消フラグ");
        exDateEquals(khShrRireki.getTorikesiymd(), null, "取消日");
        exDateEquals(khShrRireki.getSyoruiukeymd(), BizDate.valueOf("20180115"), "書類受付日");
        exDateEquals(khShrRireki.getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        exDateEquals(khShrRireki.getShrtienrskkisanymd(), BizDate.valueOf("20180118"), "支払遅延利息起算日");
        exNumericEquals(khShrRireki.getTienrsknissuu(), 15, "遅延利息日数");
        exClassificationEquals(khShrRireki.getSinsagendokknkbn(), C_SinsaGendoKknKbn.BLNK, "審査限度期間区分");
        exNumericEquals(khShrRireki.getRikoukityuutuudannissuu(), 0, "履行期中断日数");
        exClassificationEquals(khShrRireki.getZeitratkikbn(), C_ZeitratkiKbn.BLNK, "税取扱区分");
        exClassificationEquals(khShrRireki.getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");
        exClassificationEquals(khShrRireki.getYenshrtkumu(), C_UmuKbn.NONE, "円支払特約有無");
        exClassificationEquals(khShrRireki.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exClassificationEquals(khShrRireki.getSyushrgkkeisyukbn(), C_SyuShrgkSyoukeiKbn.W, "主たる支払額小計種類区分");
        exBizCalcbleEquals(khShrRireki.getSyushrgkkei(), BizCurrency.valueOf(6000), "主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(khShrRireki.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(khShrRireki.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(khShrRireki.getGstszeigk(), BizCurrency.valueOf(0), "源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exClassificationEquals(khShrRireki.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrgkgoukei(), BizCurrency.valueOf(7300), "支払通貨支払額合計");
        exBizCalcbleEquals(khShrRireki.getShrtuukasyushrgkkei(), BizCurrency.valueOf(5500), "支払通貨主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getShrtuukahaitoukin(), BizCurrency.valueOf(0), "支払通貨配当金");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotaseisangk(), BizCurrency.valueOf(0), "支払通貨その他精算額");
        exBizCalcbleEquals(khShrRireki.getShrtuukagstszeigk(), BizCurrency.valueOf(70003), "支払通貨源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getShrtuukashrtienrsk(), BizCurrency.valueOf(2000), "支払通貨支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getYenshrgkgoukei(), BizCurrency.valueOf(7300), "円換算支払額合計");
        exBizCalcbleEquals(khShrRireki.getYensyushrgkkei(), BizCurrency.valueOf(5500), "円換算主たる支払額小計");
        exBizCalcbleEquals(khShrRireki.getYenkansanhaitoukin(), BizCurrency.valueOf(15000), "円換算配当金");
        exBizCalcbleEquals(khShrRireki.getYenkansansonotaseisangk(), BizCurrency.valueOf(0), "円換算その他精算額");
        exBizCalcbleEquals(khShrRireki.getYenmikeikap(), BizCurrency.valueOf(9000), "円換算未経過保険料");
        exBizCalcbleEquals(khShrRireki.getYengstszeigk(), BizCurrency.valueOf(70003), "円換算源泉徴収税額");
        exBizCalcbleEquals(khShrRireki.getYengstszeigknationaltax(), BizCurrency.valueOf(70004),
            "円換算源泉徴収税額（国税）");
        exBizCalcbleEquals(khShrRireki.getYengstszeigklocaltax(), BizCurrency.valueOf(70005),
            "円換算源泉徴収税額（地方税）");
        exStringEquals(khShrRireki.getNztodouhukencd(), "01", "納税先都道府県コード");
        exBizCalcbleEquals(khShrRireki.getYenshrtienrsk(), BizCurrency.valueOf(1800), "円換算支払遅延利息");
        exBizCalcbleEquals(khShrRireki.getHtykeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(khShrRireki.getKztgk(), BizCurrency.valueOf(0), "課税対象額");
        exBizCalcbleEquals(khShrRireki.getYenhtykeihi(), BizCurrency.valueOf(3000), "円換算必要経費");
        exBizCalcbleEquals(khShrRireki.getYenkztgk(), BizCurrency.valueOf(70006), "円換算課税対象額");
        exDateEquals(khShrRireki.getShrkwsratekjnymd(), BizDate.valueOf("20180117"), "支払時為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getShrkwsrate(), BizNumber.valueOf(1), "支払時為替レート");
        exDateEquals(khShrRireki.getZeimukwsratekjnymd(), BizDate.valueOf("20180121"), "税務用為替レート基準日");
        exBizCalcbleEquals(khShrRireki.getZeimukwsrate(), BizNumber.valueOf(2), "税務用為替レート");
        exClassificationEquals(khShrRireki.getSoukinsakisiteikbn(), C_SoukinsakisiteiKbn.BLNK, "送金先指定区分");
        exStringEquals(khShrRireki.getSoukinsakinmkn(), "", "送金先氏名（カナ）");
        exStringEquals(khShrRireki.getSoukinsakinmkj(), "", "送金先氏名（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiyno(), "", "送金先郵便番号");
        exStringEquals(khShrRireki.getSoukinsakiadr1kj(), "", "送金先住所１（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr2kj(), "", "送金先住所２（漢字）");
        exStringEquals(khShrRireki.getSoukinsakiadr3kj(), "", "送金先住所３（漢字）");
        exStringEquals(khShrRireki.getKyksyaszknmkn(), "カナ", "契約者相続人氏名（カナ）");
        exStringEquals(khShrRireki.getKyksyaszknmkj(), "契約者相続人氏名", "契約者相続人氏名（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkyno(), "1001001", "契約者相続人郵便番号");
        exStringEquals(khShrRireki.getKyksyaszkadr1kj(), "契約者相続人住所１", "契約者相続人住所１（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr2kj(), "契約者相続人住所２", "契約者相続人住所２（漢字）");
        exStringEquals(khShrRireki.getKyksyaszkadr3kj(), "契約者相続人住所３", "契約者相続人住所３（漢字）");
        exStringEquals(khShrRireki.getSaikennmkj(), "債権者氏名", "債権者氏名（漢字）");
        exStringEquals(khShrRireki.getSaikennyno(), "2002002", "債権者郵便番号");
        exStringEquals(khShrRireki.getSaikenadr1kj(), "債権者住所１", "債権者住所１（漢字）");
        exStringEquals(khShrRireki.getSaikenadr2kj(), "債権者住所２", "債権者住所２（漢字）");
        exStringEquals(khShrRireki.getSaikenadr3kj(), "債権者住所３", "債権者住所３（漢字）");
        exClassificationEquals(khShrRireki.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.BLNK,
            "入力用支払方法指定区分");
        exClassificationEquals(khShrRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exClassificationEquals(khShrRireki.getKzsyuruikbn(), C_KouzasyuruiKbn.YENKOUZA, "口座種類区分");
        exStringEquals(khShrRireki.getBankcd(), "5005", "銀行コード");
        exStringEquals(khShrRireki.getSitencd(), "505", "支店コード");
        exClassificationEquals(khShrRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khShrRireki.getKouzano(), "M4725", "口座番号");
        exClassificationEquals(khShrRireki.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(khShrRireki.getKzmeiginmkn(), "カナ", "口座名義人氏名（カナ）");
        exStringEquals(khShrRireki.getKykmnmeigibangou(), "707", "契約者ＭＮ名義番号");
        exStringEquals(khShrRireki.getUktmnmeigibangou(), "707", "受取人ＭＮ名義番号");
        exClassificationEquals(khShrRireki.getShrtysysyuruikbn(), C_HtsiryosyuKbn.ITJKNSHRTYOUSYO, "支払調書種類区分");
        exStringEquals(khShrRireki.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRireki.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRireki.getYenshrkykhtykeihi(), BizCurrency.valueOf(2500), "円換算支払時契約者必要経費");
        exNumericEquals(khShrRireki.getKykhnkkaisuu(), 2, "契約者変更回数");
        IT_KhShrRirekiDetail khShrRirekiDetail = khShrRireki.getKhShrRirekiDetails().get(0);
        exStringEquals(khShrRirekiDetail.getKbnkey(), "01", "区分キー");
        exStringEquals(khShrRirekiDetail.getSyono(), "17806000116", "証券番号");
        exStringEquals(khShrRirekiDetail.getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(khShrRirekiDetail.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(khShrRirekiDetail.getKyksyouhnrenno(), 2, "契約商品連番");
        exBizCalcbleEquals(khShrRirekiDetail.getSyushrgk(), BizCurrency.valueOf(6000), "主たる支払額");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkin(), BizCurrency.valueOf(20000), "支払対象積立金");
        exBizCalcbleEquals(khShrRirekiDetail.getShrtstmttkinhngkbbn(), BizCurrency.valueOf(0),
            "支払対象積立金（変額部分）");
        exBizCalcbleEquals(khShrRirekiDetail.getSjkkktyouseigk(), BizCurrency.valueOf(500), "市場価格調整額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiritu(), BizNumber.valueOf(0.1), "解約市場価格調整率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.2),
            "解約時市場価格調整用利率");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukjgk(), BizCurrency.valueOf(70000), "解約控除額");
        exBizCalcbleEquals(khShrRirekiDetail.getKaiyakukoujyoritu(), BizNumber.valueOf(0.3), "解約控除率");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(khShrRirekiDetail.getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(khShrRirekiDetail.getTeiritutmttkngk(), BizCurrency.valueOf(70007), "定率積立金額");
        exBizCalcbleEquals(khShrRirekiDetail.getSisuurendoutmttkngk(), BizCurrency.valueOf(70008), "指数連動積立金額");

        List<IT_KykSyouhnRireki> kykSyouhnRirekiList = khTtdkRireki.getKykSyouhnRirekis();
        exStringEquals(kykSyouhnRirekiList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyono(), "17806000116", "証券番号");
        exClassificationEquals(kykSyouhnRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiList = khTtdkRireki.getSyouhnTokujouRirekis();
        exStringEquals(syouhnTokujouRirekiList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyono(), "17806000116", "証券番号");
        exClassificationEquals(syouhnTokujouRirekiList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouRirekiList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouRirekiList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");

        List<IT_KykSyouhn> kykSyouhnList = resultKykKihon.getKykSyouhns();
        exStringEquals(kykSyouhnList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(kykSyouhnList.get(0).getSyono(), "17806000116", "証券番号");
        exClassificationEquals(kykSyouhnList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(kykSyouhnList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(kykSyouhnList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(kykSyouhnList.get(0).getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU,
            "有効消滅区分");
        exClassificationEquals(kykSyouhnList.get(0).getKykjyoutai(), C_Kykjyoutai.ZENNOU, "契約状態");
        exClassificationEquals(kykSyouhnList.get(0).getSyoumetujiyuu(), C_Syoumetujiyuu.SIKKOUKAIYAKU, "消滅事由");
        exDateEquals(kykSyouhnList.get(0).getSyoumetuymd(), BizDate.valueOf("20180116"), "消滅日");
        exDateEquals(kykSyouhnList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20170201"), "効力発生日");
        exDateEquals(kykSyouhnList.get(0).getKykymd(), BizDate.valueOf("20180118"), "契約日");
        exClassificationEquals(kykSyouhnList.get(0).getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnList.get(0).getSknnkaisiymd(), BizDate.valueOf("20170301"), "責任開始日");
        exDateEquals(kykSyouhnList.get(0).getGansknnkaisiymd(), BizDate.valueOf("20170401"), "がん責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHksknnkaisiymd(), BizDate.valueOf("20170501"), "復活責任開始日");
        exDateEquals(kykSyouhnList.get(0).getHkgansknnkaisiymd(), BizDate.valueOf("20170601"), "復活がん責任開始日");
        exClassificationEquals(kykSyouhnList.get(0).getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHknkkn(), 1, "保険期間");
        exClassificationEquals(kykSyouhnList.get(0).getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnList.get(0).getHrkkkn(), 5, "払込期間");
        exNumericEquals(kykSyouhnList.get(0).getKyknen(), 30, "契約者年齢");
        exNumericEquals(kykSyouhnList.get(0).getHhknnen(), 10, "被保険者年齢");
        exDateEquals(kykSyouhnList.get(0).getHhknseiymd(), BizDate.valueOf("20100101"), "被保険者生年月日");
        exClassificationEquals(kykSyouhnList.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exDateEquals(kykSyouhnList.get(0).getHaraimanymd(), BizDate.valueOf("20170701"), "払満日");
        exDateEquals(kykSyouhnList.get(0).getHknkknmanryouymd(), BizDate.valueOf("20170801"), "保険期間満了日");
        exClassificationEquals(kykSyouhnList.get(0).getKatakbn(), C_KataKbn.HONNIN, "型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(kykSyouhnList.get(0).getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnList.get(0).getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.NIBAI,
            "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnList.get(0).getRokudaildkbn(), C_6daiLdKbn.ARI, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnList.get(0).getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKihons(), BizCurrency.valueOf(100), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnList.get(0).getHokenryou(), BizCurrency.valueOf(500), "保険料");
        exClassificationEquals(kykSyouhnList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(kykSyouhnList.get(0).getRyouritusdno(), "101", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteiriritu(), BizNumber.valueOf(1), "予定利率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getYoteirrthendohosyurrt(), BizNumber.valueOf(5),
            "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnList.get(0).getYtirrthndmnskaisuu(), 10, "予定利率変動見直回数");
        exBizCalcbleEquals(kykSyouhnList.get(0).getKyksjkkktyouseiriritu(), BizNumber.valueOf(4),
            "契約時市場価格調整用利率");
        exClassificationEquals(kykSyouhnList.get(0).getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnList.get(0).getNenkinkkn(), 4, "年金期間");
        exNumericEquals(kykSyouhnList.get(0).getNkgnshosyouritu(), 8, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getNkgnshosyougk(), BizCurrency.valueOf(1000), "年金原資最低保証額");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(kykSyouhnList.get(0).getGyoumuKousinTime().substring(0, 8), gyoumuKousinTime.substring(0, 8),
            "業務用更新時間");
        exBizCalcbleEquals(kykSyouhnList.get(0).getGengakugoyenitijibrpstgk(), BizCurrency.valueOf(7000),
            "減額後円換算一時払保険料相当額");
        exDateEquals(kykSyouhnList.get(0).getYendthnkymd(), BizDate.valueOf("20170901"), "円建変更日");
        exBizCalcbleEquals(kykSyouhnList.get(0).getSetteibairitu(), BizNumber.valueOf(9), "設定倍率");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTmttknzoukaritujygn(), BizNumber.valueOf(8), "積立金増加率上限");
        exBizCalcbleEquals(kykSyouhnList.get(0).getTumitateriritu(), BizNumber.valueOf(7), "積立利率");
        exClassificationEquals(kykSyouhnList.get(0).getTmttknhaibunjyoutai(), C_TmttknhaibunjyoutaiKbn.BLNK,
            "積立金配分状態");
        exClassificationEquals(kykSyouhnList.get(0).getSisuukbn(), C_Sisuukbn.BLNK, "指数区分");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunrikzkakuninumu(), C_UmuKbn.NONE, "源泉分離課税確認有無");
        exClassificationEquals(kykSyouhnList.get(0).getGsbunritaisyou(), C_UmuKbn.ARI, "源泉分離課税対象");

        List<IT_SyouhnTokujou> syouhnTokujouList = resultKykKihon.getSyouhnTokujous();
        exStringEquals(syouhnTokujouList.get(0).getKbnkey(), "01", "区分キー");
        exStringEquals(syouhnTokujouList.get(0).getSyono(), "17806000116", "証券番号");
        exClassificationEquals(syouhnTokujouList.get(0).getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(syouhnTokujouList.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(syouhnTokujouList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouList.get(0).getKyksyouhnrenno(), 2, "契約商品連番");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyhyouten(), C_Tkjyhyouten.HYOUTEN100, "特条標点");
        exBizCalcbleEquals(syouhnTokujouList.get(0).getTkjyp(), BizCurrency.valueOf(400), "特条保険料");
        exClassificationEquals(syouhnTokujouList.get(0).getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "特条削減期間");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd1(), "11", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn1(), C_Htnpkkn.BLNK, "不担保期間１");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd2(), "21", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn2(), C_Htnpkkn.ONE, "不担保期間２");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd3(), "31", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn3(), C_Htnpkkn.TOW, "不担保期間３");
        exStringEquals(syouhnTokujouList.get(0).getHtnpbuicd4(), "41", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouList.get(0).getHtnpkkn4(), C_Htnpkkn.FOUR, "不担保期間４");
        exClassificationEquals(syouhnTokujouList.get(0).getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK,
            "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinKinou(), "EditKaiyakuTblUpdateTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(syouhnTokujouList.get(0).getGyoumuKousinTime().substring(0, 8),
            gyoumuKousinTime.substring(0, 8), "業務用更新時間");

        //        IT_KhHenreikin khHenreikin = resultKykKihon.getKhHenreikins().get(0);
        //        exStringEquals(khHenreikin.getKbnkey(), "01", "区分キー");
        //        exStringEquals(khHenreikin.getSyono(), "17806000116", "証券番号");
        //        exStringEquals(khHenreikin.getHenkousikibetukey(), "1001", "変更識別キー");
        //        exClassificationEquals(khHenreikin.getHrsyuruikbn(), C_HrsyuruiKbn.YENDTHNKHENREI, "返戻金種類区分");
        //        exDateEquals(khHenreikin.getShrymd(), BizDate.valueOf("20180101"), "支払日");
        //        exDateEquals(khHenreikin.getShrsyoriymd(), BizDate.valueOf("20180102"), "支払処理日");
        //        exDateEquals(khHenreikin.getHrhsisyoriymd(), BizDate.valueOf("20180103"), "返戻金発生処理日");
        //        exDateEquals(khHenreikin.getHrhsiymd(), BizDate.valueOf("20180104"), "返戻金発生日");
        //        exBizCalcbleEquals(khHenreikin.getHenreikingk(), BizCurrency.valueOf(2000), "返戻金額");
        //        exClassificationEquals(khHenreikin.getHrsiharaijyoutaikbn(), C_Siharaijyoutaikbn.MBR,
        //            "返戻金支払状態区分");
        //        exClassificationEquals(khHenreikin.getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        //        exClassificationEquals(khHenreikin.getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        //        exClassificationEquals(khHenreikin.getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = editKaiyakuTblUpdate.getKhGaikaFBSoukinData();
        exBooleanEquals(khGaikaFBSoukinData == null, true, "契約保全外貨ＦＢ送金データテーブルエンティティ");

        IT_KykKihon batchKykKihon = khozenCommonParam.getBatchKeiyakuKihon();
        exStringEquals(batchKykKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(batchKykKihon.getSyono(), "17806000116", "証券番号");

        IT_AnsyuKihon batchAnsyuKihon = khozenCommonParam.getBatchAnsyuKihon();
        exStringEquals(batchAnsyuKihon.getKbnkey(), "01", "区分キー");
        exStringEquals(batchAnsyuKihon.getSyono(), "17806000116", "証券番号");

        KhozenCommonParam khozenCommonParam1 = (KhozenCommonParam) MockObjectManager.getArgument(
            EditKykSyhnRirekiTblMockForHozen.class, "exec", 0);
        exStringEquals(khozenCommonParam1.getBatchKeiyakuKihon().getSyono(), "17806000116", "証券番号");
        MockObjectManager.assertArgumentPassed(EditKykSyhnRirekiTblMockForHozen.class, "exec", 1, "17806000116");

        CommonSiwakeInBean commonSiwakeInBeanParam = (CommonSiwakeInBean) MockObjectManager.getArgument(
            CommonSiwakeMockForHozen.class, "exec", 0);
        exStringEquals(commonSiwakeInBeanParam.getKinouId(), "EditKaiyakuTblUpdateTest_exec", "機能ID");
        exDateEquals(commonSiwakeInBeanParam.getDenYmd(), BizDate.valueOf("20180101"), "伝票日付");
        exClassificationEquals(commonSiwakeInBeanParam.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exDateEquals(commonSiwakeInBeanParam.getSyoriYmd(), BizDate.valueOf("20180129"), "処理年月日");
        exDateEquals(commonSiwakeInBeanParam.getKykYmd(), BizDate.valueOf("20180118"), "契約日");
        exStringEquals(commonSiwakeInBeanParam.getSyouhnCd(), "ﾕﾁ", "商品コード");
        exNumericEquals(commonSiwakeInBeanParam.getSyouhnsdNo(), 1, "商品世代番号");
        exClassificationEquals(commonSiwakeInBeanParam.getSyoriKbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(commonSiwakeInBeanParam.getShrhousiteiKbn(), C_ShrhousiteiKbn.FB_YOKUJITU,
            "支払方法指定区分");
        exClassificationEquals(commonSiwakeInBeanParam.getKyktuukaSyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTuukasyuKansanKawaserate(), BizNumber.valueOf(1),
            "契約通貨換算為替レート");
        exClassificationEquals(commonSiwakeInBeanParam.getAzukarikinUmuKbn(), C_UmuKbn.ARI, "預り金有無区分");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getTaisyouGk(),
        //            BizCurrency.valueOf(6000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(0).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(6000), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SHRTIENRSK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(1).getTaisyouGk(),
        //            BizCurrency.valueOf(2000), "対象金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.GENSENTYOUSYU, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getTaisyouGk(),
        //            BizCurrency.valueOf(70003), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(2).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(70003), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SHRGK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getTaisyouGk(),
        //            BizCurrency.valueOf(8000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(3).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(8000), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getTaisyouGk(),
        //            BizCurrency.valueOf(0), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(4).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_D, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getTaisyouGk(),
        //            BizCurrency.valueOf(27000), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(5).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getTaisyouGk(),
        //            BizCurrency.valueOf(150), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(6).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        //        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKhDengkSyuruiKbn(),
        //            C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP, "金額種類");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getTaisyouGk(),
        //            BizCurrency.valueOf(200), "対象金額");
        //        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(7).getKeiyakutuukaGk(),
        //            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        exClassificationEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKhDengkSyuruiKbn(),
            C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN, "金額種類");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getTaisyouGk(),
            BizCurrency.valueOf(5000), "対象金額");
        exBizCalcbleEquals(commonSiwakeInBeanParam.getTaisyouGkBeanLst().get(9).getKeiyakutuukaGk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.YEN), "契約通貨金額");
        C_Tuukasyu tuukasyu = (C_Tuukasyu) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = (List<BzSiwakeMeisaiBean>) MockObjectManager. getArgument(CommonSiwakeUtilMockForHozen.class, "execTaisyakuTyousei", 1);

        exClassificationEquals(tuukasyu, C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenyenkagk(), BizCurrency.valueOf(200, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDengaikagk(), BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenkarikanjyono(), "1234567", "（ＩＢ）伝票用仮勘定番号");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbDenyenkagk(), BizCurrency.valueOf(400, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKA_SEGMENT_SISYUTU_V, "（ＩＢ）勘定科目コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "（ＩＢ）為替適用区分");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(2).getIbKeiyakutuukagk(), BizCurrency.valueOf(300, BizCurrencyTypes.YEN), "（ＩＢ）契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg1cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbSeg2cd(), C_Segcd.AUDSISUURENDOUNENKINITIJIJYUNYUU, "（ＩＢ）セグメント２コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(2).getIbSuitoubumoncd(), "123", "（ＩＢ）出納部門コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(2).getIbTaisyakutyouseiflg(), true, " （ＩＢ）貸借調整フラグ");

        MockObjectManager.assertArgumentPassed(BzGetAdrDataMockForHozen.class, "execTodouhukenCdByPostalcd", 0, "1011001");

        //        KhozenCommonParam khozenCommonParam2 = (KhozenCommonParam) MockObjectManager.getArgument(
        //            EditDairitenTesuuryouTblMock.class, "exec", 0);
        //        exStringEquals(khozenCommonParam2.getBatchKeiyakuKihon().getSyono(), "17806000116", "証券番号");
        //        exStringEquals(khozenCommonParam2.getBatchAnsyuKihon().getSyono(), "17806000116", "証券番号");
        //        exStringEquals(khozenCommonParam2.getFunctionId(), "khsyoukenmeisailistsks", "機能ID");
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 1, "17806000116");
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 2, C_TsrysyoriKbn.SIKKOU);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 3, null);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 4, 10);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 5, 20);
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 6, BizCurrency.valueOf(9000));
        //        MockObjectManager.assertArgumentPassed(EditDairitenTesuuryouTblMock.class, "exec", 7, BizCurrency.valueOf(0));
        //                IT_BAK_KykKihon bAK_KykKihon = (IT_BAK_KykKihon) MockObjectManager.getArgument(
        //                    EditDairitenTesuuryouTblMock.class, "exec", 8);
        //                exStringEquals(bAK_KykKihon.getKbnkey(), "01", "区分キー");
        //                exStringEquals(bAK_KykKihon.getSyono(), "17806000116", "証券番号");
        //                exStringEquals(bAK_KykKihon.getTrkssikibetukey(), "1001", "取消識別キー");
        //                BizDate denYmd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 0);
        //                exDateEquals(denYmd, BizDate.valueOf("20180120"), "伝票日付");
        //                BizDate kykymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 1);
        //                exDateEquals(kykymd, BizDate.valueOf("20180118"), "契約日");
        //                BizCurrency jpyzennouseisankgk = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 2);
        //                exBizCalcbleEquals(jpyzennouseisankgk, BizCurrency.valueOf(3000), "前納精算金");
        //                BizDate ryosyuymd = (BizDate) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 3);
        //                exDateEquals(ryosyuymd, BizDate.valueOf("20181219"), "領収日");
        //                BizDateYM jkipjytym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 4);
        //                exDateYMEquals(jkipjytym, BizDateYM.valueOf("201812"), "次回Ｐ充当年月");
        //                BizCurrency jpymikeikap = (BizCurrency) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 5);
        //                exBizCalcbleEquals(jpymikeikap, BizCurrency.valueOf(9000), "未経過Ｐ");
        //                BizDateYM mikeikapjyutouym = (BizDateYM) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 6);
        //                exDateYMEquals(mikeikapjyutouym, BizDateYM.valueOf("201812"), "未経過Ｐ充当年月");
        //                MiKeikaPBean[] miKeikaPBeanTest = (MiKeikaPBean[]) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 7);
        //                exBizCalcbleEquals(miKeikaPBeanTest[0].getMiKeikaP(), BizCurrency.valueOf(120), "明細未経過Ｐ");
        //                exClassificationEquals(miKeikaPBeanTest[0].getMkeiPHrkKaisuu(), C_Hrkkaisuu.HALFY, "明細未経過Ｐ払込回数");
        //                exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuM(), 12, "明細未経過Ｐ充当回数（月）");
        //                exNumericEquals(miKeikaPBeanTest[0].getMkeiPJytKaisuuY(), 1, "明細未経過Ｐ充当回数（年）");
        //                exDateYMEquals(miKeikaPBeanTest[0].getMkeiPJytYm(), BizDateYM.valueOf("201812"), "明細未経過Ｐ充当年月");
        //                exDateEquals(miKeikaPBeanTest[0].getMkeiPNykDenYmd(), BizDate.valueOf("20181212"), "明細未経過Ｐ入金伝票日付");
        //                String functionId = (String) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 8);
        //                exStringEquals(functionId, "khsyoukenmeisailistsks", "機能ＩＤ");
        //                C_SyoriKbn syoriKbn = (C_SyoriKbn) MockObjectManager. getArgument(CommonSiwakeUtilMock.class, "execPKanjokamokuHantei", 9);
        //                exClassificationEquals(syoriKbn, C_SyoriKbn.BLNK, "処理区分");
        //                exBizCalcbleEquals(khShrRireki.getYenzennomikeikap(), BizCurrency.valueOf(3000), "円換算前納未経過保険料");
        //                exBizCalcbleEquals(khShrRireki.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(5000), "税適預り金額（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getZitkazukarikingkyen(), BizCurrency.valueOf(2000), "税適預り金額（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getYensonotahaitoukin(), BizCurrency.valueOf(12000), "円換算その他配当金");
        //                exBizCalcbleEquals(khShrRireki.getYenkrkgk(), BizCurrency.valueOf(6000), "円換算仮受金額");
        //                exDateEquals(khShrRireki.getGaikashrkwsratekjnymd(), BizDate.valueOf("20181212"), "外貨支払時為替レート基準日");
        //                exBizCalcbleEquals(khShrRireki.getGaikashrkwsrate(), BizNumber.valueOf(123.123), "外貨支払時為替レート");
        //                exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizCurrency.valueOf(6000), "解約返戻金額合計（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getShrtuukakaiyakuhrkngkkei(), BizCurrency.valueOf(5500), "支払通貨解約返戻金額合計");
        //                exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeiyen(), BizCurrency.valueOf(5500), "解約返戻金額合計（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getSonotashrkngksiteituuka(), BizCurrency.valueOf(97001), "その他支払金額（指定通貨）");
        //                exBizCalcbleEquals(khShrRireki.getShrtuukasonotashrkngk(), BizCurrency.valueOf(97001), "支払通貨その他支払金額");
        //                exBizCalcbleEquals(khShrRireki.getSonotashrkngkyen(), BizCurrency.valueOf(97001), "その他支払金額（円貨）");
        //                exBizCalcbleEquals(khShrRireki.getYensynykngk(), BizCurrency.valueOf(5600), "円換算収入金額");
        //        List<IT_Azukarikin> azukarikinList = editKaiyakuTblUpdate.getKykKihon().getAzukarikins();
        //        exDateEquals(azukarikinList.get(0).getShrymd(), BizDate.valueOf("20180118"), "支払日");
        //        exDateEquals(azukarikinList.get(0).getShrsyoriymd(), BizDate.valueOf("20180129"), "支払処理日");
        //        exStringEquals(azukarikinList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(azukarikinList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_Kariukekin> kariukekinList = editKaiyakuTblUpdate.getKykKihon().getKariukekins();
        //        exClassificationEquals(kariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.SUMI, "仮受精算済フラグ");
        //        exStringEquals(kariukekinList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(kariukekinList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        IT_AnsyuKihon ansyuKihon1 = editKaiyakuTblUpdate.getAnsyuKihon();
        //        exStringEquals(ansyuKihon1.getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(ansyuKihon1.getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_Zennou> zennouLst = ansyuKihon1.getZennous();
        //        exClassificationEquals(zennouLst.get(0).getZennouseisankbn(), C_ZennouSeisanKbn.SEISANZUMI, "前納精算区分");
        //        exDateEquals(zennouLst.get(0).getZennouseisansyoriymd(), BizDate.valueOf("20180129"), "前納精算処理日");
        //        exBizCalcbleEquals(zennouLst.get(0).getZennouseisankgk(), BizCurrency.valueOf(3000), "前納精算金額");
        //        exDateEquals(zennouLst.get(0).getZennouseisankijyunymd(), BizDate.valueOf("20180116"), "前納精算基準日");
        //        exDateEquals(zennouLst.get(0).getZennouseisandenymd(), BizDate.valueOf("20180118"), "前納精算伝票日付");
        //        exStringEquals(zennouLst.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(zennouLst.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiList = resultKykKihon.getKihrkmpSeisanRirekis();
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getRenno(), 1, "連番");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getHenkousikibetukey(), "1001", "変更識別キー");
        //        exDateEquals(kihrkmpSeisanRirekiList.get(0).getKouryokuhasseiymd(), BizDate.valueOf("20180116"), "効力発生日");
        //        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getKihrkpssnaiyoukbn(), C_KiharaiPseisanNaiyouKbn.SEISANP, "既払込Ｐ精算内容区分");
        //        exDateYMEquals(kihrkmpSeisanRirekiList.get(0).getJyuutouym(), BizDateYM.valueOf("201812"), "充当年月");
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuum(), 20, "精算充当回数（月）");
        //        exNumericEquals(kihrkmpSeisanRirekiList.get(0).getSeijyutoukaisuuy(), 10, "精算充当回数（年）");
        //        exClassificationEquals(kihrkmpSeisanRirekiList.get(0).getMisyuumikeikakbn(), C_MisyuumikeikaKbn.MIKEIKAP, "未収未経過区分");
        //        exDateEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsratekjnymd(), BizDate.valueOf("20180117"), "税務用為替レート基準日");
        //        exBizCalcbleEquals(kihrkmpSeisanRirekiList.get(0).getZeimukwsrate(), BizNumber.valueOf(1), "税務用為替レート");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinKinou(), "khsyoukenmeisailistsks", "業務用更新機能ＩＤ");
        //        exStringEquals(kihrkmpSeisanRirekiList.get(0).getGyoumuKousinsyaId(), "wmh", "業務用更新者ＩＤ");
        //        ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = (ZennouKoujyogakuKeisanParam) MockObjectManager.getArgument(
        //            EditKoujyonaiyouTblMock.class, "setZennouKoujyogakuKeisanParam", 0);
        //        exDateEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(), BizDate.valueOf("20181224"), "控除証明用前納開始年月日");
        //        exStringEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(), "30", "控除証明用前納期間（月）");
        //        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(), BizCurrency.valueOf(123456789), "控除証明用前納入金額");
        //        exBizCalcbleEquals(zennouKoujyogakuKeisanParam.getHrkp(), BizCurrency.valueOf(122345789), "払込保険料");
        //        exClassificationEquals(zennouKoujyogakuKeisanParam.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        //        exDateEquals(zennouKoujyogakuKeisanParam.getZennoukaisiymd(), BizDate.valueOf("20181212"), "前納開始年月日");
        //        exNumericEquals(zennouKoujyogakuKeisanParam.getZennourenno(), 2, "前納連番");
        //        BizDate calcKjnYmd = (BizDate) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setCalcKjnYmd", 0);
        //        exDateEquals(calcKjnYmd, BizDate.valueOf("20180116"), "計算基準日");
        //        BizDateYM henmaeJkipJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setHenmaeJkipJytYm", 0);
        //        exDateYMEquals(henmaeJkipJytYm, BizDateYM.valueOf("201812"), "変更前次回P充当年月");
        //        String henmaeHenkousikibetukey = (String) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setHenmaeHenkousikibetukey", 0);
        //        exStringEquals(henmaeHenkousikibetukey, "1001", "変更前変更識別キー");
        //        int kihrkpSeisanRenno = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanRenno", 0);
        //        exNumericEquals(kihrkpSeisanRenno, 1, "既払込Ｐ精算連番");
        //        BizDateYM kihrkpSeisanJytYm = (BizDateYM) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytYm", 0);
        //        exDateYMEquals(kihrkpSeisanJytYm, BizDateYM.valueOf("201812"), "既払込Ｐ精算充当年月");
        //        int kihrkpSeisanJytKaisuuY = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytKaisuuY", 0);
        //        exNumericEquals(kihrkpSeisanJytKaisuuY, 10, "既払込Ｐ精算充当回数（年）");
        //        int kihrkpSeisanJytKaisuuM = (int) MockObjectManager.getArgument(EditKoujyonaiyouTblMock.class, "setKihrkpSeisanJytKaisuuM", 0);
        //        exNumericEquals(kihrkpSeisanJytKaisuuM, 20, "既払込Ｐ精算充当回数（月）");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN4;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000127");

        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000127");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6001));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5501));
        editKaiyakuTblUpdateBean.setKaiyakuhrgoukeiyen(BizCurrency.valueOf(6002));
        editKaiyakuTblUpdateBean.setJpysonotashrgk(BizCurrency.valueOf(6003));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20001));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(501));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(80000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.4));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2001));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(16);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1801));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(26);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(80002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(80003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(80004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(80005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(80006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.optional());
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(80008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(3));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180122"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5601));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3001));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(3);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2501));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.USD);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5006");
        editKaiyakuTblUpdateBean.setSitencd("506");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.HUTUU);
        editKaiyakuTblUpdateBean.setKouzano("M4726");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.SITEI);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名２");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001002");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３２");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名２");
        editKaiyakuTblUpdateBean.setSaikennyno("2002003");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１２");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３２");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("708");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("809");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.NNKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000127");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000127", "1005");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(-1000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(9000));

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SYOUKENMEISAILISTSKS);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "02", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000127", "証券番号");

        exClassificationEquals(khShrRireki.getShrtysykurikosiyouhi(), C_YouhiKbn.YOU, "支払調書繰越要否");

        exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeisiteituuka(), BizCurrency.valueOf(6002), "解約返戻金額合計（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getShrtuukakaiyakuhrkngkkei(), BizCurrency.valueOf(6002), "支払通貨解約返戻金額合計");
        exBizCalcbleEquals(khShrRireki.getKaiyakuhrkngkkeiyen(), BizCurrency.valueOf(6002), "解約返戻金額合計（円貨）");
        exBizCalcbleEquals(khShrRireki.getSonotashrkngksiteituuka(), BizCurrency.valueOf(6003), "その他支払金額（指定通貨）");
        exBizCalcbleEquals(khShrRireki.getShrtuukasonotashrkngk(), BizCurrency.valueOf(6003), "支払通貨その他支払金額");
        exBizCalcbleEquals(khShrRireki.getSonotashrkngkyen(), BizCurrency.valueOf(6003), "その他支払金額（円貨）");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN4;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000138");

        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000138");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6001));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5501));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20001));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(501));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(80000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.4));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2001));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(16);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1801));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(26);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(80002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(80003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(80004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(80005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(80006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.optional());
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(80008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(3));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180122"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5601));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3001));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(3);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2501));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.USD);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5006");
        editKaiyakuTblUpdateBean.setSitencd("506");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.HUTUU);
        editKaiyakuTblUpdateBean.setKouzano("M4726");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.SITEI);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名２");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001002");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３２");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名２");
        editKaiyakuTblUpdateBean.setSaikennyno("2002003");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１２");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３２");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("708");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("809");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.BLNK);
        editKaiyakuTblUpdateBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000138");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000138", "1005");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(-1000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(9000));

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SYOUKENMEISAILISTSKS);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "03", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000138", "証券番号");

        exClassificationEquals(khShrRireki.getShrtysykurikosiyouhi(), C_YouhiKbn.HUYOU, "要否区分");

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN4;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");

        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000149");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6001));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5501));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20001));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(501));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(80000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.4));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2001));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(16);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1801));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(26);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(80002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(80003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(80004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(80005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(80006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.optional());
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(80008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(3));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180122"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5601));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3001));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(3);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2501));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.USD);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5006");
        editKaiyakuTblUpdateBean.setSitencd("506");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.HUTUU);
        editKaiyakuTblUpdateBean.setKouzano("M4726");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.SITEI);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名２");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001002");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３２");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名２");
        editKaiyakuTblUpdateBean.setSaikennyno("2002003");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１２");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３２");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("708");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("809");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.BLNK);
        editKaiyakuTblUpdateBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000149");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000149", "1005");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(-1000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(9000));

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SYOUKENMEISAILISTSKS);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "04", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000149", "証券番号");

        exClassificationEquals(khShrRireki.getShrtysykurikosiyouhi(), C_YouhiKbn.HUYOU, "要否区分");

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        MockObjectManager.initialize();
        EditKykSyhnRirekiTblMockForHozen.SYORIPTN = EditKykSyhnRirekiTblMockForHozen.TESTPATTERN1;
        CommonSiwakeMockForHozen.SYORIPTN = CommonSiwakeMockForHozen.TESTPATTERN4;
        EditDairitenTesuuryouTblMockForHozen.SYORIPTN = EditDairitenTesuuryouTblMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");

        BizDate syoriYmd = BizDate.valueOf("20180130");

        EditKaiyakuTblUpdateBean editKaiyakuTblUpdateBean = SWAKInjector.getInstance(EditKaiyakuTblUpdateBean.class);
        editKaiyakuTblUpdateBean.setSyono("17806000150");
        editKaiyakuTblUpdateBean.setSyoruiukeymd(BizDate.valueOf("20180116"));
        editKaiyakuTblUpdateBean.setKaiykymd(BizDate.valueOf("20180117"));
        editKaiyakuTblUpdateBean.setYenshrtkumu(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        editKaiyakuTblUpdateBean.setKaiyakujiyuu(C_Kaiyakujiyuu.SKS);
        editKaiyakuTblUpdateBean.setKaiyakuhr(BizCurrency.valueOf(6001));
        editKaiyakuTblUpdateBean.setKaiyakuhryen(BizCurrency.valueOf(5501));
        editKaiyakuTblUpdateBean.setYenshrrate(BizNumber.valueOf(2));
        editKaiyakuTblUpdateBean.setYenshrratetekiymd(BizDate.valueOf("20180118"));
        editKaiyakuTblUpdateBean.setKiykhrsyousaiptumitatekin(BizCurrency.valueOf(20001));
        editKaiyakuTblUpdateBean.setKiykhrsyousaisjkkktyouseigk(BizCurrency.valueOf(501));
        editKaiyakuTblUpdateBean.setKaiyakukjgk(BizCurrency.valueOf(80000));
        editKaiyakuTblUpdateBean.setSjkkktyouseiritu(BizNumber.valueOf(0.2));
        editKaiyakuTblUpdateBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.3));
        editKaiyakuTblUpdateBean.setKaiyakukoujyoritu(BizNumber.valueOf(0.4));
        editKaiyakuTblUpdateBean.setShrtienrsk(BizCurrency.valueOf(2001));
        editKaiyakuTblUpdateBean.setShrtienrskkisanymd(BizDate.valueOf("20180119"));
        editKaiyakuTblUpdateBean.setTienrsknissuu(16);
        editKaiyakuTblUpdateBean.setJpyshrtienrsk(BizCurrency.valueOf(1801));
        editKaiyakuTblUpdateBean.setJpytienrisokukisanymd(BizDate.valueOf("20180120"));
        editKaiyakuTblUpdateBean.setJpytienrsknissuu(26);
        editKaiyakuTblUpdateBean.setYendthnkhr(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setGstszeigk(BizCurrency.valueOf(80002));
        editKaiyakuTblUpdateBean.setJpygstszeigk(BizCurrency.valueOf(80003));
        editKaiyakuTblUpdateBean.setYengstszeigknationaltax(BizCurrency.valueOf(80004));
        editKaiyakuTblUpdateBean.setYengstszeigklocaltax(BizCurrency.valueOf(80005));
        editKaiyakuTblUpdateBean.setGsbunritaisyouflg(C_UmuKbn.NONE);
        editKaiyakuTblUpdateBean.setYengststaisyousaeki(BizCurrency.valueOf(80006));
        editKaiyakuTblUpdateBean.setTeiritutmttkngk(BizCurrency.optional());
        editKaiyakuTblUpdateBean.setSisuurendoutmttkngk(BizCurrency.valueOf(80008));
        editKaiyakuTblUpdateBean.setShrgkkei(BizCurrency.valueOf(8001));
        editKaiyakuTblUpdateBean.setJpyshrgkgoukei(BizCurrency.valueOf(7301));
        editKaiyakuTblUpdateBean.setZeimukwsrate(BizNumber.valueOf(3));
        editKaiyakuTblUpdateBean.setZeimukwsratekjnymd(BizDate.valueOf("20180122"));
        editKaiyakuTblUpdateBean.setSynykngk(BizCurrency.valueOf(5601));
        editKaiyakuTblUpdateBean.setHtykeihi(BizCurrency.valueOf(3001));
        editKaiyakuTblUpdateBean.setKykhnkkaisuu(3);
        editKaiyakuTblUpdateBean.setYenshrkykhtykeihi(BizCurrency.valueOf(2501));
        editKaiyakuTblUpdateBean.setShrymd(BizDate.valueOf("20180121"));
        editKaiyakuTblUpdateBean.setShrtuukasyu(C_Tuukasyu.USD);
        editKaiyakuTblUpdateBean.setShrhousiteikbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        editKaiyakuTblUpdateBean.setBankcd("5006");
        editKaiyakuTblUpdateBean.setSitencd("506");
        editKaiyakuTblUpdateBean.setYokinkbn(C_YokinKbn.HUTUU);
        editKaiyakuTblUpdateBean.setKouzano("M4726");
        editKaiyakuTblUpdateBean.setKzmeiginmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKzsyuruikbn(C_KouzasyuruiKbn.GAIKAKOUZA);
        editKaiyakuTblUpdateBean.setKzdoukbn(C_Kzdou.SITEI);
        editKaiyakuTblUpdateBean.setKyksyaszknmkn("カナカナ");
        editKaiyakuTblUpdateBean.setKyksyaszknmkj("契約者相続人氏名２");
        editKaiyakuTblUpdateBean.setKyksyaszkyno("1001002");
        editKaiyakuTblUpdateBean.setKyksyaszkadr1kj("契約者相続人住所１２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr2kj("契約者相続人住所２２");
        editKaiyakuTblUpdateBean.setKyksyaszkadr3kj("契約者相続人住所３２");
        editKaiyakuTblUpdateBean.setSaikennmkj("債権者氏名２");
        editKaiyakuTblUpdateBean.setSaikennyno("2002003");
        editKaiyakuTblUpdateBean.setSaikenadr1kj("債権者住所１２");
        editKaiyakuTblUpdateBean.setSaikenadr2kj("債権者住所２２");
        editKaiyakuTblUpdateBean.setSaikenadr3kj("債権者住所３２");
        editKaiyakuTblUpdateBean.setKykmnmeigibangou("708");
        editKaiyakuTblUpdateBean.setUktmnmeigibangou("809");
        editKaiyakuTblUpdateBean.setShrtysysyuruikbn(C_HtsiryosyuKbn.ITJKNSHRTYOUSYO);
        editKaiyakuTblUpdateBean.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.BLNK);
        editKaiyakuTblUpdateBean.setSeg1cd(C_Segcd.JPYSYUUSIN);
        editKaiyakuTblUpdateBean.setSeg2cd(C_Segcd.BLNK);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000150");
        editKaiyakuTblUpdateBean.setAnsyuKihon(ansyuKihon);

        IT_BAK_KykKihon bakKykKihon = hozenDomManager.getBAKKykKihon("17806000150", "1005");

        kinou.setKinouKbn(C_KinouKbn.BATCH);
        editKaiyakuTblUpdateBean.setJpyzennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkkaiyakuhr(BizCurrency.valueOf(-1000));
        editKaiyakuTblUpdateBean.setAzukarikinkykhnkmikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpykariukekin(BizCurrency.valueOf(6000));
        editKaiyakuTblUpdateBean.setJpymikeikap(BizCurrency.valueOf(0));
        editKaiyakuTblUpdateBean.setJpytkbthaitoukin(BizCurrency.valueOf(12000));
        editKaiyakuTblUpdateBean.setJpyhaitoukin(BizCurrency.valueOf(15000));
        editKaiyakuTblUpdateBean.setZennouseisankgk(BizCurrency.valueOf(-3000));
        editKaiyakuTblUpdateBean.setMikeikap(BizCurrency.valueOf(9000));

        khozenCommonParam.setFunctionId(IKhozenCommonConstants.KINOUID_SYOUKENMEISAILISTSKS);

        EditKaiyakuTblUpdate editKaiyakuTblUpdate = SWAKInjector.getInstance(EditKaiyakuTblUpdate.class);
        C_ErrorKbn result = editKaiyakuTblUpdate.exec(khozenCommonParam, kykKihon, syoriYmd, editKaiyakuTblUpdateBean,
            bakKykKihon);

        exClassificationEquals(result, C_ErrorKbn.OK, "結果区分");
        IT_KykKihon resultKykKihon = editKaiyakuTblUpdate.getKykKihon();

        IT_KhTtdkRireki khTtdkRireki = resultKykKihon.getKhTtdkRirekis().get(0);

        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
        exStringEquals(khShrRireki.getKbnkey(), "05", "区分キー");
        exStringEquals(khShrRireki.getSyono(), "17806000150", "証券番号");

        exClassificationEquals(khShrRireki.getShrtysykurikosiyouhi(), C_YouhiKbn.HUYOU, "要否区分");

    }
}
