package yuyu.testinfr;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

/**
 * 単体テストクラス実行前の初期処理実行クラスです。<br />
 * このクラスの初期化処理はテスト基盤の＠BeforeTestで呼び出されます。<br />
 * テスト基盤と、案件毎のテスト前初期化要求を分離することが目的です。
 */
public class TestInitializer {


    private static Logger logger = LoggerFactory.getLogger(TestInitializer.class);

    static void initTestClass(){

        logger.debug("◆ テストクラス初期化処理を開始しました。");


        logger.debug("◆ テストクラス初期化処理を終了しました。");

    }

    static void initTest(){

        logger.debug("◆ テストメソッド初期化処理を開始しました。");


        logger.debug("◆ テストメソッド初期化処理を終了しました。");
    }

}
