package yuyu.app.base.system.kadoutimegrouptouroku;

import static yuyu.app.base.system.kadoutimegrouptouroku.GenKadouTimeGroupTourokuConstants.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.io.InputStream;
import java.util.List;
import javax.inject.Inject;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.file.FileDescription;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.description.ColumnDesc;
import jp.co.slcs.swak.file.description.HeadDesc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 稼動時間グループ登録機能のロジックテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class KadouTimeGroupTourokuTest extends AbstractTest{

    @Inject
    private static Logger logger;

    @Inject
    private KadouTimeGroupTourokuAction action;

    @Inject
    private KadouTimeGroupTourokuUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Override
    protected void beforeAllTest(){

        setBackupTargets(AT_TokuteibiKadouTime.class);
    }


    @Test
    @TestOrder(1)
    public void testInputKey_Case1(){

        inputKeyInit();
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(2)
    public void testInputKey_Case2(){

        inputKeyTouroku("Default");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(3)
    public void testInputKey_Case3(){

        inputKeyTouroku("");
    }


    @Test
    @TestOrder(4)
    public void testInputKey_Case4(){

        String forward = inputKeyTouroku("TEST002");

        exStringEquals(forward                              , FORWARDNAME_INPUTCONTENTS             , "フォワード名");
        exStringEquals(uiBean.getKadouTimeGroupCd()         , "TEST002"                             , "稼働時間グループコード");
    }

    @Test
    @TestOrder(5)
    public void testInputKey_Case5(){

        String forward = inputKeyHenkou(1);

        exStringEquals(forward                                                     , FORWARDNAME_INPUTCONTENTS                 , "フォワード名");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupCd()                             , "TEST001"             , "稼動時間グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupNm()                             , "テスト００１"        , "稼動時間グループ名");
        exStringEquals(uiBean.getKadouTimeGroup().getHolidayGroupCd()                             , "BankHolidays"          , "休日グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupDescription()                        , "テスト００１備考"   , "稼働時間グループ備考");
    }


    @Test
    @TestOrder(6)
    public void testInputKey_Case6(){

        String forward = inputKeySakujyo(0);

        exStringEquals(forward                                                     , FORWARDNAME_CONFIRM                       , "フォワード名");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupCd()                             , "Default"             , "稼動時間グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupNm()                             , "デフォルト稼働時間"        , "稼動時間グループ名");
        exStringEquals(uiBean.getKadouTimeGroup().getHolidayGroupCd()                             , "BankHolidays"          , "休日グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupDescription()                    , "システムに初期登録された稼働時間グループです。"   , "稼働時間グループ備考");
    }

    @Test
    @TestOrder(7)
    public void testInputContents_Case1(){

        inputKeyTouroku("TEST002");

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();
        kadouTimeGroup.setKadouTimeGroupNm("テスト００2");
        kadouTimeGroup.setHolidayGroupCd("JapanHolidays");
        kadouTimeGroup.setKadouTimeGroupDescription("テスト002備考");

        uiBean.setKadouTimeGroup(kadouTimeGroup);


        String forward = action.kakuninBtnOnClick();

        exStringEquals(forward                                                     , FORWARDNAME_CONFIRM                       , "フォワード名");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupCd()                             , "TEST002"             , "稼動時間グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupNm()                             , "テスト００2"        , "稼動時間グループ名");
        exStringEquals(uiBean.getKadouTimeGroup().getHolidayGroupCd()                             , "JapanHolidays"          , "休日グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupDescription()                    , "テスト002備考"   , "稼働時間グループ備考");

    }


    @Test
    @TestOrder(8)
    public void testInputContents_Case2(){

        inputKeyHenkou(1);

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();
        kadouTimeGroup.setKadouTimeGroupNm("テスト００１変更");
        kadouTimeGroup.setHolidayGroupCd("WeekendHolidays");
        kadouTimeGroup.setKadouTimeGroupDescription("テスト001備考変更");

        String forward = action.kakuninBtnOnClick();

        exStringEquals(forward                                                     , FORWARDNAME_CONFIRM                       , "フォワード名");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupCd()                             , "TEST001"             , "稼動時間グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupNm()                             , "テスト００１変更"        , "稼動時間グループ名");
        exStringEquals(uiBean.getKadouTimeGroup().getHolidayGroupCd()                             , "WeekendHolidays"          , "休日グループコード");
        exStringEquals(uiBean.getKadouTimeGroup().getKadouTimeGroupDescription()                    , "テスト001備考変更"   , "稼働時間グループ備考");

    }

    @Test
    @TestOrder(9)
    public void testConfirm_Case1(){

        inputKeyTouroku("TEST002");

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();
        kadouTimeGroup.setKadouTimeGroupNm("テスト００２");
        kadouTimeGroup.setHolidayGroupCd("JapanHolidays");
        kadouTimeGroup.setKadouTimeGroupDescription("テスト002備考");

        uiBean.setKadouTimeGroup(kadouTimeGroup);

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

        AT_KadouTimeGroup kadouTimeGroupTemp  = manager.getKadouTimeGroup("TEST002");
        List<AT_KadouTime>  kadouTimeList = kadouTimeGroupTemp.getKadouTimes();

        exStringEquals(kadouTimeGroupTemp.getKadouTimeGroupCd()                             , "TEST002"             , "稼動時間グループコード");
        exStringEquals(kadouTimeGroupTemp.getKadouTimeGroupNm()                             , "テスト００２"        , "稼動時間グループ名");
        exStringEquals(kadouTimeGroupTemp.getHolidayGroupCd()                             , "JapanHolidays"          , "休日グループコード");
        exStringEquals(kadouTimeGroupTemp.getKadouTimeGroupDescription()                    , "テスト002備考"   , "稼働時間グループ備考");

        int iCnt = 0;
        for (AT_KadouTime kadouTime : kadouTimeList) {

            iCnt = iCnt + 1;
            if (iCnt == 1) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "1"   , "稼働時間曜日区分");
            }else if (iCnt == 2) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "1"   , "稼働時間曜日区分"); }
            else if (iCnt == 3) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "2"   , "稼働時間曜日区分");
            } else if (iCnt == 4) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "2"   , "稼働時間曜日区分");
            } else if (iCnt == 5) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "3"   , "稼働時間曜日区分");
            } else if (iCnt == 6) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "3"   , "稼働時間曜日区分");
            } else if (iCnt == 7) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "4"   , "稼働時間曜日区分");
            } else if (iCnt == 8) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "4"   , "稼働時間曜日区分");
            } else if (iCnt == 9) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "5"   , "稼働時間曜日区分");
            } else if (iCnt == 10) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "5"   , "稼働時間曜日区分");
            } else if (iCnt == 11) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "6"   , "稼働時間曜日区分");
            } else if (iCnt == 12) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "6"   , "稼働時間曜日区分");
            } else if (iCnt == 13) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "7"   , "稼働時間曜日区分");
            } else if (iCnt == 14) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "1"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "7"   , "稼働時間曜日区分");
            } else if (iCnt == 15) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "1"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "4"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "8"   , "稼働時間曜日区分");
            }  else if (iCnt == 16) {
                exStringEquals(kadouTime.getKadouTimeGroupCd()                    , "TEST002"   , "稼動時間グループコード");
                exStringEquals(kadouTime.getEigyoubiKbn() .toString()             , "2"   , "営業日区分");
                exStringEquals(kadouTime.getKadouTimeSiteiKbn().toString()        , "4"   , "稼働時間指定区分");
                exStringEquals(kadouTime.getKadouTimeYoubiKbn().toString()        , "8"   , "稼働時間曜日区分");
            }
        }

    }


    @Test
    @TestOrder(10)
    public void testConfirm_Case2(){

        inputKeyHenkou(1);

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();
        kadouTimeGroup.setKadouTimeGroupNm("テスト００１変更");
        kadouTimeGroup.setHolidayGroupCd("WeekendHolidays");
        kadouTimeGroup.setKadouTimeGroupDescription("テスト001備考変更");

        uiBean.setKadouTimeGroup(kadouTimeGroup);

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

        AT_KadouTimeGroup kadouTimeGroupTemp  = manager.getKadouTimeGroup("TEST001");

        exStringEquals(kadouTimeGroupTemp.getKadouTimeGroupCd()                             , "TEST001"             , "稼動時間グループコード");
        exStringEquals(kadouTimeGroupTemp.getKadouTimeGroupNm()                             , "テスト００１変更"        , "稼動時間グループ名");
        exStringEquals(kadouTimeGroupTemp.getHolidayGroupCd()                             , "WeekendHolidays"          , "休日グループコード");
        exStringEquals(kadouTimeGroupTemp.getKadouTimeGroupDescription()                    , "テスト001備考変更"   , "稼働時間グループ備考");
    }


    @Test
    @TestOrder(11)
    public void testConfirm_Case3(){

        inputKeySakujyo(2);

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

        List<AT_KadouTimeGroup> kadouTimeGruops = manager.getAllKadouTimeGroups();

        exNumericEquals(kadouTimeGruops.size()                              , 2                         , "DBに格納件数");

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(12)
    public void testConfirm_Case4(){
        inputKeySakujyo(0);

        try{
            action.kakuteiBtnOnClick();
        }
        catch(Exception e){
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    @Test
    @TestOrder(13)
    public void testResult_Case1(){

        inputKeyHenkou(1);

        AT_KadouTimeGroup kadouTimeGroup = uiBean.getKadouTimeGroup();
        kadouTimeGroup.setKadouTimeGroupNm("テスト００１変更");
        kadouTimeGroup.setHolidayGroupCd("WeekendHolidays");
        kadouTimeGroup.setKadouTimeGroupDescription("テスト001備考変更");

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
        FileDescription<KadouTimeGroupInfoListDataSourceBean, ? extends HeadDesc, ? extends ColumnDesc> fd;

        List<KadouTimeGroupInfoListDataSourceBean> dataSourceBeanList1;
        try (InputStream dataFile = getClass().getResourceAsStream("KadouTimeGroupInfoList.xls")) {
            fd = fileEntityManager.parseDescription(KadouTimeGroupInfoListDataSourceBean.class, dataFile);

            try (InputStream dataFile2 = getClass().getResourceAsStream("KadouTimeGroupInfoList.xls")) {
                dataSourceBeanList1 = fileEntityManager.read(fd, dataFile);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        List<KadouTimeGroupInfoListDataSourceBean>  dataSourceBeanList2 = uiBean.getKadouTimeGroupInfoList();

        for (int i = 0; i < dataSourceBeanList2.size(); i++) {
            KadouTimeGroupInfoListDataSourceBean DataSourceBean1 = dataSourceBeanList1.get(i);
            KadouTimeGroupInfoListDataSourceBean DataSourceBean2 = dataSourceBeanList2.get(i);
            exStringEquals(DataSourceBean2.getKadouTimeGroupCd()      , DataSourceBean1.getKadouTimeGroupCd()                    , "稼働時間グループコード");
            exStringEquals(DataSourceBean2.getKadouTimeGroupNm()      , DataSourceBean1.getKadouTimeGroupNm()                    , "稼働時間グループ名");
            exStringEquals(DataSourceBean2.getKadouTimeGroupDescription()      , DataSourceBean1.getKadouTimeGroupDescription()  , "稼働時間グループ備考");
            exStringEquals(DataSourceBean2.getHolidayGroupCd()      , DataSourceBean1.getHolidayGroupCd()                        , "休日グループコード");
            exStringEquals(DataSourceBean2.getHenkouLink()      , DataSourceBean1.getHenkouLink()                                , "変更リンク");
            exStringEquals(DataSourceBean2.getSakujyoLink()      , DataSourceBean1.getSakujyoLink()                              , "削除リンク");
        }
    }

    private String inputKeyTouroku(String pKadouTimeGroupCd){


        action.init();
        pageSeparate();

        uiBean.setKadouTimeGroupCd(pKadouTimeGroupCd);

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

        uiBean.getKadouTimeGroupInfoListDataSource().setSelectedIndex(Integer.valueOf(pSelectedIndex));


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

        uiBean.getKadouTimeGroupInfoListDataSource().setSelectedIndex(Integer.valueOf(pSelectedIndex));

        try {
            return action.sakujyoLinkOnClick();
        } finally {
            pageSeparate();
        }
    }

}
