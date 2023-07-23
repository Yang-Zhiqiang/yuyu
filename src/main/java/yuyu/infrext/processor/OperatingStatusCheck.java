package yuyu.infrext.processor;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_OnlineStatusKbn;
import yuyu.def.db.dao.AT_RinjiKadouTaisyoSosikiDao;
import yuyu.def.db.dao.AT_SystemControlInfoDao;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.entity.AT_SystemControlInfo;
import yuyu.infr.processor.OnlineKadouCheck;

import com.google.inject.ProvisionException;

/**
 * 稼動状態チェッククラス<br />
 * コントロール情報テーブルのオンライン状態区分を参照し、<br />
 * オンライン中であるかを判定します。<br />
 */
public class OperatingStatusCheck implements OnlineKadouCheck {

    private static final String SYSTEM_CTRLINFO_KEY = "ctrlInfo";
    @Inject
    private AT_RinjiKadouTaisyoSosikiDao rinjiKadouDao;
    @Inject
    private AT_SystemControlInfoDao systemControlDao;

    private static final String KINOUID_LOGIN =  "login";

    @Override
    public boolean isOnlineKadouOnOnline() {
        return isOnlineOpenOnOnline();
    }

    @Override
    public boolean isOnlineKadouOnBatch() {
        return isOnlineOpenOnBatch();
    }

    public boolean isOnlineOpenOnOnline() {
        boolean isOnlineOpen = true;
        BaseUserInfo userInfo;
        try {
            userInfo = SWAKInjector.getInstance(BaseUserInfo.class);
        } catch (ProvisionException ex) {
            return isOnlineOpen;
        }

        AT_SystemControlInfo systemControlInfo = systemControlDao.getSystemControlInfo(SYSTEM_CTRLINFO_KEY);
        C_OnlineStatusKbn onlineStatus = C_OnlineStatusKbn.valueOf(systemControlInfo.getOnlineStatus());
        if (C_OnlineStatusKbn.ONLINE_KA.eq(onlineStatus)) {
        } else if (C_OnlineStatusKbn.ONLINE_HUKA.eq(onlineStatus)) {
            isOnlineOpen = false;
        } else if (C_OnlineStatusKbn.ONLINE_KA_SOSIKI.eq(onlineStatus)) {

            AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
            if(kinou.getKinouId().equals(KINOUID_LOGIN)){
                return true;
            }

            AT_RinjiKadouTaisyoSosiki rinjiKadouTaisyoSosiki = rinjiKadouDao.getRinjiKadouTaisyoSosiki(userInfo.getTmSosikiCd());
            if (rinjiKadouTaisyoSosiki == null) {
                isOnlineOpen = false;
            }
        }
        return isOnlineOpen;
    }

    public boolean isOnlineOpenOnBatch() {
        boolean isOnlineOpen = true;

        AT_SystemControlInfo systemControlInfo = systemControlDao.getSystemControlInfo(SYSTEM_CTRLINFO_KEY);
        C_OnlineStatusKbn onlineStatus = C_OnlineStatusKbn.valueOf(systemControlInfo.getOnlineStatus());
        if (C_OnlineStatusKbn.ONLINE_HUKA.eq(onlineStatus)) {
            isOnlineOpen = false;
        }
        return isOnlineOpen;
    }
}
