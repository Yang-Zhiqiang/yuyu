package yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku;

import java.util.List;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 振込入金削除データ登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkHurikomiSakujyoTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SakujyoInfoListDataSourceBean> sakujyoInfoListDataSource = new DataSource<>();
    public DataSource<SakujyoInfoListDataSourceBean> getSakujyoInfoListDataSource() {
        return sakujyoInfoListDataSource;
    }

    @Deprecated
    public List<SakujyoInfoListDataSourceBean> getSakujyoInfoList() {
        return sakujyoInfoListDataSource.getDatas();
    }

    public void setSakujyoInfoList(List<SakujyoInfoListDataSourceBean> pSakujyoInfoList) {
        sakujyoInfoListDataSource.setDatas(pSakujyoInfoList, 10);
    }

    private BizDate sakujyotrkymd;

    public BizDate getSakujyotrkymd() {
        return sakujyotrkymd;
    }

    public void setSakujyotrkymd(BizDate pSakujyotrkymd) {
        sakujyotrkymd = pSakujyotrkymd;
    }

    @MaxLength(max=9)
    @AlphaDigit
    private String mosnochknasi;

    public String getMosnochknasi() {
        return mosnochknasi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosnochknasi(String pMosnochknasi) {
        mosnochknasi = pMosnochknasi;
    }

    @SingleByteStrings
    @AlphaDigit
    private String oyadrtencd;

    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private C_Tuukasyu rstuukasyu;

    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

    @MaxLength(max=96)
    @MultiByteStrings
    @InvalidCharacter
    private String hrkmirninnm;

    public String getHrkmirninnm() {
        return hrkmirninnm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHrkmirninnm(String pHrkmirninnm) {
        hrkmirninnm = pHrkmirninnm;
    }

    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    private BizCurrency rsgaku;

    public BizCurrency getRsgaku() {
        return rsgaku;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsgaku(BizCurrency pRsgaku) {
        rsgaku = pRsgaku;
    }
}
