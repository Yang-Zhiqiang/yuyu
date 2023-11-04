package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.GenkyouTuutiKariPasswordHakkou;
import yuyu.common.direct.dscommon.GenkyouTuutiKariPasswordHakkouMockForHozen;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;
/**
 * 契約内容のお知らせ編集（共通項目）クラスのメソッド {@link EditKykNaiyouOsiraseKytKm#editDsTourokuJyou(String,BizDate,ZT_GaikaKokyakuTuutiTy)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou {

    @Inject
    private EditKykNaiyouOsiraseKytKm editKykNaiyouOsiraseKytKm;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GenkyouTuutiKariPasswordHakkou.class).to(
                    GenkyouTuutiKariPasswordHakkouMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        GenkyouTuutiKariPasswordHakkouMockForHozen.caller = EditKykNaiyouOsiraseKytKmTest_editDsTourokuJyou.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.caller = null;
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = null;

    }

    @Test
    @TestOrder(10)
    public void testEditDsTourokuJyou_A1() {

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN1;

        String errorMsg = "";

        try {
            editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
        exStringEquals(errorMsg, "システム整合性エラーです。ダイレクトサービス．現況通知用仮パスワード発行　　対象証券番号：17806000013", "メッセージ内容");

    }

    @Test
    @TestOrder(20)
    public void testEditDsTourokuJyou_A2() {

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN1;

        String errorMsg = "";

        try {
            editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        } catch (Exception e) {
            errorMsg = e.getMessage();
        }
        exStringEquals(errorMsg, "システム整合性エラーです。ダイレクトサービス状況取得が実行できませんでした。", "メッセージ内容");

    }

    @Test
    @TestOrder(30)
    public void testEditDsTourokuJyou_A3() {


        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN2;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        String mSyoNo = (String)MockObjectManager.getArgument(GenkyouTuutiKariPasswordHakkouMockForHozen.class, "exec", 0, 0);
        exStringEquals(mSyoNo, "17806000013", "証券番号");

        BizDate mSyoriYmd = (BizDate)MockObjectManager.getArgument(GenkyouTuutiKariPasswordHakkouMockForHozen.class, "exec", 0, 1);
        exDateEquals(mSyoriYmd, BizDate.valueOf(20181001), "処理年月日");

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "", "（中継用）有効期限（和暦）");

    }

    @Test
    @TestOrder(40)
    public void testEditDsTourokuJyou_A4() {

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN3;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "4", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "", "（中継用）有効期限（和暦）");

    }

    @Test
    @TestOrder(50)
    public void testEditDsTourokuJyou_A5() {

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN4;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "", "（中継用）有効期限（和暦）");

    }

    @Test
    @TestOrder(60)
    public void testEditDsTourokuJyou_A6() {

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN5;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "3", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "", "（中継用）有効期限（和暦）");

    }

    @Test
    @TestOrder(70)
    public void testEditDsTourokuJyou_A7() {

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN6;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "1", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "", "（中継用）有効期限（和暦）");

    }

    @Test
    @TestOrder(80)
    public void testEditDsTourokuJyou_A8() {

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN7;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "2", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "", "（中継用）有効期限（和暦）");

    }

    @Test
    @TestOrder(90)
    public void testEditDsTourokuJyou_A9() {

        String syoNo = "17806000013";
        BizDate syoriYmd = BizDate.valueOf("20181001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        GenkyouTuutiKariPasswordHakkouMockForHozen.SYORIPTN = GenkyouTuutiKariPasswordHakkouMockForHozen.TESTPATTERN8;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editDsTourokuJyou(syoNo, syoriYmd, gaikaKokyakuTuutiTy);

        exStringEquals(gaikaKokyakuTuutiTy.getZtydstourokujyou(), "0", "（中継用）ＤＳ登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd1msgcd(), "07003", "（中継用）スミセイダイレクト１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd2msgcd(), "", "（中継用）スミセイダイレクト２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysd3msgcd(), "", "（中継用）スミセイダイレクト３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykrpassword(), "", "（中継用）仮パスワード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyyuukoukigenwareki(), "", "（中継用）有効期限（和暦）");

    }
}
