package yuyu.app.sinkeiyaku.skhubikanri.skhubitouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.web.ui.AbstractUiBean.LoopChain;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 新契約不備登録 - ●未発信不備一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHubiList2DataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispinputtrkymd;

    public BizDate getDispinputtrkymd() {
        return dispinputtrkymd;
    }

    public void setDispinputtrkymd(BizDate pDispinputtrkymd) {
        dispinputtrkymd = pDispinputtrkymd;
    }


    private C_SyoruiCdKbn hubisyoruicd;

    public C_SyoruiCdKbn getHubisyoruicd() {
        return hubisyoruicd;
    }

    public void setHubisyoruicd(C_SyoruiCdKbn pHubisyoruicd) {
        hubisyoruicd = pHubisyoruicd;
    }


    private String dummykmk1;

    public String getDummykmk1() {
        return dummykmk1;
    }

    public void setDummykmk1(String pDummykmk1) {
        dummykmk1 = pDummykmk1;
    }


    private C_HasinkyokaKbn dispinputhasinkyokakbn;

    public C_HasinkyokaKbn getDispinputhasinkyokakbn() {
        return dispinputhasinkyokakbn;
    }

    public void setDispinputhasinkyokakbn(C_HasinkyokaKbn pDispinputhasinkyokakbn) {
        dispinputhasinkyokakbn = pDispinputhasinkyokakbn;
    }


    private String dispinputnyuryokutantounm;

    public String getDispinputnyuryokutantounm() {
        return dispinputnyuryokutantounm;
    }

    public void setDispinputnyuryokutantounm(String pDispinputnyuryokutantounm) {
        dispinputnyuryokutantounm = pDispinputnyuryokutantounm;
    }


    private Boolean dispinputtyoubunflg;

    public Boolean getDispinputtyoubunflg() {
        return dispinputtyoubunflg == null ? Boolean.FALSE : dispinputtyoubunflg;
    }

    public void setDispinputtyoubunflg(Boolean pDispinputtyoubunflg) {
        dispinputtyoubunflg = pDispinputtyoubunflg == null ? Boolean.FALSE : pDispinputtyoubunflg;
    }


    private String dispinputskhubikoumoku;

    public String getDispinputskhubikoumoku() {
        return dispinputskhubikoumoku;
    }

    @Trim("left")
    public void setDispinputskhubikoumoku(String pDispinputskhubikoumoku) {
        dispinputskhubikoumoku = pDispinputskhubikoumoku;
    }


    private LoopChain<UserDefsList> dispinputskhubikoumokuOptionBeanList = new LoopChain<>();
    public UserDefsList getDispinputskhubikoumokuOptionBeanList() {
        return dispinputskhubikoumokuOptionBeanList.get();
    }

    public void setDispinputskhubikoumokuOptionBeanList(UserDefsList pDispinputskhubikoumokuOptionBeanList) {
        dispinputskhubikoumokuOptionBeanList.add(pDispinputskhubikoumokuOptionBeanList);
    }

    public void clearDispinputskhubikoumokuOptionBeanList() {
        dispinputskhubikoumokuOptionBeanList.clear();
    }

    private String dispinputhubinaiyoucd;

    public String getDispinputhubinaiyoucd() {
        return dispinputhubinaiyoucd;
    }

    public void setDispinputhubinaiyoucd(String pDispinputhubinaiyoucd) {
        dispinputhubinaiyoucd = pDispinputhubinaiyoucd;
    }


    private LoopChain<UserDefsList> dispinputhubinaiyoucdOptionBeanList = new LoopChain<>();
    public UserDefsList getDispinputhubinaiyoucdOptionBeanList() {
        return dispinputhubinaiyoucdOptionBeanList.get();
    }

    public void setDispinputhubinaiyoucdOptionBeanList(UserDefsList pDispinputhubinaiyoucdOptionBeanList) {
        dispinputhubinaiyoucdOptionBeanList.add(pDispinputhubinaiyoucdOptionBeanList);
    }

    public void clearDispinputhubinaiyoucdOptionBeanList() {
        dispinputhubinaiyoucdOptionBeanList.clear();
    }

    private String dummykmk2;

    public String getDummykmk2() {
        return dummykmk2;
    }

    public void setDummykmk2(String pDummykmk2) {
        dummykmk2 = pDummykmk2;
    }


    private C_HassinsakiKbn dispinputhassinsakikbn;

    public C_HassinsakiKbn getDispinputhassinsakikbn() {
        return dispinputhassinsakikbn;
    }

    public void setDispinputhassinsakikbn(C_HassinsakiKbn pDispinputhassinsakikbn) {
        dispinputhassinsakikbn = pDispinputhassinsakikbn;
    }


    private String sakujyoLink;

    public String getSakujyoLink() {
        return sakujyoLink;
    }

    public void setSakujyoLink(String pSakujyoLink) {
        sakujyoLink = pSakujyoLink;
    }


    private C_Delflag sakujyoflg;

    public C_Delflag getSakujyoflg() {
        return sakujyoflg;
    }

    public void setSakujyoflg(C_Delflag pSakujyoflg) {
        sakujyoflg = pSakujyoflg;
    }


    private String dispinputskseibisijinaiyou;

    public String getDispinputskseibisijinaiyou() {
        return dispinputskseibisijinaiyou;
    }

    @Trim("left")
    public void setDispinputskseibisijinaiyou(String pDispinputskseibisijinaiyou) {
        dispinputskseibisijinaiyou = pDispinputskseibisijinaiyou;
    }


    private LoopChain<UserDefsList> dispinputskseibisijinaiyouOptionBeanList = new LoopChain<>();
    public UserDefsList getDispinputskseibisijinaiyouOptionBeanList() {
        return dispinputskseibisijinaiyouOptionBeanList.get();
    }

    public void setDispinputskseibisijinaiyouOptionBeanList(UserDefsList pDispinputskseibisijinaiyouOptionBeanList) {
        dispinputskseibisijinaiyouOptionBeanList.add(pDispinputskseibisijinaiyouOptionBeanList);
    }

    public void clearDispinputskseibisijinaiyouOptionBeanList() {
        dispinputskseibisijinaiyouOptionBeanList.clear();
    }

    @MultiByteStringsReturnable
    @InvalidCharacter
    private String tyoubundisprenrakujikou;

    public String getTyoubundisprenrakujikou() {
        return tyoubundisprenrakujikou;
    }

    @DataConvert("toMultiByte")
    public void setTyoubundisprenrakujikou(String pTyoubundisprenrakujikou) {
        tyoubundisprenrakujikou = pTyoubundisprenrakujikou;
    }

}
