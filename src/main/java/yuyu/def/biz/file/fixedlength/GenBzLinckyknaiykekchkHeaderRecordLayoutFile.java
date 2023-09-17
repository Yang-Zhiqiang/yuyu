package yuyu.def.biz.file.fixedlength;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）契約内容ＬＩＮＣ結果Ｆ（ヘッダーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzLinckyknaiykekchkHeaderRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzLinckyknaiykekchkHeaderRecordLayoutFile() {
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
    private String iffLincgyoumusyubetu;

    public String getIffLincgyoumusyubetu() {
        return iffLincgyoumusyubetu;
    }

    public void setIffLincgyoumusyubetu(String pIffLincgyoumusyubetu) {
        iffLincgyoumusyubetu = pIffLincgyoumusyubetu;
    }

    @Column(order = 3, length = 1)
    private String iffLinccdkbn;

    public String getIffLinccdkbn() {
        return iffLinccdkbn;
    }

    public void setIffLinccdkbn(String pIffLinccdkbn) {
        iffLinccdkbn = pIffLinccdkbn;
    }

    @Column(order = 4, length = 10)
    private String iffLincseihocd;

    public String getIffLincseihocd() {
        return iffLincseihocd;
    }

    public void setIffLincseihocd(String pIffLincseihocd) {
        iffLincseihocd = pIffLincseihocd;
    }

    @Column(order = 5, length = 8)
    private String iffLincsousinymd;

    public String getIffLincsousinymd() {
        return iffLincsousinymd;
    }

    public void setIffLincsousinymd(String pIffLincsousinymd) {
        iffLincsousinymd = pIffLincsousinymd;
    }

    @Column(order = 6, length = 2)
    private String iffLincdatasyubetu;

    public String getIffLincdatasyubetu() {
        return iffLincdatasyubetu;
    }

    public void setIffLincdatasyubetu(String pIffLincdatasyubetu) {
        iffLincdatasyubetu = pIffLincdatasyubetu;
    }

    @Column(order = 7, length = 1)
    private String iffLinckaitoukurikosi;

    public String getIffLinckaitoukurikosi() {
        return iffLinckaitoukurikosi;
    }

    public void setIffLinckaitoukurikosi(String pIffLinckaitoukurikosi) {
        iffLinckaitoukurikosi = pIffLinckaitoukurikosi;
    }

    @Column(order = 8, length = 575)
    private String iffDummy575;

    public String getIffDummy575() {
        return iffDummy575;
    }

    public void setIffDummy575(String pIffDummy575) {
        iffDummy575 = pIffDummy575;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
