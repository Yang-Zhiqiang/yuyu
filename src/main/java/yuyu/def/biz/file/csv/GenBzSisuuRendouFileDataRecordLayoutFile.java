package yuyu.def.biz.file.csv;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Sisuukbn;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）指数連動ファイル（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSisuuRendouFileDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSisuuRendouFileDataRecordLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）指数区分")
    private C_Sisuukbn ifcSisuukbn;

    public C_Sisuukbn getIfcSisuukbn() {
        return ifcSisuukbn;
    }

    public void setIfcSisuukbn(C_Sisuukbn pIfcSisuukbn) {
        ifcSisuukbn = pIfcSisuukbn;
    }

    @Column(order = 2, label = "（ＩＦｃ）指数公表日")
    private BizDate ifcSisuukouhyouymd;

    public BizDate getIfcSisuukouhyouymd() {
        return ifcSisuukouhyouymd;
    }

    public void setIfcSisuukouhyouymd(BizDate pIfcSisuukouhyouymd) {
        ifcSisuukouhyouymd = pIfcSisuukouhyouymd;
    }

    @Column(order = 3, label = "（ＩＦｃ）指数")
    private BizNumber ifcSisuu;

    public BizNumber getIfcSisuu() {
        return ifcSisuu;
    }

    public void setIfcSisuu(BizNumber pIfcSisuu) {
        ifcSisuu = pIfcSisuu;
    }

    @Column(order = 4, label = "（ＩＦｃ）指数計算基準日")
    private BizDate ifcSisuucalckijyunymd;

    public BizDate getIfcSisuucalckijyunymd() {
        return ifcSisuucalckijyunymd;
    }

    public void setIfcSisuucalckijyunymd(BizDate pIfcSisuucalckijyunymd) {
        ifcSisuucalckijyunymd = pIfcSisuucalckijyunymd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
