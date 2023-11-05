package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewippanhantei.ViewIppanhanteiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setIppanhantei(CommonViewUiBeanParam, JT_SateiIppanHanteiInfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setIppanhantei {

    @Test
    @TestOrder(10)
    public void testSetIppanhantei_A1() {

        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo = new JT_SateiIppanHanteiInfo();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setIppanhantei(commonViewUiBeanParam, sateiIppanHanteiInfo);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetIppanhantei_A2() {

        ViewIppanhanteiUiBeanParamImpl viewIppanhanteiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewIppanhanteiUiBeanParamImpl.class);
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu1("11");

        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo = null;

        SiSetUiBean.setIppanhantei(viewIppanhanteiUiBeanParamImpl, sateiIppanHanteiInfo);

        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuu1(), "", "一般判定点数１");

    }

    @Test
    @TestOrder(30)
    public void testSetIppanhantei_A3() {

        ViewIppanhanteiUiBeanParamImpl viewIppanhanteiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewIppanhanteiUiBeanParamImpl.class);
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu1("11");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment1("12");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu2("13");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment2("14");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu3("15");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment3("16");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu4("17");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment4("18");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu5("19");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment5("20");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuu6("21");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteicomment6("22");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteitensuugoukei("23");
        viewIppanhanteiUiBeanParamImpl.setIppanhanteigoukeicomment("24");

        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo = new JT_SateiIppanHanteiInfo();
        sateiIppanHanteiInfo.setIppanhanteitensuu1("51");
        sateiIppanHanteiInfo.setIppanhanteicomment1("52");
        sateiIppanHanteiInfo.setIppanhanteitensuu2("53");
        sateiIppanHanteiInfo.setIppanhanteicomment2("54");
        sateiIppanHanteiInfo.setIppanhanteitensuu3("55");
        sateiIppanHanteiInfo.setIppanhanteicomment3("56");
        sateiIppanHanteiInfo.setIppanhanteitensuu4("57");
        sateiIppanHanteiInfo.setIppanhanteicomment4("58");
        sateiIppanHanteiInfo.setIppanhanteitensuu5("59");
        sateiIppanHanteiInfo.setIppanhanteicomment5("60");
        sateiIppanHanteiInfo.setIppanhanteitensuu6("61");
        sateiIppanHanteiInfo.setIppanhanteicomment6("62");
        sateiIppanHanteiInfo.setIppanhanteitensuugoukei("63");
        sateiIppanHanteiInfo.setIppanhanteigoukeicomment("64");

        SiSetUiBean.setIppanhantei(viewIppanhanteiUiBeanParamImpl, sateiIppanHanteiInfo);

        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuu1(), "51", "一般判定点数１");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteicomment1(), "52", "一般判定コメント１");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuu2(), "53", "一般判定点数２");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteicomment2(), "54", "一般判定コメント２");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuu3(), "55", "一般判定点数３");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteicomment3(), "56", "一般判定コメント３");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuu4(), "57", "一般判定点数４");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteicomment4(), "58", "一般判定コメント４");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuu5(), "59", "一般判定点数５");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteicomment5(), "60", "一般判定コメント５");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuu6(), "61", "一般判定点数６");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteicomment6(), "62", "一般判定コメント６");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteitensuugoukei(), "63", "一般判定点数合計");
        exStringEquals(viewIppanhanteiUiBeanParamImpl.getIppanhanteigoukeicomment(), "64", "一般判定合計コメント");

    }

    @Test
    @TestOrder(40)
    public void testSetIppanhantei_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo = new JT_SateiIppanHanteiInfo();
        sateiIppanHanteiInfo.setSkno("2002");

        SiSetUiBean.setIppanhantei(viewSkKihonUiBeanParamImpl, sateiIppanHanteiInfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
