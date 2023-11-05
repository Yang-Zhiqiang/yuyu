package yuyu.app.dsweb.dwninsyou.dwpasswordhenkou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwPasswordHenkouOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * パスワード変更のメイン処理{@link DwPasswordHenkouImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwPasswordHenkouTest_execPostForm extends AbstractTest{

    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1234180000");
        if (dsKokyakuKanri == null) {

            dsKokyakuKanri = new MT_DsKokyakuKanri("1234190000");

            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.createDsHonninKakuninCd();
            dsHonninKakuninCd.setDshnnkakcd("1001");

            MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.createDsLoginKanri();
            dsLoginKanri.setSyokailogintime("142140");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.createDsKokyakuKeiyaku();
            dsKokyakuKeiyaku.setSyono("11807111118");

            MT_DsTtdkRireki dsTtdkRireki = dsKokyakuKanri.createDsTtdkRireki();
            dsTtdkRireki.setHenkousikibetukey("0000000001");

            directDomManager.insert(dsKokyakuKanri);
        }

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AS_Sequence sequence = new AS_Sequence();
        sequence.setId("17");
        sequence.setName("ＤＳ変更識別キー");
        sequence.setStartWith(new Long("1"));
        sequence.setIncrease(1);
        sequence.setMaxValue(new Long("9999999999"));
        sequence.setCacheSize(1);
        sequence.setPadding(C_UmuKbn.ARI);
        sequence.setLength(18);
        sequence.setKousinsyaId("init");
        sequence.setKousinTime("0");
        sequence.setKousinKinou("init");
        sequence.setVersion(0);
        baseDomManager.insert(sequence);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        directDomManager.delete(directDomManager.getAllBAKDsKokyakuKanri());

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'0000001','iwsSclakatopassword':'123456'}");

        DwPasswordHenkouImpl dwPasswordHenkouImpl = SWAKInjector.getInstance(DwPasswordHenkouImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        WsDwPasswordHenkouOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwPasswordHenkouOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(),"003100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'1234180000','iwsSclakatopassword':'123456'}");

        DwPasswordHenkouImpl dwPasswordHenkouImpl = SWAKInjector.getInstance(DwPasswordHenkouImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        WsDwPasswordHenkouOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwPasswordHenkouOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "003200", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception{

        MockObjectManager.initialize();

        changeSystemDate(BizDate.valueOf(20160509));

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'1234190000','iwsSclakatopassword':'12345678901234567890'}");

        DwPasswordHenkouImpl dwPasswordHenkouImpl = SWAKInjector.getInstance(DwPasswordHenkouImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1234190000");

        exStringEquals(dsKokyakuKanri.getDskokno(), "1234190000", "ＤＳ顧客番号");
        exClassificationEquals(dsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.YUUKOU, "ＤＳ顧客状態区分");
        exDateEquals(dsKokyakuKanri.getDskokyakusakuseiymd(), null, "ＤＳ顧客作成年月日");
        exClassificationEquals(dsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.BLANK, "ＤＳ停止理由区分");
        exDateEquals(dsKokyakuKanri.getDskokyakumukouymd(), null, "ＤＳ顧客無効年月日");
        exClassificationEquals(dsKokyakuKanri.getSeisahuyouhyj(), null, "精査不要表示");
        exStringEquals(dsKokyakuKanri.getDskokyakunmkn(), null, "ＤＳ顧客名（カナ）");
        exStringEquals(dsKokyakuKanri.getDskokyakunmkj(), null, "ＤＳ顧客名（漢字）");
        exDateEquals(dsKokyakuKanri.getDskokyakuseiymd(), null, "ＤＳ顧客生年月日");
        exStringEquals(dsKokyakuKanri.getDskokyakuyno(), null, "ＤＳ顧客郵便番号");

        MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();

        exStringEquals(dsHonninKakuninCd.getDskokno(), "1234190000", "ＤＳ顧客番号");
        exStringEquals(dsHonninKakuninCd.getDskrhnnkakcd(), "", "ＤＳ仮本人確認コード");
        exClassificationEquals(dsHonninKakuninCd.getDskrhnnkakcdsetkbn(), C_DsKrHnnKakCdSetKbn.BLANK, "ＤＳ仮本人確認コード設定区分");
        exDateEquals(dsHonninKakuninCd.getDskrhnnkakcdsetymd(), null, "ＤＳ仮本人確認コード設定年月日");
        exDateEquals(dsHonninKakuninCd.getDskrhnnkakcdyuukouymd(), null, "ＤＳ仮本人確認コード有効年月日");
        exStringEquals(dsHonninKakuninCd.getDshnnkakcd(), "12345678901234567890", "ＤＳ本人確認コード");
        exDateEquals(dsHonninKakuninCd.getDshnnkakcdsetymd(), BizDate.valueOf(20160509), "ＤＳ本人確認コード設定年月日");
        exStringEquals(dsHonninKakuninCd.getZenkaidskrhnnkakcd(), null, "前回ＤＳ仮本人確認コード");

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();

        exNumericEquals(dsTtdkRirekiLst.size(), 2, "ＤＳ手続履歴テーブルエンティティリスト件数");

        MT_DsTtdkRireki dsTtdkRireki1 = dsTtdkRirekiLst.get(1);

        exStringEquals(dsTtdkRireki1.getDskokno(), "1234190000", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRireki1.getHenkousikibetukey(), "000000000000000001", "変更識別キー");
        exStringEquals(dsTtdkRireki1.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRirekiLst.get(1).getDsHenkouRirekis();

        exNumericEquals(dsHenkouRirekiLst.size(), 6, "ＤＳ変更履歴テーブルエンティティリスト件数");

        MT_DsHenkouRireki dsHenkouRireki0 = dsHenkouRirekiLst.get(0);

        exStringEquals(dsHenkouRireki0.getDskokno(), "1234190000", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki0.getHenkousikibetukey(), "000000000000000001", "変更識別キー");

        exNumericEquals(dsHenkouRireki0.getRenno(), 1, "連番");

        exStringEquals(dsHenkouRireki0.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki1 = dsHenkouRirekiLst.get(1);

        exStringEquals(dsHenkouRireki1.getDskokno(), "1234190000", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki1.getHenkousikibetukey(), "000000000000000001", "変更識別キー");

        exNumericEquals(dsHenkouRireki1.getRenno(), 2, "連番");

        exStringEquals(dsHenkouRireki1.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki2 = dsHenkouRirekiLst.get(2);

        exStringEquals(dsHenkouRireki2.getDskokno(), "1234190000", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki2.getHenkousikibetukey(), "000000000000000001", "変更識別キー");

        exNumericEquals(dsHenkouRireki2.getRenno(), 3, "連番");

        exStringEquals(dsHenkouRireki2.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki3 = dsHenkouRirekiLst.get(3);

        exStringEquals(dsHenkouRireki3.getDskokno(), "1234190000", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki3.getHenkousikibetukey(), "000000000000000001", "変更識別キー");

        exNumericEquals(dsHenkouRireki3.getRenno(), 4, "連番");

        exStringEquals(dsHenkouRireki3.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki4 = dsHenkouRirekiLst.get(4);

        exStringEquals(dsHenkouRireki4.getDskokno(), "1234190000", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki4.getHenkousikibetukey(), "000000000000000001", "変更識別キー");

        exNumericEquals(dsHenkouRireki4.getRenno(), 5, "連番");

        exStringEquals(dsHenkouRireki4.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");

        MT_DsHenkouRireki dsHenkouRireki5 = dsHenkouRirekiLst.get(5);

        exStringEquals(dsHenkouRireki5.getDskokno(), "1234190000", "ＤＳ顧客番号");

        exStringEquals(dsHenkouRireki5.getHenkousikibetukey(), "000000000000000001", "変更識別キー");

        exNumericEquals(dsHenkouRireki5.getRenno(), 6, "連番");

        exStringEquals(dsHenkouRireki5.getGyoumuKousinKinou(), "dwpasswordhenkou", "業務用更新機能ＩＤ");

        WsDwPasswordHenkouOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwPasswordHenkouOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(), "000000", "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals((String) MockObjectManager.getArgument(DsTetudukiRirekiTableEditParamImpl.class, "setDskokno", 0, 0), "1234190000","ＤＳ顧客番号");
        exStringEquals((String) MockObjectManager.getArgument(DsTetudukiRirekiTableEditParamImpl.class, "setHenkousikibetukey", 0, 0), "000000000000000001","変更識別キー");
        exDateEquals((BizDate) MockObjectManager.getArgument(DsTetudukiRirekiTableEditParamImpl.class, "setSyoriYmd", 0, 0), BizDate.valueOf(20160509),"処理年月日");
        exClassificationEquals((C_DsSyoriKbn) MockObjectManager.getArgument(DsTetudukiRirekiTableEditParamImpl.class, "setDssyorikbn", 0, 0), C_DsSyoriKbn.PASSWORD_HENKOU,"変更履歴作成要否");
        exClassificationEquals((C_YouhiKbn) MockObjectManager.getArgument(DsTetudukiRirekiTableEditParamImpl.class, "setHenkouRrkYouhi", 0, 0), C_YouhiKbn.YOU,"ＤＳ処理区分");

    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'','iwsSclakatopassword':'12345678901234567890'}");

        DwPasswordHenkouImpl dwPasswordHenkouImpl = SWAKInjector.getInstance(DwPasswordHenkouImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        WsDwPasswordHenkouOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwPasswordHenkouOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(),"003100", "（ＩＷＳ）ＤＳメッセージコード");

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception{

        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName("org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();
        pMap.add("gyoumuData", "{'iwsDskokno':'1234190000','iwsSclakatopassword':''}");

        DwPasswordHenkouImpl dwPasswordHenkouImpl = SWAKInjector.getInstance(DwPasswordHenkouImpl.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        WsDwPasswordHenkouOutputBean resultBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwPasswordHenkouOutputBean.class);

        exStringEquals(resultBean.getIwsDsmsgcd(),"003100", "（ＩＷＳ）ＤＳメッセージコード");

    }
}
