package yuyu.batch.hozen.khansyuu.khuriageseikyuukekkatrsks;

import java.io.Serializable;

/**
 * 突合せＮＧ件数管理Beanクラスです。<br />
 * @author  安　昊
 * @version 2019/10/25 安　昊 : 新規作成<br />
 */
public class TukiawaseNgkensuuKanriBean implements Serializable {

    /** デフォルト・シリアル・バージョン ID */
    private static final long serialVersionUID = 1L;

    /** 突合せ売上請求未実施チェックNG件数 */
    private int tukiawaseUriageseikyuuMijissiCheckNgKensuu;

    /** 突合せ多重受信チェックNG件数 */
    private int tukiawaseTajyuujyusinCheckNgKensuu;

    /** 突合せ結果データ未受信チェックNG件数 */
    private int tukiawaseKekkadataMijyusinCheckNgKensuu;

    /**
     * 突合せ売上請求未実施チェックNG件数 を取得します
     * @return tukiawaseuriageseikyuumijissicheckngkensuu 突合せ売上請求未実施チェックNG件数
     */
    public int getTukiawaseUriageseikyuuMijissiCheckNgKensuu() {
        return tukiawaseUriageseikyuuMijissiCheckNgKensuu;
    }

    /**
     * 突合せ売上請求未実施チェックNG件数 を設定します
     * @param pTukiawaseUriageseikyuuMijissiCheckNgKensuu 突合せ売上請求未実施チェックNG件数
     */
    public void setTukiawaseUriageseikyuuMijissiCheckNgKensuu(int pTukiawaseUriageseikyuuMijissiCheckNgKensuu) {
        this.tukiawaseUriageseikyuuMijissiCheckNgKensuu = pTukiawaseUriageseikyuuMijissiCheckNgKensuu;
    }

    /**
     * 突合せ多重受信チェックNG件数 を取得します
     * @return tukiawaseTajyuujyusinCheckNgKensuu 突合せ多重受信チェックNG件数
     */
    public int getTukiawaseTajyuujyusinCheckNgKensuu() {
        return tukiawaseTajyuujyusinCheckNgKensuu;
    }

    /**
     * 突合せ多重受信チェックNG件数 を設定します
     * @param pTukiawaseTajyuujyusinCheckNgKensuu 突合せ多重受信チェックNG件数
     */
    public void setTukiawaseTajyuujyusinCheckNgKensuu(int pTukiawaseTajyuujyusinCheckNgKensuu) {
        this.tukiawaseTajyuujyusinCheckNgKensuu = pTukiawaseTajyuujyusinCheckNgKensuu;
    }

    /**
     * 突合せ結果データ未受信チェックNG件数 を取得します
     * @return tukiawaseKekkadataMijyusinCheckNgKensuu 突合せ結果データ未受信チェックNG件数
     */
    public int getTukiawaseKekkadataMijyusinCheckNgKensuu() {
        return tukiawaseKekkadataMijyusinCheckNgKensuu;
    }

    /**
     * 突合せ結果データ未受信チェックNG件数 を設定します
     * @param pTukiawaseKekkadataMijyusinCheckNgKensuu 突合せ結果データ未受信チェックNG件数
     */
    public void setTukiawaseKekkadataMijyusinCheckNgKensuu(int pTukiawaseKekkadataMijyusinCheckNgKensuu) {
        this.tukiawaseKekkadataMijyusinCheckNgKensuu = pTukiawaseKekkadataMijyusinCheckNgKensuu;
    }
}
