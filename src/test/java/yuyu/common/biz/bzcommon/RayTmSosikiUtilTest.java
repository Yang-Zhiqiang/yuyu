package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.testinfr.TestOrder;

/**
 * 端末設置組織コードに関するユーティリティクラスのテスト用クラスです。<br />
 * 仕様は以下の通り
 * 4桁目が8の場合：拠点（""を返却）
 * 以下の場合：支社（"2999999"を返却）
 * （(端末設置組織コードの上3桁＜300 または
 *   端末設置組織コードの上3桁＝業務共通設定ファイル．支社扱い組織コードリスト） かつ
 *   端末設置組織コードの4桁目＝0 かつ
 *   端末設置組織コードの上3桁≠業務共通設定ファイル．支社例外組織コードリスト の場合）
 * 上記以外：組織コードをそのまま返却する。
 */
@RunWith(SWAKTestRunner.class)
public class RayTmSosikiUtilTest {




    @Test
    @TestOrder(10)
    public void testExec_A1(){
        assertEquals("", RayTmSosikiUtil.getTmSosikiCd(null));
    }



    @Test
    @TestOrder(20)
    public void testExec_A2(){
        assertEquals("", RayTmSosikiUtil.getTmSosikiCd(""));
    }



    @SuppressWarnings("static-access")
    @Test
    @TestOrder(10)
    public void testExec_B1(){
        RayTmSosikiUtil rayTmSosikiUtil = new RayTmSosikiUtil();
        assertEquals("", rayTmSosikiUtil.getTmSosikiCd("1238567"));
    }



    @Test
    @TestOrder(10)
    public void testExec_C1(){
        assertEquals("", RayTmSosikiUtil.getTmSosikiCd("30"));
    }


    @Test
    @TestOrder(20)
    public void testExec_C2(){
        assertEquals("300", RayTmSosikiUtil.getTmSosikiCd("300"));
    }


    @Test
    @TestOrder(30)
    public void testExec_C3(){
        assertEquals("3001", RayTmSosikiUtil.getTmSosikiCd("3001"));
    }



    @Test
    @TestOrder(40)
    public void testExec_D1(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("256");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("256");

        assertEquals("2999999", RayTmSosikiUtil.getTmSosikiCd("2990567"));
    }



    @Test
    @TestOrder(50)
    public void testExec_D2(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("256");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("256");

        assertEquals("2991567", RayTmSosikiUtil.getTmSosikiCd("2991567"));
    }



    @Test
    @TestOrder(60)
    public void testExec_D3(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("300");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("256");

        assertEquals("2999999", RayTmSosikiUtil.getTmSosikiCd("3000567"));
    }



    @Test
    @TestOrder(70)
    public void testExec_D4(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("300");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("256");


        assertEquals("3001567", RayTmSosikiUtil.getTmSosikiCd("3001567"));
    }



    @Test
    @TestOrder(80)
    public void testExec_D5(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("256");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("256");

        assertEquals("2560567", RayTmSosikiUtil.getTmSosikiCd("2560567"));
    }



    @Test
    @TestOrder(90)
    public void testExec_D6(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("256");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("256");

        assertEquals("2561567", RayTmSosikiUtil.getTmSosikiCd("2561567"));
    }



    @Test
    @TestOrder(100)
    public void testExec_D7(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("350");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("350");

        assertEquals("3010567", RayTmSosikiUtil.getTmSosikiCd("3010567"));
    }



    @Test
    @TestOrder(110)
    public void testExec_D8(){

        YuyuBizConfig.getInstance().addSisyaAtukaiSosikiCd("350");

        YuyuBizConfig.getInstance().addSisyaReigaiSosikiCd("350");

        assertEquals("3011567", RayTmSosikiUtil.getTmSosikiCd("3011567"));
    }


    @Test
    @TestOrder(120)
    public void testExec_E1(){
        assertEquals("456789", RayTmSosikiUtil.getTmSosikiCd("456789"));
    }


    @Test
    @TestOrder(130)
    public void testExec_E2(){
        assertEquals("4567890", RayTmSosikiUtil.getTmSosikiCd("45678901"));

        MockObjectManager.initialize();
    }


}
