package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.configuration.YuyuBaseConfig;

/**
 * ファイルパスユーティリティクラスのメソッド {@link FilePathUtil#getBatchOutDataPath()} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class FilePathUtilTest_getBatchOutDataPath {

    @Test
    public void testBatchOutDataPath01() {
        String batchOutDataPath = FilePathUtil.getBatchOutDataPath();
        exStringEquals(
            batchOutDataPath, YuyuBaseConfig.getInstance().getBatchOutputDir(),
            "バッチ出力ファイルフォルダパス");
    }
}
