package yuyu.common.biz.koutei;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * {@link GetProgressHistory}のモッククラスです。<br />
 */
public class GetProgressHistoryMockForBiz extends GetProgressHistory{

    public static Class<?> caller = null;

    @Override
    public List<GetProgressHistoryOutBean> exec(String kouteiKanriId){

        List<GetProgressHistoryOutBean> getProgressHistoryOutBeanLst = new ArrayList<>();
        if(caller ==SetProgressHistoryTest_exec.class){

            if ("ParProgressId".equals(kouteiKanriId)) {

                GetProgressHistoryOutBean getProgressHistoryOutBean = SWAKInjector.getInstance(GetProgressHistoryOutBean.class);
                getProgressHistoryOutBean.setSyoriTime("201602011220");
                getProgressHistoryOutBean.setTaskName("TASK名0");
                getProgressHistoryOutBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU);
                getProgressHistoryOutBean.setTantousyaName("User0");
                getProgressHistoryOutBean.setComment("コメント０");

                getProgressHistoryOutBeanLst.add(getProgressHistoryOutBean);

                return  getProgressHistoryOutBeanLst;
            }
            else if ("ParProgressId2".equals(kouteiKanriId)) {

                GetProgressHistoryOutBean getProgressHistoryOutBean = SWAKInjector.getInstance(GetProgressHistoryOutBean.class);
                getProgressHistoryOutBean.setSyoriTime("201602031220");
                getProgressHistoryOutBean.setTaskName("TASK名0");
                getProgressHistoryOutBean.setSyorikekkaKbn(C_SyorikekkaKbn.TENSOU);
                getProgressHistoryOutBean.setTantousyaName("User0");
                getProgressHistoryOutBean.setComment("コメント０");
                getProgressHistoryOutBeanLst.add(getProgressHistoryOutBean);

                GetProgressHistoryOutBean getProgressHistoryOutBean2 = SWAKInjector.getInstance(GetProgressHistoryOutBean.class);
                getProgressHistoryOutBean2.setSyoriTime("201602021220");
                getProgressHistoryOutBean2.setTaskName("TASK名1");
                getProgressHistoryOutBean2.setSyorikekkaKbn(C_SyorikekkaKbn.HORYUU);
                getProgressHistoryOutBean2.setTantousyaName("User1");
                getProgressHistoryOutBean2.setComment("コメント１");
                getProgressHistoryOutBeanLst.add(getProgressHistoryOutBean2);

                GetProgressHistoryOutBean getProgressHistoryOutBean3 = SWAKInjector.getInstance(GetProgressHistoryOutBean.class);
                getProgressHistoryOutBean3.setSyoriTime("201602011220");
                getProgressHistoryOutBean3.setTaskName("TASK名2");
                getProgressHistoryOutBean3.setSyorikekkaKbn(C_SyorikekkaKbn.SASIMODOSI);
                getProgressHistoryOutBean3.setTantousyaName("User2");
                getProgressHistoryOutBean3.setComment("コメント２");
                getProgressHistoryOutBeanLst.add(getProgressHistoryOutBean3);

                return  getProgressHistoryOutBeanLst;
            }
        }

        return  super.exec(kouteiKanriId);

    }
}
