package yuyu.common.siharai.siedittyouhyou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.bean.report.SiSeisansksBean;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 精算金振込依頼書編集のメソッド{@link EditSeisankinhurikomiiraisyo#exec(EditSeisankinhurikomiiraisyoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeisankinhurikomiiraisyoTest_exec {
    @Inject
    private EditSeisankinhurikomiiraisyo editSeisankinhurikomiiraisyo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_精算金振込依頼書編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSeisankinhurikomiiraisyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS));
        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.HK_SOUHU));
        baseDomManager.delete(baseDomManager.getSyoruiZokusei(C_SyoruiCdKbn.HK_STI_KAS));

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk015", "SOUHU_ANNAI"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk015", "ANNAI_NAIYOU"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk015", "ANNAI_NAIYOU_BIKOUNASI"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk015", "SOUHU_ANNAI_KYUHUKIN"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk015", "ANNAI_NAIYOU_KYUHUKIN"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk015", "ANNAI_NAIYOU_KYUHUKIN_BIKOUNASI"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk090", "SOUHU_ANNAI"));
        siharaiDomManager.delete(siharaiDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2("hk090", "ANNAI_NAIYOU"));

        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(null);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoriYmd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(null);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);
        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151212));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='syoruiCd'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_B1() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20151214));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20151214));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.JPY);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕA");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151214), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０１５年１２月１４日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), "　このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), "　今般死亡保険金ご請求のお申し出をいただきましたが、当社保険約款上の免責事由（死亡保険", "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), "金をお支払いできない事由）に該当するため、死亡保険金をお支払いすることができません。", "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), "　何とぞご了承賜りますようよろしくお願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０１５年１２月１４日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０１５年１２月１４日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), "　当社の保険約款上、被保険者さまが上記契約の責任開始の日（復活の場合は復活日）から", "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), "起算して一定期間以内に自殺によりお亡くなりになられた場合は、死亡保険金をお支払いで", "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), "きない旨を定めています。（お支払いできない理由の詳細は、ご契約のしおり・約款の該当", "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), "箇所をご確認ください。）", "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), "　上記約款規定に該当し、死亡保険金をお支払いできない場合には、保険料積立金（責任準", "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), "備金）を契約者さま（お亡くなりの場合にはそのご相続人さま）にお支払いいたします。", "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), "　別添の「精算金振込み手続きのご案内」に沿ってお手続きくださいますようお願い申し上", "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), "げます。", "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), "", "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), "", "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), "＊被保険者さまが心神喪失またはこれと同程度の著しい精神障がいなどにより、自らの死亡", "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), "　の結果を認識するに足りる正常な判断能力を有していなかった場合には、死亡保険金をお", "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), "　受け取りいただける場合があります。このような可能性があるときは、お手数ですが下記", "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), "　下記担当までご連絡くださいますようお願いいたします。", "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");

        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2015年12月14日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（円建）表示有無");
    }
    @Test
    @TestOrder(50)
    public void testExec_B2() {

        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_STI_KAS);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20151214));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20151214));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.JPY);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SAIGAIHOKENKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕA");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_STI_KAS.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151214), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０１５年１２月１４日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), null,"（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), null, "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), null, "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), null, "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０１５年１２月１４日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０１５年１２月１４日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), null, "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), null, "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), null, "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), null, "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), null, "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), null, "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), null, "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), null, "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), null, "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), null, "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), null, "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), null, "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), null, "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), null, "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");

        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2015年12月14日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（円建）表示有無");

    }
    @Test
    @TestOrder(60)
    public void testExec_B3() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SOUHU);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20151214));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20151214));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.USD);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBKYUUHUKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕﾁ");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SOUHU.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151214), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０１５年１２月１４日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), "メッセージ１", "（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), "メッセージ２", "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), "メッセージ３", "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), "メッセージ４", "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), "メッセージ５", "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０１５年１２月１４日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０１５年１２月１４日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), "メッセージ６", "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), "メッセージ７", "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), "メッセージ８", "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), "メッセージ９", "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), "メッセージ１０", "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), "メッセージ１１", "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), "メッセージ１２", "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), "メッセージ１３", "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), "メッセージ１４", "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), "メッセージ１５", "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), "メッセージ１６", "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), "メッセージ１７", "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), "メッセージ１８", "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), "メッセージ１９", "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), "メッセージ２０", "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), "メッセージ２１", "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), "メッセージ２２", "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2015年12月14日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（円建）表示有無");

    }

    @Test
    @TestOrder(70)
    public void testExec_C1() {

        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(null);

        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        try {
            editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='seikyuusyaInfoBean'", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_C2() {

        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20151215));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20151216));
        editSeisankinhurikomiiraisyoBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.KYKSBARI);

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);

        exClassificationEquals(siSeisansksBean.getIrShsrtdkdadrhyjumu(), C_UmuKbn.NONE, "（ＩＲ）送付先欄（届出住所）表示有無");
        exClassificationEquals(siSeisansksBean.getIrShsrkinyuuhyjumu(), C_UmuKbn.ARI, "（ＩＲ）送付先欄（記入用）表示有無");

    }

    @Test
    @TestOrder(90)
    public void testExec_C3() {

        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20151214));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20151215));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20151216));
        editSeisankinhurikomiiraisyoBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.BLNK);

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);

        exClassificationEquals(siSeisansksBean.getIrShsrtdkdadrhyjumu(), C_UmuKbn.ARI, "（ＩＲ）送付先欄（届出住所）表示有無");
        exClassificationEquals(siSeisansksBean.getIrShsrkinyuuhyjumu(), C_UmuKbn.NONE, "（ＩＲ）送付先欄（記入用）表示有無");

    }

    @Test
    @TestOrder(100)
    public void testExec_D1() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20201127));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.JPY);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕF");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20201127), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０２０年１１月２７日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), "　このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), "　今般死亡保険金ご請求のお申し出をいただきましたが、当社保険約款上の免責事由（死亡保険", "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), "金をお支払いできない事由）に該当するため、死亡保険金をお支払いすることができません。", "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), "　何とぞご了承賜りますようよろしくお願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０２０年１１月２７日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０２０年１１月２７日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), "　当社の保険約款上、被保険者さまが上記契約の責任開始の日（復活の場合は復活日）から", "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), "起算して一定期間以内に自殺によりお亡くなりになられた場合は、死亡保険金をお支払いで", "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), "きない旨を定めています。（お支払いできない理由の詳細は、ご契約のしおり・約款の該当", "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), "箇所をご確認ください。）", "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), "　上記約款規定に該当し、死亡保険金をお支払いできない場合には、保険料積立金（責任準", "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), "備金）を契約者さま（お亡くなりの場合にはそのご相続人さま）にお支払いいたします。", "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), "　別添の「精算金振込み手続きのご案内」に沿ってお手続きくださいますようお願い申し上", "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), "げます。", "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), "", "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), "", "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), "", "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), "", "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), "", "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), "", "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");

        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2020年11月27日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（円建）表示有無");
    }

    @Test
    @TestOrder(110)
    public void testExec_D2() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20201127));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.USD);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕﾉ");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20201127), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０２０年１１月２７日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), "　このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), "　今般死亡保険金ご請求のお申し出をいただきましたが、当社保険約款上の免責事由（死亡保険", "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), "金をお支払いできない事由）に該当するため、死亡保険金をお支払いすることができません。", "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), "　何とぞご了承賜りますようよろしくお願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０２０年１１月２７日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０２０年１１月２７日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), "　当社の保険約款上、被保険者さまが上記契約の責任開始の日（復活の場合は復活日）から", "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), "起算して一定期間以内に自殺によりお亡くなりになられた場合は、死亡保険金をお支払いで", "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), "きない旨を定めています。（お支払いできない理由の詳細は、ご契約のしおり・約款の該当", "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), "箇所をご確認ください。）", "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), "　上記約款規定に該当し、死亡保険金をお支払いできない場合には、保険料積立金（責任準", "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), "備金）を契約者さま（お亡くなりの場合にはそのご相続人さま）にお支払いいたします。", "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), "　別添の「精算金振込み手続きのご案内」に沿ってお手続きくださいますようお願い申し上", "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), "げます。", "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), "", "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), "", "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), "＊被保険者さまが心神喪失またはこれと同程度の著しい精神障がいなどにより、自らの死亡", "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), "　の結果を認識するに足りる正常な判断能力を有していなかった場合には、死亡保険金をお", "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), "　受け取りいただける場合があります。このような可能性があるときは、お手数ですが下記", "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), "　下記担当までご連絡くださいますようお願いいたします。", "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");

        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2020年11月27日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（円建）表示有無");
    }

    @Test
    @TestOrder(120)
    public void testExec_D3() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20201127));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.JPY);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕA");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20201127), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０２０年１１月２７日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), "　このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), "　今般死亡保険金ご請求のお申し出をいただきましたが、当社保険約款上の免責事由（死亡保険", "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), "金をお支払いできない事由）に該当するため、死亡保険金をお支払いすることができません。", "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), "　何とぞご了承賜りますようよろしくお願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０２０年１１月２７日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０２０年１１月２７日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), "　当社の保険約款上、被保険者さまが上記契約の責任開始の日（復活の場合は復活日）から", "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), "起算して一定期間以内に自殺によりお亡くなりになられた場合は、死亡保険金をお支払いで", "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), "きない旨を定めています。（お支払いできない理由の詳細は、ご契約のしおり・約款の該当", "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), "箇所をご確認ください。）", "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), "　上記約款規定に該当し、死亡保険金をお支払いできない場合には、保険料積立金（責任準", "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), "備金）を契約者さま（お亡くなりの場合にはそのご相続人さま）にお支払いいたします。", "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), "　別添の「精算金振込み手続きのご案内」に沿ってお手続きくださいますようお願い申し上", "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), "げます。", "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), "", "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), "", "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), "＊被保険者さまが心神喪失またはこれと同程度の著しい精神障がいなどにより、自らの死亡", "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), "　の結果を認識するに足りる正常な判断能力を有していなかった場合には、死亡保険金をお", "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), "　受け取りいただける場合があります。このような可能性があるときは、お手数ですが下記", "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), "　下記担当までご連絡くださいますようお願いいたします。", "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");

        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2020年11月27日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（円建）表示有無");
    }

    @Test
    @TestOrder(130)
    public void testExec_D4() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20201127));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.USD);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBKYUUHUKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕﾁ");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20201127), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０２０年１１月２７日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), "　このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), "　今般死亡給付金ご請求のお申し出をいただきましたが、当社保険約款上の免責事由（死亡給付", "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), "金をお支払いできない事由）に該当するため、死亡給付金をお支払いすることができません。", "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), "　何とぞご了承賜りますようよろしくお願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０２０年１１月２７日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０２０年１１月２７日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), "　当社の保険約款上、被保険者さまが上記契約の責任開始の日（復活の場合は復活日）から", "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), "起算して一定期間以内に自殺によりお亡くなりになられた場合は、死亡給付金をお支払いで", "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), "きない旨を定めています。（お支払いできない理由の詳細は、ご契約のしおり・約款の該当", "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), "箇所をご確認ください。）", "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), "　上記約款規定に該当し、死亡給付金をお支払いできない場合には、保険料積立金（責任準", "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), "備金）を契約者さま（お亡くなりの場合にはそのご相続人さま）にお支払いいたします。", "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), "　別添の「精算金振込み手続きのご案内」に沿ってお手続きくださいますようお願い申し上", "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), "げます。", "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), "", "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), "", "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), "＊被保険者さまが心神喪失またはこれと同程度の著しい精神障がいなどにより、自らの死亡", "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), "　の結果を認識するに足りる正常な判断能力を有していなかった場合には、死亡給付金をお", "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), "　受け取りいただける場合があります。このような可能性があるときは、お手数ですが下記", "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), "　下記担当までご連絡くださいますようお願いいたします。", "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");

        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2020年11月27日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（円建）表示有無");
    }

    @Test
    @TestOrder(140)
    public void testExec_D5() {
        EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean =
            SWAKInjector.getInstance(EditSeisankinhurikomiiraisyoBean.class);
        SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
            .getInstance(SiTyouhyouHensyuuCommonBean.class);

        SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
        seikyuusyaInfoBean.setSeikyuusyanmKj("請求者");
        seikyuusyaInfoBean.setTsinyno("1231042");
        seikyuusyaInfoBean.setTsinadr1kj(
            "一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四");
        seikyuusyaInfoBean.setTsinadr2kj("");
        seikyuusyaInfoBean.setTsinadr3kj("通信先住所３");
        seikyuusyaInfoBean.setTsintelno("03-1234-5678");
        editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);

        siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.valueOf(20201127));
        siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
        editSeisankinhurikomiiraisyoBean.setUktnmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setSyono("17806000079");
        editSeisankinhurikomiiraisyoBean.setHhknNmkj("加藤");
        editSeisankinhurikomiiraisyoBean.setKykYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(BizDate.valueOf(20201127));
        editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd("AKB00000001");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei("小野　緑");
        editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei("組織名");
        editSeisankinhurikomiiraisyoBean.setKyktuukasyu(C_Tuukasyu.JPY);
        editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBKYUUHUKIN);
        editSeisankinhurikomiiraisyoBean.setSyouhncd("ﾕF");

        ReportServicesBean reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);
        SiSeisansksBean siSeisansksBean = (SiSeisansksBean) (reportServicesBean.getParamObjectsData().get(
            C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue())[0]);
        exStringEquals(reportServicesBean.getKensakuKeys()[0], "17806000079", "検索キー[0]");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20201127), "処理日付");
        exStringEquals(siSeisansksBean.getIrSyoriYmdzenkaku(), "２０２０年１１月２７日", "（ＩＲ）処理年月日（全角）");
        exStringEquals(siSeisansksBean.getIrUktnmkj(), "加藤", "（ＩＲ）受取人名（漢字）");
        exStringEquals(siSeisansksBean.getIrMsg1(), "　このたびは、被保険者さまのご訃報に接し、謹んでお悔やみ申し上げます。", "（ＩＲ）メッセージ１");
        exStringEquals(siSeisansksBean.getIrMsg2(), "　今般死亡給付金ご請求のお申し出をいただきましたが、当社保険約款上の免責事由（死亡給付", "（ＩＲ）メッセージ２");
        exStringEquals(siSeisansksBean.getIrMsg3(), "金をお支払いできない事由）に該当するため、死亡給付金をお支払いすることができません。", "（ＩＲ）メッセージ３");
        exStringEquals(siSeisansksBean.getIrMsg4(), "　何とぞご了承賜りますようよろしくお願い申し上げます。", "（ＩＲ）メッセージ４");
        exStringEquals(siSeisansksBean.getIrMsg5(), null, "（ＩＲ）メッセージ５");
        exStringEquals(siSeisansksBean.getIrSyono(), "17806000079", "（ＩＲ）証券番号");
        exStringEquals(siSeisansksBean.getIrHhknnmkj(), "加藤", "（ＩＲ）被保険者名（漢字）");
        exStringEquals(siSeisansksBean.getIrKykymd(), "２０２０年１１月２７日", "（ＩＲ）契約日");
        exStringEquals(siSeisansksBean.getIrSknnkaisiymd(), "２０２０年１１月２７日", "（ＩＲ）責任開始日");
        exStringEquals(siSeisansksBean.getIrMsg6(), "　当社の保険約款上、被保険者さまが上記契約の責任開始の日（復活の場合は復活日）から", "（ＩＲ）メッセージ６");
        exStringEquals(siSeisansksBean.getIrMsg7(), "起算して一定期間以内に自殺によりお亡くなりになられた場合は、死亡給付金をお支払いで", "（ＩＲ）メッセージ７");
        exStringEquals(siSeisansksBean.getIrMsg8(), "きない旨を定めています。（お支払いできない理由の詳細は、ご契約のしおり・約款の該当", "（ＩＲ）メッセージ８");
        exStringEquals(siSeisansksBean.getIrMsg9(), "箇所をご確認ください。）", "（ＩＲ）メッセージ９");
        exStringEquals(siSeisansksBean.getIrMsg10(), "　上記約款規定に該当し、死亡給付金をお支払いできない場合には、保険料積立金（責任準", "（ＩＲ）メッセージ１０");
        exStringEquals(siSeisansksBean.getIrMsg11(), "備金）を契約者さま（お亡くなりの場合にはそのご相続人さま）にお支払いいたします。", "（ＩＲ）メッセージ１１");
        exStringEquals(siSeisansksBean.getIrMsg12(), "　別添の「精算金振込み手続きのご案内」に沿ってお手続きくださいますようお願い申し上", "（ＩＲ）メッセージ１２");
        exStringEquals(siSeisansksBean.getIrMsg13(), "げます。", "（ＩＲ）メッセージ１３");
        exStringEquals(siSeisansksBean.getIrMsg14(), "", "（ＩＲ）メッセージ１４");
        exStringEquals(siSeisansksBean.getIrMsg15(), "", "（ＩＲ）メッセージ１５");
        exStringEquals(siSeisansksBean.getIrMsg16(), "", "（ＩＲ）メッセージ１６");
        exStringEquals(siSeisansksBean.getIrMsg17(), "", "（ＩＲ）メッセージ１７");
        exStringEquals(siSeisansksBean.getIrMsg18(), "", "（ＩＲ）メッセージ１８");
        exStringEquals(siSeisansksBean.getIrMsg19(), "", "（ＩＲ）メッセージ１９");
        exStringEquals(siSeisansksBean.getIrMsg20(), null, "（ＩＲ）メッセージ２０");
        exStringEquals(siSeisansksBean.getIrMsg21(), null, "（ＩＲ）メッセージ２１");
        exStringEquals(siSeisansksBean.getIrMsg22(), null, "（ＩＲ）メッセージ２２");
        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");

        exStringEquals(siSeisansksBean.getIrToritsugisyasyozokunm(), "組織名", "（ＩＲ）取次者所属名");
        exStringEquals(siSeisansksBean.getIrToritsugisyakjncd(), "AKB00000001", "（ＩＲ）取次者個人コード");
        exStringEquals(siSeisansksBean.getIrToritsugisyanm(), "小野　緑", "（ＩＲ）取次者氏名");
        exStringEquals(siSeisansksBean.getIrTyouhyousakuseiymd(), "2020年11月27日", "（ＩＲ）帳票作成日");
        exStringEquals(siSeisansksBean.getIrHozonkkn(), "5", "（ＩＲ）保存期間");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuuhknknhyjumu(), C_UmuKbn.NONE, "（ＩＲ）免責事由（保険金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrMensekijiyuukyhknhyjumu(), C_UmuKbn.ARI, "（ＩＲ）免責事由（給付金）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthougkdthyjumu(), C_UmuKbn.NONE, "（ＩＲ）お受取方法（外貨建）表示有無");
        exClassificationEquals(siSeisansksBean.getIrUkthouendthyjumu(), C_UmuKbn.ARI, "（ＩＲ）お受取方法（円建）表示有無");
    }
}
