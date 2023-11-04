package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link GetSyoriKokouteiInfo}のモッククラスです。<br />
 */
public class GetSyoriKokouteiInfoMock extends GetSyoriKokouteiInfo {

    public static final String TESTPATTERN1 = "02-01";

    public static final String TESTPATTERN2 = "02-02";

    public static final String TESTPATTERN3 = "32-01";

    public static final String TESTPATTERN4 = "32-02";

    public static final String TESTPATTERN5 = "32-03";

    public static final String TESTPATTERN6 = "01-01";

    public static final String TESTPATTERN7 = "27-01";

    public static final String TESTPATTERN8 = "27-02";

    public static final String TESTPATTERN9 = "27-03";

    public static String mode = null;

    public static String caller = null;
    @Override
    public List<GetSyoriKokouteiInfoOutBean> exec(String pKouteiKanriId, String pJimutetuzukiCd) {

        List<GetSyoriKokouteiInfoOutBean> getSyoriKokouteiInfoOutBeanList = new ArrayList<>();

        if ("Test".equals(caller)) {

            if (TESTPATTERN1.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean.setSyoriKokouteikanriId("hijklmn");
                getSyoriKokouteiInfoOutBean.setSyoriKokouteiJimutetuzukiCd("hzn");
                getSyoriKokouteiInfoOutBean.setDouJimutetuzukicdUmuKbn(C_UmuKbn.ARI);
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean);

                return getSyoriKokouteiInfoOutBeanList;
            }
            else if (TESTPATTERN2.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean1 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean1.setSyoriKokouteikanriId("hijklmn1");
                getSyoriKokouteiInfoOutBean1.setSyoriKokouteiJimutetuzukiCd("hzn1");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean1);

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean2 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean2.setSyoriKokouteikanriId("hijklmn2");
                getSyoriKokouteiInfoOutBean2.setSyoriKokouteiJimutetuzukiCd("hzn2");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);

