package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BnktAnnaiHouhouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 被災害特伸特別案内共通処理クラスのメソッド {@link CommonHsigiTksnTkbtAnnai#exec(BizDateYM, BizDateYM , BizDateYM ,
        C_Hrkkaisuu , C_TkiktbrisyuruiKbn , C_HsigiTkbtTaiouSyuruiKbn , C_BnktAnnaiHouhouKbn , BizDateYM)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonHsigiTksnTkbtAnnaiTest_exec {

    @Inject
    CommonHsigiTksnTkbtAnnai commonHsigiTksnTkbtAnnai;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202005"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.IKKATU ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 2, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.IKKATU ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202005"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.IKKATU ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 2, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202006"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202005"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 2, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202004"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 3, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202010"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202009"),
            BizDateYM.valueOf("202007"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 2, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202009"),
            BizDateYM.valueOf("202006"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 2, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202009"),
            BizDateYM.valueOf("202005"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 3, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202006"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202009"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202004"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202009"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 2, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202009"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202010"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202009"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202009"),
            BizDateYM.valueOf("202007"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.BLNK ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU2P ,
            BizDateYM.valueOf("202009"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 2, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(1).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202007"),
            BizDateYM.valueOf("202004"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.NONE ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU1P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 3, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.NONE ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU1P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202009"),
            BizDateYM.valueOf("202005"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.NONE ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU1P ,
            BizDateYM.valueOf("202008"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 3, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.NONE ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            C_BnktAnnaiHouhouKbn.BUNKATU1P ,
            BizDateYM.valueOf("202009"));

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.TEIKI_6MONTHS ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            null ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 6, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.TUKI ,
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS ,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            null ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 12, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.NEN ,
            null,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            null ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 1, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            C_Hrkkaisuu.HALFY ,
            null,
            C_HsigiTkbtTaiouSyuruiKbn.TOKUBETU1 ,
            null ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 1, "被災害特伸特別案内Beanリストの件数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutoutukisuu(), 6, "被災害特伸特別案内Beanリスト．１件目．充当月数");
        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.get(0).getJyuutounensuu(), 0, "被災害特伸特別案内Beanリスト．１件目．充当年数");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        List<HsigiTksnTkbtAnnaiBean> hsigiTksnTkbtAnnaiBeanLst = commonHsigiTksnTkbtAnnai.exec(
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            BizDateYM.valueOf("202008"),
            null ,
            null,
            C_HsigiTkbtTaiouSyuruiKbn.BLNK ,
            null ,
            null);

        exNumericEquals(hsigiTksnTkbtAnnaiBeanLst.size(), 0, "被災害特伸特別案内Beanリストの件数");
    }
}
