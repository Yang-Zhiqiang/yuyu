package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SibouBasyoKbn;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSkJiyuu(CommonViewUiBeanParam, List<JT_SkJiyuu>, List<JT_SkByoumei>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSkJiyuu {

    @Inject
    private SiSetUiBean siSetUiBean;

    @Test
    @TestOrder(10)
    public void testSetSkJiyuu_A1() {

        List<JT_SkJiyuu> skJiyuuLst = new ArrayList<>();
        List<JT_SkByoumei> skByoumeiLst = new ArrayList<>();

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        siSetUiBean.setSkJiyuu(commonViewUiBeanParam, skJiyuuLst, skByoumeiLst);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSkJiyuu_A2() {

        SiSetUiBeanTest_setSkJiyuuUibean siSetUiBeanTest_setSkJiyuuUibean = SWAKInjector
            .getInstance(SiSetUiBeanTest_setSkJiyuuUibean.class);
        siSetUiBeanTest_setSkJiyuuUibean.setGeninkbn(C_GeninKbn.BLNK);

        List<JT_SkJiyuu> skJiyuuLst = new ArrayList<>();

        List<JT_SkByoumei> skByoumeiLst = null;

        siSetUiBean.setSkJiyuu(siSetUiBeanTest_setSkJiyuuUibean, skJiyuuLst, skByoumeiLst);

        exClassificationEquals(siSetUiBeanTest_setSkJiyuuUibean.getGeninkbn(), C_GeninKbn.BLNK, "原因区分");

    }

    @Test
    @TestOrder(30)
    public void testSetSkJiyuu_A3() {

        SiSetUiBeanTest_setSkJiyuuUibean siSetUiBeanTest_setSkJiyuuUibean = SWAKInjector
            .getInstance(SiSetUiBeanTest_setSkJiyuuUibean.class);
        siSetUiBeanTest_setSkJiyuuUibean.setGeninkbn(C_GeninKbn.BLNK);
        siSetUiBeanTest_setSkJiyuuUibean.setSibouymd(BizDate.valueOf(20160301));
        siSetUiBeanTest_setSkJiyuuUibean.setSiboubasyokbn(C_SibouBasyoKbn.BLNK);
        siSetUiBeanTest_setSkJiyuuUibean.setSiboubasyo("AAA");

        List<JT_SkJiyuu> skJiyuuLst = new ArrayList<>();
        JT_SkJiyuu skJiyuu = new JT_SkJiyuu();
        skJiyuu.setGeninkbn(C_GeninKbn.SP);
        skJiyuu.setSibouymd(BizDate.valueOf(20150301));
        skJiyuu.setSiboubasyokbn(C_SibouBasyoKbn.SINRYOUJYO);
        skJiyuu.setSiboubasyo("BBB");
        skJiyuuLst.add(skJiyuu);

        List<JT_SkByoumei> skByoumeiLst = new ArrayList<>();

        siSetUiBean.setSkJiyuu(siSetUiBeanTest_setSkJiyuuUibean, skJiyuuLst, skByoumeiLst);

        exClassificationEquals(siSetUiBeanTest_setSkJiyuuUibean.getGeninkbn(), C_GeninKbn.SP, "原因区分");
        exDateEquals(siSetUiBeanTest_setSkJiyuuUibean.getSibouymd(), BizDate.valueOf(20150301), "死亡日");
        exClassificationEquals(siSetUiBeanTest_setSkJiyuuUibean.getSiboubasyokbn(), C_SibouBasyoKbn.SINRYOUJYO,
            "死亡場所区分");
        exStringEquals(siSetUiBeanTest_setSkJiyuuUibean.getSiboubasyo(), "BBB", "死亡場所");
        exNumericEquals(siSetUiBeanTest_setSkJiyuuUibean.getViewSindansyoInfo2DataSourceBeanCommonParamImpl().size(),0,"請求病名表示");

    }

    @Test
    @TestOrder(40)
    public void testSetSkJiyuu_A4() {

        SiSetUiBeanTest_setSkJiyuuUibean siSetUiBeanTest_setSkJiyuuUibean = SWAKInjector
            .getInstance(SiSetUiBeanTest_setSkJiyuuUibean.class);
        siSetUiBeanTest_setSkJiyuuUibean.setGeninkbn(C_GeninKbn.BLNK);
        siSetUiBeanTest_setSkJiyuuUibean.setSibouymd(BizDate.valueOf(20160301));
        siSetUiBeanTest_setSkJiyuuUibean.setSiboubasyokbn(C_SibouBasyoKbn.BLNK);
        siSetUiBeanTest_setSkJiyuuUibean.setSiboubasyo("AAA");

        List<JT_SkJiyuu> skJiyuuLst = new ArrayList<>();
        JT_SkJiyuu skJiyuu = new JT_SkJiyuu();
        skJiyuu.setGeninkbn(C_GeninKbn.SP);
        skJiyuu.setSibouymd(BizDate.valueOf(20150301));
        skJiyuu.setSiboubasyokbn(C_SibouBasyoKbn.SINRYOUJYO);
        skJiyuu.setSiboubasyo("BBB");
        skJiyuuLst.add(skJiyuu);

        List<JT_SkByoumei> skByoumeiLst = new ArrayList<>();
        JT_SkByoumei skByoumei = new JT_SkByoumei();
        skByoumei.setByoumeitourokuno("1001");
        skByoumei.setByoumeikn("CCC");
        skByoumei.setByoumeikj("DDD");
        skByoumeiLst.add(skByoumei);
        JT_SkByoumei skByoumei1 = new JT_SkByoumei();
        skByoumei1.setByoumeitourokuno("1002");
        skByoumei1.setByoumeikn("EEE");
        skByoumei1.setByoumeikj("FFF");
        skByoumeiLst.add(skByoumei1);
        JT_SkByoumei skByoumei2 = new JT_SkByoumei();
        skByoumei2.setByoumeitourokuno("1003");
        skByoumei2.setByoumeikn("GGG");
        skByoumei2.setByoumeikj("HHH");
        skByoumeiLst.add(skByoumei2);

        siSetUiBean.setSkJiyuu(siSetUiBeanTest_setSkJiyuuUibean, skJiyuuLst, skByoumeiLst);

        exClassificationEquals(siSetUiBeanTest_setSkJiyuuUibean.getGeninkbn(), C_GeninKbn.SP, "原因区分");
        exDateEquals(siSetUiBeanTest_setSkJiyuuUibean.getSibouymd(), BizDate.valueOf(20150301), "死亡日");
        exClassificationEquals(siSetUiBeanTest_setSkJiyuuUibean.getSiboubasyokbn(), C_SibouBasyoKbn.SINRYOUJYO,
            "死亡場所区分");
        exStringEquals(siSetUiBeanTest_setSkJiyuuUibean.getSiboubasyo(), "BBB", "死亡場所");

        List<ViewSindansyoInfo2DataSourceBeanCommonParamImpl> viewSindansyoInfo2DataSourceBeanCommonParamImplLst =
            siSetUiBeanTest_setSkJiyuuUibean.getViewSindansyoInfo2DataSourceBeanCommonParamImpl();
        exNumericEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.size(),
            3, "請求病名 のデータソースのデータ");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(0).getByoumeitourokuno(), "1001",
            "病名登録番号");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(0).getByoumeikn(), "CCC", "病名（カナ）");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(0).getByoumeikj(), "DDD", "病名（漢字）");
        exClassificationEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(0).getSakujyoflg(),
            C_Delflag.BLNK, "削除フラグ");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(1).getByoumeitourokuno(), "1002",
            "病名登録番号");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(1).getByoumeikn(), "EEE", "病名（カナ）");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(1).getByoumeikj(), "FFF", "病名（漢字）");
        exClassificationEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(1).getSakujyoflg(),
            C_Delflag.BLNK, "削除フラグ");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(2).getByoumeitourokuno(), "1003",
            "病名登録番号");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(2).getByoumeikn(), "GGG", "病名（カナ）");
        exStringEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(2).getByoumeikj(), "HHH", "病名（漢字）");
        exClassificationEquals(viewSindansyoInfo2DataSourceBeanCommonParamImplLst.get(2).getSakujyoflg(),
            C_Delflag.BLNK, "削除フラグ");

    }

    @Test
    @TestOrder(50)
    public void testSetSkJiyuu_A5() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        List<JT_SkJiyuu> skJiyuuLst = new ArrayList<>();
        JT_SkJiyuu skJiyuu = new JT_SkJiyuu();
        skJiyuu.setSkno("2001");
        skJiyuuLst.add(skJiyuu);

        List<JT_SkByoumei> skByoumeiLst = new ArrayList<>();
        JT_SkByoumei skByoumei = new JT_SkByoumei();
        skByoumei.setSkno("3001");
        skByoumeiLst.add(skByoumei);

        siSetUiBean.setSkJiyuu(viewSkKihonUiBeanParamImpl, skJiyuuLst, skByoumeiLst);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }
}
