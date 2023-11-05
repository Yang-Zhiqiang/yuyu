package yuyu.app.base.system.holidaygrouptouroku;

import static yuyu.app.base.system.holidaygrouptouroku.GenHolidayGroupTourokuConstants.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.file.FileDescription;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.description.ColumnDesc;
import jp.co.slcs.swak.file.description.HeadDesc;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.web.message.MessageManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import yuyu.common.base.ConversationStatus;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.enumeration.E_SyoriKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 休日グループ登録機能のロジックテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HolidayGroupTourokuTest extends AbstractTest{

    @Inject
    private static Logger logger;

    @Inject
    private HolidayGroupTourokuAction action;

    @Inject
    private HolidayGroupTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private ConversationStatus status;

    @Override
    protected void beforeAllTest(){

        setBackupTargets(AT_TokuteibiKadouTime.class, AT_KadouTime.class);
    }

    @Test
    @TestOrder(1)
    public void testInputKey_Case1(){

        inputKeyInit();
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(2)
    public void testInputKey_Case2(){

        inputKeyTouroku("BankHolidays");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(3)
    public void testInputKey_Case3(){

        inputKeyTouroku("");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(4)
    public void testInputKey_Case4(){

        inputKeySakujyo(0);
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(5)
    public void testInputKey_Case5(){

        inputKeySakujyo(1);
    }
    @Test(expected = BizLogicException.class)
    @TestOrder(6)
    public void testInputKey_Case6(){

        inputKeySakujyo(2);
    }

    @Test
    @TestOrder(7)
    public void testInputKey_Case7(){

        String forward = inputKeyTouroku("CalendarH5");

        exStringEquals(forward                              , FORWARDNAME_INPUTCONTENTS             , "フォワード名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupCd()      , "CalendarH5"                               , "休日グループコード");
        exEnumEquals(status.getSyoriKbn()      , E_SyoriKbn.NEW                               , "処理区分列挙型");
    }

    @Test
    @TestOrder(8)
    public void testInputKey_Case8(){

        String forward = inputKeyHenkou(3);

        exStringEquals(forward                                                     , FORWARDNAME_INPUTCONTENTS                 , "フォワード名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupCd()                             , "CalendarH4"          , "休日グループ名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupNm()                             , "休日グループテスト４"          , "休日グループ備考");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupDescription()                             , "休日グループテスト休日グループテスト休日グループテスト休日グループテスト４"          , "休日グループコード");
        exEnumEquals(status.getSyoriKbn()                                          , E_SyoriKbn.EDIT                           , "処理区分列挙型");
    }

    @Test
    @TestOrder(9)
    public void testInputKey_Case9(){

        String forward = inputKeySakujyo(3);

        exStringEquals(forward                                                     , FORWARDNAME_CONFIRM               , "フォワード名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupCd()                             , "CalendarH4"          , "休日グループコード");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupNm()                             , "休日グループテスト４"          , "休日グループ名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupDescription()                             , "休日グループテスト休日グループテスト休日グループテスト休日グループテスト４"          , "休日グループ備考");
        exEnumEquals(status.getSyoriKbn()                                          , E_SyoriKbn.DELETE                           , "処理区分列挙型");
    }

    @Test
    @TestOrder(10)
    public void testInputContents_Case1(){

        inputKeyTouroku("CalendarH5");

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();
        holidayGroup.setHolidayGroupNm("休日グループテスト５");
        holidayGroup.setHolidayGroupDescription("休日グループテスト休日グループテスト休日グループテスト休日グループテスト５");
        uiBean.setHolidayGroup(holidayGroup);

        String forward = action.kakuninBtnOnClick();

        exStringEquals(forward                                                     , FORWARDNAME_CONFIRM                 , "フォワード名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupCd()                             , "CalendarH5"          , "休日グループコード");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupNm()                             , "休日グループテスト５"          , "休日グループ名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupDescription()                             , "休日グループテスト休日グループテスト休日グループテスト休日グループテスト５"          , "休日グループ備考");
        exEnumEquals(status.getSyoriKbn()                                          , E_SyoriKbn.NEW                          , "処理区分列挙型");

    }

    @Test
    @TestOrder(11)
    public void testInputContents_Case2(){

        inputKeyHenkou(3);

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();
        holidayGroup.setHolidayGroupNm("休日グループテスト６");
        holidayGroup.setHolidayGroupDescription("休日グループテスト休日グループテスト休日グループテスト休日グループテスト６");
        uiBean.setHolidayGroup(holidayGroup);

        String forward = action.kakuninBtnOnClick();

        exStringEquals(forward                                                     , FORWARDNAME_CONFIRM                 , "フォワード名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupCd()                             , "CalendarH4"          , "休日グループコード");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupNm()                             , "休日グループテスト６"          , "休日グループ名");
        exStringEquals(uiBean.getHolidayGroup().getHolidayGroupDescription()                             , "休日グループテスト休日グループテスト休日グループテスト休日グループテスト６"          , "休日グループ備考");
        exEnumEquals(status.getSyoriKbn()                                          , E_SyoriKbn.EDIT                          , "処理区分列挙型");

    }

    @Test
    @TestOrder(12)
    public void testConfirm_Case1(){

        inputKeyTouroku("CalendarH5");

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();
        holidayGroup.setHolidayGroupNm("休日グループテスト６");
        holidayGroup.setHolidayGroupDescription("休日グループテスト休日グループテスト休日グループテスト休日グループテスト６");
        uiBean.setHolidayGroup(holidayGroup);

        action.kakuninBtnOnClick();

        pageSeparate();

        String forward;

        try{
            forward = action.kakuteiBtnOnClick();
        }
        catch(Exception e){
            logger.error(e.getMessage(), e);
            throw e;
        }


        exStringEquals(forward , FORWARDNAME_RESULT  , "フォワード名");

        AT_HolidayGroup holidayGroup1  = manager.getHolidayGroup("CalendarH5");
        exStringEquals(holidayGroup1.getHolidayGroupCd()                             , "CalendarH5"          , "休日グループコード");
        exStringEquals(holidayGroup1.getHolidayGroupNm()                             , "休日グループテスト６"          , "休日グループ名");
        exStringEquals(holidayGroup1.getHolidayGroupDescription()                             , "休日グループテスト休日グループテスト休日グループテスト休日グループテスト６"          , "休日グループ備考");
        exClassificationEquals(holidayGroup1.getSysSiyouKbn()                             , C_SysSiyouKbn.TUUJYOU          , "システム使用区分");
        exEnumEquals(status.getSyoriKbn()                                          , E_SyoriKbn.NEW                          , "処理区分列挙型");

        List<Message> list = messageManager.getMessages();
        List<Message> list2 = new ArrayList<>();
        list2.add(new Message(Message.DEFAULT_GROUP, null, "IAC0009", Message.NO_ROW_NUMBER, null, null));
        exListEquals(list, list2, "メッセージ");
    }


    @Test
    @TestOrder(13)
    public void testConfirm_Case2(){

        inputKeyHenkou(4);

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();
        holidayGroup.setHolidayGroupNm("休日グループテスト５");
        holidayGroup.setHolidayGroupDescription("休日グループテスト休日グループテスト休日グループテスト休日グループテスト５");
        uiBean.setHolidayGroup(holidayGroup);

        action.kakuninBtnOnClick();

        pageSeparate();

        String forward;

        try{
            forward = action.kakuteiBtnOnClick();
        }
        catch(Exception e){
            logger.error(e.getMessage(), e);
            throw e;
        }

        pageSeparate();

        exStringEquals(forward , FORWARDNAME_RESULT  , "フォワード名");

        AT_HolidayGroup holidayGroup1  = manager.getHolidayGroup("CalendarH5");
        exStringEquals(holidayGroup1.getHolidayGroupCd()               , "CalendarH5"          , "休日グループコード");
        exStringEquals(holidayGroup1.getHolidayGroupNm()               , "休日グループテスト５"          , "休日グループ名");
        exStringEquals(holidayGroup1.getHolidayGroupDescription()      , "休日グループテスト休日グループテスト休日グループテスト休日グループテスト５"          , "休日グループ備考");
        exClassificationEquals(holidayGroup1.getSysSiyouKbn()          , C_SysSiyouKbn.TUUJYOU          , "システム使用区分");
        exEnumEquals(status.getSyoriKbn()                              , E_SyoriKbn.EDIT                          , "処理区分列挙型");

    }

    @Test
    @TestOrder(14)
    public void testConfirm_Case3(){

        inputKeySakujyo(3);

        String forward;

        try{
            forward = action.kakuteiBtnOnClick();
        }
        catch(Exception e){
            logger.error(e.getMessage(), e);
            throw e;
        }

        pageSeparate();

        exStringEquals(forward , FORWARDNAME_RESULT  , "フォワード名");
        exEnumEquals(status.getSyoriKbn()                              , E_SyoriKbn.DELETE                          , "処理区分列挙型");

        List<AT_HolidayGroup> holidayGroup1 = manager.getAllHolidayGroups();

        exNumericEquals(holidayGroup1.size()                              , 7                         , "DBに格納件数");

    }

    @Test
    @TestOrder(15)
    public void testResult_Case1(){

        inputKeyHenkou(3);

        AT_HolidayGroup holidayGroup = uiBean.getHolidayGroup();
        holidayGroup.setHolidayGroupNm("休日グループテスト８");
        holidayGroup.setHolidayGroupDescription("休日グループテスト休日グループテスト休日グループテスト休日グループテスト８");
        uiBean.setHolidayGroup(holidayGroup);

        action.kakuninBtnOnClick();

        pageSeparate();

        action.kakuteiBtnOnClick();

        pageSeparate();

        String forward = action.syokigamenheBtnOnClick();

        exStringEquals(forward , FORWARDNAME_INIT , "フォワード名");
    }


    private void inputKeyInit(){

        String forward = action.init();
        pageSeparate();

        exStringEquals(forward                              , FORWARDNAME_INPUTKEY            , "フォワード名");

        FileEntityManager fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.XLS);
        List<HolidayGroupInfoListDataSourceBean> dataSourceBeanList1;
        try (InputStream dataFileStream1 = getClass().getResourceAsStream("HolidayGroupInfoList.xls")) {
            FileDescription<HolidayGroupInfoListDataSourceBean, ? extends HeadDesc, ? extends ColumnDesc> fd =
                    fileEntityManager.parseDescription(HolidayGroupInfoListDataSourceBean.class, dataFileStream1);
            try (InputStream dataFileStream2 = getClass().getResourceAsStream("HolidayGroupInfoList.xls")) {
                dataSourceBeanList1 = fileEntityManager.read(fd, dataFileStream2);
            } catch (CvtVdtException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<HolidayGroupInfoListDataSourceBean>  dataSourceBeanList2 = uiBean.getHolidayGroupInfoListDataSource().getAllData();

        for (int i = 0; i < dataSourceBeanList2.size(); i++) {
            HolidayGroupInfoListDataSourceBean DataSourceBean1 = dataSourceBeanList1.get(i);
            HolidayGroupInfoListDataSourceBean DataSourceBean2 = dataSourceBeanList2.get(i);
            exStringEquals(DataSourceBean2.getHolidayGroupCd()      , DataSourceBean1.getHolidayGroupCd()                               , "休日グループコード");
            exStringEquals(DataSourceBean2.getHolidayGroupNm()      , DataSourceBean1.getHolidayGroupNm()                               , "休日グループ名");
            exStringEquals(DataSourceBean2.getHolidayGroupDescription()      , DataSourceBean1.getHolidayGroupDescription()                               , "休日グループ備考");
            exStringEquals(DataSourceBean2.getHenkouLink()      , DataSourceBean1.getHenkouLink()                               , "変更リンク");
            exStringEquals(DataSourceBean2.getSakujyoLink()      , DataSourceBean1.getSakujyoLink()                               , "削除リンク");

        }

    }

    private String inputKeyTouroku(String pHolidayGroupCd){

        action.init();
        pageSeparate();

        uiBean.getHolidayGroup().setHolidayGroupCd(pHolidayGroupCd);

        try {
            return action.tourokuBtnOnClick();
        } finally {
            pageSeparate();
        }
    }

    @SuppressWarnings("deprecation")
    private String inputKeyHenkou(int pSelectedIndex){

        action.init();
        pageSeparate();

        uiBean.getHolidayGroupInfoListDataSource().setSelectedIndex(Integer.valueOf(pSelectedIndex));


        try {
            pageSeparate();
            return action.henkouLinkOnClick();
        } finally {
            pageSeparate();
        }
    }

    @SuppressWarnings("deprecation")
    private String inputKeySakujyo(int pSelectedIndex){

        action.init();
        pageSeparate();

        uiBean.getHolidayGroupInfoListDataSource().setSelectedIndex(Integer.valueOf(pSelectedIndex));

        try {
            return action.sakujyoLinkOnClick();
        } finally {
            pageSeparate();
        }
    }
}
