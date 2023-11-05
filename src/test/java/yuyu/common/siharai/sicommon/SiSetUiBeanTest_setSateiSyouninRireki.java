package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewKekkaInputUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSateiSyouninRireki(CommonViewUiBeanParam, JT_SateiSyouninRireki, JT_TtdkRireki)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSateiSyouninRireki {

    @Test
    @TestOrder(10)
    public void testSetSateiSyouninRireki_A1() {

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setSateiSyouninRireki(commonViewUiBeanParam, sateiSyouninRireki, ttdkRireki);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSateiSyouninRireki_A2() {

        ViewKekkaInputUiBeanParamImpl viewKekkaInputUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKekkaInputUiBeanParamImpl.class);
        viewKekkaInputUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();

        JT_TtdkRireki ttdkRireki = null;

        SiSetUiBean.setSateiSyouninRireki(viewKekkaInputUiBeanParamImpl, sateiSyouninRireki, ttdkRireki);

        exClassificationEquals(viewKekkaInputUiBeanParamImpl.getSyorikekkakbn(), C_SyorikekkaKbn.BLNK, "処理結果区分");

    }

    @Test
    @TestOrder(30)
    public void testSetSateiSyouninRireki_A3() {

        ViewKekkaInputUiBeanParamImpl viewKekkaInputUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKekkaInputUiBeanParamImpl.class);
        viewKekkaInputUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewKekkaInputUiBeanParamImpl.setTennousakisousasyacd("AAA");
        viewKekkaInputUiBeanParamImpl.setSyanaicomment("BBB");

        JT_SateiSyouninRireki sateiSyouninRireki = null;

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSyanaicomment("CCC");

        SiSetUiBean.setSateiSyouninRireki(viewKekkaInputUiBeanParamImpl, sateiSyouninRireki, ttdkRireki);

        exClassificationEquals(viewKekkaInputUiBeanParamImpl.getSyorikekkakbn(), null, "処理結果区分");
        exStringEquals(viewKekkaInputUiBeanParamImpl.getTennousakisousasyacd(), null, "転送先操作者コード");
        exStringEquals(viewKekkaInputUiBeanParamImpl.getSyanaicomment(), "CCC", "社内用コメント");

    }

    @Test
    @TestOrder(40)
    public void testSetSateiSyouninRireki_A4() {

        ViewKekkaInputUiBeanParamImpl viewKekkaInputUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKekkaInputUiBeanParamImpl.class);
        viewKekkaInputUiBeanParamImpl.setSyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewKekkaInputUiBeanParamImpl.setTennousakisousasyacd("AAA");
        viewKekkaInputUiBeanParamImpl.setSyanaicomment("BBB");

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        sateiSyouninRireki.setTennousakisousasyacd("DDD");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSyanaicomment("CCC");

        SiSetUiBean.setSateiSyouninRireki(viewKekkaInputUiBeanParamImpl, sateiSyouninRireki, ttdkRireki);

        exClassificationEquals(viewKekkaInputUiBeanParamImpl.getSyorikekkakbn(), C_SyorikekkaKbn.TENSOU, "処理結果区分");
        exStringEquals(viewKekkaInputUiBeanParamImpl.getTennousakisousasyacd(), "DDD", "転送先操作者コード");
        exStringEquals(viewKekkaInputUiBeanParamImpl.getSyanaicomment(), "CCC", "社内用コメント");

    }

    @Test
    @TestOrder(50)
    public void testSetSateiSyouninRireki_A5() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSkno("2001");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSkno("2002");

        SiSetUiBean.setSateiSyouninRireki(viewSkKihonUiBeanParamImpl, sateiSyouninRireki, ttdkRireki);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

    @Test
    @TestOrder(60)
    public void testSetSateiSyouninRireki_A6() {

        ViewSateiKekkaUiBeanParamImpl viewSateiKekkaUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSateiKekkaUiBeanParamImpl.class);
        viewSateiKekkaUiBeanParamImpl.setSateisyorikekkakbn(C_SyorikekkaKbn.BLNK);
        viewSateiKekkaUiBeanParamImpl.setSateitennousakisousasyacd("AAA");
        viewSateiKekkaUiBeanParamImpl.setKaiketuymd(BizDate.valueOf(20160101));
        viewSateiKekkaUiBeanParamImpl.setSateisyanaicomment("BBB");

        JT_SateiSyouninRireki sateiSyouninRireki = new JT_SateiSyouninRireki();
        sateiSyouninRireki.setSyorikekkakbn(C_SyorikekkaKbn.TENSOU);
        sateiSyouninRireki.setTennousakisousasyacd("DDD");
        sateiSyouninRireki.setKaiketuymd(BizDate.valueOf(20150101));
        sateiSyouninRireki.setReportcomment("EEE");

        JT_TtdkRireki ttdkRireki = new JT_TtdkRireki();
        ttdkRireki.setSyanaicomment("CCC");

        SiSetUiBean.setSateiSyouninRireki(viewSateiKekkaUiBeanParamImpl, sateiSyouninRireki, ttdkRireki);

        exClassificationEquals(viewSateiKekkaUiBeanParamImpl.getSateisyorikekkakbn(), C_SyorikekkaKbn.TENSOU,
            "（査定用）処理結果区分");
        exStringEquals(viewSateiKekkaUiBeanParamImpl.getSateitennousakisousasyacd(), "DDD", "（査定用）転送先操作者コード");
        exDateEquals(viewSateiKekkaUiBeanParamImpl.getKaiketuymd(), BizDate.valueOf(20150101), "解決日");
        exStringEquals(viewSateiKekkaUiBeanParamImpl.getSateisyanaicomment(), "CCC", "（査定用）社内用コメント");

    }

}
