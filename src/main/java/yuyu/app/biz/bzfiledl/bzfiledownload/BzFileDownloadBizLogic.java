package yuyu.app.biz.bzfiledl.bzfiledownload;

import static yuyu.app.biz.bzfiledl.bzfiledownload.BzFileDownloadConstants.*;
import static yuyu.app.biz.bzfiledl.bzfiledownload.GenBzFileDownloadConstants.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.base.result.bean.FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean;
import yuyu.def.base.sorter.SortAT_FileHozonInfo;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_BzkinouModeIdKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.entity.AT_FileSansyoKaisu;
import yuyu.def.db.entity.AT_SosikiRole;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.infr.file.FileHozonUtil4Online;
import yuyu.infr.file.FileSearchCondition;

import com.google.common.collect.Lists;

/**
 * ファイルダウンロード のビジネスロジックです。
 */
public class BzFileDownloadBizLogic {

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzFileDownloadUiBean uiBean;

    @Inject
    private FileHozonUtil4Online fileHozonUtil;

    @Inject
    private MessageManager messageManager;

    String init() {
        clear();

        AM_User amUser = baseDomManager.getUser(baseUserInfo.getUserId());

        List<AT_UserRole> atUserRoles = amUser.getUserRoles();

        if (0 == atUserRoles.size()) {
            messageManager.addMessageId(MessageId.IBA1001);
            return BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR;
        }

        String[] userRoleCds = new String[atUserRoles.size()];

        int count = 0;
        for (AT_UserRole atUserRole : atUserRoles) {
            userRoleCds[count] = atUserRole.getRoleCd();
            count++;
        }

        List<AT_SosikiRole> atSosikiRoles =
            baseDomManager.getSosikiRolesByTanmatusettisosikicd(baseUserInfo.getTmSosikiCd());

        if (0 == atSosikiRoles.size()) {
            messageManager.addMessageId(MessageId.IBA1001);
            return BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR;
        }

        String[] sosikiRoleCds = new String[atSosikiRoles.size()];

        count = 0;
        for (AT_SosikiRole atSosikiRole : atSosikiRoles) {
            sosikiRoleCds[count] = atSosikiRole.getRoleCd();
            count++;
        }

        List<String> fileDownloadAbleMachineKindList =
            Lists.newArrayList(YuyuBizConfig.getInstance().getFileDownloadAbleMachineKindList());

        boolean fileDownloadAbleMachineKindFlg = false;

        for (int i = 0; i < fileDownloadAbleMachineKindList.size(); i++) {
            if (baseUserInfo.getMachineKind().equals(fileDownloadAbleMachineKindList.get(i))) {
                fileDownloadAbleMachineKindFlg = true;
                break;
            }
        }

        if (!fileDownloadAbleMachineKindFlg) {
            messageManager.addMessageId(MessageId.IBA1008);
            return BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR;
        }

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruiBeans =
            baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCds, sosikiRoleCds);

        if (0 == fileSyuruiBeans.size()) {
            messageManager.addMessageId(MessageId.IBA1001);
            return BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR;
        }

        UserDefsList userDefsList = new UserDefsList();

        userDefsList.add(new LabelValuePair("", ""));

        for (FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean fileSyuruiBean : fileSyuruiBeans) {
            LabelValuePair labelValuePair = new LabelValuePair();
            labelValuePair.setLabel(fileSyuruiBean.getFileSyuruiNm());
            labelValuePair.setValue(fileSyuruiBean.getFileSyuruiCd().getValue());

            userDefsList.add(labelValuePair);
        }

        uiBean.setFilesyuruiOptionBeanList(userDefsList);

        uiBean.setKinouMode(C_BzkinouModeIdKbn.DEFAULT.getValue());

