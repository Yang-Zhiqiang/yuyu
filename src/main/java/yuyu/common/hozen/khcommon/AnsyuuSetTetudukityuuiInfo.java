package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 案内収納用注意情報設定
 */
public class AnsyuuSetTetudukityuuiInfo {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public AnsyuuSetTetudukityuuiInfo() {
        super();
    }

    public C_KktyuitaKbn exec(String pSyono) {

        logger.debug("▽ 案内収納用注意情報設定 開始");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        C_KktyuitaKbn kktyuitaKbn = khTtdkTyuui.getKktyuitakbn();

        logger.debug("△ 案内収納用注意情報設定 終了");

        return kktyuitaKbn;
    }

    public AnsyuuSetTetudukityuuiInfoBean getAnsyuuSetTetudukityuuiInfo(String pSyono) {

        logger.debug("▽ 案内収納用注意情報設定 開始");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        AnsyuuSetTetudukityuuiInfoBean ansyuuSetTetudukityuuiInfoBean = new AnsyuuSetTetudukityuuiInfoBean();

        ansyuuSetTetudukityuuiInfoBean.setKktyuitaKbn(khTtdkTyuui.getKktyuitakbn());

        ansyuuSetTetudukityuuiInfoBean.setKykdrknhatudoujyoutaiKbn(khTtdkTyuui.getKykdrknhatudoujyoutai());

        logger.debug("△ 案内収納用注意情報設定 終了");

        return ansyuuSetTetudukityuuiInfoBean;
    }
}