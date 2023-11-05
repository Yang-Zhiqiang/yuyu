package yuyu.app.base.system.roletouroku;

import static yuyu.app.base.system.roletouroku.GenRoleTourokuConstants.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.ConversationStatus;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.enumeration.E_SyoriKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

@RunWith(OrderedRunner.class)
public class RoleTourokuTest extends AbstractTest {

    @Inject
    private RoleTourokuAction action;

    @Inject
    private RoleTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private ConversationStatus status;

    static final String BLNK = "";

    @Test(expected = BizLogicException.class)
    @TestOrder(10)
    public void keyInputTest1(){

        action.init();

        uiBean.getRole().setRoleCd("test1");
        action.tourokuBtnOnClick();

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void keyInputTest2(){

        action.init();

        uiBean.getRole().setRoleCd("systest");
        action.tourokuBtnOnClick();

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(30)
    public void keyInputTest3(){

        action.init();

        uiBean.getRole().setRoleCd("test0");
        action.henkouBtnOnClick();

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void keyInputTest4(){

        action.init();

        uiBean.getRole().setRoleCd("systest");
        action.henkouBtnOnClick();

    }


    @Test(expected = BizLogicException.class)
    @TestOrder(50)
    public void keyInputTest5(){

        action.init();

        uiBean.getRole().setRoleCd("test0");
        action.sakujyoBtnOnClick();

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(60)
    public void keyInputTest6(){

        action.init();

        uiBean.getRole().setRoleCd("test1");
        action.sakujyoBtnOnClick();

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(70)
    public void keyInputTest7(){

        action.init();

        uiBean.getRole().setRoleCd("systest");
        action.sakujyoBtnOnClick();

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(80)
    public void keyInputTest8(){

        action.init();

        uiBean.getRole().setRoleCd("test2");
        action.sakujyoBtnOnClick();

    }

    @Test()
    @TestOrder(90)
    public void keyInputTest9(){

        action.init();

        uiBean.getRole().setRoleCd("test3");
        String forward = action.tourokuBtnOnClick();

        exStringEquals(forward  , FORWARDNAME_INPUTCONTENTS, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test3", "ロールコード");
        exEnumEquals(status.getSyoriKbn(), E_SyoriKbn.NEW, "処理区分");

    }

    @Test()
    @TestOrder(100)
    public void keyInputTest10(){

        action.init();

        uiBean.getRole().setRoleCd("test4");
        String forward = action.henkouBtnOnClick();

        exStringEquals(forward  , FORWARDNAME_INPUTCONTENTS, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test4", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト４", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用４", "ロール説明");
        exEnumEquals(status.getSyoriKbn(), E_SyoriKbn.EDIT, "処理区分");

    }

    @Test()
    @TestOrder(110)
    public void keyInputTest11(){

        action.init();

        uiBean.getRole().setRoleCd("test5");
        String forward = action.sakujyoBtnOnClick();

        exStringEquals(forward  , FORWARDNAME_CONFIRM, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test5", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト５", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用５", "ロール説明");
        exEnumEquals(status.getSyoriKbn(), E_SyoriKbn.DELETE, "処理区分");

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(120)
    public void inputContentsTest1(){

        action.init();

        uiBean.getRole().setRoleCd("test6");
        action.tourokuBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm(BLNK);
        uiBean.getRole().setRoleSetumei("テスト用６");
        action.kakuninBtnOnClick();

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(130)
    public void inputContentsTest2(){

        action.init();

        uiBean.getRole().setRoleCd("test7");
        action.henkouBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm(BLNK);
        uiBean.getRole().setRoleSetumei("テスト用７");
        action.kakuninBtnOnClick();

    }

    @Test()
    @TestOrder(140)
    public void inputContentsTest3(){

        action.init();

        uiBean.getRole().setRoleCd("test8");
        action.tourokuBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト８");
        uiBean.getRole().setRoleSetumei("テスト用８");
        String forward = action.kakuninBtnOnClick();

        exStringEquals(forward, FORWARDNAME_CONFIRM, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test8", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト８", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用８", "ロール説明");

    }

    @Test()
    @TestOrder(150)
    public void inputContentsTest4(){

        action.init();

        uiBean.getRole().setRoleCd("test9");
        action.henkouBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト９");
        uiBean.getRole().setRoleSetumei("テスト用９　変更");
        String forward = action.kakuninBtnOnClick();

        exStringEquals(forward, FORWARDNAME_CONFIRM, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test9", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト９", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用９　変更", "ロール説明");

    }

    @Test()
    @TestOrder(160)
    public void inputContentsTest5(){

        action.init();

        uiBean.getRole().setRoleCd("test10");
        action.tourokuBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト １０");
        uiBean.getRole().setRoleSetumei("テスト用１０");

        String forward = action.modoruBtnByInputContentsOnClick();

        exStringEquals(forward, FORWARDNAME_INPUTKEY, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test10", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), null, "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), null, "ロール説明");

    }

    @Test()
    @TestOrder(170)
    public void inputContentsTest6(){

        action.init();

        uiBean.getRole().setRoleCd("test11");
        action.henkouBtnOnClick();

        pageSeparate();

        String forward = action.modoruBtnByInputContentsOnClick();

        pageSeparate();

        exStringEquals(forward, FORWARDNAME_INPUTKEY, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test11", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), null, "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), null, "ロール説明");

    }

    @Test()
    @TestOrder(180)
    public void confirmTest1(){

        action.init();

        uiBean.getRole().setRoleCd("test12");
        action.tourokuBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト１２");
        uiBean.getRole().setRoleSetumei("テスト用１２　登録");
        action.kakuninBtnOnClick();

        pageSeparate();

        String forward = action.kakuteiBtnOnClick();

        exStringEquals(forward, FORWARDNAME_RESULT, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test12", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト１２", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用１２　登録", "ロール説明");

        AM_Role role = manager.getRole(uiBean.getRole().getRoleCd());
        exStringEquals(role.getRoleCd(), uiBean.getRole().getRoleCd(), "ロールコード");
        exStringEquals(role.getRoleNm(), uiBean.getRole().getRoleNm(), "ロール名");
        exStringEquals(role.getRoleSetumei(), uiBean.getRole().getRoleSetumei(), "ロール説明");

    }

    @Test()
    @TestOrder(190)
    public void confirmTest2(){
        AM_Role role = manager.getRole("test13");
        exStringEquals(role.getRoleCd(), "test13", "ロールコード");
        exStringEquals(role.getRoleNm(), "テスト１３", "ロール名");
        exStringEquals(role.getRoleSetumei(), "テスト用１３", "ロール説明");

        action.init();

        uiBean.getRole().setRoleCd("test13");
        action.henkouBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト１３");
        uiBean.getRole().setRoleSetumei("テスト用１３　変更");
        action.kakuninBtnOnClick();

        pageSeparate();

        String forward = action.kakuteiBtnOnClick();

        pageSeparate();

        exStringEquals(forward, FORWARDNAME_RESULT, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test13", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト１３", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用１３　変更", "ロール説明");

        exStringEquals(role.getRoleCd(), uiBean.getRole().getRoleCd(), "ロールコード");
        exStringEquals(role.getRoleNm(), uiBean.getRole().getRoleNm(), "ロール名");
        exStringEquals(role.getRoleSetumei(), uiBean.getRole().getRoleSetumei(), "ロール説明");


    }

    @Test()
    @TestOrder(200)
    public void confirmTest3(){
        AM_Role role = manager.getRole("test14");
        exStringEquals(role.getRoleCd(), "test14", "ロールコード");
        exStringEquals(role.getRoleNm(), "テスト１４", "ロール名");
        exStringEquals(role.getRoleSetumei(), "テスト用１４", "ロール説明");

        action.init();

        uiBean.getRole().setRoleCd("test14");
        action.sakujyoBtnOnClick();

        pageSeparate();

        String forward = action.kakuteiBtnOnClick();

        pageSeparate();

        exStringEquals(forward, FORWARDNAME_RESULT, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test14", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト１４", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用１４", "ロール説明");

        boolean roleSakuzyoResult;
        role = manager.getRole(uiBean.getRole().getRoleCd());
        if(role == null) {
            roleSakuzyoResult = true;
        } else {
            roleSakuzyoResult = false;
        }
        exBooleanEquals(roleSakuzyoResult, true, "DB削除結果");

    }
    @Test()
    @TestOrder(210)
    public void confirmTest4(){

        action.init();

        uiBean.getRole().setRoleCd("test15");
        action.tourokuBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト１５");
        uiBean.getRole().setRoleSetumei("テスト用１５　登録");
        action.kakuninBtnOnClick();

        pageSeparate();

        String forward = action.modoruBtnByConfirmOnClick();

        exStringEquals(forward, FORWARDNAME_INPUTCONTENTS, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test15", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト１５", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用１５　登録", "ロール説明");

    }

    @Test()
    @TestOrder(220)
    public void confirmTest5(){
        AM_Role role = manager.getRole("test16");
        exStringEquals(role.getRoleCd(), "test16", "ロールコード");
        exStringEquals(role.getRoleNm(), "テスト１６", "ロール名");
        exStringEquals(role.getRoleSetumei(), "テスト用１６", "ロール説明");

        action.init();

        uiBean.getRole().setRoleCd("test16");
        action.henkouBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト１６");
        uiBean.getRole().setRoleSetumei("テスト用１６　変更");
        action.kakuninBtnOnClick();

        pageSeparate();

        String forward = action.modoruBtnByConfirmOnClick();

        pageSeparate();

        exStringEquals(forward, FORWARDNAME_INPUTCONTENTS, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test16", "ロールコード");
        exStringEquals(uiBean.getRole().getRoleNm(), "テスト１６", "ロール名");
        exStringEquals(uiBean.getRole().getRoleSetumei(), "テスト用１６　変更", "ロール説明");

    }

    @Test()
    @TestOrder(230)
    public void confirmTest6(){
        action.init();

        uiBean.getRole().setRoleCd("test17");
        action.sakujyoBtnOnClick();

        pageSeparate();

        String forward = action.modoruBtnByConfirmOnClick();

        pageSeparate();

        exStringEquals(forward, FORWARDNAME_INPUTKEY, "フォワード名");
        exStringEquals(uiBean.getRole().getRoleCd(), "test17", "ロールコード");

    }

    @Test()
    @TestOrder(240)
    public void resultTest1(){

        action.init();

        uiBean.getRole().setRoleCd("test18");
        action.tourokuBtnOnClick();

        pageSeparate();

        uiBean.getRole().setRoleNm("テスト１８");
        uiBean.getRole().setRoleSetumei("テスト用１８");
        action.kakuninBtnOnClick();

        pageSeparate();

        action.kakuteiBtnOnClick();

        pageSeparate();

        String forward = action.syokigamenheBtnOnClick();

        exStringEquals(forward, FORWARDNAME_INIT, "フォワード名");


    }

    //    @Test()
    //    @TestOrder(250)
    //    public void resultTest2(){
    //        action.init();
    //
    //        uiBean.getRole().setRoleCd("test19");
    //        action.henkouBtnOnClick();
    //
    //        pageSeparate();
    //
    //        uiBean.getRole().setRoleNm("テスト１９");
    //        uiBean.getRole().setRoleSetumei("テスト用１９　変更");
    //        action.kakuninBtnOnClick();
    //
    //        pageSeparate();
    //
    //        action.kakuteiBtnOnClick();
    //
    //        pageSeparate();
    //
    //        String forward = action.syokigamenheBtnOnClick();
    //
    //        exStringEquals(forward, FORWARDNAME_INIT, "フォワード名");
    //
    //    }
    //    @Test()
    //    @TestOrder(260)
    //    public void resultTest3(){
    //        action.init();
    //
    //        uiBean.getRole().setRoleCd("test20");
    //        action.sakujyoBtnOnClick();
    //
    //        pageSeparate();
    //
    //        action.kakuteiBtnOnClick();
    //
    //        pageSeparate();
    //
    //        String forward = action.syokigamenheBtnOnClick();
    //
    //        exStringEquals(forward, FORWARDNAME_INIT, "フォワード名");
    //
    //    }

}

