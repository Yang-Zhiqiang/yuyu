package yuyu.common.biz.kaikei;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.GkFBSoukinDataParam;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;


/**
 * 業務共通 経理・会計 外貨ＦＢ送金データテーブルクラス
 */
public class GkFBSoukinDataParamImpl implements GkFBSoukinDataParam{

    private static final long serialVersionUID = 1L;

    public String fbsoukindatasikibetukey;
    private String denrenno;
    private Integer edano;
    private C_DensysKbn densyskbn;
    private C_Gkgyoumucd gkgyoumucd;
    private C_Tantositucd tantositucd;
    private String syoricd;
    private String syorisosikicd;
    private BizDate syoriYmd;
    private BizDate denymd;
    private String syono;
    private C_ShrhousiteiKbn shrhousiteikbn;
    private String bankcd;
    private String banknmej;
    private String sitencd;
    private String sitennmej;
    private String kouzano;
    private String kzmeiginmei;
    private C_Tuukasyu shrtuukasyu;
    private BizCurrency gaikashrgk;
    private C_Tuukasyu kyktuukasyu;
    private BizCurrency crossrateshrgk;
    private BizNumber soukinkwsrate;
    private String irninnmei;
    private String gyoumuKousinKinou;
    private String gyoumuKousinsyaId;
    private String gyoumuKousinTime;



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
    public C_Gkgyoumucd getGkgyoumucd() {
        return gkgyoumucd;
    }
    @Override
    public void setGkgyoumucd(C_Gkgyoumucd gkgyoumucd) {
        this.gkgyoumucd = gkgyoumucd;
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
    public String getBanknmej() {
        return banknmej;
    }
    @Override
    public void setBanknmej(String banknmej) {
        this.banknmej = banknmej;
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
    public String getSitennmej() {
        return sitennmej;
    }
    @Override
    public void setSitennmej(String sitennmej) {
        this.sitennmej = sitennmej;
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
    public String getKzmeiginmei() {
        return kzmeiginmei;
    }
    @Override
    public void setKzmeiginmei(String kzmeiginmei) {
        this.kzmeiginmei = kzmeiginmei;
    }
    @Override
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }
    @Override
    public void setShrtuukasyu(C_Tuukasyu shrtuukasyu) {
        this.shrtuukasyu = shrtuukasyu;
    }
    @Override
    public BizCurrency getGaikashrgk() {
        return gaikashrgk;
    }
    @Override
    public void setGaikashrgk(BizCurrency gaikashrgk) {
        this.gaikashrgk = gaikashrgk;
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
    public BizCurrency getCrossrateshrgk() {
        return crossrateshrgk;
    }
    @Override
    public void setCrossrateshrgk(BizCurrency crossrateshrgk) {
        this.crossrateshrgk = crossrateshrgk;
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
    public String getIrninnmei() {
        return irninnmei;
    }
    @Override
    public void setIrninnmei(String irninnmei) {
        this.irninnmei = irninnmei;
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

