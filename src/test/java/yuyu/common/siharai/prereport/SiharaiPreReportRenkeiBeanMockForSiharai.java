package yuyu.common.siharai.prereport;

import java.util.HashMap;
import java.util.Map;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.siharai.koutei.SiHituyousyoruiHanteiInBean;

/**
 * {@link KiteiCheckParam}のモッククラスです。<br />
 */
public class SiharaiPreReportRenkeiBeanMockForSiharai extends SiharaiPreReportRenkeiBean {

    private static final long serialVersionUID = -149489001710542596L;

    public static Class<?> caller = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static String SYORIPTN = null;

    public SiharaiPreReportRenkeiBeanMockForSiharai() {
        super();
    }

    @Override
    public Map<String, String> getSakuseizumiKouteikanriIdMp() {
        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller) {
            if (SYORIPTN == TESTPATTERN1) {
                Map<String, String> map = new HashMap<>();
                map.put("tesuto", "");
                return map;
            } else if (SYORIPTN == TESTPATTERN2) {
                Map<String, String> map = new HashMap<>();
                map.put("tesuto", null);
                return map;
            } else if (SYORIPTN == TESTPATTERN6) {
                Map<String, String> map = new HashMap<>();
                map.put("tesuto", "123");
                return map;
            }
        }
        return super.getSakuseizumiKouteikanriIdMp();

    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {

        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller) {
            if (SYORIPTN == TESTPATTERN1) {
                BzWorkflowInfo bzWorkflowInfo = new BzWorkflowInfo();
                bzWorkflowInfo.setOyaKouteiKanriId("");
                bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("100");
                return bzWorkflowInfo;
            }
            else if (SYORIPTN == TESTPATTERN2) {
                BzWorkflowInfo bzWorkflowInfo = new BzWorkflowInfo();
                bzWorkflowInfo.setOyaKouteiKanriId(null);
                bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("100");
                return bzWorkflowInfo;
            }
            else if (SYORIPTN == TESTPATTERN3) {
                BzWorkflowInfo bzWorkflowInfo = new BzWorkflowInfo();
                bzWorkflowInfo.setOyaKouteiKanriId("100");
                bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("");
                return bzWorkflowInfo;
            }
            else if (SYORIPTN == TESTPATTERN4) {
                BzWorkflowInfo bzWorkflowInfo = new BzWorkflowInfo();
                bzWorkflowInfo.setOyaKouteiKanriId("100");
                bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);
                return bzWorkflowInfo;
            }
            else if (SYORIPTN == TESTPATTERN5) {
                BzWorkflowInfo bzWorkflowInfo = new BzWorkflowInfo();
                bzWorkflowInfo.setOyaKouteiKanriId("100");
                bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd("101");
                return bzWorkflowInfo;
            }
            else if (SYORIPTN == TESTPATTERN7) {
                BzWorkflowInfo bzWorkflowInfo = new BzWorkflowInfo();
                bzWorkflowInfo.setOyaKouteiKanriId("");
                bzWorkflowInfo.setOyaKouteiJimuTetuzukiCd(null);
                return bzWorkflowInfo;
            }
        }

        return super.getBzWorkflowInfo();
    }

    @Override
    public String getSkNo() {
        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller) {
            return "123";
        }
        return super.getSkNo();
    }

    @Override
    public Map<String, SiHituyousyoruiHanteiInBean> getSiHituyousyoruiHanteiInBeanMp() {
        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller) {
            SiHituyousyoruiHanteiInBean SiHituyousyoruiHanteiInBean = SWAKInjector
                .getInstance(SiHituyousyoruiHanteiInBean.class);
            Map<String, SiHituyousyoruiHanteiInBean> map = new HashMap<>();
            map.put("tesuto", SiHituyousyoruiHanteiInBean);
            return map;
        }
        return super.getSiHituyousyoruiHanteiInBeanMp();
    }

    @Override
    public String getSyoriComment() {
        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller) {
            return "exec";
        }
        return super.getSyoriComment();
    }

    @Override
    public String getTaskNm() {
        if (SiharaiPreReportOperateProcessTest_operateProcess.class == caller) {
            return "SiharaiPreReportOperateProcess";
        }
        return super.getTaskNm();
    }

}
