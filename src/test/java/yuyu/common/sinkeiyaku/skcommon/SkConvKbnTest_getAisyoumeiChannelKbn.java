package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約区分変換処理ユーティリティのメソッド {@link SkConvKbn#getAisyoumeiChannelKbn(C_SkeijimuKbn pSkeiJimuKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkConvKbnTest_getAisyoumeiChannelKbn {

    @Inject
    private SkConvKbn skConvKbn;

    @Test
    @Transactional
    @TestOrder(10)
    public void testGetAisyoumeiChannelKbn_A1() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.SMBC;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.SMBC, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testGetAisyoumeiChannelKbn_A2() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.MIZUHO;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.MIZUHO, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetAisyoumeiChannelKbn_A3() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.SHOP;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.SHOP, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testGetAisyoumeiChannelKbn_A4() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.YUUTYO;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.YUUSEI, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testGetAisyoumeiChannelKbn_A5() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.YUUSEI, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testGetAisyoumeiChannelKbn_A6() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.YUUSEI, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testGetAisyoumeiChannelKbn_A7() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.BLNK;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.MADOHAN, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testGetAisyoumeiChannelKbn_A8() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.MADOHAN, "愛称名チャネル区分");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testGetAisyoumeiChannelKbn_A9() {

        C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.SMTB;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(skeiJimuKbn);

        exClassificationEquals(aisyoumeiChannelKbn, C_AisyoumeiChannelKbn.MADOHAN, "愛称名チャネル区分");

    }
}
