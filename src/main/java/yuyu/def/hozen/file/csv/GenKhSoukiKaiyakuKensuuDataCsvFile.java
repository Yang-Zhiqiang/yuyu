package yuyu.def.hozen.file.csv;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）早期解約件数データＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhSoukiKaiyakuKensuuDataCsvFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhSoukiKaiyakuKensuuDataCsvFile() {
    }

    @Column(order = 1, label = "早期解約件数")
    @NotNull
    private String ifcSkikaiykkensuu;

    public String getIfcSkikaiykkensuu() {
        return ifcSkikaiykkensuu;
    }

    public void setIfcSkikaiykkensuu(String pIfcSkikaiykkensuu) {
        ifcSkikaiykkensuu = pIfcSkikaiykkensuu;
    }

    @Column(order = 2, label = "前納契約早期解約件数")
    @NotNull
    private String ifcSkikaiykkensuuznkizennou;

    public String getIfcSkikaiykkensuuznkizennou() {
        return ifcSkikaiykkensuuznkizennou;
    }

    public void setIfcSkikaiykkensuuznkizennou(String pIfcSkikaiykkensuuznkizennou) {
        ifcSkikaiykkensuuznkizennou = pIfcSkikaiykkensuuznkizennou;
    }

    @Column(order = 3, label = "一時払い契約早期解約件数")
    @NotNull
    private String ifcSkikaiykkensuuitiji;

    public String getIfcSkikaiykkensuuitiji() {
        return ifcSkikaiykkensuuitiji;
    }

    public void setIfcSkikaiykkensuuitiji(String pIfcSkikaiykkensuuitiji) {
        ifcSkikaiykkensuuitiji = pIfcSkikaiykkensuuitiji;
    }

    @Column(order = 4, label = "一時払い契約３年以内解約件数")
    @NotNull
    private String ifcSkikaiykkensuuitiji3y;

    public String getIfcSkikaiykkensuuitiji3y() {
        return ifcSkikaiykkensuuitiji3y;
    }

    public void setIfcSkikaiykkensuuitiji3y(String pIfcSkikaiykkensuuitiji3y) {
        ifcSkikaiykkensuuitiji3y = pIfcSkikaiykkensuuitiji3y;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
