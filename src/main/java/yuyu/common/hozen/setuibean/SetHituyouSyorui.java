package yuyu.common.hozen.setuibean;

import java.util.List;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenCommonParamGetHituyouSyoruiUiBeanParam;
import yuyu.def.db.entity.IM_KhHituyouSyorui;

import com.google.common.base.Joiner;

/**
 * 契約保全 UiBean設定 必要書類設定
 */
public class SetHituyouSyorui {

    public static boolean exec(KhozenCommonParam pKhCParm, SetHituyouSyoruiExecUiBeanParam pUiBean) {

        List<IM_KhHituyouSyorui> khHituyouSyoruiLst = pKhCParm.getHituyouSyorui((KhozenCommonParamGetHituyouSyoruiUiBeanParam)pUiBean);

        String htySyoruiMsg = "";

        if (khHituyouSyoruiLst != null) {
            String[] htySyoruiMsgs = new String[khHituyouSyoruiLst.size()];

            for (int index = 0; index < khHituyouSyoruiLst.size(); index++) {
                htySyoruiMsgs[index] = khHituyouSyoruiLst.get(index).getHtysyorui();
            }

            htySyoruiMsg = Joiner.on("<br/>").join(htySyoruiMsgs);
        }

        pUiBean.setVhtysdisphtysyorui(htySyoruiMsg);

        return true;
    }

    public static void init(SetHituyouSyoruiExecUiBeanParam pUiBean) {
        pUiBean.setVhtysdisphtysyorui("");
    }
}
