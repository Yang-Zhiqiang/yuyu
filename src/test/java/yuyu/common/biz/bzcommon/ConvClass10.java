package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;

public class ConvClass10 {

    @Column(order = 1, label = "バッチジョブＩＤ")
    private String batchJobId;

    public String getBatchJobId() {
        return batchJobId;
    }

    @Padding(mode = "left", padChar = '0', length = 20)
    public void setBatchJobId(String pBatchJobId) {
        batchJobId = pBatchJobId;
    }

    @Column(order = 2, label = "（ＩＦｃ）銀行コード")
    private String ifcBankcd;

    public String getIfcBankcd() {
        return ifcBankcd;
    }

    @Padding(mode = "right", padChar = '+', length = 4)
    public void setIfcBankcd(String pIfcBankcd) {
        ifcBankcd = pIfcBankcd;
    }

    @Column(order = 3, label = "（ＩＦｃ）銀行名（漢字）")
    private String ifcBanknmkj;

    public String getIfcBanknmkj() {
        return ifcBanknmkj;
    }

    @Padding(mode = "left", padChar = '＠', length = 20)
    public void setIfcBanknmkj(String pIfcBanknmkjd) {
        ifcBanknmkj = pIfcBanknmkjd;
    }

    @Column(order = 4, label = "（ＩＦｃ）銀行名（カナ）")
    private String ifcBanknmkn;

    public String getIfcBanknmkn() {
        return ifcBanknmkn;
    }

    @Padding(mode = "right", padChar = '*', length = 15)
    public void setIfcBanknmkn(String pIfcBanknmkn) {
        ifcBanknmkn = pIfcBanknmkn;
    }

    @Column(order = 5, label = "（ＩＦｃ）銀行名（カナ）")
    private String ifcBanknmkn_0;

    public String getIfcBanknmkn_0() {
        return ifcBanknmkn_0;
    }

    @Padding(mode = "right", padChar = '*', length = 0)
    public void setIfcBanknmkn_0(String pIfcBanknmkn_0) {
        ifcBanknmkn_0 = pIfcBanknmkn_0;
    }
}
