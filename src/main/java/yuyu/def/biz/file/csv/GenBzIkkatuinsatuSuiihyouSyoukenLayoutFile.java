package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）専用帳票一括印刷送信ファイル（推移表レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzIkkatuinsatuSuiihyouSyoukenLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzIkkatuinsatuSuiihyouSyoukenLayoutFile() {
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

    @Column(order = 6, label = "（ＩＦｃ）経過年数")
    private Integer ifcKeikanensuu;

    public Integer getIfcKeikanensuu() {
        return ifcKeikanensuu;
    }

    public void setIfcKeikanensuu(Integer pIfcKeikanensuu) {
        ifcKeikanensuu = pIfcKeikanensuu;
    }

    @Column(order = 7, label = "（ＩＦｃ）被保険者年齢")
    private Integer ifcHhknnen;

    public Integer getIfcHhknnen() {
        return ifcHhknnen;
    }

    public void setIfcHhknnen(Integer pIfcHhknnen) {
        ifcHhknnen = pIfcHhknnen;
    }

    @Column(order = 8, label = "（ＩＦｃ）主契約保険料積立金")
    private String ifcSyuptumitatekin;

    public String getIfcSyuptumitatekin() {
        return ifcSyuptumitatekin;
    }

    public void setIfcSyuptumitatekin(String pIfcSyuptumitatekin) {
        ifcSyuptumitatekin = pIfcSyuptumitatekin;
    }

    @Column(order = 9, label = "（ＩＦｃ）主契約死亡S")
    private String ifcSyusbs;

    public String getIfcSyusbs() {
        return ifcSyusbs;
    }

    public void setIfcSyusbs(String pIfcSyusbs) {
        ifcSyusbs = pIfcSyusbs;
    }

    @Column(order = 10, label = "（ＩＦｃ）特約保険料積立金")
    private String ifcTkptumitatekin;

    public String getIfcTkptumitatekin() {
        return ifcTkptumitatekin;
    }

    public void setIfcTkptumitatekin(String pIfcTkptumitatekin) {
        ifcTkptumitatekin = pIfcTkptumitatekin;
    }

    @Column(order = 11, label = "（ＩＦｃ）特約死亡S")
    private String ifcTksbs;

    public String getIfcTksbs() {
        return ifcTksbs;
    }

    public void setIfcTksbs(String pIfcTksbs) {
        ifcTksbs = pIfcTksbs;
    }

    @Column(order = 12, label = "（ＩＦｃ）合計保険料積立金")
    private String ifcSumptumitatekin;

    public String getIfcSumptumitatekin() {
        return ifcSumptumitatekin;
    }

    public void setIfcSumptumitatekin(String pIfcSumptumitatekin) {
        ifcSumptumitatekin = pIfcSumptumitatekin;
    }

    @Column(order = 13, label = "（ＩＦｃ）合計死亡S")
    private String ifcSumsbs;

    public String getIfcSumsbs() {
        return ifcSumsbs;
    }

    public void setIfcSumsbs(String pIfcSumsbs) {
        ifcSumsbs = pIfcSumsbs;
    }

    @Column(order = 14, label = "（ＩＦｃ）エンド")
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
