package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
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
import yuyu.def.db.dao.AS_SequenceDao;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品履歴TBL編集クラスのメソッド {@link EditKykSyhnRirekiTbl#exec(KhozenCommonParam, String, C_SyutkKbn, String, int, int, C_Syoumetujiyuu, BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykSyhnRirekiTblTest_exec_A3 {

    private final static String syoNo6 = "30806000012";

    private final static String syoNo7 = "30806000023";

    private final static String syoNo8 = "30806000034";

    @Inject
    private HozenDomManager hozenDomManager;

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
            testDataAndTblMap = testDataMaker.getInData(EditKykSyhnRirekiTblTest_exec_A3.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        AS_SequenceDao syoriCTLDao = SWAKInjector.getInstance(AS_SequenceDao.class);
        sinkeiyakuDomManager.delete(syoriCTLDao.selectAll());

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        kinou.setKinouId("EditKykSyhnRirekiTbl");

        AM_User aMUser = new AM_User();
        aMUser.setUserId("A0000001");
        changeCurrentUser(baseUserInfo, aMUser);

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        try{
            editKykSyhnRirekiTbl.exec(kCParam, syoNo6, C_SyutkKbn.SYU, "MA10",
                Integer.valueOf(1), Integer.valueOf(12), C_Syoumetujiyuu.SBKAIJO,
                BizDate.valueOf(20150718), BizDate.valueOf(20150718));
        }
        catch (CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。契約商品TBLにデータが存在しません。 証券番号＝30806000012", "エラーメッセージ");
            throw e;
        }

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
        editKykSyhnRirekiTbl.exec(kCParam, syoNo7, C_SyutkKbn.SYU, "MD11",
            Integer.valueOf(1), Integer.valueOf(12), C_Syoumetujiyuu.SBKAIJO,
            BizDate.valueOf(20150718), BizDate.valueOf(20150717));

        exNumericEquals(hozenDomManager.getKykKihon(syoNo7).getKhTtdkRirekis().get(0).getKykSyouhnRirekis().size(), 1, "契約商品履歴テーブルエンティティリストの要素数");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = hozenDomManager.getKykKihon(syoNo7).getKhTtdkRirekis().get(0).getKykSyouhnRirekis();
        IT_KykSyouhnRireki kykSyouhnRireki = kykSyouhnRirekiLst.get(0);

        exStringEquals(kykSyouhnRireki.getKbnkey(), "02", "区分キー");

        exStringEquals(kykSyouhnRireki.getSyono(), syoNo7, "証券番号");
        exStringEquals(kykSyouhnRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exNumericEquals(kykSyouhnRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRireki.getKyksyouhnrenno(), 12, "契約商品連番");
        exStringEquals(kykSyouhnRireki.getHenkousikibetukey(), "1", "変更識別キー");
        exClassificationEquals(kykSyouhnRireki.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU ,"有効消滅区分");
        exClassificationEquals(kykSyouhnRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.SBKAIJO ,"消滅事由");
        exDateEquals(kykSyouhnRireki.getSyoumetuymd(), BizDate.valueOf(20150718) ,"消滅日");
        exDateEquals(kykSyouhnRireki.getKouryokuhasseiymd(), BizDate.valueOf(20150717) ,"効力発生日");
        exClassificationEquals(kykSyouhnRireki.getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
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

        exStringEquals(kykSyouhnRireki.getGyoumuKousinKinou(), "EditKykSyhnRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnRireki.getGyoumuKousinsyaId(), "A0000001", "業務用更新者ＩＤ");

        exNumericEquals(hozenDomManager.getKykKihon(syoNo7).getKhTtdkRirekis().get(1).getKykSyouhnRirekis().size(), 1, "契約商品履歴テーブルエンティティリスト(消滅前の履歴)の要素数");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst_2 = hozenDomManager.getKykKihon(syoNo7).getKhTtdkRirekis().get(1).getKykSyouhnRirekis();
        IT_KykSyouhnRireki kykSyouhnRireki_2 = kykSyouhnRirekiLst_2.get(0);

        exStringEquals(kykSyouhnRireki_2.getKbnkey(), "02", "区分キー");

        exStringEquals(kykSyouhnRireki_2.getSyono(), syoNo7, "証券番号");
        exStringEquals(kykSyouhnRireki_2.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki_2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exNumericEquals(kykSyouhnRireki_2.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRireki_2.getKyksyouhnrenno(), 12, "契約商品連番");
        exStringEquals(kykSyouhnRireki_2.getHenkousikibetukey(), "2", "変更識別キー");
        exClassificationEquals(kykSyouhnRireki_2.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK ,"有効消滅区分");
        exClassificationEquals(kykSyouhnRireki_2.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK ,"消滅事由");
        exDateEquals(kykSyouhnRireki_2.getSyoumetuymd(), null ,"消滅日");
        exDateEquals(kykSyouhnRireki_2.getKouryokuhasseiymd(), null, "効力発生日");
        exClassificationEquals(kykSyouhnRireki_2.getKykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exDateEquals(kykSyouhnRireki_2.getKykymd(), null, "契約日");
        exClassificationEquals(kykSyouhnRireki_2.getKykymdsiteiumukbn(), C_UmuKbn.NONE, "契約日指定有無区分");
        exDateEquals(kykSyouhnRireki_2.getSknnkaisiymd(), null, "責任開始日");
        exDateEquals(kykSyouhnRireki_2.getGansknnkaisiymd(), null, "がん責任開始日");
        exDateEquals(kykSyouhnRireki_2.getHksknnkaisiymd(), null, "復活責任開始日");
        exDateEquals(kykSyouhnRireki_2.getHkgansknnkaisiymd(), null, "復活がん責任開始日");
        exClassificationEquals(kykSyouhnRireki_2.getHknkknsmnkbn(), C_HknkknsmnKbn.BLNK, "保険期間歳満期区分");
        exClassificationEquals(kykSyouhnRireki_2.getHrkkknsmnkbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exNumericEquals(kykSyouhnRireki_2.getHknkkn(), 0, "保険期間");
        exNumericEquals(kykSyouhnRireki_2.getKyknen(), 0,"契約者年齢");
        exNumericEquals(kykSyouhnRireki_2.getHhknnen(), 0,"被保険者年齢");
        exNumericEquals(kykSyouhnRireki_2.getHrkkkn(), 0, "払込期間");

        exDateEquals(kykSyouhnRireki_2.getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(kykSyouhnRireki_2.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");

        exDateEquals(kykSyouhnRireki_2.getHaraimanymd(), null, "払満日");
        exDateEquals(kykSyouhnRireki_2.getHknkknmanryouymd(), null, "保険期間満了日");
        exClassificationEquals(kykSyouhnRireki_2.getKatakbn(), C_KataKbn.BLNK, "型区分");
        exClassificationEquals(kykSyouhnRireki_2.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exClassificationEquals(kykSyouhnRireki_2.getSyukyhkinkatakbn(), C_SyukyhkinkataKbn.BLNK, "手術給付金型区分");
        exClassificationEquals(kykSyouhnRireki_2.getKhnkyhkgbairitukbn(), C_KhnkyhkgbairituKbn.BLNK, "基本給付金額倍率区分");
        exClassificationEquals(kykSyouhnRireki_2.getRokudaildkbn(), C_6daiLdKbn.BLNK, "６大生活習慣病追加給付型区分");
        exClassificationEquals(kykSyouhnRireki_2.getPmnjtkkbn(), C_PmnjtkKbn.NONE, "保険料免除特約区分");
        exBizCalcbleEquals(kykSyouhnRireki.getKihons(), BizCurrency.valueOf(0), "基本Ｓ");
        exBizCalcbleEquals(kykSyouhnRireki.getHokenryou(), BizCurrency.valueOf(0), "保険料");

        exClassificationEquals(kykSyouhnRireki_2.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(kykSyouhnRireki_2.getRyouritusdno(), "", "料率世代番号");
        exBizCalcbleEquals(kykSyouhnRireki_2.getYoteiriritu(), BizNumber.valueOf(0), "予定利率");
        exBizCalcbleEquals(kykSyouhnRireki_2.getYoteirrthendohosyurrt(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exNumericEquals(kykSyouhnRireki_2.getYtirrthndmnskaisuu(), 0, "予定利率変動見直回数");
        exClassificationEquals(kykSyouhnRireki_2.getNksyukbn(), C_Nenkinsyu.BLNK, "年金種類区分");
        exNumericEquals(kykSyouhnRireki_2.getNenkinkkn(), 0, "年金期間");
        exNumericEquals(kykSyouhnRireki_2.getNkgnshosyouritu(), 0, "年金原資最低保証率");
        exBizCalcbleEquals(kykSyouhnRireki_2.getNkgnshosyougk(), BizCurrency.valueOf(0), "年金原資最低保証額");

        exStringEquals(kykSyouhnRireki_2.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(kykSyouhnRireki_2.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiLst  = hozenDomManager.getKykKihon(syoNo7).getKhTtdkRirekis().get(0).getSyouhnTokujouRirekis();
        exNumericEquals(syouhnTokujouRirekiLst.size(), 1,"商品特条履歴テーブルエンティティリストの要素数");

        IT_SyouhnTokujouRireki syouhnTokujouRireki = syouhnTokujouRirekiLst.get(0);

        exStringEquals(syouhnTokujouRireki.getSyono(), syoNo7, "証券番号");
        exStringEquals(syouhnTokujouRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(syouhnTokujouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exNumericEquals(syouhnTokujouRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouRireki.getKyksyouhnrenno(), 12, "契約商品連番");
        exStringEquals(syouhnTokujouRireki.getHenkousikibetukey(), "1" ,"変更識別キー");
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
        exStringEquals(syouhnTokujouRireki.getGyoumuKousinKinou(), "EditKykSyhnRirekiTbl", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouRireki.getGyoumuKousinsyaId(), "A0000001", "業務用更新者ＩＤ");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiLst_2  = hozenDomManager.getKykKihon(syoNo7).getKhTtdkRirekis().get(1).getSyouhnTokujouRirekis();
        exNumericEquals(syouhnTokujouRirekiLst_2.size(), 1,"商品特条履歴テーブルエンティティリスト(消滅前の履歴)の要素数");

        IT_SyouhnTokujouRireki syouhnTokujouRireki_2 = syouhnTokujouRirekiLst_2.get(0);

        exStringEquals(syouhnTokujouRireki_2.getSyono(), syoNo7, "証券番号");
        exStringEquals(syouhnTokujouRireki_2.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(syouhnTokujouRireki_2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exNumericEquals(syouhnTokujouRireki_2.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(syouhnTokujouRireki_2.getKyksyouhnrenno(), 12, "契約商品連番");
        exStringEquals(syouhnTokujouRireki_2.getHenkousikibetukey(), "2" ,"変更識別キー");
        exClassificationEquals(syouhnTokujouRireki_2.getTkjyhyouten(), C_Tkjyhyouten.BLNK, "特条標点");
        exBizCalcbleEquals(syouhnTokujouRireki_2.getTkjyp(), BizCurrency.valueOf(0), "特条保険料");
        exClassificationEquals(syouhnTokujouRireki_2.getTkjyskgnkkn(), C_Tkjyskgnkkn.BLNK, "特条削減期間");
        exStringEquals(syouhnTokujouRireki_2.getHtnpbuicd1(), "", "不担保部位コード１");
        exClassificationEquals(syouhnTokujouRireki_2.getHtnpkkn1(), C_Htnpkkn.BLNK, "不担保期間１");
        exStringEquals(syouhnTokujouRireki_2.getHtnpbuicd2(), "", "不担保部位コード２");
        exClassificationEquals(syouhnTokujouRireki_2.getHtnpkkn2(), C_Htnpkkn.BLNK, "不担保期間２");
        exStringEquals(syouhnTokujouRireki_2.getHtnpbuicd3(), "", "不担保部位コード３");
        exClassificationEquals(syouhnTokujouRireki_2.getHtnpkkn3(), C_Htnpkkn.BLNK, "不担保期間３");
        exStringEquals(syouhnTokujouRireki_2.getHtnpbuicd4(), "", "不担保部位コード４");
        exClassificationEquals(syouhnTokujouRireki_2.getHtnpkkn4(), C_Htnpkkn.BLNK, "不担保期間４");
        exClassificationEquals(syouhnTokujouRireki_2.getTokkoudosghtnpkbn(), C_TokkoudosghtnpKbn.BLNK, "特定高度障害不担保区分");
        exStringEquals(syouhnTokujouRireki_2.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(syouhnTokujouRireki_2.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");

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

        editKykSyhnRirekiTbl.exec(kCParam, syoNo8, C_SyutkKbn.SYU, "MD11",
            Integer.valueOf(1), Integer.valueOf(11), C_Syoumetujiyuu.SBKAIJO,
            BizDate.valueOf(20150718), BizDate.valueOf(20150717));
        String sikibetuKey = kCParam.getSikibetuKey(syoNo8);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey).getKykSyouhnRirekis();
        exNumericEquals(kykSyouhnRirekiLst.size(), 1, "契約商品履歴テーブルエンティティリストの要素数");
        IT_KykSyouhnRireki kykSyouhnRireki = kykSyouhnRirekiLst.get(0);

        exStringEquals(kykSyouhnRireki.getKbnkey(), "03", "区分キー");

        exStringEquals(kykSyouhnRireki.getSyono(), syoNo8, "証券番号");
        exStringEquals(kykSyouhnRireki.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(kykSyouhnRireki.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.SYOUMETU ,"有効消滅区分");
        exClassificationEquals(kykSyouhnRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.SBKAIJO ,"消滅事由");
        exDateEquals(kykSyouhnRireki.getSyoumetuymd(), BizDate.valueOf(20150718) ,"消滅日");
        exDateEquals(kykSyouhnRireki.getKouryokuhasseiymd(), BizDate.valueOf(20150717) ,"効力発生日");
        exNumericEquals(kykSyouhnRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRireki.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(kykSyouhnRireki.getHenkousikibetukey(), "1", "変更識別キー");

        exNumericEquals(kykKihon.getKhTtdkRirekis().get(1).getKykSyouhnRirekis().size(), 1, "契約商品履歴テーブルエンティティリスト(消滅前の履歴)の要素数");
        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst_2 = kykKihon.getKhTtdkRirekis().get(1).getKykSyouhnRirekis();
        IT_KykSyouhnRireki kykSyouhnRireki_2 = kykSyouhnRirekiLst_2.get(0);

        exStringEquals(kykSyouhnRireki_2.getKbnkey(), "03", "区分キー");

        exStringEquals(kykSyouhnRireki_2.getSyono(), syoNo8, "証券番号");
        exStringEquals(kykSyouhnRireki_2.getSyouhncd(), "MD11", "商品コード");
        exClassificationEquals(kykSyouhnRireki_2.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exNumericEquals(kykSyouhnRireki_2.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(kykSyouhnRireki_2.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(kykSyouhnRireki_2.getHenkousikibetukey(), "2", "変更識別キー");

        List<IT_SyouhnTokujouRireki> syouhnTokujouRirekiLst  = kykKihon.getKhTtdkRirekiByHenkousikibetukey(sikibetuKey).getSyouhnTokujouRirekis();
        exNumericEquals(syouhnTokujouRirekiLst.size(), 0,"商品特条履歴テーブルエンティティリストの要素数");

    }

}
