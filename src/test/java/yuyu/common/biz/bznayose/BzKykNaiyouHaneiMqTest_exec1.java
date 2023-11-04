package yuyu.common.biz.bznayose;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Nkshrjk;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.infrext.mq.MqApiCaller;
import yuyu.infrext.mq.MqApiCallerStubForSinkeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * PALあて契約内容反映（MQ）クラスのメソッド {@link BzKykNaiyouHaneiMq#exec(BzKykNaiyouHaneiYokenBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzKykNaiyouHaneiMqTest_exec1 {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_PALあて契約内容反映（MQ）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(MqApiCaller.class).to(MqApiCallerStubForSinkeiyaku.class);
            }
        });
    }

    @AfterClass
    public static void testClear() {
        MqApiCallerStubForSinkeiyaku.caller = null;
    }

    @Transactional
    @BeforeClass
    public static void testInit() {
        MqApiCallerStubForSinkeiyaku.caller = BzKykNaiyouHaneiMqTest_exec1.class;

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzKykNaiyouHaneiMqTest_exec1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        AS_Sequence aS_Sequence = baseDomManager.getSequence("15");
        if ( null != aS_Sequence ) {
            aS_Sequence.getSequenceValues().removeAll(aS_Sequence.getSequenceValues());
            baseDomManager.update(aS_Sequence);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
        bizDomManager.delete(bizDomManager.getAllMqBatchSosiki());
    }

    public void editYokenData (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHuho2kykno("79807111114");
        pbzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(4);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhncd("Kh01");
        pbzKykNaiyouHaneiYokenBean.setKhkykjyoutai(C_Kykjyoutai.ENTYOU);
        pbzKykNaiyouHaneiYokenBean.setKhkykymd(BizDate.valueOf("20160401"));
        pbzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetuymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setKhtsntuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234567890123L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231234567890L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setKhhrkkkn(12);
        pbzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(C_SntkhouKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhbosyuuym(BizDateYM.valueOf("201605"));
        pbzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(6);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(C_TtdktyuuiKbn.HOZENSONOTA);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUJISEISAN);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(C_TtdktyuuiKbn.KAIGAITOKOU);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhnsdno(11);
        pbzKykNaiyouHaneiYokenBean.setKhkaigomaehrtkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhpyennykntkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(12345678091L));
        pbzKykNaiyouHaneiYokenBean.setKhskjmosno("764123598");
        pbzKykNaiyouHaneiYokenBean.setKhhrkkeiro(C_Hrkkeiro.SYUUDAN);

        pbzKykNaiyouHaneiYokenBean.setSksyouhncd("Sk01");
        pbzKykNaiyouHaneiYokenBean.setSkmosymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setSkkykymd(BizDate.valueOf("20160411"));
        pbzKykNaiyouHaneiYokenBean.setSksknnkaisiymd(BizDate.valueOf("20160511"));
        pbzKykNaiyouHaneiYokenBean.setSkseiritukbn(C_SeirituKbn.SEIRITU);
        pbzKykNaiyouHaneiYokenBean.setSksrsyoriymd(BizDate.valueOf("20160416"));
        pbzKykNaiyouHaneiYokenBean.setSkmfrenflg(C_Mfrenflg.SUMI);
        pbzKykNaiyouHaneiYokenBean.setSksyono("10000000003");
        pbzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsntuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(1236543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1236543210456L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkkn(10);
        pbzKykNaiyouHaneiYokenBean.setSksntkhoukbn(C_SntkhouKbn.HJY);
        pbzKykNaiyouHaneiYokenBean.setSkbosyuuym(BizDateYM.valueOf("201604"));
        pbzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(C_MossyoumetuKbn.ENKI);
        pbzKykNaiyouHaneiYokenBean.setSksyouhnsdno(21);
        pbzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(12345678901L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkeiro(C_Hrkkeiro.SYUUDAN);

        pbzKykNaiyouHaneiYokenBean.setNksyouhncd("Nk01");
        pbzKykNaiyouHaneiYokenBean.setNknkshrjk(C_Nkshrjk.SYUURYOU);
        pbzKykNaiyouHaneiYokenBean.setNknkshrstartymd(BizDate.valueOf("20160412"));
        pbzKykNaiyouHaneiYokenBean.setNkkykymd(BizDate.valueOf("20160512"));
        pbzKykNaiyouHaneiYokenBean.setNknksyoumetucd(C_NkSyoumetuCd.NKTORIKESI);
        pbzKykNaiyouHaneiYokenBean.setNksyoumetuymd(BizDate.valueOf("20160312"));
        pbzKykNaiyouHaneiYokenBean.setNkshrtuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setNkteinksyu("1990");
        pbzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setNknkukthhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setNksyouhnsdno(31);

        pbzKykNaiyouHaneiYokenBean.setHhknnmkn("ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ");
        pbzKykNaiyouHaneiYokenBean.setHhknnmkj("被保険者名被保険者名被保険者名");
        pbzKykNaiyouHaneiYokenBean.setHhknseiymd(BizDate.valueOf("19881206"));
        pbzKykNaiyouHaneiYokenBean.setHhknsei(C_Hhknsei.FEMALE);
        pbzKykNaiyouHaneiYokenBean.setHhknyno("4354001");
        pbzKykNaiyouHaneiYokenBean.setHhknadr1kj("住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr2kj("住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr3kj("住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhkntelno("0100-6642-6870");
        pbzKykNaiyouHaneiYokenBean.setHhknsykgycd("004");
        pbzKykNaiyouHaneiYokenBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲｶｹｲﾔｸｼｬﾒｲﾅ");
        pbzKykNaiyouHaneiYokenBean.setKyknmkj("佐佐木佐佐木佐佐木佐佐木佐佐木");
        pbzKykNaiyouHaneiYokenBean.setKykseiymd(BizDate.valueOf("19900406"));
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkana("ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkanji("年金受取人名佐佐木年金受取受取");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktseiymd(BizDate.valueOf("19881112"));
        pbzKykNaiyouHaneiYokenBean.setTsinyno("4354112");
        pbzKykNaiyouHaneiYokenBean.setTsinadr1kj("通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr2kj("通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr3kj("通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsintelno("0200-0714-6642");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn1("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj1("死亡受取人花田杏子死亡受取人花");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn2("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾆ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj2("死亡受取人花田杏子死亡受取人田");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn3("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj3("死亡受取人花田杏子死亡受取人杏");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn4("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾖ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj4("死亡受取人花田杏子死亡受取人子");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkn("ｼﾃｲﾀﾞｲﾘｾｲｷｭｳｼﾞﾝﾒｲｶ");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkj("指定代理請求人指定山口三十兵衛");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkn("ｳｹｵｲｷﾞｮｼｬｳｹｵｲｷﾞｮｼｬ");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkj("契約者代理人指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn1("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj1("家族登録名１指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn2("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞﾆﾆ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj2("家族登録名２指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setBankcd("1234");
        pbzKykNaiyouHaneiYokenBean.setSitencd("123");
        pbzKykNaiyouHaneiYokenBean.setYokinkbn(C_YokinKbn.HUTUU);
        pbzKykNaiyouHaneiYokenBean.setKouzano("2345678");
        pbzKykNaiyouHaneiYokenBean.setKzmeiginmkn("ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        pbzKykNaiyouHaneiYokenBean.setDairitencd1("DLCode1");
        pbzKykNaiyouHaneiYokenBean.setBunwari1(BizNumber.valueOf(101));
        pbzKykNaiyouHaneiYokenBean.setDairitencd2("DLCode2");
        pbzKykNaiyouHaneiYokenBean.setBunwari2(BizNumber.valueOf(202));
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd1("Kanri01");
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd2("Kanri02");

    }

    public void editMqKykYokenLength (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHhknadr1kj("住所１２３４５６７８");
        pbzKykNaiyouHaneiYokenBean.setHhknadr2kj("住所２２３４５６７８");
        pbzKykNaiyouHaneiYokenBean.setHhknadr3kj("住所３２３４５６７８");
        pbzKykNaiyouHaneiYokenBean.setKhsyouhncd("Kh");
        pbzKykNaiyouHaneiYokenBean.setSksyouhncd("Sk");
        pbzKykNaiyouHaneiYokenBean.setNksyouhncd("Nk");

        pbzKykNaiyouHaneiYokenBean.setTsinadr1kj("通信先住所１２３４５");
        pbzKykNaiyouHaneiYokenBean.setTsinadr2kj("通信先住所２２３４５");
        pbzKykNaiyouHaneiYokenBean.setTsinadr3kj("通信先住所３２３４５");

        pbzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234));
        pbzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231));
        pbzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(987));
        pbzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(4567));

        pbzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(876));
        pbzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(123));
        pbzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1233));
        pbzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(1235));

        pbzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(765));
        pbzKykNaiyouHaneiYokenBean.setNkteinksyu("21");

        pbzKykNaiyouHaneiYokenBean.setHhknnmkn("ﾋﾎｹﾝｼｬ");
        pbzKykNaiyouHaneiYokenBean.setHhknnmkj("被保険者名");
        pbzKykNaiyouHaneiYokenBean.setKyknmkn("ｹｲﾔｸｼｬ");
        pbzKykNaiyouHaneiYokenBean.setKyknmkj("佐佐木");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkana("ﾈﾝｷﾝ");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkanji("年金受取人");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn1("ｼﾎﾞｳｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj1("死亡受取人１");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn2("ｼﾎﾞｳﾆ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj2("死亡受取人２");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn3("ｼﾎﾞｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj3("死亡受取人３");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn4("ｼﾎﾞｳﾖ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj4("死亡受取人４");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkn("ｼﾃｲﾀﾞｲﾘ");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkj("指定代理");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkn("ｳｹｵｲｷﾞｮ");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkj("契約者代理");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn1("ｶｿﾞｸﾀﾞｲ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj1("家族登録名１");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn2("ｶｿﾞｸﾀﾞﾆ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj2("家族登録名２");
    }

    public void editYokenData1 (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHuho2kykno("79807111114");
        pbzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(4);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhncd("Kh01");
        pbzKykNaiyouHaneiYokenBean.setKhkykjyoutai(C_Kykjyoutai.ENTYOU);
        pbzKykNaiyouHaneiYokenBean.setKhkykymd(BizDate.valueOf("20160401"));
        pbzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetuymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setKhtsntuukasyu(C_Tuukasyu.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234567890123L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231234567890L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setKhhrkkkn(12);
        pbzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(C_SntkhouKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhbosyuuym(BizDateYM.valueOf("201605"));
        pbzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(6);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(C_TtdktyuuiKbn.HOZENSONOTA);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUJISEISAN);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(C_TtdktyuuiKbn.KAIGAITOKOU);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhnsdno(11);
        pbzKykNaiyouHaneiYokenBean.setKhkaigomaehrtkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhpyennykntkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(12345678091L));
        pbzKykNaiyouHaneiYokenBean.setKhskjmosno("764123598");
        pbzKykNaiyouHaneiYokenBean.setKhhrkkeiro(C_Hrkkeiro.BLNK);

        pbzKykNaiyouHaneiYokenBean.setSksyouhncd("Sk01");
        pbzKykNaiyouHaneiYokenBean.setSkmosymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setSkkykymd(BizDate.valueOf("20160411"));
        pbzKykNaiyouHaneiYokenBean.setSksknnkaisiymd(BizDate.valueOf("20160511"));
        pbzKykNaiyouHaneiYokenBean.setSkseiritukbn(C_SeirituKbn.SEIRITU);
        pbzKykNaiyouHaneiYokenBean.setSksrsyoriymd(BizDate.valueOf("20160416"));
        pbzKykNaiyouHaneiYokenBean.setSkmfrenflg(C_Mfrenflg.SUMI);
        pbzKykNaiyouHaneiYokenBean.setSksyono("10000000003");
        pbzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsntuukasyu(C_Tuukasyu.BLNK);
        pbzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(1236543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1236543210456L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkkn(10);
        pbzKykNaiyouHaneiYokenBean.setSksntkhoukbn(C_SntkhouKbn.HJY);
        pbzKykNaiyouHaneiYokenBean.setSkbosyuuym(BizDateYM.valueOf("201604"));
        pbzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(C_MossyoumetuKbn.ENKI);
        pbzKykNaiyouHaneiYokenBean.setSksyouhnsdno(21);
        pbzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(12345678901L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkeiro(C_Hrkkeiro.BLNK);

        pbzKykNaiyouHaneiYokenBean.setNksyouhncd("Nk01");
        pbzKykNaiyouHaneiYokenBean.setNknkshrjk(C_Nkshrjk.SYUURYOU);
        pbzKykNaiyouHaneiYokenBean.setNknkshrstartymd(BizDate.valueOf("20160412"));
        pbzKykNaiyouHaneiYokenBean.setNkkykymd(BizDate.valueOf("20160512"));
        pbzKykNaiyouHaneiYokenBean.setNknksyoumetucd(C_NkSyoumetuCd.NKTORIKESI);
        pbzKykNaiyouHaneiYokenBean.setNksyoumetuymd(BizDate.valueOf("20160312"));
        pbzKykNaiyouHaneiYokenBean.setNkshrtuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setNkteinksyu("1990");
        pbzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setNknkukthhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setNksyouhnsdno(31);

        pbzKykNaiyouHaneiYokenBean.setHhknnmkn("ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ");
        pbzKykNaiyouHaneiYokenBean.setHhknnmkj("被保険者名被保険者名被保険者名");
        pbzKykNaiyouHaneiYokenBean.setHhknseiymd(BizDate.valueOf("19881206"));
        pbzKykNaiyouHaneiYokenBean.setHhknsei(C_Hhknsei.FEMALE);
        pbzKykNaiyouHaneiYokenBean.setHhknyno("4354001");
        pbzKykNaiyouHaneiYokenBean.setHhknadr1kj("住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr2kj("住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr3kj("住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhkntelno("0100-6642-6870");
        pbzKykNaiyouHaneiYokenBean.setHhknsykgycd("004");
        pbzKykNaiyouHaneiYokenBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲｶｹｲﾔｸｼｬﾒｲﾅ");
        pbzKykNaiyouHaneiYokenBean.setKyknmkj("佐佐木佐佐木佐佐木佐佐木佐佐木");
        pbzKykNaiyouHaneiYokenBean.setKykseiymd(BizDate.valueOf("19900406"));
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkana("ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkanji("年金受取人名佐佐木年金受取受取");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktseiymd(BizDate.valueOf("19881112"));
        pbzKykNaiyouHaneiYokenBean.setTsinyno("4354112");
        pbzKykNaiyouHaneiYokenBean.setTsinadr1kj("通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr2kj("通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr3kj("通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsintelno("0200-0714-6642");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn1("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj1("死亡受取人花田杏子死亡受取人花");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn2("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾆ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj2("死亡受取人花田杏子死亡受取人田");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn3("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj3("死亡受取人花田杏子死亡受取人杏");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn4("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾖ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj4("死亡受取人花田杏子死亡受取人子");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkn("ｼﾃｲﾀﾞｲﾘｾｲｷｭｳｼﾞﾝﾒｲｶ");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkj("指定代理請求人指定山口三十兵衛");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkn("ｳｹｵｲｷﾞｮｼｬｳｹｵｲｷﾞｮｼｬ");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkj("契約者代理人指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn1("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj1("家族登録名１指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn2("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞﾆﾆ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj2("家族登録名２指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setBankcd("");
        pbzKykNaiyouHaneiYokenBean.setSitencd("");
        pbzKykNaiyouHaneiYokenBean.setYokinkbn(C_YokinKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKouzano("");
        pbzKykNaiyouHaneiYokenBean.setKzmeiginmkn("ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        pbzKykNaiyouHaneiYokenBean.setDairitencd1("DLCode1");
        pbzKykNaiyouHaneiYokenBean.setBunwari1(BizNumber.valueOf(101));
        pbzKykNaiyouHaneiYokenBean.setDairitencd2("DLCode2");
        pbzKykNaiyouHaneiYokenBean.setBunwari2(BizNumber.valueOf(202));
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd1("Kanri01");
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd2("Kanri02");

    }

    public void editYokenData2 (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHuho2kykno("79807111114");
        pbzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(4);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhncd("Kh01");
        pbzKykNaiyouHaneiYokenBean.setKhkykjyoutai(C_Kykjyoutai.ENTYOU);
        pbzKykNaiyouHaneiYokenBean.setKhkykymd(BizDate.valueOf("20160401"));
        pbzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetuymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setKhtsntuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234567890123L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231234567890L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setKhhrkkkn(12);
        pbzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(C_SntkhouKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhbosyuuym(BizDateYM.valueOf("201605"));
        pbzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(6);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(C_TtdktyuuiKbn.HOZENSONOTA);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUJISEISAN);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(C_TtdktyuuiKbn.KAIGAITOKOU);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhnsdno(11);
        pbzKykNaiyouHaneiYokenBean.setKhkaigomaehrtkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhpyennykntkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(12345678091L));
        pbzKykNaiyouHaneiYokenBean.setKhskjmosno("764123598");
        pbzKykNaiyouHaneiYokenBean.setKhhrkkeiro(C_Hrkkeiro.SYUUDAN);

        pbzKykNaiyouHaneiYokenBean.setSksyouhncd("Sk01");
        pbzKykNaiyouHaneiYokenBean.setSkmosymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setSkkykymd(BizDate.valueOf("20160411"));
        pbzKykNaiyouHaneiYokenBean.setSksknnkaisiymd(BizDate.valueOf("20160511"));
        pbzKykNaiyouHaneiYokenBean.setSkseiritukbn(C_SeirituKbn.SEIRITU);
        pbzKykNaiyouHaneiYokenBean.setSksrsyoriymd(BizDate.valueOf("20160416"));
        pbzKykNaiyouHaneiYokenBean.setSkmfrenflg(C_Mfrenflg.SUMI);
        pbzKykNaiyouHaneiYokenBean.setSksyono("10000000003");
        pbzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsntuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(1236543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1236543210456L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkkn(10);
        pbzKykNaiyouHaneiYokenBean.setSksntkhoukbn(C_SntkhouKbn.HJY);
        pbzKykNaiyouHaneiYokenBean.setSkbosyuuym(BizDateYM.valueOf("201604"));
        pbzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(C_MossyoumetuKbn.ENKI);
        pbzKykNaiyouHaneiYokenBean.setSksyouhnsdno(21);
        pbzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(12345678901L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkeiro(C_Hrkkeiro.SYUUDAN);

        pbzKykNaiyouHaneiYokenBean.setNksyouhncd("Nk01");
        pbzKykNaiyouHaneiYokenBean.setNknkshrjk(C_Nkshrjk.SYUURYOU);
        pbzKykNaiyouHaneiYokenBean.setNknkshrstartymd(BizDate.valueOf("20160412"));
        pbzKykNaiyouHaneiYokenBean.setNkkykymd(BizDate.valueOf("20160512"));
        pbzKykNaiyouHaneiYokenBean.setNknksyoumetucd(C_NkSyoumetuCd.NKTORIKESI);
        pbzKykNaiyouHaneiYokenBean.setNksyoumetuymd(BizDate.valueOf("20160312"));
        pbzKykNaiyouHaneiYokenBean.setNkshrtuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setNkteinksyu("1990");
        pbzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setNknkukthhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setNksyouhnsdno(31);

        pbzKykNaiyouHaneiYokenBean.setHhknnmkn("ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ");
        pbzKykNaiyouHaneiYokenBean.setHhknnmkj("被保険者名被保険者名被保険者名");
        pbzKykNaiyouHaneiYokenBean.setHhknseiymd(BizDate.valueOf("19881206"));
        pbzKykNaiyouHaneiYokenBean.setHhknsei(C_Hhknsei.FEMALE);
        pbzKykNaiyouHaneiYokenBean.setHhknyno("4354001");
        pbzKykNaiyouHaneiYokenBean.setHhknadr1kj("住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr2kj("住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr3kj("住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhkntelno("0100-6642-6870");
        pbzKykNaiyouHaneiYokenBean.setHhknsykgycd("004");
        pbzKykNaiyouHaneiYokenBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲｶｹｲﾔｸｼｬﾒｲﾅ");
        pbzKykNaiyouHaneiYokenBean.setKyknmkj("佐佐木佐佐木佐佐木佐佐木佐佐木");
        pbzKykNaiyouHaneiYokenBean.setKykseiymd(BizDate.valueOf("19900406"));
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkana("ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkanji("年金受取人名佐佐木年金受取受取");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktseiymd(BizDate.valueOf("19881112"));
        pbzKykNaiyouHaneiYokenBean.setTsinyno("4354112");
        pbzKykNaiyouHaneiYokenBean.setTsinadr1kj("通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr2kj("通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr3kj("通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsintelno("0200-0714-6642");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn1("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj1("死亡受取人花田杏子死亡受取人花");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn2("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾆ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj2("死亡受取人花田杏子死亡受取人田");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn3("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj3("死亡受取人花田杏子死亡受取人杏");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn4("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾖ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj4("死亡受取人花田杏子死亡受取人子");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkn("ｼﾃｲﾀﾞｲﾘｾｲｷｭｳｼﾞﾝﾒｲｶ");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkj("指定代理請求人指定山口三十兵衛");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkn("ｳｹｵｲｷﾞｮｼｬｳｹｵｲｷﾞｮｼｬ");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkj("契約者代理人指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn1("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj1("家族登録名１指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn2("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞﾆﾆ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj2("家族登録名２指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setBankcd("123");
        pbzKykNaiyouHaneiYokenBean.setSitencd("2");
        pbzKykNaiyouHaneiYokenBean.setYokinkbn(C_YokinKbn.HUTUU);
        pbzKykNaiyouHaneiYokenBean.setKouzano("12345");
        pbzKykNaiyouHaneiYokenBean.setKzmeiginmkn("ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
        pbzKykNaiyouHaneiYokenBean.setDairitencd1("DLCode1");
        pbzKykNaiyouHaneiYokenBean.setBunwari1(BizNumber.valueOf(101));
        pbzKykNaiyouHaneiYokenBean.setDairitencd2("DLCode2");
        pbzKykNaiyouHaneiYokenBean.setBunwari2(BizNumber.valueOf(202));
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd1("Kanri01");
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd2("Kanri02");

    }

    public void editYokenData3 (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHuho2kykno("79807111114");
        pbzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(4);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhncd("Kh01");
        pbzKykNaiyouHaneiYokenBean.setKhkykjyoutai(C_Kykjyoutai.ENTYOU);
        pbzKykNaiyouHaneiYokenBean.setKhkykymd(BizDate.valueOf("20160401"));
        pbzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetuymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setKhtsntuukasyu(C_Tuukasyu.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234567890123L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231234567890L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setKhhrkkkn(12);
        pbzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(C_SntkhouKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhbosyuuym(BizDateYM.valueOf("201605"));
        pbzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(6);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(C_TtdktyuuiKbn.HOZENSONOTA);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUJISEISAN);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(C_TtdktyuuiKbn.KAIGAITOKOU);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhnsdno(11);
        pbzKykNaiyouHaneiYokenBean.setKhkaigomaehrtkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhpyennykntkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(12345678091L));
        pbzKykNaiyouHaneiYokenBean.setKhskjmosno("764123598");
        pbzKykNaiyouHaneiYokenBean.setKhhrkkeiro(C_Hrkkeiro.CREDIT);

        pbzKykNaiyouHaneiYokenBean.setSksyouhncd("Sk01");
        pbzKykNaiyouHaneiYokenBean.setSkmosymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setSkkykymd(BizDate.valueOf("20160411"));
        pbzKykNaiyouHaneiYokenBean.setSksknnkaisiymd(BizDate.valueOf("20160511"));
        pbzKykNaiyouHaneiYokenBean.setSkseiritukbn(C_SeirituKbn.SEIRITU);
        pbzKykNaiyouHaneiYokenBean.setSksrsyoriymd(BizDate.valueOf("20160416"));
        pbzKykNaiyouHaneiYokenBean.setSkmfrenflg(C_Mfrenflg.SUMI);
        pbzKykNaiyouHaneiYokenBean.setSksyono("10000000003");
        pbzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsntuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(1236543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1236543210456L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkkn(10);
        pbzKykNaiyouHaneiYokenBean.setSksntkhoukbn(C_SntkhouKbn.HJY);
        pbzKykNaiyouHaneiYokenBean.setSkbosyuuym(BizDateYM.valueOf("201604"));
        pbzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(C_MossyoumetuKbn.ENKI);
        pbzKykNaiyouHaneiYokenBean.setSksyouhnsdno(21);
        pbzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(12345678901L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkeiro(C_Hrkkeiro.DANTAI);

        pbzKykNaiyouHaneiYokenBean.setNksyouhncd("Nk01");
        pbzKykNaiyouHaneiYokenBean.setNknkshrjk(C_Nkshrjk.SYUURYOU);
        pbzKykNaiyouHaneiYokenBean.setNknkshrstartymd(BizDate.valueOf("20160412"));
        pbzKykNaiyouHaneiYokenBean.setNkkykymd(BizDate.valueOf("20160512"));
        pbzKykNaiyouHaneiYokenBean.setNknksyoumetucd(C_NkSyoumetuCd.NKTORIKESI);
        pbzKykNaiyouHaneiYokenBean.setNksyoumetuymd(BizDate.valueOf("20160312"));
        pbzKykNaiyouHaneiYokenBean.setNkshrtuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setNkteinksyu("1990");
        pbzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setNknkukthhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setNksyouhnsdno(31);

        pbzKykNaiyouHaneiYokenBean.setHhknnmkn("ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ");
        pbzKykNaiyouHaneiYokenBean.setHhknnmkj("被保険者名被保険者名被保険者名");
        pbzKykNaiyouHaneiYokenBean.setHhknseiymd(BizDate.valueOf("19881206"));
        pbzKykNaiyouHaneiYokenBean.setHhknsei(C_Hhknsei.FEMALE);
        pbzKykNaiyouHaneiYokenBean.setHhknyno("4354001");
        pbzKykNaiyouHaneiYokenBean.setHhknadr1kj("住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr2kj("住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr3kj("住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhkntelno("0100-6642-6870");
        pbzKykNaiyouHaneiYokenBean.setHhknsykgycd("004");
        pbzKykNaiyouHaneiYokenBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲｶｹｲﾔｸｼｬﾒｲﾅ");
        pbzKykNaiyouHaneiYokenBean.setKyknmkj("佐佐木佐佐木佐佐木佐佐木佐佐木");
        pbzKykNaiyouHaneiYokenBean.setKykseiymd(BizDate.valueOf("19900406"));
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkana("ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkanji("年金受取人名佐佐木年金受取受取");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktseiymd(BizDate.valueOf("19881112"));
        pbzKykNaiyouHaneiYokenBean.setTsinyno("4354112");
        pbzKykNaiyouHaneiYokenBean.setTsinadr1kj("通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr2kj("通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr3kj("通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsintelno("0200-0714-6642");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn1("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj1("死亡受取人花田杏子死亡受取人花");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn2("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾆ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj2("死亡受取人花田杏子死亡受取人田");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn3("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj3("死亡受取人花田杏子死亡受取人杏");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn4("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾖ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj4("死亡受取人花田杏子死亡受取人子");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkn("ｼﾃｲﾀﾞｲﾘｾｲｷｭｳｼﾞﾝﾒｲｶ");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkj("指定代理請求人指定山口三十兵衛");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkn("ｳｹｵｲｷﾞｮｼｬｳｹｵｲｷﾞｮｼｬ");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkj("契約者代理人指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn1("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj1("家族登録名１指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn2("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞﾆﾆ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj2("家族登録名２指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setBankcd("1234");
        pbzKykNaiyouHaneiYokenBean.setSitencd("123");
        pbzKykNaiyouHaneiYokenBean.setYokinkbn(C_YokinKbn.HUTUU);
        pbzKykNaiyouHaneiYokenBean.setKouzano("2345678901");
        pbzKykNaiyouHaneiYokenBean.setKzmeiginmkn("ｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝｼﾎﾞｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
        pbzKykNaiyouHaneiYokenBean.setDairitencd1("DLCode1");
        pbzKykNaiyouHaneiYokenBean.setBunwari1(BizNumber.valueOf(101));
        pbzKykNaiyouHaneiYokenBean.setDairitencd2("DLCode2");
        pbzKykNaiyouHaneiYokenBean.setBunwari2(BizNumber.valueOf(202));
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd1("Kanri01");
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd2("Kanri02");

    }

    public void editYokenData4 (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHuho2kykno("79807111114");
        pbzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(4);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhncd("Kh01");
        pbzKykNaiyouHaneiYokenBean.setKhkykjyoutai(C_Kykjyoutai.ENTYOU);
        pbzKykNaiyouHaneiYokenBean.setKhkykymd(BizDate.valueOf("20160401"));
        pbzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.MENSEKI);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetuymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setKhtsntuukasyu(null);
        pbzKykNaiyouHaneiYokenBean.setKhtsnsibous(BizCurrency.valueOf(1234567890123L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnitijip(BizCurrency.valueOf(1231234567890L));
        pbzKykNaiyouHaneiYokenBean.setKhtsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setKhhrkkkn(12);
        pbzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(C_SntkhouKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhbosyuuym(BizDateYM.valueOf("201605"));
        pbzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(6);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(C_TtdktyuuiKbn.HOZENSONOTA);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUJISEISAN);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(C_TtdktyuuiKbn.KAIGAITOKOU);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(C_TtdktyuuiKbn.ADRHUMEI);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhnsdno(11);
        pbzKykNaiyouHaneiYokenBean.setKhkaigomaehrtkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setKhpyennykntkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(BizCurrency.valueOf(12345678091L));
        pbzKykNaiyouHaneiYokenBean.setKhskjmosno("764123598");
        pbzKykNaiyouHaneiYokenBean.setKhhrkkeiro(null);

        pbzKykNaiyouHaneiYokenBean.setSksyouhncd("Sk01");
        pbzKykNaiyouHaneiYokenBean.setSkmosymd(BizDate.valueOf("20160311"));
        pbzKykNaiyouHaneiYokenBean.setSkkykymd(BizDate.valueOf("20160411"));
        pbzKykNaiyouHaneiYokenBean.setSksknnkaisiymd(BizDate.valueOf("20160511"));
        pbzKykNaiyouHaneiYokenBean.setSkseiritukbn(C_SeirituKbn.SEIRITU);
        pbzKykNaiyouHaneiYokenBean.setSksrsyoriymd(BizDate.valueOf("20160416"));
        pbzKykNaiyouHaneiYokenBean.setSkmfrenflg(C_Mfrenflg.SUMI);
        pbzKykNaiyouHaneiYokenBean.setSksyono("10000000003");
        pbzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setSktsntuukasyu(null);
        pbzKykNaiyouHaneiYokenBean.setSktsnsibous(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnitijip(BizCurrency.valueOf(1236543210123L));
        pbzKykNaiyouHaneiYokenBean.setSktsnnkgns(BizCurrency.valueOf(1236543210456L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkkn(10);
        pbzKykNaiyouHaneiYokenBean.setSksntkhoukbn(C_SntkhouKbn.HJY);
        pbzKykNaiyouHaneiYokenBean.setSkbosyuuym(BizDateYM.valueOf("201604"));
        pbzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(C_MossyoumetuKbn.ENKI);
        pbzKykNaiyouHaneiYokenBean.setSksyouhnsdno(21);
        pbzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(C_UmuKbn.ARI);
        pbzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(C_UmuKbn.NONE);
        pbzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(BizCurrency.valueOf(12345678901L));
        pbzKykNaiyouHaneiYokenBean.setSkhrkkeiro(null);

        pbzKykNaiyouHaneiYokenBean.setNksyouhncd("Nk01");
        pbzKykNaiyouHaneiYokenBean.setNknkshrjk(C_Nkshrjk.SYUURYOU);
        pbzKykNaiyouHaneiYokenBean.setNknkshrstartymd(BizDate.valueOf("20160412"));
        pbzKykNaiyouHaneiYokenBean.setNkkykymd(BizDate.valueOf("20160512"));
        pbzKykNaiyouHaneiYokenBean.setNknksyoumetucd(C_NkSyoumetuCd.NKTORIKESI);
        pbzKykNaiyouHaneiYokenBean.setNksyoumetuymd(BizDate.valueOf("20160312"));
        pbzKykNaiyouHaneiYokenBean.setNkshrtuukasyu(C_Tuukasyu.JPY);
        pbzKykNaiyouHaneiYokenBean.setNkteinksyu("1990");
        pbzKykNaiyouHaneiYokenBean.setNktsnnkgns(BizCurrency.valueOf(9876543210123L));
        pbzKykNaiyouHaneiYokenBean.setNknkukthhkndouhyouji(1);
        pbzKykNaiyouHaneiYokenBean.setNksyouhnsdno(31);

        pbzKykNaiyouHaneiYokenBean.setHhknnmkn("ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ");
        pbzKykNaiyouHaneiYokenBean.setHhknnmkj("被保険者名被保険者名被保険者名");
        pbzKykNaiyouHaneiYokenBean.setHhknseiymd(BizDate.valueOf("19881206"));
        pbzKykNaiyouHaneiYokenBean.setHhknsei(C_Hhknsei.FEMALE);
        pbzKykNaiyouHaneiYokenBean.setHhknyno("4354001");
        pbzKykNaiyouHaneiYokenBean.setHhknadr1kj("住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr2kj("住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhknadr3kj("住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setHhkntelno("0100-6642-6870");
        pbzKykNaiyouHaneiYokenBean.setHhknsykgycd("004");
        pbzKykNaiyouHaneiYokenBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲｶｹｲﾔｸｼｬﾒｲﾅ");
        pbzKykNaiyouHaneiYokenBean.setKyknmkj("佐佐木佐佐木佐佐木佐佐木佐佐木");
        pbzKykNaiyouHaneiYokenBean.setKykseiymd(BizDate.valueOf("19900406"));
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkana("ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktnmkanji("年金受取人名佐佐木年金受取受取");
        pbzKykNaiyouHaneiYokenBean.setNenkinuktseiymd(BizDate.valueOf("19881112"));
        pbzKykNaiyouHaneiYokenBean.setTsinyno("4354112");
        pbzKykNaiyouHaneiYokenBean.setTsinadr1kj("通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr2kj("通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsinadr3kj("通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０");
        pbzKykNaiyouHaneiYokenBean.setTsintelno("0200-0714-6642");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn1("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj1("死亡受取人花田杏子死亡受取人花");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn2("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾆ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj2("死亡受取人花田杏子死亡受取人田");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn3("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｻﾝ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj3("死亡受取人花田杏子死亡受取人杏");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkn4("ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾖ");
        pbzKykNaiyouHaneiYokenBean.setSbuktnmkj4("死亡受取人花田杏子死亡受取人子");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkn("ｼﾃｲﾀﾞｲﾘｾｲｷｭｳｼﾞﾝﾒｲｶ");
        pbzKykNaiyouHaneiYokenBean.setStdrsknmkj("指定代理請求人指定山口三十兵衛");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkn("ｳｹｵｲｷﾞｮｼｬｳｹｵｲｷﾞｮｼｬ");
        pbzKykNaiyouHaneiYokenBean.setKykdairinmkj("契約者代理人指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn1("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞｲﾁ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj1("家族登録名１指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkn2("ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞﾆﾆ");
        pbzKykNaiyouHaneiYokenBean.setKzktourokunmkj2("家族登録名２指定山口三十兵衛度");
        pbzKykNaiyouHaneiYokenBean.setBankcd(null);
        pbzKykNaiyouHaneiYokenBean.setSitencd(null);
        pbzKykNaiyouHaneiYokenBean.setYokinkbn(null);
        pbzKykNaiyouHaneiYokenBean.setKouzano(null);
        pbzKykNaiyouHaneiYokenBean.setKzmeiginmkn(null);
        pbzKykNaiyouHaneiYokenBean.setKzkykdoukbn(null);
        pbzKykNaiyouHaneiYokenBean.setDairitencd1("DLCode1");
        pbzKykNaiyouHaneiYokenBean.setBunwari1(BizNumber.valueOf(101));
        pbzKykNaiyouHaneiYokenBean.setDairitencd2("DLCode2");
        pbzKykNaiyouHaneiYokenBean.setBunwari2(BizNumber.valueOf(202));
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd1("Kanri01");
        pbzKykNaiyouHaneiYokenBean.setKanrisosikicd2("Kanri02");

    }

    public void editYokenKbnToNull (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(null);
        pbzKykNaiyouHaneiYokenBean.setRecordsakujyohyouji(null);
        pbzKykNaiyouHaneiYokenBean.setKhkykjyoutai(null);
        pbzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(null);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(null);
        pbzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(null);
        pbzKykNaiyouHaneiYokenBean.setKhtsntuukasyu(null);
        pbzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(null);
        pbzKykNaiyouHaneiYokenBean.setKhkykhhkndouhyouji(null);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(null);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(null);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(null);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(null);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(null);
        pbzKykNaiyouHaneiYokenBean.setKhkaigomaehrtkykumukbn(null);
        pbzKykNaiyouHaneiYokenBean.setKhpyennykntkykumukbn(null);
        pbzKykNaiyouHaneiYokenBean.setKhtsnsibous(null);
        pbzKykNaiyouHaneiYokenBean.setKhtsnitijip(null);
        pbzKykNaiyouHaneiYokenBean.setKhtsnnkgns(null);
        pbzKykNaiyouHaneiYokenBean.setKhhrkkkn(null);
        pbzKykNaiyouHaneiYokenBean.setKhsyouhnsdno(null);
        pbzKykNaiyouHaneiYokenBean.setKhtsnyennyknkgk(null);
        pbzKykNaiyouHaneiYokenBean.setKhhrkkeiro(null);

        pbzKykNaiyouHaneiYokenBean.setSkseiritukbn(null);
        pbzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(null);
        pbzKykNaiyouHaneiYokenBean.setSktsntuukasyu(null);
        pbzKykNaiyouHaneiYokenBean.setSksntkhoukbn(null);
        pbzKykNaiyouHaneiYokenBean.setSkkykhhkndouhyouji(null);
        pbzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(null);
        pbzKykNaiyouHaneiYokenBean.setSkmfrenflg(null);
        pbzKykNaiyouHaneiYokenBean.setSkkaigomaehrtkykumukbn(null);
        pbzKykNaiyouHaneiYokenBean.setSkpyennykntkykumukbn(null);
        pbzKykNaiyouHaneiYokenBean.setSktsnsibous(null);
        pbzKykNaiyouHaneiYokenBean.setSktsnitijip(null);
        pbzKykNaiyouHaneiYokenBean.setSktsnnkgns(null);
        pbzKykNaiyouHaneiYokenBean.setSkhrkkkn(null);
        pbzKykNaiyouHaneiYokenBean.setSksyouhnsdno(null);
        pbzKykNaiyouHaneiYokenBean.setSktsnyennyknkgk(null);
        pbzKykNaiyouHaneiYokenBean.setSkhrkkeiro(null);

        pbzKykNaiyouHaneiYokenBean.setNknkshrjk(null);
        pbzKykNaiyouHaneiYokenBean.setNknksyoumetucd(null);
        pbzKykNaiyouHaneiYokenBean.setNkshrtuukasyu(null);
        pbzKykNaiyouHaneiYokenBean.setNknkukthhkndouhyouji(null);
        pbzKykNaiyouHaneiYokenBean.setNktsnnkgns(null);
        pbzKykNaiyouHaneiYokenBean.setNksyouhnsdno(null);

        pbzKykNaiyouHaneiYokenBean.setYokinkbn(null);

        pbzKykNaiyouHaneiYokenBean.setHhknsei(null);
        pbzKykNaiyouHaneiYokenBean.setBunwari1(null);
        pbzKykNaiyouHaneiYokenBean.setBunwari2(null);
    }

    public void editYokenKbnToDefault (BzKykNaiyouHaneiYokenBean pbzKykNaiyouHaneiYokenBean) {

        pbzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhkykjyoutai(C_Kykjyoutai.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhyuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhsyoumetujiyuu(C_Syoumetujiyuu.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhkyktuukasyu(C_Tuukasyu.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhsntkhoukbn(C_SntkhouKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setKhttdktyuuikbn5(C_TtdktyuuiKbn.BLNK);

        pbzKykNaiyouHaneiYokenBean.setSkseiritukbn(C_SeirituKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setSkkyktuukasyu(C_Tuukasyu.BLNK);
        pbzKykNaiyouHaneiYokenBean.setSksntkhoukbn(C_SntkhouKbn.BLNK);
        pbzKykNaiyouHaneiYokenBean.setSkmossyoumetukbn(C_MossyoumetuKbn.BLNK);

        pbzKykNaiyouHaneiYokenBean.setNknkshrjk(C_Nkshrjk.BLNK);
        pbzKykNaiyouHaneiYokenBean.setNknksyoumetucd(C_NkSyoumetuCd.BLNK);
        pbzKykNaiyouHaneiYokenBean.setNkshrtuukasyu(C_Tuukasyu.BLNK);

        pbzKykNaiyouHaneiYokenBean.setHhknsei(C_Hhknsei.BLNK);
    }

    @Test
    @TestOrder(10)
    public void testExec1_A1() {

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = null;

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());
    }

    @Test
    @TestOrder(20)
    public void testExec1_A2() {

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.HUYOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);

        editYokenData(bzKykNaiyouHaneiYokenBean);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        assertNull("ＭＱ処理結果区分", bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn());
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        assertNull("契約内容反映エラー区分", bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn());
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNyKh tjtIdouNyKh = bzKykNaiyouHaneiKekkaBean.getTjtidounykh();

        exStringEquals(tjtIdouNyKh.getSyono(), "79807111114", "証券番号");
        exNumericEquals(tjtIdouNyKh.getRenno3keta(), 1, "連番(３桁)");
        exNumericEquals(tjtIdouNyKh.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyKh.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNyKh.getSyouhncd(), "Kh01", "商品コード");
        exClassificationEquals(tjtIdouNyKh.getKykjyoutai(), C_Kykjyoutai.ENTYOU, "契約状態");
        exDateEquals(tjtIdouNyKh.getKykymd(), BizDate.valueOf(20160401), "契約日");
        exClassificationEquals(tjtIdouNyKh.getYuukousyoumetukbn(), C_YuukousyoumetuKbn.YUUKOU, "有効消滅区分");
        exClassificationEquals(tjtIdouNyKh.getSyoumetujiyuu(), C_Syoumetujiyuu.MENSEKI, "消滅事由");
        exDateEquals(tjtIdouNyKh.getSyoumetuymd(), BizDate.valueOf(20160311), "消滅日");
        exClassificationEquals(tjtIdouNyKh.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNyKh.getTsnyousibous().toString(), Long.toString(1234567890123L), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNyKh.getTsnyouitijip().toString(), Long.toString(1231234567890L), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNyKh.getTsnyounkgns().toString(), Long.toString(9876543210123L), "通算用年金原資");
        exNumericEquals(tjtIdouNyKh.getHrkkkn(), 12, "払込期間");
        exClassificationEquals(tjtIdouNyKh.getSntkhoukbn(), C_SntkhouKbn.NONE, "選択方法区分");
        exDateYMEquals(tjtIdouNyKh.getBosyuuym(), BizDateYM.valueOf(201605), "募集年月");
        exNumericEquals(tjtIdouNyKh.getKykhhkndouhyouji(), 6, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn1(), C_TtdktyuuiKbn.HOZENSONOTA, "手続注意区分１");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn2(), C_TtdktyuuiKbn.SYOUMETUJISEISAN, "手続注意区分２");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn3(), C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI, "手続注意区分３");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn4(), C_TtdktyuuiKbn.KAIGAITOKOU, "手続注意区分４");
        exClassificationEquals(tjtIdouNyKh.getTtdktyuuikbn5(), C_TtdktyuuiKbn.ADRHUMEI, "手続注意区分５");
        exNumericEquals(tjtIdouNyKh.getSyouhnsdno(), 11, "商品世代番号");
        exClassificationEquals(tjtIdouNyKh.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNyKh.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNyKh.getTsnyennyknkgk(), BizCurrency.valueOf(12345678091L), "通算用円入金額");
        exStringEquals(tjtIdouNyKh.getSkjmosno(), "764123598", "新契約時申込番号");

        BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();

        exStringEquals(idouKhMeigi.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhMeigi.getRenno3keta(), 1, "連番(３桁)");
        exStringEquals(idouKhMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ", "被保険者名（カナ）");
        exStringEquals(idouKhMeigi.getHhknnmkj(), "被保険者名被保険者名被保険者名", "被保険者名（漢字）");
        exDateEquals(idouKhMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouKhMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouKhMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouKhMeigi.getHhknadr1kj(),
            "住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所１（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr2kj(),
            "住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所２（漢字）");
        exStringEquals(idouKhMeigi.getHhknadr3kj(),
            "住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所３（漢字）");
        exStringEquals(idouKhMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouKhMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouKhMeigi.getKyknmkn(), "ｹｲﾔｸｼｬﾒｲｶｹｲﾔｸｼｬﾒｲﾅ", "契約者名（カナ）");
        exStringEquals(idouKhMeigi.getKyknmkj(), "佐佐木佐佐木佐佐木佐佐木佐佐木", "契約者名（漢字）");
        exDateEquals(idouKhMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouKhMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ", "年金受取人名（カナ）");
        exStringEquals(idouKhMeigi.getNenkinuktnmkanji(), "年金受取人名佐佐木年金受取受取", "年金受取人名（漢字）");
        exDateEquals(idouKhMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouKhMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouKhMeigi.getTsinadr1kj(),
            "通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所１（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr2kj(),
            "通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所２（漢字）");
        exStringEquals(idouKhMeigi.getTsinadr3kj(),
            "通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所３（漢字）");
        exStringEquals(idouKhMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouKhMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouKhMeigi.getSbuktnmkj1(), "死亡受取人花田杏子死亡受取人花", "死亡受取人名（漢字）１");
        exStringEquals(idouKhMeigi.getSbuktnmkn2(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouKhMeigi.getSbuktnmkj2(), "死亡受取人花田杏子死亡受取人田", "死亡受取人名（漢字）２");
        exStringEquals(idouKhMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouKhMeigi.getSbuktnmkj3(), "死亡受取人花田杏子死亡受取人杏", "死亡受取人名（漢字）３");
        exStringEquals(idouKhMeigi.getSbuktnmkn4(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouKhMeigi.getSbuktnmkj4(), "死亡受取人花田杏子死亡受取人子", "死亡受取人名（漢字）４");
        exStringEquals(idouKhMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘｾｲｷｭｳｼﾞﾝﾒｲｶ", "指定代理請求人名（カナ）");
        exStringEquals(idouKhMeigi.getStdrsknmkj(), "指定代理請求人指定山口三十兵衛", "指定代理請求人名（漢字）");
        exStringEquals(idouKhMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮｼｬｳｹｵｲｷﾞｮｼｬ", "契約者代理人名（カナ）");
        exStringEquals(idouKhMeigi.getKykdairinmkj(), "契約者代理人指定山口三十兵衛度", "契約者代理人名（漢字）");
        exStringEquals(idouKhMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞｲﾁ", "家族登録名（カナ）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkj1(), "家族登録名１指定山口三十兵衛度", "家族登録名（漢字）１");
        exStringEquals(idouKhMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞﾆﾆ", "家族登録名（カナ）２");
        exStringEquals(idouKhMeigi.getKzktourokunmkj2(), "家族登録名２指定山口三十兵衛度", "家族登録名（漢字）２");


        BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();

        exStringEquals(idouKhBosyuudr.getSyono(), "79807111114", "証券番号");
        exNumericEquals(idouKhBosyuudr.getRenno3keta(), 1, "連番(３桁)");
        exStringEquals(idouKhBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouKhBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouKhBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouKhBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouKhBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");
    }

    @Test
    @TestOrder(30)
    public void testExec1_A3() {

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.HUYOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.MOSNO);

        editYokenData(bzKykNaiyouHaneiYokenBean);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        assertNull("ＭＱ処理結果区分", bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn());
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        assertNull("契約内容反映エラー区分", bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn());
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BT_TjtIdouNySk tjtIdouNySk = bzKykNaiyouHaneiKekkaBean.getTjtidounysk();

        exStringEquals(tjtIdouNySk.getMosno(), "79807111114", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番(３桁)");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "Sk01", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf(20160311), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf(20160411), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf(20160511), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf(20160416), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "10000000003", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exStringEquals(tjtIdouNySk.getTsnyousibous().toString(), Long.toString(9876543210123L), "通算用死亡Ｓ");
        exStringEquals(tjtIdouNySk.getTsnyouitijip().toString(), Long.toString(1236543210123L), "通算用一時払Ｐ");
        exStringEquals(tjtIdouNySk.getTsnyounkgns().toString(), Long.toString(1236543210456L), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 10, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf(201604), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 1, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.ENKI, "申込消滅区分");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 21, "商品世代番号");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.ARI, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(12345678901L), "通算用円入金額");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();

        exStringEquals(idouSkMeigi.getMosno(), "79807111114", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番(３桁)");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "被保険者名被保険者名被保険者名", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(),
            "住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(),
            "住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(),
            "住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "ｹｲﾔｸｼｬﾒｲｶｹｲﾔｸｼｬﾒｲﾅ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "佐佐木佐佐木佐佐木佐佐木佐佐木", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf(19900406), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "年金受取人名佐佐木年金受取受取", "年金受取人名（漢字）");
        exDateEquals(idouSkMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouSkMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(),
            "通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(),
            "通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(),
            "通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｲﾁ", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "死亡受取人花田杏子死亡受取人花", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾆ", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "死亡受取人花田杏子死亡受取人田", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｻﾝ", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "死亡受取人花田杏子死亡受取人杏", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "ｼﾎﾞｳｳｹﾄﾘｼﾞﾝｼﾎﾞｳｳｶﾖ", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "死亡受取人花田杏子死亡受取人子", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "ｼﾃｲﾀﾞｲﾘｾｲｷｭｳｼﾞﾝﾒｲｶ", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "指定代理請求人指定山口三十兵衛", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "ｳｹｵｲｷﾞｮｼｬｳｹｵｲｷﾞｮｼｬ", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "契約者代理人指定山口三十兵衛度", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞｲﾁ", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "家族登録名１指定山口三十兵衛度", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "ｶｿﾞｸﾀﾞｲﾘﾃﾝｶｿﾞｸﾀﾞﾆﾆ", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "家族登録名２指定山口三十兵衛度", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();

        exStringEquals(idouSkBosyuudr.getMosno(), "79807111114", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番(３桁)");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouSkBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouSkBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");
    }

    @Test
    @TestOrder(40)
    public void testExec1_A4() {

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.HUYOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.NKSYSYNO);

        editYokenData(bzKykNaiyouHaneiYokenBean);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        assertNull("ＭＱ処理結果区分", bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn());
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        assertNull("契約内容反映エラー区分", bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn());
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());

        BT_TjtIdouNyNk tjtIdouNyNk = bzKykNaiyouHaneiKekkaBean.getTjtidounynk();

        exStringEquals(tjtIdouNyNk.getNksysyno(), "79807111114", "年金証書番号");
        exNumericEquals(tjtIdouNyNk.getRenno3keta(), 1, "連番(３桁)");
        exNumericEquals(tjtIdouNyNk.getRecordsakujyohyouji(), 4, "レコード削除表示");
        exStringEquals(tjtIdouNyNk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNyNk.getSyouhncd(), "Nk01", "商品コード");
        exDateEquals(tjtIdouNyNk.getNkshrstartymd(), BizDate.valueOf(20160412), "年金支払開始日");
        exDateEquals(tjtIdouNyNk.getKykymd(), BizDate.valueOf(20160512), "契約日");
        exClassificationEquals(tjtIdouNyNk.getNksyoumetucd(), C_NkSyoumetuCd.NKTORIKESI, "年金消滅コード");
        exDateEquals(tjtIdouNyNk.getSyoumetuymd(), BizDate.valueOf(20160312), "消滅日");
        exClassificationEquals(tjtIdouNyNk.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exStringEquals(tjtIdouNyNk.getTeinksyu(), "1990", "定額年金年金種類");
        exStringEquals(tjtIdouNyNk.getTsnyounkgns().toString(), Long.toString(9876543210123L), "通算用年金原資");
        exNumericEquals(tjtIdouNyNk.getNkukthhkndouhyouji(), 1, "年金受取人被保険者同一表示");
        exNumericEquals(tjtIdouNyNk.getSyouhnsdno(), 31, "商品世代番号");

        BT_IdouNkMeigi idouNkMeigi = tjtIdouNyNk.getIdouNkMeigi();

        exStringEquals(idouNkMeigi.getNksysyno(), "79807111114", "年金証書番号");
        exNumericEquals(idouNkMeigi.getRenno3keta(), 1, "連番(３桁)");
        exStringEquals(idouNkMeigi.getHhknnmkn(), "ﾋﾎｹﾝｼｬｶﾅｶﾋﾎｹﾝｼｬｶﾅﾅ", "被保険者名（カナ）");
        exStringEquals(idouNkMeigi.getHhknnmkj(), "被保険者名被保険者名被保険者名", "被保険者名（漢字）");
        exDateEquals(idouNkMeigi.getHhknseiymd(), BizDate.valueOf(19881206), "被保険者生年月日");
        exClassificationEquals(idouNkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouNkMeigi.getHhknyno(), "4354001", "被保険者郵便番号");
        exStringEquals(idouNkMeigi.getHhknadr1kj(),
            "住所１２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所１（漢字）");
        exStringEquals(idouNkMeigi.getHhknadr2kj(),
            "住所２２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所２（漢字）");
        exStringEquals(idouNkMeigi.getHhknadr3kj(),
            "住所３２３４５６７８１２３４５６７８９０１２３４５６７８９０", "被保険者住所３（漢字）");
        exStringEquals(idouNkMeigi.getHhkntelno(), "0100-6642-6870", "被保険者電話番号");
        exStringEquals(idouNkMeigi.getHhknsykgycd(), "004", "被保険者職業コード");
        exStringEquals(idouNkMeigi.getNenkinuktnmkana(), "ﾈﾝｷﾝｳｹﾄﾘｶﾈﾝｷﾝｳｹﾄﾘﾅ", "年金受取人名（カナ）");
        exStringEquals(idouNkMeigi.getNenkinuktnmkanji(), "年金受取人名佐佐木年金受取受取", "年金受取人名（漢字）");
        exDateEquals(idouNkMeigi.getNenkinuktseiymd(), BizDate.valueOf(19881112), "年金受取人生年月日");
        exStringEquals(idouNkMeigi.getTsinyno(), "4354112", "通信先郵便番号");
        exStringEquals(idouNkMeigi.getTsinadr1kj(),
            "通信先住所１２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所１（漢字）");
        exStringEquals(idouNkMeigi.getTsinadr2kj(),
            "通信先住所２２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所２（漢字）");
        exStringEquals(idouNkMeigi.getTsinadr3kj(),
            "通信先住所３２３４５１２３４５６７８９０１２３４５６７８９０", "通信先住所３（漢字）");
        exStringEquals(idouNkMeigi.getTsintelno(), "0200-0714-6642", "通信先電話番号");

        BT_IdouNkBosyuudr idouNkBosyuudr = tjtIdouNyNk.getIdouNkBosyuudr();

        exStringEquals(idouNkBosyuudr.getNksysyno(), "79807111114", "年金証書番号");
        exNumericEquals(idouNkBosyuudr.getRenno3keta(), 1, "連番(３桁)");
        exStringEquals(idouNkBosyuudr.getDairitencd1(), "DLCode1", "代理店コード１");
        exStringEquals(idouNkBosyuudr.getBunwari1().toString(), "101", "分担割合１");
        exStringEquals(idouNkBosyuudr.getDairitencd2(), "DLCode2", "代理店コード2");
        exStringEquals(idouNkBosyuudr.getBunwari2().toString(), "202", "分担割合２");
        exStringEquals(idouNkBosyuudr.getKanrisosikicd1(), "Kanri01", "管理組織コード１");
        exStringEquals(idouNkBosyuudr.getKanrisosikicd2(), "Kanri02", "管理組織コード２");
    }

    @Test
    @TestOrder(50)
    public void testExec1_A5() {

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.HUYOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.BLNK);

        editYokenData(bzKykNaiyouHaneiYokenBean);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        assertNull("ＭＱ処理結果区分", bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn());
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        assertNull("契約内容反映エラー区分", bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn());
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());
    }

    @Test
    @TestOrder(60)
    public void testExec1_A6() {

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        editYokenData(bzKykNaiyouHaneiYokenBean);
        editYokenKbnToNull(bzKykNaiyouHaneiYokenBean);
        editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000010");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000010", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(70)
    public void testExec1_A7() {

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean = SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        bzKykNaiyouHaneiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.NKSYSYNO);
        editYokenData(bzKykNaiyouHaneiYokenBean);
        editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean =
            bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());
    }

    @Test
    @TestOrder(80)
    public void testExec_B1 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error1";

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean =
            SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        editYokenData(bzKykNaiyouHaneiYokenBean);
        editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean
        = bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000030");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000030", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_B2 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error2";

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean =
            SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        editYokenData(bzKykNaiyouHaneiYokenBean);
        editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean
        = bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        exStringEquals(bzKykNaiyouHaneiKekkaBean.getYoukyuuno(), "000000000000000040", "要求通番");
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000040");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000040", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.ERROR,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.HUMEI_JIDOUTRKSYOU,
            "契約内容反映エラー区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_B3 () {

        MqApiCallerStubForSinkeiyaku.SYORIPTN = "error3";

        BzKykNaiyouHaneiMq bzKykNaiyouHaneiMq = SWAKInjector.getInstance(BzKykNaiyouHaneiMq.class);

        BzKykNaiyouHaneiYokenBean bzKykNaiyouHaneiYokenBean =
            SWAKInjector.getInstance(BzKykNaiyouHaneiYokenBean.class);

        bzKykNaiyouHaneiYokenBean.setMqyouhikbn(C_YouhiKbn.YOU);
        editYokenData(bzKykNaiyouHaneiYokenBean);
        editMqKykYokenLength(bzKykNaiyouHaneiYokenBean);
        editYokenKbnToDefault(bzKykNaiyouHaneiYokenBean);

        CoreConfig.getInstance().setProductMode(ProductMode.WEB);

        BzKykNaiyouHaneiKekkaBean bzKykNaiyouHaneiKekkaBean
        = bzKykNaiyouHaneiMq.exec(bzKykNaiyouHaneiYokenBean);

        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getMqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU, "ＭＱ処理結果区分");
        assertNull("ACS基盤エラーコード", bzKykNaiyouHaneiKekkaBean.getAcserrcd());
        exClassificationEquals(bzKykNaiyouHaneiKekkaBean.getKyknaiyouhaneierrkbn(),
            C_KyknaiyouhaneiErrKbn.SYORIERROR, "契約内容反映エラー区分");
        assertNull("被保険者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getHhknnysjissikekkakbn());
        assertNull("被保険者索引名番号", bzKykNaiyouHaneiKekkaBean.getHhknsakuinmeino());
        assertNull("契約者名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getKyknysjissikekkakbn());
        assertNull("契約者索引名番号", bzKykNaiyouHaneiKekkaBean.getKyksakuinmeino());
        assertNull("年金受取人名寄せ実施結果区分", bzKykNaiyouHaneiKekkaBean.getNkuktnysjissikekkakbn());
        assertNull("年金受取人索引名番号", bzKykNaiyouHaneiKekkaBean.getNkuktsakuinnmno());
        assertNull("要求通番", bzKykNaiyouHaneiKekkaBean.getYoukyuuno());
        assertNull("当日異動内容契約保全テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounykh());
        assertNull("当日異動内容新契約テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounysk());
        assertNull("当日異動内容年金支払テーブル", bzKykNaiyouHaneiKekkaBean.getTjtidounynk());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BT_YoukyuuNoKanri youkyuuNoKanri = bizDomManager.getYoukyuuNoKanri("000000000000000050");

        exStringEquals(youkyuuNoKanri.getYoukyuuno(), "000000000000000050", "要求通番");
        exClassificationEquals(youkyuuNoKanri.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(youkyuuNoKanri.getHuho2kykno(), "79807111114", "普保Ⅱ契約番号");
        exClassificationEquals(youkyuuNoKanri.getMqkousinmqsyorikekkakbn(), C_MQSyorikekkaKbn.SEIJYOU,
            "（ＭＱ更新用）ＭＱ処理結果区分");
        exStringEquals(youkyuuNoKanri.getMqkousinacserrcd(), "", "（ＭＱ更新用）ＡＣＳ基盤エラーコード");
        exClassificationEquals(youkyuuNoKanri.getKyknaiyouhaneierrkbn(), C_KyknaiyouhaneiErrKbn.SYORIERROR,
            "契約内容反映エラー区分");
    }
}
