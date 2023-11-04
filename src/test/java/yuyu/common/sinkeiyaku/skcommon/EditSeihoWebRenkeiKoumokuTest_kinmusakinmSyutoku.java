package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 生保Ｗｅｂ連携項目編集のメソッド{@link EditSeihoWebRenkeiKoumoku#kinmusakinmSyutoku()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditSeihoWebRenkeiKoumokuTest_kinmusakinmSyutoku {

    @Inject
    private EditSeihoWebRenkeiKoumoku editSeihoWebRenkeiKoumoku;

    @Test
    @TestOrder(10)
    public void testKinmusakinmSyutoku_A1(){

        String pKinmusakinm = "お勤め先お勤め先お勤め先お勤め先お勤め先お勤"
            + "め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お";
        String kinmusakinm = editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(pKinmusakinm);
        exStringEquals(kinmusakinm, "お勤め先お勤め先お勤め先お勤め先お勤め先お"
            + "勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お", "勤務先名");
    }

    @Test
    @TestOrder(20)
    public void testKinmusakinmSyutoku_A2(){

        String pKinmusakinm = "お勤め先お勤め先お勤め先お勤め先お勤め先お勤"
            + "め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤";
        String kinmusakinm = editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(pKinmusakinm);
        exStringEquals(kinmusakinm, "お勤め先お勤め先お勤め先お勤め先お勤め先お"
            + "勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤", "勤務先名");
    }

    @Test
    @TestOrder(30)
    public void testKinmusakinmSyutoku_A3(){

        String pKinmusakinm = "お勤め先お勤め先お勤め先お勤め先お勤め先お勤"
            + "め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤め";
        String kinmusakinm = editSeihoWebRenkeiKoumoku.kinmusakinmSyutoku(pKinmusakinm);
        exStringEquals(kinmusakinm, "お勤め先お勤め先お勤め先お勤め先お勤め先お"
            + "勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤め先お勤", "勤務先名");
    }
}
