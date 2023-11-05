package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkjyhyouten;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品履歴TBL編集クラスのメソッド {@link EditKykSyhnRirekiTbl#exec(KhozenCommonParam, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykSyhnRirekiTblTest_exec_A2 {

    private final static String syoNo3 = "20806000019";

    private final static String syoNo4 = "20806000020";

    private final static String syoNo5 = "20806000031";

    private final static String syoNo6 = "20806000042";

    private final static String kbnKey2 = "02";

    private final static String kbnKey3 = "03";

    private final static String kbnKey4 = "04";

    @Inject
    private EditKykSyhnRirekiTbl editKykSyhnRirekiTbl;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_契約商品履歴TBL編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKykSyhnRirekiTblTest_exec_A2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        kinou.setKinouId("EditKykSyhnRirekiTbl");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("A0000001");
        changeCurrentUser(baseUserInfo, aMUser);

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKykSyhnRirekiTbl.exec(kCParam, syoNo3);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);
        exNumericEquals(kykKihon.getKhTtdkRirekis().get(0).getKhHenkouRirekis().size(), 0,"契約商品履歴テーブルエンティティリストの要素数");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiLst  = kykKihon.getKhTtdkRirekiByHenkousikibetukey("2").getSyouhnTokujouRirekis();
        exNumericEquals(syouhnTokujouRirekiLst.size(), 0,"商品特条履歴テーブルエンティティリストの要素数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        kinou.setKinouId("EditKykSyhnRirekiTbl");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("A0000001");
        changeCurrentUser(baseUserInfo, aMUser);

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKykSyhnRirekiTbl.exec(kCParam, syoNo4);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
            C_SyutkKbn.SYU, "MD11", 1, 11);

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = kykKihon.getKhTtdkRirekiByHenkousikibetukey(
            kykSyouhn.getHenkousikibetukey()).getKykSyouhnRirekis();
        exNumericEquals(kykSyouhnRirekiLst.size(), 1 ,"契約商品履歴テーブルエンティティリストの要素数");
        IT_KykSyouhnRireki kykSyouhnRireki = kykSyouhnRirekiLst.get(0);

        exStringEquals(kykSyouhnRireki.getKbnkey(), kbnKey2, "区分キー");

        exStringEquals(kykSyouhnRireki.getSyono(), syoNo4, "証券番号");
        exStringEquals(kykSyouhnRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exNumericEquals(kykSyouhnRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRireki.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(kykSyouhnRireki.getHenkousikibetukey(), "2", "変更識別キー");
        exClassificationEquals(kykSyouhnRireki.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(kykSyouhnRireki.getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exClassificationEquals(kykSyouhnRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(kykSyouhnRireki.getSyoumetuymd(), null, "消滅日");
        exDateEquals(kykSyouhnRireki.getKouryokuhasseiymd(), null, "効力発生日");
        exDateEquals(kykSyouhnRireki.getKykymd(), null, "契約日");
        exClassificationEquals(kykSyouhnRireki.getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnRireki.getSknnkaisiymd(), null, "責任開始日");
        exDateEquals(kykSyouhnRireki.getGansknnkaisiymd(), null, "がん責任開始日");
        exDateEquals(kykSyouhnRireki.getHksknnkaisiymd(), null, "復活責任開始日");
        exDateEquals(kykSyouhnRireki.getHkgansknnkaisiymd(), null, "復活がん責任開始日");
        exClassificationEquals(kykSyouhnRireki.getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnRireki.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnRireki.getHknkkn(), 0, "保険期間");
        exNumericEquals(kykSyouhnRireki.getKyknen(), 0,"契約者年齢");
        exNumericEquals(kykSyouhnRireki.getHhknnen(), 0,"被保険者年齢");
        exNumericEquals(kykSyouhnRireki.getHrkkkn(), 0, "払込期間");

        exDateEquals(kykSyouhnRireki.getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(kykSyouhnRireki.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");

        exDateEquals(kykSyouhnRireki.getHaraimanymd(), null, "払満日");
        exDateEquals(kykSyouhnRireki.getHknkknmanryouymd(), null, "保険期間満了日");
        exClassificationEquals(kykSyouhnRireki.getKatakbn(), C_KataKbn.BLNK, "型区分");
        exClassificationEquals(kykSyouhnRireki.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(kykSyouhnRireki.getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnRireki.getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.BLNK, "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnRireki.getRokudaildkbn(), C_6daiLdKbn.BLNK, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnRireki.getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnRireki.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnRireki.getHokenryou(), BizCurrency.valueOf(0), "保険料");

        exClassificationEquals(kykSyouhnRireki.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(kykSyouhnRireki.getRyouritusdno(), "", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnRireki.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(kykSyouhnRireki.getYoteirrthendohosyurrt(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnRireki.getYtirrthndmnskaisuu(), 0, "予定利率変動見直回数");
        exClassificationEquals(kykSyouhnRireki.getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnRireki.getNenkinkkn(), 0, "年金期間");
        exNumericEquals(kykSyouhnRireki.getNkgnshosyouritu(), 0, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnRireki.getNkgnshosyougk(), BizCurrency.valueOf(0), "年金原資最低保証額");

        exStringEquals(kykSyouhnRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiLst  = kykKihon.getKhTtdkRirekiByHenkousikibetukey("2").getSyouhnTokujouRirekis();
        exNumericEquals(syouhnTokujouRirekiLst.size(), 1 ,"商品特条履歴テーブルエンティティリストの要素数");
        IT_SyouhnTokujouRireki syouhnTokujouRireki = syouhnTokujouRirekiLst.get(0);
        exStringEquals(syouhnTokujouRireki.getSyono(), syoNo4, "証券番号");
        exStringEquals(syouhnTokujouRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(syouhnTokujouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(syouhnTokujouRireki.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(syouhnTokujouRireki.getKyksyouhnrenno(), 11 ,"契約商品連番");
        exStringEquals(syouhnTokujouRireki.getHenkousikibetukey(), "2", "変更識別キー");
        exClassificationEquals(syouhnTokujouRireki.getTkjyhyouten(), C_Tkjyhyouten.BLNK, "特条標点");
        exBizCalcbleEquals(syouhnTokujouRireki.getTkjyp(), BizCurrency.valueOf(0), "特条保険料");
        exClassificationEquals(syouhnTokujouRireki.getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "特条削減期間");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd1(), "", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn1(), C_Htnpkkn.BLNK, "不担保期間１");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd2(), "", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn2(), C_Htnpkkn.BLNK, "不担保期間２");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd3(), "", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn3(), C_Htnpkkn.BLNK, "不担保期間３");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd4(), "", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn4(), C_Htnpkkn.BLNK, "不担保期間４");
        exClassificationEquals(syouhnTokujouRireki.getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK, "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        kinou.setKinouId("EditKykSyhnRirekiTbl");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("A0000001");
        changeCurrentUser(baseUserInfo, aMUser);

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        editKykSyhnRirekiTbl.exec(kCParam, syoNo5);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
            C_SyutkKbn.SYU, "MD11", 1, 11);

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = kykKihon.getKhTtdkRirekiByHenkousikibetukey(
            kykSyouhn.getHenkousikibetukey()).getKykSyouhnRirekis();
        exNumericEquals(kykSyouhnRirekiLst.size(), 3,"契約商品履歴テーブルエンティティリストの要素数");

        IT_KykSyouhnRireki kykSyouhnRireki = kykSyouhnRirekiLst.get(0);

        exStringEquals(kykSyouhnRireki.getKbnkey(), kbnKey3, "区分キー");

        exStringEquals(kykSyouhnRireki.getSyono(), syoNo5, "証券番号");
        exStringEquals(kykSyouhnRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(kykSyouhnRireki.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(kykSyouhnRireki.getKyksyouhnrenno(), 0 ,"契約商品連番");
        exStringEquals(kykSyouhnRireki.getHenkousikibetukey(), "2", "変更識別キー");
        IT_KykSyouhnRireki kykSyouhnRireki1 = kykSyouhnRirekiLst.get(1);

        exStringEquals(kykSyouhnRireki1.getKbnkey(), kbnKey3, "区分キー");

        exStringEquals(kykSyouhnRireki1.getSyono(), syoNo5, "証券番号");
        exStringEquals(kykSyouhnRireki1.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki1.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(kykSyouhnRireki1.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(kykSyouhnRireki1.getKyksyouhnrenno(), 9,"契約商品連番");
        exStringEquals(kykSyouhnRireki1.getHenkousikibetukey(), "2", "変更識別キー");
        IT_KykSyouhnRireki kykSyouhnRireki2 = kykSyouhnRirekiLst.get(2);

        exStringEquals(kykSyouhnRireki2.getKbnkey(), kbnKey3, "区分キー");

        exStringEquals(kykSyouhnRireki2.getSyono(), syoNo5, "証券番号");
        exStringEquals(kykSyouhnRireki2.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(kykSyouhnRireki2.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(kykSyouhnRireki2.getKyksyouhnrenno(), 11 ,"契約商品連番");
        exStringEquals(kykSyouhnRireki2.getHenkousikibetukey(), "2", "変更識別キー");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiLst  = kykKihon.getKhTtdkRirekiByHenkousikibetukey("2").getSyouhnTokujouRirekis();
        exNumericEquals(syouhnTokujouRirekiLst.size(), 3,"商品特条履歴テーブルエンティティリストの要素数");
        IT_SyouhnTokujouRireki syouhnTokujouRireki = syouhnTokujouRirekiLst.get(0);
        exStringEquals(syouhnTokujouRireki.getSyono(), syoNo5, "証券番号");
        exStringEquals(syouhnTokujouRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(syouhnTokujouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(syouhnTokujouRireki.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(syouhnTokujouRireki.getKyksyouhnrenno(), 2 ,"契約商品連番");
        exStringEquals(syouhnTokujouRireki.getHenkousikibetukey(), "2", "変更識別キー");
        IT_SyouhnTokujouRireki syouhnTokujouRireki1 = syouhnTokujouRirekiLst.get(1);
        exStringEquals(syouhnTokujouRireki1.getSyono(), syoNo5, "証券番号");
        exStringEquals(syouhnTokujouRireki1.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(syouhnTokujouRireki1.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(syouhnTokujouRireki1.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(syouhnTokujouRireki1.getKyksyouhnrenno(),  7,"契約商品連番");
        exStringEquals(syouhnTokujouRireki1.getHenkousikibetukey(), "2", "変更識別キー");
        IT_SyouhnTokujouRireki syouhnTokujouRireki2 = syouhnTokujouRirekiLst.get(2);
        exStringEquals(syouhnTokujouRireki2.getSyono(), syoNo5, "証券番号");
        exStringEquals(syouhnTokujouRireki2.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(syouhnTokujouRireki2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(syouhnTokujouRireki2.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(syouhnTokujouRireki2.getKyksyouhnrenno(), 11 ,"契約商品連番");
        exStringEquals(syouhnTokujouRireki2.getHenkousikibetukey(), "2", "変更識別キー");

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        kinou.setKinouId("EditKykSyhnRirekiTbl");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("A0000001");
        changeCurrentUser(baseUserInfo, aMUser);

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);
        kCParam.setBatchKeiyakuKihon(kykKihon);

        kinou.setKinouKbn(C_KinouKbn.BATCH);

        editKykSyhnRirekiTbl.exec(kCParam, syoNo6);

        kykKihon = hozenDomManager.getKykKihon(syoNo6);
        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnByPK(
            C_SyutkKbn.SYU, "MD11", 1, 11);

        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = kykKihon.getKhTtdkRirekiByHenkousikibetukey(
            kykSyouhn.getHenkousikibetukey()).getKykSyouhnRirekis();
        exNumericEquals(kykSyouhnRirekiLst.size(), 1 ,"契約商品履歴テーブルエンティティリストの要素数");
        IT_KykSyouhnRireki kykSyouhnRireki = kykSyouhnRirekiLst.get(0);

        exStringEquals(kykSyouhnRireki.getKbnkey(), kbnKey4, "区分キー");

        exStringEquals(kykSyouhnRireki.getSyono(), syoNo6, "証券番号");
        exStringEquals(kykSyouhnRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exNumericEquals(kykSyouhnRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRireki.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(kykSyouhnRireki.getHenkousikibetukey(), "2", "変更識別キー");
        exClassificationEquals(kykSyouhnRireki.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(kykSyouhnRireki.getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exClassificationEquals(kykSyouhnRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(kykSyouhnRireki.getSyoumetuymd(), null, "消滅日");
        exDateEquals(kykSyouhnRireki.getKouryokuhasseiymd(), null, "効力発生日");
        exDateEquals(kykSyouhnRireki.getKykymd(), null, "契約日");
        exClassificationEquals(kykSyouhnRireki.getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnRireki.getSknnkaisiymd(), null, "責任開始日");
        exDateEquals(kykSyouhnRireki.getGansknnkaisiymd(), null, "がん責任開始日");
        exDateEquals(kykSyouhnRireki.getHksknnkaisiymd(), null, "復活責任開始日");
        exDateEquals(kykSyouhnRireki.getHkgansknnkaisiymd(), null, "復活がん責任開始日");
        exClassificationEquals(kykSyouhnRireki.getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnRireki.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnRireki.getHknkkn(), 0, "保険期間");
        exNumericEquals(kykSyouhnRireki.getKyknen(), 0,"契約者年齢");
        exNumericEquals(kykSyouhnRireki.getHhknnen(), 0,"被保険者年齢");
        exNumericEquals(kykSyouhnRireki.getHrkkkn(), 0, "払込期間");

        exDateEquals(kykSyouhnRireki.getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(kykSyouhnRireki.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");

        exDateEquals(kykSyouhnRireki.getHaraimanymd(), null, "払満日");
        exDateEquals(kykSyouhnRireki.getHknkknmanryouymd(), null, "保険期間満了日");
        exClassificationEquals(kykSyouhnRireki.getKatakbn(), C_KataKbn.BLNK, "型区分");
        exClassificationEquals(kykSyouhnRireki.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(kykSyouhnRireki.getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnRireki.getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.BLNK, "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnRireki.getRokudaildkbn(), C_6daiLdKbn.BLNK, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnRireki.getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnRireki.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnRireki.getHokenryou(), BizCurrency.valueOf(0), "保険料");

        exClassificationEquals(kykSyouhnRireki.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(kykSyouhnRireki.getRyouritusdno(), "", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnRireki.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(kykSyouhnRireki.getYoteirrthendohosyurrt(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnRireki.getYtirrthndmnskaisuu(), 0, "予定利率変動見直回数");
        exClassificationEquals(kykSyouhnRireki.getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnRireki.getNenkinkkn(), 0, "年金期間");
        exNumericEquals(kykSyouhnRireki.getNkgnshosyouritu(), 0, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnRireki.getNkgnshosyougk(), BizCurrency.valueOf(0), "年金原資最低保証額");

        exStringEquals(kykSyouhnRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiLst  = kykKihon.getKhTtdkRirekiByHenkousikibetukey("2").getSyouhnTokujouRirekis();
        exNumericEquals(syouhnTokujouRirekiLst.size(), 1 ,"商品特条履歴テーブルエンティティリストの要素数");
        IT_SyouhnTokujouRireki syouhnTokujouRireki = syouhnTokujouRirekiLst.get(0);
        exStringEquals(syouhnTokujouRireki.getSyono(), syoNo6, "証券番号");
        exStringEquals(syouhnTokujouRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(syouhnTokujouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分 ");
        exNumericEquals(syouhnTokujouRireki.getSyouhnsdno(), 1 ,"商品世代番号");
        exNumericEquals(syouhnTokujouRireki.getKyksyouhnrenno(), 11 ,"契約商品連番");
        exStringEquals(syouhnTokujouRireki.getHenkousikibetukey(), "2", "変更識別キー");
        exClassificationEquals(syouhnTokujouRireki.getTkjyhyouten(), C_Tkjyhyouten.BLNK, "特条標点");
        exBizCalcbleEquals(syouhnTokujouRireki.getTkjyp(), BizCurrency.valueOf(0), "特条保険料");
        exClassificationEquals(syouhnTokujouRireki.getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "特条削減期間");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd1(), "", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn1(), C_Htnpkkn.BLNK, "不担保期間１");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd2(), "", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn2(), C_Htnpkkn.BLNK, "不担保期間２");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd3(), "", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn3(), C_Htnpkkn.BLNK, "不担保期間３");
        exStringEquals(syouhnTokujouRireki.getHtnpbuicd4(), "", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouRireki.getHtnpkkn4(), C_Htnpkkn.BLNK, "不担保期間４");
        exClassificationEquals(syouhnTokujouRireki.getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK, "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouRireki.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouRireki.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
    }
}
