package yuyu.infr;

import java.util.Locale;

import javax.inject.Inject;

import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

/**
 * アプリケーションリソースから項目名等を取得するテストです。
 */
@RunWith(SWAKTestRunner.class)
public class ResourceLoadingTest {

    @Inject private static Logger logger;

    @Test
    public void testGetKoumokuNm1() {
        testResource(Locale.JAPANESE, "ユーザーＩＤ", "userId");
    }

    @Test
    public void testGetKoumokuNm2() {
        testResource(Locale.JAPANESE, "暗号化区分", "angoukaKbn");
    }

    private static void testResource(Locale pLocale, String pExpected, String pKoumokuId) {
        String actual = ResourceUtil.getApplicationResources(pLocale).getString(pKoumokuId);
        logger.debug("項目ID    = {}", pKoumokuId);
        logger.debug("│ 期待値 = {}", pExpected);
        logger.debug("└ 結果   = {}", actual);
        Assert.assertEquals(pExpected, actual);
    }
}
