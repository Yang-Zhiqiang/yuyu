package yuyu.infr.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.upload.UploadFile;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_FileStatusKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.entity.AT_FileHozonInfo;

import com.google.common.base.Strings;
import com.google.common.io.Files;

/**
 * ファイル保存用のユーティリティークラスです。
 */
public class FileHozonUtil {


    private static Logger logger = LoggerFactory.getLogger(FileHozonUtil.class);

    @Inject
    private BaseDomManager manager;
    @Inject
    protected UniqueKeyGenerator uniqueKeyGenerator;

    public static final String PATH_SEPARATOR1      = "\\";
    public static final String PATH_SEPARATOR2      = "/";
    public static final String KAIGYOUCD            = "\r\n";

    public boolean putFile(UploadFile upload,
            C_FileSyuruiCdKbn fileSyuruiCd,
            String haitaKey,
            String kinouId) {

        if (upload.getFileSize() <= 0) {
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0040));
            }
            return false;
        }
        try {
            return putFile(upload.getFileData(),
                    getBaseName(upload.getFileName()),
                    fileSyuruiCd,
                    haitaKey,
                    kinouId);
        } catch (IOException e) {
            throw new FileHozonException(e, MessageId.EAS0040);
        }
    }

    public boolean putFile(String filePath,
            C_FileSyuruiCdKbn fileSyuruiCd,
            String haitaKey,
            String kinouId) {

        File file = new File(SWAK.getApplicationRootFile() + filePath);

        if (!file.exists()) {
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0041));
            }
            return false;
        }
        try {
            return putFile(Files.toByteArray(file),
                    file.getName(),
                    fileSyuruiCd,
                    haitaKey,
                    kinouId);
        } catch (IOException e) {
            throw new FileHozonException(e, MessageId.EAS0040);
        }
    }

    @Transactional
    public boolean putFile(byte[] binary,
            String fileName,
            C_FileSyuruiCdKbn fileSyuruiCd,
            String haitaKey,
            String kinouId) {

        try {
            if (binary.length <= 0) {
                throw new FileHozonException(MessageUtil.getMessage(MessageId.EAS0041));
            }

            if (!checkFileNmPtn(fileSyuruiCd, fileName)) {
                throw new FileHozonException(MessageUtil.getMessage(MessageId.EAS0042));
            }

            if (!Strings.isNullOrEmpty(haitaKey)){
                List<AT_FileHozonInfo> fileInfoList = manager.getFileHozonInfoByHaitaKey(fileSyuruiCd, haitaKey);
                if(!fileInfoList.isEmpty()){
                    throw new FileHozonException(MessageUtil.getMessage(MessageId.EAS0043));
                }
            }

            byte[] zipBytes = BytesSerializer.zip(binary);

            String uniqueId = uniqueKeyGenerator.generateUniqueKey();

            AT_FileHozon fileHozon = new AT_FileHozon(uniqueId);
            AT_FileHozonInfo fileHozonInfo = new AT_FileHozonInfo(uniqueId);

            fileHozonInfo.setFileNm(fileName);
            fileHozonInfo.setFileSyuruiCd(fileSyuruiCd);
            fileHozonInfo.setFileStatusKbn(C_FileStatusKbn.UPLOADING);
            fileHozonInfo.setHaitaKey(haitaKey);
            fileHozonInfo.setTourokuTime(BizDate.getSysDateTimeMilli());
            fileHozonInfo.setSakuseiKinouId(kinouId);

            manager.insert(fileHozon);
            manager.insert(fileHozonInfo);

            AT_FileHozon uploadFile = manager.getFileHozon(uniqueId);
            AT_FileHozonInfo uploadFileInfo = manager.getFileHozonInfo(uniqueId);
            uploadFileInfo.setFileStatusKbn(C_FileStatusKbn.NONE);

            uploadFile.setFileContents(zipBytes);

            manager.flush();

            return true;
        }
        catch (FileHozonException e) {
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0046));
            }
            return false;
        }
    }

    public List<AT_FileHozonInfo> getFileInfoList(FileSearchCondition condition) {

        return manager.getFileHozonInfoByAllCondition(condition.getUniqueId(),
                condition.getFileName(),
                condition.getFileSyuruiCd(),
                condition.getHaitaKey(),
                condition.getTourokuTimeFrom(),
                condition.getTourokuTimeTo(),
                condition.getSakuseiKinouId(),
                condition.getUserId());
    }

    public int deleteFile(List<String> uniqueIdList) {

        int delCnt = 0;

        for(String uniqueId:uniqueIdList){
            AT_FileHozonInfo hozonInfo = manager.getFileHozonInfo(uniqueId);

            if(null != hozonInfo){
                manager.delete(hozonInfo.getFileHozon());
                manager.delete(hozonInfo);
                delCnt++;
            }
        }
        manager.flush();
        return delCnt;
    }

    public boolean checkFileNmPtn(C_FileSyuruiCdKbn fileSyuruiCd, String fileName) {

        if(null == fileSyuruiCd ||
                Strings.isNullOrEmpty(fileName) ){
            return true;
        }

        AS_FileSyurui fileSyurui = manager.getFileSyurui(fileSyuruiCd);

        if(fileSyurui == null){
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0048));
            }
            return false;
        }

        if (Strings.isNullOrEmpty(fileSyurui.getFileNmPattern())) {
            return true;
        }

        return fileName.matches(fileSyurui.getFileNmPattern());
    }



    public byte[] convList2Bytes(List<String> list) throws IOException{

        StringBuffer buffer = new StringBuffer();
        for(String str:list){
            buffer.append(str);
            buffer.append(KAIGYOUCD);
        }
        byte[] bytes = buffer.toString().getBytes("MS932");
        return bytes;
    }

    String getBaseName(String filePath) {

        int index1 = filePath.lastIndexOf(PATH_SEPARATOR1);
        int index2 = filePath.lastIndexOf(PATH_SEPARATOR2);
        int iIndex;
        if (index1 == -1) {
            if (index2 == -1) {
                return filePath;
            }
            iIndex = index2;
        }
        else {
            if (index2 == -1) {
                iIndex = index1;
            }
            else {
                if (index1 > index2) {
                    iIndex = index1;
                }
                iIndex = index2;
            }
        }
        return filePath.substring(iIndex + 1);
    }

}
