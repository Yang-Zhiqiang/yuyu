package yuyu.app.sinkeiyaku.skkettei.skkyouseihand;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 強制ハンド決定入力 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkKyouseiHandUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
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

    private C_SyorikekkaKbn mostenkenkekkakbn;

    public C_SyorikekkaKbn getMostenkenkekkakbn() {
        return mostenkenkekkakbn;
    }

    public void setMostenkenkekkakbn(C_SyorikekkaKbn pMostenkenkekkakbn) {
        mostenkenkekkakbn = pMostenkenkekkakbn;
    }

    private String mostenkentnsketsyacd;

    public String getMostenkentnsketsyacd() {
        return mostenkentnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMostenkentnsketsyacd(String pMostenkentnsketsyacd) {
        mostenkentnsketsyacd = pMostenkentnsketsyacd;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String mostenkencommentgamen;

    public String getMostenkencommentgamen() {
        return mostenkencommentgamen;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setMostenkencommentgamen(String pMostenkencommentgamen) {
        mostenkencommentgamen = pMostenkencommentgamen;
    }

    private C_SyorikekkaKbn knksateikekkakbn;

    public C_SyorikekkaKbn getKnksateikekkakbn() {
        return knksateikekkakbn;
    }

    public void setKnksateikekkakbn(C_SyorikekkaKbn pKnksateikekkakbn) {
        knksateikekkakbn = pKnksateikekkakbn;
    }

    private String knktnsketsyacd;

    public String getKnktnsketsyacd() {
        return knktnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKnktnsketsyacd(String pKnktnsketsyacd) {
        knktnsketsyacd = pKnktnsketsyacd;
    }

    @ValidTextArea(length=40, rows=10)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String knksateiiraicomment;

    public String getKnksateiiraicomment() {
        return knksateiiraicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKnksateiiraicomment(String pKnksateiiraicomment) {
        knksateiiraicomment = pKnksateiiraicomment;
    }

    private C_SyorikekkaKbn imusateikekkakbn;

    public C_SyorikekkaKbn getImusateikekkakbn() {
        return imusateikekkakbn;
    }

    public void setImusateikekkakbn(C_SyorikekkaKbn pImusateikekkakbn) {
        imusateikekkakbn = pImusateikekkakbn;
    }

    private String imutnsketsyacd;

    public String getImutnsketsyacd() {
        return imutnsketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setImutnsketsyacd(String pImutnsketsyacd) {
        imutnsketsyacd = pImutnsketsyacd;
    }

    @ValidTextArea(length=40, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    private String imusateiiraicomment;

    public String getImusateiiraicomment() {
        return imusateiiraicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setImusateiiraicomment(String pImusateiiraicomment) {
        imusateiiraicomment = pImusateiiraicomment;
    }

    private String modorubtn;

    public String getModorubtn() {
        return modorubtn;
    }

    public void setModorubtn(String pModorubtn) {
        modorubtn = pModorubtn;
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

    private LoopChain<UserDefsList> mostenkentnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getMostenkentnsketsyacdOptionBeanList() {
        return mostenkentnsketsyacdOptionBeanList.get();
    }

    public void setMostenkentnsketsyacdOptionBeanList(UserDefsList pMostenkentnsketsyacdOptionBeanList) {
        clearMostenkentnsketsyacdOptionBeanList();
        mostenkentnsketsyacdOptionBeanList.add(pMostenkentnsketsyacdOptionBeanList);
    }

    public void clearMostenkentnsketsyacdOptionBeanList() {
        mostenkentnsketsyacdOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> knktnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getKnktnsketsyacdOptionBeanList() {
        return knktnsketsyacdOptionBeanList.get();
    }

    public void setKnktnsketsyacdOptionBeanList(UserDefsList pKnktnsketsyacdOptionBeanList) {
        clearKnktnsketsyacdOptionBeanList();
        knktnsketsyacdOptionBeanList.add(pKnktnsketsyacdOptionBeanList);
    }

    public void clearKnktnsketsyacdOptionBeanList() {
        knktnsketsyacdOptionBeanList.clear();
    }

    private LoopChain<UserDefsList> imutnsketsyacdOptionBeanList = new LoopChain<>();
    public UserDefsList getImutnsketsyacdOptionBeanList() {
        return imutnsketsyacdOptionBeanList.get();
    }

    public void setImutnsketsyacdOptionBeanList(UserDefsList pImutnsketsyacdOptionBeanList) {
        clearImutnsketsyacdOptionBeanList();
        imutnsketsyacdOptionBeanList.add(pImutnsketsyacdOptionBeanList);
    }

    public void clearImutnsketsyacdOptionBeanList() {
        imutnsketsyacdOptionBeanList.clear();
    }
}
