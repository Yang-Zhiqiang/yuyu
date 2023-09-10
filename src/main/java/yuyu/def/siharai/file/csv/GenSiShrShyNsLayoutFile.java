package yuyu.def.siharai.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）支払所要日数情報レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiShrShyNsLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiShrShyNsLayoutFile() {
    }


    @Column(order = 1, label = "処理組織コード")
    @NotNull
    private String ifcSyorisosikicd;


    public String getIfcSyorisosikicd() {
        return ifcSyorisosikicd;
    }


    public void setIfcSyorisosikicd(String pIfcSyorisosikicd) {
        ifcSyorisosikicd = pIfcSyorisosikicd;
    }


    @Column(order = 2, label = "処理コード")
    @NotNull
    private String ifcSyoricd;


    public String getIfcSyoricd() {
        return ifcSyoricd;
    }


    public void setIfcSyoricd(String pIfcSyoricd) {
        ifcSyoricd = pIfcSyoricd;
    }


    @Column(order = 3, label = "保険金支払処理選択番号")
    private String ifcHknknshrsntkno;


    public String getIfcHknknshrsntkno() {
        return ifcHknknshrsntkno;
    }


    public void setIfcHknknshrsntkno(String pIfcHknknshrsntkno) {
        ifcHknknshrsntkno = pIfcHknknshrsntkno;
    }


    @Column(order = 4, label = "書類受付年月日")
    private BizDate ifcSyoruiukeymd;


    public BizDate getIfcSyoruiukeymd() {
        return ifcSyoruiukeymd;
    }


    public void setIfcSyoruiukeymd(BizDate pIfcSyoruiukeymd) {
        ifcSyoruiukeymd = pIfcSyoruiukeymd;
    }


    @Column(order = 5, label = "処理年月日")
    private BizDate ifcSyoriymd;


    public BizDate getIfcSyoriymd() {
        return ifcSyoriymd;
    }


    public void setIfcSyoriymd(BizDate pIfcSyoriymd) {
        ifcSyoriymd = pIfcSyoriymd;
    }


    @Column(order = 6, label = "伝票日付")
    private BizDate ifcDenpyouymd;


    public BizDate getIfcDenpyouymd() {
        return ifcDenpyouymd;
    }


    public void setIfcDenpyouymd(BizDate pIfcDenpyouymd) {
        ifcDenpyouymd = pIfcDenpyouymd;
    }


    @Column(order = 7, label = "書類受付経過営業日数")
    private Integer ifcSyoruikeikaeigyoubisuu;


    public Integer getIfcSyoruikeikaeigyoubisuu() {
        return ifcSyoruikeikaeigyoubisuu;
    }


    public void setIfcSyoruikeikaeigyoubisuu(Integer pIfcSyoruikeikaeigyoubisuu) {
        ifcSyoruikeikaeigyoubisuu = pIfcSyoruikeikaeigyoubisuu;
    }


    @Column(order = 8, label = "処理経過営業日数")
    private Integer ifcSyorikeikaeigyoubisuu;


    public Integer getIfcSyorikeikaeigyoubisuu() {
        return ifcSyorikeikaeigyoubisuu;
    }


    public void setIfcSyorikeikaeigyoubisuu(Integer pIfcSyorikeikaeigyoubisuu) {
        ifcSyorikeikaeigyoubisuu = pIfcSyorikeikaeigyoubisuu;
    }


    @Column(order = 9, label = "取次組織コード")
    private String ifcToritugisosikicd;


    public String getIfcToritugisosikicd() {
        return ifcToritugisosikicd;
    }


    public void setIfcToritugisosikicd(String pIfcToritugisosikicd) {
        ifcToritugisosikicd = pIfcToritugisosikicd;
    }


    @Column(order = 10, label = "端末種類区分")
    private String ifcTanmatusyuruikbn;


    public String getIfcTanmatusyuruikbn() {
        return ifcTanmatusyuruikbn;
    }


    public void setIfcTanmatusyuruikbn(String pIfcTanmatusyuruikbn) {
        ifcTanmatusyuruikbn = pIfcTanmatusyuruikbn;
    }


    @Column(order = 11, label = "証券番号")
    @NotNull
    private String ifcSyono;


    public String getIfcSyono() {
        return ifcSyono;
    }


    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }


    @Column(order = 12, label = "契約年月日")
    private BizDate ifcKykymd;


    public BizDate getIfcKykymd() {
        return ifcKykymd;
    }


    public void setIfcKykymd(BizDate pIfcKykymd) {
        ifcKykymd = pIfcKykymd;
    }


    @Column(order = 13, label = "不備解消年月日")
    private BizDate ifcKaisyouymd;


    public BizDate getIfcKaisyouymd() {
        return ifcKaisyouymd;
    }


    public void setIfcKaisyouymd(BizDate pIfcKaisyouymd) {
        ifcKaisyouymd = pIfcKaisyouymd;
    }


    @Column(order = 14, label = "延伸区分")
    private String ifcEnsinkbn;


    public String getIfcEnsinkbn() {
        return ifcEnsinkbn;
    }


    public void setIfcEnsinkbn(String pIfcEnsinkbn) {
        ifcEnsinkbn = pIfcEnsinkbn;
    }


    @Column(order = 15, label = "中断日数")
    private Integer ifcTdnnissuu;


    public Integer getIfcTdnnissuu() {
        return ifcTdnnissuu;
    }


    public void setIfcTdnnissuu(Integer pIfcTdnnissuu) {
        ifcTdnnissuu = pIfcTdnnissuu;
    }


    @Column(order = 16, label = "書類受付不備経過基準日")
    private BizDate ifcSyrhubikeikakijyunbi;


    public BizDate getIfcSyrhubikeikakijyunbi() {
        return ifcSyrhubikeikakijyunbi;
    }


    public void setIfcSyrhubikeikakijyunbi(BizDate pIfcSyrhubikeikakijyunbi) {
        ifcSyrhubikeikakijyunbi = pIfcSyrhubikeikakijyunbi;
    }


    @Column(order = 17, label = "書類受付不備経過営業日数")
    private Integer ifcSyrhubikeikaegybisuu;


    public Integer getIfcSyrhubikeikaegybisuu() {
        return ifcSyrhubikeikaegybisuu;
    }


    public void setIfcSyrhubikeikaegybisuu(Integer pIfcSyrhubikeikaegybisuu) {
        ifcSyrhubikeikaegybisuu = pIfcSyrhubikeikaegybisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
