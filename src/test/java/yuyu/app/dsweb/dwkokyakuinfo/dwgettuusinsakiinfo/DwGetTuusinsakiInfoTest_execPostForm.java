package yuyu.app.dsweb.dwkokyakuinfo.dwgettuusinsakiinfo;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwGetTuusinsakiInfoOutputBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 顧客通信先情報取得のメイン処理{@link DwGetTuusinsakiInfoImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwGetTuusinsakiInfoTest_execPostForm {

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        IT_KykKihon itKykKihon4 = hozenDomManager.getKykKihon("17806000024");
        if (itKykKihon4 == null) {

            itKykKihon4 = new IT_KykKihon("17806000024");
            itKykKihon4.setKbnkey("02");

            hozenDomManager.insert(itKykKihon4);
        }

        IT_KykKihon itKykKihon5 = hozenDomManager.getKykKihon("17806000035");
        if (itKykKihon5 == null) {

            itKykKihon5 = new IT_KykKihon("17806000035");
            itKykKihon5.setKbnkey("03");

            IT_KykSya kykSya5 = itKykKihon5.createKykSya();
            kykSya5.setKbnkey("03");

            hozenDomManager.insert(itKykKihon5);
        }

        IT_KykKihon itKykKihon6 = hozenDomManager.getKykKihon("17806000046");
        if (itKykKihon6 == null) {

            itKykKihon6 = new IT_KykKihon("17806000046");
            itKykKihon6.setKbnkey("04");

            IT_KykSya kykSya6 = itKykKihon6.createKykSya();
            kykSya6.setKbnkey("04");

            hozenDomManager.insert(itKykKihon6);
        }
        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("1620000001");
        dsKokyakuKanri6.setDskokno("1620000001");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku6 = dsKokyakuKanri6.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku6.setDskokno("1620000001");
        dsKokyakuKeiyaku6.setSyono("17806000046");
        dsKokyakuKeiyaku6.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(dsKokyakuKanri6);

        IT_KykKihon itKykKihon7 = hozenDomManager.getKykKihon("17806000057");
        if (itKykKihon7 == null) {

            itKykKihon7 = new IT_KykKihon("17806000057");
            itKykKihon7.setKbnkey("05");

            IT_KykSya kykSya7 = itKykKihon7.createKykSya();
            kykSya7.setKbnkey("05");
            kykSya7.setTsinyno("1234569");
            kykSya7.setTsinadr1kj("通信先住所一４");
            kykSya7.setTsinadr2kj("通信先住所二４");
            kykSya7.setTsinadr3kj("通信先住所三４");
            kykSya7.setTsintelno("011-1135-8681");
            kykSya7.setDai2tsintelno("011-1532-5216");

            hozenDomManager.insert(itKykKihon7);
        }
        MT_DsKokyakuKanri dsKokyakuKanri7 = new MT_DsKokyakuKanri("1620000002");
        dsKokyakuKanri7.setDskokno("1620000002");
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku7 = dsKokyakuKanri7.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku7.setDskokno("1620000002");
        dsKokyakuKeiyaku7.setSyono("17806000057");
        dsKokyakuKeiyaku7.setDskykmukouhyj(C_MukouHyj.BLANK);
        MT_DsMailAddress dsMailAddress7 = dsKokyakuKanri7.createDsMailAddress();
        dsMailAddress7.setDskokno("1620000002");
        dsMailAddress7.setDsmailaddressrenban(0);
        dsMailAddress7.setDsmailaddress("benjia@sd.com");
        dsMailAddress7.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.OKYAKUSAMAYOUBOU);

        directDomManager.insert(dsKokyakuKanri7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }


    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':''}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean  wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "006100", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(resultBean.getIwsTsinkokyno(), null, "（ＩＷＳ）通信先顧客郵便番号");

        exStringEquals(resultBean.getIwsTsinadr1kj(), null, "（ＩＷＳ）通信先住所１（漢字）");

        exStringEquals(resultBean.getIwsTsinadr2kj(), null, "（ＩＷＳ）通信先住所２（漢字）");

        exStringEquals(resultBean.getIwsTsinadr3kj(), null, "（ＩＷＳ）通信先住所３（漢字）");

        exStringEquals(resultBean.getIwsTsintelno(), null, "（ＩＷＳ）通信先電話番号");

        exStringEquals(resultBean.getIwsDai2tsintelno(), null, "（ＩＷＳ）第２通信先電話番号");

        exStringEquals(resultBean.getIwsDsmailaddress(), null, "（ＩＷＳ）ＤＳメールアドレス");

        exStringEquals(resultBean.getIwsDsmailsousintisrykbn(), null, "（ＩＷＳ）ＤＳメール送信停止理由区分");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'100000000001'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean  wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "006100", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(resultBean.getIwsTsinkokyno(), null, "（ＩＷＳ）通信先顧客郵便番号");

        exStringEquals(resultBean.getIwsTsinadr1kj(), null, "（ＩＷＳ）通信先住所１（漢字）");

        exStringEquals(resultBean.getIwsTsinadr2kj(), null, "（ＩＷＳ）通信先住所２（漢字）");

        exStringEquals(resultBean.getIwsTsinadr3kj(), null, "（ＩＷＳ）通信先住所３（漢字）");

        exStringEquals(resultBean.getIwsTsintelno(), null, "（ＩＷＳ）通信先電話番号");

        exStringEquals(resultBean.getIwsDai2tsintelno(), null, "（ＩＷＳ）第２通信先電話番号");

        exStringEquals(resultBean.getIwsDsmailaddress(), null, "（ＩＷＳ）ＤＳメールアドレス");

        exStringEquals(resultBean.getIwsDsmailsousintisrykbn(), null, "（ＩＷＳ）ＤＳメール送信停止理由区分");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000013'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "006200", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(resultBean.getIwsTsinkokyno(), null, "（ＩＷＳ）通信先顧客郵便番号");

        exStringEquals(resultBean.getIwsTsinadr1kj(), null, "（ＩＷＳ）通信先住所１（漢字）");

        exStringEquals(resultBean.getIwsTsinadr2kj(), null, "（ＩＷＳ）通信先住所２（漢字）");

        exStringEquals(resultBean.getIwsTsinadr3kj(), null, "（ＩＷＳ）通信先住所３（漢字）");

        exStringEquals(resultBean.getIwsTsintelno(), null, "（ＩＷＳ）通信先電話番号");

        exStringEquals(resultBean.getIwsDai2tsintelno(), null, "（ＩＷＳ）第２通信先電話番号");

        exStringEquals(resultBean.getIwsDsmailaddress(), null, "（ＩＷＳ）ＤＳメールアドレス");

        exStringEquals(resultBean.getIwsDsmailsousintisrykbn(), null, "（ＩＷＳ）ＤＳメール送信停止理由区分");

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000024'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "006201", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(resultBean.getIwsTsinkokyno(), null, "（ＩＷＳ）通信先顧客郵便番号");

        exStringEquals(resultBean.getIwsTsinadr1kj(), null, "（ＩＷＳ）通信先住所１（漢字）");

        exStringEquals(resultBean.getIwsTsinadr2kj(), null, "（ＩＷＳ）通信先住所２（漢字）");

        exStringEquals(resultBean.getIwsTsinadr3kj(), null, "（ＩＷＳ）通信先住所３（漢字）");

        exStringEquals(resultBean.getIwsTsintelno(), null, "（ＩＷＳ）通信先電話番号");

        exStringEquals(resultBean.getIwsDai2tsintelno(), null, "（ＩＷＳ）第２通信先電話番号");

        exStringEquals(resultBean.getIwsDsmailaddress(), null, "（ＩＷＳ）ＤＳメールアドレス");

        exStringEquals(resultBean.getIwsDsmailsousintisrykbn(), null, "（ＩＷＳ）ＤＳメール送信停止理由区分");

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000035'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "006202", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(resultBean.getIwsTsinkokyno(), null, "（ＩＷＳ）通信先顧客郵便番号");

        exStringEquals(resultBean.getIwsTsinadr1kj(), null, "（ＩＷＳ）通信先住所１（漢字）");

        exStringEquals(resultBean.getIwsTsinadr2kj(), null, "（ＩＷＳ）通信先住所２（漢字）");

        exStringEquals(resultBean.getIwsTsinadr3kj(), null, "（ＩＷＳ）通信先住所３（漢字）");

        exStringEquals(resultBean.getIwsTsintelno(), null, "（ＩＷＳ）通信先電話番号");

        exStringEquals(resultBean.getIwsDai2tsintelno(), null, "（ＩＷＳ）第２通信先電話番号");

        exStringEquals(resultBean.getIwsDsmailaddress(), null, "（ＩＷＳ）ＤＳメールアドレス");

        exStringEquals(resultBean.getIwsDsmailsousintisrykbn(), null, "（ＩＷＳ）ＤＳメール送信停止理由区分");

    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000046'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "006203", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(resultBean.getIwsTsinkokyno(), null, "（ＩＷＳ）通信先顧客郵便番号");

        exStringEquals(resultBean.getIwsTsinadr1kj(), null, "（ＩＷＳ）通信先住所１（漢字）");

        exStringEquals(resultBean.getIwsTsinadr2kj(), null, "（ＩＷＳ）通信先住所２（漢字）");

        exStringEquals(resultBean.getIwsTsinadr3kj(), null, "（ＩＷＳ）通信先住所３（漢字）");

        exStringEquals(resultBean.getIwsTsintelno(), null, "（ＩＷＳ）通信先電話番号");

        exStringEquals(resultBean.getIwsDai2tsintelno(), null, "（ＩＷＳ）第２通信先電話番号");

        exStringEquals(resultBean.getIwsDsmailaddress(), null, "（ＩＷＳ）ＤＳメールアドレス");

        exStringEquals(resultBean.getIwsDsmailsousintisrykbn(), null, "（ＩＷＳ）ＤＳメール送信停止理由区分");

    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsSyono':'17806000057'}");

        DwGetTuusinsakiInfoImpl dwGetTuusinsakiInfoImpl = SWAKInjector.getInstance(DwGetTuusinsakiInfoImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwGetTuusinsakiInfoImpl.execPostForm(pMap);

        WsDwGetTuusinsakiInfoOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwGetTuusinsakiInfoOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "000000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(resultBean.getIwsTsinkokyno(), "1234569", "（ＩＷＳ）通信先顧客郵便番号");

        exStringEquals(resultBean.getIwsTsinadr1kj(), "通信先住所一４", "（ＩＷＳ）通信先住所１（漢字）");

        exStringEquals(resultBean.getIwsTsinadr2kj(), "通信先住所二４", "（ＩＷＳ）通信先住所２（漢字）");

        exStringEquals(resultBean.getIwsTsinadr3kj(), "通信先住所三４", "（ＩＷＳ）通信先住所３（漢字）");

        exStringEquals(resultBean.getIwsTsintelno(), "011-1135-8681", "（ＩＷＳ）通信先電話番号");

        exStringEquals(resultBean.getIwsDai2tsintelno(), "011-1532-5216", "（ＩＷＳ）第２通信先電話番号");

        exStringEquals(resultBean.getIwsDsmailaddress(), "benjia@sd.com", "（ＩＷＳ）ＤＳメールアドレス");

        exStringEquals(resultBean.getIwsDsmailsousintisrykbn(), "2", "（ＩＷＳ）ＤＳメール送信停止理由区分");

    }

}
