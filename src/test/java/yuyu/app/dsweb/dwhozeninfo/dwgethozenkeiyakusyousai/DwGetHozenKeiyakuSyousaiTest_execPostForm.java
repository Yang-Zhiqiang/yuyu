package yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutputMockForDirect;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousai;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiMockForDirect;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwGetHozenKeiyakuSyousaiOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保全契約詳細取得のメイン処理{@link DwGetHozenKeiyakuSyousaiImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwGetHozenKeiyakuSyousaiTest_execPostForm extends AbstractTest {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(DsGetKeiyakuSyousai.class).to(DsGetKeiyakuSyousaiMockForDirect.class);
                bind(WebServiceAccesslogOutput.class).to(WebServiceAccesslogOutputMockForDirect.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        DsGetKeiyakuSyousaiMockForDirect.caller = DwGetHozenKeiyakuSyousaiTest_execPostForm.class;
        WebServiceAccesslogOutputMockForDirect.caller = DwGetHozenKeiyakuSyousaiTest_execPostForm.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        DsGetKeiyakuSyousaiMockForDirect.caller = null;
        DsGetKeiyakuSyousaiMockForDirect.SYORIPTN = null;
        WebServiceAccesslogOutputMockForDirect.caller = null;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = null;
    }

    @Test
    @TestOrder(1010)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':''}");

        DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "005100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(2010)
    public void testExecPostForm_B1() throws Exception {

        MockObjectManager.initialize();
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'100000000001'}");

        DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "005100", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(3010)
    public void testExecPostForm_C1() throws Exception {

        MockObjectManager.initialize();
        DsGetKeiyakuSyousaiMockForDirect.SYORIPTN = DsGetKeiyakuSyousaiMockForDirect.TESTPATTERN1;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111118'}");

        DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "005200", "（ＩＷＳ）ＤＳメッセージコード");
    }

    @Test
    @TestOrder(3020)
    public void testExecPostForm_C2() throws Exception {

        MockObjectManager.initialize();
        DsGetKeiyakuSyousaiMockForDirect.SYORIPTN = DsGetKeiyakuSyousaiMockForDirect.TESTPATTERN2;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111129'}");

        DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "005000", "（ＩＷＳ）ＤＳメッセージコード ");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyono(), "11807111129", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyouhnnm(), "", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHhknnmkn(), "", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHhknseiymdstr(), null, "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykymdstr(), null, "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTutakinumukbn(), "0", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSbhsyumukbn(), "0", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKghsyumukbn(), "0", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsIryhsyumukbn(), "0", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRougohsyumukbn(), "0", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSakuseikijyunymdstr(), null, "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSksikijyunymdkawaserate(), "0", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKwsratekijyunymdsakusei(), null, "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsPtumitatekngkyen(), "0", "（ＩＷＳ）保険料積立金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsPtumitatekngkgaika(), "0", "（ＩＷＳ）保険料積立金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyktuukasyu(), "0", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsytuukasyu(), "0", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKaiyakuhryen(), "0", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKaiyakuhrgaika(), "0", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKaiyakuhrsuiiumukbn(), "0", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsAisyoumei(), "", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyknmkn(), "", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyknmkj(), "", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykseiymdstr(), null, "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyksei(), "0", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSbuktnin(), "0", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn1(), "0", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn1str(), "0", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei1(), "", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn2(), "0", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn2str(), "0", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei2(), "", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn3(), "0", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn3str(), "0", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei3(), "", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn4(), "0", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn4str(), "0", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei4(), "", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn5(), "0", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn5str(), "0", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei5(), "", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn6(), "0", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn6str(), "0", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei6(), "", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn7(), "0", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn7str(), "0", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei7(), "", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn8(), "0", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn8str(), "0", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei8(), "", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn9(), "0", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn9str(), "0", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei9(), "", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn10(), "0", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn10str(), "0", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei10(), "", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknkaisiymd1str(), null, "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknmanryouymd1str(), null, "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkkn1(), "0", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknkaisiymd2str(), null, "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknmanryouymd2str(), null, "（ＩＷＳ）第２保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkkn2(), "0", "（ＩＷＳ）第２保険期間");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknkaisiymd3str(), null, "（ＩＷＳ）第３保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknmanryouymd3str(), null, "（ＩＷＳ）第３保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsStdrsktkyhkumu(), "0", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsYennykntkhkumu(), "0", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsGaikanykntkhkumu(), "0", "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTargettkhkumu(), "0", "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyksbyensitihsyutyhkumu(), "0", "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsJyudkaigomehrtkhkumu(), "0", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsZeiseitkkktkykhukaumu(), "0", "（ＩＷＳ）税制適格特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsymdkawaserate(), "0", "（ＩＷＳ）領収日為替レート");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsymdkawaseratestigi(), "0", "（ＩＷＳ）領収日為替レート（指定外通貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKwsratekijyunymdrs(), null, "（ＩＷＳ）為替レート基準日（領収日）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKwsratekijyunymdrsstigi(), null, "（ＩＷＳ）為替レート基準日（領収日）（指定外通貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsgakuyen(), "0", "（ＩＷＳ）領収金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsgakustigi(), "0", "（ＩＷＳ）領収金額（指定外通貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKijyunkingaku(), "0", "（ＩＷＳ）基準金額");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsItijibrprsyen(), "0", "（ＩＷＳ）一時払保険料（領収日）（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsItijibrpgaika(), "0", "（ＩＷＳ）一時払保険料（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsItijibrprsgaika(), "0", "（ＩＷＳ）一時払保険料（領収日）（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKihonhokenkngkgaika(), "0", "（ＩＷＳ）基本保険金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsMkhgkwari(), "0", "（ＩＷＳ）目標額割合");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSibohknkngkyen(), "0", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSibohknkngkgaika(), "0", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSgsbhknkngkyen(), "0", "（ＩＷＳ）災害死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSgsbhknkngkkgaika(), "0", "（ＩＷＳ）災害死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSgsbhknkngkhyoujiumu(), "0", "（ＩＷＳ）災害死亡保険金額表示有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKjsmsaihakkoukahikbn(), "0", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykmeigihnkkahikbn(), "0", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyoukensaihkkahikbn(), "0", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsStdrsktkytthkkahikbn(), "0", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTargettkhkkahikbn(), "0", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHokenkngkksnkekkakbn(), "0", "（ＩＷＳ）保険金額計算結果区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykniyusyoukaikahikbn(), "0", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTumitatekinitenkahikbn(), "0", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDskaiyakukahikbn(), "0", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsAdrhenkoukahikbn(), "0", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsPhrkhouhenkoukahikbn(), "0", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkkn3hyoujiumu(), "0", "（ＩＷＳ）第３保険期間表示有無");
    }

    @Test
    @TestOrder(3030)
    public void testExecPostForm_C3() throws Exception {

        MockObjectManager.initialize();
        DsGetKeiyakuSyousaiMockForDirect.SYORIPTN = DsGetKeiyakuSyousaiMockForDirect.TESTPATTERN3;
        WebServiceAccesslogOutputMockForDirect.SYORIPTN = WebServiceAccesslogOutputMockForDirect.TESTPATTERN1;


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'11807111163'}");

        DwGetHozenKeiyakuSyousaiImpl dwGetHozenKeiyakuSyousaiImpl = SWAKInjector.getInstance(DwGetHozenKeiyakuSyousaiImpl.class);
        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetHozenKeiyakuSyousaiImpl.execPostForm(pMap);
        WsDwGetHozenKeiyakuSyousaiOutputBean wsDwGetHozenKeiyakuSyousaiOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetHozenKeiyakuSyousaiOutputBean.class);

        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDsmsgcd(), "005000", "（ＩＷＳ）ＤＳメッセージコード ");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyono(), "11807111163", "（ＩＷＳ）証券番号");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyouhnnm(), "商品名", "（ＩＷＳ）商品名");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHhknnmkn(), "カナカナ", "（ＩＷＳ）被保険者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHhknseiymdstr(), "19901102", "（ＩＷＳ）被保険者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykymdstr(), "20161122", "（ＩＷＳ）契約日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTutakinumukbn(), "1", "（ＩＷＳ）積立金有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSbhsyumukbn(), "1", "（ＩＷＳ）死亡保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKghsyumukbn(), "1", "（ＩＷＳ）介護保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsIryhsyumukbn(), "1", "（ＩＷＳ）医療保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRougohsyumukbn(), "1", "（ＩＷＳ）老後保障有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSakuseikijyunymdstr(), "20161101", "（ＩＷＳ）作成基準日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSksikijyunymdkawaserate(), "100", "（ＩＷＳ）作成基準日為替レート");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKwsratekijyunymdsakusei(), "20161102", "（ＩＷＳ）為替レート基準日（作成基準日）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsPtumitatekngkyen(), "200", "（ＩＷＳ）保険料積立金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsPtumitatekngkgaika(), "300", "（ＩＷＳ）保険料積立金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyktuukasyu(), "JPY", "（ＩＷＳ）契約通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsytuukasyu(), "USD", "（ＩＷＳ）領収通貨種類");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKaiyakuhryen(), "400", "（ＩＷＳ）解約返戻金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKaiyakuhrgaika(), "500", "（ＩＷＳ）解約返戻金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKaiyakuhrsuiiumukbn(), "1", "（ＩＷＳ）解約返戻金推移有無区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsAisyoumei(), "愛称名", "（ＩＷＳ）愛称名");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyknmkn(), "カナ", "（ＩＷＳ）契約者名（カナ）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyknmkj(), "契約者名（漢字）", "（ＩＷＳ）契約者名（漢字）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykseiymdstr(), "19801012", "（ＩＷＳ）契約者生年月日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKyksei(), "2", "（ＩＷＳ）契約者性別");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSbuktnin(), "4", "（ＩＷＳ）死亡受取人人数");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn1(), "1", "（ＩＷＳ）受取人見出し区分１");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn1str(), "01", "（ＩＷＳ）受取人区分１（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei1(), "死亡受取人名１（漢字）", "（ＩＷＳ）受取人氏名１");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn2(), "2", "（ＩＷＳ）受取人見出し区分２");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn2str(), "02", "（ＩＷＳ）受取人区分２（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei2(), "死亡受取人名２（漢字）", "（ＩＷＳ）受取人氏名２");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn3(), "3", "（ＩＷＳ）受取人見出し区分３");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn3str(), "03", "（ＩＷＳ）受取人区分３（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei3(), "死亡受取人名３（漢字）", "（ＩＷＳ）受取人氏名３");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn4(), "4", "（ＩＷＳ）受取人見出し区分４");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn4str(), "04", "（ＩＷＳ）受取人区分４（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei4(), "死亡受取人名４（漢字）", "（ＩＷＳ）受取人氏名４");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn5(), "5", "（ＩＷＳ）受取人見出し区分５");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn5str(), "05", "（ＩＷＳ）受取人区分５（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei5(), "死亡受取人名５（漢字）", "（ＩＷＳ）受取人氏名５");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn6(), "9", "（ＩＷＳ）受取人見出し区分６");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn6str(), "06", "（ＩＷＳ）受取人区分６（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei6(), "死亡受取人名６（漢字）", "（ＩＷＳ）受取人氏名６");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn7(), "1", "（ＩＷＳ）受取人見出し区分７");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn7str(), "07", "（ＩＷＳ）受取人区分７（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei7(), "死亡受取人名７（漢字）", "（ＩＷＳ）受取人氏名７");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn8(), "2", "（ＩＷＳ）受取人見出し区分８");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn8str(), "02", "（ＩＷＳ）受取人区分８（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei8(), "死亡受取人名８（漢字）", "（ＩＷＳ）受取人氏名８");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn9(), "3", "（ＩＷＳ）受取人見出し区分９");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn9str(), "03", "（ＩＷＳ）受取人区分９（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei9(), "死亡受取人名９（漢字）", "（ＩＷＳ）受取人氏名９");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktmidasikbn10(), "4", "（ＩＷＳ）受取人見出し区分１０");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktkbn10str(), "04", "（ＩＷＳ）受取人区分１０（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsUktsimei10(), "死亡受取人名１０（漢字）", "（ＩＷＳ）受取人氏名１０");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknkaisiymd1str(), "20161201", "（ＩＷＳ）第１保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknmanryouymd1str(), "20250101", "（ＩＷＳ）第１保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkkn1(), "0", "（ＩＷＳ）第１保険期間");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknkaisiymd2str(), "20161202", "（ＩＷＳ）第２保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknmanryouymd2str(), "20260101", "（ＩＷＳ）第２保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkkn2(), "0", "（ＩＷＳ）第２保険期間");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknkaisiymd3str(), "20161203", "（ＩＷＳ）第３保険期間開始日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkknmanryouymd3str(), "20270101", "（ＩＷＳ）第３保険期間満了日（文字列）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsStdrsktkyhkumu(), "1", "（ＩＷＳ）指定代理請求特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsYennykntkhkumu(), "1", "（ＩＷＳ）円入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsGaikanykntkhkumu(), "1", "（ＩＷＳ）外貨入金特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTargettkhkumu(), "1", "（ＩＷＳ）ターゲット特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyksbyensitihsyutyhkumu(), "1", "（ＩＷＳ）初期死亡時円換算最低保証特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsJyudkaigomehrtkhkumu(), "1", "（ＩＷＳ）重度介護前払特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsZeiseitkkktkykhukaumu(), "1", "（ＩＷＳ）税制適格特約付加有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsymdkawaserate(), "600", "（ＩＷＳ）領収日為替レート");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsymdkawaseratestigi(), "100", "（ＩＷＳ）領収日為替レート（指定外通貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKwsratekijyunymdrs(), "20161101", "（ＩＷＳ）為替レート基準日（領収日）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKwsratekijyunymdrsstigi(), "20161102", "（ＩＷＳ）為替レート基準日（領収日）（指定外通貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsgakuyen(), "2000", "（ＩＷＳ）領収金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsRsgakustigi(), "2100", "（ＩＷＳ）領収金額（指定外通貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKijyunkingaku(), "700", "（ＩＷＳ）基準金額");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsItijibrprsyen(), "750", "（ＩＷＳ）一時払保険料（領収日）（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsItijibrpgaika(), "800", "（ＩＷＳ）一時払保険料（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsItijibrprsgaika(), "2200", "（ＩＷＳ）一時払保険料（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKihonhokenkngkgaika(), "900", "（ＩＷＳ）基本保険金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsMkhgkwari(), "1000", "（ＩＷＳ）目標額割合");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSibohknkngkyen(), "1100", "（ＩＷＳ）死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSibohknkngkgaika(), "1200", "（ＩＷＳ）死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSgsbhknkngkyen(), "1300", "（ＩＷＳ）災害死亡保険金額（円貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSgsbhknkngkkgaika(), "1400", "（ＩＷＳ）災害死亡保険金額（外貨）");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSgsbhknkngkhyoujiumu(), "1", "（ＩＷＳ）災害死亡保険金額表示有無");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKjsmsaihakkoukahikbn(), "1", "（ＩＷＳ）控除証明書再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykmeigihnkkahikbn(), "1", "（ＩＷＳ）名義変更処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsSyoukensaihkkahikbn(), "1", "（ＩＷＳ）証券再発行処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsStdrsktkytthkkahikbn(), "1", "（ＩＷＳ）指定代理請求特約中途付加処理可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTargettkhkkahikbn(), "1", "（ＩＷＳ）ターゲット特約変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHokenkngkksnkekkakbn(), "1", "（ＩＷＳ）保険金額計算結果区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsKykniyusyoukaikahikbn(), "1", "（ＩＷＳ）契約内容照会可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsTumitatekinitenkahikbn(), "1", "（ＩＷＳ）積立金移転可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsDskaiyakukahikbn(), "1", "（ＩＷＳ）ＤＳ解約可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsAdrhenkoukahikbn(), "1", "（ＩＷＳ）住所変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsPhrkhouhenkoukahikbn(), "1", "（ＩＷＳ）保険料払込方法変更可否区分");
        exStringEquals(wsDwGetHozenKeiyakuSyousaiOutputBean.getIwsHknkkn3hyoujiumu(), "1", "（ＩＷＳ）第３保険期間表示有無");
    }
}
