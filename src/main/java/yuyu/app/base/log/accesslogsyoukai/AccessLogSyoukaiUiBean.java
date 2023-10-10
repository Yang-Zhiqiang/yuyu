package yuyu.app.base.log.accesslogsyoukai;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;

/**
 * アクセスログ照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class AccessLogSyoukaiUiBean extends GenAccessLogSyoukaiUiBean {

    private static final long serialVersionUID = 1L;

    public AccessLogSyoukaiUiBean() {
    }


    private String maxShutokuKensu;

    public String getMaxShutokuKensu() {
        return maxShutokuKensu;
    }

    public void setMaxShutokuKensu(String pMaxShutokuKensu) {
        this.maxShutokuKensu = pMaxShutokuKensu;
    }

    private String accessLogInfoCount;

    public String getAccessLogInfoCount() {
        return accessLogInfoCount;
    }

    public void setAccessLogInfoCount(String pAccessLogInfoCount) {
        this.accessLogInfoCount = pAccessLogInfoCount;
    }

}
