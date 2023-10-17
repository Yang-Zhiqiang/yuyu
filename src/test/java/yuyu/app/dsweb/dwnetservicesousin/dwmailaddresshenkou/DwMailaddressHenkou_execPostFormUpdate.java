package yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwMailaddressHenkouOutputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * メール変更のメイン処理{@link DwMailAddressHenkouImpl#execPostFormUpdate(MultivaluedMap<String, String>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwMailaddressHenkou_execPostFormUpdate {

    @Inject
    private DwMailAddressHenkouImpl dwMailAddressHenkouImpl;

    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1001111001");

        if (dsKokyakuKanri == null) {

            dsKokyakuKanri = new MT_DsKokyakuKanri("1001111001");
            dsKokyakuKanri.setDskokno("1001111001");
            dsKokyakuKanri.setDskokyakujtkbn(C_DsKokyakuJtKbn.SEISA_SYOUMETU);
            dsKokyakuKanri.setDskokyakusakuseiymd(BizDate.valueOf("20160401"));
            dsKokyakuKanri.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.OMOUSIDE);
            dsKokyakuKanri.setDskokyakumukouymd(BizDate.valueOf("20160404"));
            dsKokyakuKanri.setSeisahuyouhyj(C_SeisaHuyouHyj.SEISA_HUYOU);
            dsKokyakuKanri.setDskokyakunmkn("カナカナカナカナカナカナカナカカナカナカナカナカナカナカナカ");
            dsKokyakuKanri.setDskokyakunmkj("漢字漢字漢字漢字漢字漢字漢字漢漢字漢字漢字漢字漢字漢字漢字漢");
            dsKokyakuKanri.setDskokyakuseiymd(BizDate.valueOf(19881206));
            dsKokyakuKanri.setDskokyakuyno("4354001");
            dsKokyakuKanri.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
            dsKokyakuKanri.setGyoumuKousinKinou("test1test1test1test1test1test1test1test1test1test1");
            dsKokyakuKanri.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKanri.setGyoumuKousinsyaId("testuser1234567");

            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.createDsHonninKakuninCd();

            dsHonninKakuninCd.setDskokno("1001111001");
            dsHonninKakuninCd.setDskrhnnkakcd("A20010327");
            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
            dsHonninKakuninCd.setDskrhnnkakcdsetymd(BizDate.valueOf("20160201"));
            dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(BizDate.valueOf("20160204"));
            dsHonninKakuninCd.setDshnnkakcd("B1989");
            dsHonninKakuninCd.setDshnnkakcdsetymd(BizDate.valueOf("20160206"));
            dsHonninKakuninCd.setZenkaidskrhnnkakcd("C1999");
            dsHonninKakuninCd.setGyoumuKousinKinou("test1");
            dsHonninKakuninCd.setGyoumuKousinTime("20160411141111111");
            dsHonninKakuninCd.setGyoumuKousinsyaId("testuser1");

            MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.createDsLoginKanri();

            dsLoginKanri.setDskokno("1001111001");
            dsLoginKanri.setSyokailoginymd(BizDate.valueOf(20000121));
            dsLoginKanri.setSyokailogintime("142140");
            dsLoginKanri.setSyokailoginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setSaisinloginymd(BizDate.valueOf(20160311));
            dsLoginKanri.setSaisinlogintime("142021");
            dsLoginKanri.setSaisinloginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setDshnnkakcderrorkaisuu(5);
            dsLoginKanri.setDskokyakunmerrorkaisuu(3);
            dsLoginKanri.setDskokyakuseiymderrorkaisuu(7);
            dsLoginKanri.setDskokyakutelnoerrorkaisuu(2);
            dsLoginKanri.setGyoumuKousinKinou("test1");
            dsLoginKanri.setGyoumuKousinTime("20160411141111111");
            dsLoginKanri.setGyoumuKousinsyaId("testuser1");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.createDsKokyakuKeiyaku();

            dsKokyakuKeiyaku.setDskokno("1001111001");
            dsKokyakuKeiyaku.setSyono("11807111118");
            dsKokyakuKeiyaku.setDskykkanyuuymd(BizDate.valueOf(20150311));
            dsKokyakuKeiyaku.setDskykhenkouymd(BizDate.valueOf(20150511));
            dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.MUKOU);
            dsKokyakuKeiyaku.setDskykmukouymd(BizDate.valueOf(20150930));
            dsKokyakuKeiyaku.setGyoumuKousinKinou("test1");
            dsKokyakuKeiyaku.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKeiyaku.setGyoumuKousinsyaId("testuser1");

            MT_DsTtdkRireki dsTtdkRireki = dsKokyakuKanri.createDsTtdkRireki();

            dsTtdkRireki.setDskokno("1001111001");
            dsTtdkRireki.setHenkousikibetukey("1236");
            dsTtdkRireki.setSyoriYmd(BizDate.valueOf(20150727));
            dsTtdkRireki.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_TOUGOU);
            dsTtdkRireki.setHenkourrkumu(C_UmuKbn.ARI);
            dsTtdkRireki.setGyoumuKousinKinou("test1");
            dsTtdkRireki.setGyoumuKousinTime("20160411141111111");
            dsTtdkRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();
            dsHenkouRireki.setDskokno("1001111001");
            dsHenkouRireki.setHenkousikibetukey("1236");
            dsHenkouRireki.setRenno(1);
            dsHenkouRireki.setGyoumuKousinKinou("test1");
            dsHenkouRireki.setGyoumuKousinTime("20160411141111111");
            dsHenkouRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsMailHaisinRireki dsMailHaisinRireki1 = dsKokyakuKanri.createDsMailHaisinRireki();
            dsMailHaisinRireki1.setDsdatasakuseiymd(BizDate.getSysDate());
            dsMailHaisinRireki1.setDsmailhaisinrenban(1);

            MT_DsMailHaisinRireki dsMailHaisinRireki2 = dsKokyakuKanri.createDsMailHaisinRireki();
            dsMailHaisinRireki2.setDsdatasakuseiymd(BizDate.getSysDate());
            dsMailHaisinRireki2.setDsmailhaisinrenban(2);

            MT_DsMailAddress dsMailAddress = dsKokyakuKanri.createDsMailAddress();
            dsMailAddress.setDsmailaddressrenban(1);
            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.MITOUROKU);
            dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.TEISI);
            dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.MAILHAISINERROR);
            BizPropertyInitializer.initialize(dsMailAddress);

            MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.createDsMailAddressSpiralYyk();
            dsMailAddressSpiralYyk.setDsdatasakuseiymd(BizDate.getSysDate());
            dsMailAddressSpiralYyk.setDsmailaddressrenban(1);

            directDomManager.insert(dsKokyakuKanri);
        }

        MT_DsKokyakuKanri dsKokyakuKanri2 = directDomManager.getDsKokyakuKanri("1001111002");

        if (dsKokyakuKanri2 == null) {

            dsKokyakuKanri2 = new MT_DsKokyakuKanri("1001111002");
            dsKokyakuKanri2.setDskokno("1001111002");
            BizPropertyInitializer.initialize(dsKokyakuKanri2);

            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri2.createDsHonninKakuninCd();

            dsHonninKakuninCd.setDskokno("1001111002");
            dsHonninKakuninCd.setDskrhnnkakcd("A20010327");
            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
            dsHonninKakuninCd.setDskrhnnkakcdsetymd(BizDate.valueOf("20160201"));
            dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(BizDate.valueOf("20160204"));
            dsHonninKakuninCd.setDshnnkakcd("B1989");
            dsHonninKakuninCd.setDshnnkakcdsetymd(BizDate.valueOf("20160206"));
            dsHonninKakuninCd.setZenkaidskrhnnkakcd("C1999");
            dsHonninKakuninCd.setGyoumuKousinKinou("test1");
            dsHonninKakuninCd.setGyoumuKousinTime("20160411141111111");
            dsHonninKakuninCd.setGyoumuKousinsyaId("testuser1");

            MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri2.createDsLoginKanri();

            dsLoginKanri.setDskokno("1001111002");
            dsLoginKanri.setSyokailoginymd(BizDate.valueOf(20000121));
            dsLoginKanri.setSyokailogintime("142140");
            dsLoginKanri.setSyokailoginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setSaisinloginymd(BizDate.valueOf(20160311));
            dsLoginKanri.setSaisinlogintime("142021");
            dsLoginKanri.setSaisinloginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setDshnnkakcderrorkaisuu(5);
            dsLoginKanri.setDskokyakunmerrorkaisuu(3);
            dsLoginKanri.setDskokyakuseiymderrorkaisuu(7);
            dsLoginKanri.setDskokyakutelnoerrorkaisuu(2);
            dsLoginKanri.setGyoumuKousinKinou("test1");
            dsLoginKanri.setGyoumuKousinTime("20160411141111111");
            dsLoginKanri.setGyoumuKousinsyaId("testuser1");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri2.createDsKokyakuKeiyaku();

            dsKokyakuKeiyaku.setDskokno("1001111002");
            dsKokyakuKeiyaku.setSyono("11807111118");
            dsKokyakuKeiyaku.setDskykkanyuuymd(BizDate.valueOf(20150311));
            dsKokyakuKeiyaku.setDskykhenkouymd(BizDate.valueOf(20150511));
            dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.MUKOU);
            dsKokyakuKeiyaku.setDskykmukouymd(BizDate.valueOf(20150930));
            dsKokyakuKeiyaku.setGyoumuKousinKinou("test1");
            dsKokyakuKeiyaku.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKeiyaku.setGyoumuKousinsyaId("testuser1");

            MT_DsTtdkRireki dsTtdkRireki = dsKokyakuKanri2.createDsTtdkRireki();

            dsTtdkRireki.setDskokno("1001111002");
            dsTtdkRireki.setHenkousikibetukey("1236");
            dsTtdkRireki.setSyoriYmd(BizDate.valueOf(20150727));
            dsTtdkRireki.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_TOUGOU);
            dsTtdkRireki.setHenkourrkumu(C_UmuKbn.ARI);
            dsTtdkRireki.setGyoumuKousinKinou("test1");
            dsTtdkRireki.setGyoumuKousinTime("20160411141111111");
            dsTtdkRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();
            dsHenkouRireki.setDskokno("1001111002");
            dsHenkouRireki.setHenkousikibetukey("1236");
            dsHenkouRireki.setRenno(1);
            dsHenkouRireki.setGyoumuKousinKinou("test1");
            dsHenkouRireki.setGyoumuKousinTime("20160411141111111");
            dsHenkouRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsMailAddress dsMailAddress = dsKokyakuKanri2.createDsMailAddress();
            dsMailAddress.setDsmailaddressrenban(1);
            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.MITOUROKU);
            dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.TEISI);
            dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.MAILHAISINERROR);
            BizPropertyInitializer.initialize(dsMailAddress);


            directDomManager.insert(dsKokyakuKanri2);
        }

        MT_DsKokyakuKanri dsKokyakuKanri3 = directDomManager.getDsKokyakuKanri("1001111003");

        if (dsKokyakuKanri3 == null) {

            dsKokyakuKanri3 = new MT_DsKokyakuKanri("1001111003");
            dsKokyakuKanri3.setDskokno("1001111003");
            dsKokyakuKanri3.setDskokyakujtkbn(C_DsKokyakuJtKbn.SEISA_SYOUMETU);
            dsKokyakuKanri3.setDskokyakusakuseiymd(BizDate.valueOf("20160401"));
            dsKokyakuKanri3.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.OMOUSIDE);
            dsKokyakuKanri3.setDskokyakumukouymd(BizDate.valueOf("20160404"));
            dsKokyakuKanri3.setSeisahuyouhyj(C_SeisaHuyouHyj.SEISA_HUYOU);
            dsKokyakuKanri3.setDskokyakunmkn("カナカナカナカナカナカナカナカ");
            dsKokyakuKanri3.setDskokyakunmkj("漢字漢字漢字漢字漢字漢字漢字漢");
            dsKokyakuKanri3.setDskokyakuseiymd(BizDate.valueOf(19881206));
            dsKokyakuKanri3.setDskokyakuyno("4354001");
            dsKokyakuKanri3.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
            dsKokyakuKanri3.setGyoumuKousinKinou("test1test1test1test1test1test1test1test1test1test1");
            dsKokyakuKanri3.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKanri3.setGyoumuKousinsyaId("testuser1234567");

            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri3.createDsHonninKakuninCd();

            dsHonninKakuninCd.setDskokno("1001111003");
            dsHonninKakuninCd.setDskrhnnkakcd("A20010327");
            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
            dsHonninKakuninCd.setDskrhnnkakcdsetymd(BizDate.valueOf("20160201"));
            dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(BizDate.valueOf("20160204"));
            dsHonninKakuninCd.setDshnnkakcd("B1989");
            dsHonninKakuninCd.setDshnnkakcdsetymd(BizDate.valueOf("20160206"));
            dsHonninKakuninCd.setZenkaidskrhnnkakcd("C1999");
            dsHonninKakuninCd.setGyoumuKousinKinou("test1");
            dsHonninKakuninCd.setGyoumuKousinTime("20160411141111111");
            dsHonninKakuninCd.setGyoumuKousinsyaId("testuser1");

            MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri3.createDsLoginKanri();

            dsLoginKanri.setDskokno("1001111003");
            dsLoginKanri.setSyokailoginymd(BizDate.valueOf(20000121));
            dsLoginKanri.setSyokailogintime("142140");
            dsLoginKanri.setSyokailoginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setSaisinloginymd(BizDate.valueOf(20160311));
            dsLoginKanri.setSaisinlogintime("142021");
            dsLoginKanri.setSaisinloginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setDshnnkakcderrorkaisuu(5);
            dsLoginKanri.setDskokyakunmerrorkaisuu(3);
            dsLoginKanri.setDskokyakuseiymderrorkaisuu(7);
            dsLoginKanri.setDskokyakutelnoerrorkaisuu(2);
            dsLoginKanri.setGyoumuKousinKinou("test1");
            dsLoginKanri.setGyoumuKousinTime("20160411141111111");
            dsLoginKanri.setGyoumuKousinsyaId("testuser1");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri3.createDsKokyakuKeiyaku();

            dsKokyakuKeiyaku.setDskokno("1001111003");
            dsKokyakuKeiyaku.setSyono("11807111118");
            dsKokyakuKeiyaku.setDskykkanyuuymd(BizDate.valueOf(20150311));
            dsKokyakuKeiyaku.setDskykhenkouymd(BizDate.valueOf(20150511));
            dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.MUKOU);
            dsKokyakuKeiyaku.setDskykmukouymd(BizDate.valueOf(20150930));
            dsKokyakuKeiyaku.setGyoumuKousinKinou("test1");
            dsKokyakuKeiyaku.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKeiyaku.setGyoumuKousinsyaId("testuser1");

            MT_DsTtdkRireki dsTtdkRireki = dsKokyakuKanri3.createDsTtdkRireki();

            dsTtdkRireki.setDskokno("1001111003");
            dsTtdkRireki.setHenkousikibetukey("1236");
            dsTtdkRireki.setSyoriYmd(BizDate.valueOf(20150727));
            dsTtdkRireki.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_TOUGOU);
            dsTtdkRireki.setHenkourrkumu(C_UmuKbn.ARI);
            dsTtdkRireki.setGyoumuKousinKinou("test1");
            dsTtdkRireki.setGyoumuKousinTime("20160411141111111");
            dsTtdkRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();
            dsHenkouRireki.setDskokno("1001111003");
            dsHenkouRireki.setHenkousikibetukey("1236");
            dsHenkouRireki.setRenno(1);
            dsHenkouRireki.setGyoumuKousinKinou("test1");
            dsHenkouRireki.setGyoumuKousinTime("20160411141111111");
            dsHenkouRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsMailAddress dsMailAddress = dsKokyakuKanri3.createDsMailAddress();
            dsMailAddress.setDsmailaddressrenban(1);
            dsMailAddress.setDsmailaddress("aaa@co.jp");
            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.MITOUROKU);
            dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.TEISI);
            dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.MAILHAISINERROR);
            BizPropertyInitializer.initialize(dsMailAddress);

            directDomManager.insert(dsKokyakuKanri3);
        }

        MT_DsKokyakuKanri dsKokyakuKanri4 = directDomManager.getDsKokyakuKanri("1001111004");

        if (dsKokyakuKanri4 == null) {

            dsKokyakuKanri4 = new MT_DsKokyakuKanri("1001111004");
            dsKokyakuKanri4.setDskokno("1001111004");
            dsKokyakuKanri4.setDskokyakujtkbn(C_DsKokyakuJtKbn.SEISA_SYOUMETU);
            dsKokyakuKanri4.setDskokyakusakuseiymd(BizDate.valueOf("20160401"));
            dsKokyakuKanri4.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.OMOUSIDE);
            dsKokyakuKanri4.setDskokyakumukouymd(BizDate.valueOf("20160404"));
            dsKokyakuKanri4.setSeisahuyouhyj(C_SeisaHuyouHyj.SEISA_HUYOU);
            dsKokyakuKanri4.setDskokyakunmkn("カナカナカナカナカナカナカナカ");
            dsKokyakuKanri4.setDskokyakunmkj("漢字漢字漢字漢字漢字漢字漢字漢");
            dsKokyakuKanri4.setDskokyakuseiymd(BizDate.valueOf(19881206));
            dsKokyakuKanri4.setDskokyakuyno("4354001");
            dsKokyakuKanri4.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
            dsKokyakuKanri4.setGyoumuKousinKinou("test1test1test1test1test1test1test1test1test1test1");
            dsKokyakuKanri4.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKanri4.setGyoumuKousinsyaId("testuser1234567");

            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri4.createDsHonninKakuninCd();

            dsHonninKakuninCd.setDskokno("1001111004");
            dsHonninKakuninCd.setDskrhnnkakcd("A20010327");
            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
            dsHonninKakuninCd.setDskrhnnkakcdsetymd(BizDate.valueOf("20160201"));
            dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(BizDate.valueOf("20160204"));
            dsHonninKakuninCd.setDshnnkakcd("B1989");
            dsHonninKakuninCd.setDshnnkakcdsetymd(BizDate.valueOf("20160206"));
            dsHonninKakuninCd.setZenkaidskrhnnkakcd("C1999");
            dsHonninKakuninCd.setGyoumuKousinKinou("test1");
            dsHonninKakuninCd.setGyoumuKousinTime("20160411141111111");
            dsHonninKakuninCd.setGyoumuKousinsyaId("testuser1");

            MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri4.createDsLoginKanri();

            dsLoginKanri.setDskokno("1001111004");
            dsLoginKanri.setSyokailoginymd(BizDate.valueOf(20000121));
            dsLoginKanri.setSyokailogintime("142140");
            dsLoginKanri.setSyokailoginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setSaisinloginymd(BizDate.valueOf(20160311));
            dsLoginKanri.setSaisinlogintime("142021");
            dsLoginKanri.setSaisinloginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setDshnnkakcderrorkaisuu(5);
            dsLoginKanri.setDskokyakunmerrorkaisuu(3);
            dsLoginKanri.setDskokyakuseiymderrorkaisuu(7);
            dsLoginKanri.setDskokyakutelnoerrorkaisuu(2);
            dsLoginKanri.setGyoumuKousinKinou("test1");
            dsLoginKanri.setGyoumuKousinTime("20160411141111111");
            dsLoginKanri.setGyoumuKousinsyaId("testuser1");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri4.createDsKokyakuKeiyaku();

            dsKokyakuKeiyaku.setDskokno("1001111004");
            dsKokyakuKeiyaku.setSyono("11807111118");
            dsKokyakuKeiyaku.setDskykkanyuuymd(BizDate.valueOf(20150311));
            dsKokyakuKeiyaku.setDskykhenkouymd(BizDate.valueOf(20150511));
            dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.MUKOU);
            dsKokyakuKeiyaku.setDskykmukouymd(BizDate.valueOf(20150930));
            dsKokyakuKeiyaku.setGyoumuKousinKinou("test1");
            dsKokyakuKeiyaku.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKeiyaku.setGyoumuKousinsyaId("testuser1");

            MT_DsTtdkRireki dsTtdkRireki = dsKokyakuKanri4.createDsTtdkRireki();

            dsTtdkRireki.setDskokno("1001111004");
            dsTtdkRireki.setHenkousikibetukey("1236");
            dsTtdkRireki.setSyoriYmd(BizDate.valueOf(20150727));
            dsTtdkRireki.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_TOUGOU);
            dsTtdkRireki.setHenkourrkumu(C_UmuKbn.ARI);
            dsTtdkRireki.setGyoumuKousinKinou("test1");
            dsTtdkRireki.setGyoumuKousinTime("20160411141111111");
            dsTtdkRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();
            dsHenkouRireki.setDskokno("1001111004");
            dsHenkouRireki.setHenkousikibetukey("1236");
            dsHenkouRireki.setRenno(1);
            dsHenkouRireki.setGyoumuKousinKinou("test1");
            dsHenkouRireki.setGyoumuKousinTime("20160411141111111");
            dsHenkouRireki.setGyoumuKousinsyaId("testuser1");

            directDomManager.insert(dsKokyakuKanri4);
        }
        MT_DsKokyakuKanri dsKokyakuKanri5 = directDomManager.getDsKokyakuKanri("1001111005");

        if (dsKokyakuKanri5 == null) {

            dsKokyakuKanri5 = new MT_DsKokyakuKanri("1001111005");
            dsKokyakuKanri5.setDskokno("1001111005");
            dsKokyakuKanri5.setDskokyakujtkbn(C_DsKokyakuJtKbn.SEISA_SYOUMETU);
            dsKokyakuKanri5.setDskokyakusakuseiymd(BizDate.valueOf("20160401"));
            dsKokyakuKanri5.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.OMOUSIDE);
            dsKokyakuKanri5.setDskokyakumukouymd(BizDate.valueOf("20160404"));
            dsKokyakuKanri5.setSeisahuyouhyj(C_SeisaHuyouHyj.SEISA_HUYOU);
            dsKokyakuKanri5.setDskokyakunmkn("カナカナカナカナカナカナカナカ");
            dsKokyakuKanri5.setDskokyakunmkj("漢字漢字漢字漢字漢字漢字漢字漢");
            dsKokyakuKanri5.setDskokyakuseiymd(BizDate.valueOf(19881206));
            dsKokyakuKanri5.setDskokyakuyno("4354001");
            dsKokyakuKanri5.setDskanyuukeirokbn(C_DsKanyuuKeiroKbn.TYUUTOKANYUU);
            dsKokyakuKanri5.setGyoumuKousinKinou("test1test1test1test1test1test1test1test1test1test1");
            dsKokyakuKanri5.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKanri5.setGyoumuKousinsyaId("testuser1234567");

            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri5.createDsHonninKakuninCd();

            dsHonninKakuninCd.setDskokno("1001111005");
            dsHonninKakuninCd.setDskrhnnkakcd("A20010327");
            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
            dsHonninKakuninCd.setDskrhnnkakcdsetymd(BizDate.valueOf("20160201"));
            dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(BizDate.valueOf("20160204"));
            dsHonninKakuninCd.setDshnnkakcd("B1989");
            dsHonninKakuninCd.setDshnnkakcdsetymd(BizDate.valueOf("20160206"));
            dsHonninKakuninCd.setZenkaidskrhnnkakcd("C1999");
            dsHonninKakuninCd.setGyoumuKousinKinou("test1");
            dsHonninKakuninCd.setGyoumuKousinTime("20160411141111111");
            dsHonninKakuninCd.setGyoumuKousinsyaId("testuser1");

            MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri5.createDsLoginKanri();

            dsLoginKanri.setDskokno("1001111005");
            dsLoginKanri.setSyokailoginymd(BizDate.valueOf(20000121));
            dsLoginKanri.setSyokailogintime("142140");
            dsLoginKanri.setSyokailoginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setSaisinloginymd(BizDate.valueOf(20160311));
            dsLoginKanri.setSaisinlogintime("142021");
            dsLoginKanri.setSaisinloginbaitaikbn(C_BaitaiKbn.PC);
            dsLoginKanri.setDshnnkakcderrorkaisuu(5);
            dsLoginKanri.setDskokyakunmerrorkaisuu(3);
            dsLoginKanri.setDskokyakuseiymderrorkaisuu(7);
            dsLoginKanri.setDskokyakutelnoerrorkaisuu(2);
            dsLoginKanri.setGyoumuKousinKinou("test1");
            dsLoginKanri.setGyoumuKousinTime("20160411141111111");
            dsLoginKanri.setGyoumuKousinsyaId("testuser1");

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri5.createDsKokyakuKeiyaku();

            dsKokyakuKeiyaku.setDskokno("1001111005");
            dsKokyakuKeiyaku.setSyono("11807111118");
            dsKokyakuKeiyaku.setDskykkanyuuymd(BizDate.valueOf(20150311));
            dsKokyakuKeiyaku.setDskykhenkouymd(BizDate.valueOf(20150511));
            dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.MUKOU);
            dsKokyakuKeiyaku.setDskykmukouymd(BizDate.valueOf(20150930));
            dsKokyakuKeiyaku.setGyoumuKousinKinou("test1");
            dsKokyakuKeiyaku.setGyoumuKousinTime("20160411141111111");
            dsKokyakuKeiyaku.setGyoumuKousinsyaId("testuser1");

            MT_DsTtdkRireki dsTtdkRireki = dsKokyakuKanri5.createDsTtdkRireki();

            dsTtdkRireki.setDskokno("1001111005");
            dsTtdkRireki.setHenkousikibetukey("123456789012345678");
            dsTtdkRireki.setSyoriYmd(BizDate.valueOf(20150727));
            dsTtdkRireki.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_TOUGOU);
            dsTtdkRireki.setHenkourrkumu(C_UmuKbn.ARI);
            dsTtdkRireki.setGyoumuKousinKinou("test1");
            dsTtdkRireki.setGyoumuKousinTime("20160411141111111");
            dsTtdkRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsHenkouRireki dsHenkouRireki = dsTtdkRireki.createDsHenkouRireki();
            dsHenkouRireki.setDskokno("1001111005");
            dsHenkouRireki.setHenkousikibetukey("123456789012345678");
            dsHenkouRireki.setRenno(1);
            dsHenkouRireki.setGyoumuKousinKinou("test1");
            dsHenkouRireki.setGyoumuKousinTime("20160411141111111");
            dsHenkouRireki.setGyoumuKousinsyaId("testuser1");

            MT_DsMailHaisinRireki dsMailHaisinRireki1 = dsKokyakuKanri5.createDsMailHaisinRireki();
            dsMailHaisinRireki1.setDsdatasakuseiymd(BizDate.getSysDate());
            dsMailHaisinRireki1.setDsmailhaisinrenban(987654321);

            MT_DsMailHaisinRireki dsMailHaisinRireki2 = dsKokyakuKanri5.createDsMailHaisinRireki();
            dsMailHaisinRireki2.setDsdatasakuseiymd(BizDate.getSysDate());
            dsMailHaisinRireki2.setDsmailhaisinrenban(123456789);

            MT_DsMailAddress dsMailAddress = dsKokyakuKanri5.createDsMailAddress();
            dsMailAddress.setDsmailaddressrenban(1);
            dsMailAddress.setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn.MITOUROKU);
            dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.TEISI);
            dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.MAILHAISINERROR);
            BizPropertyInitializer.initialize(dsMailAddress);

            MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri5.createDsMailAddressSpiralYyk();
            dsMailAddressSpiralYyk.setDsdatasakuseiymd(BizDate.getSysDate());
            dsMailAddressSpiralYyk.setDsmailaddressrenban(1);

            directDomManager.insert(dsKokyakuKanri5);
        }
        AS_Sequence sequence = new AS_Sequence();
        sequence.setId("17");
        sequence.setName("ＤＳ送信番号連番");
        sequence.setStartWith(Long.valueOf(1));
        sequence.setIncrease(1);
        sequence.setMaxValue(Long.valueOf(999999999));
        sequence.setCacheSize(1);
        sequence.setPadding(C_UmuKbn.ARI);
        sequence.setLength(10);
        sequence.setKousinsyaId("init");
        sequence.setKousinTime("0");
        sequence.setKousinKinou("init");
        sequence.setVersion(Long.valueOf(0));
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
    public void testExecPostFormUpdate_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111001', 'iwsDsmailaddress':'www.liant@co.jp', 'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormUpdate(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_000000, "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ１");

        MT_BAK_DsKokyakuKanri bAKDsKokyakuKanri = directDomManager.getBAKDsKokyakuKanri("1001111001", "0000000001");
        exStringEquals(bAKDsKokyakuKanri.getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(bAKDsKokyakuKanri.getTrkssikibetukey(), "0000000001", "取消識別キー");
        exClassificationEquals(bAKDsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.SEISA_SYOUMETU, "ＤＳ顧客状態区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakusakuseiymd(), BizDate.valueOf("20160401"), "ＤＳ顧客作成年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.OMOUSIDE, "ＤＳ停止理由区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf("20160404"), "ＤＳ顧客無効年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getSeisahuyouhyj(), C_SeisaHuyouHyj.SEISA_HUYOU, "精査不要表示");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkn(), "カナカナカナカナカナカナカナカカナカナカナカナカナカナカナカ", "ＤＳ顧客名（カナ）");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkj(), "漢字漢字漢字漢字漢字漢字漢字漢漢字漢字漢字漢字漢字漢字漢字漢", "ＤＳ顧客名（漢字）");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf("19881206"), "ＤＳ顧客生年月日");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakuyno(), "4354001", "ＤＳ顧客郵便番号");
        exClassificationEquals(bAKDsKokyakuKanri.getDskanyuukeirokbn(), C_DsKanyuuKeiroKbn.TYUUTOKANYUU, "ＤＳ加入経路区分");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinKinou(), "test1test1test1test1test1test1test1test1test1test1", "業務用更新機能ＩＤ");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinTime(), "20160411141111111", "業務用更新時間");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinsyaId(), "testuser1234567", "業務用更新者ＩＤ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1001111001");
        MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(1);
        exStringEquals(dsMailAddress.getDskokno(), "1001111001", "ＤＳ顧客番号");
        exNumericEquals(dsMailAddress.getDsmailaddressrenban(), 1, "ＤＳメールアドレス連番");
        exClassificationEquals(dsMailAddress.getDsmailtourokujyoutaikbn(), C_DsMailTourokuJyoutaiKbn.TOUROKU, "ＤＳメール登録状態区分");
        exStringEquals(dsMailAddress.getDsmailaddress(), "www.liant@co.jp", "ＤＳメールアドレス");
        exClassificationEquals(dsMailAddress.getDsmailsousinjyoutaikbn(), C_DsMailSousinJyoutaiKbn.YUUKOU, "ＤＳメール送信状態区分");
        exClassificationEquals(dsMailAddress.getDsmailsousintisrykbn(), C_DsMailSousinTeisiRiyuuKbn.BLNK, "ＤＳメール送信停止理由区分");
        exStringEquals(dsMailAddress.getDstourokuymdtime(), "", "ＤＳ登録日時");
        exStringEquals(dsMailAddress.getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsMailAddress.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.getSysDate(), 1);
        assertNull(dsMailAddressSpiralYyk);

        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri.getDsMailHaisinRirekis();
        exNumericEquals(dsMailHaisinRirekiLst.size(), 3, "件数");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban(), 1, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getHaisinjidsmailaddress(), null, "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDssousinno(), null, "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(dsMailHaisinRirekiLst.get(1).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(1).getDsmailhaisinrenban(), 2, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getHaisinjidsmailaddress(), null, "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getDssousinno(), null, "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(dsMailHaisinRirekiLst.get(2).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(2).getDsmailhaisinrenban(), 3, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getHaisinjidsmailaddress(), "www.liant@co.jp", "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getDssousinno(), "123456789012345678901", "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 2, "件数");
        exStringEquals(dsTtdkRirekiLst.get(0).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(0).getHenkousikibetukey(), "1236", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getDssyorikbn(), C_DsSyoriKbn.KOKYAKU_TOUGOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinTime(), "20160411141111111", "業務用更新時間");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(dsTtdkRirekiLst.get(1).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(1).getHenkousikibetukey(), "0000000001", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getDssyorikbn(), C_DsSyoriKbn.MAIL_HENKOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRirekiLst.get(0).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 1, "件数");
        exStringEquals(dsHenkouRirekiLst.get(0).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkousikibetukey(), "1236", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst.get(0).getTablenm(), null, "テーブル名称");
        exStringEquals(dsHenkouRirekiLst.get(0).getTableid(), null, "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst.get(0).getHnksyuruikbn(), null, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst.get(0).getHanbetukoumokunm(), null, "判別項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokuid(), null, "変更項目ID");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokunm(), null, "変更項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyouoriginal(), null, "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyou(), null, "変更前内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyouoriginal(), null, "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyou(), null, "変更後内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst1 = dsTtdkRirekiLst.get(1).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst1.size(), 5, "件数");
        exStringEquals(dsHenkouRirekiLst1.get(0).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkousikibetukey(), "0000000001", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokuid(), "dsmailtourokujyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokunm(), "ＤＳメール登録状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyou(), "未登録", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyou(), "登録", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(1).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkousikibetukey(), "0000000001", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(1).getRenno(), 2, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(1).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokuid(), "dsmailaddress", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokunm(), "ＤＳメールアドレス", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyouoriginal(), "www.liant@co.jp", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyou(), "www.liant@co.jp", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(2).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkousikibetukey(), "0000000001", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(2).getRenno(), 3, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(2).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokuid(), "dsmailsousinjyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokunm(), "ＤＳメール送信状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyouoriginal(), "2", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyou(), "停止", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyou(), "有効", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(3).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkousikibetukey(), "0000000001", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(3).getRenno(), 4, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(3).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokuid(), "dsmailsousintisrykbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokunm(), "ＤＳメール送信停止理由区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyou(), "メール配信エラー", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(4).getDskokno(), "1001111001", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkousikibetukey(), "0000000001", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(4).getRenno(), 5, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(4).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokuid(), "dskousinymdtime", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokunm(), "ＤＳ更新日時", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormUpdate_A2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111002', 'iwsDsmailaddress':'www.liant@co.jp', 'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormUpdate(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_000000, "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ１");

        MT_BAK_DsKokyakuKanri bAKDsKokyakuKanri = directDomManager.getBAKDsKokyakuKanri("1001111002", "0000000002");
        exStringEquals(bAKDsKokyakuKanri.getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(bAKDsKokyakuKanri.getTrkssikibetukey(), "0000000002", "取消識別キー");
        exClassificationEquals(bAKDsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.BLANK, "ＤＳ顧客状態区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakusakuseiymd(), null, "ＤＳ顧客作成年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.BLANK, "ＤＳ停止理由区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakumukouymd(), null, "ＤＳ顧客無効年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getSeisahuyouhyj(), C_SeisaHuyouHyj.BLANK, "精査不要表示");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkn(), "", "ＤＳ顧客名（カナ）");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkj(), "", "ＤＳ顧客名（漢字）");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakuseiymd(), null, "ＤＳ顧客生年月日");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakuyno(), "", "ＤＳ顧客郵便番号");
        exClassificationEquals(bAKDsKokyakuKanri.getDskanyuukeirokbn(), C_DsKanyuuKeiroKbn.BLNK, "ＤＳ加入経路区分");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinKinou(), "", "業務用更新機能ＩＤ");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinTime(), "", "業務用更新時間");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1001111002");
        MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(1);
        exStringEquals(dsMailAddress.getDskokno(), "1001111002", "ＤＳ顧客番号");
        exNumericEquals(dsMailAddress.getDsmailaddressrenban(), 1, "ＤＳメールアドレス連番");
        exClassificationEquals(dsMailAddress.getDsmailtourokujyoutaikbn(), C_DsMailTourokuJyoutaiKbn.TOUROKU, "ＤＳメール登録状態区分");
        exStringEquals(dsMailAddress.getDsmailaddress(), "www.liant@co.jp", "ＤＳメールアドレス");
        exClassificationEquals(dsMailAddress.getDsmailsousinjyoutaikbn(), C_DsMailSousinJyoutaiKbn.YUUKOU, "ＤＳメール送信状態区分");
        exClassificationEquals(dsMailAddress.getDsmailsousintisrykbn(), C_DsMailSousinTeisiRiyuuKbn.BLNK, "ＤＳメール送信停止理由区分");
        exStringEquals(dsMailAddress.getDstourokuymdtime(), "", "ＤＳ登録日時");
        exStringEquals(dsMailAddress.getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsMailAddress.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.getSysDate(), 1);
        assertNull(dsMailAddressSpiralYyk);

        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri.getDsMailHaisinRirekis();
        exNumericEquals(dsMailHaisinRirekiLst.size(), 1, "件数");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban(), 1, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getHaisinjidsmailaddress(), "www.liant@co.jp", "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDssousinno(), "123456789012345678901", "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 2, "件数");
        exStringEquals(dsTtdkRirekiLst.get(0).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(0).getHenkousikibetukey(), "1236", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getDssyorikbn(), C_DsSyoriKbn.KOKYAKU_TOUGOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinTime(), "20160411141111111", "業務用更新時間");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(dsTtdkRirekiLst.get(1).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(1).getHenkousikibetukey(), "0000000002", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getDssyorikbn(), C_DsSyoriKbn.MAIL_HENKOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRirekiLst.get(0).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 1, "件数");
        exStringEquals(dsHenkouRirekiLst.get(0).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkousikibetukey(), "1236", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst.get(0).getTablenm(), null, "テーブル名称");
        exStringEquals(dsHenkouRirekiLst.get(0).getTableid(), null, "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst.get(0).getHnksyuruikbn(), null, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst.get(0).getHanbetukoumokunm(), null, "判別項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokuid(), null, "変更項目ID");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokunm(), null, "変更項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyouoriginal(), null, "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyou(), null, "変更前内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyouoriginal(), null, "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyou(), null, "変更後内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst1 = dsTtdkRirekiLst.get(1).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst1.size(), 5, "件数");
        exStringEquals(dsHenkouRirekiLst1.get(0).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkousikibetukey(), "0000000002", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokuid(), "dsmailtourokujyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokunm(), "ＤＳメール登録状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyou(), "未登録", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyou(), "登録", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(1).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkousikibetukey(), "0000000002", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(1).getRenno(), 2, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(1).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokuid(), "dsmailaddress", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokunm(), "ＤＳメールアドレス", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyouoriginal(), "www.liant@co.jp", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyou(), "www.liant@co.jp", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(2).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkousikibetukey(), "0000000002", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(2).getRenno(), 3, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(2).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokuid(), "dsmailsousinjyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokunm(), "ＤＳメール送信状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyouoriginal(), "2", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyou(), "停止", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyou(), "有効", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(3).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkousikibetukey(), "0000000002", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(3).getRenno(), 4, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(3).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokuid(), "dsmailsousintisrykbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokunm(), "ＤＳメール送信停止理由区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyou(), "メール配信エラー", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(4).getDskokno(), "1001111002", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkousikibetukey(), "0000000002", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(4).getRenno(), 5, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(4).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokuid(), "dskousinymdtime", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokunm(), "ＤＳ更新日時", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormUpdate_A3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111003', 'iwsDsmailaddress':'', 'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormUpdate(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_000000, "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ１");

        MT_BAK_DsKokyakuKanri bAKDsKokyakuKanri = directDomManager.getBAKDsKokyakuKanri("1001111003", "0000000003");
        exStringEquals(bAKDsKokyakuKanri.getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(bAKDsKokyakuKanri.getTrkssikibetukey(), "0000000003", "取消識別キー");
        exClassificationEquals(bAKDsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.SEISA_SYOUMETU, "ＤＳ顧客状態区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakusakuseiymd(), BizDate.valueOf("20160401"), "ＤＳ顧客作成年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.OMOUSIDE, "ＤＳ停止理由区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf("20160404"), "ＤＳ顧客無効年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getSeisahuyouhyj(), C_SeisaHuyouHyj.SEISA_HUYOU, "精査不要表示");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkn(), "カナカナカナカナカナカナカナカ", "ＤＳ顧客名（カナ）");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkj(), "漢字漢字漢字漢字漢字漢字漢字漢", "ＤＳ顧客名（漢字）");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf("19881206"), "ＤＳ顧客生年月日");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakuyno(), "4354001", "ＤＳ顧客郵便番号");
        exClassificationEquals(bAKDsKokyakuKanri.getDskanyuukeirokbn(), C_DsKanyuuKeiroKbn.TYUUTOKANYUU, "ＤＳ加入経路区分");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinKinou(), "test1test1test1test1test1test1test1test1test1test1", "業務用更新機能ＩＤ");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinTime(), "20160411141111111", "業務用更新時間");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinsyaId(), "testuser1234567", "業務用更新者ＩＤ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1001111003");
        MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(1);
        exStringEquals(dsMailAddress.getDskokno(), "1001111003", "ＤＳ顧客番号");
        exNumericEquals(dsMailAddress.getDsmailaddressrenban(), 1, "ＤＳメールアドレス連番");
        exClassificationEquals(dsMailAddress.getDsmailtourokujyoutaikbn(), C_DsMailTourokuJyoutaiKbn.SAKUJYO, "ＤＳメール登録状態区分");
        exStringEquals(dsMailAddress.getDsmailaddress(), "", "ＤＳメールアドレス");
        exClassificationEquals(dsMailAddress.getDsmailsousinjyoutaikbn(), C_DsMailSousinJyoutaiKbn.BLNK, "ＤＳメール送信状態区分");
        exClassificationEquals(dsMailAddress.getDsmailsousintisrykbn(), C_DsMailSousinTeisiRiyuuKbn.BLNK, "ＤＳメール送信停止理由区分");
        exStringEquals(dsMailAddress.getDstourokuymdtime(), "", "ＤＳ登録日時");
        exStringEquals(dsMailAddress.getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsMailAddress.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.getSysDate(), 1);
        assertNull(dsMailAddressSpiralYyk);

        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri.getDsMailHaisinRirekis();
        exNumericEquals(dsMailHaisinRirekiLst.size(), 0, "件数");

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 2, "件数");
        exStringEquals(dsTtdkRirekiLst.get(0).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(0).getHenkousikibetukey(), "1236", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getDssyorikbn(), C_DsSyoriKbn.KOKYAKU_TOUGOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinTime(), "20160411141111111", "業務用更新時間");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(dsTtdkRirekiLst.get(1).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(1).getHenkousikibetukey(), "0000000003", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getDssyorikbn(), C_DsSyoriKbn.MAIL_HENKOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRirekiLst.get(0).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 1, "件数");
        exStringEquals(dsHenkouRirekiLst.get(0).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkousikibetukey(), "1236", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst.get(0).getTablenm(), null, "テーブル名称");
        exStringEquals(dsHenkouRirekiLst.get(0).getTableid(), null, "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst.get(0).getHnksyuruikbn(), null, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst.get(0).getHanbetukoumokunm(), null, "判別項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokuid(), null, "変更項目ID");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokunm(), null, "変更項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyouoriginal(), null, "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyou(), null, "変更前内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyouoriginal(), null, "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyou(), null, "変更後内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst1 = dsTtdkRirekiLst.get(1).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst1.size(), 5, "件数");
        exStringEquals(dsHenkouRirekiLst1.get(0).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkousikibetukey(), "0000000003", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokuid(), "dsmailtourokujyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokunm(), "ＤＳメール登録状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyou(), "未登録", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyouoriginal(), "2", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyou(), "削除", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(1).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkousikibetukey(), "0000000003", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(1).getRenno(), 2, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(1).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokuid(), "dsmailaddress", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokunm(), "ＤＳメールアドレス", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyouoriginal(), "aaa@co.jp", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyou(), "aaa@co.jp", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyouoriginal(), "", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(2).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkousikibetukey(), "0000000003", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(2).getRenno(), 3, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(2).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokuid(), "dsmailsousinjyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokunm(), "ＤＳメール送信状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyouoriginal(), "2", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyou(), "停止", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(3).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkousikibetukey(), "0000000003", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(3).getRenno(), 4, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(3).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokuid(), "dsmailsousintisrykbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokunm(), "ＤＳメール送信停止理由区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyou(), "メール配信エラー", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(4).getDskokno(), "1001111003", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkousikibetukey(), "0000000003", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(4).getRenno(), 5, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(4).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokuid(), "dskousinymdtime", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokunm(), "ＤＳ更新日時", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormUpdate_A4() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111004', 'iwsDsmailaddress':'www.liant@co.jp', 'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormUpdate(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_009201, "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ１");

    }
    @Test
    @TestOrder(50)
    public void testExecPostFormUpdate_A5() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111005', 'iwsDsmailaddress':'www.liantaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@co.jp', 'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormUpdate(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_000000, "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ１");

        MT_BAK_DsKokyakuKanri bAKDsKokyakuKanri = directDomManager.getBAKDsKokyakuKanri("1001111005", "0000000005");
        exStringEquals(bAKDsKokyakuKanri.getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(bAKDsKokyakuKanri.getTrkssikibetukey(), "0000000005", "取消識別キー");
        exClassificationEquals(bAKDsKokyakuKanri.getDskokyakujtkbn(), C_DsKokyakuJtKbn.SEISA_SYOUMETU, "ＤＳ顧客状態区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakusakuseiymd(), BizDate.valueOf("20160401"), "ＤＳ顧客作成年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getDsteisiriyuukbn(), C_DsTeisiRiyuuKbn.OMOUSIDE, "ＤＳ停止理由区分");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakumukouymd(), BizDate.valueOf("20160404"), "ＤＳ顧客無効年月日");
        exClassificationEquals(bAKDsKokyakuKanri.getSeisahuyouhyj(), C_SeisaHuyouHyj.SEISA_HUYOU, "精査不要表示");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkn(), "カナカナカナカナカナカナカナカ", "ＤＳ顧客名（カナ）");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakunmkj(), "漢字漢字漢字漢字漢字漢字漢字漢", "ＤＳ顧客名（漢字）");
        exDateEquals(bAKDsKokyakuKanri.getDskokyakuseiymd(), BizDate.valueOf("19881206"), "ＤＳ顧客生年月日");
        exStringEquals(bAKDsKokyakuKanri.getDskokyakuyno(), "4354001", "ＤＳ顧客郵便番号");
        exClassificationEquals(bAKDsKokyakuKanri.getDskanyuukeirokbn(), C_DsKanyuuKeiroKbn.TYUUTOKANYUU, "ＤＳ加入経路区分");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinKinou(), "test1test1test1test1test1test1test1test1test1test1", "業務用更新機能ＩＤ");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinTime(), "20160411141111111", "業務用更新時間");
        exStringEquals(bAKDsKokyakuKanri.getGyoumuKousinsyaId(), "testuser1234567", "業務用更新者ＩＤ");

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri("1001111005");
        MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddressByDsmailaddressrenban(1);
        exStringEquals(dsMailAddress.getDskokno(), "1001111005", "ＤＳ顧客番号");
        exNumericEquals(dsMailAddress.getDsmailaddressrenban(), 1, "ＤＳメールアドレス連番");
        exClassificationEquals(dsMailAddress.getDsmailtourokujyoutaikbn(), C_DsMailTourokuJyoutaiKbn.TOUROKU, "ＤＳメール登録状態区分");
        exStringEquals(dsMailAddress.getDsmailaddress(), "www.liantaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@co.jp", "ＤＳメールアドレス");
        exClassificationEquals(dsMailAddress.getDsmailsousinjyoutaikbn(), C_DsMailSousinJyoutaiKbn.YUUKOU, "ＤＳメール送信状態区分");
        exClassificationEquals(dsMailAddress.getDsmailsousintisrykbn(), C_DsMailSousinTeisiRiyuuKbn.BLNK, "ＤＳメール送信停止理由区分");
        exStringEquals(dsMailAddress.getDstourokuymdtime(), "", "ＤＳ登録日時");
        exStringEquals(dsMailAddress.getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsMailAddress.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(BizDate.getSysDate(), 1);
        assertNull(dsMailAddressSpiralYyk);

        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri.getDsMailHaisinRirekis();
        exNumericEquals(dsMailHaisinRirekiLst.size(), 3, "件数");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban(), 123456789, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getHaisinjidsmailaddress(), null, "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getDssousinno(), null, "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(dsMailHaisinRirekiLst.get(1).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(1).getDsmailhaisinrenban(), 987654321, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getHaisinjidsmailaddress(), null, "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getDssousinno(), null, "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(1).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        exStringEquals(dsMailHaisinRirekiLst.get(2).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exNumericEquals(dsMailHaisinRirekiLst.get(2).getDsmailhaisinrenban(), 987654322, "ＤＳメール配信連番");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getHaisinjidsmailaddress(), "www.liantaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@co.jp", "配信時ＤＳメールアドレス");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getDssousinno(), "123456789012345678901", "ＤＳ送信番号");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsMailHaisinRirekiLst.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsTtdkRireki> dsTtdkRirekiLst = dsKokyakuKanri.getDsTtdkRirekis();
        exNumericEquals(dsTtdkRirekiLst.size(), 2, "件数");
        exStringEquals(dsTtdkRirekiLst.get(0).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(0).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getDssyorikbn(), C_DsSyoriKbn.KOKYAKU_TOUGOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(0).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinTime(), "20160411141111111", "業務用更新時間");
        exStringEquals(dsTtdkRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        exStringEquals(dsTtdkRirekiLst.get(1).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsTtdkRirekiLst.get(1).getHenkousikibetukey(), "0000000005", "変更識別キー");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getDssyorikbn(), C_DsSyoriKbn.MAIL_HENKOU, "ＤＳ処理区分");
        exClassificationEquals(dsTtdkRirekiLst.get(1).getHenkourrkumu(), C_UmuKbn.ARI, "変更履歴有無");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsTtdkRirekiLst.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst = dsTtdkRirekiLst.get(0).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst.size(), 1, "件数");
        exStringEquals(dsHenkouRirekiLst.get(0).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst.get(0).getTablenm(), null, "テーブル名称");
        exStringEquals(dsHenkouRirekiLst.get(0).getTableid(), null, "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst.get(0).getHnksyuruikbn(), null, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst.get(0).getHanbetukoumokunm(), null, "判別項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokuid(), null, "変更項目ID");
        exStringEquals(dsHenkouRirekiLst.get(0).getHenkoukoumokunm(), null, "変更項目名");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyouoriginal(), null, "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getBfrnaiyou(), null, "変更前内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyouoriginal(), null, "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst.get(0).getNewnaiyou(), null, "変更後内容");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinKinou(), "test1", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst.get(0).getGyoumuKousinsyaId(), "testuser1", "業務用更新者ＩＤ");

        List<MT_DsHenkouRireki> dsHenkouRirekiLst1 = dsTtdkRirekiLst.get(1).getDsHenkouRirekis();
        exNumericEquals(dsHenkouRirekiLst1.size(), 5, "件数");
        exStringEquals(dsHenkouRirekiLst1.get(0).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkousikibetukey(), "0000000005", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(0).getRenno(), 1, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(0).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(0).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokuid(), "dsmailtourokujyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(0).getHenkoukoumokunm(), "ＤＳメール登録状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyouoriginal(), "0", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getBfrnaiyou(), "未登録", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(0).getNewnaiyou(), "登録", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(1).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkousikibetukey(), "0000000005", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(1).getRenno(), 2, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(1).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(1).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokuid(), "dsmailaddress", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(1).getHenkoukoumokunm(), "ＤＳメールアドレス", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyouoriginal(), "www.liantaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@co.jp", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(1).getNewnaiyou(), "www.liantaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@co.jp", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(1).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(2).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkousikibetukey(), "0000000005", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(2).getRenno(), 3, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(2).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(2).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokuid(), "dsmailsousinjyoutaikbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(2).getHenkoukoumokunm(), "ＤＳメール送信状態区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyouoriginal(), "2", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getBfrnaiyou(), "停止", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyouoriginal(), "1", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(2).getNewnaiyou(), "有効", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(2).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(3).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkousikibetukey(), "0000000005", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(3).getRenno(), 4, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(3).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(3).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokuid(), "dsmailsousintisrykbn", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(3).getHenkoukoumokunm(), "ＤＳメール送信停止理由区分", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyouoriginal(), "1", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getBfrnaiyou(), "メール配信エラー", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyouoriginal(), "0", "変更後内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(3).getNewnaiyou(), "", "変更後内容");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(3).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        exStringEquals(dsHenkouRirekiLst1.get(4).getDskokno(), "1001111005", "ＤＳ顧客番号");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkousikibetukey(), "0000000005", "変更識別キー");
        exNumericEquals(dsHenkouRirekiLst1.get(4).getRenno(), 5, "連番");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTablenm(), "ＤＳメールアドレステーブル", "テーブル名称");
        exStringEquals(dsHenkouRirekiLst1.get(4).getTableid(), "MT_DsMailAddress", "テーブルＩＤ");
        exClassificationEquals(dsHenkouRirekiLst1.get(4).getHnksyuruikbn(), C_HnkSyuruiKbn.HENKOU, "変更種類区分");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHanbetukoumokunm(), "ＤＳメールアドレス情報　ＤＳメールアドレス連番：1", "判別項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokuid(), "dskousinymdtime", "変更項目ID");
        exStringEquals(dsHenkouRirekiLst1.get(4).getHenkoukoumokunm(), "ＤＳ更新日時", "変更項目名");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyouoriginal(), "", "変更前内容原本");
        exStringEquals(dsHenkouRirekiLst1.get(4).getBfrnaiyou(), "", "変更前内容");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinKinou(), "dwmailaddresshenkou", "業務用更新機能ＩＤ");
        exStringEquals(dsHenkouRirekiLst1.get(4).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
    }

    private void setKibanKoumoku(MultivaluedMap<String, String> pMap){

        pMap.add("operatorId","operatorId");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwnetservicesousin.dwmailaddresshenkou.DwMailAddressHenkou/execPostFormUpdate");
    }
}
