package yuyu.app.base.system.useritiranhyou;

import static yuyu.app.base.system.useritiranhyou.UserItiranhyouConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.bean.report.UserItiranDataSourceBean;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.infr.report.swakreport.SyoruiZokusei;
import yuyu.infr.report.swakreport.SyoruiZokuseiReader;

import com.google.common.base.Strings;

/**
 * ユーザー一覧表 のビジネスロジックです。
 */
public class UserItiranhyouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @SuppressWarnings("unused")
    @Inject
    private UserItiranhyouUiBean uiBean;

    @Inject
    private BaseDomManager manager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private CreateReport createReport;

    @Inject
    private OutputReport outputReport;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private SyoruiZokuseiReader syoruiZokuseiReader;

    void init() {
        clear();
        messageManager.addMessageId(MessageId.QAC0002);

    }

    void clear() {
    }

    void execPrePrint(){

        messageManager.addMessageId(MessageId.IAC0004);
    }

    void printOut(){

        try{

            Map<String, SyoruiZokusei> zokuseiMap = syoruiZokuseiReader.read();

            SyoruiZokusei zokusei = zokuseiMap.get(C_SyoruiCdKbn.USERITIRANHYOU.getValue());

            ReportServicesBean serviceBean = createReport.createNewReportServiceBean(asKinou.getSubSystemId(), asKinou.getCategoryId(), asKinou.getKinouId(), C_SyoruiCdKbn.valueOf(zokusei.getSyoruiCdKbn().getValue()));

            serviceBean.setKensakuKeys(new String[]{zokusei.getKensakuKeyKoumokuId1(), zokusei.getKensakuKeyKoumokuId2()});

            List<IReportDataSouceBean> rdsBeanList = new ArrayList<IReportDataSouceBean>();

            setUsers(rdsBeanList);

            serviceBean.addParamObjects(rdsBeanList);

            String tyouhyouKey = createReport.exec(serviceBean);

            outputReport.outputPDFSingle(tyouhyouKey); /* エラーの場合のみエラーフォワード名を返却します */

        }catch(Throwable e){
            throw new RuntimeException(e);
        }

    }

    private void setUsers(List<IReportDataSouceBean> rdsBeanList) {

        List<AM_User> allUsers = manager.getAllUsers();

        for( AM_User am_user: allUsers ){

            UserItiranDataSourceBean userItiranDataSourceBean = new UserItiranDataSourceBean();

            String userGroupNm = "";
            if(!Strings.isNullOrEmpty(am_user.getUserGroupCd())){
                userGroupNm = manager.getUserGroup(am_user.getUserGroupCd()).getUserGroupNm();
            }

            List<AT_UserRole> userRoles = am_user.getUserRoles();

            StringBuilder roleNms = new StringBuilder();

            boolean IsDispKakuninMark = false;

            int roleCount = 0;

            for(AT_UserRole userRole : userRoles){

                roleCount++;

                if(roleCount > MAX_ROLES_COUNT){
                    IsDispKakuninMark = true;
                    break;
                }

                if(roleCount > 1){
                    roleNms.append("<br/>");
                }

                roleNms.append(userRole.getRole().getRoleNm());

            }

            userItiranDataSourceBean.setUserId(am_user.getUserId());
            userItiranDataSourceBean.setUserNm(am_user.getUserNm());
            userItiranDataSourceBean.setUserGroupNm(userGroupNm);
            userItiranDataSourceBean.setPasswordSetteiYmd(am_user.getPasswordSetteiYmd());
            userItiranDataSourceBean.setPasswordYuukouKigenYmd(am_user.getPasswordYuukouKigenYmd());
            userItiranDataSourceBean.setPasswordHenkouKyokaKbn(am_user.getPasswordHenkouKyokaKbn());
            userItiranDataSourceBean.setLoginKyokaKbn(am_user.getLoginKyokaKbn());
            userItiranDataSourceBean.setLastLoginTime(am_user.getLastLoginTime());
            userItiranDataSourceBean.setRoleNm(roleNms.toString());
            userItiranDataSourceBean.setHoyuuRoleKakuninFlg(IsDispKakuninMark);

            rdsBeanList.add(userItiranDataSourceBean);
        }
    }
}
