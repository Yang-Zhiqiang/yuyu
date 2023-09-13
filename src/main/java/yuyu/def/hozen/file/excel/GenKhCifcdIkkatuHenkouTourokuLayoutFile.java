package yuyu.def.hozen.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （保全）ＣＩＦコード一括変更登録レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenKhCifcdIkkatuHenkouTourokuLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenKhCifcdIkkatuHenkouTourokuLayoutFile() {
    }

    @Column(order = 1, label = "証券番号")
    private String ifeSyono;

    public String getIfeSyono() {
        return ifeSyono;
    }

    public void setIfeSyono(String pIfeSyono) {
        ifeSyono = pIfeSyono;
    }

    @Column(order = 2, label = "ＣＩＦコード")
    private String ifecifcd;

    public String getIfecifcd() {
        return ifecifcd;
    }

    public void setIfecifcd(String pIfecifcd) {
        ifecifcd = pIfecifcd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
