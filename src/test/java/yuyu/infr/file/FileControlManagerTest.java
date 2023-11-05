package yuyu.infr.file;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.file.FileEntityReader;
import jp.co.slcs.swak.file.FileEntityWriter;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.exception.CvtVdtException;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

@RunWith(SWAKTestRunner.class)
public class FileControlManagerTest extends AbstractTest{

    @Inject
    private FileControlManager fcm;

    @Test
    @TestOrder(1)
    public void test_Operation() throws IOException {

    	fcm.createDir("target/rename/dir");
        newTestFile("target/rename/file.txt");
        exBooleanEquals(new File("target/rename").exists(), true, "フォルダ作成");
        exBooleanEquals(new File("target/rename/dir").exists(), true, "フォルダ作成");

        fcm.rename("target/rename", "rename2");
        exBooleanEquals(new File("target/rename").exists(), false, "フォルダリネーム");
        exBooleanEquals(new File("target/rename2").exists(), true, "フォルダリネーム");
        exBooleanEquals(new File("target/rename2/file.txt").exists(), true, "フォルダリネーム");
        exBooleanEquals(new File("target/rename2/dir").exists(), true, "フォルダリネーム");

        fcm.move("target/rename2", "target/move");
        exBooleanEquals(new File("target/rename2").exists(), false, "フォルダ移動");
        exBooleanEquals(new File("target/move/rename2").exists(), true, "フォルダ移動");
        exBooleanEquals(new File("target/move/rename2/dir").exists(), true, "フォルダ移動");
        exBooleanEquals(new File("target/move/rename2/file.txt").exists(), true, "フォルダ移動");

        exBooleanEquals(fcm.isExistFile("target/rename2"), false, "フォルダ存在チェック");
        exBooleanEquals(fcm.isExistFile("target/move/rename2"), true, "フォルダ存在チェック");

        fcm.copy("target/move/rename2", "target/copy");
        exBooleanEquals(new File("target/move/rename2").exists(), true, "フォルダコピー");
        exBooleanEquals(new File("target/move/rename2/dir").exists(), true, "フォルダコピー");
        exBooleanEquals(new File("target/move/rename2/file.txt").exists(), true, "フォルダコピー");
        exBooleanEquals(new File("target/copy/rename2").exists(), true, "フォルダコピー");
        exBooleanEquals(new File("target/copy/rename2/dir").exists(), true, "フォルダコピー");
        exBooleanEquals(new File("target/copy/rename2/file.txt").exists(), true, "フォルダコピー");
        BufferedReader r = Files.newBufferedReader(new File("target/copy/rename2/file.txt").toPath(), Charset.forName("UTF-8"));
        exStringEquals(r.readLine(), "あいうえお", "フォルダコピー");
        r.close();

        fcm.remove("target/move");
        exBooleanEquals(new File("target/move").exists(), false, "フォルダ削除");
        fcm.remove("target/copy");
        exBooleanEquals(new File("target/copy").exists(), false, "フォルダ削除");

        newTestFile("target/file.txt");
        fcm.rename("target/file.txt", "rename2.bat");
        exBooleanEquals(new File("target/file.txt").exists(), false, "ファイルリネーム");
        exBooleanEquals(new File("target/rename2.bat").exists(), true, "ファイルリネーム");

        fcm.move("target/rename2.bat", "target/move");
        exBooleanEquals(new File("target/rename2.bat").exists(), false, "ファイル移動");
        exBooleanEquals(new File("target/move/rename2.bat").exists(), true, "ファイル移動");

        exBooleanEquals(fcm.isExistFile("target/rename2.bat"), false, "ファイル存在チェック");
        exBooleanEquals(fcm.isExistFile("target/move/rename2.bat"), true, "ファイル存在チェック");

        fcm.copy("target/move/rename2.bat", "target/copy");
        exBooleanEquals(new File("target/move/rename2.bat").exists(), true, "ファイルコピー");
        exBooleanEquals(new File("target/copy/rename2.bat").exists(), true, "ファイルコピー");
        r = Files.newBufferedReader(new File("target/copy/rename2.bat").toPath(), Charset.forName("UTF-8"));
        exStringEquals(r.readLine(), "あいうえお", "ファイルコピー");
        r.close();

        fcm.remove("target/move/rename2.bat");
        exBooleanEquals(new File("target/move/rename2.bat").exists(), false, "ファイル削除");
        fcm.remove("target/copy/rename2.bat");
        exBooleanEquals(new File("target/copy/rename2.bat").exists(), false, "ファイル削除");
        fcm.remove("target/move");
        fcm.remove("target/copy");

        newTestFile("target/file.txt");
        fcm.createDir("target/テスト");
        newTestFile("target/テスト/file２.txt");
        fcm.move(new String[] {"target/file.txt", "target/テスト/file２.txt"}, "target/move");
        exBooleanEquals(new File("target/file.txt").exists(), false, "ファイル移動");
        exBooleanEquals(new File("target/テスト/file２.txt").exists(), false, "ファイル移動");
        exBooleanEquals(new File("target/move/file.txt").exists(), true, "ファイル移動");
        r = Files.newBufferedReader(new File("target/move/file.txt").toPath(), Charset.forName("UTF-8"));
        exStringEquals(r.readLine(), "あいうえお", "ファイルコピー");
        r.close();
        exBooleanEquals(new File("target/move/file２.txt").exists(), true, "ファイル移動");
        r = Files.newBufferedReader(new File("target/move/file２.txt").toPath(), Charset.forName("UTF-8"));
        exStringEquals(r.readLine(), "あいうえお", "ファイルコピー");
        r.close();

        newTestFile("target/file.txt");
        fcm.copy(new String[] {"target/file.txt", "target/move/file２.txt"}, "target/copy");
        exBooleanEquals(new File("target/file.txt").exists(), true, "ファイルコピー");
        exBooleanEquals(new File("target/move/file２.txt").exists(), true, "ファイルコピー");
        exBooleanEquals(new File("target/copy/file.txt").exists(), true, "ファイルコピー");
        r = Files.newBufferedReader(new File("target/copy/file.txt").toPath(), Charset.forName("UTF-8"));
        exStringEquals(r.readLine(), "あいうえお", "ファイルコピー");
        r.close();
        exBooleanEquals(new File("target/copy/file２.txt").exists(), true, "ファイルコピー");
        r = Files.newBufferedReader(new File("target/copy/file２.txt").toPath(), Charset.forName("UTF-8"));
        exStringEquals(r.readLine(), "あいうえお", "ファイルコピー");
        r.close();

        fcm.remove("target/file.txt");
        fcm.remove("target/テスト");
        fcm.remove("target/move");
        fcm.remove("target/copy");
    }

