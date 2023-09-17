package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;

/**
 * （共通）専用帳票一括印刷送信ファイル（無効通知レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzIkkatuinsatuMukouTuutiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzIkkatuinsatuMukouTuutiLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）レコード区分")
    private String ifcRecordkbn;

    public String getIfcRecordkbn() {
        return ifcRecordkbn;
    }

    public void setIfcRecordkbn(String pIfcRecordkbn) {
        ifcRecordkbn = pIfcRecordkbn;
    }

    @Column(order = 2, label = "（ＩＦｃ）書類コード")
    private String ifcSyoruicd;

    public String getIfcSyoruicd() {
        return ifcSyoruicd;
    }

    public void setIfcSyoruicd(String pIfcSyoruicd) {
        ifcSyoruicd = pIfcSyoruicd;
    }

    @Column(order = 3, label = "（ＩＦｃ）一連番号")
    private String ifcItirenno;

    public String getIfcItirenno() {
        return ifcItirenno;
    }

    public void setIfcItirenno(String pIfcItirenno) {
        ifcItirenno = pIfcItirenno;
    }

    @Column(order = 4, label = "（ＩＦｃ）証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 5, label = "（ＩＦｃ）帳票作成日")
    private BizDate ifcTyouhyousakuseiymd;

    public BizDate getIfcTyouhyousakuseiymd() {
        return ifcTyouhyousakuseiymd;
    }

    public void setIfcTyouhyousakuseiymd(BizDate pIfcTyouhyousakuseiymd) {
        ifcTyouhyousakuseiymd = pIfcTyouhyousakuseiymd;
    }

    @Column(order = 6, label = "（ＩＦｃ）代理店コード")
    private String ifcDrtencd;

    public String getIfcDrtencd() {
        return ifcDrtencd;
    }

    public void setIfcDrtencd(String pIfcDrtencd) {
        ifcDrtencd = pIfcDrtencd;
    }

    @Column(order = 7, label = "（ＩＦｃ）代理店名（漢字）")
    private String ifcDrtennmkj;

    public String getIfcDrtennmkj() {
        return ifcDrtennmkj;
    }

    public void setIfcDrtennmkj(String pIfcDrtennmkj) {
        ifcDrtennmkj = pIfcDrtennmkj;
    }

    @Column(order = 8, label = "（ＩＦｃ）通信先郵便番号")
    private String ifcTsinyno;

    public String getIfcTsinyno() {
        return ifcTsinyno;
    }

    public void setIfcTsinyno(String pIfcTsinyno) {
        ifcTsinyno = pIfcTsinyno;
    }

    @Column(order = 9, label = "（ＩＦｃ）通信先住所１（漢字）")
    private String ifcTsinadr1kj;

    public String getIfcTsinadr1kj() {
        return ifcTsinadr1kj;
    }

    public void setIfcTsinadr1kj(String pIfcTsinadr1kj) {
        ifcTsinadr1kj = pIfcTsinadr1kj;
    }

    @Column(order = 10, label = "（ＩＦｃ）通信先住所２（漢字）")
    private String ifcTsinadr2kj;

    public String getIfcTsinadr2kj() {
        return ifcTsinadr2kj;
    }

    public void setIfcTsinadr2kj(String pIfcTsinadr2kj) {
        ifcTsinadr2kj = pIfcTsinadr2kj;
    }

    @Column(order = 11, label = "（ＩＦｃ）通信先住所３（漢字）")
    private String ifcTsinadr3kj;

    public String getIfcTsinadr3kj() {
        return ifcTsinadr3kj;
    }

    public void setIfcTsinadr3kj(String pIfcTsinadr3kj) {
        ifcTsinadr3kj = pIfcTsinadr3kj;
    }

    @Column(order = 12, label = "（ＩＦｃ）通信先住所４（漢字）")
    private String ifcTsinadr4kj;

    public String getIfcTsinadr4kj() {
        return ifcTsinadr4kj;
    }

    public void setIfcTsinadr4kj(String pIfcTsinadr4kj) {
        ifcTsinadr4kj = pIfcTsinadr4kj;
    }

    @Column(order = 13, label = "（ＩＦｃ）契約者名（漢字）")
    private String ifcKyknmkj;

    public String getIfcKyknmkj() {
        return ifcKyknmkj;
    }

    public void setIfcKyknmkj(String pIfcKyknmkj) {
        ifcKyknmkj = pIfcKyknmkj;
    }

    @Column(order = 14, label = "（ＩＦｃ）被保険者名（漢字）")
    private String ifcHhknnmkj;

    public String getIfcHhknnmkj() {
        return ifcHhknnmkj;
    }

    public void setIfcHhknnmkj(String pIfcHhknnmkj) {
        ifcHhknnmkj = pIfcHhknnmkj;
    }

    @Column(order = 15, label = "（ＩＦｃ）契約日")
    private BizDate ifcKykymd;

    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }

    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }

    @Column(order = 16, label = "（ＩＦｃ）払込保険料")
    private String ifcHrkp;

    public String getIfcHrkp() {
        return ifcHrkp;
    }

    public void setIfcHrkp(String pIfcHrkp) {
        ifcHrkp = pIfcHrkp;
    }

    @Column(order = 17, label = "（ＩＦｃ）払込回数")
    private C_Hrkkaisuu ifcHrkkaisuu;

    public C_Hrkkaisuu getIfcHrkkaisuu() {
        return ifcHrkkaisuu;
    }

    public void setIfcHrkkaisuu(C_Hrkkaisuu pIfcHrkkaisuu) {
        ifcHrkkaisuu = pIfcHrkkaisuu;
    }

    @Column(order = 18, label = "（ＩＦｃ）猶予期間満了日")
    private BizDate ifcYykknmnryymd;

    public BizDate getIfcYykknmnryymd() {
        return ifcYykknmnryymd;
    }

    public void setIfcYykknmnryymd(BizDate pIfcYykknmnryymd) {
        ifcYykknmnryymd = pIfcYykknmnryymd;
    }

    @Column(order = 19, label = "（ＩＦｃ）取扱コード")
    private Integer ifcTratkicd;

    public Integer getIfcTratkicd() {
        return ifcTratkicd;
    }

    public void setIfcTratkicd(Integer pIfcTratkicd) {
        ifcTratkicd = pIfcTratkicd;
    }

    @Column(order = 20, label = "（ＩＦｃ）帳票コード")
    private String ifcTyouhyoucd;

    public String getIfcTyouhyoucd() {
        return ifcTyouhyoucd;
    }

    public void setIfcTyouhyoucd(String pIfcTyouhyoucd) {
        ifcTyouhyoucd = pIfcTyouhyoucd;
    }

    @Column(order = 21, label = "（ＩＦｃ）帳票連絡先識別区分")
    private C_TyhyrenrakusikibetuKbn ifcTyhyrenrakusikibetukbn;

    public C_TyhyrenrakusikibetuKbn getIfcTyhyrenrakusikibetukbn() {
        return ifcTyhyrenrakusikibetukbn;
    }

    public void setIfcTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pIfcTyhyrenrakusikibetukbn) {
        ifcTyhyrenrakusikibetukbn = pIfcTyhyrenrakusikibetukbn;
    }

    @Column(order = 22, label = "（ＩＦｃ）エンド")
    private String ifcEnd;

    public String getIfcEnd() {
        return ifcEnd;
    }

    public void setIfcEnd(String pIfcEnd) {
        ifcEnd = pIfcEnd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
