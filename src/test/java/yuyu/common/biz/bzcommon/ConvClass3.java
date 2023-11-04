package yuyu.common.biz.bzcommon;


import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;

public class ConvClass3 {

    //    @Column(order = 1, label = "（ＩＦｃ）レコード区分")
    //    private String ifcRecordkbn;
    //
    //    public String getIfcRecordkbn() {
    //        return ifcRecordkbn;
    //    }
    //
    //    public void setIfcRecordkbn(String pIfcRecordkbn) {
    //        ifcRecordkbn = pIfcRecordkbn;
    //    }

    @Column(order = 1, label = "（ＩＦｃ）相手先証券番号")
    private String ifcAitesyono;

    public String getIfcAitesyono() {
        return ifcAitesyono;
    }

    @Padding(mode = "left", padChar = '0', length = 20)
    public void setIfcAitesyono(String pIfcAitesyono) {
        ifcAitesyono = pIfcAitesyono;
    }

}
