package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 推移表ＴＢＬ編集（終身３）のメソッド {@link EditSuiihyouTblSyuusin3#editTBL(KhozenCommonParam, IT_KykKihon,
 *    List<IT_KykSyouhn> IT_HhknSya, BizDate, EditHokenSyoukenParam, C_SinsaihkKbn, IT_Zennou)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSuiihyouTblSyuusin3Test_editTBL {

    @Inject
    private EditSuiihyouTblSyuusin3 editSuiihyouTblSyuusin3;

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    KhozenCommonParam pKkanriCommonParam;

    @Inject
    private HozenDomManager hozenDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_推移表ＴＢＬ編集（終身３）";
    private final static String sheetName = "テストデータ";

    private final static String SyoNo_yen = "21806003161";
    private final static String SyoNo_yen_zen = "21806003172";
    private final static String SyoNo_gai = "21806003183";
    private final static String SyoNo_gai_zen = "21806003194";


    @Inject
    private static Logger logger;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
            }
        });
        baseUserInfo.getUser().setUserId("User1");
        pKkanriCommonParam.setFunctionId("EditSuiihyouTblSyuusin3");
    }

    @BeforeClass
    public static void testInit() {
        KeisanWExtMockForHozen.caller = EditSuiihyouTblSyuusin3Test_editTBL.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.caller = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSuiihyouTblSyuusin3Test_editTBL.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getKykKihon(SyoNo_yen));
        hozenDomManager.delete(hozenDomManager.getKykKihon(SyoNo_yen_zen));
        hozenDomManager.delete(hozenDomManager.getKykKihon(SyoNo_gai));
        hozenDomManager.delete(hozenDomManager.getKykKihon(SyoNo_gai_zen));
        hozenDomManager.delete(hozenDomManager.getAnsyuKihon(SyoNo_yen));
        hozenDomManager.delete(hozenDomManager.getAnsyuKihon(SyoNo_yen_zen));
        hozenDomManager.delete(hozenDomManager.getAnsyuKihon(SyoNo_gai));
        hozenDomManager.delete(hozenDomManager.getAnsyuKihon(SyoNo_gai_zen));
    }

    @Test (expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testEditTBL_A1() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN1;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(SyoNo_yen);
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        BizDate pSyoriYmd = BizDate.valueOf(20210410);
        EditHokenSyoukenParam pEditHokenSyoukenParam = new EditHokenSyoukenParam();
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_Zennou zennou = null;

        try {
            editSuiihyouTblSyuusin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,
                pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,zennou);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。解約返戻金計算拡張情報作成が実行できませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_B1() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(SyoNo_yen);
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BizDate pSyoriYmd = BizDate.valueOf(20210405);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.BLNK);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SIN;
        IT_Zennou pZennnou = null;

        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        C_Tuukasyu wkTuukasyu = wkKykSyouhn.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkTuukasyu);

        editSuiihyouTblSyuusin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pZennnou);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 19, "推移表レコード件数");
        List<SibouSBean> sibouSBeanList = editSuiihyouTblSyuusin3.getSibouSBeanList();
        exNumericEquals(sibouSBeanList.size(), 6, "死亡ＳBeanリスト件数");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "06", "区分キー");
            exStringEquals(Suiihyou.getSyono(), SyoNo_yen, "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "20", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), pSyoriYmd, "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), wkTuukasyu, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(0), "前納残高１");
            exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
            exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), Suiihyou.getMvanonewsame(), "解約時受取額");
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_YenNone(Suiihyou);
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 0, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20220404), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202204), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(120000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(792000, currencyType), "ＭＶＡ適用外解約返戻金額");
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 1, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20230404), "計算基準日");
                    break;
                case 2:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20240404), "計算基準日");
                    break;
                case 3:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 3, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20250404), "計算基準日");
                    break;
                case 4:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 4, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20260404), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202604), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(4073400, currencyType), "ＭＶＡ適用外解約返戻金額");
                    break;
                case 5:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 5, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20260405), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202604), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5818800, currencyType), "ＭＶＡ適用外解約返戻金額");
                    break;
                case 6:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 6, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20270404), "計算基準日");
                    break;
                case 7:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 7, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20280404), "計算基準日");
                    break;
                case 8:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 8, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20290404), "計算基準日");
                    break;
                case 9:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 9, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20300404), "計算基準日");
                    break;
                case 10:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 10, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20310404), "計算基準日");
                    break;
                case 11:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 20, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20410404), "計算基準日");
                    break;
                case 12:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 30, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20510404), "計算基準日");
                    break;
                case 13:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 40, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20610404), "計算基準日");
                    break;
                case 14:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 50, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20710404), "計算基準日");
                    break;
                case 15:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 60, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20810404), "計算基準日");
                    break;
                case 16:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 70, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20910404), "計算基準日");
                    break;
                case 17:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 80, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(21010404), "計算基準日");
                    break;
                case 18:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 90, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(21110404), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(211104), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5996400, currencyType), "ＭＶＡ適用外解約返戻金額");
                    break;
                default:
                    break;
            }
        }
        for (int cnt = 0; cnt < sibouSBeanList.size(); cnt++){
            SibouSBean sibouSBean = sibouSBeanList.get(cnt);
            displayContents(sibouSBean);
        }
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_B2() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(SyoNo_yen_zen);
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BizDate pSyoriYmd = BizDate.valueOf(20260404);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(pKykKihon.getSyono());
        IT_Zennou pZennnou = pAnsyuKihon.getZennous().get(0);

        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        C_Tuukasyu wkTuukasyu = wkKykSyouhn.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkTuukasyu);

        editSuiihyouTblSyuusin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pZennnou);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 12, "推移表レコード件数");
        List<SibouSBean> sibouSBeanList = editSuiihyouTblSyuusin3.getSibouSBeanList();
        exNumericEquals(sibouSBeanList.size(), 6, "死亡ＳBeanリスト件数");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "07", "区分キー");
            exStringEquals(Suiihyou.getSyono(), SyoNo_yen_zen, "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "21", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), pSyoriYmd, "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), wkTuukasyu, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(0), "前納残高１");
            exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_YenNone(Suiihyou);
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 4, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20260404), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202604), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(5416940, currencyType), "前納残高（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(4182600, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(9599540, currencyType), "解約時受取額");
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 5, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20260405), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202604), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0, currencyType), "前納残高（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5974800, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), Suiihyou.getMvanonewsame(), "解約時受取額");
                    break;
                case 2:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 6, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20270404), "計算基準日");
                    break;
                case 3:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 7, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20280404), "計算基準日");
                    break;
                case 4:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 8, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20290404), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202904), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5979600, currencyType), "ＭＶＡ適用外解約返戻金額");
                    break;
                case 5:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 9, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20300404), "計算基準日");
                    break;
                case 6:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 10, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20310404), "計算基準日");
                    break;
                case 7:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 11, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20320404), "計算基準日");
                    break;
                case 8:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 12, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20330404), "計算基準日");
                    break;
                case 9:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 13, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20340404), "計算基準日");
                    break;
                case 10:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 14, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20350404), "計算基準日");
                    break;
                case 11:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 24, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20450404), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(204504), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000, currencyType), "既払込保険料（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0, currencyType), "前納残高（円貨）１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5995200, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), Suiihyou.getMvanonewsame(), "解約時受取額");
                    break;
                default:
                    break;
            }
        }
        for (int cnt = 0; cnt < sibouSBeanList.size(); cnt++){
            SibouSBean sibouSBean = sibouSBeanList.get(cnt);
            displayContents(sibouSBean);
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（円高）");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（中央値）");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（円安）");
            switch (cnt) {
                case 0:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20220404), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(1193544, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(5883528, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(7077072, currencyType), "死亡時受取額");
                    break;
                case 1:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20230404), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(2387088, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(5766986, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(8154074, currencyType), "死亡時受取額");
                    break;
                case 2:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20240404), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(3580632, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(5650374, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(9231006, currencyType), "死亡時受取額");
                    break;
                case 3:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250404), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(4774176, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(5533692, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(10307868, currencyType), "死亡時受取額");
                    break;
                case 4:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20260404), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(5967720, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(5416940, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(11384660, currencyType), "死亡時受取額");
                    break;
                case 5:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20260405), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(6000000, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(0, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), sibouSBean.getSibouS(), "死亡時受取額");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_B3() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(SyoNo_gai);
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BizDate pSyoriYmd = BizDate.valueOf(20260517);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_Zennou pZennnou = null;

        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        C_Tuukasyu wkTuukasyu = wkKykSyouhn.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkTuukasyu);

        editSuiihyouTblSyuusin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pZennnou);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 16, "推移表レコード件数");
        List<SibouSBean> sibouSBeanList = editSuiihyouTblSyuusin3.getSibouSBeanList();
        exNumericEquals(sibouSBeanList.size(), 0, "死亡ＳBeanリスト件数");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "08", "区分キー");
            exStringEquals(Suiihyou.getSyono(), SyoNo_gai, "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "22", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), pSyoriYmd, "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), wkTuukasyu, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
            exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(300000, currencyType), "既払込保険料１");
            exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(0, currencyType), "前納残高１");
            exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), Suiihyou.getMvanonewsame(), "解約時受取額");
            exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyendaka(), Suiihyou.getMvanonewyensameyendaka(), "解約時受取額（円貨）（円高）");
            exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenkijyun(), Suiihyou.getMvanonewyensameyenkijyun(), "解約時受取額（円貨）（中央値）");
            exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenyasu(), Suiihyou.getMvanonewyensameyenyasu(), "解約時受取額（円貨）（円安）");
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou);
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 6, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20270516), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202705), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(4390800, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(495940860), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(539848860), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(583756860), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 7, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20280516), "計算基準日");
                    break;
                case 2:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 8, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20290516), "計算基準日");
                    break;
                case 3:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 9, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20300516), "計算基準日");
                    break;
                case 4:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 10, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20310516), "計算基準日");
                    break;
                case 5:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 11, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20320516), "計算基準日");
                    break;
                case 6:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 12, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20330516), "計算基準日");
                    break;
                case 7:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 13, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20340516), "計算基準日");
                    break;
                case 8:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 14, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20350516), "計算基準日");
                    break;
                case 9:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 15, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20360516), "計算基準日");
                    break;
                case 10:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 25, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20460516), "計算基準日");
                    break;
                case 11:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 35, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20560516), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(205605), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5251800, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(593190810), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(645708810), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(698226810), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
                    break;
                case 12:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 45, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20660516), "計算基準日");
                    break;
                case 13:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 55, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20760516), "計算基準日");
                    break;
                case 14:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 65, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20860516), "計算基準日");
                    break;
                case 15:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 75, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20960516), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(209605), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5949600, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(672007320), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(731503320), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(790999320), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
                    break;
            }
        }
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_B4() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(SyoNo_gai_zen);
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BizDate pSyoriYmd = BizDate.valueOf(20200315);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(pKykKihon.getSyono());
        IT_Zennou pZennnou = pAnsyuKihon.getZennous().get(0);

        IT_KykSyouhn wkKykSyouhn = pKykSyohnSyuLst.get(0);
        C_Tuukasyu wkTuukasyu = wkKykSyouhn.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wkTuukasyu);

        editSuiihyouTblSyuusin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pZennnou);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 14, "推移表レコード件数");
        List<SibouSBean> sibouSBeanList = editSuiihyouTblSyuusin3.getSibouSBeanList();
        exNumericEquals(sibouSBeanList.size(), 6, "死亡ＳBeanリスト件数");

        for (int cnt = 0; cnt < suiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = suiihyouLst.get(cnt);
            displayContents(Suiihyou);

            exStringEquals(Suiihyou.getKbnkey(), "09", "区分キー");
            exStringEquals(Suiihyou.getSyono(), SyoNo_gai_zen, "証券番号");
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "23", "推移表種別");
            exDateEquals(Suiihyou.getTyouhyouymd(), pSyoriYmd, "帳票作成日");
            exClassificationEquals(Suiihyou.getKyktuukasyu(), wkTuukasyu, "契約通貨種類");
            exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
            exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_KawaseRate_zen(Suiihyou);
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 0, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20210227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202102), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(60000, currencyType), "既払込保険料１");
                    exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(5948910, currencyType), "前納残高１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(678600, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(75290670), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(82076670), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(88862670), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(6627510, currencyType), "解約時受取額");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(735322234), "解約時受取額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(801597334), "解約時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(867872434), "解約時受取額（円貨）（円安）");
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 1, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20220227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202202), "計算年日");
                    break;
                case 2:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20230227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202302), "計算年日");
                    break;
                case 3:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 3, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20240228), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202402), "計算年日");
                    break;
                case 4:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 4, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20250227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202502), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(300000, currencyType), "既払込保険料１");
                    exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(5743782.47, currencyType), "前納残高１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(3601200, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(399553140), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(435565140), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(471577140), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(9344982.47, currencyType), "解約時受取額");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(1036825805), "解約時受取額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(1130275629), "解約時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(1223725454), "解約時受取額（円貨）（円安）");
                    break;
                case 5:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 5, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20250301), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202502), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(300000, currencyType), "既払込保険料１");
                    exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(0, currencyType), "前納残高１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5144400, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(570771180), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(622215180), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(673659180), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), Suiihyou.getMvanonewsame(), "解約時受取額");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyendaka(), Suiihyou.getMvanonewyensameyendaka(), "解約時受取額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenkijyun(), Suiihyou.getMvanonewyensameyenkijyun(), "解約時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenyasu(), Suiihyou.getMvanonewyensameyenyasu(), "解約時受取額（円貨）（円安）");
                    break;
                case 6:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 6, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20260227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202602), "計算年日");
                    break;
                case 7:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 7, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20270227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202702), "計算年日");
                    break;
                case 8:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 8, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20280228), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202802), "計算年日");
                    break;
                case 9:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 9, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20290227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(202902), "計算年日");
                    break;
                case 10:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 10, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20300227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(203002), "計算年日");
                    break;
                case 11:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 20, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20400228), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(204002), "計算年日");
                    break;
                case 12:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 30, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20500227), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(205002), "計算年日");
                    break;
                case 13:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 40, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf(20600228), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf(206002), "計算年日");
                    exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
                    exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(300000, currencyType), "既払込保険料１");
                    exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(0, currencyType), "前納残高１");
                    exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(5916000, currencyType), "ＭＶＡ適用外解約返戻金額");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(656380200), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(715540200), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(774700200), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(5916000, currencyType), "解約時受取額");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(656380200), "解約時受取額（円貨）（円高）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(715540200), "解約時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(Suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(774700200), "解約時受取額（円貨）（円安）");
                    break;
            }
        }
        for (int cnt = 0; cnt < sibouSBeanList.size(); cnt++){
            SibouSBean sibouSBean = sibouSBeanList.get(cnt);
            displayContents(sibouSBean);
            switch (cnt) {
                case 0:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20210227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(1025928, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(5948910, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(6974838, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(773858276), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(843606656), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(913355036), "死亡時受取額（円貨）（円安）");
                    break;
                case 1:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20220227), "計算基準日");
                    break;
                case 2:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20230227), "計算基準日");
                    break;
                case 3:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20240228), "計算基準日");
                    break;
                case 4:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(5129640, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(5743782.47, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(10873422.47, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(1206406223), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(1315140447), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(1423874672), "死亡時受取額（円貨）（円安）");
                    break;
                case 5:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250301), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(6000000, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(0, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), sibouSBean.getSibouS(), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(665700000), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(725700000), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(785700000), "死亡時受取額（円貨）（円安）");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_B5() {
        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = null;

        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(SyoNo_yen_zen);
        List<IT_KykSyouhn> pKykSyohnSyuLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BizDate pSyoriYmd = BizDate.valueOf(20460405);
        EditHokenSyoukenParam pEditHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        pEditHokenSyoukenParam.setCalckijyunYMD(pSyoriYmd);
        pEditHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        C_SinsaihkKbn pCSinsaihkKbn = C_SinsaihkKbn.SAI;
        IT_AnsyuKihon pAnsyuKihon = hozenDomManager.getAnsyuKihon(pKykKihon.getSyono());
        IT_Zennou pZennnou = pAnsyuKihon.getZennous().get(0);

        editSuiihyouTblSyuusin3.editTBL(pKkanriCommonParam,pKykKihon,pKykSyohnSyuLst,
            pSyoriYmd,pEditHokenSyoukenParam,pCSinsaihkKbn,pZennnou);

        List<IT_Suiihyou> suiihyouLst = pKykKihon.getSuiihyous();
        exNumericEquals(suiihyouLst.size(), 1, "推移表レコード件数");
        List<SibouSBean> sibouSBeanList = editSuiihyouTblSyuusin3.getSibouSBeanList();
        exNumericEquals(sibouSBeanList.size(), 0, "死亡ＳBeanリスト件数");

        IT_Suiihyou Suiihyou = suiihyouLst.get(0);
        displayContents(Suiihyou);

        exStringEquals(Suiihyou.getSyono(), SyoNo_yen_zen, "証券番号");
        exDateEquals(Suiihyou.getTyouhyouymd(), pSyoriYmd, "帳票作成日");
        exNumericEquals(Suiihyou.getKeikanensuu(), 99, "経過年数");
        exDateEquals(Suiihyou.getCalckijyunymd(), null, "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), null, "計算年月");
        exStringEquals(Suiihyou.getSuiihyousyubetu(), "00", "推移表種別");
        exClassificationEquals(Suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE , "払込期間満了有無区分");
        checkWSuiihyou1_Default(Suiihyou);
        checkWSuiihyouOther_Default(Suiihyou);
    }

    private void checkWSuiihyouOther_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用状態区分");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.ZERO, "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.ZERO, "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.ZERO, "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(0), "予定利率計算基準利率１");
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou1_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(0), "前納残高１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(0), "解約時受取額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(0), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(0), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(0), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou2_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup2(), BizNumber.ZERO, "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame2(), BizNumber.ZERO, "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown2(), BizNumber.ZERO, "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup2(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown2(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
    }

    private void checkWSuiihyou3_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup3(), BizNumber.ZERO, "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame3(), BizNumber.ZERO, "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown3(), BizNumber.ZERO, "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup3(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown3(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
    }

    private void checkWSuiihyou1_YenNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(0), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(0), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(0), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou1_KawaseRate(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(112.95), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(122.95), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(132.95), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
    }

    private void checkWSuiihyou1_KawaseRate_zen(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(110.95), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(120.95), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(130.95), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
    }

    private void displayContents(IT_Suiihyou pSuiihyou) {
        logger.debug("▼ 推移表TBLの設定値");
        logger.debug("│ ★共通：経過年数 = {}", pSuiihyou.getKeikanensuu());
        logger.debug("│ ★共通：計算基準日 = {}", pSuiihyou.getCalckijyunymd());
        logger.debug("│ ★共通：計算年月 = {}", pSuiihyou.getCalcym());
        //        logger.debug("│ ★共通：ＭＶＡ適用状態区分 = {}", pSuiihyou.getMvatekijyoutaikbn());
        logger.debug("│ ★共通：契約通貨種類 = {}", pSuiihyou.getKyktuukasyu());
        logger.debug("│ ★共通：推移表種別 = {}", pSuiihyou.getSuiihyousyubetu());
        logger.debug("│ ★共通：払込期間満了有無区分 = {}", pSuiihyou.getHrkkknmnryumukbn());
        //        logger.debug("│ ★①：市場価格調整用利率（上昇） = {}", pSuiihyou.getSjkkktusirrtup());
        //        logger.debug("│ ★①：市場価格調整用利率（同水準） = {}", pSuiihyou.getSjkkktusirrtsame());
        //        logger.debug("│ ★①：市場価格調整用利率（低下） = {}", pSuiihyou.getSjkkktusirrtdown());
        //        logger.debug("│ ★①：市場価格調整用利率変動幅（上） = {}", pSuiihyou.getSjkkktusirrthendouup());
        //        logger.debug("│ ★①：市場価格調整用利率変動幅（下） = {}", pSuiihyou.getSjkkktusirrthendoudown());
        //        logger.debug("│ ★②：市場価格調整用利率（上昇）２ = {}", pSuiihyou.getSjkkktusirrtup2());
        //        logger.debug("│ ★②：市場価格調整用利率（同水準）２ = {}", pSuiihyou.getSjkkktusirrtsame2());
        //        logger.debug("│ ★②：市場価格調整用利率（低下）２ = {}", pSuiihyou.getSjkkktusirrtdown2());
        //        logger.debug("│ ★②：市場価格調整用利率変動幅（上）２ = {}", pSuiihyou.getSjkkktusirrthendouup2());
        //        logger.debug("│ ★②：市場価格調整用利率変動幅（下）２ = {}", pSuiihyou.getSjkkktusirrthendoudown2());
        //        logger.debug("│ ★③：市場価格調整用利率（上昇）３ = {}", pSuiihyou.getSjkkktusirrtup3());
        //        logger.debug("│ ★③：市場価格調整用利率（同水準）３ = {}", pSuiihyou.getSjkkktusirrtsame3());
        //        logger.debug("│ ★③：市場価格調整用利率（低下）３ = {}", pSuiihyou.getSjkkktusirrtdown3());
        //        logger.debug("│ ★③：市場価格調整用利率変動幅（上）３ = {}", pSuiihyou.getSjkkktusirrthendouup3());
        //        logger.debug("│ ★③：市場価格調整用利率変動幅（下）３ = {}", pSuiihyou.getSjkkktusirrthendoudown3());
        logger.debug("│ ★①：円換算適用為替レート（円高） = {}", pSuiihyou.getYenknsnkwsrateyendaka());
        logger.debug("│ ★①：円換算適用為替レート（中央値） = {}", pSuiihyou.getYenknsnkwsrateyenkijyun());
        logger.debug("│ ★①：円換算適用為替レート（円安） = {}", pSuiihyou.getYenknsnkwsrateyenyasu());
        logger.debug("│ ★①：円換算適用為替レート変動額（円高） = {}", pSuiihyou.getYenknsnkwsrategkyendaka());
        logger.debug("│ ★①：円換算適用為替レート変動額（円安） = {}", pSuiihyou.getYenknsnkwsrategkyenyasu());
        //        logger.debug("│ ★②：円換算適用為替レート（円高）２ = {}", pSuiihyou.getYenknsnkwsrateyendaka2());
        //        logger.debug("│ ★②：円換算適用為替レート（中央値）２ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun2());
        //        logger.debug("│ ★②：円換算適用為替レート（円安）２ = {}", pSuiihyou.getYenknsnkwsrateyenyasu2());
        //        logger.debug("│ ★②：円換算適用為替レート変動額（円高）２ = {}", pSuiihyou.getYenknsnkwsrategkyendaka2());
        //        logger.debug("│ ★②：円換算適用為替レート変動額（円安）２ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu2());
        //        logger.debug("│ ★③：円換算適用為替レート（円高）３ = {}", pSuiihyou.getYenknsnkwsrateyendaka3());
        //        logger.debug("│ ★③：円換算適用為替レート（中央値）３ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun3());
        //        logger.debug("│ ★③：円換算適用為替レート（円安）３ = {}", pSuiihyou.getYenknsnkwsrateyenyasu3());
        //        logger.debug("│ ★③：円換算適用為替レート変動額（円高）３ = {}", pSuiihyou.getYenknsnkwsrategkyendaka3());
        //        logger.debug("│ ★③：円換算適用為替レート変動額（円安）３ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu3());
        //        logger.debug("│ ★①：指数上昇率１ = {}", pSuiihyou.getSisuuupritu1());
        //        logger.debug("│ ★①：積立金増加率１ = {}", pSuiihyou.getTmttknzoukaritu1());
        //        logger.debug("│ ★①：ＭＶＡ適用保険料積立金 = {}", pSuiihyou.getMvaariptumitatekin());
        //        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（上昇）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
        //        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（同水準）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
        //        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（低下）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（上昇） = {}", pSuiihyou.getMvaariwup());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（同水準） = {}", pSuiihyou.getMvaariwsame());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（低下） = {}", pSuiihyou.getMvaariwdown());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高） = {}", pSuiihyou.getMvaariwyenupyendaka());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値） = {}", pSuiihyou.getMvaariwyenupyenkijyun());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安） = {}", pSuiihyou.getMvaariwyenupyenyasu());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高） = {}", pSuiihyou.getMvaariwyensameyendaka());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値） = {}", pSuiihyou.getMvaariwyensameyenkijyun());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安） = {}", pSuiihyou.getMvaariwyensameyenyasu());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高） = {}", pSuiihyou.getMvaariwyendownyendaka());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値） = {}", pSuiihyou.getMvaariwyendownyenkijyun());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安） = {}", pSuiihyou.getMvaariwyendownyenyasu());
        //        logger.debug("│ ★①：積立金内訳（１）１ = {}", pSuiihyou.getTutmttknutiwake11());
        //        logger.debug("│ ★①：積立金内訳（２）１ = {}", pSuiihyou.getTutmttknutiwake21());
        //        logger.debug("│ ★②：指数上昇率２ = {}", pSuiihyou.getSisuuupritu2());
        //        logger.debug("│ ★②：積立金増加率２ = {}", pSuiihyou.getTmttknzoukaritu2());
        //        logger.debug("│ ★②：ＭＶＡ適用保険料積立金２ = {}", pSuiihyou.getMvaariptumitatekin2());
        //        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（上昇）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        //        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（同水準）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        //        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（低下）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（上昇）２ = {}", pSuiihyou.getMvaariwup2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（同水準）２ = {}", pSuiihyou.getMvaariwsame2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（低下）２ = {}", pSuiihyou.getMvaariwdown2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２ = {}", pSuiihyou.getMvaariwyenupyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２ = {}", pSuiihyou.getMvaariwyenupyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２ = {}", pSuiihyou.getMvaariwyenupyenyasu2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２ = {}", pSuiihyou.getMvaariwyensameyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２ = {}", pSuiihyou.getMvaariwyensameyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２ = {}", pSuiihyou.getMvaariwyensameyenyasu2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２ = {}", pSuiihyou.getMvaariwyendownyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２ = {}", pSuiihyou.getMvaariwyendownyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２ = {}", pSuiihyou.getMvaariwyendownyenyasu2());
        //        logger.debug("│ ★②：積立金内訳（１）２ = {}", pSuiihyou.getTutmttknutiwake12());
        //        logger.debug("│ ★②：積立金内訳（２）２ = {}", pSuiihyou.getTutmttknutiwake22());
        //        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（上昇）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        //        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（同水準）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        //        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（低下）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        //        logger.debug("│ ★③：指数上昇率３ = {}", pSuiihyou.getSisuuupritu3());
        //        logger.debug("│ ★③：積立金増加率３ = {}", pSuiihyou.getTmttknzoukaritu3());
        //        logger.debug("│ ★③：ＭＶＡ適用保険料積立金３ = {}", pSuiihyou.getMvaariptumitatekin3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（上昇）３ = {}", pSuiihyou.getMvaariwup3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（同水準）３ = {}", pSuiihyou.getMvaariwsame3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（低下）３ = {}", pSuiihyou.getMvaariwdown3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３ = {}", pSuiihyou.getMvaariwyenupyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３ = {}", pSuiihyou.getMvaariwyenupyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３ = {}", pSuiihyou.getMvaariwyenupyenyasu3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３ = {}", pSuiihyou.getMvaariwyensameyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３ = {}", pSuiihyou.getMvaariwyensameyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３ = {}", pSuiihyou.getMvaariwyensameyenyasu3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３ = {}", pSuiihyou.getMvaariwyendownyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３ = {}", pSuiihyou.getMvaariwyendownyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３ = {}", pSuiihyou.getMvaariwyendownyenyasu3());
        //        logger.debug("│ ★③：積立金内訳（１）３ = {}", pSuiihyou.getTutmttknutiwake13());
        //        logger.debug("│ ★③：積立金内訳（２）３ = {}", pSuiihyou.getTutmttknutiwake23());
        //        logger.debug("│ ★①：ＭＶＡ適用外保険料積立金 = {}", pSuiihyou.getMvanoneptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額 = {}", pSuiihyou.getMvanonewsame());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円高） = {}", pSuiihyou.getMvanonewyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（中央値） = {}", pSuiihyou.getMvanonewyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円安） = {}", pSuiihyou.getMvanonewyensameyenyasu());
        //        logger.debug("│ ★②：ＭＶＡ適用外保険料積立金２ = {}", pSuiihyou.getMvanoneptumitatekin2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額２ = {}", pSuiihyou.getMvanonewsame2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円高）２ = {}", pSuiihyou.getMvanonewyensameyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（中央値）２ = {}", pSuiihyou.getMvanonewyensameyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円安）２ = {}", pSuiihyou.getMvanonewyensameyenyasu2());
        //        logger.debug("│ ★③：ＭＶＡ適用外保険料積立金３ = {}", pSuiihyou.getMvanoneptumitatekin3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額３ = {}", pSuiihyou.getMvanonewsame3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円高）３ = {}", pSuiihyou.getMvanonewyensameyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（中央値）３ = {}", pSuiihyou.getMvanonewyensameyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円安）３ = {}", pSuiihyou.getMvanonewyensameyenyasu3());
        //        logger.debug("│ ★①：予定利率計算基準利率１ = {}", pSuiihyou.getYtirrtcalckijyunrrt1());
        //        logger.debug("│ ★②：予定利率計算基準利率２ = {}", pSuiihyou.getYtirrtcalckijyunrrt2());
        //        logger.debug("│ ★③：予定利率計算基準利率３ = {}", pSuiihyou.getYtirrtcalckijyunrrt3());
        logger.debug("│ ★①：前納残高（円貨）１ = {}", pSuiihyou.getZennouzndkyen1());
        //        logger.debug("│ ★②：前納残高（円貨）２ = {}", pSuiihyou.getZennouzndkyen2());
        //        logger.debug("│ ★③：前納残高（円貨）３ = {}", pSuiihyou.getZennouzndkyen3());
        logger.debug("│ ★①：既払込保険料（円貨）１ = {}", pSuiihyou.getKihrkmpyen1());
        //        logger.debug("│ ★②：既払込保険料（円貨）２ = {}", pSuiihyou.getKihrkmpyen2());
        //        logger.debug("│ ★③：既払込保険料（円貨）３ = {}", pSuiihyou.getKihrkmpyen3());
        logger.debug("│ ★①：既払込保険料１ = {}", pSuiihyou.getKihrkmp1());
        //        logger.debug("│ ★②：既払込保険料２ = {}", pSuiihyou.getKihrkmp2());
        //        logger.debug("│ ★③：既払込保険料３ = {}", pSuiihyou.getKihrkmp3());
        logger.debug("│ ★①：前納残高１ = {}", pSuiihyou.getZennouzndk1());
        logger.debug("│ ★①：解約時受取額 = {}", pSuiihyou.getKaiyakujuktrgk());
        logger.debug("│ ★①：解約時受取額（円貨）（円高） = {}", pSuiihyou.getKaiyakujuktrgkyendaka());
        logger.debug("│ ★①：解約時受取額（円貨）（中央値） = {}", pSuiihyou.getKaiyakujuktrgkyenkijyun());
        logger.debug("│ ★①：解約時受取額（円貨）（円安） = {}", pSuiihyou.getKaiyakujuktrgkyenyasu());
        logger.debug("▲ 推移表TBLの設定値");
    }

    private void displayContents(SibouSBean pSibouSBean) {
        logger.debug("▼ 死亡ＳBeanの設定値");
        logger.debug("│ ★計算基準日 = {}", pSibouSBean.getCalcKijyunYmd());
        logger.debug("│ ★死亡保険金額 = {}", pSibouSBean.getSibouS());
        logger.debug("│ ★前納残高 = {}", pSibouSBean.getZennouZndk());
        logger.debug("│ ★死亡時受取額 = {}", pSibouSBean.getSibouUktrgk());
        logger.debug("│ ★死亡時受取額（円貨）（円高） = {}", pSibouSBean.getSibouUktrgkYendaka());
        logger.debug("│ ★死亡時受取額（円貨）（中央値） = {}", pSibouSBean.getSibouUktrgkYen());
        logger.debug("│ ★死亡時受取額（円貨）（円安） = {}", pSibouSBean.getSibouUktrgkYenyasu());
        logger.debug("▲ 死亡ＳBeanの設定値");
    }
}
