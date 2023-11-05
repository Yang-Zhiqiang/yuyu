package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込内容チェック用パラメータクラスのメソッド {@link MosnaiCheckParam} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class MosnaiCheckParamTest_getSyouhnZokusei {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Test
    @TestOrder(10)
    public void testGetSyouhnZokusei_A1() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("6666");
        syuSyouhnZokusei.setSyouhnsdno(66);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        BM_SyouhnZokusei syuSyouhnZokusei1 = mosnaiCheckParam.getSyouhnZokusei("6666", 66);

        exStringEquals(syuSyouhnZokusei1.getSyouhncd(), "6666", "商品コード");
        exNumericEquals(syuSyouhnZokusei1.getSyouhnsdno(), 66, "商品世代番号");
    }

    @Test
    @TestOrder(20)
    public void testGetSyouhnZokusei_A2() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        BM_SyouhnZokusei syuSyouhnZokusei = null;
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        BM_SyouhnZokusei syuSyouhnZokusei1 = mosnaiCheckParam.getSyouhnZokusei("6666", 66);

        exBooleanEquals(syuSyouhnZokusei1 == null, true, "商品コード");
    }

    @Test
    @TestOrder(30)
    public void testGetSyouhnZokusei_A3() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("1000");
        syouhnZokusei.setSyouhnsdno(10);
        syouhnZokuseiList.add(syouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);

        BM_SyouhnZokusei syuSyouhnZokusei = null;
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        BM_SyouhnZokusei syuSyouhnZokusei1 = mosnaiCheckParam.getSyouhnZokusei("1000", 10);

        exStringEquals(syuSyouhnZokusei1.getSyouhncd(), "1000", "商品コード");
        exNumericEquals(syuSyouhnZokusei1.getSyouhnsdno(), 10, "商品世代番号");
    }

    @Test
    @TestOrder(40)
    public void testGetSyouhnZokusei_A4() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("6666");
        syouhnZokusei.setSyouhnsdno(66);
        syouhnZokusei2.setSyouhncd("7777");
        syouhnZokusei2.setSyouhnsdno(66);
        syouhnZokusei3.setSyouhncd("8888");
        syouhnZokusei3.setSyouhnsdno(66);
        syouhnZokuseiList.add(syouhnZokusei);
        syouhnZokuseiList.add(syouhnZokusei2);
        syouhnZokuseiList.add(syouhnZokusei3);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("7777");
        syuSyouhnZokusei.setSyouhnsdno(66);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        BM_SyouhnZokusei syuSyouhnZokusei1 = mosnaiCheckParam.getSyouhnZokusei("6666", 66);

        exStringEquals(syuSyouhnZokusei1.getSyouhncd(), "6666", "商品コード");
        exNumericEquals(syuSyouhnZokusei1.getSyouhnsdno(), 66, "商品世代番号");
    }

    @Test
    @TestOrder(50)
    public void testGetSyouhnZokusei_A5() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("6666");
        syouhnZokusei.setSyouhnsdno(77);
        syouhnZokusei2.setSyouhncd("7777");
        syouhnZokusei2.setSyouhnsdno(77);
        syouhnZokusei3.setSyouhncd("8888");
        syouhnZokusei3.setSyouhnsdno(77);
        syouhnZokuseiList.add(syouhnZokusei);
        syouhnZokuseiList.add(syouhnZokusei2);
        syouhnZokuseiList.add(syouhnZokusei3);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("7777");
        syuSyouhnZokusei.setSyouhnsdno(66);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        BM_SyouhnZokusei syuSyouhnZokusei1 = mosnaiCheckParam.getSyouhnZokusei("7777", 77);

        exStringEquals(syuSyouhnZokusei1.getSyouhncd(), "7777", "商品コード");
        exNumericEquals(syuSyouhnZokusei1.getSyouhnsdno(), 77, "商品世代番号");
    }

    @Test
    @TestOrder(60)
    public void testGetSyouhnZokusei_A6() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("6666");
        syouhnZokusei.setSyouhnsdno(88);
        syouhnZokusei2.setSyouhncd("8888");
        syouhnZokusei2.setSyouhnsdno(77);
        syouhnZokusei3.setSyouhncd("8888");
        syouhnZokusei3.setSyouhnsdno(88);
        syouhnZokuseiList.add(syouhnZokusei);
        syouhnZokuseiList.add(syouhnZokusei2);
        syouhnZokuseiList.add(syouhnZokusei3);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("7777");
        syuSyouhnZokusei.setSyouhnsdno(66);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        BM_SyouhnZokusei syuSyouhnZokusei1 = mosnaiCheckParam.getSyouhnZokusei("8888", 88);

        exStringEquals(syuSyouhnZokusei1.getSyouhncd(), "8888", "商品コード");
        exNumericEquals(syuSyouhnZokusei1.getSyouhnsdno(), 88, "商品世代番号");
    }

    @Test
    @TestOrder(70)
    public void testGetSyouhnZokusei_A7() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("6666");
        syouhnZokusei.setSyouhnsdno(99);
        syouhnZokusei2.setSyouhncd("7777");
        syouhnZokusei2.setSyouhnsdno(99);
        syouhnZokusei3.setSyouhncd("8888");
        syouhnZokusei3.setSyouhnsdno(99);
        syouhnZokuseiList.add(syouhnZokusei);
        syouhnZokuseiList.add(syouhnZokusei2);
        syouhnZokuseiList.add(syouhnZokusei3);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("7777");
        syuSyouhnZokusei.setSyouhnsdno(66);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        BM_SyouhnZokusei syuSyouhnZokusei1 = mosnaiCheckParam.getSyouhnZokusei("6666", 66);

        exBooleanEquals(syuSyouhnZokusei1 == null, true, "商品コード");

    }
}