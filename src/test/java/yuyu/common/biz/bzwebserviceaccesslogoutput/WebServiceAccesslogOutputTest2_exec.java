package yuyu.common.biz.bzwebserviceaccesslogoutput;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbKeiyakuSyoukaiWebServiceInputBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebKaiyakuhrSuiiInputBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.dsweb.bean.webservice.WsDwHonninKakuninInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwHukamojiCheckInputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * WEBサービスアクセスログ出力クラスのメソッド {@link WebServiceAccesslogOutput#exec(String, String, WsBzWebserviceReqParamBean, Map<String, String>)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class WebServiceAccesslogOutputTest2_exec extends AbstractTest{

    @Inject
    private WebServiceAccesslogOutput webServiceAccesslogOutput;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAccessLogsByTimeStamp(Long.valueOf("20161115000000000"),Long.valueOf("20161119235959999")));

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        //        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        //        bizDomManager.delete(bizDomManager.getAccessLogsByTimeStamp(Long.valueOf("20160927000000000"),Long.valueOf("20160929999999999")));
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(1)
    public void testExec_A1() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        changeSystemDate(BizDate.valueOf(20161115));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("");

        WsHbSeihoWebKaiyakuhrSuiiInputBean wsHbSeihoWebKaiyakuhrSuiiInputBean =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceReqParamBean.getGyoumuData(), WsHbSeihoWebKaiyakuhrSuiiInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbSeihoWebKaiyakuhrSuiiInputBean);

        ExDBResults<AT_AccessLog> accessLogList = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(Long.valueOf("20161115000000000"),Long.valueOf("20161115235959999"));

        for(AT_AccessLog accessLog : accessLogList) {
            exStringEquals(accessLog.getSyoriUserId(), "operatorId", "処理ユーザID");
            exStringEquals(accessLog.getTransactionId(), "", "トランザクションID");
            exClassificationEquals(accessLog.getLogKindCd(), C_AccessLogSyubetuKbn.ACTION_BEGIN, "ログ種別コード");
            exStringEquals(accessLog.getSubSystemId(), "subsystemid", "サブシステムID");
            exStringEquals(accessLog.getCategoryId(), "categoryid", "カテゴリID");
            exStringEquals(accessLog.getKinouId(), "kinouid", "機能ID");
            exStringEquals(accessLog.getTanmatuType(), "1", "端末タイプ");
            exStringEquals(accessLog.getButsuriSosikiCd(), "", "物理組織コード");
            exStringEquals(accessLog.getRonriSosikiCd(), "orgCode", "論理組織コード");
            exStringEquals(accessLog.getTanmatuJyoutaiHyouji(), "", "端末状態表示");
            exStringEquals(accessLog.getLogData(), "classname/methodname", "ログデータ");
            exNumericEquals(accessLog.getSyousaiKensuu(), Long.valueOf(0), "詳細ログ件数");

            exNumericEquals(accessLog.getAccessLogSyousais().size(), 0, "アクセスログ詳細エンティティリスト件数");

        }

        accessLogList.close();
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(2)
    public void testExec_A2() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        changeSystemDate(BizDate.valueOf(20161116));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("iwsSyono11keta:\"12345678901\"");

        WsHbKeiyakuSyoukaiWebServiceInputBean wsHbKeiyakuSyoukaiWebServiceInputBean = JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsHbKeiyakuSyoukaiWebServiceInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbKeiyakuSyoukaiWebServiceInputBean);

        ExDBResults<AT_AccessLog> accessLogList = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(Long.valueOf("20161116000000000"),Long.valueOf("20161116235959999"));

        for(AT_AccessLog accessLog : accessLogList) {
            exStringEquals(accessLog.getSyoriUserId(), "operatorId", "処理ユーザID");
            exStringEquals(accessLog.getTransactionId(), "", "トランザクションID");
            exClassificationEquals(accessLog.getLogKindCd(), C_AccessLogSyubetuKbn.ACTION_BEGIN, "ログ種別コード");
            exStringEquals(accessLog.getSubSystemId(), "subsystemid", "サブシステムID");
            exStringEquals(accessLog.getCategoryId(), "categoryid", "カテゴリID");
            exStringEquals(accessLog.getKinouId(), "kinouid", "機能ID");
            exStringEquals(accessLog.getTanmatuType(), "1", "端末タイプ");
            exStringEquals(accessLog.getButsuriSosikiCd(), "", "物理組織コード");
            exStringEquals(accessLog.getRonriSosikiCd(), "orgCode", "論理組織コード");
            exStringEquals(accessLog.getTanmatuJyoutaiHyouji(), "", "端末状態表示");
            exStringEquals(accessLog.getLogData(), "classname/methodname", "ログデータ");
            exNumericEquals(accessLog.getSyousaiKensuu(), Long.valueOf(1), "詳細ログ件数");

            exNumericEquals(accessLog.getAccessLogSyousais().size(), 1, "アクセスログ詳細エンティティリスト件数");

            AT_AccessLogSyousai accessLogSyousai = accessLog.getAccessLogSyousais().get(0);

            exNumericEquals(accessLogSyousai.getSyousaiEdaNo(), Long.valueOf(1), "詳細ログ枝番号");
            exStringEquals(accessLogSyousai.getLogSyousaiData(), "iwsSyono11keta=12345678901", "ログ詳細データ");
        }

        accessLogList.close();
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(3)
    public void testExec_A3() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        changeSystemDate(BizDate.valueOf(20161117));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("a201601011201612312a012016070120161115201610bcd123456789123456789012323456789013456789012345341111122222512346789333d1d2d3d4d5045678901234444455556666777708888199990101011212345");

        WsHbSeihoWebKaiyakuhrSuiiInputBean wsHbSeihoWebKaiyakuhrSuiiInputBean =
            FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceReqParamBean.getGyoumuData(), WsHbSeihoWebKaiyakuhrSuiiInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbSeihoWebKaiyakuhrSuiiInputBean);

        ExDBResults<AT_AccessLog> accessLogList = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(Long.valueOf("20161117000000000"),Long.valueOf("20161117235959999"));

        for(AT_AccessLog accessLog : accessLogList) {
            exStringEquals(accessLog.getSyoriUserId(), "operatorId", "処理ユーザID");
            exStringEquals(accessLog.getTransactionId(), "", "トランザクションID");
            exClassificationEquals(accessLog.getLogKindCd(), C_AccessLogSyubetuKbn.ACTION_BEGIN, "ログ種別コード");
            exStringEquals(accessLog.getSubSystemId(), "subsystemid", "サブシステムID");
            exStringEquals(accessLog.getCategoryId(), "categoryid", "カテゴリID");
            exStringEquals(accessLog.getKinouId(), "kinouid", "機能ID");
            exStringEquals(accessLog.getTanmatuType(), "1", "端末タイプ");
            exStringEquals(accessLog.getButsuriSosikiCd(), "", "物理組織コード");
            exStringEquals(accessLog.getRonriSosikiCd(), "orgCode", "論理組織コード");
            exStringEquals(accessLog.getTanmatuJyoutaiHyouji(), "", "端末状態表示");
            exStringEquals(accessLog.getLogData(), "classname/methodname", "ログデータ");
            exNumericEquals(accessLog.getSyousaiKensuu(), Long.valueOf(49), "詳細ログ件数");

            exNumericEquals(accessLog.getAccessLogSyousais().size(), 49, "アクセスログ詳細エンティティリスト件数");

            AT_AccessLogSyousai accessLogSyousai = accessLog.getAccessLogSyousais().get(0);

            exNumericEquals(accessLogSyousai.getSyousaiEdaNo(), Long.valueOf(1), "詳細ログ枝番号");
        }

        accessLogList.close();
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(4)
    public void testExec_A4() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        changeSystemDate(BizDate.valueOf(20161118));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("012345678901234567890123456789");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("1234567");
        wsBzWebserviceReqParamBean.setMethodName("01234567890123456789012345678901234567890123456789.01234567890123456789012345678901234567890123456789.01234567890123456789012345678901234567890123456789.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("\"iwsSyono11keta\":12345678901");

        WsHbKeiyakuSyoukaiWebServiceInputBean wsHbKeiyakuSyoukaiWebServiceInputBean = JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsHbKeiyakuSyoukaiWebServiceInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsHbKeiyakuSyoukaiWebServiceInputBean);

        ExDBResults<AT_AccessLog> accessLogList = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(Long.valueOf("20161118000000000"),Long.valueOf("20161118235959999"));

        for(AT_AccessLog accessLog : accessLogList) {
            exStringEquals(accessLog.getSyoriUserId(), "012345678901234567890123456789", "処理ユーザID");
            exStringEquals(accessLog.getTransactionId(), "", "トランザクションID");
            exClassificationEquals(accessLog.getLogKindCd(), C_AccessLogSyubetuKbn.ACTION_BEGIN, "ログ種別コード");
            exStringEquals(accessLog.getSubSystemId(), "01234567890123456789012345678901234567890123456789", "サブシステムID");
            exStringEquals(accessLog.getCategoryId(), "01234567890123456789012345678901234567890123456789", "カテゴリID");
            exStringEquals(accessLog.getKinouId(), "01234567890123456789012345678901234567890123456789", "機能ID");
            exStringEquals(accessLog.getTanmatuType(), "1", "端末タイプ");
            exStringEquals(accessLog.getButsuriSosikiCd(), "", "物理組織コード");
            exStringEquals(accessLog.getRonriSosikiCd(), "1234567", "論理組織コード");
            exStringEquals(accessLog.getTanmatuJyoutaiHyouji(), "", "端末状態表示");
            exStringEquals(accessLog.getLogData(), "classname/methodname", "ログデータ");
            exNumericEquals(accessLog.getSyousaiKensuu(), Long.valueOf(1), "詳細ログ件数");

            exNumericEquals(accessLog.getAccessLogSyousais().size(), 1, "アクセスログ詳細エンティティリスト件数");

            AT_AccessLogSyousai accessLogSyousai = accessLog.getAccessLogSyousais().get(0);

            exNumericEquals(accessLogSyousai.getSyousaiEdaNo(), Long.valueOf(1), "詳細ログ枝番号");
            exStringEquals(accessLogSyousai.getLogSyousaiData(), "iwsSyono11keta=12345678901", "ログ詳細データ");
        }

        accessLogList.close();
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(5)
    public void testExec_A5() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        changeSystemDate(BizDate.valueOf(20161119));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("iwsSyono:\"12345678901\",iwsDskokno:\"0123456789\",iwsNmkn:\"あいうえおかきくけこさしすせそたちつ\",iwsSeiymd:\"19740812\",iwsTelnosimo4:\"0716\"");

        WsDwHonninKakuninInputBean wsDwHonninKakuninInputBean =
            JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsDwHonninKakuninInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsDwHonninKakuninInputBean);

        ExDBResults<AT_AccessLog> accessLogList = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(Long.valueOf("20161119000000000"),Long.valueOf("20161119235959999"));

        for(AT_AccessLog accessLog : accessLogList) {
            exStringEquals(accessLog.getSyoriUserId(), "operatorId", "処理ユーザID");
            exStringEquals(accessLog.getTransactionId(), "", "トランザクションID");
            exClassificationEquals(accessLog.getLogKindCd(), C_AccessLogSyubetuKbn.ACTION_BEGIN, "ログ種別コード");
            exStringEquals(accessLog.getSubSystemId(), "subsystemid", "サブシステムID");
            exStringEquals(accessLog.getCategoryId(), "categoryid", "カテゴリID");
            exStringEquals(accessLog.getKinouId(), "kinouid", "機能ID");
            exStringEquals(accessLog.getTanmatuType(), "1", "端末タイプ");
            exStringEquals(accessLog.getButsuriSosikiCd(), "", "物理組織コード");
            exStringEquals(accessLog.getRonriSosikiCd(), "orgCode", "論理組織コード");
            exStringEquals(accessLog.getTanmatuJyoutaiHyouji(), "", "端末状態表示");
            exStringEquals(accessLog.getLogData(), "classname/methodname", "ログデータ");
            exNumericEquals(accessLog.getSyousaiKensuu(), Long.valueOf(5), "詳細ログ件数");

            exNumericEquals(accessLog.getAccessLogSyousais().size(), 5, "アクセスログ詳細エンティティリスト件数");

        }

        accessLogList.close();
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(6)
    public void testExec_A6() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        changeSystemDate(BizDate.valueOf(20161120));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("iwsCheckmojiretu:\"あaいbうcえdおeかfきgくhけiこjさkしlすmせnそo\"");

        WsDwHukamojiCheckInputBean wsDwHukamojiCheckInputBean =
            JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsDwHukamojiCheckInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsDwHukamojiCheckInputBean);

        ExDBResults<AT_AccessLog> accessLogList = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(Long.valueOf("20161120000000000"),Long.valueOf("20161120235959999"));

        for(AT_AccessLog accessLog : accessLogList) {
            exStringEquals(accessLog.getSyoriUserId(), "operatorId", "処理ユーザID");
            exStringEquals(accessLog.getTransactionId(), "", "トランザクションID");
            exClassificationEquals(accessLog.getLogKindCd(), C_AccessLogSyubetuKbn.ACTION_BEGIN, "ログ種別コード");
            exStringEquals(accessLog.getSubSystemId(), "subsystemid", "サブシステムID");
            exStringEquals(accessLog.getCategoryId(), "categoryid", "カテゴリID");
            exStringEquals(accessLog.getKinouId(), "kinouid", "機能ID");
            exStringEquals(accessLog.getTanmatuType(), "1", "端末タイプ");
            exStringEquals(accessLog.getButsuriSosikiCd(), "", "物理組織コード");
            exStringEquals(accessLog.getRonriSosikiCd(), "orgCode", "論理組織コード");
            exStringEquals(accessLog.getTanmatuJyoutaiHyouji(), "", "端末状態表示");
            exStringEquals(accessLog.getLogData(), "classname/methodname", "ログデータ");
            exNumericEquals(accessLog.getSyousaiKensuu(), Long.valueOf(1), "詳細ログ件数");

            exNumericEquals(accessLog.getAccessLogSyousais().size(), 1, "アクセスログ詳細エンティティリスト件数");

            AT_AccessLogSyousai accessLogSyousai = accessLog.getAccessLogSyousais().get(0);

            exNumericEquals(accessLogSyousai.getSyousaiEdaNo(), Long.valueOf(1), "詳細ログ枝番号");
            exStringEquals(accessLogSyousai.getLogSyousaiData(), "iwsCheckmojiretu=あaいbうcえdおeかfきgくhけiこjさkしlすmせnそo", "ログ詳細データ");
        }

        accessLogList.close();
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(7)
    public void testExec_A7() {
        changeSystemDate(BizDate.valueOf(20161121));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("iwsCheckmojiretu:\"あaいbうcえdおeかfきgくhけiこjさkしlすmせnそo\"");

        WsDwHukamojiCheckInputBean wsDwHukamojiCheckInputBean =
            JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsDwHukamojiCheckInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN, wsBzWebserviceReqParamBean, wsDwHukamojiCheckInputBean);
    }

    @SuppressWarnings("unused")
    @Test
    @TestOrder(8)
    public void testExec_A8() {
        changeSystemDate(BizDate.valueOf(20161122));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        wsBzWebserviceReqParamBean.setOperatorId("operatorId");
        wsBzWebserviceReqParamBean.setCoopClass("01");
        wsBzWebserviceReqParamBean.setOrgCode("orgCode");
        wsBzWebserviceReqParamBean.setMethodName("subsystemid.categoryid.kinouid.classname/methodname");
        wsBzWebserviceReqParamBean.setGyoumuData("iwsCheckmojiretu:\"あaいbうcえdおeかfきgくhけiこjさkしlすmせnそo\"");

        WsDwHukamojiCheckInputBean wsDwHukamojiCheckInputBean =
            JSON.decode(wsBzWebserviceReqParamBean.getGyoumuData(), WsDwHukamojiCheckInputBean.class);

        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_END, wsBzWebserviceReqParamBean, wsDwHukamojiCheckInputBean);
    }
}