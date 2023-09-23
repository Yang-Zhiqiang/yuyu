package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SyorikekkaKbn;


/**
 * 保険金給付金支払 保険金給付金支払共通 処理結果Paramインターフェース実現クラス
 */
public class SiSyoriKekkaParamImpl implements SiSyoriKekkaParam {

    private C_SyorikekkaKbn syorikekkakbn;

    private String tennousakisousasyacd;

    @Override
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    @Override
    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    @Override
    public String getTennousakisousasyacd() {
        return tennousakisousasyacd;
    }

    @Override
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {
        tennousakisousasyacd = pTennousakisousasyacd;
    }

}
