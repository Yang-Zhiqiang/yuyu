package yuyu.common.sinkeiyaku.moschk;

import java.math.RoundingMode;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Taihntmdr;

/**
 * 新契約 申込内容チェック 体格判定
 */
public class HanteiTaikaku {

    private static final BizNumber HEIGHT_KEISUU = BizNumber.valueOf(100);

    public HanteiTaikaku() {
        super();
    }

    public static C_Taihntmdr hantei(int pHeight, int pWeight){

        if ((pHeight == 0) || (pWeight == 0)) {
            return C_Taihntmdr.CHK_NONE;
        }

        BizNumber hantei  = null;
        BizNumber height  = BizNumber.valueOf(pHeight);
        BizNumber weight  = BizNumber.valueOf(pWeight);
        BizNumber height2 = null;

        height = height.divide(HEIGHT_KEISUU, 2, RoundingMode.DOWN);

        height2 = height.multiply(height);
        hantei = weight.divide(height2, 1, RoundingMode.DOWN);

        BizNumber hanteiMin = null;
        BizNumber hanteiMax = null;

        hanteiMin = YuyuBizConfig.getInstance().getTaiHyoujyunMin();
        hanteiMax = YuyuBizConfig.getInstance().getTaiHyoujyunMax();

        if (hantei.compareTo(hanteiMin) < 0) {
            return C_Taihntmdr.KAKEI;
        }
        else if (hantei.compareTo(hanteiMax) >= 0) {
            return C_Taihntmdr.KAJYUU;
        }
        else {
            return C_Taihntmdr.NORMAL;
        }
    }
}
