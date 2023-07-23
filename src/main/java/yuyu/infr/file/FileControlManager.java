package yuyu.infr.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.db.typesafe.ExDBEntity;
import jp.co.slcs.swak.file.FileDescription;
import jp.co.slcs.swak.file.FileEntityManager;
import jp.co.slcs.swak.file.FileEntityManagerFactory;
import jp.co.slcs.swak.file.FileEntityReader;
import jp.co.slcs.swak.file.FileEntityWriter;
import jp.co.slcs.swak.file.FileType;
import jp.co.slcs.swak.file.description.ColumnDesc;
import jp.co.slcs.swak.file.description.HeadDesc;
import jp.co.slcs.swak.file.exception.CvtVdtException;
import jp.co.slcs.swak.file.manager.Configuration;
import yuyu.infr.NoDataDummyBean;

/**
 * ファイル操作管理するクラスです。<br />
 * ファイル操作に関連する機能を収めます。<br />
 */
public class FileControlManager {

    public <T> List<T> readFileData(String pFilePath, Class<T> pBeanClass, FileType pType) throws IOException, CvtVdtException {
        return readFileData(pFilePath, pBeanClass, pType, true);
    }

    public <T> List<T> readFileData(String pFilePath, Class<T> pBeanClass, FileType pType, boolean pFailOnError) throws IOException, CvtVdtException {
        List<T> list;
        try (InputStream is = new FileInputStream(pFilePath)) {
            FileEntityManager fileEntityManager = createFileEntityManager(pType, pFailOnError);

            list =  fileEntityManager.read(pBeanClass, is);
        }

        AccessLog.FileRead.log(pFilePath);
        return list;
    }

    private static FileEntityManager createFileEntityManager(FileType pType, boolean pFailOnError) {
        FileEntityManager fileEntityManager = null;
        if (pFailOnError) {
            fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(pType);
        } else {
            Configuration conf = new Configuration();
            conf.setConfig(Configuration.LENIENT, "true");
            fileEntityManager = FileEntityManagerFactory.getDefaultFactory().createFileEntityManager(pType, conf);
        }
        return fileEntityManager;
    }