                return getSyoriKokouteiInfoOutBeanList;
            }
            else if (TESTPATTERN3.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean1 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean2 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                if ("hijklmn1".equals(pKouteiKanriId)) {

                    getSyoriKokouteiInfoOutBean1.setSyoriKokouteikanriId("hijklmn1");
                    getSyoriKokouteiInfoOutBean1.setSyoriKokouteiJimutetuzukiCd("hzn1");

                    getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean1);

                } else {

                    getSyoriKokouteiInfoOutBean2.setSyoriKokouteikanriId("hijklmn2");
                    getSyoriKokouteiInfoOutBean2.setSyoriKokouteiJimutetuzukiCd("hzn2");

                    getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);
                }

                return getSyoriKokouteiInfoOutBeanList;
            }
            else if (TESTPATTERN4.equals(mode)) {
                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean1 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean1.setSyoriKokouteikanriId("hijklmn1");
                getSyoriKokouteiInfoOutBean1.setSyoriKokouteiJimutetuzukiCd("hzn1");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean1);

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean2 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean2.setSyoriKokouteikanriId("hijklmn2");
                getSyoriKokouteiInfoOutBean2.setSyoriKokouteiJimutetuzukiCd("hzn2");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean3 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean3.setSyoriKokouteikanriId("hijklmn3");
                getSyoriKokouteiInfoOutBean3.setSyoriKokouteiJimutetuzukiCd("hzn3");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);

                return getSyoriKokouteiInfoOutBeanList;
            }
            else if (TESTPATTERN6.equals(mode)) {

                return getSyoriKokouteiInfoOutBeanList;
            }

            else if (TESTPATTERN7.equals(mode)) {
                return getSyoriKokouteiInfoOutBeanList;
            }
            else if (TESTPATTERN8.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean.setSyoriKokouteikanriId("101");
                getSyoriKokouteiInfoOutBean.setSyoriKokouteiJimutetuzukiCd("1002");
                getSyoriKokouteiInfoOutBean.setDouJimutetuzukicdUmuKbn(C_UmuKbn.ARI);
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean);

                return getSyoriKokouteiInfoOutBeanList;
            }
            else if (TESTPATTERN9.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean1 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean1.setSyoriKokouteikanriId("hijklmn1");
                getSyoriKokouteiInfoOutBean1.setSyoriKokouteiJimutetuzukiCd("hzn1");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean1);

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean2 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean2.setSyoriKokouteikanriId("hijklmn2");
                getSyoriKokouteiInfoOutBean2.setSyoriKokouteiJimutetuzukiCd("hzn2");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean3 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean3.setSyoriKokouteikanriId("hijklmn3");
                getSyoriKokouteiInfoOutBean3.setSyoriKokouteiJimutetuzukiCd("hzn3");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);

                return getSyoriKokouteiInfoOutBeanList;
            }

        }
        else if ("Test01".equals(caller)) {

            if (TESTPATTERN1.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                getSyoriKokouteiInfoOutBean.setDouJimutetuzukicdUmuKbn(C_UmuKbn.ARI);
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean);

            }
            else if (TESTPATTERN2.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                getSyoriKokouteiInfoOutBean.setDouJimutetuzukicdUmuKbn(C_UmuKbn.NONE);
                getSyoriKokouteiInfoOutBean.setSyoriKokouteikanriId("10000000002");
                getSyoriKokouteiInfoOutBean.setSyoriKokouteiJimutetuzukiCd("002");
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean);

            }
            else if (TESTPATTERN3.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean1 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean2 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean3 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                getSyoriKokouteiInfoOutBean1.setDouJimutetuzukicdUmuKbn(C_UmuKbn.NONE);
                getSyoriKokouteiInfoOutBean1.setSyoriKokouteikanriId("10000000002");
                getSyoriKokouteiInfoOutBean1.setSyoriKokouteiJimutetuzukiCd("002");
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean1);
                getSyoriKokouteiInfoOutBean2.setDouJimutetuzukicdUmuKbn(C_UmuKbn.NONE);
                getSyoriKokouteiInfoOutBean2.setSyoriKokouteikanriId("10000000003");
                getSyoriKokouteiInfoOutBean2.setSyoriKokouteiJimutetuzukiCd("003");
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);
                getSyoriKokouteiInfoOutBean3.setDouJimutetuzukicdUmuKbn(C_UmuKbn.NONE);
                getSyoriKokouteiInfoOutBean3.setSyoriKokouteikanriId("10000000004");
                getSyoriKokouteiInfoOutBean3.setSyoriKokouteiJimutetuzukiCd("004");
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean3);

            }
        }

        else if ("BzLockProcessTest_exec".equals(caller)) {

            if (TESTPATTERN1.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                getSyoriKokouteiInfoOutBean.setDouJimutetuzukicdUmuKbn(C_UmuKbn.ARI);
                getSyoriKokouteiInfoOutBean.setSyoriKokouteikanriId("10000000001");
                getSyoriKokouteiInfoOutBean.setSyoriKokouteiJimutetuzukiCd("001");
                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean);

            }
            else if (TESTPATTERN2.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean1 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean1.setSyoriKokouteikanriId("10000000001");
                getSyoriKokouteiInfoOutBean1.setSyoriKokouteiJimutetuzukiCd("001");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean1);

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean2 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                getSyoriKokouteiInfoOutBean2.setSyoriKokouteikanriId("10000000002");
                getSyoriKokouteiInfoOutBean2.setSyoriKokouteiJimutetuzukiCd("002");

                getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);

                return getSyoriKokouteiInfoOutBeanList;

            }
            else if (TESTPATTERN3.equals(mode)) {

                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean1 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);
                GetSyoriKokouteiInfoOutBean getSyoriKokouteiInfoOutBean2 = SWAKInjector.getInstance(GetSyoriKokouteiInfoOutBean.class);

                if ("10000000001".equals(pKouteiKanriId)) {

                    getSyoriKokouteiInfoOutBean1.setSyoriKokouteikanriId("10000000001");
                    getSyoriKokouteiInfoOutBean1.setSyoriKokouteiJimutetuzukiCd("001");

                    getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean1);

                } else {

                    getSyoriKokouteiInfoOutBean2.setSyoriKokouteikanriId("10000000002");
                    getSyoriKokouteiInfoOutBean2.setSyoriKokouteiJimutetuzukiCd("002");

                    getSyoriKokouteiInfoOutBeanList.add(getSyoriKokouteiInfoOutBean2);
                }

                return getSyoriKokouteiInfoOutBeanList;
            }

        }

        else {

            getSyoriKokouteiInfoOutBeanList = super.exec(pKouteiKanriId, pJimutetuzukiCd);
        }

        return getSyoriKokouteiInfoOutBeanList;
    }
}