package yuyu.common.workflowcore.core.webservice.provide.accountkanri.updauthority;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;

/**
 * 権限更新サービスのプロバイダークラスです。<br/>
 *
 * 権限ＩＤが存在する場合は、該当権限ＩＤの情報を更新<br/>
 * 権限ＩＤが存在しない場合は、権限情報を追加<br/>
 *
 */
public class WSUpdAuthorityImpl implements WSUpdAuthority {

    private static final Logger LOGGER = LoggerFactory.getLogger(WSUpdAuthorityImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    private static final int iUPD_OK = 0;

    public WSUpdAuthorityResponse validate(WSUpdAuthorityRequest request)
        throws Exception {
        LOGGER.debug("│バリデーションチェック処理・・・");

        WSUpdAuthorityResponse oResponse = new WSUpdAuthorityResponse();
        String   sAuthId = request.getAuthid();
        String   sAuthNm = request.getAuthname();

        IwfCoreConfig iwfCoreConfig = IwfCoreConfig.getInstance();
        String accountKanriMode = String.valueOf(iwfCoreConfig.getAccountKanriMode());

        if (StringUtils.isEmpty(sAuthId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "権限ＩＤ");
            return oResponse;
        }
        if (StringUtils.isEmpty(sAuthNm)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "権限名");
            return oResponse;
        }
        if ("1".equals(accountKanriMode)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0010);
            return oResponse;
        }

        return oResponse;
    }

    @Override
    @Transactional
    public WSUpdAuthorityResponse executeBizMain(WSUpdAuthorityRequest request)
        throws Exception {

        LOGGER.debug("│主処理・・・");

        WSUpdAuthorityResponse oResponse = new WSUpdAuthorityResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String   sAuthId = request.getAuthid();
        String   sAuthNm = IwfBase64Urls.decodeToString(request.getAuthname());

        try {
            int iResKanri = _setAuthKanri(sAuthId, sAuthNm);

            if (iResKanri == iUPD_OK) {
                IwfEditMessageUtil.setMsgResultOK(oResponse, "権限更新");
            }
            else {
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "権限更新");
            }
        } catch (HibernateException he) {

            LOGGER.error("データベースアクセス中に例外が発生しました。", he);

            iwfCoreDomManager.clear();
        } catch (Exception e) {

            LOGGER.error("想定外のエラーが発生しました。", e);

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "権限更新");
        }
        return oResponse;
    }


    public WSUpdAuthorityResponse getStubResult(WSUpdAuthorityRequest request)
        throws Exception {

        return null;
    }

    private int _setAuthKanri(final String psAuthId, final String psAuthName) throws Exception {

        AM_Role role = baseDomManager.getRole(psAuthId);

        AM_Role oRecord = new AM_Role();
        if (null != role) {
            oRecord.setRoleCd(psAuthId);
            oRecord.setRoleNm(psAuthName);
            oRecord.setKousinTime(IwfDateUtils.getSysDate());

            iwfCoreDomManager.update(oRecord);
        } else {
            oRecord = new AM_Role();
            oRecord.setRoleCd(psAuthId);
            oRecord.setRoleNm(psAuthName);
            oRecord.setKousinTime(IwfDateUtils.getSysDate());
            iwfCoreDomManager.insert(oRecord);
        }

        if(LOGGER.isDebugEnabled()){
            List<AM_Role> amRoles = baseDomManager.getAllRoles();
            for (AM_Role amRole : amRoles) {
                LOGGER.debug(Objects.toStringHelper(this)
                    .add("AuthId", amRole.getRoleCd())
                    .add("AuthNm", amRole.getRoleNm())
                    .add("Time", amRole.getKousinTime())
                    .toString());
            }
        }
        return iUPD_OK;
    }


    public WSUpdAuthorityResponse getBootErrResponse() {
        WSUpdAuthorityResponse res = new WSUpdAuthorityResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
