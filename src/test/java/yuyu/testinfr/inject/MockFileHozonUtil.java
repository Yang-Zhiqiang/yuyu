package yuyu.testinfr.inject;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.inject.Inject;

import jp.co.slcs.swak.SWAK;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.infr.file.BytesSerializer;
import yuyu.infr.file.FileHozonException;
import yuyu.infr.file.FileHozonUtil4Online;

import com.google.common.base.Strings;

public class MockFileHozonUtil extends FileHozonUtil4Online {

    @Inject
    private BaseDomManager manager;

    private String outputPath = "";

    public void setOutputPath(String pOutputPath){
        outputPath = pOutputPath;
    }

    //    @Override
    //    public boolean getFile2Screen(FileSearchCondition condition, String... fileName) throws Exception {
    //
    //        List<AT_FileHozonInfo> fileHozonList = manager.getFileHozonInfoByFileSyuruiCd(condition.getFileSyuruiCd());
    //
    //        if(fileHozonList.isEmpty()){
    //            return false;
    //        }
    //
    //        String makeFileName = "";
    //        if(fileName.length > 0 &&
    //           !Strings.isNullOrEmpty(fileName[0])){
    //            makeFileName = fileName[0];
    //        } else {
    //            makeFileName = fileHozonList.get(0).getFileNm();
    //        }
    //
    //        if(1 == fileHozonList.size()){
    //            return makeFile(fileHozonList.get(0), makeFileName);
    //        } else {
    //            return makeZipFile(fileHozonList, makeFileName);
    //        }
    //    }

    @Override
    public boolean makeFile(AT_FileHozonInfo fileHozonInfo,  String fileName) {

        if(!Strings.isNullOrEmpty(outputPath)){
            outputPath = outputPath.replace('\\', '/');
            if(!outputPath.substring(outputPath.length() - 1).equals("/")) {
                outputPath = outputPath + "/";
            }
        }

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();) {

            File file = null;
            if(Strings.isNullOrEmpty(outputPath)){
                file = new File(SWAK.getApplicationRootFile() + "/test_out/" + fileHozonInfo.getFileNm());
            } else {
                file = new File(outputPath + fileHozonInfo.getFileNm());
            }
            try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));){
                bos.write(BytesSerializer.unzip(manager.getFileHozon(fileHozonInfo.getUniqueId()).getFileContents()));
            } catch (Exception e2) {
                throw new FileHozonException(e2, "EAS0007");
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean makeZipFile(List<AT_FileHozonInfo> fileHozonInfoList, String zipFileName) {

        if(!Strings.isNullOrEmpty(outputPath)){
            outputPath = outputPath.replace('\\', '/');
            if(!outputPath.substring(outputPath.length() - 1).equals("/")) {
                outputPath = outputPath + "/";
            }
        }

        String fileName;
        if (!Strings.isNullOrEmpty(zipFileName)){
            fileName = zipFileName;
        } else {
            fileName = fileHozonInfoList.get(0).getFileNm();
        }

        File file = null;
        if(Strings.isNullOrEmpty(outputPath)){
            file = new File(SWAK.getApplicationRootFile() + "/test_out/" + fileName);
        } else {
            file = new File(outputPath + fileName);
        }

        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file));){

            ArrayList<String> list = new ArrayList<String>();
            String tempFileName = null;
            int iPrefix = 1;
            for (AT_FileHozonInfo fileHozonInfo:fileHozonInfoList) {
                if(list.contains(fileHozonInfo.getFileNm())){
                    tempFileName = "[" + Integer.toString(iPrefix) + "]" + fileHozonInfo.getFileNm();
                    iPrefix++;
                } else {
                    tempFileName = fileHozonInfo.getFileNm();
                }
                list.add(tempFileName);
                zos.putNextEntry(new ZipEntry(tempFileName));
                zos.write(BytesSerializer.unzip(manager.getFileHozon(fileHozonInfo.getUniqueId()).getFileContents()));
                zos.closeEntry();
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
