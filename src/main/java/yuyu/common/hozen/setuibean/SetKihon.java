package yuyu.common.hozen.setuibean;

import java.util.List;

import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 UiBean設定 基本情報設定
 */
public class SetKihon {

    public static boolean exec(KhozenCommonParam pKhCParm, SetKihonExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();
        IT_KykKihon kykKihon = pKhCParm.getKeiyakuKihon(syoNo);
        List<IT_KykSyouhn> kykSyouhnLst = pKhCParm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);

        if (kykSyouhnLst == null || kykSyouhnLst.size() != 1) {
            return false;
        }

        pUiBean.setVkihnsyono(kykKihon.getSyono());
        pUiBean.setVkihnlastsyosaihkymd(kykKihon.getLastsyosaihkymd());
        pUiBean.setVkihnyuukousyoumetukbn(kykSyouhnLst.get(0).getYuukousyoumetukbn());
        pUiBean.setVkihnkykjyoutai(kykSyouhnLst.get(0).getKykjyoutai());
        pUiBean.setVkihnsyoumetujiyuu(kykSyouhnLst.get(0).getSyoumetujiyuu());
        pUiBean.setVkihnsyoumetuymd(kykSyouhnLst.get(0).getSyoumetuymd());

        return true;
    }

    public static void init(SetKihonExecUiBeanParam pUiBean) {
        pUiBean.setVkihnsyono("");
        pUiBean.setVkihnlastsyosaihkymd(null);
        pUiBean.setVkihnyuukousyoumetukbn(C_YuukousyoumetuKbn.BLNK);
        pUiBean.setVkihnkykjyoutai(C_Kykjyoutai.BLNK);
        pUiBean.setVkihnsyoumetujiyuu(C_Syoumetujiyuu.BLNK);
        pUiBean.setVkihnsyoumetuymd(null);

    }
}
