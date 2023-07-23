package yuyu.infr.file;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.YuyuStandardCharsets;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_FileHozon;
import yuyu.def.db.entity.AT_FileHozonInfo;

import com.google.common.base.Strings;

/**
 * ファイル保存用のユーティリティークラスです。<br />
 * FileHozonUtilのメソッドのうち、servletを使用している（オンラインのみで動作可能）メソッドのみを抜きだしました。<br />
 * FileHozonUtilを継承しているため、このクラスからその他のメソッドを使用することも可能です。<br />
 * バッチから使用する場合は、FileHozonUtilを使用してください。
 */
public class FileHozonUtil4Online extends FileHozonUtil{

    private static Logger logger = LoggerFactory.getLogger(FileHozonUtil.class);

    @Inject
    private BaseDomManager manager;

    public boolean getFile2Screen(FileSearchCondition condition, String... fileName) {
        List<AT_FileHozonInfo> fileHozonList = manager.getFileHozonInfoByAllCondition(condition.getUniqueId(),
                condition.getFileName(),
                condition.getFileSyuruiCd(),
                condition.getHaitaKey(),
                condition.getTourokuTimeFrom(),
                condition.getTourokuTimeTo(),
                condition.getSakuseiKinouId(),
                condition.getUserId());

        if(fileHozonList.isEmpty()){
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0047));
            }
            return false;
        }

        String makeFileName = "";
        if(fileName.length > 0 &&
                !Strings.isNullOrEmpty(fileName[0])){
            makeFileName = fileName[0];
        } else {
            makeFileName = fileHozonList.get(0).getFileNm();
        }

        if(1 == fileHozonList.size() && !condition.isForceCompress()){
            return makeFile(fileHozonList.get(0), makeFileName);
        }

        makeFileName = makeFileName + ".zip";

        return makeZipFile(fileHozonList, makeFileName);
    }

    public boolean makeFile(AT_FileHozonInfo fileHozonInfo, String fileName) {

        String encFileName = null;
        try {
            encFileName = URLEncoder.encode(fileName, YuyuStandardCharsets.UTF_8_STRING);
        } catch (UnsupportedEncodingException e1) {
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0044));
            }
            return false;
        }

        AT_FileHozon fileHozon = manager.getFileHozon(fileHozonInfo.getUniqueId());

        if(fileHozon == null || fileHozon.getFileContents() == null){
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0044));
            }
            return false;
        }

        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        response.setHeader("Content-Disposition", "attachment; filename=\"" + encFileName + "\";");

        try(ServletOutputStream oSos =  response.getOutputStream();){
            oSos.write(BytesSerializer.unzip(fileHozon.getFileContents()));
        } catch(Exception e) {
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0044));
            }
            return false;
        }
        return true;
    }

    public boolean makeZipFile(List<AT_FileHozonInfo> fileHozonInfoList, String zipFileName) {

        String encFileName = null;
        try {
            encFileName = URLEncoder.encode(zipFileName, YuyuStandardCharsets.UTF_8_STRING);
        } catch (UnsupportedEncodingException e1) {
            if (logger.isDebugEnabled()) {
                logger.debug(MessageUtil.getMessage(MessageId.EAS0045));
            }
            return false;
        }

        Set<String> dupFileNmSet = new HashSet<String>();
        Map<String, String> fileNmMap = new HashMap<String,String>();
        String sFileNm = null;
        int iPrefix = 1;
        List<AT_FileHozon> fileHozonList = new ArrayList<AT_FileHozon>();
        for (AT_FileHozonInfo fileHozonInfo : fileHozonInfoList) {

            if(dupFileNmSet.contains(fileHozonInfo.getFileNm())){
                sFileNm = "[" + Integer.toString(iPrefix) + "]" + fileHozonInfo.getFileNm();
                iPrefix++;
            } else {
                sFileNm = fileHozonInfo.getFileNm();
            }
            dupFileNmSet.add(sFileNm);

            AT_FileHozon fileHozon = manager.getFileHozon(fileHozonInfo.getUniqueId());

            if(fileHozon == null || fileHozon.getFileContents() == null){
                if (logger.isDebugEnabled()) {
                    logger.debug(MessageUtil.getMessage(MessageId.EAS0045));
                }
                return false;
            }

            fileHozonList.add(fileHozon);

            fileNmMap.put(fileHozon.getUniqueId(),sFileNm);
        }

        HttpServletResponse response = SWAKInjector.getInstance(HttpServletResponse.class);

        response.setContentType("application/x-zip-compressed");

        response.setHeader("Content-Disposition", "attachment; filename=\"" + encFileName + "\";");

        for (AT_FileHozon fileHozon : fileHozonList) {
            try(ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());){
                zos.putNextEntry(new ZipEntry(fileNmMap.get(fileHozon.getUniqueId())));
                zos.write(BytesSerializer.unzip(fileHozon.getFileContents()));
                zos.closeEntry();
            } catch(Exception e) {
                if (logger.isDebugEnabled()) {
                    logger.debug(MessageUtil.getMessage(MessageId.EAS0045));
                }
                return false;
            }

        }

        return true;
    }

}
