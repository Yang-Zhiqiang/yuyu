package yuyu.infr.processor;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.base.Strings;

/**
 * 業務アクションクラスのイベントハンドラメソッド実行前に稼動時間チェック Interceptor です。<br />
 */
@Singleton
public class KadouTimeCheck implements OnlineKadouCheck {
    static final Logger logger = LoggerFactory.getLogger(KadouTimeCheck.class);

    private static final String SUBSYSTEMID_BASE  = "base";
    private static final String CATEGORYID_SYSTEM = "system";
    private static final String CATEGORYID_MENU   = "menu";
    private static final String KINOUID_LOGIN     = "login";

    @Override
    public boolean isOnlineKadouOnOnline() {
        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);

        return isKadouTime(BizDate.getSysDateTime(), kinou, SWAKInjector.getInstance(KinouMode.class));
    }

    @Override
    public boolean isOnlineKadouOnBatch() {
        boolean result = true;
        return result;
    }

    boolean isKadouTime(final String pSystemDateTime, final AS_Kinou pKinou, final KinouMode pKinouMode) {

        AS_Kinou kinou = pKinou;

        BizDate bizDate = BizDate.valueOf(pSystemDateTime.substring(0, 8));
        String bizTime = pSystemDateTime.substring(8, 12);
        String subSystemId = kinou.getSubSystemId();
        String categoryId = kinou.getCategoryId();
        String kinouId = kinou.getKinouId();

        if (SUBSYSTEMID_BASE.equals(subSystemId) &&
            CATEGORYID_MENU .equals(categoryId ) &&
            KINOUID_LOGIN   .equals(kinouId)) {
            return true;
        }

        if (SWAKInjector.getInstance(BaseUserInfo.class).getUser() != null) {
            C_SpecialUserKbn specialUserKbn = SWAKInjector
                .getInstance(BaseUserInfo.class).getUser()
                .getSpecialUserKbn();
            if (SUBSYSTEMID_BASE.equals(subSystemId)
                && CATEGORYID_SYSTEM.equals(categoryId)
                && C_SpecialUserKbn.TOKKEN.equals(specialUserKbn)) {
                return true;
            }
        }

        AS_KinouMode asKinouMode = kinou.getKinouMode(pKinouMode.getKinouMode());

        if (asKinouMode != null) {
            AT_TokuteibiKadouTime tokuteibiKadouTime = asKinouMode.getKadouTimeGroup().getTokuteibiKadouTime(bizDate);

            if (tokuteibiKadouTime != null) {
                C_KadouTimeSiteiKbn kadouTimeSiteiKbn = tokuteibiKadouTime.getKadouTimeSiteiKbn();
                if (C_KadouTimeSiteiKbn.ZENJITURIYOU_KA.eq(kadouTimeSiteiKbn)) {
                    return true;
                } else if (C_KadouTimeSiteiKbn.ZENJITURIYOU_HUKA.eq(kadouTimeSiteiKbn)) {
                    return false;
                } else {
                    if (C_KadouTimeSiteiKbn.SITEI.equals(kadouTimeSiteiKbn)) {
                        if (chkTime(tokuteibiKadouTime.getKadouTimeFrom1(),
                            tokuteibiKadouTime.getKadouTimeTo1(),
                            bizTime)) {
                            return true;
                        }

                        if (chkTime(tokuteibiKadouTime.getKadouTimeFrom2(),
                            tokuteibiKadouTime.getKadouTimeTo2(),
                            bizTime)) {
                            return true;
                        }

                        if (chkTime(tokuteibiKadouTime.getKadouTimeFrom3(),
                            tokuteibiKadouTime.getKadouTimeTo3(),
                            bizTime)) {
                            return true;
                        }

                        if (chkTime(tokuteibiKadouTime.getKadouTimeFrom4(),
                            tokuteibiKadouTime.getKadouTimeTo4(),
                            bizTime)) {
                            return true;
                        }

                        if (chkTime(tokuteibiKadouTime.getKadouTimeFrom5(),
                            tokuteibiKadouTime.getKadouTimeTo5(),
                            bizTime)) {
                            return true;
                        }
                        return false;
                    }
                    throw new RuntimeException(
                        String.format(
                            "特定日稼働時間テーブルのデータが不整合です。稼働時間グループコード：%s, 稼働時間指定年月日：%s",
                            tokuteibiKadouTime.getKadouTimeGroupCd(),
                            tokuteibiKadouTime.getKadouTimeSiteiYmd().toString()
                            )
                        );
                }
            }

            C_EigyoubiKbn eigyoubiKbn;
            if (bizDate.isBusinessDay(asKinouMode.getKadouTimeGroup().getHolidayGroupCd())) {
                eigyoubiKbn = C_EigyoubiKbn.EIGYOUBI;
            } else {
                eigyoubiKbn = C_EigyoubiKbn.HIEIGYOUBI;
            }
            C_KadouTimeYoubiKbn kadouTimeYoubiKbn = C_KadouTimeYoubiKbn.valueOf(String.valueOf(bizDate.getDayOfWeek().intValue()));
            AT_KadouTime kadouTime = asKinouMode.getKadouTimeGroup().getKadouTime(kadouTimeYoubiKbn, eigyoubiKbn);
            C_KadouTimeSiteiKbn kadouTimeSiteiKbn = kadouTime.getKadouTimeSiteiKbn();
            if (C_KadouTimeSiteiKbn.ZENJITURIYOU_KA.eq(kadouTimeSiteiKbn)) {
                return true;
            } else if (C_KadouTimeSiteiKbn.ZENJITURIYOU_HUKA.eq(kadouTimeSiteiKbn)) {
                return false;
            } else {
                if (C_KadouTimeSiteiKbn.SITEI.equals(kadouTimeSiteiKbn)) {
                    return chkKadouTimeRange(bizTime, kadouTime);
                } else if (C_KadouTimeSiteiKbn.HYOUJUN.equals(kadouTimeSiteiKbn)) {
                    kadouTime = asKinouMode.getKadouTimeGroup().getKadouTime(C_KadouTimeYoubiKbn.HYOUJYUN,eigyoubiKbn);
                    kadouTimeSiteiKbn = kadouTime.getKadouTimeSiteiKbn();
                    if (C_KadouTimeSiteiKbn.ZENJITURIYOU_KA.eq(kadouTimeSiteiKbn)) {
                        return true;
                    } else if (C_KadouTimeSiteiKbn.ZENJITURIYOU_HUKA.eq(kadouTimeSiteiKbn)) {
                        return false;
                    } else {
                        if (C_KadouTimeSiteiKbn.SITEI.equals(kadouTimeSiteiKbn)) {
                            return chkKadouTimeRange(bizTime, kadouTime);
                        }
                        logger.error("稼働時間テーブルのデータが不整合です。稼働時間グループコード："
                            + kadouTime.getKadouTimeGroupCd() + ";稼働時間グループコード:"
                            + kadouTime.getKadouTimeYoubiKbn()  + ";営業日区分:"
                            + kadouTime.getEigyoubiKbn());
                    }
                } else {
                    logger.error("稼働時間テーブルのデータが不整合です。稼働時間グループコード："
                        + kadouTime.getKadouTimeGroupCd() + ";稼働時間グループコード:"
                        + kadouTime.getKadouTimeYoubiKbn()  + ";営業日区分:"
                        + kadouTime.getEigyoubiKbn());
                }
            }
        } else {
            String message = String.format(
                "機能モードが存在しません。（機能ID:%s、機能モード：%s）",
                kinou.getKinouId(),
                pKinouMode.getKinouMode()
                );
            throw new RuntimeException(message);
        }

        return false;
    }

    static boolean chkKadouTimeRange(String pBizTime, AT_KadouTime pKadouTimes) {
        if (chkTime(pKadouTimes.getKadouTimeFrom1(),
            pKadouTimes.getKadouTimeTo1(),
            pBizTime)) {
            return true;
        }

        if (chkTime(pKadouTimes.getKadouTimeFrom2(),
            pKadouTimes.getKadouTimeTo2(),
            pBizTime)) {
            return true;
        }

        if (chkTime(pKadouTimes.getKadouTimeFrom3(),
            pKadouTimes.getKadouTimeTo3(),
            pBizTime)) {
            return true;
        }

        if (chkTime(pKadouTimes.getKadouTimeFrom4(),
            pKadouTimes.getKadouTimeTo4(),
            pBizTime)) {
            return true;
        }

        if (chkTime(pKadouTimes.getKadouTimeFrom5(),
            pKadouTimes.getKadouTimeTo5(),
            pBizTime)) {
            return true;
        }
        return false;
    }

    static boolean chkTime(String pKadouTimeFrom,
        String pKadouTimeTo,
        String pKadouTime) {

        if (!Strings.isNullOrEmpty(pKadouTimeFrom) &&
            !Strings.isNullOrEmpty(pKadouTimeTo)) {

            int kTimeFrom = Integer.parseInt(pKadouTimeFrom);
            int kTimeTo   = Integer.parseInt(pKadouTimeTo);
            int kTime     = Integer.parseInt(pKadouTime);

            return (kTimeFrom <= kTime) && (kTime < kTimeTo);
        }
        return false;
    }
}
