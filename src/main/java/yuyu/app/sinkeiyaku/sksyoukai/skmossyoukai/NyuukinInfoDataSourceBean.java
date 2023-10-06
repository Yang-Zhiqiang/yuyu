package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 申込状況照会 - ●入金情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class NyuukinInfoDataSourceBean extends GenNyuukinInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private BizDate dispSoukinYmd;

    private String dispRssyouNo;

    private C_Tuukasyu rsgakuTuukasyu;

    public NyuukinInfoDataSourceBean() {
    }

    public BizDate getDispSoukinYmd() {
        return dispSoukinYmd;
    }

    public void setDispSoukinYmd(BizDate pDispSoukinYmd) {
        dispSoukinYmd = pDispSoukinYmd;
    }

    public String getDispRssyouNo() {
        return dispRssyouNo;
    }

    public void setDispRssyouNo(String pDispRssyouNo) {
        dispRssyouNo = pDispRssyouNo;
    }

    public C_Tuukasyu getRsgakuTuukasyu() {
        return rsgakuTuukasyu;
    }

    public void setRsgakuTuukasyu(C_Tuukasyu pRsgakuTuukasyu) {
        rsgakuTuukasyu = pRsgakuTuukasyu;
    }

}