package yuyu.def.db.entity;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.runner.RunWith;

@RunWith(SWAKTestRunner.class)
public interface EntityTestInterface {

    public void getAll();

    public void getUniqueEntity();

    public void noUniqueEntity();

    public void blankCondition();

    public void nullCondition();
}
