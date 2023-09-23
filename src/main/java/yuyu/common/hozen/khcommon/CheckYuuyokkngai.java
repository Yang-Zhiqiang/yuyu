package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 猶予期間外チェック
 */
public class CheckYuuyokkngai {

    @Inject
    private SetYuuyokknmanryobi setYuuyokknmanryobi;

    @Inject
    private HozenDomManager hozenDomManager;

    public CheckYuuyokkngai() {
        super();
    }

    public boolean exec(String pSyono, BizDate pDate) {

        String syoNo = pSyono;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {

            return true;
        }

        if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhnLst.get(0).getYuukousyoumetukbn())
            && (C_Kykjyoutai.HRKMTYUU.eq(kykSyouhnLst.get(0).getKykjyoutai())
                || C_Kykjyoutai.IKKATUNK.eq(kykSyouhnLst.get(0).getKykjyoutai()))) {

            IT_AnsyuKihon ansyuuKihon = hozenDomManager.getAnsyuKihon(pSyono);

            setYuuyokknmanryobi.exec(syoNo, ansyuuKihon.getJkipjytym());

            if (BizDateUtil.compareYmd(
                setYuuyokknmanryobi.getTksnYuuyokknMnrybi(), pDate) == BizDateUtil.COMPARE_LESSER) {

                return false;
            }

            return true;
        }

        return true;
    }
}