    @SuppressWarnings("resource")
    public <T> FileEntityReader<T> getFileEntityReader(String pFilePath, Class<T> pBeanClass, FileType pType) throws IOException {
        FileEntityManager fileEntityManager = createFileEntityManager(pType, true);
        try {
            return fileEntityManager.getFileEntityReader(pBeanClass, new FileInputStream(pFilePath));
        } finally {
            AccessLog.FileRead.log(pFilePath);
        }
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXls(String pFilePath, Class<T> pEntityClass) throws IOException, CvtVdtException {
        return readDbFileDataFromXls(pFilePath, pEntityClass, true);
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXls(String pFilePath, Class<T> pEntityClass, boolean pFailOnError) throws IOException, CvtVdtException {
        return readFileData(pFilePath, pEntityClass, FileType.XLS, pFailOnError);
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXlsx(String pFilePath, Class<T> pEntityClass) throws IOException, CvtVdtException {
        return readDbFileDataFromXlsx(pFilePath, pEntityClass, true);
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXlsx(String pFilePath, Class<T> pEntityClass, boolean pFailOnError) throws IOException, CvtVdtException {
        return readFileData(pFilePath, pEntityClass, FileType.XLSX, pFailOnError);
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXls(String pFilePath, String pSheetName, Class<T> pEntityClass) throws IOException, CvtVdtException {
        return readDbFileDataFromXls(pFilePath, pSheetName, pEntityClass, true);
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXls(String pFilePath, String pSheetName, Class<T> pEntityClass, boolean pFailOnError) throws IOException, CvtVdtException {
        FileEntityManager fileEntityManager = createFileEntityManager(FileType.XLS, pFailOnError);
        List<T> list;

        try (InputStream iStream1 = new FileInputStream(pFilePath)) {
            FileDescription<T, ? extends HeadDesc, ? extends ColumnDesc> fDesc = fileEntityManager.parseDescription(pEntityClass, iStream1, pSheetName);

            try (InputStream iStream2 = new FileInputStream(pFilePath)) {
                list = fileEntityManager.read(fDesc, iStream2);
            }
        }

        AccessLog.FileRead.log(pFilePath);
        return list;
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXlsx(String pFilePath, String pSheetName, Class<T> pEntityClass) throws IOException, CvtVdtException {
        return readDbFileDataFromXlsx(pFilePath, pSheetName, pEntityClass, true);
    }

    public <T extends ExDBEntity<T,?>> List<T> readDbFileDataFromXlsx(String pFilePath, String pSheetName, Class<T> pEntityClass, boolean pFailOnError) throws IOException, CvtVdtException {
        FileEntityManager fileEntityManager = createFileEntityManager(FileType.XLSX, pFailOnError);

        List<T> list;
        try (InputStream iStream1 = new FileInputStream(pFilePath)) {
            FileDescription<T, ? extends HeadDesc, ? extends ColumnDesc> fDesc = fileEntityManager.parseDescription(pEntityClass, iStream1, pSheetName);

            try (InputStream iStream2 = new FileInputStream(pFilePath)) {
                list = fileEntityManager.read(fDesc, iStream2);
            }
        }

        AccessLog.FileRead.log(pFilePath);
        return list;
    }

    public <T> void writeFileData(String pFilePath, List<T> pData, Class<T> classt, FileType pType) throws IOException {
        writeFileData(pFilePath,pData,classt,pType,false);
    }

    @SuppressWarnings({ "unchecked"})
    public <T> void writeFileData(String pFilePath, List<T> pData, FileType pType) throws IOException{
        if(pData == null || pData.size()==0){
            writeFileData(pFilePath, new ArrayList<NoDataDummyBean>(), NoDataDummyBean.class, pType, false);
        }else{
            writeFileData(pFilePath, pData, (Class<T>)pData.get(0).getClass() , pType, false);
        }
    }

    public <T> void writeFileData(String pFilePath, List<T> pData, Class<T> classt, FileType pType, boolean pCreateEmptyFile) throws IOException {
        FileEntityManager fileEntityManager = createFileEntityManager(pType, true);
        try (OutputStream outputStream = new FileOutputStream(pFilePath)) {
            if (pData != null && pData.size() > 0 && pData.get(0) != null || pCreateEmptyFile) {
                fileEntityManager.write(classt, pData, outputStream);

                AccessLog.FileWrite.log(pFilePath);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if ( (pData == null || pData.size() <= 0) && !pCreateEmptyFile) {
            new File(pFilePath).delete();
        }
    }

    @SuppressWarnings("resource")
    public <T> FileEntityWriter<T> getFileEntityWriter(String pFilePath, Class<T> pBeanClass, FileType pType) throws IOException {
        FileEntityManager fileEntityManager = createFileEntityManager(pType, true);
        try {
            return fileEntityManager.getFileEntityWriter(pBeanClass, new FileOutputStream(pFilePath));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            AccessLog.FileWrite.log(pFilePath);
        }
    }

    @SuppressWarnings({ "unchecked"})
    public <T extends ExDBEntity<T,?>> void writeDbFileDataToXls(String pFilePath, List<T> pEntityList) throws IOException {
        if(pEntityList == null || pEntityList.size()==0){
            writeFileData(pFilePath, new ArrayList<NoDataDummyBean>(), NoDataDummyBean.class,FileType.XLS);
        }else{
            writeFileData(pFilePath, pEntityList, (Class<T>)pEntityList.get(0).getClass(),FileType.XLS);
        }
    }

    @SuppressWarnings({ "unchecked"})
    public <T extends ExDBEntity<T,?>> void writeDbFileDataToXlsx(String pFilePath, List<T> pEntityList) throws IOException {
        if(pEntityList == null || pEntityList.size()==0){
            writeFileData(pFilePath, new ArrayList<NoDataDummyBean>(), NoDataDummyBean.class,FileType.XLSX);
        }else{
            writeFileData(pFilePath, pEntityList, (Class<T>)pEntityList.get(0).getClass(),FileType.XLSX);
        }
    }

    public <T extends ExDBEntity<T,?>> void writeDbFileDataToXls(String pFilePath, List<T> pEntityList, Class<T> classt) throws IOException {
        writeFileData(pFilePath, pEntityList, classt,FileType.XLS);
    }

    public <T extends ExDBEntity<T,?>> void writeDbFileDataToXlsx(String pFilePath, List<T> pEntityList, Class<T> classt) throws IOException {
        writeFileData(pFilePath, pEntityList, classt, FileType.XLSX);
    }

    public boolean isExistFile(String pFilePath) {
        return new File(pFilePath).exists();
    }

    public void copy(String pFromPath, String pToDir) throws IOException {
        copy(new File(pFromPath), new File(pToDir));
    }

    public void copy(File pFile, File pToDir) throws IOException {
        if (!pFile.exists()) {
            return;
        }
        if (!pToDir.exists()) {
            pToDir.mkdirs();
        }
        File toFile = new File(pToDir, pFile.getName());
        copy0(pFile, toFile);

        AccessLog.FileCopy.log(pFile.getAbsolutePath() + " => " + toFile.getAbsolutePath());
    }

    public void copy(String[] pFromPaths, String pToDir) throws IOException {
        if (pFromPaths != null && pFromPaths.length > 0) {
            for (String f : pFromPaths) {
                copy(f, pToDir);
            }
        }
    }

    private void copy0(File pFromFile, File pToFile) throws IOException {
        if (pFromFile.isFile()) {
            Files.copy(pFromFile.toPath(), pToFile.toPath());
        } else if (pFromFile.isDirectory()) {
            pToFile.mkdir();
            File[] fs = pFromFile.listFiles();
            if (fs != null && fs.length > 0) {
                for (File f : fs) {
                    copy0(f, new File(pToFile, f.getName()));
                }
            }
        }
    }

    public void move(String pFromPath, String pToDir) {
        File f = new File(pFromPath);
        if (!f.exists()) {
            return;
        }
        File pToDirFile = new File(pToDir);
        if (!pToDirFile.exists()) {
            pToDirFile.mkdirs();
        }
        File toFile = new File(pToDirFile, f.getName());
        f.renameTo(toFile);

        AccessLog.FileMove.log(f.getAbsolutePath() + " => " + toFile.getAbsolutePath());
    }

    public void move(String[] pFromPaths, String pToDir) {
        if (pFromPaths != null && pFromPaths.length > 0) {
            for (String f : pFromPaths) {
                move(f, pToDir);
            }
        }
    }

    public void rename(String pFilePath, String pFileName) {
        File f = new File(pFilePath);
        if (!f.exists()) {
            return;
        }
        File toFile = new File(f.getParentFile(), pFileName);
        f.renameTo(toFile);

        AccessLog.FileMove.log(f.getAbsolutePath() + " => " + toFile.getAbsolutePath());
    }

    public void remove(String pFilePath) {
        remove(new File(pFilePath));
    }

    public void remove(File pFile) {
        if (!pFile.exists()) {
            return;
        }
        remove0(pFile);

        AccessLog.FileRemove.log(pFile.getAbsolutePath());
    }

    private void remove0(File pFile) {
        if (pFile.isDirectory()) {
            File[] fs = pFile.listFiles();
            if (fs != null && fs.length > 0) {
                for (File f : fs) {
                    remove0(f);
                }
            }
        }
        pFile.delete();
    }

    public void createDir(String pFilePath) {
        File f = new File(pFilePath);
        if (f.exists()) {
            return;
        }

        f.mkdirs();
    }

    public Calendar getCreateTime(String pFilePath) throws IOException {
        File f = new File(pFilePath);
        if (!f.exists()) {
            return null;
        }

        Path p = Paths.get(pFilePath);
        BasicFileAttributes view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(view.creationTime().toMillis());
        return date;
    }

    public Calendar getUpdateTime(String pFilePath) {
        File f = new File(pFilePath);
        if (!f.exists()) {
            return null;
        }
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(f.lastModified());
        return date;
    }
}
