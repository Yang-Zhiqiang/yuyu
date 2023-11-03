package yuyu.common.biz.bzcommon;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataTest_exec;
import yuyu.common.biz.bzcommon.BzGetSosikiDataTest_exec1;
import yuyu.testinfr.AbstractTest;

/**
 * {@link BzGetSosikiData}クラスに含まれる、全メソッドのテストをまとめて実施するクラスです。<br />
 */
@RunWith(Suite.class)
@SuiteClasses({ BzGetSosikiDataTest_exec.class
    , BzGetSosikiDataTest_exec1.class})
public class BzGetSosikiDataTest_All extends AbstractTest {
}