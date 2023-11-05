package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.haitou.SetDNnd.DRateBean;
import yuyu.common.hozen.haitou.SetDNnd.HaitouKaisuuBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * Dレート年度回数設定のメソッド {@link SetDNnd#execCorrespoindingOverAYear(BizDate, String, BizDate, BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SetDNndTest_ExecCorrespoindingOverAYear {

    @Inject
    private SetDNnd setDNnd;

    @Test
    @TestOrder(10)
    public void testExecCorrespoindingOverAYear_A1() {

        BizDate kykymd = BizDate.valueOf(20160413);

        String pSyono = null;

        BizDate calckijyunymd = BizDate.valueOf(20170414);

        BizDate pTyouseizCalckijyunymd = BizDate.valueOf(20170414);


        List<DRateBean> lstDRateBean = setDNnd.execCorrespoindingOverAYear(kykymd, pSyono,calckijyunymd, pTyouseizCalckijyunymd);

        exBooleanEquals(lstDRateBean == null, true, "ＤレートBeanリスト");
    }

    @Test
    @TestOrder(20)
    public void testExecCorrespoindingOverAYear_A2() {

        BizDate kykymd = BizDate.valueOf(20160413);

        String pSyono = "99806001010";

        BizDate calckijyunymd = BizDate.valueOf(20170414);

        BizDate pTyouseizCalckijyunymd = BizDate.valueOf(20170414);


        List<DRateBean> lstDRateBean = setDNnd.execCorrespoindingOverAYear(kykymd, pSyono,calckijyunymd, pTyouseizCalckijyunymd);

        exNumericEquals(lstDRateBean.size(), 2, "ＤレートBeanリストの件数");

        DRateBean dRateBean1 = lstDRateBean.get(0);
        exBooleanEquals(dRateBean1.getDRateSyutokuInfoBean() == null, true, "Ｄレート取得条件Bean");
        exNumericEquals(dRateBean1.getHaitouKaisuuBeanLst().size(), 1, "配当回数Beanリストの件数");

        HaitouKaisuuBean haitouKaisuuBean11 = dRateBean1.getHaitouKaisuuBeanLst().get(0);
        exDateEquals(haitouKaisuuBean11.getKikanfrom(), BizDate.valueOf(20160413), "期間（自）");
        exDateEquals(haitouKaisuuBean11.getKikanto(), BizDate.valueOf(20170413), "期間（至）");
        exNumericEquals(haitouKaisuuBean11.getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBean11.getHaitoukaisuu(), 1, "配当回数");

        DRateBean dRateBean2 = lstDRateBean.get(1);
        exBooleanEquals(dRateBean2.getDRateSyutokuInfoBean() == null, true, "Ｄレート取得条件Bean");
        exNumericEquals(dRateBean2.getHaitouKaisuuBeanLst().size(), 1, "配当回数Beanリストの件数");

        HaitouKaisuuBean haitouKaisuuBean21 = dRateBean2.getHaitouKaisuuBeanLst().get(0);
        exDateEquals(haitouKaisuuBean21.getKikanfrom(), BizDate.valueOf(20170413), "期間（自）");
        exDateEquals(haitouKaisuuBean21.getKikanto(), BizDate.valueOf(20170414), "期間（至）");
        exNumericEquals(haitouKaisuuBean21.getKeikamon(), 0, "経過月数");
        exNumericEquals(haitouKaisuuBean21.getHaitoukaisuu(), 2, "配当回数");

    }

    @Test
    @TestOrder(30)
    public void testExecCorrespoindingOverAYear_A3() {

        BizDate kykymd = BizDate.valueOf(20160414);

        String pSyono = "99806001010";

        BizDate calckijyunymd = BizDate.valueOf(20170414);

        BizDate pTyouseizCalckijyunymd = BizDate.valueOf(20170414);


        List<DRateBean> lstDRateBean = setDNnd.execCorrespoindingOverAYear(kykymd, pSyono,calckijyunymd, pTyouseizCalckijyunymd);

        exNumericEquals(lstDRateBean.size(), 1, "ＤレートBeanリストの件数");

        DRateBean dRateBean1 = lstDRateBean.get(0);
        exBooleanEquals(dRateBean1.getDRateSyutokuInfoBean() == null, true, "Ｄレート取得条件Bean");
        exNumericEquals(dRateBean1.getHaitouKaisuuBeanLst().size(), 1, "配当回数Beanリストの件数");

        HaitouKaisuuBean haitouKaisuuBean1 = dRateBean1.getHaitouKaisuuBeanLst().get(0);
        exDateEquals(haitouKaisuuBean1.getKikanfrom(), BizDate.valueOf(20160414), "期間（自）");
        exDateEquals(haitouKaisuuBean1.getKikanto(), BizDate.valueOf(20170414), "期間（至）");
        exNumericEquals(haitouKaisuuBean1.getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBean1.getHaitoukaisuu(), 1, "配当回数");

    }

    @Test
    @TestOrder(40)
    public void testExecCorrespoindingOverAYear_A4() {

        BizDate kykymd = BizDate.valueOf(20160415);

        String pSyono = "99806001010";

        BizDate calckijyunymd = BizDate.valueOf(20170414);

        BizDate pTyouseizCalckijyunymd = BizDate.valueOf(20170414);


        List<DRateBean> lstDRateBean = setDNnd.execCorrespoindingOverAYear(kykymd, pSyono,calckijyunymd, pTyouseizCalckijyunymd);

        DRateBean dRateBean1 = lstDRateBean.get(0);
        exBooleanEquals(dRateBean1.getDRateSyutokuInfoBean() == null, true, "Ｄレート取得条件Bean");
        exNumericEquals(dRateBean1.getHaitouKaisuuBeanLst().size(), 1, "配当回数Beanリストの件数");

        HaitouKaisuuBean haitouKaisuuBean1 = dRateBean1.getHaitouKaisuuBeanLst().get(0);
        exDateEquals(haitouKaisuuBean1.getKikanfrom(), BizDate.valueOf(20160415), "期間（自）");
        exDateEquals(haitouKaisuuBean1.getKikanto(), BizDate.valueOf(20170414), "期間（至）");
        exNumericEquals(haitouKaisuuBean1.getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBean1.getHaitoukaisuu(), 1, "配当回数");
    }

    @Test
    @TestOrder(50)
    public void testExecCorrespoindingOverAYear_A5() {

        BizDate kykymd = BizDate.valueOf(20140414);

        String pSyono = "99806001010";

        BizDate calckijyunymd = BizDate.valueOf(20170414);

        BizDate pTyouseizCalckijyunymd = BizDate.valueOf(20170414);


        List<DRateBean> lstDRateBean = setDNnd.execCorrespoindingOverAYear(kykymd, pSyono,calckijyunymd, pTyouseizCalckijyunymd);

        exNumericEquals(lstDRateBean.size(), 3, "ＤレートBeanリストの件数");

        DRateBean dRateBean1 = lstDRateBean.get(0);
        exBooleanEquals(dRateBean1.getDRateSyutokuInfoBean() == null, true, "Ｄレート取得条件Bean");
        exNumericEquals(dRateBean1.getHaitouKaisuuBeanLst().size(), 1, "配当回数Beanリストの件数");

        HaitouKaisuuBean haitouKaisuuBean1 = dRateBean1.getHaitouKaisuuBeanLst().get(0);
        exDateEquals(haitouKaisuuBean1.getKikanfrom(), BizDate.valueOf(20140414), "期間（自）");
        exDateEquals(haitouKaisuuBean1.getKikanto(), BizDate.valueOf(20150414), "期間（至）");
        exNumericEquals(haitouKaisuuBean1.getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBean1.getHaitoukaisuu(), 1, "配当回数");

        DRateBean dRateBean2 = lstDRateBean.get(1);
        exBooleanEquals(dRateBean2.getDRateSyutokuInfoBean() == null, true, "Ｄレート取得条件Bean");
        exNumericEquals(dRateBean2.getHaitouKaisuuBeanLst().size(), 1, "配当回数Beanリストの件数");

        HaitouKaisuuBean haitouKaisuuBean2 = dRateBean2.getHaitouKaisuuBeanLst().get(0);
        exDateEquals(haitouKaisuuBean2.getKikanfrom(), BizDate.valueOf(20150414), "期間（自）");
        exDateEquals(haitouKaisuuBean2.getKikanto(), BizDate.valueOf(20160414), "期間（至）");
        exNumericEquals(haitouKaisuuBean2.getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBean2.getHaitoukaisuu(), 2, "配当回数");

        DRateBean dRateBean3 = lstDRateBean.get(2);
        exBooleanEquals(dRateBean3.getDRateSyutokuInfoBean() == null, true, "Ｄレート取得条件Bean");
        exNumericEquals(dRateBean3.getHaitouKaisuuBeanLst().size(), 1, "配当回数Beanリストの件数");

        HaitouKaisuuBean haitouKaisuuBean3 = dRateBean3.getHaitouKaisuuBeanLst().get(0);
        exDateEquals(haitouKaisuuBean3.getKikanfrom(), BizDate.valueOf(20160414), "期間（自）");
        exDateEquals(haitouKaisuuBean3.getKikanto(), BizDate.valueOf(20170414), "期間（至）");
        exNumericEquals(haitouKaisuuBean3.getKeikamon(), 12, "経過月数");
        exNumericEquals(haitouKaisuuBean3.getHaitoukaisuu(), 3, "配当回数");
    }
}
