package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import yuyu.def.classification.C_Tuukasyu;

/**
 * 申込状況照会 - ●返金情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class HenkinInfoDataSourceBean extends GenHenkinInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private C_Tuukasyu hnkngkTuukasyu;

    public HenkinInfoDataSourceBean() {
    }

    public C_Tuukasyu getHnkngkTuukasyu() {
        return hnkngkTuukasyu;
    }

    public void setHnkngkTuukasyu(C_Tuukasyu pHnkngkTuukasyu) {
        hnkngkTuukasyu = pHnkngkTuukasyu;
    }
}
