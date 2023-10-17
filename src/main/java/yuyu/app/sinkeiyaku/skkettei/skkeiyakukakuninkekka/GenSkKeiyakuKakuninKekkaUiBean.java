package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka;

import java.util.List;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.DataSource;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 契約確認結果入力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkKeiyakuKakuninKekkaUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private DataSource<SyoruiInfoListDataSourceBean> syoruiInfoListDataSource = new DataSource<>();
    public DataSource<SyoruiInfoListDataSourceBean> getSyoruiInfoListDataSource() {
        return syoruiInfoListDataSource;
    }

    @Deprecated
    public List<SyoruiInfoListDataSourceBean> getSyoruiInfoList() {
        return syoruiInfoListDataSource.getDatas();
    }

    public void setSyoruiInfoList(List<SyoruiInfoListDataSourceBean> pSyoruiInfoList) {
        syoruiInfoListDataSource.setDatas(pSyoruiInfoList);
    }

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
    }

    private String vktifdispjimutetuzukinm;

    public String getVktifdispjimutetuzukinm() {
        return vktifdispjimutetuzukinm;
    }

    public void setVktifdispjimutetuzukinm(String pVktifdispjimutetuzukinm) {
        vktifdispjimutetuzukinm = pVktifdispjimutetuzukinm;
    }

    private String vktifdisptasknm;

    public String getVktifdisptasknm() {
        return vktifdisptasknm;
    }

    public void setVktifdisptasknm(String pVktifdisptasknm) {
        vktifdisptasknm = pVktifdisptasknm;
    }

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknnmkj;

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private String allhyoujibtn;

    public String getAllhyoujibtn() {
        return allhyoujibtn;
    }

    public void setAllhyoujibtn(String pAllhyoujibtn) {
        allhyoujibtn = pAllhyoujibtn;
    }

    private String imageid;

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String pImageid) {
        imageid = pImageid;
    }

    private C_KykkakkekKbn kykkakkekkbn;

    public C_KykkakkekKbn getKykkakkekkbn() {
        return kykkakkekkbn;
    }

    public void setKykkakkekkbn(C_KykkakkekKbn pKykkakkekkbn) {
        kykkakkekkbn = pKykkakkekkbn;
    }

    @ValidDate
    private BizDate kykkakkanymd;

    public BizDate getKykkakkanymd() {
        return kykkakkanymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykkakkanymd(BizDate pKykkakkanymd) {
        kykkakkanymd = pKykkakkanymd;
    }

    @MaxLength(max=12)
    @AlphaDigit
    private String kykkakkaisyacd;

    public String getKykkakkaisyacd() {
        return kykkakkaisyacd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setKykkakkaisyacd(String pKykkakkaisyacd) {
        kykkakkaisyacd = pKykkakkaisyacd;
    }

    @MaxLength(max=12)
    @AlphaDigit
    private String kykkaktantcd;

    public String getKykkaktantcd() {
        return kykkaktantcd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setKykkaktantcd(String pKykkaktantcd) {
        kykkaktantcd = pKykkaktantcd;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
}
