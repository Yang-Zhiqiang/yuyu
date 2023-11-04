package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 登録家族情報設定のメソッド{@link SetTrkKazoku#init(SetTrkKazokuExecUiBeanParam)}
                                   テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTrkKazokuTest_init {

    private SetTrkKazokuExecUiBeanParamImpl setTrkKazokuExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        SetTrkKazoku.init(setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), null, "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), null, "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分２");

    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {

        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzknmkn1("カナシメイ１");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzknmkj1("漢字氏名１");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzknmkjkhukakbn1(C_KjkhukaKbn.KJKHUKA);
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkseiymd1(BizDate.valueOf("19801229"));
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzksei1(C_Seibetu.MALE);
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzktdk1(C_Tdk.KYDSM);
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkyno1("1234567");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkadr1kj1("住所１漢字１");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkadr2kj1("住所２漢字１");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkadr3kj1("住所３漢字１");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzktelno1("011-0123-4567");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkumukbn1(C_UmuKbn.ARI);

        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzknmkn2("カナシメイ２");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzknmkj2("漢字氏名２");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzknmkjkhukakbn2(C_KjkhukaKbn.KJKHUKA);
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkseiymd2(BizDate.valueOf("19750925"));
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzksei2(C_Seibetu.FEMALE);
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzktdk2(C_Tdk.SHB);
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkyno2("7654321");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkadr1kj2("住所１漢字２");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkadr2kj2("住所２漢字２");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkadr3kj2("住所３漢字２");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzktelno2("022-0123-4567");
        setTrkKazokuExecUiBeanParamImpl.setVtrkkzktrkkzkumukbn2(C_UmuKbn.ARI);

        SetTrkKazoku.init(setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), null, "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), null, "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分２");

    }
}
