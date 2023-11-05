package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsonotachecksibou.ViewSonotaCheckSibouUiBeanParamImpl;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSonotaCheckSibou(CommonViewUiBeanParam, JT_SibouSateiChkInfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSonotaCheckSibou {

    @Test
    @TestOrder(10)
    public void testSetSonotaCheckSibou_A1() {

        JT_SibouSateiChkInfo sibouSateiChkInfo = new JT_SibouSateiChkInfo();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setSonotaCheckSibou(commonViewUiBeanParam, sibouSateiChkInfo);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSonotaCheckSibou_A2() {

        ViewSonotaCheckSibouUiBeanParamImpl viewSonotaCheckSibouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSonotaCheckSibouUiBeanParamImpl.class);
        viewSonotaCheckSibouUiBeanParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.BLNK);

        JT_SibouSateiChkInfo sibouSateiChkInfo = null;

        SiSetUiBean.setSonotaCheckSibou(viewSonotaCheckSibouUiBeanParamImpl, sibouSateiChkInfo);

        exClassificationEquals(viewSonotaCheckSibouUiBeanParamImpl.getBengosikenkaiumukbn(), null,
            "弁護士見解有無区分");

    }

    @Test
    @TestOrder(30)
    public void testSetSonotaCheckSibou_A3() {

        ViewSonotaCheckSibouUiBeanParamImpl viewSonotaCheckSibouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSonotaCheckSibouUiBeanParamImpl.class);
        viewSonotaCheckSibouUiBeanParamImpl.setBengosikenkaiumukbn(C_NoinitUmuKbn.BLNK);
        viewSonotaCheckSibouUiBeanParamImpl.setKujyouumukbn(C_NoinitUmuKbn.BLNK);
        viewSonotaCheckSibouUiBeanParamImpl.setJimumissumukbn(C_NoinitUmuKbn.BLNK);
        viewSonotaCheckSibouUiBeanParamImpl.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.BLNK);

        JT_SibouSateiChkInfo sibouSateiChkInfo = new JT_SibouSateiChkInfo();
        sibouSateiChkInfo.setBengosikenkaiumukbn(C_NoinitUmuKbn.ARI);
        sibouSateiChkInfo.setKujyouumukbn(C_NoinitUmuKbn.NONE);
        sibouSateiChkInfo.setJimumissumukbn(C_NoinitUmuKbn.ARI);
        sibouSateiChkInfo.setKyhgksitukaisouyouhikbn(C_NoinitYouhiKbn.HI);

        SiSetUiBean.setSonotaCheckSibou(viewSonotaCheckSibouUiBeanParamImpl, sibouSateiChkInfo);

        exClassificationEquals(viewSonotaCheckSibouUiBeanParamImpl.getBengosikenkaiumukbn(), C_NoinitUmuKbn.ARI,
            "弁護士見解有無区分");
        exClassificationEquals(viewSonotaCheckSibouUiBeanParamImpl.getKujyouumukbn(),
            C_NoinitUmuKbn.NONE, "苦情有無区分");
        exClassificationEquals(viewSonotaCheckSibouUiBeanParamImpl.getJimumissumukbn(),
            C_NoinitUmuKbn.ARI, "事務ミス有無区分");
        exClassificationEquals(viewSonotaCheckSibouUiBeanParamImpl.getKyhgksitukaisouyouhikbn(), C_NoinitYouhiKbn.HI,
            "給付金室回送要否区分");

    }

    @Test
    @TestOrder(40)
    public void testSetSonotaCheckSibou_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SibouSateiChkInfo sibouSateiChkInfo = new JT_SibouSateiChkInfo();
        sibouSateiChkInfo.setSkno("2002");

        SiSetUiBean.setSonotaCheckSibou(viewSkKihonUiBeanParamImpl, sibouSateiChkInfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
