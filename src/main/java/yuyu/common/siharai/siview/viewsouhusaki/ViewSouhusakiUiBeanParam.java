package yuyu.common.siharai.siview.viewsouhusaki;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.def.classification.C_SouhusakiKbn;

/**
 * 保険金給付金支払 支払画面部品 送付先情報表示 <br />
 */
public interface ViewSouhusakiUiBeanParam extends CommonViewUiBeanParam{

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

    public boolean isViewSouhusakiInputDispFlg();

    public boolean isViewSouhusakiSeigyo();

    public boolean isViewSouhusakiDispFlg();
}