        return BzFileDownloadConstants.FORWARDNAME_INIT;

    }

    public String initIppanjimubumonyou() {
        clear();

        AM_User amUser = baseDomManager.getUser(baseUserInfo.getUserId());

        List<AT_UserRole> atUserRoles = amUser.getUserRoles();

        if (0 == atUserRoles.size()) {
            messageManager.addMessageId(MessageId.IBA1001);
            return BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR;
        }

        String[] userRoleCds = new String[atUserRoles.size()];

        int count = 0;
        for (AT_UserRole atUserRole : atUserRoles) {
            userRoleCds[count] = atUserRole.getRoleCd();
            count++;
        }

        List<AT_SosikiRole> atSosikiRoles =
            baseDomManager.getSosikiRolesByTanmatusettisosikicd(baseUserInfo.getTmSosikiCd());

        if (0 == atSosikiRoles.size()) {
            messageManager.addMessageId(MessageId.IBA1001);
            return BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR;
        }

        String[] sosikiRoleCds = new String[atSosikiRoles.size()];

        count = 0;
        for (AT_SosikiRole atSosikiRole : atSosikiRoles) {
            sosikiRoleCds[count] = atSosikiRole.getRoleCd();
            count++;
        }

        List<FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean> fileSyuruiBeans =
            baseDomManager.getFileSyuruisByRoleCdsTanmatusettisosikiRoleCds(userRoleCds, sosikiRoleCds);

        if (0 == fileSyuruiBeans.size()) {
            messageManager.addMessageId(MessageId.IBA1001);
            return BzFileDownloadConstants.FORWARDNAME_OUTPUTKENGENERROR;
        }

        UserDefsList userDefsList = new UserDefsList();

        userDefsList.add(new LabelValuePair("", ""));

        for (FileSyuruisByRoleCdsTanmatusettisosikiRoleCdBean fileSyuruiBean : fileSyuruiBeans) {
            LabelValuePair labelValuePair = new LabelValuePair();
            labelValuePair.setLabel(fileSyuruiBean.getFileSyuruiNm());
            labelValuePair.setValue(fileSyuruiBean.getFileSyuruiCd().getValue());

            userDefsList.add(labelValuePair);
        }

        uiBean.setFilesyuruiOptionBeanList(userDefsList);

        uiBean.setKinouMode(C_BzkinouModeIdKbn.SYOUKAI.getValue());

        return BzFileDownloadConstants.FORWARDNAME_INIT;

    }

    void clear() {
        uiBean.setFileInfoList(null);
    }

    public void pushFileNmBL() {

        AT_FileHozonInfo atFileHozonInfo =
            baseDomManager.getFileHozonInfo(uiBean.getFileInfoListDataSource().getSelectedBean().getUniqueId());

        if (atFileHozonInfo == null) {
            throw new BizLogicException(MessageId.EAF0052);
        }

        uiBean.setDlflag(true);
        uiBean.setSelectedBean(uiBean.getFileInfoListDataSource().getSelectedBean());
    }

    public void pushKakuteiBL() {
        List<AT_FileHozonInfo> atFileHozonInfos =
            baseDomManager.getFileHozonInfoByFileSyuruiCd(C_FileSyuruiCdKbn.valueOf(uiBean.getFilesyurui()));

        if (0 == atFileHozonInfos.size()) {
            throw new BizLogicException(MessageId.EAF0052);
        }
        messageManager.addConversationMessageId(MessageId.IBA1002);

        SortAT_FileHozonInfo sortAtFileHozonInfo = SWAKInjector.getInstance(SortAT_FileHozonInfo.class);
        atFileHozonInfos = sortAtFileHozonInfo.OrderAT_FileHozonInfoByTourokuTimeDesc(atFileHozonInfos);

        List<FileInfoListDataSourceBean> fileInfoListDataSourceBeans = new ArrayList<>();
        for (AT_FileHozonInfo atFileHozonInfo : atFileHozonInfos) {
            FileInfoListDataSourceBean fileInfoListDataSourceBean =
                SWAKInjector.getInstance(FileInfoListDataSourceBean.class);

            fileInfoListDataSourceBean.setFileNm(atFileHozonInfo.getFileNm());

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddhhmmssSSS");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            String resultDate = null;
            try {
                resultDate = sdf2.format(sdf1.parse(atFileHozonInfo.getTourokuTime()));
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

            fileInfoListDataSourceBean.setTourokuTime(resultDate);
            if (atFileHozonInfo.getFileSansyoKaisu() == null || atFileHozonInfo.getFileSansyoKaisu().getSansyoucount() == null) {
                fileInfoListDataSourceBean.setSansyoucount(0);
            }
            else {
                fileInfoListDataSourceBean.setSansyoucount(atFileHozonInfo.getFileSansyoKaisu().getSansyoucount());
            }
            fileInfoListDataSourceBean.setUniqueId(atFileHozonInfo.getUniqueId());
            fileInfoListDataSourceBeans.add(fileInfoListDataSourceBean);
        }

        uiBean.setFileInfoList(fileInfoListDataSourceBeans);
    }

    @Transactional
    public void downloadFile() {

        uiBean.setDlflag(false);

        AT_FileHozonInfo atFileHozonInfo =
            baseDomManager.getFileHozonInfo(uiBean.getSelectedBean().getUniqueId());

        FileSearchCondition fileSearchCondition = new FileSearchCondition();
        fileSearchCondition.setUniqueId(uiBean.getSelectedBean().getUniqueId());

        boolean result = fileHozonUtil.getFile2Screen(fileSearchCondition, uiBean.getSelectedBean().getFileNm());
        if (!result) {

            uiBean.setSelectedBean(null);

            throw new BizLogicException(MessageId.EAF0053);
        }

        AT_FileSansyoKaisu atFileSansyoKaisu = atFileHozonInfo.getFileSansyoKaisu();

        if (atFileSansyoKaisu == null) {
            atFileSansyoKaisu = atFileHozonInfo.createFileSansyoKaisu();

            atFileSansyoKaisu.setUniqueId(uiBean.getSelectedBean().getUniqueId());
            atFileSansyoKaisu.setSansyoucount(1);
            BizPropertyInitializer.initialize(atFileSansyoKaisu);
        }
        else {
            if (atFileSansyoKaisu.getSansyoucount() != null) {
                if (atFileSansyoKaisu.getSansyoucount() >= 99) {
                    atFileSansyoKaisu.setSansyoucount(99);
                }
                else {
                    atFileSansyoKaisu.setSansyoucount(atFileSansyoKaisu.getSansyoucount() + 1);
                }
            }
            else {
                atFileSansyoKaisu.setSansyoucount(1);
            }
        }

        baseDomManager.update(atFileHozonInfo);

        uiBean.setSelectedBean(null);
    }

    public String getSenisaki() {

        String seniSaki = "";

        if (C_BzkinouModeIdKbn.DEFAULT.getValue().equals(uiBean.getKinouMode())) {
            seniSaki = FORWARDNAME_INIT;
        } else {
            seniSaki = FORWARDNAME_INIT_IPPANJIMUBUMONYOU;
        }

        return seniSaki;
    }

}
