package yuyu.common.siharai.sicommon;

import yuyu.common.siharai.edittbl.EditSateiRrkTblParam;
import yuyu.common.siharai.edittbl.SiSyoriKekkaParam;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定承認履歴TBL編集パラメータ（処理結果Param）実現クラス
 */
public class EditSateiRrkTblParamKekkaImpl implements EditSateiRrkTblParam, SiSyoriKekkaParam {

    private C_SyorikekkaKbn syorikekkakbn;

    private String tennousakisousasyacd;

    @Override
    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    @Override
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {
        tennousakisousasyacd = pTennousakisousasyacd;
    }

    @Override
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    @Override
    public String getTennousakisousasyacd() {
        return tennousakisousasyacd;
    }
}
