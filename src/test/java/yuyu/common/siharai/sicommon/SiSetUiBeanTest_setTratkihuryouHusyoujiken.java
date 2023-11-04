package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken.ViewTratkihuryouHusyoujikenUiBeanParamImpl;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setTratkihuryouHusyoujiken(CommonViewUiBeanParam, JT_Toriatukaifuryouinfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setTratkihuryouHusyoujiken {

    @Test
    @TestOrder(10)
    public void testSetTratkihuryouHusyoujiken_A1() {

        JT_Toriatukaifuryouinfo toriatukaifuryouinfo = new JT_Toriatukaifuryouinfo();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setTratkihuryouHusyoujiken(commonViewUiBeanParam, toriatukaifuryouinfo);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetTratkihuryouHusyoujiken_A2() {

        ViewTratkihuryouHusyoujikenUiBeanParamImpl viewTratkihuryouHusyoujikenUiBeanParamImpl = SWAKInjector
            .getInstance(ViewTratkihuryouHusyoujikenUiBeanParamImpl.class);
        viewTratkihuryouHusyoujikenUiBeanParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.BLNK);

        JT_Toriatukaifuryouinfo toriatukaifuryouinfo = null;

        SiSetUiBean.setTratkihuryouHusyoujiken(viewTratkihuryouHusyoujikenUiBeanParamImpl, toriatukaifuryouinfo);

        exClassificationEquals(viewTratkihuryouHusyoujikenUiBeanParamImpl.getTratkihuryouumukbn(), null,
            "取扱不良有無区分");

    }

    @Test
    @TestOrder(30)
    public void testSetTratkihuryouHusyoujiken_A3() {

        ViewTratkihuryouHusyoujikenUiBeanParamImpl viewTratkihuryouHusyoujikenUiBeanParamImpl = SWAKInjector
            .getInstance(ViewTratkihuryouHusyoujikenUiBeanParamImpl.class);
        viewTratkihuryouHusyoujikenUiBeanParamImpl.setTratkihuryouumukbn(C_NoinitUmuKbn.BLNK);
        viewTratkihuryouHusyoujikenUiBeanParamImpl.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.BLNK);
        viewTratkihuryouHusyoujikenUiBeanParamImpl.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.BLNK);
        viewTratkihuryouHusyoujikenUiBeanParamImpl.setTratkihuryoucomment("AAA");

        JT_Toriatukaifuryouinfo toriatukaifuryouinfo = new JT_Toriatukaifuryouinfo();
        toriatukaifuryouinfo.setTratkihuryouumukbn(C_NoinitUmuKbn.ARI);
        toriatukaifuryouinfo.setGyousinkaisouyouhikbn(C_NoinitYouhiKbn.HI);
        toriatukaifuryouinfo.setAireqdaityoukisaikbn(C_NoinitSyorizumiKbn.SYORIZUMI);
        toriatukaifuryouinfo.setTratkihuryoucomment("BBB");

        SiSetUiBean.setTratkihuryouHusyoujiken(viewTratkihuryouHusyoujikenUiBeanParamImpl, toriatukaifuryouinfo);

        exClassificationEquals(viewTratkihuryouHusyoujikenUiBeanParamImpl.getTratkihuryouumukbn(), C_NoinitUmuKbn.ARI,
            "取扱不良有無区分");
        exClassificationEquals(viewTratkihuryouHusyoujikenUiBeanParamImpl.getGyousinkaisouyouhikbn(),
            C_NoinitYouhiKbn.HI, "業審回送要否区分");
        exClassificationEquals(viewTratkihuryouHusyoujikenUiBeanParamImpl.getAireqdaityoukisaikbn(),
            C_NoinitSyorizumiKbn.SYORIZUMI, "あいリク台帳記載区分");
        exStringEquals(viewTratkihuryouHusyoujikenUiBeanParamImpl.getTratkihuryoucomment(), "BBB", "取扱不良コメント");

    }

    @Test
    @TestOrder(40)
    public void testSetTratkihuryouHusyoujiken_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_Toriatukaifuryouinfo toriatukaifuryouinfo = new JT_Toriatukaifuryouinfo();
        toriatukaifuryouinfo.setSkno("2002");

        SiSetUiBean.setTratkihuryouHusyoujiken(viewSkKihonUiBeanParamImpl, toriatukaifuryouinfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
