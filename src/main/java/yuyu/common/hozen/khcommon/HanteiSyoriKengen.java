package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 契約保全 契約保全共通 処理権限判定
 */
public class HanteiSyoriKengen {

    public HanteiSyoriKengen() {
        super();
    }

    @Inject
    private KinouMode kinouMode;

    @Inject
    private BaseUserInfo baseUserInfo;

    public void exec() {

        String kinMode = kinouMode.getKinouMode();

        if (kinMode == null || C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinMode)) {

            boolean inputKengenFlg = baseUserInfo.hasAuthenticatedFunctionMode(
                C_KhkinouModeIdKbn.INPUTKEY.getValue());

            if (inputKengenFlg) {

                kinouMode.setKinouMode(C_KhkinouModeIdKbn.INPUTKEY.getValue());
            }
            else {

                boolean syoukaiKengenFlg = baseUserInfo.hasAuthenticatedFunctionMode(
                    C_KhkinouModeIdKbn.SYOUKAI.getValue());

                if (syoukaiKengenFlg) {

                    kinouMode.setKinouMode(C_KhkinouModeIdKbn.SYOUKAI.getValue());
                }
                else {

                    throw new BizAppException(MessageId.EBS0003);

                }
            }
        }
    }
}
