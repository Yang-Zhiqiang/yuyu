package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebServiceTest_exec;
import yuyu.common.direct.renkei.DsGetSyanaiWebKeiyakuInfo;
import yuyu.def.biz.bean.webservice.IwssnSyanaiDsInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;

/**
 * {@link DsGetSyanaiWebKeiyakuInfo}のモッククラスです。<br />
 */
public class DsGetSyanaiWebKeiyakuInfoMockForBiz extends DsGetSyanaiWebKeiyakuInfo{
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    private IwssnSyanaiDsInfoOutputBean iwssnSyanaiDsInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiDsInfoOutputBean.class);

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
                return C_IwssnKykSyoukaiKekkaKbn.DSKANRENKOUMOKU_ERROR;
            }

        }

        return super.exec(pSyono);
    }

    @Override
    public IwssnSyanaiDsInfoOutputBean getIwssnSyanaiDsInfoOutputBean() {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {
            iwssnSyanaiDsInfoOutputBean.setIwssnDsokyksmno("1023456789");
            iwssnSyanaiDsInfoOutputBean.setIwssnDsmailaddress("ＤＳメールアドレス");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskokyakujtkbn("1");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskokyakujtkbnnm("有効取引中");
            iwssnSyanaiDsInfoOutputBean.setIwssnKaripasswordhkymd("20200605");
            iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkkahikbn("1");
            iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkahikbnnm("可");
            iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkhukariyuukbn("01");
            iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkhukariyuukbnnm("稼動時間外");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskouzano("120123456789");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskzmeigii("ＤＳ口座名義人");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskinyunm("ＤＳ金融機関名");
            iwssnSyanaiDsInfoOutputBean.setIwssnSitennm("ＤＳ支店名");
            iwssnSyanaiDsInfoOutputBean.setIwssnDsyokinkbnnm("当座");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskzsyuruikbn("1");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskzsyuruikbnnm("円口座");
            iwssnSyanaiDsInfoOutputBean.setIwssnDsbankcd("5005");
            iwssnSyanaiDsInfoOutputBean.setIwssnDssitencd("505");
            iwssnSyanaiDsInfoOutputBean.setIwssnDsyokinkbn("2");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskzdoukbn("1");
            iwssnSyanaiDsInfoOutputBean.setIwssnDskzdoukbnnm("同一");
            iwssnSyanaiDsInfoOutputBean.setIwssnKaripasswordykymd("20200401");

            return iwssnSyanaiDsInfoOutputBean;
        }

        return super.getIwssnSyanaiDsInfoOutputBean();
    }
}
