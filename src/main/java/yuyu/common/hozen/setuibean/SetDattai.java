package yuyu.common.hozen.setuibean;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_DattaiUktk;

/**
 * 契約保全 UiBean設定 脱退情報設定
 */
public class SetDattai {

    public static boolean exec(KhozenCommonParam pKhCParm, SetDattaiExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        IT_DattaiUktk dattaiUktk = pKhCParm.getDattaiUktk(syoNo);

        if (dattaiUktk != null) {
            pUiBean.setVdtumukbn(C_UmuKbn.ARI);
            pUiBean.setVdtdattaisyoriymd(dattaiUktk.getSyoriYmd());
            pUiBean.setVdtdattairiyuukbn(dattaiUktk.getDattairiyuukbn());
            pUiBean.setVdtcomment(dattaiUktk.getComment124keta());
        }

        return true;
    }

    public static void init (SetDattaiExecUiBeanParam pUiBean) {
        pUiBean.setVdtumukbn(C_UmuKbn.NONE);
        pUiBean.setVdtdattaisyoriymd(null);
        pUiBean.setVdtdattairiyuukbn(C_DattairiyuuKbn.BLNK);
        pUiBean.setVdtcomment("");
    }
}
