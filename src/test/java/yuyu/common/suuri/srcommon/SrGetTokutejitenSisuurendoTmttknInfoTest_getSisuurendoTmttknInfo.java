package yuyu.common.suuri.srcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定時点指数連動型積立金情報取得のメソッド {@link SrGetTokutejitenSisuurendoTmttknInfo#getSisuurendoTmttknInfo(BizDate,
 *       ,String, List<SrGetTokutejitenTmttknInfoBean>)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrGetTokutejitenSisuurendoTmttknInfoTest_getSisuurendoTmttknInfo {

    @Test
    @TestOrder(10)
    public void testGetSisuurendoTmttknInfo_B1() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, null, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        assertNull("指数連動積増型年金積立金テーブルエンティティ（前）", khSisuurendoTmttknMae);
        assertNull("指数連動積増型年金積立金テーブルエンティティ（後）", khSisuurendoTmttknAto);

    }

    @Test
    @TestOrder(20)
    public void testGetSisuurendoTmttknInfo_B2() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean.setKbnkey("03");
        srGetTokutejitenTmttknInfoBean.setSyono("17806000035");
        srGetTokutejitenTmttknInfoBean.setTmttkntaisyouym(BizDateYM.valueOf("201801"));
        srGetTokutejitenTmttknInfoBean.setRenno(1);
        srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean.setTeiritutmttkngk(BizCurrency.valueOf(123456789));
        srGetTokutejitenTmttknInfoBean.setSisuurendoutmttkngk(BizCurrency.valueOf(234567891));
        srGetTokutejitenTmttknInfoBean.setSisuuupritu(BizNumber.valueOf(3.4567));
        srGetTokutejitenTmttknInfoBean.setTmttknzoukaritu(BizNumber.valueOf(4.5678));
        srGetTokutejitenTmttknInfoBean.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180201"));
        srGetTokutejitenTmttknInfoBean.setTmttknhaneisisuu(BizNumber.valueOf(12345.12345));
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou("khgengaku");
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinsyaId("user001");
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean.setKousinsyaId("user101");
        srGetTokutejitenTmttknInfoBean.setKousinTime("20180618210926127");
        srGetTokutejitenTmttknInfoBean.setKousinKinou("testkinou01");
        srGetTokutejitenTmttknInfoBean.setVersion(1L);
        srGetTokutejitenTmttknInfoBean.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012345L));

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, null, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        assertNull("指数連動積増型年金積立金テーブルエンティティ（前）", khSisuurendoTmttknMae);
        exStringEquals(khSisuurendoTmttknAto.getKbnkey(), "03", "区分キー");
        exStringEquals(khSisuurendoTmttknAto.getSyono(), "17806000035", "証券番号");
        exDateYMEquals(khSisuurendoTmttknAto.getTmttkntaisyouym(), BizDateYM.valueOf("201801"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknAto.getRenno(), 1, "連番");
        exDateEquals(khSisuurendoTmttknAto.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180807"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTeiritutmttkngk(), BizCurrency.valueOf(123456789), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567891), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuuupritu(), BizNumber.valueOf(3.4567), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknzoukaritu(), BizNumber.valueOf(4.5678), "積立金増加率");
        exDateEquals(khSisuurendoTmttknAto.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180201"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12345), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinTime(), "20180618210926123", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinsyaId(), "user101", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getKousinTime(), "20180618210926127", "更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinKinou(), "testkinou01", "更新機能");
        exNumericEquals(khSisuurendoTmttknAto.getVersion(), 1L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901234L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012345L), "移転前指数連動積立金額");

    }

    @Test
    @TestOrder(30)
    public void testGetSisuurendoTmttknInfo_B3() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean1.setKbnkey("01");
        srGetTokutejitenTmttknInfoBean1.setSyono("17806000013");
        srGetTokutejitenTmttknInfoBean1.setTmttkntaisyouym(BizDateYM.valueOf("201801"));
        srGetTokutejitenTmttknInfoBean1.setRenno(1);
        srGetTokutejitenTmttknInfoBean1.setTmttknkouryokukaisiymd(BizDate.valueOf("20180809"));
        srGetTokutejitenTmttknInfoBean1.setTeiritutmttkngk(BizCurrency.valueOf(123456781));
        srGetTokutejitenTmttknInfoBean1.setSisuurendoutmttkngk(BizCurrency.valueOf(234567891));
        srGetTokutejitenTmttknInfoBean1.setSisuuupritu(BizNumber.valueOf(3.4561));
        srGetTokutejitenTmttknInfoBean1.setTmttknzoukaritu(BizNumber.valueOf(4.5671));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180201"));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneisisuu(BizNumber.valueOf(12345.12341));
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinKinou("khgengaku");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinsyaId("user001");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinTime("20180618210926121");
        srGetTokutejitenTmttknInfoBean1.setKousinsyaId("user101");
        srGetTokutejitenTmttknInfoBean1.setKousinTime("20180618210926121");
        srGetTokutejitenTmttknInfoBean1.setKousinKinou("testkinou01");
        srGetTokutejitenTmttknInfoBean1.setVersion(1L);
        srGetTokutejitenTmttknInfoBean1.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901231L));
        srGetTokutejitenTmttknInfoBean1.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012341L));

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean1);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean2 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean2.setKbnkey("02");
        srGetTokutejitenTmttknInfoBean2.setSyono("17806000024");
        srGetTokutejitenTmttknInfoBean2.setTmttkntaisyouym(BizDateYM.valueOf("201802"));
        srGetTokutejitenTmttknInfoBean2.setRenno(2);
        srGetTokutejitenTmttknInfoBean2.setTmttknkouryokukaisiymd(null);
        srGetTokutejitenTmttknInfoBean2.setTeiritutmttkngk(BizCurrency.valueOf(123456782));
        srGetTokutejitenTmttknInfoBean2.setSisuurendoutmttkngk(BizCurrency.valueOf(234567892));
        srGetTokutejitenTmttknInfoBean2.setSisuuupritu(BizNumber.valueOf(3.4562));
        srGetTokutejitenTmttknInfoBean2.setTmttknzoukaritu(BizNumber.valueOf(4.5672));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180202"));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneisisuu(BizNumber.valueOf(12345.12342));
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinKinou("khgengaku");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinsyaId("user002");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean2.setKousinsyaId("user102");
        srGetTokutejitenTmttknInfoBean2.setKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean2.setKousinKinou("testkinou02");
        srGetTokutejitenTmttknInfoBean2.setVersion(2L);
        srGetTokutejitenTmttknInfoBean2.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901232L));
        srGetTokutejitenTmttknInfoBean2.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012342L));

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean2);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean3 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean3.setKbnkey("03");
        srGetTokutejitenTmttknInfoBean3.setSyono("17806000035");
        srGetTokutejitenTmttknInfoBean3.setTmttkntaisyouym(BizDateYM.valueOf("201803"));
        srGetTokutejitenTmttknInfoBean3.setRenno(3);
        srGetTokutejitenTmttknInfoBean3.setTmttknkouryokukaisiymd(BizDate.valueOf("20180808"));
        srGetTokutejitenTmttknInfoBean3.setTeiritutmttkngk(BizCurrency.valueOf(123456783));
        srGetTokutejitenTmttknInfoBean3.setSisuurendoutmttkngk(BizCurrency.valueOf(234567893));
        srGetTokutejitenTmttknInfoBean3.setSisuuupritu(BizNumber.valueOf(3.4563));
        srGetTokutejitenTmttknInfoBean3.setTmttknzoukaritu(BizNumber.valueOf(4.5673));
        srGetTokutejitenTmttknInfoBean3.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180203"));
        srGetTokutejitenTmttknInfoBean3.setTmttknhaneisisuu(BizNumber.valueOf(12345.12343));
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinKinou("khgengaku");
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinsyaId("user003");
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean3.setKousinsyaId("user103");
        srGetTokutejitenTmttknInfoBean3.setKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean3.setKousinKinou("testkinou03");
        srGetTokutejitenTmttknInfoBean3.setVersion(3L);
        srGetTokutejitenTmttknInfoBean3.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901233L));
        srGetTokutejitenTmttknInfoBean3.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012343L));

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean3);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean4 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean4.setKbnkey("04");
        srGetTokutejitenTmttknInfoBean4.setSyono("17806000046");
        srGetTokutejitenTmttknInfoBean4.setTmttkntaisyouym(BizDateYM.valueOf("201804"));
        srGetTokutejitenTmttknInfoBean4.setRenno(4);
        srGetTokutejitenTmttknInfoBean4.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean4.setTeiritutmttkngk(BizCurrency.valueOf(123456784));
        srGetTokutejitenTmttknInfoBean4.setSisuurendoutmttkngk(BizCurrency.valueOf(234567894));
        srGetTokutejitenTmttknInfoBean4.setSisuuupritu(BizNumber.valueOf(3.4564));
        srGetTokutejitenTmttknInfoBean4.setTmttknzoukaritu(BizNumber.valueOf(4.5674));
        srGetTokutejitenTmttknInfoBean4.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180204"));
        srGetTokutejitenTmttknInfoBean4.setTmttknhaneisisuu(BizNumber.valueOf(12345.12344));
        srGetTokutejitenTmttknInfoBean4.setGyoumuKousinKinou("khgengaku");
        srGetTokutejitenTmttknInfoBean4.setGyoumuKousinsyaId("user004");
        srGetTokutejitenTmttknInfoBean4.setGyoumuKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean4.setKousinsyaId("user104");
        srGetTokutejitenTmttknInfoBean4.setKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean4.setKousinKinou("testkinou04");
        srGetTokutejitenTmttknInfoBean4.setVersion(4L);
        srGetTokutejitenTmttknInfoBean4.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean4.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012344L));

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean4);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, null, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        assertNull("指数連動積増型年金積立金テーブルエンティティ（前）", khSisuurendoTmttknMae);
        exStringEquals(khSisuurendoTmttknAto.getKbnkey(), "03", "区分キー");
        exStringEquals(khSisuurendoTmttknAto.getSyono(), "17806000035", "証券番号");
        exDateYMEquals(khSisuurendoTmttknAto.getTmttkntaisyouym(), BizDateYM.valueOf("201803"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknAto.getRenno(), 3, "連番");
        exDateEquals(khSisuurendoTmttknAto.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180808"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTeiritutmttkngk(), BizCurrency.valueOf(123456783), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567893), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuuupritu(), BizNumber.valueOf(3.4563), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknzoukaritu(), BizNumber.valueOf(4.5673), "積立金増加率");
        exDateEquals(khSisuurendoTmttknAto.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180203"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12343), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinsyaId(), "user003", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinTime(), "20180618210926123", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinsyaId(), "user103", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getKousinTime(), "20180618210926123", "更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinKinou(), "testkinou03", "更新機能");
        exNumericEquals(khSisuurendoTmttknAto.getVersion(), 3L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901233L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012343L), "移転前指数連動積立金額");

    }

    @Test
    @TestOrder(40)
    public void testGetSisuurendoTmttknInfo_B4() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        assertNull("指数連動積増型年金積立金テーブルエンティティ（前）", khSisuurendoTmttknMae);
        assertNull("指数連動積増型年金積立金テーブルエンティティ（後）", khSisuurendoTmttknAto);

    }

    @Test
    @TestOrder(50)
    public void testGetSisuurendoTmttknInfo_B5() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean.setKbnkey("03");
        srGetTokutejitenTmttknInfoBean.setSyono("17806000035");
        srGetTokutejitenTmttknInfoBean.setTmttkntaisyouym(BizDateYM.valueOf("201801"));
        srGetTokutejitenTmttknInfoBean.setRenno(1);
        srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean.setTeiritutmttkngk(BizCurrency.valueOf(123456789));
        srGetTokutejitenTmttknInfoBean.setSisuurendoutmttkngk(BizCurrency.valueOf(234567891));
        srGetTokutejitenTmttknInfoBean.setSisuuupritu(BizNumber.valueOf(3.4567));
        srGetTokutejitenTmttknInfoBean.setTmttknzoukaritu(BizNumber.valueOf(4.5678));
        srGetTokutejitenTmttknInfoBean.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180201"));
        srGetTokutejitenTmttknInfoBean.setTmttknhaneisisuu(BizNumber.valueOf(12345.12345));
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou("khgengaku");
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinsyaId("user001");
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean.setKousinsyaId("user101");
        srGetTokutejitenTmttknInfoBean.setKousinTime("20180618210926127");
        srGetTokutejitenTmttknInfoBean.setKousinKinou("testkinou01");
        srGetTokutejitenTmttknInfoBean.setVersion(1L);
        srGetTokutejitenTmttknInfoBean.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012345L));
        srGetTokutejitenTmttknInfoBean.setHenkousikibetukey("002");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        assertNull("指数連動積増型年金積立金テーブルエンティティ（前）", khSisuurendoTmttknMae);
        assertNull("指数連動積増型年金積立金テーブルエンティティ（後）", khSisuurendoTmttknAto);

    }


    @Test
    @TestOrder(60)
    public void testGetSisuurendoTmttknInfo_B6() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean.setKbnkey("03");
        srGetTokutejitenTmttknInfoBean.setSyono("17806000035");
        srGetTokutejitenTmttknInfoBean.setTmttkntaisyouym(BizDateYM.valueOf("201801"));
        srGetTokutejitenTmttknInfoBean.setRenno(1);
        srGetTokutejitenTmttknInfoBean.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean.setTeiritutmttkngk(BizCurrency.valueOf(123456789));
        srGetTokutejitenTmttknInfoBean.setSisuurendoutmttkngk(BizCurrency.valueOf(234567891));
        srGetTokutejitenTmttknInfoBean.setSisuuupritu(BizNumber.valueOf(3.4567));
        srGetTokutejitenTmttknInfoBean.setTmttknzoukaritu(BizNumber.valueOf(4.5678));
        srGetTokutejitenTmttknInfoBean.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180201"));
        srGetTokutejitenTmttknInfoBean.setTmttknhaneisisuu(BizNumber.valueOf(12345.12345));
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinKinou("khbatchkaiyaku");
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinsyaId("user001");
        srGetTokutejitenTmttknInfoBean.setGyoumuKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean.setKousinsyaId("user101");
        srGetTokutejitenTmttknInfoBean.setKousinTime("20180618210926127");
        srGetTokutejitenTmttknInfoBean.setKousinKinou("testkinou01");
        srGetTokutejitenTmttknInfoBean.setVersion(1L);
        srGetTokutejitenTmttknInfoBean.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012345L));
        srGetTokutejitenTmttknInfoBean.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        assertNull("指数連動積増型年金積立金テーブルエンティティ（前）", khSisuurendoTmttknMae);
        assertNull("指数連動積増型年金積立金テーブルエンティティ（後）", khSisuurendoTmttknAto);

    }

    @Test
    @TestOrder(70)
    public void testGetSisuurendoTmttknInfo_B7() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();
        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean1.setKbnkey("01");
        srGetTokutejitenTmttknInfoBean1.setSyono("17806000013");
        srGetTokutejitenTmttknInfoBean1.setTmttkntaisyouym(BizDateYM.valueOf("201801"));
        srGetTokutejitenTmttknInfoBean1.setRenno(1);
        srGetTokutejitenTmttknInfoBean1.setTmttknkouryokukaisiymd(BizDate.valueOf("20180809"));
        srGetTokutejitenTmttknInfoBean1.setTeiritutmttkngk(BizCurrency.valueOf(123456781));
        srGetTokutejitenTmttknInfoBean1.setSisuurendoutmttkngk(BizCurrency.valueOf(234567891));
        srGetTokutejitenTmttknInfoBean1.setSisuuupritu(BizNumber.valueOf(3.4561));
        srGetTokutejitenTmttknInfoBean1.setTmttknzoukaritu(BizNumber.valueOf(4.5671));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180201"));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneisisuu(BizNumber.valueOf(12345.12341));
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinKinou("khsisuurendotmttknhanei");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinsyaId("user001");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinTime("20180618210926121");
        srGetTokutejitenTmttknInfoBean1.setKousinsyaId("user101");
        srGetTokutejitenTmttknInfoBean1.setKousinTime("20180618210926121");
        srGetTokutejitenTmttknInfoBean1.setKousinKinou("testkinou01");
        srGetTokutejitenTmttknInfoBean1.setVersion(1L);
        srGetTokutejitenTmttknInfoBean1.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901231L));
        srGetTokutejitenTmttknInfoBean1.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012341L));
        srGetTokutejitenTmttknInfoBean1.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean1);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean2 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean2.setKbnkey("02");
        srGetTokutejitenTmttknInfoBean2.setSyono("17806000024");
        srGetTokutejitenTmttknInfoBean2.setTmttkntaisyouym(BizDateYM.valueOf("201802"));
        srGetTokutejitenTmttknInfoBean2.setRenno(2);
        srGetTokutejitenTmttknInfoBean2.setTmttknkouryokukaisiymd(null);
        srGetTokutejitenTmttknInfoBean2.setTeiritutmttkngk(BizCurrency.valueOf(123456782));
        srGetTokutejitenTmttknInfoBean2.setSisuurendoutmttkngk(BizCurrency.valueOf(234567892));
        srGetTokutejitenTmttknInfoBean2.setSisuuupritu(BizNumber.valueOf(3.4562));
        srGetTokutejitenTmttknInfoBean2.setTmttknzoukaritu(BizNumber.valueOf(4.5672));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180202"));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneisisuu(BizNumber.valueOf(12345.12342));
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinKinou("SrGetTokutejitenSisuurendoTmttknInfoHanei");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinsyaId("user002");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean2.setKousinsyaId("user102");
        srGetTokutejitenTmttknInfoBean2.setKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean2.setKousinKinou("testkinou02");
        srGetTokutejitenTmttknInfoBean2.setVersion(2L);
        srGetTokutejitenTmttknInfoBean2.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901232L));
        srGetTokutejitenTmttknInfoBean2.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012342L));
        srGetTokutejitenTmttknInfoBean2.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean2);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean3 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean3.setKbnkey("03");
        srGetTokutejitenTmttknInfoBean3.setSyono("17806000035");
        srGetTokutejitenTmttknInfoBean3.setTmttkntaisyouym(BizDateYM.valueOf("201803"));
        srGetTokutejitenTmttknInfoBean3.setRenno(3);
        srGetTokutejitenTmttknInfoBean3.setTmttknkouryokukaisiymd(BizDate.valueOf("20180808"));
        srGetTokutejitenTmttknInfoBean3.setTeiritutmttkngk(BizCurrency.valueOf(123456783));
        srGetTokutejitenTmttknInfoBean3.setSisuurendoutmttkngk(BizCurrency.valueOf(234567893));
        srGetTokutejitenTmttknInfoBean3.setSisuuupritu(BizNumber.valueOf(3.4563));
        srGetTokutejitenTmttknInfoBean3.setTmttknzoukaritu(BizNumber.valueOf(4.5673));
        srGetTokutejitenTmttknInfoBean3.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180203"));
        srGetTokutejitenTmttknInfoBean3.setTmttknhaneisisuu(BizNumber.valueOf(12345.12343));
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinKinou("SrGetTokutejitenSisuurendoTmttknInfoHaneiTrks");
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinsyaId("user003");
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean3.setKousinsyaId("user103");
        srGetTokutejitenTmttknInfoBean3.setKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean3.setKousinKinou("testkinou03");
        srGetTokutejitenTmttknInfoBean3.setVersion(3L);
        srGetTokutejitenTmttknInfoBean3.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901233L));
        srGetTokutejitenTmttknInfoBean3.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012343L));
        srGetTokutejitenTmttknInfoBean3.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean3);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean4 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean4.setKbnkey("04");
        srGetTokutejitenTmttknInfoBean4.setSyono("17806000046");
        srGetTokutejitenTmttknInfoBean4.setTmttkntaisyouym(BizDateYM.valueOf("201804"));
        srGetTokutejitenTmttknInfoBean4.setRenno(4);
        srGetTokutejitenTmttknInfoBean4.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean4.setTeiritutmttkngk(BizCurrency.valueOf(123456784));
        srGetTokutejitenTmttknInfoBean4.setSisuurendoutmttkngk(BizCurrency.valueOf(234567894));
        srGetTokutejitenTmttknInfoBean4.setSisuuupritu(BizNumber.valueOf(3.4564));
        srGetTokutejitenTmttknInfoBean4.setTmttknzoukaritu(BizNumber.valueOf(4.5674));
        srGetTokutejitenTmttknInfoBean4.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180204"));
        srGetTokutejitenTmttknInfoBean4.setTmttknhaneisisuu(BizNumber.valueOf(12345.12344));
        srGetTokutejitenTmttknInfoBean4.setGyoumuKousinKinou("khbatchkaiyaku");
        srGetTokutejitenTmttknInfoBean4.setGyoumuKousinsyaId("user004");
        srGetTokutejitenTmttknInfoBean4.setGyoumuKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean4.setKousinsyaId("user104");
        srGetTokutejitenTmttknInfoBean4.setKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean4.setKousinKinou("testkinou04");
        srGetTokutejitenTmttknInfoBean4.setVersion(4L);
        srGetTokutejitenTmttknInfoBean4.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean4.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012344L));
        srGetTokutejitenTmttknInfoBean4.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean4);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        exStringEquals(khSisuurendoTmttknMae.getKbnkey(), "04", "区分キー");
        exStringEquals(khSisuurendoTmttknMae.getSyono(), "17806000046", "証券番号");
        exDateYMEquals(khSisuurendoTmttknMae.getTmttkntaisyouym(), BizDateYM.valueOf("201804"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknMae.getRenno(), 4, "連番");
        exDateEquals(khSisuurendoTmttknMae.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180807"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTeiritutmttkngk(), BizCurrency.valueOf(123456784), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567894), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuuupritu(), BizNumber.valueOf(3.4564), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknzoukaritu(), BizNumber.valueOf(4.5674), "積立金増加率");
        exDateEquals(khSisuurendoTmttknMae.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180204"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12344), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinKinou(), "khbatchkaiyaku", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinsyaId(), "user004", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinTime(), "20180618210926124", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinsyaId(), "user104", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getKousinTime(), "20180618210926124", "更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinKinou(), "testkinou04", "更新機能");
        exNumericEquals(khSisuurendoTmttknMae.getVersion(), 4L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901234L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012344L), "移転前指数連動積立金額");
        exStringEquals(khSisuurendoTmttknAto.getKbnkey(), "01", "区分キー");
        exStringEquals(khSisuurendoTmttknAto.getSyono(), "17806000013", "証券番号");
        exDateYMEquals(khSisuurendoTmttknAto.getTmttkntaisyouym(), BizDateYM.valueOf("201801"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknAto.getRenno(), 1, "連番");
        exDateEquals(khSisuurendoTmttknAto.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180809"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTeiritutmttkngk(), BizCurrency.valueOf(123456781), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567891), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuuupritu(), BizNumber.valueOf(3.4561), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknzoukaritu(), BizNumber.valueOf(4.5671), "積立金増加率");
        exDateEquals(khSisuurendoTmttknAto.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180201"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12341), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinKinou(), "khsisuurendotmttknhanei", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinTime(), "20180618210926121", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinsyaId(), "user101", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getKousinTime(), "20180618210926121", "更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinKinou(), "testkinou01", "更新機能");
        exNumericEquals(khSisuurendoTmttknAto.getVersion(), 1L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901231L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012341L), "移転前指数連動積立金額");

    }

    @Test
    @TestOrder(80)
    public void testGetSisuurendoTmttknInfo_B8() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean1.setKbnkey("02");
        srGetTokutejitenTmttknInfoBean1.setSyono("17806000024");
        srGetTokutejitenTmttknInfoBean1.setTmttkntaisyouym(BizDateYM.valueOf("201802"));
        srGetTokutejitenTmttknInfoBean1.setRenno(2);
        srGetTokutejitenTmttknInfoBean1.setTmttknkouryokukaisiymd(null);
        srGetTokutejitenTmttknInfoBean1.setTeiritutmttkngk(BizCurrency.valueOf(123456782));
        srGetTokutejitenTmttknInfoBean1.setSisuurendoutmttkngk(BizCurrency.valueOf(234567892));
        srGetTokutejitenTmttknInfoBean1.setSisuuupritu(BizNumber.valueOf(3.4562));
        srGetTokutejitenTmttknInfoBean1.setTmttknzoukaritu(BizNumber.valueOf(4.5672));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180202"));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneisisuu(BizNumber.valueOf(12345.12342));
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinKinou("SrGetTokutejitenSisuurendoTmttknInfoHanei");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinsyaId("user002");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean1.setKousinsyaId("user102");
        srGetTokutejitenTmttknInfoBean1.setKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean1.setKousinKinou("testkinou02");
        srGetTokutejitenTmttknInfoBean1.setVersion(2L);
        srGetTokutejitenTmttknInfoBean1.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901232L));
        srGetTokutejitenTmttknInfoBean1.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012342L));
        srGetTokutejitenTmttknInfoBean1.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean1);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean2 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean2.setKbnkey("04");
        srGetTokutejitenTmttknInfoBean2.setSyono("17806000046");
        srGetTokutejitenTmttknInfoBean2.setTmttkntaisyouym(BizDateYM.valueOf("201804"));
        srGetTokutejitenTmttknInfoBean2.setRenno(4);
        srGetTokutejitenTmttknInfoBean2.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean2.setTeiritutmttkngk(BizCurrency.valueOf(123456784));
        srGetTokutejitenTmttknInfoBean2.setSisuurendoutmttkngk(BizCurrency.valueOf(234567894));
        srGetTokutejitenTmttknInfoBean2.setSisuuupritu(BizNumber.valueOf(3.4564));
        srGetTokutejitenTmttknInfoBean2.setTmttknzoukaritu(BizNumber.valueOf(4.5674));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180204"));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneisisuu(BizNumber.valueOf(12345.12344));
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinKinou("khbatchkaiyaku");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinsyaId("user004");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean2.setKousinsyaId("user104");
        srGetTokutejitenTmttknInfoBean2.setKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean2.setKousinKinou("testkinou04");
        srGetTokutejitenTmttknInfoBean2.setVersion(4L);
        srGetTokutejitenTmttknInfoBean2.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean2.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012344L));
        srGetTokutejitenTmttknInfoBean2.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean2);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        exStringEquals(khSisuurendoTmttknMae.getKbnkey(), "04", "区分キー");
        exStringEquals(khSisuurendoTmttknMae.getSyono(), "17806000046", "証券番号");
        exDateYMEquals(khSisuurendoTmttknMae.getTmttkntaisyouym(), BizDateYM.valueOf("201804"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknMae.getRenno(), 4, "連番");
        exDateEquals(khSisuurendoTmttknMae.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180807"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTeiritutmttkngk(), BizCurrency.valueOf(123456784), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567894), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuuupritu(), BizNumber.valueOf(3.4564), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknzoukaritu(), BizNumber.valueOf(4.5674), "積立金増加率");
        exDateEquals(khSisuurendoTmttknMae.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180204"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12344), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinKinou(), "khbatchkaiyaku", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinsyaId(), "user004", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinTime(), "20180618210926124", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinsyaId(), "user104", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getKousinTime(), "20180618210926124", "更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinKinou(), "testkinou04", "更新機能");
        exNumericEquals(khSisuurendoTmttknMae.getVersion(), 4L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901234L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012344L), "移転前指数連動積立金額");
        exStringEquals(khSisuurendoTmttknAto.getKbnkey(), "02", "区分キー");
        exStringEquals(khSisuurendoTmttknAto.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(khSisuurendoTmttknAto.getTmttkntaisyouym(), BizDateYM.valueOf("201802"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknAto.getRenno(), 2, "連番");
        assertNull("積立金効力開始日", khSisuurendoTmttknAto.getTmttknkouryokukaisiymd());
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTeiritutmttkngk(), BizCurrency.valueOf(123456782), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567892), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuuupritu(), BizNumber.valueOf(3.4562), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknzoukaritu(), BizNumber.valueOf(4.5672), "積立金増加率");
        exDateEquals(khSisuurendoTmttknAto.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180202"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12342), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinKinou(), "SrGetTokutejitenSisuurendoTmttknInfoHanei", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinTime(), "20180618210926122", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinsyaId(), "user102", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getKousinTime(), "20180618210926122", "更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinKinou(), "testkinou02", "更新機能");
        exNumericEquals(khSisuurendoTmttknAto.getVersion(), 2L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901232L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012342L), "移転前指数連動積立金額");

    }

    @Test
    @TestOrder(90)
    public void testGetSisuurendoTmttknInfo_B9() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean1.setKbnkey("02");
        srGetTokutejitenTmttknInfoBean1.setSyono("17806000024");
        srGetTokutejitenTmttknInfoBean1.setTmttkntaisyouym(BizDateYM.valueOf("201802"));
        srGetTokutejitenTmttknInfoBean1.setRenno(2);
        srGetTokutejitenTmttknInfoBean1.setTmttknkouryokukaisiymd(null);
        srGetTokutejitenTmttknInfoBean1.setTeiritutmttkngk(BizCurrency.valueOf(123456782));
        srGetTokutejitenTmttknInfoBean1.setSisuurendoutmttkngk(BizCurrency.valueOf(234567892));
        srGetTokutejitenTmttknInfoBean1.setSisuuupritu(BizNumber.valueOf(3.4562));
        srGetTokutejitenTmttknInfoBean1.setTmttknzoukaritu(BizNumber.valueOf(4.5672));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180202"));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneisisuu(BizNumber.valueOf(12345.12342));
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinKinou("SrGetTokutejitenSisuurendoTmttknInfoHaneiTrks");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinsyaId("user002");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean1.setKousinsyaId("user102");
        srGetTokutejitenTmttknInfoBean1.setKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean1.setKousinKinou("testkinou02");
        srGetTokutejitenTmttknInfoBean1.setVersion(2L);
        srGetTokutejitenTmttknInfoBean1.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901232L));
        srGetTokutejitenTmttknInfoBean1.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012342L));
        srGetTokutejitenTmttknInfoBean1.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean1);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean2 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean2.setKbnkey("03");
        srGetTokutejitenTmttknInfoBean2.setSyono("17806000035");
        srGetTokutejitenTmttknInfoBean2.setTmttkntaisyouym(BizDateYM.valueOf("201803"));
        srGetTokutejitenTmttknInfoBean2.setRenno(3);
        srGetTokutejitenTmttknInfoBean2.setTmttknkouryokukaisiymd(BizDate.valueOf("20180808"));
        srGetTokutejitenTmttknInfoBean2.setTeiritutmttkngk(BizCurrency.valueOf(123456783));
        srGetTokutejitenTmttknInfoBean2.setSisuurendoutmttkngk(BizCurrency.valueOf(234567893));
        srGetTokutejitenTmttknInfoBean2.setSisuuupritu(BizNumber.valueOf(3.4563));
        srGetTokutejitenTmttknInfoBean2.setTmttknzoukaritu(BizNumber.valueOf(4.5673));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180203"));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneisisuu(BizNumber.valueOf(12345.12343));
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinKinou("SrGetTokutejitenSisuurendoTmttknInfoHanei");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinsyaId("user003");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean2.setKousinsyaId("user103");
        srGetTokutejitenTmttknInfoBean2.setKousinTime("20180618210926123");
        srGetTokutejitenTmttknInfoBean2.setKousinKinou("testkinou03");
        srGetTokutejitenTmttknInfoBean2.setVersion(3L);
        srGetTokutejitenTmttknInfoBean2.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901233L));
        srGetTokutejitenTmttknInfoBean2.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012343L));
        srGetTokutejitenTmttknInfoBean2.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean2);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean3 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean3.setKbnkey("04");
        srGetTokutejitenTmttknInfoBean3.setSyono("17806000046");
        srGetTokutejitenTmttknInfoBean3.setTmttkntaisyouym(BizDateYM.valueOf("201804"));
        srGetTokutejitenTmttknInfoBean3.setRenno(4);
        srGetTokutejitenTmttknInfoBean3.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean3.setTeiritutmttkngk(BizCurrency.valueOf(123456784));
        srGetTokutejitenTmttknInfoBean3.setSisuurendoutmttkngk(BizCurrency.valueOf(234567894));
        srGetTokutejitenTmttknInfoBean3.setSisuuupritu(BizNumber.valueOf(3.4564));
        srGetTokutejitenTmttknInfoBean3.setTmttknzoukaritu(BizNumber.valueOf(4.5674));
        srGetTokutejitenTmttknInfoBean3.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180204"));
        srGetTokutejitenTmttknInfoBean3.setTmttknhaneisisuu(BizNumber.valueOf(12345.12344));
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinKinou("khbatchkaiyaku");
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinsyaId("user004");
        srGetTokutejitenTmttknInfoBean3.setGyoumuKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean3.setKousinsyaId("user104");
        srGetTokutejitenTmttknInfoBean3.setKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean3.setKousinKinou("testkinou04");
        srGetTokutejitenTmttknInfoBean3.setVersion(4L);
        srGetTokutejitenTmttknInfoBean3.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean3.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012344L));
        srGetTokutejitenTmttknInfoBean3.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean3);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        exStringEquals(khSisuurendoTmttknMae.getKbnkey(), "03", "区分キー");
        exStringEquals(khSisuurendoTmttknMae.getSyono(), "17806000035", "証券番号");
        exDateYMEquals(khSisuurendoTmttknMae.getTmttkntaisyouym(), BizDateYM.valueOf("201803"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknMae.getRenno(), 3, "連番");
        exDateEquals(khSisuurendoTmttknMae.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180808"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTeiritutmttkngk(), BizCurrency.valueOf(123456783), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567893), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuuupritu(), BizNumber.valueOf(3.4563), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknzoukaritu(), BizNumber.valueOf(4.5673), "積立金増加率");
        exDateEquals(khSisuurendoTmttknMae.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180203"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12343), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinKinou(), "SrGetTokutejitenSisuurendoTmttknInfoHanei", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinsyaId(), "user003", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinTime(), "20180618210926123", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinsyaId(), "user103", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getKousinTime(), "20180618210926123", "更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinKinou(), "testkinou03", "更新機能");
        exNumericEquals(khSisuurendoTmttknMae.getVersion(), 3L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901233L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012343L), "移転前指数連動積立金額");
        exStringEquals(khSisuurendoTmttknAto.getKbnkey(), "04", "区分キー");
        exStringEquals(khSisuurendoTmttknAto.getSyono(), "17806000046", "証券番号");
        exDateYMEquals(khSisuurendoTmttknAto.getTmttkntaisyouym(), BizDateYM.valueOf("201804"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknAto.getRenno(), 4, "連番");
        exDateEquals(khSisuurendoTmttknAto.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180807"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTeiritutmttkngk(), BizCurrency.valueOf(123456784), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567894), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuuupritu(), BizNumber.valueOf(3.4564), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknzoukaritu(), BizNumber.valueOf(4.5674), "積立金増加率");
        exDateEquals(khSisuurendoTmttknAto.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180204"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12344), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinKinou(), "khbatchkaiyaku", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinsyaId(), "user004", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinTime(), "20180618210926124", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinsyaId(), "user104", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getKousinTime(), "20180618210926124", "更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinKinou(), "testkinou04", "更新機能");
        exNumericEquals(khSisuurendoTmttknAto.getVersion(), 4L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901234L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012344L), "移転前指数連動積立金額");

    }

    @Test
    @TestOrder(100)
    public void testGetSisuurendoTmttknInfo_B10() {

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        BizDate pKijyunYmd = BizDate.valueOf(20180808);
        String pHenkouSikibetuKey = "001";
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean1 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean1.setKbnkey("02");
        srGetTokutejitenTmttknInfoBean1.setSyono("17806000024");
        srGetTokutejitenTmttknInfoBean1.setTmttkntaisyouym(BizDateYM.valueOf("201802"));
        srGetTokutejitenTmttknInfoBean1.setRenno(2);
        srGetTokutejitenTmttknInfoBean1.setTmttknkouryokukaisiymd(null);
        srGetTokutejitenTmttknInfoBean1.setTeiritutmttkngk(BizCurrency.valueOf(123456782));
        srGetTokutejitenTmttknInfoBean1.setSisuurendoutmttkngk(BizCurrency.valueOf(234567892));
        srGetTokutejitenTmttknInfoBean1.setSisuuupritu(BizNumber.valueOf(3.4562));
        srGetTokutejitenTmttknInfoBean1.setTmttknzoukaritu(BizNumber.valueOf(4.5672));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180202"));
        srGetTokutejitenTmttknInfoBean1.setTmttknhaneisisuu(BizNumber.valueOf(12345.12342));
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinKinou("khgengaku");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinsyaId("user002");
        srGetTokutejitenTmttknInfoBean1.setGyoumuKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean1.setKousinsyaId("user102");
        srGetTokutejitenTmttknInfoBean1.setKousinTime("20180618210926122");
        srGetTokutejitenTmttknInfoBean1.setKousinKinou("testkinou02");
        srGetTokutejitenTmttknInfoBean1.setVersion(2L);
        srGetTokutejitenTmttknInfoBean1.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901232L));
        srGetTokutejitenTmttknInfoBean1.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012342L));
        srGetTokutejitenTmttknInfoBean1.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean1);

        SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean2 =
            SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);
        srGetTokutejitenTmttknInfoBean2.setKbnkey("04");
        srGetTokutejitenTmttknInfoBean2.setSyono("17806000046");
        srGetTokutejitenTmttknInfoBean2.setTmttkntaisyouym(BizDateYM.valueOf("201804"));
        srGetTokutejitenTmttknInfoBean2.setRenno(4);
        srGetTokutejitenTmttknInfoBean2.setTmttknkouryokukaisiymd(BizDate.valueOf("20180807"));
        srGetTokutejitenTmttknInfoBean2.setTeiritutmttkngk(BizCurrency.valueOf(123456784));
        srGetTokutejitenTmttknInfoBean2.setSisuurendoutmttkngk(BizCurrency.valueOf(234567894));
        srGetTokutejitenTmttknInfoBean2.setSisuuupritu(BizNumber.valueOf(3.4564));
        srGetTokutejitenTmttknInfoBean2.setTmttknzoukaritu(BizNumber.valueOf(4.5674));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneitmmshanteiymd(BizDate.valueOf("20180204"));
        srGetTokutejitenTmttknInfoBean2.setTmttknhaneisisuu(BizNumber.valueOf(12345.12344));
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinKinou("khbatchkaiyaku");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinsyaId("user004");
        srGetTokutejitenTmttknInfoBean2.setGyoumuKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean2.setKousinsyaId("user104");
        srGetTokutejitenTmttknInfoBean2.setKousinTime("20180618210926124");
        srGetTokutejitenTmttknInfoBean2.setKousinKinou("testkinou04");
        srGetTokutejitenTmttknInfoBean2.setVersion(4L);
        srGetTokutejitenTmttknInfoBean2.setItenmaeteiritutmttkngk(BizCurrency.valueOf(5678901234L));
        srGetTokutejitenTmttknInfoBean2.setItenmaesisuurendoutmttkngk(BizCurrency.valueOf(6789012344L));
        srGetTokutejitenTmttknInfoBean2.setHenkousikibetukey("001");

        pSrGetTokutejitenTmttknInfoBeanList.add(srGetTokutejitenTmttknInfoBean2);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                pKijyunYmd, pHenkouSikibetuKey, pSrGetTokutejitenTmttknInfoBeanList);

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

        exStringEquals(khSisuurendoTmttknMae.getKbnkey(), "04", "区分キー");
        exStringEquals(khSisuurendoTmttknMae.getSyono(), "17806000046", "証券番号");
        exDateYMEquals(khSisuurendoTmttknMae.getTmttkntaisyouym(), BizDateYM.valueOf("201804"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknMae.getRenno(), 4, "連番");
        exDateEquals(khSisuurendoTmttknMae.getTmttknkouryokukaisiymd(), BizDate.valueOf("20180807"), "積立金効力開始日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTeiritutmttkngk(), BizCurrency.valueOf(123456784), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567894), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getSisuuupritu(), BizNumber.valueOf(3.4564), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknzoukaritu(), BizNumber.valueOf(4.5674), "積立金増加率");
        exDateEquals(khSisuurendoTmttknMae.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180204"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12344), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinKinou(), "khbatchkaiyaku", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinsyaId(), "user004", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getGyoumuKousinTime(), "20180618210926124", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinsyaId(), "user104", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknMae.getKousinTime(), "20180618210926124", "更新時間");
        exStringEquals(khSisuurendoTmttknMae.getKousinKinou(), "testkinou04", "更新機能");
        exNumericEquals(khSisuurendoTmttknMae.getVersion(), 4L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901234L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknMae.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012344L), "移転前指数連動積立金額");
        exStringEquals(khSisuurendoTmttknAto.getKbnkey(), "02", "区分キー");
        exStringEquals(khSisuurendoTmttknAto.getSyono(), "17806000024", "証券番号");
        exDateYMEquals(khSisuurendoTmttknAto.getTmttkntaisyouym(), BizDateYM.valueOf("201802"), "積立金対象年月");
        exNumericEquals(khSisuurendoTmttknAto.getRenno(), 2, "連番");
        assertNull("積立金効力開始日", khSisuurendoTmttknAto.getTmttknkouryokukaisiymd());
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTeiritutmttkngk(), BizCurrency.valueOf(123456782), "定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuurendoutmttkngk(), BizCurrency.valueOf(234567892), "指数連動積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getSisuuupritu(), BizNumber.valueOf(3.4562), "指数上昇率");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknzoukaritu(), BizNumber.valueOf(4.5672), "積立金増加率");
        exDateEquals(khSisuurendoTmttknAto.getTmttknhaneitmmshanteiymd(), BizDate.valueOf("20180202"), "積立金反映時積増判定日");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getTmttknhaneisisuu(), BizNumber.valueOf(12345.12342), "積立金反映時指数");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinKinou(), "khgengaku", "業務用更新機能ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getGyoumuKousinTime(), "20180618210926122", "業務用更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinsyaId(), "user102", "更新者ＩＤ");
        exStringEquals(khSisuurendoTmttknAto.getKousinTime(), "20180618210926122", "更新時間");
        exStringEquals(khSisuurendoTmttknAto.getKousinKinou(), "testkinou02", "更新機能");
        exNumericEquals(khSisuurendoTmttknAto.getVersion(), 2L, "バージョン");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaeteiritutmttkngk(), BizCurrency.valueOf(5678901232L), "移転前定率積立金額");
        exBizCalcbleEquals(khSisuurendoTmttknAto.getItenmaesisuurendoutmttkngk(), BizCurrency.valueOf(6789012342L), "移転前指数連動積立金額");

    }

}
