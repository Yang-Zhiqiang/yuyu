package yuyu.def.biz.bean.mq;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＭＱ代理店手数料情報取得結果BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqDairitenTesuuryouInfoSyutokuKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqDairitenTesuuryouInfoSyutokuKekkaBean() {
    }

    @Column(order = 1, length = 4)
    private String iwsAcserrcd;

    public String getIwsAcserrcd() {
        return iwsAcserrcd;
    }

    public void setIwsAcserrcd(String pIwsAcserrcd) {
        iwsAcserrcd = pIwsAcserrcd;
    }

    @Column(order = 2, length = 1)
    private String iwsTsrsisankekkakbn;

    public String getIwsTsrsisankekkakbn() {
        return iwsTsrsisankekkakbn;
    }

    public void setIwsTsrsisankekkakbn(String pIwsTsrsisankekkakbn) {
        iwsTsrsisankekkakbn = pIwsTsrsisankekkakbn;
    }

    @Column(order = 3, length = 1)
    private String iwsKeijyouymsyoukaikekkakbn;

    public String getIwsKeijyouymsyoukaikekkakbn() {
        return iwsKeijyouymsyoukaikekkakbn;
    }

    public void setIwsKeijyouymsyoukaikekkakbn(String pIwsKeijyouymsyoukaikekkakbn) {
        iwsKeijyouymsyoukaikekkakbn = pIwsKeijyouymsyoukaikekkakbn;
    }

    @Column(order = 4, length = 11)
    private String iwsSyotsrygkyen;

    public String getIwsSyotsrygkyen() {
        return iwsSyotsrygkyen;
    }

    public void setIwsSyotsrygkyen(String pIwsSyotsrygkyen) {
        iwsSyotsrygkyen = pIwsSyotsrygkyen;
    }

    @Column(order = 5, length = 11)
    private String iwsSyotsrygkkyktuuka;

    public String getIwsSyotsrygkkyktuuka() {
        return iwsSyotsrygkkyktuuka;
    }

    public void setIwsSyotsrygkkyktuuka(String pIwsSyotsrygkkyktuuka) {
        iwsSyotsrygkkyktuuka = pIwsSyotsrygkkyktuuka;
    }

    @Column(order = 6, length = 11)
    private String iwsJitsrygkyen;

    public String getIwsJitsrygkyen() {
        return iwsJitsrygkyen;
    }

    public void setIwsJitsrygkyen(String pIwsJitsrygkyen) {
        iwsJitsrygkyen = pIwsJitsrygkyen;
    }

    @Column(order = 7, length = 11)
    private String iwsJitsrygkkyktuuka;

    public String getIwsJitsrygkkyktuuka() {
        return iwsJitsrygkkyktuuka;
    }

    public void setIwsJitsrygkkyktuuka(String pIwsJitsrygkkyktuuka) {
        iwsJitsrygkkyktuuka = pIwsJitsrygkkyktuuka;
    }

    @Column(order = 8, length = 7)
    private String iwsTsrycd;

    public String getIwsTsrycd() {
        return iwsTsrycd;
    }

    public void setIwsTsrycd(String pIwsTsrycd) {
        iwsTsrycd = pIwsTsrycd;
    }

    @Column(order = 9, length = 1)
    private String iwsSyotsrygktuukasyu;

    public String getIwsSyotsrygktuukasyu() {
        return iwsSyotsrygktuukasyu;
    }

    public void setIwsSyotsrygktuukasyu(String pIwsSyotsrygktuukasyu) {
        iwsSyotsrygktuukasyu = pIwsSyotsrygktuukasyu;
    }

    @Column(order = 10, length = 1)
    private String iwsJitsrygktuukasyu;

    public String getIwsJitsrygktuukasyu() {
        return iwsJitsrygktuukasyu;
    }

    public void setIwsJitsrygktuukasyu(String pIwsJitsrygktuukasyu) {
        iwsJitsrygktuukasyu = pIwsJitsrygktuukasyu;
    }

    @Column(order = 11, length = 38)
    private String iwsYobiv38;

    public String getIwsYobiv38() {
        return iwsYobiv38;
    }

    public void setIwsYobiv38(String pIwsYobiv38) {
        iwsYobiv38 = pIwsYobiv38;
    }

    @Column(order = 12, length = 11)
    private String iwsSyotsryruigkyen;

    public String getIwsSyotsryruigkyen() {
        return iwsSyotsryruigkyen;
    }

    public void setIwsSyotsryruigkyen(String pIwsSyotsryruigkyen) {
        iwsSyotsryruigkyen = pIwsSyotsryruigkyen;
    }

    @Column(order = 13, length = 11)
    private String iwsSyotsryruigkgaika;

    public String getIwsSyotsryruigkgaika() {
        return iwsSyotsryruigkgaika;
    }

    public void setIwsSyotsryruigkgaika(String pIwsSyotsryruigkgaika) {
        iwsSyotsryruigkgaika = pIwsSyotsryruigkgaika;
    }

    @Column(order = 14, length = 1)
    private String iwsSyotsryruigktuukasyu;

    public String getIwsSyotsryruigktuukasyu() {
        return iwsSyotsryruigktuukasyu;
    }

    public void setIwsSyotsryruigktuukasyu(String pIwsSyotsryruigktuukasyu) {
        iwsSyotsryruigktuukasyu = pIwsSyotsryruigktuukasyu;
    }

    @Column(order = 15, length = 11)
    private String iwsJitsryruigkyen;

    public String getIwsJitsryruigkyen() {
        return iwsJitsryruigkyen;
    }

    public void setIwsJitsryruigkyen(String pIwsJitsryruigkyen) {
        iwsJitsryruigkyen = pIwsJitsryruigkyen;
    }

    @Column(order = 16, length = 11)
    private String iwsJitsryruigkgaika;

    public String getIwsJitsryruigkgaika() {
        return iwsJitsryruigkgaika;
    }

    public void setIwsJitsryruigkgaika(String pIwsJitsryruigkgaika) {
        iwsJitsryruigkgaika = pIwsJitsryruigkgaika;
    }

    @Column(order = 17, length = 1)
    private String iwsJitsryruigktuukasyu;

    public String getIwsJitsryruigktuukasyu() {
        return iwsJitsryruigktuukasyu;
    }

    public void setIwsJitsryruigktuukasyu(String pIwsJitsryruigktuukasyu) {
        iwsJitsryruigktuukasyu = pIwsJitsryruigktuukasyu;
    }

    @Column(order = 18, length = 11)
    private String iwsSoutsrygkyen;

    public String getIwsSoutsrygkyen() {
        return iwsSoutsrygkyen;
    }

    public void setIwsSoutsrygkyen(String pIwsSoutsrygkyen) {
        iwsSoutsrygkyen = pIwsSoutsrygkyen;
    }

    @Column(order = 19, length = 11)
    private String iwsSoutsrygkgaika;

    public String getIwsSoutsrygkgaika() {
        return iwsSoutsrygkgaika;
    }

    public void setIwsSoutsrygkgaika(String pIwsSoutsrygkgaika) {
        iwsSoutsrygkgaika = pIwsSoutsrygkgaika;
    }

    @Column(order = 20, length = 1)
    private String iwsSoutsrygktuukasyu;

    public String getIwsSoutsrygktuukasyu() {
        return iwsSoutsrygktuukasyu;
    }

    public void setIwsSoutsrygktuukasyu(String pIwsSoutsrygktuukasyu) {
        iwsSoutsrygktuukasyu = pIwsSoutsrygktuukasyu;
    }

    @Column(order = 21, length = 19)
    private String iwsYobiv19;

    public String getIwsYobiv19() {
        return iwsYobiv19;
    }

    public void setIwsYobiv19(String pIwsYobiv19) {
        iwsYobiv19 = pIwsYobiv19;
    }

    @Column(order = 22, length = 6)
    private String iwsKeijyouymstr;

    public String getIwsKeijyouymstr() {
        return iwsKeijyouymstr;
    }

    public void setIwsKeijyouymstr(String pIwsKeijyouymstr) {
        iwsKeijyouymstr = pIwsKeijyouymstr;
    }

    @Column(order = 23, length = 55)
    private String iwsYobiv55;

    public String getIwsYobiv55() {
        return iwsYobiv55;
    }

    public void setIwsYobiv55(String pIwsYobiv55) {
        iwsYobiv55 = pIwsYobiv55;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
