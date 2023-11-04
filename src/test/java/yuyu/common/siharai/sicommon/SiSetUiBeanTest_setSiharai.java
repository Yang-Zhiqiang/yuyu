package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSiharai(CommonViewUiBeanParam, JT_SiRireki, JT_Sk)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSiharai {

    @Test
    @TestOrder(10)
    public void testSetSiharai_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SiRireki siRireki = new JT_SiRireki();
        JT_Sk sk = new JT_Sk();
        SiSetUiBean.setSiharai(commonViewUiBeanParam, siRireki, sk);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSiharai_A2() {

        ViewSiharaiInfoUiBeanParamImpl viewSiharaiInfoUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSiharaiInfoUiBeanParamImpl.class);
        viewSiharaiInfoUiBeanParamImpl.setShrtuukasyu(C_Tuukasyu.BLNK);
        viewSiharaiInfoUiBeanParamImpl.setShrkwsratekjnymd(BizDate.valueOf(20160314));
        viewSiharaiInfoUiBeanParamImpl.setShrkwsrate(BizNumber.valueOf(10));
        viewSiharaiInfoUiBeanParamImpl.setDispsyoruiukeymd(BizDate.valueOf(20160315));
        viewSiharaiInfoUiBeanParamImpl.setDisphubikanryouymd(BizDate.valueOf(20160316));
        viewSiharaiInfoUiBeanParamImpl.setShrymd(BizDate.valueOf(20160317));
        viewSiharaiInfoUiBeanParamImpl.setDispsinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiInfoUiBeanParamImpl.setDisprkktydnnissuu(11);

        JT_SiRireki siRireki = new JT_SiRireki();
        siRireki.setTyakkinymd(BizDate.valueOf(20150317));

        JT_Sk sk = new JT_Sk();
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setShrkwsratekjnymd(BizDate.valueOf(20150314));
        sk.setShrkwsrate(BizNumber.valueOf(12));
        sk.setSyoruiukeymd(BizDate.valueOf(20150315));
        sk.setHubikanryouymd(BizDate.valueOf(20150316));
        sk.setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        sk.setRikoukityuutuudannissuu(13);

        SiSetUiBean.setSiharai(viewSiharaiInfoUiBeanParamImpl, siRireki, sk);

        exClassificationEquals(viewSiharaiInfoUiBeanParamImpl.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getShrkwsratekjnymd(), BizDate.valueOf(20150314), "支払時為替レート基準日");
        exBizCalcbleEquals(viewSiharaiInfoUiBeanParamImpl.getShrkwsrate(), BizNumber.valueOf(12), "支払時為替レート");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getDispsyoruiukeymd(), BizDate.valueOf(20150315), "（表示用）書類受付日");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getDisphubikanryouymd(), BizDate.valueOf(20150316), "（表示用）不備完了日");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getShrymd(), BizDate.valueOf(20150317), "支払日");
        exClassificationEquals(viewSiharaiInfoUiBeanParamImpl.getDispsinsagendokknkbn(), C_SinsaGendoKknKbn.BD5,
                "（表示用）審査限度期間区分");
        exNumericEquals(viewSiharaiInfoUiBeanParamImpl.getDisprkktydnnissuu(), 13, "（表示用）履行期中断日数");

    }

    @Test
    @TestOrder(30)
    public void testSetSiharai_A3() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
                .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SiRireki siRireki = new JT_SiRireki();
        siRireki.setSkno("2001");
        JT_Sk sk = new JT_Sk();
        sk.setSkno("2003");

        SiSetUiBean.setSiharai(viewSkKihonUiBeanParamImpl, siRireki, sk);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
