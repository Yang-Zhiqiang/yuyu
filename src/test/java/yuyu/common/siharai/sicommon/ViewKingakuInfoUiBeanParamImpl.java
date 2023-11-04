package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.siharai.siview.viewkingakuinfo.ViewKingakuInfoUiBeanParam;

/**
 * 保険金給付金支払 支払画面部品 金額情報表示の実現クラス（テスト用）
 */
public class ViewKingakuInfoUiBeanParamImpl implements ViewKingakuInfoUiBeanParam {

    private BizCurrency hokenryoustgk;

    private BizCurrency yenhokenryoustgk;

    private BizCurrency tutakngk;

    private BizCurrency yentutakngk;

    private BizCurrency kaiyakuhr;

    private BizCurrency yenkaiyakuhr;

    private BizCurrency kihonhokenkngk;

    private BizCurrency yenkihonhokenkngk;

    private BizCurrency saigais;

    private BizCurrency yensaigais;

    private boolean viewKingakuInfoSeigyo;

    private boolean viewKingakuInfoDispFlg;

    @Override
    public BizCurrency getHokenryoustgk() {
        return hokenryoustgk;
    }

    @Override
    public void setHokenryoustgk(BizCurrency pHokenryoustgk) {
        hokenryoustgk = pHokenryoustgk;
    }

    @Override
    public BizCurrency getYenhokenryoustgk() {
        return yenhokenryoustgk;
    }

    @Override
    public void setYenhokenryoustgk(BizCurrency pYenhokenryoustgk) {
        yenhokenryoustgk = pYenhokenryoustgk;
    }

    @Override
    public BizCurrency getTutakngk() {
        return tutakngk;
    }

    @Override
    public void setTutakngk(BizCurrency pTutakngk) {
        tutakngk = pTutakngk;
    }

    @Override
    public BizCurrency getYentutakngk() {
        return yentutakngk;
    }

    @Override
    public void setYentutakngk(BizCurrency pYentutakngk) {
        yentutakngk = pYentutakngk;
    }

    @Override
    public BizCurrency getKaiyakuhr() {
        return kaiyakuhr;
    }

    @Override
    public void setKaiyakuhr(BizCurrency pKaiyakuhr) {
        kaiyakuhr = pKaiyakuhr;
    }

    @Override
    public BizCurrency getYenkaiyakuhr() {
        return yenkaiyakuhr;
    }

    @Override
    public void setYenkaiyakuhr(BizCurrency pYenkaiyakuhr) {
        yenkaiyakuhr = pYenkaiyakuhr;
    }

    @Override
    public BizCurrency getKihonhokenkngk() {
        return kihonhokenkngk;
    }

    @Override
    public void setKihonhokenkngk(BizCurrency pKihonhokenkngk) {
        kihonhokenkngk = pKihonhokenkngk;
    }

    @Override
    public BizCurrency getYenkihonhokenkngk() {
        return yenkihonhokenkngk;
    }

    @Override
    public void setYenkihonhokenkngk(BizCurrency pYenkihonhokenkngk) {
        yenkihonhokenkngk = pYenkihonhokenkngk;
    }

    @Override
    public BizCurrency getSaigais() {
        return saigais;
    }

    @Override
    public void setSaigais(BizCurrency pSaigais) {
        saigais = pSaigais;
    }

    @Override
    public BizCurrency getYensaigais() {
        return yensaigais;
    }

    @Override
    public void setYensaigais(BizCurrency pYensaigais) {
        yensaigais = pYensaigais;
    }

    @Override
    public boolean isViewKingakuInfoSeigyo() {
        return viewKingakuInfoSeigyo;
    }

    public void setViewKingakuInfoSeigyo(boolean pViewKingakuInfoSeigyo) {
        viewKingakuInfoSeigyo = pViewKingakuInfoSeigyo;
    }

    @Override
    public boolean isViewKingakuInfoDispFlg() {
        return viewKingakuInfoDispFlg;
    }

    public void setViewKingakuInfoDispFlg(boolean pViewKingakuInfoDispFlg) {
        viewKingakuInfoDispFlg = pViewKingakuInfoDispFlg;
    }

    @Override
    public boolean isViewKingakuInfoHokenryouStgkDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKingakuInfoTutaKngkDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKingakuInfoKaiyakuHrDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKingakuInfoKihonHokenKngkDispFlg() {
        return false;
    }

    @Override
    public boolean isViewKingakuInfoSaigaiSDispFlg() {
        return false;
    }
}
