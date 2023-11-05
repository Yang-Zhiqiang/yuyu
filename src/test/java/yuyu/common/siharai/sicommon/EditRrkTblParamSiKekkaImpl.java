package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditRrkTblParam;
import yuyu.common.siharai.edittbl.SiKekkaInputParam;

/**
 * 保険金給付金支払 保険金給付金支払共通 手続履歴TBL編集パラメータ（結果入力Param）実現クラス
 */
public class EditRrkTblParamSiKekkaImpl implements EditRrkTblParam, SiKekkaInputParam {

    private String syanaicomment;

    @Override
    public void setSyanaicomment(String pSyanaicomment) {
        this.syanaicomment = pSyanaicomment;
    }

    @Override
    public String getSyanaicomment() {
        return syanaicomment;
    }

}
