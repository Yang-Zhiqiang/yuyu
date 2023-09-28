package yuyu.common.biz.kaikei;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * （共通）伝票データ情報登録BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzDenpyouDataTourokuBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzDenpyouDataTourokuBean() {
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
    private C_HuridensksKbn ibHuridenskskbn;

    public C_HuridensksKbn getIbHuridenskskbn() {
        return ibHuridenskskbn;
    }

    public void setIbHuridenskskbn(C_HuridensksKbn pIbHuridenskskbn) {
        ibHuridenskskbn = pIbHuridenskskbn;
    }

    @NotNull
    private C_DenhnknhouKbn ibDenhnknhoukbn;

    public C_DenhnknhouKbn getIbDenhnknhoukbn() {
        return ibDenhnknhoukbn;
    }

    public void setIbDenhnknhoukbn(C_DenhnknhouKbn pIbDenhnknhoukbn) {
        ibDenhnknhoukbn = pIbDenhnknhoukbn;
    }

    @NotNull
    private C_DenshrhouKbn ibDenshrhoukbn;

    public C_DenshrhouKbn getIbDenshrhoukbn() {
        return ibDenshrhoukbn;
    }

    public void setIbDenshrhoukbn(C_DenshrhouKbn pIbDenshrhoukbn) {
        ibDenshrhoukbn = pIbDenshrhoukbn;
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

    @NotNull
    private C_DenSyorisyousaiKbn ibDensyorisyousaikbn;

    public C_DenSyorisyousaiKbn getIbDensyorisyousaikbn() {
        return ibDensyorisyousaikbn;
    }

    public void setIbDensyorisyousaikbn(C_DenSyorisyousaiKbn pIbDensyorisyousaikbn) {
        ibDensyorisyousaikbn = pIbDensyorisyousaikbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
