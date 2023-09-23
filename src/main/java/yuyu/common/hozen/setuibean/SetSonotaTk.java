package yuyu.common.hozen.setuibean;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanTeikishrkin;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Joiner;

/**
 * 契約保全 UiBean設定 その他特約特則設定
 */
public class SetSonotaTk {

    private static final String BLANK = "";

    public static boolean exec(KhozenCommonParam pKhCParm, SetSonotaTkExecUiBeanParam pUiBean) {

        String syoNo = pUiBean.getSyono();

        IT_KykSonotaTkyk kykSonotaTkyk = pKhCParm.getSonotaTokuyaku(syoNo);
        ArrayList<String> tkLst = new ArrayList<>();

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {
            tkLst.add(IKhozenCommonConstants.TOKUYAKUNM_HOKENKYKDRTKYK);
        }

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {
            tkLst.add(IKhozenCommonConstants.TOKUYAKUNM_SITEIDAIRISEIKYUU);
        }

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getYennykntkhkumu())) {
            tkLst.add(kykSonotaTkyk.getYennyknsyuruikbn().getContent());
        }

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getGaikanykntkhkumu())) {
            tkLst.add(IKhozenCommonConstants.TOKUYAKUNM_GAIKANYUUKIN);
        }

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getTeikishrtkykhukaumu())) {

            List<IT_KykSyouhn> kykSyouhnLst = pKhCParm.getKeiyakuSyouhin(syoNo, C_SyutkKbn.SYU);

            KeisanTeikishrkin keisanTeikishrkin = SWAKInjector.getInstance(KeisanTeikishrkin.class);
            keisanTeikishrkin.exec(kykSyouhnLst.get(0).getKihons(), kykSyouhnLst.get(0).getTeikishrritu());

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            C_Tuukasyu kihonsTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(kykSyouhnLst.get(0).getKihons().getType());

            tkLst.add(IKhozenCommonConstants.TOKUYAKUNM_SITEITUUKANENKIN_TEIKISHR + "　（支払通貨： " +
                kykSonotaTkyk.getTeikishrkinshrtuukasyu().getContent() +
                "　　定期支払金額： " + keisanTeikishrkin.getTeikishrkin().toFormatString() + " " +
                kihonsTuukasyu.getContent()  + "）");
        }

        if (kykSonotaTkyk != null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu()) &&
            kykSonotaTkyk.getTargettkmokuhyouti() == 0) {

            if (C_TargetTkKbn.SYUUSIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                tkLst.add(kykSonotaTkyk.getTargettkkbn().getContent() + "　（基準金額： " +
                    kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + " 円" + "　　目標額割合： 指定なし）");

            } else if (C_TargetTkKbn.NENKIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                tkLst.add(kykSonotaTkyk.getTargettkkbn().getContent() + "　（円建基準金額： " +
                    kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + " 円" + "　　目標額割合： 指定なし）");
            }

        } else if (kykSonotaTkyk != null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu()) &&
            kykSonotaTkyk.getTargettkmokuhyouti() != 0) {

            if (C_TargetTkKbn.SYUUSIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                tkLst.add(kykSonotaTkyk.getTargettkkbn().getContent() + "　（基準金額： " +
                    kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + " 円" + "　　目標額割合： " +
                    kykSonotaTkyk.getTargettkmokuhyouti() + " ％）");

            } else if (C_TargetTkKbn.NENKIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                tkLst.add(kykSonotaTkyk.getTargettkkbn().getContent() + "　（円建基準金額： " +
                    kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + " 円" + "　　目標額割合： " +
                    kykSonotaTkyk.getTargettkmokuhyouti() + " ％）");
            }
        }

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {

            tkLst.add(IKhozenCommonConstants.TOKUYAKUNM_INITSBJIYENSHRGKSITIHSYUTK + "　（基準金額： " +
                kykSonotaTkyk.getInitsbjiyenkasaiteihsygk().toFormatString() + " 円）");
        }

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu())) {
            tkLst.add(IKhozenCommonConstants.TOKUYAKUNM_JYUUDOKAIGOMAEBARAI);
        }

        if (kykSonotaTkyk!= null && C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {
            tkLst.add(IKhozenCommonConstants.TOKUYAKUNM_ZEISEITEKIKAKU);
        }

        int size = tkLst.size();
        if (size == 0) {
            pUiBean.setVsntkdisptkhukainfo(BLANK);
        }

        String disptkhukainfo = Joiner.on("<br/>").join(tkLst.toArray(new String[tkLst.size()]));
        pUiBean.setVsntkdisptkhukainfo(disptkhukainfo);

        return true;
    }

    public static void init(SetSonotaTkExecUiBeanParam pUiBean) {
        pUiBean.setVsntkdisptkhukainfo(BLANK);
    }
}

