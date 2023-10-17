package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import yuyu.def.classification.C_Tuukasyu;

/**
 * 申込状況照会 - ●Ｐ過金情報 の 行データBean クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class PkakinInfoDataSourceBean extends GenPkakinInfoDataSourceBean {

    private static final long serialVersionUID = 1L;

    private C_Tuukasyu pkakinTuukasyu;

    public PkakinInfoDataSourceBean() {
    }

    public C_Tuukasyu getPkakinTuukasyu() {
        return pkakinTuukasyu;
    }

    public void setPkakinTuukasyu(C_Tuukasyu pPkakinTuukasyu) {
        pkakinTuukasyu = pPkakinTuukasyu;
    }

}