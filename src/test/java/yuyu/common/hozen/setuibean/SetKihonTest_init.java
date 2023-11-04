package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.testinfr.TestOrder;

/**
 * 基本情報設定のメソッド{@link SetKihon#init(SetKihonExecUiBeanParam)}
 *                        テスト用クラスです。<br />
 */
public class SetKihonTest_init {
    private SetKihonExecUiBeanParamImpl setKihonExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setKihonExecUiBeanParamImpl = SWAKInjector.getInstance(SetKihonExecUiBeanParamImpl.class);
        SetKihon.init(setKihonExecUiBeanParamImpl);
        exStringEquals(setKihonExecUiBeanParamImpl.getVkihnsyono(), "", "証券番号");
        exDateEquals(setKihonExecUiBeanParamImpl.getVkihnlastsyosaihkymd(), null, "最終証券再発行日");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnyuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnkykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnsyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(setKihonExecUiBeanParamImpl.getVkihnsyoumetuymd(),null, "消滅日");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setKihonExecUiBeanParamImpl = SWAKInjector.getInstance(SetKihonExecUiBeanParamImpl.class);
        setKihonExecUiBeanParamImpl.setVkihnsyono("12806345694");
        setKihonExecUiBeanParamImpl.setVkihnlastsyosaihkymd(BizDate.valueOf("20151219"));
        setKihonExecUiBeanParamImpl.setVkihnyuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        setKihonExecUiBeanParamImpl.setVkihnkykjyoutai(C_Kykjyoutai.PMEN);
        setKihonExecUiBeanParamImpl.setVkihnsyoumetujiyuu(C_Syoumetujiyuu.SBMUKOU);
        setKihonExecUiBeanParamImpl.setVkihnsyoumetuymd(BizDate.valueOf("20151103"));
        SetKihon.init(setKihonExecUiBeanParamImpl);
        exStringEquals(setKihonExecUiBeanParamImpl.getVkihnsyono(), "", "証券番号");
        exDateEquals(setKihonExecUiBeanParamImpl.getVkihnlastsyosaihkymd(), null, "最終証券再発行日");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnyuukousyoumetukbn(), C_YuukousyoumetuKbn.BLNK, "有効消滅区分");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnkykjyoutai(), C_Kykjyoutai.BLNK, "契約状態");
        exClassificationEquals(setKihonExecUiBeanParamImpl.getVkihnsyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateEquals(setKihonExecUiBeanParamImpl.getVkihnsyoumetuymd(),null, "消滅日");

        MockObjectManager.initialize();

    }




}
