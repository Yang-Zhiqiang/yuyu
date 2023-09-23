package yuyu.common.siharai.edittbl;

import yuyu.def.classification.C_SouhusakiKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 送付先情報Paramインターフェース
 */
public interface SiSouhusakiInfoParam {

    public C_SouhusakiKbn getSouhusakikbn();

    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn);

    public String getTsinyno();

    public void setTsinyno(String pTsinyno);

    public String getTsinadr1kj();

    public void setTsinadr1kj(String pTsinadr1kj);

    public String getTsinadr2kj();

    public void setTsinadr2kj(String pTsinadr2kj);

    public String getTsinadr3kj();

    public void setTsinadr3kj(String pTsinadr3kj);

    public String getTsintelno();

    public void setTsintelno(String pTsintelno);

}
