package yuyu.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.direct.dscommon.DsDB2UtilTest_exec;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.common.direct.dscommon.DsKanyuuYoukenCheckTest_exec;
import yuyu.common.direct.dscommon.DsNayoseTest_exec;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditTest_All;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutokuTest_All;
import yuyu.common.direct.dscommon.TableMaintenanceUtilTest_exec;

/**
 * 全メソッド（ダイレクトサービス）の、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({

    // M_ダイレクトサービス ダイレクトサービス共通 テーブルメンテナンスユーティリティ
    TableMaintenanceUtilTest_exec.class,
    // M_ダイレクトサービス ダイレクトサービス共通 保全契約異動状態取得
    HozenKeiyakuIdouJyoutaiSyutokuTest_All.class,
    // M_ダイレクトサービス ダイレクトサービス共通 ＤＳ加入要件チェック
    DsKanyuuYoukenCheckTest_exec.class,
    // M_ダイレクトサービス ダイレクトサービス共通 ＤＳ名寄せ
    DsNayoseTest_exec.class,
    // M_ダイレクトサービス ダイレクトサービス共通 ＤＳ契約詳細取得
    DsGetKeiyakuSyousaiTest_exec.class,
    // M_ダイレクトサービス ダイレクトサービス共通 ＤＳ手続履歴テーブル編集
    DsTetudukiRirekiTableEditTest_All.class,
    // M_ダイレクトサービス ダイレクトサービス共通 ＤＳ採番処理
    //DsSaibanSyoriTest_All.class,
    // M_ダイレクトサービス ダイレクトサービス共通 ＤＳＤＢ２ユーティリティ
    DsDB2UtilTest_exec.class,

})
public class TestAll_Direct {
    /* 全メソッドのテストをまとめて実施するクラスです。 */
}
