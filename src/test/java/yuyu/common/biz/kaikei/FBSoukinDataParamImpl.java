package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.FBSoukinDataParam;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;

/**
 * 業務共通 経理・会計 ＦＢ送金データテーブルクラス
 */
public class FBSoukinDataParamImpl implements FBSoukinDataParam {

    private String fbsoukindatasikibetukey = null;
    private String denrenno = null;
    Integer edano = null;
    private C_DensysKbn densyskbn = null;
    private C_Gyoumucd gyoumucd = null;
    private C_Tantositucd tantositucd;
    private String syoricd = null;
    private String syorisosikicd = null;
    private BizDate syoriYmd = null;
    private BizDate denymd = null;
    private String syono = null;
    private C_ShrhousiteiKbn shrhousiteikbn = null;
    private String bankcd = null;
    private String sitencd = null;
    private C_YokinKbn yokinkbn = null;
    private String kouzano = null;
    private String kzmeiginmkn = null;
    private BizCurrency soukingk = null;
    private C_Tuukasyu kyktuukasyu = null;
    private BizCurrency gaikataikagk = null;
    private BizNumber soukinkwsrate = null;
    private String gyoumuKousinKinou = null;
    private String gyoumuKousinsyaId = null;
    private String gyoumuKousinTime = null;

    @Override
    public String getFbsoukindatasikibetukey() {
        return fbsoukindatasikibetukey;
    }

    @Override
    public void setFbsoukindatasikibetukey(String fbsoukindatasikibetukey) {
        this.fbsoukindatasikibetukey = fbsoukindatasikibetukey;
    }

    @Override
    public String getDenrenno() {
        return denrenno;
    }

    @Override
    public void setDenrenno(String denrenno) {
        this.denrenno = denrenno;
    }

    @Override
    public Integer getEdano() {
        return edano;
    }

    @Override
    public void setEdano(Integer edano) {
        this.edano = edano;
    }

    @Override
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    @Override
    public void setDensyskbn(C_DensysKbn densyskbn) {
        this.densyskbn = densyskbn;
    }

    @Override
    public C_Gyoumucd getGyoumucd() {
        return gyoumucd;
    }

    @Override
    public void setGyoumucd(C_Gyoumucd gyoumucd) {
        this.gyoumucd = gyoumucd;
    }

    @Override
    public C_Tantositucd getTantositucd() {
        return tantositucd;
    }

    @Override
    public void setTantositucd(C_Tantositucd tantositucd) {
        this.tantositucd = tantositucd;
    }

    @Override
    public String getSyoricd() {
        return syoricd;
    }

    @Override
    public void setSyoricd(String syoricd) {
        this.syoricd = syoricd;
    }

    @Override
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    @Override
    public void setSyorisosikicd(String syorisosikicd) {
        this.syorisosikicd = syorisosikicd;
    }

    @Override
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Override
    public void setSyoriYmd(BizDate syoriYmd) {
        this.syoriYmd = syoriYmd;
    }

    @Override
    public BizDate getDenymd() {
        return denymd;
    }

    @Override
    public void setDenymd(BizDate denymd) {
        this.denymd = denymd;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String syono) {
        this.syono = syono;
    }

    @Override
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    @Override
    public void setShrhousiteikbn(C_ShrhousiteiKbn shrhousiteikbn) {
        this.shrhousiteikbn = shrhousiteikbn;
    }

    @Override
    public String getBankcd() {
        return bankcd;
    }

    @Override
    public void setBankcd(String bankcd) {
        this.bankcd = bankcd;
    }

    @Override
    public String getSitencd() {
        return sitencd;
    }

    @Override
    public void setSitencd(String sitencd) {
        this.sitencd = sitencd;
    }

    @Override
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    @Override
    public void setYokinkbn(C_YokinKbn yokinkbn) {
        this.yokinkbn = yokinkbn;
    }

    @Override
    public String getKouzano() {
        return kouzano;
    }

    @Override
    public void setKouzano(String kouzano) {
        this.kouzano = kouzano;
    }

    @Override
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Override
    public void setKzmeiginmkn(String kzmeiginmkn) {
        this.kzmeiginmkn = kzmeiginmkn;
    }

    @Override
    public BizCurrency getSoukingk() {
        return soukingk;
    }

    @Override
    public void setSoukingk(BizCurrency soukingk) {
        this.soukingk = soukingk;
    }

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu kyktuukasyu) {
        this.kyktuukasyu = kyktuukasyu;
    }

    @Override
    public BizCurrency getGaikataikagk() {
        return gaikataikagk;
    }

    @Override
    public void setGaikataikagk(BizCurrency gaikataikagk) {
        this.gaikataikagk = gaikataikagk;
    }

    @Override
    public BizNumber getSoukinkwsrate() {
        return soukinkwsrate;
    }

    @Override
    public void setSoukinkwsrate(BizNumber soukinkwsrate) {
        this.soukinkwsrate = soukinkwsrate;
    }

    @Override
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    @Override
    public void setGyoumuKousinKinou(String gyoumuKousinKinou) {
        this.gyoumuKousinKinou = gyoumuKousinKinou;
    }

    @Override
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    @Override
    public void setGyoumuKousinsyaId(String gyoumuKousinsyaId) {
        this.gyoumuKousinsyaId = gyoumuKousinsyaId;
    }

    @Override
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    @Override
    public void setGyoumuKousinTime(String gyoumuKousinTime) {
        this.gyoumuKousinTime = gyoumuKousinTime;
    }
}
