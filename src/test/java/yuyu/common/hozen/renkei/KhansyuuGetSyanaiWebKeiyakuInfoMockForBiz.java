package yuyu.common.hozen.renkei;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebServiceTest_exec;
import yuyu.def.biz.bean.webservice.IwssnSyanaiAnsyuInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;

/**
 * {@link KhansyuuGetSyanaiWebKeiyakuInfo}のモッククラスです。<br />
 */
public class KhansyuuGetSyanaiWebKeiyakuInfoMockForBiz extends KhansyuuGetSyanaiWebKeiyakuInfo{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    private IwssnSyanaiAnsyuInfoOutputBean iwssnSyanaiAnsyuInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiAnsyuInfoOutputBean.class);

    @Override
    public C_IwssnKykSyoukaiKekkaKbn exec(String pSyono) {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.NORMAL;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.DSKANRENKOUMOKU_ERROR;
            }
        }

        return super.exec(pSyono);
    }

    @Override
    public IwssnSyanaiAnsyuInfoOutputBean getIwssnSyanaiAnsyuInfoOutputBean() {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {


            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym1("201601");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym2("201602");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunanjoannaiym3("201603");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym1("201604");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym2("201605");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijytym3("201606");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn1("1");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn2("2");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbn3("3");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm1("案内中");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm2("入金");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynanjoannaijokbnnm3("未入");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynannaijytkaisuuy("11");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHijynannaijytkaisuum("12");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaigk("11000");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnTeikiikkatubaraijkkbn("1");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkaisuukbn("1");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkaisuukbnnm("一時払い");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkeirokbnnm("口座振替扱い");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattairiyuukbn("1");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattairiyuukbnnm("払変希望");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjkouzano("123456789");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjkzmeigikn("ユケイメイ　ニコ");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjbanknm("預振情報銀行名称");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjsitennm("預振情報支店名称");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjyokinkbnnm("普通");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjbankcd("1004");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjsitencd("105");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYfrjyokinkbn("1");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnDattaisyoriymd("20170505");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnDtjcomment("脱退情報コメント");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaiym("201607");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunannaijyutouym("201608");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHeijyunjkipjytym("201611");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnTikiktbrjkkbnnm("定期一括なし");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkkeirokbn("1");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkp("26000");

            iwssnSyanaiAnsyuInfoOutputBean.setIwssnCreyuukoukakkekka("2");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnCreyuukoukakkekkakbnnm("有効確認ＮＧ");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnCredityuukoukakym("20200327");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn1("1");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn2("8");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbn3("5");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm1("限度額超過");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm2("緊急停止");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnUragngjiyuukbnnm3("有効期限エラー");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnHrkptuukasyu("DOLLAR");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYenkansanp("300000");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYenkansanptuukasyu("YEN");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnKktikwsrate("0.0234");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnKnsnkijyunymd("20200331");
            iwssnSyanaiAnsyuInfoOutputBean.setIwssnYykknmnryymd("20200401");

            return iwssnSyanaiAnsyuInfoOutputBean;
        }

        return super.getIwssnSyanaiAnsyuInfoOutputBean();
    }
}