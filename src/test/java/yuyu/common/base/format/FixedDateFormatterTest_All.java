package yuyu.common.base.format;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * {@link FixedDateFormatter}クラスに含まれる全メソッドの、テストケースをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({FixedDateFormatterTest_FormatYoubi.class
    ,FixedDateFormatterTest_FormatDZenkakuKanji.class
    ,FixedDateFormatterTest_FormatDZeroFill.class
    ,FixedDateFormatterTest_FormatMDZenkakuKanji.class
    ,FixedDateFormatterTest_FormatMZenkakuKanji.class
    ,FixedDateFormatterTest_FormatMZeroFill.class
    ,FixedDateFormatterTest_FormatYMDSeirekiSlashZeroFill.class
    ,FixedDateFormatterTest_FormatYMDWarekiKanjiNoneFill.class
    ,FixedDateFormatterTest_FormatYMDZenkakuSeirekiKanji.class
    ,FixedDateFormatterTest_FormatYMDZenkakuWarekiKanji.class
    ,FixedDateFormatterTest_FormatYMZenkakuSeirekiKanji.class
    ,FixedDateFormatterTest_FormatYMZenkakuWarekiKanji.class
    ,FixedDateFormatterTest_FormatYZenkakuSeirekiKanji.class
    ,FixedDateFormatterTest_FormatYZenkakuWarekiKanji.class
    ,FixedDateFormatterTest.class
})
public class FixedDateFormatterTest_All {
}
