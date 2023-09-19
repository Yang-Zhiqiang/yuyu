package yuyu.common.workflowcore.core.iwfinfr.util;

import static yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey.*;

import java.util.Date;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.def.classification.C_LockKbn;
import yuyu.def.classification.C_UnlockResultKbn;
import yuyu.def.workflowcore.configration.IwfCoreConfig;

import com.google.common.base.Strings;


/**
 * ロックユーティリティ<br/>
 */
public class IwfLockUtils  {

    public static C_LockKbn setLock(IWorkflowToken poToken, String psLockKey) throws Exception {


        if (poToken == null) {
            LoggerFactory.getLogger(IwfLockUtils.class).debug("トークンが未設定です。");

            return C_LockKbn.LOCK_NG;
        }


        IWorkflowToken rootToken = poToken.getRootToken();



        String sCurrentLockKey = rootToken.getStringVariable(LOCK.key);

        String sCurrentLockTime = rootToken.getStringVariable(LOCK_TIME.key);


        if (StringUtils.isNotEmpty(sCurrentLockKey)) {

            if(_isValidLockTime(sCurrentLockTime)){

                LoggerFactory.getLogger(IwfLockUtils.class).debug("他者ロック中です。");
                return C_LockKbn.LOCK_OTHER;

            }
            LoggerFactory.getLogger(IwfLockUtils.class).debug("有効期間外です。アンロック状態とみなします。");

            rootToken.setStringVariable(LOCK.key, null);
            rootToken.setStringVariable(LOCK_TIME.key, null);
        }


        rootToken.setStringVariable(LOCK.key, psLockKey);

        rootToken.setStringVariable(LOCK_TIME.key, IwfDateUtils.getSysDate());

        LoggerFactory.getLogger(IwfLockUtils.class).debug("LOCK_KEY      : " + rootToken.getVariable(LOCK.key));
        LoggerFactory.getLogger(IwfLockUtils.class).debug("LOCK_TIME     : " + rootToken.getVariable(LOCK_TIME.key));


        return C_LockKbn.LOCK_OK;
    }

    public static C_LockKbn continueLock(IWorkflowToken poToken, String psLockKey) throws Exception {


        if (poToken == null) {
            LoggerFactory.getLogger(IwfLockUtils.class).debug("トークンが未設定です。");

            return C_LockKbn.LOCK_NG;
        }


        IWorkflowToken rootToken = poToken.getRootToken();



        String sCurrentLockKey = rootToken.getStringVariable(LOCK.key);

        String sCurrentLockTime = rootToken.getStringVariable(LOCK_TIME.key);


        if (Strings.isNullOrEmpty(sCurrentLockKey)) {
            LoggerFactory.getLogger(IwfLockUtils.class).debug("ロックキーが未設定です。");

            return C_LockKbn.LOCK_NG;



        }


        if(!psLockKey.equals(sCurrentLockKey)){
            LoggerFactory.getLogger(IwfLockUtils.class).debug("無効なロックキーです。");

            return C_LockKbn.LOCK_NG;
        }



        poToken.getRootToken().setStringVariable(LOCK_TIME.key, IwfDateUtils.getSysDate());
        LoggerFactory.getLogger(IwfLockUtils.class).debug("LOCK_TIME     : " + poToken.getRootToken().getVariable(LOCK_TIME.key));




        return C_LockKbn.LOCK_OK;
    }

    public static C_UnlockResultKbn setUnlock(IWorkflowToken poToken, String psLockKey) throws Exception {


        if (poToken == null) {

            return C_UnlockResultKbn.UNKNOWN_ERR;
        }

        IWorkflowToken rootToken = poToken.getRootToken();



        String sCurrentLockKey = rootToken.getStringVariable(LOCK.key);


        if (StringUtils.isNotEmpty(sCurrentLockKey)) {

            if(sCurrentLockKey.equals(psLockKey)){

                rootToken.setStringVariable(LOCK.key, null);
                rootToken.setStringVariable(LOCK_TIME.key, null);

                return C_UnlockResultKbn.OK;
            } else {

                return C_UnlockResultKbn.LOCK_KEY_ERR;
            }

        } else {

            return C_UnlockResultKbn.NOLOCK;
        }
    }

    public static C_UnlockResultKbn forceUnlock(IWorkflowToken poToken) throws Exception {


        if (poToken == null) {

            return C_UnlockResultKbn.UNKNOWN_ERR;
        }

        IWorkflowToken rootToken = poToken.getRootToken();



        String sCurrentLockKey = rootToken.getStringVariable(LOCK.key);


        if (StringUtils.isNotEmpty(sCurrentLockKey)) {

            rootToken.setStringVariable(LOCK.key, null);
            rootToken.setStringVariable(LOCK_TIME.key, null);

            return C_UnlockResultKbn.OK;


        } else {

            return C_UnlockResultKbn.NOLOCK;
        }
    }

    public static boolean isTokenLocked(IWorkflowToken poToken) throws Exception {


        boolean bResult = false;


        if (poToken == null) {

            return bResult;
        }


        IWorkflowToken rootToken = poToken.getRootToken();



        String sCurrentLockKey = rootToken.getStringVariable(LOCK.key);

        String sCurrentLockTime = rootToken.getStringVariable(LOCK_TIME.key);


        if (sCurrentLockKey != null) {

            if(_isValidLockTime(sCurrentLockTime)){

                bResult = true;
            }
        }

        return bResult;
    }

    public static boolean isValidLockKey(IWorkflowToken poToken, String psLockKey) throws Exception {


        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();


        if(!bLockYouhi) {
            return true;
        }


        boolean bResult = false;


        if (poToken == null) {

            return bResult;
        }


        IWorkflowToken rootToken = poToken.getRootToken();


        if(isTokenLocked(rootToken)){


            String sCurrentLockKey = rootToken.getStringVariable(LOCK.key);


            if(psLockKey.equals(sCurrentLockKey)){

                bResult = true;
            }
        }

        return bResult;
    }

    public static boolean _isValidLockTime(String psDate) throws Exception {


        boolean bChkResult = false;


        Date oLockDate;
        synchronized (IwfDateUtils.sdfSYSDATE_TIME_MILLI) {
            oLockDate = IwfDateUtils.sdfSYSDATE_TIME_MILLI.parse(psDate);
        }


        Date oSysDate;
        synchronized (IwfDateUtils.sdfSYSDATE_TIME_MILLI) {
            oSysDate = IwfDateUtils.sdfSYSDATE_TIME_MILLI.parse(IwfDateUtils.getSysDate());
        }


        int lckValidTime =  IwfCoreConfig.getInstance().getLockValidTime();




        oLockDate = DateUtils.addMinutes(oLockDate, lckValidTime);


        if(oLockDate.compareTo(oSysDate) > 0){

            bChkResult = true;
        }

        return bChkResult;
    }

    public static void clearLockVariable(IWorkflowToken token) {


        if (null == token) {
            return;
        }


        IWorkflowToken rootToken = token.getRootToken();

        String sCurrentLockKey = rootToken.getStringVariable(LOCK.key);


        if (StringUtils.isNotEmpty(sCurrentLockKey)) {

            rootToken.setStringVariable(LOCK.key, null);
            rootToken.setStringVariable(LOCK_TIME.key, null);
        }
    }
}
