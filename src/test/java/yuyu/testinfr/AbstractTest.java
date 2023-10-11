package yuyu.testinfr;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.file.FileDescription;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.exception.CvtVdtException.Message;
import jp.co.slcs.swak.web.conversation.ConversationContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.db.mapping.AbstractExDBEntity;

import com.google.common.collect.Lists;

/**
 * 機能単体テスト親クラスです。
 */
@RunWith(SWAKTestRunner.class)
public abstract class AbstractTest {

    private static final String ENTITY_PACKAGE = "yuyu.def.db.entity.";

    @Inject
    private static Logger logger;

    @Inject
    private TableDataReplacer replacer;

    private static TableDataReplacer backupReplacer;

    private static boolean firstFlg = true;

    List<Class<?>> clearTargets = null;

    List<Class<?>> backupTargets = null;

    private static boolean changeDateFlg = false;

    @Inject
    protected ExDBEntityManager em;

    protected void setClearTargets(Class<?>... classes){

        clearTargets = Lists.newArrayList(Arrays.asList(classes));
    }

    protected void setBackupTargets(Class<?>... classes){

        backupTargets = Lists.newArrayList(Arrays.asList(classes));
    }


    protected void beforeAllTest() {
    }

    @BeforeClass
    public static void callBeforeTestClass(){
        TestInitializer.initTestClass();
    }

    @Before
    public void testDataReplace(){
        //        dbReplace();
        TestInitializer.initTest();
        SWAKInjector.getInstance(ExDBEntityManager.class).clear();
        SWAKInjector.injectMembers(this);
    }

    @After
    public void afterTest(){

        if(changeDateFlg){
            SystemDateChange.revialSystemDateFile();
            changeDateFlg = false;
        }
        ConversationContext.shutdown();
    }

    protected void changeSystemDate(BizDate pDate){
        SystemDateChange.changeSystemDate(pDate);
        changeDateFlg = true;
    }

    protected void pageSeparate(){

        if(em.getTransaction().isActive()){
            em.clear();
            em.getTransaction().rollback();
        }
        em.getTransaction().begin();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private synchronized void dbReplace(){

        if(firstFlg){

            beforeAllTest();

            try{

                if(clearTargets != null){

                    for(Class<?> clazz : clearTargets){

                        Class<AbstractExDBEntity> entityClass = null;

                        try{
                            entityClass = (Class<AbstractExDBEntity>) clazz;
                        }
                        catch(ClassCastException e){
                            throw new RuntimeException("バックアップクリア対象にエンティティ以外のクラスが指定されました", e);
                        }


                        replacer.backupDelete(entityClass, true);
                    }
                }

                //              List<String> sheets = getTestDataSheetNames(new FileInputStream(getTestFilePath()));
                List<String> sheets = getTestDataSheetNames(getTestDataAsStream());

                if(sheets != null){

                    List<List<AbstractExDBEntity>> testEntityLists = Lists.newArrayList();

                    for(String entityname : sheets){

                        logger.debug(entityname + "の読み込みを開始します");

                        FileEntityManager fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(FileType.XLS);
                        FileDescription fd = fileEntityManager.parseDescription(Class.forName(ENTITY_PACKAGE + entityname), getTestDataAsStream(), entityname);

                        List<AbstractExDBEntity> entities = fileEntityManager.read(fd, getTestDataAsStream());

                        testEntityLists.add(entities);
                    }

                    replacer.tableDataReplace(backupTargets, testEntityLists);

                    backupReplacer = replacer;
                }
            }
            catch(FileNotFoundException e){

                logger.info("◆ テストデータファイルが見つからないため、洗替処理をスキップしました。");

            }
            catch(CvtVdtException e){

                for (Message msg : e.getMessages()) {
                    System.out.println(msg.getMessageType() + ": " + msg.getMessage());
                }
                throw new RuntimeException(e);
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
            finally{
                firstFlg = false;
            }
        }

        pageSeparate();
    }

    @AfterClass
    public static void afterAll(){

        //        if(backupReplacer != null){
        //
        //            backupReplacer.tableDataRestore();
        //
        //            backupReplacer = null;
        //        }

        if(changeDateFlg){
            SystemDateChange.revialSystemDateFile();
        }

        firstFlg = true;
        changeDateFlg = false;
    }

    //    private String getTestFilePath(){
    //
    //        String className = this.getClass().getName();
    //        int idx;
    //        className = (idx = className.indexOf("$$")) >= 0 ? className.substring(0, idx) : className;
    //
    //        return System.getProperty("user.dir") + "/src/test/java/" + className.replaceAll("\\.", "/") + ".xls";
    //    }

    private static final String[] EXCEL_FILE_EXTS = {
        "xls",
        "xlsx"
    };

    private InputStream getTestDataAsStream() {
        for (String excelFileExt : EXCEL_FILE_EXTS) {
            String excelFileName = getClass().getSimpleName().split("\\$\\$")[0] + "." + excelFileExt;
            InputStream istream = getClass().getResourceAsStream(excelFileName);
            if (istream != null) {
                return istream;
            }
        }
        return null;
    }

    private static List<String> getTestDataSheetNames(InputStream pInputStream) {

        if (pInputStream == null){
            logger.info("◆ テストデータファイルが見つからないため、洗替処理をスキップしました。");
            return null;
        }
        logger.info("◆ テストデータファイルがみつかりました。洗替処理を行います。");

        List<String> sheets = Lists.newArrayList();
        HSSFWorkbook book = null;

        try{
            book = new HSSFWorkbook(pInputStream);
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        for(int i=0; i<book.getNumberOfSheets(); i++){
            sheets.add(book.getSheetAt(i).getSheetName());
        }

        logger.debug("▽ sheets.size() = {}", Integer.valueOf(sheets.size()));
        for (String sheetName : sheets) {
            logger.debug("│ [{}]", sheetName);
        }
        logger.debug("△");

        return sheets;
    }
}
