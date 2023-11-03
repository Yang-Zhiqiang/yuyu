package yuyu.app.base.system.userkensaku;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YoukyuuKbn;


public class SeleniumUserKensakuConstants {

    public static final String ALREADYUSERID                                   = "Selenium";
    public static final String ALREADYUSERNM                                   = "セレニウムテスト名";
    public static final C_SpecialUserKbn ALREADYSPEAIALUSERKBN                 = C_SpecialUserKbn.IPPAN;
    public static final String ALREADYPASSWORD                                 = "password";
    public static final BizDate ALREADYPASSWORDSETEIYMD                        = BizDate.getSysDate();
    public static final C_PasswordYuukouKikanKbn ALREADYPASSWORDYUUKOUKIKANKBN = C_PasswordYuukouKikanKbn.NONE;
    public static final C_KyokaKbn ALREADYPASSWORDKYOKAKBN                     = C_KyokaKbn.KYOKA;
    public static final C_YoukyuuKbn ALREADYYOUKYUUKBN                         = C_YoukyuuKbn.NONE;
    public static final C_KyokaKbn ALREADYLOGINKYOKAKBN                        = C_KyokaKbn.KYOKA;

    public static final String NOTUSERID                                       = "ユーザー１２３４５";

    public static final String USERKENSAKUBTN                                  = "user.userIdPopupButton";
    public static final String PAGELINK_NO                                     = "userInfoDataSource[6]";
    public static final String PAGELINK_R                                      = "userInfoDataSource[12]";
    public static final String PAGELINK_L                                      = "userInfoDataSource[6]";
    public static final String PAGELINK_RR                                     = "userInfoDataSource[36]";
    public static final String PAGELINK_LL                                     = "userInfoDataSource[1]";
    public static final String USERSENTAKULINK                                 = "userInfo[3].userId";
}