package yuyu.app.base.system.rolekensaku;

import static yuyu.app.base.system.rolekensaku.GenRoleKensakuConstants.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.ui.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


@RunWith(OrderedRunner.class)
public class RoleKensakuTest extends AbstractTest {

    @Inject
    private RoleKensakuAction action;

    @Inject
    private RoleKensakuUiBean uiBean;


    @Test
    @TestOrder(10)
    public void testInputKey_Case1(){

        String forward = init();

        boolean existRoleInfo = false;
        DataSource<RoleInfoDataSourceBean> dataSourceBean = uiBean.getRoleInfoDataSource();
        if (dataSourceBean.size() == 0) {
            existRoleInfo = true;
        }

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exStringEquals(uiBean.getRoleCd()                   , null                                         , "ロールコード");
        exStringEquals(uiBean.getRoleNm()                   , null                                         , "ロール名");
        exBooleanEquals(existRoleInfo                       , true                                         , "ロール情報データソース");
    }

    @Test
    @TestOrder(20)
    public void testInputKey_Case2(){

        String roleCd = "1000";
        String roleNm = null;

        String forward = inputKeySearch(roleCd, roleNm);


        DataSource<RoleInfoDataSourceBean> dataSourceBean = uiBean.getRoleInfoDataSource();
        List<RoleInfoDataSourceBean> list = dataSourceBean.getAllData();

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exNumericEquals(dataSourceBean.size()               , 2                                            , "検索結果件数");
        exStringEquals(uiBean.getRoleCd()                   , roleCd                                       , "ロールコード");
        exStringEquals(uiBean.getRoleNm()                   , roleNm                                       , "ロール名");
        exStringEquals(list.get(0).getRoleCd()              , "1000"                                       , "検索結果1件目（ロールコード）");
        exStringEquals(list.get(0).getRoleNm()              , "ＢＣ"                                       , "検索結果1件目（ロール名）");
        exStringEquals(list.get(1).getRoleCd()              , "10001"                                      , "検索結果2件目（ロールコード）");
        exStringEquals(list.get(1).getRoleNm()              , "ＢＣＤ"                                     , "検索結果2件目（ロール名）");
    }

    @Test
    @TestOrder(30)
    public void testInputKey_Case3(){

        String roleCd = null;
        String roleNm = "ＢＣ";

        String forward = inputKeySearch(roleCd, roleNm);

        DataSource<RoleInfoDataSourceBean> dataSourceBean = uiBean.getRoleInfoDataSource();
        List<RoleInfoDataSourceBean> list = dataSourceBean.getAllData();

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exNumericEquals(dataSourceBean.size()               , 4                                            , "検索結果件数");
        exStringEquals(uiBean.getRoleCd()                   , roleCd                                       , "ロールコード");
        exStringEquals(uiBean.getRoleNm()                   , roleNm                                       , "ロール名");
        exStringEquals(list.get(0).getRoleCd()              , "1000"                                       , "検索結果1件目（ロールコード）");
        exStringEquals(list.get(0).getRoleNm()              , "ＢＣ"                                       , "検索結果1件目（ロール名）");
        exStringEquals(list.get(1).getRoleCd()              , "10001"                                      , "検索結果2件目（ロールコード）");
        exStringEquals(list.get(1).getRoleNm()              , "ＢＣＤ"                                     , "検索結果2件目（ロール名）");
        exStringEquals(list.get(2).getRoleCd()              , "11000"                                      , "検索結果3件目（ロールコード）");
        exStringEquals(list.get(2).getRoleNm()              , "ＡＢＣ"                                     , "検索結果3件目（ロール名）");
        exStringEquals(list.get(3).getRoleCd()              , "110001"                                     , "検索結果4件目（ロールコード）");
        exStringEquals(list.get(3).getRoleNm()              , "ＡＢＣＤ"                                   , "検索結果4件目（ロール名）");
    }

