package yuyu.common.biz.bzdairiten;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_BosyuuKbn;
import yuyu.def.classification.C_BsKahiKbn;

/**
 * 業務共通 代理店 募集人情報出力Beanクラス
 */
public class BzGetBsInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bosyuuCd;

    private String bosyuuNm;

    private String kanjiBosyuuninNm;

    private BizDate itakuYmd;

    private String dairiten1Cd;

    private String dairiten2Cd;

    private String dairiten3Cd;

    private String dairitenKanriSosikiCd1;

    private String dairitenKanriSosikiCd2;

    private String dairitenKanriSosikiCd3;

    private C_BosyuuKbn bosyuuKbn;

    private BizDate bosyuuninTourokuYmd;

    private C_BsKahiKbn bosyuuKahiKbn;

    private BizDate bosyuuninGyouhaiYmd;

    private BizDate hngkHknSkkTrkYmd;

    private BizDate hngkHknSkkTrkMsuYmd;

    private BizDate bosyuuSeiYmd;

    private BizDate itakuKaiyakuYmd;

    private String daiBosyuuCd;

    private String bosyuuTrkNo;

    private String kouinCd;

    public String getBosyuuCd() {
        return this.bosyuuCd;
    }

    public void setBosyuuCd(String pBosyuuCd) {
        this.bosyuuCd = pBosyuuCd;
    }

    public String getBosyuuNm() {
        return this.bosyuuNm;
    }

    public void setBosyuuNm(String pBosyuuNm) {
        this.bosyuuNm = pBosyuuNm;
    }

    public String getKanjiBosyuuninNm() {
        return this.kanjiBosyuuninNm;
    }

    public void setKanjiBosyuuninNm(String pKanjiBosyuuninNm) {
        this.kanjiBosyuuninNm = pKanjiBosyuuninNm;
    }

    public BizDate getItakuYmd() {
        return this.itakuYmd;
    }

    public void setItakuYmd(BizDate pItakuYmd) {
        this.itakuYmd = pItakuYmd;
    }

    public String getDairiten1Cd() {
        return this.dairiten1Cd;
    }

    public void setDairiten1Cd(String pDairiten1Cd) {
        this.dairiten1Cd = pDairiten1Cd;
    }

    public String getDairiten2Cd() {
        return this.dairiten2Cd;
    }

    public void setDairiten2Cd(String pDairiten2Cd) {
        this.dairiten2Cd = pDairiten2Cd;
    }

    public String getDairiten3Cd() {
        return this.dairiten3Cd;
    }

    public void setDairiten3Cd(String pDairiten3Cd) {
        this.dairiten3Cd = pDairiten3Cd;
    }

    public String getDairitenKanriSosikiCd1() {
        return this.dairitenKanriSosikiCd1;
    }

    public void setDairitenKanriSosikiCd1(String pDairitenKanriSosikiCd1) {
        this.dairitenKanriSosikiCd1 = pDairitenKanriSosikiCd1;
    }

    public String getDairitenKanriSosikiCd2() {
        return this.dairitenKanriSosikiCd2;
    }

    public void setDairitenKanriSosikiCd2(String pDairitenKanriSosikiCd2) {
        this.dairitenKanriSosikiCd2 = pDairitenKanriSosikiCd2;
    }

    public String getDairitenKanriSosikiCd3() {
        return this.dairitenKanriSosikiCd3;
    }

    public void setDairitenKanriSosikiCd3(String pDairitenKanriSosikiCd3) {
        this.dairitenKanriSosikiCd3 = pDairitenKanriSosikiCd3;
    }

    public C_BosyuuKbn getBosyuuKbn() {
        return this.bosyuuKbn;
    }

    public void setBosyuuKbn(C_BosyuuKbn pBosyuuKbn) {
        this.bosyuuKbn = pBosyuuKbn;
    }

    public BizDate getBosyuuninTourokuYmd() {
        return this.bosyuuninTourokuYmd;
    }

    public void setBosyuuninTourokuYmd(BizDate pBosyuuninTourokuYmd) {
        this.bosyuuninTourokuYmd = pBosyuuninTourokuYmd;
    }

    public C_BsKahiKbn getBosyuuKahiKbn() {
        return this.bosyuuKahiKbn;
    }

    public void setBosyuuKahiKbn(C_BsKahiKbn pBosyuuKahiKbn) {
        this.bosyuuKahiKbn = pBosyuuKahiKbn;
    }

    public BizDate getBosyuuninGyouhaiYmd() {
        return this.bosyuuninGyouhaiYmd;
    }

    public void setBosyuuninGyouhaiYmd(BizDate pBosyuuninGyouhaiYmd) {
        this.bosyuuninGyouhaiYmd = pBosyuuninGyouhaiYmd;
    }

    public BizDate getHngkHknSkkTrkYmd() {
        return this.hngkHknSkkTrkYmd;
    }

    public void setHngkHknSkkTrkYmd(BizDate pHngkHknSkkTrkYmd) {
        this.hngkHknSkkTrkYmd = pHngkHknSkkTrkYmd;
    }

    public BizDate getHngkHknSkkTrkMsuYmd() {
        return this.hngkHknSkkTrkMsuYmd;
    }

    public void setHngkHknSkkTrkMsuYmd(BizDate pHngkHknSkkTrkMsuYmd) {
        this.hngkHknSkkTrkMsuYmd = pHngkHknSkkTrkMsuYmd;
    }

    public BizDate getBosyuuSeiYmd() {
        return this.bosyuuSeiYmd;
    }

    public void setBosyuuSeiYmd(BizDate pBosyuuSeiYmd) {
        this.bosyuuSeiYmd = pBosyuuSeiYmd;
    }

    public BizDate getItakuKaiyakuYmd() {
        return this.itakuKaiyakuYmd;
    }

    public void setItakuKaiyakuYmd(BizDate pItakuKaiyakuYmd) {
        this.itakuKaiyakuYmd = pItakuKaiyakuYmd;
    }

    public String getDaiBosyuuCd() {
        return this.daiBosyuuCd;
    }

    public void setDaiBosyuuCd(String pDaiBosyuuCd) {
        this.daiBosyuuCd = pDaiBosyuuCd;
    }

    public String getBosyuuTrkNo() {
        return this.bosyuuTrkNo;
    }

    public void setBosyuuTrkNo(String pBosyuuTrkNo) {
        this.bosyuuTrkNo = pBosyuuTrkNo;
    }

    public String getKouinCd() {
        return this.kouinCd;
    }

    public void setKouinCd(String pKouinCd) {
        this.kouinCd = pKouinCd;
    }
}
