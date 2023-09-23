package yuyu.common.siharai.siview.viewkingakuinfo;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 金額情報表示 <br />
 */
public interface ViewKingakuInfoUiBeanParam extends CommonViewUiBeanParam{

    public BizCurrency getHokenryoustgk();

    public void setHokenryoustgk(BizCurrency pHokenryoustgk);

    public BizCurrency getYenhokenryoustgk();

    public void setYenhokenryoustgk(BizCurrency pYenhokenryoustgk);

    public BizCurrency getTutakngk();

    public void setTutakngk(BizCurrency pTutakngk);

    public BizCurrency getYentutakngk();

    public void setYentutakngk(BizCurrency pYentutakngk);

    public BizCurrency getKaiyakuhr();

    public void setKaiyakuhr(BizCurrency pKaiyakuhr);

    public BizCurrency getYenkaiyakuhr();

    public void setYenkaiyakuhr(BizCurrency pYenkaiyakuhr);

    public BizCurrency getKihonhokenkngk();

    public void setKihonhokenkngk(BizCurrency pKihonhokenkngk);

    public BizCurrency getYenkihonhokenkngk();

    public void setYenkihonhokenkngk(BizCurrency pYenkihonhokenkngk);

    public BizCurrency getSaigais();

    public void setSaigais(BizCurrency pSaigais);

    public BizCurrency getYensaigais();

    public void setYensaigais(BizCurrency pYensaigais);

    public boolean isViewKingakuInfoSeigyo();

    public boolean isViewKingakuInfoDispFlg();

    public boolean isViewKingakuInfoHokenryouStgkDispFlg();

    public boolean isViewKingakuInfoTutaKngkDispFlg();

    public boolean isViewKingakuInfoKaiyakuHrDispFlg();

    public boolean isViewKingakuInfoKihonHokenKngkDispFlg();

    public boolean isViewKingakuInfoSaigaiSDispFlg();
}
