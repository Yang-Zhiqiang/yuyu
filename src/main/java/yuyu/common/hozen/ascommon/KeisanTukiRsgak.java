package yuyu.common.hozen.ascommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_KykKihon;
/**
 * 契約保全 案内収納共通 月払領収金額計算
 */
public class KeisanTukiRsgak {

    private String errorRiyuu;

    private KeisanRsgkOutBean keisanRsgkOutBean;

    @Inject
    private static Logger logger;

    public String getErrorRiyuu() {
        return errorRiyuu;
    }

    public KeisanRsgkOutBean getKeisanRsgkOutBean() {
        return keisanRsgkOutBean;
    }

    public C_ErrorKbn exec(KeisanRsgakuBean pKeisanRsgakuBean) {


        return C_ErrorKbn.OK;
    }

    public C_ErrorKbn exec(IT_KykKihon pKykKihon, C_Nykkeiro pNykkeiro, C_NyknaiyouKbn pNyknaiyouKbn,
        BizDate pRsymd, BizDateYM pJyutoustartym, Integer pJyuutounensuu, Integer pJyuutoutukisuu) {


        return C_ErrorKbn.OK;
    }

}
