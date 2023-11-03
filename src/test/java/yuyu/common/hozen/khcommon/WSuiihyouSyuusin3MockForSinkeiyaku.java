package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_Suiihyou;

/**
 * {@link WSuiihyouSyuusin3}のモッククラスです。<br />
 */
public class WSuiihyouSyuusin3MockForSinkeiyaku extends WSuiihyouSyuusin3{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        List<IT_Suiihyou> suiihyouLst = new ArrayList<>();

        if (caller == HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class) {

            if (SYORIPTN == TESTPATTERN1 || SYORIPTN == TESTPATTERN2) {

                IT_Suiihyou suiihyou1 = new IT_Suiihyou();

                suiihyou1.setMvanonewsame(BizCurrency.valueOf(2000));
                suiihyou1.setZennouzndkyen1(BizCurrency.valueOf(3000));
                suiihyou1.setKihrkmpyen1(BizCurrency.valueOf(4000));
                suiihyou1.setHrkkknmnryumukbn(C_UmuKbn.NONE);
                suiihyouLst.add(suiihyou1);
                return suiihyouLst;
            }
            else if (SYORIPTN == TESTPATTERN3) {

                return suiihyouLst;
            }
            else if (SYORIPTN == TESTPATTERN4) {
                IT_Suiihyou suiihyou1 = new IT_Suiihyou();
                IT_Suiihyou suiihyou2 = new IT_Suiihyou();
                IT_Suiihyou suiihyou3 = new IT_Suiihyou();

                suiihyou1.setMvanonewsame(BizCurrency.valueOf(2000));
                suiihyou1.setZennouzndk1(BizCurrency.valueOf(3000));
                suiihyou1.setKihrkmp1(BizCurrency.valueOf(4000));
                suiihyou1.setHrkkknmnryumukbn(C_UmuKbn.ARI);
                suiihyou2.setMvanonewsame(BizCurrency.valueOf(2200));
                suiihyou2.setZennouzndk1(BizCurrency.valueOf(3300));
                suiihyou2.setKihrkmp1(BizCurrency.valueOf(4400));
                suiihyou2.setHrkkknmnryumukbn(C_UmuKbn.ARI);
                suiihyou3.setMvanonewsame(BizCurrency.valueOf(2220));
                suiihyou3.setZennouzndk1(BizCurrency.valueOf(3330));
                suiihyou3.setKihrkmp1(BizCurrency.valueOf(4440));
                suiihyou3.setHrkkknmnryumukbn(C_UmuKbn.ARI);
                suiihyouLst.add(suiihyou1);
                suiihyouLst.add(suiihyou2);
                suiihyouLst.add(suiihyou3);
                return suiihyouLst;
            }
            else if (SYORIPTN == TESTPATTERN5) {

                for (int i = 1; i < 100; i++) {

                    IT_Suiihyou suiihyou = new IT_Suiihyou();
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(100).add(BizCurrency.valueOf(i)));
                    suiihyou.setZennouzndkyen1(BizCurrency.valueOf(200).add(BizCurrency.valueOf(i)));
                    suiihyou.setKihrkmpyen1(BizCurrency.valueOf(300).add(BizCurrency.valueOf(i)));
                    suiihyou.setHrkkknmnryumukbn(C_UmuKbn.ARI);

                    suiihyouLst.add(suiihyou);
                }
                return suiihyouLst;
            }
            else if (SYORIPTN == TESTPATTERN6) {

                for (int i = 1; i < 101; i++) {

                    IT_Suiihyou suiihyou = new IT_Suiihyou();
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(100).add(BizCurrency.valueOf(i)));
                    suiihyou.setZennouzndk1(BizCurrency.valueOf(200).add(BizCurrency.valueOf(i)));
                    suiihyou.setKihrkmp1(BizCurrency.valueOf(300).add(BizCurrency.valueOf(i)));
                    suiihyou.setHrkkknmnryumukbn(C_UmuKbn.ARI);

                    suiihyouLst.add(suiihyou);
                }
                return suiihyouLst;
            }
            else if (SYORIPTN == TESTPATTERN7) {

                for (int i = 1; i < 100; i++) {

                    IT_Suiihyou suiihyou = new IT_Suiihyou();
                    suiihyou.setMvanonewsame(BizCurrency.valueOf(100).add(BizCurrency.valueOf(i)));
                    suiihyou.setZennouzndkyen1(BizCurrency.valueOf(200).add(BizCurrency.valueOf(i)));
                    suiihyou.setKihrkmpyen1(BizCurrency.valueOf(300).add(BizCurrency.valueOf(i)));
                    suiihyou.setHrkkknmnryumukbn(C_UmuKbn.NONE);

                    suiihyouLst.add(suiihyou);
                }
                return suiihyouLst;
            }
            return super.exec(pWSuiihyouParam);
        }
        return super.exec(pWSuiihyouParam);
    }

    @Override
    public List<SibouSBean> getSibouSBeanList() {

        List<SibouSBean> sibouSBeanList = new ArrayList<>();
        SibouSBean sibouSBean1 = SWAKInjector.getInstance(SibouSBean.class);

        if (caller == HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class) {

            if (SYORIPTN == TESTPATTERN1) {

                return null;
            }
            else if (SYORIPTN == TESTPATTERN2) {

                sibouSBean1.setSibouS(BizCurrency.valueOf(1000));
                sibouSBeanList.add(sibouSBean1);
                return sibouSBeanList;
            }
            else if (SYORIPTN == TESTPATTERN4) {

                SibouSBean sibouSBean2 = SWAKInjector.getInstance(SibouSBean.class);
                SibouSBean sibouSBean3 = SWAKInjector.getInstance(SibouSBean.class);

                sibouSBean1.setSibouS(BizCurrency.valueOf(1000));
                sibouSBean2.setSibouS(BizCurrency.valueOf(6000));
                sibouSBean3.setSibouS(BizCurrency.valueOf(7000));
                sibouSBeanList.add(sibouSBean1);
                sibouSBeanList.add(sibouSBean2);
                sibouSBeanList.add(sibouSBean3);
                return sibouSBeanList;
            }
            else if (SYORIPTN == TESTPATTERN5 || SYORIPTN == TESTPATTERN7) {

                for (int i = 1; i < 100; i++) {

                    SibouSBean sibouSBean = SWAKInjector.getInstance(SibouSBean.class);

                    sibouSBean.setSibouS(BizCurrency.valueOf(400).add(BizCurrency.valueOf(i)));
                    sibouSBeanList.add(sibouSBean);
                }
                return sibouSBeanList;
            }
            else if (SYORIPTN == TESTPATTERN6) {

                for (int i = 1; i < 101; i++) {

                    SibouSBean sibouSBean = SWAKInjector.getInstance(SibouSBean.class);

                    sibouSBean.setSibouS(BizCurrency.valueOf(400).add(BizCurrency.valueOf(i)));
                    sibouSBeanList.add(sibouSBean);
                }
                return sibouSBeanList;
            }
            return super.getSibouSBeanList();
        }
        return super.getSibouSBeanList();
    }
}
