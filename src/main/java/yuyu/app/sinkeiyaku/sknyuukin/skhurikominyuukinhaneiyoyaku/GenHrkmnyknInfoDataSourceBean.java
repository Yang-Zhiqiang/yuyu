package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean.LoopChain;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 振込入金反映予約 - ●明細 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHrkmnyknInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer disprenno3keta;

    public Integer getDisprenno3keta() {
        return disprenno3keta;
    }

    public void setDisprenno3keta(Integer pDisprenno3keta) {
        disprenno3keta = pDisprenno3keta;
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


    private String nyknoyadrtencd;

    public String getNyknoyadrtencd() {
        return nyknoyadrtencd;
    }

    public void setNyknoyadrtencd(String pNyknoyadrtencd) {
        nyknoyadrtencd = pNyknoyadrtencd;
    }


    private LoopChain<UserDefsList> nyknoyadrtencdOptionBeanList = new LoopChain<>();
    public UserDefsList getNyknoyadrtencdOptionBeanList() {
        return nyknoyadrtencdOptionBeanList.get();
    }

    public void setNyknoyadrtencdOptionBeanList(UserDefsList pNyknoyadrtencdOptionBeanList) {
        nyknoyadrtencdOptionBeanList.add(pNyknoyadrtencdOptionBeanList);
    }

    public void clearNyknoyadrtencdOptionBeanList() {
        nyknoyadrtencdOptionBeanList.clear();
    }

    @MaxLength(max=48)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String hrkmirninnm48;

    public String getHrkmirninnm48() {
        return hrkmirninnm48;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHrkmirninnm48(String pHrkmirninnm48) {
        hrkmirninnm48 = pHrkmirninnm48;
    }


    private C_Tuukasyu hrktuukasyu;

    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }


    private C_Tuukasyu siteituuka;

    public C_Tuukasyu getSiteituuka() {
        return siteituuka;
    }

    public void setSiteituuka(C_Tuukasyu pSiteituuka) {
        siteituuka = pSiteituuka;
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


    private BizCurrency dengk;

    public BizCurrency getDengk() {
        return dengk;
    }

    public void setDengk(BizCurrency pDengk) {
        dengk = pDengk;
    }


    @ValidDate
    private BizDate ryosyuymd;

    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String simukebanknm15;

    public String getSimukebanknm15() {
        return simukebanknm15;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSimukebanknm15(String pSimukebanknm15) {
        simukebanknm15 = pSimukebanknm15;
    }


    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    private String simuketennm15;

    public String getSimuketennm15() {
        return simuketennm15;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSimuketennm15(String pSimuketennm15) {
        simuketennm15 = pSimuketennm15;
    }

}