    @Test
    @TestOrder(2)
    public void test_Info() throws IOException {
        newTestFile("target/file.txt");
        long l = new File("target/file.txt").lastModified();

        long diff = l - fcm.getCreateTime("target/file.txt").getTimeInMillis();
        exBooleanEquals(diff >= 0 && diff < 500, true,  "作成時間");
        exStringEquals(Long.toString(fcm.getUpdateTime("target/file.txt").getTimeInMillis()), Long.toString(l), "更新時間");
        fcm.remove("target/file.txt");
    }

    @Test
    @TestOrder(3)
    public void test_FileEntityManager() throws IOException, CvtVdtException {
        List<TestEntity> datas = Lists.newArrayList();
        TestEntity ent = new TestEntity();
        ent.setName("1234567");
        ent.setAge("88");
        datas.add(ent);
        ent = new TestEntity();
        ent.setName("○");
        ent.setAge("８８");
        datas.add(ent);
        fcm.writeFileData("target/test.xls", datas, TestEntity.class ,FileType.XLS);
        List<TestEntity> datas2 = fcm.readFileData("target/test.xls", TestEntity.class, FileType.XLS);
        exListEquals(datas2, datas, "FileEntityManagerチェック");
        fcm.remove("target/test.xls");

        try (FileEntityWriter<TestEntity> few = fcm.getFileEntityWriter("target/test.xls", TestEntity.class, FileType.XLS)) {
            for (TestEntity e : datas) {
                few.write(e);
            }
        }
        datas2 = Lists.newArrayList();
        try (FileEntityReader<TestEntity> fer = fcm.getFileEntityReader("target/test.xls", TestEntity.class, FileType.XLS)) {
            while (fer.hasNext()) {
                datas2.add(fer.next());
            }
        }
        exListEquals(datas2, datas, "FileEntityManagerチェック");
        fcm.remove("target/test.xls");

        fcm.writeDbFileDataToXls("target/test.xls", datas,TestEntity.class );
        datas2 = fcm.readDbFileDataFromXls("target/test.xls", TestEntity.class);
        exListEquals(datas2, datas, "FileEntityManagerチェック");
        datas2 = fcm.readDbFileDataFromXls("target/test.xls", "TestEntity", TestEntity.class);
        exListEquals(datas2, datas, "FileEntityManagerチェック");
//        fcm.remove("target/test.xls");

        fcm.writeDbFileDataToXlsx("target/test.xlsx", datas,TestEntity.class);
        datas2 = fcm.readDbFileDataFromXlsx("target/test.xlsx", TestEntity.class);
        exListEquals(datas2, datas, "FileEntityManagerチェック");
        datas2 = fcm.readDbFileDataFromXlsx("target/test.xlsx", "TestEntity", TestEntity.class);
        exListEquals(datas2, datas, "FileEntityManagerチェック");
//        fcm.remove("target/test.xlsx");


    }


