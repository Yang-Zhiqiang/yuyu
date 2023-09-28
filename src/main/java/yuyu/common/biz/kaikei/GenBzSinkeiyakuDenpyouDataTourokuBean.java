package yuyu.common.biz.kaikei;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * （共通）新契約伝票データ情報登録BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSinkeiyakuDenpyouDataTourokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSinkeiyakuDenpyouDataTourokuBean() {
    }

    @NotNull
    private String ibSyono;

    public String getIbSyono() {
        return ibSyono;
    }

    public void setIbSyono(String pIbSyono) {
        ibSyono = pIbSyono;
    }

    @NotNull
    private String ibHuridenatesakicd;

    public String getIbHuridenatesakicd() {
        return ibHuridenatesakicd;
    }

    public void setIbHuridenatesakicd(String pIbHuridenatesakicd) {
        ibHuridenatesakicd = pIbHuridenatesakicd;
    }

    @NotNull
    private C_TantouCdKbn ibTantocd;

    public C_TantouCdKbn getIbTantocd() {
        return ibTantocd;
    }

    public void setIbTantocd(C_TantouCdKbn pIbTantocd) {
        ibTantocd = pIbTantocd;
    }

    @NotNull
    private BizDate ibDenymd;

    public BizDate getIbDenymd() {
        return ibDenymd;
    }

    public void setIbDenymd(BizDate pIbDenymd) {
        ibDenymd = pIbDenymd;
    }

    @NotNull
    private C_Tuukasyu ibTuukasyu;

    public C_Tuukasyu getIbTuukasyu() {
        return ibTuukasyu;
    }

    public void setIbTuukasyu(C_Tuukasyu pIbTuukasyu) {
        ibTuukasyu = pIbTuukasyu;
    }

    @NotNull
    private BizDate ibSyoriymd;

    public BizDate getIbSyoriymd() {
        return ibSyoriymd;
    }

    public void setIbSyoriymd(BizDate pIbSyoriymd) {
        ibSyoriymd = pIbSyoriymd;
    }

    @NotNull
    private String ibSyoricd;

    public String getIbSyoricd() {
        return ibSyoricd;
    }

    public void setIbSyoricd(String pIbSyoricd) {
        ibSyoricd = pIbSyoricd;
    }

    @NotNull
    private String ibSyorisosikicd;

    public String getIbSyorisosikicd() {
        return ibSyorisosikicd;
    }

    public void setIbSyorisosikicd(String pIbSyorisosikicd) {
        ibSyorisosikicd = pIbSyorisosikicd;
    }

    @NotNull
    private C_KessantyouseiKbn ibKessantyouseikbn;

    public C_KessantyouseiKbn getIbKessantyouseikbn() {
        return ibKessantyouseikbn;
    }

    public void setIbKessantyouseikbn(C_KessantyouseiKbn pIbKessantyouseikbn) {
        ibKessantyouseikbn = pIbKessantyouseikbn;
    }

    @NotNull
    private C_NaibuKeiyakuKbn ibNaibukeiyakukbn;

    public C_NaibuKeiyakuKbn getIbNaibukeiyakukbn() {
        return ibNaibukeiyakukbn;
    }

    public void setIbNaibukeiyakukbn(C_NaibuKeiyakuKbn pIbNaibukeiyakukbn) {
        ibNaibukeiyakukbn = pIbNaibukeiyakukbn;
    }

    @NotNull
    private C_TekiyouKbn ibTekiyoukbn;

    public C_TekiyouKbn getIbTekiyoukbn() {
        return ibTekiyoukbn;
    }

    public void setIbTekiyoukbn(C_TekiyouKbn pIbTekiyoukbn) {
        ibTekiyoukbn = pIbTekiyoukbn;
    }

    @NotNull
    private C_DensyoriKbn ibDensyorikbn;

    public C_DensyoriKbn getIbDensyorikbn() {
        return ibDensyorikbn;
    }

    public void setIbDensyorikbn(C_DensyoriKbn pIbDensyorikbn) {
        ibDensyorikbn = pIbDensyorikbn;
    }

    @NotNull
    private String ibAatsukaishasuitososhikicd;

    public String getIbAatsukaishasuitososhikicd() {
        return ibAatsukaishasuitososhikicd;
    }

    public void setIbAatsukaishasuitososhikicd(String pIbAatsukaishasuitososhikicd) {
        ibAatsukaishasuitososhikicd = pIbAatsukaishasuitososhikicd;
    }

    @NotNull
    private BizDate ibKykymd;

    public BizDate getIbKykymd() {
        return ibKykymd;
    }

    public void setIbKykymd(BizDate pIbKykymd) {
        ibKykymd = pIbKykymd;
    }

    @NotNull
    private BizDateYM ibBosyuuym;

    public BizDateYM getIbBosyuuym() {
        return ibBosyuuym;
    }

    public void setIbBosyuuym(BizDateYM pIbBosyuuym) {
        ibBosyuuym = pIbBosyuuym;
    }

    @NotNull
    private String ibAatsukaishasoshikicd;

    public String getIbAatsukaishasoshikicd() {
        return ibAatsukaishasoshikicd;
    }

    public void setIbAatsukaishasoshikicd(String pIbAatsukaishasoshikicd) {
        ibAatsukaishasoshikicd = pIbAatsukaishasoshikicd;
    }

    @NotNull
    private String ibAatkisyadaibosyuucd;

    public String getIbAatkisyadaibosyuucd() {
        return ibAatkisyadaibosyuucd;
    }

    public void setIbAatkisyadaibosyuucd(String pIbAatkisyadaibosyuucd) {
        ibAatkisyadaibosyuucd = pIbAatkisyadaibosyuucd;
    }

    @NotNull
    private String ibSyusyouhncd;

    public String getIbSyusyouhncd() {
        return ibSyusyouhncd;
    }

    public void setIbSyusyouhncd(String pIbSyusyouhncd) {
        ibSyusyouhncd = pIbSyusyouhncd;
    }

    @NotNull
    private C_Sdpd ibSdpdkbn;

    public C_Sdpd getIbSdpdkbn() {
        return ibSdpdkbn;
    }

    public void setIbSdpdkbn(C_Sdpd pIbSdpdkbn) {
        ibSdpdkbn = pIbSdpdkbn;
    }

    @NotNull
    private C_Hrkkaisuu ibHrkkaisuu;

    public C_Hrkkaisuu getIbHrkkaisuu() {
        return ibHrkkaisuu;
    }

    public void setIbHrkkaisuu(C_Hrkkaisuu pIbHrkkaisuu) {
        ibHrkkaisuu = pIbHrkkaisuu;
    }

    @NotNull
    private C_Hrkkeiro ibHrkkeiro;

    public C_Hrkkeiro getIbHrkkeiro() {
        return ibHrkkeiro;
    }

    public void setIbHrkkeiro(C_Hrkkeiro pIbHrkkeiro) {
        ibHrkkeiro = pIbHrkkeiro;
    }

    @NotNull
    private BizDate ibSknnkaisiymd;

    public BizDate getIbSknnkaisiymd() {
        return ibSknnkaisiymd;
    }

    public void setIbSknnkaisiymd(BizDate pIbSknnkaisiymd) {
        ibSknnkaisiymd = pIbSknnkaisiymd;
    }

    @NotNull
    private BizDate ibMosymd;

    public BizDate getIbMosymd() {
        return ibMosymd;
    }

    public void setIbMosymd(BizDate pIbMosymd) {
        ibMosymd = pIbMosymd;
    }

    @NotNull
    private C_HenkinriyuuKbn ibHnknriyuukbn;

    public C_HenkinriyuuKbn getIbHnknriyuukbn() {
        return ibHnknriyuukbn;
    }

    public void setIbHnknriyuukbn(C_HenkinriyuuKbn pIbHnknriyuukbn) {
        ibHnknriyuukbn = pIbHnknriyuukbn;
    }

    @NotNull
    private BizDate ibFstpryosyuymd;

    public BizDate getIbFstpryosyuymd() {
        return ibFstpryosyuymd;
    }

    public void setIbFstpryosyuymd(BizDate pIbFstpryosyuymd) {
        ibFstpryosyuymd = pIbFstpryosyuymd;
    }

    @NotNull
    private String ibAatkisyabosyuucd;

    public String getIbAatkisyabosyuucd() {
        return ibAatkisyabosyuucd;
    }

    public void setIbAatkisyabosyuucd(String pIbAatkisyabosyuucd) {
        ibAatkisyabosyuucd = pIbAatkisyabosyuucd;
    }

    @NotNull
    private String ibRyouritusdno;

    public String getIbRyouritusdno() {
        return ibRyouritusdno;
    }

    public void setIbRyouritusdno(String pIbRyouritusdno) {
        ibRyouritusdno = pIbRyouritusdno;
    }

    @NotNull
    private String ibGyoumuKousinsyaId;

    public String getIbGyoumuKousinsyaId() {
        return ibGyoumuKousinsyaId;
    }

    public void setIbGyoumuKousinsyaId(String pIbGyoumuKousinsyaId) {
        ibGyoumuKousinsyaId = pIbGyoumuKousinsyaId;
    }

    @NotNull
    private Boolean ibKakokawaserateshiteiflg;

    public Boolean getIbKakokawaserateshiteiflg() {
        return ibKakokawaserateshiteiflg;
    }

    public void setIbKakokawaserateshiteiflg(Boolean pIbKakokawaserateshiteiflg) {
        ibKakokawaserateshiteiflg = pIbKakokawaserateshiteiflg;
    }

    private BizDate ibKakokawaserateshiteiymd;

    public BizDate getIbKakokawaserateshiteiymd() {
        return ibKakokawaserateshiteiymd;
    }

    public void setIbKakokawaserateshiteiymd(BizDate pIbKakokawaserateshiteiymd) {
        ibKakokawaserateshiteiymd = pIbKakokawaserateshiteiymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
