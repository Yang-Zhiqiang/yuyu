package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_Rendouflg;
import yuyu.def.db.dao.HT_SmbcStyKanriDao;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SMBC進捗管理データ作成クーリングオフクラスのメソッド {@link SmbcsintyokukanriCoolingoff#exec(String, BizDate, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SmbcsintyokukanriCoolingoffTest_exec {

    @Inject
    private SmbcsintyokukanriCoolingoff smbcsintyokukanriCoolingoff;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    private final static String syoNo1 = "11807111118";

    private final static String syoNo2 = "11807111129";

    private final static String syoNo3 = "11807111130";

    private final static String syoNo4 = "11807111141";

    private final static String syoNo5 = "11807111152";

    private final static String syoNo6 = "17806000301";

    private final static String fileName = "UT_SP_単体テスト仕様書_SMBC進捗管理データ作成クーリングオフ";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SmbcsintyokukanriCoolingoffTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SmbcStyKanriDao smbcStyKanriDao = SWAKInjector.getInstance(HT_SmbcStyKanriDao.class);
        sinkeiyakuDomManager.delete(smbcStyKanriDao.selectAll());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        baseUserInfo.getUser().setUserId("JUnit");

        smbcsintyokukanriCoolingoff.exec(syoNo1, BizDate.valueOf("20150609"), BizDate.valueOf("20150610"));

        HT_SmbcStyKanri smbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(BizDate.valueOf("20150610"), BizNumber.valueOf(7));

        exDateEquals(smbcStyKanri.getDatarenymd(), BizDate.valueOf("20150610"), "データ連動日");
        exBizCalcbleEquals(smbcStyKanri.getDatasakuseirenno(), BizNumber.valueOf(7), "データ作成連番");
        exStringEquals(smbcStyKanri.getSyono(), syoNo1, "証券番号");
        exStringEquals(smbcStyKanri.getMosno(), "791112220", "申込番号");
        exClassificationEquals(smbcStyKanri.getRendouflg(), C_Rendouflg.MIRENDOU, "連動フラグ");
        exStringEquals(smbcStyKanri.getSmbcdatakbn(), "0", "ＳＭＢＣ＿データ区分");
        exStringEquals(smbcStyKanri.getSmbcdatasakuseiymd(), "20150610", "ＳＭＢＣ＿データ作成日");
        exStringEquals(smbcStyKanri.getSmbchknkaisyacd(), "1", "ＳＭＢＣ＿保険会社コード");
        exStringEquals(smbcStyKanri.getSmbcuktkkanriid(), "2", "ＳＭＢＣ＿受付管理ID");
        exStringEquals(smbcStyKanri.getSmbcseihouktkzmymd(), "20150601", "ＳＭＢＣ＿生保受付済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohbymd(), "20150602", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(smbcStyKanri.getSmbcbankhnkykflg(), "0", "ＳＭＢＣ＿銀行返却フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihohbksyymd(), "20150603", "ＳＭＢＣ＿生保不備解消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohjyttykymd(), "20150604", "ＳＭＢＣ＿生保報状到着DATE");
        exStringEquals(smbcStyKanri.getSmbcseihonyknzmymd(), "20150605", "ＳＭＢＣ＿生保入金済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosnszmymd(), "20150606", "ＳＭＢＣ＿生保審査済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyknhkkzmymd(), "20150607", "ＳＭＢＣ＿生保証券発行済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyumoku(), "2", "ＳＭＢＣ＿生保種目");
        exStringEquals(smbcStyKanri.getSmbcseihosyurui(), "3", "ＳＭＢＣ＿生保種類");
        exStringEquals(smbcStyKanri.getSmbcsyono(), "10000000010", "ＳＭＢＣ＿証券番号");
        exStringEquals(smbcStyKanri.getSmbcsyonoedaban(), "001", "ＳＭＢＣ＿証券番号枝番");
        exStringEquals(smbcStyKanri.getSmbcjktkflg(), "0", "ＳＭＢＣ＿条件付フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihotrksymd(), "20150609", "ＳＭＢＣ＿生保取消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohktymd(), "20150608", "ＳＭＢＣ＿生保否決DATE");
        exStringEquals(smbcStyKanri.getSmbckykseiymd(), "20150609", "ＳＭＢＣ＿契約者生年月日");
        exStringEquals(smbcStyKanri.getSmbckyknmkn(), "カナ", "ＳＭＢＣ＿契約者名(カナ)");
        exStringEquals(smbcStyKanri.getSmbcmosuktymd(), "20150611", "ＳＭＢＣ＿申込書受付DATE");
        exStringEquals(smbcStyKanri.getSmbcmossyoriflg(), "1", "ＳＭＢＣ＿申込処理フラグ");
        exStringEquals(smbcStyKanri.getSmbckosyaareastyknr(), "3", "ＳＭＢＣ＿個社領域（進捗管理）");
        exStringEquals(smbcStyKanri.getGyoumuKousinKinou(), "SmbcsintyokukanriCoolingoffTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(smbcStyKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        smbcsintyokukanriCoolingoff.exec(syoNo2, BizDate.valueOf("20150613"), BizDate.valueOf("20150614"));

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager
            .getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(syoNo2, "", "");
        exNumericEquals(smbcStyKanriLst.size(), 0, "ＳＭＢＣ進捗管理テーブルエンティティリスト取得件数");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        baseUserInfo.getUser().setUserId("JUnit");

        smbcsintyokukanriCoolingoff.exec(syoNo3, BizDate.valueOf("20150617"), BizDate.valueOf("20150620"));

        HT_SmbcStyKanri smbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(BizDate.valueOf("20150620"), BizNumber.valueOf(7));

        exDateEquals(smbcStyKanri.getDatarenymd(), BizDate.valueOf("20150620"), "データ連動日");
        exBizCalcbleEquals(smbcStyKanri.getDatasakuseirenno(), BizNumber.valueOf(7), "データ作成連番");
        exStringEquals(smbcStyKanri.getSyono(), syoNo3, "証券番号");
        exStringEquals(smbcStyKanri.getMosno(), "791112238", "申込番号");
        exClassificationEquals(smbcStyKanri.getRendouflg(), C_Rendouflg.MIRENDOU, "連動フラグ");
        exStringEquals(smbcStyKanri.getSmbcdatakbn(), "0", "ＳＭＢＣ＿データ区分");
        exStringEquals(smbcStyKanri.getSmbcdatasakuseiymd(), "20150620", "ＳＭＢＣ＿データ作成日");
        exStringEquals(smbcStyKanri.getSmbchknkaisyacd(), "1", "ＳＭＢＣ＿保険会社コード");
        exStringEquals(smbcStyKanri.getSmbcuktkkanriid(), "2", "ＳＭＢＣ＿受付管理ID");
        exStringEquals(smbcStyKanri.getSmbcseihouktkzmymd(), "20151001", "ＳＭＢＣ＿生保受付済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohbymd(), "20151002", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(smbcStyKanri.getSmbcbankhnkykflg(), "0", "ＳＭＢＣ＿銀行返却フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihohbksyymd(), "20151003", "ＳＭＢＣ＿生保不備解消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohjyttykymd(), "20151004", "ＳＭＢＣ＿生保報状到着DATE");
        exStringEquals(smbcStyKanri.getSmbcseihonyknzmymd(), "20151005", "ＳＭＢＣ＿生保入金済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosnszmymd(), "20151006", "ＳＭＢＣ＿生保審査済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyknhkkzmymd(), "20151007", "ＳＭＢＣ＿生保証券発行済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyumoku(), "4", "ＳＭＢＣ＿生保種目");
        exStringEquals(smbcStyKanri.getSmbcseihosyurui(), "5", "ＳＭＢＣ＿生保種類");
        exStringEquals(smbcStyKanri.getSmbcsyono(), "10000000010", "ＳＭＢＣ＿証券番号");
        exStringEquals(smbcStyKanri.getSmbcsyonoedaban(), "001", "ＳＭＢＣ＿証券番号枝番");
        exStringEquals(smbcStyKanri.getSmbcjktkflg(), "0", "ＳＭＢＣ＿条件付フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihotrksymd(), "20150617", "ＳＭＢＣ＿生保取消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohktymd(), "20151008", "ＳＭＢＣ＿生保否決DATE");
        exStringEquals(smbcStyKanri.getSmbckykseiymd(), "20151009", "ＳＭＢＣ＿契約者生年月日");
        exStringEquals(smbcStyKanri.getSmbckyknmkn(), "カナ", "ＳＭＢＣ＿契約者名(カナ)");
        exStringEquals(smbcStyKanri.getSmbcmosuktymd(), "20151011", "ＳＭＢＣ＿申込書受付DATE");
        exStringEquals(smbcStyKanri.getSmbcmossyoriflg(), "1", "ＳＭＢＣ＿申込処理フラグ");
        exStringEquals(smbcStyKanri.getSmbckosyaareastyknr(), "7", "ＳＭＢＣ＿個社領域（進捗管理）");
        exStringEquals(smbcStyKanri.getGyoumuKousinKinou(), "SmbcsintyokukanriCoolingoffTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(smbcStyKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        baseUserInfo.getUser().setUserId("JUnit");
        smbcsintyokukanriCoolingoff.exec(syoNo4, BizDate.valueOf("20150621"), BizDate.valueOf("20150625"));

        HT_SmbcStyKanri smbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(BizDate.valueOf("20150625"), BizNumber.valueOf(1));

        exDateEquals(smbcStyKanri.getDatarenymd(), BizDate.valueOf("20150625"), "データ連動日");
        exBizCalcbleEquals(smbcStyKanri.getDatasakuseirenno(), BizNumber.valueOf(1), "データ作成連番");
        exStringEquals(smbcStyKanri.getSyono(), syoNo4, "証券番号");
        exStringEquals(smbcStyKanri.getMosno(), "791112253", "申込番号");
        exClassificationEquals(smbcStyKanri.getRendouflg(), C_Rendouflg.MIRENDOU, "連動フラグ");
        exStringEquals(smbcStyKanri.getSmbcdatakbn(), "2", "ＳＭＢＣ＿データ区分");
        exStringEquals(smbcStyKanri.getSmbcdatasakuseiymd(), "20150625", "ＳＭＢＣ＿データ作成日");
        exStringEquals(smbcStyKanri.getSmbchknkaisyacd(), "4", "ＳＭＢＣ＿保険会社コード");
        exStringEquals(smbcStyKanri.getSmbcuktkkanriid(), "6", "ＳＭＢＣ＿受付管理ID");
        exStringEquals(smbcStyKanri.getSmbcseihouktkzmymd(), "20150901", "ＳＭＢＣ＿生保受付済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohbymd(), "20150902", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(smbcStyKanri.getSmbcbankhnkykflg(), "1", "ＳＭＢＣ＿銀行返却フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihohbksyymd(), "20150903", "ＳＭＢＣ＿生保不備解消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohjyttykymd(), "20150904", "ＳＭＢＣ＿生保報状到着DATE");
        exStringEquals(smbcStyKanri.getSmbcseihonyknzmymd(), "20150905", "ＳＭＢＣ＿生保入金済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosnszmymd(), "20150906", "ＳＭＢＣ＿生保審査済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyknhkkzmymd(), "20150907", "ＳＭＢＣ＿生保証券発行済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyumoku(), "8", "ＳＭＢＣ＿生保種目");
        exStringEquals(smbcStyKanri.getSmbcseihosyurui(), "9", "ＳＭＢＣ＿生保種類");
        exStringEquals(smbcStyKanri.getSmbcsyono(), "10000000022", "ＳＭＢＣ＿証券番号");
        exStringEquals(smbcStyKanri.getSmbcsyonoedaban(), "002", "ＳＭＢＣ＿証券番号枝番");
        exStringEquals(smbcStyKanri.getSmbcjktkflg(), "1", "ＳＭＢＣ＿条件付フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihotrksymd(), "20150621", "ＳＭＢＣ＿生保取消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohktymd(), "20150908", "ＳＭＢＣ＿生保否決DATE");
        exStringEquals(smbcStyKanri.getSmbckykseiymd(), "20150909", "ＳＭＢＣ＿契約者生年月日");
        exStringEquals(smbcStyKanri.getSmbckyknmkn(), "カナ", "ＳＭＢＣ＿契約者名(カナ)");
        exStringEquals(smbcStyKanri.getSmbcmosuktymd(), "20150911", "ＳＭＢＣ＿申込書受付DATE");
        exStringEquals(smbcStyKanri.getSmbcmossyoriflg(), "1", "ＳＭＢＣ＿申込処理フラグ");
        exStringEquals(smbcStyKanri.getSmbckosyaareastyknr(), "2", "ＳＭＢＣ＿個社領域（進捗管理）");
        exStringEquals(smbcStyKanri.getGyoumuKousinKinou(), "SmbcsintyokukanriCoolingoffTest_exec", "業務用更新機能ＩＤ");
        exStringEquals(smbcStyKanri.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setKinouId("skcommonteskcommonteskcommonteskcommonteskcommonte");

        baseUserInfo.getUser().setUserId("JUnit1234567890");

        smbcsintyokukanriCoolingoff.exec("11807111163", BizDate.valueOf("20150609"), BizDate.valueOf("20150629"));

        HT_SmbcStyKanri smbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(BizDate.valueOf("20150629"), BizNumber.valueOf(1234568));

        exDateEquals(smbcStyKanri.getDatarenymd(), BizDate.valueOf("20150629"), "データ連動日");
        exBizCalcbleEquals(smbcStyKanri.getDatasakuseirenno(), BizNumber.valueOf(1234568), "データ作成連番");
        exStringEquals(smbcStyKanri.getSyono(), "11807111163", "証券番号");
        exStringEquals(smbcStyKanri.getMosno(), "791112279", "申込番号");
        exClassificationEquals(smbcStyKanri.getRendouflg(), C_Rendouflg.MIRENDOU, "連動フラグ");
        exStringEquals(smbcStyKanri.getSmbcdatakbn(), "0", "ＳＭＢＣ＿データ区分");
        exStringEquals(smbcStyKanri.getSmbcdatasakuseiymd(), "20150629", "ＳＭＢＣ＿データ作成日");
        exStringEquals(smbcStyKanri.getSmbchknkaisyacd(), "11", "ＳＭＢＣ＿保険会社コード");
        exStringEquals(smbcStyKanri.getSmbcuktkkanriid(), "12345678901", "ＳＭＢＣ＿受付管理ID");
        exStringEquals(smbcStyKanri.getSmbcseihouktkzmymd(), "20150601", "ＳＭＢＣ＿生保受付済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohbymd(), "20150602", "ＳＭＢＣ＿生保不備DATE");
        exStringEquals(smbcStyKanri.getSmbcbankhnkykflg(), "0", "ＳＭＢＣ＿銀行返却フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihohbksyymd(), "20150603", "ＳＭＢＣ＿生保不備解消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohjyttykymd(), "20150604", "ＳＭＢＣ＿生保報状到着DATE");
        exStringEquals(smbcStyKanri.getSmbcseihonyknzmymd(), "20150605", "ＳＭＢＣ＿生保入金済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosnszmymd(), "20150606", "ＳＭＢＣ＿生保審査済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyknhkkzmymd(), "20150907", "ＳＭＢＣ＿生保証券発行済DATE");
        exStringEquals(smbcStyKanri.getSmbcseihosyumoku(), "11", "ＳＭＢＣ＿生保種目");
        exStringEquals(smbcStyKanri.getSmbcseihosyurui(), "12", "ＳＭＢＣ＿生保種類");
        exStringEquals(smbcStyKanri.getSmbcsyono(), "100000000100", "ＳＭＢＣ＿証券番号");
        exStringEquals(smbcStyKanri.getSmbcsyonoedaban(), "00001", "ＳＭＢＣ＿証券番号枝番");
        exStringEquals(smbcStyKanri.getSmbcjktkflg(), "0", "ＳＭＢＣ＿条件付フラグ");
        exStringEquals(smbcStyKanri.getSmbcseihotrksymd(), "20150609", "ＳＭＢＣ＿生保取消DATE");
        exStringEquals(smbcStyKanri.getSmbcseihohktymd(), "20150608", "ＳＭＢＣ＿生保否決DATE");
        exStringEquals(smbcStyKanri.getSmbckykseiymd(), "20150609", "ＳＭＢＣ＿契約者生年月日");
        exStringEquals(smbcStyKanri.getSmbckyknmkn(), "カナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナカナ", "ＳＭＢＣ＿契約者名(カナ)");
        exStringEquals(smbcStyKanri.getSmbcmosuktymd(), "20150611", "ＳＭＢＣ＿申込書受付DATE");
        exStringEquals(smbcStyKanri.getSmbcmossyoriflg(), "1", "ＳＭＢＣ＿申込処理フラグ");
        exStringEquals(smbcStyKanri.getSmbckosyaareastyknr(), "12345678901234567890123456", "ＳＭＢＣ＿個社領域（進捗管理）");
        exStringEquals(smbcStyKanri.getGyoumuKousinKinou(), "skcommonteskcommonteskcommonteskcommonteskcommonte", "業務用更新機能ＩＤ");
        exStringEquals(smbcStyKanri.getGyoumuKousinsyaId(), "JUnit1234567890", "業務用更新者ＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        smbcsintyokukanriCoolingoff.exec(syoNo6, BizDate.valueOf("20170229"), BizDate.valueOf("20150610"));
        HT_SmbcStyKanri smbcStyKanri = sinkeiyakuDomManager.getSmbcStyKanri(BizDate.valueOf("20150610"), BizNumber.valueOf(2));
        assertNull("WK．ＳＭＢＣ進捗管理テーブルエンティティ", smbcStyKanri);

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_B1() {
        smbcsintyokukanriCoolingoff.exec(syoNo5, null, BizDate.valueOf("20150628"));

        sinkeiyakuDomManager.flush();

        List<HT_SmbcStyKanri> smbcStyKanriLst = sinkeiyakuDomManager
            .getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(syoNo5, "", "");
        exNumericEquals(smbcStyKanriLst.size(), 0, "ＳＭＢＣ進捗管理テーブルエンティティリスト取得件数");
    }

}
