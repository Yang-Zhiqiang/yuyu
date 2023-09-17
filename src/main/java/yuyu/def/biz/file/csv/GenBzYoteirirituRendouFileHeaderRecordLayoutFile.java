package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）予定利率連動ファイル（ヘッダーレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzYoteirirituRendouFileHeaderRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzYoteirirituRendouFileHeaderRecordLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）レコード識別文字列")
    private String ifcRecordsikibetumojiretu;

    public String getIfcRecordsikibetumojiretu() {
        return ifcRecordsikibetumojiretu;
    }

    public void setIfcRecordsikibetumojiretu(String pIfcRecordsikibetumojiretu) {
        ifcRecordsikibetumojiretu = pIfcRecordsikibetumojiretu;
    }

    @Column(order = 2, label = "（ＩＦｃ）作成年月日")
    private BizDate ifcSakuseiymd;

    public BizDate getIfcSakuseiymd() {
        return ifcSakuseiymd;
    }

    public void setIfcSakuseiymd(BizDate pIfcSakuseiymd) {
        ifcSakuseiymd = pIfcSakuseiymd;
    }

    @Column(order = 3, label = "（ＩＦｃ）データレコード総件数")
    private Integer ifcDtrecordkensuu;

    public Integer getIfcDtrecordkensuu() {
        return ifcDtrecordkensuu;
    }

    public void setIfcDtrecordkensuu(Integer pIfcDtrecordkensuu) {
        ifcDtrecordkensuu = pIfcDtrecordkensuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
