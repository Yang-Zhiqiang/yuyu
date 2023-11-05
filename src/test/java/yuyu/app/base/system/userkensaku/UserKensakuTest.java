package yuyu.app.base.system.userkensaku;

import static yuyu.app.base.system.userkensaku.GenUserKensakuConstants.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.ui.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_PasswordRireki;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


@RunWith(OrderedRunner.class)
public class UserKensakuTest extends AbstractTest {

    @Inject
    private UserKensakuAction action;

    @Inject
    private UserKensakuUiBean uiBean;

    @Override
    protected void beforeAllTest(){
        setClearTargets(AT_UserHenkouRireki.class, AT_PasswordRireki.class);
    }

    @Test
    @TestOrder(10)
    public void testInputKey_Case1(){

        String forward = init();

        boolean existUserInfo = false;
        DataSource<UserInfoDataSourceBean> dataSourceBean = uiBean.getUserInfoDataSource();
        if (dataSourceBean.size() == 0) {
            existUserInfo = true;
        }

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exStringEquals(uiBean.getUserId()                   , null                                         , "ユーザーID");
        exStringEquals(uiBean.getUserNm()                   , null                                         , "ユーザー名");
        exBooleanEquals(existUserInfo                       , true                                         , "ユーザー情報データソース");
    }

    @Test
    @TestOrder(20)
    public void testInputKey_Case2(){

        String userId = "1000";
        String userNm = null;

        String forward = inputKeySearch(userId, userNm);


        DataSource<UserInfoDataSourceBean> dataSourceBean = uiBean.getUserInfoDataSource();
        List<UserInfoDataSourceBean> list = dataSourceBean.getAllData();

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exNumericEquals(dataSourceBean.size()               , 2                                            , "検索結果件数");
        exStringEquals(uiBean.getUserId()                   , userId                                       , "ユーザーID");
        exStringEquals(uiBean.getUserNm()                   , userNm                                       , "ユーザー名");
        exStringEquals(list.get(0).getUserId()              , "1000"                                       , "検索結果1件目（ユーザーID）");
        exStringEquals(list.get(0).getUserNm()              , "ＢＣ"                                       , "検索結果1件目（ユーザー名）");
        exStringEquals(list.get(1).getUserId()              , "10001"                                      , "検索結果2件目（ユーザーID）");
        exStringEquals(list.get(1).getUserNm()              , "ＢＣＤ"                                     , "検索結果2件目（ユーザー名）");
    }

    @Test
    @TestOrder(30)
    public void testInputKey_Case3(){

        String userId = null;
        String userNm = "ＢＣ";

        String forward = inputKeySearch(userId, userNm);

        DataSource<UserInfoDataSourceBean> dataSourceBean = uiBean.getUserInfoDataSource();
        List<UserInfoDataSourceBean> list = dataSourceBean.getAllData();

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exNumericEquals(dataSourceBean.size()               , 4                                            , "検索結果件数");
        exStringEquals(uiBean.getUserId()                   , userId                                       , "ユーザーID");
        exStringEquals(uiBean.getUserNm()                   , userNm                                       , "ユーザー名");
        exStringEquals(list.get(0).getUserId()              , "1000"                                       , "検索結果1件目（ユーザーID）");
        exStringEquals(list.get(0).getUserNm()              , "ＢＣ"                                       , "検索結果1件目（ユーザー名）");
        exStringEquals(list.get(1).getUserId()              , "10001"                                      , "検索結果2件目（ユーザーID）");
        exStringEquals(list.get(1).getUserNm()              , "ＢＣＤ"                                     , "検索結果2件目（ユーザー名）");
        exStringEquals(list.get(2).getUserId()              , "11000"                                      , "検索結果3件目（ユーザーID）");
        exStringEquals(list.get(2).getUserNm()              , "ＡＢＣ"                                     , "検索結果3件目（ユーザー名）");
        exStringEquals(list.get(3).getUserId()              , "110001"                                     , "検索結果4件目（ユーザーID）");
        exStringEquals(list.get(3).getUserNm()              , "ＡＢＣＤ"                                   , "検索結果4件目（ユーザー名）");
    }

    @Test
    @TestOrder(40)
    public void testInputKey_Case4(){

        String userId = "1000";
        String userNm = "ＣＤ";

        String forward = inputKeySearch(userId, userNm);

        DataSource<UserInfoDataSourceBean> dataSourceBean = uiBean.getUserInfoDataSource();
        List<UserInfoDataSourceBean> list = dataSourceBean.getAllData();

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY                         , "フォワード名");
        exNumericEquals(dataSourceBean.size()               , 1                                            , "検索結果件数");
        exStringEquals(uiBean.getUserId()                   , userId                                       , "ユーザーID");
        exStringEquals(uiBean.getUserNm()                   , userNm                                       , "ユーザー名");
        exStringEquals(list.get(0).getUserId()              , "10001"                                      , "検索結果1件目（ユーザーID）");
        exStringEquals(list.get(0).getUserNm()              , "ＢＣＤ"                                     , "検索結果1件目（ユーザー名）");
    }

    @Test
    @TestOrder(50)
    public void testInputKey_Case5(){

        String userId = "XXX";
        String userNm = "ＸＸＸ";
        try {

            inputKeySearch(userId, userNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage(),   "指定された抽出条件に合致するユーザーIDは存在しません。"          , "メッセージ");
            exStringEquals(uiBean.getUserId()                   , userId                                       , "ユーザーID");
            exStringEquals(uiBean.getUserNm()                   , userNm                                       , "ユーザー名");
        }
    }

    @Test
    @TestOrder(60)
    public void testInputKey_Case6(){

        String userId = null;
        String userNm = null;
        try {

            inputKeySearch(userId, userNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage()                       , "検索結果が多すぎます。条件を絞ってください。"  , "メッセージ");
            exStringEquals(uiBean.getUserId()                   , userId                                       , "ユーザーID");
            exStringEquals(uiBean.getUserNm()                   , userNm                                       , "ユーザー名");
        }
    }

    @Test
    @TestOrder(70)
    public void testInputKey_Case7(){

        String userId = "XXX";
        String userNm = null;
        try {

            inputKeySearch(userId, userNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage(),   "指定された抽出条件に合致するユーザーIDは存在しません。"          , "メッセージ");
            exStringEquals(uiBean.getUserId()                   , userId                                       , "ユーザーID");
            exStringEquals(uiBean.getUserNm()                   , userNm                                       , "ユーザー名");
        }
    }

    @Test
    @TestOrder(80)
    public void testInputKey_Case8(){

        String userId = null;
        String userNm = "ＸＸＸ";
        try {

            inputKeySearch(userId, userNm);

        } catch (BizLogicException e) {

            exStringEquals(e.getMessage(),   "指定された抽出条件に合致するユーザーIDは存在しません。"          , "メッセージ");
            exStringEquals(uiBean.getUserId()                   , userId                                       , "ユーザーID");
            exStringEquals(uiBean.getUserNm()                   , userNm                                       , "ユーザー名");
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

    private String inputKeySearch(String pUserId, String pUserNm){

        action.init();

        uiBean.setUserId(pUserId);
        uiBean.setUserNm(pUserNm);

        return action.searchBtnOnClick();
    }

}
