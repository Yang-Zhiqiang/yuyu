package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import java.util.List;

import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 ＰＡＬ別口索引照会結果Beanクラス
 */
public class PALBetuSakuinSyoukaiKekkaBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private int kykmfkensuu;

    private int sueokifkensuu;

    private int nkfkensuu;

    private int kkkensuu;

    private int nkkensuu;

    private C_UmuKbn palkykmfkensuutyoukaumu;

    private C_UmuKbn palsueokifkensuutyoukaumu;

    private C_UmuKbn palnkfkensuutyoukaumu;

    private C_UmuKbn hozenkensuutyoukaumu;

    private C_UmuKbn nkkensuutyoukaumu;

    private List<PALKykMFSakuinKekkaBean> palKykMFSakuinKekkaBeanList;

    private List<PALSueokiFSakuinKekkaBean> palSueokiFSakuinKekkaBeanList;

    private List<PALSouNenkinFSakuinKekkaBean> palSouNenkinFSakuinKekkaBeanList;

    private List<KykSakuinKekkaBean> kykSakuinKekkaBeanList;

    private List<NenkinSakuinKekkaBean> nenkinSakuinKekkaBeanList;

    public int getKykmfkensuu() {
        return this.kykmfkensuu;
    }

    public void setKykmfkensuu(int pKykmfkensuu) {
        this.kykmfkensuu = pKykmfkensuu;
    }

    public int getSueokifkensuu() {
        return this.sueokifkensuu;
    }

    public void setSueokifkensuu(int pSueokifkensuu) {
        this.sueokifkensuu = pSueokifkensuu;
    }

    public int getNkfkensuu() {
        return this.nkfkensuu;
    }

    public void setNkfkensuu(int pNkfkensuu) {
        this.nkfkensuu = pNkfkensuu;
    }

    public int getKkkensuu() {
        return this.kkkensuu;
    }

    public void setKkkensuu(int pKkkensuu) {
        this.kkkensuu = pKkkensuu;
    }

    public int getNkkensuu() {
        return this.nkkensuu;
    }

    public void setNkkensuu(int pNkkensuu) {
        this.nkkensuu = pNkkensuu;
    }

    public C_UmuKbn getPalkykmfkensuutyoukaumu() {
        return this.palkykmfkensuutyoukaumu;
    }

    public void setPalkykmfkensuutyoukaumu(C_UmuKbn pPalkykmfkensuutyoukaumu) {
        this.palkykmfkensuutyoukaumu = pPalkykmfkensuutyoukaumu;
    }

    public C_UmuKbn getPalsueokifkensuutyoukaumu() {
        return this.palsueokifkensuutyoukaumu;
    }

    public void setPalsueokifkensuutyoukaumu(C_UmuKbn pPalsueokifkensuutyoukaumu) {
        this.palsueokifkensuutyoukaumu = pPalsueokifkensuutyoukaumu;
    }

    public C_UmuKbn getPalnkfkensuutyoukaumu() {
        return this.palnkfkensuutyoukaumu;
    }

    public void setPalnkfkensuutyoukaumu(C_UmuKbn pPalnkfkensuutyoukaumu) {
        this.palnkfkensuutyoukaumu = pPalnkfkensuutyoukaumu;
    }
    public C_UmuKbn getHozenkensuutyoukaumu() {
        return this.hozenkensuutyoukaumu;
    }

    public void setHozenkensuutyoukaumu(C_UmuKbn pHozenkensuutyoukaumu) {
        this.hozenkensuutyoukaumu = pHozenkensuutyoukaumu;
    }

    public C_UmuKbn getNkkensuutyoukaumu() {
        return this.nkkensuutyoukaumu;
    }

    public void setNkkensuutyoukaumu(C_UmuKbn pNkkensuutyoukaumu) {
        this.nkkensuutyoukaumu = pNkkensuutyoukaumu;
    }

    public List<PALKykMFSakuinKekkaBean> getPalKykMFSakuinKekkaBeanList() {
        return this.palKykMFSakuinKekkaBeanList;
    }

    public void setPalKykMFSakuinKekkaBeanList(List<PALKykMFSakuinKekkaBean> pPalKykMFSakuinKekkaBeanList) {
        this.palKykMFSakuinKekkaBeanList = pPalKykMFSakuinKekkaBeanList;
    }

    public List<PALSueokiFSakuinKekkaBean> getPalSueokiFSakuinKekkaBeanList() {
        return this.palSueokiFSakuinKekkaBeanList;
    }

    public void setPalSueokiFSakuinKekkaBeanList(List<PALSueokiFSakuinKekkaBean> pPalSueokiFSakuinKekkaBeanList) {
        this.palSueokiFSakuinKekkaBeanList = pPalSueokiFSakuinKekkaBeanList;
    }

    public List<PALSouNenkinFSakuinKekkaBean> getPalSouNenkinFSakuinKekkaBeanList() {
        return this.palSouNenkinFSakuinKekkaBeanList;
    }

    public void setPalSouNenkinFSakuinKekkaBeanList(
        List<PALSouNenkinFSakuinKekkaBean> pPalSouNenkinFSakuinKekkaBeanList) {
        this.palSouNenkinFSakuinKekkaBeanList = pPalSouNenkinFSakuinKekkaBeanList;
    }

    public List<KykSakuinKekkaBean> getKykSakuinKekkaBeanList() {
        return this.kykSakuinKekkaBeanList;
    }

    public void setKykSakuinKekkaBeanList(List<KykSakuinKekkaBean> pKykSakuinKekkaBeanList) {
        this.kykSakuinKekkaBeanList = pKykSakuinKekkaBeanList;
    }

    public List<NenkinSakuinKekkaBean> getNenkinSakuinKekkaBeanList() {
        return this.nenkinSakuinKekkaBeanList;
    }

    public void setNenkinSakuinKekkaBeanList(List<NenkinSakuinKekkaBean> pNenkinSakuinKekkaBeanList) {
        this.nenkinSakuinKekkaBeanList = pNenkinSakuinKekkaBeanList;
    }
}
