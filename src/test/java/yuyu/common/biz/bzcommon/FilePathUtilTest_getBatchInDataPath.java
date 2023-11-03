package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.configuration.YuyuBaseConfig;

/**
 * ファイルパスユーティリティクラスのメソッド {@link FilePathUtil#getBatchInDataPath()} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class FilePathUtilTest_getBatchInDataPath {

    @Test
    public void testBatchOutDataPath01() {
        String batchInDataPath = FilePathUtil.getBatchInDataPath();
        exStringEquals(
            batchInDataPath, YuyuBaseConfig.getInstance().getBatchInputDir(),
            "バッチ入力ファイルフォルダパス");
    }
}
