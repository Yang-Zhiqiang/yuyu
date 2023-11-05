package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.BizRate;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.db.mapping.AbstractExDBEntity;

/**
 * エンティティ初期化テスト用クラス<br />
 */
@SuppressWarnings("rawtypes")
public abstract class GenBizPropertyInitializerTestEntity extends AbstractExDBEntity {

    private static final long serialVersionUID = 1L;

    private BizCurrency bizCurrency;

    private BizDate bizDate;

    private BizNumber bizNumber;

    private Boolean bool;

    private Byte byt;

    private Integer inte;

    private C_KadouTimeSiteiKbn kbn;

    private Long lon;

    private String string;

    private BizDateMD bizDateMD;

    private BizDateY bizDateY;

    private BizDateYM bizDateYM;

    private BizRate bizRate;

    private byte[] byteList;

    private Double doubl;

    public C_KadouTimeSiteiKbn getKbn() {
        return kbn;
    }

    public void setKbn(C_KadouTimeSiteiKbn kbn) {
        this.kbn = kbn;
    }

    public BizDateMD getBizDateMD() {
        return bizDateMD;
    }

    public void setBizDateMD(BizDateMD bizDateMD) {
        this.bizDateMD = bizDateMD;
    }

    public BizDateY getBizDateY() {
        return bizDateY;
    }

    public void setBizDateY(BizDateY bizDateY) {
        this.bizDateY = bizDateY;
    }

    public BizDateYM getBizDateYM() {
        return bizDateYM;
    }

    public void setBizDateYM(BizDateYM bizDateYM) {
        this.bizDateYM = bizDateYM;
    }

    public BizDate getBizDate() {
        return bizDate;
    }

    public void setBizDate(BizDate bizDate) {
        this.bizDate = bizDate;
    }

    public BizCurrency getBizCurrency() {
        return bizCurrency;
    }

    public void setBizCurrency(BizCurrency bizCurrency) {
        this.bizCurrency = bizCurrency;
    }

    public BizRate getBizRate() {
        return bizRate;
    }

    public void setBizRate(BizRate bizRate) {
        this.bizRate = bizRate;
    }

    public BizNumber getBizNumber() {
        return bizNumber;
    }

    public void setBizNumber(BizNumber bizNumber) {
        this.bizNumber = bizNumber;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public byte[] getByteList() {
        return byteList;
    }

    public void setByteList(byte[] byteList) {
        this.byteList = byteList;
    }

    public Byte getByt() {
        return byt;
    }

    public void setByt(Byte byt) {
        this.byt = byt;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Long getLon() {
        return lon;
    }

    public void setLon(Long lon) {
        this.lon = lon;
    }

    public Integer getInte() {
        return inte;
    }

    public void setInte(Integer inte) {
        this.inte = inte;
    }

    public Double getDoubl() {
        return doubl;
    }

    public void setDoubl(Double doubl) {
        this.doubl = doubl;
    }

}
