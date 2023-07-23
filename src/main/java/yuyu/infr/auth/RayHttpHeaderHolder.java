package yuyu.infr.auth;

import jp.co.slcs.swak.core.inject.annotation.ThreadScoped;
import lombok.Getter;
import lombok.Setter;

/**
 * バックアップ用のRayHttpHeaderBeanを格納するHolder
 * #142937 YuyuAuthenticator#postAuthenticatorの処理時にRayHttpHeaderの認証情報が格納されていない場合がある
 * セッションフィクセーション対策によるクリア前の認証情報保持用
 */
@ThreadScoped
public class RayHttpHeaderHolder {
    @Setter @Getter
    private RayHttpHeaderBean rayHeaderBean;
}
