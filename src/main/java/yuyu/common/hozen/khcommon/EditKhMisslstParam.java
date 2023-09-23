package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Dbhanei;

/**
 * 契約保全 契約保全共通 ミスリストTBL編集パラメータ
 */
public class EditKhMisslstParam {

    private int dataNo = 0;
    private int seqNo = 1;
    private String misslistMsg = "";
    private C_Dbhanei dBhaneiKbn = C_Dbhanei.NONE;
    private String syoNo = "";

    public EditKhMisslstParam() {
        super();
    }

    public int getDataNo() {
        return dataNo;
    }

    public void setDataNo(int pDataNo) {
        dataNo = pDataNo;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int pSeqNo) {
        seqNo = pSeqNo;
    }

    public String getMisslistMsg() {
        return misslistMsg;
    }

    public void setMisslistMsg(String pMisslistMsg) {
        misslistMsg = pMisslistMsg;
    }

    public C_Dbhanei getDBhaneikbn() {
        return dBhaneiKbn;
    }

    public void setDBhaneikbn(C_Dbhanei pDBhaneiKbn) {
        dBhaneiKbn = pDBhaneiKbn;
    }

    public String getSyoNo() {
        return syoNo;
    }

    public void setSyoNo(String pSyoNo) {
        syoNo = pSyoNo;
    }
}