    @Test
    @TestOrder(40)
    public void testInputKey_Case4(){

        String roleCd = "1000";
        String roleNm = "ＣＤ";

        String forward = inputKeySearch(roleCd, roleNm);

        DataSource<RoleInfoDataSourceBean> dataSourceBean = uiBean.getRoleInfoDataSource();
        List<RoleInfoDataSourceBean> list = dataSourceBean.getAllData();

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exNumericEquals(dataSourceBean.size()               , 1                                            , "検索結果件数");
        exStringEquals(uiBean.getRoleCd()                   , roleCd                                       , "ロールコード");
        exStringEquals(uiBean.getRoleNm()                   , roleNm                                       , "ロール名");
        exStringEquals(list.get(0).getRoleCd()              , "10001"                                      , "検索結果1件目（ロールコード）");
        exStringEquals(list.get(0).getRoleNm()              , "ＢＣＤ"                                     , "検索結果1件目（ロール名）");
    }

    @Test
    @TestOrder(50)
    public void testInputKey_Case5(){

        String roleCd = "XXX";
        String roleNm = "ＸＸＸ";
        try {

            inputKeySearch(roleCd, roleNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage(),   "指定された抽出条件に合致するロールコードは存在しません。"          , "メッセージ");
            exStringEquals(uiBean.getRoleCd()                   , roleCd                                       , "ロールコード");
            exStringEquals(uiBean.getRoleNm()                   , roleNm                                       , "ロール名");
        }
    }

    @Test
    @TestOrder(60)
    public void testInputKey_Case6(){

        String roleCd = null;
        String roleNm = null;
        try {

            inputKeySearch(roleCd, roleNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage()                       , "検索結果が多すぎます。条件を絞ってください。"  , "メッセージ");
            exStringEquals(uiBean.getRoleCd()                   , roleCd                                       , "ロールコード");
            exStringEquals(uiBean.getRoleNm()                   , roleNm                                       , "ロール名");
        }
    }

    @Test
    @TestOrder(70)
    public void testInputKey_Case7(){

        String roleCd = "XXX";
        String roleNm = null;
        try {

            inputKeySearch(roleCd, roleNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage(),   "指定された抽出条件に合致するロールコードは存在しません。"          , "メッセージ");
            exStringEquals(uiBean.getRoleCd()                   , roleCd                                       , "ロールコード");
            exStringEquals(uiBean.getRoleNm()                   , roleNm                                       , "ロール名");
        }
    }

    @Test
    @TestOrder(80)
    public void testInputKey_Case8(){

        String roleCd = null;
        String roleNm = "ＸＸＸ";
        try {

            inputKeySearch(roleCd, roleNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage(),   "指定された抽出条件に合致するロールコードは存在しません。"          , "メッセージ");
            exStringEquals(uiBean.getRoleCd()                   , roleCd                                       , "ロールコード");
            exStringEquals(uiBean.getRoleNm()                   , roleNm                                       , "ロール名");
        }
    }

    @Test
    @TestOrder(90)
    public void testInputKey_Case9(){

        testInputKey_Case2();

        pageSeparate();

        testInputKey_Case3();
    }

    @Test
    @TestOrder(100)
    public void testInputKey_Case10(){

        testInputKey_Case2();

        pageSeparate();

        testInputKey_Case5();
    }

    @Test
    @TestOrder(110)
    public void testInputKey_Case11(){

        testInputKey_Case5();

        pageSeparate();

        testInputKey_Case3();
    }

    @Test
    @TestOrder(120)
    public void testInputKey_Case12(){

        testInputKey_Case6();

        pageSeparate();

        testInputKey_Case5();
    }


    private String init(){

        return action.init();
    }

    private String inputKeySearch(String pRoleCd, String pRoleNm){

        action.init();

        uiBean.setRoleCd(pRoleCd);
        uiBean.setRoleNm(pRoleNm);

        return action.searchBtnOnClick();
    }
}
