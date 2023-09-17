package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_YokinKbn;

/**
 * （共通）振込入金ファイル（ヘッダーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzHurikominyuukinHeaderRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzHurikominyuukinHeaderRecordLayoutFile() {
    }

    @Column(order = 1, length = 1)
    private String iffDatakbn;

    public String getIffDatakbn() {
        return iffDatakbn;
    }

    public void setIffDatakbn(String pIffDatakbn) {
        iffDatakbn = pIffDatakbn;
    }

    @Column(order = 2, length = 2)
    private String iffSyubetucd;

    public String getIffSyubetucd() {
        return iffSyubetucd;
    }

    public void setIffSyubetucd(String pIffSyubetucd) {
        iffSyubetucd = pIffSyubetucd;
    }

    @Column(order = 3, length = 1)
    private String iffCdkbn;

    public String getIffCdkbn() {
        return iffCdkbn;
    }

    public void setIffCdkbn(String pIffCdkbn) {
        iffCdkbn = pIffCdkbn;
    }

    @Column(order = 4, length = 6)
    private String iffSakuseiymdwareki;

    public String getIffSakuseiymdwareki() {
        return iffSakuseiymdwareki;
    }

    public void setIffSakuseiymdwareki(String pIffSakuseiymdwareki) {
        iffSakuseiymdwareki = pIffSakuseiymdwareki;
    }

    @Column(order = 5, length = 6)
    private String iffKnjyymdfromwareki;

    public String getIffKnjyymdfromwareki() {
        return iffKnjyymdfromwareki;
    }

    public void setIffKnjyymdfromwareki(String pIffKnjyymdfromwareki) {
        iffKnjyymdfromwareki = pIffKnjyymdfromwareki;
    }

    @Column(order = 6, length = 6)
    private String iffKnjyymdtowareki;

    public String getIffKnjyymdtowareki() {
        return iffKnjyymdtowareki;
    }

    public void setIffKnjyymdtowareki(String pIffKnjyymdtowareki) {
        iffKnjyymdtowareki = pIffKnjyymdtowareki;
    }

    @Column(order = 7, length = 4)
    private String iffBankcd;

    public String getIffBankcd() {
        return iffBankcd;
    }

    public void setIffBankcd(String pIffBankcd) {
        iffBankcd = pIffBankcd;
    }

    @Column(order = 8, length = 15)
    private String iffBanknmkn15;

    public String getIffBanknmkn15() {
        return iffBanknmkn15;
    }

    public void setIffBanknmkn15(String pIffBanknmkn15) {
        iffBanknmkn15 = pIffBanknmkn15;
    }

    @Column(order = 9, length = 3)
    private String iffSitencd;

    public String getIffSitencd() {
        return iffSitencd;
    }

    public void setIffSitencd(String pIffSitencd) {
        iffSitencd = pIffSitencd;
    }

    @Column(order = 10, length = 15)
    private String iffSitennmkn15;

    public String getIffSitennmkn15() {
        return iffSitennmkn15;
    }

    public void setIffSitennmkn15(String pIffSitennmkn15) {
        iffSitennmkn15 = pIffSitennmkn15;
    }

    @Column(order = 11, length = 3)
    private String iffDummy3;

    public String getIffDummy3() {
        return iffDummy3;
    }

    public void setIffDummy3(String pIffDummy3) {
        iffDummy3 = pIffDummy3;
    }

    @Column(order = 12, length = 1)
    private C_YokinKbn iffInterfyokinkbn;

    public C_YokinKbn getIffInterfyokinkbn() {
        return iffInterfyokinkbn;
    }

    public void setIffInterfyokinkbn(C_YokinKbn pIffInterfyokinkbn) {
        iffInterfyokinkbn = pIffInterfyokinkbn;
    }

    @Column(order = 13, length = 10)
    private String iffKouzano10;

    public String getIffKouzano10() {
        return iffKouzano10;
    }

    public void setIffKouzano10(String pIffKouzano10) {
        iffKouzano10 = pIffKouzano10;
    }

    @Column(order = 14, length = 40)
    private String iffKznmkn;

    public String getIffKznmkn() {
        return iffKznmkn;
    }

    public void setIffKznmkn(String pIffKznmkn) {
        iffKznmkn = pIffKznmkn;
    }

    @Column(order = 15, length = 1)
    private Integer iffKasikosikbn;

    public Integer getIffKasikosikbn() {
        return iffKasikosikbn;
    }

    public void setIffKasikosikbn(Integer pIffKasikosikbn) {
        iffKasikosikbn = pIffKasikosikbn;
    }

    @Column(order = 16, length = 1)
    private Integer iffTuutyousysykbn;

    public Integer getIffTuutyousysykbn() {
        return iffTuutyousysykbn;
    }

    public void setIffTuutyousysykbn(Integer pIffTuutyousysykbn) {
        iffTuutyousysykbn = pIffTuutyousysykbn;
    }

    @Column(order = 17, length = 14)
    private String iffTrhkmaezndk;

    public String getIffTrhkmaezndk() {
        return iffTrhkmaezndk;
    }

    public void setIffTrhkmaezndk(String pIffTrhkmaezndk) {
        iffTrhkmaezndk = pIffTrhkmaezndk;
    }

    @Column(order = 18, length = 71)
    private String iffDummytwo71;

    public String getIffDummytwo71() {
        return iffDummytwo71;
    }

    public void setIffDummytwo71(String pIffDummytwo71) {
        iffDummytwo71 = pIffDummytwo71;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