    @Test
    @TestOrder(4)
    public void test_FileEntityManagerEmptyFile() throws IOException, CvtVdtException {
        List<TestEntity> datas = Lists.newArrayList();
//        TestEntity ent = new TestEntity();
//        ent.setName("1234567");
//        ent.setAge("88");
//        datas.add(ent);
//        ent = new TestEntity();
//        ent.setName("○");
//        ent.setAge("８８");
//        datas.add(ent);

        fcm.writeFileData("target/testEmptyFile.xls", datas, TestEntity.class ,FileType.XLS);
        File testEmptyFile = new File("target/testEmptyFile.xls");
        assertTrue(!testEmptyFile.exists());
//        List<TestEntity> datas2 = fcm.readFileData("target/testEmptyFile.xls", TestEntity.class, FileType.XLS);
//        assertTrue(datas2.size()==0);

//        fcm.remove("target/testEmptyFile.xls");

        fcm.writeDbFileDataToXls("target/test.xls", null, TestEntity.class);
        testEmptyFile = new File("target/test.xls");
        assertTrue(!testEmptyFile.exists());
//        datas2 = fcm.readDbFileDataFromXls("target/test.xls", TestEntity.class);
//        assertTrue(datas2.size()==0);
//        fcm.remove("target/test.xls");

        fcm.writeDbFileDataToXlsx("target/test.xlsx", datas, TestEntity.class);
        testEmptyFile = new File("target/test.xls");
        assertTrue(!testEmptyFile.exists());
//        datas2 = fcm.readDbFileDataFromXlsx("target/test.xlsx", TestEntity.class);
//        assertTrue(datas2.size()==0);
//        fcm.remove("target/test.xlsx");
    }

    private void newTestFile(String file) throws IOException {
        BufferedWriter w = Files.newBufferedWriter(new File(file).toPath(), Charset.forName("UTF-8"));
        w.write("あいうえお");
        w.close();
    }

    @Test
    @TestOrder(5)
    public void test_FileEntityManagerCreateEmptyFile() throws IOException, CvtVdtException {

        List<TestEntity> datas = Lists.newArrayList();
        TestEntity ent = new TestEntity();
        ent=null;
        fcm.writeFileData("target/testTrueLebellessFalse.xls", datas, TestEntity.class ,FileType.XLS,true);
        List<TestEntity> datas2 = Lists.newArrayList();
        try (FileEntityReader<TestEntity> fer = fcm.getFileEntityReader("target/testTrueLebellessFalse.xls", TestEntity.class, FileType.XLS)) {
            while (fer.hasNext()) {
                datas2.add(fer.next());
            }
        }
        assertTrue(datas2.size()==0);


        List<TestEntityLabellesTrue> datasLabellesTrue = null;
        fcm.writeFileData("target/testTrueLebellessTrue.xls", datasLabellesTrue, TestEntityLabellesTrue.class ,FileType.XLS,true);
        List<TestEntityLabellesTrue> datasLabellesTrue2 = Lists.newArrayList();
        try (FileEntityReader<TestEntityLabellesTrue> fer = fcm.getFileEntityReader("target/testTrueLebellessTrue.xls", TestEntityLabellesTrue.class, FileType.XLS)) {
            while (fer.hasNext()) {
                datasLabellesTrue2.add(fer.next());
            }
        }
        assertTrue(datasLabellesTrue2.size()==0);



        fcm.writeFileData("target/testFalseLebellessFalse.xls", datas, TestEntity.class ,FileType.XLS,false);
        assertTrue(!new File("target/testFalseLebellessFalse.xls").exists());

        fcm.writeFileData("target/testFalseLebellessTrue.xls", datasLabellesTrue, TestEntityLabellesTrue.class ,FileType.XLS,false);
        assertTrue(!new File("target/testFalseLebellessTrue.xls").exists());

        ent = new TestEntity();
        ent.setName("1234567");
        ent.setAge("88");
        datas.add(ent);
        ent = new TestEntity();
        ent.setName("○");
        ent.setAge("８８");
        datas.add(ent);
        fcm.writeFileData("target/testFalseDataExitst.xls", datas, TestEntity.class ,FileType.XLS,false);


        try (FileEntityReader<TestEntity> fer = fcm.getFileEntityReader("target/testFalseDataExitst.xls", TestEntity.class, FileType.XLS)) {
            int i = 0;
            while (fer.hasNext()) {
                assertTrue(datas.get(i).equals(fer.next()));
                i++;
            }
        }

    }

}
